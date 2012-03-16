
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

%>
<!--  다국어 지원을 위해, 로케일 및 다국어 resource bundle 을 설정 한다. -->
<fmt:setLocale value="<%=cUser.getLocale() %>" scope="request" />
<fmt:setBundle basename="resource.smartworksMessage" scope="request" />

<%	
// 호출시 전달된 lastDate, assignedOnly 값을 가져온다..
String strLastDate = request.getParameter("lastDate");
LocalDate lastDate = new LocalDate();
if(!SmartUtil.isBlankObject(strLastDate))		
	lastDate = LocalDate.convertLocalStringToLocalDate(request.getParameter("lastDate"));
boolean assignedOnly = Boolean.parseBoolean(request.getParameter("assignedOnly"));

// lastDate와 assignedOnly값을 가지고 현재 진행중인 모든 인스턴스리스트를 가져온다...
InstanceInfo[] instances = smartWorks.getMyRunningInstances(lastDate, 20, assignedOnly);
if (instances != null) {
	// 인스턴스 갯수 만큼 리스트를 그린다...
	for (InstanceInfo instance : instances) {
		String statusImage;
		String statusTitle;
		WorkInstanceInfo workInstance = null;
		TaskInstanceInfo taskInstance = null;
		TaskInstanceInfo[] assignedTasks = null;
		TaskInstanceInfo[] forwardedTasks = null;
		boolean isAssignedTask = false;
		String trTarget = "";
		
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
			trTarget = workInstance.getController() + "?cid=" + workInstance.getContextId() + "&workId=" + workInstance.getWork().getId();
		// 인스턴스타입이 태스크인 경우.....
		} else if (instance.getType() == Instance.TYPE_TASK) {
			isAssignedTask = true;
			workInstance = (WorkInstanceInfo)((TaskInstanceInfo) instance).getWorkInstance();
			
			taskInstance = (TaskInstanceInfo) instance;
			trTarget = taskInstance.getController() + "?cid=" + taskInstance.getContextId() + "&workId=" + workInstance.getWork().getId() + "&taskInstId=" + taskInstance.getId();
		}
		UserInfo owner = workInstance.getOwner();
		String userDetailInfo = SmartUtil.getUserDetailInfo(owner);
		SmartWorkInfo work = (SmartWorkInfo) workInstance.getWork();
		String runningTaskName = "";
		if (taskInstance != null)
			runningTaskName = taskInstance.getName();

		// 인스턴스가 할당태스크인 경우 중에...
		if (isAssignedTask) {
			switch (taskInstance.getStatus()) {
			// 인스턴스가 현재 진행중인 경우..
			case Instance.STATUS_RUNNING:
				statusImage = "images/icon_status_running.jpg";
				statusTitle = "content.status.running";
				break;
			// 인스턴스가 지연진행중인 경우....
			case Instance.STATUS_DELAYED_RUNNING:
				statusImage = "images/icon_status_d_running.jpg";
				statusTitle = "content.status.delayed_running";
				break;
			// 인스턴스가 반려된 경우...
			case Instance.STATUS_RETURNED:
				statusImage = "images/icon_status_returned.jpg";
				statusTitle = "content.status.returned";
				break;
			// 기타 잘못되어 상태가 없는 경우..
			default:
				statusImage = "images/icon_status_not_yet.jpg";
				statusTitle = "content.status.not_yet";
			}
		// 인스턴스가 할당태스크가 아닌경우....
		} else {
			statusImage = "images/icon_status_running.jpg";
			statusTitle = "content.status.running";
		}
%>
		<!-- 진행중인 업무 아이템 -->
		<tr class="working_br instance_list js_more_instance_item js_content" href="<%=trTarget%>" dateValue="<%=workInstance.getLastModifiedDate().toLocalDateString2()%>">
			<!-- 인스턴스 상태 및 시작자 사진표시 -->
			<td class="pic">
				<img src="<%=statusImage%>" title="<fmt:message key='<%=statusTitle%>'/>" />
				<a class="js_pop_user_info" href="<%=owner.getSpaceController() %>?cid=<%=owner.getSpaceContextId()%>" userId="<%=owner.getId()%>" profile="<%=owner.getOrgPicture()%>" userDetail="<%=userDetailInfo%>"><img class="profile_size_m" src="<%=owner.getMidPicture()%>"/></a>
			</td>
			<!-- 인스턴스 상태 및 시작자 사진표시 -->
			
			<!-- 인스턴스 상세내용 표시 -->
			<td>
				<!--  시작자 이름 -->
				<a href="<%=owner.getSpaceController() %>?cid=<%=owner.getSpaceContextId()%>"><span class="t_name"><%=owner.getLongName()%></span> </a>
				<%
				// 공간이 사람이 아닌 공간(그룹, 부서) 경우에는 공간 표시를 해준다...
				if (!workInstance.getWorkSpace().getId().equals(owner.getId())) {
					WorkSpaceInfo workSpace = workInstance.getWorkSpace();
				%>
					<span class="arr">▶</span>
					<a href="<%=workSpace.getSpaceController()%>?cid=<%=workSpace.getSpaceContextId()%>"><span class="<%=workSpace.getIconClass()%>"><%=workSpace.getName()%></span> </a>
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
								<a class="js_content" href='<%=((TaskInstanceInfo)taskInstance).getController()%>?cid=<%=((TaskInstanceInfo)taskInstance).getContextId()%>&workId=<%=work.getId()%>&taskInstId=<%=taskInstance.getId()%>'>
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
								<a class="js_content" href="<%=((TaskInstanceInfo)taskInstance).getController()%>?cid=<%=((TaskInstanceInfo)taskInstance).getContextId()%>&workId=<%=work.getId()%>&taskInstId=<%=taskInstance.getId()%>">
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
								<a class="js_content" href="<%=((TaskInstanceInfo)taskInstance).getController()%>?cid=<%=((TaskInstanceInfo)taskInstance).getContextId()%>&workId=<%=work.getId()%>&taskInstId=<%=taskInstance.getId()%>">
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
								<a class="js_content" href="<%=((TaskInstanceInfo)taskInstance).getController()%>?cid=<%=((TaskInstanceInfo)taskInstance).getContextId()%>&workId=<%=work.getId()%>&taskInstId=<%=taskInstance.getId()%>">
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
								<a class="js_content" href="<%=((TaskInstanceInfo)taskInstance).getController()%>?cid=<%=((TaskInstanceInfo)taskInstance).getContextId()%>&workId=<%=work.getId()%>&taskInstId=<%=taskInstance.getId()%>">
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
								<a class="js_content" href="<%=((TaskInstanceInfo)taskInstance).getController()%>?cid=<%=((TaskInstanceInfo)taskInstance).getContextId()%>&workId=<%=work.getId()%>&taskInstId=<%=taskInstance.getId()%>">
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
								<a class="js_content" href="<%=((TaskInstanceInfo)taskInstance).getController()%>?cid=<%=((TaskInstanceInfo)taskInstance).getContextId()%>&workId=<%=work.getId()%>&taskInstId=<%=taskInstance.getId()%>%>">
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
								<a class="js_content" href="<%=((TaskInstanceInfo)taskInstance).getController()%>?cid=<%=((TaskInstanceInfo)taskInstance).getContextId()%>&workId=<%=work.getId()%>&taskInstId=<%=taskInstance.getId()%>">
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
									<a href="<%=assignee.getSpaceController() %>?cid=<%=assignee.getSpaceContextId()%>" title="<%=assignee.getLongName()%>">
										<span class="t_name"><%=assignee.getName()%></span>
									</a>
								</fmt:param>
								<fmt:param>
									<a href="<%=assignedTask.getController()%>?cid=<%=assignedTask.getContextId()%>&wid=<%=assignee.getId() %>&workId=<%=workInstance.getWorkSpace().getId()%>">
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
						String forwardedContextId = ISmartWorks.CONTEXT_PREFIX_USER_SPACE + forwardee.getId();
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
								<a href="<%=forwardee.getSpaceController() %>?cid=<%=forwardee.getSpaceContextId()%>" title="<%=forwardee.getLongName()%>">
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
				<a href="<%=work.getController()%>?cid=<%=work.getContextId()%>" class="js_content">
					<span class="<%=work.getIconClass()%>"></span>
					<span class="t_date"><%=work.getFullpathName()%></span>
				</a>
				<a href="<%=workInstance.getController()%>?cid=<%=workInstance.getContextId() %>&workId=<%=work.getId() %>" class="js_content">
					<span class="t_bold"><%=workInstance.getSubject()%></span> 
				</a>
				<%if(workInstance.getSubInstanceCount()>0){ %><font class="t_sub_count">[<b><%=workInstance.getSubInstanceCount() %></b>]</font><%} %>
				<%if(workInstance.isNew()){ %><span class="icon_new"></span><%} %>
			</td>
			<!-- 인스턴스 상세내용 표시 //-->
			
			<!-- 인스턴스 마지막수정일자 -->
			<td class="vb tr pr10"><span class="t_date"><%=workInstance.getLastModifiedDate().toLocalString()%></span></td>
			<!-- 인스턴스 마지막수정일자 //-->
		</tr>
		<!-- 진행중인 업무 아이템 //-->
<%
	}
}
%>	