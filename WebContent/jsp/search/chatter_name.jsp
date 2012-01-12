<%@page import="net.smartworks.model.community.info.UserInfo"%>
<%@page import="net.smartworks.model.community.info.CommunityInfo"%>
<%@page import="net.smartworks.model.community.info.WorkSpaceInfo"%>
<%@ page import="net.smartworks.util.SmartUtil"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="net.smartworks.service.ISmartWorks"%>
<%@ page import="net.smartworks.model.community.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	User cUser = SmartUtil.getCurrentUser();

	ISmartWorks smartWorks = (ISmartWorks) request.getAttribute("smartWorks");
	String key = request.getParameter("key");
	WorkSpaceInfo[] communities = smartWorks.searchCommunity(key);
%>
<fmt:setLocale value="<%=cUser.getLocale() %>" scope="request" />
<fmt:setBundle basename="resource.smartworksMessage" scope="request" />

<ul>
	<%
		if(communities != null){
			for (CommunityInfo community : communities) {
				if(!community.getClass().equals(UserInfo.class)) continue;
				String picName = community.getMinPicture();
				String comContext = ISmartWorks.CONTEXT_PREFIX_USER_SPACE + community.getId();
				String comName = null;
				if(community.getClass().equals(UserInfo.class)) comName = ((UserInfo)community).getLongName();
				else comName = community.getName();
				String comId = community.getId();
	%>
	<li><a href="" comName="<%=comName %>" comId="<%=comId %>" class="js_select_chatter"><img class="space_r2 profile_size_s" src="<%=picName%>"> <%=comName %></a>
	</li>
	<%
			}
		}else{
			%>
			<li><span><fmt:message key="search.message.no_searched_data"/></span></li>
			<%} %>

</ul>

