<%@page import="net.smartworks.model.community.info.UserInfo"%>
<%@page import="net.smartworks.model.instance.info.AsyncMessageInstanceInfo"%>
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
			String instContext = null;
			if (noticeBox != null && noticeBox.getNoticeType() == Notice.TYPE_MESSAGE) {
				AsyncMessageInstanceInfo messageInstance = (AsyncMessageInstanceInfo) nMessage.getInstance();
				UserInfo owner = messageInstance.getSender();
				instContext = ISmartWorks.CONTEXT_PREFIX_USER_SPACE + owner.getId();
%>
<li><div class="info_img">
		<a href="user_space.sw?cid=<%=instContext%>"
			title="<%=owner.getLongName()%>"> <img
			src="<%=owner.getMinPicture()%>" border="0"> </a>
	</div>
	<div class="info_list"><%=messageInstance.getMessage()%>
		<div class="t_date"><%=messageInstance.getSendDate().toLocalString()%>
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
%>
