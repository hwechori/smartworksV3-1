<%@page import="net.smartworks.util.SmartUtil"%>
<%@page import="net.smartworks.model.community.User"%>
<%@page import="net.smartworks.model.work.info.SmartWorkInfo"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="net.smartworks.service.ISmartWorks"%>
<%@ page import="net.smartworks.model.work.*"%>
<%
	ISmartWorks smartWorks = (ISmartWorks) request.getAttribute("smartWorks");
	SmartWorkInfo[] works = smartWorks.getMyFavoriteWorks();
	String iconType = null;
	String classType = "js_content";
	String workContext = null;
	String targetContent = null;
%>

<ul>
	<%
		if (works != null) {
			for (SmartWorkInfo work : works) {
				if (work.getType() == SmartWork.TYPE_PROCESS) {
					iconType = "ico_pworks";
					workContext = ISmartWorks.CONTEXT_PREFIX_PWORK_LIST + work.getId();
					targetContent = "pwork_list.sw";
				} else if (work.getType() == SmartWork.TYPE_INFORMATION) {
					iconType = "ico_iworks";
					workContext = ISmartWorks.CONTEXT_PREFIX_IWORK_LIST + work.getId();
					targetContent = "iwork_list.sw";//"information_work_list.sw";
				} else if (work.getType() == SmartWork.TYPE_SCHEDULE) {
					iconType = "ico_sworks";
					workContext = ISmartWorks.CONTEXT_PREFIX_SWORK_LIST + work.getId();
					targetContent = "swork_list.sw";//"schedule_work_list.sw";
				}
	%>
	<li>
	<a href="<%=targetContent%>?cid=<%=workContext%>" 
		title="<%=work.getFullpathName()%>">
		<span class="<%=iconType%> <%=classType%>"></span>
		<span><%=work.getName()%></span>
		</a>
	</li>
	<%
		}
		}
	%>
</ul>