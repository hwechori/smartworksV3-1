<%@page import="net.smartworks.util.SmartUtil"%>
<%@page import="net.smartworks.model.community.info.UserInfo"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="net.smartworks.service.ISmartWorks"%>
<%@ page import="net.smartworks.model.community.*"%>
<%
	User cUser = SmartUtil.getCurrentUser(request, response);

	ISmartWorks smartWorks = (ISmartWorks) request.getAttribute("smartWorks");
	String key = request.getParameter("key");
	UserInfo[] chatters = smartWorks.searchAvailableChatter(cUser.getCompanyId(), cUser.getId(), key);
%>

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
		}
	%>
</ul>
