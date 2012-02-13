<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link href="css/default.css" type="text/css" rel="stylesheet" /></link>
		<link href="css/login.css" type="text/css" rel="stylesheet" /></link>
		<title>스마트웍스닷넷</title>
	</head>
	<body class="welcome">
		<div id="wrap">
	
			<!-- Header -->
			<div id="lo_header">
				<div class="lo_logo">
					<a title="Smartworks.net" href="http://www.smartworks.net"><img src="images/lo_logo_f.gif" /></a>
				</div>
	
				<form class="lo_idpass" action="j_spring_security_check" method="post">
					<input id="j_username" name="j_username" maxlength="50" type="text" class="loginInput" />
					<input id="j_password" name="j_password" maxlength="50" type="password" class="loginInput" />
					<input type="submit" value="Login" class="btnWelcomeLogin" ><img src="images/login_btn.gif" />
					<div class="lo_checkbox">Remember Me? <input id="_spring_security_remember_me" type="checkbox" style="margin-right: 3px;" value="on" tabindex="3" name="_spring_security_remember_me" /></div>
				</form>
			</div>
			<!-- Header //-->
	
			<!-- Contents -->
			<div id="lo_contents"><img src="images/lo_center_img.jpg" border="0" /></div>
			<!-- End of Contents -->
	
			<!-- Footer -->
			<div id="footer">
				<div class="login_flogo1">
					<span class="bottomText">Copyright <span onclick="clickBlank()">ⓒ </span>2010-2012 <b>Maninsoft,</b>Inc. All Rights Reserved. </span>
				</div>
			</div>
			<!-- End of Footer -->
		</div>
	</body>
</html>