
<!-- Name 			: more_instance_list.jsp										 -->
<!-- Description	: 현재사용자에게 할당된 업무나, 현재사용자 진행중인 업무목록을 보여주는 화면	 -->
<!-- Author			: Maninsoft, Inc.												 -->
<!-- Created Date	: 2011.9.														 -->

<%@page import="net.smartworks.model.community.info.WorkSpaceInfo"%>
<%@page import="net.smartworks.model.community.info.UserInfo"%>
<%@page import="net.smartworks.model.work.info.SmartWorkInfo"%>
<%@page import="net.smartworks.model.instance.info.WorkInstanceInfo"%>
<%@page import="net.smartworks.model.instance.info.TaskInstanceInfo"%>
<%@page import="net.smartworks.model.instance.info.InstanceInfo"%>
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
	// 스마트웍스 서비스들을 사용하기위한 핸들러를 가져온다. 현재사용자 정보도 가져온다 
	ISmartWorks smartWorks = (ISmartWorks) request.getAttribute("smartWorks");
	User cUser = SmartUtil.getCurrentUser();
	
	// 호출시 전달된 lastDate, assignedOnly 값을 가져온다..
	String strLastDate = request.getParameter("lastDate");
	LocalDate lastDate = new LocalDate();
	if(!SmartUtil.isBlankObject(strLastDate))		
		lastDate = LocalDate.convertLocalStringToLocalDate(request.getParameter("lastDate"));
	boolean assignedOnly = Boolean.parseBoolean(request.getParameter("assignedOnly"));

	// lastDate와 assignedOnly값을 가지고 현재 진행중인 모든 인스턴스리스트를 가져온다...
	InstanceInfo[] instances = smartWorks.getMyRunningInstances(lastDate, 20, assignedOnly);
	if (instances != null) {
		// 인스턴스 갯수 만큼 리스를 그린다...
		for (InstanceInfo instance : instances) {
			String statusImage;
			String statusTitle;
			WorkInstanceInfo workInstance = null;
			TaskInstanceInfo taskInstance = null;
			TaskInstanceInfo[] assignedTasks = null;
			TaskInstanceInfo[] forwardedTasks = null;
			boolean isAssignedTask = false;
			
			// 인스턴스 타입이 Work인경우.....
			if (instance.getType() == Instance.TYPE_WORK) {
				workInstance = (WorkInstanceInfo) instance;
				TaskInstanceInfo lastTask = workInstance.getLastTask();
				int lastTaskCount = workInstance.getLastTaskCount();
				List<TaskInstanceInfo> assignedList = new ArrayList<TaskInstanceInfo>();
				List<TaskInstanceInfo> forwardedList = new ArrayList<TaskInstanceInfo>();
				if ((lastTask.getTaskType() % 10) == 1)
							assignedList.add(lastTask);
				else if ((lastTask.getTaskType() % 10) == 2)
							forwardedList.add(lastTask);
				assignedTasks = (TaskInstanceInfo[]) assignedList.toArray(new TaskInstanceInfo[0]);
				forwardedTasks = (TaskInstanceInfo[]) forwardedList.toArray(new TaskInstanceInfo[0]);
			// 인스턴스타입이 태스크인 경우.....
			} else if (instance.getType() == Instance.TYPE_TASK) {
				isAssignedTask = true;
				workInstance = (WorkInstanceInfo)((TaskInstanceInfo) instance).getWorkInstance();
				
				taskInstance = (TaskInstanceInfo) instance;
			}
			UserInfo owner = workInstance.getOwner();
			SmartWorkInfo work = (SmartWorkInfo) workInstance.getWork();
			String runningTaskName = "";
			if (taskInstance != null)
				runningTaskName = taskInstance.getName();
			String ownerContextId = ISmartWorks.CONTEXT_PREFIX_USER_SPACE + owner.getId();

			String targetContent, taskContextId, workContextId, workListContextId, workTypeClass;
			// Work 타입별로 필요한 값들을 설정한다..
			switch (work.getType()) {
			
			// Work타입이 정보관리업무인 경우....
			case SmartWork.TYPE_INFORMATION:
				workTypeClass = "ico_iworks";
				targetContent = "iwork_";
				taskContextId = ISmartWorks.CONTEXT_PREFIX_IWORK_TASK + ((taskInstance != null) ? taskInstance.getId() : "");
				workContextId = ISmartWorks.CONTEXT_PREFIX_IWORK_SPACE + workInstance.getId();
				workListContextId = ISmartWorks.CONTEXT_PREFIX_IWORK_LIST + work.getId();
				break;
				
			// Work타입이 프로세스업무인 경우...
			case SmartWork.TYPE_PROCESS:
				workTypeClass = "ico_pworks";
				targetContent = "pwork_";
				taskContextId = ISmartWorks.CONTEXT_PREFIX_PWORK_TASK + ((taskInstance != null) ? taskInstance.getId() : "");
				workContextId = ISmartWorks.CONTEXT_PREFIX_PWORK_SPACE + workInstance.getId();
				workListContextId = ISmartWorks.CONTEXT_PREFIX_PWORK_LIST + work.getId();
				break;
			
			// Work타입이 일정계획업무인 경우...
			case SmartWork.TYPE_SCHEDULE:
				workTypeClass = "ico_sworks";
				targetContent = "swork_";
				taskContextId = ISmartWorks.CONTEXT_PREFIX_SWORK_TASK + ((taskInstance != null) ? taskInstance.getId() : "");
				workContextId = ISmartWorks.CONTEXT_PREFIX_SWORK_SPACE + workInstance.getId();
				workListContextId = ISmartWorks.CONTEXT_PREFIX_SWORK_LIST + work.getId();
				break;
			
			// 기타 Work타입이 잘못되어 없는 경우...
			default:
				workTypeClass = "";
				targetContent = "";
				taskContextId = "";
				workContextId = "";
				workListContextId = "";
				break;
			}

			// 인스턴스가 할당태스크인 경우 중에...
			if (isAssignedTask) {
				switch (taskInstance.getStatus()) {
				// 인스턴스가 현재 진행중인 경우..
				case Instance.STATUS_RUNNING:
					statusImage = "images/ic_state_ing.jpg";
					statusTitle = "content.status.running";
					break;
				// 인스턴스가 지연진행중인 경우....
				case Instance.STATUS_DELAYED_RUNNING:
					statusImage = "images/ic_state_ing.jpg";
					statusTitle = "content.status.delayed_running";
					break;
				// 인스턴스가 반려된 경우...
				case Instance.STATUS_RETURNED:
					statusImage = "images/ic_state_ing.jpg";
					statusTitle = "content.status.returned";
					break;
				// 인스턴스가 지연반려된 경우....
				case Instance.STATUS_RETURNED_DELAYED:
					statusImage = "images/ic_state_ing.jpg";
					statusTitle = "content.status.returned_delayed";
					break;
				// 기타 잘못되어 상태가 없는 경우..
				default:
					statusImage = "images/ic_state_ing.jpg";
					statusTitle = "content.status.running";
				}
			// 인스턴스가 할당태스크가 아닌경우....
			} else {
				statusImage = "images/ic_state_ing.jpg";
				statusTitle = "content.status.running";
			}
%>
<!--  다국어 지원을 위해, 로케일 및 다국어 resource bundle 을 설정 한다. -->
<fmt:setLocale value="<%=cUser.getLocale() %>" scope="request" />
<fmt:setBundle basename="resource.smartworksMessage" scope="request" />

			<!-- 진행중인 업무 아이템 -->
			<tr class="working_br js_more_instance_item" dateValue="<%=workInstance.getLastModifiedDate().toLocalDateValue()%>">
			
				<!-- 인스턴스 상태 및 시작자 사진표시 -->
				<td class="pic">
					<img src="<%=statusImage%>" title="<fmt:message key='<%=statusTitle%>'/>" />
					<a href="user_space.sw?cid=<%=ownerContextId%>"><img class="profile_size_m" src="<%=owner.getMidPicture()%>" title="<%=owner.getLongName()%>" /></a>
				</td>
				<!-- 인스턴스 상태 및 시작자 사진표시 -->
				
				<!-- 인스턴스 상세내용 표시 -->
				<td>
					<!--  시작자 이름 -->
					<a href="user_space.sw?cid=<%=ownerContextId%>"><span class="t_name"><%=owner.getLongName()%></span> </a>
					<%
					// 공간이 사람이 아닌 공간(그룹, 부서) 경우에는 공간 표시를 해준다...
					if (!workInstance.getWorkSpace().getId().equals(owner.getId())) {
						WorkSpaceInfo workSpace = workInstance.getWorkSpace();
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
						<span class="arr">▶</span>
						<a href="<%=spaceContent%>?cid=<%=commContext%>"><span class="ico_division_s"><%=workSpace.getName()%></span> </a>
					<%
					}
					// 인스턴스 타입에 할당태스크인 경우들 중에서....
					if (isAssignedTask) {
						switch (taskInstance.getTaskType()) {
						
						// 정보관리업무 할당 태스크인 경우..
						case TaskInstance.TYPE_INFORMATION_TASK_ASSIGNED:
					%>
							<fmt:message key="content.sentence.itask_assigned">
								<fmt:param>
									<a href='<%=targetContent%>task.sw?cid=<%=taskContextId%>&wid=<%=workInstance.getWorkSpace().getId()%>'>
										<span class='t_woname'><%=runningTaskName%></span> 
									</a>
								</fmt:param>
							</fmt:message>
						<%
							break;
						// 정보관리업무 업무전달인 경우....
						case TaskInstance.TYPE_INFORMATION_TASK_FORWARDED:
						%>
							<fmt:message key="content.sentence.itask_forwarded">
								<fmt:param>
									<a href="<%=targetContent%>task.sw?cid=<%=taskContextId%>&wid=<%=workInstance.getWorkSpace().getId()%>">
										<span class="t_woname"><%=runningTaskName%></span>
									</a>
								</fmt:param>
							</fmt:message>
						<%
							break;
						// 프로세스업무 할당테스크인 경우...
						case TaskInstance.TYPE_PROCESS_TASK_ASSIGNED:
						%>
							<fmt:message key="content.sentence.ptask_assigned">
								<fmt:param>
									<a href="<%=targetContent%>task.sw?cid=<%=taskContextId%>&wid=<%=workInstance.getWorkSpace().getId()%>">
										<span class="t_woname"><%=runningTaskName%></span> 
									</a>
								</fmt:param>
							</fmt:message>
						<%
							break;
						// 프로세스업무 업무전달인 경우...
						case TaskInstance.TYPE_PROCESS_TASK_FORWARDED:
						%>
							<fmt:message key="content.sentence.ptask_forwarded">
								<fmt:param>
									<a href="<%=targetContent%>task.sw?cid=<%=taskContextId%>&wid=<%=workInstance.getWorkSpace().getId()%>">
										<span class="t_woname"><%=runningTaskName%></span> 
									</a>
								</fmt:param>
							</fmt:message>
						<%
							break;
						// 일정계획업무 할당태스크인 경우...
						case TaskInstance.TYPE_SCHEDULE_TASK_ASSIGNED:
						%>
							<fmt:message key="content.sentence.stask_assigned">
								<fmt:param>
									<a href="<%=targetContent%>task.sw?cid=<%=taskContextId%>&wid=<%=workInstance.getWorkSpace().getId()%>">
										<span class="t_woname"><%=runningTaskName%></span> 
									</a>
								</fmt:param>
							</fmt:message>
						<%
							break;
						// 일정계획업무 업무전달인 경우...
						case TaskInstance.TYPE_SCHEDULE_TASK_FORWARDED:
						%>
							<fmt:message key="content.sentence.stask_forwarded">
								<fmt:param>
									<a href="<%=targetContent%>task.sw?cid=<%=taskContextId%>&wid=<%=workInstance.getWorkSpace().getId()%>">
										<span class="t_woname"><%=runningTaskName%></span> 
									</a>
								</fmt:param>
							</fmt:message>
						<%
							break;
						// 전자결재업무 할당태스크인 경우...
						case TaskInstance.TYPE_APPROVAL_TASK_ASSIGNED:
						%>
							<fmt:message key="content.sentence.stask_forwarded">
								<fmt:param>
									<a href="<%=targetContent%>task.sw?cid=<%=taskContextId%>&wid=<%=workInstance.getWorkSpace().getId()%>">
										<span class="t_woname"><%=runningTaskName%></span> 
									</a>
								</fmt:param>
							</fmt:message>
						<%
							break;
						// 전자결재업무 업무전달인 경우....
						case TaskInstance.TYPE_APPROVAL_TASK_FORWARDED:
						%>
							<fmt:message key="content.sentence.stask_forwarded">
								<fmt:param>
									<a href="<%=targetContent%>task.sw?cid=<%=taskContextId%>&wid=<%=workInstance.getWorkSpace().getId()%>">
										<span class="t_woname"><%=runningTaskName%></span> 
									</a>
								</fmt:param>
							</fmt:message>
					<%
							break;
						// 기타 잘못된 경우....
						default:
							break;
						}
					// 할당태스크가 아닌경우....
					} else {
						
						// 할당된 태스크들이 있으면... 현재상태를 설명해줄수 있는 표현문장을 만든다....
						if (assignedTasks != null) {
					%>
							<fmt:message key="content.sentence.users_work_is" />
					<%
							boolean firstRun = true;
							for (TaskInstanceInfo assignedTask : assignedTasks) {
								UserInfo assignee = assignedTask.getAssignee();
								String userContextId = ISmartWorks.CONTEXT_PREFIX_USER_SPACE + assignee.getId();
								String assignedContextId = taskContextId + assignee.getId();
								runningTaskName = assignedTask.getName();
								if (firstRun) {
									firstRun = false;
								} else {
					%>
									,
								<%
								}
								%>
								<fmt:message key="content.sentence.task_by_assignee">
									<fmt:param>
										<a href="user_space.sw?cid=<%=userContextId%>" title="<%=assignee.getLongName()%>">
											<span class="t_name"><%=assignee.getName()%></span>
										</a>
									</fmt:param>
									<fmt:param>
										<a href="<%=targetContent%>task.sw?cid=<%=assignedContextId%>&wid=<%=workInstance.getWorkSpace().getId()%>">
											<span class="t_woname"><%=runningTaskName%></span> 
										</a>
									</fmt:param>
								</fmt:message>
							<%
							}
							%>
							<fmt:message key="content.sentence.task_is_running" />
						<%
						}
						if (!SmartUtil.isBlankObject(forwardedTasks)) {
							UserInfo forwardee = forwardedTasks[0].getAssignee();
							String userContextId = ISmartWorks.CONTEXT_PREFIX_USER_SPACE + forwardee.getId();
							String forwardedContextId = taskContextId + forwardee.getId();
							runningTaskName = forwardedTasks[0].getName();
							if (assignedTasks != null) {
						%>
								<fmt:message key="content.sentence.and_also" />
							<%
							} else {
							%>
								<fmt:message key="content.sentence.forwarded_work_is" />
							<%
							}
							%>
							<fmt:message key="content.sentence.and_user">
								<fmt:param>
									<a href="user_space.sw?cid=<%=userContextId%>" title="<%=forwardee.getLongName()%>">
										<span class="t_name"><%=forwardee.getName()%></span>
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
					<br/>
					<a href="<%=targetContent%>list.sw?cid=<%=workListContextId%>&wid=<%=cUser.getId()%>">
						<span class="<%=workTypeClass%>"></span>
						<span class="t_date"><%=work.getFullpathName()%></span>
					</a>
					<a href="<%=targetContent%>space.sw?cid=<%=workContextId%>&wid=<%=workInstance.getWorkSpace().getId()%>">
						<span class="t_bold"><%=workInstance.getSubject()%></span> 
					</a>
				</td>
				<!-- 인스턴스 상세내용 표시 //-->
				
				<!-- 인스턴스 마지막수정일자 -->
				<td class="vAlignBottom hAlignRight"><span class="t_date"><%= workInstance.getLastModifiedDate().toLocalString()%></span></td>
				<!-- 인스턴스 마지막수정일자 //-->
			</tr>
			<!-- 진행중인 업무 아이템 //-->
	<%
		}
	}
	%>
	