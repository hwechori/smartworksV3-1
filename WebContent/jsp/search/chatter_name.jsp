<%@page import="net.smartworks.model.community.info.UserInfo"%>
<%@page import="net.smartworks.model.community.info.CommunityInfo"%>
<%@page import="net.smartworks.model.community.info.WorkSpaceInfo"%>
<%@ page import="net.smartworks.util.SmartUtil"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="net.smartworks.service.ISmartWorks"%>
<%@ page import="net.smartworks.model.community.*"%>
<%
	User cUser = SmartUtil.getCurrentUser(request, response);

	ISmartWorks smartWorks = (ISmartWorks) request.getAttribute("smartWorks");
	String key = request.getParameter("key");
	WorkSpaceInfo[] communities = smartWorks.searchCommunity(cUser.getCompanyId(), cUser.getId(), key);
%>

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
	<li><a href="" comName="<%=comName%>" comId="<%=comId %>" class="js_select_chatter"><img src="<%=picName%>"><%=comName%></a>
	</li>
	<%
			}
		}
	%>
</ul>

