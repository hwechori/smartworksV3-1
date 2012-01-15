
<!-- Name 			: mailbox_list_box.jsp										 -->
<!-- Description	: 화면구성중에 Header 에서 새로 도착한 메일 목록들을 보여주는 박스 	 -->
<!-- Author			: Maninsoft, Inc.											 -->
<!-- Created Date	: 2011.9.													 -->

<%@page import="net.smartworks.model.mail.MailFolder"%>
<%@page import="net.smartworks.model.community.info.UserInfo"%>
<%@page import="net.smartworks.util.SmartUtil"%>
<%@page import="net.smartworks.model.instance.info.MailInstanceInfo"%>
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

	// 호출될때 전달되는 lastNoticeId를 가져온다.
	String lastNoticeId = request.getParameter("lastNoticeId");
	int noticeType = Notice.TYPE_MAILBOX;

	// 서버에게 lastNoticeId를 기준으로 최근 10개의 Notice항목을 가져오는 기능.
	NoticeBox noticeBox = smartWorks.getNoticeBoxForMe10(noticeType, lastNoticeId);

	NoticeMessage[] noticeMessages = noticeBox.getNoticeMessages();
	if (noticeMessages != null) {
		for (NoticeMessage nMessage : (NoticeMessage[]) noticeBox.getNoticeMessages()) {
			if (noticeBox != null && noticeBox.getNoticeType() == Notice.TYPE_MAILBOX) {
				MailInstanceInfo mailInstance = (MailInstanceInfo) nMessage.getInstance();
				UserInfo owner = mailInstance.getSender();
				String instContext = ISmartWorks.CONTEXT_PREFIX_MAIL_SPACE + owner.getId();
%>
				<ul>
					<li>
						<div class="info_ms_section">
						<div class="info_img"><b><%=owner.getName()%> </b></div>
						<div class="info_list">
							<a href="mail_space.sw?folderId=<%=MailFolder.ID_INBOX %>&msgId=<%=mailInstance.getId()%>"><%=mailInstance.getSubject()%></a>
							<div class="t_date"><%=mailInstance.getSendDate().toLocalString()%></div>
						</div>
						</div>
					</li>
				</ul>
<%
			}
		}
	}
%>
