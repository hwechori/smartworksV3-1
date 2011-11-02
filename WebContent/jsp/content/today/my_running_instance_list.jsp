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
%>

<!-- 나의 진행중인 업무 -->
<div id="section_portlet">
	<div class="portlet_t">
		<div class="portlet_tl"></div>
	</div>
	<div class="portlet_l" style="display: block;">
		<ul class="portlet_r" style="display: block;">
			<div id="work_ing">
				<ul>
					<li><span class="tit"><fmt:message
								key="content.my_running_instance_list" /></span>
					<li class="nav_srch">
						<div class="srch">
							<input id="" class="input js_auto_complete" type="text"
								title="<fmt:message key="search.search_running_instance"/>"
								placeholder="<fmt:message key="search.search_running_instance"/>"
								href="running_instance_list.sw">
							<button title="<fmt:message key='search.search'/>" onclick=""></button>
						</div>
						<div style="display: none"></div>
					</li>
					<%
					for(Instance instance : instances){
						String statusImage;
						String statusTitle;
						WorkInstance workInstance=null;
						TaskInstance taskInstance=null;
						if(instance.getClass().equals(WorkInstance.class)){
							workInstance = (WorkInstance)instance;
							taskInstance = workInstance.getRunningTask();
						}else if(instance.getClass().equals(TaskInstance.class)){
							workInstance = ((TaskInstance)instance).getWorkInstance();
							taskInstance = (TaskInstance)instance;
						}
						User owner = workInstance.getOwner();
						SmartWork work = (SmartWork)workInstance.getWork();
						String runningTaskName = "";
						if(workInstance.getRunningTask()!=null) runningTaskName = workInstance.getRunningTask().getName();
						String ownerContextId = ISmartWorks.CONTEXT_PREFIX_USER_SPACE + owner.getId();

						String targetContent, taskContextId, workContextId, workListContextId, workTypeClass;
						switch(work.getType()){
							case SmartWork.TYPE_INFORMATION:
								workTypeClass = "ico_iworks";
								targetContent = "iwork_";
								taskContextId = ISmartWorks.CONTEXT_PREFIX_IWORK_TASK + taskInstance.getId();
								workContextId = ISmartWorks.CONTEXT_PREFIX_IWORK_SPACE + workInstance.getId();
								workListContextId = ISmartWorks.CONTEXT_PREFIX_IWORK_LIST + work.getId();
								break;
							case SmartWork.TYPE_PROCESS:
								workTypeClass = "ico_pworks";
								targetContent = "pwork_";
								taskContextId = ISmartWorks.CONTEXT_PREFIX_PWORK_TASK + taskInstance.getId();
								workContextId = ISmartWorks.CONTEXT_PREFIX_PWORK_SPACE + workInstance.getId();
								workListContextId = ISmartWorks.CONTEXT_PREFIX_PWORK_LIST + work.getId();
								break;
							case SmartWork.TYPE_SCHEDULE:
								workTypeClass = "ico_sworks";
								targetContent = "swork_";
								taskContextId = ISmartWorks.CONTEXT_PREFIX_SWORK_TASK + taskInstance.getId();
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

						switch(taskInstance.getStatus()){
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
						%>
					<li class="working_br">
						<div class="pic">
							<img src="<%=statusImage %>" title="<fmt:message key='<%=statusTitle%>'/>" />
							<a href="user_space.sw?cid=<%=ownerContextId%>"><img
								src="<%=owner.getMidPicture()%>" title="<%=owner.getLongName() %>" /></a>
						</div>
						<div>
							<a href="user_space.sw?cid=<%=ownerContextId%>"><span class="t_name"><%=owner.getLongName()%></span></a>
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
						switch(taskInstance.getTaskType()){
						case TaskInstance.INFORMATION_TASK_ASSIGNED:
						%>
							의 업무가 
							<a href="<%=targetContent%>task.sw?cid=<%=taskContextId%>&wid=<%=workInstance.getWorkSpace().getId()%>"><span
								class="t_woname"><%=runningTaskName%></span></a>을 기다리고 있습니다
						<%
							break;
						case TaskInstance.INFORMATION_TASK_FORWARDED:
						%>
							의 업무가 
							<a href="<%=targetContent%>task.sw?cid=<%=taskContextId%>&wid=<%=workInstance.getWorkSpace().getId()%>"><span
								class="t_woname"><%=runningTaskName%></span></a>을 기다리고 있습니다
						<%
							break;
						case TaskInstance.PROCESS_TASK_ASSIGNED:
						%>
							의 업무가 
							<a href="<%=targetContent%>task.sw?cid=<%=taskContextId%>&wid=<%=workInstance.getWorkSpace().getId()%>"><span
								class="t_woname"><%=runningTaskName%></span></a>을 기다리고 있습니다
						<%
							break;
						case TaskInstance.PROCESS_TASK_FORWARDED:
						%>
							의 업무가 
							<a href="<%=targetContent%>task.sw?cid=<%=taskContextId%>&wid=<%=workInstance.getWorkSpace().getId()%>"><span
								class="t_woname"><%=runningTaskName%></span></a>을 기다리고 있습니다
						<%
							break;
						case TaskInstance.SCHEDULE_TASK_ASSIGNED:
						%>
							의 업무가 
							<a href="<%=targetContent%>task.sw?cid=<%=taskContextId%>&wid=<%=workInstance.getWorkSpace().getId()%>"><span
								class="t_woname"><%=runningTaskName%></span></a>을 기다리고 있습니다
						<%
							break;
						case TaskInstance.SCHEDULE_TASK_FORWARDED:
						%>
							의 업무가 
							<a href="<%=targetContent%>task.sw?cid=<%=taskContextId%>&wid=<%=workInstance.getWorkSpace().getId()%>"><span
								class="t_woname"><%=runningTaskName%></span></a>을 기다리고 있습니다
						<%
							break;
						case TaskInstance.APPROVAL_TASK_ASSIGNED:
						%>
							의 업무가 
							<a href="<%=targetContent%>task.sw?cid=<%=taskContextId%>&wid=<%=workInstance.getWorkSpace().getId()%>"><span
								class="t_woname"><%=runningTaskName%></span></a>을 기다리고 있습니다
						<%
							break;
						case TaskInstance.APPROVAL_TASK_FORWARDED:
						%>
							의 업무가 
							<a href="<%=targetContent%>task.sw?cid=<%=taskContextId%>&wid=<%=workInstance.getWorkSpace().getId()%>"><span
								class="t_woname"><%=runningTaskName%></span></a>을 기다리고 있습니다
						<%
							break;
						default:
							break;
						}
						%>
						</div>
						<div>
							<a href="<%=targetContent%>list.sw?cid=<%=workListContextId%>&wid=<%=cUser.getId()%>"><span class="<%=workTypeClass%> t_date"><%=work.getFullpathName() %></span></a>
							<a href="<%=targetContent%>space.sw?cid=<%=workContextId%>&wid=<%=workInstance.getWorkSpace().getId()%>"> <span
								class="t_bold"><%=workInstance.getSubject() %></span></a>
						</div>
						<div>
							<span class="t_date"><%=workInstance.getLastModifiedDate().toLocalString() %></span>
						</div>
					</li>
					<%
					}
					%>
				</ul>
			</div>
		</ul>


	</div>
	<div class="portlet_b" style="display: block;"></div>
</div>
<!-- 나의 진행중인 업무 //-->