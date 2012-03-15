<%@page import="java.util.Locale"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<script type="text/javascript">
	var currentUser = {
		locale : "<%=java.util.Locale.getDefault().getLanguage()%>"
	};
</script>
<html>
<fmt:setLocale value="<%=java.util.Locale.getDefault().getLanguage() %>" scope="request" />
<fmt:setBundle basename="resource.smartworksMessage" scope="request" />
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link href="css/default.css" type="text/css" rel="stylesheet" /></link>
		<link href="css/black/pop.css" type="text/css" rel="stylesheet" /></link>
		<link href="css/black/login.css" type="text/css" rel="stylesheet" /></link>
		<script type="text/javascript" src="js/jquery/jquery-1.6.2.min.js"></script>
		<script type="text/javascript" src="js/sw/sw-language.js"></script>
		<script type="text/javascript" src="js/sw/sw-language-ko.js"></script>
		<script type="text/javascript" src="js/sw/sw-language-en.js"></script>
		<script type="text/javascript" src="js/sw/sw-util.js"></script>
		<script type="text/javascript" src='js/sw/sw-popup.js'></script>
		<title><fmt:message key="login.head.title"/></title>
	</head>
	<body>
		<div id="lo_wrap">
	
			<!-- Header -->
			<div id="lo_header">
				<div class="lo_logo">
					<a title="Smartworks.net" href="http://www.smartworks.net"><img src="images/lo_logo_f.gif" /></a>
				</div>
	
				<form class="lo_idp t_wh" action="j_spring_security_check" method="post">
				
					<div class="fl mr7" >
					<div class="mb2"><fmt:message key="profile.title.email"/></div>
					<input id="j_username" name="j_username" maxlength="50" type="text" style="height:21px; width:142px"/>
					</div>
					
					<div class="fl">
					<div class="mb2"><fmt:message key="profile.title.password"/></div>
					<input id="j_password" name="j_password" maxlength="50" type="password" style="height:21px; width:142px"/>
					</div>
					
					<input class="fr btn_login" type="submit" value="<fmt:message key="login.button.login"/>">
					
					
					<div class="lo_checkbox cb"><span><fmt:message key="login.title.remember_me"/></span><input class="mr3" name="_spring_security_remember_me" type="checkbox" value="true" tabindex="3" /></div>
				</form>
			</div>
			<!-- Header //-->
	
			<!-- Contents -->
			<div id="lo_contents">
			<div><img src="images/login_logoTitle.gif" border="0" /></div>
			<div><img src="images/login_img.gif" border="0" /></div>
			</div>
			<!-- End of Contents -->
	
			<!-- Footer -->
			<div id="footer">
					<span class="bottom_text">Copyright <span onclick="clickBlank()">ⓒ</span> 2009-2012 <b>Maninsoft,</b> Inc. All Rights Reserved.</span>
			</div>
			<!-- End of Footer -->
		</div>
	</body>
</html>
<%
	String type = (String)request.getAttribute("type");
%>
<script type="text/javascript">
$(function() {
	<%
	if(type.equals("failedLogin")) {
	%>
		smartPop.showInfo(smartPop.ERROR, smartMessage.get('illegalAcountError'));
	<%
	} else if(type.equals("logout")) {
	%>
		smartPop.showInfo(smartPop.INFO, smartMessage.get('logoutSucceed'));
	<%
	} else if(type.equals("expiredSession")) {
	%>
		if(top.document.location.href === "login.sw")
			smartPop.showInfo(smartPop.WARN, smartMessage.get('sessionTimeouted'));
		else
			top.document.location.href = "login.sw";			
	<%
	}
	%>
	
    $(document).keypress(function (e) {
        if ((e.which && e.which == 13) || (e.keyCode && e.keyCode == 13)) {
            $('input[type="submit"]').click();
            return false;
        } else {
            return true;
        }
    });
});
</script>
