<%@page import="net.smartworks.model.community.info.UserInfo"%>
<%@ page import="net.smartworks.util.SmartUtil"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="net.smartworks.service.ISmartWorks"%>
<%@ page import="net.smartworks.model.community.*"%>
<%
	String companyId = (String) session.getAttribute("companyId");
	String userId = (String) session.getAttribute("userId");

	ISmartWorks smartWorks = (ISmartWorks) request.getAttribute("smartWorks");
	String key = request.getParameter("key");
	String communityId = request.getParameter("communityId");
	UserInfo[] users = smartWorks.searchCommunityMember(companyId, communityId, key);
%>

<ul>
	<%
		if(users != null){
			for (UserInfo user : users) {
				String picName = user.getMinPicture();
				String comContext = ISmartWorks.CONTEXT_PREFIX_USER_SPACE + user.getId();
				String targetContent = "user_space.sw";
				String comName = user.getName();
				String comId = user.getId();
	%>	
	<li><a href="<%=targetContent%>?cid=<%=comContext%>&wid=<%=comId%>"><img src="<%=picName%>" border="0"><%=comName%></a>
	</li>
	<%
			}
		}
	%>
</ul>
