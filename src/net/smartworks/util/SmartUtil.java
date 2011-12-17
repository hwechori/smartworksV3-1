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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.smartworks.model.community.User;
import net.smartworks.model.work.SmartWork;
import net.smartworks.server.engine.security.model.Login;
import net.smartworks.service.ISmartWorks;
import net.smartworks.service.impl.SmartWorks;

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
	public static boolean isSameContextPrefix(String contextPrefix,
			String contextId) throws Exception {
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
	public static boolean isWorkSpaceContextType(String contextId)
			throws Exception {
		if (contextId == null || contextId.length() < 6)
			return false;
		if (contextId.substring(0, 6).equals("iw.sp.")
				|| contextId.substring(0, 6).equals("pw.sp.")
				|| contextId.substring(0, 6).equals("sw.sp.")
				|| contextId.substring(0, 6).equals("fl.sp.")
				|| contextId.substring(0, 6).equals("mm.sp.")
				|| contextId.substring(0, 6).equals("im.sp.")
				|| contextId.substring(0, 6).equals("ev.sp.")
				|| contextId.substring(0, 6).equals("bd.sp.")
				|| contextId.substring(0, 6).equals("ml.sp."))
			return true;
		return false;
	}

	/* (non-Javadoc)
	 * @see net.smartworks.service.impl.ISmartWorks#isTaskSpaceContextType(java.lang.String)
	 */
	public static boolean isTaskSpaceContextType(String contextId)
			throws Exception {
		if (contextId == null || contextId.length() < 6)
			return false;
		if (contextId.substring(0, 6).equals("iw.ts.")
				|| contextId.substring(0, 6).equals("pw.ts.")
				|| contextId.substring(0, 6).equals("sw.ts."))
			return true;
		return false;
	}

	/* (non-Javadoc)
	 * @see net.smartworks.service.impl.ISmartWorks#isCommunitySpaceContextType(java.lang.String)
	 */
	public static boolean isCommunitySpaceContextType(String contextId)
			throws Exception {
		if (contextId == null || contextId.length() < 6)
			return false;
		if (contextId.substring(0, 6).equals(SmartWorks.CONTEXT_PREFIX_DEPARTMENT_SPACE)
				|| contextId.substring(0, 6).equals(SmartWorks.CONTEXT_PREFIX_GROUP_SPACE)
				|| contextId.substring(0, 6).equals(SmartWorks.CONTEXT_PREFIX_USER_SPACE))
			return true;
		return false;
	}

	public static String getSpaceIdFromContentContext(String contentContext)
			throws Exception {
		if (contentContext == null || contentContext.length() <= SmartWorks.CONTEXT_PREFIX_LENGTH)
			return null;
		return contentContext.substring(SmartWorks.CONTEXT_PREFIX_LENGTH);
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
		} else if(spaceType == SmartWorks.SPACE_TYPE_TASK_INSTANCE){
			if (smartWorkType == SmartWork.TYPE_INFORMATION)
				return SmartWorks.CONTEXT_PREFIX_IWORK_TASK;
			if (smartWorkType == SmartWork.TYPE_PROCESS)
				return SmartWorks.CONTEXT_PREFIX_PWORK_TASK;
			if (smartWorkType == SmartWork.TYPE_SCHEDULE)
				return SmartWorks.CONTEXT_PREFIX_SWORK_TASK;
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

	public static User getCurrentUser(HttpServletRequest request, HttpServletResponse response) throws Exception {

		User user = new Login();
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
			return (User)(principal instanceof Login ? principal : null);
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
	
	public static String getSubjectString(String userId){
		return userId.replaceAll(".", "_");
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
								
								String pubChannel = "/smartworks/Semiteq/" + message.channel; 
								Map<String, Object> data = new HashMap<String, Object>();
								data.put("msgType", message.msgType);
								data.put("sender", "smartServer");
								data.put("body", message.message);
								
								client.getChannel(pubChannel).publish(data);
							} catch(Exception e){
								e.printStackTrace();
							}
						}
					}catch(Exception e){
						e.printStackTrace();
					}
				}
			});
			messageAgent.start();
		}

		messageQueue.add(new MessageModel(channel, msgType, message));
	}
	

// 	var repeat1 = function() {
//	 clearInterval(timer);
//	 smartTalk.publishBcast(new Array(
//	 " Hello, this is SmartWorks!! Welcome~~",
//	 "오늘은 삼겹살데이 입니다. 점심시간에 가급적이면 많은 분들이 참석바랍니다.!!! from 경영기획본부"));
//	 };
//	 smartTalk.publishNoticeCount({
//	 type : 0,
//	 count : 0
//	 });
//	 smartTalk.publishNoticeCount({
//	 type : 1,
//	 count : 1
//	 });
//	 smartTalk.publishNoticeCount({
//	 type : 2,
//	 count : 2
//	 });
//	 smartTalk.publishNoticeCount({
//	 type : 3,
//	 count : 3
//	 });
//	 smartTalk.publishNoticeCount({
//	 type : 4,
//	 count : 4
//	 });
//	 smartTalk.publishNoticeCount({
//	 type : 5,
//	 count : 5
//	 });
//
//	 setTimeout(function() {
//		smartTalk.publish(swSubject.SMARTWORKS + swSubject.COMPANYID
//				+ swSubject.BROADCASTING, {
//			msgType : msgType.AVAILABLE_CHATTERS,
//			sender : "smartworks.net",
//			userInfos : new Array({
//				userId : "ysjung@maninsoft.co.kr",
//				longName : "대표이사 정윤식",
//				minPicture : "images/no_user_picture_min.jpg"
//			}, {
//				userId : "jskim@maninsoft.co.kr",
//				longName : "과장 김지숙",
//				minPicture : "images/no_user_picture_min.jpg"
//			}, {
//				userId : "hsshin@maninsoft.co.kr",
//				longName : "선임연구원 신현성",
//				minPicture : "images/no_user_picture_min.jpg"
//			}, {
//				userId : "kmyu@maninsoft.co.kr",
//				longName : "선임연구원 유광민",
//				minPicture : "images/no_user_picture_min.jpg"
//			}, {
//				userId : "hjlee@maninsoft.co.kr",
//				longName : "대리 이현정",
//				minPicture : "images/no_user_picture_min.jpg"
//			})
//		});
//	}, 5000);
//	
	
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

