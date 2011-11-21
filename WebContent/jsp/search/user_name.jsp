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
	UserInfo[] users = smartWorks.searchUser(companyId, key);
%>

<ul>
	<%
		if (users != null) {
			for (UserInfo user : users) {
				String picName = user.getMinPicture();
				String comContext = ISmartWorks.CONTEXT_PREFIX_USER_SPACE + user.getId();
				String comName = user.getName();
				String comId = user.getId();
	%>
	<li><a href="" uname="<%=user.getLongName()%>" uid="<%=comId%>"
		class="js_select_user"><img src="<%=picName%>"><%=comName%></a>
	</li>
	<%
		}
		}
	%>
</ul>
