<%@page import="net.smartworks.model.community.info.GroupInfo"%>
<%@page import="net.smartworks.model.community.info.DepartmentInfo"%>
<%@page import="net.smartworks.model.community.info.UserInfo"%>
<%@page import="net.smartworks.model.community.info.WorkSpaceInfo"%>
<%@page import="net.smartworks.util.SmartUtil"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="net.smartworks.service.ISmartWorks"%>
<%@ page import="net.smartworks.model.community.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	User cUser = SmartUtil.getCurrentUser(request, response);

	ISmartWorks smartWorks = (ISmartWorks) request.getAttribute("smartWorks");
	String key = request.getParameter("key");
	WorkSpaceInfo[] communities = smartWorks.searchCommunity(cUser.getCompanyId(), cUser.getId(), key);
%>
<fmt:setLocale value="<%=cUser.getLocale() %>" scope="request" />
<fmt:setBundle basename="resource.smartworksMessage" scope="request" />

<ul>
	<%
		if (communities != null) {
			for (WorkSpaceInfo workSpace : communities) {
				String picName = null, comContext = null, targetContent = null, comName = null, comId = null;
				if (workSpace.getClass() == UserInfo.class) {
					UserInfo user = (UserInfo) workSpace;
					picName = user.getMinPicture();
					comContext = ISmartWorks.CONTEXT_PREFIX_USER_SPACE + user.getId();
					targetContent = "user_space.sw";
					comName = user.getName();
					comId = user.getId();
				} else if (workSpace.getClass() == DepartmentInfo.class) {
					DepartmentInfo depart = (DepartmentInfo) workSpace;
					picName = depart.getMinPicture();
					comContext = ISmartWorks.CONTEXT_PREFIX_DEPARTMENT_SPACE + depart.getId();
					targetContent = "department_space.sw";
					comName = depart.getName();
					comId = depart.getId();
				} else if (workSpace.getClass() == GroupInfo.class) {
					GroupInfo group = (GroupInfo) workSpace;
					picName = group.getMinPicture();
					comContext = ISmartWorks.CONTEXT_PREFIX_GROUP_SPACE + group.getId();
					targetContent = "group_space.sw";
					comName = group.getName();
					comId = group.getId();
				}
	%>
	<li><img src="<%=picName%>" border="0"><a
		href="<%=targetContent%>?cid=<%=comContext%>&wid=<%=comId%>"><%=comName%></a>
	</li>
	<%
		}
		}else{
			%>
			<li><span><fmt:message key="search.message.no_searched_data"/></span></li>
			<%} %>

</ul>
