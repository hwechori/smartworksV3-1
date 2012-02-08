<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String type = (String)request.getAttribute("type");
%>
<script type="text/javascript">
<%
	if(type.equals("failedLogin")) {
%>
		alert("로그인 정보가 일치하지 않습니다. 정확한 정보를 입력하십시오~!!");
<%
	} else if(type.equals("logout")) {
%>
		alert("정상적으로 로그아웃 처리되었습니다.");
<%
	} else if(type.equals("expiredSession")) {
%>
		alert("세션이 만료되었습니다. 다시 로그인 해주세요~");
		top.document.location.href = "login.sw";
<%
	}
%>
</script>
<html lang='en'>
<head>
<title>SmartWorks.net</title>
</head>
<body class="welcome">
	<div class="welcomeMent">
		<span class="productName">SmartWorks.net</span> <span>Welcome,</span>
		Please Log In to Your Account ...
	</div>

	<form action="j_spring_security_check" method="post">
		<label for="j_username">user name</label>: <input id="j_username" name="j_username" maxlength="50" type="text" class="loginInput" />
		<label for="j_password">password</label>: <input id="j_password" name="j_password" maxlength="50" type="password" class="loginInput" />
		<div class="btnline">
			<input id="_spring_security_remember_me" name="_spring_security_remember_me" type="checkbox" value="true" />
			<label for="_spring_security_remember_me">remember me?</label><input type="submit" value="Login" class="btnWelcomeLogin" />
		</div>
	</form>
</body>
</html>