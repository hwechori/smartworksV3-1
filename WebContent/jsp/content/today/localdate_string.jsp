<%@page import="net.smartworks.util.LocalDate"%>
<%
	LocalDate today = new LocalDate();
%>
<%=today.toLocalDateString()%>