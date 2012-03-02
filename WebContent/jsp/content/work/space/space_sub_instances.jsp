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

	InstanceInfo[] subInstances = (InstanceInfo[])session.getAttribute("subInstances");
	
%>
<!--  다국어 지원을 위해, 로케일 및 다국어 resource bundle 을 설정 한다. -->
<fmt:setLocale value="<%=cUser.getLocale() %>" scope="request" />
<fmt:setBundle basename="resource.smartworksMessage" scope="request" />

	<%
	if(!SmartUtil.isBlankObject(subInstances) && subInstances.length > 0){
		for(int i=0; i<subInstances.length; i++){
			InstanceInfo workInstance = subInstances[i];
			if(workInstance.getType()<0){
				String lastDateStr = (i>0) ? (new LocalDate(subInstances[i-1].getLastModifiedDate().getTime())).toLocalDateString2() : ""; 
	%>
				<li class="t_nowork"><a href="" class="js_space_more_instance" lastDate="<%=lastDateStr%>"><fmt:message key="common.message.more_work_task"></fmt:message></a></li>
	<%
				break;
			}
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

			switch(workInstance.getType()){
			
			// 태스크가 게시판인 경우...									
			case Instance.TYPE_BOARD:
				board = (BoardInstanceInfo)workInstance;
	%>
				<li>
					<div class="det_title">
						<div class="noti_pic"><a class="js_pop_user_info" href="<%=owner.getSpaceController() %>?cid=<%=owner.getSpaceContextId()%>" userId="<%=owner.getId()%>" profile="<%=owner.getOrgPicture()%>" userDetail="<%=userDetailInfo%>"><img src="<%=owner.getMidPicture()%>" class="profile_size_m"></a></div>
						<div class="noti_in_m">
							<a href="<%=owner.getSpaceController() %>?cid=<%=owner.getSpaceContextId()%>"><span class="t_name"><%=owner.getLongName()%></span></a><%if(onWorkSpace){ %><span class="arr">▶</span>
							<a href="<%=workSpace.getSpaceController()%>?cid=<%=workSpace.getSpaceContextId()%>"><span class="<%=workSpace.getIconClass()%>"><%=workSpace.getName() %></span></a><%} %>
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
						<div class="noti_pic"><a class="js_pop_user_info" href="<%=owner.getSpaceController() %>?cid=<%=owner.getSpaceContextId()%>" userId="<%=owner.getId()%>" profile="<%=owner.getOrgPicture()%>" userDetail="<%=userDetailInfo%>"><img src="<%=owner.getMidPicture()%>" class="profile_size_m"></a></div>
						<div class="noti_in_m">
							<a href="<%=owner.getSpaceController() %>?cid=<%=owner.getSpaceContextId()%>"><span class="t_name"><%=owner.getLongName()%></span></a><%if(onWorkSpace){ %><span class="arr">▶</span>
							<a href="<%=workSpace.getSpaceController()%>?cid=<%=workSpace.getSpaceContextId()%>"><span class="<%=workSpace.getIconClass()%>"><%=workSpace.getName() %></span></a><%} %>
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
						<div class="noti_pic"><a class="js_pop_user_info" href="<%=owner.getSpaceController() %>?cid=<%=owner.getSpaceContextId()%>" userId="<%=owner.getId()%>" profile="<%=owner.getOrgPicture()%>" userDetail="<%=userDetailInfo%>"><img src="<%=owner.getMidPicture()%>" class="profile_size_m"></a></div>
						<div class="noti_in_m">
							<a href="<%=owner.getSpaceController() %>?cid=<%=owner.getSpaceContextId()%>"><span class="t_name"><%=owner.getLongName()%></span></a><%if(onWorkSpace){ %><span class="arr">▶</span>
							<a href="<%=workSpace.getSpaceController()%>?cid=<%=workSpace.getSpaceContextId()%>"><span class="<%=workSpace.getIconClass()%>"><%=workSpace.getName() %></span></a><%} %>
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
						<div class="noti_pic"><a class="js_pop_user_info" href="<%=owner.getSpaceController() %>?cid=<%=owner.getSpaceContextId()%>" userId="<%=owner.getId()%>" profile="<%=owner.getOrgPicture()%>" userDetail="<%=userDetailInfo%>"><img src="<%=owner.getMidPicture()%>" class="profile_size_m"></a></div>
						<div class="noti_in_m">
							<a href="<%=owner.getSpaceController() %>?cid=<%=owner.getSpaceContextId()%>"><span class="t_name"><%=owner.getLongName()%></span></a><%if(onWorkSpace){ %><span class="arr">▶</span>
							<a href="<%=workSpace.getSpaceController()%>?cid=<%=workSpace.getSpaceContextId()%>"><span class="<%=workSpace.getIconClass()%>"><%=workSpace.getName() %></span></a><%} %>
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
						<div class="noti_pic"><a class="js_pop_user_info" href="<%=owner.getSpaceController() %>?cid=<%=owner.getSpaceContextId()%>" userId="<%=owner.getId()%>" profile="<%=owner.getOrgPicture()%>" userDetail="<%=userDetailInfo%>"><img src="<%=owner.getMidPicture()%>" class="profile_size_m"></a></div>
						<div class="noti_in_m">
							<a href="<%=owner.getSpaceController() %>?cid=<%=owner.getSpaceContextId()%>"><span class="t_name"><%=owner.getLongName()%></span></a><%if(onWorkSpace){ %><span class="arr">▶</span>
							<a href="<%=workSpace.getSpaceController()%>?cid=<%=workSpace.getSpaceContextId()%>"><span class="<%=workSpace.getIconClass()%>"><%=workSpace.getName() %></span></a><%} %>
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
					<div class="noti_pic"><a class="js_pop_user_info" href="<%=owner.getSpaceController() %>?cid=<%=owner.getSpaceContextId()%>" userId="<%=owner.getId()%>" profile="<%=owner.getOrgPicture()%>" userDetail="<%=userDetailInfo%>"><img src="<%=owner.getMidPicture()%>" class="profile_size_m"></a></div>
					<div class="noti_in_m">
						<a href="<%=owner.getSpaceController() %>?cid=<%=owner.getSpaceContextId()%>"><span class="t_name"><%=owner.getLongName()%></span></a><%if(onWorkSpace){ %><span class="arr">▶</span>
						<a href="<%=workSpace.getSpaceController()%>?cid=<%=workSpace.getSpaceContextId()%>"><span class="<%=workSpace.getIconClass()%>"><%=workSpace.getName() %></span></a><%} %>
						<div><%=workInstance.getSubject() %></div>
						<!-- 인스턴스 마지막수정일자 -->
						<div class="vAlignBottom hAlignRight"><span class="t_date"><%=workInstance.getLastModifiedDate().toLocalString()%></span></div>
						<!-- 인스턴스 마지막수정일자 //-->
					</div>
				</div>
			</li>							
	<%
			}
		}
	}
	%>
