<%@page
	import="org.springframework.security.web.context.HttpSessionSecurityContextRepository"%>
<%@page import="java.util.Calendar"%>
<%@page import="net.smartworks.server.engine.security.model.Login"%>
<%@page import="org.springframework.security.core.Authentication"%>
<%@page
	import="org.springframework.security.core.context.SecurityContext"%>
<%@page import="net.smartworks.util.SmartUtil"%>
<%@page import="net.smartworks.model.community.User"%>
<%@page import="net.smartworks.service.ISmartWorks"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<!-- For Development Purpose -->
<%
	SecurityContext context = (SecurityContext) request
			.getSession()
			.getAttribute(
					HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY);
	if (context != null) {
		Authentication auth = context.getAuthentication();
		if (auth != null) {
			if (request.getSession().getAttribute("loginId") == null) {
				System.out
						.println("-------------------------------------------");
				System.out.println(((Login) auth.getPrincipal())
						.getPosition()
						+ " "
						+ ((Login) auth.getPrincipal()).getName()
						+ " 님이 접속하였습니다.");
				System.out.println("ID : "
						+ ((Login) auth.getPrincipal()).getId());
				System.out
						.println("DEPT : "
								+ ((Login) auth.getPrincipal())
										.getDepartment());
				Calendar rightNow = Calendar.getInstance();
				int year = rightNow.get(Calendar.YEAR) % 100;
				int month = rightNow.get(Calendar.MONTH);
				int date = rightNow.get(Calendar.DATE);
				int hour = rightNow.get(Calendar.HOUR);
				int minute = rightNow.get(Calendar.MINUTE);
				int second = rightNow.get(Calendar.SECOND);

				System.out.println("ConnectTime : " + year + "년 "
						+ month + "월 " + date + "일 " + hour + "시 "
						+ minute + "분 " + second + "초");

				request.getSession().setAttribute("loginId",
						((Login) auth.getPrincipal()).getId());

				System.out
						.println("-------------------------------------------");
			}
		}
	}

	String cid = (String) session.getAttribute("cid");
	String wid = (String) session.getAttribute("wid");
	if (cid == null) {
		session.setAttribute("cid", ISmartWorks.CONTEXT_HOME);
	}
	ISmartWorks smartWorks = (ISmartWorks) request
			.getAttribute("smartWorks");
	User currentUser = SmartUtil.getCurrentUser(request, response);
%>
<fmt:setLocale value="<%=currentUser.getLocale() %>" scope="request" />
<fmt:setBundle basename="resource.smartworksMessage" scope="request" />

<head>
<script type="">
currentUser = {
	userId : "<%=currentUser.getId()%>",
	longName : "<%=currentUser.getLongName()%>",
	companyId : "<%=currentUser.getCompanyId()%>",
	minPicture : "<%=currentUser.getMinPicture()%>",
	midPicture : "<%=currentUser.getMidPicture()%>"
};
</script>

<link href="css/default.css" type="text/css" rel="stylesheet" />
<link href="css/layout.css" type="text/css" rel="stylesheet" />
<link href="css/detail.css" type="text/css" rel="stylesheet" />
<link href="css/chat.css" type="text/css" rel="stylesheet" />
<link rel="stylesheet"
	href="css/custom-theme/jquery-ui-1.8.16.custom.css" type="text/css"
	title="ui-theme" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><fmt:message key="head.title">
		<fmt:param value="<%=currentUser.getCompany() %>" />
	</fmt:message> <sec:authentication property="principal.name" /> <sec:authorize
		access="hasRole('ADMINISTRATOR')"> 
		(ADMIN)
	</sec:authorize>
</title>

<script type="text/javascript" src="js/jquery/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery/jquery.ui.core.js"></script>
<script type="text/javascript" src="js/jquery/jquery.validate.js"></script>
<script type="text/javascript" src="js/jquery/jquery.effects.core.js"></script>
<script type="text/javascript" src="js/jquery/jquery.effects.explode.js"></script>
<script type="text/javascript" src="js/jquery/jquery.ui.datepicker.js"></script>
<script type="text/javascript"
	src="js/jquery/jquery.ui.datepicker-ko.js"></script>
<script type="text/javascript"
	src="js/jquery/jquery-ui-1.8.16.custom.js"></script>
<script type="text/javascript" src="js/jquery/history/jquery.history.js"></script>
<!-- <script type="text/javascript" src="js/faye/faye-browser-min.js"></script>
 -->
<script type="text/javascript" src="js/sw/sw-util.js"></script>
<script type="text/javascript" src="js/sw/sw-all.js"></script>
<script type="text/javascript" src="js/sw/sw-more.js"></script>
<script type="text/javascript" src="js/sw/sw-nav.js"></script>
<script type="text/javascript" src="js/sw/sw-validate.js"></script>
<script type="text/javascript" src="http://192.168.0.8:8000/faye.js"></script>
<script type="text/javascript" src="js/sw/sw-messaging.js"></script>

<script type="text/javascript">
	smartTalk.init();
	var repeat1 = function() {
		clearInterval(timer);
		smartTalk.publishBcast(new Array(
				" Hello, this is SmartWorks!! Welcome~~",
				"오늘은 삼겹살데이 입니다. 점심시간에 가급적이면 많은 분들이 참석바랍니다.!!! from 경영기획본부"));
	};
	smartTalk.publishNoticeCount({
		type : 0,
		count : 0
	});
	smartTalk.publishNoticeCount({
		type : 1,
		count : 1
	});
	smartTalk.publishNoticeCount({
		type : 2,
		count : 2
	});
	smartTalk.publishNoticeCount({
		type : 3,
		count : 3
	});
	smartTalk.publishNoticeCount({
		type : 4,
		count : 4
	});
	smartTalk.publishNoticeCount({
		type : 5,
		count : 5
	});

	var sendChatterList = function() {
		clearInterval(timer);
		smartTalk.publish(swSubject.SMARTWORKS + swSubject.COMPANYID
				+ swSubject.BROADCASTING, {
			msgType : msgType.AVAILABLE_CHATTERS,
			sender : "smartworks.net",
			userInfos : new Array({
				userId : "ysjung@maninsoft.co.kr",
				longName : "대표이사 정윤식",
				minPicture : "images/ysjung@maninsoft.co.kr_min.jpg"
			}, {
				userId : "jskim@maninsoft.co.kr",
				longName : "과장 김지숙",
				minPicture : "images/jskim@maninsoft.co.kr_min.jpg"
			}, {
				userId : "hsshin@maninsoft.co.kr",
				longName : "선임연구원 신현성",
				minPicture : "images/hsshin@maninsoft.co.kr_min.jpg"
			})
		});
	};
	var timer = setInterval(sendChatterList, 5000);

	function startChattingWindow(message) {
		var userInfos = message.userInfos;
		var title = "";
		if (userInfos != null && userInfos.length > 0) {
			title = userInfos[0].longName;
			if (userInfos.length > 2) {
				title = title + "외 " + (userInfos.length - 1) + "명";
			} else {
				for ( var i = 1; i < userInfos.length; i++) {
					title = title + "," + userInfos[i].longName;
				}
				title = title + "님";
			}
			title = title + "과의 대화";
		}
		var target = $('div.js_chatting_box')
		target.find('div.js_chatting_title').html(title);
		target.attr("id", message.chatId);
		target.slideDown();
	}
</script>

</head>

<body>

	<div id="wrap">
		<!-- Header -->
		<div id="header">
			<tiles:insertAttribute name="header" />
		</div>
		<!-- Header//-->

		<!-- Navigation -->
		<div id="nav">
			<tiles:insertAttribute name="nav" />
		</div>
		<!-- Navigation// -->

		<!-- Broadcasting Board -->
		<div id="board">
			<tiles:insertAttribute name="board" />
		</div>
		<!-- Broadcasting Board//-->

		<!-- Contents-->
		<div id="content">
			<tiles:insertAttribute name="content" />
		</div>
		<!-- Contents//-->

		<!-- Footer-->
		<div id="footer">
			<tiles:insertAttribute name="footer" />
		</div>
		<!-- Footer //-->

	</div>

	<div class="js_chatting_box" style="display: none">
			<jsp:include page="/jsp/chatting/chatting_box.jsp" />
	</div>

</body>
</html>
