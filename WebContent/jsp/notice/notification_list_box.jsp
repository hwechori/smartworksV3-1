
<!-- Name 			: notification_list_box.jsp										 -->
<!-- Description	: 화면구성중에 Header 에서 개인에게 알림이 필요한 목록들을 보여주는 박스 	 -->
<!-- Author			: Maninsoft, Inc.												 -->
<!-- Created Date	: 2011.9.														 -->

<%@page import="net.smartworks.model.instance.info.InstanceInfo"%>
<%@page import="net.smartworks.model.instance.info.TaskInstanceInfo"%>
<%@page import="net.smartworks.model.community.info.UserInfo"%>
<%@page import="net.smartworks.model.instance.info.EventInstanceInfo"%>
<%@page import="net.smartworks.util.SmartUtil"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="net.smartworks.service.ISmartWorks"%>
<%@ page import="net.smartworks.model.community.*"%>
<%@ page import="net.smartworks.model.notice.*"%>
<%@ page import="net.smartworks.model.instance.*"%>
<%@ page import="net.smartworks.model.work.*"%>
<%@ page import="net.smartworks.util.LocalDate"%>
<%
	// 스마트웍스 서비스들을 사용하기위한 핸들러를 가져온다.
	ISmartWorks smartWorks = (ISmartWorks) request.getAttribute("smartWorks");

	// 호출될때 전달되는 lastNoticeId를 가져온다.
	String lastNoticeId = request.getParameter("lastNoticeId");
	int noticeType = Notice.TYPE_NOTIFICATION;
	
	// 서버에게 lastNoticeId를 기준으로 최근 10개의 Notice항목을 가져오는 기능.
	NoticeBox noticeBox = smartWorks.getNoticeBoxForMe10(noticeType, lastNoticeId);

	NoticeMessage[] noticeMessages = noticeBox.getNoticeMessages();
	if (noticeMessages != null) {
		for (NoticeMessage nMessage : (NoticeMessage[]) noticeBox.getNoticeMessages()) {
			if (noticeBox != null && noticeBox.getNoticeType() == Notice.TYPE_NOTIFICATION) {
				String instContext = null, targetContent = null, userContext = null;
				UserInfo owner = null;

				// Notice message type 이 시스템 알림인 경우, 
				if (nMessage.getType() == NoticeMessage.TYPE_SYSTEM_NOTICE) {
%>
					<li>
						<div class="info_img"><img src="images/pop_ico_info.jpg"  class="profile_size_s"></div>
						<div class="info_list"><%=nMessage.getMessage()%><div class="t_date"><%=nMessage.getIssuedDate().toLocalString()%>
							<a href="" noticeId=<%=nMessage.getId() %> noticeType="<%=noticeType%>" lastNoticeId=<%=lastNoticeId %>>
								<div class="btn_x js_remove_notice" >X</div></a></div>
						</div>
					</li>
				<%
				// Notice Message type 이 이벤트 알림인 경우 
				} else if (nMessage.getType() == NoticeMessage.TYPE_EVENT_ALARM) {
					EventInstanceInfo event = (EventInstanceInfo) nMessage.getEvent();
					owner = event.getOwner();
					instContext = ISmartWorks.CONTEXT_PREFIX_EVENT_SPACE + event.getId();
					userContext = ISmartWorks.CONTEXT_PREFIX_USER_SPACE + owner.getId();
				%>
					<li>
						<div class="info_img"><img src="images/upic_event.jpg"  class="profile_size_s"></div>
						<div class="info_list">
							<b><%=event.getStart().toLocalString()%> </b><a href="event_space.sw?cid=<%=instContext%>&wid=<%=event.getWorkSpace().getId()%>"><%=event.getSubject()%></a>
							<div class="t_date"><%=nMessage.getIssuedDate().toLocalString()%>
								<a href="" noticeId=<%=nMessage.getId() %> noticeType="<%=noticeType%>" lastNoticeId=<%=lastNoticeId %>>
									<div class="btn_x js_remove_notice" >X</div></a></div>
						</div>
					</li>
				<%
				// Notice Message type 이 지연 업무 알림인 경우
				} else if (nMessage.getType() == NoticeMessage.TYPE_TASK_DELAYED) {
					TaskInstanceInfo task = (TaskInstanceInfo) nMessage.getInstance();
					owner = task.getOwner();
					InstanceInfo work = (InstanceInfo) task.getWorkInstance();
					instContext = ISmartWorks.CONTEXT_PREFIX_PWORK_TASK + task.getId();
					userContext = ISmartWorks.CONTEXT_PREFIX_USER_SPACE + owner.getId();
				%>
					<li>
						<div class="info_img">
							<a href="user_space.sw?cid=<%=userContext%>"title="<%=owner.getLongName()%>"><img src="<%=owner.getMinPicture()%>"  class="profile_size_s"> </a>
						</div>
						<div class="info_list">
							<a href="pwork_task.sw?cid=<%=instContext%>&wid=<%=task.getWorkSpace().getId()%>"><%=work.getSubject()%>▶<%=task.getName()%></a>
							<fmt:message key="notice.message.task.delayed" />
							<div class="t_date"><%=nMessage.getIssuedDate().toLocalString()%>
								<a href="" noticeId=<%=nMessage.getId() %> noticeType="<%=noticeType%>" lastNoticeId=<%=lastNoticeId %>>
									<div class="btn_x js_remove_notice" >X</div></a></div>
						</div>
					</li>
				<%
				// Notice Message type 이 그룹 가입신청 알림인 경우 
				} else if (nMessage.getType() == NoticeMessage.TYPE_JOIN_REQUEST) {
					owner = nMessage.getIssuer();
					instContext = ISmartWorks.CONTEXT_PREFIX_GROUP_SPACE + nMessage.getGroup().getId();
					userContext = ISmartWorks.CONTEXT_PREFIX_USER_SPACE + owner.getId();
				%>
					<li>
						<div class="info_img">
							<a href="user_space.sw?cid=<%=userContext%>" title="<%=owner.getLongName()%>"><img src="<%=owner.getMinPicture()%>"  class="profile_size_s"> </a>
						</div>
						<div class="info_list">
							<a href="group_space.sw?cid=<%=instContext%>"><%=nMessage.getGroup().getName()%></a>
							<fmt:message key="notice.message.join.request" />
							<div class="t_date"><%=nMessage.getIssuedDate().toLocalString()%>
								<a href="" noticeId=<%=nMessage.getId() %> noticeType="<%=noticeType%>" lastNoticeId=<%=lastNoticeId %>>
									<div class="btn_x js_remove_notice" >X</div></a></div>
						</div>
					</li>
				<%
				// Notice Message type 이 새로운 업무 생성 알림인 경우 
				} else if (nMessage.getType() == NoticeMessage.TYPE_INSTANCE_CREATED) {
					InstanceInfo instance = (InstanceInfo) nMessage.getInstance();
					owner = instance.getOwner();
					targetContent = SmartUtil.getTargetContentByWorkType(nMessage.getInstance().getWork().getType(), ISmartWorks.SPACE_TYPE_TASK_INSTANCE);
					instContext = SmartUtil.getContextPrefixByWorkType(nMessage.getInstance().getWork().getType(), ISmartWorks.SPACE_TYPE_TASK_INSTANCE)
							+ nMessage.getInstance().getOwner().getId();
					userContext = ISmartWorks.CONTEXT_PREFIX_USER_SPACE + owner.getId();
				%>
					<li>
						<div class="info_img">
							<a href="user_space.sw?cid=<%=userContext%>" title="<%=owner.getLongName()%>"><img src="<%=owner.getMinPicture()%>"  class="profile_size_s"> </a>
						</div>
						<div class="info_list">
							<a href="<%=targetContent%>?cid=<%=instContext%>&wid=<%=instance.getWorkSpace().getId()%>"><%=instance.getSubject()%></a>
							<fmt:message key="notice.message.instance.created" />
							<div class="t_date"><%=nMessage.getIssuedDate().toLocalString()%>
								<a href="" noticeId=<%=nMessage.getId() %> noticeType="<%=noticeType%>" lastNoticeId=<%=lastNoticeId %>>
									<div class="btn_x js_remove_notice" >X</div></a></div>
						</div>
					</li>
	<%
				}
			}
		}
	}
	%>
