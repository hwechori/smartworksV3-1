<%@page import="net.smartworks.server.engine.docfile.manager.IDocFileManager"%>
<%@page import="net.smartworks.model.community.User"%>
<%@page import="net.smartworks.util.SmartUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	User cUser = SmartUtil.getCurrentUser(request, response);
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form name="uplaodForm" action="../upload_file.sw" method="post" enctype="multipart/form-data">
<input type="hidden" name="userId" value="<%=cUser.getId()%>">
<input name="upload1" type="file" size="30"><p>
<input name="upload2" type="file" size="30"><p>
<input name="upload3" type="file" size="30"><p>
<input type="submit" value="UPLOAD">
</form>

</body>
</html>