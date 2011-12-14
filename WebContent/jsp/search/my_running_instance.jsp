<%@page import="net.smartworks.model.community.User"%>
<%@page import="net.smartworks.model.instance.info.TaskInstanceInfo"%>
<%@page import="net.smartworks.model.work.info.SmartWorkInfo"%>
<%@page import="net.smartworks.model.instance.info.WorkInstanceInfo"%>
<%@page import="net.smartworks.model.instance.info.InstanceInfo"%>
<%@page import="net.smartworks.model.instance.TaskInstance"%>
<%@page import="net.smartworks.model.instance.WorkInstance"%>
<%@page import="net.smartworks.model.instance.Instance"%>
<%@ page import="net.smartworks.util.SmartUtil"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="net.smartworks.service.ISmartWorks"%>
<%@ page import="net.smartworks.model.work.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	User cUser = SmartUtil.getCurrentUser(request, response);

	ISmartWorks smartWorks = (ISmartWorks) request.getAttribute("smartWorks");
	String key = request.getParameter("key");
	InstanceInfo[] instances = smartWorks.searchMyRunningInstance(cUser.getCompanyId(), cUser.getId(), key);
%>
<fmt:setLocale value="<%=cUser.getLocale() %>" scope="request" />
<fmt:setBundle basename="resource.smartworksMessage" scope="request" />

<ul>
	<%
		if (instances != null) {
			for (InstanceInfo instance : instances) {
				String iconType = null;
				String workContext = null;
				String targetContent = null;
				SmartWorkInfo work = null;
				WorkInstanceInfo workInstance = null;
				if (instance.getClass().equals(WorkInstanceInfo.class)) {
					workInstance = (WorkInstanceInfo) instance;
					work = (SmartWorkInfo) workInstance.getWork();
					switch (work.getType()) {
					case SmartWork.TYPE_INFORMATION:
						iconType = "ico_iworks";
						workContext = ISmartWorks.CONTEXT_PREFIX_IWORK_SPACE + workInstance.getId();
						targetContent = "iwork_space.sw";
						break;
					case SmartWork.TYPE_PROCESS:
						iconType = "ico_pworks";
						workContext = ISmartWorks.CONTEXT_PREFIX_PWORK_SPACE + workInstance.getId();
						targetContent = "pwork_space.sw";
						break;
					case SmartWork.TYPE_SCHEDULE:
						iconType = "ico_sworks";
						workContext = ISmartWorks.CONTEXT_PREFIX_SWORK_SPACE + workInstance.getId();
						targetContent = "swork_space.sw";
						break;
					default:
					}
				} else if (instance.getClass().equals(TaskInstanceInfo.class)) {
					workInstance = ((TaskInstanceInfo) instance).getWorkInstance();
					work = (SmartWorkInfo) workInstance.getWork();
					switch (work.getType()) {
					case SmartWork.TYPE_INFORMATION:
						iconType = "ico_iworks";
						workContext = ISmartWorks.CONTEXT_PREFIX_IWORK_TASK + instance.getId();
						targetContent = "iwork_task.sw";
						break;
					case SmartWork.TYPE_PROCESS:
						iconType = "ico_pworks";
						workContext = ISmartWorks.CONTEXT_PREFIX_PWORK_TASK + instance.getId();
						targetContent = "pwork_task.sw";
						break;
					case SmartWork.TYPE_SCHEDULE:
						iconType = "ico_sworks";
						workContext = ISmartWorks.CONTEXT_PREFIX_SWORK_TASK + instance.getId();
						targetContent = "swork_taskz.sw";
						break;
					default:
					}
				}
	%>
	<li><a href="<%=targetContent%>?cid=<%=workContext%>"
		class="js_content"><img class="<%=iconType%>" border="0"><%=work.getFullpathName()%>
			<%=workInstance.getSubject()%></a></li>
	<%
		}
		}else{
			%>
			<li><span><fmt:message key="search.message.no_searched_data"/></span></li>
			<%} %>

</ul>
