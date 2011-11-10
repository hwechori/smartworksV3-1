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
	public Department[] getMyDepartments() throws Exception {
		return communityService.getMyDepartments();
	}

	@Override
	public Department getDepartmentById(String departId) throws Exception {
		return communityService.getDepartmentById(departId);
	}

	@Override
	public Group[] getMyGroups() throws Exception {
		return communityService.getMyGroups();
	}

	@Override
	public Group getGroupById(String groupId) throws Exception {
		return communityService.getGroupById(groupId);
	}

	@Override
	public Group setGroup(HttpServletRequest request) throws Exception {
		return communityService.setGroup(request);
	}

	@Override
	public User getUserById(String userId) throws Exception {
		return communityService.getUserById(userId);
	}

	@Override
	public WorkSpace[] searchCommunity(String key) throws Exception {
		return communityService.searchCommunity(key);
	}

	@Override
	public User[] searchCommunityMember(String communityId, String key) throws Exception {
		return communityService.searchCommunityMember(communityId, key);
	}

	@Override
	public SmartWork[] searchWork(String key) throws Exception {
		return workService.searchWork(key);
	}

	@Override
	public User[] searchUser(String key) throws Exception {
		return communityService.searchUser(key);
	}


	@Override
	public Instance[] searchMyRunningInstance(String key) throws Exception {
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
	public WorkSpace getWorkSpaceById(String workSpaceId) throws Exception {
		return communityService.getWorkSpaceById(workSpaceId);
	}

	@Override
	public User[] getAvailableChatter() throws Exception {
		return communityService.getAvailableChatter();
	}

	@Override
	public User[] searchAvailableChatter(String key) throws Exception {
		return communityService.searchAvailableChatter(key);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.smartworks.service.impl.ISmartWorks#getBroadcastingMessages()
	 */
	@Override
	public String[] getBroadcastingMessages() throws Exception {
		return noticeService.getBroadcastingMessages();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * net.smartworks.service.impl.ISmartWorks#getNoticesForMe(java.lang.String)
	 */
	@Override
	public Notice[] getNoticesForMe() throws Exception {
		return noticeService.getNoticesForMe();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.smartworks.service.impl.ISmartWorks#getNoticeBoxForMe10(int,
	 * net.smartworks.util.LocalDate)
	 */
	@Override
	public NoticeBox getNoticeBoxForMe10(int noticeType, LocalDate lastNotice) throws Exception {
		return noticeService.getNoticeBoxForMe10(noticeType, lastNotice);
	}

	@Override
	public CompanyCalendar[] getCompanyCalendars(LocalDate fromDate, int days) throws Exception {
		return calendarService.getCompanyCalendars(fromDate, days);
	}

	@Override
	public CompanyCalendar[] getCompanyCalendars(LocalDate fromDate, LocalDate toDate) throws Exception {
		return calendarService.getCompanyCalendars(fromDate, toDate);
	}

	@Override
	public EventInstance[] getEventInstances(LocalDate fromDate, int days) throws Exception {
		return calendarService.getEventInstances(fromDate, days);
	}

	@Override
	public EventInstance[] getEventInstances(LocalDate fromDate, LocalDate toDate) throws Exception {
		return calendarService.getEventInstances(fromDate, toDate);
	}

	@Override
	public CompanyCalendar getCompanyEventBox(LocalDate date) throws Exception {
		return calendarService.getCompanyEventBox(date);
	}

	@Override
	public EventInstance[] getCompanyEventsByDate(LocalDate date, int maxEvents) throws Exception {
		return calendarService.getCompanyEventsByDate(date, maxEvents);
	}

	@Override
	public EventInstance[] getMyEventsByDate(LocalDate date, int maxEvents) throws Exception {
		return calendarService.getMyEventsByDate(date, maxEvents);
	}

	@Override
	public BoardInstance[] getBoardInstances(LocalDate fromDate, int days) throws Exception {
		return instanceService.getBoardInstances(fromDate, days);
	}

	@Override
	public BoardInstance[] getBoardInstances(LocalDate fromDate, LocalDate toDate) throws Exception {
		return instanceService.getBoardInstances(fromDate, toDate);
	}

	@Override
	public WorkInstance[] getMyRecentInstances() throws Exception {
		return instanceService.getMyRecentInstances();
	}

	@Override
	public SmartWork[] getMyFavoriteWorks() throws Exception {
		return workService.getMyFavoriteWorks();
	}

	@Override
	public WorkCategory[] getMyWorkCategories() throws Exception {
		return workService.getMyWorkCategories();
	}

	@Override
	public SmartWork[] getMyAllWorksByCategoryId(String categoryId) throws Exception {
		return workService.getMyAllWorksByCategoryId(categoryId);
	}

	@Override
	public SmartWork[] getMyAllWorksByGroupId(String groupId) throws Exception {
		return workService.getMyAllWorksByGroupId(groupId);
	}

	@Override
	public Instance[] getMyRunningInstances() throws Exception {
		return instanceService.getMyRunningInstances();
	}

	@Override
	public Work getWorkById(String workId) throws Exception {
		return workService.getWorkById(workId);
	}

	@Override
	public Instance getInstanceById(String instanceId) throws Exception {
		return instanceService.getInstanceById(instanceId);
	}

	@Override
	public Community[] getMyCommunities() throws Exception {
		return communityService.getMyCommunities();
	}
}
