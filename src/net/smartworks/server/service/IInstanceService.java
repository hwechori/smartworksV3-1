package net.smartworks.server.service;

import javax.servlet.http.HttpServletRequest;

import net.smartworks.model.instance.BoardInstance;
import net.smartworks.model.instance.CommentInstance;
import net.smartworks.model.instance.Instance;
import net.smartworks.model.instance.InstanceList;
import net.smartworks.model.instance.ListRequestParams;
import net.smartworks.model.instance.WorkInstance;
import net.smartworks.util.LocalDate;

public interface IInstanceService {

	public BoardInstance[] getBoardInstances(String companyId, String userId, LocalDate fromDate, LocalDate toDate) throws Exception;

	public WorkInstance[] getMyRecentInstances(String companyId, String userId) throws Exception;

	public BoardInstance[] getBoardInstances(String companyId, String userId, LocalDate fromDate, int days) throws Exception;

	public Instance getInstanceById(String companyId, String instanceId) throws Exception;

	public Instance[] getMyRunningInstances(String companyId, String userId) throws Exception;

	public Instance[] searchMyRunningInstance(String companyId, String userId, String key) throws Exception;

	public CommentInstance[] getRecentCommentsInWorkManual(String companyId, String workId, int length) throws Exception;

	public InstanceList getWorkInstanceList(String companyId, String workId, ListRequestParams params) throws Exception;

	public String setInformationWorkInstance(HttpServletRequest request) throws Exception;

	public String startProcessWorkInstance(HttpServletRequest request) throws Exception;

	public String setFileInstance(HttpServletRequest request) throws Exception;

	public String setEventInstance(HttpServletRequest request) throws Exception;

	public String setMemoInstance(HttpServletRequest request) throws Exception;

	public String setBoardInstance(HttpServletRequest request) throws Exception;

}
