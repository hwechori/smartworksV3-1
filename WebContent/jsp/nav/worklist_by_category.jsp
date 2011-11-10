<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="net.smartworks.service.ISmartWorks"%>
<%@ page import="net.smartworks.model.work.*"%>

<%
	ISmartWorks smartWorks = (ISmartWorks) request.getAttribute("smartWorks");
	SmartWork[] works = smartWorks.getMyAllWorksByCategoryId(request.getParameter("categoryId"));
	String iconType = null;
	String classType = "js_content";
	String workContext = null;
	String targetContent = null;
%>

<ul>
	<%
		for (SmartWork work : works) {
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
			} else if (work.getType() == SmartWork.TYPE_GROUP) {
				iconType = "ico_gworks";
				targetContent = "swork_list.sw";
			}
			if (work.getType() != SmartWork.TYPE_GROUP) {
	%>
	<li class="<%=iconType%>"><a
		href="<%=targetContent%>?cid=<%=workContext%>" class="<%=classType%>"><%=work.getName()%></a>
	</li>
	<%
		} else {
	%>
	<li class="js_drilling_down <%=iconType%>"><a
		targetContent="worklist_by_group.sw" groupId="<%=work.getId()%>">
			<%=work.getName()%></a>
		<div style="display: none"></div></li>
	<%
		}
	%>
	<%
		}
	%>
</ul>