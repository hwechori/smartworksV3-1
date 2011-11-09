package net.smartworks.server.engine.process.task.manager.impl;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import net.smartworks.server.engine.common.collection.manager.IColManager;
import net.smartworks.server.engine.common.collection.model.ColValue;
import net.smartworks.server.engine.common.collection.model.ColValueCond;
import net.smartworks.server.engine.common.manager.IManager;
import net.smartworks.server.engine.common.model.MisObject;
import net.smartworks.server.engine.common.model.Property;
import net.smartworks.server.engine.common.util.CommonUtil;
import net.smartworks.server.engine.common.util.MisUtil;
import net.smartworks.server.engine.process.process.model.PrcProcess;
import net.smartworks.server.engine.process.process.model.PrcProcessCond;
import net.smartworks.server.engine.process.process.model.PrcProcessInst;
import net.smartworks.server.engine.process.process.model.PrcProcessInstCond;
import net.smartworks.server.engine.process.task.exception.TskException;
import net.smartworks.server.engine.process.task.manager.AbstractTskManagerAdvisor;
import net.smartworks.server.engine.process.task.model.TskTask;
import net.smartworks.server.engine.process.task.model.TskTaskDef;

public class TskManagerDefaultAdvisorImpl extends AbstractTskManagerAdvisor {
	public static final String USER = "defaultTaskAdvisor";
	public static final String VALUETYPE_PROCESSMONITORINGDIAGRAMDIRTYFLAG = "process.monitoringdiagram.dirtyflag";
	public TskManagerDefaultAdvisorImpl() {
		super();
	}
	public void preSetTask(String user, TskTask obj, String level) throws Exception {
		if (level != null && level.equals(IManager.LEVEL_LITE))
			return;
		// 태스크 값을 채움.
		this.fill(obj);
		
		// 프로세스 인스턴스 설정
		this.setProcessInst(user, obj);
		
		// 프로세스 모니터링 다이어그램 더디플래그를 올린다.
		this.raiseDirtyFlag(obj);
	}
	private void fill(TskTask obj) throws Exception {
		if (obj.getObjId() != null && obj.getStatus() != null && obj.getStatus() != "1")
			return;
		String status = null;
		if (obj.getStatus() == "1") {
			status = CommonUtil.toDefault((String)MisUtil.taskStatusMap().get("created"), "created");
		} else {
			status = CommonUtil.toDefault((String)MisUtil.taskStatusMap().get("started"), "started");
		}
		
		obj.setStatus(status);
		String def = obj.getDef();
		if (def == null) {
			fillForm(obj, toData(obj), null);
			return;
		}
		TskTaskDef taskDef = getTskManager().getTaskDef("tskManagerDefaultAdvisor", def, null);
		if (taskDef == null) 
			return;
		this.fill(obj, taskDef);
	}
	private void fill(TskTask obj, TskTaskDef def) throws Exception {
		Object data = toData(obj);
		
		fillName(obj, data, def.getName());
		fillCorrelation(obj, data, def.getCorrelation());
		fillProcessInstId(obj, data, def.getProcessInstId());
		fillType(obj, data, def.getType());
		fillPriority(obj, data, def.getPriority());
		fillTitle(obj, data, def.getTitle());
		fillDescription(obj, data, def.getDescription());
		fillDocument(obj, data, def.getDocument());
		fillAssigner(obj, data, def.getAssigner());
		fillAssignmentDate(obj, data, def.getAssignmentDate());
		fillDueDate (obj, data, def.getDueDate());
		fillForm(obj, data, def.getForm());
		fillDef(obj, data, def.getObjId());
		fillExtendedProperties(obj, data, def.getExtendedProperties());
	}
	private void setProcessInst(String user, TskTask obj) throws Exception {
		if (getPrcManager() == null)
			return;
		String preDefinedPrcInstId = null;
		if (obj.getProcessInstId() != null) {
			if (getPrcManager().getProcessInst(user, obj.getProcessInstId(), null) != null) {
				return;
			} else {
				preDefinedPrcInstId = obj.getProcessInstId();
			}
		} else {
			obj.setObjId(CommonUtil.newId());
		}
		String title = obj.getTitle();
		String priority = obj.getPriority();
		String dId = obj.getExtendedPropertyValue("diagramId");
		String pId = obj.getExtendedPropertyValue("processId");
		String dVer = obj.getExtendedPropertyValue("diagramVersion");
		String superTaskId = obj.getExtendedPropertyValue("superTaskId");
		String parentPrcInstId = obj.getExtendedPropertyValue("parentPrcInstId");
		String parentTskDefId = obj.getExtendedPropertyValue("parentTskDefId");
		String pName = this.getProcessName(dId, dVer, pId);
		
		PrcProcessInst prcInst = new PrcProcessInst();
		if (preDefinedPrcInstId != null)
			prcInst.setObjId(preDefinedPrcInstId);
		prcInst.setStatus(CommonUtil.toDefault((String)MisUtil.processInstStatusMap().get("started"), "started"));
		prcInst.setTitle(title);
		prcInst.setPriority(priority);
		prcInst.setDiagramId(dId);
		prcInst.setDiagramVersion(dVer);
		prcInst.setProcessId(pId);
		prcInst.setName(pName);
		prcInst.setExtendedPropertyValue("superTaskId", superTaskId);
		if (!CommonUtil.isEmpty(parentPrcInstId)) {
			prcInst.setIsSubInstance("TRUE");
			prcInst.setExtendedPropertyValue("parentPrcInstId", parentPrcInstId);
			prcInst.setExtendedPropertyValue("parentTskDefId", parentTskDefId);
		}	
		getPrcManager().setProcessInst(user, prcInst, null);
		if (logger.isInfoEnabled()) {
			logger.info("Set Process Instance [ " + title + " ( " + pName + " Process : " + pId + " , Process Instance Id : " + prcInst.getObjId() + " ) ]");
		}
		
		obj.setProcessInstId(prcInst.getObjId());
		obj.setExtendedPropertyValue("processInstCreationUser", user);

	}
	private String getProcessName(String dId, String dVer, String pId) throws Exception {
		if (dId == null && pId == null)
			return null;
		PrcProcessCond prcCond = new PrcProcessCond();
		prcCond.setDiagramId(dId);
		prcCond.setDiagramVersion(dVer);
		prcCond.setProcessId(pId);
		PrcProcess[] prcs = getPrcManager().getProcesses("tskManagerDefaultAdvisor", prcCond, IManager.LEVEL_LITE);
		if (prcs == null || prcs.length == 0)
			return null;
		PrcProcess prc = prcs[0];
		return prc.getName();
	}
	
	private void raiseDirtyFlag(TskTask task) throws Exception {
		String prcInstId = task.getProcessInstId();
		if (prcInstId == null)
			return;
		IColManager colManager = this.getColManager();
		if (colManager == null)
			return;
		
		// 기존 플래그 조회
		ColValueCond cond = new ColValueCond();
		cond.setType(VALUETYPE_PROCESSMONITORINGDIAGRAMDIRTYFLAG);
		cond.setRef(prcInstId);
		ColValue[] values = colManager.getValues(USER, cond, null);
		
		ColValue value = null;
		if (values != null && values.length != 0) {
			// 기존 플래그가 있으면 업데이트
			value = values[0];
			// 기존 플개그 값이 true이면 바로 끝
			String valueStr = value.getValue();
			if (valueStr != null && valueStr.equalsIgnoreCase(CommonUtil.TRUE))
				return;
			value.setName(task.getTitle());
			value.setValue(CommonUtil.TRUE);
			colManager.setValue(USER, value, null);
			if (logger.isInfoEnabled()) {
				logger.info("Update Collection process.monitoringdiagram.dirtyflag");
			}
		}
	}
	
	public void preExecuteTask(String user, TskTask obj, String action) throws Exception {
		// 업무의 상태가 taskExecutedStatusSet에 포함되었다면 실행 할수 없음
		String objStatus = CommonUtil.toDefault((String)MisUtil.taskStatusMap().get(obj.getStatus()), obj.getStatus());
		if (objStatus != null) {
			if (MisUtil.taskExecutedStatusSet().contains(objStatus))
				throw new TskException(new StringBuffer("Not executable status. taskId: ").append(obj.getObjId()).append(" status: ").append(objStatus).toString());
		}

		// 배치된 프로세스 업무가 아니면 에러
		this.checkDeploy(obj);
		
		// 아직 생성되지 않은 태스크인 경우 기본 설정
		if (obj.getObjId() == null)
			preSetTask(user, obj, IManager.LEVEL_ALL);
		
		//다음태스크가 이전에 완료되었던 태스크의 데피니션과 같다면 반려된 업무라고 판단
		//보류
		
		// 완료 상태 설정
		if (action == null || action.equalsIgnoreCase("execute")) {
			obj.setStatus(CommonUtil.toDefault((String)MisUtil.taskStatusMap().get("executed"), "executed"));
		} else if (action == null || action.equalsIgnoreCase("return")) {
			obj.setStatus(CommonUtil.toDefault((String)MisUtil.taskStatusMap().get("returned"), "returned"));
		}
	}
	private void checkDeploy(TskTask obj) throws Exception {
		if (getPrcManager() == null)
			return;
		String dId = obj.getExtendedPropertyValue("diagramId");
		String pId = obj.getExtendedPropertyValue("processId");
		if (dId == null && pId == null)
			return;
		PrcProcessCond prcCond = new PrcProcessCond();
		prcCond.setDiagramId(dId);
		prcCond.setProcessId(pId);
		long prcSize = getPrcManager().getProcessSize("tskManagerDefaultAdvisor", prcCond);
		if (prcSize > 0)
			return;
		throw new TskException(new StringBuffer("Not deployed process (diagramId: ").append(dId)
				.append(" processId:").append(pId).append(") of task(title: ").append(obj.getTitle()).append(")").toString());
	}
	public void postExecuteTask(String user, TskTask obj, String action) throws Exception {
		// 인스턴스 우선순위 업데이트
		this.updateProcessInstPriority(obj);
	}
	private void updateProcessInstPriority(TskTask obj) throws Exception {
		if (getPrcManager() == null)
			return;
		String prcInstId = obj.getProcessInstId();
		String priority = obj.getPriority();
		if (prcInstId == null || priority == null)
			return;
		PrcProcessInstCond prcInstCond = new PrcProcessInstCond();
		prcInstCond.setObjId(prcInstId);
		prcInstCond.setPriorityNotIns(new String[] {priority});
		PrcProcessInst[] prcInsts = getPrcManager().getProcessInsts("tskManagerDefaultAdvisor", prcInstCond, IManager.LEVEL_LITE);
		if (prcInsts != null && prcInsts.length != 0) {
			PrcProcessInst prcInst = prcInsts[0];
			prcInst.setPriority(priority);
			getPrcManager().setProcessInst("tskManagerDefaultAdvisor", prcInst, IManager.LEVEL_LITE);
			if (logger.isInfoEnabled()) {
				logger.info("Update Process Instance Priority - " + priority + " [Process Instance Id : " + prcInstId + " , From Task : " + obj.getObjId() + "] ");
			}
		}
	}
	protected boolean isExecutable(TskTask obj, Object data, String action, String expression) throws Exception {
		if (action.equalsIgnoreCase(expression))
			return true;
		return false;
	}
	protected Object toData(TskTask obj) throws Exception {
		return null;
	}
	protected void fillName(TskTask obj, Object data, String expression) throws Exception {
		if (obj.getName() != null)
			return;
		obj.setName(expression);
	}
	protected void fillCorrelation(TskTask obj, Object data, String expression) throws Exception {
	}
	protected void fillType (TskTask obj, Object data, String expression) throws Exception {
		if (obj.getType() != null)
			return;
		obj.setType(expression);
	}
	protected void fillProcessInstId(TskTask obj, Object data, String expression) throws Exception {
		if (obj.getProcessInstId() != null)
			return;
		obj.setProcessInstId(expression);
	}
	protected void fillTitle(TskTask obj, Object data, String expression) throws Exception {
		if (obj.getTitle() != null)
			return;
		obj.setTitle(expression);
	}
	protected void fillDescription (TskTask obj, Object data, String expression) throws Exception {
		if (obj.getDescription() != null)
			return;
		obj.setDescription(expression);
	}
	protected void fillPriority (TskTask obj, Object data, String expression) throws Exception {
		if (obj.getPriority() != null)
			return;
		obj.setPriority(expression);
	}
	protected void fillDocument (TskTask obj, Object data, String expression) throws Exception {
		if (obj.getDocument() != null)
			return;
		obj.setDocument(expression);
	}
	protected void fillAssigner (TskTask obj, Object data, String expression) throws Exception {
		if (obj.getAssigner() != null)
			return;
		obj.setAssigner(expression);
	}
	protected void fillAssignmentDate(TskTask obj, Object data, String expression) throws Exception {
		if (obj.getAssignmentDate() != null)
			return;
		obj.setAssignmentDate(new Date());
	}
	protected void fillDueDate(TskTask obj, Object data, String expression) throws Exception {
	}
	protected void fillForm (TskTask obj, Object data, String expression) throws Exception {
		if (obj.getForm() != null)
			return;
		if (expression != null) {
			obj.setForm(expression);
		} else {
			String defaultForm = MisUtil.defaultForm();
			if (defaultForm == null || defaultForm.length() == 0)
				return;
			obj.setForm(defaultForm);
		}
	}
	protected void fillDef(TskTask obj, Object data, String expression) throws Exception {
		if (obj.getDef() != null)
			return;
		obj.setDef(expression);
	}
	protected void fillExtendedProperties (TskTask obj, Object data, Property[] extProps) throws Exception {
		Property[] oldExtProps = obj.getExtendedProperties();
		obj.setExtendedProperties(Property.cloneProperties(extProps));
		if (oldExtProps == null || oldExtProps.length == 0)
			return;
		Set oldSet = new HashSet();
		MisObject misObj = new MisObject();
		misObj.setExtendedProperties(oldExtProps);
		for (int i=0; i<oldExtProps.length; i++) {
			Property oldExtProp = oldExtProps[i];
			String name = oldExtProp.getName();
			if (oldSet.contains(name))
				continue;
			oldSet.add(name);
			obj.setExtendedPropertyValues(name, misObj.getExtendedPropertyValues(name));
		}
	}
}
