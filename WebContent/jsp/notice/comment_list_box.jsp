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
	String companyId = (String) session.getAttribute("companyId");
	String userId = (String) session.getAttribute("userId");

	ISmartWorks smartWorks = (ISmartWorks) request.getAttribute("smartWorks");
	String sNoticeType = request.getParameter("noticeType");
	String sLastNotice = request.getParameter("dateOfLastNotice");
	int noticeType = (sNoticeType == null) ? Notice.TYPE_INVALID : Integer.parseInt(sNoticeType);
	LocalDate dateOfLastNotice = (sLastNotice == null) ? new LocalDate(0) : new LocalDate(Long.parseLong(sLastNotice));
	NoticeBox noticeBox = smartWorks.getNoticeBoxForMe10(companyId, userId, noticeType, dateOfLastNotice);
%>
<%
	NoticeMessage[] noticeMessages = noticeBox.getNoticeMessages();
	if (noticeMessages != null) {
		for (NoticeMessage nMessage : (NoticeMessage[]) noticeBox.getNoticeMessages()) {
	if (noticeBox != null && noticeBox.getNoticeType() == Notice.TYPE_COMMENTS) {
		CommentInstance commentInstance = (CommentInstance) nMessage.getInstance();
		String instContext = null, targetContent = null;
		User owner = commentInstance.getOwner();
		String userContext = ISmartWorks.CONTEXT_PREFIX_USER_SPACE + owner.getId();
		Work work = null;
		if (commentInstance.getCommentType() == CommentInstance.COMMENT_TYPE_ON_WORK_DESC
				|| commentInstance.getCommentType() == CommentInstance.COMMENT_TYPE_ON_WORK_MANUAL) {
			work = commentInstance.getWork();
			owner = commentInstance.getOwner();
			targetContent = SmartUtil.getTargetContentByWorkType(work.getType(), ISmartWorks.SPACE_TYPE_WORK_LIST);
			instContext = SmartUtil.getContextPrefixByWorkType(work.getType(), ISmartWorks.SPACE_TYPE_WORK_LIST) + work.getId();
%>
<li><div class="info_img">
		<a href="user_space.sw?cid=<%=userContext%>"
			title="<%=owner.getLongName()%>"> <img
			src="<%=owner.getMinPicture()%>" border="0"> </a>
	</div>
	<div class="info_list">
		<a href="<%=targetContent%>?cid=<%=instContext%>"><%=work.getName()%></a>
		<%=commentInstance.getComment()%>
		<div class="t_date"><%=commentInstance.getLastModifiedDate().toLocalString()%>
			<div class="btn_x">
				<a href="">X</a>
			</div>
		</div>
	</div>
</li>
<%
	} else if (commentInstance.getCommentType() == CommentInstance.COMMENT_TYPE_ON_WORK_INSTANCE) {
			work = commentInstance.getWorkInstance().getWork();
			WorkInstance workInstance = commentInstance.getWorkInstance();
			targetContent = SmartUtil.getTargetContentByWorkType(work.getType(), ISmartWorks.SPACE_TYPE_WORK_INSTANCE);
			instContext = SmartUtil.getContextPrefixByWorkType(work.getType(), ISmartWorks.SPACE_TYPE_WORK_INSTANCE) + workInstance.getId();
%>
<li><div class="info_img">
		<a href="user_space.sw?cid=<%=userContext%>"
			title="<%=owner.getLongName()%>"> <img
			src="<%=owner.getMinPicture()%>" border="0"> </a>
	</div>
	<div class="info_list">
		<a
			href="<%=targetContent%>?cid=<%=instContext%>&wid=<%=workInstance.getWorkSpace()%>"><%=workInstance.getSubject()%></a>
		<%=commentInstance.getComment()%>
		<div class="t_date"><%=commentInstance.getLastModifiedDate().toLocalString()%>
			<div class="btn_x">
				<a href="">X</a>
			</div>
		</div>
	</div>
</li>
<%
	} else if (commentInstance.getCommentType() == CommentInstance.COMMENT_TYPE_ON_TASK_INSTANCE) {
			work = commentInstance.getTaskInstance().getWorkInstance().getWork();
			TaskInstance taskInstance = commentInstance.getTaskInstance();
			targetContent = SmartUtil.getTargetContentByWorkType(work.getType(), ISmartWorks.SPACE_TYPE_TASK_INSTANCE);
			instContext = SmartUtil.getContextPrefixByWorkType(work.getType(), ISmartWorks.SPACE_TYPE_TASK_INSTANCE)
					+ taskInstance.getWorkInstance().getId();
%>
<li><div class="info_img">
		<a href="user_space.sw?cid=<%=userContext%>"
			title="<%=owner.getLongName()%>"> <img
			src="<%=owner.getMinPicture()%>" border="0"> </a>
	</div>
	<div class="info_list">
		<a
			href="<%=targetContent%>?cid=<%=instContext%>&wid=<%=taskInstance.getWorkInstance().getWorkSpace()%>"><%=taskInstance.getSubject()%></a>
		<%=commentInstance.getComment()%>
		<div class="t_date"><%=commentInstance.getLastModifiedDate().toLocalString()%>
			<div class="btn_x">
				<a href="">X</a>
			</div>
		</div>
	</div>
</li>
<%
	}
			}
		}
	}
%>
