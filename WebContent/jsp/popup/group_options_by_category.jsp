<%@page import="net.smartworks.util.SmartUtil"%>
<%@page import="net.smartworks.model.community.User"%>
<%@page import="net.smartworks.model.work.info.WorkInfo"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="net.smartworks.service.ISmartWorks"%>
<%@ page import="net.smartworks.model.work.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	ISmartWorks smartWorks = (ISmartWorks) request.getAttribute("smartWorks");
	User cUser = SmartUtil.getCurrentUser();

	WorkInfo[] groups = smartWorks.getMyAllWorksByCategoryId(request.getParameter("categoryId"));
%>
<!--  다국어 지원을 위해, 로케일 및 다국어 resource bundle 을 설정 한다. -->
<fmt:setLocale value="<%=cUser.getLocale() %>" scope="request" />
<fmt:setBundle basename="resource.smartworksMessage" scope="request" />

<option><fmt:message key="common.title.none"/></option>
<%
if(!SmartUtil.isBlankObject(groups)){
	for(WorkInfo group : groups){
		if(group.getType() != WorkCategory.TYPE_CATEGORY) continue;
%>
		<option value="<%=group.getId() %>"><%=group.getName() %></option>
<%
	}
}
%>
