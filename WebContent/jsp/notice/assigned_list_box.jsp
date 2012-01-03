
<!-- Name 			: assigned_list_box.jsp											 -->
<!-- Description	: 화면구성중에 Header 에서 현재사용자에게 할당된 업무 목록들을 보여주는 박스  -->
<!-- Author			: Y.S. JUNG														 -->
<!-- Created Date	: 2011.9.														 -->

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
					InstanceInfo workInstance = taskInstance.getWorkInstance();
					WorkInfo work = workInstance.getWork();
					String targetContent = SmartUtil.getTargetContentByWorkType(work.getType(), ISmartWorks.SPACE_TYPE_TASK_INSTANCE);
					String contextId = SmartUtil.getContextPrefixByWorkType(work.getType(), ISmartWorks.SPACE_TYPE_TASK_INSTANCE)
							+ taskInstance.getId();
					String workSpaceId = taskInstance.getWorkSpace().getId();
					String userContext = ISmartWorks.CONTEXT_PREFIX_USER_SPACE + owner.getId();
%>
					<li>
						<div class="info_img">
							<a href="user_space.sw?cid=<%=userContext%>" title="<%=owner.getLongName()%>">
								<img src="<%=owner.getMinPicture()%>" border="0"></a>
						</div>
						<div class="info_list">
							<a href="<%=targetContent%>?cid=<%=contextId%>&wid=<%=workSpaceId%>"><%=workInstance.getSubject()%>▶<%=taskInstance.getName()%></a>
							<div class="t_date"><%=taskInstance.getLastModifiedDate().toLocalString()%></div>
						</div>
					</li>
<%
				}
			}
		}
	}
%>
