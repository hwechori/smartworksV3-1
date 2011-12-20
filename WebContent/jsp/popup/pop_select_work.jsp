<%@page import="net.smartworks.model.community.User"%>
<%@page import="net.smartworks.model.work.info.WorkInfo"%>
<%@page import="net.smartworks.util.SmartUtil"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="net.smartworks.service.ISmartWorks"%>
<%@ page import="net.smartworks.model.work.*"%>
<%
	ISmartWorks smartWorks = (ISmartWorks) request.getAttribute("smartWorks");
	WorkInfo[] workCategories = smartWorks.getMyAllWorksByCategoryId("");
%>

<ul>
	<%
		if(workCategories != null){
			for (WorkInfo workCategory : workCategories) {
	%>
	<li class="js_drill_down"><a href="worklist_by_category.sw"
		categoryId="<%=workCategory.getId()%>"> <span class="ico_cworks"></span>
			<span class="nav_subtitl_area"><%=workCategory.getName()%></span> </a>
		<div class="menu_2dep" style="display: none"></div>
	</li>
	<%
			}
		}
	%>
</ul>
