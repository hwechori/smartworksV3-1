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
	String classType = "js_content";
	String workContext = null;
	String targetContent = null;
%>

<ul>
	<%
		if (works != null) {
			for (WorkInfo work : works) {
				if (work.getType() == SmartWork.TYPE_PROCESS) {
					iconType = "ico_pworks";
					workContext = ISmartWorks.CONTEXT_PREFIX_PWORK_LIST + work.getId();
					targetContent = "pwork_list.sw";
				} else if (work.getType() == SmartWork.TYPE_INFORMATION) {
					iconType = "ico_iworks";
					workContext = ISmartWorks.CONTEXT_PREFIX_IWORK_LIST + work.getId();
					targetContent = "iwork_list.sw";
				} else if (work.getType() == SmartWork.TYPE_SCHEDULE) {
					iconType = "ico_sworks";
					workContext = ISmartWorks.CONTEXT_PREFIX_SWORK_LIST + work.getId();
					targetContent = "swork_list.sw";
				} else if (work.getType() == WorkCategory.TYPE_CATEGORY) {
					iconType = "ico_gworks";
					targetContent = "worklist_by_group.sw";
				}
				if (work.getType() != WorkCategory.TYPE_CATEGORY) {
	%>
	<li><a
		href="<%=targetContent%>?cid=<%=workContext%>" class="<%=classType%>">
		<span class="<%=iconType%>"></span>
		<%=work.getName()%></a>
	</li>
	<%
		} else {
	%>
	<li class="js_drill_down"><a
		href="worklist_by_group.sw" groupId="<%=work.getId()%>"><span class="<%=iconType%>"></span>
			<span><%=work.getName()%></span></a>
		<div style="display: none"></div></li>
	<%
		}
	%>
	<%
		}
		}
	%>
</ul>