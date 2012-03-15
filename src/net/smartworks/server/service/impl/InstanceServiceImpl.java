package net.smartworks.server.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Stack;
import java.util.TimeZone;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

import net.smartworks.model.community.User;
import net.smartworks.model.community.info.UserInfo;
import net.smartworks.model.community.info.WorkSpaceInfo;
import net.smartworks.model.filter.Condition;
import net.smartworks.model.filter.SearchFilter;
import net.smartworks.model.instance.FieldData;
import net.smartworks.model.instance.InformationWorkInstance;
import net.smartworks.model.instance.Instance;
import net.smartworks.model.instance.ProcessWorkInstance;
import net.smartworks.model.instance.RunningCounts;
import net.smartworks.model.instance.SortingField;
import net.smartworks.model.instance.WorkInstance;
import net.smartworks.model.instance.info.BoardInstanceInfo;
import net.smartworks.model.instance.info.CommentInstanceInfo;
import net.smartworks.model.instance.info.EventInstanceInfo;
import net.smartworks.model.instance.info.IWInstanceInfo;
import net.smartworks.model.instance.info.ImageInstanceInfo;
import net.smartworks.model.instance.info.InstanceInfo;
import net.smartworks.model.instance.info.InstanceInfoList;
import net.smartworks.model.instance.info.PWInstanceInfo;
import net.smartworks.model.instance.info.RequestParams;
import net.smartworks.model.instance.info.TaskInstanceInfo;
import net.smartworks.model.instance.info.WorkInstanceInfo;
import net.smartworks.model.work.FileCategory;
import net.smartworks.model.work.FormField;
import net.smartworks.model.work.SmartForm;
import net.smartworks.model.work.SmartWork;
import net.smartworks.model.work.Work;
import net.smartworks.model.work.info.SmartWorkInfo;
import net.smartworks.model.work.info.WorkCategoryInfo;
import net.smartworks.model.work.info.WorkInfo;
import net.smartworks.server.engine.common.manager.IManager;
import net.smartworks.server.engine.common.model.Filter;
import net.smartworks.server.engine.common.model.Filters;
import net.smartworks.server.engine.common.model.Order;
import net.smartworks.server.engine.common.model.Property;
import net.smartworks.server.engine.common.util.CommonUtil;
import net.smartworks.server.engine.common.util.DateUtil;
import net.smartworks.server.engine.common.util.StringUtil;
import net.smartworks.server.engine.config.manager.ISwcManager;
import net.smartworks.server.engine.config.model.SwcWorkHour;
import net.smartworks.server.engine.config.model.SwcWorkHourCond;
import net.smartworks.server.engine.docfile.exception.DocFileException;
import net.smartworks.server.engine.docfile.manager.IDocFileManager;
import net.smartworks.server.engine.docfile.model.FileWork;
import net.smartworks.server.engine.docfile.model.FileWorkCond;
import net.smartworks.server.engine.docfile.model.IFileModel;
import net.smartworks.server.engine.factory.SwManagerFactory;
import net.smartworks.server.engine.folder.manager.IFdrManager;
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
import net.smartworks.server.engine.infowork.form.model.SwfFieldMapping;
import net.smartworks.server.engine.infowork.form.model.SwfFieldRef;
import net.smartworks.server.engine.infowork.form.model.SwfForm;
import net.smartworks.server.engine.infowork.form.model.SwfFormCond;
import net.smartworks.server.engine.infowork.form.model.SwfFormLink;
import net.smartworks.server.engine.infowork.form.model.SwfFormModel;
import net.smartworks.server.engine.infowork.form.model.SwfFormRef;
import net.smartworks.server.engine.infowork.form.model.SwfFormat;
import net.smartworks.server.engine.infowork.form.model.SwfMapping;
import net.smartworks.server.engine.infowork.form.model.SwfMappings;
import net.smartworks.server.engine.organization.manager.ISwoManager;
import net.smartworks.server.engine.organization.model.SwoDepartment;
import net.smartworks.server.engine.organization.model.SwoDepartmentCond;
import net.smartworks.server.engine.organization.model.SwoUser;
import net.smartworks.server.engine.organization.model.SwoUserCond;
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
import net.smartworks.server.engine.worklist.manager.IWorkListManager;
import net.smartworks.server.engine.worklist.model.TaskWork;
import net.smartworks.server.engine.worklist.model.TaskWorkCond;
import net.smartworks.server.service.ICalendarService;
import net.smartworks.server.service.ICommunityService;
import net.smartworks.server.service.IInstanceService;
import net.smartworks.server.service.util.ModelConverter;
import net.smartworks.util.LocalDate;
import net.smartworks.util.SmartMessage;
import net.smartworks.util.SmartTest;
import net.smartworks.util.SmartUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class InstanceServiceImpl implements IInstanceService {
	protected final Log logger = LogFactory.getLog(getClass());

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
	private ISwcManager getSwcManager() {
		return SwManagerFactory.getInstance().getSwcManager();
	}
	private IWorkListManager getWlmManager() {
		return SwManagerFactory.getInstance().getWorkListManager();
	}
	private static IFdrManager getFdrManager() {
		return SwManagerFactory.getInstance().getFdrManager();
	}

	private ICommunityService communityService;
	private ICalendarService calendarService;

	@Autowired
	public void setCommunityService(ICommunityService communityService) {
		this.communityService = communityService;
	}
	@Autowired
	public void setCalendarService(ICalendarService calendarService) {
		this.calendarService = calendarService;
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
			String workId = SmartWork.ID_BOARD_MANAGEMENT;
	
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

			String subCtgId = swdRecordExtends[0].getSubCtgId();
			String subCtgName = swdRecordExtends[0].getSubCtg();
			String parentCtgId = swdRecordExtends[0].getParentCtgId();
			String parentCtgName = swdRecordExtends[0].getParentCtg();
			String formId = swdDomain.getFormId();
			String formName = swdDomain.getFormName();

			if(!CommonUtil.isEmpty(swdRecords)) {
				int swdRecordsLength = swdRecords.length;
				boardInstanceInfos = new BoardInstanceInfo[swdRecordsLength];
				for(int i=0; i < swdRecordsLength; i++) {
					SwdRecord swdRecord = swdRecords[i];
					BoardInstanceInfo boardInstanceInfo = new BoardInstanceInfo();
					boardInstanceInfo.setId(swdRecord.getRecordId());
					boardInstanceInfo.setOwner(ModelConverter.getUserInfoByUserId(swdRecord.getCreationUser()));
					boardInstanceInfo.setCreatedDate(new LocalDate((swdRecord.getCreationDate()).getTime()));
					int type = WorkInstance.TYPE_INFORMATION;
					boardInstanceInfo.setType(type);
					boardInstanceInfo.setStatus(WorkInstance.STATUS_COMPLETED);
					String workSpaceId = swdRecord.getWorkSpaceId();
					if(workSpaceId == null)
						workSpaceId = user.getId();

					WorkSpaceInfo workSpaceInfo = communityService.getWorkSpaceInfoById(workSpaceId);

					boardInstanceInfo.setWorkSpace(workSpaceInfo);

					WorkCategoryInfo groupInfo = null;
					if (!CommonUtil.isEmpty(subCtgId))
						groupInfo = new WorkCategoryInfo(subCtgId, subCtgName);

					WorkCategoryInfo categoryInfo = new WorkCategoryInfo(parentCtgId, parentCtgName);

					WorkInfo workInfo = new SmartWorkInfo(formId, formName, SmartWork.TYPE_INFORMATION, groupInfo, categoryInfo);

					boardInstanceInfo.setWork(workInfo);
					boardInstanceInfo.setLastModifier(ModelConverter.getUserInfoByUserId(swdRecord.getModificationUser()));
					boardInstanceInfo.setLastModifiedDate(new LocalDate((swdRecord.getModificationDate()).getTime()));

					SwdDataField[] swdDataFields = swdRecord.getDataFields();
					if(!CommonUtil.isEmpty(swdDataFields)) {
						int swdDataFieldsLength = swdDataFields.length;
						for(int j=0; j<swdDataFieldsLength; j++) {
							SwdDataField swdDataField = swdDataFields[j];
							String value = swdDataField.getValue();
							if(swdDataField.getId().equals("0")) {
								boardInstanceInfo.setSubject(StringUtil.subString(value, 0, 24, "..."));
							} else if(swdDataField.getId().equals("1")) {
								boardInstanceInfo.setBriefContent(StringUtil.subString(value, 0, 40, "..."));
							}
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
			User cuser = SmartUtil.getCurrentUser();
			String userId = null;
			if (cuser != null)
				userId = cuser.getId();
			
			TaskWorkCond cond = new TaskWorkCond();
			cond.setTskAssignee(userId);
			cond.setTskStatus(TskTask.TASKSTATUS_COMPLETE);
			cond.setOrders(new Order[]{new Order("taskLastModifyDate", false)});
			cond.setPageNo(0);
			cond.setPageSize(50);
			TaskWork[] tasks = getWlmManager().getTaskWorkList(userId, cond);
			if (tasks == null || tasks.length == 0)
				return null;
			
			List<InstanceInfo> InstanceInfoList = new ArrayList<InstanceInfo>();
			List<String> prcInstIdList = new ArrayList<String>();
			for (int i = 0; i < tasks.length; i++) {
				TaskWork task = tasks[i];
				if (InstanceInfoList.size() == 10)
					break;
				if (prcInstIdList.contains(task.getTskPrcInstId()))
					continue;
				prcInstIdList.add(task.getTskPrcInstId());
				InstanceInfoList.add(ModelConverter.getWorkInstanceInfoByTaskWork(task));
			}
			InstanceInfo[] resultTasks = new InstanceInfo[InstanceInfoList.size()];
			InstanceInfoList.toArray(resultTasks);
			
			return resultTasks;
			
//			User user = SmartUtil.getCurrentUser();
//			if (CommonUtil.isEmpty(user.getCompanyId()) || CommonUtil.isEmpty(user.getId()))
//				return null;
//	
//			TskTaskCond taskCond = new TskTaskCond();
//			taskCond.setAssignee(user.getId());
//			taskCond.setStatus(TskTask.TASKSTATUS_COMPLETE);
//			taskCond.setTypeNotIns(TskTask.NOTUSERTASKTYPES);
//			taskCond.setOrders(new Order[]{new Order("executionDate" , false)});
//			taskCond.setPageNo(0);
//			taskCond.setPageSize(50);
//			
//			TskTask[] tasks = getTskManager().getTasks(user.getId(), taskCond, IManager.LEVEL_LITE);
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
//			prcInstCond.setCompanyId(user.getCompanyId());
//			prcInstCond.setObjIdIns(prcInstIdArray);
//			prcInstCond.setOrders(new Order[]{new Order("creationDate" , false)});
//			
//			PrcProcessInst[] prcInsts = getPrcManager().getProcessInsts(user.getId(), prcInstCond, IManager.LEVEL_LITE);
//			
//			InstanceInfo[] instInfo = ModelConverter.getInstanceInfoArrayByPrcInstArray(prcInsts);
//			
//			return instInfo;
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
			taskCond.setPrcStatus(PrcProcessInst.PROCESSINSTSTATUS_RUNNING);
			
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
			taskCond.setPrcStatus(PrcProcessInst.PROCESSINSTSTATUS_RUNNING);
			
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
	public SwdRecord refreshDataFields(Map<String, Object> requestBody, HttpServletRequest request) throws Exception {
		
		try{
			User cuser = SmartUtil.getCurrentUser();
			String userId = null;
			if (cuser != null)
				userId = cuser.getId();
			
			String formId = (String)requestBody.get("formId");
			String formName = (String)requestBody.get("formName");// 사용?
			
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

			SwfField[] formFields = form.getFields();
			List domainFieldList = new ArrayList();
			for (SwfField field: formFields) {
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
			
			SwdRecord record = getSwdRecordByRequestBody(userId, domainFields, requestBody, request);
			
			//새로 값이 셋팅되어 변경될 레코드 클론
			SwdRecord oldRecord = (SwdRecord)record.clone();
			SwdRecord newRecord = (SwdRecord)record.clone();
			
			Map<String, SwdDataField> resultMap = new HashMap<String, SwdDataField>();
			
			// 각 필드들 마다 가져오기 맵핑을 확인하여 값을 셋팅한다
			for (SwfField field : fields) {
				setResultFieldMapByFields(userId, form, resultMap, field, newRecord, oldRecord);
			}
			
			return null; 
		}catch (Exception e){
			// Exception Handling Required
			e.printStackTrace();
			return null;			
			// Exception Handling Required			
		}
	}
	private void setResultFieldMapByFields(String userId, SwfForm form, Map<String, SwdDataField> resultMap, SwfField field, SwdRecord newRecord, SwdRecord oldRecord) throws Exception {
		
		try{
			if (resultMap == null)
				resultMap = new HashMap<String, SwdDataField>();
			
			String fieldId = field.getId();
			String fieldType = field.getSystemType();
			
			SwfMappings mappings = field.getMappings();
			if (mappings == null) {
				resultMap.put(fieldId, oldRecord.getDataField(fieldId));
				newRecord.setDataField(fieldId, oldRecord.getDataField(fieldId));
				return;
			}	
			SwfMapping[] preMappings = mappings.getPreMappings();
			if (CommonUtil.isEmpty(preMappings)){
				resultMap.put(fieldId, oldRecord.getDataField(fieldId));
				newRecord.setDataField(fieldId, oldRecord.getDataField(fieldId));
				return;
			}	
			// 가져오기 매핑정의가 있는지 확인 끝

			// 연결 업무 목록
			SwfFormLink[] formLinks = form.getMappingForms();
			Map<String, SwfFormLink> formLinkMap = new HashMap<String, SwfFormLink>();
			if (!CommonUtil.isEmpty(formLinks)) {
				for (SwfFormLink formLink:formLinks)
					formLinkMap.put(formLink.getId(), formLink);
			}
			
			
			boolean isFirst = true;
			//현재폼, 외부폼, 프로세스폼의 우선 적용순위를 정하기위한 트리맵(소팅맵)
			Map<Long, SwdDataField> resultTreeMap = new HashMap<Long, SwdDataField>();
			//함수, 웹서비스, 계산식의 순서중 마지막 값을 취하기위한 스텍
			Stack<SwdDataField> resultStack = new Stack<SwdDataField>();
			
			//가져오기 셋팅이 여러개 일수 있다
			for (SwfMapping preMapping : preMappings) {
				//초기 데이터 가져오기 호출이 아니고 매번호출이 아니라면 스킵
				//초기 데이터 가져오기내용 검토 필요(초기인지 아닌지 알수 있나?)
				if (!preMapping.isEachTime() && !isFirst){
					//resultMap.put(fieldId, oldRecord.getDataField(fieldId));
					//newRecord.setDataField(fieldId, oldRecord.getDataField(fieldId));
					continue;
				}	
	
				String mappingType = preMapping.getType();
	//			mappingType = TYPE_SIMPLE = "mapping_form"; 단순 맵핑
	//			mappingTYpe = TYPE_EXPRESSION = "expression"; 계산식
				
				if (SwfMapping.TYPE_SIMPLE.equalsIgnoreCase(mappingType)) {
					//단순 맵핑 (현재업무화면, 다른업무화면, 프로세스업무화면, 시스템함수, 웹서비스)
					String mappingFormType = preMapping.getMappingFormType();
					// 현재업무항목
					if (SwfMapping.MAPPINGTYPE_SELFFORM.equalsIgnoreCase(mappingFormType)) {
						//현재 업무 항목이라면 재귀 함수호출로 호출되는쪽의 데이터 맵핑이 있는지를 다시 살핀다
						String mappingFieldId = CommonUtil.toNull(preMapping.getFieldId());
						if (CommonUtil.isEmpty(mappingFieldId))
							continue;
						SwfField[] fields = form.getFields();
						SwfField targetField = null;
						for (SwfField tempField : fields) {
							if (tempField.getId().equalsIgnoreCase(mappingFieldId)) {
								targetField = tempField;
								break;
							}
						}
						if (targetField == null) {
							logger.warn("TargetMapping Field Is Null!!! Check Change Field Id!!");
							continue;
						}
						//재귀 호출
						if (!resultMap.containsKey(targetField.getId()))
							setResultFieldMapByFields(userId, form, resultMap, targetField, newRecord, oldRecord);
						
						SwdDataField dataField = (SwdDataField)resultMap.get(mappingFieldId);
						
						SwdDataField myDataField = new SwdDataField();
						myDataField.setId(fieldId);
						myDataField.setType(fieldType);
						if (dataField != null)
							myDataField.setValue(dataField.getValue());
						//resultMap.put(fieldId, new SwdDataField());
						
						long timeKey = oldRecord.getCreationDate().getTime();
						if (!resultTreeMap.containsKey(timeKey)) {
							resultTreeMap.put(timeKey, myDataField);
						}
					} else if (SwfMapping.MAPPINGTYPE_OTHERFORM.equalsIgnoreCase(mappingFormType)) {
					//외부업무 화면
						String formLinkId = preMapping.getMappingFormId();
						String mappingFieldId = preMapping.getFieldId();
						SwfFieldMapping[] fieldMappings = preMapping.getFieldMappings();
						
						if (CommonUtil.isEmpty(formLinkId) || !formLinkMap.containsKey(formLinkId) || 
							(CommonUtil.isEmpty(mappingFieldId) && CommonUtil.isEmpty(fieldMappings))) {
							continue;
						}
						
						String valueFunc = preMapping.getValueFunc();
						if (valueFunc == null || valueFunc.equalsIgnoreCase("value")) {
							SwdRecord[] mappingRecords = null;
							if (!CommonUtil.isEmpty(mappingFieldId)) {
								SwdRecord mappingRecord = getSwdManager().getRecordByMappingForm(userId, oldRecord,  formLinkMap.get(formLinkId));
								if (mappingRecord != null)
									mappingRecords = new SwdRecord[] {mappingRecord};
							} else {
								mappingRecords = getSwdManager().getRecordsByMappingForm(userId, oldRecord,  formLinkMap.get(formLinkId));
							}
							
							if (CommonUtil.isEmpty(mappingRecords)) 
								continue;
							
							if (!CommonUtil.isEmpty(mappingFieldId)) {
								
								SwdRecord mappingRecord = mappingRecords[0];
								SwdDataField mappingDataField = mappingRecord.getDataField(mappingFieldId);
								
								SwdDataField dataField = oldRecord.getDataField(fieldId);
								if (dataField == null) {
									dataField = new SwdDataField();
									dataField.setId(fieldId);
									dataField.setType(fieldType);
								}
								if (mappingDataField == null) {
									dataField.setValue(null);
									dataField.setRefRecordId(null);
								} else {
									dataField.setValue(mappingDataField.getValue());
									dataField.setRefRecordId(mappingDataField.getRefRecordId());
								}
								//setResultTreeMap
								long timeKey = mappingRecord.getCreationDate().getTime();
								if (!resultTreeMap.containsKey(timeKey)) 
									resultTreeMap.put(timeKey, dataField);
								
								SwfFormat format = field.getFormat();
								if (format == null)
									continue;
								String formatType = format.getType();
								if (!"refFormField".equalsIgnoreCase(formatType))
									continue;
								SwfFormRef formRef = format.getRefForm();
								if (formRef == null)
									continue;
								dataField.setRefForm(formRef.getId());
								SwfFieldRef fieldRef = formRef.getField();
								if (fieldRef == null)
									continue;
								dataField.setRefFormField(fieldRef.getId());
								if (CommonUtil.toNull(dataField.getRefRecordId()) == null &&
										CommonUtil.toNull(dataField.getRefForm()) != null && 
										CommonUtil.toNull(dataField.getRefFormField()) != null && 
										CommonUtil.toNull(dataField.getValue()) != null) {
									dataField.setRefRecordId(mappingRecord.getRecordId());
								}
								
							} else {
								//Sw 2.0 에서 구현 되어 있지만 3.0에서는 미구현! mappingFieldId 가 비어 있는 경우가 없어 보인다! 만약에 아래 오류를 발견한다면
								//2.0의 executionService.jsp 소스에서 refreshData 부분을 참고하여 코드를 작성해야 한다
								throw new Exception("InstanceServiceImpl Exception : mappingFieldId is Empty (InstanceServiceImpl.java 760Line)");
							}
						} else {
							double value = getSwdManager().getRecordValueByMappingForm(userId, oldRecord, formLinkMap.get(formLinkId), mappingFieldId, valueFunc);
							SwdDataField dataField = new SwdDataField();
							dataField.setId(fieldId);
							dataField.setType(fieldType);
							dataField.setRefRecordId(null);
							dataField.setRefForm(null);
							dataField.setRefFormField(null);
							dataField.setValue(value + "");
							resultStack.add(dataField);
						}
					} else if (SwfMapping.MAPPINGTYPE_PROCESSFORM.equalsIgnoreCase(mappingFormType)) {
					//프로세스 업무
						String mappingFormId = preMapping.getMappingFormId();
						if (!mappingFormId.equalsIgnoreCase("processParam"))
							continue;
					} else if (SwfMapping.MAPPINGTYPE_SYSTEM.equalsIgnoreCase(mappingFormType)) {
					//시스템 함수
						ISwoManager mgr = SwManagerFactory.getInstance().getSwoManager();
						SwoUser func = mgr.getUser(userId, userId, "all");
						String functionId = CommonUtil.toNull(preMapping.getFieldId());
						String funcDeptId = "";
						String funcDeptName = "";
						String funcTeamLeader = "";
						if (CommonUtil.isEmpty(functionId))
							continue;
						if (functionId.equals("mis:generateId")) {
							SwdDataField dataField = new SwdDataField();
							dataField.setId(fieldId);
							dataField.setType(fieldType);
							dataField.setRefRecordId(null);
							dataField.setRefForm(null);
							dataField.setRefFormField(null);
							dataField.setValue(CommonUtil.newId());
							resultStack.add(dataField);
							
						} else if (functionId.equals("mis:getCurrentDate")) {
							SwdDataField dataField = new SwdDataField();
							dataField.setId(fieldId);
							dataField.setType(fieldType);
							dataField.setRefRecordId(null);
							dataField.setRefForm(null);
							dataField.setRefFormField(null);
							dataField.setValue(DateUtil.toXsdDateString(new Date()));
							resultStack.add(dataField);
							
						} else if (functionId.equals("mis:getCurrentUser")) {
							SwdDataField dataField = toDataField(userId, field, userId);
							dataField.setId(fieldId);
							resultStack.add(dataField);
							
						} else if (functionId.equals("mis:getDeptId")){		
							if(func != null){
							funcDeptId = func.getDeptId();
							SwoDepartment funcdept = mgr.getDepartment(userId, funcDeptId, "all");
								if(funcdept != null){
									funcDeptName = funcdept.getName();
								}
							}
							SwdDataField dataField = toDataField(userId, field, funcDeptName);
							dataField.setId(fieldId);
							resultStack.add(dataField);
							
						} else if (functionId.equals("mis:getTeamLeaderId")){
							if(func != null){
								funcDeptId = func.getDeptId();
								SwoUserCond cond = new SwoUserCond();
								cond.setDeptId(funcDeptId);
								cond.setRoleId("DEPT LEADER");
								
								SwoUser[] funcs = mgr.getUsers(userId, cond, "all");
								if(funcs != null){
									funcTeamLeader = funcs[0].getId();
								}
							}
							SwdDataField dataField = toDataField(userId, field, funcTeamLeader);
							dataField.setId(fieldId);
							resultStack.add(dataField);
							
						} else if (functionId.equals("mis:getEmpNo")){
							String funcEmpNo = func.getEmpNo();
							SwdDataField dataField = toDataField(userId, field, funcEmpNo);
							dataField.setId(fieldId);
							resultStack.add(dataField);
							
						} else if (functionId.equals("mis:getMobileNo")){
							String funcMobileNo = func.getMobileNo();
							SwdDataField dataField = toDataField(userId, field, funcMobileNo);
							dataField.setId(fieldId);
							resultStack.add(dataField);
							
						} else if (functionId.equals("mis:getInternalNo")){
							String funcExtensionNo = func.getExtensionNo();
							SwdDataField dataField = toDataField(userId, field, funcExtensionNo);
							dataField.setId(fieldId);
							resultStack.add(dataField);
							
						}
				//web Service
					} else if ("service_form".equalsIgnoreCase(mappingFormType)) {
						//TODO web service
						
						
						
						
						
						
						
						
						
						
					} else if (SwfMapping.TYPE_EXPRESSION.equalsIgnoreCase(mappingFormType)) {
						String value = preMapping.getFieldName();
						value = StringUtils.replace(value, "'", "");
						SwdDataField dataField = toDataField(userId, field, value);
						dataField.setId(fieldId);
						resultStack.add(dataField);
					}
					
				} else if (SwfMapping.TYPE_EXPRESSION.equalsIgnoreCase(mappingType)) {
					//계산식
					
					
					
					
					
					
					
					
				}
				
				
				if (resultTreeMap != null) {
					TreeMap<Long, SwdDataField> sortMap = new TreeMap<Long, SwdDataField>(resultTreeMap);
					resultMap.put(fieldId, sortMap.get(sortMap.lastKey()) );
					newRecord.setDataField(fieldId, sortMap.get(sortMap.lastKey()));
				} else if (resultStack != null) {
					resultMap.put(fieldId, resultStack.pop());
					newRecord.setDataField(fieldId, resultStack.pop());
				} else {
					resultMap.put(fieldId, oldRecord.getDataField(fieldId));
					newRecord.setDataField(fieldId, oldRecord.getDataField(fieldId));
				}
			}
		
		}catch (Exception e){
			// Exception Handling Required
			e.printStackTrace();
			// Exception Handling Required			
		}
	}	
	private SwdDataField toDataField(String user, SwfField field, String id) throws Exception {
		if (CommonUtil.isEmpty(id))
			return null;
		SwfFormat fieldFormat = field.getFormat();
		SwdDataField obj = null;
		if (fieldFormat == null || !"userField".equals(fieldFormat.getType())) {
			obj = new SwdDataField();
			obj.setId(field.getId());
			obj.setType(field.getSystemType());
			obj.setValue(id);
		} else {
			obj = toUserDataField(user, id);
		}
		return obj;
	}
	private SwdDataField toUserDataField(String user, String id) throws Exception {
		if (CommonUtil.isEmpty(id))
			return null;
		SwoUser userModel = getSwoManager().getUser(user, id, IManager.LEVEL_LITE);
		if (userModel == null)
			return null;
		SwdDataField dataField = new SwdDataField();
		dataField.setRefForm("frm_user_SYSTEM");
		dataField.setRefFormField("4");
		dataField.setRefRecordId(id);
		dataField.setValue(userModel.getPosition() + " " + userModel.getName());
		return dataField;
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
						getDocManager().insertFiles(workType, "", groupId, fileId, fileName, fileSize);
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
			Map<String, Object> frmSmartFormMap = (Map<String, Object>)requestBody.get("frmSmartForm");
			Map<String, Object> frmAccessSpaceMap = (Map<String, Object>)requestBody.get("frmAccessSpace");
	
			String domainId = null; // domainId 가 없어도 내부 서버에서 폼아이디로 검색하여 저장
			String formId = (String)requestBody.get("formId");
			String formName = (String)requestBody.get("formName");
			String instanceId = (String)requestBody.get("instanceId");
			if(CommonUtil.isEmpty(instanceId))
				instanceId = "dr_" + CommonUtil.newId();
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
	
			Set<String> keySet = frmSmartFormMap.keySet();
			Iterator<String> itr = keySet.iterator();
			
	//		SwdField[] fieldDatas = new SwdField[keySet.size()];
			List fieldDataList = new ArrayList();
			List<Map<String, String>> files = null;
			List<Map<String, String>> users = null;
			String groupId = null;
			Map<String, List<Map<String, String>>> fileGroupMap = new HashMap<String, List<Map<String, String>>>();
			while (itr.hasNext()) {
				String fieldId = (String)itr.next();
				String value = null;
				String type = null;
				String refForm = null;
				String refFormField = null;
				String refRecordId = null;
				Object fieldValue = frmSmartFormMap.get(fieldId);
				if (fieldValue instanceof LinkedHashMap) {
					Map<String, Object> valueMap = (Map<String, Object>)fieldValue;
					groupId = (String)valueMap.get("groupId");
					refForm = (String)valueMap.get("refForm");
					users = (ArrayList<Map<String,String>>)valueMap.get("users");

					if(!CommonUtil.isEmpty(groupId)) {
						files = (ArrayList<Map<String,String>>)valueMap.get("files");
						if(!CommonUtil.isEmpty(files)) {
							fileGroupMap.put(groupId, files);
							value = groupId;
						}
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
					value = (String)frmSmartFormMap.get(fieldId);
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
						if(type.equals("datetime")) {
							if(value.length() == FieldData.SIZE_DATETIME)
								value = LocalDate.convertLocalDateTimeStringToLocalDate(value).toGMTDateString();
							else if(value.length() == FieldData.SIZE_DATE)
								value = LocalDate.convertLocalDateStringToLocalDate(value).toGMTDateString();
						} else if(type.equals("time")) {
							value = LocalDate.convertLocalTimeStringToLocalDate(value).toGMTTimeString2();
						}
					}
				} else if(fieldValue instanceof Integer) {
					value = (Integer)frmSmartFormMap.get(fieldId) + "";
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
	
			SwdDataField[] fieldDatas = new SwdDataField[fieldDataList.size()];
			fieldDataList.toArray(fieldDatas);
			SwdRecord obj = new SwdRecord();
			obj.setDomainId(domainId);
			obj.setFormId(formId);
			obj.setFormName(formName);
			obj.setFormVersion(formVersion);
			obj.setDataFields(fieldDatas);
			obj.setRecordId(instanceId);

			if(frmAccessSpaceMap != null) {
				keySet = frmAccessSpaceMap.keySet();
				itr = keySet.iterator();
	
				String workSpaceId = null;
				String workSpaceType = null;
				String accessLevel = null;
				String accessValue = null;
	
				while (itr.hasNext()) {
					String fieldId = (String)itr.next();
					Object fieldValue = frmAccessSpaceMap.get(fieldId);
					if (fieldValue instanceof LinkedHashMap) {
						Map<String, Object> valueMap = (Map<String, Object>)fieldValue;
						users = (ArrayList<Map<String,String>>)valueMap.get("users");
						if(!CommonUtil.isEmpty(users)) {
							String symbol = ";";
							if(users.size() == 1) {
								accessValue = users.get(0).get("id");
							} else {
								accessValue = "";
								for(int i=0; i < users.subList(0, users.size()).size(); i++) {
									Map<String, String> user = users.get(i);
									accessValue += user.get("id") + symbol;
								}
							}
						}
					} else if(fieldValue instanceof String) {
						if(fieldId.equals("selWorkSpace")) {
							workSpaceId = (String)fieldValue;
						} else if(fieldId.equals("selWorkSpaceType")) {
							workSpaceType = (String)fieldValue;
						} else if(fieldId.equals("selAccessLevel")) {
							accessLevel = (String)fieldValue;
						}
					}
				}

				obj.setWorkSpaceId(workSpaceId);
				obj.setWorkSpaceType(workSpaceType);
				obj.setAccessLevel(accessLevel);
				obj.setAccessValue(accessValue);
			}
			
			//TODO 좋은방법이 멀까?
			String servletPath = request.getServletPath();
			if(servletPath.equals("/upload_new_picture.sw")) {
				obj.setExtendedAttributeValue("tskRefType", TskTask.TASKREFTYPE_IMAGE);
			} else if (servletPath.equals("/upload_new_file.sw")) {
				obj.setExtendedAttributeValue("tskRefType", TskTask.TASKREFTYPE_FILE);
			} else if (servletPath.equals("/create_new_event.sw")) {
				obj.setExtendedAttributeValue("tskRefType", TskTask.TASKREFTYPE_EVENT);
			} else if (servletPath.equals("/create_new_memo.sw")) {
				obj.setExtendedAttributeValue("tskRefType", TskTask.TASKREFTYPE_MEMO);
			} else if (servletPath.equals("/create_new_board.sw")) {
				obj.setExtendedAttributeValue("tskRefType", TskTask.TASKREFTYPE_BOARD);
			}

			instanceId = getSwdManager().setRecord(userId, obj, IManager.LEVEL_ALL);

			TskTaskCond tskCond = new TskTaskCond();
			tskCond.setExtendedProperties(new Property[] {new Property("recordId", instanceId)});
			tskCond.setModificationUser(userId);
			tskCond.setOrders(new Order[]{new Order(TskTaskCond.A_CREATIONDATE, false)});
			TskTask[] tskTasks = getTskManager().getTasks(userId, tskCond, IManager.LEVEL_LITE);
			String taskInstId = tskTasks[0].getObjId();

			String workType = "";
			if(servletPath.equals("/upload_new_picture.sw")) workType = "Pictures";
			else workType = "Files";

			if(fileGroupMap.size() > 0) {
				for(Map.Entry<String, List<Map<String, String>>> entry : fileGroupMap.entrySet()) {
					String fileGroupId = entry.getKey();
					List<Map<String, String>> fileGroups = entry.getValue();

					try {
						for(int i=0; i < fileGroups.subList(0, fileGroups.size()).size(); i++) {
							Map<String, String> file = fileGroups.get(i);
							String fileId = file.get("fileId");
							String fileName = file.get("fileName");
							String fileSize = file.get("fileSize");
							getDocManager().insertFiles(workType, taskInstId, fileGroupId, fileId, fileName, fileSize);
						}
					} catch (Exception e) {
						throw new DocFileException("file upload fail...");
					}
				}
			}
			return instanceId;

		}catch (Exception e){
			e.printStackTrace();
			return null;			
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

	@Override
	public void addCommentOnWork(Map<String, Object> requestBody, HttpServletRequest request) throws Exception {

		try{
		}catch (Exception e){
			// Exception Handling Required
			e.printStackTrace();
			// Exception Handling Required			
		}
	}

	@Override
	public void addCommentOnInstance(Map<String, Object> requestBody, HttpServletRequest request) throws Exception {

		try{
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
						getDocManager().insertFiles(workType, "", groupId, fileId, fileName, fileSize);
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
			Map<String, List<Map<String, String>>> fileGroupMap = new HashMap<String, List<Map<String,String>>>();
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
						if(!CommonUtil.isEmpty(files)) {
							fileGroupMap.put(groupId, files);
							value = groupId;
						}
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

			SwdDataField[] fieldDatas = new SwdDataField[fieldDataList.size()];
			fieldDataList.toArray(fieldDatas);
			SwdRecord obj = new SwdRecord();
			obj.setDomainId(domainId);
			obj.setFormId(formId);
			obj.setFormName(formName);
			obj.setFormVersion(formVersion);
			obj.setDataFields(fieldDatas);
			obj.setRecordId(instanceId);
			obj.setFileGroupMap(fileGroupMap);

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
			Map<String, List<Map<String, String>>> fileGroupMap = null;
			if (recordObj != null) {
				taskDocument = recordObj.toString();
				fileGroupMap = recordObj.getFileGroupMap();
			}

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

			String taskInstId = task.getObjId();

			if(fileGroupMap.size() > 0) {
				for(Map.Entry<String, List<Map<String, String>>> entry : fileGroupMap.entrySet()) {
					String fileGroupId = entry.getKey();
					List<Map<String, String>> fileGroups = entry.getValue();

					try {
						for(int i=0; i < fileGroups.subList(0, fileGroups.size()).size(); i++) {
							Map<String, String> file = fileGroups.get(i);
							String fileId = file.get("fileId");
							String fileName = file.get("fileName");
							String fileSize = file.get("fileSize");
							getDocManager().insertFiles("Files", taskInstId, fileGroupId, fileId, fileName, fileSize);
						}
					} catch (Exception e) {
						throw new DocFileException("file upload fail...");
					}
				}
			}

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
	public CommentInstanceInfo[] getRecentCommentsInWorkManual(String workId, int length) throws Exception {
		try{
			if(length==WorkInstance.FETCH_ALL_SUB_INSTANCE)
				return SmartTest.getAllCommentInstances();
			else
				return SmartTest.getCommentInstances();
		}catch (Exception e){
			// Exception Handling Required
			e.printStackTrace();
			return null;			
			// Exception Handling Required			
		}
	}

	@Override
	public InstanceInfo[] getRecentSubInstancesInInstance(String instanceId, int length) throws Exception {
		try{
			if(length==WorkInstance.FETCH_ALL_SUB_INSTANCE)
				return SmartTest.getAllInstances();
			else
				return SmartTest.getInstances();
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

			SearchFilter searchFilter = params.getSearchFilter();
			List<Filter> filterList = new ArrayList<Filter>();
			if(searchFilter != null) {
				Condition[] conditions = searchFilter.getConditions();
				for(Condition condition : conditions) {
					Filter filter = new Filter();
	
					FormField leftOperand = condition.getLeftOperand();
					String formFieldId = leftOperand.getId();
					String tableColName = formFieldId;
					if(!formFieldId.equals(FormField.ID_OWNER) && !formFieldId.equals(FormField.ID_CREATED_DATE) && !formFieldId.equals(FormField.ID_LAST_MODIFIER) && !formFieldId.equals(FormField.ID_LAST_MODIFIED_DATE))
						tableColName = getSwdManager().getTableColName(swdDomain.getObjId(), formFieldId);

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
				} else {
					searchFilter = ModelConverter.getSearchFilterByFilterId(SwfFormModel.TYPE_SINGLE, workId, filterId);
					Condition[] conditions = searchFilter.getConditions();
					Filters filters = new Filters();
					filterList = new ArrayList<Filter>();
					for(Condition condition : conditions) {
						Filter filter = new Filter();
						FormField leftOperand = condition.getLeftOperand();
						String lefOperandType = leftOperand.getType();
						String operator = condition.getOperator();
						Object rightOperand = condition.getRightOperand();
						String rightOperandValue = "";
						if(rightOperand instanceof User) {
							rightOperandValue = ((User)rightOperand).getId();
						} else if(rightOperand instanceof Work) {
							rightOperandValue = ((Work)rightOperand).getId();
						} else {
							if(lefOperandType.equals(FormField.TYPE_DATETIME)) rightOperandValue = ((LocalDate)rightOperand).toGMTDateString();
							else if(lefOperandType.equals(FormField.TYPE_DATE)) rightOperandValue = ((LocalDate)rightOperand).toGMTSimpleDateString2();
							else if(lefOperandType.equals(FormField.TYPE_TIME)) rightOperandValue = ((LocalDate)rightOperand).toGMTTimeString2();
							else rightOperandValue = (String)rightOperand;
						}
						filter.setLeftOperandType(lefOperandType);
						filter.setLeftOperandValue(leftOperand.getId());
						filter.setOperator(operator);
						filter.setRightOperandType(lefOperandType);
						filter.setRightOperandValue(rightOperandValue);
						filterList.add(filter);
					}
					Filter[] searchfilters = null;
					if(filterList.size() != 0) {
						searchfilters = new Filter[filterList.size()];
						filterList.toArray(searchfilters);
						filters.setFilter(searchfilters);
					}
					swdRecordCond.addFilters(filters);
				}
			}

			String searchKey = params.getSearchKey();
			if(!CommonUtil.isEmpty(searchKey))
				swdRecordCond.setSearchKey(searchKey);

			long totalCount = getSwdManager().getRecordSize(user.getId(), swdRecordCond);

			SortingField sf = params.getSortingField();
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
			if(pageSize == 0) pageSize = 20;

			int currentPage = params.getCurrentPage();
			if(currentPage == 0) currentPage = 1;

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

			if(previousPageSize != pageSize)
				currentPage = 1;

			previousPageSize = pageSize;

			if((long)((pageSize * (currentPage - 1)) + 1) > totalCount)
				currentPage = 1;

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
				int swdRecordsLength = swdRecords.length;
				for(int i = 0; i < swdRecordsLength; i++) {
					IWInstanceInfo iWInstanceInfo = new IWInstanceInfo();
					SwdRecord swdRecord = swdRecords[i];
					iWInstanceInfo.setId(swdRecord.getRecordId());
					iWInstanceInfo.setOwner(ModelConverter.getUserInfoByUserId(swdRecord.getCreationUser()));
					int type = WorkInstance.TYPE_INFORMATION;
					iWInstanceInfo.setType(type);
					iWInstanceInfo.setStatus(WorkInstance.STATUS_COMPLETED);
					String workSpaceId = swdRecord.getWorkSpaceId();
					if(workSpaceId == null)
						workSpaceId = user.getId();

					WorkSpaceInfo workSpaceInfo = communityService.getWorkSpaceInfoById(workSpaceId);

					iWInstanceInfo.setWorkSpace(workSpaceInfo);

					WorkCategoryInfo groupInfo = null;
					if (!CommonUtil.isEmpty(swdRecordExtends[0].getSubCtgId()))
						groupInfo = new WorkCategoryInfo(swdRecordExtends[0].getSubCtgId(), swdRecordExtends[0].getSubCtg());
		
					WorkCategoryInfo categoryInfo = new WorkCategoryInfo(swdRecordExtends[0].getParentCtgId(), swdRecordExtends[0].getParentCtg());
		
					WorkInfo workInfo = new SmartWorkInfo(formId, formName, SmartWork.TYPE_INFORMATION, groupInfo, categoryInfo);
	
					iWInstanceInfo.setWork(workInfo);
					iWInstanceInfo.setLastModifier(ModelConverter.getUserInfoByUserId(swdRecord.getModificationUser()));
					iWInstanceInfo.setLastModifiedDate(new LocalDate((swdRecord.getModificationDate()).getTime()));
	
					SwdDataField[] swdDataFields = swdRecord.getDataFields();
					List<FieldData> fieldDataList = new ArrayList<FieldData>();

					if(!CommonUtil.isEmpty(swdDataFields)) {
						int swdDataFieldsLength = swdDataFields.length;
						for(int j=0; j<swdDataFieldsLength; j++) {
							SwdDataField swdDataField = swdDataFields[j];
							if(swdDataField.getId().equals(titleFieldId))
								iWInstanceInfo.setSubject(swdDataField.getValue());
							if(!CommonUtil.isEmpty(swfFields)) {
								int swfFieldsLength = swfFields.length;
								for(int k=0; k<swfFieldsLength; k++) {
									SwfField swfField = swfFields[k];
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
													if(!CommonUtil.isEmpty(users) && users.length > 0) {
														if(users.length < 4) {
															for(int l=0; l<users.length; l++) {
																resultUser += users[j] + ", ";
															}
															resultUser = resultUser.substring(0, resultUser.length()-2);
														} else if(users.length > 3) {
															for(int l=0; l<3; l++) {
																resultUser += users[j] + ", ";
															}
															resultUser = resultUser.substring(0, resultUser.length()-2);
															resultUser = resultUser + " " + SmartMessage.getString("content.sentence.with_other_users", (new Object[]{(users.length - 3)}));
														}
													}
													value = resultUser;
												}
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
												List<IFileModel> fileModelList = getDocManager().findFileGroup(value);
												List<Map<String, String>> fileList = new ArrayList<Map<String,String>>();
												int fileModelListLength = fileModelList.size();
												for(int l=0; l<fileModelListLength; l++) {
													Map<String, String> fileMap = new LinkedHashMap<String, String>();
													IFileModel fileModel = fileModelList.get(l);
													String fileId = fileModel.getId();
													String fileName = fileModel.getFileName();
													String fileType = fileModel.getType();
													String fileSize = fileModel.getFileSize() + "";
													fileMap.put("fileId", fileId);
													fileMap.put("fileName", fileName);
													fileMap.put("fileType", fileType);
													fileMap.put("fileSize", fileSize);
													fileList.add(fileMap);
												}
												if(fileList.size() > 0)
													fieldData.setFiles(fileList);
											} else if(formatType.equals(FormField.TYPE_TEXT)) {
												value = StringUtil.subString(value, 0, 30, "...");
											}
											fieldData.setValue(value);
											fieldDataList.add(fieldData);
										}
									}
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

			instanceInfoList.setTotalSize((int)totalCount);
			instanceInfoList.setSortedField(sortingField);
			instanceInfoList.setType(InstanceInfoList.TYPE_INFORMATION_INSTANCE_LIST);
			instanceInfoList.setPageSize(pageSize);
			instanceInfoList.setTotalPages(totalPages);
			instanceInfoList.setCurrentPage(currentPage);

			return instanceInfoList;
		} catch(Exception e){
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
					status = Instance.STATUS_RUNNING;
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
				
				WorkInfo workInfo = new SmartWorkInfo(prcInst.getPrcDid(), prcInst.getPrcName(), SmartWork.TYPE_PROCESS, groupInfo, categoryInfo);
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

			instanceInfoList.setTotalSize((int)totalCount);
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

	public InstanceInfoList getInstanceInfoListByRefType(String spaceId, RequestParams params, String refType, int displayBy, String parentId) throws Exception {

		try {
			User cUser = SmartUtil.getCurrentUser();
			String userId = cUser.getId();

			InstanceInfoList instanceInfoList = new InstanceInfoList();

			TaskWorkCond taskWorkCond = new TaskWorkCond();
			taskWorkCond.setTskRefType(refType);
			//taskWorkCond.setTskWorkSpaceType(spaceType + "");
			taskWorkCond.setTskWorkSpaceId(spaceId);

			long totalCount = getWlmManager().getTaskWorkListSize(userId, taskWorkCond);

			int pageSize = params.getPageSize();
			if(pageSize == 0) pageSize = 20;

			int currentPage = params.getCurrentPage();
			if(currentPage == 0) currentPage = 1;

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

			if(previousPageSize != pageSize)
				currentPage = 1;

			previousPageSize = pageSize;

			if((long)((pageSize * (currentPage - 1)) + 1) > totalCount)
				currentPage = 1;

			if (currentPage > 0)
				taskWorkCond.setPageNo(currentPage-1);

			taskWorkCond.setPageSize(pageSize);

			taskWorkCond.setOrders(new Order[]{new Order("tskCreatedate", false)});

			TaskWork[] taskWorks = getWlmManager().getTaskWorkList(userId, taskWorkCond);

			WorkInstanceInfo[] workInstanceInfos = ModelConverter.getWorkInstanceInfosByTaskWorks(taskWorks);

			instanceInfoList.setTotalSize((int)totalCount);
			instanceInfoList.setInstanceDatas(workInstanceInfos);
			instanceInfoList.setType(InstanceInfoList.TYPE_INFORMATION_INSTANCE_LIST);
			instanceInfoList.setPageSize(pageSize);
			instanceInfoList.setTotalPages(totalPages);
			instanceInfoList.setCurrentPage(currentPage);

			return instanceInfoList;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public InstanceInfoList getWorkInstanceList(String workSpaceId, RequestParams params) throws Exception {
		return getInstanceInfoListByRefType(workSpaceId, params, TskTask.TASKREFTYPE_NOTHING, -1, "");
	}

	
	public InstanceInfoList getImageInstanceList(String workSpaceId, RequestParams params) throws Exception {
		return getInstanceInfoListByRefType(workSpaceId, params, TskTask.TASKREFTYPE_IMAGE, -1, "");
	}

	public InstanceInfoList getInstanceInfoListByImageList(String workSpaceId, RequestParams params, int displayBy, String parentId) {
		try {
			User cUser = SmartUtil.getCurrentUser();
			String userId = cUser.getId();

			InstanceInfoList instanceInfoList = new InstanceInfoList();

			FileWorkCond fileWorkCond = new FileWorkCond();
			fileWorkCond.setTskAssigneeOrSpaceId(workSpaceId);
			fileWorkCond.setTskRefType(TskTask.TASKREFTYPE_IMAGE);

			switch (displayBy) {
			case FileCategory.DISPLAY_BY_CATEGORY:
				fileWorkCond.setFolderId(parentId);
				break;
			case FileCategory.DISPLAY_BY_YEAR:
				fileWorkCond.setWrittenTimeMonthString(parentId);
				break;
			case FileCategory.DISPLAY_BY_OWNER:
				fileWorkCond.setTskAssignee(parentId);
				break;
			}

			long totalCount = getDocManager().getFileWorkListSize(userId, fileWorkCond);

			SortingField sf = params.getSortingField();
			String columnName = "";
			boolean isAsc;

			if (sf != null) {
				String defaultSortingField = sf.getFieldId();
				if(defaultSortingField.equals(FormField.ID_LAST_MODIFIED_DATE))
					defaultSortingField = "taskLastModifyDate";
				columnName  = CommonUtil.toDefault(defaultSortingField, FormField.ID_LAST_MODIFIED_DATE);
				isAsc = sf.isAscending();
			} else {
				columnName = "taskLastModifyDate";
				isAsc = false;
			}
			SortingField sortingField = new SortingField();
			sortingField.setFieldId(columnName);
			sortingField.setAscending(isAsc);

			fileWorkCond.setOrders(new Order[]{new Order(columnName, isAsc)});

			int pageSize = params.getPageSize();
			if(pageSize == 0) pageSize = 20;

			int currentPage = params.getCurrentPage();
			if(currentPage == 0) currentPage = 1;

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

			if(previousPageSize != pageSize)
				currentPage = 1;

			previousPageSize = pageSize;

			if((long)((pageSize * (currentPage - 1)) + 1) > totalCount)
				currentPage = 1;

			if (currentPage > 0)
				fileWorkCond.setPageNo(currentPage-1);

			fileWorkCond.setPageSize(pageSize);
			//fileWorkCond.setOrders(new Order[]{new Order("tskCreatedate", false)});

			FileWork[] fileWorks = getDocManager().getFileWorkList(userId, fileWorkCond);
			WorkInstanceInfo[] workInstanceInfos = null;
			if(!CommonUtil.isEmpty(fileWorks)) {
				workInstanceInfos = ModelConverter.getWorkInstanceInfosByFileWorks(fileWorks, TskTask.TASKREFTYPE_IMAGE, displayBy);
			}

/*			List<WorkInstanceInfo> newWorkInstanceInfoList = new ArrayList<WorkInstanceInfo>();
			for(WorkInstanceInfo workInstanceInfo : workInstanceInfos) {
				ImageInstanceInfo imageInstanceInfo = (ImageInstanceInfo)workInstanceInfo;
				if(imageInstanceInfo.getFileCategory().getId().equals(parentId)) {
					newWorkInstanceInfoList.add(workInstanceInfo);
				}
			}
			if(newWorkInstanceInfoList.size() > 0) {
				workInstanceInfos = new WorkInstanceInfo[newWorkInstanceInfoList.size()];
				newWorkInstanceInfoList.toArray(workInstanceInfos);
			} else {
				workInstanceInfos = null;
			}*/

			instanceInfoList.setTotalSize((int)totalCount);
			instanceInfoList.setInstanceDatas(workInstanceInfos);
			instanceInfoList.setType(InstanceInfoList.TYPE_INFORMATION_INSTANCE_LIST);
			instanceInfoList.setPageSize(pageSize);
			instanceInfoList.setTotalPages(totalPages);
			instanceInfoList.setCurrentPage(currentPage);

			return instanceInfoList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public ImageInstanceInfo[] getImageInstancesByDate(int displayBy, String wid, String parentId, LocalDate lastDate, int maxCount) throws Exception{

		ImageInstanceInfo[] imageInstanceInfos = null;
		RequestParams params = new RequestParams();
		params.setPageSize(maxCount);
		InstanceInfoList instanceInfoList = getInstanceInfoListByImageList(wid, params, displayBy, parentId);
		if(instanceInfoList != null) {
			WorkInstanceInfo[] workInstanceInfos = (WorkInstanceInfo[])instanceInfoList.getInstanceDatas();
			if(!CommonUtil.isEmpty(workInstanceInfos)) {
				int workInstanceInfosLength = workInstanceInfos.length;
				imageInstanceInfos = new ImageInstanceInfo[workInstanceInfosLength];
				for(int i=0; i<workInstanceInfosLength; i++) {
					ImageInstanceInfo imageInstanceInfo = (ImageInstanceInfo)workInstanceInfos[i];
					imageInstanceInfos[i] = imageInstanceInfo;
				}
				return imageInstanceInfos;
			}
		}
		return null;

	}

	public InstanceInfoList getInstanceInfoListByFileList(String workSpaceId, RequestParams params, int displayBy) {
		try {
			User cUser = SmartUtil.getCurrentUser();
			String userId = cUser.getId();

			InstanceInfoList instanceInfoList = new InstanceInfoList();

			FileWorkCond fileWorkCond = new FileWorkCond();
			fileWorkCond.setTskAssigneeOrSpaceId(workSpaceId);

			SearchFilter searchFilter = params.getSearchFilter();
			if(searchFilter != null) {
				Condition[] conditions = searchFilter.getConditions();
				if(!CommonUtil.isEmpty(conditions) && conditions.length == 1) {
					Condition condition = conditions[0];
					String rightOperand = String.valueOf(condition.getRightOperand());
					if(!rightOperand.equals(FileCategory.ID_ALL_FILES)) {
						switch (displayBy) {
						case FileCategory.DISPLAY_BY_CATEGORY:
							fileWorkCond.setFolderId(rightOperand);
							break;
						case FileCategory.DISPLAY_BY_WORK:
							fileWorkCond.setPackageId(rightOperand);
							break;
						case FileCategory.DISPLAY_BY_YEAR:
							fileWorkCond.setWrittenTimeMonthString(rightOperand);
							break;
						case FileCategory.DISPLAY_BY_OWNER:
							fileWorkCond.setTskAssignee(rightOperand);
							break;
						case FileCategory.DISPLAY_BY_FILE_TYPE:
							fileWorkCond.setFileType(rightOperand);
							break;
						}
					}
				}
			}

			/*SearchFilter searchFilter = params.getSearchFilter();
			if(searchFilter != null) {
				Condition[] conditions = searchFilter.getConditions();
				Filters filters = new Filters();
				List<Filter> filterList = new ArrayList<Filter>();
				for(Condition condition : conditions) {
					Filter filter = new Filter();
					FormField leftOperand = condition.getLeftOperand();
					String leftOperandValue = leftOperand.getId();
					String operator = condition.getOperator();
					Object rightOperand = condition.getRightOperand();
					String rightOperandValue = String.valueOf(rightOperand);
					if(!rightOperandValue.equals(FileCategory.ID_ALL_FILES)) {
						if(leftOperandValue.equals(FormField.ID_FILE_CATEGORY)) leftOperandValue = "folderId";
						else if(leftOperandValue.equals(FormField.ID_WORK)) leftOperandValue = "form.packageId";
						else if(leftOperandValue.equals(FormField.ID_CREATED_DATE)) leftOperandValue = "writtenTime";
						else if(leftOperandValue.equals(FormField.ID_OWNER)) leftOperandValue = "tskassignee";
						else if(leftOperandValue.equals(FormField.ID_FILE_TYPE)) leftOperandValue = "docfile.type";
						filter.setLeftOperandValue(leftOperandValue);
						filter.setOperator(operator);
						filter.setRightOperandValue(rightOperandValue);
						filterList.add(filter);
					}
				}

				Filter[] searchfilters = null;
				if(filterList.size() != 0) {
					searchfilters = new Filter[filterList.size()];
					filterList.toArray(searchfilters);
					filters.setFilter(searchfilters);
				}
				fileWorkCond.addFilters(filters);
			}*/

			long totalCount = getDocManager().getFileWorkListSize(userId, fileWorkCond);

			SortingField sf = params.getSortingField();
			String columnName = "";
			boolean isAsc;

			if (sf != null) {
				String defaultSortingField = sf.getFieldId();
				if(defaultSortingField.equals(FormField.ID_LAST_MODIFIED_DATE))
					defaultSortingField = "taskLastModifyDate";
				columnName  = CommonUtil.toDefault(defaultSortingField, FormField.ID_LAST_MODIFIED_DATE);
				isAsc = sf.isAscending();
			} else {
				columnName = "taskLastModifyDate";
				isAsc = false;
			}
			SortingField sortingField = new SortingField();
			sortingField.setFieldId(columnName);
			sortingField.setAscending(isAsc);

			fileWorkCond.setOrders(new Order[]{new Order(columnName, isAsc)});

			int pageSize = params.getPageSize();
			if(pageSize == 0) pageSize = 20;

			int currentPage = params.getCurrentPage();
			if(currentPage == 0) currentPage = 1;

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

			if(previousPageSize != pageSize)
				currentPage = 1;

			previousPageSize = pageSize;

			if((long)((pageSize * (currentPage - 1)) + 1) > totalCount)
				currentPage = 1;

			if (currentPage > 0)
				fileWorkCond.setPageNo(currentPage-1);

			fileWorkCond.setPageSize(pageSize);
			//fileWorkCond.setOrders(new Order[]{new Order("tskCreatedate", false)});

			FileWork[] fileWorks = getDocManager().getFileWorkList(userId, fileWorkCond);
			WorkInstanceInfo[] workInstanceInfos = null;
			if(!CommonUtil.isEmpty(fileWorks)) {
				workInstanceInfos = ModelConverter.getWorkInstanceInfosByFileWorks(fileWorks, TskTask.TASKREFTYPE_FILE, 0);
			}

			instanceInfoList.setTotalSize((int)totalCount);
			instanceInfoList.setInstanceDatas(workInstanceInfos);
			instanceInfoList.setType(InstanceInfoList.TYPE_INFORMATION_INSTANCE_LIST);
			instanceInfoList.setPageSize(pageSize);
			instanceInfoList.setTotalPages(totalPages);
			instanceInfoList.setCurrentPage(currentPage);

			return instanceInfoList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public InstanceInfoList getFileInstanceList(String workSpaceId, RequestParams params) throws Exception {
		SearchFilter searchFilter = params.getSearchFilter();
		int displayBy = 0;
		if(searchFilter != null) {
			 String searchFilterId = searchFilter.getId();
			 if(searchFilterId.equals(SearchFilter.FILTER_BY_FILE_CATEGORY_ID)) displayBy = FileCategory.DISPLAY_BY_CATEGORY;
			 if(searchFilterId.equals(SearchFilter.FILTER_BY_WORK_ID)) displayBy = FileCategory.DISPLAY_BY_WORK;
			 if(searchFilterId.equals(SearchFilter.FILTER_BY_CREATED_DATE)) displayBy = FileCategory.DISPLAY_BY_YEAR;
			 if(searchFilterId.equals(SearchFilter.FILTER_BY_OWNER)) displayBy = FileCategory.DISPLAY_BY_OWNER;
			 if(searchFilterId.equals(SearchFilter.FILTER_BY_FILE_TYPE)) displayBy = FileCategory.DISPLAY_BY_FILE_TYPE;
		}
		return getInstanceInfoListByFileList(workSpaceId, params, displayBy);
	}

	public EventInstanceInfo[] getEventInstanceList(String workSpaceId, LocalDate fromDate, LocalDate toDate) throws Exception {
		return calendarService.getEventInstanceInfosByWorkSpaceId(workSpaceId, fromDate, toDate);
	}

	public InstanceInfoList getMemoInstanceList(String workSpaceId, RequestParams params) throws Exception {
		return getInstanceInfoListByRefType(workSpaceId, params, TskTask.TASKREFTYPE_MEMO, -1, "");
	}

	public InstanceInfoList getBoardInstanceList(String workSpaceId, RequestParams params) throws Exception {
		return getInstanceInfoListByRefType(workSpaceId, params, TskTask.TASKREFTYPE_BOARD, -1, "");
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

			if((int)totalCount == 0)
				currentPage = 0;

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
	private Map getLongTimeByTodayWorkHour(SwcWorkHour workHour) throws Exception {
		//type = start, end
		long workStartTime = 30600000;//오전 8시30분의 밀리세컨드
		long workEndTime = 64800000;//오후 6시00분의 밀리세컨드
		
		if (workHour != null) {
			Calendar now = Calendar.getInstance();
			Calendar tempDate = Calendar.getInstance();
			Date startDate = null;
			Date endDate = null;
			int day = now.get(Calendar.DAY_OF_WEEK);
			switch (day) {  
			   case 1 :
				   // "일" ;
				   startDate = workHour.getSunStartTime();
				   endDate = workHour.getSunEndTime();
				   tempDate.setTime(startDate);
				   workStartTime = (tempDate.get(Calendar.HOUR_OF_DAY) * 60 * 60 * 1000) + (tempDate.get(Calendar.MINUTE) * 60 * 1000) 
						   + (tempDate.get(Calendar.SECOND) * 1000) + (tempDate.get(Calendar.MILLISECOND));
				   tempDate.setTime(endDate);
				   workEndTime =  (tempDate.get(Calendar.HOUR_OF_DAY) * 60 * 60 * 1000) + (tempDate.get(Calendar.MINUTE) * 60 * 1000) 
						   + (tempDate.get(Calendar.SECOND) * 1000) + (tempDate.get(Calendar.MILLISECOND));
				   break ;
			   case 2 :
				   // "월" ;
				   startDate = workHour.getMonStartTime();
				   endDate = workHour.getMonEndTime();
				   tempDate.setTime(startDate);
				   workStartTime = (tempDate.get(Calendar.HOUR_OF_DAY) * 60 * 60 * 1000) + (tempDate.get(Calendar.MINUTE) * 60 * 1000) 
						   + (tempDate.get(Calendar.SECOND) * 1000) + (tempDate.get(Calendar.MILLISECOND));
				   tempDate.setTime(endDate);
				   workEndTime =  (tempDate.get(Calendar.HOUR_OF_DAY) * 60 * 60 * 1000) + (tempDate.get(Calendar.MINUTE) * 60 * 1000) 
						   + (tempDate.get(Calendar.SECOND) * 1000) + (tempDate.get(Calendar.MILLISECOND));
				   break ;
			   case 3 :
				   // "화" ;
				   startDate = workHour.getTueStartTime();
				   endDate = workHour.getTueEndTime();
				   tempDate.setTime(startDate);
				   workStartTime = (tempDate.get(Calendar.HOUR_OF_DAY) * 60 * 60 * 1000) + (tempDate.get(Calendar.MINUTE) * 60 * 1000) 
						   + (tempDate.get(Calendar.SECOND) * 1000) + (tempDate.get(Calendar.MILLISECOND));
				   tempDate.setTime(endDate);
				   workEndTime =  (tempDate.get(Calendar.HOUR_OF_DAY) * 60 * 60 * 1000) + (tempDate.get(Calendar.MINUTE) * 60 * 1000) 
						   + (tempDate.get(Calendar.SECOND) * 1000) + (tempDate.get(Calendar.MILLISECOND));
				   break ;
			   case 4 :
				   // "수" ;
				   startDate = workHour.getWedStartTime();
				   endDate = workHour.getWedEndTime();
				   tempDate.setTime(startDate);
				   workStartTime = (tempDate.get(Calendar.HOUR_OF_DAY) * 60 * 60 * 1000) + (tempDate.get(Calendar.MINUTE) * 60 * 1000) 
						   + (tempDate.get(Calendar.SECOND) * 1000) + (tempDate.get(Calendar.MILLISECOND));
				   tempDate.setTime(endDate);
				   workEndTime =  (tempDate.get(Calendar.HOUR_OF_DAY) * 60 * 60 * 1000) + (tempDate.get(Calendar.MINUTE) * 60 * 1000) 
						   + (tempDate.get(Calendar.SECOND) * 1000) + (tempDate.get(Calendar.MILLISECOND));
				   break ;
			  
			   case 5 :
				   // "목" ;
				   startDate = workHour.getThuStartTime();
				   endDate = workHour.getThuEndTime();
				   tempDate.setTime(startDate);
				   workStartTime = (tempDate.get(Calendar.HOUR_OF_DAY) * 60 * 60 * 1000) + (tempDate.get(Calendar.MINUTE) * 60 * 1000) 
						   + (tempDate.get(Calendar.SECOND) * 1000) + (tempDate.get(Calendar.MILLISECOND));
				   tempDate.setTime(endDate);
				   workEndTime =  (tempDate.get(Calendar.HOUR_OF_DAY) * 60 * 60 * 1000) + (tempDate.get(Calendar.MINUTE) * 60 * 1000) 
						   + (tempDate.get(Calendar.SECOND) * 1000) + (tempDate.get(Calendar.MILLISECOND));
				   break ;
			   case 6 :
				   // "금" ;
				   startDate = workHour.getFriStartTime();
				   endDate = workHour.getFriEndTime();
				   tempDate.setTime(startDate);
				   workStartTime = (tempDate.get(Calendar.HOUR_OF_DAY) * 60 * 60 * 1000) + (tempDate.get(Calendar.MINUTE) * 60 * 1000) 
						   + (tempDate.get(Calendar.SECOND) * 1000) + (tempDate.get(Calendar.MILLISECOND));
				   tempDate.setTime(endDate);
				   workEndTime =  (tempDate.get(Calendar.HOUR_OF_DAY) * 60 * 60 * 1000) + (tempDate.get(Calendar.MINUTE) * 60 * 1000) 
						   + (tempDate.get(Calendar.SECOND) * 1000) + (tempDate.get(Calendar.MILLISECOND));
				   break ;
			   case 7 :
				   // "토" ;  
				   startDate = workHour.getSatStartTime();
				   endDate = workHour.getSatEndTime();
				   tempDate.setTime(startDate);
				   workStartTime = (tempDate.get(Calendar.HOUR_OF_DAY) * 60 * 60 * 1000) + (tempDate.get(Calendar.MINUTE) * 60 * 1000) 
						   + (tempDate.get(Calendar.SECOND) * 1000) + (tempDate.get(Calendar.MILLISECOND));
				   tempDate.setTime(endDate);
				   workEndTime =  (tempDate.get(Calendar.HOUR_OF_DAY) * 60 * 60 * 1000) + (tempDate.get(Calendar.MINUTE) * 60 * 1000) 
						   + (tempDate.get(Calendar.SECOND) * 1000) + (tempDate.get(Calendar.MILLISECOND));
			  }
		}
		Map resultMap = new HashMap();
		resultMap.put("startTime", workStartTime);
		resultMap.put("endTime", workEndTime);
		return resultMap;
	}
	
	private TaskWork[] getTaskWorkByFromToDate(String contextId, String spaceId, Date fromDate, Date toDate, int maxSize) throws Exception {
		User cuser = SmartUtil.getCurrentUser();
		String userId = null;
		String companyId = null;
		if (cuser != null) {
			userId = cuser.getId();
			companyId = cuser.getCompanyId();
		}
		if (CommonUtil.isEmpty(contextId) || CommonUtil.isEmpty(spaceId) || CommonUtil.isEmpty(companyId))
			return null;
		
		//해당 날짜의 인스턴스를 조회 한다
		//사용자 공간(contextId = us.sp) 일경우는 task의 assignee(owner)가 spaceId 인것들을 조회 하고 
		//이외의 것들(부서, 그룹... 등의 공간) 일경우는 task의 spaceId 가 spaceId 인것을을 조회 한다
		TaskWorkCond taskWorkCond = new TaskWorkCond();
		if (contextId.equalsIgnoreCase("us.sp")) {
			
			//커런트 유져와 공간아이디가 같다면
			//assignee가 유져아이디 와 spaceid가 유져아이디인 테스크를 조회한다
			//커런트 유져와 공간아이디가 같지 않다면
			//spaceid가 공간아이디인 테스크를 조회한다
			if (userId.equalsIgnoreCase(spaceId)) {
				taskWorkCond.setTskAssigneeOrSpaceId(spaceId);
			} else {
				taskWorkCond.setTskWorkSpaceId(spaceId);
			}
		} else {
			taskWorkCond.setTskWorkSpaceId(spaceId);
		}
		
		taskWorkCond.setTskExecuteDateFrom(fromDate);
		taskWorkCond.setTskExecuteDateTo(toDate);
		
		taskWorkCond.setOrders(new Order[]{new Order("tskcreatedate", true)});
		
//		taskWorkCond.setPageNo(0);
//		taskWorkCond.setPageSize(maxSize);

		TaskWork[] tasks = getWlmManager().getTaskWorkList(userId, taskWorkCond);
		
		return tasks;
	}
	
	@Override
	public TaskInstanceInfo[][] getTaskInstancesByWorkHours(String contextId, String spaceId, LocalDate date, int maxSize) throws Exception {
		try{
			User cuser = SmartUtil.getCurrentUser();
			String userId = null;
			String companyId = null;
			if (cuser != null) {
				userId = cuser.getId();
				companyId = cuser.getCompanyId();
			}
			if (CommonUtil.isEmpty(contextId) || CommonUtil.isEmpty(spaceId) || CommonUtil.isEmpty(companyId))
				return null;

			Date tempFromDate = null;
			Date tempToDate = null;
			if (date != null) {
				tempFromDate = new Date();
				tempToDate = new Date();

				tempFromDate.setTime(date.getLocalTime());
				tempToDate.setTime(date.getLocalTime());
				
				tempFromDate = DateUtil.toFromDate(tempFromDate, DateUtil.CYCLE_DAY);
				tempFromDate.setTime(tempFromDate.getTime() - TimeZone.getDefault().getRawOffset());
				
				tempToDate = DateUtil.toToDate(tempToDate, DateUtil.CYCLE_DAY);
				tempToDate.setTime(tempToDate.getTime() - TimeZone.getDefault().getRawOffset());
			}
			
			TaskWork[] tasks = getTaskWorkByFromToDate(contextId, spaceId, tempFromDate, tempToDate, maxSize);
			if (tasks == null)
				return null;
			//회사 워크아워 정책을 조회 한다
			SwcWorkHourCond workHourCond = new SwcWorkHourCond();
			workHourCond.setCompanyId(companyId);
			SwcWorkHour[] workHours = getSwcManager().getWorkhours(userId, workHourCond, IManager.LEVEL_LITE);
			Map workHourTimeMap = null;
			if (workHours == null || workHours.length == 0) {
				workHourTimeMap = getLongTimeByTodayWorkHour(null);
			} else {
				workHourTimeMap = getLongTimeByTodayWorkHour(workHours[0]);
			}
			//업무 시간 전, 업무시간, 업무시간 후로 인스턴스를 분류 한다
			
			List<TaskWork> beforeWorkTimeList = new ArrayList<TaskWork>();
			List<TaskWork> workTimeList = new ArrayList<TaskWork>();
			List<TaskWork> afterWorkTimeList = new ArrayList<TaskWork>();
			if (tasks != null & tasks.length != 0) {
				for (int i = 0; i < tasks.length; i++) {
					TaskWork task = tasks[i];
					Date executeDate = task.getTaskLastModifyDate();
					LocalDate localExecuteDate = new LocalDate(executeDate.getTime());
					
					Calendar cal = Calendar.getInstance();
					cal.setTime(new Date(localExecuteDate.getLocalDate()));
					
					long executeTime = (cal.get(Calendar.HOUR_OF_DAY) * 60 * 60 * 1000) + (cal.get(Calendar.MINUTE) * 60 * 1000) 
					   + (cal.get(Calendar.SECOND) * 1000) + (cal.get(Calendar.MILLISECOND));
					
					if (executeTime < (Long)workHourTimeMap.get("startTime")) {
						beforeWorkTimeList.add(task);
					} else if (executeTime < (Long)workHourTimeMap.get("endTime") && executeTime > (Long)workHourTimeMap.get("startTime")) {
						workTimeList.add(task);
					} else {
						afterWorkTimeList.add(task);
					}
				}
			}
			TaskInstanceInfo[] beforeTaskInstanceInfo = null;
			TaskInstanceInfo[] taskInstanceInfo = null;
			TaskInstanceInfo[] afterInstanceInfo = null;
			
			if (beforeWorkTimeList.size() != 0) {
				TaskWork[] taskArray = new TaskWork[beforeWorkTimeList.size()];
				beforeWorkTimeList.toArray(taskArray);
				beforeTaskInstanceInfo = (TaskInstanceInfo[])ModelConverter.getTaskInstanceInfoArrayByTaskWorkArray(userId, taskArray);
				
				if (beforeTaskInstanceInfo != null && beforeTaskInstanceInfo.length > maxSize) {
					TaskInstanceInfo[] tempTaskInstanceInfo = new TaskInstanceInfo[maxSize + 1];
					for (int i = 0; i < maxSize; i++) {
						tempTaskInstanceInfo[i] = beforeTaskInstanceInfo[i];
					}
					TaskInstanceInfo moreInstance = new TaskInstanceInfo();
					moreInstance.setType(-21);
					tempTaskInstanceInfo[maxSize] = moreInstance;
					beforeTaskInstanceInfo = tempTaskInstanceInfo;
				}
			}
			if (workTimeList.size() != 0) {
				TaskWork[] taskArray = new TaskWork[workTimeList.size()];
				workTimeList.toArray(taskArray);
				taskInstanceInfo = (TaskInstanceInfo[])ModelConverter.getTaskInstanceInfoArrayByTaskWorkArray(userId, taskArray);
				
				if (taskInstanceInfo != null && taskInstanceInfo.length > maxSize) {
					TaskInstanceInfo[] tempTaskInstanceInfo = new TaskInstanceInfo[maxSize + 1];
					for (int i = 0; i < maxSize; i++) {
						tempTaskInstanceInfo[i] = taskInstanceInfo[i];
					}
					TaskInstanceInfo moreInstance = new TaskInstanceInfo();
					moreInstance.setType(-21);
					tempTaskInstanceInfo[maxSize] = moreInstance;
					taskInstanceInfo = tempTaskInstanceInfo;
				}
				
			}
			if (afterWorkTimeList.size() != 0) {
				TaskWork[] taskArray = new TaskWork[afterWorkTimeList.size()];
				afterWorkTimeList.toArray(taskArray);
				afterInstanceInfo = (TaskInstanceInfo[])ModelConverter.getTaskInstanceInfoArrayByTaskWorkArray(userId, taskArray);
				
				if (afterInstanceInfo != null && afterInstanceInfo.length > maxSize) {
					TaskInstanceInfo[] tempTaskInstanceInfo = new TaskInstanceInfo[maxSize + 1];
					for (int i = 0; i < maxSize; i++) {
						tempTaskInstanceInfo[i] = afterInstanceInfo[i];
					}
					TaskInstanceInfo moreInstance = new TaskInstanceInfo();
					moreInstance.setType(-21);
					tempTaskInstanceInfo[maxSize] = moreInstance;
					afterInstanceInfo = tempTaskInstanceInfo;
				}
			}	
			
			//리턴타입으로 생성후 리턴한다
			
			return new TaskInstanceInfo[][]{beforeTaskInstanceInfo, taskInstanceInfo, afterInstanceInfo};
			
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
			User cuser = SmartUtil.getCurrentUser();
			String userId = null;
			String companyId = null;
			if (cuser != null) {
				userId = cuser.getId();
				companyId = cuser.getCompanyId();
			}
			if (CommonUtil.isEmpty(contextId) || CommonUtil.isEmpty(spaceId) || CommonUtil.isEmpty(companyId))
				return null;
			
			Date tempFromDate = null;
			Date tempToDate = null;
			if (fromDate != null) {
				tempFromDate = new Date();
				tempFromDate.setTime(fromDate.getLocalTime());
				tempFromDate = DateUtil.toFromDate(tempFromDate, DateUtil.CYCLE_DAY);
				tempFromDate.setTime(tempFromDate.getTime() - TimeZone.getDefault().getRawOffset());
			} 
			if (toDate != null) {
				tempToDate = new Date();
				tempToDate.setTime(toDate.getLocalTime());
				tempToDate = DateUtil.toToDate(tempToDate, DateUtil.CYCLE_DAY);
				tempToDate.setTime(tempToDate.getTime() - TimeZone.getDefault().getRawOffset());
			}
			
			TaskWork[] tasks = getTaskWorkByFromToDate(contextId, spaceId, tempFromDate, tempToDate, maxSize);

			//회사 워크아워 정책을 조회 한다
			SwcWorkHourCond workHourCond = new SwcWorkHourCond();
			workHourCond.setCompanyId(companyId);
			SwcWorkHour[] workHours = getSwcManager().getWorkhours(userId, workHourCond, IManager.LEVEL_LITE);
			
			int startOfWeek = 2;
			if (workHours != null && workHours.length != 0)
				startOfWeek = Integer.parseInt(workHours[0].getStartDayOfWeek());
			
			Map<Integer, Integer> dayOfWeekMappingMap = new HashMap<Integer, Integer>();
			int weekNum = startOfWeek;
			for (int i = 1; i <= 7; i++) {
				dayOfWeekMappingMap.put(weekNum, i);
				if (weekNum == 7) {
					weekNum = 1;
				} else {
					weekNum = weekNum + 1;
				}
			}
			List instanceInfoList1 = new ArrayList();
			List instanceInfoList2 = new ArrayList();
			List instanceInfoList3 = new ArrayList();
			List instanceInfoList4 = new ArrayList();
			List instanceInfoList5 = new ArrayList();
			List instanceInfoList6 = new ArrayList();
			List instanceInfoList7 = new ArrayList();
			
			if (tasks != null && tasks.length != 0) {
				for (int i = 0; i < tasks.length; i++) {
					Date executeDate = tasks[i].getTaskLastModifyDate();
					LocalDate temp = new LocalDate(executeDate.getTime());
					
					switch (dayOfWeekMappingMap.get(temp.getDayOfWeek())) {
					case 1:
						instanceInfoList1.add(tasks[i]);
						break;
					case 2:
						instanceInfoList2.add(tasks[i]);
						break;
					case 3:
						instanceInfoList3.add(tasks[i]);
						break;
					case 4:
						instanceInfoList4.add(tasks[i]);
						break;
					case 5:
						instanceInfoList5.add(tasks[i]);
						break;
					case 6:
						instanceInfoList6.add(tasks[i]);
						break;
					case 7:
						instanceInfoList7.add(tasks[i]);
						break;
					}
				}
			}

			TaskInstanceInfo[] instanceInfo1 = null;
			TaskInstanceInfo[] instanceInfo2 = null;
			TaskInstanceInfo[] instanceInfo3 = null;
			TaskInstanceInfo[] instanceInfo4 = null;
			TaskInstanceInfo[] instanceInfo5 = null;
			TaskInstanceInfo[] instanceInfo6 = null;
			TaskInstanceInfo[] instanceInfo7 = null;
			
	
			if (instanceInfoList1.size() != 0) {
				TaskWork[] taskArray = new TaskWork[instanceInfoList1.size()];
				instanceInfoList1.toArray(taskArray);
				instanceInfo1 = (TaskInstanceInfo[])ModelConverter.getTaskInstanceInfoArrayByTaskWorkArray(userId, taskArray);
				
				if (instanceInfo1 != null && instanceInfo1.length > maxSize) {
					TaskInstanceInfo[] tempTaskInstanceInfo = new TaskInstanceInfo[maxSize + 1];
					for (int i = 0; i < maxSize; i++) {
						tempTaskInstanceInfo[i] = instanceInfo1[i];
					}
					TaskInstanceInfo moreInstance = new TaskInstanceInfo();
					moreInstance.setType(-21);
					tempTaskInstanceInfo[maxSize] = moreInstance;
					instanceInfo1 = tempTaskInstanceInfo;
				}
				
			}
			if (instanceInfoList2.size() != 0) {
				TaskWork[] taskArray = new TaskWork[instanceInfoList2.size()];
				instanceInfoList2.toArray(taskArray);
				instanceInfo2 = (TaskInstanceInfo[])ModelConverter.getTaskInstanceInfoArrayByTaskWorkArray(userId, taskArray);
				
				if (instanceInfo2 != null && instanceInfo2.length > maxSize) {
					TaskInstanceInfo[] tempTaskInstanceInfo = new TaskInstanceInfo[maxSize + 1];
					for (int i = 0; i < maxSize; i++) {
						tempTaskInstanceInfo[i] = instanceInfo2[i];
					}
					TaskInstanceInfo moreInstance = new TaskInstanceInfo();
					moreInstance.setType(-21);
					tempTaskInstanceInfo[maxSize] = moreInstance;
					instanceInfo2 = tempTaskInstanceInfo;
				}
			}
			if (instanceInfoList3.size() != 0) {
				TaskWork[] taskArray = new TaskWork[instanceInfoList3.size()];
				instanceInfoList3.toArray(taskArray);
				instanceInfo3 = (TaskInstanceInfo[])ModelConverter.getTaskInstanceInfoArrayByTaskWorkArray(userId, taskArray);
				
				if (instanceInfo3 != null && instanceInfo3.length > maxSize) {
					TaskInstanceInfo[] tempTaskInstanceInfo = new TaskInstanceInfo[maxSize + 1];
					for (int i = 0; i < maxSize; i++) {
						tempTaskInstanceInfo[i] = instanceInfo3[i];
					}
					TaskInstanceInfo moreInstance = new TaskInstanceInfo();
					moreInstance.setType(-21);
					tempTaskInstanceInfo[maxSize] = moreInstance;
					instanceInfo3 = tempTaskInstanceInfo;
				}
			}
			if (instanceInfoList4.size() != 0) {
				TaskWork[] taskArray = new TaskWork[instanceInfoList4.size()];
				instanceInfoList4.toArray(taskArray);
				instanceInfo4 = (TaskInstanceInfo[])ModelConverter.getTaskInstanceInfoArrayByTaskWorkArray(userId, taskArray);
				
				if (instanceInfo4 != null && instanceInfo4.length > maxSize) {
					TaskInstanceInfo[] tempTaskInstanceInfo = new TaskInstanceInfo[maxSize + 1];
					for (int i = 0; i < maxSize; i++) {
						tempTaskInstanceInfo[i] = instanceInfo4[i];
					}
					TaskInstanceInfo moreInstance = new TaskInstanceInfo();
					moreInstance.setType(-21);
					tempTaskInstanceInfo[maxSize] = moreInstance;
					instanceInfo4 = tempTaskInstanceInfo;
				}
			}
			if (instanceInfoList5.size() != 0) {
				TaskWork[] taskArray = new TaskWork[instanceInfoList5.size()];
				instanceInfoList5.toArray(taskArray);
				instanceInfo5 = (TaskInstanceInfo[])ModelConverter.getTaskInstanceInfoArrayByTaskWorkArray(userId, taskArray);
				
				if (instanceInfo5 != null && instanceInfo5.length > maxSize) {
					TaskInstanceInfo[] tempTaskInstanceInfo = new TaskInstanceInfo[maxSize + 1];
					for (int i = 0; i < maxSize; i++) {
						tempTaskInstanceInfo[i] = instanceInfo5[i];
					}
					TaskInstanceInfo moreInstance = new TaskInstanceInfo();
					moreInstance.setType(-21);
					tempTaskInstanceInfo[maxSize] = moreInstance;
					instanceInfo5 = tempTaskInstanceInfo;
				}
			}
			if (instanceInfoList6.size() != 0) {
				TaskWork[] taskArray = new TaskWork[instanceInfoList6.size()];
				instanceInfoList6.toArray(taskArray);
				instanceInfo6 = (TaskInstanceInfo[])ModelConverter.getTaskInstanceInfoArrayByTaskWorkArray(userId, taskArray);
				
				if (instanceInfo6 != null && instanceInfo6.length > maxSize) {
					TaskInstanceInfo[] tempTaskInstanceInfo = new TaskInstanceInfo[maxSize + 1];
					for (int i = 0; i < maxSize; i++) {
						tempTaskInstanceInfo[i] = instanceInfo6[i];
					}
					TaskInstanceInfo moreInstance = new TaskInstanceInfo();
					moreInstance.setType(-21);
					tempTaskInstanceInfo[maxSize] = moreInstance;
					instanceInfo6 = tempTaskInstanceInfo;
				}
			}
			if (instanceInfoList7.size() != 0) {
				TaskWork[] taskArray = new TaskWork[instanceInfoList7.size()];
				instanceInfoList7.toArray(taskArray);
				instanceInfo7 = (TaskInstanceInfo[])ModelConverter.getTaskInstanceInfoArrayByTaskWorkArray(userId, taskArray);
				
				if (instanceInfo7 != null && instanceInfo7.length > maxSize) {
					TaskInstanceInfo[] tempTaskInstanceInfo = new TaskInstanceInfo[maxSize + 1];
					for (int i = 0; i < maxSize; i++) {
						tempTaskInstanceInfo[i] = instanceInfo7[i];
					}
					TaskInstanceInfo moreInstance = new TaskInstanceInfo();
					moreInstance.setType(-21);
					tempTaskInstanceInfo[maxSize] = moreInstance;
					instanceInfo7 = tempTaskInstanceInfo;
				}
			}
//			return new TaskInstanceInfo[][]{monInstanceInfo, tueInstanceInfo, wedInstanceInfo, thuInstanceInfo, friInstanceInfo, satInstanceInfo, sunInstanceInfo};
			return new TaskInstanceInfo[][]{instanceInfo1, instanceInfo2, instanceInfo3, instanceInfo4, instanceInfo5, instanceInfo6, instanceInfo7};
			
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
			User cuser = SmartUtil.getCurrentUser();
			String userId = null;
			String companyId = null;
			if (cuser != null) {
				userId = cuser.getId();
				companyId = cuser.getCompanyId();
			}
			if (CommonUtil.isEmpty(contextId) || CommonUtil.isEmpty(spaceId) || CommonUtil.isEmpty(companyId))
				return null;
			

			Date tempFromDate = null;
			Date tempToDate = null;
			if (month != null) {
				tempFromDate = new Date();
				tempToDate = new Date();

				tempFromDate.setTime(month.getLocalTime());
				tempToDate.setTime(month.getLocalTime());
				
				tempFromDate = DateUtil.toFromDate(tempFromDate, DateUtil.CYCLE_MONTH);
				tempFromDate.setTime(tempFromDate.getTime() - TimeZone.getDefault().getRawOffset());
				
				tempToDate = DateUtil.toToDate(tempToDate, DateUtil.CYCLE_MONTH);
				tempToDate.setTime(tempToDate.getTime() - TimeZone.getDefault().getRawOffset());
				
			}
			
			TaskWork[] tasks = getTaskWorkByFromToDate(contextId, spaceId, tempFromDate, tempToDate, maxSize);	
			
			Date temp = new Date(month.getLocalTime());
			temp = DateUtil.toToDate(temp, DateUtil.CYCLE_MONTH);
			LocalDate endOfLocalDate = new LocalDate(temp.getTime() - TimeZone.getDefault().getRawOffset());
			int endOfWeek = endOfLocalDate.getWeekOfMonth(1);
			
			Map<Integer, List<TaskWork>> weekMappingMap = new HashMap<Integer, List<TaskWork>>();
			
			for (int i = 0; i < endOfWeek; i++) {
				List<TaskWork> tempList = new ArrayList<TaskWork>();
				weekMappingMap.put(i, tempList);
			}
			for (int i = 0; i < tasks.length; i++) {
				TaskWork task = tasks[i];
				Date executeDate = tasks[i].getTaskLastModifyDate();
				LocalDate tempExecuteDate = new LocalDate(executeDate.getTime());
				int weekOfMonth = tempExecuteDate.getWeekOfMonth(1);
				weekMappingMap.get(weekOfMonth-1).add(task);
			}
			
			TaskInstanceInfo[][] result = new TaskInstanceInfo[endOfWeek][];
			for (int i : weekMappingMap.keySet()) {
				List taskWorksList = weekMappingMap.get(i);
				TaskWork[] taskWorks = new TaskWork[taskWorksList.size()];
				taskWorksList.toArray(taskWorks);
				result[i] = (TaskInstanceInfo[])ModelConverter.getTaskInstanceInfoArrayByTaskWorkArray(userId, taskWorks);

				if (result[i] != null && result[i].length > maxSize) {
					TaskInstanceInfo[] tempTaskInstanceInfo = new TaskInstanceInfo[maxSize + 1];
					for (int j = 0; j < maxSize; j++) {
						tempTaskInstanceInfo[j] = result[i][j];
					}
					TaskInstanceInfo moreInstance = new TaskInstanceInfo();
					moreInstance.setType(-21);
					tempTaskInstanceInfo[maxSize] = moreInstance;
					result[i] = tempTaskInstanceInfo;
				}
			}
			
			return result;
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
			User cuser = SmartUtil.getCurrentUser();
			String userId = null;
			String companyId = null;
			if (cuser != null) {
				userId = cuser.getId();
				companyId = cuser.getCompanyId();
			}
			if (CommonUtil.isEmpty(contextId) || CommonUtil.isEmpty(spaceId) || CommonUtil.isEmpty(companyId))
				return null;
			
			Date tempFromDate = null;
			Date tempToDate = null;
			if (fromDate != null) {
				tempFromDate = new Date();
				tempFromDate.setTime(fromDate.getLocalTime());
				tempFromDate.setTime(tempFromDate.getTime() - TimeZone.getDefault().getRawOffset());
			}
			if (toDate != null) {
				tempToDate = new Date();
				tempToDate.setTime(toDate.getLocalTime());
				tempToDate.setTime(tempToDate.getTime() - TimeZone.getDefault().getRawOffset());
			}
			TaskWork[] tasks = getTaskWorkByFromToDate(contextId, spaceId, tempFromDate, tempToDate, maxSize);

			return (TaskInstanceInfo[])ModelConverter.getTaskInstanceInfoArrayByTaskWorkArray(userId, tasks);
			
		}catch (Exception e){
			// Exception Handling Required
			e.printStackTrace();
			return null;			
			// Exception Handling Required			
		}
	}
	
	@Override
	public InstanceInfo[] getSpaceInstancesByDate(String spaceId, LocalDate fromDate, int maxSize) throws Exception {
		try{
			return SmartTest.getMyRecentInstances();
			
		}catch (Exception e){
			// Exception Handling Required
			e.printStackTrace();
			return null;			
			// Exception Handling Required			
		}
	}
	
	private void addSubDepartmentUsers(String user, String parentDeptId, List<String> userList) throws Exception {
		
		ISwoManager swoMgr = SwManagerFactory.getInstance().getSwoManager();
		SwoDepartmentCond deptCond = new SwoDepartmentCond();
		deptCond.setParentId(parentDeptId);
		SwoDepartment[] subDeptObjs = swoMgr.getDepartments(user, deptCond, IManager.LEVEL_LITE);
		if (subDeptObjs == null)
			return;
		for (int i = 0; i < subDeptObjs.length; i++) {
			SwoDepartment subDeptObj = subDeptObjs[i];
			SwoUserCond userCond = new SwoUserCond();
			userCond.setDeptId(subDeptObj.getId());
			SwoUser[] teamUsers = swoMgr.getUsers(user, userCond, IManager.LEVEL_LITE);
			if (teamUsers != null) {
				for (int j = 0; j < teamUsers.length; j++) {
					SwoUser teamUser = teamUsers[i];
					String teamUserId = teamUser.getId();
					
					if (!userList.contains(teamUserId)); {
						userList.add(teamUserId);
					}
				}
			}
			//재귀호출
			addSubDepartmentUsers(user, subDeptObj.getId(), userList);
		}	
	}
	
	@Override
	public TaskInstanceInfo[] getCastTaskInstancesByDate(LocalDate fromDate, int maxSize) throws Exception {
		try{
			User cuser = SmartUtil.getCurrentUser();
			String userId = null;
			String departmentId = null;
			if (cuser != null) {
				userId = cuser.getId();
				departmentId = cuser.getDepartmentId();	
			}	
			List<String> relatedUserIdArray = new ArrayList<String>();
			relatedUserIdArray.add(userId);
			
			if (departmentId != null) {

				SwoUserCond userCond = new SwoUserCond();
				userCond.setDeptId(departmentId);
				userCond.setRoleId("DEPT MEMBER");//모든 부서원들을 가져온다, 내 아디디는 무조건 포함되기 때문에 내가 부서장이면 나머지 부서원, 부서원이면 나머지 부서원을 가져온다
				
				SwoUser[] relatedUserObjs = getSwoManager().getUsers(userId, userCond, IManager.LEVEL_LITE);
				if (relatedUserObjs != null) {
					for (int i = 0; i < relatedUserObjs.length; i++) {
						SwoUser relatedUserObj = relatedUserObjs[i];
						if (!relatedUserObj.getId().equalsIgnoreCase(userId))
							relatedUserIdArray.add(relatedUserObj.getId());//자기 부서원들을 array에 포함시킨다
					}
				}
				//자기 하위부서의 사람들도 포함시킨다(재귀함수를 이용)
				addSubDepartmentUsers(userId, departmentId, relatedUserIdArray);//userDeptId의 자식 부서들의 사용자들을 array에 추가시킨다
			}
			StringBuffer userSelectStr = new StringBuffer();
			boolean isFirst = true;
			for (int i = 0; i < relatedUserIdArray.size(); i++) {
				if (isFirst) {
					userSelectStr.append("'").append(relatedUserIdArray.get(i)).append("'");
					isFirst = false;
				} else {
					userSelectStr.append(",'").append(relatedUserIdArray.get(i)).append("'");
				}
			}
			
			TaskWorkCond cond = new TaskWorkCond();
			cond.setTskAssigneeIdIns(userSelectStr.toString());
			cond.setTskAssignee(userId);
			cond.setTskModifyDateFrom(fromDate);
			long totalSize = getWlmManager().getCastWorkListSize(userId, cond);
			
			cond.setPageNo(0);
			cond.setPageSize(maxSize);
			
			cond.setOrders(new Order[]{new Order("tskcreatedate", false)});
			
			TaskWork[] tasks = getWlmManager().getCastWorkList(userId, cond);
			
			TaskInstanceInfo[] taskInfos = ModelConverter.getTaskInstanceInfoArrayByTaskWorkArray(userId, tasks);
			
			if (totalSize > maxSize) {
				TaskInstanceInfo[] tempTaskInfos = new TaskInstanceInfo[taskInfos.length + 1];
				for (int i = 0; i < taskInfos.length + 1; i++) {
					if (i == taskInfos.length) {
						TaskInstanceInfo moreInstance = new TaskInstanceInfo();
						moreInstance.setType(-21);
						tempTaskInfos[i] = moreInstance;
					} else {
						tempTaskInfos[i] = taskInfos[i];
					}
				}
				taskInfos = tempTaskInfos;
			}
			
			return taskInfos;
			//return ModelConverter.getTaskInstanceInfoArrayByTaskWorkArray(userId, tasks);
			//return SmartTest.getTaskInstancesByDate(null, null, null, null, maxSize);
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
			
						WorkInfo workInfo = new SmartWorkInfo(formId, formName, SmartWork.TYPE_INFORMATION, groupInfo, categoryInfo);
		
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
											List<IFileModel> fileModelList = getDocManager().findFileGroup(value);
											List<Map<String, String>> fileList = new ArrayList<Map<String,String>>();
											int fileModelListLength = fileModelList.size();
											for(int j=0; j<fileModelListLength; j++) {
												Map<String, String> fileMap = new LinkedHashMap<String, String>();
												IFileModel fileModel = fileModelList.get(j);
												String fileId = fileModel.getId();
												String fileName = fileModel.getFileName();
												String fileType = fileModel.getType();
												String fileSize = fileModel.getFileSize() + "";
												fileMap.put("fileId", fileId);
												fileMap.put("fileName", fileName);
												fileMap.put("fileType", fileType);
												fileMap.put("fileSize", fileSize);
												fileList.add(fileMap);
											}
											if(fileList.size() > 0)
												fieldData.setFiles(fileList);
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
	private String executeTask(Map<String, Object> requestBody, HttpServletRequest request, String action) throws Exception {
		User cuser = SmartUtil.getCurrentUser();
		String userId = null;
		if (cuser != null)
			userId = cuser.getId();
		
		if (action == null || action.equalsIgnoreCase("EXECUTE") || action.equalsIgnoreCase("RETURN") || action.equalsIgnoreCase("SAVE")) {
			
			/*{
			workId=pkg_cf3b0087995f4f99a41c93e2fe95b22d, 
			instanceId=402880eb35426e06013542712d7c0002, 
			taskInstId=402880eb35426e060135427135d20004, 
			formId=frm_5aeb1a53f9cf439dbe83693be9e27624, 
			formName=승인자 결재, 
			frmSmartForm={
				8=승인자 의견, 
				12={
					users=[
						{
							id=kmyu@maninsoft.co.kr, 
							name=연구소장 유광민
						}
					]
				}, 
				16={users=[{id=kmyu@maninsoft.co.kr, name=연구소장 유광민}]}, 
				76={users=[{id=kmyu@maninsoft.co.kr, name=연구소장 유광민}]}
			}
			}*/
		

			if (logger.isInfoEnabled()) {
				logger.info(action + " Task Start [processInstanceId : " + (String)requestBody.get("instanceId") + ", " + (String)requestBody.get("formName") + "( taskId : " + (String)requestBody.get("taskInstId") + ") ] by " + userId);
			}
			//태스크인스턴스 아이디를 이용하여 저장 되어 있는 태스크를 조회 하고 실행 가능 여부를 판단한다
			String taskInstId = (String)requestBody.get("taskInstId");
			if (CommonUtil.isEmpty(taskInstId))
				throw new Exception(action +" TaskId Is Null");
			TskTask task = getTskManager().getTask(userId, taskInstId, IManager.LEVEL_ALL);
			if (task == null)
				throw new Exception("Not Exist Task : taskId = " + taskInstId);
			if (!task.getStatus().equalsIgnoreCase(TskTask.TASKSTATUS_ASSIGN))
				throw new Exception("Task Is Not Executable(" + action + ") Status : taskId = " + taskInstId +" (status - " + task.getStatus() + ")");
			if (!task.getAssignee().equalsIgnoreCase(userId)) 
				throw new Exception("Task is Not Executable(" + action + ") Assignee : taskId = " + taskInstId + " (assignee - " + task.getAssignee() + " But performer - " + userId + ")");
			
			//태스크에 사용자가 입력한 업무 데이터를 셋팅한다
			String formId = (String)requestBody.get("formId");
			SwfForm form = getSwfManager().getForm(userId, formId);
			SwfField[] formFields = form.getFields();
			List domainFieldList = new ArrayList();
			
			for (SwfField field: formFields) {
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
			Map<String, List<Map<String, String>>> fileGroupMap = null;
			if (recordObj != null) {
				taskDocument = recordObj.toString();
				fileGroupMap = recordObj.getFileGroupMap();
			}
			task.setDocument(taskDocument);
			if (logger.isInfoEnabled()) {
				logger.info(action + " Task [processInstanceId : " + (String)requestBody.get("instanceId") + ", " + (String)requestBody.get("formName") + "( taskId : " + (String)requestBody.get("taskInstId") + "), document : " + recordObj.toString() + " ] ");
			}
			//태스크의 실제 완료 시간을 입력한다
			if (task.getRealStartDate() == null)
				task.setRealStartDate(new LocalDate(new Date().getTime()));
			task.setRealEndDate(new LocalDate(new Date().getTime()));
			//태스크를 실행한다
			
			if (action.equalsIgnoreCase("save")) {
				getTskManager().setTask(userId, task, IManager.LEVEL_ALL);
			} else {
				getTskManager().executeTask(userId, task, action);
			}
			if (logger.isInfoEnabled()) {
				logger.info(action + " Task Done [processInstanceId : " + (String)requestBody.get("instanceId") + ", " + (String)requestBody.get("formName") + "( taskId : " + (String)requestBody.get("taskInstId") + ")] ");
			}

			if(fileGroupMap.size() > 0) {
				for(Map.Entry<String, List<Map<String, String>>> entry : fileGroupMap.entrySet()) {
					String fileGroupId = entry.getKey();
					List<Map<String, String>> fileGroups = entry.getValue();

					try {
						for(int i=0; i < fileGroups.subList(0, fileGroups.size()).size(); i++) {
							Map<String, String> file = fileGroups.get(i);
							String fileId = file.get("fileId");
							String fileName = file.get("fileName");
							String fileSize = file.get("fileSize");
							getDocManager().insertFiles("Files", taskInstId, fileGroupId, fileId, fileName, fileSize);
						}
					} catch (Exception e) {
						throw new DocFileException("file upload fail...");
					}
				}
			}

			return taskInstId;
		}  else if (action.equalsIgnoreCase("delegate")) {
			String taskInstId = "";
			String delegateUserId = "";
			if (CommonUtil.isEmpty(taskInstId) || CommonUtil.isEmpty(delegateUserId))
				return null;
			
			TskTask task = getTskManager().getTask(userId, taskInstId, IManager.LEVEL_ALL);
			
			if (task == null || !task.getAssignee().equalsIgnoreCase(userId))
				throw new Exception("Task("+taskInstId+") Is Null Or Mismatch Between AssigneeId("+task.getAssignee()+") And PerformerId("+userId+")");
			
			task.setAssignee(delegateUserId);
			
			if (logger.isInfoEnabled())
				logger.info("Delegate Task "+ task.getName() +"("+taskInstId+") From " + userId + " To " + delegateUserId);
			getTskManager().setTask(userId, task, IManager.LEVEL_ALL);
			return taskInstId;
		}
		return null;
	}

	@Override
	public String performTaskInstance(Map<String, Object> requestBody, HttpServletRequest request) throws Exception {
		return executeTask(requestBody, request, "execute");
// execute, return, delegate, save 함수를 한곳(executeTask(Map<String, Object> requestBody, HttpServletRequest request, String action))으로 모으기전 execute 소스 - 테스트 진행 후 한곳으로 합쳐지는게 불가능하다면 이전으로 돌리기 위해 주석 처리함
//		/*{
//			workId=pkg_cf3b0087995f4f99a41c93e2fe95b22d, 
//			instanceId=402880eb35426e06013542712d7c0002, 
//			taskInstId=402880eb35426e060135427135d20004, 
//			formId=frm_5aeb1a53f9cf439dbe83693be9e27624, 
//			formName=승인자 결재, 
//			frmSmartForm={
//				8=승인자 의견, 
//				12={
//					users=[
//						{
//							id=kmyu@maninsoft.co.kr, 
//							name=연구소장 유광민
//						}
//					]
//				}, 
//				16={users=[{id=kmyu@maninsoft.co.kr, name=연구소장 유광민}]}, 
//				76={users=[{id=kmyu@maninsoft.co.kr, name=연구소장 유광민}]}
//			}
//		}*/
//		
//		try {
//			
//			User cuser = SmartUtil.getCurrentUser();
//			String userId = null;
//			if (cuser != null)
//				userId = cuser.getId();
//
//			if (logger.isInfoEnabled()) {
//				logger.info("ExecuteTask Task Start [processInstanceId : " + (String)requestBody.get("instanceId") + ", " + (String)requestBody.get("formName") + "( taskId : " + (String)requestBody.get("taskInstId") + ") ] by " + userId);
//			}
//			//태스크인스턴스 아이디를 이용하여 저장 되어 있는 태스크를 조회 하고 실행 가능 여부를 판단한다
//			String taskInstId = (String)requestBody.get("taskInstId");
//			if (CommonUtil.isEmpty(taskInstId))
//				throw new Exception("ExecuteTaskId Is Null");
//			TskTask task = getTskManager().getTask(userId, taskInstId, IManager.LEVEL_ALL);
//			if (task == null)
//				throw new Exception("Not Exist Task Object(data) : taskId = " + taskInstId);
//			if (!task.getStatus().equalsIgnoreCase(TskTask.TASKSTATUS_ASSIGN))
//				throw new Exception("Task Is Not Executable Status : taskId = " + taskInstId +" (status - " + task.getStatus() + ")");
//			if (!task.getAssignee().equalsIgnoreCase(userId)) 
//				throw new Exception("Task is Not Executable Assignee : taskId = " + taskInstId + " (assignee - " + task.getAssignee() + " But performer - " + userId + ")");
//			
//			//태스크에 사용자가 입력한 업무 데이터를 셋팅한다
//			String formId = (String)requestBody.get("formId");
//			SwfForm form = getSwfManager().getForm(userId, formId);
//			SwfField[] formFields = form.getFields();
//			List domainFieldList = new ArrayList();
//			
//			for (SwfField field: formFields) {
//				SwdField domainField = new SwdField();
//				domainField.setFormFieldId(field.getId());
//				domainField.setFormFieldName(field.getName());
//				domainField.setFormFieldType(field.getSystemType());
//				domainField.setArray(field.isArray());
//				domainField.setSystemField(field.isSystem());
//				domainFieldList.add(domainField);
//			}
//			SwdField[] domainFields = new SwdField[domainFieldList.size()];
//			domainFieldList.toArray(domainFields);
//			
//			SwdRecord recordObj = getSwdRecordByRequestBody(userId, domainFields, requestBody, request);
//			String taskDocument = null;
//			if (recordObj != null)
//				taskDocument = recordObj.toString();
//			task.setDocument(taskDocument);
//			if (logger.isInfoEnabled()) {
//				logger.info("ExecuteTask Task [processInstanceId : " + (String)requestBody.get("instanceId") + ", " + (String)requestBody.get("formName") + "( taskId : " + (String)requestBody.get("taskInstId") + "), document : " + recordObj.toString() + " ] ");
//			}
//			//태스크의 실제 완료 시간을 입력한다
//			if (task.getRealStartDate() == null)
//				task.setRealStartDate(new LocalDate(new Date().getTime()));
//			task.setRealEndDate(new LocalDate(new Date().getTime()));
//			//태스크를 실행한다
//			TskTask executedTask = getTskManager().executeTask(userId, task, "execute");
//			String prcInstId = executedTask.getProcessInstId();
//			if (logger.isInfoEnabled()) {
//				logger.info("ExecuteTask Task Done [processInstanceId : " + (String)requestBody.get("instanceId") + ", " + (String)requestBody.get("formName") + "( taskId : " + (String)requestBody.get("taskInstId") + ")] ");
//			}
//			return prcInstId;
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw e;
//		}
	}
	@Override
	public String returnTaskInstance(Map<String, Object> requestBody, HttpServletRequest request) throws Exception {
		return executeTask(requestBody, request, "return");
	}
	@Override
	public String reassignTaskInstance(Map<String, Object> requestBody, HttpServletRequest request) throws Exception {
		return executeTask(requestBody, request, "delegate");
	}
	@Override
	public String tempSaveTaskInstance(Map<String, Object> requestBody, HttpServletRequest request) throws Exception {
		return executeTask(requestBody, request, "save");
	}
}
