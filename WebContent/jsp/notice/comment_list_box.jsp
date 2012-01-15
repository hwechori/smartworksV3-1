
<!-- Name 			: comment_list_box.jsp									 -->
<!-- Description	: 화면구성중에 Header 에서 새로운 댓글 목록들을 보여주는 박스 	 -->
<!-- Author			: Maninsoft, Inc.										 -->
<!-- Created Date	: 2011.9.												 -->

<%@page import="net.smartworks.model.community.info.GroupInfo"%>
<%@page import="net.smartworks.model.community.info.DepartmentInfo"%>
<%@page import="net.smartworks.model.community.info.WorkSpaceInfo"%>
<%@page import="net.smartworks.model.instance.info.TaskInstanceInfo"%>
<%@page import="net.smartworks.model.instance.info.InstanceInfo"%>
<%@page import="net.smartworks.model.community.info.UserInfo"%>
<%@page import="net.smartworks.model.work.info.WorkInfo"%>
<%@page import="net.smartworks.model.instance.info.CommentInstanceInfo"%>
<%@page import="net.smartworks.util.SmartUtil"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="net.smartworks.service.ISmartWorks"%>
<%@ page import="net.smartworks.model.community.*"%>
<%@ page import="net.smartworks.model.notice.*"%>
<%@ page import="net.smartworks.model.instance.*"%>
<%@ page import="net.smartworks.model.work.*"%>
<%@ page import="net.smartworks.util.LocalDate"%>
<%
	// 스마트웍스 서비스들을 사용하기위한 핸들러를 가져온다.
	ISmartWorks smartWorks = (ISmartWorks) request.getAttribute("smartWorks");
	User cUser = SmartUtil.getCurrentUser();

	// 호출될때 전달되는 lastNoticeId를 가져온다.
	String lastNoticeId = request.getParameter("lastNoticeId");
	int noticeType = Notice.TYPE_COMMENT;
	NoticeBox noticeBox = smartWorks.getNoticeBoxForMe10(noticeType, lastNoticeId);

	// 서버에게 lastNoticeId를 기준으로 최근 10개의 Notice항목을 가져오는 기능.
	NoticeMessage[] noticeMessages = noticeBox.getNoticeMessages();
	if (noticeMessages != null) {
		for (NoticeMessage nMessage : (NoticeMessage[]) noticeBox.getNoticeMessages()) {
			if (noticeBox != null && noticeBox.getNoticeType() == Notice.TYPE_COMMENT) {
				CommentInstanceInfo commentInstance = (CommentInstanceInfo) nMessage.getInstance();
				String instContext = null, targetContent = null;
				UserInfo owner = commentInstance.getOwner();
				String userContext = ISmartWorks.CONTEXT_PREFIX_USER_SPACE + owner.getId();
				WorkInfo work = null;

				// 업무 매뉴얼에 댓글로 의견을 남긴 경우  
				if (commentInstance.getCommentType() == CommentInstance.COMMENT_TYPE_ON_WORK_MANUAL) {
					work = commentInstance.getWork();
					owner = commentInstance.getOwner();
					targetContent = SmartUtil.getTargetContentByWorkType(work.getType(), ISmartWorks.SPACE_TYPE_WORK_LIST);
					instContext = SmartUtil.getContextPrefixByWorkType(work.getType(), ISmartWorks.SPACE_TYPE_WORK_LIST) + work.getId();
%>
					<ul>
					<li>
					<div class="info_ms_section">
						<div class="info_img">
							<a href="user_space.sw?cid=<%=userContext%>" title="<%=owner.getLongName()%>">
								<img src="<%=owner.getMinPicture()%>" class="profile_size_s"> </a>
						</div>
						<div class="info_list">
							<a href="<%=targetContent%>?cid=<%=instContext%>"><%=work.getName()%></a>
							<%=commentInstance.getComment()%>
							<div class="t_date"><%=commentInstance.getLastModifiedDate().toLocalString()%>
								<a href="" noticeId=<%=nMessage.getId() %> noticeType="<%=noticeType%>" lastNoticeId=<%=lastNoticeId %>>
									<div class="btn_x js_remove_notice" ></div></a>
							</div>
						</div>
					</div>
					</li>
				<%
				// 업무 인스턴스 공간에 댓글을 남긴 경우   
				} else if (commentInstance.getCommentType() == CommentInstance.COMMENT_TYPE_ON_WORK_INSTANCE) {
					work = commentInstance.getWorkInstance().getWork();
					InstanceInfo workInstance = commentInstance.getWorkInstance();
					targetContent = SmartUtil.getTargetContentByWorkType(work.getType(), ISmartWorks.SPACE_TYPE_WORK_INSTANCE);
					instContext = SmartUtil.getContextPrefixByWorkType(work.getType(), ISmartWorks.SPACE_TYPE_WORK_INSTANCE) + workInstance.getId();
				%>
					<li>
					<div class="info_ms_section">
						<div class="info_img">
							<a href="user_space.sw?cid=<%=userContext%>"title="<%=owner.getLongName()%>">
								<img src="<%=owner.getMinPicture()%>"  class="profile_size_s"> </a>
						</div>
						<div class="info_list">
							<a href="<%=targetContent%>?cid=<%=instContext%>&wid=<%=workInstance.getWorkSpace()%>"><%=workInstance.getSubject()%></a>
							<%=commentInstance.getComment()%>
							<div class="t_date"><%=commentInstance.getLastModifiedDate().toLocalString()%>
								<a href="" noticeId=<%=nMessage.getId() %> noticeType="<%=noticeType%>" lastNoticeId=<%=lastNoticeId %>>
									<div class="btn_x js_remove_notice" ></div></a>
							</div>
						</div>
						</div>
					</li>
				<%
				// 태스크 인스턴스 공간에 댓글을 남긴 경우   
				} else if (commentInstance.getCommentType() == CommentInstance.COMMENT_TYPE_ON_TASK_INSTANCE) {
					work = commentInstance.getTaskInstance().getWorkInstance().getWork();
					TaskInstanceInfo taskInstance = commentInstance.getTaskInstance();
					targetContent = SmartUtil.getTargetContentByWorkType(work.getType(), ISmartWorks.SPACE_TYPE_TASK_INSTANCE);
					instContext = SmartUtil.getContextPrefixByWorkType(work.getType(), ISmartWorks.SPACE_TYPE_TASK_INSTANCE)
							+ taskInstance.getWorkInstance().getId();
				%>
					<li>
					<div class="info_ms_section">
						<div class="info_img">
							<a href="user_space.sw?cid=<%=userContext%>" title="<%=owner.getLongName()%>">
								<img src="<%=owner.getMinPicture()%>"  class="profile_size_s"> </a>
						</div>
						<div class="info_list">
							<a href="<%=targetContent%>?cid=<%=instContext%>&wid=<%=taskInstance.getWorkInstance().getWorkSpace()%>"><%=taskInstance.getSubject()%></a>
							<%=commentInstance.getComment()%>
							<div class="t_date"><%=commentInstance.getLastModifiedDate().toLocalString()%>
								<a href="" noticeId=<%=nMessage.getId() %> noticeType="<%=noticeType%>" lastNoticeId=<%=lastNoticeId %>>
									<div class="btn_x js_remove_notice" ></div></a>
							</div>
						</div>
						</div>
					</li>
				<%
				// Community 및 업무 공간에 댓글을 남긴 경우   
				} else if (commentInstance.getCommentType() == CommentInstance.COMMENT_TYPE_ON_WORK_SPACE) {
					WorkSpaceInfo workSpace = commentInstance.getWorkSpace();
					if(workSpace.getClass().equals(UserInfo.class)){
						targetContent = "user_space.sw";
						instContext = ISmartWorks.CONTEXT_PREFIX_USER_SPACE + workSpace.getId();
					}else if(workSpace.getClass().equals(GroupInfo.class)){
						targetContent = "group_space.sw";
						instContext = ISmartWorks.CONTEXT_PREFIX_GROUP_SPACE + workSpace.getId();
					}else if(workSpace.getClass().equals(DepartmentInfo.class)){
						targetContent = "department_space.sw";
						instContext = ISmartWorks.CONTEXT_PREFIX_DEPARTMENT_SPACE + workSpace.getId();
					}
				%>
					<li>
					<div class="info_ms_section">
						<div class="info_img">
							<a href="user_space.sw?cid=<%=userContext%>" title="<%=owner.getLongName()%>">
								<img src="<%=owner.getMinPicture()%>"  class="profile_size_s"> </a>
						</div>
						<div class="info_list">
							<a href="<%=targetContent%>?cid=<%=instContext%>"><%=workSpace.getName()%></a>
							<%=commentInstance.getComment()%>
							<div class="t_date"><%=commentInstance.getLastModifiedDate().toLocalString()%>
								<a href="" noticeId=<%=nMessage.getId() %> noticeType="<%=noticeType%>" lastNoticeId=<%=lastNoticeId %>>
									<div class="btn_x js_remove_notice" ></div></a>
							</div>
						</div>
						</div>
					</li>
					</ul>
	<%
				}
			}
		}
	}
	%>
