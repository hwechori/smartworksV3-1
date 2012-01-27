package net.smartworks.server.engine.process.task.manager.impl;

import java.util.Date;

import org.springframework.util.StringUtils;

import net.smartworks.server.engine.common.manager.IManager;
import net.smartworks.server.engine.common.model.InstanceVariable;
import net.smartworks.server.engine.common.model.InstanceVariables;
import net.smartworks.server.engine.common.model.Property;
import net.smartworks.server.engine.common.util.CommonUtil;
import net.smartworks.server.engine.common.util.MisUtil;
import net.smartworks.server.engine.factory.SwManagerFactory;
import net.smartworks.server.engine.infowork.domain.model.SwdDataField;
import net.smartworks.server.engine.infowork.domain.model.SwdRecord;
import net.smartworks.server.engine.infowork.form.manager.ISwfManager;
import net.smartworks.server.engine.infowork.form.model.SwfField;
import net.smartworks.server.engine.infowork.form.model.SwfForm;
import net.smartworks.server.engine.infowork.form.model.SwfMapping;
import net.smartworks.server.engine.infowork.form.model.SwfMappings;
import net.smartworks.server.engine.organization.model.SwoUser;
import net.smartworks.server.engine.process.deploy.model.AcpActualParameter;
import net.smartworks.server.engine.process.deploy.model.AcpActualParameters;
import net.smartworks.server.engine.process.process.manager.IPrcManager;
import net.smartworks.server.engine.process.process.model.PrcProcess;
import net.smartworks.server.engine.process.process.model.PrcProcessCond;
import net.smartworks.server.engine.process.process.model.PrcProcessInst;
import net.smartworks.server.engine.process.process.model.PrcProcessInstRel;
import net.smartworks.server.engine.process.process.model.PrcProcessInstRelCond;
import net.smartworks.server.engine.process.task.manager.AbstractTskManagerAdvisor;
import net.smartworks.server.engine.process.task.manager.ITskManager;
import net.smartworks.server.engine.process.task.model.TskTask;
import net.smartworks.server.engine.process.task.model.TskTaskCond;
import net.smartworks.server.engine.process.task.model.TskTaskDef;
import net.smartworks.server.engine.process.task.model.TskTaskDefCond;

public class TskManagerSubFlowAdvisorImpl extends AbstractTskManagerAdvisor {

	public void preExecuteTask(String user, TskTask obj, String action) throws Exception {
		System.out.println("SubFlowAdvisor preExecuteTask");
	}
	public void postExecuteTask(String user, TskTask obj, String action) throws Exception {
		System.out.println("SubFlowAdvisor postExecuteTask");
	}
	public void preSetTask(String user, TskTask obj, String level) throws Exception {
		if (!obj.getType().equalsIgnoreCase(CommonUtil.toDefault((String)MisUtil.taskDefTypeMap().get("subFlow"), "subFlow")))
			return;

//		String taskId = CommonUtil.newId();
//		obj.setObjId(taskId);
		
		//저장되는 서브플로우의 태스크의 인스턴스아이디가 없다면 인스턴스를 먼저 생성한다
		if (obj.getProcessInstId() == null)
			obj.setProcessInstId(CommonUtil.newId());
		
		
		//저장되는 서브플로우 태스크 데피니션을 조회 하여 서브프로세스의  아이디를 구하여 서브 프로세스를 실행한다
		String taskDefId = obj.getDef();
		if (taskDefId == null)
			return;
		TskTaskDef taskDef = getTskManager().getTaskDef(user, taskDefId, IManager.LEVEL_LITE);

		PrcProcess process = getSubProcessBySubFlowTaskDef(user, taskDef);
		
		if (process == null)
			throw new Exception("SubProcess is Null or Not Deployed!");
		
		//서브프로세스를 시작한다
		String subProcessInstId = initiateSubProcess(user, obj, taskDef, process);

		obj.addExtendedProperty(new Property("targetPrcId", process.getProcessId()));
		obj.addExtendedProperty(new Property("targetPrcInstId", subProcessInstId));
		
		//생성된 서브프로세스인스턴스와 부모프로세스인스턴스의 관계(PrcProcessInstRel)를 설정한다
		IPrcManager prcMgr = getPrcManager();
		
		String parentProcessInstId = obj.getProcessInstId();
		PrcProcessInstRelCond prcInstRelCond = new PrcProcessInstRelCond();
		prcInstRelCond.setInstanceId(subProcessInstId);
		long prcInstRelSize = prcMgr.getProcessInstRelSize(user, prcInstRelCond);
		if (prcInstRelSize > 0)
			return;
		PrcProcessInstRel prcInstRelObj = new PrcProcessInstRel();
		prcInstRelObj.setType(CommonUtil.toDefault((String)MisUtil.taskDefTypeMap().get("subFlow"), "subFlow"));
		prcInstRelObj.setPinstanceId(parentProcessInstId);
		prcInstRelObj.setInstanceId(subProcessInstId);
		prcMgr.setProcessInstRel(user, prcInstRelObj, IManager.LEVEL_ALL);
		
	}

	protected String setChildPrcInstFormalParamter(String user, TskTask tskObj, PrcProcessInst childPrcInst, TskTaskDef subTaskDef) throws Exception {
		if (childPrcInst == null || subTaskDef == null || subTaskDef.getDocument() == null)
			return null;
		if (subTaskDef.getDocument().indexOf("actualParameters") < 1)
			return null;
		AcpActualParameters actualParams = (AcpActualParameters)AcpActualParameters.toObject(subTaskDef.getDocument());
		if (actualParams == null)
			return null;

		String parentPrcInstId = tskObj.getProcessInstId();
		
		AcpActualParameter[] actualParam = actualParams.getActualParameters();
		IPrcManager prcMgr = getPrcManager();
		ITskManager tskMgr = getTskManager();
		//TODO 엑츄얼파리미터의 내용대로 값을 가져와
		InstanceVariables subInstVariablesObj = new InstanceVariables();
		
		for (int i = 0; i < actualParam.length; i++) {
			AcpActualParameter aParam = actualParam[i];
			InstanceVariable instVariable = null;
			InstanceVariable fromInstVariable = null;
			if (aParam.getTargetType().equalsIgnoreCase("expression")) {
				//직접입력
				instVariable = new InstanceVariable();
				instVariable.setInstType("process");
				instVariable.setId(aParam.getId());
				instVariable.setInstId(childPrcInst.getObjId());
				instVariable.setVariableType(aParam.getDataType());
				instVariable.setVariableName(aParam.getName());
				instVariable.setVariableMode(aParam.getMode());
				instVariable.setVariableValue(aParam.getExpression());
				
			} else if (aParam.getTargetType().equalsIgnoreCase("processForm")) {
				//프로세스 데이터
				if (aParam.getFieldId().indexOf("$ProcessParam") > -1) {
					
					//$ProcessParam.INOUT.variableId
					String[] script = StringUtils.tokenizeToStringArray(aParam.getFieldId(), ".");
					
					//프로세스파라미터(포멀)
					PrcProcessInst parentPrcInst = prcMgr.getProcessInst(user, parentPrcInstId, IManager.LEVEL_LITE);
					
					if (parentPrcInst.getInstVariable() == null || parentPrcInst.getInstVariable().length() == 0)
						continue;
					InstanceVariables instanceVariables = (InstanceVariables)InstanceVariables.toObject(parentPrcInst.getInstVariable());
					fromInstVariable = instanceVariables.getInstanceVariableById(script[2]);
					
					instVariable = new InstanceVariable();
					instVariable.setInstType("process");
					instVariable.setId(aParam.getId());
					instVariable.setInstId(childPrcInst.getObjId());
					instVariable.setVariableType(aParam.getDataType());
					instVariable.setVariableName(aParam.getName());
					instVariable.setVariableMode(aParam.getMode());
					instVariable.setVariableValue(fromInstVariable.getVariableValue());
					
				} else if (aParam.getFieldId().indexOf("$ServiceParam") > -1) {
					//서비스태스크
					//$ServiceParameter.8.INOUT.variableId
					String[] script = StringUtils.tokenizeToStringArray(aParam.getFieldId(), ".");
					
					TskTaskCond cond = new TskTaskCond();
					cond.setProcessInstId(parentPrcInstId);
					cond.setType("SERVICE");
					cond.setExtendedProperties(new Property[] {new Property("activityId", script[1])});
					
					TskTask[] tsk = tskMgr.getTasks(user, cond, IManager.LEVEL_LITE);
					if (tsk == null)
						continue;
					if (tsk[0].getInstVariable() == null || tsk[0].getInstVariable().length() == 0)
						continue;
					InstanceVariables instanceVariables = (InstanceVariables)InstanceVariables.toObject(tsk[0].getInstVariable());
					fromInstVariable = instanceVariables.getInstanceVariableById(script[3]);

					instVariable = new InstanceVariable();
					instVariable.setInstType("process");
					instVariable.setId(aParam.getId());
					instVariable.setInstId(childPrcInst.getObjId());
					instVariable.setVariableType(aParam.getDataType());
					instVariable.setVariableName(aParam.getName());
					instVariable.setVariableMode(aParam.getMode());
					instVariable.setVariableValue(fromInstVariable.getVariableValue());
					
				}  else if (aParam.getFieldId().indexOf("$SubParameter") > -1) {
					//서브태스크
					//$SubParameter.8.INOUT.variableId
					String[] script = StringUtils.tokenizeToStringArray(aParam.getFieldId(), ".");
					
					TskTaskCond cond = new TskTaskCond();
					cond.setProcessInstId(parentPrcInstId);
					cond.setType("SUBFLOW");
					cond.setExtendedProperties(new Property[] {new Property("activityId", script[1])});
					
					TskTask[] tsk = tskMgr.getTasks(user, cond, IManager.LEVEL_LITE);
					if (tsk == null)
						continue;
					if (tsk[0].getInstVariable() == null || tsk[0].getInstVariable().length() == 0)
						continue;
					InstanceVariables instanceVariables = (InstanceVariables)InstanceVariables.toObject(tsk[0].getInstVariable());
					fromInstVariable = instanceVariables.getInstanceVariableById(script[3]);
					
					instVariable = new InstanceVariable();
					instVariable.setInstType("process");
					instVariable.setId(aParam.getId());
					instVariable.setInstId(childPrcInst.getObjId());
					instVariable.setVariableType(aParam.getDataType());
					instVariable.setVariableName(aParam.getName());
					instVariable.setVariableMode(aParam.getMode());
					instVariable.setVariableValue(fromInstVariable.getVariableValue());
					
				} else if (aParam.getFieldId().indexOf("$ActivityData") > -1) {
					//업무폼
					//$ActivityData.34.0.a
					String[] script = StringUtils.tokenizeToStringArray(aParam.getFieldId(), ".");

					TskTaskCond cond = new TskTaskCond();
					cond.setProcessInstId(parentPrcInstId);
					cond.setExtendedProperties(new Property[] {new Property("activityId", script[1])});
					TskTask[] tsk = tskMgr.getTasks(user, cond, IManager.LEVEL_LITE);
					if (tsk == null)
						continue;
					if (tsk[0].getDocument() == null || tsk[0].getDocument().length() == 0)
						continue;
					
					SwdRecord rec = (SwdRecord)SwdRecord.toObject(tsk[0].getDocument());
					SwdDataField dField = rec.getDataField(script[2]);
					String value = null;
					//TODO 지저분한 소스 사용자일경우 이름이 아닌 아이디를 가져오도록 한다.....변경 필요
					if (dField.getRefForm() != null) {
						if (dField.getRefForm().equalsIgnoreCase("frm_user_SYSTEM")) {
							value = dField.getRefRecordId();
						} else {
							value = dField.getValue();
						}
					}	
					
					instVariable = new InstanceVariable();
					instVariable.setInstType("process");
					instVariable.setId(aParam.getId());
					instVariable.setInstId(childPrcInst.getObjId());
					instVariable.setVariableType(aParam.getDataType());
					instVariable.setVariableName(aParam.getName());
					instVariable.setVariableMode(aParam.getMode());
					instVariable.setVariableValue(value);
				}
			}
			subInstVariablesObj.addInstanceVariable(instVariable);
		}
		
		//TODO 프로세스 인스턴스의 instVariable 을 생성후 XML 로 변환하여 저장한다
		
		childPrcInst.setInstVariable(subInstVariablesObj.toString());
		
		prcMgr.setProcessInst(user, childPrcInst, IManager.LEVEL_LITE);
		
		return subInstVariablesObj.toString();
	}
	protected PrcProcess getSubProcessBySubFlowTaskDef(String user, TskTaskDef taskDef) throws Exception {
		if (taskDef == null)
			return null;
		String packageId = taskDef.getSubFlowTargetId();
		PrcProcessCond cond = new PrcProcessCond();
		cond.setDiagramId(packageId);
		PrcProcess[] process = getPrcManager().getProcesses(user, cond, IManager.LEVEL_ALL);
		if (process == null || process.length == 0) {
			return null;
		} else if (process.length > 1) {
			throw new Exception("SubProcess More Then 1");
		} else {
			return process[0];
		}
	}

	private String getProcessName(String dId, String dVer, String pId) throws Exception {
		if (dId == null && pId == null)
			return null;
		PrcProcessCond prcCond = new PrcProcessCond();
		prcCond.setDiagramId(dId);
		prcCond.setDiagramVersion(dVer);
		prcCond.setProcessId(pId);
		PrcProcess[] prcs = getPrcManager().getProcesses("tskManagerDefaultAdvisor", prcCond, null);
		if (prcs == null || prcs.length == 0)
			return null;
		PrcProcess prc = prcs[0];
		return prc.getName();
	}
	protected String initiateSubProcess(String user, TskTask subTask, TskTaskDef subTaskDef, PrcProcess subProcess) throws Exception {
		//서브 프로세스 인스턴스를 생성한다
		
		String title = subTask.getTitle();
		//String priority = obj.getPriority();
		String dId = subProcess.getDiagramId();
		String pId = subProcess.getProcessId();
		String dVer = subProcess.getDiagramVersion();
		
		String parentPrcInstId = subTask.getProcessInstId();
		String parentTskDefId = subTaskDef.getObjId();
		String pName = this.getProcessName(dId, dVer, pId);
		
		PrcProcessInst prcInst = new PrcProcessInst();
		String prcInstId = CommonUtil.newId();
		prcInst.setObjId(prcInstId);
		prcInst.setStatus(CommonUtil.toDefault((String)MisUtil.processInstStatusMap().get("started"), "started"));
		prcInst.setTitle(title);
		
		//prcInst.setPriority(priority);
		prcInst.setDiagramId(dId);
		prcInst.setDiagramVersion(dVer);
		prcInst.setProcessId(pId);
		prcInst.setName(pName);
		if (!CommonUtil.isEmpty(parentPrcInstId)) {
			prcInst.setIsSubInstance("TRUE");
			prcInst.setExtendedPropertyValue("parentPrcInstId", parentPrcInstId);
			prcInst.setExtendedPropertyValue("parentTskDefId", parentTskDefId);
		}	
		getPrcManager().setProcessInst(user, prcInst, null);
		
		String tskInstVariables = setChildPrcInstFormalParamter(user, subTask, prcInst, subTaskDef);
		subTask.setInstVariable(tskInstVariables);
		
		//서브프로세스 시작 업무를 조회 하여 시작한다.
		
		TskTaskDef startTaskDef = getStartTaskDef(user, subProcess.getProcessId());
		if (startTaskDef == null)
			throw new Exception("initiate subprocess failed : not exist startActivity");
		
		TskTask task = new TskTask();

		task.setProcessInstId(prcInstId);
		task.setType(startTaskDef.getType());
		task.setTitle(title);
		task.setStatus(CommonUtil.toDefault((String)MisUtil.taskStatusMap().get("started"), "started"));
		//task.setPriority("priority");
		if (subTask.getExtendedAttributeValue("workItemData") != null) {
			if (task.getType().equalsIgnoreCase("SUBFLOW")) {
				task.setExtendedAttributeValue("workItemData", subTask.getExtendedAttributeValue("workItemData"));
			} else {
				task.setDocument(subTask.getExtendedAttributeValue("workItemData"));
			}
		} else {
			task.setDocument(this.toDocumentByInstVariable(user, startTaskDef, tskInstVariables));
		}
		task.setAssigner("parentProcess");
		if (!task.getType().equalsIgnoreCase("SUBFLOW"))
			task.setAssignee(this.toAssignee(user, startTaskDef, task.getDocument()));
		task.setForm(startTaskDef.getForm());
		task.setDef(startTaskDef.getObjId());
		
		task.setExtendedPropertyValue("processInstCreationUser", user);
		task.setExtendedPropertyValue("parentPrcInstId", parentPrcInstId);
		task.setExtendedPropertyValue("parentTskDefId", subTaskDef.getObjId());
		
		Date now = new Date();
		task.setExpectStartDate(now);
		task.setRealStartDate(now);
		Date expectEndDate = new Date();
		if (startTaskDef != null &&  !CommonUtil.isEmpty(startTaskDef.getDueDate())) {
			//dueDate 는 분단위로 설정이 되어 있다
			expectEndDate.setTime(now.getTime() + ((Long.parseLong(startTaskDef.getDueDate())) * 60 * 1000));
		} else {
			expectEndDate.setTime(now.getTime() + 1800000);
		}
		task.setExpectEndDate(expectEndDate);
		if (subTask.getExtendedAttributeValue("workItemData") != null && task.getType().equalsIgnoreCase("COMMON")) {
			getTskManager().executeTask(user, task, "execute");
		} else {
			task = getTskManager().setTask(user, task, IManager.LEVEL_ALL);
		}
		if (logger.isInfoEnabled()) {
			logger.info("Initiate Sub Process Instance [ " + title + " " + prcInstId + ", Parent Process InstanceId : " + parentPrcInstId + " ]");
		}
		return task.getProcessInstId();
	}

	protected String toDocumentByInstVariable(String user, TskTaskDef taskDef, String instVariables) throws Exception {
		
		String formId = taskDef.getForm();
		if (formId == null || formId.equalsIgnoreCase("SYSTEMFORM"))
			return null;
		
		ISwfManager swfMgr = SwManagerFactory.getInstance().getSwfManager();
		SwfForm form = swfMgr.getForm(user, formId);
		
		SwfField[] fields = form.getFields();
		
		SwdDataField[] dataFields = new SwdDataField[fields.length];
		for (int i = 0; i < fields.length; i++) {
			SwfField swField = fields[i];
			SwfMappings mappings = swField.getMappings();
			
			SwdDataField dataField = new SwdDataField();
			dataField.setId(swField.getId());
			dataField.setName(swField.getName());
			dataField.setType(swField.getFormat().getType());
			if (mappings != null) {
				SwfMapping[] preMappings =  mappings.getPreMappings();
				if (preMappings != null) {
					for (int j = 0; j < preMappings.length; j++) {
						SwfMapping preMapping = preMappings[j];
						String mappingFormId = preMapping.getMappingFormId();
						if (mappingFormId == null || !mappingFormId.equalsIgnoreCase("processParam"))
							continue;
						if (CommonUtil.isEmpty(instVariables))
							continue;
						InstanceVariables instVaris = (InstanceVariables)InstanceVariables.toObject(instVariables);
						InstanceVariable instVari = instVaris.getInstanceVariableById(preMapping.getFieldId());
						if (instVari != null && !CommonUtil.isEmpty(instVari.getVariableValue())) {
							if (swField.getFormat().getType().equalsIgnoreCase("userField")) {
								dataField.setRefRecordId(instVari.getVariableValue());
								dataField.setRefForm("frm_user_SYSTEM");
								dataField.setRefFormField("4");
								SwoUser userObj = SwManagerFactory.getInstance().getSwoManager().getUser(user, instVari.getVariableValue(), IManager.LEVEL_LITE);
								if (userObj != null) {
									dataField.setValue(userObj.getPosition() + " " + userObj.getName());
									continue;
								} else {
									dataField.setValue(instVari.getVariableValue());
									continue;
								}
							} 
							dataField.setValue(instVari.getVariableValue());
						}
					}
				}	
			}
			dataFields[i] = dataField;
		}
		SwdRecord record = new SwdRecord();
		record.setFormId(formId);
		record.setFormVersion(1);
		record.setDataFields(dataFields);
		
		return StringUtils.replace(record.toString(), "<?xml version=\"1.0\" encoding=\"UTF-8\"?>", "");
	}
	protected String toAssignee(String user, TskTaskDef taskDef, String taskDocument) throws Exception {
		
		String assigneeId = taskDef.getAssignee();
		if (assigneeId == null)
			return null;
		//assigneeId 의 길이가 4자 이하이면 필드 아이디로 간주한다
		if (assigneeId.length() > 4)
			return assigneeId;
		SwdRecord rec = (SwdRecord)SwdRecord.toObject(taskDocument);
		
		SwdDataField sdf = rec.getDataField(assigneeId);
		String refFormType = sdf.getRefForm();
		if (refFormType != null && refFormType.equalsIgnoreCase("frm_user_SYSTEM")) {
			return sdf.getRefRecordId();
		} else {	
			return rec.getDataFieldValue(assigneeId);
		}
	}
	
	private TskTaskDef getStartTaskDef(String user, String processId) throws Exception {
		Property[] extProps = new Property[] {new Property("processId", processId), new Property("startActivity", "true")};
		TskTaskDefCond taskCond = new TskTaskDefCond();
		taskCond.setExtendedProperties(extProps);
		TskTaskDef[] taskDefs = getTskManager().getTaskDefs(user, taskCond, IManager.LEVEL_ALL);
		if (CommonUtil.isEmpty(taskDefs))
			throw new Exception(new StringBuffer("No start activity. -> processId:").append(processId).toString());
		//TskTaskDef taskDef = taskDefs[0];
		//taskDef.setExtendedPropertyValue("startActivity", "true");
		return taskDefs[0];
	}
	
	public void postSetTask(String user, TskTask obj, String level) throws Exception {

		if (!obj.getType().equalsIgnoreCase(CommonUtil.toDefault((String)MisUtil.taskDefTypeMap().get("subFlow"), "subFlow"))) 
			return;

		String taskDefId = obj.getDef();
		if (taskDefId == null)
			return;
		TskTaskDef taskDef = getTskManager().getTaskDef(user, taskDefId, IManager.LEVEL_ALL);
		
		String syncMode = taskDef.getSubFlowExecution();
		//서브플로우 설정이 싱크가 아니면 다음 단계로 넘어간다
		if (!syncMode.equalsIgnoreCase("SYNCHR"))
			getTskManager().executeTask(user, obj, "execute");
	}
}
