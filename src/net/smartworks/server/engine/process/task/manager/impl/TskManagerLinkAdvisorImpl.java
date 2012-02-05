package net.smartworks.server.engine.process.task.manager.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.smartworks.server.engine.common.manager.IManager;
import net.smartworks.server.engine.common.model.Order;
import net.smartworks.server.engine.common.model.Property;
import net.smartworks.server.engine.common.script.manager.impl.SctXPathManagerImpl;
import net.smartworks.server.engine.common.util.CommonUtil;
import net.smartworks.server.engine.common.util.DateUtil;
import net.smartworks.server.engine.common.util.MisUtil;
import net.smartworks.server.engine.common.util.Wrapper;
import net.smartworks.server.engine.factory.SwManagerFactory;
import net.smartworks.server.engine.infowork.domain.manager.ISwdManager;
import net.smartworks.server.engine.infowork.domain.model.SwdDataField;
import net.smartworks.server.engine.infowork.domain.model.SwdRecord;
import net.smartworks.server.engine.infowork.domain.model.SwdRecordCond;
import net.smartworks.server.engine.infowork.form.manager.ISwfManager;
import net.smartworks.server.engine.infowork.form.model.SwfField;
import net.smartworks.server.engine.infowork.form.model.SwfForm;
import net.smartworks.server.engine.organization.manager.ISwoManager;
import net.smartworks.server.engine.process.approval.model.AprApproval;
import net.smartworks.server.engine.process.approval.model.AprApprovalLine;
import net.smartworks.server.engine.process.approval.model.AprApprovalLineCond;
import net.smartworks.server.engine.process.link.manager.ILnkManager;
import net.smartworks.server.engine.process.link.model.LnkCondition;
import net.smartworks.server.engine.process.link.model.LnkLink;
import net.smartworks.server.engine.process.link.model.LnkLinkCond;
import net.smartworks.server.engine.process.link.model.LnkObject;
import net.smartworks.server.engine.process.process.model.PrcProcessInst;
import net.smartworks.server.engine.process.script.util.F2SUtil;
import net.smartworks.server.engine.process.task.exception.TskException;
import net.smartworks.server.engine.process.task.manager.AbstractTskManagerAdvisor;
import net.smartworks.server.engine.process.task.model.TskTask;
import net.smartworks.server.engine.process.task.model.TskTaskCond;
import net.smartworks.server.engine.process.task.model.TskTaskDef;
import net.smartworks.util.LocalDate;

import org.springframework.util.StringUtils;

public class TskManagerLinkAdvisorImpl extends AbstractTskManagerAdvisor {
	
	public TskManagerLinkAdvisorImpl() {
		super();
	}

	private static Pattern pattern = Pattern.compile("\\{\\$[^$]+\\}");
	
	public void postExecuteTask(String user, TskTask obj, String action) throws Exception {
		System.out.println("LinkAdvisor postExecuteTask");

		postMapping(user, obj, action);
		
		// ####참조업무#### 
		//obj 객체에 담겨 넘어오는 참조자에게 업무를 전달(생성)한다
		this.applyRefTasks(user, obj);
		
		// ####전자결재 시작####
		//approvalLine 은 이미 만들어진 상태에서 아이디값이 넘어 온다(SmartApi.executeTask 에서 set approvalLine, SmartApi.setRecord 에서 set approvalLine)
		// 정보관리 업무는 SwdManagerAdvisorImpl postSetRecord에서 set approvalLine 한후 넘어 온다
		String type = obj.getType();
		String apprLineId = obj.getExtendedPropertyValue("approvalLine");
		
		//정보관리 업무에서 전자결재를 처음 시작했다면 type이 SINGLE이다
		//type 이 null이 아니며 approval 이고 apprLineId 를 가지고 있다면...
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
				if (logger.isInfoEnabled()) {
					logger.info("Reject Approval [" + obj.getName() + "/" + obj.getTitle() + " (TaskId : " + obj.getObjId() + " , User : " + obj.getAssignee() + ") ]");
				}
				return;
				
			// 승인인 경우
			} else {
				nextTask = setNextApproval(null, obj, apprLine);
				if (logger.isInfoEnabled()) {
					logger.info("Execute Approval [" + obj.getName() + "/" + obj.getTitle() + " (TaskId : " + obj.getObjId() + " , User : " + obj.getAssignee() + ") ]");
				}
				if (nextTask != null)
					status = nextTask.getStatus();
			}
			
			apprLine.setStatus(status);
			getAprManager().setApprovalLine("linkadvisor", apprLine, null);

			if (nextTask == null) {
				String taskRef = obj.getExtendedPropertyValue("taskRef");
				if (CommonUtil.isEmpty(taskRef)) {
					updateProcessInstStatus(user, obj.getProcessInstId());
					if (logger.isInfoEnabled()) {
						logger.info("End Approval [" + obj.getName() + "/" + obj.getTitle() + " ]");
					}
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
			if (logger.isInfoEnabled()) {
				logger.info("Cancel Approval [" + obj.getName() + "/" + obj.getTitle() + " (TaskId : " + obj.getObjId() + " , User : " + obj.getAssignee() + ") ]");
			}
			return;
				
		} else {          
			// 결재자 반영
			if (applyApprovalTask(user, obj) != null)
				return;
		}
		//####전자결재 끝####
		
		// 연결 업무 반영
		LnkLink recLink = this.applyReceiptTask(user, obj);
		
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
				if (this.doLinkTo(obj, data, action, link, linkList))
					
				if (type != null && type.equalsIgnoreCase("xor"))
					break;
			}
			// else link의 to 처리
			if (!isExe && elseLink != null)
				this.doLinkTo(obj, data, action, elseLink, linkList);

			clearLinks(obj);
		}
		
		if (!linkList.isEmpty()) {
			for (Iterator linkItr = linkList.iterator(); linkItr.hasNext();) {
				LnkLink link = (LnkLink)linkItr.next();
				this.getLnkManager().setLink("linkadvisor", link, null);
			}
		}
		
		// 프로세스 상태 갱신
		this.updateProcessInstStatus(user, obj.getProcessInstId());
		
		String objType = obj.getType();
		
		if (objType == null || objType.equalsIgnoreCase("route") || objType.equalsIgnoreCase("and")
				|| objType.equalsIgnoreCase("or") || objType.equalsIgnoreCase("xor")) 
			return;
		
		if (objType.equalsIgnoreCase("SINGLE")) {
			Date cDate = obj.getCreationDate();
			if (cDate.getTime() + 5000 < new LocalDate().getTime())//date to localdate - 
				setSingleTask(user, obj);
		}
		
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
			
			if (CommonUtil.isEmpty(obj.getFromRefId())) {
				apprTask.setFromRefType(obj.getType());
				apprTask.setFromRefId(obj.getObjId());
			} else {
				apprTask.setFromRefType(obj.getFromRefType());
				apprTask.setFromRefId(obj.getFromRefId());
			}
			
			apprTask.setExtendedPropertyValue("taskRef", taskRef);
			apprTask.setExtendedPropertyValue("approvalLine", apprLine.getObjId());
			apprTask.setExtendedPropertyValue("approval", appr.getObjId());
			this.getTskManager().setTask("linkadvisor", apprTask, null);
			if (logger.isInfoEnabled()) {
				logger.info("Assignee Next Approval [" + obj.getTitle() + " ( User : " + obj.getAssignee() + " ) ]");
			}
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
		recTask.setAssignmentDate(new LocalDate());//date to localdate - 
		recTask.setForm(recForm);
		//recTask.setDueDate(DateUtil.toDate(recDueDate));
		
		recTask.setFromRefType(obj.getType());
		recTask.setFromRefId(obj.getObjId());
		
		recTask.setExtendedAttributeValue("projectName", projectName);
		recTask.setExtendedAttributeValue("isPublic", isPublic);
		
		Date realEndDate = obj.getRealEndDate();
		recTask.setExpectStartDate(realEndDate);
		recTask.setRealStartDate(realEndDate);
		
		//date to localdate - Date expectEndDate = new Date();
		LocalDate expectEndDate = new LocalDate();
		try {
			expectEndDate = (LocalDate)DateUtil.toDate(hopeEndDate, "yyyy-MM-dd HH:mm");
		} catch (Exception e) {
			logger.warn("fail to convert hopeEndDate(yyyy-MM-dd HH:mm), default setExpectEndDate : RealStartDate + 30Min");
			expectEndDate.setTime(realEndDate.getTime() + 1800000);
		}
		recTask.setExpectEndDate(expectEndDate);
		
		this.getTskManager().setTask(user, recTask, null);
		if (logger.isInfoEnabled()) {
			logger.info("Assgined Receipt Task [ " + recTask.getTitle() + " To " + recTask.getAssignee() + " From Task Id : " + obj.getObjId() + " ]");
		}
		
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
		
		//TODO 왜하는지 모르겠다 삭제 예정
//		TskTaskCond cond = new TskTaskCond();
//		cond.setType(CommonUtil.toDefault((String)MisUtil.taskDefTypeMap().get("reference"), "reference"));
//		cond.setExtendedProperties(new Property[] {new Property("taskRef", obj.getObjId())});
//		TskTask[] taskRefs = this.getTskService().getTasks(user, cond);
//		Set refUserSet = new HashSet();
//		TskTask refTask = null;
//		if (!CommonUtil.isEmpty(taskRefs)) {
//			String assignee = null;
//			for (int i=0; i<taskRefs.length; i++) {
//				refTask = taskRefs[i];
//				assignee = refTask.getAssignee();
//				refUserSet.add(assignee);
//			}
//		}
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
		
		TskTask refTask = null;
		Set refUserSet = new HashSet();
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
			refTask.setFromRefId(obj.getObjId());
			refTask.setFromRefType(obj.getType());
			refTask.setExtendedPropertyValue("subject", subject);
			refTask.setExtendedPropertyValue("taskRef", obj.getObjId());
			refTask.setExtendedPropertyValue("workContents", workContents);
			refTask.setExtendedPropertyValue("projectName", projectName);
			refTask.setExtendedPropertyValue("isPublic", isPublic);
			
			this.getTskManager().setTask(user, refTask, null);
			if (logger.isInfoEnabled()) {
				logger.info("Assigned Reference Task [ " + subject + " ( Process Instance Id : " + refTask.getProcessInstId() + " , To User : " + refTask.getAssignee() + ")]");
			}
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
		long taskSize = getTskManager().getTaskSize(user, taskCond);
		
		// 진행 중인 태스크가 없고, 완료상태가 아니면, 완료상태로 변경
		String status = prcInst.getStatus();
		if (taskSize == 0) {
			if (status == null || !MisUtil.processInstExecutedStatusSet().contains(status)) {
				prcInst.setStatus(CommonUtil.toDefault((String)MisUtil.processInstStatusMap().get("completed"), "completed"));
				this.getPrcManager().setProcessInst("linkadvisor", prcInst, IManager.LEVEL_LITE);
				if (logger.isInfoEnabled()) {
					logger.info("Completed Process Instance [ " + prcInst.getTitle() + "( " + prcInst.getObjId() + " ) ]");
				}
				//서브인스턴스이면 부모의 SUBFLOW TASK를 찾아서 실행한다
				if (prcInst.getIsSubInstance() != null && prcInst.getIsSubInstance().equalsIgnoreCase("TRUE")) {
					invokeParentPrcInstTask(user, prcInst);
				}
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
//		PrcProcessInst pPrcInst = this.getPrcManager().getProcessInst(user, parentPrcInstId, IManager.LEVEL_LITE);
//		if (pPrcInst != null && pPrcInst.getInstVariable() != null) {
//			InstanceVariables prcInstVariables = (InstanceVariables)InstanceVariables.toObject(prcInst.getInstVariable());
//			InstanceVariable[] prcInstVariable = prcInstVariables.getInstanceVariables();
//
//			InstanceVariables pPrcInstVariables = (InstanceVariables)InstanceVariables.toObject(pPrcInst.getInstVariable());
//			InstanceVariable[] pPrcInstVariable = pPrcInstVariables.getInstanceVariables();
//			
//			Map pPrcInstVariableMap = new HashMap();
//			for (int i = 0; i < pPrcInstVariable.length; i++) {
//				pPrcInstVariableMap.put(pPrcInstVariable[i].getId(), pPrcInstVariable[i]);
//			}
//			
//			for (int i = 0; i < prcInstVariable.length; i++) {
//				if (pPrcInstVariableMap.get(prcInstVariable[i].getId()) == null) {
//					pPrcInstVariables.addInstanceVariable(prcInstVariable[i]);
//				} else {
//					InstanceVariable tempVariable = (InstanceVariable)pPrcInstVariableMap.get(prcInstVariable[i].getId());
//					tempVariable.setVariableValue(prcInstVariable[i].getVariableValue());
//				}
//				
//			}
//			
//			pPrcInst.setInstVariable(pPrcInstVariables.toString());
//			
//			this.getPrcManager().setProcessInst(user, pPrcInst, IManager.LEVEL_LITE);	
//		} else {
//			pPrcInst.setInstVariable(prcInst.getInstVariable());
//			this.getPrcManager().setProcessInst(user, pPrcInst, IManager.LEVEL_LITE);	
//		}
		TskTaskCond cond = new TskTaskCond();
		cond.setProcessInstId(parentPrcInstId);
		cond.setDef(parentTskDefId);

		cond.setOrders(new Order[] {new Order(TskTask.A_CREATIONDATE, false)});
		
		TskTask[] parentTask = this.getTskManager().getTasks(user, cond, IManager.LEVEL_ALL);
		if (parentTask[0] == null || parentTask[0].getStatus().equalsIgnoreCase(CommonUtil.toDefault((String)MisUtil.taskStatusMap().get("executed"), "executed")))
			return;
		parentTask[0].setInstVariable(prcInst.getInstVariable());
		getTskManager().executeTask(user, parentTask[0], "execute");
		if (logger.isInfoEnabled()) {
			logger.info("End Sub Process, Invoke Parent Process [ " + prcInst.getTitle() + " - Sub Process Instance: " + prcInst.getObjId() + " To Parent Process Instance: " + parentPrcInstId + ", Parent Task Instance : " + parentTask[0].getObjId() + " ]");
		}
			
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
		
		ILnkManager lnkMgr = this.getLnkManager();
		
		LnkLinkCond cond = new LnkLinkCond();
		cond.setType("processinst");
		cond.setCorrelation(obj.getCorrelation());
		cond.setFromType("task");
		cond.setFromRef(obj.getObjId());
		LnkLink[] links = lnkMgr.getLinks("linkadvisor", cond, null);
		
		if (links != null)
			return links;

		String def = obj.getDef();
		if (def == null || def.length() == 0)
			return null;
		
		cond.setType("process");
		cond.setCorrelation(null);
		cond.setFromType("taskdef");
		cond.setFromRef(def);
		links = lnkMgr.getLinks("linkadvisor", cond, null);
		
		return links;
	}
	protected TskTask getPreviousTask(TskTask obj) throws Exception {
		String[] prevTaskIds = obj.getExtendedPropertyValues("previousTaskId");
		if (prevTaskIds == null || prevTaskIds.length == 0)
			return null;
		
		String prevTaskId = prevTaskIds[0];
		TskTask prevTask = this.getTskManager().getTask("linkadvisor", prevTaskId, null);
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
	private boolean doLinkTo(TskTask obj, Object data, String action, LnkLink link, List linkList) throws Exception {
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
			TskTaskDef taskDef = this.getTskManager().getTaskDef("linkadvisor", toRef, null);
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
				
				long andTaskSize = this.getTskManager().getTaskSize("linkadvisor", cond);
				
				if (andTaskSize < 1)
					tasks = toTasks(obj, data, action, taskDef, toLabel, toExpr);
			} else {
				tasks = toTasks(obj, data, action, taskDef, toLabel, toExpr);
			}
		} else if (toType.equalsIgnoreCase("task")) {
			// TODO 지저분한 소스 (보내기 업무, 반려)
			tasks = new TskTask[] {cloneTask(toRef)};
		}
		
		if (tasks != null && tasks.length != 0) {
			String linkId =link.getObjId();
			Property[] extProps = null;
			if (linkId != null) {
				link = this.getLnkManager().getLink("linkadvisor", linkId, null);
				extProps = Property.cloneProperties(link.getExtendedProperties());
			}
			
			for (int j=0; j<tasks.length; j++) {
				TskTask task = tasks[j];
				String extValues = obj.getExtendedAttributeValue("extValues");
				if (!CommonUtil.isEmpty(extValues)) {
					task.setExtendedAttributeValue("extValues", extValues);		
				}
				this.getTskManager().setTask("linkadvisor", task, null);
				linkList.add(newLink(obj, task, action, extProps));
			}
		}
		
		return ((Boolean)isPertChanged.getObj()).booleanValue();
	}
	private TskTask cloneTask(String objId) throws Exception {
		return cloneTask(this.getTskManager().getTask("linkadvisor", objId, null));
	}
	private TskTask cloneTask(TskTask task) throws Exception {
		if (task == null)
			return null;
		TskTask newTask = (TskTask)task.cloneNew();
		newTask.setAssignmentDate(new LocalDate());//date to localdate - 
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
		this.getLnkManager().removeLinks("linkadvisor", cond);
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
	private TskTask[] toTasks(TskTask context, Object data, String action, TskTaskDef def, String label, String expression) throws Exception {
		String doc = toTaskDocument(context, data, def);
		String[] assignees = toTaskAssignees(context, data, def);
		if (assignees == null || assignees.length == 0)
			return null;
		if (label == null || label.length() == 0)
			label = def.getName();
		String corr = toTaskCorrelation(context, data, def);
		String prcInstId = toTaskProcessInstId(context, data, def);
		String workSpaceId = context.getWorkSpaceId();
		if (workSpaceId == null) {
			PrcProcessInst prcInst = getPrcManager().getProcessInst("", prcInstId, IManager.LEVEL_LITE);
			if (prcInst == null) {
				workSpaceId = null;
			} else {
				workSpaceId = prcInst.getWorkSpaceId();
			}
		}
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
			TskTask[] prevTasks = this.getTskManager().getTasks("linkAdvisor", prevTaskCond, null);
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
		
		TskTask[] tasks = new TskTask[assignees.length];
		for (int i=0; i<assignees.length; i++) {
			String assignee = assignees[i];
			TskTask task = new TskTask();
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
			task.setWorkSpaceId(workSpaceId);
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
	protected Date toTaskAssignmentDate(TskTask context, Object data, TskTaskDef def) throws Exception {
		return new LocalDate();//date to localdate - 
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
		getLnkManager().removeLinks(user, linkCond);
		linkCond = new LnkLinkCond();
		linkCond.setToType("task");
		linkCond.setToRef(id);
		getLnkManager().removeLinks(user, linkCond);
	}
	private void removeLinksByTaskDefId(String user, String id) throws Exception {
		LnkLinkCond linkCond = null;
		linkCond = new LnkLinkCond();
		linkCond.setFromType("taskdef");
		linkCond.setFromRef(id);
		getLnkManager().removeLinks(user, linkCond);
		linkCond = new LnkLinkCond();
		linkCond.setToType("taskdef");
		linkCond.setToRef(id);
		getLnkManager().removeLinks(user, linkCond);
	}
	
	
	
	
	
	
	
	
	
	//################  sub class content #####################
	
	
	
	private String preMapping(TskTask exeTask, Object data, TskTaskDef def) throws Exception {
		String formId = def.getForm();
		if (CommonUtil.isEmpty(formId))
			return null;
		
		// 폼이 없으면 바로 반환
		SwfForm form = F2SUtil.getForm(formId);
		if (form == null)
			return null;
		
		SwdRecord record = new SwdRecord();
		
		// 필드 매핑
		Map context = null;
		if (data instanceof Map) {
			context = (Map)data;
			context.put("exeTask", exeTask);
		}
		
		if (!formId.equalsIgnoreCase("SYSTEMFORM") && !formId.equalsIgnoreCase("DEFAULTFORM"))
			getSwdManager().preFieldMapping(exeTask.getPerformer(), form, record, context);

		// 4. 데이터를 만듭니다.
		String taskDoc = newTaskDocument(form, record);
		
		return taskDoc;
	}
	private String newTaskDocument(SwfForm form, SwdRecord record) throws Exception {
		if (form == null)
			return null;
		record.setFormId(form.getId());
		record.setFormVersion(form.getVersion());
		
		SwfField[] fields = form.getFields();
		if (CommonUtil.isEmpty(fields))
			return record.toString();
		
		SwfField field;
		SwdDataField dataField;
		for (int i=0; i<fields.length; i++) {
			field = fields[i];
			String fieldId = field.getId();
			dataField = record.getDataField(fieldId);
			if (dataField == null) {
				dataField = this.newDataField(field);
				record.addDataField(dataField);
			} else {
				populateDataField(field, dataField);
			}
		}

		return record.toString("DataRecord", null);
	}
	private SwdDataField newDataField(SwfField field)
			throws Exception {
		String fieldId = field.getId();
		SwdDataField dataField = new SwdDataField();
		dataField.setId(fieldId);
		
		populateDataField(field, dataField);
		
		return dataField;
	}
	private void populateDataField(SwfField field, SwdDataField dataField) throws Exception {
		dataField.setName(field.getName());
		dataField.setType(field.getSystemType());
	}
	private void postMapping(String user, TskTask obj, String action) throws Exception {
		// 폼 연결이 되어있지 않으면 바로 반환
		String formId = obj.getForm();
		if (CommonUtil.isEmpty(formId))
			return;
		
		// 폼이 없으면 바로 반환
		SwfForm form = F2SUtil.getForm(formId);
		if (form == null)
			return;
		
		// 업무 도큐먼트가 없으면 바로 반환
		String taskDoc = obj.getDocument();
		if (taskDoc == null)
			return;
		taskDoc = taskDoc.trim();
		taskDoc = StringUtils.replace(taskDoc, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>", "");
		taskDoc = taskDoc.trim();
		if (!taskDoc.startsWith("<DataRecord") || !taskDoc.endsWith(">"))
			return;
		
		Map context = new HashMap();
		SwdRecord taskDocRecord = (SwdRecord)SwdRecord.toObject(taskDoc);
		context.put("task", obj);
		this.getSwdManager().postFieldMapping(user, form, taskDocRecord, context);
	}
	public void postGetTask(String user, String id, String level, TskTask res) throws Exception {
		if (res == null)
			return;
		String formId = res.getForm();
		if (!"SINGLE".equalsIgnoreCase(res.getType()) || CommonUtil.isEmpty(formId) || formId.equalsIgnoreCase("DEFAULTFORM"))
			return;
		if (MisUtil.taskExecutedStatusSet().contains(res.getStatus()))
			return;
//		String domainId = res.getExtendedPropertyValue("domainId");
		String recordId = res.getExtendedPropertyValue("recordId");
		if (CommonUtil.isEmpty(formId) || CommonUtil.isEmpty(recordId))
			return;
		SwdRecordCond cond = new SwdRecordCond();
		cond.setFormId(formId);
		cond.setRecordId(recordId);
		SwdRecord rec = getSwdManager().getRecord(user, cond, IManager.LEVEL_ALL);
		if (rec == null)
			return;
		res.setDocument(rec.toString(null, null));
	}
	public void preSetTask(String user, TskTask obj, String level) throws Exception {
		super.preSetTask(user, obj, level);
		
		String type = obj.getType();
		if (type.equalsIgnoreCase("SINGLE")) {
			String domainId = obj.getExtendedPropertyValue("domainId");
			String recordId = obj.getExtendedPropertyValue("recordId");
			if (domainId == null || recordId == null) {
				String doc = obj.getDocument();
				if (CommonUtil.isEmpty(doc)) {
					SwdRecord record = new SwdRecord();
					record.setFormId(obj.getForm());
					record.setFormVersion(1);
					obj.setDocument(record.toString(null, null));
					return;
				} else {
					SwdRecord record = (SwdRecord)SwdRecord.toObject(doc);
					obj.setExtendedPropertyValue("domainId", record.getDomainId());
					obj.setExtendedPropertyValue("recordId", record.getRecordId());
				}
			}
		}
		//예정 시작, 종료     실제 시작,종료시간을 셋팅한다.
		Date expectStartDate = obj.getExpectStartDate();
		Date expectEndDate = obj.getExpectEndDate();
		if (expectStartDate != null && expectEndDate != null)
			return;
		//taskDef 를 조회 하여 평균 소요시간을 구한다
		if (expectStartDate == null) {
			//예상 시작시간이 없다면 예상시작, 실제시작시간에 현재 시간을 입력하고 taskDef의 평균소요 시간을 
			//구하여 예상 종료시간을 채운다. 만약에 taskDef가 없다면 기본30분으로 한다(//TODO 정책확립필요)
			//date to localdate - Date now = new Date();
			LocalDate now = new LocalDate();
			obj.setExpectStartDate(now);
			obj.setRealStartDate(now);
			
			String def = obj.getDef();
			TskTaskDef taskDef = null;
			
			if (!CommonUtil.isEmpty(def))
				taskDef = getTskManager().getTaskDef("tskManagerSmartLinkAdvisor", def, IManager.LEVEL_LITE);
			expectEndDate = new LocalDate();//date to localdate - 
			if (taskDef != null &&  !CommonUtil.isEmpty(taskDef.getDueDate())) {
				//dueDate 는 분단위로 설정이 되어 있다
				expectEndDate.setTime(now.getTime() + ((Long.parseLong(taskDef.getDueDate())) * 60 * 1000));
			} else {
				expectEndDate.setTime(now.getTime() + 1800000);
			}
			obj.setExpectEndDate(expectEndDate);
			
			
			//postGetTasks 에 있는 내용을 옮김 - 데이터를 get()하고나서 evict(obj)를 하는데 extprop가 맞지 않아 nullpoint가 난다...
			//세션케쉬에는 processInstCreationUser 값이 없는 상태로 올라가 있는데 postGetTasks를 하는 도중 processInstCreationUser를
			//끼워 넣는다 -> 캐쉬에있는 properties의 갯수와 가져온 properties의 갯수가 틀려서 evict를 하는 도중 널포인트에러를 발생한다(추측)
			String prcInstCreateUser = obj.getExtendedPropertyValue("processInstCreationUser");
			if (prcInstCreateUser != null)
				return;
			String prcInstId = obj.getProcessInstId();
			if (prcInstId != null) {
				PrcProcessInst prcInst = this.getPrcManager().getProcessInst("linkAdvisor", prcInstId, IManager.LEVEL_LITE);
				if (prcInst != null) {
					prcInstCreateUser = prcInst.getCreationUser();
					obj.addExtendedProperty(new Property("processInstCreationUser", prcInstCreateUser));
				}
			}
			
			
			
			
		}
	}
	public void postSetTask(String user, TskTask obj, String action) throws Exception {
		super.postSetTask(user, obj, action);
		
		String type = obj.getType();
		if (type.equalsIgnoreCase("SINGLE")) {
			Date cDate = obj.getCreationDate();
			if (cDate.getTime() + 5000 < new LocalDate().getTime())//date to localdate - 
				setSingleTask(user, obj);
		}
		
	}
	public void preExecuteTask(String user, TskTask obj, String action) throws Exception {
		System.out.println("LnkAdvisor preExecuteTask");
//		if (action != null && action.equalsIgnoreCase("return"))
//			return;
		
		String name = obj.getName();
		String formId = obj.getForm();

		// 결재자 / 수신자 / 참조자
		String superTaskId = obj.getExtendedAttributeValue("superTaskId");
		String superForm = obj.getExtendedAttributeValue("superForm");
		String superRecordId = obj.getExtendedAttributeValue("superRecordId");
		String approvalLine = obj.getExtendedAttributeValue("approvalLine");
		String receiptUser = obj.getExtendedAttributeValue("receiptUser");
		String referenceUser = obj.getExtendedAttributeValue("referenceUser");
		String receiptTitle = obj.getExtendedAttributeValue("receiptTitle");
		String receiptPriority = obj.getExtendedAttributeValue("receiptPriority");
		String receiptForm = obj.getExtendedAttributeValue("receiptForm");
		String receiptDescription = obj.getExtendedAttributeValue("receiptDescription");
		String fileGroupId = obj.getExtendedAttributeValue("fileGroupId");
		if (!CommonUtil.isEmpty(superTaskId))
			obj.setExtendedAttributeValue("superTaskId", null);
		if (!CommonUtil.isEmpty(superForm))
			obj.setExtendedAttributeValue("superForm", null);
		if (!CommonUtil.isEmpty(superRecordId))
			obj.setExtendedAttributeValue("superRecordId", null);
		if (!CommonUtil.isEmpty(approvalLine))
			obj.setExtendedAttributeValue("approvalLine", null);
		if (!CommonUtil.isEmpty(receiptUser))
			obj.setExtendedAttributeValue("receiptUser", null);
		if (!CommonUtil.isEmpty(referenceUser))
			obj.setExtendedAttributeValue("referenceUser", null);
		if (!CommonUtil.isEmpty(receiptTitle))
			obj.setExtendedAttributeValue("receiptTitle", null);
		if (!CommonUtil.isEmpty(receiptPriority))
			obj.setExtendedAttributeValue("receiptPriority", null);
		if (!CommonUtil.isEmpty(receiptForm))
			obj.setExtendedAttributeValue("receiptForm", null);
		if (!CommonUtil.isEmpty(receiptDescription))
			obj.setExtendedAttributeValue("receiptDescription", null);
		if (!CommonUtil.isEmpty(fileGroupId))
			obj.setExtendedAttributeValue("fileGroupId", null);
		superTaskId = CommonUtil.toNull(superTaskId);
		superForm = CommonUtil.toNull(superForm);
		superRecordId = CommonUtil.toNull(superRecordId);
		approvalLine = CommonUtil.toNull(approvalLine);
		receiptUser = CommonUtil.toNull(receiptUser);
		referenceUser = CommonUtil.toNull(referenceUser);
		receiptTitle = CommonUtil.toNull(receiptTitle);
		receiptPriority = CommonUtil.toNull(receiptPriority);
		receiptForm = CommonUtil.toNull(receiptForm);
		receiptDescription = CommonUtil.toNull(receiptDescription);
		fileGroupId = CommonUtil.toNull(fileGroupId);

		if (superTaskId != null)
			obj.setExtendedPropertyValue("superTaskId", superTaskId);
		if (superForm != null)
			obj.setExtendedPropertyValue("superForm", superForm);
		if (superRecordId != null)
			obj.setExtendedPropertyValue("superRecordId", superRecordId);
		if (approvalLine != null)
			obj.setExtendedPropertyValue("approvalLine", approvalLine);
		if (receiptTitle != null)
			obj.setTitle(receiptTitle);
		if (receiptDescription != null)
			obj.setDescription(receiptDescription);
		if (receiptUser != null) {
			obj.setExtendedPropertyValue("receiptUser", receiptUser);
			obj.setExtendedPropertyValue("receiptType", "SINGLE");
			if (receiptForm == null || receiptForm.equalsIgnoreCase(formId)) {
				obj.setExtendedPropertyValue("receiptForm", formId);
				obj.setExtendedPropertyValue("receiptName", name);
			} else {
				obj.setExtendedPropertyValue("receiptForm", receiptForm);
				SwfForm receiptFormObj = getSwfManager().getForm(user, receiptForm);
				String receiptName = null;
				if (receiptFormObj == null) {
					receiptName = name;
				} else {
					receiptName = receiptFormObj.getName();
				}
				obj.setExtendedPropertyValue("receiptName", receiptName);
			}
			if (receiptDescription != null)
				obj.setExtendedPropertyValue("receiptDescription", receiptDescription);
		}
		if (referenceUser != null)
			obj.setExtendedPropertyValue("referenceUser", referenceUser);
		if (fileGroupId != null)
			obj.setExtendedPropertyValue("fileGroupId", fileGroupId);
		
		// 내보내기 할당
	}
	private void setSingleTask(String user, TskTask obj) throws Exception {
		String doc = obj.getDocument();
		if (CommonUtil.isEmpty(doc))
			return;
		SwdRecord record = (SwdRecord)SwdRecord.toObject(doc);
		record.setRecordId(null);
//		if (CommonUtil.isEmpty(record.getRecordId()))
//			return;
		String formId = record.getFormId();
		if (CommonUtil.isEmpty(formId) || formId.equalsIgnoreCase("DEFAULTFORM"))
			return;
		record.setExtendedAttributeValue("setMode", "process");//setMode가 없거나 process가 아니라면 Task를 만든다
		this.getSwdManager().setRecord(user, record, null);
	}
	public void postGetTasks(String user, TskTaskCond cond, String level, TskTask[] res) throws Exception {
		super.postGetTasks(user, cond, level, res);
		if (res == null || res.length == 0)
			return;
		Map<String, String> creationUserMap = new HashMap<String, String>();
		TskTask task = null;
		PrcProcessInst prcInst = null;
		String prcInstCreateUser = null;
		

		//preSetTask로 내용 옮김 - 데이터를 get()하고나서 evict(obj)를 하는데 extprop가 맞지 않아 nullpoint가 난다...
		//세션케쉬에는 processInstCreationUser 값이 없는 상태로 올라가 있는데 postGetTasks를 하는 도중 processInstCreationUser를
		//끼워 넣는다 -> 캐쉬에있는 properties의 갯수와 가져온 properties의 갯수가 틀려서 evict를 하는 도중 널포인트에러를 발생한다(추측)
//		for (int i=0; i<res.length; i++) {
//			task = res[i];
//			prcInstCreateUser = task.getExtendedPropertyValue("processInstCreationUser");
//			if (prcInstCreateUser != null)
//				continue;
//			String prcInstId = task.getProcessInstId();
//			if (prcInstId != null) {
//				if (creationUserMap.containsKey(prcInstId)) {
//					task.setExtendedPropertyValue("processInstCreationUser", creationUserMap.get(prcInstId));
//				} else {
//					prcInst = this.getPrcManager().getProcessInst("linkAdvisor", prcInstId, IManager.LEVEL_LITE);
//					if (prcInst != null) {
//						prcInstCreateUser = prcInst.getCreationUser();
//						creationUserMap.put(prcInstId, prcInstCreateUser);
//						task.setExtendedPropertyValue("processInstCreationUser", prcInstCreateUser);
//					}
//				}
//			}
//		}
	}
	protected boolean isExecutable(TskTask context, Object data, String action, String expression) throws Exception {
		String script = parse(context, expression, getSctManager() instanceof SctXPathManagerImpl);
		return getSctManager().executeBoolean(script, data);
	}

	protected String toTaskAssigner(TskTask context, Object data, TskTaskDef def) throws Exception {
		String assigner = context.getAssignee();
		if (assigner != null && assigner.length() != 0)
			return assigner;
		assigner = context.getExtendedPropertyValue("previousPerformer");
		if (assigner == null)
			assigner = context.getExtendedPropertyValue("previousAssignee");
		return assigner;
	}

	protected Object toData(TskTask exeTask) throws Exception {
		Map taskDocMap = new HashMap();
		if (exeTask != null) {
			String actId = exeTask.getExtendedPropertyValue("activityId");
			if (actId != null) {
				String taskDoc = exeTask.getDocument();
				if (taskDoc != null) {
					taskDoc = taskDoc.trim();
					if (taskDoc.startsWith("<") && taskDoc.endsWith(">")) {
						taskDocMap.put(actId, taskDoc);
						taskDocMap.put(actId + "Record", SwdRecord.toObject(taskDoc));
					}
				}
			}
		}
		return taskDocMap;
	}

	protected String[] toTaskAssignees(TskTask context, Object data, TskTaskDef def)
			throws Exception {
		String expression = def.getAssignee();
		Map taskDocMap = (Map)data;
		boolean hasTaskDoc = false;
		if (taskDocMap != null)
			hasTaskDoc = taskDocMap.containsKey("taskDocRecord");
		if (CommonUtil.isEmpty(expression)) {
			String type = context.getType();
			if (type != null && 
					(type.equalsIgnoreCase("xor") ||  
					type.equalsIgnoreCase("and") || 
					type.equalsIgnoreCase("or") || 
					type.equalsIgnoreCase("route"))) {
				context = getPreviousTask(context);
			}
			if (context != null) {
				String prevForm = context.getForm();
				if (prevForm != null && prevForm.equalsIgnoreCase("SYSTEMFORM")) {
					SwdRecord prevRec = (SwdRecord)SwdRecord.toObject(context.getDocument());
					SwdDataField nextAssignee = prevRec.getDataField("nextAssignee");
					if (nextAssignee != null)
						return new String[]{nextAssignee.getRefRecordId()};
				}
			}
			return new String[]{null};
		}
		
//		String taskDocStr = null;
		SwdRecord taskDocRecord = null;
		if (hasTaskDoc) {
//			taskDocStr = (String)taskDocMap.get("taskDoc");
			taskDocRecord = (SwdRecord)taskDocMap.get("taskDocRecord");
		}

		// TODO 지정된수행자/변수에 대한 새 정의와 그에 따른 구현
		if (expression.startsWith("{$") || expression.startsWith("$")) {
			String script = parse(context, expression, getSctManager() instanceof SctXPathManagerImpl);
			return new String[]{(String) getSctManager().execute(script, data)};
		
			//TODO KM 2010_11_30 플렉스 부분이 수정되어야 테스트가 가능함(위의 소스를 사용할지 아래 소스를 사용할지)
//		if (expression.startsWith("{$") || expression.startsWith("$ServiceParam")) {
//			String prcInstId = context.getProcessInstId();
//			if (CommonUtil.isEmpty(prcInstId))
//				return new String[] {null};
//
//			TskTaskCond tskCond = new TskTaskCond();
//			tskCond.setProcessInstId(prcInstId);
//			tskCond.setExtendedProperties(new Property[]{new Property("activityId", actId)});
//			TskTask[] tasks = getTskManager().getTasks("SctSmartXPathFunction", tskCond, IManager.LEVEL_ALL);
//			if (tasks == null)
//				return new String[] {null};
//			InstanceVariables variables = (InstanceVariables)InstanceVariables.toObject(tasks[0].getInstVariable());
//			InstanceVariable variable = variables.getInstanceVariableById(variableName);
//		
//			if (variable == null)
//				return new String[] {null};
//
//			return new String[] {variable.getVariableValue()};
			
		} else {
			// 표현식이 4자 이하의 숫자이면 dataFieldId로 간주한다.
			boolean isNumber = CommonUtil.isNumber(expression);
			if (isNumber && expression.length() < 5) {
				if (taskDocRecord == null) {
					return new String[] {null};
				}

				SwdDataField dataField = taskDocRecord.getDataField(expression);
				if (dataField == null)
					return new String[] {null};
				
				String refRecordId = dataField.getRefRecordId();
				if (CommonUtil.isEmpty(refRecordId))
					refRecordId = dataField.getValue();

				return new String[] {refRecordId};
				
//				String[] assignees = F2SUtil.getDataFieldValues(taskDocStr, expression);
//				if (assignees == null || assignees.length == 0)
//					return new String[] {null};
//				return assignees;
			} else {
				return new String[] {expression};
			}
		}

	}

	/**
	 * 치환패턴에 의거한 스크립트 1차 파싱
	 * @param context
	 * @param script
	 * @return
	 * @throws Exception
	 */
	private static String parse(TskTask context, String script, boolean isXPath) throws Exception {
		Matcher matcher = pattern.matcher(script);
		for (int i = 0; matcher.find(i); i = matcher.end()) {
			// matched string - "{$ActivityData.3.34.승인여부}"
			String str = matcher.group();
			if (str.length() < 3)
				throw new TskException("Empty reserved word: " + str);
			str = str.substring(2, str.length() - 1);
			String func = null;
			// "ActivityData.3.34.승인여부"
			StringTokenizer tokenizer = new StringTokenizer(str, CommonUtil.DOT);
			if (tokenizer.countTokens() < 3)
				continue;
			String instId = context.getProcessInstId();
			String funcPrefix = null;
			String actId = null;
			String dataId = null;
			for (int j = 0; tokenizer.hasMoreTokens(); j++) {
				String token = tokenizer.nextToken();
				switch (j) {
					case 0 :
						funcPrefix = token;
						break;
					case 1 :
						actId = token;
						break;
					case 2 :
						dataId = token;
						break;
					case 3 :
						//SubParameter.26.INOUT.resultSub //INOUT은 현재 필요없는 데이터이기때문에 dataId를 마지막에 있는 전역변수아이디로 셋팅한다
						if (funcPrefix.equals("SubParameter") || funcPrefix.equals("ServiceParam"))
							dataId = token;
						break;
					default :
						continue;
				}
			}
			// If isXPath is true, "mis:getActivityData(인스턴스아이디, '3', '34')"
			// else "getActivityData(인스턴스아이디, '3', '34')"
			func = new StringBuffer(isXPath ? "mis:get" : "get").append(funcPrefix)
					.append("('").append(instId)
					.append("', '").append(actId)
					.append("', '").append(dataId)
					.append("')").toString();
			script = StringUtils.replace(script, new StringBuffer("{$").append(str).append("}").toString(), func);
//			script = script.replaceAll(new StringBuffer("\\{\\$").append(str).append("\\}").toString(), func);
		}
		
		script = StringUtils.replace(script, "&&", "and");
		script = StringUtils.replace(script, "||", "or");

		return script;
	}
	protected String getSubPrcInstId(String parentPrcInstId, String parentTskActId) throws Exception {
		return null;
	}
	protected String toTaskDocument (TskTask exeTask, Object data, TskTaskDef def) throws Exception {
		String taskDoc = preMapping(exeTask, data, def);
		
		// 5. 데이터 컨텍스트에 추가합니다.
		if (data != null && taskDoc != null) {
			taskDoc = taskDoc.trim();
			if (taskDoc.startsWith("<") && taskDoc.endsWith(">")) {
				((Map)data).put("taskDoc", taskDoc);
				((Map)data).put("taskDocRecord", (SwdRecord)SwdRecord.toObject(taskDoc));
			}
		}
		return taskDoc;
	}
}
