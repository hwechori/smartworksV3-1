package net.smartworks.server.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.smartworks.model.instance.BoardInstance;
import net.smartworks.model.instance.CommentInstance;
import net.smartworks.model.instance.Instance;
import net.smartworks.model.instance.WorkInstance;
import net.smartworks.model.instance.info.BoardInstanceInfo;
import net.smartworks.model.instance.info.InstanceInfo;
import net.smartworks.model.instance.info.InstanceInfoList;
import net.smartworks.model.instance.info.RequestParams;
import net.smartworks.util.LocalDate;

public interface IInstanceService {

	public BoardInstanceInfo[] getBoardInstances(String companyId, String userId, LocalDate fromDate, LocalDate toDate) throws Exception;

	public InstanceInfo[] getMyRecentInstances(String companyId, String userId) throws Exception;

	public BoardInstanceInfo[] getBoardInstances(String companyId, String userId, LocalDate fromDate, int days) throws Exception;

	public Instance getInstanceById(String companyId, String instanceId) throws Exception;

	public InstanceInfo[] getMyRunningInstances(String companyId, String userId) throws Exception;

	public InstanceInfo[] searchMyRunningInstance(String companyId, String userId, String key) throws Exception;

	public CommentInstance[] getRecentCommentsInWorkManual(String companyId, String workId, int length) throws Exception;

	public InstanceInfoList getIWorkInstanceList(String companyId, String userId, String workId, RequestParams params) throws Exception;

	public InstanceInfoList getPWorkInstanceList(String companyId, String userId, String workId, RequestParams params) throws Exception;

	public WorkInstance getWorkInstanceById(String companyId, String userId, String instanceId) throws Exception;

	public String setInformationWorkInstance(Map<String, Object> requestBody) throws Exception;

	public String startProcessWorkInstance(HttpServletRequest request) throws Exception;

	public String setFileInstance(HttpServletRequest request) throws Exception;

	public String setEventInstance(HttpServletRequest request) throws Exception;

	public String setMemoInstance(HttpServletRequest request) throws Exception;

	public String setBoardInstance(HttpServletRequest request) throws Exception;

}
