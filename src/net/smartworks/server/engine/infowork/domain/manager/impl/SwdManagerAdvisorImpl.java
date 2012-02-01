package net.smartworks.server.engine.infowork.domain.manager.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import net.smartworks.server.engine.common.manager.IManager;
import net.smartworks.server.engine.common.model.Order;
import net.smartworks.server.engine.common.model.Property;
import net.smartworks.server.engine.common.util.CommonUtil;
import net.smartworks.server.engine.common.util.DateUtil;
import net.smartworks.server.engine.common.util.MisUtil;
import net.smartworks.server.engine.factory.SwManagerFactory;
import net.smartworks.server.engine.infowork.domain.manager.AbstractSwdManagerAdvisor;
import net.smartworks.server.engine.infowork.domain.manager.ISwdManager;
import net.smartworks.server.engine.infowork.domain.model.SwdDataField;
import net.smartworks.server.engine.infowork.domain.model.SwdDataRef;
import net.smartworks.server.engine.infowork.domain.model.SwdDataRefCond;
import net.smartworks.server.engine.infowork.domain.model.SwdDomain;
import net.smartworks.server.engine.infowork.domain.model.SwdDomainCond;
import net.smartworks.server.engine.infowork.domain.model.SwdField;
import net.smartworks.server.engine.infowork.domain.model.SwdRecord;
import net.smartworks.server.engine.infowork.domain.model.SwdRecordCond;
import net.smartworks.server.engine.infowork.form.manager.ISwfManager;
import net.smartworks.server.engine.infowork.form.model.SwfField;
import net.smartworks.server.engine.infowork.form.model.SwfForm;
import net.smartworks.server.engine.infowork.form.model.SwfMapping;
import net.smartworks.server.engine.infowork.form.model.SwfMappings;
import net.smartworks.server.engine.process.process.manager.IPrcManager;
import net.smartworks.server.engine.process.task.manager.ITskManager;
import net.smartworks.server.engine.process.task.model.TskTask;
import net.smartworks.server.engine.process.task.model.TskTaskCond;
import net.smartworks.util.LocalDate;

public class SwdManagerAdvisorImpl extends AbstractSwdManagerAdvisor {
	public SwdManagerAdvisorImpl() {
		super();
	}

	private ISwfManager swfManager;
	private ISwdManager swdManager;
	private ITskManager tskManager;
	private IPrcManager prcManager;

	public IPrcManager getPrcManager() {
		if (prcManager == null)
			prcManager = SwManagerFactory.getInstance().getPrcManager();
		return prcManager;
	}
	public ITskManager getTskManager() {
		if (tskManager == null)
			tskManager = SwManagerFactory.getInstance().getTskManager();
		return tskManager;
	}
	public ISwfManager getSwfManager() {
		if (swfManager == null)
			swfManager = SwManagerFactory.getInstance().getSwfManager();
		return swfManager;
	}
	public ISwdManager getSwdManager() {
		if (swdManager == null)
			swdManager = SwManagerFactory.getInstance().getSwdManager();
		return swdManager;
	}
	public void postGetRecord(String user, String domainId, String recordId, String level, SwdRecord res) throws Exception {
		populateRecord(user, res);
	}
	public void postGetRecord(String user, SwdRecordCond cond, String level, SwdRecord res) throws Exception {
		populateRecord(user, res);
	}
	public void postGetRecords(String user, SwdRecordCond cond, String level, SwdRecord[] res) throws Exception {
		if(level == null || level == IManager.LEVEL_ALL) {
			for(SwdRecord swdRecord: res) {
				populateRecord(user, swdRecord);
			}
		}
	}
	private void populateRecord(String user, SwdRecord obj) throws Exception {
		if (obj == null)
			return;
		
		String formId = obj.getFormId();
		String recordId = obj.getRecordId();
		if (recordId == null)
			return;
		
		SwdDataRefCond cond = new SwdDataRefCond();
		cond.setMyFormId(formId);
		cond.setMyRecordId(recordId);
		SwdDataRef[] dataRefs = this.getSwdManager().getDataRefs(user, cond, null);
		if (CommonUtil.isEmpty(dataRefs))
			return;
		
		String fieldId;
		SwdDataField dataField;
		for (SwdDataRef dataRef : dataRefs) {
			fieldId = dataRef.getMyFormFieldId();
			dataField = obj.getDataField(fieldId);
			if (dataField == null)
				continue;
			dataField.setRefForm(dataRef.getRefFormId());
			dataField.setRefFormField(dataRef.getRefFormFieldId());
			dataField.setRefRecordId(dataRef.getRefRecordId());
		}
	}
	public void preSetRecord(String user, SwdRecord obj, String level) throws Exception {
		//date to localdate - Date date = new Date();
		LocalDate date = new LocalDate();
		String cUser = obj.getCreationUser();
		Date cDate = obj.getCreationDate();
		if (cUser == null || cDate == null) {
			obj.setCreationUser(user);
			obj.setCreationDate(date);
		}
		obj.setModificationUser(user);
		obj.setModificationDate(date);
	}
	public void postSetRecord(String user, SwdRecord obj, String level) throws Exception {
		// 도메인 조회
		String formId = obj.getFormId();
		String domainId = null;
		String recordId = null;
		String name = null;
		String title = null;
		if ("DEFAULTFORM".equalsIgnoreCase(formId)) {
			
		} else {
			domainId = obj.getDomainId();
			SwdDomain domain = null;
			if (CommonUtil.isEmpty(formId)) {
				if (CommonUtil.isEmpty(domainId))
					return;
				domain = getSwdManager().getDomain(user, domainId, null);
				formId = domain.getFormId();
				obj.setFormId(formId);
			} else {
				SwdDomainCond domainCond = new SwdDomainCond();
				domainCond.setFormId(formId);
				domain = getSwdManager().getDomain(user, domainCond, null);
				domainId = domain.getObjId();
				obj.setDomainId(domainId);
			}
			if (domain == null)
				return;
			
			SwdField[] fields = domain.getFields();
			if (CommonUtil.isEmpty(fields))
				return;
			
			// 데이터 참조 삭제
			recordId = obj.getRecordId();
			this.removeDataRefsByRecordId(user, domain.getFormId(), recordId);
			
			String dataFieldId;
			SwdDataField dataField;
			int refFormFieldPathIndex;
			String refFormId;
			String refFormFieldId;
			String refRecordId;
			SwdDataRef dataRef;
			for (SwdField field : fields) {
				dataFieldId = field.getFormFieldId();
				dataField = obj.getDataField(dataFieldId);
				if (dataField == null)
					continue;
				String refFormFieldPath = field.getFormFieldPath();
				if (CommonUtil.isEmpty(refFormFieldPath)) {
					refFormId = dataField.getRefForm();
					refFormFieldId = dataField.getRefFormField();
					refRecordId = dataField.getRefRecordId();
					if (CommonUtil.isEmpty(refFormId) || CommonUtil.isEmpty(refFormFieldId) || CommonUtil.isEmpty(refRecordId))
						continue;
					dataRef = this.newDataRef(obj.getRecordId(), domain.getFormId(), dataFieldId, refRecordId, refFormId, refFormFieldId);
					getSwdManager().setDataRef(user, dataRef, null);
				} else {
					refFormFieldPathIndex = refFormFieldPath.indexOf(".");
					if (refFormFieldPathIndex == -1)
						continue;
					refFormId = refFormFieldPath.substring(0, refFormFieldPathIndex);
					refFormFieldId = refFormFieldPath.substring(refFormFieldPathIndex + 1);
					refRecordId = dataField.getRefRecordId();
					if (CommonUtil.isEmpty(refRecordId))
						continue;
					dataRef = this.newDataRef(obj.getRecordId(), domain.getFormId(), dataFieldId, refRecordId, refFormId, refFormFieldId);
					getSwdManager().setDataRef(user, dataRef, null);
				}
			}
			
			// 이후 데이터 매핑
			postFieldMapping(user, domain, obj);

			name = domain.getFormName();
			String titleFieldId = domain.getTitleFieldId();
			if (!CommonUtil.isEmpty(titleFieldId))
				title = obj.getDataFieldValue(titleFieldId);
		}
		
		// 결재자 / 수신자 / 참조자
		
		//superTask관련 내용이 없다...삭제예정
		String superTaskId = obj.getExtendedAttributeValue("superTaskId");
		String superForm = obj.getExtendedAttributeValue("superForm");
		String superRecordId = obj.getExtendedAttributeValue("superRecordId");
		String approvalLine = obj.getExtendedAttributeValue("approvalLine");
		//METADATA
		//제목
		String subject = obj.getExtendedAttributeValue("subject");//기본 제목

		//참조, 기본 업무 설명
		String workContents = obj.getExtendedAttributeValue("workContents");
		//전달자의견, 전자결재 내용		
		String m_Description = obj.getExtendedAttributeValue("receiptDescription");
		
		//프로젝트 팀명(ID?)
		String projectName = obj.getExtendedAttributeValue("projectName");

		//공개여부
		String isPublic = obj.getExtendedAttributeValue("isPublic");

		//중요도
		String priority = obj.getExtendedAttributeValue("priority");

		//수신자 업무
		String receiptForm = obj.getExtendedAttributeValue("receiptForm");
		
		//수신자
		String receiptUser = obj.getExtendedAttributeValue("receiptUser");

		//참조자
		String referenceUser = obj.getExtendedAttributeValue("referenceUser");

		//희망완료날짜
		String hopeEndDate = obj.getExtendedAttributeValue("hopeEndDate");

		//METADATA END

		String work_Title = obj.getExtendedAttributeValue("title");//업무 제목
		
		String fileGroupId = obj.getExtendedAttributeValue("fileGroupId");

		String startTimeStr = obj.getExtendedAttributeValue("startDate");
		String endTimeStr = obj.getExtendedAttributeValue("endDate");
		
//				if (!CommonUtil.isEmpty(superTaskId))
//					obj.setExtendedAttributeValue("superTaskId", null);
//				if (!CommonUtil.isEmpty(superForm))
//					obj.setExtendedAttributeValue("superForm", null);
//				if (!CommonUtil.isEmpty(superRecordId))
//					obj.setExtendedAttributeValue("superRecordId", null);
		if (!CommonUtil.isEmpty(approvalLine))
			obj.setExtendedAttributeValue("approvalLine", null);
		if (!CommonUtil.isEmpty(subject))
			obj.setExtendedAttributeValue("subject", null);
		if (!CommonUtil.isEmpty(workContents))
			obj.setExtendedAttributeValue("workContents", null);
		if (!CommonUtil.isEmpty(m_Description))
			obj.setExtendedAttributeValue("receiptDescription", null);
		if (!CommonUtil.isEmpty(projectName))
			obj.setExtendedAttributeValue("projectName", null);
		if (!CommonUtil.isEmpty(isPublic))
			obj.setExtendedAttributeValue("isPublic", null);
		if (!CommonUtil.isEmpty(priority))
			obj.setExtendedAttributeValue("priority", null);
		if (!CommonUtil.isEmpty(receiptForm))
			obj.setExtendedAttributeValue("receiptForm", null);
		if (!CommonUtil.isEmpty(receiptUser))
			obj.setExtendedAttributeValue("receiptUser", null);
		if (!CommonUtil.isEmpty(referenceUser))
			obj.setExtendedAttributeValue("referenceUser", null);
		if (!CommonUtil.isEmpty(hopeEndDate))
			obj.setExtendedAttributeValue("hopeEndDate", null);
		if (!CommonUtil.isEmpty(fileGroupId))
			obj.setExtendedAttributeValue("fileGroupId", null);
		if (!CommonUtil.isEmpty(startTimeStr))
			obj.setExtendedAttributeValue("startDate", null);
		if (!CommonUtil.isEmpty(endTimeStr))
			obj.setExtendedAttributeValue("endDate", null);
		
//				superTaskId = CommonUtil.toNull(superTaskId);
//				superForm = CommonUtil.toNull(superForm);
//				superRecordId = CommonUtil.toNull(superRecordId);
		approvalLine = CommonUtil.toNull(approvalLine);
		receiptUser = CommonUtil.toNull(receiptUser);
		referenceUser = CommonUtil.toNull(referenceUser);
		subject = CommonUtil.toNull(subject);
		workContents = CommonUtil.toNull(workContents);
		
		m_Description = CommonUtil.toNull(m_Description);
		projectName = CommonUtil.toNull(projectName);
		isPublic = CommonUtil.toNull(isPublic);
		priority = CommonUtil.toNull(priority);
		receiptForm = CommonUtil.toNull(receiptForm);
		receiptUser = CommonUtil.toNull(receiptUser);
		referenceUser = CommonUtil.toNull(referenceUser);
		hopeEndDate = CommonUtil.toNull(hopeEndDate);
		Date startDate = DateUtil.toDate(CommonUtil.toNull(startTimeStr), "yyyy-MM-dd HH:mm:ss");
		Date endDate = DateUtil.toDate(CommonUtil.toNull(endTimeStr), "yyyy-MM-dd HH:mm:ss");
		fileGroupId = CommonUtil.toNull(fileGroupId);
		
//				if (superTaskId != null || superForm != null || approvalLine != null || receiptUser != null || referenceUser != null) {
		
		if (CommonUtil.isEmpty(obj.getExtendedAttributeValue("setMode")) || !obj.getExtendedAttributeValue("setMode").equals("process")) {
			
			//정보관리 업무를 저장할때 정보관리업무에 대한 태스크를 생성한다 
			//정보관리 업무를 수정할때 처음 정보관리 업무를 만들때 생성된 태스크를 조회 하여 clon하여 태스크를 생성한다.
			//기존에 만들어진 태스크에 초기 메타 데이터가 저장 되어 있기 때문이다
			TskTaskCond cond = new TskTaskCond();
			cond.setExtendedProperties(new Property[] {new Property("recordId", obj.getRecordId())});
			cond.setOrders(new Order[] {new Order("creationDate", false)});
			
			TskTask[] tasks = getTskManager().getTasks(user, cond, IManager.LEVEL_ALL);
			TskTask task = null;
			
			if (tasks != null && tasks.length != 0) {
				task = (TskTask)tasks[0].clone();
				
				task.setObjId(null);
				task.setStatus(null);
				task.setCreationDate(null);
				task.setModificationDate(null);
				task.setCreationUser(user);
				task.setExecutionDate(null);
				task.setDocument(obj.toString(null, null));
				task.setAssigner(user);
				task.setAssignee(user);
				task.setAssignmentDate(new Date());
				if (approvalLine != null) {
					task.setExtendedPropertyValue("approvalLine", approvalLine);
				} else {
					task.setExtendedPropertyValue("approvalLine", null);
				}
				//MEATADATA
				if (receiptUser != null) {
					task.setExtendedPropertyValue("receiptUser", receiptUser);
					task.setExtendedPropertyValue("receiptType", "SINGLE");
					
					if (receiptForm == null || receiptForm.equalsIgnoreCase(formId)) {
		//				task.setExtendedPropertyValue("receiptForm", formId);
						task.setExtendedPropertyValue("receiptForm", receiptForm);
						task.setExtendedPropertyValue("receiptName", name);
					} else {
						task.setExtendedPropertyValue("receiptForm", receiptForm);
						SwfForm receiptFormObj = getSwfManager().getForm(user, receiptForm);
						String receiptName = null;
						if (receiptFormObj == null) {
							receiptName = name;
						} else {
							receiptName = receiptFormObj.getName();
						}
						task.setExtendedPropertyValue("receiptName", receiptName);
					}
				} else {
					task.setExtendedPropertyValue("receiptUser", null);
					task.setExtendedPropertyValue("receiptType", null);
					task.setExtendedPropertyValue("receiptForm", null);
					task.setExtendedPropertyValue("receiptName", null);
				}
				if (referenceUser != null) {
					task.setExtendedPropertyValue("referenceUser", referenceUser);
				} else {
					task.setExtendedPropertyValue("referenceUser", null);
				}
				if (startDate != null) {
					task.setExpectStartDate(startDate);
					task.setRealStartDate(startDate);
				}	
				if (endDate != null) {
					task.setExpectEndDate(endDate);
					task.setRealEndDate(endDate);
				}
			} else {
				task = new TskTask();

				task.setName(name);
				task.setType("SINGLE");
				task.setPriority(priority);
				
				if (!CommonUtil.isEmpty(subject)) {
					title = subject;
				} 
				task.setExtendedPropertyValue("subject", title);
				task.setTitle(title);
				task.setDocument(obj.toString(null, null));
				task.setAssigner(user);
				task.setAssignee(user);
				task.setAssignmentDate(new Date());
				task.setForm(formId);
				task.setExtendedPropertyValue("superTaskId", superTaskId);
				task.setExtendedPropertyValue("superForm", superForm);
				task.setExtendedPropertyValue("superRecordId", superRecordId);
				task.setExtendedPropertyValue("domainId", domainId);
				task.setExtendedPropertyValue("recordId", recordId);
				if (approvalLine != null)
					task.setExtendedPropertyValue("approvalLine", approvalLine);
				if (work_Title != null)
					task.setTitle(work_Title);
				//TODO 연결업무의 설명이다 변경 필요
				if (m_Description != null)
					task.setDescription(m_Description);
				if (m_Description != null)
					task.setExtendedPropertyValue("m_Description", m_Description);
				
		
				//MEATADATA
				if (receiptUser != null) {
					task.setExtendedPropertyValue("receiptUser", receiptUser);
					task.setExtendedPropertyValue("receiptType", "SINGLE");
					
					if (receiptForm == null || receiptForm.equalsIgnoreCase(formId)) {
		//				task.setExtendedPropertyValue("receiptForm", formId);
						task.setExtendedPropertyValue("receiptForm", receiptForm);
						task.setExtendedPropertyValue("receiptName", name);
					} else {
						task.setExtendedPropertyValue("receiptForm", receiptForm);
						SwfForm receiptFormObj = getSwfManager().getForm(user, receiptForm);
						String receiptName = null;
						if (receiptFormObj == null) {
							receiptName = name;
						} else {
							receiptName = receiptFormObj.getName();
						}
						task.setExtendedPropertyValue("receiptName", receiptName);
					}
				}
				if (workContents != null)
					task.setExtendedPropertyValue("workContents", workContents);
				if (referenceUser != null)
					task.setExtendedPropertyValue("referenceUser", referenceUser);
				if (fileGroupId != null)
					task.setExtendedPropertyValue("fileGroupId", fileGroupId);
				if (projectName != null)
					task.setExtendedPropertyValue("projectName", projectName);
				if (isPublic != null)
					task.setExtendedPropertyValue("isPublic", isPublic);
				if (hopeEndDate != null)
					task.setExtendedPropertyValue("hopeEndDate", hopeEndDate);
				if (startDate != null) {
					task.setExpectStartDate(startDate);
					task.setRealStartDate(startDate);
				}	
				if (endDate != null) {
					task.setExpectEndDate(endDate);
					task.setRealEndDate(endDate);
				}
			}
			if (obj.getExtendedAttributeValue("extValues") != null && obj.getExtendedAttributeValue("extValues").length() != 0)
				task.setExtendedAttributeValue("extValues", obj.getExtendedAttributeValue("extValues"));
			this.getTskManager().executeTask(user, task, null);
		}

	}
	private SwdDataRef newDataRef(String myRecordId, String myFormId, String myFormFieldId, String refRecordId, String refFormId, String refFormFieldId) {
		SwdDataRef dataRef = new SwdDataRef();
		dataRef.setMyFormId(myFormId);
		dataRef.setMyFormFieldId(myFormFieldId);
		dataRef.setMyRecordId(myRecordId);
		dataRef.setRefFormId(refFormId);
		dataRef.setRefFormFieldId(refFormFieldId);
		dataRef.setRefRecordId(refRecordId);
		return dataRef;
	}
	public void postRemoveRecord(String user, String domainId, String recordId) throws Exception {
		SwdDomain domain = getSwdManager().getDomain(user, domainId, IManager.LEVEL_LITE);
		
		// 데이터 참조 삭제
		this.removeDataRefsByRecordId(user, domain.getFormId(), recordId);
		
		// 댓글 삭제
		//getOpinionManager().deleteOpinionByRef("admin", SmartCommonConstants.TYPE_REF_SINGLE_WORK, domain.getFormId(), recordId);
		
		// 전달업무 삭제
		this.removeProcessInstsByRecordId(user, domain.getFormId(), recordId);
	}
	
	private void removeDataRefsByRecordId(String user, String formId, String recordId) throws Exception {
		SwdDataRefCond dataRefCond = new SwdDataRefCond();
		dataRefCond.setMyFormId(formId);
		dataRefCond.setMyRecordId(recordId);
		SwdDataRef[] dataRefs = getSwdManager().getDataRefs(user, dataRefCond, IManager.LEVEL_LITE);
		if (!CommonUtil.isEmpty(dataRefs)) {
			for (SwdDataRef dataRef : dataRefs)
				getSwdManager().removeDataRef(user, dataRef.getObjId());
		}
	}
	private void removeProcessInstsByRecordId(String user, String formId, String recordId) throws Exception {
		if (CommonUtil.isEmpty(formId) || CommonUtil.isEmpty(recordId))
			return;
		
		// TODO 진행 중인 업무만 지우기로 함.
		TskTaskCond cond = new TskTaskCond();
		cond.setType("SINGLE");
		cond.setForm(formId);
		cond.setExtendedProperties(new Property[] {new Property("recordId", recordId)});
		Set exeStatusSet = MisUtil.taskExecutedStatusSet();
		if (CommonUtil.isEmpty(exeStatusSet))
			return;
		String[] exeStatuses = new String[exeStatusSet.size()];
		exeStatusSet.toArray(exeStatuses);
		cond.setStatusNotIns(exeStatuses);
		TskTask[] tasks = getTskManager().getTasks(user, cond, null);
		if (CommonUtil.isEmpty(tasks))
			return;
		
		for (TskTask task : tasks)
			getTskManager().removeTask(user, task.getObjId());
	}

	private List<SwfField> getMappingFieldList(SwfForm form, String type) {
		if (form == null)
			return null;
		SwfField[] fields = form.getFields();
		if (CommonUtil.isEmpty(fields))
			return null;
		List<SwfField> list = new ArrayList<SwfField>();
		SwfMappings maps;
		SwfMapping[] mappings;
		for (SwfField field : fields) {
			maps = field.getMappings();
			if (maps == null)
				continue;
			if (type.equalsIgnoreCase("pre")) {
				mappings = maps.getPreMappings();
				if (CommonUtil.isEmpty(mappings))
					continue;
				for (SwfMapping mapping : mappings) {
					// TODO 매번 매핑 여부
				}
			} else if (type.equalsIgnoreCase("post")) {
				if (CommonUtil.isEmpty(maps.getPostMappings()))
					continue;
			}
			list.add(field);
		}
		return list;
	}
	
	private void preFieldMapping(String user, SwdRecordCond cond, SwdRecord[] records) throws Exception {
		String domainId = cond.getDomainId();
		String formId = cond.getFormId();
		if (domainId != null) {
			this.preFieldMapping(user, domainId, records);
		} else if (formId != null) {
			this.preFieldMappingByFormId(user, formId, records);
		}
	}
	private void preFieldMapping(String user, String domainId, SwdRecord[] records) throws Exception {
		if (domainId == null || CommonUtil.isEmpty(records))
			return;
		SwdDomain domain = getSwdManager().getDomain(user, domainId, IManager.LEVEL_LITE);
		preFieldMapping(user, domain, records);
	}
	private void preFieldMappingByFormId(String user, String formId, SwdRecord[] records) throws Exception {
		if (formId == null || CommonUtil.isEmpty(records))
			return;
		SwdDomainCond cond = new SwdDomainCond();
		cond.setFormId(formId);
		SwdDomain domain = getSwdManager().getDomain(user, cond, IManager.LEVEL_LITE);
		preFieldMapping(user, domain, records);
	}
	private void preFieldMapping(String user, SwdDomain domain, SwdRecord[] records) throws Exception {
		if (domain == null || CommonUtil.isEmpty(records))
			return;
		SwfForm form = getSwfManager().getForm(null, domain.getFormId());
		this.getSwdManager().preFieldMapping(user, form, records, null);
	}
	private void postFieldMapping(String user, SwdDomain domain, SwdRecord record) throws Exception {
		if (domain == null || record == null)
			return;
		SwfForm form = getSwfManager().getForm(null, domain.getFormId());
		if (form == null)
			return;
		this.getSwdManager().postFieldMapping(user, form, record, null);
	}
}
