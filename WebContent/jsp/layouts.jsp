<%@page	import="org.springframework.security.web.context.HttpSessionSecurityContextRepository"%>
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
				System.out.println("ID : " + ((Login) auth.getPrincipal()).getId());
				System.out.println("DEPT : " + ((Login) auth.getPrincipal()).getDepartment());
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
	User currentUser = SmartUtil.getCurrentUser();
%>
<fmt:setLocale value="<%=currentUser.getLocale() %>" scope="request" />
<fmt:setBundle basename="resource.smartworksMessage" scope="request" />

<head>
<script type="">
currentUser = {
	userId : "<%=currentUser.getId()%>",
	name : "<%=currentUser.getName()%>",
	longName : "<%=currentUser.getLongName()%>",
	companyId : "<%=currentUser.getCompanyId()%>",
	minPicture : "<%=currentUser.getMinPicture()%>",
	midPicture : "<%=currentUser.getMidPicture()%>",
	locale : "<%=currentUser.getLocale()%>",
	timeZone : "<%=currentUser.getTimeZone()%>"
};
</script>

<link href="css/default.css" type="text/css" rel="stylesheet" />
<link href="css/layout.css" type="text/css" rel="stylesheet" />
<link href="css/detail.css" type="text/css" rel="stylesheet" />
<link href="css/chat.css" type="text/css" rel="stylesheet" />
<link rel="stylesheet" href="css/ui-lightness/jquery-ui-1.8.16.custom.css" type="text/css" title="ui-theme" />
<link href="css/ext/ext-all.css" type="text/css" rel="stylesheet" />
<!-- <link href="css/ext/example.css" type="text/css" rel="stylesheet" />
-->
<link rel="stylesheet" href="css/fileuploader/fileuploader.css" type="text/css"/>	
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><fmt:message key="head.title">
		<fmt:param value="<%=currentUser.getCompany() %>" />
	</fmt:message>
</title>

<script type="text/javascript" src="js/jquery/jquery-1.6.2.min.js"></script>
<script type="text/javascript" src="js/jquery/jquery.ui.core.min.js"></script>
<script type="text/javascript" src="js/jquery/jquery.validate.js"></script>
<script type="text/javascript" src="js/jquery/jquery.effects.core.js"></script>
<script type="text/javascript" src="js/jquery/jquery.effects.explode.js"></script>
<script type="text/javascript" src="js/jquery/jquery-ui-1.8.16.custom.min.js"></script>
<script type="text/javascript" src="js/jquery/jquery.ui.widget.min.js"></script>
<script type="text/javascript" src="js/jquery/jquery.ui.mouse.min.js"></script>
<script type="text/javascript" src="js/jquery/jquery.ui.slider.min.js"></script>
<script type="text/javascript" src="js/jquery/jquery.ui.datepicker.min.js"></script>
<script type="text/javascript" src="js/jquery/jquery.ui.datepicker-ko.js"></script>
<script type="text/javascript" src="js/jquery/jquery-ui-timepicker-addon.js"></script>
<script type="text/javascript" src="js/jquery/jquery-ui-timepicker-ko.js"></script>

<script type="text/javascript" src="js/jquery/jquery.popupWindow.js"></script>

<script type="text/javascript" src="js/jquery/history/jquery.history.js"></script>
<script type="text/javascript" src="js/jquery/jquery.json-2.3.min.js"></script>
<script type="text/javascript" src="js/jquery/jquery.zclip.min.js"></script>
<script type="text/javascript" src="js/jquery/jquery.showLoading.min.js"></script>
<script type="text/javascript" src="js/jquery/jshashtable-2.1.js"></script>
<script type="text/javascript" src="js/jquery/jquery.numberformatter-1.2.2.min.js"></script>
<script type="text/javascript" src="js/jquery/jquery.formatCurrency-1.4.0.min.js"></script>
<script type="text/javascript" src="js/jstorage/jstorage.js"></script>
<script type="text/javascript" src="js/faye/faye-browser-min.js"></script>
<script type="text/javascript" src="js/ext/bootstrap.js"></script>
<script type="text/javascript" src="js/ext/ext-all.js"></script>
<script type="text/javascript" src="js/sw/sw-util.js"></script>
<script type="text/javascript" src="js/sw/sw-all.js"></script>
<script type="text/javascript" src="js/sw/sw-more.js"></script>
<script type="text/javascript" src="js/sw/sw-nav.js"></script>
<script type="text/javascript" src="js/sw/sw-validate.js"></script>
<script type="text/javascript" src="http://localhost:8000/faye.js"></script>
<script type="text/javascript" src="js/sw/sw-faye.js"></script>
<script type="text/javascript" src="js/sw/sw-chat.js"></script>
<script type="text/javascript" src="js/sw/sw-report.js"></script>
<script type="text/javascript" src="js/sw/sw-file.js"></script>
<script type="text/javascript" src="js/sw/sw-language.js"></script>
<script type="text/javascript" src="js/sw/sw-language-ko.js"></script>
<script type="text/javascript" src="js/sw/sw-language-en.js"></script>

<script type="text/javascript" src='js/smartform/smartworks.js'></script>
<script type="text/javascript" src='js/smartform/sw-form-layout.js'></script>
<script type="text/javascript" src='js/smartform/sw-form-field-builder.js'></script>

<script type="text/javascript" src='js/smartform/field/currency_input.js'></script>
<script type="text/javascript" src='js/smartform/field/radio_button.js'></script>
<script type="text/javascript" src='js/smartform/field/check_box.js'></script>
<script type="text/javascript" src='js/smartform/field/combo_box.js'></script>
<script type="text/javascript" src='js/smartform/field/date_chooser.js'></script>
<script type="text/javascript" src='js/smartform/field/email_input.js'></script>
<script type="text/javascript" src='js/smartform/field/file_field.js'></script>
<script type="text/javascript" src='js/smartform/field/number_input.js'></script>
<script type="text/javascript" src='js/smartform/field/percent_input.js'></script>
<script type="text/javascript" src='js/smartform/field/rich_editor.js'></script>
<script type="text/javascript" src='js/smartform/field/text_input.js'></script>
<script type="text/javascript" src='js/smartform/field/time_chooser.js'></script>
<script type="text/javascript" src='js/smartform/field/datetime_chooser.js'></script>
<script type="text/javascript" src='js/smartform/field/user_field.js'></script>


<link href="smarteditor/css/default_kor.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="smarteditor/js/HuskyEZCreator.js" charset="utf-8"></script>

<script type="text/javascript" src="js/jquery/fileuploader/fileuploader.js" ></script>

<script type="text/javascript">
	$(document).ready(function(){
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
	
		 setTimeout(function() {
			smartTalk.publish(swSubject.SMARTWORKS + swSubject.COMPANYID
					+ swSubject.BROADCASTING, {
				msgType : msgType.AVAILABLE_CHATTERS,
				sender : "smartworks.net",
				userInfos : new Array({
					userId : "ysjung@maninsoft.co.kr",
					longName : "대표이사 정윤식",
					minPicture : "images/no_user_picture_min.jpg"
				}, {
					userId : "jskim@maninsoft.co.kr",
					longName : "과장 김지숙",
					minPicture : "images/no_user_picture_min.jpg"
				}, {
					userId : "hsshin@maninsoft.co.kr",
					longName : "선임연구원 신현성",
					minPicture : "images/no_user_picture_min.jpg"
				}, {
					userId : "kmyu@maninsoft.co.kr",
					longName : "선임연구원 유광민",
					minPicture : "images/no_user_picture_min.jpg"
				}, {
					userId : "hjlee@maninsoft.co.kr",
					longName : "대리 이현정",
					minPicture : "images/no_user_picture_min.jpg"
				})
			});
		}, 5000);
	});
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
 	<jsp:include page="/jsp/chatting/chatter_list.jsp" />
</body>
</html>
