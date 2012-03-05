/*	
 * $Id$
 * created by    : SHIN HYUN SEONG
 * creation-date : 2011. 7. 15.
 * =========================================================
 * Copyright (c) 2011 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.util;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.lang.reflect.Array;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.smartworks.model.community.User;
import net.smartworks.model.community.info.UserInfo;
import net.smartworks.model.work.SmartWork;
import net.smartworks.server.engine.security.model.Login;
import net.smartworks.service.ISmartWorks;
import net.smartworks.service.impl.SmartWorks;

import org.apache.axis.utils.StringUtils;
import org.cometd.bayeux.client.ClientSession;
import org.cometd.client.BayeuxClient;
import org.cometd.client.transport.ClientTransport;
import org.cometd.client.transport.LongPollingTransport;
import org.eclipse.jetty.client.HttpClient;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;

import com.sun.xml.internal.bind.v2.TODO;

public class SmartUtil {

	public SmartUtil() {
		super();
	}

	/**
	 * beanName; getBean
	 * @param beanName
	 * @param request
	 * @return
	 */
	public static Object getBean(String beanName, HttpServletRequest request) {

		WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getSession().getServletContext());

		return (Object) wac.getBean(beanName);
	}

	public static ModelAndView returnMnv(HttpServletRequest request, String ajaxPage, String defaultPage) {
		String getHeader = request.getHeader("X-Requested-With");
 		ISmartWorks smartworks = (ISmartWorks)SmartUtil.getBean("smartWorks", request);
		if (getHeader != null)
			return new ModelAndView(ajaxPage, "smartWorks", smartworks);
		else
			return new ModelAndView(defaultPage, "smartWorks", smartworks);
	}

	/* (non-Javadoc)
	 * @see net.smartworks.service.impl.ISmartWorks#isSameContextPrefix(java.lang.String, java.lang.String)
	 */
	public static boolean isSameContextPrefix(String contextPrefix,	String contextId) throws Exception {
		if (contextPrefix == null || contextId == null
				|| contextPrefix.length() >= contextId.length())
			return false;
		if (contextId.subSequence(0, contextPrefix.length()).equals(
				contextPrefix))
			return true;
		return false;
	}

	/* (non-Javadoc)
	 * @see net.smartworks.service.impl.ISmartWorks#isWorkContextType(java.lang.String)
	 */
	public static boolean isWorkContextType(String contextId) throws Exception {
		if (contextId == null || contextId.length() < 3)
			return false;
		if (contextId.substring(0, 3).equals("iw.")
				|| contextId.substring(0, 3).equals("pw.")
				|| contextId.substring(0, 3).equals("sw.")
				|| contextId.substring(0, 3).equals("fl.")
				|| contextId.substring(0, 3).equals("fl.")
				|| contextId.substring(0, 3).equals("mm.")
				|| contextId.substring(0, 3).equals("im.")
				|| contextId.substring(0, 3).equals("ev.")
				|| contextId.substring(0, 3).equals("bd.")
				|| contextId.substring(0, 3).equals("ml.")
				|| contextId.substring(0, 3).equals("sv."))
			return true;
		return false;
	}

	/* (non-Javadoc)
	 * @see net.smartworks.service.impl.ISmartWorks#isWorkSpaceContextType(java.lang.String)
	 */
	public static boolean isWorkSpaceContextType(String contextId) throws Exception {
		if (contextId == null || contextId.length() < 6)
			return false;
		if (contextId.substring(0, 6).equals(ISmartWorks.CONTEXT_PREFIX_IWORK_SPACE)
				|| contextId.substring(0, 6).equals(ISmartWorks.CONTEXT_PREFIX_PWORK_SPACE)
				|| contextId.substring(0, 6).equals(ISmartWorks.CONTEXT_PREFIX_SWORK_SPACE)
				|| contextId.substring(0, 6).equals(ISmartWorks.CONTEXT_PREFIX_FILE_SPACE)
				|| contextId.substring(0, 6).equals(ISmartWorks.CONTEXT_PREFIX_MEMO_SPACE)
				|| contextId.substring(0, 6).equals(ISmartWorks.CONTEXT_PREFIX_IMAGE_SPACE)
				|| contextId.substring(0, 6).equals(ISmartWorks.CONTEXT_PREFIX_EVENT_SPACE)
				|| contextId.substring(0, 6).equals(ISmartWorks.CONTEXT_PREFIX_BOARD_SPACE)
				|| contextId.substring(0, 6).equals(ISmartWorks.CONTEXT_PREFIX_MAIL_SPACE))
			return true;
		return false;
	}

	/* (non-Javadoc)
	 * @see net.smartworks.service.impl.ISmartWorks#isCommunitySpaceContextType(java.lang.String)
	 */
	public static boolean isCommunitySpaceContextType(String contextId) throws Exception {
		if (contextId == null || contextId.length() < 6)
			return false;
		if (contextId.substring(0, 6).equals(SmartWorks.CONTEXT_PREFIX_DEPARTMENT_SPACE)
				|| contextId.substring(0, 6).equals(SmartWorks.CONTEXT_PREFIX_GROUP_SPACE)
				|| contextId.substring(0, 6).equals(SmartWorks.CONTEXT_PREFIX_USER_SPACE))
			return true;
		return false;
	}

	public static String getSpaceIdFromContentContext(String contextId) throws Exception {
		if (contextId == null || contextId.length() <= SmartWorks.CONTEXT_PREFIX_LENGTH)
			return null;
		return contextId.substring(SmartWorks.CONTEXT_PREFIX_LENGTH);
	}

	public static int getSpaceTypeFromContentContext(String contextId) throws Exception {
		if (contextId == null)
			return 0;
		if(contextId.length() == 5 && contextId.substring(0, 5).equals(ISmartWorks.CONTEXT_ALL_WORKS_LIST))
			return ISmartWorks.SPACE_TYPE_AWORK_LIST;
		if(contextId.length() < 6) return 0;
		if (contextId.substring(0, 6).equals(ISmartWorks.CONTEXT_PREFIX_IWORK_SPACE)
				|| contextId.substring(0, 6).equals(ISmartWorks.CONTEXT_PREFIX_PWORK_SPACE)
				|| contextId.substring(0, 6).equals(ISmartWorks.CONTEXT_PREFIX_SWORK_SPACE)
				|| contextId.substring(0, 6).equals(ISmartWorks.CONTEXT_PREFIX_FILE_SPACE)
				|| contextId.substring(0, 6).equals(ISmartWorks.CONTEXT_PREFIX_IMAGE_SPACE)
				|| contextId.substring(0, 6).equals(ISmartWorks.CONTEXT_PREFIX_EVENT_SPACE)
				|| contextId.substring(0, 6).equals(ISmartWorks.CONTEXT_PREFIX_MEMO_SPACE)
				|| contextId.substring(0, 6).equals(ISmartWorks.CONTEXT_PREFIX_BOARD_SPACE)
				|| contextId.substring(0, 6).equals(ISmartWorks.CONTEXT_PREFIX_MAIL_SPACE))
			return ISmartWorks.SPACE_TYPE_WORK_INSTANCE;
		else if (contextId.substring(0, 6).equals(ISmartWorks.CONTEXT_PREFIX_IWORK_LIST)
				|| contextId.substring(0, 6).equals(ISmartWorks.CONTEXT_PREFIX_PWORK_LIST)
				|| contextId.substring(0, 6).equals(ISmartWorks.CONTEXT_PREFIX_SWORK_LIST))
			return ISmartWorks.SPACE_TYPE_WORK_LIST;
		else if(contextId.substring(0, 6).equals(ISmartWorks.CONTEXT_PREFIX_FILE_LIST))
			return ISmartWorks.SPACE_TYPE_FILE_LIST;
		else if(contextId.substring(0, 6).equals(ISmartWorks.CONTEXT_PREFIX_IMAGE_LIST))
			return ISmartWorks.SPACE_TYPE_IMAGE_LIST;
		else if(contextId.substring(0, 6).equals(ISmartWorks.CONTEXT_PREFIX_EVENT_LIST))
			return ISmartWorks.SPACE_TYPE_EVENT_LIST;
		else if(contextId.substring(0, 6).equals(ISmartWorks.CONTEXT_PREFIX_MEMO_LIST))
			return ISmartWorks.SPACE_TYPE_MEMO_LIST;
		else if(contextId.substring(0, 6).equals(ISmartWorks.CONTEXT_PREFIX_BOARD_LIST))
			return ISmartWorks.SPACE_TYPE_BOARD_LIST;
		else if(contextId.substring(0, 6).equals(ISmartWorks.CONTEXT_PREFIX_MAIL_LIST))
			return ISmartWorks.SPACE_TYPE_MAIL_LIST;
		else if(contextId.substring(0, 6).equals(ISmartWorks.CONTEXT_PREFIX_SAVED_LIST))
			return ISmartWorks.SPACE_TYPE_SAVED_LIST;
		else if(contextId.substring(0, 6).equals(ISmartWorks.CONTEXT_PREFIX_USER_SPACE))
			return ISmartWorks.SPACE_TYPE_USER;
		else if(contextId.substring(0, 6).equals(ISmartWorks.CONTEXT_PREFIX_GROUP_SPACE))
			return ISmartWorks.SPACE_TYPE_GROUP;
		else if(contextId.substring(0, 6).equals(ISmartWorks.CONTEXT_PREFIX_DEPARTMENT_SPACE))
			return ISmartWorks.SPACE_TYPE_DEPARTMENT;
		return 0;
	}

	/* (non-Javadoc)
	 * @see net.smartworks.service.impl.ISmartWorks#getContextPrefixByWorkType(int, int)
	 */
	public static String getContextPrefixByWorkType(int smartWorkType,
			int spaceType) throws Exception {

		if (spaceType == SmartWorks.SPACE_TYPE_WORK_LIST) {
			if (smartWorkType == SmartWork.TYPE_INFORMATION)
				return SmartWorks.CONTEXT_PREFIX_IWORK_LIST;
			if (smartWorkType == SmartWork.TYPE_PROCESS)
				return SmartWorks.CONTEXT_PREFIX_PWORK_LIST;
			if (smartWorkType == SmartWork.TYPE_SCHEDULE)
				return SmartWorks.CONTEXT_PREFIX_SWORK_LIST;
		} else if(spaceType == SmartWorks.SPACE_TYPE_WORK_INSTANCE){
			if (smartWorkType == SmartWork.TYPE_INFORMATION)
				return SmartWorks.CONTEXT_PREFIX_IWORK_SPACE;
			if (smartWorkType == SmartWork.TYPE_PROCESS)
				return SmartWorks.CONTEXT_PREFIX_PWORK_SPACE;
			if (smartWorkType == SmartWork.TYPE_SCHEDULE)
				return SmartWorks.CONTEXT_PREFIX_SWORK_SPACE;
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see net.smartworks.service.impl.ISmartWorks#getTargetContentByWorkType(int, int)
	 */
	public static String getTargetContentByWorkType(int smartWorkType,
			int spaceType) throws Exception {

		if (spaceType == SmartWorks.SPACE_TYPE_WORK_LIST) {
			if (smartWorkType == SmartWork.TYPE_INFORMATION)
				return "iwork_list.sw";
			if (smartWorkType == SmartWork.TYPE_PROCESS)
				return "pwork_list.sw";
			if (smartWorkType == SmartWork.TYPE_SCHEDULE)
				return "swork_list.sw";
		} else if(spaceType == SmartWorks.SPACE_TYPE_WORK_INSTANCE){
			if (smartWorkType == SmartWork.TYPE_INFORMATION)
				return "iwork_space.sw";
			if (smartWorkType == SmartWork.TYPE_PROCESS)
				return "pwork_space.sw";
			if (smartWorkType == SmartWork.TYPE_SCHEDULE)
				return "swork_space.sw";
		} else if(spaceType == SmartWorks.SPACE_TYPE_TASK_INSTANCE){
			if (smartWorkType == SmartWork.TYPE_INFORMATION)
				return "iwork_task.sw";
			if (smartWorkType == SmartWork.TYPE_PROCESS)
				return "pwork_task.sw";
			if (smartWorkType == SmartWork.TYPE_SCHEDULE)
				return "swork_task.sw";

		}
		return null;
	}

	/* (non-Javadoc)
	 * @see net.smartworks.service.impl.ISmartWorks#getCurrentUser()
	 */
	public static User getCurrentUserOld() throws Exception {
		User user = new User();
		user.setId("jisook@maninsoft.co.kr");
		user.setName("김지숙");
		user.setPosition("CEO");
		user.setDepartment("경영기획실 디자인팀");
		user.setLocale("ko"); // ko, en
		user.setTimeZone(LocalDate.TIMEZONE_SEOUL); //Asia/Seoul, America/Los_Angeles
		user.setCompany("(주)맨인소프트");
		user.setUserLevel(User.USER_LEVEL_AMINISTRATOR);

		return user;
	}

	public static Login getCurrentUser(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Login user = new Login();
		SecurityContext context = (SecurityContext) request.getSession().getAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY);
		if(context != null) {
			Authentication auth = context.getAuthentication();
			if(auth != null) {
				if(((Login)auth.getPrincipal()).getId() != null)
					user = (Login)auth.getPrincipal();
				else
					response.sendRedirect("logout");
			} else {
				response.sendRedirect("logout");
			}
		}

		return user;
	}

	public static User getCurrentUser() {
		SecurityContext securityContext = SecurityContextHolder.getContext();
		Authentication authentication = securityContext.getAuthentication();
		if(authentication != null) {
			Object principal = authentication.getPrincipal();
			if(!principal.equals("anonymousUser")) {
				Login login = (Login)(principal instanceof Login ? principal : null);
				User user = new User();
				if(login != null) {
					user.setId(login.getId());
					user.setName(login.getName());
					user.setPassword(login.getPassword());
					user.setCompanyId(login.getCompanyId());
					user.setCompany(login.getCompany());
					user.setDepartmentId(login.getDepartmentId());
					user.setDepartment(login.getDepartment());
					user.setPosition(login.getPosition());
					user.setBigPictureName(login.getBigPictureName());
					user.setSmallPictureName(login.getSmallPictureName());
					user.setLocale(login.getLocale());
					user.setTimeZone(login.getTimeZone());
					user.setRole(login.getRole());
					user.setUserLevel(login.getUserLevel());
					user.setPhoneNo(login.getPhoneNo());
					user.setCellPhoneNo(login.getCellPhoneNo());
					user.setEmployeeId(login.getEmpNo());
				}
				return user;
			} else {
				//TO-DO
			}
		}
		return null;
	}

	public static User getSystemUser(){

		User user = new User();
		user.setId("systemUser");
		user.setName("System");
		user.setPosition("");
		user.setDepartment("");
		user.setCompany("");
		user.setUserLevel(User.USER_LEVEL_AMINISTRATOR);
		return user;
	}
	
	public static String getUserDetailInfo(UserInfo user){
		String roleStr = (user.getRole() == User.USER_ROLE_LEADER) ? SmartMessage.getString("department.role.head") : SmartMessage.getString("department.role.member");
		String info = "<div><span class='smartp_name'>" + user.getLongName() + "</span><div>";
		if(!SmartUtil.isBlankObject(user.getDepartment())){
			info = info + "<div class='smartp_info'>" + SmartMessage.getString("profile.title.department") + ": " + user.getDepartment().getName() + " (" + roleStr + ")</div>";
		}
		if(!SmartUtil.isBlankObject(user.getPhoneNo())){
			info = info + "<div class='smartp_info'>" + SmartMessage.getString("profile.title.phone_no") + ": " + user.getPhoneNo() + "</div>";
		}
		if(!SmartUtil.isBlankObject(user.getCellPhoneNo())){		
			info = info + "<div class='smartp_info'>" + SmartMessage.getString("profile.title.cell_phone_no") + ": " + user.getCellPhoneNo() + "</div>";
		}
		info = info + "<div class='smartp_info'>" + SmartMessage.getString("profile.title.email") + ": " + user.getId() + "</div>";
		
		return info;
	}
	
	public static String getFileNamesDetailInfo(List<Map<String, String>> fileNames){
		String html = "";
		if(SmartUtil.isBlankObject(fileNames)) return html;
		for(int i=0; i<fileNames.size(); i++){
			Map<String, String> files = (Map<String, String>)fileNames.get(i);
			String fileName = files.get("fileName");
			String filePath = files.get("filePath");
			String fileType = "";
			html = html + "<div href='" + filePath + "'><span class='icon_file_" + fileType + "'>" + fileName + "</span></div>";
		}
		return html;
	}

	
	public static String getSubjectString(String userId){
		return userId.replaceAll(".", "_");
	}

	public static boolean isBlankObject(Object obj){
		if(obj==null) return true;
		if(obj.getClass().equals(String.class)) return StringUtils.isEmpty((String)obj);
		if(obj.getClass().isArray()) return (obj==null || Array.getLength(obj)==0) ? true : false;
		return false;
	}

	public static boolean isEmpty(String str){
		return (str == null || str.length()==0) ? true : false;
	}
	
	private static final String SUBJECT_SMARTWORKS = "/smartworks";
	private static final String SUBJECT_BROADCASTING = "/broadcasting";
	private static final String MSG_TYPE_BROADCASTING = "BCAST";
	private static final String MSG_TYPE_NOTICE_COUNT = "NCOUNT";
	private static final String MSG_TYPE_AVAILABLE_CHATTERS = "ACHATTERS";
	
	public static void publishBcast(String[] messages){
		publishMessage(SUBJECT_BROADCASTING, MSG_TYPE_BROADCASTING, messages);
	}
	
	public static void publishAChatters(UserInfo[] users){

		class UserInformation{
			String userId;
			String longName;
			String minPicture;
		}
		
		if(SmartUtil.isBlankObject(users)) return;
		UserInformation[] userInfos = new UserInformation[users.length];
		for(int i=0; i<users.length; i++){
			UserInfo user = users[i];
			UserInformation userInfo = new UserInformation();
			userInfo.userId = user.getId();
			userInfo.longName = user.getLongName();
			userInfo.minPicture = user.getMinPicture();
			userInfos[i] = userInfo;
		}
		
		publishMessage(SUBJECT_BROADCASTING, MSG_TYPE_AVAILABLE_CHATTERS, userInfos);		
	}
	
	public static void publishNoticeCount(String userId, int noticeType, int count){
		publishMessage( SmartUtil.getSubjectString(userId), MSG_TYPE_NOTICE_COUNT, count );
	}
	
	static Thread messageAgent = null;
	static List<MessageModel> messageQueue = new LinkedList<MessageModel>();
	
	public synchronized static void publishMessage(String channel, String msgType, Object  message){
		if(messageAgent == null) {
			messageAgent = new Thread(new Runnable() {
				public void run() {
					try{
						HttpClient httpClient = new HttpClient();
						httpClient.start();
						Map<String, Object> options = new HashMap<String, Object>();
						ClientTransport transport = LongPollingTransport.create(options, httpClient);
						ClientSession client = new BayeuxClient("http://localhost:8000/faye", transport);
						client.handshake();
				
						MessageModel message = null;
						
						while(true) {
							try {
								message = null;
								while(message == null) {
									try {
										message = messageQueue.remove(0);
									} catch(Exception e) {
										Thread.sleep(1000);
									}
								}
								
								String pubChannel = SUBJECT_SMARTWORKS + "/" + SmartUtil.getCurrentUser().getCompanyId() + message.channel; 
								Map<String, Object> data = new HashMap<String, Object>();
								data.put("msgType", message.msgType);
								data.put("sender", "smartServer");
								data.put("body", message.message);
								
								client.getChannel(pubChannel).publish(data);
							} catch(Exception e){
//								e.printStackTrace();
							}
						}
					}catch(Exception e){
//						e.printStackTrace();
					}
				}
			});
			messageAgent.start();
		}

		messageQueue.add(new MessageModel(channel, msgType, message));
	}
}

class MessageModel {
	MessageModel(String channel, String msgType, Object message) {
		this.channel = channel;
		this.msgType = msgType;
		this.message = message;
	}
	
	protected String channel;
	protected String msgType;
	protected Object message;
}

