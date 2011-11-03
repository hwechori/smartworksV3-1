<%@ page import="net.smartworks.util.SmartUtil"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="net.smartworks.service.ISmartWorks"%>
<%@ page import="net.smartworks.model.work.*"%>
<%
	ISmartWorks smartWorks = (ISmartWorks) request.getAttribute("smartWorks");
	String key = request.getParameter("key");
	SmartWork[] works = smartWorks.searchWorkList(SmartUtil.getCurrentUser().getId(), key);
%>

<ul>
	<%
		for (SmartWork work : works) {
			String iconType = null;
			String workContext = null;
			String targetContent = null;
			switch(work.getType()){
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
		href="<%=targetContent%>?key=<%=work.getId() %>" class="js_select_work"><%=work.getFullpathName()%></a>
	</li>
	<%
		}
	%>
</ul>
