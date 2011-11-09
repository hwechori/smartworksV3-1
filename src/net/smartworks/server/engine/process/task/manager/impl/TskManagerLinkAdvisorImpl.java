package net.smartworks.server.engine.process.task.manager.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.smartworks.server.engine.common.manager.IManager;
import net.smartworks.server.engine.common.model.InstanceVariable;
import net.smartworks.server.engine.common.model.InstanceVariables;
import net.smartworks.server.engine.common.model.Order;
import net.smartworks.server.engine.common.model.Property;
import net.smartworks.server.engine.common.util.CommonUtil;
import net.smartworks.server.engine.common.util.DateUtil;
import net.smartworks.server.engine.common.util.MisUtil;
import net.smartworks.server.engine.common.util.Wrapper;
import net.smartworks.server.engine.process.link.model.LnkCondition;
import net.smartworks.server.engine.process.link.model.LnkLink;
import net.smartworks.server.engine.process.link.model.LnkLinkCond;
import net.smartworks.server.engine.process.link.model.LnkObject;
import net.smartworks.server.engine.process.process.model.PrcProcessInst;
import net.smartworks.server.engine.process.task.exception.TskException;
import net.smartworks.server.engine.process.task.manager.AbstractTskManagerAdvisor;
import net.smartworks.server.engine.process.task.model.TskTask;
import net.smartworks.server.engine.process.task.model.TskTaskCond;
import net.smartworks.server.engine.process.task.model.TskTaskDef;

import org.springframework.util.StringUtils;

public class TskManagerLinkAdvisorImpl extends AbstractTskManagerAdvisor {
	
	public TskManagerLinkAdvisorImpl() {
		super();
	}
	
	public void postExecuteTask(String user, TskTask obj, String action) throws Exception {
		// 결재업무 처리
		
		//YKM 결재선을 타기전에 참조업무는 생성이 된다.
		this.applyRefTasks(user, obj);
		
		String type = obj.getType();
		String apprLineId = obj.getExtendedPropertyValue("approvalLine");

		if (type != null && type.equalsIgnoreCase(CommonUtil.toDefault((String)MisUtil.taskDefTypeMap().get("approval"), "approval")) && !CommonUtil.isEmpty(apprLineId)) {
			TskTask nextTask = null;
			
			AprApprovalLine apprLine = this.getAprManager().getApprovalLine(user, apprLineId, null);
			String status = obj.getStatus();
			// 반려인 경우
			if (action != null && action.equalsIgnoreCase("return")) {
				String apprId = obj.getExtendedPropertyValue("approval");
				if (apprLine != null && !CommonUtil.isEmpty(apprId)) {
					AprApproval[] apprs = apprLine.getApprovals();
					if (!CommonUtil.isEmpty(apprs)) {
						for (int i=0; i<apprs.length; i++) {
							AprApproval appr = apprs[i];
							if (appr.getObjId().equalsIgnoreCase(apprId))
								appr.setStatus(status);
						}
					}
				}
				String taskRef = obj.getExtendedPropertyValue("taskRef");
				if (!CommonUtil.isEmpty(taskRef)) {
					TskTask newTask = cloneTask(taskRef);
					getTskManager().setTask("linkeadvisor", newTask, null);
				}
				
				apprLine.setStatus(status);
				getAprManager().setApprovalLine("linkadvisor", apprLine, null);
				return;
				
			// 승인인 경우
			} else {
				nextTask = setNextApproval(null, obj, apprLine);
				if (nextTask != null)
					status = nextTask.getStatus();
			}
			
			apprLine.setStatus(status);
			getAprManager().setApprovalLine("linkadvisor", apprLine, null);

			if (nextTask == null) {
				String taskRef = obj.getExtendedPropertyValue("taskRef");
				if (CommonUtil.isEmpty(taskRef)) {
					updateProcessInstStatus(user, obj.getProcessInstId());
					return;
				}
				
				obj = getTskManager().getTask(user, taskRef, null);
			} else {
				return;
			}
		//기안취소
		} else if(action != null && action.equalsIgnoreCase("cancel")){
			//MisUtil utill = new MisUtil();
			//Map status = (Map)utill.getTaskStatusMap();
			//String canceledStatus = (String) status.get("canceled");
			String canceledStatus = "24";
			obj.setStatus(canceledStatus);
			getTskManager().setTask("linkeadvisor", obj, null);
			
			//PrcInstance 종료
			PrcProcessInst prcInst = this.getPrcManager().getProcessInst("linkadvisor", obj.getProcessInstId(), IManager.LEVEL_ALL);
			prcInst.setStatus(CommonUtil.toDefault((String)MisUtil.processInstStatusMap().get("completed"), "completed"));
			this.getPrcManager().setProcessInst("linkadvisor", prcInst, IManager.LEVEL_LITE);
			
			//Apprline 종료
			String aprStatus = "24";
			AprApprovalLine apprLine = this.getAprManager().getApprovalLine(user, apprLineId, null);
			apprLine.setStatus(aprStatus);
			getAprManager().setApprovalLine("linkadvisor", apprLine, null);
			return;
			
		} else {          
			// 결재자 반영
			if (applyApprovalTask(user, obj) != null)
				return;
		}
		
		// 수신 업무 반영
		LnkLink recLink = this.applyReceiptTask(user, obj);
		
		// 링크 반영
		if (!this.checkMultiInstCondition(obj, action))
			return;
		
		// task를 from으로 하는 link 조회
		LnkLink[] links = this.getNextLinks(obj, action);
		
		// 이후 링크가 없으면, 프로세스 상태 갱신 후 반환
		if (CommonUtil.isEmpty(links) && recLink == null) {
			updateProcessInstStatus(user, obj.getProcessInstId());
			return;
		}

		List linkList = new ArrayList();
		
		if (recLink != null)
			linkList.add(recLink);
		
		if (!CommonUtil.isEmpty(links)) {
			Object data = toData(obj);

			ChtPertChart pert = null;
			Map pertItemMap = null;
			boolean pertChanged = false;
			ChtPertChartCond pertCond = new ChtPertChartCond();
			pertCond.setObjId(obj.getProcessInstId());
			ChtPertChart[] perts = this.getChtManager().getPertCharts("tskManagerDefaultAdvisor", pertCond, IManager.LEVEL_ALL);
			if (!CommonUtil.isEmpty(perts)) {
				pert = perts[0];
				ChtPertItem[] items = pert.getItems();
				if (!CommonUtil.isEmpty(items)) {
					ChtPertItem item = null;
					String itemType = null;
					for (int i=0; i<items.length; i++) {
						item = items[i];
						itemType = item.getType();
						if (!itemType.equalsIgnoreCase("taskdef"))
							continue;
						if (pertItemMap == null)
							pertItemMap = new HashMap();
						pertItemMap.put(item.getRef(), item);
					}
				}
			}
			
			boolean isExe = false;
			LnkLink elseLink = null;
			for (int i = 0; i < links.length; i++) {
				LnkLink link = links[i];
				
				// condition 확인
				LnkCondition cond = link.getCondition();
				if (cond != null) {
					String condType = cond.getType();
					if (condType != null && (
							condType.equalsIgnoreCase("default") || 
							condType.equalsIgnoreCase("otherwise") ||
							condType.equalsIgnoreCase("else"))) {
						elseLink = link;
						continue;
					}
				}
				if (!isExecutable(obj, data, action, cond))
					continue;
				isExe = true;
				
				// link의 to 처리
				if (this.doLinkTo(obj, data, action, link, linkList, pert, pertItemMap))
					pertChanged = true;
					
				if (type != null && type.equalsIgnoreCase("xor"))
					break;
			}
			// else link의 to 처리
			if (!isExe && elseLink != null)
				pertChanged = this.doLinkTo(obj, data, action, elseLink, linkList, pert, pertItemMap);

			// 태스크 일정 저장
			if (pertChanged)
				this.getChtService().setPertChart(pert.getModificationUser(), pert);

			clearLinks(obj);
		}
		
		if (!linkList.isEmpty()) {
			for (Iterator linkItr = linkList.iterator(); linkItr.hasNext();) {
				LnkLink link = (LnkLink)linkItr.next();
				this.getLnkService().setLink("linkadvisor", link);
			}
			
//			프로세스 상태 갱신
//			PrcProcessInst prcInst = this.getPrcManager().getProcessInst("linkadvisor", obj.getProcessInstId(), IManager.LEVEL_LITE);
//			if (prcInst != null) {
//				String prcInstStatus = prcInst.getStatus();
//				Date modDate = prcInst.getModificationDate();
//				if (
//						prcInstStatus == null || 
//						(
//								modDate != null && 
//								modDate.getTime() < new Date().getTime() - 5000 && 
//								prcInstStatus.equals(CommonUtil.toDefault((String)MisUtil.processInstStatusMap().get("completed"), "completed"))
//						)
//					) {
//					prcInst.setStatus(CommonUtil.toDefault((String)MisUtil.processInstStatusMap().get("started"), "started"));
//					this.getPrcManager().setProcessInst("linkadvisor", prcInst, IManager.LEVEL_LITE);
//				}
//			}
		}
		
		// 프로세스 상태 갱신
		this.updateProcessInstStatus(user, obj.getProcessInstId());
	}
	private TskTask applyApprovalTask(String user, TskTask obj) throws Exception {
		// 결재선 여부 체크
		String apprLineId = obj.getExtendedPropertyValue("approvalLine");
		if (CommonUtil.isEmpty(apprLineId))
			return null;
		
		AprApprovalLineCond cond = new AprApprovalLineCond();
		cond.setObjId(apprLineId);
		cond.setStatusNotIns(CommonUtil.toStringArray(MisUtil.taskExecutedStatusSet()));
		AprApprovalLine apprLine = getAprManager().getApprovalLine(user, apprLineId, null);
		if (apprLine == null)
			return null;
		apprLine.setCorrelation(obj.getObjId());
		StringBuffer nameBuf = new StringBuffer();
		if (!CommonUtil.isEmpty(obj.getName()))
			nameBuf.append("[").append(obj.getName()).append("] ");
		if (CommonUtil.isEmpty(obj.getTitle()))
			nameBuf.append(obj.getTitle());
		apprLine.setName(CommonUtil.toNull(CommonUtil.substring(nameBuf.toString().trim(), 0, 20)));
		TskTask nextApprTask = setNextApproval(obj, null, apprLine);
		getAprManager().setApprovalLine("linkadvisor", apprLine, null);
		return nextApprTask;
	}
	private TskTask setNextApproval(TskTask obj, TskTask preApprTask, AprApprovalLine apprLine) throws Exception {
		if (apprLine == null || (obj == null && preApprTask == null))
			return null;
		AprApproval[] apprs = apprLine.getApprovals();
		if (CommonUtil.isEmpty(apprs))
			return null;
		
		String preApprId = null;
		if (preApprTask != null)
			preApprId = preApprTask.getExtendedPropertyValue("approval");
		for (int i=0; i<apprs.length; i++) {
			AprApproval appr = apprs[i];
			String approver = appr.getApprover();
			if (CommonUtil.isEmpty(approver))
				continue;
			
			String apprId = appr.getObjId();
			if (preApprId != null && apprId.equalsIgnoreCase(preApprId)) {
				appr.setStatus(preApprTask.getStatus());
				continue;
			}
			
			String apprStatus = appr.getStatus();
			if (apprStatus != null && apprStatus.equalsIgnoreCase((String)MisUtil.taskStatusMap().get("executed")))
				continue;
			
			String prcInstId = null;
			String name = null;
			String priority = null;
			String title = null;
			String assigner = null;
			String taskRef = null;
			if (obj != null) {
				prcInstId = obj.getProcessInstId();
				name = obj.getName();
				priority = obj.getPriority();
				
				if (CommonUtil.isEmpty(obj.getExtendedPropertyValue("m_Title"))) {
					title = obj.getTitle();
				} else {
					title = obj.getExtendedPropertyValue("m_Title");
				}
				assigner = obj.getAssignee();
				taskRef = obj.getObjId();
			} else {
				prcInstId = preApprTask.getProcessInstId();
				name = preApprTask.getName();
				priority = preApprTask.getPriority();
				title = preApprTask.getTitle();
				assigner = preApprTask.getAssigner();
				taskRef = preApprTask.getExtendedPropertyValue("taskRef");
			}
			
			TskTask apprTask = new TskTask();
			apprTask.setProcessInstId(prcInstId);
			apprTask.setName(name);
			apprTask.setType(CommonUtil.toDefault((String)MisUtil.taskDefTypeMap().get("approval"), "approval"));
			apprTask.setPriority(priority);
			apprTask.setTitle(title);
			apprTask.setAssigner(assigner);
			apprTask.setAssignee(approver);
			apprTask.setForm(preApprTask != null ? preApprTask.getForm() : obj.getForm());
			apprTask.setExtendedPropertyValue("taskRef", taskRef);
			apprTask.setExtendedPropertyValue("approvalLine", apprLine.getObjId());
			apprTask.setExtendedPropertyValue("approval", appr.getObjId());
			this.getTskManager().setTask("linkadvisor", apprTask, null);
			
			return apprTask;
		}
		
		return null;
	}
	private LnkLink applyReceiptTask(String user, TskTask obj) throws Exception {
		//수신자가 존재한다면 태스크를 생성
		String recUser  = obj.getExtendedPropertyValue("receiptUser");
		if (CommonUtil.isEmpty(recUser))
			return null;

		String recName = obj.getExtendedPropertyValue("receiptName");
		//String recType = obj.getExtendedPropertyValue("receiptType");
		String recDesc = obj.getExtendedPropertyValue("m_Description");
		String recForm = obj.getExtendedPropertyValue("receiptForm");
		//String recTitle = obj.getExtendedPropertyValue("receiptTitle") != null ? obj.getExtendedPropertyValue("receiptTitle") : obj.getExtendedPropertyValue("m_Title");
		String subject = obj.getExtendedPropertyValue("subject");
		String projectName = obj.getExtendedPropertyValue("projectName");
		String isPublic = obj.getExtendedPropertyValue("isPublic");
		//TODO 연결업무를 만들면서 해당 업무의 참조업무를 생성할수 있다
		//String recReferenceUser = obj.getExtendedPropertyValue("recReferenceUser");
		String hopeEndDate = obj.getExtendedPropertyValue("hopeEndDate");
		//String recDueDate = obj.getExtendedPropertyValue("receiptDueDate");
		String prevForm = obj.getForm();
		
		//if (recType == null)
		//	recType = CommonUtil.toDefault((String)MisUtil.taskDefTypeMap().get("normal"), "normal");
		
		TskTask recTask = new TskTask();
		recTask.setProcessInstId(obj.getProcessInstId());
		recTask.setName(recName);
		recTask.setType("SINGLE");
		recTask.setPriority(obj.getPriority());
//		recTask.setTitle(obj.getTitle());
		recTask.setTitle(subject);
		//recTask.setDescription(recDesc);
		if (prevForm != null && prevForm.equals(recForm))
			recTask.setDocument(obj.getDocument());
		recTask.setAssigner(obj.getAssignee());
		recTask.setAssignee(recUser);
		recTask.setAssignmentDate(new Date());
		recTask.setForm(recForm);
		//recTask.setDueDate(DateUtil.toDate(recDueDate));
		recTask.setExtendedAttributeValue("projectName", projectName);
		recTask.setExtendedAttributeValue("isPublic", isPublic);
		
		Date realEndDate = obj.getRealEndDate();
		recTask.setExpectStartDate(realEndDate);
		recTask.setRealStartDate(realEndDate);
		
		Date expectEndDate = new Date();
		try {
			expectEndDate = DateUtil.toDate(hopeEndDate, "yyyy-MM-dd HH:mm");
		} catch (Exception e) {
			logger.warn("fail to convert hopeEndDate(yyyy-MM-dd HH:mm), default setExpectEndDate : RealStartDate + 30Min");
			expectEndDate.setTime(realEndDate.getTime() + 1800000);
		}
		recTask.setExpectEndDate(expectEndDate);
		
		this.getTskManager().setTask(user, recTask, null);
		
		obj.setExtendedPropertyValue("processInstCreationUser", user);
		
		return newLink(obj, recTask, null, null);
	}
	private void applyRefTasks(String user, TskTask obj) throws Exception {
		//참조자가 존재한다면 참조타입의 태스크를 생성
		String refUsersStr  = obj.getExtendedPropertyValue("referenceUser");
		if (CommonUtil.isEmpty(refUsersStr))
			return;
		String[] refUsers = StringUtils.tokenizeToStringArray(refUsersStr, ";");
		if (CommonUtil.isEmpty(refUsers))
			return;
		TskTaskCond cond = new TskTaskCond();
		cond.setType(CommonUtil.toDefault((String)MisUtil.taskDefTypeMap().get("reference"), "reference"));
		cond.setExtendedProperties(new Property[] {new Property("taskRef", obj.getObjId())});
		TskTask[] taskRefs = this.getTskService().getTasks(user, cond);
		Set refUserSet = new HashSet();
		TskTask refTask = null;
		if (!CommonUtil.isEmpty(taskRefs)) {
			String assignee = null;
			for (int i=0; i<taskRefs.length; i++) {
				refTask = taskRefs[i];
				assignee = refTask.getAssignee();
				refUserSet.add(assignee);
			}
		}
		//metadata
		//제목
		String subject = obj.getExtendedPropertyValue("subject");
		//설명
		String workContents = obj.getExtendedPropertyValue("workContents");
		//프로젝트명
		String projectName = obj.getExtendedPropertyValue("projectName");
		//공개여부
		String isPublic = obj.getExtendedPropertyValue("isPublic");
		//중요도
		String priority = obj.getPriority();
		
		String refUser = null;
		for (int i = 0; i < refUsers.length; i++) {
			refUser = refUsers[i];
			if (refUserSet.contains(refUser))
				continue;
			
			refTask = new TskTask();
			refTask.setProcessInstId(obj.getProcessInstId());
			refTask.setType(CommonUtil.toDefault((String)MisUtil.taskDefTypeMap().get("reference"), "reference"));
			refTask.setPriority(priority);
//			refTask.setTitle(obj.getTitle());
			refTask.setTitle(subject);
			refTask.setName(obj.getName());
			refTask.setAssigner(obj.getAssigner());
			refTask.setAssignee(refUser);
			refTask.setForm(obj.getForm());
			refTask.setExtendedPropertyValue("subject", subject);
			refTask.setExtendedPropertyValue("taskRef", obj.getObjId());
			refTask.setExtendedPropertyValue("workContents", workContents);
			refTask.setExtendedPropertyValue("projectName", projectName);
			refTask.setExtendedPropertyValue("isPublic", isPublic);
			this.getTskManager().setTask(user, refTask, null);
			refUserSet.add(refUser);
		}
	}
	private void updateProcessInstStatus(String user, String prcInstId) throws Exception {
		if (prcInstId == null)
			return;
			
		PrcProcessInst prcInst = this.getPrcManager().getProcessInst("linkadvisor", prcInstId, IManager.LEVEL_ALL);
		if (prcInst == null)
			return;
		
		TskTaskCond taskCond = new TskTaskCond();
		taskCond.setProcessInstId(prcInstId);
		taskCond.setTypeNotIns(new String[] {CommonUtil.toDefault((String)MisUtil.taskDefTypeMap().get("reference"), "refernece")});
		taskCond.setStatusNotIns(CommonUtil.toStringArray(MisUtil.taskExecutedStatusSet()));
		long taskSize = getTskService().getTaskSize(user, taskCond);
		
		// 진행 중인 태스크가 없고, 완료상태가 아니면, 완료상태로 변경
		String status = prcInst.getStatus();
		if (taskSize == 0) {
			if (status == null || !MisUtil.processInstExecutedStatusSet().contains(status)) {
				prcInst.setStatus(CommonUtil.toDefault((String)MisUtil.processInstStatusMap().get("completed"), "completed"));
				this.getPrcManager().setProcessInst("linkadvisor", prcInst, IManager.LEVEL_LITE);
				//서브인스턴스이면 부모의 SUBFLOW TASK를 찾아서 실행한다
				if (prcInst.getIsSubInstance() != null && prcInst.getIsSubInstance().equalsIgnoreCase("TRUE"))
					invokeParentPrcInstTask(user, prcInst);
			}
		
		// 진행 중인 태스크가 있고, 완료상태이면, 진행상태로 변경
		} else {
			if (status == null || MisUtil.processInstExecutedStatusSet().contains(status)) {
				prcInst.setStatus(CommonUtil.toDefault((String)MisUtil.processInstStatusMap().get("started"), "started"));
				this.getPrcManager().setProcessInst("linkadvisor", prcInst, IManager.LEVEL_LITE);
			}
		}
		
	}
	private void invokeParentPrcInstTask(String user, PrcProcessInst prcInst) throws Exception {
		String parentPrcInstId = prcInst.getExtendedPropertyValue("parentPrcInstId");
		String parentTskDefId = prcInst.getExtendedPropertyValue("parentTskDefId");
		//부모의 instanceVariable 를 업데이트 한다.
		//부모의 전역변수를 업데이트 칠이유가 있나?????????????????????????
		PrcProcessInst pPrcInst = this.getPrcManager().getProcessInst(user, parentPrcInstId, IManager.LEVEL_LITE);
		if (pPrcInst != null && pPrcInst.getInstVariable() != null) {
			InstanceVariables prcInstVariables = (InstanceVariables)InstanceVariables.toObject(prcInst.getInstVariable());
			InstanceVariable[] prcInstVariable = prcInstVariables.getInstanceVariables();

			InstanceVariables pPrcInstVariables = (InstanceVariables)InstanceVariables.toObject(pPrcInst.getInstVariable());
			InstanceVariable[] pPrcInstVariable = pPrcInstVariables.getInstanceVariables();
			
			Map pPrcInstVariableMap = new HashMap();
			for (int i = 0; i < pPrcInstVariable.length; i++) {
				pPrcInstVariableMap.put(pPrcInstVariable[i].getId(), pPrcInstVariable[i]);
			}
			
			for (int i = 0; i < prcInstVariable.length; i++) {
				if (pPrcInstVariableMap.get(prcInstVariable[i].getId()) == null) {
					pPrcInstVariables.addInstanceVariable(prcInstVariable[i]);
				} else {
					InstanceVariable tempVariable = (InstanceVariable)pPrcInstVariableMap.get(prcInstVariable[i].getId());
					tempVariable.setVariableValue(prcInstVariable[i].getVariableValue());
				}
				
			}
			
			pPrcInst.setInstVariable(pPrcInstVariables.toString());
			
			this.getPrcManager().setProcessInst(user, pPrcInst, IManager.LEVEL_LITE);	
		} else {
			pPrcInst.setInstVariable(prcInst.getInstVariable());
			this.getPrcManager().setProcessInst(user, pPrcInst, IManager.LEVEL_LITE);	
		}
		TskTaskCond cond = new TskTaskCond();
		cond.setProcessInstId(parentPrcInstId);
		cond.setDef(parentTskDefId);

		cond.setOrders(new Order[] {new Order(TskTask.A_CREATIONDATE, false)});
		
		TskTask[] parentTask = this.getTskManager().getTasks(user, cond, IManager.LEVEL_ALL);
		if (parentTask[0] == null || parentTask[0].getStatus().equalsIgnoreCase(CommonUtil.toDefault((String)MisUtil.taskStatusMap().get("executed"), "executed")))
			return;
		parentTask[0].setInstVariable(prcInst.getInstVariable());
		getTskManager().executeTask(user, parentTask[0], "execute");
			
	}
	private void applyTaskPert(TskTask obj) throws Exception {
		String type = obj.getType();
		if (getChtManager() == null || obj.getProcessInstId() == null || type == null || 
				type.equalsIgnoreCase(CommonUtil.toDefault((String)MisUtil.taskDefTypeMap().get("route"), "route")) ||
				type.equalsIgnoreCase(CommonUtil.toDefault((String)MisUtil.taskDefTypeMap().get("xor"), "xor")) ||
				type.equalsIgnoreCase(CommonUtil.toDefault((String)MisUtil.taskDefTypeMap().get("and"), "and")) ||
				type.equalsIgnoreCase(CommonUtil.toDefault((String)MisUtil.taskDefTypeMap().get("or"), "or")))
			return;

		ChtPertChartCond pertCond = new ChtPertChartCond();
		pertCond.setObjId(obj.getProcessInstId());
		ChtPertChart[] perts = this.getChtManager().getPertCharts("tskManagerDefaultAdvisor", pertCond, IManager.LEVEL_ALL);
		if (CommonUtil.isEmpty(perts))
			return;
		
		this.getChtManager().setPertChart(obj.getModificationUser(), perts[0], null);
	}
	private boolean checkMultiInstCondition(TskTask obj, String action) throws Exception {
		String miId = obj.getMultiInstId();
		if (miId == null)
			return true;
		// TODO Multi Instance Ordering
//		String miOrder = obj.getMultiInstOrdering();
		String miFlowCond = obj.getMultiInstFlowCondition();
		if (miFlowCond != null && miFlowCond.equalsIgnoreCase("none"))
			return true;
		TskTaskCond miCond = new TskTaskCond();
		miCond.setMultiInstId(miId);
		TskTask[] miTasks = this.getTskManager().getTasks("linkAdvisor", miCond, IManager.LEVEL_LITE);
		if (miTasks == null || miTasks.length == 0)
			return true;
		if (miFlowCond == null || miFlowCond.equalsIgnoreCase("all")) {
			for (int i=0; i<miTasks.length; i++) {
				TskTask miTask = miTasks[i];
				String miTaskStatus = miTask.getStatus();
				if (miTaskStatus == null)
					return false;
				if (!MisUtil.taskExecutedStatusSet().contains(miTaskStatus))
					return false;
			}
		} else {
			for (int i=0; i<miTasks.length; i++) {
				TskTask miTask = miTasks[i];
				String miTaskStatus = miTask.getStatus();
				if (miTaskStatus == null)
					return false;
				if (MisUtil.taskExecutedStatusSet().contains(miTaskStatus))
					return false;
			}
		}
		return true;
	}
	protected LnkLink[] getNextLinks(TskTask obj, String action) throws Exception {
		if (action != null && action.equalsIgnoreCase("return")) {
			TskTask prevTask = this.getPreviousTask(obj);
			String prevMiId = prevTask.getMultiInstId();
			String toType = null;
			String toRef = null;
			if (prevMiId == null) {
				toType = "task";
				toRef = prevTask.getObjId();
			} else {
				toType = "multiinst";
				toRef = prevMiId;
			}
			
			return new LnkLink[] {newLink(toType, toRef)};
		}
		
		ILnkAdminService lnkSvc = this.getLnkService();
		
		LnkLinkCond cond = new LnkLinkCond();
		cond.setType("processinst");
		cond.setCorrelation(obj.getCorrelation());
		cond.setFromType("task");
		cond.setFromRef(obj.getObjId());
		LnkLink[] links = lnkSvc.getLinks("linkadvisor", cond);
		
		if (links != null)
			return links;

		String def = obj.getDef();
		if (def == null || def.length() == 0)
			return null;
		
		cond.setType("process");
		cond.setCorrelation(null);
		cond.setFromType("taskdef");
		cond.setFromRef(def);
		links = lnkSvc.getLinks("linkadvisor", cond);
		
		return links;
	}
	protected TskTask getPreviousTask(TskTask obj) throws Exception {
		String[] prevTaskIds = obj.getExtendedPropertyValues("previousTaskId");
		if (prevTaskIds == null || prevTaskIds.length == 0)
			return null;
		
		String prevTaskId = prevTaskIds[0];
		TskTask prevTask = this.getTskService().getTask("linkadvisor", prevTaskId);
		if (prevTask == null)
			throw new TskException("Coudn't find previous task of task id: " + obj.getObjId());
		String prevTaskType = prevTask.getType();
		if (prevTaskType == null || 
				!(prevTaskType.equalsIgnoreCase("xor") ||  
				prevTaskType.equalsIgnoreCase("and") || 
				prevTaskType.equalsIgnoreCase("or") || 
				prevTaskType.equalsIgnoreCase("route"))) {
			return prevTask;
		}
		return getPreviousTask(prevTask);
	}
	private LnkLink newLink(String toType, String toRef) throws Exception {
		LnkObject to = new LnkObject();
		to.setType(toType);
		to.setRef(toRef);

		LnkLink link = new LnkLink();
		link.setType("tmp");
		link.setTo(to);
		
		return link;
	}
	private boolean doLinkTo(TskTask obj, Object data, String action, LnkLink link, List linkList, ChtPertChart pert, Map pertItemMap) throws Exception {
		LnkObject to = link.getTo();
		if (to == null)
			return false;
		
		String toType = to.getType();
		String toRef = to.getRef();
		String toLabel = to.getLabel();
		String toExpr = to.getExpression();
		if (toRef == null || toRef.length() == 0)
			return false;
		
		// TODO 지저분한 소스 (보내기 업무, 반려)
		if (toType != null && toType.equalsIgnoreCase("task") && 
				action != null && !action.equalsIgnoreCase("return")) {
			linkList.add(link);
			return false;
		}
		
		TskTask[] tasks = null;
		Wrapper isPertChanged = new Wrapper(new Boolean(false));
		if (toType == null || toType.equalsIgnoreCase("taskdef")) {
			TskTaskDef taskDef = this.getTskService().getTaskDef("linkadvisor", toRef);
			if (taskDef == null)
				return false;
			
			if (toExpr == null || toExpr.length() == 0)
				toExpr = taskDef.getAssignee();
			//TODO AND GATEWAY 설정
			//AND GATEWAY 를 만났을경우 현재 같은 인스턴스 아이디 내에서 진행중인 태스크가  자신 말고 또있다면 다음 태스크를 생성하지 않는다
			//FIXME and 분기 내부에서 또 and 분기를 했을경우 처음분기한 태스크가 살아 있으면 두번째분기한 인스턴스가 다음으로 진행되지 않는다...고쳐야됨
			if (taskDef.getType().equalsIgnoreCase("AND")) {
				String processInstId = obj.getProcessInstId();
				
				TskTaskCond cond = new TskTaskCond();
				cond.setProcessInstId(processInstId);
				cond.setTypeNotIns(new String[] {"REFERENCE"});
				String[] statusNotIns = new String[] {"23", "21"};
				cond.setStatusNotIns(statusNotIns);
				
				long andTaskSize = this.getTskService().getTaskSize("linkadvisor", cond);
				
				if (andTaskSize < 1)
					tasks = toTasks(obj, data, action, taskDef, toLabel, toExpr, pert, pertItemMap, isPertChanged);
			} else {
				tasks = toTasks(obj, data, action, taskDef, toLabel, toExpr, pert, pertItemMap, isPertChanged);
			}
		} else if (toType.equalsIgnoreCase("task")) {
			// TODO 지저분한 소스 (보내기 업무, 반려)
			tasks = new TskTask[] {cloneTask(toRef)};
		} else if (toType.equalsIgnoreCase("multiinst")) {
			TskTaskCond taskCond =new TskTaskCond();
			taskCond.setMultiInstId(toRef);
			TskTask[] multis = this.getTskManager().getTasks("linkadvisor", taskCond, IManager.LEVEL_ALL);
			if (multis != null && multis.length != 0) {
				tasks = new TskTask[multis.length];
				String multiInstId = CommonUtil.newId();
				for (int i=0; i<multis.length; i++) {
					tasks[i] = (TskTask)multis[i].cloneNew();
					tasks[i].setMultiInstId(multiInstId);
				}
			}
		}
		
		if (tasks != null && tasks.length != 0) {
			String linkId =link.getObjId();
			Property[] extProps = null;
			if (linkId != null) {
				link = this.getLnkService().getLink("linkadvisor", linkId);
				extProps = Property.cloneProperties(link.getExtendedProperties());
			}
			
			for (int j=0; j<tasks.length; j++) {
				TskTask task = tasks[j];
				String extValues = obj.getExtendedAttributeValue("extValues");
				if (!CommonUtil.isEmpty(extValues)) {
					task.setExtendedAttributeValue("extValues", extValues);		
				}
				this.getTskService().setTask("linkadvisor", task);
				linkList.add(newLink(obj, task, action, extProps));
			}
		}
		
		return ((Boolean)isPertChanged.getObj()).booleanValue();
	}
	private TskTask cloneTask(String objId) throws Exception {
		return cloneTask(this.getTskService().getTask("linkadvisor", objId));
	}
	private TskTask cloneTask(TskTask task) throws Exception {
		if (task == null)
			return null;
		TskTask newTask = (TskTask)task.cloneNew();
		newTask.setAssignmentDate(new Date());
		newTask.setStartDate(null);
		newTask.setExecutionDate(null);
		newTask.setExtendedAttributeValue("counter", null);
		return newTask;
	}
	private LnkLink newLink(TskTask fromTask, TskTask toTask, String action, Property[] extProps) throws Exception {
		LnkLink link = new LnkLink();
		
		LnkObject from = new LnkObject();
		from.setType("task");
		from.setRef(fromTask.getObjId());
		from.setLabel(fromTask.getName());
		from.setExpression(fromTask.getAssignee());
		LnkObject to = new LnkObject();
		to.setType("task");
		to.setRef(toTask.getObjId());
		to.setLabel(toTask.getName());
		to.setExpression(toTask.getAssignee());
		LnkCondition cond = new LnkCondition();
		cond.setExpression(action);
		
		StringBuffer nameBuf = new StringBuffer("[").append(CommonUtil.substring(fromTask.getName(), 0, 10))
				.append("] -> [").append(CommonUtil.substring(toTask.getName(), 0, 10)).append("] ")
				.append(CommonUtil.substring(fromTask.getTitle(), 0, 10));
		link.setName(nameBuf.toString());
		link.setType("processinst");
		link.setCorrelation(fromTask.getProcessInstId());
		link.setFrom(from);
		link.setTo(to);
		link.setCondition(cond);
		
		link.setExtendedProperties(extProps);
		
		return link;
	}
	private void clearLinks(TskTask task) throws Exception {
		LnkLinkCond cond = new LnkLinkCond();
		cond.setFromType("task");
		cond.setFromRef(task.getObjId());
		cond.setCorrelation(task.getCorrelation());
		this.getLnkService().removeLinks("linkadvisor", cond);
	}
	protected boolean isExecutable(TskTask task, Object data, String action, LnkCondition condition) throws Exception {
		if (condition == null)
			return true;
		
		String expression = condition.getExpression();
		if (expression == null)
			return true;

		expression = expression.trim();
		if (expression.length() == 0)
			return true;
		
		boolean isExe = isExecutable(task, data, action, expression);
		return isExe;
	}
	private TskTask[] toTasks(TskTask context, Object data, String action, TskTaskDef def, String label, String expression, 
			ChtPertChart pert, Map pertItemMap, Wrapper pertChanged) throws Exception {
		String doc = toTaskDocument(context, data, def);
		String[] assignees = toTaskAssignees(context, data, def);
		if (assignees == null || assignees.length == 0)
			return null;
		if (label == null || label.length() == 0)
			label = def.getName();
		String corr = toTaskCorrelation(context, data, def);
		String prcInstId = toTaskProcessInstId(context, data, def);
		String type = toTaskType(context, data, def);
		String title = toTaskTitle(context, data, def);
		String desc = toTaskDescription(context, data, def);
		String priority = toTaskPriority(context, data, def);
		String assigner = toTaskAssigner(context, data, def);
		Date assignDate = toTaskAssignmentDate(context, data, def);
		Date dueDate = toTaskDueDate (context, data, def);
		String form = toTaskForm(context, data, def);
		String defId = def.getObjId();
		String miId = assignees == null || assignees.length <= 1? null:CommonUtil.newId();
		String miFlowCond = toTaskMultiInstFlowCondition(context, data, def);
		String miOrder = toTaskMultiInstOrdering(context, data, def);
		Property[] extProps = toTaskExtendedProperties(context, data, def);
		String[] prevTaskIds = null;
		String[] prevPerformers = null;
		String prevMiId = context.getMultiInstId();
		String prevMiFlowCond = context.getMultiInstFlowCondition();
		if (prevMiId != null && prevMiFlowCond != null && !prevMiFlowCond.equalsIgnoreCase("none")) {
			TskTaskCond prevTaskCond = new TskTaskCond();
			prevTaskCond.setMultiInstId(prevMiId);
			TskTask[] prevTasks = this.getTskService().getTasks("linkAdvisor", prevTaskCond);
			if (prevTasks != null && prevTasks.length != 0) {
				prevTaskIds = new String[prevTasks.length];
				List prevPerformerList = null;
				for (int i=0; i<prevTasks.length; i++) {
					TskTask prevTask = prevTasks[i];
					prevTaskIds[i] = prevTask.getObjId();
					String prevPerformer = prevTask.getPerformer();
					if (prevPerformer != null) {
						if (prevPerformerList == null)
							prevPerformerList = new ArrayList();
						prevPerformerList.add(prevPerformer);
					}
				}
				if (prevPerformerList != null && !prevPerformerList.isEmpty()) {
					prevPerformers = new String[prevPerformerList.size()];
					prevPerformerList.toArray(prevPerformers);
				}
			}
		} else {
			String prevPerformer = context.getPerformer();
			if (prevPerformer == null || prevPerformer.length() == 0) {
				prevPerformers = context.getExtendedPropertyValues("previousPerformer");
				if (prevPerformers == null)
					prevPerformers = context.getExtendedPropertyValues("previousAssignee");
			} else {
				prevPerformers = new String[] {prevPerformer};
			}
		}
		
		Map assigneeTaskIdMap = new HashMap();
		ChtPertItem item = null;
		if (pertItemMap != null && pertItemMap.containsKey(defId)) {
			item = (ChtPertItem)pertItemMap.get(defId);
			item.setPlanFrom(assignDate);
			Date planTo = item.getPlanTo();
			if (planTo != null)
				dueDate = DateUtil.toToDate(planTo, DateUtil.CYCLE_DAY);
			String itemAssignee = item.getAssignee();
			Set itemAssigneeSet = CommonUtil.toSet(itemAssignee, CommonUtil.SEMICOLON);
			if (!CommonUtil.isEmpty(itemAssigneeSet) && !CommonUtil.isEqual(itemAssigneeSet, CommonUtil.toSet(assignees)))
				assignees = CommonUtil.toStringArray(itemAssigneeSet);
			if (!CommonUtil.isEmpty(assignees)) {
				String assignee = null;
				String taskId = null;
				for (int i=0; i<assignees.length; i++) {
					taskId = CommonUtil.newId();
					assignee = assignees[i];
					if (i == 0) {
						pertChanged.setObj(new Boolean(true));
						item.setType("task");
					} else {
						item = (ChtPertItem)item.clone();
						pert.addItem(item);
					}
					item.setAssignee(assignee);
					item.setRef(taskId);
					assigneeTaskIdMap.put(assignee, taskId);
				}
			}
		}
	
		TskTask[] tasks = new TskTask[assignees.length];
		for (int i=0; i<assignees.length; i++) {
			String assignee = assignees[i];
			TskTask task = new TskTask();
			if (!CommonUtil.isEmpty(assignee) && assigneeTaskIdMap.containsKey(assignee))
				task.setObjId((String)assigneeTaskIdMap.remove(assignee));
			task.setName(label);
			task.setAssignee(assignee);
			task.setCorrelation(corr);
			task.setProcessInstId(prcInstId);
			task.setType(type);
			task.setTitle(title);
			task.setDescription(desc);
			task.setPriority(priority);
			task.setDocument(doc);
			task.setAssigner(assigner);
			task.setAssignmentDate(assignDate);
			task.setDueDate(dueDate);
			task.setForm(form);
			task.setDef(defId);
			task.setMultiInstId(miId);
			task.setMultiInstFlowCondition(miFlowCond);
			task.setMultiInstOrdering(miOrder);
			task.setLoopCounter(i);
			if (i == 0) {
				task.setExtendedProperties(extProps);
			} else {
				task.setExtendedProperties(Property.cloneProperties(extProps));
			}
			if (prevTaskIds == null || prevTaskIds.length == 0) {
				task.setExtendedPropertyValue("previousTaskId", context.getObjId());
			} else {
				task.setExtendedPropertyValues("previousTaskId", prevTaskIds);
			}
			task.setExtendedPropertyValues("previousPerformer", prevPerformers);
			tasks[i] = task;
		}
		return tasks;
	}
	protected boolean isExecutable(TskTask context, Object data, String action, String expression) throws Exception {
		if (action == null || action.equalsIgnoreCase(expression))
			return true;
		return false;
	}
	protected Object toData(TskTask context) throws Exception {
		return null;
	}
	protected String[] toTaskAssignees(TskTask context, Object data, TskTaskDef def) throws Exception {
		return new String[] {def.getAssignee()};
	}
	protected String toTaskCorrelation(TskTask context, Object data, TskTaskDef def) throws Exception {
		return context.getCorrelation();
	}
	protected String toTaskType (TskTask context, Object data, TskTaskDef def) throws Exception {
		return def.getType();
	}
	protected String toTaskProcessInstId(TskTask context, Object data, TskTaskDef def) throws Exception {
		return context.getProcessInstId();
	}
	protected String toTaskTitle(TskTask context, Object data, TskTaskDef def) throws Exception {
		return context.getTitle();
	}
	protected String toTaskDescription (TskTask context, Object data, TskTaskDef def) throws Exception {
		return def.getDescription();
	}
	protected String toTaskPriority (TskTask context, Object data, TskTaskDef def) throws Exception {
		return context.getPriority();
	}
	protected String toTaskDocument (TskTask context, Object data, TskTaskDef def) throws Exception {
		return def.getDocument();
	}
	protected String toTaskAssigner (TskTask context, Object data, TskTaskDef def) throws Exception {
		return context.getAssigner();
	}
	protected Date toTaskAssignmentDate(TskTask context, Object data, TskTaskDef def) throws Exception {
		return new Date();
	}
	protected Date toTaskDueDate(TskTask context, Object data, TskTaskDef def) throws Exception {
		return null;
	}
	protected String toTaskForm (TskTask context, Object data, TskTaskDef def) throws Exception {
		return def.getForm();
	}
	protected String toTaskMultiInstFlowCondition(TskTask context, Object data, TskTaskDef def) throws Exception {
		return def.getMultiInstFlowCondition();
	}
	protected String toTaskMultiInstOrdering(TskTask context, Object data, TskTaskDef def) throws Exception {
		return def.getMultiInstOrdering();
	}
	protected Property[] toTaskExtendedProperties (TskTask context, Object data, TskTaskDef def) throws Exception {
		return Property.cloneProperties(def.getExtendedProperties());
	}
	public void postRemoveTask(String user, String id) throws Exception {
		super.postRemoveTask(user, id);
		this.removeLinksByTaskId(user, id);
	}
	public void postRemoveTaskDef(String user, String id) throws Exception {
		super.postRemoveTaskDef(user, id);
		this.removeLinksByTaskDefId(user, id);
	}
	private void removeLinksByTaskId(String user, String id) throws Exception {
		LnkLinkCond linkCond = null;
		linkCond = new LnkLinkCond();
		linkCond.setFromType("task");
		linkCond.setFromRef(id);
		getLnkService().removeLinks(user, linkCond);
		linkCond = new LnkLinkCond();
		linkCond.setToType("task");
		linkCond.setToRef(id);
		getLnkService().removeLinks(user, linkCond);
	}
	private void removeLinksByTaskDefId(String user, String id) throws Exception {
		LnkLinkCond linkCond = null;
		linkCond = new LnkLinkCond();
		linkCond.setFromType("taskdef");
		linkCond.setFromRef(id);
		getLnkService().removeLinks(user, linkCond);
		linkCond = new LnkLinkCond();
		linkCond.setToType("taskdef");
		linkCond.setToRef(id);
		getLnkService().removeLinks(user, linkCond);
	}
}
