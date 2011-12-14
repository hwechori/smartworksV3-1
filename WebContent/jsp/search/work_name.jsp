<%@page import="net.smartworks.model.community.User"%>
<%@page import="net.smartworks.model.work.info.SmartWorkInfo"%>
<%@ page import="net.smartworks.util.SmartUtil"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="net.smartworks.service.ISmartWorks"%>
<%@ page import="net.smartworks.model.work.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	User cUser = SmartUtil.getCurrentUser(request, response);

	ISmartWorks smartWorks = (ISmartWorks) request.getAttribute("smartWorks");
	String key = request.getParameter("key");
	SmartWorkInfo[] works = smartWorks.searchWork(cUser.getCompanyId(), cUser.getId(), key);
%>
<fmt:setLocale value="<%=cUser.getLocale() %>" scope="request" />
<fmt:setBundle basename="resource.smartworksMessage" scope="request" />

<ul>
	<%
		if (works != null) {
			for (SmartWorkInfo work : works) {
				String iconType = null;
				String workContext = null;
				String targetContent = null;
				switch (work.getType()) {
				case SmartWork.TYPE_PROCESS:
					iconType = "ico_pworks";
					targetContent = "start_pwork.sw";
					break;
				case SmartWork.TYPE_INFORMATION:
					iconType = "ico_iworks";
					targetContent = "new_iwork.sw";
					break;
				case SmartWork.TYPE_SCHEDULE:
					iconType = "ico_sworks";
					targetContent = "plan_swork.sw";
					break;
				}
	%>
	<li>
	<a href="<%=targetContent%>?workId=<%=work.getId()%>" class="js_select_work">
		<span class="<%=iconType%>"></span>
		<span class="nav_subtitl_area"><%=work.getFullpathName()%></span>
	</a>
	</li>
	<%
		}
		}else{
			%>
			<li><span><fmt:message key="search.message.no_searched_data"/></span></li>
			<%} %>

</ul>