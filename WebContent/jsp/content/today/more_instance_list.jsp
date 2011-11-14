<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="net.smartworks.model.work.SmartWork"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="net.smartworks.service.ISmartWorks"%>
<%@ page import="net.smartworks.model.calendar.*"%>
<%@ page import="net.smartworks.util.*"%>
<%@ page import="net.smartworks.model.instance.*"%>
<%@ page import="net.smartworks.model.community.*"%>
<%
	ISmartWorks smartWorks = (ISmartWorks) request.getAttribute("smartWorks");
	User cUser = SmartUtil.getCurrentUser();

	Instance[] instances = smartWorks.getMyRunningInstances();
	for (Instance instance : instances) {
		String statusImage;
		String statusTitle;
		WorkInstance workInstance = null;
		TaskInstance taskInstance = null;
		TaskInstance[] assignedTasks = null;
		TaskInstance[] forwardedTasks = null;
		boolean isAssignedTask = false;
		if (instance.getClass().equals(WorkInstance.class)) {
			isAssignedTask = false;
			workInstance = (WorkInstance) instance;

			List<TaskInstance> assignedList = new ArrayList<TaskInstance>();
			List<TaskInstance> forwardedList = new ArrayList<TaskInstance>();
			for (TaskInstance task : workInstance.getTasks()) {
				if ((task.getTaskType() % 10) == 1)
					assignedList.add(task);
				else if ((task.getTaskType() % 10) == 2)
					forwardedList.add(task);
			}
			assignedTasks = (TaskInstance[]) assignedList.toArray(new TaskInstance[0]);
			forwardedTasks = (TaskInstance[]) forwardedList.toArray(new TaskInstance[0]);

		} else if (instance.getClass().equals(TaskInstance.class)) {
			isAssignedTask = true;
			workInstance = ((TaskInstance) instance).getWorkInstance();
			taskInstance = (TaskInstance) instance;
		}
		User owner = workInstance.getOwner();
		SmartWork work = (SmartWork) workInstance.getWork();
		String runningTaskName = "";
		if (taskInstance != null)
			runningTaskName = taskInstance.getName();
		String ownerContextId = ISmartWorks.CONTEXT_PREFIX_USER_SPACE + owner.getId();

		String targetContent, taskContextId, workContextId, workListContextId, workTypeClass;
		switch (work.getType()) {
		case SmartWork.TYPE_INFORMATION:
			workTypeClass = "ico_iworks";
			targetContent = "iwork_";
			taskContextId = ISmartWorks.CONTEXT_PREFIX_IWORK_TASK + ((taskInstance != null) ? taskInstance.getId() : "");
			workContextId = ISmartWorks.CONTEXT_PREFIX_IWORK_SPACE + workInstance.getId();
			workListContextId = ISmartWorks.CONTEXT_PREFIX_IWORK_LIST + work.getId();
			break;
		case SmartWork.TYPE_PROCESS:
			workTypeClass = "ico_pworks";
			targetContent = "pwork_";
			taskContextId = ISmartWorks.CONTEXT_PREFIX_PWORK_TASK + ((taskInstance != null) ? taskInstance.getId() : "");
			workContextId = ISmartWorks.CONTEXT_PREFIX_PWORK_SPACE + workInstance.getId();
			workListContextId = ISmartWorks.CONTEXT_PREFIX_PWORK_LIST + work.getId();
			break;
		case SmartWork.TYPE_SCHEDULE:
			workTypeClass = "ico_sworks";
			targetContent = "swork_";
			taskContextId = ISmartWorks.CONTEXT_PREFIX_SWORK_TASK + ((taskInstance != null) ? taskInstance.getId() : "");
			workContextId = ISmartWorks.CONTEXT_PREFIX_SWORK_SPACE + workInstance.getId();
			workListContextId = ISmartWorks.CONTEXT_PREFIX_SWORK_LIST + work.getId();
			break;
		default:
			workTypeClass = "";
			targetContent = "";
			taskContextId = "";
			workContextId = "";
			workListContextId = "";
			break;
		}

		if (isAssignedTask) {
			switch (taskInstance.getStatus()) {
			case Instance.STATUS_RUNNING:
				statusImage = "images/ic_state_ing.jpg";
				statusTitle = "content.status.running";
				break;
			case Instance.STATUS_DELAYED_RUNNING:
				statusImage = "images/ic_state_ing.jpg";
				statusTitle = "content.status.delayed_running";
				break;
			case Instance.STATUS_RETURNED:
				statusImage = "images/ic_state_ing.jpg";
				statusTitle = "content.status.returned";
				break;
			case Instance.STATUS_RETURNED_DELAYED:
				statusImage = "images/ic_state_ing.jpg";
				statusTitle = "content.status.returned_delayed";
				break;
			default:
				statusImage = "images/ic_state_ing.jpg";
				statusTitle = "content.status.running";
			}
		} else {
			statusImage = "images/ic_state_ing.jpg";
			statusTitle = "content.status.running";
		}
%>
<fmt:setLocale value="<%=cUser.getLocale() %>" scope="request" />
<fmt:setBundle basename="resource.smartworksMessage" scope="request" />

<li class="working_br">
	<div class="pic">
		<img src="<%=statusImage%>"
			title="<fmt:message key='<%=statusTitle%>'/>" /> <a
			href="user_space.sw?cid=<%=ownerContextId%>"><img
			src="<%=owner.getMidPicture()%>" title="<%=owner.getLongName()%>" />
		</a>
	</div>
	<div>
		<a href="user_space.sw?cid=<%=ownerContextId%>"><span
			class="t_name"><%=owner.getLongName()%></span> </a>
		<%
			if (!workInstance.getWorkSpace().getId().equals(owner.getId())) {
					WorkSpace workSpace = workInstance.getWorkSpace();
					String spaceContent = "";
					String commContext = "";
					if (workSpace.getClass().equals(Group.class)) {
						targetContent = "group_space.sw";
						commContext = ISmartWorks.CONTEXT_PREFIX_GROUP_SPACE + workSpace.getId();
					} else if (workSpace.getClass().equals(Department.class)) {
						targetContent = "department_space.sw";
						commContext = ISmartWorks.CONTEXT_PREFIX_DEPARTMENT_SPACE + workSpace.getId();
					}
		%>
		<span class="arr">▶</span><a
			href="<%=spaceContent%>?cid=<%=commContext%>"><span
			class="ico_division_s"><%=workSpace.getName()%></span> </a>
		<%
			}
		%>
		<%
			if (isAssignedTask) {
		%>
		<%
			switch (taskInstance.getTaskType()) {
					case TaskInstance.TYPE_INFORMATION_TASK_ASSIGNED:
		%><fmt:message key="content.sentence.itask_assigned">
			<fmt:param>
				<a
					href='<%=targetContent%>task.sw?cid=<%=taskContextId%>&wid=<%=workInstance.getWorkSpace().getId()%>'><span
					class='t_woname'><%=runningTaskName%></span> </a>
			</fmt:param>
		</fmt:message>
		<%
			break;
					case TaskInstance.TYPE_INFORMATION_TASK_FORWARDED:
		%>
		<fmt:message key="content.sentence.itask_forwarded">
			<fmt:param>
				<a
					href="<%=targetContent%>task.sw?cid=<%=taskContextId%>&wid=<%=workInstance.getWorkSpace().getId()%>"><span
					class="t_woname"><%=runningTaskName%></span> </a>
			</fmt:param>
		</fmt:message>
		<%
			break;
					case TaskInstance.TYPE_PROCESS_TASK_ASSIGNED:
		%>
		<fmt:message key="content.sentence.ptask_assigned">
			<fmt:param>
				<a
					href="<%=targetContent%>task.sw?cid=<%=taskContextId%>&wid=<%=workInstance.getWorkSpace().getId()%>"><span
					class="t_woname"><%=runningTaskName%></span> </a>
			</fmt:param>
		</fmt:message>
		<%
			break;
					case TaskInstance.TYPE_PROCESS_TASK_FORWARDED:
		%>
		<fmt:message key="content.sentence.ptask_forwarded">
			<fmt:param>
				<a
					href="<%=targetContent%>task.sw?cid=<%=taskContextId%>&wid=<%=workInstance.getWorkSpace().getId()%>"><span
					class="t_woname"><%=runningTaskName%></span> </a>
			</fmt:param>
		</fmt:message>
		<%
			break;
					case TaskInstance.TYPE_SCHEDULE_TASK_ASSIGNED:
		%>
		<fmt:message key="content.sentence.stask_assigned">
			<fmt:param>
				<a
					href="<%=targetContent%>task.sw?cid=<%=taskContextId%>&wid=<%=workInstance.getWorkSpace().getId()%>"><span
					class="t_woname"><%=runningTaskName%></span> </a>
			</fmt:param>
		</fmt:message>
		<%
			break;
					case TaskInstance.TYPE_SCHEDULE_TASK_FORWARDED:
		%>
		<fmt:message key="content.sentence.stask_forwarded">
			<fmt:param>
				<a
					href="<%=targetContent%>task.sw?cid=<%=taskContextId%>&wid=<%=workInstance.getWorkSpace().getId()%>"><span
					class="t_woname"><%=runningTaskName%></span> </a>
			</fmt:param>
		</fmt:message>
		<%
			break;
					case TaskInstance.TYPE_APPROVAL_TASK_ASSIGNED:
		%>
		<fmt:message key="content.sentence.stask_forwarded">
			<fmt:param>
				<a
					href="<%=targetContent%>task.sw?cid=<%=taskContextId%>&wid=<%=workInstance.getWorkSpace().getId()%>"><span
					class="t_woname"><%=runningTaskName%></span> </a>
			</fmt:param>
		</fmt:message>
		<%
			break;
					case TaskInstance.TYPE_APPROVAL_TASK_FORWARDED:
		%>
		<fmt:message key="content.sentence.stask_forwarded">
			<fmt:param>
				<a
					href="<%=targetContent%>task.sw?cid=<%=taskContextId%>&wid=<%=workInstance.getWorkSpace().getId()%>"><span
					class="t_woname"><%=runningTaskName%></span> </a>
			</fmt:param>
		</fmt:message>
		<%
			break;
					default:
						break;
					}
				} else {
					if (assignedTasks != null) {
		%>
		<fmt:message key="content.sentence.users_work_is" />
		<%
			boolean firstRun = true;
						for (TaskInstance assignedTask : assignedTasks) {
							User assignee = assignedTask.getAssignee();
							String userContextId = ISmartWorks.CONTEXT_PREFIX_USER_SPACE + assignee.getId();
							String assignedContextId = taskContextId + assignee.getId();
							runningTaskName = assignedTask.getName();
							if (firstRun) {
								firstRun = false;
							} else {
		%>,
		<%
			}
		%>
		<fmt:message key="content.sentence.task_by_assignee">
			<fmt:param>
				<a href="user_space.sw?cid=<%=userContextId%>"
					title="<%=assignee.getLongName()%>"><span class="t_name"><%=assignee.getName()%></span>
				</a>
			</fmt:param>
			<fmt:param>
				<a
					href="<%=targetContent%>task.sw?cid=<%=assignedContextId%>&wid=<%=workInstance.getWorkSpace().getId()%>"><span
					class="t_woname"><%=runningTaskName%></span> </a>
			</fmt:param>
		</fmt:message>
		<%
			}
		%>
		<fmt:message key="content.sentence.task_is_running" />
		<%
			}
					if (forwardedTasks != null) {
						User forwardee = forwardedTasks[0].getAssignee();
						String userContextId = ISmartWorks.CONTEXT_PREFIX_USER_SPACE + forwardee.getId();
						String forwardedContextId = taskContextId + forwardee.getId();
						runningTaskName = forwardedTasks[0].getName();
						if(assignedTasks != null){
		%>
		<fmt:message key="content.sentence.and_also"/>
		<%					
						}else{
		%>
		<fmt:message key="content.sentence.forwarded_work_is"/>
		<%
						}
		%>
		<fmt:message key="content.sentence.and_user">
			<fmt:param>
				<a href="user_space.sw?cid=<%=userContextId%>"
					title="<%=forwardee.getLongName()%>"><span class="t_name"><%=forwardee.getName()%></span>
				</a>
			</fmt:param>
		</fmt:message>
		<%
			if (forwardedTasks.length > 1) {
		%>
		<fmt:message key="content.sentence.with_other_users">
			<fmt:param><%=forwardedTasks.length - 1%></fmt:param>
		</fmt:message>
		<%
			}
		%>
		<fmt:message key="content.sentence.on_forwarded_task" />
		<%
			}
				}
		%>
	</div>
	<div>
		<a
			href="<%=targetContent%>list.sw?cid=<%=workListContextId%>&wid=<%=cUser.getId()%>"><span
			class="<%=workTypeClass%> t_date"><%=work.getFullpathName()%></span>
		</a> <a
			href="<%=targetContent%>space.sw?cid=<%=workContextId%>&wid=<%=workInstance.getWorkSpace().getId()%>"><span
			class="t_bold"><%=workInstance.getSubject()%></span> </a>
	</div>
	<div>
		<span class="t_date"><%=workInstance.getLastModifiedDate().toLocalString()%></span>
	</div></li>
<%
	}
%>