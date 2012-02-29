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
			if(taskInstance.getType()<0){
				String lastDateStr = (i>0) ? (new LocalDate(tasksHistories[i-1].getLastModifiedDate().getTime())).toLocalDateString2() : ""; 
	%>
				<li class="t_nowork"><a href="" class="js_space_more_history" lastDate="<%=lastDateStr%>"><fmt:message key="common.message.more_work_task"></fmt:message></a></li>
	<%
				break;
			}
			InstanceInfo workInstance = taskInstance.getWorkInstance();
			SmartWorkInfo work = (SmartWorkInfo)workInstance.getWork();
			UserInfo owner = workInstance.getOwner();
			String userDetailInfo = SmartUtil.getUserDetailInfo(owner);
			WorkSpaceInfo workSpace = workInstance.getWorkSpace();
			String comClass = "";
			if(SmartUtil.isBlankObject(workSpace)) workSpace = workInstance.getOwner();
			boolean onWorkSpace = false;
			String spaceContent = "";
			String commContext = "";
			if(workSpace.getClass().equals(DepartmentInfo.class)){
				comClass = "ico_division_s";
				onWorkSpace = true;
				commContext = ISmartWorks.CONTEXT_PREFIX_DEPARTMENT_SPACE + workSpace.getId();
			}else if(workSpace.getClass().equals(GroupInfo.class)){
				comClass = "ico_group_s";
				onWorkSpace = true;
				commContext = ISmartWorks.CONTEXT_PREFIX_GROUP_SPACE + workSpace.getId();
			}
			BoardInstanceInfo board=null;
			EventInstanceInfo event=null;
			FileInstanceInfo file=null;
			ImageInstanceInfo image=null;
			MemoInstanceInfo memo=null;

			String ownerContextId = ISmartWorks.CONTEXT_PREFIX_USER_SPACE + owner.getId();
			switch(workInstance.getType()){
			
			// 태스크가 게시판인 경우...									
			case Instance.TYPE_BOARD:
				board = (BoardInstanceInfo)workInstance;
	%>
				<li>
					<div class="det_title">
						<div class="noti_pic"><a class="js_pop_user_info" href="user_space.sw?cid=<%=ownerContextId%>" userId="<%=owner.getId()%>" profile="<%=owner.getOrgPicture()%>" userDetail="<%=userDetailInfo%>"><img src="<%=owner.getMidPicture()%>" class="profile_size_m"></a></div>
						<div class="noti_in_m">
							<a href="user_space.sw?cid=<%=ownerContextId%>"><span class="t_name"><%=owner.getLongName()%></span></a><%if(onWorkSpace){ %><span class="arr">▶</span>
							<a href="<%=spaceContent%>?cid=<%=commContext%>"><span class="<%=comClass%>"><%=workSpace.getName() %></span></a><%} %>
							<div><%=board.getSubject() %></div>
							<div><%=board.getBriefContent() %></div>
							<%if(!SmartUtil.isBlankObject(board.getAttachment())){ %><div><%=board.getAttachment() %></div><%} %>
							<!-- 인스턴스 마지막수정일자 -->
							<div class="vAlignBottom hAlignRight"><span class="t_date"><%=workInstance.getLastModifiedDate().toLocalString()%></span></div>
							<!-- 인스턴스 마지막수정일자 //-->
						</div>
					</div>
				</li>							
			<%
				break;
			// 태스크가 이벤트인 경우...									
			case Instance.TYPE_EVENT:
				event = (EventInstanceInfo)workInstance;
			%>
				<li>
					<div class="det_title">
						<div class="noti_pic"><a class="js_pop_user_info" href="user_space.sw?cid=<%=ownerContextId%>" userId="<%=owner.getId()%>" profile="<%=owner.getOrgPicture()%>" userDetail="<%=userDetailInfo%>"><img src="<%=owner.getMidPicture()%>" class="profile_size_m"></a></div>
						<div class="noti_in_m">
							<a href="user_space.sw?cid=<%=ownerContextId%>"><span class="t_name"><%=owner.getLongName()%></span></a><%if(onWorkSpace){ %><span class="arr">▶</span>
							<a href="<%=spaceContent%>?cid=<%=commContext%>"><span class="<%=comClass%>"><%=workSpace.getName() %></span></a><%} %>
							<div><%=event.getSubject() %></div>
							<div><fmt:message key="common.upload.event.start_date"/> : <%=event.getStart().toLocalString() %> 
								<%if(!SmartUtil.isBlankObject(event.getEnd())) {%><fmt:message key="common.upload.event.end_date"/> : <%=event.getEnd().toLocalString() %> <%} %></div>
							<!-- 인스턴스 마지막수정일자 -->
							<div class="vAlignBottom hAlignRight"><span class="t_date"><%=workInstance.getLastModifiedDate().toLocalString()%></span></div>
							<!-- 인스턴스 마지막수정일자 //-->
						</div>
					</div>
				</li>
			<%
				break;
			// 태스크가 파일인 경우...									
			case Instance.TYPE_FILE:
				file = (FileInstanceInfo)workInstance;
			%>
				<li>
					<div class="det_title">
						<div class="noti_pic"><a class="js_pop_user_info" href="user_space.sw?cid=<%=ownerContextId%>" userId="<%=owner.getId()%>" profile="<%=owner.getOrgPicture()%>" userDetail="<%=userDetailInfo%>"><img src="<%=owner.getMidPicture()%>" class="profile_size_m"></a></div>
						<div class="noti_in_m">
							<a href="user_space.sw?cid=<%=ownerContextId%>"><span class="t_name"><%=owner.getLongName()%></span></a><%if(onWorkSpace){ %><span class="arr">▶</span>
							<a href="<%=spaceContent%>?cid=<%=commContext%>"><span class="<%=comClass%>"><%=workSpace.getName() %></span></a><%} %>
							<div class="js_space_file_instance" groupId="<%=file.getGroupId() %>"></div>
							<%if(!SmartUtil.isBlankObject(file.getContent())){ %><div><%=file.getContent() %></div><%} %>
							<!-- 인스턴스 마지막수정일자 -->
							<div class="vAlignBottom hAlignRight"><span class="t_date"><%=workInstance.getLastModifiedDate().toLocalString()%></span></div>
							<!-- 인스턴스 마지막수정일자 //-->
						</div>
					</div>
				</li>
			<%
				break;
			// 태스크가 사진인 경우...									
			case Instance.TYPE_IMAGE:
				image = (ImageInstanceInfo)workInstance;
			%>
				<li>
					<div class="det_title">
						<div class="noti_pic"><a class="js_pop_user_info" href="user_space.sw?cid=<%=ownerContextId%>" userId="<%=owner.getId()%>" profile="<%=owner.getOrgPicture()%>" userDetail="<%=userDetailInfo%>"><img src="<%=owner.getMidPicture()%>" class="profile_size_m"></a></div>
						<div class="noti_in_m">
							<a href="user_space.sw?cid=<%=ownerContextId%>"><span class="t_name"><%=owner.getLongName()%></span></a><%if(onWorkSpace){ %><span class="arr">▶</span>
							<a href="<%=spaceContent%>?cid=<%=commContext%>"><span class="<%=comClass%>"><%=workSpace.getName() %></span></a><%} %>
							<div><a href="" class=""><img src="<%=image.getImgSource()%>" style="min-height:20px;width:200px;"></a></div>
							<%if(!SmartUtil.isBlankObject(image.getContent())){ %><div><%=image.getContent() %></div><%} %>
							<!-- 인스턴스 마지막수정일자 -->
							<div class="vAlignBottom hAlignRight"><span class="t_date"><%=workInstance.getLastModifiedDate().toLocalString()%></span></div>
							<!-- 인스턴스 마지막수정일자 //-->
						</div>
					</div>
				</li>
			<%
				break;
			// 태스크가 메모인 경우...									
			case Instance.TYPE_MEMO:
				memo = (MemoInstanceInfo)workInstance;
			%>
				<li>
					<div class="det_title">
						<div class="noti_pic"><a class="js_pop_user_info" href="user_space.sw?cid=<%=ownerContextId%>" userId="<%=owner.getId()%>" profile="<%=owner.getOrgPicture()%>" userDetail="<%=userDetailInfo%>"><img src="<%=owner.getMidPicture()%>" class="profile_size_m"></a></div>
						<div class="noti_in_m">
							<a href="user_space.sw?cid=<%=ownerContextId%>"><span class="t_name"><%=owner.getLongName()%></span></a><%if(onWorkSpace){ %><span class="arr">▶</span>
							<a href="<%=spaceContent%>?cid=<%=commContext%>"><span class="<%=comClass%>"><%=workSpace.getName() %></span></a><%} %>
							<div><%=memo.getContent() %></div>
							<!-- 인스턴스 마지막수정일자 -->
							<div class="vAlignBottom hAlignRight"><span class="t_date"><%=workInstance.getLastModifiedDate().toLocalString()%></span></div>
							<!-- 인스턴스 마지막수정일자 //-->
						</div>
					</div>
				</li>
			<%
				break;
			default:
			%>
				<li>
					<div class="det_title">
						<div class="noti_pic"><a class="js_pop_user_info" href="user_space.sw?cid=<%=ownerContextId%>" userId="<%=owner.getId()%>" profile="<%=owner.getOrgPicture()%>" userDetail="<%=userDetailInfo%>"><img src="<%=owner.getMidPicture()%>" class="profile_size_m"></a></div>
						<div class="noti_in_m">
							<a href="user_space.sw?cid=<%=ownerContextId%>"><span class="t_name"><%=owner.getLongName()%></span></a><%if(onWorkSpace){ %><span class="arr">▶</span>
							<a href="<%=spaceContent%>?cid=<%=commContext%>"><span class="<%=comClass%>"><%=workSpace.getName() %></span></a><%} %>
						<%
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
						String runningTaskName = taskInstance.getName();
						switch(taskInstance.getTaskType()){
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
						case TaskInstance.TYPE_INFORMATION_TASK_CREATED:
							break;
						case TaskInstance.TYPE_INFORMATION_TASK_DELETED:
							break;
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
						case TaskInstance.TYPE_INFORMATION_TASK_UDATED:
							break;
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
						}
						%>
						</div>			
						<div>
							<a href="<%=targetContent%>list.sw?cid=<%=workListContextId%>&wid=<%=cUser.getId()%>">
								<span class="<%=workTypeClass%>"></span>
								<span class="t_date"><%=work.getFullpathName()%></span>
							</a>
							<a href="<%=targetContent%>space.sw?cid=<%=workContextId%>&wid=<%=workInstance.getWorkSpace().getId()%>&workId=<%=work.getId()%>">
								<span class="t_bold"><%=workInstance.getSubject()%></span> 
							</a>
						</div>
						<!-- 인스턴스 마지막수정일자 -->
						<div class="vAlignBottom hAlignRight"><span class="t_date"><%=workInstance.getLastModifiedDate().toLocalString()%></span></div>
						<!-- 인스턴스 마지막수정일자 //-->
					</div>
				</li>
			
			<%
			}
		}
	}
	%>
