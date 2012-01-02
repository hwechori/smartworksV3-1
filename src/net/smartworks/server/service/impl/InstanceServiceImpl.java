package net.smartworks.server.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import net.smartworks.model.community.User;
import net.smartworks.model.community.info.UserInfo;
import net.smartworks.model.community.info.WorkSpaceInfo;
import net.smartworks.model.filter.Condition;
import net.smartworks.model.filter.SearchFilter;
import net.smartworks.model.instance.CommentInstance;
import net.smartworks.model.instance.FieldData;
import net.smartworks.model.instance.Instance;
import net.smartworks.model.instance.ProcessWorkInstance;
import net.smartworks.model.instance.SortingField;
import net.smartworks.model.instance.WorkInstance;
import net.smartworks.model.instance.info.BoardInstanceInfo;
import net.smartworks.model.instance.info.IWInstanceInfo;
import net.smartworks.model.instance.info.InstanceInfo;
import net.smartworks.model.instance.info.InstanceInfoList;
import net.smartworks.model.instance.info.PWInstanceInfo;
import net.smartworks.model.instance.info.RequestParams;
import net.smartworks.model.instance.info.TaskInstanceInfo;
import net.smartworks.model.work.FormField;
import net.smartworks.model.work.info.SmartWorkInfo;
import net.smartworks.model.work.info.WorkCategoryInfo;
import net.smartworks.model.work.info.WorkInfo;
import net.smartworks.server.engine.common.manager.IManager;
import net.smartworks.server.engine.common.model.Filter;
import net.smartworks.server.engine.common.model.Order;
import net.smartworks.server.engine.common.util.CommonUtil;
import net.smartworks.server.engine.docfile.exception.DocFileException;
import net.smartworks.server.engine.docfile.manager.IDocFileManager;
import net.smartworks.server.engine.factory.SwManagerFactory;
import net.smartworks.server.engine.infowork.domain.manager.ISwdManager;
import net.smartworks.server.engine.infowork.domain.model.SwdDataField;
import net.smartworks.server.engine.infowork.domain.model.SwdDomain;
import net.smartworks.server.engine.infowork.domain.model.SwdDomainCond;
import net.smartworks.server.engine.infowork.domain.model.SwdField;
import net.smartworks.server.engine.infowork.domain.model.SwdFieldCond;
import net.smartworks.server.engine.infowork.domain.model.SwdRecord;
import net.smartworks.server.engine.infowork.domain.model.SwdRecordCond;
import net.smartworks.server.engine.infowork.domain.model.SwdRecordExtend;
import net.smartworks.server.engine.infowork.form.manager.ISwfManager;
import net.smartworks.server.engine.infowork.form.model.SwfField;
import net.smartworks.server.engine.infowork.form.model.SwfForm;
import net.smartworks.server.engine.infowork.form.model.SwfFormCond;
import net.smartworks.server.engine.infowork.form.model.SwfFormLink;
import net.smartworks.server.engine.infowork.form.model.SwfMapping;
import net.smartworks.server.engine.infowork.form.model.SwfMappings;
import net.smartworks.server.engine.organization.manager.ISwoManager;
import net.smartworks.server.engine.organization.model.SwoDepartmentCond;
import net.smartworks.server.engine.process.process.manager.IPrcManager;
import net.smartworks.server.engine.process.process.model.PrcProcess;
import net.smartworks.server.engine.process.process.model.PrcProcessCond;
import net.smartworks.server.engine.process.process.model.PrcProcessInst;
import net.smartworks.server.engine.process.process.model.PrcProcessInstCond;
import net.smartworks.server.engine.process.process.model.PrcProcessInstExtend;
import net.smartworks.server.engine.process.task.manager.ITskManager;
import net.smartworks.server.engine.process.task.model.TskTask;
import net.smartworks.server.engine.worklist.model.TaskWork;
import net.smartworks.server.engine.worklist.model.TaskWorkCond;
import net.smartworks.server.service.IInstanceService;
import net.smartworks.server.service.util.ModelConverter;
import net.smartworks.util.LocalDate;
import net.smartworks.util.SmartTest;
import net.smartworks.util.SmartUtil;

import org.springframework.stereotype.Service;

@Service
public class InstanceServiceImpl implements IInstanceService {

	private ITskManager getTskManager() {
		return SwManagerFactory.getInstance().getTskManager();
	}
	private IPrcManager getPrcManager() {
		return SwManagerFactory.getInstance().getPrcManager();
	}
	private ISwdManager getSwdManager() {
		return SwManagerFactory.getInstance().getSwdManager();
	}
	private ISwfManager getSwfManager() {
		return SwManagerFactory.getInstance().getSwfManager();
	}
	private IDocFileManager getDocManager() {
		return SwManagerFactory.getInstance().getDocManager();
	}
	private ISwoManager getSwoManager() {
		return SwManagerFactory.getInstance().getSwoManager();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * net.smartworks.service.impl.ISmartWorks#getBoardInstances(net.smartworks
	 * .util.LocalDate, int)
	 */
	@Override
	public BoardInstanceInfo[] getBoardInstances(LocalDate fromDate, int days) throws Exception {
		return SmartTest.getBoardInstances();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * net.smartworks.service.impl.ISmartWorks#getBoardInstances(net.smartworks
	 * .util.LocalDate, net.smartworks.util.LocalDate)
	 */
	@Override
	public BoardInstanceInfo[] getBoardInstances(LocalDate fromDate, LocalDate toDate) throws Exception {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * net.smartworks.service.impl.ISmartWorks#getMyRecentInstances(java.lang
	 * .String)
	 */
	@Override
	public InstanceInfo[] getMyRecentInstances() throws Exception {
		 return SmartTest.getMyRecentInstances();	
//			if (CommonUtil.isEmpty(companyId) || CommonUtil.isEmpty(userId))
//				return null;
//	
//			TskTaskCond taskCond = new TskTaskCond();
//			taskCond.setAssignee(userId);
//			taskCond.setStatus(TskTask.TASKSTATUS_COMPLETE);
//			taskCond.setTypeNotIns(TskTask.NOTUSERTASKTYPES);
//			taskCond.setOrders(new Order[]{new Order("executionDate" , false)});
//			taskCond.setPageNo(0);
//			taskCond.setPageSize(50);
//			
//			TskTask[] tasks = getTskManager().getTasks(userId, taskCond, IManager.LEVEL_LITE);
//			if (CommonUtil.isEmpty(tasks))
//				return null;
//		
//			List<String> prcInstIdList = new ArrayList<String>();
//			for (int i = 0; i < tasks.length; i++) {
//				TskTask task = tasks[i];
//				if (prcInstIdList.size() == 10)
//					break;
//				if (prcInstIdList.contains(task.getProcessInstId()))
//					continue;
//				prcInstIdList.add(task.getProcessInstId());
//			}
//			
//			String[] prcInstIdArray = new String[prcInstIdList.size()];
//			
//			prcInstIdList.toArray(prcInstIdArray);
//			
//			PrcProcessInstCond prcInstCond = new PrcProcessInstCond();
//			
//			prcInstCond.setCompanyId(companyId);
//			prcInstCond.setObjIdIns(prcInstIdArray);
//			
//			PrcProcessInst[] prcInsts = getPrcManager().getProcessInsts(userId, prcInstCond, IManager.LEVEL_LITE);
//			
//			InstanceInfo[] instInfo = ModelConverter.getInstanceInfoArrayByPrcInstArray(prcInsts);
//			
//			return instInfo;
			
	}

	@Override
	public Instance getInstanceById(String instanceId) throws Exception {
		return SmartTest.getInstanceById(instanceId);
	}

	public InstanceInfo[] getMyRunningInstances() throws Exception {
		Date limitDate = new Date();
		int resultSize = 10;
		return getMyRunningInstances( limitDate, resultSize);
	}
	
	public InstanceInfo[] getMyRunningInstances(Date limitDate, int resultSize) throws Exception {
//		return SmartTest.getRunningInstances();
		//정보관리업무에서 파생된 업무는 IWInstanceInfo
		//프로세스 태스크및 프로세스에서 파생된 업무는 PWInstanceInfo

		User user = SmartUtil.getCurrentUser();
		if (CommonUtil.isEmpty(user.getCompanyId()) || CommonUtil.isEmpty(user.getId()))
			return null;

		TaskWorkCond taskCond = new TaskWorkCond();
		taskCond.setTskAssignee(user.getId());
		taskCond.setPageNo(0);
		taskCond.setPageSize(10);
		
		TaskWork[] tasks = SwManagerFactory.getInstance().getWorkListManager().getTaskWorkList(user.getId(), taskCond);
		
		if(tasks != null) return ModelConverter.getInstanceInfoArrayByTaskWorkArray(user.getId(), tasks);
		return null;
	}

	@Override
	public InstanceInfo[] searchMyRunningInstance(String key) throws Exception {
		return SmartTest.getRunningInstances();
	}

	@Override
	public String  setMemoInstance(HttpServletRequest request) throws Exception {		
		return "testId";
	}

	private SwdRecord getSwdRecordByJsonFormData(Map<String, Object> jsonFormDataMap) throws Exception {
		
		//TODO
		
		return null;
	}
	public SwdRecord refreshDataFields(Map<String, Object> requestBody) throws Exception {
		
		String formId = (String)requestBody.get("formId");
		String formName = (String)requestBody.get("formName");// 사용?
		SwdRecord record = this.getSwdRecordByJsonFormData((Map<String, Object>)requestBody.get("frmSmartForm"));
		boolean isFirstSetMode = true; //초기 데이터 입력인지 수정인지를 판단한다
		
		//레코드 폼정보를 가져온다
		if (CommonUtil.isEmpty(formId))
			return null;
		SwfForm form = SwManagerFactory.getInstance().getSwfManager().getForm(null, formId);
		if (form == null)
			return null;
		SwfField[] fields = form.getFields();
		if (CommonUtil.isEmpty(fields))
			return null;
		
		//폼에 연결된 연결업무 링크 정보를 가져온다
		/*<formLink id="8" name="test" targetFormId="frm_b5d88ed991dd4677a9f0d482f412fb55">
			<conds operator="and">
				<cond operator="=">
					<first type="other" fieldId="0"/>
					<second type="self" fieldId="0"/>
				</cond>
			</conds>
		</formLink>*/
		SwfFormLink[] formLinks = form.getMappingForms();
		Map<String, SwfFormLink> formLinkMap = new HashMap<String, SwfFormLink>();
		if (!CommonUtil.isEmpty(formLinks)) {
			for (SwfFormLink formLink:formLinks)
				formLinkMap.put(formLink.getId(), formLink);
		}
		

		// 업무연결아이디와 해당 업무 맵 ??????//
		Map<String, SwdRecord[]> formLinkIdRecordMap = new HashMap<String, SwdRecord[]>();

		// 각 필드들 마다 가져오기 맵핑을 확인하여 값을 셋팅한다
		// 
		for (SwfField field : fields) {
			// 가져오기 매핑정의가 있는지 확인 시작
			SwfMappings mappings = field.getMappings();
			if (mappings == null)
				continue;
			SwfMapping[] preMappings = mappings.getPreMappings();
			if (CommonUtil.isEmpty(preMappings))
				continue;
			// 가져오기 매핑정의가 있는지 확인 끝

			String fieldId = field.getId();
			String fieldType = field.getSystemType();

			//가져오기 셋팅이 여러개 일수 있다
			for (SwfMapping preMapping : preMappings) {
				
				
				
			}
		}
		
		return null;  
	}
	
	
	@Override
	public String setInformationWorkInstance(Map<String, Object> requestBody, HttpServletRequest request) throws Exception {
		
		/*
		Key Set : frmSmartForm
		Key Set : frmScheduleWork
		Key Set : frmAccessSpace
		key Set : formId
		key Set : formName
		*/
		Map<String, Object> SmartFormInfoMap = (Map<String, Object>)requestBody.get("frmSmartForm");
		
		String domainId = null; // domainId 가 없어도 내부 서버에서 폼아이디로 검색하여 저장
		String formId = (String)requestBody.get("formId");
		String formName = (String)requestBody.get("formName");
		int formVersion = 1;
		User cuser = SmartUtil.getCurrentUser();
		String userId = null;
		if (cuser != null)
			userId = cuser.getId();

		SwdDomainCond swdDomainCond = new SwdDomainCond();
		swdDomainCond.setFormId(formId);
		SwdDomain swdDomain = getSwdManager().getDomain(userId, swdDomainCond, IManager.LEVEL_LITE);

		domainId = swdDomain.getObjId();

		SwdFieldCond swdFieldCond = new SwdFieldCond();
		swdFieldCond.setDomainObjId(domainId);
		SwdField[] fields = getSwdManager().getFields(userId, swdFieldCond, IManager.LEVEL_LITE);
		if (CommonUtil.isEmpty(fields))
			return null;//TODO return null? throw new Exception??
		
		Map<String, SwdField> fieldInfoMap = new HashMap<String, SwdField>();
		for (SwdField field : fields) {
			fieldInfoMap.put(field.getFormFieldId(), field);
		}
		
		Set<String> keySet = SmartFormInfoMap.keySet();
		Iterator<String> itr = keySet.iterator();
		
//		SwdField[] fieldDatas = new SwdField[keySet.size()];
		List fieldDataList = new ArrayList();
		List<Map<String, String>> files = null;
		List users = null;
		String groupId = null;
		while (itr.hasNext()) {
			String fieldId = (String)itr.next();
			String value = null;
			String refForm = null;
			String refFormField = null;
			String refRecordId = null;
			Object fieldValue = SmartFormInfoMap.get(fieldId);
			if (fieldValue instanceof LinkedHashMap) {
				Map<String, Object> valueMap = (Map<String, Object>)fieldValue;
				groupId = (String)valueMap.get("groupId");
				refForm = (String)valueMap.get("refForm");
				users = (ArrayList)valueMap.get("users");

				if(!CommonUtil.isEmpty(groupId)) {
					files = (ArrayList<Map<String,String>>)valueMap.get("files");
					value = groupId;
				} else if(!CommonUtil.isEmpty(refForm)) {
					refFormField = (String)valueMap.get("refFormField");
					refRecordId = (String)valueMap.get("refRecordId");
					SwoDepartmentCond swoDepartmentCond = new SwoDepartmentCond();
					swoDepartmentCond.setId(refRecordId);
					String deptName = getSwoManager().getDepartment(userId, swoDepartmentCond, IManager.LEVEL_LITE).getName();
					value = deptName;
				} else if(!CommonUtil.isEmpty(users)) {
					String user = "";
					String symbol = ";";
					if(users.size() == 1) {
						user = (String)users.get(0);
					} else {
						for(int i=0; i < users.size(); i++) {
							user += (String)users.get(i) + symbol;
						}
//						int sapaEmptyInt = 2;
//						int userSapaEmpty = user.length() - sapaEmptyInt;
//						user = user.substring(0, userSapaEmpty);
						System.out.println("user : " + user);
					}
					value = user;
				}
			} else if(fieldValue instanceof String) {
				value = (String)SmartFormInfoMap.get(fieldId);
			}
			if (CommonUtil.isEmpty(value))
				continue;
			SwdDataField fieldData = new SwdDataField();
			fieldData.setId(fieldId);
			fieldData.setName(fieldInfoMap.get(fieldId).getFormFieldName());
			fieldData.setRefForm(refForm);
			fieldData.setRefFormField(refFormField);
			fieldData.setRefRecordId(refRecordId);
			fieldData.setValue(value);

			fieldDataList.add(fieldData);
			
		}
		String workType = "";
		String servletPath = request.getServletPath();
		if(servletPath.equals("/upload_new_picture.sw"))
			workType = "Pictures";
		else
			workType = "Files";

		SwdDataField[] fieldDatas = new SwdDataField[fieldDataList.size()];
		fieldDataList.toArray(fieldDatas);
		SwdRecord obj = new SwdRecord();
		obj.setDomainId(domainId);
		obj.setFormId(formId);
		obj.setFormName(formName);
		obj.setFormVersion(formVersion);
		obj.setDataFields(fieldDatas);

		getSwdManager().setRecord(userId, obj, IManager.LEVEL_ALL);

		try {
			for(int i=0; i < files.subList(0, files.size()).size(); i++) {
				Map<String, String> file = files.get(i);
				String fileId = file.get("fileId");
				String fileName = file.get("fileName");
				String fileSize = file.get("fileSize");
				getDocManager().insertFiles(workType, groupId, fileId, fileName, fileSize);
			}
		} catch (Exception e) {
			throw new DocFileException("file upload fail...");
		}
		return null;
	}

	@Override
	public String startProcessWorkInstance(HttpServletRequest request) throws Exception {
		return "testId";
	}

	@Override
	public String setFileInstance(HttpServletRequest request) throws Exception {
		return "testId";
	}

	@Override
	public String setEventInstance(HttpServletRequest request) throws Exception {
		return "testId";		
	}

	@Override
	public String setBoardInstance(HttpServletRequest request) throws Exception {
		return "testId";		
	}

	@Override
	public CommentInstance[] getRecentCommentsInWorkManual(String workId, int length) throws Exception {
		// TODO Auto-generated method stub
		return SmartTest.getCommentInstances();
	}

	@Override
	public InstanceInfoList getIWorkInstanceList(String workId, RequestParams params) throws Exception {

		Date start = new Date();

		User user = SmartUtil.getCurrentUser();

		SwdDomainCond swdDomainCond = new SwdDomainCond();
		swdDomainCond.setCompanyId(user.getCompanyId());

		SwfFormCond swfFormCond = new SwfFormCond();
		swfFormCond.setCompanyId(user.getCompanyId());
		swfFormCond.setPackageId(workId);

		swdDomainCond.setFormId(getSwfManager().getForms(user.getId(), swfFormCond, IManager.LEVEL_LITE)[0].getId());

		SwdDomain swdDomain = getSwdManager().getDomain(user.getId(), swdDomainCond, IManager.LEVEL_LITE);

		SwdRecordCond swdRecordCond = new SwdRecordCond();
		swdRecordCond.setCompanyId(user.getCompanyId());
		swdRecordCond.setFormId(swdDomain.getFormId());
		swdRecordCond.setDomainId(swdDomain.getObjId());

		long totalCount = getSwdManager().getRecordSize(user.getId(), swdRecordCond);

		int pageCount = params.getPageSize();
		int currentPage = params.getCurrentPage();
		SortingField sf = params.getSortingField();
//		SearchFilter searchFilter = params.getSearchFilter();
//		Condition[] conditions = searchFilter.getConditions();
//		for(Condition condition : conditions) {
//			FormField leftOperand = condition.getLeftOperand();
//			String operator = condition.getOperator();
//			Object rightOperand = condition.getRightOperand();
//		}

		String fieldName = "";
		boolean isAsc;

		if (sf != null) {
			fieldName  = CommonUtil.toDefault("createdTime" , sf.getFieldId());
			isAsc =  sf.isAscending();
		} else {
			fieldName = "createdTime";
			isAsc = false;
		}
		swdRecordCond.setOrders(new Order[]{new Order(fieldName, isAsc)});

		swdRecordCond.setPageNo(currentPage);
		swdRecordCond.setPageSize(pageCount);

		SwdRecord[] swdRecords = getSwdManager().getRecords(user.getId(), swdRecordCond, IManager.LEVEL_LITE);

		if (swdRecords == null)
			return null;
			
		SwdRecordExtend[] swdRecordExtends = getSwdManager().getCtgPkg(workId);

		//SwdField[] swdFields = getSwdManager().getViewFieldList(workId, swdDomain.getFormId());

		SwfForm[] swfForms = getSwfManager().getForms(user.getId(), swfFormCond, IManager.LEVEL_ALL);
		SwfField[] swfFields = swfForms[0].getFields();

		IWInstanceInfo[] iWInstanceInfos = new IWInstanceInfo[swdRecords.length];

		for(int i = 0; i < swdRecords.length; i++) {
			IWInstanceInfo iWInstanceInfo = new IWInstanceInfo();
			SwdRecord swdRecord = swdRecords[i];
			iWInstanceInfo.setId(swdRecord.getRecordId());
			iWInstanceInfo.setOwner(ModelConverter.getUserInfoByUserId(swdRecord.getCreationUser()));
			iWInstanceInfo.setSubject(""); //TODO
			int type = WorkInstance.TYPE_INFORMATION;
			iWInstanceInfo.setType(type);
			iWInstanceInfo.setStatus(WorkInstance.STATUS_COMPLETED);
			iWInstanceInfo.setWorkSpace(null);

			WorkCategoryInfo groupInfo = null;
			if (!CommonUtil.isEmpty(swdRecordExtends[0].getSubCtgId()))
				groupInfo = new WorkCategoryInfo(swdRecordExtends[0].getSubCtgId(), swdRecordExtends[0].getSubCtg());

			WorkCategoryInfo categoryInfo = new WorkCategoryInfo(swdRecordExtends[0].getParentCtgId(), swdRecordExtends[0].getParentCtg());

			WorkInfo workInfo = new SmartWorkInfo(swdRecord.getFormId(), swdRecord.getFormName(), type, groupInfo, categoryInfo);

			iWInstanceInfo.setWork(workInfo);
			iWInstanceInfo.setLastModifier(ModelConverter.getUserInfoByUserId(swdRecord.getModificationUser()));
			iWInstanceInfo.setLastModifiedDate(new LocalDate((swdRecord.getModificationDate()).getTime()));

			SwdDataField[] swdDataFields = swdRecord.getDataFields();
			List<FieldData> fieldDataList = new ArrayList<FieldData>();

			for(SwdDataField swdDataField : swdDataFields) {
				for(SwfField swfField : swfFields) {
					if(swdDataField.getDisplayOrder() > -1) {
						if(swdDataField.getId().equals(swfField.getId())) {
							FieldData fieldData = new FieldData();
							fieldData.setFieldId(swdDataField.getId());
							fieldData.setFieldType(swfField.getFormat().getViewingType());
							fieldData.setValue(swdDataField.getValue());
							fieldDataList.add(fieldData);
						}
					}
				}
			}
			FieldData[] fieldDatas = new FieldData[fieldDataList.size()];
			fieldDataList.toArray(fieldDatas);
			iWInstanceInfo.setDisplayDatas(fieldDatas);
			iWInstanceInfos[i] = iWInstanceInfo;
		}

		InstanceInfoList instanceInfoList = new InstanceInfoList();
		instanceInfoList.setInstanceDatas(iWInstanceInfos);
		long termTime = start.getTime() - new Date().getTime();
		instanceInfoList.setType(InstanceInfoList.TYPE_INFORMATION_INSTANCE_LIST);
		instanceInfoList.setPageSize(pageCount);
		instanceInfoList.setTotalPages((int)totalCount);
		instanceInfoList.setCurrentPage(currentPage);

		return instanceInfoList;
	}

	@Override
	public InstanceInfoList getIWorkInstanceListByFormId(String formId, RequestParams params) throws Exception {

		User user = SmartUtil.getCurrentUser();

		SwfFormCond swfCond = new SwfFormCond();
		swfCond.setCompanyId(user.getCompanyId());
		swfCond.setId(formId);

		SwfForm swfForm = getSwfManager().getForms(user.getId(), swfCond, IManager.LEVEL_LITE)[0];

		String workId = swfForm.getPackageId();

		InstanceInfoList instanceInfoList = getIWorkInstanceList(workId, params);

		return instanceInfoList;
	}

	public InstanceInfoList getPWorkInstanceList(String workId, RequestParams params) throws Exception {

		User user = SmartUtil.getCurrentUser();
		//TODO workId = category 프로세스 인스턴스정보에는 패키지 컬럼이 없고 다이어 그램 컬럼에 정보가 들어가 있다
		//임시로 프로세스 다이어그램아이디 필드를 이용하고 프로세스인스턴스가 생성되는 시점(업무 시작, 처리 개발 완료)에 패키지 아이디 컬럼을 추가해 그곳에서 조회하는걸로 변경한다
		PrcProcessInstCond prcInstCond = new PrcProcessInstCond();
		prcInstCond.setPackageId(workId);
		long totalCount = getPrcManager().getProcessInstExtendsSize(user.getId(), prcInstCond);
		
		int pageCount = params.getPageSize();
		int currentPage = params.getCurrentPage();
		
		SortingField sf = params.getSortingField();
		
		prcInstCond.setPageNo(currentPage);
		prcInstCond.setPageSize(pageCount);
		PrcProcessInstExtend[] prcInsts = getPrcManager().getProcessInstExtends(user.getId(), prcInstCond);
		
		if (prcInsts == null)
			return null;
		
		InstanceInfoList instanceInfoList = new InstanceInfoList();
		
		PWInstanceInfo[] pWInstanceInfos = new PWInstanceInfo[prcInsts.length];
		
		for (int i = 0; i < prcInsts.length; i++) {
			PWInstanceInfo pwInstInfo = new PWInstanceInfo();
			PrcProcessInstExtend prcInst = prcInsts[i];
			
			pwInstInfo.setId(prcInst.getPrcObjId());
			pwInstInfo.setOwner(ModelConverter.getUserInfoByUserId(prcInst.getPrcCreateUser()));
			int status = -1;
			if (prcInst.getPrcStatus().equalsIgnoreCase(PrcProcessInst.PROCESSINSTSTATUS_RUNNING)) {
				status = Instance.STATUS_COMPLETED;
			} else if (prcInst.getPrcStatus().equalsIgnoreCase(PrcProcessInst.PROCESSINSTSTATUS_COMPLETE)) {
				status = Instance.STATUS_COMPLETED;
			}
			pwInstInfo.setStatus(status);
			pwInstInfo.setSubject(prcInst.getPrcTitle());
			int type = WorkInstance.TYPE_PROCESS;
			pwInstInfo.setType(type);
			
			WorkCategoryInfo groupInfo = null;
			if (!CommonUtil.isEmpty(prcInst.getSubCtgId()))
				groupInfo = new WorkCategoryInfo(prcInst.getSubCtgId(), prcInst.getSubCtg());
				
			WorkCategoryInfo categoryInfo = new WorkCategoryInfo(prcInst.getParentCtgId(), prcInst.getParentCtg());
			
			WorkInfo workInfo = new SmartWorkInfo(prcInst.getPrcDid(), prcInst.getPrcName(), type, groupInfo, categoryInfo);
			pwInstInfo.setWork(workInfo);

			TaskInstanceInfo lastTaskInfo = null;
			
			if (!CommonUtil.isEmpty(prcInst.getLastTask_tskObjId())) {
				lastTaskInfo = new TaskInstanceInfo();
				
				if (prcInst.getLastTask_tskStatus().equalsIgnoreCase(TskTask.TASKSTATUS_ASSIGN) || prcInst.getLastTask_tskStatus().equalsIgnoreCase(TskTask.TASKSTATUS_CREATE)) {
					pwInstInfo.setLastModifiedDate(new LocalDate(prcInst.getLastTask_tskCreateDate().getTime()));
				} else {
					pwInstInfo.setLastModifiedDate(new LocalDate(prcInst.getLastTask_tskExecuteDate().getTime()));//마지막태스크 수행일
				}
				pwInstInfo.setLastModifier(ModelConverter.getUserInfoByUserId(prcInst.getLastTask_tskAssignee()));//마지막태스크 수행자
				
				String id = prcInst.getLastTask_tskObjId();
				String subject = prcInst.getLastTask_tskTitle();
				int tskType = WorkInstance.TYPE_TASK;
				String name = prcInst.getLastTask_tskName();
				String assignee = prcInst.getLastTask_tskAssignee();
				String performer = prcInst.getLastTask_tskAssignee();
				
				WorkSpaceInfo workSpace = null; //TODO
				
				int tskStatus = -1;
				if (prcInst.getLastTask_tskStatus().equalsIgnoreCase(TskTask.TASKSTATUS_ASSIGN)) {
					tskStatus = Instance.STATUS_COMPLETED;
				} else if (prcInst.getLastTask_tskStatus().equalsIgnoreCase(TskTask.TASKSTATUS_COMPLETE)) {
					tskStatus = Instance.STATUS_COMPLETED;
				}
				UserInfo owner = ModelConverter.getUserInfoByUserId(prcInst.getLastTask_tskAssignee());
				UserInfo lastModifier = ModelConverter.getUserInfoByUserId(prcInst.getLastTask_tskAssignee()); 
				LocalDate lastModifiedDate = new LocalDate((prcInst.getLastTask_tskCreateDate().getTime()));
				
				lastTaskInfo.setId(id);
				lastTaskInfo.setLastModifiedDate(lastModifiedDate);
				lastTaskInfo.setLastModifier(lastModifier);
				lastTaskInfo.setOwner(owner);
				lastTaskInfo.setStatus(tskStatus);
				lastTaskInfo.setSubject(subject);
				lastTaskInfo.setType(tskType);
				lastTaskInfo.setWork(workInfo);
				lastTaskInfo.setWorkInstance(pwInstInfo);
				lastTaskInfo.setWorkSpace(workSpace);
				lastTaskInfo.setName(name);
				lastTaskInfo.setTaskType(tskType);
				lastTaskInfo.setAssignee(ModelConverter.getUserInfoByUserId(assignee));
				lastTaskInfo.setPerformer(ModelConverter.getUserInfoByUserId(performer));
				//WorkInstanceInfo workInstanceInfo = paretProcessInstObj;
				pwInstInfo.setLastTask(lastTaskInfo);//마지막 태스크
			}
			pwInstInfo.setLastTaskCount(prcInst.getLastTask_tskCount());
			pwInstInfo.setWorkSpace(null);
			pWInstanceInfos[i] = pwInstInfo;
		}
//		instanceInfoList.setInstanceDatas(ModelConverter.getPWInstanceInfoArrayByPrcProcessInstArray(prcInsts));
		instanceInfoList.setInstanceDatas(pWInstanceInfos);
		
		instanceInfoList.setPageSize(pageCount);
		instanceInfoList.setTotalPages((int)totalCount);
		instanceInfoList.setCurrentPage(currentPage);
		instanceInfoList.setTotalPages(InstanceInfoList.TYPE_PROCESS_INSTANCE_LIST);
		return instanceInfoList;
	}
	public InstanceInfoList getPWorkInstanceList_bak(String workId, RequestParams params) throws Exception {

		Date startTime = new Date();
		Long start = startTime.getTime();
		//TODO workId = category 프로세스 인스턴스정보에는 패키지 컬럼이 없고 다이어 그램 컬럼에 정보가 들어가 있다
		//임시로 프로세스 다이어그램아이디 필드를 이용하고 프로세스인스턴스가 생성되는 시점(업무 시작, 처리 개발 완료)에 패키지 아이디 컬럼을 추가해 그곳에서 조회하는걸로 변경한다

		User user = SmartUtil.getCurrentUser();
		PrcProcessCond prcCond = new PrcProcessCond();
		prcCond.setDiagramId(workId);
		prcCond.setCompanyId(user.getCompanyId());
		PrcProcess[] prc = getPrcManager().getProcesses(user.getId(), prcCond, IManager.LEVEL_LITE);
		if (prc == null)
			return null;
		
		PrcProcessInstCond prcInstCond = new PrcProcessInstCond();
		prcInstCond.setCompanyId(user.getCompanyId());
		prcInstCond.setProcessId(prc[0].getProcessId());
		
		long totalCount = getPrcManager().getProcessInstSize(user.getId(), prcInstCond);
		
		int currentPage = params.getCurrentPage();
		int pageCount = params.getPageSize();
		SortingField sf = params.getSortingField();
		
		//임시로 무조건 오더링 한다
		if (sf != null || true) {
			//TODO fieldId 가 없음 프로세스 업무는 아래 처럼 컬럼(모델 필드명) 이름을 직접 주어야 한다
			String fieldName = "creationDate";
			boolean isAsc = false;
			prcInstCond.setOrders(new Order[]{new Order(fieldName, isAsc)});
		}
		
		prcInstCond.setPageNo(currentPage);
		prcInstCond.setPageSize(pageCount);
		
		PrcProcessInst[] prcInsts = getPrcManager().getProcessInsts(user.getId(), prcInstCond, IManager.LEVEL_LITE);
		
		InstanceInfoList instanceInfoList = new InstanceInfoList();
		instanceInfoList.setInstanceDatas(ModelConverter.getPWInstanceInfoArrayByPrcProcessInstArray(prcInsts));
		instanceInfoList.setPageSize(pageCount);
		instanceInfoList.setTotalPages((int)totalCount);
		instanceInfoList.setCurrentPage(currentPage);
		instanceInfoList.setTotalPages(InstanceInfoList.TYPE_PROCESS_INSTANCE_LIST);

		return instanceInfoList;
	}
	public InstanceInfoList getPWorkInstanceList_bak2(String companyId, String userId, String workId, RequestParams params) throws Exception {
		Date startTime = new Date();
		Long start = startTime.getTime();
		//TODO workId = category 프로세스 인스턴스정보에는 패키지 컬럼이 없고 다이어 그램 컬럼에 정보가 들어가 있다
		//임시로 프로세스 다이어그램아이디 필드를 이용하고 프로세스인스턴스가 생성되는 시점(업무 시작, 처리 개발 완료)에 패키지 아이디 컬럼을 추가해 그곳에서 조회하는걸로 변경한다
		PrcProcessCond prcCond = new PrcProcessCond();
		prcCond.setDiagramId(workId);
		prcCond.setCompanyId(companyId);
		PrcProcess[] prc = getPrcManager().getProcesses(userId, prcCond, IManager.LEVEL_LITE);
		if (prc == null)
			return null;
		PrcProcessInstCond prcInstCond = new PrcProcessInstCond();
		prcInstCond.setCompanyId(companyId);
		prcInstCond.setProcessId(prc[0].getProcessId());
		long totalCount = getPrcManager().getProcessInstSize(userId, prcInstCond);
		int currentPage = params.getCurrentPage();
		int pageCount = params.getPageSize();
		SortingField sf = params.getSortingField();
		//임시로 무조건 오더링 한다
		if (sf != null || true) {
			//TODO fieldId 가 없음 프로세스 업무는 아래 처럼 컬럼(모델 필드명) 이름을 직접 주어야 한다
			String fieldName = "creationDate";
			boolean isAsc = false;
			prcInstCond.setOrders(new Order[]{new Order(fieldName, isAsc)});
		}
		prcInstCond.setPageNo(currentPage);
		prcInstCond.setPageSize(pageCount);
		PrcProcessInst[] prcInsts = getPrcManager().getProcessInsts(userId, prcInstCond, IManager.LEVEL_LITE);
		InstanceInfoList instanceInfoList = new InstanceInfoList();
		PWInstanceInfo[] pWInstanceInfos = new PWInstanceInfo[prcInsts.length];
		for (int i = 0; i < prcInsts.length; i++) {
			PWInstanceInfo pwInstInfo = new PWInstanceInfo();
			PrcProcessInst prcInst = prcInsts[i];
			pwInstInfo.setId(prcInst.getObjId());
			pwInstInfo.setOwner(ModelConverter.getUserInfoByUserId(prcInst.getCreationUser()));
			int status = -1;
			if (prcInst.getStatus().equalsIgnoreCase(PrcProcessInst.PROCESSINSTSTATUS_RUNNING)) {
				status = Instance.STATUS_COMPLETED;
			} else if (prcInst.getStatus().equalsIgnoreCase(PrcProcessInst.PROCESSINSTSTATUS_COMPLETE)) {
				status = Instance.STATUS_COMPLETED;
			}
			pwInstInfo.setStatus(status);
			pwInstInfo.setSubject(prcInst.getTitle());
			int type = WorkInstance.TYPE_PROCESS;
			pwInstInfo.setType(type);
			WorkInfo workInfo = ModelConverter.getWorkInfoByPackageId(prcInst.getDiagramId());
			pwInstInfo.setWork(workInfo);
			TskTask lastTskTask = ModelConverter.getLastExecutedTskTaskByPrcInstId(prcInst.getObjId());
			TaskInstanceInfo lastTaskInfo = null;
			TaskInstanceInfo runningTaskInfo = null;
			if (lastTskTask != null) {
				pwInstInfo.setLastModifiedDate(new LocalDate(lastTskTask.getExecutionDate().getTime()));//마지막태스크 수행일
				pwInstInfo.setLastModifier(ModelConverter.getUserInfoByUserId(lastTskTask.getAssignee()));//마지막태스크 수행자
				lastTaskInfo = new TaskInstanceInfo();
				String id = lastTskTask.getObjId();
				String subject = lastTskTask.getTitle();
				int tskType = WorkInstance.TYPE_TASK;
				String name = lastTskTask.getName();
				String assignee = lastTskTask.getAssignee();
				String performer = lastTskTask.getAssignee();
				WorkSpaceInfo workSpace = null; //TODO
				int tskStatus = -1;
				if (lastTskTask.getStatus().equalsIgnoreCase(TskTask.TASKSTATUS_ASSIGN)) {
					tskStatus = Instance.STATUS_COMPLETED;
				} else if (lastTskTask.getStatus().equalsIgnoreCase(TskTask.TASKSTATUS_COMPLETE)) {
					tskStatus = Instance.STATUS_COMPLETED;
				}
				UserInfo owner = ModelConverter.getUserInfoByUserId(lastTskTask.getCreationUser());
				UserInfo lastModifier = ModelConverter.getUserInfoByUserId(lastTskTask.getModificationUser()); 
				LocalDate lastModifiedDate = new LocalDate(lastTskTask.getModificationDate().getTime());
				lastTaskInfo.setId(id);
				lastTaskInfo.setLastModifiedDate(lastModifiedDate);
				lastTaskInfo.setLastModifier(lastModifier);
				lastTaskInfo.setOwner(owner);
				lastTaskInfo.setStatus(status);
				lastTaskInfo.setSubject(subject);
				lastTaskInfo.setType(type);
				lastTaskInfo.setWork(workInfo);
				lastTaskInfo.setWorkSpace(workSpace);
				lastTaskInfo.setName(name);
				lastTaskInfo.setTaskType(type);
				lastTaskInfo.setAssignee(ModelConverter.getUserInfoByUserId(assignee));
				lastTaskInfo.setPerformer(ModelConverter.getUserInfoByUserId(performer));
				//WorkInstanceInfo workInstanceInfo = paretProcessInstObj;
				pwInstInfo.setLastTask(lastTaskInfo);//마지막 태스크
			}
			TskTask runningTask = null;
			if (prcInst.getStatus().equalsIgnoreCase(PrcProcessInst.PROCESSINSTSTATUS_RUNNING)) {
				runningTask = ModelConverter.getLastTskTaskByInstanceId(prcInst.getObjId());
				if (runningTask != null) {
					runningTaskInfo = new TaskInstanceInfo();
					String id = runningTask.getObjId();
					String subject = runningTask.getTitle();
					int tskType = WorkInstance.TYPE_TASK;
					String name = runningTask.getName();
					String assignee = runningTask.getAssignee();
					String performer = runningTask.getAssignee();
					WorkSpaceInfo workSpace = null; //TODO
					int tskStatus = -1;
					if (runningTask.getStatus().equalsIgnoreCase(TskTask.TASKSTATUS_ASSIGN)) {
						tskStatus = Instance.STATUS_COMPLETED;
					} else if (runningTask.getStatus().equalsIgnoreCase(TskTask.TASKSTATUS_COMPLETE)) {
						tskStatus = Instance.STATUS_COMPLETED;
					}
					UserInfo owner = ModelConverter.getUserInfoByUserId(lastTskTask.getCreationUser());
					UserInfo lastModifier = ModelConverter.getUserInfoByUserId(lastTskTask.getModificationUser()); 
					LocalDate lastModifiedDate = new LocalDate(lastTskTask.getModificationDate().getTime());
					runningTaskInfo.setId(id);
					runningTaskInfo.setLastModifiedDate(lastModifiedDate);
					runningTaskInfo.setLastModifier(lastModifier);
					runningTaskInfo.setOwner(owner);
					runningTaskInfo.setStatus(status);
					runningTaskInfo.setSubject(subject);
					runningTaskInfo.setType(type);
					runningTaskInfo.setWork(workInfo);
					runningTaskInfo.setWorkSpace(workSpace);
					runningTaskInfo.setName(name);
					runningTaskInfo.setTaskType(type);
					runningTaskInfo.setAssignee(ModelConverter.getUserInfoByUserId(assignee));
					runningTaskInfo.setPerformer(ModelConverter.getUserInfoByUserId(performer));
//					pwInstInfo.setRunningTasks(new TaskInstanceInfo[]{runningTaskInfo});//실행중태스크
				}
			}
			pwInstInfo.setWorkSpace(null);
			pWInstanceInfos[i] = pwInstInfo;
		}
//		instanceInfoList.setInstanceDatas(ModelConverter.getPWInstanceInfoArrayByPrcProcessInstArray(prcInsts));
		instanceInfoList.setInstanceDatas(pWInstanceInfos);
		
		instanceInfoList.setPageSize(pageCount);
		instanceInfoList.setTotalPages((int)totalCount);
		instanceInfoList.setCurrentPage(currentPage);
		instanceInfoList.setTotalPages(InstanceInfoList.TYPE_PROCESS_INSTANCE_LIST);

		return instanceInfoList;
	}

	@Override
	public WorkInstance getWorkInstanceById(String instanceId) throws Exception {
		//TODO 인스턴스로 패키지 타입을 알수가 없다 테이블에 컬럼을 생성하기는 했지만 초기 테스트시에는 데이터가 없기 때문에
		//인스턴스에 diagramId = pkgId 가 있으면 프로세스 업무 없으면 정보관리 업무로 판단한다

		User user = SmartUtil.getCurrentUser();
		PrcProcessInst prcInst = getPrcManager().getProcessInst(user.getId(), instanceId, IManager.LEVEL_LITE);
		if (prcInst == null)
			return null;
		String packageId = prcInst.getDiagramId();
		
		if (!CommonUtil.isEmpty(packageId)) {
			return getProcessWorkInstanceById(user.getCompanyId(), user.getId(), prcInst);
		} else {
			return SmartTest.getWorkInstanceById(instanceId);
		}
	}
	
	public ProcessWorkInstance getProcessWorkInstanceById(String companyId, String userId, PrcProcessInst prcInst) throws Exception {
		
		return ModelConverter.getProcessWorkInstanceByPrcProcessInst(userId, null, prcInst);
		
	}	
}