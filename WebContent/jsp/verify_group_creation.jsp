<%@page import="net.smartworks.model.community.User"%>
<%@page import="net.smartworks.model.community.Group"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	Group group = (Group)request.getAttribute("group");
	User[] users = group.getMembers();
	for(User user : users) {
		out.println(user.getId());
	}
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>verify page~!!</title>
</head>
<body>
</body>
</html>