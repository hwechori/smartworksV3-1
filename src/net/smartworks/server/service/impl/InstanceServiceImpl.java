package net.smartworks.server.service.impl;

import javax.servlet.http.HttpServletRequest;

import net.smartworks.model.instance.CommentInstance;
import net.smartworks.model.instance.Instance;
import net.smartworks.model.instance.ProcessWorkInstance;
import net.smartworks.model.instance.SortingField;
import net.smartworks.model.instance.WorkInstance;
import net.smartworks.model.instance.info.BoardInstanceInfo;
import net.smartworks.model.instance.info.InstanceInfo;
import net.smartworks.model.instance.info.InstanceInfoList;
import net.smartworks.model.instance.info.RequestParams;
import net.smartworks.server.engine.common.manager.IManager;
import net.smartworks.server.engine.common.model.Order;
import net.smartworks.server.engine.common.util.CommonUtil;
import net.smartworks.server.engine.factory.SwManagerFactory;
import net.smartworks.server.engine.infowork.domain.manager.ISwdManager;
import net.smartworks.server.engine.infowork.domain.model.SwdDomain;
import net.smartworks.server.engine.infowork.domain.model.SwdDomainCond;
import net.smartworks.server.engine.infowork.domain.model.SwdRecord;
import net.smartworks.server.engine.infowork.domain.model.SwdRecordCond;
import net.smartworks.server.engine.infowork.form.manager.ISwfManager;
import net.smartworks.server.engine.infowork.form.model.SwfFormCond;
import net.smartworks.server.engine.process.process.manager.IPrcManager;
import net.smartworks.server.engine.process.process.model.PrcProcess;
import net.smartworks.server.engine.process.process.model.PrcProcessCond;
import net.smartworks.server.engine.process.process.model.PrcProcessInst;
import net.smartworks.server.engine.process.process.model.PrcProcessInstCond;
import net.smartworks.server.engine.process.task.manager.ITskManager;
import net.smartworks.server.service.IInstanceService;
import net.smartworks.server.service.util.ModelConverter;
import net.smartworks.server.service.util.ModelConverterInfo;
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
	private ISwfManager getSwfManager() {
		return SwManagerFactory.getInstance().getSwfManager();
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
/*		if (CommonUtil.isEmpty(companyId) || CommonUtil.isEmpty(userId))
			return null;

		TskTaskCond taskCond = new TskTaskCond();
		taskCond.setAssignee(userId);
		taskCond.setStatus(TskTask.TASKSTATUS_COMPLETE);
		taskCond.setTypeNotIns(TskTask.NOTUSERTASKTYPES);
		taskCond.setOrders(new Order[]{new Order("executionDate" , false)});
		taskCond.setPageNo(0);
		taskCond.setPageSize(50);
		
		TskTask[] tasks = getTskManager().getTasks(userId, taskCond, IManager.LEVEL_LITE);
		if (CommonUtil.isEmpty(tasks))
			return null;
	
		List<String> prcInstIdList = new ArrayList<String>();
		for (int i = 0; i < tasks.length; i++) {
			TskTask task = tasks[i];
			if (prcInstIdList.size() == 10)
				break;
			if (prcInstIdList.contains(task.getProcessInstId()))
				continue;
			prcInstIdList.add(task.getProcessInstId());
		}
		
		String[] prcInstIdArray = new String[prcInstIdList.size()];
		
		prcInstIdList.toArray(prcInstIdArray);
		
		PrcProcessInstCond prcInstCond = new PrcProcessInstCond();
		
		prcInstCond.setCompanyId(companyId);
		prcInstCond.setObjIdIns(prcInstIdArray);
		
		PrcProcessInst[] prcInsts = getPrcManager().getProcessInsts(userId, prcInstCond, IManager.LEVEL_LITE);
		
		InstanceInfo[] instInfo = ModelConverter.getInstanceInfoArrayByPrcInstArray(prcInsts);
		
		return instInfo;
*/		
	}

	@Override
	public Instance getInstanceById(String companyId, String instanceId) throws Exception {
		return SmartTest.getInstanceById(instanceId);
	}

	@Override
	public InstanceInfo[] getMyRunningInstances(String companyId, String userId) throws Exception {
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

		SwdDomainCond swdDomainCond = new SwdDomainCond();
		swdDomainCond.setCompanyId(companyId);

		SwfFormCond swfFormCond = new SwfFormCond();
		swfFormCond.setCompanyId(companyId);
		swfFormCond.setPackageId(workId);

		swdDomainCond.setFormId(getSwfManager().getForms(userId, swfFormCond, IManager.LEVEL_LITE)[0].getId());

		SwdDomain swdDomain = getSwdManager().getDomain(userId, swdDomainCond, IManager.LEVEL_LITE);

		SwdRecordCond swdRecordCond = new SwdRecordCond();
		swdRecordCond.setCompanyId(companyId);
		swdRecordCond.setFormId(swdDomain.getFormId());
		swdRecordCond.setDomainId(swdDomain.getObjId());

		long totalCount = getSwdManager().getRecordSize(userId, swdRecordCond);

		int currentPage = params.getPageNumber();
		int pageCount = params.getCountInPage();
		SortingField sf = params.getSortingField();

		String fieldName = "";
		boolean isAsc;

		if (sf != null) {
			fieldName  = CommonUtil.toDefault("createdTime" , sf.getFiieldId());
			isAsc =  sf.isAscending();
		} else {
			fieldName = "createdTime";
			isAsc = false;
		}
		swdRecordCond.setOrders(new Order[]{new Order(fieldName, isAsc)});

		//swdRecordCond.setPageNo(currentPage);
		//swdRecordCond.setPageSize(pageCount);

		SwdRecord[] swdRecords = getSwdManager().getRecords(userId, swdRecordCond, IManager.LEVEL_LITE);

		InstanceInfoList instanceList = new InstanceInfoList();
		instanceList.setInstanceDatas(ModelConverterInfo.getIWInstanceInfoArrayBySwdRecordArray(swdRecords));
		instanceList.setType(InstanceInfoList.TYPE_INFORMATION_INSTANCE_LIST);
		instanceList.setCountInPage(pageCount);
		instanceList.setTotalPages((int)totalCount);
		instanceList.setCurrentPage(currentPage);

		return instanceList;
	}

	@Override
	public InstanceInfoList getPWorkInstanceList(String companyId, String userId, String workId, RequestParams params) throws Exception {
		
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
