package net.smartworks.service.impl;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.smartworks.model.calendar.CompanyCalendar;
import net.smartworks.model.community.Department;
import net.smartworks.model.community.Group;
import net.smartworks.model.community.User;
import net.smartworks.model.community.WorkSpace;
import net.smartworks.model.community.info.CommunityInfo;
import net.smartworks.model.community.info.DepartmentInfo;
import net.smartworks.model.community.info.GroupInfo;
import net.smartworks.model.community.info.UserInfo;
import net.smartworks.model.community.info.WorkSpaceInfo;
import net.smartworks.model.filter.SearchFilter;
import net.smartworks.model.instance.CommentInstance;
import net.smartworks.model.instance.Instance;
import net.smartworks.model.instance.MailInstance;
import net.smartworks.model.instance.WorkInstance;
import net.smartworks.model.instance.info.BoardInstanceInfo;
import net.smartworks.model.instance.info.EventInstanceInfo;
import net.smartworks.model.instance.info.InstanceInfo;
import net.smartworks.model.instance.info.InstanceInfoList;
import net.smartworks.model.instance.info.RequestParams;
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
import net.smartworks.server.service.ICalendarService;
import net.smartworks.server.service.ICommunityService;
import net.smartworks.server.service.IDocFileService;
import net.smartworks.server.service.IInstanceService;
import net.smartworks.server.service.IMailService;
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
	IMailService mailService;
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
	public void setMailService(IMailService mailService) {
		this.mailService = mailService;
	}

	@Autowired
	public void setDocFileService(IDocFileService docFileService) {
		this.docFileService = docFileService;
	}

	@Override
	public DepartmentInfo[] getMyDepartments() throws Exception {
		return communityService.getMyDepartments();
	}

	@Override
	public Department getDepartmentById(String departId) throws Exception {
		return communityService.getDepartmentById(departId);
	}

	@Override
	public GroupInfo[] getMyGroups() throws Exception {
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
	public WorkSpaceInfo[] searchCommunity(String key) throws Exception {
		return communityService.searchCommunity(key);
	}

	@Override
	public UserInfo[] searchCommunityMember(String communityId, String key) throws Exception {
		return communityService.searchCommunityMember(communityId, key);
	}

	@Override
	public SmartWorkInfo[] searchWork(String key) throws Exception {
		return workService.searchWork(key);
	}

	@Override
	public UserInfo[] searchUser(String key) throws Exception {
		return communityService.searchUser(key);
	}

	@Override
	public InstanceInfo[] searchMyRunningInstance(String key) throws Exception {
		return instanceService.searchMyRunningInstance(key);
	}

	@Override
	public WorkSpace getWorkSpaceById(String workSpaceId) throws Exception {
		return communityService.getWorkSpaceById(workSpaceId);
	}

	@Override
	public UserInfo[] getAvailableChatter() throws Exception {
		return communityService.getAvailableChatter();
	}

	@Override
	public UserInfo[] searchAvailableChatter(String key) throws Exception {
		return communityService.searchAvailableChatter(key);
	}

	@Override
	public String[] getBroadcastingMessages() throws Exception {
		return noticeService.getBroadcastingMessages();
	}

	@Override
	public Notice[] getNoticesForMe() throws Exception {
		return noticeService.getNoticesForMe();
	}

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
	public EventInstanceInfo[] getEventInstances(LocalDate fromDate, int days) throws Exception {
		return calendarService.getEventInstances(fromDate, days);
	}

	@Override
	public EventInstanceInfo[] getEventInstances(LocalDate fromDate, LocalDate toDate) throws Exception {
		return calendarService.getEventInstances(fromDate, toDate);
	}

	@Override
	public CompanyCalendar getCompanyEventBox(LocalDate date) throws Exception {
		return calendarService.getCompanyEventBox(date);
	}

	@Override
	public EventInstanceInfo[] getCompanyEventsByDate(LocalDate date, int maxEvents) throws Exception {
		return calendarService.getCompanyEventsByDate(date, maxEvents);
	}

	@Override
	public EventInstanceInfo[] getMyEventsByDate(LocalDate date, int maxEvents) throws Exception {
		return calendarService.getMyEventsByDate(date, maxEvents);
	}

	@Override
	public BoardInstanceInfo[] getBoardInstances(LocalDate fromDate, int days) throws Exception {
		return instanceService.getBoardInstances(fromDate, days);
	}

	@Override
	public BoardInstanceInfo[] getBoardInstances(LocalDate fromDate, LocalDate toDate) throws Exception {
		return instanceService.getBoardInstances(fromDate, toDate);
	}

	@Override
	public InstanceInfo[] getMyRecentInstances() throws Exception {
		return instanceService.getMyRecentInstances();
	}

	@Override
	public SmartWorkInfo[] getMyFavoriteWorks() throws Exception {
		return workService.getMyFavoriteWorks();
	}

	@Override
	public WorkInfo[] getMyAllWorksByCategoryId(String categoryId) throws Exception {
		return workService.getMyAllWorksByCategoryId(categoryId);
	}

	@Override
	public InstanceInfo[] getMyRunningInstances() throws Exception {
		return instanceService.getMyRunningInstances();
	}

	@Override
	public String getWorkIdByFormId(String formId) throws Exception {
		return workService.getWorkIdByFormId(formId);
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
	public CommunityInfo[] getMyCommunities() throws Exception {
		return communityService.getMyCommunities();
	}

	@Override
	public CommentInstance[] getRecentCommentsInWorkManual(String workId, int length) throws Exception {
		return instanceService.getRecentCommentsInWorkManual(workId, length);
	}

	public String setInformationWorkInstance(Map<String, Object> requestBody, HttpServletRequest request) throws Exception {
		return instanceService.setInformationWorkInstance(requestBody, request);

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
	public InstanceInfoList getIWorkInstanceList(String workId, RequestParams params) throws Exception {
		return instanceService.getIWorkInstanceList(workId, params);
	}

	@Override
	public InstanceInfoList getPWorkInstanceList(String workId, RequestParams params) throws Exception {
		return instanceService.getPWorkInstanceList(workId, params);
	}

	@Override
	public WorkInstance getWorkInstanceById(String instanceId) throws Exception {
		return instanceService.getWorkInstanceById(instanceId);
	}

	/*
	 * @Override >>>>>>> branch 'master' of
	 * git@github.com:maninsoft/smartworksV3.git public String createFile(String
	 * userId, String groupId, IFileModel file) throws Exception { return
	 * docFileService.createFile(userId, groupId, file); }
	 * 
	 * @Override public String createFileList(String userId, String groupId,
	 * List<IFileModel> fileList) throws Exception { return
	 * docFileService.createFileList(userId, groupId, fileList); }
	 * 
	 * @Override public IFileModel retrieveFile(String fileId) throws Exception
	 * { return docFileService.retrieveFile(fileId); }
	 * 
	 * @Override public void updateFile(String userId, IFileModel file) throws
	 * Exception { docFileService.updateFile(userId, file); }
	 * 
	 * @Override public void deleteFile(String fileId) throws Exception {
	 * docFileService.deleteFile(fileId); }
	 * 
	 * @Override public void deleteFileGroup(String groupId) throws Exception {
	 * docFileService.deleteFileGroup(groupId); }
	 * 
	 * @Override public List<IFileModel> findFileGroup(String groupId) throws
	 * Exception { return docFileService.findFileGroup(groupId); }
	 * 
	 * @Override public List<String> findFileIdListByGroup(String groupId)
	 * throws Exception { return docFileService.findFileIdListByGroup(groupId);
	 * }
	 * 
	 * @Override public String createDocument(String userId, String groupId,
	 * IDocumentModel document, List<FileItem> fileList) throws Exception {
	 * return docFileService.createDocument(userId, groupId, document,
	 * fileList); }
	 * 
	 * @Override public void updateDocument(String userId, IDocumentModel
	 * document) throws Exception { docFileService.updateDocument(userId,
	 * document); }
	 * 
	 * @Override public IDocumentModel retrieveDocument(String documentId)
	 * throws Exception { return docFileService.retrieveDocument(documentId); }
	 * 
	 * @Override public IDocumentModel retrieveDocumentByGroupId(String
	 * fileGroupId) throws Exception { return
	 * docFileService.retrieveDocumentByGroupId(fileGroupId); }
	 * 
	 * @Override public List<String> findDocIdByGroupId(String fileGroupId)
	 * throws Exception { return docFileService.findDocIdByGroupId(fileGroupId);
	 * }
	 * 
	 * @Override public void deleteDocument(String documentId) throws Exception
	 * { docFileService.deleteDocument(documentId); }
	 * 
	 * @Override public IDocumentModel retrieveDocumentByRef(int refType, String
	 * refId) throws Exception { return
	 * docFileService.retrieveDocumentByRef(refType, refId); }
	 */

//	public String uploadFile(HttpServletRequest request) throws Exception {
//		return docFileService.uploadFile(request);
//	}

	public void ajaxUploadFile(HttpServletRequest request, HttpServletResponse response) throws Exception {
		docFileService.ajaxUploadFile(request, response);
	}

	public List<IFileModel> findFileGroup(HttpServletRequest request) throws Exception {
		return docFileService.findFileGroup(request);
	}

	public void deleteFile(HttpServletRequest request, HttpServletResponse response) throws Exception {
		docFileService.deleteFile(request, response);
	}

	@Override
	public Report getReportById(String reportId) throws Exception {
		// TODO Auto-generated method stub
		return workService.getReportById(reportId);
	}

	@Override
	public SearchFilter getSearchFilterById(String filterId) throws Exception {
		// TODO Auto-generated method stub
		return workService.getSearchFilterById(filterId);
	}

	@Override
	public void setMyProfile(Map<String, Object> requestBody, HttpServletRequest request) throws Exception {
		workService.setMyProfile(requestBody, request);
	}

	@Override
	public CommunityInfo[] getAllComsByDepartmentId(String departmentId, boolean departmentOnly) throws Exception {
		return workService.getAllComsByDepartmentId(departmentId, departmentOnly);
	}

	@Override
	public Data getReportData(HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		return workService.getReportData(request);
	}

	@Override
	public String getFormXml(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return workService.getFormXml(request.getParameter("workId"));
	}

	@Override
	public SwdRecord getRecord(HttpServletRequest request) throws Exception {
		return workService.getRecord(request);
	}

	public void downloadFile(HttpServletRequest request, HttpServletResponse response) throws Exception {
		docFileService.downloadFile(request, response);

	}

	@Override
	public void uploadTempFile(HttpServletRequest request, HttpServletResponse response) throws Exception {
		docFileService.uploadTempFile(request, response);
	}

	@Override
	public MailFolder[] getMailFoldersById(String folderId) throws Exception {
		return mailService.getMailFoldersById(folderId);
	}

	@Override
	public InstanceInfoList getMailInstanceList(String folderId, RequestParams params) throws Exception {
		return mailService.getMailInstanceList(folderId, params);
	}

	@Override
	public MailInstance getMailInstanceById(String folderId, String msgId) throws Exception {
		return mailService.getMailInstanceById(folderId, msgId);
	}

	@Override
	public RequestParams setInstanceListParams(Map<String, Object> requestBody, HttpServletRequest request) throws Exception {
		return workService.setInstanceListParams(requestBody, request);
	}

}