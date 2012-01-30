package net.smartworks.server.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.smartworks.model.instance.CommentInstance;
import net.smartworks.model.instance.Instance;
import net.smartworks.model.instance.RunningCounts;
import net.smartworks.model.instance.WorkInstance;
import net.smartworks.model.instance.info.BoardInstanceInfo;
import net.smartworks.model.instance.info.InstanceInfo;
import net.smartworks.model.instance.info.InstanceInfoList;
import net.smartworks.model.instance.info.RequestParams;
import net.smartworks.model.instance.info.TaskInstanceInfo;
import net.smartworks.util.LocalDate;

public interface IInstanceService {

	public BoardInstanceInfo[] getMyRecentBoardInstances() throws Exception;

	public InstanceInfo[] getMyRecentInstances() throws Exception;

	public Instance getInstanceById(String instanceId) throws Exception;

	public InstanceInfo[] getMyRunningInstances(LocalDate lastInstanceDate, int requestSize, boolean assignedOnly) throws Exception;

	public RunningCounts getMyRunningInstancesCounts() throws Exception;

	public InstanceInfo[] searchMyRunningInstance(String key) throws Exception;

	public CommentInstance[] getRecentCommentsInWorkManual(String workId, int length) throws Exception;

	public InstanceInfoList getIWorkInstanceList(String workId, RequestParams params) throws Exception;

	public InstanceInfoList getIWorkInstanceListByFormId(String formId, RequestParams params) throws Exception;

	public InstanceInfoList getPWorkInstanceList(String workId, RequestParams params) throws Exception;

	public WorkInstance getWorkInstanceById(int workType, String workId, String instanceId) throws Exception;
	
	public TaskInstanceInfo[] getTaskInstancesByWorkHour(LocalDate date, int workHourType, int maxSize) throws Exception;

	public TaskInstanceInfo[][] getTaskInstancesByWorkHours(LocalDate date, int maxSize) throws Exception;

	public TaskInstanceInfo[] getTaskInstancesByDate(LocalDate date, int maxSize) throws Exception;

	public TaskInstanceInfo[][] getTaskInstancesByDates(LocalDate fromDate, LocalDate toDate, int maxSize) throws Exception;

	public TaskInstanceInfo[] getTaskInstancesByWeek(LocalDate weekStart, LocalDate weekEnd, int maxSize) throws Exception;

	public TaskInstanceInfo[][] getTaskInstancesByWeeks(LocalDate month, int maxSize) throws Exception;

	public String setInformationWorkInstance(Map<String, Object> requestBody, HttpServletRequest request) throws Exception;

	public void removeInformationWorkInstance(Map<String, Object> requestBody, HttpServletRequest request) throws Exception;

	public String startProcessWorkInstance(Map<String, Object> requestBody, HttpServletRequest request) throws Exception;

	public String setFileInstance(HttpServletRequest request) throws Exception;

	public String setEventInstance(HttpServletRequest request) throws Exception;

	public String setMemoInstance(HttpServletRequest request) throws Exception;

	public String setBoardInstance(HttpServletRequest request) throws Exception;

}
