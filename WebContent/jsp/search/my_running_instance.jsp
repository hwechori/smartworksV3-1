<%@page import="net.smartworks.model.instance.TaskInstance"%>
<%@page import="net.smartworks.model.instance.WorkInstance"%>
<%@page import="net.smartworks.model.instance.Instance"%>
<%@ page import="net.smartworks.util.SmartUtil"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="net.smartworks.service.ISmartWorks"%>
<%@ page import="net.smartworks.model.work.*"%>
<%
	String companyId = (String) session.getAttribute("companyId");
	String userId = (String) session.getAttribute("userId");

	ISmartWorks smartWorks = (ISmartWorks) request.getAttribute("smartWorks");
	String key = request.getParameter("key");
	Instance[] instances = smartWorks.searchMyRunningInstance(companyId, userId, key);
%>

<ul>
	<%
		if (instances != null) {
			for (Instance instance : instances) {
				String iconType = null;
				String workContext = null;
				String targetContent = null;
				SmartWork work = null;
				WorkInstance workInstance = null;
				if (instance.getClass().equals(WorkInstance.class)) {
					workInstance = (WorkInstance) instance;
					work = (SmartWork) workInstance.getWork();
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
				} else if (instance.getClass().equals(TaskInstance.class)) {
					workInstance = ((TaskInstance) instance).getWorkInstance();
					work = (SmartWork) workInstance.getWork();
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
		}
	%>
</ul>
