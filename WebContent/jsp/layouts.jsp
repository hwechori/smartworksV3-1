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
	session = request.getSession();
	if (session.getAttribute("userId") == null) {
		SecurityContext context = (SecurityContext) request
				.getSession()
				.getAttribute(
						HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY);
		if (context != null) {
			Authentication auth = context.getAuthentication();
			if (auth != null) {
				session.setAttribute("userId",
						((Login) auth.getPrincipal()).getId());
				/* 				session.setAttribute("userName", ((Login) auth.getPrincipal()).getName());
				 session.setAttribute("type", ((Login) auth.getPrincipal()).getType()); */
				session.setAttribute("companyId",
						((Login) auth.getPrincipal()).getCompanyId());
				/* 				session.setAttribute("deptId", ((Login) auth.getPrincipal()).getDeptId());
				 session.setAttribute("locale", ((Login) auth.getPrincipal()).getLocale());
				 session.setAttribute("empNo", ((Login) auth.getPrincipal()).getEmpNo());
				 session.setAttribute("position", ((Login) auth.getPrincipal()).getPos());
				 session.setAttribute("email", ((Login) auth.getPrincipal()).getEmail());
				 session.setAttribute("passWord", ((Login) auth.getPrincipal()).getPassword());
				 session.setAttribute("authId", ((Login) auth.getPrincipal()).getAuthId()); */

				System.out.println("userId >>> "
						+ session.getAttribute("userId"));
				/* 				System.out.println("userName >>> " + session.getAttribute("userName"));
				 System.out.println("type >>> " + session.getAttribute("type")); */
				System.out.println("companyId >>> "
						+ session.getAttribute("companyId"));
				/* 				System.out.println("deptId >>> " + session.getAttribute("deptId"));
				 System.out.println("empNo >>> " + session.getAttribute("empNo"));
				 System.out.println("position >>> " + session.getAttribute("position"));
				 System.out.println("email >>> " + session.getAttribute("email"));
				 System.out.println("passWord >>> " + session.getAttribute("passWord"));
				 System.out.println("authId >>> " + session.getAttribute("authId"));
				 System.out.println("locale >>> " + session.getAttribute("locale")); */

				Calendar rightNow = Calendar.getInstance();
				int year = rightNow.get(Calendar.YEAR) % 100;
				int month = rightNow.get(Calendar.MONTH);
				int date = rightNow.get(Calendar.DATE);
				int hour = rightNow.get(Calendar.HOUR);
				int minute = rightNow.get(Calendar.MINUTE);
				int second = rightNow.get(Calendar.SECOND);

				System.out.println("connectTime ==> " + year + "년 "
						+ month + "월 " + date + "일 " + hour + "시 "
						+ minute + "분 " + second + "초");

			}
		}
	}

	String companyId = (String) session.getAttribute("companyId");
	String userId = (String) session.getAttribute("userId");
	String cid = (String) session.getAttribute("cid");
	String wid = (String) session.getAttribute("wid");
	if (cid == null) {
		session.setAttribute("cid", ISmartWorks.CONTEXT_HOME);
	}
	ISmartWorks smartWorks = (ISmartWorks) request
			.getAttribute("smartWorks");
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
<script type="text/javascript" src="js/sw/sw-util.js"></script>
<script type="text/javascript" src="js/sw/sw-all.js"></script>
<script type="text/javascript" src="js/sw/sw-more.js"></script>
<script type="text/javascript" src="js/sw/sw-nav.js"></script>
<script type="text/javascript" src="js/sw/sw-validate.js"></script>
<script type="text/javascript" src="http://localhost:8000/faye.js"></script>
<script type="text/javascript" src="js/sw/sw-messaging.js"></script>

<script type="text/javascript">
	smartTalk.init();
	if(smartMsgClient != null){
		smartTalk.subscribe("/test");
		var repeat = function(){
			smartTalk.publish("/test", "Hello, this is SmartWorks!! Welcome~~");			
		}
		setInterval(repeat, 2000);
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
</body>
</html>