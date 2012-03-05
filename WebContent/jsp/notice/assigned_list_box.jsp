
<!-- Name 			: assigned_list_box.jsp											 -->
<!-- Description	: 화면구성중에 Header 에서 현재사용자에게 할당된 업무 목록들을 보여주는 박스  -->
<!-- Author			: Maninsoft, Inc.												 -->
<!-- Created Date	: 2011.9.														 -->

<%@page import="net.smartworks.model.instance.info.WorkInstanceInfo"%>
<%@page import="net.smartworks.model.work.info.WorkInfo"%>
<%@page import="net.smartworks.model.instance.info.InstanceInfo"%>
<%@page import="net.smartworks.model.community.info.UserInfo"%>
<%@page import="net.smartworks.model.instance.info.TaskInstanceInfo"%>
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
<%@ page import="java.util.Date"%>
<%
	// 스마트웍스 서비스들을 사용하기위한 핸들러를 가져온다.
	ISmartWorks smartWorks = (ISmartWorks) request.getAttribute("smartWorks");

	// 호출될때 전달되는 lastNoticeId를 가져온다.
	String lastNoticeId = request.getParameter("lastNoticeId");
	int noticeType = Notice.TYPE_ASSIGNED;

	// 서버에게 lastNoticeId를 기준으로 최근 10개의 Notice항목을 가져오는 기능.
	NoticeBox noticeBox = smartWorks.getNoticeBoxForMe10(noticeType, lastNoticeId);

	NoticeMessage[] noticeMessages = (NoticeMessage[]) noticeBox.getNoticeMessages();
	if (noticeMessages != null) {
		for (NoticeMessage nMessage : noticeMessages) {
			if (noticeBox != null && noticeBox.getNoticeType() == Notice.TYPE_ASSIGNED) {
				TaskInstanceInfo taskInstance = (TaskInstanceInfo) nMessage.getInstance();
				int taskType = taskInstance.getTaskType();
				if (taskType == TaskInstance.TYPE_PROCESS_TASK_ASSIGNED || taskType == TaskInstance.TYPE_APPROVAL_TASK_ASSIGNED
						|| taskType == TaskInstance.TYPE_INFORMATION_TASK_ASSIGNED || taskType == TaskInstance.TYPE_INFORMATION_TASK_FORWARDED
						|| taskType == TaskInstance.TYPE_PROCESS_TASK_FORWARDED) {
					UserInfo owner = taskInstance.getOwner();
					WorkInstanceInfo workInstance = taskInstance.getWorkInstance();
					WorkInfo work = workInstance.getWork();
					String workSpaceId = taskInstance.getWorkSpace().getId();
%>
					<ul>
					<li>
					<div class="info_ms_section">
						<div class="info_img">
							<a href="<%=owner.getSpaceController() %>?cid=<%=owner.getSpaceContextId()%>" title="<%=owner.getLongName()%>">
								<img src="<%=owner.getMinPicture()%>"  class="profile_size_s"></a>
						</div>
						<div class="info_list">
							<a href="<%=workInstance.getController()%>?cid=<%=workInstance.getContextId()%>&wid=<%=workSpaceId%>"><%=workInstance.getSubject()%>▶<%=taskInstance.getName()%></a>
							<div class="t_date"><%=taskInstance.getLastModifiedDate().toLocalString()%></div>
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
