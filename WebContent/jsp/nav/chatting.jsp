<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="net.smartworks.service.ISmartWorks"%>
<%@ page import="net.smartworks.model.community.*"%>

<%
	String companyId = (String) session.getAttribute("companyId");
	String userId = (String) session.getAttribute("userId");
	
	ISmartWorks smartWorks = (ISmartWorks) request.getAttribute("smartWorks");
	User[] chatters = smartWorks.getAvailableChatter(companyId, userId);
%>

<ul>
	<li class="nav_srch">
		<div class="srch">
			<input id="" class="input js_auto_complete" type="text"
				title="<fmt:message key="search.search_available_chatter"/>"
				placeholder="<fmt:message key="search.search_available_chatter"/>"
				href="available_chatter.sw">
			<div class='srch_ico js_srch_x'></div>
		</div>
		<div style="display: none"></div>
	</li>
	<li class="ico_chatpe">
		<%
			for (User chatter : chatters) {
		%> <img src="<%=chatter.getMinPicture()%>"
		title="<%=chatter.getLongName()%>" /> <%
 	}
 %>
	</li>
</ul>