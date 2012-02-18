package net.smartworks.server.engine.process.deploy.manager.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import net.smartworks.server.engine.common.collection.manager.IColManager;
import net.smartworks.server.engine.common.collection.model.ColValue;
import net.smartworks.server.engine.common.collection.model.ColValueCond;
import net.smartworks.server.engine.common.model.Property;
import net.smartworks.server.engine.common.util.CommonUtil;
import net.smartworks.server.engine.common.util.MisUtil;
import net.smartworks.server.engine.factory.SwManagerFactory;
import net.smartworks.server.engine.process.deploy.exception.DepException;
import net.smartworks.server.engine.process.deploy.manager.IDepManager;
import net.smartworks.server.engine.process.deploy.model.AcpActualParameter;
import net.smartworks.server.engine.process.deploy.model.AcpActualParameters;
import net.smartworks.server.engine.process.link.manager.ILnkManager;
import net.smartworks.server.engine.process.link.model.LnkCondition;
import net.smartworks.server.engine.process.link.model.LnkLink;
import net.smartworks.server.engine.process.link.model.LnkLinkCond;
import net.smartworks.server.engine.process.link.model.LnkObject;
import net.smartworks.server.engine.process.process.manager.IPrcManager;
import net.smartworks.server.engine.process.process.model.PrcProcess;
import net.smartworks.server.engine.process.process.model.PrcProcessCond;
import net.smartworks.server.engine.process.process.model.PrcProcessInstCond;
import net.smartworks.server.engine.process.task.manager.ITskManager;
import net.smartworks.server.engine.process.task.model.TskTaskDef;
import net.smartworks.server.engine.process.task.model.TskTaskDefCond;
import net.smartworks.server.engine.process.xpdl.util.ProcessModelHelper;
import net.smartworks.server.engine.process.xpdl.xpdl2.Activities;
import net.smartworks.server.engine.process.xpdl.xpdl2.Activity;
import net.smartworks.server.engine.process.xpdl.xpdl2.ActualParameters;
import net.smartworks.server.engine.process.xpdl.xpdl2.Condition;
import net.smartworks.server.engine.process.xpdl.xpdl2.Event;
import net.smartworks.server.engine.process.xpdl.xpdl2.ExpressionType;
import net.smartworks.server.engine.process.xpdl.xpdl2.MessageType;
import net.smartworks.server.engine.process.xpdl.xpdl2.PackageType;
import net.smartworks.server.engine.process.xpdl.xpdl2.Performer;
import net.smartworks.server.engine.process.xpdl.xpdl2.Performers;
import net.smartworks.server.engine.process.xpdl.xpdl2.ProcessType1;
import net.smartworks.server.engine.process.xpdl.xpdl2.Route;
import net.smartworks.server.engine.process.xpdl.xpdl2.SubFlow;
import net.smartworks.server.engine.process.xpdl.xpdl2.TaskService;
import net.smartworks.server.engine.process.xpdl.xpdl2.Transition;
import net.smartworks.server.engine.process.xpdl.xpdl2.Transitions;
import net.smartworks.server.engine.process.xpdl.xpdl2.WorkflowProcesses;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

import commonj.sdo.Sequence;

public class DepXpdlManagerImpl implements IDepManager {
	protected final Log logger = LogFactory.getLog(getClass());
	public DepXpdlManagerImpl() {
		super();
	}
	private ILnkManager lnkManager;
	private IColManager colManager;
	private ITskManager tskManager;
	private IPrcManager prcManager;

	public ILnkManager getLnkManager() {
		if (lnkManager == null)
			lnkManager = SwManagerFactory.getInstance().getLnkManager();
		return lnkManager;
	}
	public IColManager getColManager() {
		if (colManager == null)
			colManager = SwManagerFactory.getInstance().getColManager();
		return colManager;
	}
	public ITskManager getTskManager() {
		if (tskManager == null)
			tskManager = SwManagerFactory.getInstance().getTskManager();
		return tskManager;
	}
	public IPrcManager getPrcManager() {
		if (prcManager == null)
			prcManager = SwManagerFactory.getInstance().getPrcManager();
		return prcManager;
	}
	public void deploy(String user, String str, Property[] opts) throws DepException {
		try {
			if (logger.isInfoEnabled()) {
				logger.info("Deploy Process Start!");
			}
			PackageType pt = ProcessModelHelper.load(str);
			Properties optProps = new Properties();
			if (opts != null && opts.length != 0) {
				for (int i = 0; i < opts.length; i++) {
					Property opt = opts[i];
					optProps.put(opt.getName(), opt.getValue());
				}
			}
			String dId = pt.getId();
			String dVer = null;
			if (pt.getRedefinableHeader() != null && pt.getRedefinableHeader().getVersion() != null)
				dVer = pt.getRedefinableHeader().getVersion().getValue();
			if (dId == null || dId.length() == 0)
				return;

			// 배치해제
			undeploy(user, dId);

			// 프로세스 배치
			WorkflowProcesses prcs = pt.getWorkflowProcesses();
			deployProcesses(user, prcs, dId, dVer, str);

			if (logger.isInfoEnabled()) {
				logger.info("Deploy Process Success!");
			}
		} catch (DepException e) {
			logger.error(" Deploy Process Fail ", e);
			throw e;
		} catch (Exception e) {
			logger.error(" Deploy Process Fail ", e);
			throw new DepException(e);
		}

	}
	protected void deployProcesses(String user, WorkflowProcesses prcs, String dId, String dVer, String diagram) throws Exception {
		if (prcs == null)
			return;
		List prcList = prcs.getWorkflowProcess();
		if (prcList == null || prcList.isEmpty())
			return;
		
		for (Iterator prcItr = prcList.iterator(); prcItr.hasNext();) {
			ProcessType1 prc = (ProcessType1) prcItr.next();
			String prcId = prc.getId();
			if (prcId == null || prcId.length() == 0)
				continue;
			String objId = new StringBuffer().append(dId).append(CommonUtil.BAR).append(prcId).toString();
			String name = prc.getName();

			// 프로세스 저장
			PrcProcess proc = new PrcProcess();
			proc.setObjId(objId);
			proc.setName(name);
			proc.setDiagramId(dId);
			proc.setDiagramVersion(dVer);
			proc.setProcessId(prcId);
			proc.setDiagram(diagram);
			getPrcManager().setProcess(user, proc, null);

			if (logger.isInfoEnabled()) {
				logger.info("Deploy Process [ " + prcId + " : " + name + "_" + dVer + " ] by " + user);
			}
			
			//TODO 프로세스 전역 변수에 대한 정보를 프로세스 컬럼을 만들어 저장한다
			
			
			Activities acts = prc.getActivities();
			Transitions trans = prc.getTransitions();

			// 액티비티 배치
			Map actMap = this.deployActivities(user, acts, dId, dVer, prcId);

			// 트랜지션 배치
			deployTransitions(user, trans, dId, dVer, prcId, actMap);

		}
	}
	protected Map deployActivities(String user, Activities acts, String dId, String dVer, String prcId) throws Exception {
		if (acts == null)
			return null;
		List actList = acts.getActivity();
		if (actList == null || actList.isEmpty())
			return null;
		
		String objIdPrefix = new StringBuffer().append(dId).append(CommonUtil.BAR).append(prcId).toString();
		
		Map actMap = new HashMap();
		for (Iterator actIter = actList.iterator(); actIter.hasNext();) {
			Activity act = (Activity) actIter.next();
			String actId = act.getId();

			actMap.put(actId, act);

			TskTaskDef taskDef = new TskTaskDef();
			taskDef.setObjId(new StringBuffer(objIdPrefix).append(CommonUtil.BAR)
					.append(actId)
					.toString());
			taskDef.setName(act.getName());
			// Assignee - Assume that getPerformer().size() == 1
			List performerList = null;
			Performers performers = act.getPerformers();
			if (performers != null)
				performerList = performers.getPerformer();
			if (performerList != null && !performerList.isEmpty()) {
				String peformer = ((Performer)performerList.get(0)).getValue();
				taskDef.setAssignee(peformer);
			}

			boolean isCustomForm = false;
			if(act.getImplementation() != null && act.getImplementation().getTask() != null && act.getImplementation().getTask().getTaskApplication() != null) {
				
				Sequence attrs = act.getImplementation().getTask().getTaskApplication().getAnyAttribute();
				if (attrs != null && attrs.size() > 0) {
					for (int i=0; i<attrs.size(); i++) {
						commonj.sdo.Property attr = attrs.getProperty(i);
						String attrName = attr.getName();
						Object attrValue = attrs.getValue(i);
						if (CommonUtil.isEmpty(attrName) || attrValue == null)
							continue;
						if (attrName.equals("IsCustomForm")) {
							isCustomForm = CommonUtil.toBoolean(attrValue);
						} 
					}
				}
				//외부업무 화면 태스크일경우 업무처리시 외부로 부터 받을 변수설정을 한다 (actualparameter)
				if (isCustomForm) {
					String externalFormId = act.getImplementation().getTask().getTaskApplication().getId();
					if (!CommonUtil.isEmpty(externalFormId))
						externalFormId = "ef_" + externalFormId;
					taskDef.setForm(CommonUtil.toDefault(externalFormId, MisUtil.defaultForm()));
					
					/**
					<xpdl:ActualParameters Execution="before">
						<xpdl:ActualParameter Id="returnVal" Name="반환값" DataType="string" Mode="OUT" TargetType="expression" ValueType="value"/>
					</xpdl:ActualParameters>
					*/
					ActualParameters actualParameters = act.getImplementation().getTask().getTaskApplication().getActualParameters();
					
					List actualParamList = null;
					if (actualParameters != null) {
						List actualParameter = actualParameters.getActualParameter();
						actualParamList = new ArrayList();
						for (int i = 0; i < actualParameter.size(); i++) {
							ExpressionType et = (ExpressionType)actualParameter.get(i);
							
							Sequence ActualParamAttrs = et.getAnyAttribute();
					
							String id = null;
							String name = null;
							String dataType = null;
							String mode = null;
							String editMode = null;
							String targetType = null;
							String valueType = null;
							String expression = null;
							String fieldId = null;
							String fieldName = null;
							
							if (ActualParamAttrs != null && ActualParamAttrs.size() > 0) {
								for (int j=0; j<ActualParamAttrs.size(); j++) {
									commonj.sdo.Property attr = ActualParamAttrs.getProperty(j);
									String attrName = attr.getName();
									Object attrValue = ActualParamAttrs.getValue(j);
									if (CommonUtil.isEmpty(attrName) || attrValue == null)
										continue;
									if (attrName.equals("Id")) {
										id = (String)attrValue;
									} else if (attrName.equals("Name")) {
										name = (String)attrValue;
									} else if (attrName.equals("DataType")) {
										dataType = (String)attrValue;
									} else if (attrName.equals("Mode")) {
										mode = (String)attrValue;
									} else if (attrName.equals("EditMode")) {
										editMode = (String)attrValue;
									} else if (attrName.equals("TargetType")) {
										targetType = (String)attrValue;
									} else if (attrName.equals("ValueType")) {
										valueType = (String)attrValue;
									} else if (attrName.equals("Expression")) {
										expression = (String)attrValue;
									} else if (attrName.equals("FieldId")) {
										fieldId = (String)attrValue;
									} else if (attrName.equals("FieldName")) {
										fieldName = (String)attrValue;
									}
								}
							}
							if (id == null && name == null)
								continue;
							//if (mode.equalsIgnoreCase("IN"))
							//	continue;
							
							AcpActualParameter actActualParam = new AcpActualParameter();
							actActualParam.setId(id);
							actActualParam.setName(name);
							actActualParam.setDataType(dataType);
							actActualParam.setMode(mode);
							if(!CommonUtil.isEmpty(editMode))
								actActualParam.setEditMode(editMode);
							actActualParam.setTargetType(targetType);
							actActualParam.setValueType(valueType);
							actActualParam.setFieldId(fieldId);
							actActualParam.setFieldName(fieldName);
							actActualParam.setExpression("");//리턴변수는 외부에서 변수를 받기때문에 직접입력인Expression 으로 표시되면 안된다
							if(!CommonUtil.isEmpty(editMode))
								actActualParam.setExpression(StringUtils.replace(expression, "'", ""));
							
							actualParamList.add(actActualParam);
						}
					}
					if (actualParamList != null && actualParamList.size() != 0) {
						AcpActualParameters acpActualParameters = new AcpActualParameters();
						AcpActualParameter[] actualParamArray = new AcpActualParameter[actualParamList.size()];
						actualParamList.toArray(actualParamArray);
						acpActualParameters.setActualParameters(actualParamArray);
						taskDef.setDocument(acpActualParameters.toString());
					}
					
				} else {
					taskDef.setForm(CommonUtil.toDefault(act.getImplementation().getTask().getTaskApplication().getName(), MisUtil.defaultForm()));
				}
			}

			boolean isSubFlow = false;
			boolean isServiceTask = false;
			//서브 플로우
			if (act.getImplementation() != null && act.getImplementation().getSubFlow() != null) {
				isSubFlow = true;
				SubFlow subFlow = act.getImplementation().getSubFlow();
				
				Sequence attrs = subFlow.getAnyAttribute();
				
				String subProcessVer = null;
				String subProcessPackId = null;
				String execution = subFlow.getExecution();//SYNCHR NONSYNCHR 서브 프로세스를 진행시키고 부모는 자식이 완료될때까지 기다림 or 진행
				
				if (attrs != null && attrs.size() > 0) {
					for (int i=0; i<attrs.size(); i++) {
						commonj.sdo.Property attr = attrs.getProperty(i);
						String attrName = attr.getName();
						Object attrValue = attrs.getValue(i);
						if (CommonUtil.isEmpty(attrName) || attrValue == null)
							continue;
						if (attrName.equals("SubProcessVer")) {
							subProcessVer = (String)attrValue;
						} else if (attrName.equals("SubProcessPackId")) {
							subProcessPackId = (String)attrValue;
						}
					}
				}
				taskDef.setSubFlowTargetId(subProcessPackId);
				taskDef.setSubFlowTargetVersion(subProcessVer);
				taskDef.setSubFlowExecution(execution);

				//서브 플로우 액츄얼파라미터(AcpActualParameter)
				ActualParameters actualParameters = subFlow.getActualParameters();
				AcpActualParameter[] actualParamArray = null;
				if (actualParameters != null) {
					List actualParameter = actualParameters.getActualParameter();
					actualParamArray = new AcpActualParameter[actualParameter.size()];
					for (int i = 0; i < actualParameter.size(); i++) {
						ExpressionType et = (ExpressionType)actualParameter.get(i);
						
						Sequence ActualParamAttrs = et.getAnyAttribute();
				
						String id = null;
						String name = null;
						String dataType = null;
						String mode = null;
						String targetType = null;
						String valueType = null;
						String expression = null;
						String fieldId = null;
						String fieldName = null;
						
						if (ActualParamAttrs != null && ActualParamAttrs.size() > 0) {
							for (int j=0; j<ActualParamAttrs.size(); j++) {
								commonj.sdo.Property attr = ActualParamAttrs.getProperty(j);
								String attrName = attr.getName();
								Object attrValue = ActualParamAttrs.getValue(j);
								if (CommonUtil.isEmpty(attrName) || attrValue == null)
									continue;
								if (attrName.equals("Id")) {
									id = (String)attrValue;
								} else if (attrName.equals("Name")) {
									name = (String)attrValue;
								} else if (attrName.equals("DataType")) {
									dataType = (String)attrValue;
								} else if (attrName.equals("Mode")) {
									mode = (String)attrValue;
								} else if (attrName.equals("TargetType")) {
									targetType = (String)attrValue;
								} else if (attrName.equals("ValueType")) {
									valueType = (String)attrValue;
								} else if (attrName.equals("Expression")) {
									expression = (String)attrValue;
								} else if (attrName.equals("FieldId")) {
									fieldId = (String)attrValue;
								} else if (attrName.equals("FieldName")) {
									fieldName = (String)attrValue;
								}
							}
						}
						if (id == null && name == null)
							continue;
						AcpActualParameter actActualParam = new AcpActualParameter();
						actActualParam.setId(id);
						actActualParam.setName(name);
						actActualParam.setDataType(dataType);
						actActualParam.setMode(mode);
						actActualParam.setTargetType(targetType);
						actActualParam.setValueType(valueType);
						actActualParam.setExpression(expression);
						actActualParam.setFieldId(fieldId);
						actActualParam.setFieldName(fieldName);
						
						actualParamArray[i] = actActualParam;
					}
				}
				if (actualParamArray != null && actualParamArray.length != 0) {
					AcpActualParameters acpActualParameters = new AcpActualParameters();
					acpActualParameters.setActualParameters(actualParamArray);
					taskDef.setDocument(acpActualParameters.toString());
				}
				//엑츄얼 파라미터 끝
			}
			//서브플로우 끝
			

			//서비스 테스크
			if (act.getImplementation() != null && act.getImplementation().getTask() != null && act.getImplementation().getTask().getTaskService() != null) {
				isServiceTask = true;
				
				TaskService taskService = act.getImplementation().getTask().getTaskService();
				
				Sequence taskServiceAttrs = taskService.getAnyAttribute();
				
				String taskServiceId = null;
				String taskServiceName = null;
				
				if (taskServiceAttrs != null && taskServiceAttrs.size() > 0) {
					for (int j=0; j<taskServiceAttrs.size(); j++) {
						commonj.sdo.Property attr = taskServiceAttrs.getProperty(j);
						String attrName = attr.getName();
						Object attrValue = taskServiceAttrs.getValue(j);
						if (CommonUtil.isEmpty(attrName) || attrValue == null)
							continue;
						if (attrName.equals("Id")) {
							taskServiceId = (String)attrValue;
						} else if (attrName.equals("Name")) {
							taskServiceName = (String)attrValue;
						}
					}
				}
				taskDef.setServiceTargetId(taskServiceId);
				//엑츄얼파라미터
				//입력
				MessageType messageIn = taskService.getMessageIn();
				MessageType messageOut = taskService.getMessageOut();
				
				List AcpActualParameterList = new ArrayList();
				
				if (messageIn != null) {
					ActualParameters actualParameters = messageIn.getActualParameters();
					if (actualParameters != null) {
						List actualParameter = actualParameters.getActualParameter();
						for (int i = 0; i < actualParameter.size(); i++) {
							ExpressionType et = (ExpressionType)actualParameter.get(i);
							
							Sequence ActualParamAttrs = et.getAnyAttribute();
					
							String id = null;
							String name = null;
							String dataType = null;
							String mode = null;
							String targetType = null;
							String valueType = null;
							String expression = null;
							String fieldId = null;
							String fieldName = null;
							
							if (ActualParamAttrs != null && ActualParamAttrs.size() > 0) {
								for (int j=0; j<ActualParamAttrs.size(); j++) {
									commonj.sdo.Property attr = ActualParamAttrs.getProperty(j);
									String attrName = attr.getName();
									Object attrValue = ActualParamAttrs.getValue(j);
									if (CommonUtil.isEmpty(attrName) || attrValue == null)
										continue;
									if (attrName.equals("Id")) {
										id = (String)attrValue;
									} else if (attrName.equals("Name")) {
										name = (String)attrValue;
									} else if (attrName.equals("DataType")) {
										dataType = (String)attrValue;
									} else if (attrName.equals("Mode")) {
										mode = (String)attrValue;
									} else if (attrName.equals("TargetType")) {
										targetType = (String)attrValue;
									} else if (attrName.equals("ValueType")) {
										valueType = (String)attrValue;
									} else if (attrName.equals("Expression")) {
										expression = (String)attrValue;
									} else if (attrName.equals("FieldId")) {
										fieldId = (String)attrValue;
									} else if (attrName.equals("FieldName")) {
										fieldName = (String)attrValue;
									}
								}
							}
							if (id == null && name == null)
								continue;
							AcpActualParameter actActualParam = new AcpActualParameter();
							actActualParam.setId(id);
							actActualParam.setName(name);
							actActualParam.setDataType(dataType);
							actActualParam.setMode(mode);
							actActualParam.setTargetType(targetType);
							actActualParam.setValueType(valueType);
							actActualParam.setExpression(expression);
							actActualParam.setFieldId(fieldId);
							actActualParam.setFieldName(fieldName);
							
							AcpActualParameterList.add(actActualParam);
						}
					}
				}
				//출력
				if (messageOut != null) {
					ActualParameters actualParameters = messageOut.getActualParameters();
					if (actualParameters != null) {
						List actualParameter = actualParameters.getActualParameter();
						for (int i = 0; i < actualParameter.size(); i++) {
							ExpressionType et = (ExpressionType)actualParameter.get(i);
							
							Sequence ActualParamAttrs = et.getAnyAttribute();
					
							String id = null;
							String name = null;
							String dataType = null;
							String mode = null;
							String targetType = null;
							String valueType = null;
							String expression = null;
							String fieldId = null;
							String fieldName = null;
							
							if (ActualParamAttrs != null && ActualParamAttrs.size() > 0) {
								for (int j=0; j<ActualParamAttrs.size(); j++) {
									commonj.sdo.Property attr = ActualParamAttrs.getProperty(j);
									String attrName = attr.getName();
									Object attrValue = ActualParamAttrs.getValue(j);
									if (CommonUtil.isEmpty(attrName) || attrValue == null)
										continue;
									if (attrName.equals("Id")) {
										id = (String)attrValue;
									} else if (attrName.equals("Name")) {
										name = (String)attrValue;
									} else if (attrName.equals("DataType")) {
										dataType = (String)attrValue;
									} else if (attrName.equals("Mode")) {
										mode = (String)attrValue;
									} else if (attrName.equals("TargetType")) {
										targetType = (String)attrValue;
									} else if (attrName.equals("ValueType")) {
										valueType = (String)attrValue;
									} else if (attrName.equals("Expression")) {
										expression = (String)attrValue;
									} else if (attrName.equals("FieldId")) {
										fieldId = (String)attrValue;
									} else if (attrName.equals("FieldName")) {
										fieldName = (String)attrValue;
									}
								}
							}
							if (id == null && name == null)
								continue;
							AcpActualParameter actActualParam = new AcpActualParameter();
							actActualParam.setId(id);
							actActualParam.setName(name);
							actActualParam.setDataType(dataType);
							actActualParam.setMode(mode);
							actActualParam.setTargetType(targetType);
							actActualParam.setValueType(valueType);
							actActualParam.setExpression(expression);
							actActualParam.setFieldId(fieldId);
							actActualParam.setFieldName(fieldName);
							
							AcpActualParameterList.add(actActualParam);
						}
					}
				}	
				if (AcpActualParameterList != null && AcpActualParameterList.size() != 0) {
					AcpActualParameter[] actualParamArray = new AcpActualParameter[AcpActualParameterList.size()];
					AcpActualParameterList.toArray(actualParamArray);
					
					AcpActualParameters acpActualParameters = new AcpActualParameters();
					acpActualParameters.setActualParameters(actualParamArray);
					taskDef.setDocument(acpActualParameters.toString());
				}
			}
			//서비스 테스크끝
			
			// Extended Attributes
			int extPropSize = 4;
			if (act.isStartActivity())
				extPropSize++;
			Property[] taskDefExtProps = new Property[extPropSize];
			int extPropI = 0;
			taskDefExtProps[extPropI++] = new Property("diagramId", dId);
			taskDefExtProps[extPropI++] = new Property("diagramVersion", dVer);
			taskDefExtProps[extPropI++] = new Property("processId", prcId);
			taskDefExtProps[extPropI++] = new Property("activityId", actId);
			if (act.isStartActivity())
				taskDefExtProps[extPropI++] = new Property("startActivity", CommonUtil.TRUE);
			taskDef.setExtendedProperties(taskDefExtProps);
			if (isCustomForm)
				taskDef.addExtendedProperty(new Property("isCustomForm", CommonUtil.TRUE));
			Event event = act.getEvent();
			Route route = act.getRoute();
			if (event == null && route == null) {
				String userTaskType = "normal";
				if (isSubFlow) 
					userTaskType = "subFlow";
				if (isServiceTask)
					userTaskType = "service";
					
				boolean approvalRequired = false;
				if (act.getImplementation() != null && 
						act.getImplementation().getTask() != null && 
						act.getImplementation().getTask().getTaskApplication() != null) {
					Sequence attrs = act.getImplementation().getTask().getTaskApplication().getAnyAttribute();
					if (attrs != null && attrs.size() > 0) {
						for (int i=0; i<attrs.size(); i++) {
							commonj.sdo.Property attr = attrs.getProperty(i);
							String attrName = attr.getName();
							Object attrValue = attrs.getValue(i);
							if (CommonUtil.isEmpty(attrName) || attrValue == null)
								continue;
							if (attrName.equals("UserTaskType")) {
								if (attrValue.toString().equalsIgnoreCase("approval"))
									userTaskType = "approval";
							} else if (attrName.equals("ApprovalRequired")) {
								approvalRequired = CommonUtil.toBoolean(attrValue);
							} else if (attrName.equals("MeanTime")) {
								taskDef.setDueDate((String)attrValue);
							}
						}
					}
				}
				taskDef.setType(CommonUtil.toDefault((String) MisUtil.taskDefTypeMap().get(userTaskType), "normal"));
				if (approvalRequired)
					taskDef.setExtendedPropertyValue("approvalRequired", "true");
			} else {
				
				
				//게이트 웨이나 이벤트 타입일 경우 링크맵에다가 해당 태입일경우 실행할 Advisor를 등록하여
				//실행 타임에 mapadvisor 가 시행할 advisor를 호출하여 실행 시킨다
				//sub flow 나 service 타입일경우 와 마찬가지로 advisor를 map advisor로 실행 시킬 이유가 없다 
				//변경 예정
				
//				LnkMap map = new LnkMap();
//				map.setName(act.getName());
//				map.setType("taskadvisor");
//				
//				// from	
//				map.setFromType("taskdef");
//				map.setFromRef(new StringBuffer(objIdPrefix).append(CommonUtil.BAR)
//						.append(actId)
//						.toString());
//
//				// to
//				map.setToType("bean");
//				if (event != null) {
//					taskDef.setType("route");
//					map.setToRef("routeTaskAdvisor");
//				} else if ("XOR".equals(route.getGatewayType())) {
//					taskDef.setType("xor");
//					map.setToRef("xorTaskAdvisor");
//				} else if ("AND".equals(route.getGatewayType())) {
//					taskDef.setType("and");
//					map.setToRef("andTaskAdvisor");
//				} else if ("OR".equals(route.getGatewayType())) {
//					taskDef.setType("or");
//					map.setToRef("orTaskAdvisor");
//				}
//
//				// Extended Attributes
//				Property[] mapExtProps = new Property[4];
//				mapExtProps[0] = new Property("diagramId", dId);
//				mapExtProps[1] = new Property("diagramVersion", dVer);
//				mapExtProps[2] = new Property("processId", prcId);
//				mapExtProps[3] = new Property("activityId", actId);
//				map.setExtendedProperties(mapExtProps);
//				
//				getLnkManager().setMap(user, map);
				
				if (event != null) {
					taskDef.setType("route");
				} else if ("XOR".equals(route.getGatewayType())) {
					taskDef.setType("xor");
				} else if ("AND".equals(route.getGatewayType())) {
					taskDef.setType("and");
				} else if ("OR".equals(route.getGatewayType())) {
					taskDef.setType("or");
				}
				
			}
			
			getTskManager().setTaskDef(user, taskDef, null);
			if (logger.isInfoEnabled()) {
				logger.info("Deploy Activitys [ " + prcId + "_" + taskDef.getObjId() + "(" + taskDef.getType()+ ") : " + taskDef.getName() + "_" + taskDef.getAssignee() + " ] ");
			}
		}
		return actMap;
	}
	
	
	private void deployTransitions(String user, Transitions trans, String dId, String dVer, String prcId, Map actMap) throws Exception {
		if (trans == null)
			return;
		List tranList = trans.getTransition();
		if (tranList == null || tranList.isEmpty())
			return;
		
		String objIdPrefix = new StringBuffer().append(dId).append(CommonUtil.BAR).append(prcId).toString();
		for (Iterator tranIter = tranList.iterator(); tranIter.hasNext();) {
			Transition tran = (Transition) tranIter.next();
			
			String fromId = tran.getFrom();
			String toId = tran.getTo();
			if (fromId == null || toId == null)
				continue;
			Activity actFrom = (Activity) actMap.get(fromId);
			Activity actTo = (Activity) actMap.get(toId);
			if (actFrom == null || actTo == null)
				continue;
			
			String fromLabel = CommonUtil.substring(actFrom.getName(), 0, 10);
			String toLabel = CommonUtil.substring(actTo.getName(), 0, 10);
			
			LnkLink link = new LnkLink();
			link.setObjId(new StringBuffer(objIdPrefix).append(CommonUtil.BAR)
					.append(tran.getId())
					.toString());
			link.setType("process");
			link.setName(
					new StringBuffer("from:").append(tran.getFrom()).append(CommonUtil.UNDERBAR).append(fromLabel)
					.append(CommonUtil.SPACE).append(CommonUtil.BAR).append(CommonUtil.SPACE)
					.append("to:").append(tran.getTo()).append(CommonUtil.UNDERBAR).append(toLabel)
					.toString());

			// from
			LnkObject from = new LnkObject();
			from.setType("taskdef");
			from.setLabel(actFrom.getName());
			from.setRef(new StringBuffer(objIdPrefix).append(CommonUtil.BAR).append(tran.getFrom()).toString());
			link.setFrom(from);

			// to
			LnkObject to = new LnkObject();
			to.setType("taskdef");
			to.setLabel(actTo.getName());
			to.setRef(new StringBuffer(objIdPrefix).append(CommonUtil.BAR)
					.append(tran.getTo())
					.toString());
			link.setTo(to);

			// condition
			Condition tranCond = tran.getCondition();
			if (tranCond != null) {
				String tranCondType = tranCond.getType_();
				ExpressionType tranCondExpr =  tranCond.getExpression();
				String tranCondExprValue = null;
				if (tranCondExpr != null)
					tranCondExprValue = CommonUtil.toNull(tranCondExpr.getExprValue());
				if ((tranCondType != null && tranCondType.equalsIgnoreCase("OTHERWISE")) || tranCondExprValue != null) {
					LnkCondition condition = new LnkCondition();
					if (tranCondType != null && tranCondType.equalsIgnoreCase("OTHERWISE"))
						condition.setType("otherwise");
					if (tranCondExprValue != null)
						condition.setExpression(tranCondExprValue);
					link.setCondition(condition);
				}
			}

			// Extended Attributes
			Property[] lnkExtProps = new Property[4];
			lnkExtProps[0] = new Property("diagramId", dId);
			lnkExtProps[1] = new Property("diagramVersion", dVer);
			lnkExtProps[2] = new Property("processId", prcId);
			lnkExtProps[3] = new Property("transitionId", tran.getId());
			link.setExtendedProperties(lnkExtProps);
			
			getLnkManager().setLink(user, link, null);
			if (logger.isInfoEnabled()) {
				logger.info("Deploy Transitions [ "+ prcId + " : " + link.getName() + " ]");
			}
		}
	}
	public void undeploy(String user, String id) throws DepException {
		try {
			if(logger.isInfoEnabled()) {
				logger.info("UnDeploy Process Strat!");
			}
			// 프로세스 다이어그램 백업
			this.backupDiagram(user, id);
			
			// TaskDef
			this.undeployTaskDefs(user, id);

			// Link
			this.undeployLinks(user, id);

			// Map 삭제 예정(mapAdvisor사용안할예정)
			//this.undeployMaps(user, id);
			
			// TODO Process
			this.undeployProcesses(user, id);
			
			if(logger.isInfoEnabled()) {
				logger.info("UnDeploy Process Success!");
			}
			
		} catch (DepException e) {
			logger.error(" UnDeploy Process Fail ", e);
			throw e;
		} catch (Exception e) {
			logger.error(" UnDeploy Process Fail ", e);
			throw new DepException(e);
		}

	}
	private void backupDiagram(String user, String id) throws Exception {
		PrcProcessInstCond instCond = new PrcProcessInstCond();
		instCond.setDiagramId(id);
		long instSize = this.getPrcManager().getProcessInstSize("deployManager", instCond);
		if (instSize == 0)
			return;
		PrcProcessCond prcCond = new PrcProcessCond();
		prcCond.setDiagramId(id);
		PrcProcess[] prcs = this.getPrcManager().getProcesses("deployManager", prcCond, null);
		if (prcs == null || prcs.length == 0)
			return;
		PrcProcess prc = prcs[0];
		String name = prc.getName();
		String diagram = prc.getDiagram();
		ColValueCond dCond = new ColValueCond();
		dCond.setType("process.diagram");
		dCond.setRef(id);
		ColValue[] ds = this.getColManager().getValues("deployManager", dCond, null);
		ColValue d = null;
		if (ds != null && ds.length != 0) {
			d = ds[0];
		} else {
			d = new ColValue();
			d.setType("process.diagram");
			d.setRef(id);
		}
		d.setName(name);
		d.setValue(diagram);
		this.getColManager().setValue("deployManager", d, null);
		if (logger.isInfoEnabled()) {
			logger.info("UnDeploy Process [ Backup ProcessDiagram : DigramId - " + id + "( " + prc.getName() + " ) ]");
		}
	}
	private void undeployTaskDefs(String user, String id) throws Exception {
		TskTaskDefCond taskDefCond = new TskTaskDefCond();
		Property[] taskDefExtProps = new Property[1];
		taskDefExtProps[0] = new Property("diagramId", id);
		taskDefCond.setExtendedProperties(taskDefExtProps);
		TskTaskDef[] taskDefs = getTskManager().getTaskDefs(null, taskDefCond, null);
		if (taskDefs == null || taskDefs.length == 0)
			return;
		TskTaskDef taskDef = null;
		for (int i = 0; i < taskDefs.length; i++) {
			taskDef = taskDefs[i];
			getTskManager().removeTaskDef(user, taskDef.getObjId());
		}
		if (logger.isInfoEnabled()) {
			logger.info("UnDeploy Process [ UnDeploy TaskDefs : DigramId - " + id + ", " + taskDefs.length + " TaskDefs ]");
		}
	}
	private void undeployLinks(String user, String id) throws Exception {
		LnkLinkCond linkCond = new LnkLinkCond();
		linkCond.setType("process");
		Property[] linkExtProps = new Property[1];
		linkExtProps[0] = new Property("diagramId", id);
		linkCond.setExtendedProperties(linkExtProps);
		LnkLink[] links = getLnkManager().getLinks(user, linkCond, null);
		if (links == null || links.length == 0)
			return;
		LnkLink link = null;
		for (int i = 0; i < links.length; i++) {
			link = links[i];
			getLnkManager().removeLink(user, link.getObjId());
		}
		if (logger.isInfoEnabled()) {
			logger.info("UnDeploy Process [ UnDeploy Links : DigramId - " + id + ", " + links.length + " Links ]");
		}
	}
	private void undeployMaps(String user, String id) throws Exception {
		//배치 해제시에 mapAdvisor에서 사용하였던 route advisor 들을 삭제한다  -> 배치시에 mapAdvisor를 사용하지 않기로 했기때문에 삭제예정
//		LnkMapCond mapCond = new LnkMapCond();
//		Property[] mapExtProps = new Property[1];
//		mapExtProps[0] = new Property("diagramId", id);
//		mapCond.setExtendedProperties(mapExtProps);
//		LnkMap[] maps = getLnkManager().getMaps(user, mapCond);
//		if (maps == null || maps.length ==0)
//			return;
//		LnkMap map = null;
//		for (int i = 0; i < maps.length; i++) {
//			map = maps[i];
//			getLnkManager().removeMap(user, map.getObjId());
//		}
	}
	private void undeployProcesses(String user, String id) throws Exception {
		PrcProcessCond prcCond = new PrcProcessCond();
		prcCond.setDiagramId(id);
		PrcProcess[] prcs = getPrcManager().getProcesses(user, prcCond, null);
		if (prcs == null || prcs.length == 0)
			return;
		PrcProcess prc = null;
		for (int i=0; i<prcs.length; i++) {
			prc = prcs[i];
			getPrcManager().removeProcess(user, prc.getObjId());
		}
		if (logger.isInfoEnabled()) {
			logger.info("UnDeploy Process [ UnDeploy process : DigramId - " + id + "( " + prc.getName() + " ) ]");
		}
	}
}
