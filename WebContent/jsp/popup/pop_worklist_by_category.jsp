<%@page import="net.smartworks.util.SmartUtil"%>
<%@page import="net.smartworks.model.community.User"%>
<%@page import="net.smartworks.model.work.info.WorkInfo"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="net.smartworks.service.ISmartWorks"%>
<%@ page import="net.smartworks.model.work.*"%>
<%
	ISmartWorks smartWorks = (ISmartWorks) request.getAttribute("smartWorks");
	WorkInfo[] works = smartWorks.getMyAllWorksByCategoryId(request.getParameter("categoryId"));
	String iconType = null;
	String classType = "js_pop_select_work";
	String targetContent = null;
%>

<ul>
	<%
		if (works != null) {
			for (WorkInfo work : works) {
				if (work.getType() == SmartWork.TYPE_PROCESS) {
					iconType = "ico_pworks";
					targetContent = "start_pwork.sw";
				} else if (work.getType() == SmartWork.TYPE_INFORMATION) {
					iconType = "ico_iworks";
					targetContent = "new_iwork.sw";
				} else if (work.getType() == SmartWork.TYPE_SCHEDULE) {
					iconType = "ico_sworks";
					targetContent = "plan_swork.sw";
				} else if (work.getType() == WorkCategory.TYPE_CATEGORY) {
					iconType = "ico_gworks";
					targetContent = "pop_worklist_by_category.sw";
				}
				if (work.getType() != WorkCategory.TYPE_CATEGORY) {
	%>
	<li><a href="<%=targetContent%>?workId=<%=work.getId()%>" class="<%=classType%>" workId="<%=work.getId()%>"><span class="<%=iconType%>"></span><%=work.getName()%></a>
	</li>
	<%
		} else {
	%>
	<li class="js_drill_down"><a href="<%=targetContent%>" categoryId="<%=work.getId()%>"><span class="<%=iconType%>"></span>
			<span><%=work.getName()%></span></a>
		<div style="display: none" class="menu_2dep"></div></li>
	<%
		}
	%>
	<%
		}
		}
	%>
</ul>