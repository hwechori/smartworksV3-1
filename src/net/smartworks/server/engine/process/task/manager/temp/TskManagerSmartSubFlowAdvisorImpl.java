package net.smartworks.server.engine.process.task.manager.temp;

import net.smartworks.server.engine.common.manager.IManager;
import net.smartworks.server.engine.common.model.InstanceVariable;
import net.smartworks.server.engine.common.model.InstanceVariables;
import net.smartworks.server.engine.common.model.Property;
import net.smartworks.server.engine.common.util.CommonUtil;
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
import net.smartworks.server.engine.process.task.manager.ITskManager;
import net.smartworks.server.engine.process.task.manager.impl.TskManagerSubFlowAdvisorImpl;
import net.smartworks.server.engine.process.task.model.TskTask;
import net.smartworks.server.engine.process.task.model.TskTaskCond;
import net.smartworks.server.engine.process.task.model.TskTaskDef;

import org.springframework.util.StringUtils;

public class TskManagerSmartSubFlowAdvisorImpl extends TskManagerSubFlowAdvisorImpl {
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
	
}
