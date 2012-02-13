package net.smartworks.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.smartworks.model.RecordList;
import net.smartworks.model.calendar.CompanyCalendar;
import net.smartworks.model.calendar.CompanyEvent;
import net.smartworks.model.calendar.WorkHourPolicy;
import net.smartworks.model.community.Department;
import net.smartworks.model.community.Group;
import net.smartworks.model.community.User;
import net.smartworks.model.community.WorkSpace;
import net.smartworks.model.community.info.CommunityInfo;
import net.smartworks.model.community.info.DepartmentInfo;
import net.smartworks.model.community.info.GroupInfo;
import net.smartworks.model.community.info.UserInfo;
import net.smartworks.model.community.info.WorkSpaceInfo;
import net.smartworks.model.company.CompanyGeneral;
import net.smartworks.model.filter.SearchFilter;
import net.smartworks.model.instance.CommentInstance;
import net.smartworks.model.instance.Instance;
import net.smartworks.model.instance.MailInstance;
import net.smartworks.model.instance.RunningCounts;
import net.smartworks.model.instance.WorkInstance;
import net.smartworks.model.instance.info.BoardInstanceInfo;
import net.smartworks.model.instance.info.EventInstanceInfo;
import net.smartworks.model.instance.info.InstanceInfo;
import net.smartworks.model.instance.info.InstanceInfoList;
import net.smartworks.model.instance.info.RequestParams;
import net.smartworks.model.instance.info.TaskInstanceInfo;
import net.smartworks.model.mail.MailFolder;
import net.smartworks.model.notice.Notice;
import net.smartworks.model.notice.NoticeBox;
import net.smartworks.model.report.Data;
import net.smartworks.model.report.Report;
import net.smartworks.model.work.Work;
import net.smartworks.model.work.info.SmartWorkInfo;
import net.smartworks.model.work.info.WorkInfo;
import net.smartworks.server.engine.docfile.model.IFileModel;
import net.smartworks.server.engine.infowork.domain.model.SwdRecord;
import net.smartworks.util.LocalDate;

public interface ISmartWorks {

	public final static String CONTEXT_HOME = "sf.hm";
	public final static String CONTEXT_SMARTCASTER = "sf.sc";
	public final static String CONTEXT_DASHBOARD = "sf.db";
	public final static String CONTEXT_MYPROFILE = "sf.pf";
	
	public final static String CONTEXT_USER_SPACE = "us.sp";
	public final static String CONTEXT_GROUP_SPACE = "gp.sp";
	public final static String CONTEXT_DEPARTMENT_SPACE = "dp.sp";
	public final static String CONTEXT_IWORK_SPACE = "iw.sp";
	public final static String CONTEXT_PWORK_SPACE = "pw.sp";
	public final static String CONTEXT_SWORK_SPACE = "sw.sp";
	public final static String CONTEXT_FILE_SPACE = "fl.sp";
	public final static String CONTEXT_IMAGE_SPACE = "im.sp";
	public final static String CONTEXT_EVENT_SPACE = "ev.sp";
	public final static String CONTEXT_MEMO_SPACE = "mm.sp";
	public final static String CONTEXT_BOARD_SPACE = "bd.sp";
	public final static String CONTEXT_MAIL_SPACE = "ml.sp";

	public final static String CONTEXT_PREFIX_SELF = "sf.";

	public final static int SPACE_TYPE_WORK_LIST = 1;
	public final static int SPACE_TYPE_WORK_INSTANCE = 2;
	public final static int SPACE_TYPE_TASK_INSTANCE = 3;
	public final static int SPACE_TYPE_USER = 4;
	public final static int SPACE_TYPE_GROUP = 5;
	public final static int SPACE_TYPE_DEPARTMENT = 6;
	

	public final static int CONTEXT_PREFIX_LENGTH = 6;
	public final static String CONTEXT_PREFIX_USER_SPACE = "us.sp.";
	public final static String CONTEXT_PREFIX_GROUP_SPACE = "gp.sp.";
	public final static String CONTEXT_PREFIX_DEPARTMENT_SPACE = "dp.sp.";

	public final static String CONTEXT_PREFIX_IWORK_LIST = "iw.li.";
	public final static String CONTEXT_PREFIX_PWORK_LIST = "pw.li.";
	public final static String CONTEXT_PREFIX_SWORK_LIST = "sw.li.";
	public final static String CONTEXT_PREFIX_FILE_LIST = "fl.li.";
	public final static String CONTEXT_PREFIX_IMAGE_LIST = "im.li.";
	public final static String CONTEXT_PREFIX_EVENT_LIST = "ev.li.";
	public final static String CONTEXT_PREFIX_MEMO_LIST = "mm.li.";
	public final static String CONTEXT_PREFIX_BOARD_LIST = "bd.li.";
	public final static String CONTEXT_PREFIX_MAIL_LIST = "ml.li.";
	public final static String CONTEXT_PREFIX_SAVED_LIST = "sv.li.";

	public final static String CONTEXT_PREFIX_IWORK_SPACE = "iw.sp.";
	public final static String CONTEXT_PREFIX_PWORK_SPACE = "pw.sp.";
	public final static String CONTEXT_PREFIX_SWORK_SPACE = "sw.sp.";
	public final static String CONTEXT_PREFIX_FILE_SPACE = "fl.sp.";
	public final static String CONTEXT_PREFIX_IMAGE_SPACE = "im.sp.";
	public final static String CONTEXT_PREFIX_EVENT_SPACE = "ev.sp.";
	public final static String CONTEXT_PREFIX_MEMO_SPACE = "mm.sp.";
	public final static String CONTEXT_PREFIX_BOARD_SPACE = "bd.sp.";
	public final static String CONTEXT_PREFIX_MAIL_SPACE = "ml.sp.";

	public final static String CONTEXT_PREFIX_IWORK_TASK = "iw.ts.";
	public final static String CONTEXT_PREFIX_PWORK_TASK = "pw.ts.";
	public final static String CONTEXT_PREFIX_SWORK_TASK = "sw.ts.";

	public final static String CONTEXT_PREFIX_BUILDER_SPACE = "bd.sp.";

	public abstract InstanceInfo[] getMyRunningInstances(LocalDate lastInstanceDate, int requestSize, boolean assignedOnly) throws Exception;
	
	public abstract RunningCounts getMyRunningInstancesCounts() throws Exception;
	
	public abstract String[] getBroadcastingMessages() throws Exception;

	public abstract CompanyCalendar[] getCompanyCalendars(LocalDate fromDate, int days) throws Exception;

	public abstract WorkSpace getWorkSpaceById(String workSpaceId) throws Exception;

	public abstract CompanyCalendar[] getCompanyCalendars(LocalDate fromDate, LocalDate toDate) throws Exception;

	public abstract EventInstanceInfo[] getMyEventInstances(LocalDate fromDate, int days) throws Exception;

	public abstract EventInstanceInfo[] getMyEventInstances(LocalDate fromDate, LocalDate toDate) throws Exception;

	public abstract BoardInstanceInfo[] getMyRecentBoardInstances() throws Exception;

	public abstract CompanyCalendar getCompanyEventBox(LocalDate date) throws Exception;

	public abstract SmartWorkInfo[] getMyFavoriteWorks() throws Exception;

	public abstract WorkInfo[] getMyAllWorksByCategoryId(String categoryId) throws Exception;

	public abstract WorkInfo[] getAllWorksByCategoryId(String categoryId) throws Exception;

	public abstract InstanceInfo[] getMyRecentInstances() throws Exception;

	public abstract DepartmentInfo[] getMyDepartments() throws Exception;

	public abstract Department getDepartmentById(String departId) throws Exception;

	public abstract GroupInfo[] getMyGroups() throws Exception;

	public abstract Group getGroupById(String groupId) throws Exception;

	public abstract String setGroup(Map<String, Object> requestBody, HttpServletRequest request) throws Exception;

	public abstract User getUserById(String userId) throws Exception;

	public abstract SmartWorkInfo[] searchWork(String key) throws Exception;

	public abstract WorkSpaceInfo[] searchCommunity(String key) throws Exception;

	public abstract UserInfo[] searchCommunityMember(String communityId, String key) throws Exception;

	public abstract UserInfo[] getAvailableChatter() throws Exception;

	public abstract UserInfo[] searchAvailableChatter(String key) throws Exception;

	public abstract UserInfo[] searchUser(String key) throws Exception;

	public abstract EventInstanceInfo[] getCompanyEventsByDate(LocalDate date, int maxEvents) throws Exception;

	public abstract EventInstanceInfo[] getMyEventsByDate(LocalDate date, int maxEvents) throws Exception;

	public abstract WorkHourPolicy getCompanyWorkHourPolicy() throws Exception;

	public abstract Notice[] getNoticesForMe() throws Exception;

	public abstract void removeNoticeInstance(String noticeId) throws Exception;

	public abstract NoticeBox getNoticeBoxForMe10(int noticeType, String lastNoticeId) throws Exception;

	public String getWorkIdByFormId(String formId) throws Exception;

	public abstract Work getWorkById(String workId) throws Exception;

	public abstract Instance getInstanceById(String instanceId) throws Exception;
	
	public abstract InstanceInfo[] searchMyRunningInstance(String key) throws Exception;

	public abstract CommunityInfo[] getMyCommunities() throws Exception;

	public abstract CommentInstance[] getRecentCommentsInWorkManual(String workId, int length) throws Exception;
	
	public abstract InstanceInfoList getIWorkInstanceList(String workId, RequestParams params) throws Exception;
	
	public abstract InstanceInfoList getPWorkInstanceList(String workId, RequestParams params) throws Exception;
	
	public abstract InstanceInfoList getMailInstanceList(String folderId, RequestParams params) throws Exception;

	public abstract WorkInstance getWorkInstanceById(int workType, String workId, String instanceId) throws Exception;

	public abstract TaskInstanceInfo[][] getTaskInstancesByWorkHours(String contextId, String spaceId, LocalDate date, int maxSize) throws Exception;

	public abstract TaskInstanceInfo[][] getTaskInstancesByDates(String contextId, String spaceId, LocalDate fromDate, LocalDate toDate, int maxSize) throws Exception;

	public abstract TaskInstanceInfo[][] getTaskInstancesByWeeks(String contextId, String spaceId, LocalDate month, int maxSize) throws Exception;

	public abstract TaskInstanceInfo[] getTaskInstancesByDate(String contextId, String spaceId, LocalDate fromDate, LocalDate toDate, int maxSize) throws Exception;

	public abstract TaskInstanceInfo[] getInstanceTaskHistoriesById(String instId) throws Exception;

	public abstract InstanceInfoList[] getInstanceRelatedWorksById(String instId) throws Exception;

	public abstract Report getReportById(String reportId) throws Exception;

	public abstract SearchFilter getSearchFilterById(String filterId) throws Exception;
	
	public abstract Data getReportData(HttpServletRequest request) throws Exception;
	
	public abstract String setInformationWorkInstance(Map<String, Object> requestBody, HttpServletRequest request) throws Exception;

	public abstract void removeInformationWorkInstance(Map<String, Object> requestBody, HttpServletRequest request) throws Exception;

	public abstract String startProcessWorkInstance(Map<String, Object> requestBody, HttpServletRequest request) throws Exception;

	public abstract String setFileInstance(HttpServletRequest request) throws Exception;

	public abstract String setEventInstance(HttpServletRequest request) throws Exception;

	public abstract String setMemoInstance(HttpServletRequest request) throws Exception;

	public abstract String setBoardInstance(HttpServletRequest request) throws Exception;

	public abstract CommunityInfo[] getAllComsByDepartmentId(String departmentId, boolean departmentOnly) throws Exception;

	public abstract MailFolder[] getMailFoldersById(String folderId) throws Exception;

	public abstract MailInstance getMailInstanceById(String folderId, String msgId) throws Exception;

	public abstract void setMyProfile(Map<String, Object> requestBody, HttpServletRequest request) throws Exception;

	public abstract void ajaxUploadFile(HttpServletRequest request, HttpServletResponse response) throws Exception;

	public abstract void uploadTempFile(HttpServletRequest request, HttpServletResponse response) throws Exception;

	public abstract List<IFileModel> findFileGroup(HttpServletRequest request) throws Exception;

	public abstract void deleteFile(HttpServletRequest request, HttpServletResponse response) throws Exception;

	public abstract String getFormXml(HttpServletRequest request, HttpServletResponse response) throws Exception;

	public abstract SwdRecord getRecord(HttpServletRequest request) throws Exception;

	public abstract void downloadFile(HttpServletRequest request, HttpServletResponse response) throws Exception;

	public abstract RequestParams setInstanceListParams(Map<String, Object> requestBody, HttpServletRequest request) throws Exception;

	public abstract void addAFavoriteWork(HttpServletRequest request) throws Exception;

	public abstract void removeAFavoriteWork(HttpServletRequest request) throws Exception;

	public abstract CompanyGeneral getCompanyGeneral() throws Exception;

	public abstract void setCompanyGeneral(Map<String, Object> requestBody, HttpServletRequest request) throws Exception;
	
	public abstract RecordList getWorkHourPolicyList(RequestParams params) throws Exception;
	
	public abstract WorkHourPolicy getWorkHourPolicyById(String id) throws Exception;
	
	public abstract void setWorkHourPolicy(Map<String, Object> requestBody, HttpServletRequest request) throws Exception;
	
	public abstract void removeWorkHourPolicy(Map<String, Object> requestBody, HttpServletRequest request) throws Exception;
	
	public abstract RecordList getCompanyEventList(RequestParams params) throws Exception;
	
	public abstract CompanyEvent getCompanyEventById(String id) throws Exception;
	
	public abstract void setCompanyEvent(Map<String, Object> requestBody, HttpServletRequest request) throws Exception;

	public abstract void removeCompanyEvent(Map<String, Object> requestBody, HttpServletRequest request) throws Exception;

	public abstract String performTaskInstance(Map<String, Object> requestBody, HttpServletRequest request) throws Exception;
	
	public abstract String returnTaskInstance(Map<String, Object> requestBody, HttpServletRequest request) throws Exception;
	
	public abstract String reassignTaskInstance(Map<String, Object> requestBody, HttpServletRequest request) throws Exception;
	
	public abstract String tempSaveTaskInstance(Map<String, Object> requestBody, HttpServletRequest request) throws Exception;
	
}
