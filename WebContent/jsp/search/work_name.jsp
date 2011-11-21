<%@page import="net.smartworks.model.work.info.SmartWorkInfo"%>
<%@ page import="net.smartworks.util.SmartUtil"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="net.smartworks.service.ISmartWorks"%>
<%@ page import="net.smartworks.model.work.*"%>
<%
	String companyId = (String) session.getAttribute("companyId");
	String userId = (String) session.getAttribute("userId");

	ISmartWorks smartWorks = (ISmartWorks) request.getAttribute("smartWorks");
	String key = request.getParameter("key");
	SmartWorkInfo[] works = smartWorks.searchWork(companyId, userId, key);
%>

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
	<li class="<%=iconType%>"><a
		href="<%=targetContent%>?workId=<%=work.getId()%>"
		class="js_select_work"><%=work.getFullpathName()%></a></li>
	<%
		}
		}
	%>
</ul>