package net.smartworks.server.engine.process.task.manager.impl;

import net.smartworks.server.engine.common.manager.IManager;
import net.smartworks.server.engine.common.util.CommonUtil;
import net.smartworks.server.engine.common.util.MisUtil;
import net.smartworks.server.engine.factory.SwManagerFactory;
import net.smartworks.server.engine.process.process.manager.IPrcManager;
import net.smartworks.server.engine.process.task.manager.AbstractTskManagerAdvisor;
import net.smartworks.server.engine.process.task.manager.ITskManager;
import net.smartworks.server.engine.process.task.model.TskTask;
import net.smartworks.server.engine.process.task.model.TskTaskDef;

public class TskManagerServiceAdvisorImpl extends AbstractTskManagerAdvisor {

	public void postExecuteTask(String user, TskTask obj, String action) throws Exception {
	}
	public void preExecuteTask(String user, TskTask obj, String action) throws Exception {
	}
	public void preSetTask(String user, TskTask obj, String level) throws Exception {
	}
	public void postSetTask(String user, TskTask obj, String level) throws Exception {
		if (!obj.getType().equalsIgnoreCase(CommonUtil.toDefault((String)MisUtil.taskDefTypeMap().get("service"), "SERVICE"))) 
			return;
//TODO webservice model 정의 필요
		
//		IPrcManager prcMgr = getPrcManager();
//		ITskManager tskMgr = getTskManager();
//		
//		String taskDefId = obj.getDef();
//		if (taskDefId == null)
//			return;
//		TskTaskDef taskDef = tskMgr.getTaskDef(user, taskDefId, IManager.LEVEL_ALL);
//		
//		WebWebService serviceObj = SwManagerFactory.getInstance().getWebManager().getWebService(user, taskDef.getServiceTargetId(), IManager.LEVEL_ALL);
//		if (serviceObj == null)
//			throw new Exception("not exist WebService Info");
//		
//		String targetEndpointAddress = serviceObj.getWsdlAddress();
//		String operation = serviceObj.getOperationName();
//		WebWebServiceParameter[] webWebServiceParameter =  serviceObj.getWebServiceParameters();
//		String returnType = null;
//		for (int i = 0; i < webWebServiceParameter.length; i++) {
//			WebWebServiceParameter wsp = webWebServiceParameter[i];
//			if (wsp.getType().equalsIgnoreCase("I"))
//				continue;
//			returnType = wsp.getParameterType();
//		}
//
//		AcpActualParameters acpAcutalParams = (AcpActualParameters) AcpActualParameters.toObject(taskDef.getDocument());
//		
//		AcpActualParameter[] acpAcutalParmsArray = acpAcutalParams.getActualParameters();
//		
//		if (acpAcutalParmsArray == null || acpAcutalParmsArray.length == 0)
//			return;
//		
//		Map inputParamMap = new LinkedHashMap();
//		InstanceVariable[] returnInstVariable = new InstanceVariable[1];
//		
//		for (int i = 0; i < acpAcutalParmsArray.length; i++) {
//			AcpActualParameter aParam = acpAcutalParmsArray[i];
//			String mode = aParam.getMode();
//			if (mode.equalsIgnoreCase("IN")) {
//				String inputId = aParam.getId();
//				String inputValue = null;
//				
//				if (aParam.getTargetType().equalsIgnoreCase("expression")) {
//					//직접입력
//					inputValue = aParam.getExpression();
//					
//				} else if (aParam.getTargetType().equalsIgnoreCase("processForm")) {
//					//프로세스 데이터
//					if (aParam.getFieldId().indexOf("$ProcessParam") > -1) {
//						
//						//$ProcessParam.INOUT.variableId
//						String[] script = StringUtils.tokenizeToStringArray(aParam.getFieldId(), ".");
//						
//						//프로세스파라미터(포멀)
//						PrcProcessInst prcInst = prcMgr.getProcessInst(user, obj.getProcessInstId(), IManager.LEVEL_LITE);
//						
//						if (prcInst.getInstVariable() == null || prcInst.getInstVariable().length() == 0)
//							continue;
//						InstanceVariables instanceVariables = (InstanceVariables)InstanceVariables.toObject(prcInst.getInstVariable());
//						inputValue = instanceVariables.getInstanceVariableById(script[2]).getVariableValue();
//						
//					} else if (aParam.getFieldId().indexOf("$ServiceParam") > -1) {
//						//서비스태스크
//						//$ServiceParameter.8.INOUT.variableId
//						String[] script = StringUtils.tokenizeToStringArray(aParam.getFieldId(), ".");
//						
//						TskTaskCond cond = new TskTaskCond();
//						cond.setProcessInstId(obj.getProcessInstId());
//						cond.setType("SERVICE");
//						cond.setExtendedProperties(new Property[] {new Property("activityId", script[1])});
//						
//						TskTask[] tsk = tskMgr.getTasks(user, cond, IManager.LEVEL_LITE);
//						if (tsk == null)
//							continue;
//						if (tsk[0].getInstVariable() == null || tsk[0].getInstVariable().length() == 0)
//							continue;
//						InstanceVariables instanceVariables = (InstanceVariables)InstanceVariables.toObject(tsk[0].getInstVariable());
//						inputValue = instanceVariables.getInstanceVariableById(script[3]).getVariableValue();
//						
//					} else if (aParam.getFieldId().indexOf("$SubParameter") > -1) {
//						//서브태스크
//						//$SubParameter.8.INOUT.variableId
//						String[] script = StringUtils.tokenizeToStringArray(aParam.getFieldId(), ".");
//						
//						TskTaskCond cond = new TskTaskCond();
//						cond.setProcessInstId(obj.getProcessInstId());
//						cond.setType("SUBFLOW");
//						cond.setExtendedProperties(new Property[] {new Property("activityId", script[1])});
//						
//						TskTask[] tsk = tskMgr.getTasks(user, cond, IManager.LEVEL_LITE);
//						if (tsk == null)
//							continue;
//						if (tsk[0].getInstVariable() == null || tsk[0].getInstVariable().length() == 0)
//							continue;
//						InstanceVariables instanceVariables = (InstanceVariables)InstanceVariables.toObject(tsk[0].getInstVariable());
//						inputValue = instanceVariables.getInstanceVariableById(script[3]).getVariableValue();
//						
//					} else if (aParam.getFieldId().indexOf("$ActivityData") > -1) {
//						//업무폼
//						//$ActivityData.34.0.a
//						String[] script = StringUtils.tokenizeToStringArray(aParam.getFieldId(), ".");
//
//						TskTaskCond cond = new TskTaskCond();
//						cond.setProcessInstId(obj.getProcessInstId());
//						cond.setExtendedProperties(new Property[] {new Property("activityId", script[1])});
//						TskTask[] tsk = tskMgr.getTasks(user, cond, IManager.LEVEL_LITE);
//						if (tsk == null)
//							continue;
//						if (tsk[0].getDocument() == null || tsk[0].getDocument().length() == 0)
//							continue;
//						
//						SwdRecord rec = (SwdRecord)SwdRecord.toObject(tsk[0].getDocument());
//						SwdDataField dField = rec.getDataField(script[2]);
//						String value = null;
//						//TODO 지저분한 소스 사용자일경우 이름이 아닌 아이디를 가져오도록 한다.....변경 필요
//						if (dField.getRefForm() != null) {
//							if (dField.getRefForm().equalsIgnoreCase("frm_user_SYSTEM")) {
//								inputValue = dField.getRefRecordId();
//							} else {
//								inputValue = dField.getValue();
//							}
//						}	
//					}
//				}
//				inputParamMap.put(inputId, inputValue);
//				
//			} else if (mode.equalsIgnoreCase("OUT")) {
//				//TODO 리턴값이 단일 String 일 경우만 처리됨~ String[] 에 대해서도 처리가능하게끔 변경되어야 함
//				InstanceVariable returnInstVariableObj = new InstanceVariable();
//				
//				returnInstVariableObj.setVariableName(aParam.getName());
//				returnInstVariableObj.setId(aParam.getId());
//				returnInstVariableObj.setVariableMode(aParam.getMode());
//				returnInstVariableObj.setVariableType(aParam.getValueType());
//				
//				returnInstVariable[0] = returnInstVariableObj;
//				
//			}
//		}
//		
//		Set keySet = inputParamMap.keySet();
//		Iterator itr = keySet.iterator();
//		String[] inputParams = new String[inputParamMap.size()];
//		int i = 0;
//		while (itr.hasNext()) {
//			inputParams[i] = CommonUtil.toNotNull((String)inputParamMap.get(itr.next()));
//			i = i + 1;
//		}
//
//		returnType = returnType == null ? "" : returnType;
//		//서비스를 호출한다
//		String[] result = WebServiceUtil.invokeWebService(targetEndpointAddress, operation, inputParams, returnType);
//		
//		//리턴받은 값을 intanceVariable에 셋팅한다.
//		InstanceVariables instVariables = new InstanceVariables();
//		
//		if (result != null) {
//			returnInstVariable[0].setVariableValue(result[0]);
//		} 
//		instVariables.setInstanceVariables(returnInstVariable);
//		obj.setInstVariable(instVariables.toString());	
//		
//		//부모의 인스턴스 instanceVariable 에도 값을 채워 넣는다
//		
//		String prcInstId = obj.getProcessInstId();
//		PrcProcessInst prcInst = getPrcManager().getProcessInst(user, prcInstId, IManager.LEVEL_ALL);
//		
//		
//		InstanceVariable[] prcInstVariable = instVariables.getInstanceVariables();
//
//		InstanceVariables pPrcInstVariables = (InstanceVariables)InstanceVariables.toObject(prcInst.getInstVariable());
//		if (pPrcInstVariables != null) {
//			InstanceVariable[] pPrcInstVariable = pPrcInstVariables.getInstanceVariables();
//			
//			Map pPrcInstVariableMap = new HashMap();
//			for (int j = 0; j < pPrcInstVariable.length; j++) {
//				pPrcInstVariableMap.put(pPrcInstVariable[j].getId(), pPrcInstVariable[j]);
//			}
//			
//			for (int k = 0; k < prcInstVariable.length; k++) {
//				if (pPrcInstVariableMap.get(prcInstVariable[k].getId()) == null) {
//					pPrcInstVariables.addInstanceVariable(prcInstVariable[k]);
//				} else {
//					InstanceVariable tempVariable = (InstanceVariable)pPrcInstVariableMap.get(prcInstVariable[k].getId());
//					tempVariable.setVariableValue(prcInstVariable[k].getVariableValue());
//				}
//				
//			}
//			
//			prcInst.setInstVariable(pPrcInstVariables.toString());
//		} else {
//			prcInst.setInstVariable(instVariables.toString());
//		}
//		getPrcManager().setProcessInst(user, prcInst, IManager.LEVEL_ALL);
//		
//		
//		
//		//호출이 정상적으로 이루어졌다면 서비스 태스크를 실행하여 다음 업무로 할당한다
//
//		tskMgr.executeTask(user, obj, "execute");
	}
}
