<%@page import="net.smartworks.util.SmartUtil"%>
<%@page import="net.smartworks.model.community.info.UserInfo"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="net.smartworks.service.ISmartWorks"%>
<%@ page import="net.smartworks.model.community.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	User cUser = SmartUtil.getCurrentUser();

	ISmartWorks smartWorks = (ISmartWorks) request.getAttribute("smartWorks");
	String key = request.getParameter("key");
	UserInfo[] chatters = smartWorks.searchAvailableChatter(key);
%>
<fmt:setLocale value="<%=cUser.getLocale() %>" scope="request" />
<fmt:setBundle basename="resource.smartworksMessage" scope="request" />

<ul>
	<%
		if(chatters != null){
			for (UserInfo chatter : chatters) {
	%>
	<li><img src="<%=chatter.getMinPicture()%>" border="0"><a
		title="<%=chatter.getDepartment()%>"><%=chatter.getPosition()%> <%=chatter.getName()%></a>
	</li>
	<%
			}
		}else{
			%>
			<li><span><fmt:message key="search.message.no_searched_data"/></span></li>
			<%} %>

</ul>
