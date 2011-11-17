package net.smartworks.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.smartworks.model.calendar.CompanyCalendar;
import net.smartworks.model.community.Community;
import net.smartworks.model.community.Department;
import net.smartworks.model.community.Group;
import net.smartworks.model.community.User;
import net.smartworks.model.community.WorkSpace;
import net.smartworks.model.instance.BoardInstance;
import net.smartworks.model.instance.CommentInstance;
import net.smartworks.model.instance.EventInstance;
import net.smartworks.model.instance.Instance;
import net.smartworks.model.instance.InstanceList;
import net.smartworks.model.instance.ListRequestParams;
import net.smartworks.model.instance.WorkInstance;
import net.smartworks.model.notice.Notice;
import net.smartworks.model.notice.NoticeBox;
import net.smartworks.model.work.SmartWork;
import net.smartworks.model.work.Work;
import net.smartworks.server.engine.docfile.model.IFileModel;
import net.smartworks.server.service.ICalendarService;
import net.smartworks.server.service.ICommunityService;
import net.smartworks.server.service.IDocFileService;
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
	IDocFileService docFileService;

	@Autowired
	public void setCommunityService(ICommunityService communityService) {
		this.communityService = communityService;
	}

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

	@Autowired
	public void setDocFileService(IDocFileService docFileService) {
		this.docFileService = docFileService;
	}

	@Override
	public Department[] getMyDepartments(String companyId, String userId) throws Exception {
		return communityService.getMyDepartments(companyId, userId);
	}

	@Override
	public Department getDepartmentById(String companyId, String departId) throws Exception {
		return communityService.getDepartmentById(companyId, departId);
	}

	@Override
	public Group[] getMyGroups(String companyId, String userId) throws Exception {
		return communityService.getMyGroups(companyId, userId);
	}

	@Override
	public Group getGroupById(String companyId, String groupId) throws Exception {
		return communityService.getGroupById(companyId, groupId);
	}

	@Override
	public Group setGroup(HttpServletRequest request) throws Exception {
		return communityService.setGroup(request);
	}

	@Override
	public User getUserById(String companyId, String userId) throws Exception {
		return communityService.getUserById(companyId, userId);
	}

	@Override
	public WorkSpace[] searchCommunity(String companyId, String userId, String key) throws Exception {
		return communityService.searchCommunity(companyId, userId, key);
	}

	@Override
	public User[] searchCommunityMember(String companyId, String communityId, String key) throws Exception {
		return communityService.searchCommunityMember(companyId, communityId, key);
	}

	@Override
	public SmartWork[] searchWork(String companyId, String userId, String key) throws Exception {
		return workService.searchWork(companyId, userId, key);
	}

	@Override
	public User[] searchUser(String companyId, String key) throws Exception {
		return communityService.searchUser(companyId, key);
	}

	@Override
	public Instance[] searchMyRunningInstance(String companyId, String userId, String key) throws Exception {
		return instanceService.searchMyRunningInstance(companyId, userId, key);
	}

	@Override
	public WorkSpace getWorkSpaceById(String companyId, String workSpaceId) throws Exception {
		return communityService.getWorkSpaceById(companyId, workSpaceId);
	}

	@Override
	public User[] getAvailableChatter(String companyId, String userId) throws Exception {
		return communityService.getAvailableChatter(companyId, userId);
	}

	@Override
	public User[] searchAvailableChatter(String companyId, String userId, String key) throws Exception {
		return communityService.searchAvailableChatter(companyId, userId, key);
	}

	@Override
	public String[] getBroadcastingMessages(String companyId) throws Exception {
		return noticeService.getBroadcastingMessages(companyId);
	}

	@Override
	public Notice[] getNoticesForMe(String companyId, String userId) throws Exception {
		return noticeService.getNoticesForMe(companyId, userId);
	}

	@Override
	public NoticeBox getNoticeBoxForMe10(String companyId, String userId, int noticeType, LocalDate lastNotice) throws Exception {
		return noticeService.getNoticeBoxForMe10(companyId, userId, noticeType, lastNotice);
	}

	@Override
	public CompanyCalendar[] getCompanyCalendars(String companyId, LocalDate fromDate, int days) throws Exception {
		return calendarService.getCompanyCalendars(companyId, fromDate, days);
	}

	@Override
	public CompanyCalendar[] getCompanyCalendars(String companyId, LocalDate fromDate, LocalDate toDate) throws Exception {
		return calendarService.getCompanyCalendars(companyId, fromDate, toDate);
	}

	@Override
	public EventInstance[] getEventInstances(String companyId, String userId, LocalDate fromDate, int days) throws Exception {
		return calendarService.getEventInstances(companyId, userId, fromDate, days);
	}

	@Override
	public EventInstance[] getEventInstances(String companyId, String userId, LocalDate fromDate, LocalDate toDate) throws Exception {
		return calendarService.getEventInstances(companyId, userId, fromDate, toDate);
	}

	@Override
	public CompanyCalendar getCompanyEventBox(String companyId, LocalDate date) throws Exception {
		return calendarService.getCompanyEventBox(companyId, date);
	}

	@Override
	public EventInstance[] getCompanyEventsByDate(String companyId, LocalDate date, int maxEvents) throws Exception {
		return calendarService.getCompanyEventsByDate(companyId, date, maxEvents);
	}

	@Override
	public EventInstance[] getMyEventsByDate(String companyId, String userId, LocalDate date, int maxEvents) throws Exception {
		return calendarService.getMyEventsByDate(companyId, userId, date, maxEvents);
	}

	@Override
	public BoardInstance[] getBoardInstances(String companyId, String userId, LocalDate fromDate, int days) throws Exception {
		return instanceService.getBoardInstances(companyId, userId, fromDate, days);
	}

	@Override
	public BoardInstance[] getBoardInstances(String companyId, String userId, LocalDate fromDate, LocalDate toDate) throws Exception {
		return instanceService.getBoardInstances(companyId, userId, fromDate, toDate);
	}

	@Override
	public WorkInstance[] getMyRecentInstances(String companyId, String userId) throws Exception {
		return instanceService.getMyRecentInstances(companyId, userId);
	}

	@Override
	public SmartWork[] getMyFavoriteWorks(String companyId, String userId) throws Exception {
		return workService.getMyFavoriteWorks(companyId, userId);
	}

	@Override
	public Work[] getMyAllWorksByCategoryId(String companyId, String userId, String categoryId) throws Exception {
		return workService.getMyAllWorksByCategoryId(companyId, userId, categoryId);
	}

	@Override
	public Instance[] getMyRunningInstances(String companyId, String userId) throws Exception {
		return instanceService.getMyRunningInstances(companyId, userId);
	}

	@Override
	public Work getWorkById(String companyId, String workId) throws Exception {
		return workService.getWorkById(companyId, workId);
	}

	@Override
	public Instance getInstanceById(String companyId, String instanceId) throws Exception {
		return instanceService.getInstanceById(companyId, instanceId);
	}

	@Override
	public Community[] getMyCommunities(String companyId, String userId) throws Exception {
		return communityService.getMyCommunities(companyId, userId);
	}

	@Override
	public CommentInstance[] getRecentCommentsInWorkManual(String companyId, String workId, int length) throws Exception{
		return instanceService.getRecentCommentsInWorkManual(companyId, workId, length);
	}

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

	@Override
	public InstanceList getWorkInstanceList(String companyId, String workId, ListRequestParams params) throws Exception {
		return instanceService.getWorkInstanceList(companyId, workId, params);
	}

/*	@Override
>>>>>>> branch 'master' of git@github.com:maninsoft/smartworksV3.git
	public String createFile(String userId, String groupId, IFileModel file) throws Exception {
		return docFileService.createFile(userId, groupId, file);
	}

	@Override
	public String createFileList(String userId, String groupId, List<IFileModel> fileList) throws Exception {
		return docFileService.createFileList(userId, groupId, fileList);
	}

	@Override
	public IFileModel retrieveFile(String fileId) throws Exception {
		return docFileService.retrieveFile(fileId);
	}

	@Override
	public void updateFile(String userId, IFileModel file) throws Exception {
		docFileService.updateFile(userId, file);
	}

	@Override
	public void deleteFile(String fileId) throws Exception {
		docFileService.deleteFile(fileId);
	}

	@Override
	public void deleteFileGroup(String groupId) throws Exception {
		docFileService.deleteFileGroup(groupId);
	}

	@Override
	public List<IFileModel> findFileGroup(String groupId) throws Exception {
		return docFileService.findFileGroup(groupId);
	}

	@Override
	public List<String> findFileIdListByGroup(String groupId) throws Exception {
		return docFileService.findFileIdListByGroup(groupId);
	}

	@Override
	public String createDocument(String userId, String groupId, IDocumentModel document, List<FileItem> fileList) throws Exception {
		return docFileService.createDocument(userId, groupId, document, fileList);
	}

	@Override
	public void updateDocument(String userId, IDocumentModel document) throws Exception {
		docFileService.updateDocument(userId, document);
	}

	@Override
	public IDocumentModel retrieveDocument(String documentId) throws Exception {
		return docFileService.retrieveDocument(documentId);
	}

	@Override
	public IDocumentModel retrieveDocumentByGroupId(String fileGroupId) throws Exception {
		return docFileService.retrieveDocumentByGroupId(fileGroupId);
	}

	@Override
	public List<String> findDocIdByGroupId(String fileGroupId) throws Exception {
		return docFileService.findDocIdByGroupId(fileGroupId);
	}

	@Override
	public void deleteDocument(String documentId) throws Exception {
		docFileService.deleteDocument(documentId);
	}

	@Override
	public IDocumentModel retrieveDocumentByRef(int refType, String refId) throws Exception {
		return docFileService.retrieveDocumentByRef(refType, refId);
	}*/

	public String uploadFile(HttpServletRequest request) throws Exception {
		return docFileService.uploadFile(request);
	}

	public List<IFileModel> findFileGroup(HttpServletRequest request) throws Exception {
		return docFileService.findFileGroup(request);
	}

	public void deleteFile(HttpServletRequest request) throws Exception {
		docFileService.deleteFile(request);
	}

}
