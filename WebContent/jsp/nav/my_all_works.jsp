<%@page import="net.smartworks.model.work.info.WorkInfo"%>
<%@page import="net.smartworks.util.SmartUtil"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="net.smartworks.service.ISmartWorks"%>
<%@ page import="net.smartworks.model.work.*"%>

<%
	String companyId = (String) session.getAttribute("companyId");
	String userId = (String) session.getAttribute("userId");
	
	ISmartWorks smartWorks = (ISmartWorks) request.getAttribute("smartWorks");
	WorkInfo[] workCategories = smartWorks.getMyAllWorksByCategoryId(companyId, userId, "");
%>

<ul>
	<%
		if(workCategories != null){
			for (WorkInfo workCategory : workCategories) {
	%>
	<li class="js_drill_down ico_cworks"><a
		targetContent="worklist_by_category.sw"
		categoryId="<%=workCategory.getId()%>"> <%=workCategory.getName()%></a>
		<div style="display: none"></div></li>
	<%
			}
		}
	%>
</ul>
