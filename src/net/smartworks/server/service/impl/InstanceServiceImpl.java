package net.smartworks.server.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.smartworks.model.instance.BoardInstance;
import net.smartworks.model.instance.CommentInstance;
import net.smartworks.model.instance.Instance;
import net.smartworks.model.instance.InstanceList;
import net.smartworks.model.instance.ListRequestParams;
import net.smartworks.model.instance.WorkInstance;
import net.smartworks.model.work.SocialWork;
import net.smartworks.server.engine.common.manager.IManager;
import net.smartworks.server.engine.common.model.Order;
import net.smartworks.server.engine.common.util.CommonUtil;
import net.smartworks.server.engine.factory.SwManagerFactory;
import net.smartworks.server.engine.process.process.manager.IPrcManager;
import net.smartworks.server.engine.process.process.model.PrcProcessCond;
import net.smartworks.server.engine.process.process.model.PrcProcessInst;
import net.smartworks.server.engine.process.process.model.PrcProcessInstCond;
import net.smartworks.server.engine.process.task.manager.ITskManager;
import net.smartworks.server.engine.process.task.model.TskTask;
import net.smartworks.server.engine.process.task.model.TskTaskCond;
import net.smartworks.server.service.IInstanceService;
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
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * net.smartworks.service.impl.ISmartWorks#getBoardInstances(net.smartworks
	 * .util.LocalDate, int)
	 */
	@Override
	public BoardInstance[] getBoardInstances(String companyId, String userId, LocalDate fromDate, int days) throws Exception {
		LocalDate time1 = new LocalDate();
		time1.plusToGMTTime(-(1 * LocalDate.ONE_HOUR));
		LocalDate time2 = new LocalDate();
		time2.plusToGMTTime(-(LocalDate.ONE_HOUR));
		LocalDate time3 = new LocalDate();
		time3.plusToGMTTime(-(3 * LocalDate.ONE_HOUR));
		LocalDate time4 = new LocalDate();
		time4.plusToGMTTime(-(5 * LocalDate.ONE_HOUR));
		LocalDate time5 = new LocalDate();
		time5.plusToGMTTime(-(LocalDate.ONE_DAY));
		LocalDate time6 = new LocalDate();
		time6.plusToGMTTime(-(LocalDate.ONE_DAY + LocalDate.ONE_HOUR));
		LocalDate time7 = new LocalDate();
		time7.plusToGMTTime(-(2 * LocalDate.ONE_DAY + LocalDate.ONE_HOUR * 3));
		LocalDate time8 = new LocalDate();
		time8.plusToGMTTime(-(2 * LocalDate.ONE_DAY + LocalDate.ONE_HOUR * 7));
		LocalDate time9 = new LocalDate();
		time9.plusToGMTTime(-(10 * LocalDate.ONE_DAY + LocalDate.ONE_HOUR * 10));
		LocalDate time10 = new LocalDate();
		time10.plusToGMTTime(-(10 * LocalDate.ONE_DAY + LocalDate.ONE_HOUR * 14));

		BoardInstance board1 = new BoardInstance("board1", "워크샵 일정계획 공지 합니다.", new SocialWork("socialwork1", "Board Work"), SmartUtil.getCurrentUser(), time1);
		board1.setWorkSpace(SmartTest.getGroup2());
		BoardInstance board2 = new BoardInstance("board2", "하반기 해외 B2B마케팅 성공사례 세미나", new SocialWork("socialwork1", "Board Work"), SmartTest.getUser1(), time2);
		BoardInstance board3 = new BoardInstance("board3", "올레캠퍼스 자바개발자 교육과정 소개합니다.", new SocialWork("socialwork1", "Board Work"), SmartTest.getUser2(), time3);
		board3.setWorkSpace(SmartTest.getDepartment2());
		BoardInstance board4 = new BoardInstance("board4", "가을 조직개편 조직도 입니다.", new SocialWork("socialwork1", "Board Work"), SmartTest.getUser3(), time4);
		BoardInstance board5 = new BoardInstance("board5", "가을 정기 임직원 승진 발표", new SocialWork("socialwork1", "Board Work"), SmartTest.getUser3(), time5);
		BoardInstance board6 = new BoardInstance("board6", "2011년도 경영계획 공지합니다.", new SocialWork("socialwork1", "Board Work"), SmartUtil.getCurrentUser(), time6);
		BoardInstance board7 = new BoardInstance("board7", "여름휴가 일정 공지합니다.", new SocialWork("socialwork1", "Board Work"), SmartUtil.getCurrentUser(), time7);
		BoardInstance board8 = new BoardInstance("board8", "제품개발 프로젝트 전체 일정 계획공지합니다.", new SocialWork("socialwork1", "Board Work"), SmartTest.getUser2(), time8);
		board8.setWorkSpace(SmartTest.getDepartment1());
		BoardInstance board9 = new BoardInstance("board9", "사무실 이전 계획 입니다.", new SocialWork("socialwork1", "Board Work"), SmartTest.getUser1(), time9);
		BoardInstance board10 = new BoardInstance("board10", "스마트웍스닷넷 장기 로드맵 입니다.", new SocialWork("socialwork1", "Board Work"), SmartUtil.getCurrentUser(),
				time10);
		return new BoardInstance[] { board1, board2, board3, board4, board5 };
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * net.smartworks.service.impl.ISmartWorks#getBoardInstances(net.smartworks
	 * .util.LocalDate, net.smartworks.util.LocalDate)
	 */
	@Override
	public BoardInstance[] getBoardInstances(String companyId, String userId, LocalDate fromDate, LocalDate toDate) throws Exception {
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
	public WorkInstance[] getMyRecentInstances(String companyId, String userId) throws Exception {

		if (CommonUtil.isEmpty(companyId) || CommonUtil.isEmpty(userId))
			return null;

		TskTaskCond taskCond = new TskTaskCond();
		taskCond.setAssignee(userId);
		taskCond.setStatus(TskTask.TASKSTATUS_COMPLETE);
		taskCond.setTypeNotIns(TskTask.NOTUSERTASKTYPES);
		taskCond.setOrders(new Order[]{new Order("executionDate" , false)});
		taskCond.setPageNo(0);
		taskCond.setPageSize(50);
		
		TskTask[] tasks = getTskManager().getTasks(userId, taskCond, IManager.LEVEL_ALL);
		
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
		
		
		
		

		
		
		
		
		
		
		
		
		
		
		
		
		
		return new WorkInstance[] { SmartTest.getWorkInstance1(), SmartTest.getWorkInstance2(), SmartTest.getWorkInstance3(), SmartTest.getWorkInstance4(),
				SmartTest.getWorkInstance5() };
	}

	@Override
	public Instance getInstanceById(String companyId, String instanceId) throws Exception {
		Instance[] instances = new Instance[] { SmartTest.getWorkInstance1(), SmartTest.getWorkInstance2(), SmartTest.getWorkInstance3(),
				SmartTest.getWorkInstance4(), SmartTest.getWorkInstance5(), SmartTest.getTaskInstanceIA(), SmartTest.getTaskInstanceIF(),
				SmartTest.getTaskInstancePA(), SmartTest.getTaskInstancePF(), SmartTest.getTaskInstanceSA(), SmartTest.getTaskInstanceSF(),
				SmartTest.getTaskInstanceAA(), SmartTest.getTaskInstanceAF() };
		for (Instance instance : instances) {
			if (instance.getId().equals(instanceId))
				return instance;
		}
		return null;
	}

	@Override
	public Instance[] getMyRunningInstances(String companyId, String userId) throws Exception {
		return SmartTest.getRunningInstances();
	}

	@Override
	public Instance[] searchMyRunningInstance(String companyId, String userId, String key) throws Exception {
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
	public InstanceList getWorkInstanceList(String companyId, String workId, ListRequestParams params) throws Exception {
		return SmartTest.getWorkInstanceList(params);
	}	
	
}
