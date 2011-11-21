package net.smartworks.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.smartworks.model.calendar.CompanyCalendar;
import net.smartworks.model.community.Community;
import net.smartworks.model.community.Department;
import net.smartworks.model.community.Group;
import net.smartworks.model.community.User;
import net.smartworks.model.community.WorkSpace;
import net.smartworks.model.community.info.CommunityInfo;
import net.smartworks.model.community.info.DepartmentInfo;
import net.smartworks.model.community.info.GroupInfo;
import net.smartworks.model.community.info.UserInfo;
import net.smartworks.model.community.info.WorkSpaceInfo;
import net.smartworks.model.instance.BoardInstance;
import net.smartworks.model.instance.CommentInstance;
import net.smartworks.model.instance.EventInstance;
import net.smartworks.model.instance.Instance;
import net.smartworks.model.instance.WorkInstance;
import net.smartworks.model.instance.info.BoardInstanceInfo;
import net.smartworks.model.instance.info.EventInstanceInfo;
import net.smartworks.model.instance.info.InstanceInfo;
import net.smartworks.model.instance.info.InstanceInfoList;
import net.smartworks.model.instance.info.RequestParams;
import net.smartworks.model.notice.Notice;
import net.smartworks.model.notice.NoticeBox;
import net.smartworks.model.work.SmartWork;
import net.smartworks.model.work.Work;
import net.smartworks.model.work.WorkCategory;
import net.smartworks.model.work.info.SmartWorkInfo;
import net.smartworks.model.work.info.WorkInfo;
import net.smartworks.server.engine.docfile.model.IFileModel;
import net.smartworks.util.LocalDate;

public interface ISmartWorks {

	public final static String CONTEXT_HOME = "sf.hm";
	public final static String CONTEXT_SMARTCASTER = "sf.sc";
	public final static String CONTEXT_DASHBOARD = "sf.db";
	public final static String CONTEXT_MYPROFILE = "sf.pf";

	public final static String CONTEXT_PREFIX_SELF = "sf.";

	public final static int SPACE_TYPE_WORK_LIST = 1;
	public final static int SPACE_TYPE_WORK_INSTANCE = 2;
	public final static int SPACE_TYPE_TASK_INSTANCE = 3;

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

	public abstract InstanceInfo[] getMyRunningInstances(String companyId, String userId) throws Exception;
	
	public abstract String[] getBroadcastingMessages(String companyId) throws Exception;

	public abstract CompanyCalendar[] getCompanyCalendars(String companyId, LocalDate fromDate, int days) throws Exception;

	public abstract WorkSpace getWorkSpaceById(String companyId, String workSpaceId) throws Exception;

	public abstract CompanyCalendar[] getCompanyCalendars(String companyId, LocalDate fromDate, LocalDate toDate) throws Exception;

	public abstract EventInstanceInfo[] getEventInstances(String companyId, String userId, LocalDate fromDate, int days) throws Exception;

	public abstract EventInstanceInfo[] getEventInstances(String companyId, String userId, LocalDate fromDate, LocalDate toDate) throws Exception;

	public abstract BoardInstanceInfo[] getBoardInstances(String companyId, String userId, LocalDate fromDate, int days) throws Exception;

	public abstract BoardInstanceInfo[] getBoardInstances(String companyId, String userId, LocalDate fromDate, LocalDate toDate) throws Exception;

	public abstract CompanyCalendar getCompanyEventBox(String companyId, LocalDate date) throws Exception;

	public abstract SmartWorkInfo[] getMyFavoriteWorks(String companyId, String userId) throws Exception;

	public abstract WorkInfo[] getMyAllWorksByCategoryId(String companyId, String userId, String categoryId) throws Exception;

	public abstract InstanceInfo[] getMyRecentInstances(String companyId, String userId) throws Exception;

	public abstract DepartmentInfo[] getMyDepartments(String companyId, String userId) throws Exception;

	public abstract Department getDepartmentById(String companyId, String departId) throws Exception;

	public abstract GroupInfo[] getMyGroups(String companyId, String userId) throws Exception;

	public abstract Group getGroupById(String companyId, String groupId) throws Exception;

	public abstract Group setGroup(HttpServletRequest request) throws Exception;

	public abstract User getUserById(String companyId, String userId) throws Exception;

	public abstract SmartWorkInfo[] searchWork(String companyId, String userId, String key) throws Exception;

	public abstract WorkSpaceInfo[] searchCommunity(String companyId, String userId, String key) throws Exception;

	public abstract UserInfo[] searchCommunityMember(String companyId, String communityId, String key) throws Exception;

	public abstract UserInfo[] getAvailableChatter(String companyId, String userId) throws Exception;

	public abstract UserInfo[] searchAvailableChatter(String companyId, String userId ,String key) throws Exception;

	public abstract UserInfo[] searchUser(String companyId, String key) throws Exception;

	public abstract EventInstanceInfo[] getCompanyEventsByDate(String companyId, LocalDate date, int maxEvents) throws Exception;

	public abstract EventInstanceInfo[] getMyEventsByDate(String companyId, String userId, LocalDate date, int maxEvents) throws Exception;

	public abstract Notice[] getNoticesForMe(String companyId, String userId) throws Exception;

	public abstract NoticeBox getNoticeBoxForMe10(String companyId, String userId, int noticeType, LocalDate lastNotice) throws Exception;
	
	public abstract Work getWorkById(String companyId, String userId, String workId) throws Exception;
	
	public abstract Instance getInstanceById(String companyId, String instanceId) throws Exception;
	
	public abstract InstanceInfo[] searchMyRunningInstance(String companyId, String userId, String key) throws Exception;

	public abstract CommunityInfo[] getMyCommunities(String companyId, String userId) throws Exception;

	public abstract CommentInstance[] getRecentCommentsInWorkManual(String companyId, String workId, int length) throws Exception;
	
	public abstract InstanceInfoList getIWorkInstanceList(String companyId, String userId, String workId, RequestParams params) throws Exception;
	
	public abstract InstanceInfoList getPWorkInstanceList(String companyId, String userId, String workId, RequestParams params) throws Exception;
	
	public abstract String setInformationWorkInstance(HttpServletRequest request) throws Exception;

	public abstract String startProcessWorkInstance(HttpServletRequest request) throws Exception;

	public abstract String setFileInstance(HttpServletRequest request) throws Exception;

	public abstract String setEventInstance(HttpServletRequest request) throws Exception;

	public abstract String setMemoInstance(HttpServletRequest request) throws Exception;

	public abstract String setBoardInstance(HttpServletRequest request) throws Exception;

	public abstract String uploadFile(HttpServletRequest request) throws Exception;

	public abstract List<IFileModel> findFileGroup(HttpServletRequest request) throws Exception;

	public abstract void deleteFile(HttpServletRequest request) throws Exception;

}
