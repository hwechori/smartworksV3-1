package net.smartworks.server.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import net.smartworks.model.community.User;
import net.smartworks.model.community.info.UserInfo;
import net.smartworks.model.filter.Condition;
import net.smartworks.model.filter.SearchFilter;
import net.smartworks.model.instance.CommentInstance;
import net.smartworks.model.instance.FieldData;
import net.smartworks.model.instance.InformationWorkInstance;
import net.smartworks.model.instance.Instance;
import net.smartworks.model.instance.ProcessWorkInstance;
import net.smartworks.model.instance.RunningCounts;
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
import net.smartworks.model.work.SmartForm;
import net.smartworks.model.work.SmartWork;
import net.smartworks.model.work.info.SmartWorkInfo;
import net.smartworks.model.work.info.WorkCategoryInfo;
import net.smartworks.model.work.info.WorkInfo;
import net.smartworks.server.engine.common.manager.IManager;
import net.smartworks.server.engine.common.model.Filter;
import net.smartworks.server.engine.common.model.Order;
import net.smartworks.server.engine.common.model.Property;
import net.smartworks.server.engine.common.util.CommonUtil;
import net.smartworks.server.engine.common.util.StringUtil;
import net.smartworks.server.engine.docfile.exception.DocFileException;
import net.smartworks.server.engine.docfile.manager.IDocFileManager;
import net.smartworks.server.engine.docfile.model.IFileModel;
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
import net.smartworks.server.engine.process.process.exception.PrcException;
import net.smartworks.server.engine.process.process.manager.IPrcManager;
import net.smartworks.server.engine.process.process.model.PrcProcess;
import net.smartworks.server.engine.process.process.model.PrcProcessCond;
import net.smartworks.server.engine.process.process.model.PrcProcessInst;
import net.smartworks.server.engine.process.process.model.PrcProcessInstCond;
import net.smartworks.server.engine.process.process.model.PrcProcessInstExtend;
import net.smartworks.server.engine.process.task.manager.ITskManager;
import net.smartworks.server.engine.process.task.model.TskTask;
import net.smartworks.server.engine.process.task.model.TskTaskCond;
import net.smartworks.server.engine.process.task.model.TskTaskDef;
import net.smartworks.server.engine.process.task.model.TskTaskDefCond;
import net.smartworks.server.engine.worklist.model.TaskWork;
import net.smartworks.server.engine.worklist.model.TaskWorkCond;
import net.smartworks.server.service.IInstanceService;
import net.smartworks.server.service.util.ModelConverter;
import net.smartworks.util.LocalDate;
import net.smartworks.util.SmartMessage;
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
	 * 
	 * description : 현재사용자의 최근 5개 공지사항을 가져다 주는 서비스..
	 * 
	 * BoardInstanceInfo[] : return
	 */
	@Override
	public BoardInstanceInfo[] getMyRecentBoardInstances() throws Exception {

		try{
			String workId = SmartWork.ID_NOTICE_MANAGEMENT;
	
			User user = SmartUtil.getCurrentUser();
	
			SwdDomainCond swdDomainCond = new SwdDomainCond();
			swdDomainCond.setCompanyId(user.getCompanyId());
	
			SwfFormCond swfFormCond = new SwfFormCond();
			swfFormCond.setCompanyId(user.getCompanyId());
			swfFormCond.setPackageId(workId);
	
			SwfForm[] swfForms = getSwfManager().getForms(user.getId(), swfFormCond, IManager.LEVEL_LITE);
	
			if(swfForms == null)
				return null;
	
			swdDomainCond.setFormId(swfForms[0].getId());
	
			SwdDomain swdDomain = getSwdManager().getDomain(user.getId(), swdDomainCond, IManager.LEVEL_LITE);
	
			if(swdDomain == null)
				return  null;

			SwdRecordCond swdRecordCond = new SwdRecordCond();
			swdRecordCond.setCompanyId(user.getCompanyId());
			swdRecordCond.setFormId(swdDomain.getFormId());
			swdRecordCond.setDomainId(swdDomain.getObjId());
	
			swdRecordCond.setPageNo(0);
			swdRecordCond.setPageSize(5);
	
			swdRecordCond.setOrders(new Order[]{new Order(FormField.ID_CREATED_DATE, false)});
	
			SwdRecord[] swdRecords = getSwdManager().getRecords(user.getId(), swdRecordCond, IManager.LEVEL_LITE);
	
			SwdRecordExtend[] swdRecordExtends = getSwdManager().getCtgPkg(workId);
	
			BoardInstanceInfo[] boardInstanceInfos = null;
	
			String formId = swdDomain.getFormId();
			String formName = swdDomain.getFormName();

			if(swdRecords != null) {
				boardInstanceInfos = new BoardInstanceInfo[swdRecords.length];
				for(int i=0; i < swdRecords.length; i++) {
					SwdRecord swdRecord = swdRecords[i];
					BoardInstanceInfo boardInstanceInfo = new BoardInstanceInfo();
					boardInstanceInfo.setId(swdRecord.getRecordId());
					boardInstanceInfo.setOwner(ModelConverter.getUserInfoByUserId(swdRecord.getCreationUser()));
					boardInstanceInfo.setCreatedDate(new LocalDate((swdRecord.getCreationDate()).getTime()));
					int type = WorkInstance.TYPE_INFORMATION;
					boardInstanceInfo.setType(type);
					boardInstanceInfo.setStatus(WorkInstance.STATUS_COMPLETED);
					boardInstanceInfo.setWorkSpace(null);
	
					WorkCategoryInfo groupInfo = null;
					if (!CommonUtil.isEmpty(swdRecordExtends[0].getSubCtgId()))
						groupInfo = new WorkCategoryInfo(swdRecordExtends[0].getSubCtgId(), swdRecordExtends[0].getSubCtg());
		
					WorkCategoryInfo categoryInfo = new WorkCategoryInfo(swdRecordExtends[0].getParentCtgId(), swdRecordExtends[0].getParentCtg());
		
					WorkInfo workInfo = new SmartWorkInfo(formId, formName, type, groupInfo, categoryInfo);
	
					boardInstanceInfo.setWork(workInfo);
					boardInstanceInfo.setLastModifier(ModelConverter.getUserInfoByUserId(swdRecord.getModificationUser()));
					boardInstanceInfo.setLastModifiedDate(new LocalDate((swdRecord.getModificationDate()).getTime()));
	
					SwdDataField[] swdDataFields = swdRecord.getDataFields();
					for(SwdDataField swdDataField : swdDataFields) {
						String value = swdDataField.getValue();
						if(swdDataField.getId().equals("0")) {
							boardInstanceInfo.setSubject(value);
						} else if(swdDataField.getId().equals("1")) {
							boardInstanceInfo.setBriefContent(StringUtil.subString(value, 0, 44, "..."));
						}
					}
					boardInstanceInfos[i] = boardInstanceInfo;
				}
			}
	
			return boardInstanceInfos;
		}catch (Exception e){
			// Exception Handling Required
			e.printStackTrace();
			return null;			
			// Exception Handling Required
		}
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
		try{
			return SmartTest.getMyRecentInstances();	
			
	//		User user = SmartUtil.getCurrentUser();
	//		if (CommonUtil.isEmpty(user.getCompanyId()) || CommonUtil.isEmpty(user.getId()))
	//			return null;
	//
	//		TskTaskCond taskCond = new TskTaskCond();
	//		taskCond.setAssignee(user.getId());
	//		taskCond.setStatus(TskTask.TASKSTATUS_COMPLETE);
	//		taskCond.setTypeNotIns(TskTask.NOTUSERTASKTYPES);
	//		taskCond.setOrders(new Order[]{new Order("executionDate" , false)});
	//		taskCond.setPageNo(0);
	//		taskCond.setPageSize(50);
	//		
	//		TskTask[] tasks = getTskManager().getTasks(user.getId(), taskCond, IManager.LEVEL_LITE);
	//		if (CommonUtil.isEmpty(tasks))
	//			return null;
	//	
	//		List<String> prcInstIdList = new ArrayList<String>();
	//		for (int i = 0; i < tasks.length; i++) {
	//			TskTask task = tasks[i];
	//			if (prcInstIdList.size() == 10)
	//				break;
	//			if (prcInstIdList.contains(task.getProcessInstId()))
	//				continue;
	//			prcInstIdList.add(task.getProcessInstId());
	//		}
	//		
	//		String[] prcInstIdArray = new String[prcInstIdList.size()];
	//		
	//		prcInstIdList.toArray(prcInstIdArray);
	//		
	//		PrcProcessInstCond prcInstCond = new PrcProcessInstCond();
	//		
	//		prcInstCond.setCompanyId(user.getCompanyId());
	//		prcInstCond.setObjIdIns(prcInstIdArray);
	//		prcInstCond.setOrders(new Order[]{new Order("creationDate" , false)});
	//		
	//		PrcProcessInst[] prcInsts = getPrcManager().getProcessInsts(user.getId(), prcInstCond, IManager.LEVEL_LITE);
	//		
	//		InstanceInfo[] instInfo = ModelConverter.getInstanceInfoArrayByPrcInstArray(prcInsts);
	//		
	//		return instInfo;
		}catch (Exception e){
			// Exception Handling Required
			e.printStackTrace();
			return null;			
			// Exception Handling Required
		}
	}

	@Override
	public Instance getInstanceById(String instanceId) throws Exception {
		try{
			return SmartTest.getInstanceById(instanceId);
		}catch (Exception e){
			// Exception Handling Required
			e.printStackTrace();
			return null;			
			// Exception Handling Required
		}
	}

	/*
	 * 
	 * 현재사용자의 진행중인 업무, 즉 현재사용자에게 할당된 태스크들과 현재사용자가 시작한 업무중 진행중인 업무를 가져다 주는 서비스로,
	 * 인스턴스들중에서 lastModifiedDate가 lastInstacneDate보다 이전것들을 requestSize만큼 sorting 순서를 적용하여 가져다 준다
	 * 
	 * lastInstanceDate : input
	 * 		가져올 인스턴스들의 기준 시점. lastInstanceDate가 null 이면 현재시간을 기준으로 가져다 준다.
	 * 
	 * requestSize : input
	 * 		가져올 인스턴스 갯수
	 * assignedOnly : input
	 * 		가져올 인스턴스 종류.
	 * 		true : 현재사용자의 진행중인 업무중에서 할당된 업무들만 가져온다.
	 * 		false : 현재사용자의 모든 진행중인 업무들을 가져온다..
	 * 
	 * InstanceInfo[] : return
	 * 	
	 */
	public InstanceInfo[] getMyRunningInstances(LocalDate lastInstanceDate, int requestSize, boolean assignedOnly) throws Exception {

		try{
			//정보관리업무에서 파생된 업무는 IWInstanceInfo
			//프로세스 태스크및 프로세스에서 파생된 업무는 PWInstanceInfo
	
			User user = SmartUtil.getCurrentUser();
			if (CommonUtil.isEmpty(user.getCompanyId()) || CommonUtil.isEmpty(user.getId()))
				return null;
	
			TaskWorkCond taskCond = new TaskWorkCond();
			if (assignedOnly)
				taskCond.setTskStatus(TskTask.TASKSTATUS_ASSIGN);
			if (lastInstanceDate != null) {
				taskCond.setLastInstanceDate(lastInstanceDate);
			} else {
				taskCond.setLastInstanceDate(new LocalDate());
			}
			taskCond.setTskAssignee(user.getId());
			taskCond.setPageNo(0);
			taskCond.setPageSize(requestSize);
			
			taskCond.setOrders(new Order[]{new Order("tskCreatedate", false)});
			
			TaskWork[] tasks = SwManagerFactory.getInstance().getWorkListManager().getTaskWorkList(user.getId(), taskCond);
			
			if(tasks != null) return ModelConverter.getInstanceInfoArrayByTaskWorkArray(user.getId(), tasks);
			return null;
		}catch (Exception e){
			// Exception Handling Required
			e.printStackTrace();
			return null;			
			// Exception Handling Required			
		}
	}

	/*
	 * 
	 * 현재사용자의 진행중인 업무들의 갯수를 가져도준다. 진행중인 업무 전체갯수와 할당된업무갯수만을 가져다 준다.
	 * 
	 * RunningCounts : return
	 * 	
	 */
	public RunningCounts getMyRunningInstancesCounts() throws Exception {
		
		try{
			User user = SmartUtil.getCurrentUser();
			if (CommonUtil.isEmpty(user.getCompanyId()) || CommonUtil.isEmpty(user.getId()))
				return null;
			
			TaskWorkCond taskCond = new TaskWorkCond();
			taskCond.setTskAssignee(user.getId());
			taskCond.setLastInstanceDate(new LocalDate());
			
			long totalTaskSize = SwManagerFactory.getInstance().getWorkListManager().getTaskWorkListSize(user.getId(), taskCond);
			
			taskCond.setTskStatus(TskTask.TASKSTATUS_ASSIGN);
			
			long assignedTaskSize = SwManagerFactory.getInstance().getWorkListManager().getTaskWorkListSize(user.getId(), taskCond);
			
			RunningCounts runningCounts = new RunningCounts();
			runningCounts.setTotal((int)totalTaskSize);
			runningCounts.setAssignedOnly((int)assignedTaskSize);
			return runningCounts;
		}catch (Exception e){
			// Exception Handling Required
			e.printStackTrace();
			return null;			
			// Exception Handling Required
		}
	}

	@Override
	public InstanceInfo[] searchMyRunningInstance(String key) throws Exception {
		try{
			return SmartTest.getRunningInstances();
		}catch (Exception e){
			// Exception Handling Required
			e.printStackTrace();
			return null;			
			// Exception Handling Required			
		}
	}

	@Override
	public String  setMemoInstance(HttpServletRequest request) throws Exception {		
		try{
			return "testId";
		}catch (Exception e){
			// Exception Handling Required
			e.printStackTrace();
			return null;			
			// Exception Handling Required			
		}
	}

	private SwdRecord getSwdRecordByJsonFormData(Map<String, Object> jsonFormDataMap) throws Exception {
		try{
			return null;
		}catch (Exception e){
			// Exception Handling Required
			e.printStackTrace();
			return null;			
			// Exception Handling Required			
		}
	}
	public SwdRecord refreshDataFields(Map<String, Object> requestBody) throws Exception {
		
		try{
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
	
			//새로 값이 셋팅되어 변경될 레코드 클론
			SwdRecord oldRecord = (SwdRecord)record.clone();
			SwdRecord newRecord = (SwdRecord)record.clone();
	
			
			
			// 각 필드들 마다 가져오기 맵핑을 확인하여 값을 셋팅한다
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
					//초기 데이터 가져오기 호출이 아니고 매번호출이 아니라면 스킵
					//초기 데이터 가져오기내용 검토 필요(초기인지 아닌지 알수 있나?)
					if (!isFirstSetMode && !preMapping.isEachTime())
						continue;
	
					String mappingType = preMapping.getType();
	//				mappingType = TYPE_SIMPLE = "mapping_form"; 단순 맵핑
	//				mappingTYpe = TYPE_EXPRESSION = "expression"; 계산식
					
					if (SwfMapping.TYPE_SIMPLE.equalsIgnoreCase(mappingType)) {
						//단순 맵핑 (현재업무화면, 다른업무화면, 프로세스업무화면, 시스템함수, 웹서비스)
						String mappingFormType = preMapping.getMappingFormType();
						if (CommonUtil.isEmpty(mappingFormType))
							continue;
						// 현재업무항목
						if (SwfMapping.MAPPINGTYPE_SELFFORM.equalsIgnoreCase(mappingFormType)) {
							
							
						} 
						
					} else if (SwfMapping.TYPE_EXPRESSION.equalsIgnoreCase(mappingType)) {
						//계산식
						
						
					}
					
					
					
				}
			}
			
			return null; 
		}catch (Exception e){
			// Exception Handling Required
			e.printStackTrace();
			return null;			
			// Exception Handling Required			
		}
	}
	private void setResultFieldMapByFields(String userId, Map<String, Object> resultMap, SwfField field, SwdRecord oldRecord) throws Exception {
		
		try{
			SwfMappings mappings = field.getMappings();
			if (mappings == null)
				return;
			SwfMapping[] preMappings = mappings.getPreMappings();
			if (CommonUtil.isEmpty(preMappings))
				return;
			// 가져오기 매핑정의가 있는지 확인 끝
	
			String fieldId = field.getId();
			String fieldType = field.getSystemType();
			
			//가져오기 셋팅이 여러개 일수 있다
			for (SwfMapping preMapping : preMappings) {
				//초기 데이터 가져오기 호출이 아니고 매번호출이 아니라면 스킵
				//초기 데이터 가져오기내용 검토 필요(초기인지 아닌지 알수 있나?)
				if (!preMapping.isEachTime())
					continue;
	
				String mappingType = preMapping.getType();
	//			mappingType = TYPE_SIMPLE = "mapping_form"; 단순 맵핑
	//			mappingTYpe = TYPE_EXPRESSION = "expression"; 계산식
				
				if (SwfMapping.TYPE_SIMPLE.equalsIgnoreCase(mappingType)) {
					//단순 맵핑 (현재업무화면, 다른업무화면, 프로세스업무화면, 시스템함수, 웹서비스)
					String mappingFormType = preMapping.getMappingFormType();
					if (CommonUtil.isEmpty(mappingFormType))
						continue;
					// 현재업무항목
					if (SwfMapping.MAPPINGTYPE_SELFFORM.equalsIgnoreCase(mappingFormType)) {
						
						
						//현재 업무 항목이라면 재귀 함수호출로 호출되는쪽의 데이터 맵핑이 있는지를 다시 살핀다
						
						
						
						
					} 
					
				} else if (SwfMapping.TYPE_EXPRESSION.equalsIgnoreCase(mappingType)) {
					//계산식
					
					
				}
				
				
				
			}
		
		}catch (Exception e){
			// Exception Handling Required
			e.printStackTrace();
			// Exception Handling Required			
		}
	}	
	public String setInformationWorkInstance_old(Map<String, Object> requestBody, HttpServletRequest request) throws Exception {
		
		try{
			/*
			Key Set : frmSmartForm
			Key Set : frmScheduleWork
			Key Set : frmAccessSpace
			key Set : formId
			key Set : formName
			*/
			Map<String, Object> smartFormInfoMap = (Map<String, Object>)requestBody.get("frmSmartForm");
	
			String domainId = null; // domainId 가 없어도 내부 서버에서 폼아이디로 검색하여 저장
			String formId = (String)requestBody.get("formId");
			String formName = (String)requestBody.get("formName");
			String instanceId = (String)requestBody.get("instanceId");
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
			
			Set<String> keySet = smartFormInfoMap.keySet();
			Iterator<String> itr = keySet.iterator();
			
	//		SwdField[] fieldDatas = new SwdField[keySet.size()];
			List fieldDataList = new ArrayList();
			List<Map<String, String>> files = null;
			List<Map<String, String>> users = null;
			String groupId = null;
			while (itr.hasNext()) {
				String fieldId = (String)itr.next();
				String value = null;
				String refForm = null;
				String refFormField = null;
				String refRecordId = null;
				Object fieldValue = smartFormInfoMap.get(fieldId);
				if (fieldValue instanceof LinkedHashMap) {
					Map<String, Object> valueMap = (Map<String, Object>)fieldValue;
					groupId = (String)valueMap.get("groupId");
					refForm = (String)valueMap.get("refForm");
					users = (ArrayList<Map<String,String>>)valueMap.get("users");
	
					if(!CommonUtil.isEmpty(groupId)) {
						files = (ArrayList<Map<String,String>>)valueMap.get("files");
						if(files != null && files.size() > 0)
							value = groupId;
					} else if(!CommonUtil.isEmpty(refForm)) {
						refFormField = (String)valueMap.get("refFormField");
						refRecordId = (String)valueMap.get("refRecordId");
						SwoDepartmentCond swoDepartmentCond = new SwoDepartmentCond();
						swoDepartmentCond.setId(refRecordId);
						String deptName = getSwoManager().getDepartment(userId, swoDepartmentCond, IManager.LEVEL_LITE).getName();
						value = deptName;
					} else if(!CommonUtil.isEmpty(users)) {
						refFormField = "frm_user_SYSTEM"; 
						String resultRefRecordId = "";
						String resultValue = "";
						String symbol = ";";
						if(users.size() == 1) {
							resultRefRecordId = users.get(0).get("id");
							resultValue = users.get(0).get("name");
						} else {
							for(int i=0; i < users.subList(0, users.size()).size(); i++) {
								Map<String, String> user = users.get(i);
								resultRefRecordId += user.get("id") + symbol;
								resultValue += user.get("name") + symbol;
							}
						}
						refRecordId = resultRefRecordId;
						value = resultValue;
					}
				} else if(fieldValue instanceof String) {
					value = (String)smartFormInfoMap.get(fieldId);
					if(formId.equals(SmartForm.ID_MEMO_MANAGEMENT)) {
						if(fieldId.equals("12"))
							value = StringUtil.subString(value, 0, 20, "...");
					} else if(formId.equals(SmartForm.ID_EVENT_MANAGEMENT)) {
						if(fieldId.equals("1") || fieldId.equals("2")) {
							if(!value.isEmpty())
								value = LocalDate.convertStringToLocalDate(value).toGMTDateString();
						}
					}
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
			obj.setRecordId(instanceId);
	
			String returnInstanceId = getSwdManager().setRecord(userId, obj, IManager.LEVEL_ALL);
	
			if(files != null && files.size() > 0) {
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
			}
	
			return returnInstanceId;
		}catch (Exception e){
			// Exception Handling Required
			e.printStackTrace();
			return null;			
			// Exception Handling Required			
		}
	}
	@Override
	public String setInformationWorkInstance(Map<String, Object> requestBody, HttpServletRequest request) throws Exception {

		try{
			/*
			Key Set : frmSmartForm
			Key Set : frmScheduleWork
			Key Set : frmAccessSpace
			key Set : formId
			key Set : formName
			*/
			Map<String, Object> smartFormInfoMap = (Map<String, Object>)requestBody.get("frmSmartForm");
	
			String domainId = null; // domainId 가 없어도 내부 서버에서 폼아이디로 검색하여 저장
			String formId = (String)requestBody.get("formId");
			String formName = (String)requestBody.get("formName");
			String instanceId = (String)requestBody.get("instanceId");
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
	
			Set<String> keySet = smartFormInfoMap.keySet();
			Iterator<String> itr = keySet.iterator();
			
	//		SwdField[] fieldDatas = new SwdField[keySet.size()];
			List fieldDataList = new ArrayList();
			List<Map<String, String>> files = null;
			List<Map<String, String>> users = null;
			String groupId = null;
			while (itr.hasNext()) {
				String fieldId = (String)itr.next();
				String value = null;
				String type = null;
				String refForm = null;
				String refFormField = null;
				String refRecordId = null;
				Object fieldValue = smartFormInfoMap.get(fieldId);
				if (fieldValue instanceof LinkedHashMap) {
					Map<String, Object> valueMap = (Map<String, Object>)fieldValue;
					groupId = (String)valueMap.get("groupId");
					refForm = (String)valueMap.get("refForm");
					users = (ArrayList<Map<String,String>>)valueMap.get("users");
	
					if(!CommonUtil.isEmpty(groupId)) {
						files = (ArrayList<Map<String,String>>)valueMap.get("files");
						if(files != null && files.size() > 0)
							value = groupId;
					} else if(!CommonUtil.isEmpty(refForm)) {
						refFormField = (String)valueMap.get("refFormField");
						refRecordId = (String)valueMap.get("refRecordId");
						SwoDepartmentCond swoDepartmentCond = new SwoDepartmentCond();
						swoDepartmentCond.setId(refRecordId);
						String deptName = getSwoManager().getDepartment(userId, swoDepartmentCond, IManager.LEVEL_LITE).getName();
						value = deptName;
					} else if(!CommonUtil.isEmpty(users)) {
						refForm = "frm_user_SYSTEM";
						refFormField = "4";
						String resultRefRecordId = "";
						String resultValue = "";
						String symbol = ";";
						if(users.size() == 1) {
							resultRefRecordId = users.get(0).get("id");
							resultValue = users.get(0).get("name");
						} else {
							for(int i=0; i < users.subList(0, users.size()).size(); i++) {
								Map<String, String> user = users.get(i);
								resultRefRecordId += user.get("id") + symbol;
								resultValue += user.get("name") + symbol;
							}
						}
						refRecordId = resultRefRecordId;
						value = resultValue;
					}
				} else if(fieldValue instanceof String) {
					value = (String)smartFormInfoMap.get(fieldId);
					type = fieldInfoMap.get(fieldId).getFormFieldType();
					if(!value.equals("")) {
						if(formId.equals(SmartForm.ID_MEMO_MANAGEMENT)) {
							if(fieldId.equals("12"))
								value = StringUtil.subString(value, 0, 20, "...");
						} else if(formId.equals(SmartForm.ID_EVENT_MANAGEMENT)) {
							if(fieldId.equals("1") || fieldId.equals("2")) {
								if(!value.isEmpty())
									value = LocalDate.convertStringToLocalDate(value).toGMTDateString();
							}
						}
						if(type.equals("datetime"))
							if(value.length() == FieldData.SIZE_DATETIME)
								value = LocalDate.convertLocalDateTimeStringToLocalDate(value).toGMTDateString();
							else if(value.length() == FieldData.SIZE_DATE)
								value = LocalDate.convertLocalDateStringToLocalDate(value).toGMTDateString();
						else if(type.equals("time"))
							value = LocalDate.convertLocalTimeStringToLocalDate(value).toGMTTimeString();
					}
				} else if(fieldValue instanceof Integer) {
					value = (Integer)smartFormInfoMap.get(fieldId) + "";
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
			obj.setRecordId(instanceId);
	
			String returnInstanceId = getSwdManager().setRecord(userId, obj, IManager.LEVEL_ALL);
	
			if(files != null && files.size() > 0) {
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
			}
	
			return returnInstanceId;
		}catch (Exception e){
			// Exception Handling Required
			e.printStackTrace();
			return null;			
			// Exception Handling Required			
		}
	}

	@Override
	public void removeInformationWorkInstance(Map<String, Object> requestBody, HttpServletRequest request) throws Exception {

		try{
			String workId = (String)requestBody.get("workId");
			String instanceId = (String)requestBody.get("instanceId");
	
			User user = SmartUtil.getCurrentUser();
			SwfFormCond swfFormCond = new SwfFormCond();
			swfFormCond.setCompanyId(user.getCompanyId());
			swfFormCond.setPackageId(workId);
	
			SwfForm[] swfForms = getSwfManager().getForms(user.getId(), swfFormCond, IManager.LEVEL_LITE);
	
			SwdRecordCond swdRecordCond = new SwdRecordCond();
			swdRecordCond.setPackageId(workId);
			swdRecordCond.setFormId(swfForms[0].getId());
			swdRecordCond.setRecordId(instanceId);
	
			getSwdManager().removeRecord(user.getId(), swdRecordCond);
		}catch (Exception e){
			// Exception Handling Required
			e.printStackTrace();
			// Exception Handling Required			
		}
	}

	private SwdRecord getSwdRecordByRequestBody_old(String userId, SwdField[] swdFields, Map<String, Object> requestBody, HttpServletRequest request) throws Exception {
		
		try{
			if (CommonUtil.isEmpty(swdFields))
				return null;//TODO return null? throw new Exception??
	
			Map<String, Object> smartFormInfoMap = (Map<String, Object>)requestBody.get("frmSmartForm");
	
			String domainId = null; // domainId 가 없어도 내부 서버에서 폼아이디로 검색하여 저장
			String formId = (String)requestBody.get("formId");
			String formName = (String)requestBody.get("formName");
			String instanceId = (String)requestBody.get("instanceId");
			int formVersion = 1;
			
			Map<String, SwdField> fieldInfoMap = new HashMap<String, SwdField>();
			for (SwdField field : swdFields) {
				fieldInfoMap.put(field.getFormFieldId(), field);
			}
			
			Set<String> keySet = smartFormInfoMap.keySet();
			Iterator<String> itr = keySet.iterator();
			
	//		SwdField[] fieldDatas = new SwdField[keySet.size()];
			List fieldDataList = new ArrayList();
			List<Map<String, String>> files = null;
			List<Map<String, String>> users = null;
			String groupId = null;
			while (itr.hasNext()) {
				String fieldId = (String)itr.next();
				String value = null;
				String refForm = null;
				String refFormField = null;
				String refRecordId = null;
				Object fieldValue = smartFormInfoMap.get(fieldId);
				if (fieldValue instanceof LinkedHashMap) {
					Map<String, Object> valueMap = (Map<String, Object>)fieldValue;
					groupId = (String)valueMap.get("groupId");
					refForm = (String)valueMap.get("refForm");
					users = (ArrayList<Map<String,String>>)valueMap.get("users");
	
					if(!CommonUtil.isEmpty(groupId)) {
						files = (ArrayList<Map<String,String>>)valueMap.get("files");
						if(files != null && files.size() > 0)
							value = groupId;
					} else if(!CommonUtil.isEmpty(refForm)) {
						refFormField = (String)valueMap.get("refFormField");
						refRecordId = (String)valueMap.get("refRecordId");
						SwoDepartmentCond swoDepartmentCond = new SwoDepartmentCond();
						swoDepartmentCond.setId(refRecordId);
						String deptName = getSwoManager().getDepartment(userId, swoDepartmentCond, IManager.LEVEL_LITE).getName();
						value = deptName;
					} else if(!CommonUtil.isEmpty(users)) {
						refFormField = "frm_user_SYSTEM"; 
						String resultRefRecordId = "";
						String resultValue = "";
						String symbol = ";";
						if(users.size() == 1) {
							resultRefRecordId = users.get(0).get("id");
							resultValue = users.get(0).get("name");
						} else {
							for(int i=0; i < users.subList(0, users.size()).size(); i++) {
								Map<String, String> user = users.get(i);
								resultRefRecordId += user.get("id") + symbol;
								resultValue += user.get("name") + symbol;
							}
						}
						refRecordId = resultRefRecordId;
						value = resultValue;
					}
				} else if(fieldValue instanceof String) {
					value = (String)smartFormInfoMap.get(fieldId);
					if(formId.equals(SmartForm.ID_MEMO_MANAGEMENT)) {
						if(fieldId.equals("12"))
							value = StringUtil.subString(value, 0, 20, "...");
					} else if(formId.equals(SmartForm.ID_EVENT_MANAGEMENT)) {
						if(fieldId.equals("1") || fieldId.equals("2")) {
							if(!value.isEmpty())
								value = LocalDate.convertStringToLocalDate(value).toGMTDateString();
						}
					}
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
			obj.setRecordId(instanceId);
	
			if(files != null && files.size() > 0) {
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
			}
			
			return obj;
		}catch (Exception e){
			// Exception Handling Required
			e.printStackTrace();
			return null;			
			// Exception Handling Required			
		}
	}
		
	private SwdRecord getSwdRecordByRequestBody(String userId, SwdField[] swdFields, Map<String, Object> requestBody, HttpServletRequest request) throws Exception {
		try{
			if (CommonUtil.isEmpty(swdFields))
				return null;//TODO return null? throw new Exception??
	
			Map<String, Object> smartFormInfoMap = (Map<String, Object>)requestBody.get("frmSmartForm");
	
			String domainId = null; // domainId 가 없어도 내부 서버에서 폼아이디로 검색하여 저장
			String formId = (String)requestBody.get("formId");
			String formName = (String)requestBody.get("formName");
			String instanceId = (String)requestBody.get("instanceId");
			int formVersion = 1;
			
			Map<String, SwdField> fieldInfoMap = new HashMap<String, SwdField>();
			for (SwdField field : swdFields) {
				fieldInfoMap.put(field.getFormFieldId(), field);
			}
			
			Set<String> keySet = fieldInfoMap.keySet();
			Iterator<String> itr = keySet.iterator();
			
	//		SwdField[] fieldDatas = new SwdField[keySet.size()];
			List fieldDataList = new ArrayList();
			List<Map<String, String>> files = null;
			List<Map<String, String>> users = null;
			String groupId = null;
			while (itr.hasNext()) {
				String fieldId = (String)itr.next();
				String value = null;
				String refForm = null;
				String refFormField = null;
				String refRecordId = null;
				SwdField fieldTemp = fieldInfoMap.get(fieldId);
				if (fieldTemp.getFormFieldType().equalsIgnoreCase("boolean")) {
					value = "false";
				}
				
				Object fieldValue = smartFormInfoMap.get(fieldId);
				if (fieldValue instanceof LinkedHashMap) {
					Map<String, Object> valueMap = (Map<String, Object>)fieldValue;
					groupId = (String)valueMap.get("groupId");
					refForm = (String)valueMap.get("refForm");
					users = (ArrayList<Map<String,String>>)valueMap.get("users");
	
					if(!CommonUtil.isEmpty(groupId)) {
						files = (ArrayList<Map<String,String>>)valueMap.get("files");
						if(files != null && files.size() > 0)
							value = groupId;
					} else if(!CommonUtil.isEmpty(refForm)) {
						refFormField = (String)valueMap.get("refFormField");
						refRecordId = (String)valueMap.get("refRecordId");
						SwoDepartmentCond swoDepartmentCond = new SwoDepartmentCond();
						swoDepartmentCond.setId(refRecordId);
						String deptName = getSwoManager().getDepartment(userId, swoDepartmentCond, IManager.LEVEL_LITE).getName();
						value = deptName;
					} else if(!CommonUtil.isEmpty(users)) {
						refFormField = "frm_user_SYSTEM"; 
						String resultRefRecordId = "";
						String resultValue = "";
						String symbol = ";";
						if(users.size() == 1) {
							resultRefRecordId = users.get(0).get("id");
							resultValue = users.get(0).get("name");
						} else {
							for(int i=0; i < users.subList(0, users.size()).size(); i++) {
								Map<String, String> user = users.get(i);
								resultRefRecordId += user.get("id") + symbol;
								resultValue += user.get("name") + symbol;
							}
						}
						refRecordId = resultRefRecordId;
						value = resultValue;
					}
				} else if(fieldValue instanceof String) {
					value = (String)smartFormInfoMap.get(fieldId);
					if(formId.equals(SmartForm.ID_MEMO_MANAGEMENT)) {
						if(fieldId.equals("12"))
							value = StringUtil.subString(value, 0, 20, "...");
					} else if(formId.equals(SmartForm.ID_EVENT_MANAGEMENT)) {
						if(fieldId.equals("1") || fieldId.equals("2")) {
							if(!value.isEmpty())
								value = LocalDate.convertStringToLocalDate(value).toGMTDateString();
						}
					}
				}
	//			if (CommonUtil.isEmpty(value))
	//				continue;
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
			obj.setRecordId(instanceId);
	
			if(files != null && files.size() > 0) {
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
			}
			
			return obj;
		}catch (Exception e){
			// Exception Handling Required
			e.printStackTrace();
			return null;			
			// Exception Handling Required			
		}
	}
	@Override
	public String startProcessWorkInstance(Map<String, Object> requestBody, HttpServletRequest request) throws Exception {
		/*{
			"workId":"pkg_cf3b0087995f4f99a41c93e2fe95b22d",
			"formId":"frm_c19b1fe4bceb4732acbb8a4cd2a57474",
			"formName":"기안품의",
			"frmSmartForm":
				{
					"4":
						{
							"users":
								[
									{
										"id":"kmyu@maninsoft.co.kr",
										"name":"\n\t\t\t\t\t\t\t\t연구소장 유광민\n\t\t\t\t\t\t\t"
									}
								]
						},
					"16":
						{
							"users":
								[
									{
										"id":"kmyu@maninsoft.co.kr",
										"name":"\n\t\t\t\t\t\t\t\t연구소장 유광민\n\t\t\t\t\t\t\t"
									}
								]
						},
					"92":"1",
					"535":"1"
				},
			"frmScheduleWork":
				{
				},
			"frmAccessSpace":
				{
					"selWorkSpace":"kmyu@maninsoft.co.kr",
					"selWorkSpaceType": 4(ISmartWorks.java 에 정의 되어 있음), 
					"selAccessLevel":"3",
					"txtAccessableUsers":
						{
							"users":
								[
								]
						}
				}
			}*/

		try{
			User cuser = SmartUtil.getCurrentUser();
			String userId = null;
			if (cuser != null)
				userId = cuser.getId();
			
			//패키지 정보로 프로세스 정보를 얻는다.
			String packageId = (String)requestBody.get("workId");
			String formId = (String)requestBody.get("formId");
			PrcProcessCond cond = new PrcProcessCond();
			cond.setDiagramId(packageId);
			PrcProcess[] prcs = getPrcManager().getProcesses(userId, cond, IManager.LEVEL_LITE);
			if (prcs == null || prcs.length != 1)
				throw new PrcException("Start Process Is Null Or More then 1");
			PrcProcess prc = prcs[0];
			String processId = prc.getProcessId();
			
			//패키지 정보로 프로세스 첫번째 taskdef를 찾는다
			Property[] extProps = new Property[] {new Property("processId", processId), new Property("startActivity", "true")};
			TskTaskDefCond taskCond = new TskTaskDefCond();
			taskCond.setExtendedProperties(extProps);
			TskTaskDef[] taskDefs = getTskManager().getTaskDefs(userId, taskCond, IManager.LEVEL_LITE);
			if (CommonUtil.isEmpty(taskDefs))
				throw new Exception(new StringBuffer("No start activity. -> processId:").append(processId).toString());
			TskTaskDef taskDef = taskDefs[0];
			String taskDefId = taskDef.getObjId();
			
			//넘어온 frmSamrtForm 정보로 레코드를 생성한다
			SwfForm form = getSwfManager().getForm(userId, formId);
			SwfField[] formFields = form.getFields();
			List domainFieldList = new ArrayList();
			
			//제목으로 사용할 필드 (필수>단문>첫번째)
			List requiredFieldIdList = new ArrayList();
			List textInputFieldIdList = new ArrayList();
			for (SwfField field: formFields) {
				//제목으로 사용할 필드 (필수>단문>첫번째)
				if (field.isRequired() && field.getFormat().getType().equals("textInput"))
					requiredFieldIdList.add(field.getId());
				//제목으로 사용할 필드 (필수>단문>첫번째)
				if (field.getFormat().getType().equals("textInput"))
					textInputFieldIdList.add(field.getId());
				SwdField domainField = new SwdField();
				domainField.setFormFieldId(field.getId());
				domainField.setFormFieldName(field.getName());
				domainField.setFormFieldType(field.getSystemType());
				domainField.setArray(field.isArray());
				domainField.setSystemField(field.isSystem());
				domainFieldList.add(domainField);
			}
			SwdField[] domainFields = new SwdField[domainFieldList.size()];
			domainFieldList.toArray(domainFields);
			
			SwdRecord recordObj = getSwdRecordByRequestBody(userId, domainFields, requestBody, request);
			String taskDocument = null;
			if (recordObj != null)
				taskDocument = recordObj.toString();
			
			//TODO 참조자, 전자결재, 연결업무 정보를 셋팅한다
			
			String title = null;
			if (requiredFieldIdList.size() != 0) {
				for (int i = 0; i < requiredFieldIdList.size(); i++) {
					String temp = recordObj.getDataFieldValue((String)requiredFieldIdList.get(i));
					if (!CommonUtil.isEmpty(temp)) {
						title = temp;
						break;
					}
				}
			} else {
				for (int i = 0; i < textInputFieldIdList.size(); i++) {
					String temp = recordObj.getDataFieldValue((String)textInputFieldIdList.get(i));
					if (!CommonUtil.isEmpty(temp)) {
						title = temp;
						break;
					}
					
				}
			}
			
			//태스크를 생성하여 실행한다
			TskTask task = new TskTask();
			task.setType(taskDef.getType());
			task.setName(taskDef.getName());
			task.setTitle(CommonUtil.toDefault(title, taskDef.getName() + "(No Title) - " + new LocalDate()));
			task.setAssignee(userId);
			task.setAssigner(userId);
			task.setForm(taskDef.getForm());
			task.setDef(taskDef.getObjId());
			task.setIsStartActivity("true");
			
			Map<String, Object> frmAccessSpace = (Map<String, Object>)requestBody.get("frmAccessSpace");
			String workSpaceId = (String)frmAccessSpace.get("selWorkSpace");
			String workSpaceType = (String)frmAccessSpace.get("selWorkSpaceType");
			task.setWorkSpaceId(workSpaceId);
			task.setWorkSpaceType(workSpaceType);
			
			task.setDocument(taskDocument);
			
			//date to localdate - Date now = new Date();
			LocalDate now = new LocalDate();
			task.setExpectStartDate(new LocalDate(now.getTime()));
			task.setRealStartDate(new LocalDate(now.getTime()));
			//date to localdate - Date expectEndDate = new Date();
			LocalDate expectEndDate = new LocalDate();
			if (taskDef != null &&  !CommonUtil.isEmpty(taskDef.getDueDate())) {
				//dueDate 는 분단위로 설정이 되어 있다
				expectEndDate.setTime(new LocalDate(now.getTime() + ((Long.parseLong(taskDef.getDueDate())) * 60 * 1000)).getTime());
			} else {
				expectEndDate.setTime(new LocalDate(now.getTime() + 1800000).getTime());
			}
			task.setExpectEndDate(expectEndDate);
			task = getTskManager().executeTask(userId, task, "execute");
			
			return task.getProcessInstId();
		}catch (Exception e){
			// Exception Handling Required
			e.printStackTrace();
			return null;			
			// Exception Handling Required			
		}
	}

	@Override
	public String setFileInstance(HttpServletRequest request) throws Exception {
		try{
			return "testId";
		}catch (Exception e){
			// Exception Handling Required
			e.printStackTrace();
			return null;			
			// Exception Handling Required			
		}
	}

	@Override
	public String setEventInstance(HttpServletRequest request) throws Exception {
		try{
			return "testId";		
		}catch (Exception e){
			// Exception Handling Required
			e.printStackTrace();
			return null;			
			// Exception Handling Required			
		}
	}

	@Override
	public String setBoardInstance(HttpServletRequest request) throws Exception {
		try{
			return "testId";		
		}catch (Exception e){
			// Exception Handling Required
			e.printStackTrace();
			return null;			
			// Exception Handling Required			
		}
	}

	@Override
	public CommentInstance[] getRecentCommentsInWorkManual(String workId, int length) throws Exception {
		try{
			return SmartTest.getCommentInstances();
		}catch (Exception e){
			// Exception Handling Required
			e.printStackTrace();
			return null;			
			// Exception Handling Required			
		}
	}

	int previousPageSize = 0;
	@Override
	public InstanceInfoList getIWorkInstanceList(String workId, RequestParams params) throws Exception {

		try{
			User user = SmartUtil.getCurrentUser();
	
			SwdDomainCond swdDomainCond = new SwdDomainCond();
			swdDomainCond.setCompanyId(user.getCompanyId());
	
			SwfFormCond swfFormCond = new SwfFormCond();
			swfFormCond.setCompanyId(user.getCompanyId());
			swfFormCond.setPackageId(workId);
	
			swdDomainCond.setFormId(getSwfManager().getForms(user.getId(), swfFormCond, IManager.LEVEL_LITE)[0].getId());

			SwdDomain swdDomain = getSwdManager().getDomain(user.getId(), swdDomainCond, IManager.LEVEL_LITE);

			if(swdDomain == null)
				return null;

			SwdRecordCond swdRecordCond = new SwdRecordCond();
			swdRecordCond.setCompanyId(user.getCompanyId());
			swdRecordCond.setFormId(swdDomain.getFormId());
			swdRecordCond.setDomainId(swdDomain.getObjId());

			String filterId = params.getFilterId();

			LocalDate priviousDate = new LocalDate(new LocalDate().getTime() - LocalDate.ONE_DAY*7);

			if(filterId != null) {
				if(filterId.equals(SearchFilter.FILTER_ALL_INSTANCES)) {
				} else if(filterId.equals(SearchFilter.FILTER_MY_INSTANCES)) {
					swdRecordCond.addFilter(new Filter("=", FormField.ID_LAST_MODIFIER, Filter.OPERANDTYPE_STRING, user.getId()));
				} else if(filterId.equals(SearchFilter.FILTER_RECENT_INSTANCES)) {
					swdRecordCond.addFilter(new Filter(">=", FormField.ID_LAST_MODIFIED_DATE, Filter.OPERANDTYPE_DATE, priviousDate.toGMTSimpleDateString()));
				} else if(filterId.equals(SearchFilter.FILTER_MY_RECENT_INSTANCES)) {
					swdRecordCond.addFilter(new Filter("=", FormField.ID_LAST_MODIFIER, Filter.OPERANDTYPE_STRING, user.getId()));
					swdRecordCond.addFilter(new Filter(">=", FormField.ID_LAST_MODIFIED_DATE, Filter.OPERANDTYPE_DATE, priviousDate.toGMTSimpleDateString()));
				}
			}

			String searchKey = params.getSearchKey();
			SortingField sf = params.getSortingField();
			SearchFilter searchFilter = params.getSearchFilter();
			List<Filter> filterList = new ArrayList<Filter>();
			if(searchFilter != null) {
				Condition[] conditions = searchFilter.getConditions();
				for(Condition condition : conditions) {
					Filter filter = new Filter();
	
					FormField leftOperand = condition.getLeftOperand();
					String formFieldId = leftOperand.getId();
					String tableColName = getSwdManager().getTableColName(swdDomain.getObjId(), formFieldId);
					String formFieldType = leftOperand.getType();
					String operator = condition.getOperator();
					String rightOperand = (String)condition.getRightOperand();

					filter.setLeftOperandType(formFieldType);
					filter.setLeftOperandValue(tableColName);
					filter.setOperator(operator);
					filter.setRightOperandType(formFieldType);
					filter.setRightOperandValue(rightOperand);
					filterList.add(filter);
				}

				Filter[] filters = new Filter[filterList.size()];
				filterList.toArray(filters);
	
				swdRecordCond.setFilter(filters);
			}

			if(!CommonUtil.isEmpty(searchKey))
				swdRecordCond.setSearchKey(searchKey);

			long totalCount = getSwdManager().getRecordSize(user.getId(), swdRecordCond);

			String columnName = "";
			boolean isAsc;

			if (sf != null) {
				columnName  = CommonUtil.toDefault(sf.getFieldId(), FormField.ID_LAST_MODIFIED_DATE);
				isAsc = sf.isAscending();
			} else {
				columnName = FormField.ID_LAST_MODIFIED_DATE;
				isAsc = false;
			}
			SortingField sortingField = new SortingField();
			sortingField.setFieldId(columnName);
			sortingField.setAscending(isAsc);

			swdRecordCond.setOrders(new Order[]{new Order(columnName, isAsc)});

			int pageSize = params.getPageSize();

			int currentPage = params.getCurrentPage();

			if(previousPageSize != pageSize)
				currentPage = 1;

			previousPageSize = pageSize;

			if((long)((pageSize * (currentPage - 1)) + 1) > totalCount)
				currentPage = 1;

			int totalPages = (int)totalCount % pageSize;

			if(totalPages == 0)
				totalPages = (int)totalCount / pageSize;
			else
				totalPages = (int)totalCount / pageSize + 1;

			int result = 0;

			if(params.getPagingAction() != 0) {
				if(params.getPagingAction() == RequestParams.PAGING_ACTION_NEXT10) {
					result = (((currentPage - 1) / 10) * 10) + 11;
				} else if(params.getPagingAction() == RequestParams.PAGING_ACTION_NEXTEND) {
					result = totalPages;
				} else if(params.getPagingAction() == RequestParams.PAGING_ACTION_PREV10) {
					result = ((currentPage - 1) / 10) * 10;
				} else if(params.getPagingAction() == RequestParams.PAGING_ACTION_PREVEND) {
					result = 1;
				}
				currentPage = result;
			}

			if (currentPage > 0)
				swdRecordCond.setPageNo(currentPage-1);

			swdRecordCond.setPageSize(pageSize);

			SwdRecord[] swdRecords = getSwdManager().getRecords(user.getId(), swdRecordCond, IManager.LEVEL_LITE);

			SwdRecordExtend[] swdRecordExtends = getSwdManager().getCtgPkg(workId);

			//SwdField[] swdFields = getSwdManager().getViewFieldList(workId, swdDomain.getFormId());

			SwfForm[] swfForms = getSwfManager().getForms(user.getId(), swfFormCond, IManager.LEVEL_ALL);
			SwfField[] swfFields = swfForms[0].getFields();

			InstanceInfoList instanceInfoList = new InstanceInfoList();

			String formId = swdDomain.getFormId();
			String formName = swdDomain.getFormName();
			String titleFieldId = swdDomain.getTitleFieldId();

			if(swdRecords != null) {
				IWInstanceInfo[] iWInstanceInfos = new IWInstanceInfo[swdRecords.length];
	
				for(int i = 0; i < swdRecords.length; i++) {
					IWInstanceInfo iWInstanceInfo = new IWInstanceInfo();
					SwdRecord swdRecord = swdRecords[i];
					iWInstanceInfo.setId(swdRecord.getRecordId());
					iWInstanceInfo.setOwner(ModelConverter.getUserInfoByUserId(swdRecord.getCreationUser()));
					int type = WorkInstance.TYPE_INFORMATION;
					iWInstanceInfo.setType(type);
					iWInstanceInfo.setStatus(WorkInstance.STATUS_COMPLETED);
					iWInstanceInfo.setWorkSpace(null);
		
					WorkCategoryInfo groupInfo = null;
					if (!CommonUtil.isEmpty(swdRecordExtends[0].getSubCtgId()))
						groupInfo = new WorkCategoryInfo(swdRecordExtends[0].getSubCtgId(), swdRecordExtends[0].getSubCtg());
		
					WorkCategoryInfo categoryInfo = new WorkCategoryInfo(swdRecordExtends[0].getParentCtgId(), swdRecordExtends[0].getParentCtg());
		
					WorkInfo workInfo = new SmartWorkInfo(formId, formName, type, groupInfo, categoryInfo);
	
					iWInstanceInfo.setWork(workInfo);
					iWInstanceInfo.setLastModifier(ModelConverter.getUserInfoByUserId(swdRecord.getModificationUser()));
					iWInstanceInfo.setLastModifiedDate(new LocalDate((swdRecord.getModificationDate()).getTime()));
	
					SwdDataField[] swdDataFields = swdRecord.getDataFields();
					List<FieldData> fieldDataList = new ArrayList<FieldData>();
		
					for(SwdDataField swdDataField : swdDataFields) {
						if(swdDataField.getId().equals(titleFieldId))
							iWInstanceInfo.setSubject(swdDataField.getValue());
						for(SwfField swfField : swfFields) {
							String formatType = swfField.getFormat().getType();
							if(swdDataField.getDisplayOrder() > -1 && !formatType.equals("richEditor") && !formatType.equals("imageBox") && !formatType.equals("dataGrid")) {
								if(swdDataField.getId().equals(swfField.getId())) {
									FieldData fieldData = new FieldData();
									fieldData.setFieldId(swdDataField.getId());
									fieldData.setFieldType(formatType);
									String value = swdDataField.getValue();
									if(formatType.equals(FormField.TYPE_USER)) {
										if(value != null) {
											String[] users = value.split(";");
											String resultUser = "";
											if(users.length > 0 && users.length < 4) {
												for(int j=0; j<users.length; j++) {
													resultUser += users[j] + ", ";
												}
												resultUser = resultUser.substring(0, resultUser.length()-2);
											} else if(users.length > 0 && users.length > 3) {
												for(int j=0; j<3; j++) {
													resultUser += users[j] + ", ";
												}
												resultUser = resultUser.substring(0, resultUser.length()-2);
												resultUser = resultUser + " " + SmartMessage.getString("content.sentence.with_other_users", (new Object[]{(users.length - 3)}));
											}
											value = resultUser;
										}
									} else if(formatType.equals(FormField.TYPE_USERS)) {
										// TO-DO Multi User 의 경우
									} else if(formatType.equals(FormField.TYPE_CURRENCY)) {
										String symbol = swfField.getFormat().getCurrency();
										fieldData.setSymbol(symbol);
									} else if(formatType.equals(FormField.TYPE_PERCENT)) {
										// TO-DO
									} else if(formatType.equals(FormField.TYPE_DATE)) {
										if(value != null)
											value = LocalDate.convertGMTStringToLocalDate(value).toLocalDateSimpleString();
									} else if(formatType.equals(FormField.TYPE_TIME)) {
										if(value != null)
											value = LocalDate.convertGMTStringToLocalDate(value).toLocalTimeSimpleString();
									} else if(formatType.equals(FormField.TYPE_DATETIME)) {
										if(value != null)
											value = LocalDate.convertGMTStringToLocalDate(value).toLocalDateTimeSimpleString();
									} else if(formatType.equals(FormField.TYPE_FILE)) { 
										List<IFileModel> fileList = getDocManager().findFileGroup(value);
										List<Map<String, String>> fileNameList = new ArrayList<Map<String,String>>();
										for(int j=0; j<fileList.size(); j++) {
											Map<String, String> fileNameMap = new LinkedHashMap<String, String>();
											IFileModel fileModel = fileList.get(j);
											String fileName = fileModel.getFileName();
											String filePath = fileModel.getFilePath();
											fileNameMap.put("fileName", fileName);
											fileNameMap.put("filePath", filePath);
											fileNameList.add(fileNameMap);
										}
										fieldData.setFileNames(fileNameList);
									}
									fieldData.setValue(value);
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
				instanceInfoList.setInstanceDatas(iWInstanceInfos);
			}
	
			instanceInfoList.setSortedField(sortingField);
			instanceInfoList.setType(InstanceInfoList.TYPE_INFORMATION_INSTANCE_LIST);
			instanceInfoList.setPageSize(pageSize);
			instanceInfoList.setTotalPages(totalPages);
			instanceInfoList.setCurrentPage(currentPage);
	
			return instanceInfoList;
		}catch (Exception e){
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public InstanceInfoList getIWorkInstanceListByFormId(String formId, RequestParams params) throws Exception {

		try{
			User user = SmartUtil.getCurrentUser();
	
			SwfFormCond swfCond = new SwfFormCond();
			swfCond.setCompanyId(user.getCompanyId());
			swfCond.setId(formId);
	
			SwfForm swfForm = getSwfManager().getForms(user.getId(), swfCond, IManager.LEVEL_LITE)[0];
	
			String workId = swfForm.getPackageId();
	
			InstanceInfoList instanceInfoList = getIWorkInstanceList(workId, params);
	
			return instanceInfoList;
		}catch (Exception e){
			// Exception Handling Required
			e.printStackTrace();
			return null;			
			// Exception Handling Required			
		}
	}

	public InstanceInfoList getPWorkInstanceList(String workId, RequestParams params) throws Exception {
		
		try{
			User user = SmartUtil.getCurrentUser();
			//TODO workId = category 프로세스 인스턴스정보에는 패키지 컬럼이 없고 다이어 그램 컬럼에 정보가 들어가 있다
			//임시로 프로세스 다이어그램아이디 필드를 이용하고 프로세스인스턴스가 생성되는 시점(업무 시작, 처리 개발 완료)에 패키지 아이디 컬럼을 추가해 그곳에서 조회하는걸로 변경한다
			PrcProcessInstCond prcInstCond = new PrcProcessInstCond();
			prcInstCond.setPackageId(workId);

			String filterId = params.getFilterId();

			LocalDate priviousDate = new LocalDate(new LocalDate().getTime() - LocalDate.ONE_DAY*7);

			if(filterId != null) {
				if(filterId.equals(SearchFilter.FILTER_ALL_INSTANCES)) {
				} else if(filterId.equals(SearchFilter.FILTER_MY_INSTANCES)) {
					prcInstCond.addFilter(new Filter("=", FormField.ID_LAST_MODIFIER, Filter.OPERANDTYPE_STRING, user.getId()));
				} else if(filterId.equals(SearchFilter.FILTER_RECENT_INSTANCES)) {
					prcInstCond.addFilter(new Filter(">=", FormField.ID_LAST_MODIFIED_DATE, Filter.OPERANDTYPE_DATE, priviousDate.toGMTSimpleDateString()));
				} else if(filterId.equals(SearchFilter.FILTER_MY_RECENT_INSTANCES)) {
					prcInstCond.addFilter(new Filter("=", FormField.ID_LAST_MODIFIER, Filter.OPERANDTYPE_STRING, user.getId()));
					prcInstCond.addFilter(new Filter(">=", FormField.ID_LAST_MODIFIED_DATE, Filter.OPERANDTYPE_DATE, priviousDate.toGMTSimpleDateString()));
				}
			}

			long totalCount = getPrcManager().getProcessInstExtendsSize(user.getId(), prcInstCond);
			
			int pageCount = params.getPageSize();
			int currentPage = params.getCurrentPage()-1;
			
			SortingField sf = params.getSortingField();
			
			String columnName = "";
			boolean isAsc;
	
			//화면에서 사용하고 있는 컬럼의 상수값과 실제 프로세스 인스턴스 데이터 베이스의 컬럼 이름이 맞지 않아 컨버팅 작업
			//한군데에서 관리 하도록 상수로 변경 필요
			if (sf == null) {
				sf = new SortingField();
				sf.setFieldId("createdTime");
				sf.setAscending(false);
			}
			String sfColumnNameTemp = sf.getFieldId();
			
			if (sfColumnNameTemp.equalsIgnoreCase("status")) {
				sfColumnNameTemp = "prcStatus"; 
			} else if (sfColumnNameTemp.equalsIgnoreCase("subject")) {
				sfColumnNameTemp = "prcTitle";
			} else if (sfColumnNameTemp.equalsIgnoreCase("lastTask")) {
				sfColumnNameTemp = "lastTask_tskname"; 
			} else if (sfColumnNameTemp.equalsIgnoreCase("creator")) {
				sfColumnNameTemp = "prcCreateUser"; 
			} else if (sfColumnNameTemp.equalsIgnoreCase("createdTime")) {
				sfColumnNameTemp = "prcCreateDate"; 
			} else if (sfColumnNameTemp.equalsIgnoreCase("modifier")) {
				sfColumnNameTemp = "prcModifyUser"; 
			} else if (sfColumnNameTemp.equalsIgnoreCase("modifiedTime")) {
				sfColumnNameTemp = "prcModifyDate"; 
			} else {
				sfColumnNameTemp = "prcCreateDate";
			}
	
			prcInstCond.setPageNo(currentPage);
			prcInstCond.setPageSize(pageCount);
			prcInstCond.setOrders(new Order[]{new Order(sfColumnNameTemp, sf.isAscending())});
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
					lastTaskInfo.setWorkSpace(ModelConverter.getWorkSpaceInfo(prcInst.getLastTask_tskWorkSpaceType(), prcInst.getLastTask_tskWorkSpaceId()));
					lastTaskInfo.setName(name);
					lastTaskInfo.setTaskType(tskType);
					lastTaskInfo.setAssignee(ModelConverter.getUserInfoByUserId(assignee));
					lastTaskInfo.setPerformer(ModelConverter.getUserInfoByUserId(performer));
					//WorkInstanceInfo workInstanceInfo = paretProcessInstObj;
					pwInstInfo.setLastTask(lastTaskInfo);//마지막 태스크
				}
				pwInstInfo.setLastTaskCount(prcInst.getLastTask_tskCount());
				pwInstInfo.setWorkSpace(ModelConverter.getWorkSpaceInfo(prcInst.getPrcWorkSpaceType(), prcInst.getPrcWorkSpaceId()));
				pWInstanceInfos[i] = pwInstInfo;
			}
	//		instanceInfoList.setInstanceDatas(ModelConverter.getPWInstanceInfoArrayByPrcProcessInstArray(prcInsts));
			instanceInfoList.setInstanceDatas(pWInstanceInfos);
			instanceInfoList.setPageSize(pageCount);
			int totalPages = (int)totalCount / pageCount;
			if (totalPages == 0) {
				totalPages = 1;
			} else {
				int ext = (int)totalCount % pageCount;
				if (ext != 0)
					totalPages += 1;
			}
			
			instanceInfoList.setSortedField(sf);
			instanceInfoList.setTotalPages(totalPages);
			instanceInfoList.setCurrentPage(currentPage+1);
			instanceInfoList.setType(InstanceInfoList.TYPE_PROCESS_INSTANCE_LIST);
			return instanceInfoList;
		}catch (Exception e){
			// Exception Handling Required
			e.printStackTrace();
			return null;			
			// Exception Handling Required			
		}
	}
	public InstanceInfoList getPWorkInstanceList_bak(String workId, RequestParams params) throws Exception {

		try{
			//date to localdate - Date startTime = new Date();
			LocalDate startTime = new LocalDate();
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
		}catch (Exception e){
			// Exception Handling Required
			e.printStackTrace();
			return null;			
			// Exception Handling Required			
		}
	}
	public InstanceInfoList getPWorkInstanceList_bak2(String companyId, String userId, String workId, RequestParams params) throws Exception {

		try{
			//date to localdate - Date startTime = new Date();
			LocalDate startTime = new LocalDate();
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
					lastTaskInfo.setWorkSpace(ModelConverter.getWorkSpaceInfo(prcInst.getWorkSpaceType(), prcInst.getWorkSpaceId()));
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
						runningTaskInfo.setWorkSpace(ModelConverter.getWorkSpaceInfo(runningTask.getWorkSpaceType(), runningTask.getWorkSpaceId()));
						runningTaskInfo.setName(name);
						runningTaskInfo.setTaskType(type);
						runningTaskInfo.setAssignee(ModelConverter.getUserInfoByUserId(assignee));
						runningTaskInfo.setPerformer(ModelConverter.getUserInfoByUserId(performer));
	//					pwInstInfo.setRunningTasks(new TaskInstanceInfo[]{runningTaskInfo});//실행중태스크
					}
				}
				pwInstInfo.setWorkSpace(ModelConverter.getWorkSpaceInfo(prcInst.getWorkSpaceType(), prcInst.getWorkSpaceId()));
				pWInstanceInfos[i] = pwInstInfo;
			}
	//		instanceInfoList.setInstanceDatas(ModelConverter.getPWInstanceInfoArrayByPrcProcessInstArray(prcInsts));
			instanceInfoList.setInstanceDatas(pWInstanceInfos);
			
			instanceInfoList.setPageSize(pageCount);
			instanceInfoList.setTotalPages((int)totalCount);
			instanceInfoList.setCurrentPage(currentPage);
			instanceInfoList.setTotalPages(InstanceInfoList.TYPE_PROCESS_INSTANCE_LIST);
	
			return instanceInfoList;
		}catch (Exception e){
			// Exception Handling Required
			e.printStackTrace();
			return null;			
			// Exception Handling Required			
		}
	}

	@Override
	public WorkInstance getWorkInstanceById(int workType, String workId, String instanceId) throws Exception {
		//TODO 인스턴스로 패키지 타입을 알수가 없다 테이블에 컬럼을 생성하기는 했지만 초기 테스트시에는 데이터가 없기 때문에
		//인스턴스에 diagramId = pkgId 가 있으면 프로세스 업무 없으면 정보관리 업무로 판단한다

		try{
			User user = SmartUtil.getCurrentUser();
	
			if(workType == SmartWork.TYPE_PROCESS) {
				PrcProcessInst prcInst = getPrcManager().getProcessInst(user.getId(), instanceId, IManager.LEVEL_LITE);
				if (prcInst == null)
					return null;
				return getProcessWorkInstanceById(user.getCompanyId(), user.getId(), prcInst);
			} else if(workType == SmartWork.TYPE_INFORMATION){
				SwfFormCond swfFormCond = new SwfFormCond();
				swfFormCond.setCompanyId(user.getCompanyId());
				swfFormCond.setPackageId(workId);
				SwfForm[] swfForms = getSwfManager().getForms(user.getId(), swfFormCond, IManager.LEVEL_LITE);
				SwdRecordCond swdRecordCond = new SwdRecordCond();
				swdRecordCond.setCompanyId(user.getCompanyId());
				swdRecordCond.setFormId(swfForms[0].getId());
				swdRecordCond.setRecordId(instanceId);
				SwdRecord swdRecord = getSwdManager().getRecord(user.getId(), swdRecordCond, IManager.LEVEL_LITE);
				return getInformationWorkInstanceById(user.getCompanyId(), user.getId(), swdRecord);
				//return SmartTest.getInformationWorkInstance1();
			} else if(workType == SmartWork.TYPE_SCHEDULE) {
				return null;
			}

			return null;
		}catch (Exception e){
			// Exception Handling Required
			e.printStackTrace();
			return null;			
			// Exception Handling Required			
		}
	}

	public ProcessWorkInstance getProcessWorkInstanceById(String companyId, String userId, PrcProcessInst prcInst) throws Exception {
		
		try{
			return ModelConverter.getProcessWorkInstanceByPrcProcessInst(userId, null, prcInst);
		}catch (Exception e){
			// Exception Handling Required
			e.printStackTrace();
			return null;			
			// Exception Handling Required			
		}	
	}

	public InformationWorkInstance getInformationWorkInstanceById(String companyId, String userId, SwdRecord swdRecord) throws Exception {

		try{
			return ModelConverter.getInformationWorkInstanceBySwdRecord(userId, null, swdRecord);
		}catch (Exception e){
			// Exception Handling Required
			e.printStackTrace();
			return null;			
			// Exception Handling Required			
		}
	}
	@Override
	public TaskInstanceInfo[][] getTaskInstancesByWorkHours(String contextId, String spaceId, LocalDate date, int maxSize) throws Exception {
		try{
			return SmartTest.getTaskInstancesByWorkHours(contextId, spaceId, date, maxSize);
		}catch (Exception e){
			// Exception Handling Required
			e.printStackTrace();
			return null;			
			// Exception Handling Required			
		}
	}
	@Override
	public TaskInstanceInfo[][] getTaskInstancesByDates(String contextId, String spaceId, LocalDate fromDate, LocalDate toDate, int maxSize) throws Exception {
		try{
			return SmartTest.getTaskInstancesByDates(contextId, spaceId, fromDate, toDate, maxSize);
		}catch (Exception e){
			// Exception Handling Required
			e.printStackTrace();
			return null;			
			// Exception Handling Required			
		}
	}
	@Override
	public TaskInstanceInfo[][] getTaskInstancesByWeeks(String contextId, String spaceId, LocalDate month, int maxSize) throws Exception {
		try{
			return SmartTest.getTaskInstancesByWeeks(contextId, spaceId, month, maxSize);
		}catch (Exception e){
			// Exception Handling Required
			e.printStackTrace();
			return null;			
			// Exception Handling Required			
		}
	}
	@Override
	public TaskInstanceInfo[] getTaskInstancesByDate(String contextId, String spaceId, LocalDate fromDate, LocalDate toDate, int maxSize) throws Exception {
		try{
			return SmartTest.getTaskInstancesByDate(contextId, spaceId, fromDate, toDate, maxSize);
		}catch (Exception e){
			// Exception Handling Required
			e.printStackTrace();
			return null;			
			// Exception Handling Required			
		}
	}

	@Override
	public TaskInstanceInfo[] getInstanceTaskHistoriesById(String instId) throws Exception {

		try{
			User user = SmartUtil.getCurrentUser();
			TskTaskCond tskCond = new TskTaskCond();
			tskCond.setExtendedProperties(new Property[] {new Property("recordId", instId)});
			TskTask[] tskTasks = getTskManager().getTasks(user.getId(), tskCond, IManager.LEVEL_LITE);
			TaskInstanceInfo[] taskInstanceInfos = null;
			if(tskTasks != null) {
				taskInstanceInfos = new TaskInstanceInfo[tskTasks.length];
				IWInstanceInfo iWInstanceInfo = new IWInstanceInfo();
				String processInstId = tskTasks[0].getProcessInstId();

				TskTask lastSwTask = ModelConverter.getLastTskTaskByInstanceId(processInstId);

				TaskInstanceInfo lastTask = ModelConverter.getTaskInstanceInfoByTskTask(iWInstanceInfo, null, lastSwTask);
				iWInstanceInfo.setLastTask(lastTask);

				for(int i=0; i<tskTasks.length; i++) {
					TaskInstanceInfo taskInstanceInfo = ModelConverter.getTaskInstanceInfoByTskTask(iWInstanceInfo, null, tskTasks[i]);
					taskInstanceInfos[i] = taskInstanceInfo;
				}
			}
			return taskInstanceInfos;
		}catch (Exception e){
			return null;
		}

	}

	@Override
	public InstanceInfoList[] getInstanceRelatedWorksById(String instId) throws Exception {

		try{
			User user = SmartUtil.getCurrentUser();
			Map<String, Integer> refFormMap = getSwfManager().getReferenceFormIdSizeMap(user.getId(), instId);

			InstanceInfoList[] instanceInfoLists = new InstanceInfoList[refFormMap.size()];

			Iterator iterator = refFormMap.entrySet().iterator();
			int count = 0;
			while(iterator.hasNext()) {
				InstanceInfoList instanceInfoList = new InstanceInfoList();
				Entry entry = (Entry)iterator.next();
				String myFormId = CommonUtil.toNotNull(entry.getKey());

				SwfFormCond swfFormCond = new SwfFormCond();
				swfFormCond.setCompanyId(user.getCompanyId());
				swfFormCond.setId(myFormId);
				SwfForm[] swfForms = getSwfManager().getForms(user.getId(), swfFormCond, IManager.LEVEL_ALL);
				if(swfForms == null)
					return null;
				SwfField[] swfFields = swfForms[0].getFields();

				SwdRecordExtend[] swdRecordExtends = getSwdManager().getCtgPkg(swfForms[0].getPackageId());

				SwdRecordCond swdRecordCond = new SwdRecordCond();
				swdRecordCond.setFormId(myFormId);
				swdRecordCond.setReferencedRecordId(instId);

				swdRecordCond.setOrders(new Order[]{new Order(FormField.ID_CREATED_DATE, false)});

				SwdRecord[] swdRecords = getSwdManager().getRecords(user.getId(), swdRecordCond, IManager.LEVEL_LITE);

				SwdDomainCond swdDomainCond = new SwdDomainCond();
				swdDomainCond.setCompanyId(user.getCompanyId());
				swdDomainCond.setFormId(myFormId);

				SwdDomain swdDomain = getSwdManager().getDomain(user.getId(), swdDomainCond, IManager.LEVEL_LITE);

				String formId = swdDomain.getFormId();
				String formName = swdDomain.getFormName();
				String titleFieldId = swdDomain.getTitleFieldId();

				if(swdRecords != null) {
					IWInstanceInfo[] iWInstanceInfos = new IWInstanceInfo[swdRecords.length];
		
					for(int i = 0; i < swdRecords.length; i++) {
						IWInstanceInfo iWInstanceInfo = new IWInstanceInfo();
						SwdRecord swdRecord = swdRecords[i];
						iWInstanceInfo.setId(swdRecord.getRecordId());
						iWInstanceInfo.setOwner(ModelConverter.getUserInfoByUserId(swdRecord.getCreationUser()));
						int type = WorkInstance.TYPE_INFORMATION;
						iWInstanceInfo.setType(type);
						iWInstanceInfo.setStatus(WorkInstance.STATUS_COMPLETED);
						iWInstanceInfo.setWorkSpace(null);
			
						WorkCategoryInfo groupInfo = null;
						if (!CommonUtil.isEmpty(swdRecordExtends[0].getSubCtgId()))
							groupInfo = new WorkCategoryInfo(swdRecordExtends[0].getSubCtgId(), swdRecordExtends[0].getSubCtg());
			
						WorkCategoryInfo categoryInfo = new WorkCategoryInfo(swdRecordExtends[0].getParentCtgId(), swdRecordExtends[0].getParentCtg());
			
						WorkInfo workInfo = new SmartWorkInfo(formId, formName, type, groupInfo, categoryInfo);
		
						iWInstanceInfo.setWork(workInfo);
						iWInstanceInfo.setLastModifier(ModelConverter.getUserInfoByUserId(swdRecord.getModificationUser()));
						iWInstanceInfo.setLastModifiedDate(new LocalDate((swdRecord.getModificationDate()).getTime()));
		
						SwdDataField[] swdDataFields = swdRecord.getDataFields();
						List<FieldData> fieldDataList = new ArrayList<FieldData>();
			
						for(SwdDataField swdDataField : swdDataFields) {
							if(swdDataField.getId().equals(titleFieldId))
								iWInstanceInfo.setSubject(swdDataField.getValue());
							for(SwfField swfField : swfFields) {
								String formatType = swfField.getFormat().getType();
								if(swdDataField.getDisplayOrder() > -1 && !formatType.equals("richEditor") && !formatType.equals("imageBox") && !formatType.equals("dataGrid")) {
									if(swdDataField.getId().equals(swfField.getId())) {
										FieldData fieldData = new FieldData();
										fieldData.setFieldId(swdDataField.getId());
										fieldData.setFieldType(formatType);
										String value = swdDataField.getValue();
										if(formatType.equals(FormField.TYPE_USER)) {
											if(value != null) {
												String[] users = value.split(";");
												String resultUser = "";
												if(users.length > 0 && users.length < 4) {
													for(int j=0; j<users.length; j++) {
														resultUser += users[j] + ", ";
													}
													resultUser = resultUser.substring(0, resultUser.length()-2);
												} else if(users.length > 0 && users.length > 3) {
													for(int j=0; j<3; j++) {
														resultUser += users[j] + ", ";
													}
													resultUser = resultUser.substring(0, resultUser.length()-2);
													resultUser = resultUser + " " + SmartMessage.getString("content.sentence.with_other_users", (new Object[]{(users.length - 3)}));
												}
												value = resultUser;
											}
										} else if(formatType.equals(FormField.TYPE_USERS)) {
											// TO-DO Multi User 의 경우
										} else if(formatType.equals(FormField.TYPE_CURRENCY)) {
											String symbol = swfField.getFormat().getCurrency();
											fieldData.setSymbol(symbol);
										} else if(formatType.equals(FormField.TYPE_PERCENT)) {
											// TO-DO
										} else if(formatType.equals(FormField.TYPE_DATE)) {
											if(value != null)
												value = LocalDate.convertGMTStringToLocalDate(value).toLocalDateSimpleString();
										} else if(formatType.equals(FormField.TYPE_TIME)) {
											if(value != null)
												value = LocalDate.convertGMTStringToLocalDate(value).toLocalTimeSimpleString();
										} else if(formatType.equals(FormField.TYPE_DATETIME)) {
											if(value != null)
												value = LocalDate.convertGMTStringToLocalDate(value).toLocalDateTimeSimpleString();
										} else if(formatType.equals(FormField.TYPE_FILE)) { 
											List<IFileModel> fileList = getDocManager().findFileGroup(value);
											List<Map<String, String>> fileNameList = new ArrayList<Map<String,String>>();
											for(int j=0; j<fileList.size(); j++) {
												Map<String, String> fileNameMap = new LinkedHashMap<String, String>();
												IFileModel fileModel = fileList.get(j);
												String fileName = fileModel.getFileName();
												String filePath = fileModel.getFilePath();
												fileNameMap.put("fileName", fileName);
												fileNameMap.put("filePath", filePath);
												fileNameList.add(fileNameMap);
											}
											fieldData.setFileNames(fileNameList);
										}
										fieldData.setValue(value);
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
					instanceInfoList.setInstanceDatas(iWInstanceInfos);
				}

				//instanceInfoList.setSortedField(sortingField);
				instanceInfoList.setType(InstanceInfoList.TYPE_INFORMATION_INSTANCE_LIST);
				//instanceInfoList.setPageSize(pageSize);
				//instanceInfoList.setTotalPages(totalPages);
				//instanceInfoList.setCurrentPage(currentPage);
				instanceInfoLists[count] = instanceInfoList;
				count++;
			}
			return instanceInfoLists;
		}catch (Exception e){
			// Exception Handling Required
			e.printStackTrace();
			return null;			
			// Exception Handling Required			
		}
	}

}
