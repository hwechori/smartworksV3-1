<%@page import="java.util.Locale"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	String type = (String)request.getAttribute("type");
%>
<script type="text/javascript">
	<%
	if(type.equals("failedLogin")) {
	%>
		alert("로그인 정보가 일치하지 않습니다. 정확한 정보를 입력하세요.");
	<%
	} else if(type.equals("logout")) {
	%>
		alert("로그아웃이 정상적으로 처리되었습니다.");
	<%
	} else if(type.equals("expiredSession")) {
	%>
		alert("세션이 만료되었습니다. 로그인 페이지로 이동합니다.");
		top.document.location.href = "login.sw";
	<%
	}
	%>
</script>
<html>
<fmt:setLocale value="<%=java.util.Locale.getDefault().getLanguage() %>" scope="request" />
<fmt:setBundle basename="resource.smartworksMessage" scope="request" />
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link href="css/default.css" type="text/css" rel="stylesheet" /></link>
		<link href="css/login_r.css" type="text/css" rel="stylesheet" /></link>
		<title><fmt:message key="login.head.title"/></title>
	</head>
	<body>
		<div id="lo_wrap">
	
			<!-- Header -->
			<div id="lo_header">
				<div class="lo_logo">
					<a title="Smartworks.net" href="http://www.smartworks.net"><img src="images/lo_logo_f.gif" /></a>
				</div>
	
				<div class="lo_idp t_wh" action="j_spring_security_check" method="post">
				
					<div class="float_left mr7" >
					<div class="mb2">이메일</div>
					<input id="j_username" name="j_username" maxlength="50" type="text" style="height:21px; width:142px"/>
					</div>
					
					<div class="float_left">
					<div class="mb2">비밀번호</div>
					<input id="j_password" name="j_password" maxlength="50" type="password" style="height:21px; width:142px"/>
					</div>
					
					<input class="float_right btn_login" type="submit" value="<fmt:message key="login.button.login"/>">
					
					
					<div class="lo_checkbox clear"><fmt:message key="login.title.remember_me"/> <input id="_spring_security_remember_me" type="checkbox" style="margin-right: 3px;" value="on" tabindex="3" name="_spring_security_remember_me" /></div>
				</div>
			</div>
			<!-- Header //-->
	
			<!-- Contents -->
			<div id="lo_contents"><img src="images/lo_center_img.jpg" border="0" /></div>
			<!-- End of Contents -->
	
			<!-- Footer -->
			<div id="footer">
					<span class="bottom_text">
					Copyright
					<span onclick="clickBlank()">ⓒ</span>
					2010
					<b>Maninsoft,</b>
					Inc. All Rights Reserved.
					</span>
			</div>
			<!-- End of Footer -->
		</div>
	</body>
</html>