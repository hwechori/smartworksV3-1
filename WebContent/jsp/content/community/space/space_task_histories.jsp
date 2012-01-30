<%@page import="net.smartworks.model.instance.info.InstanceInfo"%>
<%@page import="net.smartworks.model.community.info.GroupInfo"%>
<%@page import="net.smartworks.model.community.info.DepartmentInfo"%>
<%@page import="net.smartworks.model.work.info.SmartWorkInfo"%>
<%@page import="net.smartworks.model.community.info.UserInfo"%>
<%@page import="net.smartworks.model.instance.info.MemoInstanceInfo"%>
<%@page import="net.smartworks.model.instance.info.ImageInstanceInfo"%>
<%@page import="net.smartworks.model.instance.info.FileInstanceInfo"%>
<%@page import="net.smartworks.model.instance.info.EventInstanceInfo"%>
<%@page import="net.smartworks.model.instance.info.BoardInstanceInfo"%>
<%@page import="net.smartworks.model.community.info.WorkSpaceInfo"%>
<%@page import="net.smartworks.model.instance.Instance"%>
<%@page import="net.smartworks.model.work.SocialWork"%>
<%@page import="net.smartworks.model.work.Work"%>
<%@page import="net.smartworks.model.work.SmartWork"%>
<%@page import="net.smartworks.model.instance.info.WorkInstanceInfo"%>
<%@page import="net.smartworks.model.instance.info.TaskInstanceInfo"%>
<%@page import="net.smartworks.model.instance.TaskInstance"%>
<%@page import="net.smartworks.model.calendar.CompanyEvent"%>
<%@page import="net.smartworks.util.SmartMessage"%>
<%@page import="net.smartworks.model.calendar.WorkHourPolicy"%>
<%@page import="net.smartworks.model.community.WorkSpace"%>
<%@page import="java.util.Calendar"%>
<%@page import="net.smartworks.model.calendar.CompanyCalendar"%>
<%@page import="net.smartworks.model.community.User"%>
<%@page import="net.smartworks.util.SmartUtil"%>
<%@page import="net.smartworks.util.LocalDate"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="net.smartworks.service.ISmartWorks"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	ISmartWorks smartWorks = (ISmartWorks) request.getAttribute("smartWorks");
	User cUser = SmartUtil.getCurrentUser();

	TaskInstanceInfo[] tasksHistories = (TaskInstanceInfo[])session.getAttribute("taskHistories");
	
%>
<!--  다국어 지원을 위해, 로케일 및 다국어 resource bundle 을 설정 한다. -->
<fmt:setLocale value="<%=cUser.getLocale() %>" scope="request" />
<fmt:setBundle basename="resource.smartworksMessage" scope="request" />

	<%
	if(!SmartUtil.isBlankObject(tasksHistories) && tasksHistories.length > 0){
		for(int i=0; i<tasksHistories.length; i++){
			TaskInstanceInfo taskInstance = tasksHistories[i];
			InstanceInfo workInstance = taskInstance.getWorkInstance();
			SmartWorkInfo work = (SmartWorkInfo)workInstance.getWork();
			UserInfo owner = workInstance.getOwner();
			WorkSpaceInfo workSpace = workInstance.getWorkSpace();
			String comClass = "";
			if(SmartUtil.isBlankObject(workSpace)) workSpace = workInstance.getOwner();
			boolean onWorkSpace = false;
			if(workSpace.getClass().equals(DepartmentInfo.class)){
				comClass = "ico_division_s";
				onWorkSpace = true;
			}else if(workSpace.getClass().equals(GroupInfo.class)){
				comClass = "ico_group_s";
				onWorkSpace = true;
			}
			switch(workInstance.getType()){
			
			// 태스크가 게시판인 경우...									
			case Instance.TYPE_BOARD:
				BoardInstanceInfo board = (BoardInstanceInfo)workInstance;
	%>
				<li>
					<div class="det_title">
						<div class="noti_pic"><img src="<%=owner.getMidPicture()%>" class="profile_size_m"></div>
						<div class="noti_in_m">
							<span class="t_name">owner.getLongName()</span><%if(onWorkSpace){ %><span class="arr">▶</span><span class="<%=comClass%>"><%=workSpace.getName() %></span><%} %>
							<div><%=board.getSubject() %></div>
							<div><%=board.getBriefContent() %></div>
							<%if(!SmartUtil.isBlankObject(board.getAttachment())){ %><div><%=board.getAttachment() %></div><%} %>
							<div><span class="t_date"><%=taskInstance.getLastModifiedDate().toLocalString() %></span> <a href=""><span class="repl_write"><fmt:message key="common.button.write_comments"/></span> </a></div>
						</div>
					</div>
				</li>							
			<%
				break;
			// 태스크가 이벤트인 경우...									
			case Instance.TYPE_EVENT:
				EventInstanceInfo event = (EventInstanceInfo)workInstance;
			%>
				<li>
					<div class="det_title">
						<div class="noti_pic"><img src="<%=owner.getMidPicture()%>" class="profile_size_m"></div>
						<div class="noti_in_m">
							<span class="t_name">owner.getLongName()</span><%if(onWorkSpace){ %><span class="arr">▶</span><span class="<%=comClass%>"><%=workSpace.getName() %></span><%} %>
							<div><%=event.getSubject() %></div>
							<div><fmt:message key="common.upload.event.start_date"/> : <%=event.getStart().toLocalString() %> 
								<%if(!SmartUtil.isBlankObject(event.getEnd())) {%><fmt:message key="common.upload.event.end_date"/> : <%=event.getEnd().toLocalString() %> <%} %></div>
							<div><span class="t_date"><%=taskInstance.getLastModifiedDate().toLocalString() %></span> <a href=""><span class="repl_write"><fmt:message key="common.button.write_comments"/></span> </a></div>
						</div>
					</div>
				</li>
			<%
				break;
			// 태스크가 파일인 경우...									
			case Instance.TYPE_FILE:
				FileInstanceInfo file = (FileInstanceInfo)workInstance;
			%>
				<li>
					<div class="det_title">
						<div class="noti_pic"><img src="<%=owner.getMidPicture()%>" class="profile_size_m"></div>
						<div class="noti_in_m">
							<span class="t_name">owner.getLongName()</span><%if(onWorkSpace){ %><span class="arr">▶</span><span class="<%=comClass%>"><%=workSpace.getName() %></span><%} %>
							<div><%=file.getSubject() %></div>
							<div><%=file.getContent() %></div>
							<div><span class="t_date"><%=taskInstance.getLastModifiedDate().toLocalString() %></span> <a href=""><span class="repl_write"><fmt:message key="common.button.write_comments"/></span> </a></div>
						</div>
					</div>
				</li>
			<%
				break;
			// 태스크가 사진인 경우...									
			case Instance.TYPE_IMAGE:
				ImageInstanceInfo image = (ImageInstanceInfo)workInstance;
			%>
				<li>
					<div class="det_title">
						<div class="noti_pic"><img src="<%=owner.getMidPicture()%>" class="profile_size_m"></div>
						<div class="noti_in_m">
							<span class="t_name">owner.getLongName()</span><%if(onWorkSpace){ %><span class="arr">▶</span><span class="<%=comClass%>"><%=workSpace.getName() %></span><%} %>
							<div><%=board.getSubject() %></div>
							<div><%=board.getBriefContent() %></div>
							<div><span class="t_date"><%=taskInstance.getLastModifiedDate().toLocalString() %></span> <a href=""><span class="repl_write"><fmt:message key="common.button.write_comments"/></span> </a></div>
						</div>
					</div>
				</li>
			<%
				break;
			// 태스크가 메모인 경우...									
			case Instance.TYPE_MEMO:
				MemoInstanceInfo memo = (MemoInstanceInfo)workInstance;
			%>
				<li>
					<div class="det_title">
						<div class="noti_pic"><img src="<%=owner.getMidPicture()%>" class="profile_size_m"></div>
						<div class="noti_in_m">
							<span class="t_name">owner.getLongName()</span><%if(onWorkSpace){ %><span class="arr">▶</span><span class="<%=comClass%>"><%=workSpace.getName() %></span><%} %>
							<div><%=memo.getContent() %></div>
							<div><span class="t_date"><%=taskInstance.getLastModifiedDate().toLocalString() %></span> <a href=""><span class="repl_write"><fmt:message key="common.button.write_comments"/></span> </a></div>
						</div>
					</div>
				</li>
			<%
				break;
			default:
				switch(taskInstance.getTaskType()){
				case TaskInstance.TYPE_APPROVAL_TASK_ASSIGNED:
					break;
				case TaskInstance.TYPE_APPROVAL_TASK_FORWARDED:
					break;
				case TaskInstance.TYPE_INFORMATION_TASK_ASSIGNED:
					break;
				case TaskInstance.TYPE_INFORMATION_TASK_CREATED:
					break;
				case TaskInstance.TYPE_INFORMATION_TASK_DELETED:
					break;
				case TaskInstance.TYPE_INFORMATION_TASK_FORWARDED:
					break;
				case TaskInstance.TYPE_INFORMATION_TASK_UDATED:
					break;
				case TaskInstance.TYPE_PROCESS_TASK_ASSIGNED:
					break;
				case TaskInstance.TYPE_PROCESS_TASK_FORWARDED:
					break;
				case TaskInstance.TYPE_SCHEDULE_TASK_ASSIGNED:
					break;
				case TaskInstance.TYPE_SCHEDULE_TASK_FORWARDED:
					break;
				}
			}
		}
	%>
			<li>
				<div class="det_title">
					<div class="noti_pic">
						<img src="../images/pic_size_48.jpg">
					</div>
					<div class="noti_in_m">
						<span class="t_name">Minashin</span><span class="arr">▶</span><span
							class="ico_division_s">마케팅/디자인팀</span>
						<div>회의록 내용 중 빠진 부분이나 수정할 사항이 있으시면 참석자 누구든 수정해주시기 바랍니다^^
							(메모는 타이틀 성격이 아니기 때문에 볼드가 안들어갑니다.)</div>
						<div>
							<span class="t_date"> 2011.10.13</span> <a href=""><span
								class="repl_write">댓글달기</span> </a>
						</div>
					</div>
				</div>
			</li>
	<%
	}
	%>
