<%@page import="net.smartworks.util.SmartUtil"%>
<%@page import="net.smartworks.model.community.User"%>
<%@page import="net.smartworks.service.ISmartWorks"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<!-- For Development Purpose -->
<%
	if(session.getAttribute("companyId")==null || session.getAttribute("userId")==null){
		session.setAttribute("companyId", "Maninsoft");
		session.setAttribute("userId", "jskim@maninsoft.co.kr");
	}
	String companyId = session.getAttribute("companyId");
	String userId = session.getAttribute("userId");
	
	
	if (session.getAttribute("cid") == null) {
		session.setAttribute("cid", ISmartWorks.CONTEXT_HOME);
	}
%>
<%
	ISmartWorks smartWorks = (ISmartWorks) request.getAttribute("smartWorks");
	User currentUser = SmartUtil.getCurrentUser();
%>
<fmt:setLocale value="<%=currentUser.getLocale() %>" scope="request" />
<fmt:setBundle basename="resource.smartworksMessage" scope="request" />


<head>

<link href="css/default.css" type="text/css" rel="stylesheet" />
<link href="css/layout.css" type="text/css" rel="stylesheet" />
<link href="css/calendar.css" type="text/css" rel="stylesheet" />
<link rel="stylesheet" href="css/custom-theme/jquery-ui-1.8.16.custom.css" type="text/css" title="ui-theme" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><fmt:message key="head.title">
		<fmt:param value="<%=currentUser.getCompany() %>" />
	</fmt:message></title>

<script type="text/javascript" src="js/jquery/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery/jquery.ui.core.js"></script>
<script type="text/javascript" src="js/jquery/jquery.validate.js"></script>
<script type="text/javascript" src="js/jquery/jquery.effects.core.js"></script>
<script type="text/javascript" src="js/jquery/jquery.effects.explode.js"></script>
<script type="text/javascript" src="js/jquery/jquery.ui.datepicker.js"></script>
<script type="text/javascript" src="js/jquery/jquery.ui.datepicker-ko.js"></script>
<script type="text/javascript" src="js/jquery/jquery-ui-1.8.16.custom.js"></script>
<script type="text/javascript" src="js/jquery/history/jquery.history.js"></script>
<script type="text/javascript" src="js/sw/sw-util.js"></script>
<script type="text/javascript" src="js/sw/sw-all.js"></script>
<script type="text/javascript" src="js/sw/sw-more.js"></script>
<script type="text/javascript" src="js/sw/sw-nav.js"></script>
<script type="text/javascript" src="js/sw/sw-validate.js"></script>

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