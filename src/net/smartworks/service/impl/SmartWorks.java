package net.smartworks.service.impl;

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
import net.smartworks.server.service.ICalendarService;
import net.smartworks.server.service.ICommunityService;
import net.smartworks.server.service.IInstanceService;
import net.smartworks.server.service.INoticeService;
import net.smartworks.server.service.IWorkService;
import net.smartworks.service.ISmartWorks;
import net.smartworks.util.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SmartWorks implements ISmartWorks {

	ICommunityService communityService;
	INoticeService noticeService;
	ICalendarService calendarService;
	IInstanceService instanceService;
	IWorkService workService;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * net.smartworks.service.impl.ISmartWorks#setCommunityService(net.smartworks
	 * .server.service.ICommunityService)
	 */
	@Autowired
	public void setCommunityService(ICommunityService communityService) {
		this.communityService = communityService;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * net.smartworks.service.impl.ISmartWorks#setNoticeService(net.smartworks
	 * .server.service.INoticeService)
	 */
	@Autowired
	public void setNoticeService(INoticeService noticeService) {
		this.noticeService = noticeService;
	}

	@Autowired
	public void setCalendarService(ICalendarService calendarService) {
		this.calendarService = calendarService;
	}

	@Autowired
	public void setInstanceService(IInstanceService instanceService) {
		this.instanceService = instanceService;
	}

	@Autowired
	public void setWorkService(IWorkService workService) {
		this.workService = workService;
	}

	@Override
	public Department[] getMyDepartments(String companyId, String userId) throws Exception {
		return communityService.getMyDepartments();
	}

	@Override
	public Department getDepartmentById(String companyId, String departId) throws Exception {
		return communityService.getDepartmentById(departId);
	}

	@Override
	public Group[] getMyGroups(String companyId, String userId) throws Exception {
		return communityService.getMyGroups();
	}

	@Override
	public Group getGroupById(String companyId, String groupId) throws Exception {
		return communityService.getGroupById(groupId);
	}

	@Override
	public Group setGroup(HttpServletRequest request) throws Exception {
		return communityService.setGroup(request);
	}

	@Override
	public User getUserById(String companyId, String userId) throws Exception {
		return communityService.getUserById(userId);
	}

	@Override
	public WorkSpace[] searchCommunity(String companyId, String userId, String key) throws Exception {
		return communityService.searchCommunity(key);
	}

	@Override
	public User[] searchCommunityMember(String companyId, String communityId, String key) throws Exception {
		return communityService.searchCommunityMember(communityId, key);
	}

	@Override
	public SmartWork[] searchWork(String companyId, String userId, String key) throws Exception {
		return workService.searchWork(key);
	}

	@Override
	public User[] searchUser(String companyId, String key) throws Exception {
		return communityService.searchUser(key);
	}

	@Override
	public Instance[] searchMyRunningInstance(String companyId, String userId, String key) throws Exception {
		return instanceService.searchMyRunningInstance(key);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * net.smartworks.service.impl.ISmartWorks#getWorkSpaceById(java.lang.String
	 * )
	 */
	@Override
	public WorkSpace getWorkSpaceById(String companyId, String workSpaceId) throws Exception {
		return communityService.getWorkSpaceById(workSpaceId);
	}

	@Override
	public User[] getAvailableChatter(String companyId, String userId) throws Exception {
		return communityService.getAvailableChatter();
	}

	@Override
	public User[] searchAvailableChatter(String companyId, String userId, String key) throws Exception {
		return communityService.searchAvailableChatter(key);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.smartworks.service.impl.ISmartWorks#getBroadcastingMessages()
	 */
	@Override
	public String[] getBroadcastingMessages(String companyId) throws Exception {
		return noticeService.getBroadcastingMessages();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * net.smartworks.service.impl.ISmartWorks#getNoticesForMe(java.lang.String)
	 */
	@Override
	public Notice[] getNoticesForMe(String companyId, String userId) throws Exception {
		return noticeService.getNoticesForMe();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.smartworks.service.impl.ISmartWorks#getNoticeBoxForMe10(int,
	 * net.smartworks.util.LocalDate)
	 */
	@Override
	public NoticeBox getNoticeBoxForMe10(String companyId, String userId, int noticeType, LocalDate lastNotice) throws Exception {
		return noticeService.getNoticeBoxForMe10(noticeType, lastNotice);
	}

	@Override
	public CompanyCalendar[] getCompanyCalendars(String companyId, LocalDate fromDate, int days) throws Exception {
		return calendarService.getCompanyCalendars(fromDate, days);
	}

	@Override
	public CompanyCalendar[] getCompanyCalendars(String companyId, LocalDate fromDate, LocalDate toDate) throws Exception {
		return calendarService.getCompanyCalendars(fromDate, toDate);
	}

	@Override
	public EventInstance[] getEventInstances(String companyId, String userId, LocalDate fromDate, int days) throws Exception {
		return calendarService.getEventInstances(fromDate, days);
	}

	@Override
	public EventInstance[] getEventInstances(String companyId, String userId, LocalDate fromDate, LocalDate toDate) throws Exception {
		return calendarService.getEventInstances(fromDate, toDate);
	}

	@Override
	public CompanyCalendar getCompanyEventBox(String companyId, LocalDate date) throws Exception {
		return calendarService.getCompanyEventBox(date);
	}

	@Override
	public EventInstance[] getCompanyEventsByDate(String companyId, LocalDate date, int maxEvents) throws Exception {
		return calendarService.getCompanyEventsByDate(date, maxEvents);
	}

	@Override
	public EventInstance[] getMyEventsByDate(String companyId, String userId, LocalDate date, int maxEvents) throws Exception {
		return calendarService.getMyEventsByDate(date, maxEvents);
	}

	@Override
	public BoardInstance[] getBoardInstances(String companyId, String userId, LocalDate fromDate, int days) throws Exception {
		return instanceService.getBoardInstances(fromDate, days);
	}

	@Override
	public BoardInstance[] getBoardInstances(String companyId, String userId, LocalDate fromDate, LocalDate toDate) throws Exception {
		return instanceService.getBoardInstances(fromDate, toDate);
	}

	@Override
	public WorkInstance[] getMyRecentInstances(String companyId, String userId) throws Exception {
		return instanceService.getMyRecentInstances();
	}

	@Override
	public SmartWork[] getMyFavoriteWorks(String companyId, String userId) throws Exception {
		return workService.getMyFavoriteWorks();
	}

	@Override
	public WorkCategory[] getMyWorkCategories(String companyId, String userId) throws Exception {
		return workService.getMyWorkCategories(companyId, userId);
	}

	@Override
	public SmartWork[] getMyAllWorksByCategoryId(String companyId, String userId, String categoryId) throws Exception {
		return workService.getMyAllWorksByCategoryId(categoryId);
	}

	@Override
	public SmartWork[] getMyAllWorksByGroupId(String companyId, String userId, String groupId) throws Exception {
		return workService.getMyAllWorksByGroupId(groupId);
	}

	@Override
	public Instance[] getMyRunningInstances(String companyId, String userId) throws Exception {
		return instanceService.getMyRunningInstances();
	}

	@Override
	public Work getWorkById(String companyId, String workId) throws Exception {
		return workService.getWorkById(workId);
	}

	@Override
	public Instance getInstanceById(String companyId, String instanceId) throws Exception {
		return instanceService.getInstanceById(instanceId);
	}

	@Override
	public Community[] getMyCommunities(String companyId, String userId) throws Exception {
		return communityService.getMyCommunities();
	}

	@Override
	public String setInformationWorkInstance(HttpServletRequest request) throws Exception {
		return instanceService.setInformationWorkInstance(request);

	}

	@Override
	public String startProcessWorkInstance(HttpServletRequest request) throws Exception {
		return instanceService.startProcessWorkInstance(request);

	}

	@Override
	public String setFileInstance(HttpServletRequest request) throws Exception {
		return instanceService.setFileInstance(request);

	}

	@Override
	public String setEventInstance(HttpServletRequest request) throws Exception {
		return instanceService.setEventInstance(request);

	}

	@Override
	public String setMemoInstance(HttpServletRequest request) throws Exception {
		return instanceService.setMemoInstance(request);
	}

	@Override
	public String setBoardInstance(HttpServletRequest request) throws Exception {
		return instanceService.setBoardInstance(request);

	}
}
