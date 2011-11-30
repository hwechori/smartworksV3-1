package net.smartworks.server.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.smartworks.model.community.info.UserInfo;
import net.smartworks.model.community.info.WorkSpaceInfo;
import net.smartworks.model.instance.CommentInstance;
import net.smartworks.model.instance.Instance;
import net.smartworks.model.instance.ProcessWorkInstance;
import net.smartworks.model.instance.SortingField;
import net.smartworks.model.instance.WorkInstance;
import net.smartworks.model.instance.info.BoardInstanceInfo;
import net.smartworks.model.instance.info.InstanceInfo;
import net.smartworks.model.instance.info.InstanceInfoList;
import net.smartworks.model.instance.info.PWInstanceInfo;
import net.smartworks.model.instance.info.RequestParams;
import net.smartworks.model.instance.info.TaskInstanceInfo;
import net.smartworks.model.work.info.SmartWorkInfo;
import net.smartworks.model.work.info.WorkCategoryInfo;
import net.smartworks.model.work.info.WorkInfo;
import net.smartworks.server.engine.common.manager.IManager;
import net.smartworks.server.engine.common.model.Filter;
import net.smartworks.server.engine.common.model.Order;
import net.smartworks.server.engine.common.model.Property;
import net.smartworks.server.engine.common.util.CommonUtil;
import net.smartworks.server.engine.factory.SwManagerFactory;
import net.smartworks.server.engine.infowork.domain.manager.ISwdManager;
import net.smartworks.server.engine.process.process.manager.IPrcManager;
import net.smartworks.server.engine.process.process.model.PrcProcess;
import net.smartworks.server.engine.process.process.model.PrcProcessCond;
import net.smartworks.server.engine.process.process.model.PrcProcessInst;
import net.smartworks.server.engine.process.process.model.PrcProcessInstCond;
import net.smartworks.server.engine.process.process.model.PrcProcessInstExtend;
import net.smartworks.server.engine.process.task.manager.ITskManager;
import net.smartworks.server.engine.process.task.model.TskTask;
import net.smartworks.server.engine.process.task.model.TskTaskCond;
import net.smartworks.server.service.IInstanceService;
import net.smartworks.server.service.util.ModelConverter;
import net.smartworks.util.LocalDate;
import net.smartworks.util.SmartTest;

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
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * net.smartworks.service.impl.ISmartWorks#getBoardInstances(net.smartworks
	 * .util.LocalDate, int)
	 */
	@Override
	public BoardInstanceInfo[] getBoardInstances(String companyId, String userId, LocalDate fromDate, int days) throws Exception {
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
	public BoardInstanceInfo[] getBoardInstances(String companyId, String userId, LocalDate fromDate, LocalDate toDate) throws Exception {
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
	public InstanceInfo[] getMyRecentInstances(String companyId, String userId) throws Exception {
	 return SmartTest.getMyRecentInstances();	
//		if (CommonUtil.isEmpty(companyId) || CommonUtil.isEmpty(userId))
//			return null;
//
//		TskTaskCond taskCond = new TskTaskCond();
//		taskCond.setAssignee(userId);
//		taskCond.setStatus(TskTask.TASKSTATUS_COMPLETE);
//		taskCond.setTypeNotIns(TskTask.NOTUSERTASKTYPES);
//		taskCond.setOrders(new Order[]{new Order("executionDate" , false)});
//		taskCond.setPageNo(0);
//		taskCond.setPageSize(50);
//		
//		TskTask[] tasks = getTskManager().getTasks(userId, taskCond, IManager.LEVEL_LITE);
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
//		prcInstCond.setCompanyId(companyId);
//		prcInstCond.setObjIdIns(prcInstIdArray);
//		
//		PrcProcessInst[] prcInsts = getPrcManager().getProcessInsts(userId, prcInstCond, IManager.LEVEL_LITE);
//		
//		InstanceInfo[] instInfo = ModelConverter.getInstanceInfoArrayByPrcInstArray(prcInsts);
//		
//		return instInfo;
//		
	}

	@Override
	public Instance getInstanceById(String companyId, String instanceId) throws Exception {
		return SmartTest.getInstanceById(instanceId);
	}

	public InstanceInfo[] getMyRunningInstances(String companyId, String userId) throws Exception {
		Date limitDate = new Date();
		int resultSize = 10;
		return getMyRunningInstances(companyId, userId, limitDate, resultSize);
	}
	
	public InstanceInfo[] getMyRunningInstances(String companyId, String userId, Date limitDate, int resultSize) throws Exception {
		
		//정보관리업무에서 파생된 업무는 IWInstanceInfo
		//프로세스 태스크및 프로세스에서 파생된 업무는 PWInstanceInfo
		
		TskTaskCond assignedTaskCond = new TskTaskCond();
		assignedTaskCond.setTypeNotIns(TskTask.NOTUSERTASKTYPES);
		assignedTaskCond.setAssignee(userId);
		assignedTaskCond.setStatus(TskTask.TASKSTATUS_ASSIGN);
		assignedTaskCond.setAssignmentDateTo(limitDate);
		assignedTaskCond.setPageNo(0);
		assignedTaskCond.setPageSize(resultSize);
		
		TskTask[] assignTasks = getTskManager().getTasks(userId, assignedTaskCond, IManager.LEVEL_LITE);
		
		
		PrcProcessInstCond prcInstCond = new PrcProcessInstCond();
		prcInstCond.setStatus(PrcProcessInst.PROCESSINSTSTATUS_RUNNING);
		prcInstCond.setCreationUser(userId);	
		prcInstCond.setCreationDateTo(limitDate);
		prcInstCond.setPageNo(0);
		prcInstCond.setPageSize(resultSize);
		
		PrcProcessInstExtend[] prcInst = getPrcManager().getProcessInstExtends(userId, prcInstCond);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		return SmartTest.getRunningInstances();
	}

	@Override
	public InstanceInfo[] searchMyRunningInstance(String companyId, String userId, String key) throws Exception {
		return SmartTest.getRunningInstances();
	}

	@Override
	public String  setMemoInstance(HttpServletRequest request) throws Exception {		
		return "testId";
	}

	@Override
	public String setInformationWorkInstance(HttpServletRequest request) throws Exception {
		return "testId";		
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
	public CommentInstance[] getRecentCommentsInWorkManual(String companyId, String workId, int length) throws Exception {
		// TODO Auto-generated method stub
		return SmartTest.getCommentInstances();
	}

	@Override
	public InstanceInfoList getIWorkInstanceList(String companyId, String userId, String workId, RequestParams params) throws Exception {
		return SmartTest.getWorkInstanceList1(params);
//		InstanceInfoList instanceList = new InstanceInfoList();
//		instanceList.setType(InstanceInfoList.TYPE_INFORMATION_INSTANCE_LIST);
//		instanceList.setCountInPage(params.getCountInPage());
//		instanceList.setTotalPages(31);
//		instanceList.setCurrentPage(params.getPageNumber());
//
//		SwdRecordCond swdRecordCond = new SwdRecordCond();
//		swdRecordCond.setCompanyId(companyId);
//		swdRecordCond.setFormId(workId);
//
//		long totalSize = getSwdManager().getRecordSize(userId, swdRecordCond);
//		System.out.println("totalSize : " + totalSize);
////		SwdRecord[] swdRecords = getSwdManager().getRecords(userId, swdRecordCond, IManager.LEVEL_LITE);
////
////		for(SwdRecord swdRecord : swdRecords) {
////			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>" + swdRecord.getFormId());
////		}
//		return instanceList;
//		//return SmartTest.getWorkInstanceList1(params);
	}	

	public InstanceInfoList getPWorkInstanceList(String companyId, String userId, String workId, RequestParams params) throws Exception {
		
		//TODO workId = category 프로세스 인스턴스정보에는 패키지 컬럼이 없고 다이어 그램 컬럼에 정보가 들어가 있다
		//임시로 프로세스 다이어그램아이디 필드를 이용하고 프로세스인스턴스가 생성되는 시점(업무 시작, 처리 개발 완료)에 패키지 아이디 컬럼을 추가해 그곳에서 조회하는걸로 변경한다
		PrcProcessInstCond prcInstCond = new PrcProcessInstCond();
		prcInstCond.setPackageId(workId);
		long totalCount = getPrcManager().getProcessInstExtendsSize(userId, prcInstCond);
		
		int pageCount = params.getCountInPage();
		int currentPage = params.getPageNumber();
		
		SortingField sf = params.getSortingField();
		
		prcInstCond.setPageNo(currentPage);
		prcInstCond.setPageSize(pageCount);
		PrcProcessInstExtend[] prcInsts = getPrcManager().getProcessInstExtends(userId, prcInstCond);
		
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
				lastTaskInfo.setStatus(status);
				lastTaskInfo.setSubject(subject);
				lastTaskInfo.setType(type);
				lastTaskInfo.setWork(workInfo);
				lastTaskInfo.setWorkInstance(pwInstInfo);
				lastTaskInfo.setWorkSpace(workSpace);
				lastTaskInfo.setName(name);
				lastTaskInfo.setTaskType(type);
				lastTaskInfo.setAssignee(ModelConverter.getUserInfoByUserId(assignee));
				lastTaskInfo.setPerformer(ModelConverter.getUserInfoByUserId(performer));
				//WorkInstanceInfo workInstanceInfo = paretProcessInstObj;
				pwInstInfo.setLastTask(lastTaskInfo);//마지막 태스크
			}
			pwInstInfo.setLastTaskCount(prcInst.getLastTask_count());
			pwInstInfo.setWorkSpace(null);
			pWInstanceInfos[i] = pwInstInfo;
		}
//		instanceInfoList.setInstanceDatas(ModelConverter.getPWInstanceInfoArrayByPrcProcessInstArray(prcInsts));
		instanceInfoList.setInstanceDatas(pWInstanceInfos);
		
		instanceInfoList.setCountInPage(pageCount);
		instanceInfoList.setTotalPages((int)totalCount);
		instanceInfoList.setCurrentPage(currentPage);
		instanceInfoList.setTotalPages(InstanceInfoList.TYPE_PROCESS_INSTANCE_LIST);
		return instanceInfoList;
	}
	public InstanceInfoList getPWorkInstanceList_bak(String companyId, String userId, String workId, RequestParams params) throws Exception {

		Date startTime = new Date();
		Long start = startTime.getTime();
		System.out.println(" ####### 시작 ######### " + start);
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
		
		int currentPage = params.getPageNumber();
		int pageCount = params.getCountInPage();
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
		instanceInfoList.setInstanceDatas(ModelConverter.getPWInstanceInfoArrayByPrcProcessInstArray(prcInsts));
		instanceInfoList.setCountInPage(pageCount);
		instanceInfoList.setTotalPages((int)totalCount);
		instanceInfoList.setCurrentPage(currentPage);
		instanceInfoList.setTotalPages(InstanceInfoList.TYPE_PROCESS_INSTANCE_LIST);

		System.out.println(" ####### 끝 ######### " + (new Date().getTime() - start));
		return instanceInfoList;
	}
	public InstanceInfoList getPWorkInstanceList_bak2(String companyId, String userId, String workId, RequestParams params) throws Exception {
		Date startTime = new Date();
		Long start = startTime.getTime();
		System.out.println(" ####### 시작 ######### " + start);
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
		int currentPage = params.getPageNumber();
		int pageCount = params.getCountInPage();
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
		
		instanceInfoList.setCountInPage(pageCount);
		instanceInfoList.setTotalPages((int)totalCount);
		instanceInfoList.setCurrentPage(currentPage);
		instanceInfoList.setTotalPages(InstanceInfoList.TYPE_PROCESS_INSTANCE_LIST);

		System.out.println(" ####### 끝 ######### " + (new Date().getTime() - start));
		return instanceInfoList;
	}

	@Override
	public WorkInstance getWorkInstanceById(String companyId, String userId, String instanceId) throws Exception {
		//TODO 인스턴스로 패키지 타입을 알수가 없다 테이블에 컬럼을 생성하기는 했지만 초기 테스트시에는 데이터가 없기 때문에
		//인스턴스에 diagramId = pkgId 가 있으면 프로세스 업무 없으면 정보관리 업무로 판단한다

		PrcProcessInst prcInst = getPrcManager().getProcessInst(userId, instanceId, IManager.LEVEL_LITE);
		if (prcInst == null)
			return null;
		String packageId = prcInst.getDiagramId();
		
		if (!CommonUtil.isEmpty(packageId)) {
			return getProcessWorkInstanceById(companyId, userId, prcInst);
		} else {
			return SmartTest.getWorkInstanceById(instanceId);
		}
	}	
	
	public ProcessWorkInstance getProcessWorkInstanceById(String companyId, String userId, PrcProcessInst prcInst) throws Exception {
		
		return ModelConverter.getProcessWorkInstanceByPrcProcessInst(userId, null, prcInst);
		
	}
}
