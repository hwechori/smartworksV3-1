<%@page import="java.util.Calendar"%>
<%@page import="net.smartworks.util.SmartUtil"%>
<%@page import="net.smartworks.util.LocalDate"%>
<%@page import="net.smartworks.model.community.User"%>
<%@page import="net.smartworks.server.engine.security.model.Login"%>
<%@page import="org.springframework.security.web.context.HttpSessionSecurityContextRepository"%>
<%@page import="org.springframework.security.core.Authentication"%>
<%@page import="org.springframework.security.core.context.SecurityContext"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	session = request.getSession();
	if(session.getAttribute("userId") == null) {
		SecurityContext context = (SecurityContext) request.getSession().getAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY);
		if(context != null) {
			Authentication auth = context.getAuthentication();
			if(auth != null) {
 				session.setAttribute("userId", ((Login) auth.getPrincipal()).getId());
/* 				session.setAttribute("userName", ((Login) auth.getPrincipal()).getName());
				session.setAttribute("type", ((Login) auth.getPrincipal()).getType()); */
				session.setAttribute("companyId", ((Login) auth.getPrincipal()).getCompanyId());
/* 				session.setAttribute("deptId", ((Login) auth.getPrincipal()).getDeptId());
				session.setAttribute("locale", ((Login) auth.getPrincipal()).getLocale());
				session.setAttribute("empNo", ((Login) auth.getPrincipal()).getEmpNo());
				session.setAttribute("position", ((Login) auth.getPrincipal()).getPos());
				session.setAttribute("email", ((Login) auth.getPrincipal()).getEmail());
				session.setAttribute("passWord", ((Login) auth.getPrincipal()).getPassword());
				session.setAttribute("authId", ((Login) auth.getPrincipal()).getAuthId()); */

 				System.out.println("userId >>> " + session.getAttribute("userId"));
/* 				System.out.println("userName >>> " + session.getAttribute("userName"));
				System.out.println("type >>> " + session.getAttribute("type")); */
				System.out.println("companyId >>> " + session.getAttribute("companyId"));
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

				System.out.println("connectTime ==> " + year+"년 " + month+"월 " + date+"일 " + hour + "시 " + minute + "분 " + second + "초");

			}
		}
	}

	response.sendRedirect("home.sw");
%>
</body>
</html>