<%@page import="net.smartworks.model.community.info.UserInfo"%>
<%@ page import="net.smartworks.util.SmartUtil"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="net.smartworks.service.ISmartWorks"%>
<%@ page import="net.smartworks.model.community.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	User cUser = SmartUtil.getCurrentUser();

	ISmartWorks smartWorks = (ISmartWorks) request.getAttribute("smartWorks");
	String key = request.getParameter("key");
	UserInfo[] users = smartWorks.searchUser(key);
%>
<fmt:setLocale value="<%=cUser.getLocale() %>" scope="request" />
<fmt:setBundle basename="resource.smartworksMessage" scope="request" />

<ul>
	<%
		if (users != null) {
			for (UserInfo user : users) {
				String picName = user.getMinPicture();
				String comContext = ISmartWorks.CONTEXT_PREFIX_USER_SPACE + user.getId();
				String comName = user.getLongName();
				String comId = user.getId();
	%>
	<li><a href="" comName="<%=user.getLongName()%>" comId="<%=comId%>"
		class="js_select_community"><img src="<%=picName%>" class="profile_size_s"><%=comName%></a>
	</li>
	<%
		}
		}else{
			%>
			<li><span><fmt:message key="search.message.no_searched_data"/></span></li>
			<%} %>

</ul>
