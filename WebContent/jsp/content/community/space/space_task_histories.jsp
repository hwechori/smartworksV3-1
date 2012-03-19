<%@page import="net.smartworks.model.instance.WorkInstance"%>
<%@page import="net.smartworks.util.SmartTest"%>
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
			if(SmartUtil.isBlankObject(workSpace)) workSpace = workInstance.getOwner();
			boolean onWorkSpace = false;
			if(workSpace.getClass().equals(DepartmentInfo.class)){
				onWorkSpace = true;
			}else if(workSpace.getClass().equals(GroupInfo.class)){
				onWorkSpace = true;
			}
			BoardInstanceInfo board=null;
			EventInstanceInfo event=null;
			FileInstanceInfo file=null;
			ImageInstanceInfo image=null;
			MemoInstanceInfo memo=null;
	%>
			<li class="sub_instance_list js_sub_instance_list" instanceId="<%=workInstance.getId() %>" taskInstId="<%=taskInstance.getId()%>">
				<%
				switch(workInstance.getType()){
				
				// 태스크가 게시판인 경우...									
				case Instance.TYPE_BOARD:
					board = (BoardInstanceInfo)workInstance;
				%>
					<div class="det_title">
						<div class="noti_pic"><a class="js_pop_user_info" href="<%=owner.getSpaceController() %>?cid=<%=owner.getSpaceContextId()%>" userId="<%=owner.getId()%>" profile="<%=owner.getOrgPicture()%>" userDetail="<%=userDetailInfo%>"><img src="<%=owner.getMidPicture()%>" class="profile_size_m"></a></div>
						<div class="noti_in_m">
							<a href="<%=owner.getSpaceController() %>?cid=<%=owner.getSpaceContextId()%>"><span class="t_name"><%=owner.getLongName()%></span></a>
							<!-- 인스턴스 마지막수정일자 -->
							<span class="t_date vb pl10"><%=workInstance.getLastModifiedDate().toLocalString()%></span>
							<!-- 인스턴스 마지막수정일자 //-->
							<%if(onWorkSpace){ %><span class="arr">▶</span><a href="<%=workSpace.getSpaceController()%>?cid=<%=workSpace.getSpaceContextId()%>"><span class="<%=workSpace.getIconClass()%>"><%=workSpace.getName() %></span></a><%} %>
							<a href="<%=board.getController() %>?cid=<%=board.getContextId() %>&wid=<%=workSpace.getId() %>&workId=<%=work.getId() %>">
								<div>
									<span class="<%=work.getIconClass()%>"></span>
									<div><%=board.getSubject() %></div>
								</div>
								<div><%=board.getBriefContent()%></div>
							</a>
							<%if(!SmartUtil.isBlankObject(board.getFiles())){ %><div><%=SmartUtil.getFilesDetailInfo(board.getFiles()) %></div><%} %>
						</div>
					</div>
				<%
					break;
				// 태스크가 이벤트인 경우...									
				case Instance.TYPE_EVENT:
					event = (EventInstanceInfo)workInstance;
				%>
					<div class="det_title">
						<div class="noti_pic"><a class="js_pop_user_info" href="<%=owner.getSpaceController() %>?cid=<%=owner.getSpaceContextId()%>" userId="<%=owner.getId()%>" profile="<%=owner.getOrgPicture()%>" userDetail="<%=userDetailInfo%>"><img src="<%=owner.getMidPicture()%>" class="profile_size_m"></a></div>
						<div class="noti_in_m">
							<a href="<%=owner.getSpaceController() %>?cid=<%=owner.getSpaceContextId()%>"><span class="t_name"><%=owner.getLongName()%></span></a>
							<span class="t_date vb pl10"><%=workInstance.getLastModifiedDate().toLocalString()%></span>
							<%if(onWorkSpace){ %><span class="arr">▶</span><a href="<%=workSpace.getSpaceController()%>?cid=<%=workSpace.getSpaceContextId()%>"><span class="<%=workSpace.getIconClass()%>"><%=workSpace.getName() %></span></a><%} %>
							<a href="<%=event.getController() %>?cid=<%=event.getContextId() %>&wid=<%=workSpace.getId() %>&workId=<%=work.getId() %>">
								<div>
									<span class="<%=work.getIconClass()%>"></span>
									<div><%=event.getSubject() %></div>
								</div>
								<div><fmt:message key="common.upload.event.start_date"/> : <%=event.getStart().toLocalString() %> 
									<%if(!SmartUtil.isBlankObject(event.getEnd())) {%><fmt:message key="common.upload.event.end_date"/> : <%=event.getEnd().toLocalString() %> <%} %></div>
							</a>
						</div>
					</div>
				<%
					break;
				// 태스크가 파일인 경우...									
				case Instance.TYPE_FILE:
					file = (FileInstanceInfo)workInstance;
				%>
					<div class="det_title">
						<div class="noti_pic"><a class="js_pop_user_info" href="<%=owner.getSpaceController() %>?cid=<%=owner.getSpaceContextId()%>" userId="<%=owner.getId()%>" profile="<%=owner.getOrgPicture()%>" userDetail="<%=userDetailInfo%>"><img src="<%=owner.getMidPicture()%>" class="profile_size_m"></a></div>
						<div class="noti_in_m">
							<a href="<%=owner.getSpaceController() %>?cid=<%=owner.getSpaceContextId()%>"><span class="t_name"><%=owner.getLongName()%></span></a>
							<span class="t_date vb pl10"><%=workInstance.getLastModifiedDate().toLocalString()%></span>
							<%if(onWorkSpace){ %><span class="arr">▶</span><a href="<%=workSpace.getSpaceController()%>?cid=<%=workSpace.getSpaceContextId()%>"><span class="<%=workSpace.getIconClass()%>"><%=workSpace.getName() %></span></a><%} %>
							<%if(!SmartUtil.isBlankObject(file.getFiles())){ %><div><%=SmartUtil.getFilesDetailInfo(file.getFiles()) %></div><%} %>
							<%if(!SmartUtil.isBlankObject(file.getContent())){ %><div><%=file.getContent() %></div><%} %>
						</div>
					</div>
				<%
					break;
				// 태스크가 사진인 경우...									
				case Instance.TYPE_IMAGE:
					image = (ImageInstanceInfo)workInstance;
				%>
					<div class="det_title">
						<div class="noti_pic"><a class="js_pop_user_info" href="<%=owner.getSpaceController() %>?cid=<%=owner.getSpaceContextId()%>" userId="<%=owner.getId()%>" profile="<%=owner.getOrgPicture()%>" userDetail="<%=userDetailInfo%>"><img src="<%=owner.getMidPicture()%>" class="profile_size_m"></a></div>
						<div class="noti_in_m">
							<a href="<%=owner.getSpaceController() %>?cid=<%=owner.getSpaceContextId()%>"><span class="t_name"><%=owner.getLongName()%></span></a>
							<span class="t_date vb pl10"><%=workInstance.getLastModifiedDate().toLocalString()%></span>
							<%if(onWorkSpace){ %><span class="arr">▶</span><a href="<%=workSpace.getSpaceController()%>?cid=<%=workSpace.getSpaceContextId()%>"><span class="<%=workSpace.getIconClass()%>"><%=workSpace.getName() %></span></a><%} %>
							<div><a href="" class=""><img src="<%=image.getImgSource()%>" style="min-height:20px;width:200px;"></a></div>
							<%if(!SmartUtil.isBlankObject(image.getContent())){ %><div><%=image.getContent() %></div><%} %>
						</div>
					</div>
				<%
					break;
				// 태스크가 메모인 경우...									
				case Instance.TYPE_MEMO:
					memo = (MemoInstanceInfo)workInstance;
				%>
					<div class="det_title">
						<div class="noti_pic"><a class="js_pop_user_info" href="<%=owner.getSpaceController() %>?cid=<%=owner.getSpaceContextId()%>" userId="<%=owner.getId()%>" profile="<%=owner.getOrgPicture()%>" userDetail="<%=userDetailInfo%>"><img src="<%=owner.getMidPicture()%>" class="profile_size_m"></a></div>
						<div class="noti_in_m">
							<a href="<%=owner.getSpaceController() %>?cid=<%=owner.getSpaceContextId()%>"><span class="t_name"><%=owner.getLongName()%></span></a>
							<span class="t_date vb pl10"><%=workInstance.getLastModifiedDate().toLocalString()%></span>
							<%if(onWorkSpace){ %><span class="arr">▶</span><a href="<%=workSpace.getSpaceController()%>?cid=<%=workSpace.getSpaceContextId()%>"><span class="<%=workSpace.getIconClass()%>"><%=workSpace.getName() %></span></a><%} %>
							<a href="<%=memo.getController() %>?cid=<%=memo.getContextId() %>&wid=<%=workSpace.getId() %>&workId=<%=work.getId() %>">
								<div>
									<span class="<%=work.getIconClass()%>"></span>
									<div><%=memo.getContent() %></div>
								</div>
							</a>
						</div>
					</div>
				<%
					break;
				default:
				%>
					<div class="det_title">
						<div class="noti_pic"><a class="js_pop_user_info" href="<%=owner.getSpaceController() %>?cid=<%=owner.getSpaceContextId()%>" userId="<%=owner.getId()%>" profile="<%=owner.getOrgPicture()%>" userDetail="<%=userDetailInfo%>"><img src="<%=owner.getMidPicture()%>" class="profile_size_m"></a></div>
						<div class="noti_in_m">
							<a href="<%=owner.getSpaceController() %>?cid=<%=owner.getSpaceContextId()%>"><span class="t_name"><%=owner.getLongName()%></span></a>
							<span class="t_date vb pl10"><%=workInstance.getLastModifiedDate().toLocalString()%></span>
							<%if(onWorkSpace){ %><span class="arr">▶</span><a href="<%=workSpace.getSpaceController()%>?cid=<%=workSpace.getSpaceContextId()%>"><span class="<%=workSpace.getIconClass()%>"><%=workSpace.getName() %></span></a><%} %>
						<%
						String runningTaskName = taskInstance.getName();
						switch(taskInstance.getTaskType()){
						case TaskInstance.TYPE_APPROVAL_TASK_ASSIGNED:
						%>
							<fmt:message key="content.sentence.stask_forwarded">
								<fmt:param>
									<a href="<%=taskInstance.getController()%>?cid=<%=taskInstance.getContextId()%>&wid=<%=workInstance.getWorkSpace().getId()%>">
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
									<a href="<%=taskInstance.getController()%>?cid=<%=taskInstance.getContextId()%>&wid=<%=workInstance.getWorkSpace().getId()%>">
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
									<a href='<%=taskInstance.getController()%>?cid=<%=taskInstance.getContextId()%>&wid=<%=workInstance.getWorkSpace().getId()%>'>
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
									<a href="<%=taskInstance.getController()%>?cid=<%=taskInstance.getContextId()%>&wid=<%=workInstance.getWorkSpace().getId()%>">
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
									<a href="<%=taskInstance.getController()%>?cid=<%=taskInstance.getContextId()%>&wid=<%=workInstance.getWorkSpace().getId()%>">
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
									<a href="<%=taskInstance.getController()%>?cid=<%=taskInstance.getContextId()%>&wid=<%=workInstance.getWorkSpace().getId()%>">
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
									<a href="<%=taskInstance.getController()%>?cid=<%=taskInstance.getContextId()%>&wid=<%=workInstance.getWorkSpace().getId()%>">
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
									<a href="<%=taskInstance.getController()%>?cid=<%=taskInstance.getContextId()%>&wid=<%=workInstance.getWorkSpace().getId()%>">
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
							<a href="<%=work.getController()%>?cid=<%=work.getContextId()%>&wid=<%=cUser.getId()%>">
								<span class="<%=work.getIconClass()%>"></span>
								<span class="t_date"><%=work.getFullpathName()%></span>
							</a>
							<a href="<%=((WorkInstanceInfo)workInstance).getController()%>?cid=<%=((WorkInstanceInfo)workInstance).getContextId()%>&wid=<%=workInstance.getWorkSpace().getId()%>&workId=<%=work.getId()%>">
								<span class="t_bold"><%=workInstance.getSubject()%></span> 
							</a>
						</div>
					</div>
				<%
				}
				
				%>
				<!-- 댓글 -->
			   <div class="reply_point pos_reply_point"></div>
			   <div class="reply_section pos_reply">  
			        <div class="list_reply">
			        	<%
			        	WorkInstanceInfo instance = (WorkInstanceInfo)workInstance;
			        	%>
			            <ul class="js_comment_list">
			            	<li class="comment_list js_comment_instance" style="display:none">
								<div class="noti_pic">
									<a class="js_pop_user_info" href="<%=cUser.getSpaceController() %>?cid=<%=cUser.getSpaceContextId()%>" userId="<%=cUser.getId()%>" profile="<%=cUser.getOrgPicture()%>" userDetail="<%=SmartUtil.getUserDetailInfo(cUser.getUserInfo())%>">
										<img src="<%=cUser.getMinPicture()%>" align="bottom" class="profile_size_c"/>
									</a>
								</div>
								<div class="noti_in">
									<span class="t_name"><%=cUser.getLongName()%></span><span
										class="t_date"><%=(new LocalDate()).toLocalString()%></span>
									<div class="js_comment_content"></div>
								</div>
			            	</li>
			            	<%
			            	if(instance.getSubInstanceCount()>WorkInstance.DEFAULT_SUB_INSTANCE_FETCH_COUNT){
								session.setAttribute("subComments", instance.getSubInstances());
			            	%>
				            	<li>
				            		<img class="repl_tinfo">
			            			<a href="sub_instances_in_instance.sw?instanceId=<%=instance.getId()%>&fetchCount=<%=WorkInstance.FETCH_ALL_SUB_INSTANCE %>" class="js_show_all_comments">
			            				<span><strong><fmt:message key="common.title.show_all_comments"><fmt:param><%=instance.getSubInstanceCount() %></fmt:param><</fmt:message></strong></span>
			            			</a>
				            	</li>
								<jsp:include page="/jsp/content/work/list/sub_instances_in_instance.jsp" >
									<jsp:param value="<%=instance.getId() %>" name="instanceId"/>
									<jsp:param value="<%=WorkInstance.DEFAULT_SUB_INSTANCE_FETCH_COUNT %>" name="fetchCount"/>
								</jsp:include>
							<%
							}
							%>
						</ul>
			        </div>
			        
			        <div class="reply_input comment_box js_return_on_comment">
						<div class="noti_pic">
							<img src="<%=cUser.getMinPicture()%>" class="profile_size_c"/>
						</div>
						<div class="noti_in">
							<textarea workType="<%=work.getType() %>" style="width:95%" class="up_textarea" name="txtaCommentContent" placeholder="<fmt:message key='work.message.leave_comment'/>"></textarea>
						</div>
			        </div>
			    
			    </div>
			    <!-- 댓글 //-->
			</li>
	<%		
		}
	}
	%>
