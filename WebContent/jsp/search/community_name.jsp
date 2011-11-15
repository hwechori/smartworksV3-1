<%@ page import="net.smartworks.util.SmartUtil"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="net.smartworks.service.ISmartWorks"%>
<%@ page import="net.smartworks.model.community.*"%>
<%
	ISmartWorks smartWorks = (ISmartWorks) request.getAttribute("smartWorks");
	String key = request.getParameter("key");
	WorkSpace[] communities = smartWorks.searchCommunity(key);
%>

<ul>
	<%
		for (Community community : communities) {
			String picName = community.getMinPicture();
			String comContext = ISmartWorks.CONTEXT_PREFIX_USER_SPACE + community.getId();
			String comName = null;
			if(community.getClass().equals(User.class)) comName = ((User)community).getLongName();
			else comName = community.getName();
			String comId = community.getId();
	%>
	<li><a href="" comName="<%=comName%>" comId="<%=comId %>" class="js_select_community"><img src="<%=picName%>"><%=comName%></a>
	</li>
	<%
		}
	%>
</ul>
