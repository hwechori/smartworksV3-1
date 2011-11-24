<%@page import="org.springframework.security.web.context.HttpSessionSecurityContextRepository"%>
<%@page import="java.util.Calendar"%>
<%@page import="net.smartworks.server.engine.security.model.Login"%>
<%@page import="org.springframework.security.core.Authentication"%>
<%@page	import="org.springframework.security.core.context.SecurityContext"%>
<%@page import="net.smartworks.util.SmartUtil"%>
<%@page import="net.smartworks.model.community.User"%>
<%@page import="net.smartworks.service.ISmartWorks"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<!-- For Development Purpose -->
<%
	SecurityContext context = (SecurityContext) request.getSession().getAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY);
	if (context != null) {
		Authentication auth = context.getAuthentication();
		if (auth != null) {
			if (request.getSession().getAttribute("loginId") == null) {
				System.out.println("-------------------------------------------");
				System.out.println(((Login) auth.getPrincipal()).getPosition() + " " + ((Login) auth.getPrincipal()).getName() + " 님이 접속하였습니다.");
				System.out.println("ID : "+ ((Login) auth.getPrincipal()).getId());
				System.out.println("DEPT : "+ ((Login) auth.getPrincipal()).getDepartment());

				Calendar rightNow = Calendar.getInstance();
				int year = rightNow.get(Calendar.YEAR) % 100;
				int month = rightNow.get(Calendar.MONTH);
				int date = rightNow.get(Calendar.DATE);
				int hour = rightNow.get(Calendar.HOUR);
				int minute = rightNow.get(Calendar.MINUTE);
				int second = rightNow.get(Calendar.SECOND);

				System.out.println("ConnectTime : " + year + "년 " + month + "월 " + date + "일 " + hour + "시 " + minute + "분 " + second + "초");

				request.getSession().setAttribute("loginId", ((Login) auth.getPrincipal()).getId());

				System.out.println("-------------------------------------------");
			}
		}
	}

	String cid = (String) session.getAttribute("cid");
	String wid = (String) session.getAttribute("wid");
	if (cid == null) {
		session.setAttribute("cid", ISmartWorks.CONTEXT_HOME);
	}
	ISmartWorks smartWorks = (ISmartWorks) request.getAttribute("smartWorks");
	//User currentUser = SmartUtil.getCurrentUser(request);
	User currentUser = SmartUtil.getCurrentUser(request);
%>
<fmt:setLocale value="<%=currentUser.getLocale() %>" scope="request" />
<fmt:setBundle basename="resource.smartworksMessage" scope="request" />


<head>

<link href="css/default.css" type="text/css" rel="stylesheet" />
<link href="css/layout.css" type="text/css" rel="stylesheet" />
<link href="css/detail.css" type="text/css" rel="stylesheet" />
<link rel="stylesheet"
	href="css/custom-theme/jquery-ui-1.8.16.custom.css" type="text/css"
	title="ui-theme" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><fmt:message key="head.title">
		<fmt:param value="<%=currentUser.getCompany() %>" />
	</fmt:message> <sec:authentication property="principal.name" /> <sec:authorize
		access="hasRole('ADMINISTRATOR')"> 
		(ADMIN)
	</sec:authorize></title>

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
<!-- <script type="text/javascript" src="js/sw/sw-messaging.js"></script>
 -->

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
</body>
</html>