package net.smartworks.server.engine.infowork.domain.manager.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import net.smartworks.server.engine.common.manager.IManager;
import net.smartworks.server.engine.common.model.Property;
import net.smartworks.server.engine.common.util.CommonUtil;
import net.smartworks.server.engine.common.util.MisUtil;
import net.smartworks.server.engine.factory.SwManagerFactory;
import net.smartworks.server.engine.infowork.domain.manager.AbstractSwdManagerAdvisor;
import net.smartworks.server.engine.infowork.domain.manager.ISwdManager;
import net.smartworks.server.engine.infowork.domain.model.SwdDataField;
import net.smartworks.server.engine.infowork.domain.model.SwdDataRef;
import net.smartworks.server.engine.infowork.domain.model.SwdDataRefCond;
import net.smartworks.server.engine.infowork.domain.model.SwdDomain;
import net.smartworks.server.engine.infowork.domain.model.SwdDomainCond;
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
		Date date = new Date();
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
