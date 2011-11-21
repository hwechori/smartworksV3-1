package net.smartworks.server.service.impl;

import javax.servlet.http.HttpServletRequest;

import net.smartworks.model.instance.CommentInstance;
import net.smartworks.model.instance.Instance;
import net.smartworks.model.instance.info.BoardInstanceInfo;
import net.smartworks.model.instance.info.InstanceInfo;
import net.smartworks.model.instance.info.InstanceInfoList;
import net.smartworks.model.instance.info.RequestParams;
import net.smartworks.server.service.IInstanceService;
import net.smartworks.util.LocalDate;
import net.smartworks.util.SmartTest;

import org.springframework.stereotype.Service;

@Service
public class InstanceServiceImpl implements IInstanceService {
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
