<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="net.smartworks.service.ISmartWorks"%>
<%@ page import="net.smartworks.model.community.*"%>

<%
	String companyId = (String) session.getAttribute("companyId");
	String userId = (String) session.getAttribute("userId");
	
	ISmartWorks smartWorks = (ISmartWorks) request.getAttribute("smartWorks");
	Group[] groups = smartWorks.getMyGroups(companyId, userId);
%>

<ul>
	<%
		for (Group group : groups) {
			String groupContext = ISmartWorks.CONTEXT_PREFIX_GROUP_SPACE + group.getId();
	%>
	<li class="ico_depart"><a
		href="group_space.sw?cid=<%=groupContext%>"><%=group.getName()%></a></li>
	<%
		}
	%>
</ul>
