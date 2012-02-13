
package net.smartworks.service.impl;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.smartworks.model.RecordList;
import net.smartworks.model.approval.ApprovalLine;
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
import net.smartworks.model.service.ExternalForm;
import net.smartworks.model.service.WebService;
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
import net.smartworks.server.service.ISettingsService;
import net.smartworks.server.service.IWorkService;
import net.smartworks.server.service.impl.SettingsServiceImpl;
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
	ISettingsService settingsService;

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

	@Autowired
	public void setSettingsService(ISettingsService settingsService) {
		this.settingsService = settingsService;
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
	public String setGroup(Map<String, Object> requestBody, HttpServletRequest request) throws Exception {
		return communityService.setGroup(requestBody, request);
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
	public void removeNoticeInstance(String noticeId) throws Exception {
		noticeService.removeNoticeInstance(noticeId);
	}

	@Override
	public NoticeBox getNoticeBoxForMe10(int noticeType, String lastNoticeId) throws Exception {
		return noticeService.getNoticeBoxForMe10(noticeType, lastNoticeId);
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
	public EventInstanceInfo[] getMyEventInstances(LocalDate fromDate, int days) throws Exception {
		return calendarService.getMyEventInstances(fromDate, days);
	}

	@Override
	public EventInstanceInfo[] getMyEventInstances(LocalDate fromDate, LocalDate toDate) throws Exception {
		return calendarService.getMyEventInstances(fromDate, toDate);
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
	public WorkHourPolicy getCompanyWorkHourPolicy() throws Exception {
		return calendarService.getCompanyWorkHourPolicy();
	}

	@Override
	public BoardInstanceInfo[] getMyRecentBoardInstances() throws Exception {
		return instanceService.getMyRecentBoardInstances();
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
	public WorkInfo[] getAllWorksByCategoryId(String categoryId) throws Exception {
		return workService.getAllWorksByCategoryId(categoryId);
	}

	@Override
	public InstanceInfo[] getMyRunningInstances(LocalDate lastInstanceDate, int requestSize, boolean assignedOnly) throws Exception {
		return instanceService.getMyRunningInstances(lastInstanceDate, requestSize, assignedOnly);
	}

	@Override
	public RunningCounts getMyRunningInstancesCounts() throws Exception {
		return instanceService.getMyRunningInstancesCounts();
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

	@Override
	public String setInformationWorkInstance(Map<String, Object> requestBody, HttpServletRequest request) throws Exception {
		return instanceService.setInformationWorkInstance(requestBody, request);
	}

	@Override
	public void removeInformationWorkInstance(Map<String, Object> requestBody, HttpServletRequest request) throws Exception {
		instanceService.removeInformationWorkInstance(requestBody, request);
	}

	@Override
	public String startProcessWorkInstance(Map<String, Object> requestBody, HttpServletRequest request) throws Exception {
		return instanceService.startProcessWorkInstance(requestBody, request);

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
	public WorkInstance getWorkInstanceById(int workType, String workId, String instanceId) throws Exception {
		return instanceService.getWorkInstanceById(workType, workId, instanceId);
	}

	@Override
	public TaskInstanceInfo[][] getTaskInstancesByWorkHours(String contextId, String spaceId, LocalDate date, int maxSize) throws Exception {
		// TODO Auto-generated method stub
		return instanceService.getTaskInstancesByWorkHours(contextId, spaceId, date, maxSize);
	}
	@Override
	public TaskInstanceInfo[][] getTaskInstancesByDates(String contextId, String spaceId, LocalDate fromDate, LocalDate toDate, int maxSize) throws Exception {
		// TODO Auto-generated method stub
		return instanceService.getTaskInstancesByDates(contextId, spaceId, fromDate, toDate, maxSize);
	}
	@Override
	public TaskInstanceInfo[][] getTaskInstancesByWeeks(String contextId, String spaceId, LocalDate month, int maxSize) throws Exception {
		// TODO Auto-generated method stub
		return instanceService.getTaskInstancesByWeeks(contextId, spaceId, month, maxSize);
	}
	@Override
	public TaskInstanceInfo[] getTaskInstancesByDate(String contextId, String spaceId, LocalDate fromDate, LocalDate toDate, int maxSize) throws Exception {
		// TODO Auto-generated method stub
		return instanceService.getTaskInstancesByDate(contextId, spaceId, fromDate, toDate, maxSize);
	}	

	@Override
	public TaskInstanceInfo[] getInstanceTaskHistoriesById(String instId) throws Exception {
		return instanceService.getInstanceTaskHistoriesById(instId);
	}

	@Override
	public InstanceInfoList[] getInstanceRelatedWorksById(String instId) throws Exception {
		return instanceService.getInstanceRelatedWorksById(instId);
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
		return workService.getFormXml(request.getParameter("formId"), request.getParameter("workId"));
	}

	@Override
	public SwdRecord getRecord(HttpServletRequest request) throws Exception {
		return workService.getRecord(request);
	}

	@Override
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

	@Override
	public void addAFavoriteWork(HttpServletRequest request) throws Exception {
		workService.addAFavoriteWork(request.getParameter("workId"));
	}

	@Override
	public void removeAFavoriteWork(HttpServletRequest request) throws Exception {
		workService.removeAFavoriteWork(request.getParameter("workId"));		
	}

	@Override
	public CompanyGeneral getCompanyGeneral() throws Exception {
		return settingsService.getCompanyGeneral();
	}

	@Override
	public void setCompanyGeneral(Map<String, Object> requestBody, HttpServletRequest request) throws Exception {
		settingsService.setCompanyGeneral(requestBody, request);
	}
	
	@Override
	public RecordList getWorkHourPolicyList(RequestParams params) throws Exception {
		return settingsService.getWorkHourPolicyList(params);
	}
	
	@Override
	public WorkHourPolicy getWorkHourPolicyById(String id) throws Exception {
		return settingsService.getWorkHourPolicyById(id);
	}
	
	@Override
	public void setWorkHourPolicy(Map<String, Object> requestBody, HttpServletRequest request) throws Exception {
		settingsService.setWorkHourPolicy(requestBody, request);
	}
	
	@Override
	public void removeWorkHourPolicy(Map<String, Object> requestBody, HttpServletRequest request) throws Exception {
		settingsService.removeWorkHourPolicy(requestBody, request);
	}
	
	@Override
	public RecordList getCompanyEventList(RequestParams params) throws Exception {
		return settingsService.getCompanyEventList(params);
	}
	
	@Override
	public CompanyEvent getCompanyEventById(String id) throws Exception {
		return settingsService.getCompanyEventById(id);
	}
	
	@Override
	public void setCompanyEvent(Map<String, Object> requestBody, HttpServletRequest request) throws Exception {
		settingsService.setCompanyEvent(requestBody, request);
	}
		
	@Override
	public void removeCompanyEvent(Map<String, Object> requestBody, HttpServletRequest request) throws Exception {
		settingsService.removeCompanyEvent(requestBody, request);
	}
		
	@Override
	public RecordList getApprovalLineList(RequestParams params) throws Exception {
		return settingsService.getApprovalLineList(params);
	}
	
	@Override
	public ApprovalLine getApprovalLineById(String id) throws Exception {
		return settingsService.getApprovalLineById(id);
	}
	
	@Override
	public void setApprovalLine(Map<String, Object> requestBody, HttpServletRequest request) throws Exception {
		settingsService.setApprovalLine(requestBody, request);
	}
		
	@Override
	public void removeApprovalLine(Map<String, Object> requestBody, HttpServletRequest request) throws Exception {
		settingsService.removeApprovalLine(requestBody, request);
	}
		
	@Override
	public RecordList getWebServiceList(RequestParams params) throws Exception {
		return settingsService.getWebServiceList(params);
	}
	
	@Override
	public WebService getWebServiceById(String id) throws Exception {
		return settingsService.getWebServiceById(id);
	}
	
	@Override
	public void setWebService(Map<String, Object> requestBody, HttpServletRequest request) throws Exception {
		settingsService.setWebService(requestBody, request);
	}
		
	@Override
	public void removeWebService(Map<String, Object> requestBody, HttpServletRequest request) throws Exception {
		settingsService.removeWebService(requestBody, request);
	}
		
	@Override
	public RecordList getExternalFormList(RequestParams params) throws Exception {
		return settingsService.getExternalFormList(params);
	}
	
	@Override
	public ExternalForm getExternalFormById(String id) throws Exception {
		return settingsService.getExternalFormById(id);
	}
	
	@Override
	public void setExternalForm(Map<String, Object> requestBody, HttpServletRequest request) throws Exception {
		settingsService.setExternalForm(requestBody, request);
	}
		
	@Override
	public void removeExternalForm(Map<String, Object> requestBody, HttpServletRequest request) throws Exception {
		settingsService.removeExternalForm(requestBody, request);
	}
		
	@Override
	public String performTaskInstance(Map<String, Object> requestBody, HttpServletRequest request) throws Exception {
		String instanceId = instanceService.performTaskInstance(requestBody, request);
		return instanceId;
	}

	@Override
	public String returnTaskInstance(Map<String, Object> requestBody, HttpServletRequest request) throws Exception {
		String instanceId = instanceService.returnTaskInstance(requestBody, request);
		return instanceId;
	}

	@Override
	public String reassignTaskInstance(Map<String, Object> requestBody, HttpServletRequest request) throws Exception {
		String instanceId = instanceService.reassignTaskInstance(requestBody, request);
		return instanceId;
	}

	@Override
	public String tempSaveTaskInstance(Map<String, Object> requestBody, HttpServletRequest request) throws Exception {
		String instanceId = instanceService.tempSaveTaskInstance(requestBody, request);
		return instanceId;
	}

}
