
<!-- Name 			: header.jsp									 -->
<!-- Description	: 화면구성중에 Header 에 해당 되는 부분을 표현하는 화면 	 -->
<!-- Author			: Y.S. JUNG										 -->
<!-- Created Date	: 2011.9.										 -->

<%@page import="net.smartworks.util.SmartUtil"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="net.smartworks.service.ISmartWorks"%>
<%@ page import="net.smartworks.model.community.*"%>
<%@ page import="net.smartworks.model.notice.*"%>

<script>

// 서버에서 SmartUtil.publishMessage()로 NOTICE_COUNT를 현재사용자에게 메시지를 보내면 처리하는 함수이다.
function updateNoticeCount(message){
	var type = message.body.type;
	var count = message.body.count;
	var data = "<span></span>";
	if (count > 0)
		data = "<em class='num_ic'>" + count + "<span></span></em>";

	if (type == 0) {
		$('#notification_count').html(data);
	} else if (type == 1) {
		$('#message_count').html(data);
	} else if (type == 2) {
		$('#comment_count').html(data);
	} else if (type == 3) {
		$('#assigned_count').html(data);
	} else if (type == 4) {
		$('#mailbox_count').html(data);
	} else if (type == 5) {
		$('#savedbox_count').html(data);
	}
};
</script>
<%
	// 스마트웍스 서비스들을 사용하기위한 핸들러를 가져온다. 그리고 현재사용자 정보도 가져온다.	
	ISmartWorks smartWorks = (ISmartWorks) request.getAttribute("smartWorks");
	User cUser = SmartUtil.getCurrentUser();
	String cid = request.getParameter("cid");
	if (SmartUtil.isBlankObject(cid))
		cid = ISmartWorks.CONTEXT_HOME;
	String wid = request.getParameter("wid");
	if (SmartUtil.isBlankObject(wid))
		wid = cUser.getId();
	
	// 서버에서 현재사용자에 대한 Notice들을 가져온다.
	Notice[] notices = smartWorks.getNoticesForMe();
%>

<!-- 회사 로고 및 연결 링크 -->
<div>
	<a class="company_logo"
		href="home.sw?cid=<%=ISmartWorks.CONTEXT_HOME%>"></a>
</div>
<!-- 회사 로고 및 연결 링크 //-->

<!-- Notice 아이콘들 및 연결 기능  -->
<div class="notice_ico js_notice_icons_area">
	<ul>
		<!--  Notification 알림 영역 -->
		<!-- *** js_notice_count : sw_act_nav.sw에서 이벤트를 받아 Message List Box를 보여준다. --> 
		<li class="i_info js_notice_count">
			<a id="notification_count" href="notice_message_box.sw?noticeType=<%=Notice.TYPE_NOTIFICATION%>" 
				title="<fmt:message key='header.notice.icon.notification'/>">
				<%
	 			if (notices.length > Notice.TYPE_NOTIFICATION && notices[Notice.TYPE_NOTIFICATION].getLength() > 0) {
	 			%> 
	 				<em class="num_ic"><%=notices[Notice.TYPE_NOTIFICATION].getLength()%><span></span></em>
				<%
				}
				%>
			</a>
		</li>
		<!--  Notification 알림 영역 //-->

		<!-- 쪽지 알림 영역 -->
		<!-- *** js_notice_count : sw_act_nav.sw에서 이벤트를 받아 Message List Box를 보여준다. --> 
		<li class="i_note js_notice_count">
			<a id="message_count" href="notice_message_box.sw?noticeType=<%=Notice.TYPE_MESSAGE%>"
				title="<fmt:message key='header.notice.icon.message'/>"> 
				<%
	 			if (notices.length > Notice.TYPE_MESSAGE && notices[Notice.TYPE_MESSAGE].getLength() > 0) {
	 			%> 
	 				<em class="num_ic"><%=notices[Notice.TYPE_MESSAGE].getLength()%><span></span></em> 
				<%
				}
				%>
			</a>
		</li>
		<!-- 쪽지 알림 영역 //-->

		<!-- 댓글 알림 영역  -->
		<!-- *** js_notice_count : sw_act_nav.sw에서 이벤트를 받아 Message List Box를 보여준다. --> 
		<li class="i_replay js_notice_count">
			<a id="comment_count" href="notice_message_box.sw?noticeType=<%=Notice.TYPE_COMMENT%>"
				title="<fmt:message key='header.notice.icon.comments'/>">
				<%
			 	if (notices.length > Notice.TYPE_COMMENT && notices[Notice.TYPE_COMMENT].getLength() > 0) {
			 	%> 
				 	<em class="num_ic"><%=notices[Notice.TYPE_COMMENT].getLength()%><span></span></em> 
				<%
				}
				%>
			</a>
		</li>
		<!-- 댓글 알림 영역  //-->

		<!-- 할당업무 알림 영역  -->
		<!-- *** js_notice_count : sw_act_nav.sw에서 이벤트를 받아 Message List Box를 보여준다. --> 
		<li class="i_assworks js_notice_count">
			<a id="assigned_count" href="notice_message_box.sw?noticeType=<%=Notice.TYPE_ASSIGNED%>"
				title="<fmt:message key='header.notice.icon.assigned'/>">
				<%
			 	if (notices.length > Notice.TYPE_ASSIGNED && notices[Notice.TYPE_ASSIGNED].getLength() > 0) {
			 	%> 
				 	<em class="num_ic"><%=notices[Notice.TYPE_ASSIGNED].getLength()%><span></span></em>
				<%
				}
				%>
			</a>
		</li>
		<!-- 할당업무 알림 영역  //-->

		<!-- 메일 알림 영역  -->
		<!-- *** js_notice_count : sw_act_nav.sw에서 이벤트를 받아 Message List Box를 보여준다. --> 
		<li class="i_mail js_notice_count">
			<a id="mailbox_count" href="notice_message_box.sw?noticeType=<%=Notice.TYPE_MAILBOX%>"
				title="<fmt:message key='header.notice.icon.mailbox'/>">
				<%
			 	if (notices.length > Notice.TYPE_MAILBOX && notices[Notice.TYPE_MAILBOX].getLength() > 0) {
				%> 
					<em class="num_ic"><%=notices[Notice.TYPE_MAILBOX].getLength()%><span></span></em> 
				<%
				}
				%>
			</a>
		</li>
		<!-- 메일 알림 영역  //-->

		<!-- 임시저장 알림 영역  -->
		<!-- *** js_notice_count : sw_act_nav.sw에서 이벤트를 받아 Message List Box를 보여준다. --> 
		<li class="i_imsave js_notice_count">
			<a id="savedbox_count" href="notice_message_box.sw?noticeType=<%=Notice.TYPE_SAVEDBOX%>"
				title="<fmt:message key='header.notice.icon.savedbox'/>"> 
				<%
			 	if (notices.length > Notice.TYPE_SAVEDBOX && notices[Notice.TYPE_SAVEDBOX].getLength() > 0) {
			 	%> 
			 		<em class="num_ic"><%=notices[Notice.TYPE_SAVEDBOX].getLength()%><span></span></em> 
				<%
				}
				%>
			</a>
		</li>
		<!-- 임시저장 알림 영역  -->
		<li></li>
	</ul>
	<ul></ul>
</div>
<!-- Notice 아이콘들 및 연결 기능  //-->

<!-- Notice icon들을 클릭했을때 보여주는 메시지 리스트 박스 -->
<div class="pop_i_info" id="notice_message_box" style="display: none">
</div>

<!-- 헤더에 있는 메뉴들 및 연결 기능 -->
<div class="top_menu">
	<ul>
		<!--  홈메뉴  -->
		<li class="idx1">
		<%
		if (cid.equals(ISmartWorks.CONTEXT_HOME)) {
		%> 
			<span>
				<a class="current" href="home.sw?cid=<%=ISmartWorks.CONTEXT_HOME%>"><fmt:message key="header.top_menu.home" /></a>
			</span> 
		<%
		} else {
		%> 
			<span>
				<a href="home.sw?cid=<%=ISmartWorks.CONTEXT_HOME%>"><fmt:message key="header.top_menu.home" /></a>
			</span> 
		<%
		}
		%>
		</li>
		<!--  홈메뉴  //-->

		<!--  스마트케스트 메뉴  -->
		<li class="idx2">
		<%
		if (cid.equals(ISmartWorks.CONTEXT_SMARTCASTER)) {
		%> 
			<span>
				<a class="current href="smartcaster.sw?cid=<%=ISmartWorks.CONTEXT_SMARTCASTER%>"><fmt:message key="header.top_menu.smartcaster" /></a>
			</span> 
		<%
 		} else {
 		%> 
 			<span>
 				<a href="smartcaster.sw?cid=<%=ISmartWorks.CONTEXT_SMARTCASTER%>"><fmt:message key="header.top_menu.smartcaster" /></a> 
 			</span> 
 		<%
 		}
 		%>
		</li>
		<!--  스마트케스트 메뉴 // -->

		<!--  대시보드 메뉴  -->
		<li class="idx3">
		<%
		if (cid.equals(ISmartWorks.CONTEXT_DASHBOARD)) {
		%> 
			<span>
				<a class="current" href="dashboard.sw?cid=<%=ISmartWorks.CONTEXT_DASHBOARD%>"><fmt:message key="header.top_menu.dashboard" /></a> 
			</span> 
		<%
 		} else {
 		%> 
 			<span>
 				<a href="dashboard.sw?cid=<%=ISmartWorks.CONTEXT_DASHBOARD%>"><fmt:message key="header.top_menu.dashboard" /></a> 
 			</span> 
 		<%
 		}
 		%>
		</li>
		<!--  대시보드 메뉴  //-->
	</ul>
</div>
<!-- 헤더에 있는 메뉴들 및 연결 기능 // -->

<!-- 통합 검색 기능  -->
<div class="global_srch">
	<div class="srch srch_wsize">
		<input id="" class="nav_input" type="text" title="<fmt:message key='search.global_search'/>" placeholder="<fmt:message key='search.global_search'/>">
		<button title="<fmt:message key='search.search'/>" onclick=""></button>
	</div>
</div>
<!-- 통합 검색 기능  //-->

<!--  전체 메뉴  -->
<div class="global_menu">

	<!-- 도움말 연결  -->
	<div>
		<a title="<fmt:message key='header.global_menu.help'/>" target="_blank" href="http://manual.smartWorks.net/"><fmt:message key="header.global_menu.help" /> </a>
	</div>
	<!-- 도움말 연결  //-->

	<%
	if(cUser.getUserLevel() == User.USER_LEVEL_AMINISTRATOR || cUser.getUserLevel() == User.USER_LEVEL_SYSMANAGER){
	%>
		<!-- 관리자 권한이 있는 사용자에게 제공되는 시스템설정, 스마트빌더, 앱스토어 버튼들  -->
		<div class="pop_admin">
			<a href="settings_home.sw"><span class="btn_setting" title="<fmt:message key='header.global_menu.settings'/>" ></span></a>
			<a href="http://appstore.smartworks.net" target="_blank"><span class="btn_appstore" title="<fmt:message key='header.global_menu.appstore'/>"></span></a>
			<a href="builder_home.sw"><span class="btn_builder" title="<fmt:message key='header.global_menu.smartbuilder'/>"></span></a>
		</div>
	<%
	}
	%>
	<!-- 개인정보수정 및 로그아웃 영역  -->
	<div>
		<a href="" onclick="$(this).parent().next('div').toggle(); return false;"><%=cUser.getLongName()%>▼ </a>
	</div>

	<!-- 위의 사용자정보 클릭시 나타나는 개인정보수정 및 로그아웃 버튼들  -->
	<div class="pop" style="display: none">
		<ul>
			<li><a
				href="my_profile.sw?cid=<%=ISmartWorks.CONTEXT_MYPROFILE%>"><fmt:message
						key="header.global_menu.edit_my_profile" /> </a>
			</li>
			<li><a href="logout.sw"><fmt:message key="header.global_menu.logout" />
			</a>
			</li>
		</ul>
	</div>
	<!-- // -->
	<!-- 개인정보수정 및 로그아웃 영역  //-->

</div>
<!--  전체 메뉴  //-->
