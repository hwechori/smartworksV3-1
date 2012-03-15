
<!-- Name 			: notice_message_box.jsp										 -->
<!-- Description	: 화면구성중에 Header 에서 알림아이콘을 클릭하면 알림 내용을 보여주는 박스  	 -->
<!-- Author			: Maninsoft, Inc.												 -->
<!-- Created Date	: 2011.9.														 -->

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
	// 스마트웍스 서비스들을 사용하기위한 핸들러를 가져온다. 현재 사용자 정보도 가져온다.
	ISmartWorks smartWorks = (ISmartWorks) request.getAttribute("smartWorks");
	User cUser = SmartUtil.getCurrentUser();

	// 호출될때 전달되는 noticeType, lastNoticeId를 가져온다.
	String strNoticeType = request.getParameter("noticeType");
	String lastNoticeId = request.getParameter("lastNoticeId");
	int noticeType = (SmartUtil.isBlankObject(strNoticeType)) ? Notice.TYPE_INVALID : Integer.parseInt(strNoticeType);
%>
<!--  다국어 지원을 위해, 로케일 및 다국어 resource bundle을 설정 한다. -->
<fmt:setLocale value="<%=cUser.getLocale() %>" scope="request" />
<fmt:setBundle basename="resource.smartworksMessage" scope="request" />

<div>
	<%
	// 알림 메시지
	if (noticeType == Notice.TYPE_NOTIFICATION) {
	%>
		<div class="info_ms_title t_bold"><fmt:message key="notice.message.box.notification" /></div>
		<jsp:include page="/jsp/notice/notification_list_box.jsp" >
			<jsp:param value="<%=lastNoticeId %>" name="lastNoticeId"/>
		</jsp:include>
	<%
	// 쪽지
	} else if (noticeType == Notice.TYPE_MESSAGE) {
	%>
		<div class="info_ms_title t_bold"><fmt:message key="notice.message.box.message" /></div>
		<jsp:include page="/jsp/notice/message_list_box.jsp" >
			<jsp:param value="<%=lastNoticeId %>" name="lastNoticeId"/>
		</jsp:include>
	<%
	// 댓글 
	} else if (noticeType == Notice.TYPE_COMMENT) {
	%>
		<div class="info_ms_title t_bold"><fmt:message key="notice.message.box.comments" /></div>
		<jsp:include page="/jsp/notice/comment_list_box.jsp" >
			<jsp:param value="<%=lastNoticeId %>" name="lastNoticeId"/>
		</jsp:include>
	<%
	// 할당 업무 
	} else if (noticeType == Notice.TYPE_ASSIGNED) {
	%>
		<div class="info_ms_title t_bold"><fmt:message key="notice.message.box.assigned" /></div>
		<jsp:include page="/jsp/notice/assigned_list_box.jsp" >
			<jsp:param value="<%=lastNoticeId %>" name="lastNoticeId"/>
		</jsp:include>
	<%
	// 이메일 받은편지함
	} else if (noticeType == Notice.TYPE_MAILBOX) {
	%>
		<div class="info_ms_title t_bold"><fmt:message key="notice.message.box.mailbox" /></div>
		<jsp:include page="/jsp/notice/mailbox_list_box.jsp" >
			<jsp:param value="<%=lastNoticeId %>" name="lastNoticeId"/>
		</jsp:include>
	<%
	// 임시 저장함
	} else if (noticeType == Notice.TYPE_SAVEDBOX) {
	%>
		<div class="info_ms_title t_bold"><fmt:message key="notice.message.box.savedbox" /></div>
		<jsp:include page="/jsp/notice/savedbox_list_box.jsp" >
			<jsp:param value="<%=lastNoticeId %>" name="lastNoticeId"/>
		</jsp:include>
	<%
	}
	%>

	<div class="btn_hpadding">
		<!--  메시지박스 닫기 버튼  -->
		<div class="btn_black js_close_message">
			<a href="">
				<span class="txt_btn_start"></span> 
				<span class="txt_btn_center"><fmt:message key="notice.message.box.close" /></span>
				<span class="txt_btn_end"></span>
			</a>
		</div>
		<!--  메시지박스 닫기 버튼  //-->
	
		<!--  메시지박스 전체보기 버튼  -->
		<div class="btn_black js_detail_message">
			<a href=""> 
				<span class="txt_btn_start"></span> 
				<span class="txt_btn_center"><fmt:message key="notice.message.box.detail" /></span>
				<span class="txt_btn_end"></span>
			</a>
		</div>
		<!--  메시지박스 전체보기 버튼  //-->
	</div>
</div>