package net.smartworks.service;

import javax.servlet.http.HttpServletRequest;

import net.smartworks.model.calendar.CompanyCalendar;
import net.smartworks.model.community.Community;
import net.smartworks.model.community.Department;
import net.smartworks.model.community.Group;
import net.smartworks.model.community.User;
import net.smartworks.model.community.WorkSpace;
import net.smartworks.model.instance.BoardInstance;
import net.smartworks.model.instance.EventInstance;
import net.smartworks.model.instance.Instance;
import net.smartworks.model.instance.WorkInstance;
import net.smartworks.model.notice.Notice;
import net.smartworks.model.notice.NoticeBox;
import net.smartworks.model.work.SmartWork;
import net.smartworks.model.work.Work;
import net.smartworks.model.work.WorkCategory;
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

	public abstract Instance[] getMyRunningInstances() throws Exception;
	
	public abstract String[] getBroadcastingMessages() throws Exception;

	public abstract CompanyCalendar[] getCompanyCalendars(LocalDate fromDate, int days) throws Exception;

	public abstract WorkSpace getWorkSpaceById(String workSpaceId) throws Exception;

	public abstract CompanyCalendar[] getCompanyCalendars(LocalDate fromDate, LocalDate toDate) throws Exception;

	public abstract EventInstance[] getEventInstances(LocalDate fromDate, int days) throws Exception;

	public abstract EventInstance[] getEventInstances(LocalDate fromDate, LocalDate toDate) throws Exception;

	public abstract BoardInstance[] getBoardInstances(LocalDate fromDate, int days) throws Exception;

	public abstract BoardInstance[] getBoardInstances(LocalDate fromDate, LocalDate toDate) throws Exception;

	public abstract CompanyCalendar getCompanyEventBox(LocalDate date) throws Exception;

	public abstract SmartWork[] getMyFavoriteWorks() throws Exception;

	public abstract WorkCategory[] getMyWorkCategories() throws Exception;

	public abstract SmartWork[] getMyAllWorksByCategoryId(String categoryId) throws Exception;

	public abstract SmartWork[] getMyAllWorksByGroupId(String groupId) throws Exception;

	public abstract WorkInstance[] getMyRecentInstances() throws Exception;

	public abstract Department[] getMyDepartments() throws Exception;

	public abstract Department getDepartmentById(String departId) throws Exception;

	public abstract Group[] getMyGroups() throws Exception;

	public abstract Group getGroupById(String groupId) throws Exception;

	public abstract Group setGroup(HttpServletRequest request) throws Exception;

	public abstract User getUserById(String userId) throws Exception;

	public abstract SmartWork[] searchWork(String key) throws Exception;

	public abstract WorkSpace[] searchCommunity(String key) throws Exception;

	public abstract User[] searchCommunityMember(String communityId, String key) throws Exception;

	public abstract User[] getAvailableChatter() throws Exception;

	public abstract User[] searchAvailableChatter(String key) throws Exception;

	public abstract User[] searchUser(String key) throws Exception;

	public abstract EventInstance[] getCompanyEventsByDate(LocalDate date, int maxEvents) throws Exception;

	public abstract EventInstance[] getMyEventsByDate(LocalDate date, int maxEvents) throws Exception;

	public abstract Notice[] getNoticesForMe() throws Exception;

	public abstract NoticeBox getNoticeBoxForMe10(int noticeType, LocalDate lastNotice) throws Exception;
	
	public abstract Work getWorkById(String workId) throws Exception;
	
	public abstract Instance getInstanceById(String instanceId) throws Exception;
	
	public abstract Instance[] searchMyRunningInstance(String key) throws Exception;

	public abstract Community[] getMyCommunities() throws Exception;

	public abstract String createFileXml(HttpServletRequest request) throws Exception;

}