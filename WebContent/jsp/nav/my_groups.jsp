<%@page import="net.smartworks.util.SmartUtil"%>
<%@page import="net.smartworks.model.community.info.GroupInfo"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="net.smartworks.service.ISmartWorks"%>
<%@ page import="net.smartworks.model.community.*"%>
<%
	User cUser = SmartUtil.getCurrentUser(request, response);

	ISmartWorks smartWorks = (ISmartWorks) request.getAttribute("smartWorks");
	GroupInfo[] groups = smartWorks.getMyGroups(cUser.getCompanyId(), cUser.getId());
%>

<ul>
	<%
		if (groups != null) {
			for (GroupInfo group : groups) {
				String groupContext = ISmartWorks.CONTEXT_PREFIX_GROUP_SPACE + group.getId();
	%>
	<li><a
		href="group_space.sw?cid=<%=groupContext%>" title="<%=group.getDesc()%>">
			<span class="ico_pe"><img src="<%=group.getMinPicture()%>" width="20" height="20" border="0"></span> 
			<span class="nav_subtitl_area"><%=group.getName()%></span></a>
	</li>
	<%
		}
		}
	%>
</ul>
