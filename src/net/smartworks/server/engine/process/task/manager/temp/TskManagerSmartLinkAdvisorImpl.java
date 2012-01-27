/*
 * $Id: TskManagerSmartLinkAdvisorImpl.java,v 1.1 2011/11/08 00:35:05 kmyu Exp $
 * created by    : admin
 * creation-date : 2008. 7. 30
 * =========================================================
 * Copyright (c) 2008 Miracom, Inc. All rights reserved.
 */
package net.smartworks.server.engine.process.task.manager.temp;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.smartworks.server.engine.common.manager.IManager;
import net.smartworks.server.engine.common.model.Property;
import net.smartworks.server.engine.common.util.CommonUtil;
import net.smartworks.server.engine.common.util.MisUtil;
import net.smartworks.server.engine.factory.SwManagerFactory;
import net.smartworks.server.engine.infowork.domain.manager.ISwdManager;
import net.smartworks.server.engine.infowork.domain.model.SwdDataField;
import net.smartworks.server.engine.infowork.domain.model.SwdRecord;
import net.smartworks.server.engine.infowork.domain.model.SwdRecordCond;
import net.smartworks.server.engine.infowork.form.manager.ISwfManager;
import net.smartworks.server.engine.infowork.form.model.SwfField;
import net.smartworks.server.engine.infowork.form.model.SwfForm;
import net.smartworks.server.engine.process.process.model.PrcProcessInst;
import net.smartworks.server.engine.process.script.manager.ISctManager;
import net.smartworks.server.engine.process.script.manager.impl.SctXPathManagerImpl;
import net.smartworks.server.engine.process.script.util.F2SUtil;
import net.smartworks.server.engine.process.task.exception.TskException;
import net.smartworks.server.engine.process.task.manager.impl.TskManagerLinkAdvisorImpl;
import net.smartworks.server.engine.process.task.model.TskTask;
import net.smartworks.server.engine.process.task.model.TskTaskCond;
import net.smartworks.server.engine.process.task.model.TskTaskDef;

import org.springframework.util.StringUtils;


public class TskManagerSmartLinkAdvisorImpl extends TskManagerLinkAdvisorImpl {
	private static Pattern pattern = Pattern.compile("\\{\\$[^$]+\\}");
	private ISctManager sctManager;
	private ISwfManager swfManager;
	private ISwdManager swdManager;
	public TskManagerSmartLinkAdvisorImpl() {
		super();
	}
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
			this.getSwdManager().preFieldMapping(exeTask.getPerformer(), form, record, context);

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
		SwdRecord rec = getSwdManager().getRecord(user, cond, null);
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
			Date now = new Date();
			obj.setExpectStartDate(now);
			obj.setRealStartDate(now);
			
			String def = obj.getDef();
			TskTaskDef taskDef = null;
			
			if (!CommonUtil.isEmpty(def))
				taskDef = getTskManager().getTaskDef("tskManagerSmartLinkAdvisor", def, null);
			expectEndDate = new Date();
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
			if (cDate.getTime() + 5000 < new Date().getTime())
				setSingleTask(user, obj);
		}
	}
	public void preExecuteTask(String user, TskTask obj, String action) throws Exception {
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
	public void postExecuteTask(String user, TskTask obj, String action) throws Exception {
		postMapping(user, obj, action);
		super.postExecuteTask(user, obj, action);
		
		String type = obj.getType();
		
		if (type == null || type.equalsIgnoreCase("route") || type.equalsIgnoreCase("and")
				|| type.equalsIgnoreCase("or") || type.equalsIgnoreCase("xor")) 
			return;
		
		if (type.equalsIgnoreCase("SINGLE")) {
			Date cDate = obj.getCreationDate();
			if (cDate.getTime() + 5000 < new Date().getTime())
				setSingleTask(user, obj);
		}
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
	public void postRemoveTask(String user, String id) throws Exception {
		super.postRemoveTask(user, id);
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.task.manager.impl.TskManagerLinkAdvisorImpl#isExecutable(com.maninsoft.task.model.TskTask, java.lang.Object, java.lang.String, java.lang.String)
	 */
	protected boolean isExecutable(TskTask context, Object data, String action, String expression) throws Exception {
		String script = parse(context, expression, getSctManager() instanceof SctXPathManagerImpl);
		return getSctManager().executeBoolean(script, data);
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.task.manager.impl.TskManagerLinkAdvisorImpl#toTaskAssigner(com.maninsoft.task.model.TskTask, java.lang.Object, java.lang.String)
	 */
	protected String toTaskAssigner(TskTask context, Object data, TskTaskDef def) throws Exception {
		String assigner = context.getAssignee();
		if (assigner != null && assigner.length() != 0)
			return assigner;
		assigner = context.getExtendedPropertyValue("previousPerformer");
		if (assigner == null)
			assigner = context.getExtendedPropertyValue("previousAssignee");
		return assigner;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.task.manager.impl.TskManagerLinkAdvisorImpl#toData(com.maninsoft.task.model.TskTask)
	 */
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

	/**
	 * 표현식에 의거하여 태스크의 도큐먼트에서 업무수행자 값을 얻는다.
	 * @param context
	 * @param data
	 * @param expression
	 * @param taskDoc
	 * @return
	 * @throws Exception
	 */
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
	/**
	 * com.maninsoft.smart.engine.runtime.base.WorklistTaskAppActivityRT.createWorkItemData() 참조
	 * @param exeTask
	 * @param def
	 * @return
	 */
	@Override
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

	public ISctManager getSctManager() {
		return sctManager;
	}
	public void setSctManager(ISctManager sctManager) {
		this.sctManager = sctManager;
	}
	public ISwfManager getSwfManager() {
		if (swfManager == null)
			swfManager = SwManagerFactory.getInstance().getSwfManager();
		return swfManager;
	}
	public void setSwfManager(ISwfManager swfManager) {
		this.swfManager = swfManager;
	}
	public ISwdManager getSwdManager() {
		if (swdManager == null)
			swdManager = SwManagerFactory.getInstance().getSwdManager();
		return swdManager;
	}
	public void setSwdManager(ISwdManager swdManager) {
		this.swdManager = swdManager;
	}
}
