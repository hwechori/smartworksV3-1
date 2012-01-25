<%@page import="net.smartworks.util.SmartUtil"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="net.smartworks.service.ISmartWorks"%>
<%
	ISmartWorks smartWorks = (ISmartWorks) request.getAttribute("smartWorks");
	String cid = request.getParameter("cid");

	session.setAttribute("cid", cid);
	session.removeAttribute("wid");
%>

Content for User Space ~!!!! contextId =
<%=session.getAttribute("cid")%>
workSpaceId =
<%=session.getAttribute("wid")%>