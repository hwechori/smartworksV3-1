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
	User cUser = SmartUtil.getCurrentUser();

	ISmartWorks smartWorks = (ISmartWorks) request.getAttribute("smartWorks");
	String key = request.getParameter("key");
	InstanceInfo[] instances = smartWorks.searchMyRunningInstance(key);
%>
<fmt:setLocale value="<%=cUser.getLocale() %>" scope="request" />
<fmt:setBundle basename="resource.smartworksMessage" scope="request" />

<ul>
	<%
	if (instances != null) {
		for (InstanceInfo instance : instances) {
			SmartWorkInfo work = null;
			WorkInstanceInfo workInstance = null;
			if (instance.getClass().equals(WorkInstanceInfo.class)) {
				workInstance = (WorkInstanceInfo) instance;
				work = (SmartWorkInfo) workInstance.getWork();
	%>
				<li>
					<a href="<%=workInstance.getController()%>?cid=<%=workInstance.getContextId()%>" workId="<%=work.getId() %>" class="js_content">
						<img class="<%=work.getIconClass()%>" border="0"><%=work.getFullpathName()%><%=workInstance.getSubject()%>
					</a>
				</li>
			<%
			} else if (instance.getClass().equals(TaskInstanceInfo.class)) {
				TaskInstanceInfo taskInstance = (TaskInstanceInfo)instance;
				workInstance = ((TaskInstanceInfo) instance).getWorkInstance();
				work = (SmartWorkInfo) workInstance.getWork();
			%>
				<li>
					<a href="<%=taskInstance.getController()%>?cid=<%=taskInstance.getContextId()%>" workId="<%=work.getId() %>" taskInstId="<%=taskInstance.getId() %>" class="js_content">
						<img class="<%=work.getIconClass()%>" border="0"><%=work.getFullpathName()%><%=workInstance.getSubject()%>
					</a>
				</li>
	<%
			}
		}
	}else{
	%>
		<li><span><fmt:message key="search.message.no_searched_data"/></span></li>
	<%
	} 
	%>
</ul>
