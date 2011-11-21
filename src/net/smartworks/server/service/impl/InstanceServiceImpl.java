package net.smartworks.server.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.smartworks.model.community.info.UserInfo;
import net.smartworks.model.community.info.WorkSpaceInfo;
import net.smartworks.model.instance.CommentInstance;
import net.smartworks.model.instance.Instance;
import net.smartworks.model.instance.info.BoardInstanceInfo;
import net.smartworks.model.instance.info.InstanceInfo;
import net.smartworks.model.instance.info.InstanceInfoList;
import net.smartworks.model.instance.info.RequestParams;
import net.smartworks.model.work.info.WorkInfo;
import net.smartworks.server.engine.common.manager.IManager;
import net.smartworks.server.engine.common.model.Order;
import net.smartworks.server.engine.common.util.CommonUtil;
import net.smartworks.server.engine.factory.SwManagerFactory;
import net.smartworks.server.engine.process.process.manager.IPrcManager;
import net.smartworks.server.engine.process.process.model.PrcProcessInst;
import net.smartworks.server.engine.process.process.model.PrcProcessInstCond;
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
		
		InstanceInfo[] instInfo = ModelConverter.prcInstToInstInfo(prcInsts);
		
		return instInfo;
		
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
		return SmartTest.getWorkInstanceList1(params);
	}	
	
	@Override
	public InstanceInfoList getPWorkInstanceList(String companyId, String userId, String workId, RequestParams params) throws Exception {
		return SmartTest.getWorkInstanceList2(params);
	}		
}
