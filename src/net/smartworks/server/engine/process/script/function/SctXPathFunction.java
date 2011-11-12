package net.smartworks.server.engine.process.script.function;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import net.smartworks.server.engine.factory.SwManagerFactory;
import net.smartworks.server.engine.common.manager.IManager;
import net.smartworks.server.engine.common.model.InstanceVariable;
import net.smartworks.server.engine.common.model.InstanceVariables;
import net.smartworks.server.engine.common.model.Order;
import net.smartworks.server.engine.common.model.Property;
import net.smartworks.server.engine.common.util.CommonUtil;
import net.smartworks.server.engine.common.util.DateUtil;
import net.smartworks.server.engine.common.util.MisUtil;
import net.smartworks.server.engine.process.process.manager.IPrcManager;
import net.smartworks.server.engine.process.process.model.PrcProcessInst;
import net.smartworks.server.engine.process.process.model.PrcProcessInstCond;
import net.smartworks.server.engine.process.script.util.F2SUtil;
import net.smartworks.server.engine.process.task.manager.ITskManager;
import net.smartworks.server.engine.process.task.model.TskTask;
import net.smartworks.server.engine.process.task.model.TskTaskCond;
import net.smartworks.server.engine.infowork.domain.manager.ISwdManager;
import net.smartworks.server.engine.infowork.domain.model.SwdDataField;
import net.smartworks.server.engine.infowork.domain.model.SwdRecord;
import net.smartworks.server.engine.infowork.form.model.SwfFormLink;

import org.apache.commons.jxpath.ExpressionContext;
import org.apache.commons.jxpath.Function;
import org.apache.commons.jxpath.Functions;
import org.springframework.util.StringUtils;

public class SctXPathFunction implements Function, Functions {
	
	protected String prefix = "mis";
	protected String methodName;
	
	private ITskManager tskManager;
	private ISwdManager swdManager;
	private IPrcManager prcManager;

	public Function getFunction(String namespace, String name, Object[] parameters) {
		if(!prefix.equals(namespace))
			return null;
		this.methodName = name;
		return this;
	}

	public Set getUsedNamespaces() {
		return Collections.singleton(prefix);
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	public ITskManager getTskManager() {
		if (tskManager == null)
			tskManager = SwManagerFactory.getInstance().getTskManager();
		return tskManager;
	}
	public ISwdManager getSwdManager() {
		if (swdManager == null)
			swdManager = SwManagerFactory.getInstance().getSwdManager();
		return swdManager;
	}
	public IPrcManager getPrcManager() {
		if (prcManager == null)
			prcManager = SwManagerFactory.getInstance().getPrcManager();
		return prcManager;
	}

	public Object invoke(ExpressionContext context, Object[] parameters) {
		Object result = null;
		Object _context = context.getJXPathContext().getContextBean();
		if (methodName.equals("getActivityData")) {
			if (parameters.length == 3)
				try {
					result = this.getActivityData(_context,
							parameters[0].toString(),
							parameters[1].toString(),
							parameters[2].toString());
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
		} else if (methodName.equals("getData")) {
			if (parameters.length == 4)
				try {
					result = this.getData(_context, parameters[0].toString(), parameters[1].toString(), parameters[2].toString(), parameters[3].toString());
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
		} else if (methodName.equals("getProcessParam")) {
			if (parameters.length == 3)
				try {
					//param0 : isntanceId, param1 : paramType, param2 : paramName
					result = this.getPrcInstVarableData(parameters[0].toString(), "" , "", parameters[2].toString());
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
		} else if (methodName.equals("getSubParameter")) {
			if (parameters.length == 3)
				try {
					//param0 : parentIsntanceId, param1 : parentTaskActId, param2 : paramName
					String subInstanceId = getSubInstanceIdByPInstIdAndPActId(parameters[0].toString(), parameters[1].toString());
					result = this.getPrcInstVarableData(subInstanceId, "", "", parameters[2].toString());
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
		} else if (methodName.equals("getServiceParam")) {
			if (parameters.length == 3)
				try {
					//param0 : isntanceId, param1 : taskActId, param2 : paramName
					result = this.getPrcInstVarableData(parameters[0].toString(), parameters[1].toString(),  "", parameters[2].toString());
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
		} else if (methodName.equals("getCurrentUser")) {
			if (CommonUtil.isEmpty(parameters))
				try {
					result = this.getCurrentUser(_context);
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
		} else if (methodName.equals("generateId")) {
			result = CommonUtil.newId();
		} else if (methodName.equals("getCurrentDate")) {
			result = DateUtil.toXsdDateString(new Date());
		} else {
			//result = super.invoke(context, parameters); 원래는 자식에 있던 invoke였으나 부모로 합쳐짐
			throw new RuntimeException("No Method Name (SctPathFunction : deleted Super Class Function _ 20111112)");
		}

		return result;
	}
	
	public Object getData(Object context, String type, String source, String field, String func) throws Exception {
		type = CommonUtil.toNull(type);
		source = CommonUtil.toNull(source);
		field = CommonUtil.toNull(field);
		func = CommonUtil.toNull(func);
		
		if (context == null || !(context instanceof Map))
			return new Double(0);
		
		if (type == null || source == null)
			return null;
		
		if (type != null) {
			String[] array = StringUtils.tokenizeToStringArray(type, ".");
			type = array[array.length - 1];
		}
		if (source != null) {
			String[] array = StringUtils.tokenizeToStringArray(source, ".");
			source = array[array.length - 1];
		}
		if (field != null) {
			String[] array = StringUtils.tokenizeToStringArray(field, ".");
			field = array[array.length - 1];
		}
		if (func != null) {
			String[] array = StringUtils.tokenizeToStringArray(func, ".");
			func = array[array.length - 1];
			if (func.equalsIgnoreCase("value"))
				func = null;
		}

		Map ctxMap = (Map)context;
		
		if (source.equalsIgnoreCase("this") || source.endsWith(".this")) {
			if (field == null)
				return null;
			SwdRecord record = (SwdRecord)ctxMap.get("self");
			String value = record.getDataFieldValue(field);
			if (CommonUtil.isNumber(value))
				return Double.valueOf(value);
			return value;
		}
		
		SwfFormLink mappingFormObj = null;
		SwdRecord record = null;
		if (ctxMap.containsKey(source)) {
			Object obj = ctxMap.get(source);
			if (obj instanceof SwfFormLink) {
				mappingFormObj = (SwfFormLink)obj;
			} else if (obj instanceof SwdRecord) {
				record = (SwdRecord)obj;
			}
		} else if (ctxMap.containsKey("mappingFormMap")) {
			Map mfMap = (Map)ctxMap.get("mappingFormMap");
			if (!mfMap.containsKey(source))
				return null;
			mappingFormObj = (SwfFormLink)mfMap.get(source);
		} else {
			return null;
		}
		
		if (func == null) {
			if (record == null) {
				record = getSwdManager().getRecordByMappingForm((String)ctxMap.get("user"), (SwdRecord)ctxMap.get("self"), mappingFormObj);
				if (record == null)
					return null;
			}
			SwdDataField df = record.getDataField(field);
			if (df == null)
				return null;
			String value = df.getValue();
			if (CommonUtil.isNumber(value))
				return Double.valueOf(value);
			return value;
		} else {
			double value = getSwdManager().getRecordValueByMappingForm((String)ctxMap.get("user"), (SwdRecord)ctxMap.get("self"), mappingFormObj, field, func);
			return Double.valueOf(value);
		}
	}

	/**
	 * 수행된 태스크의 도큐먼트에서 지정된 dataField의 값을 얻는다.
	 * @param context
	 * @param prcInstId
	 * @param actId
	 * @param dataId
	 * @return
	 * @throws Exception
	 */
	public Object getActivityData(Object context, String prcInstId, String actId, String dataId) throws Exception {
		Map taskDocMap = null;
		if (context != null && context instanceof Map) {
			taskDocMap = (Map) context;
		} else {
			taskDocMap = new HashMap();
		}
		String taskDocStr = null;
		if (!taskDocMap.containsKey(actId)) {
			taskDocStr = getTaskDocument(prcInstId, actId);
			if (taskDocStr == null)
				return null;
			taskDocMap.put(actId, taskDocStr);
		} else {
			taskDocStr = (String) taskDocMap.get(actId);
			if (taskDocStr == null || taskDocStr.length() == 0)
				return null;
		}

		String[] values = F2SUtil.getDataFieldValues(taskDocStr, dataId);
		if (values == null)
			return null;
		if (values.length == 1)
			return values[0];
		return values;
	}
	
	public Object getPrcInstVarableData(String prcInstId, String actId, String variableType, String variableName) throws Exception {
		
		InstanceVariables variables = null;
		InstanceVariable variable = null;
		//actId가 없다면 인스턴스 variable 에서 값을 꺼내고 있다면 태스크를 찾아 그속에서 인스턴스variable 를 꺼내어 값을 취득한다
		if (CommonUtil.isEmpty(actId)) {
			PrcProcessInstCond cond = new PrcProcessInstCond();
			cond.setObjId(prcInstId);
			PrcProcessInst prcInst = getPrcManager().getProcessInst("smartXPathFunction", cond, IManager.LEVEL_ALL);
			
			if (prcInst == null || CommonUtil.isEmpty(prcInst.getInstVariable()))
				return null;
			String instVariableStr = prcInst.getInstVariable();
			variables = (InstanceVariables)InstanceVariables.toObject(instVariableStr);
			
		} else {
			TskTaskCond tskCond = new TskTaskCond();
			tskCond.setProcessInstId(prcInstId);
			tskCond.setExtendedProperties(new Property[]{new Property("activityId", actId)});
			tskCond.setOrders(new Order[]{new Order("creationDate", false)});
			TskTask[] tasks = getTskManager().getTasks("SctSmartXPathFunction", tskCond, IManager.LEVEL_ALL);
			if (tasks == null)
				return null;
			variables = (InstanceVariables)InstanceVariables.toObject(tasks[0].getInstVariable());
		}
		variable = variables.getInstanceVariableById(variableName);
		
		if (variable == null)
			return null;
		
		return variable.getVariableValue();
	}
	public String getSubInstanceIdByPInstIdAndPActId(String pInstanceId, String actId) throws Exception {
		
		TskTaskCond cond = new TskTaskCond();
		cond.setType(CommonUtil.toDefault((String)MisUtil.taskDefTypeMap().get("SUBFLOW"), "SUBFLOW"));
		cond.setProcessInstId(pInstanceId);
		cond.setExtendedProperties(new Property[]{ new Property("activityId", actId) });
		
		TskTask[] tasks = getTskManager().getTasks("smartXPathFunction", cond, IManager.LEVEL_ALL);
		
		if (tasks == null || tasks.length == 0)
			return null;

		return tasks[0].getExtendedPropertyValue("targetPrcInstId");
	}
	
	public String getCurrentUser(Object context) throws Exception {
		if (context == null || !(context instanceof Map))
			return null;
		Map contextMap = (Map)context;
		if (contextMap.containsKey("user"))
			return (String)contextMap.get("user");
		return null;
	}

	private String getTaskDocument(String prcInstId, String activityId) throws Exception {
		TskTaskCond taskCond = new TskTaskCond();
		taskCond.setProcessInstId(prcInstId);
		taskCond.setStatus(CommonUtil.toDefault((String) MisUtil.taskStatusMap().get("executed"), "executed"));
		Property[] extProps = new Property[1];
		extProps[0] = new Property("activityId", activityId);
		Order[] orders = new Order[1];
		orders[0] = new Order("executionDate", false);
		taskCond.setExtendedProperties(extProps);
		taskCond.setOrders(orders);

		TskTask[] tasks = getTskManager().getTasks("smartXPathFunction", taskCond, IManager.LEVEL_ALL);
		if (tasks == null || tasks.length == 0)
			return null;

		String taskDoc = tasks[0].getDocument();
		if (taskDoc != null && !taskDoc.trim().startsWith("<"))
			return null;
		return taskDoc;
	}
	
}
