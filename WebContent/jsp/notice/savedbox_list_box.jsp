
<!-- Name 			: savedbox_list_box.jsp													 -->
<!-- Description	: 화면구성중에 Header 에서 현재사용자가 임시저장해놓은 항목의 목록들을 보여주는 박스 	 -->
<!-- Author			: Maninsoft, Inc.														 -->
<!-- Created Date	: 2011.9.																 -->

<%@page import="net.smartworks.model.instance.info.TaskInstanceInfo"%>
<%@page import="net.smartworks.model.mail.MailFolder"%>
<%@page import="net.smartworks.model.community.info.WorkSpaceInfo"%>
<%@page import="net.smartworks.model.work.info.SmartWorkInfo"%>
<%@page import="net.smartworks.model.instance.info.InstanceInfo"%>
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
	int noticeType = Notice.TYPE_SAVEDBOX;

	// 서버에게 lastNoticeId를 기준으로 최근 10개의 Notice항목을 가져오는 기능.
	NoticeBox noticeBox = smartWorks.getNoticeBoxForMe10(noticeType, lastNoticeId);

	NoticeMessage[] noticeMessages = noticeBox.getNoticeMessages();
	if (noticeMessages != null) {
		for (NoticeMessage nMessage : (NoticeMessage[]) noticeBox.getNoticeMessages()) {
			if (noticeBox != null && noticeBox.getNoticeType() == Notice.TYPE_SAVEDBOX) {
				InstanceInfo instance = nMessage.getInstance();
				SmartWorkInfo work = (SmartWorkInfo)instance.getWork();
				if(instance.getType() == Instance.TYPE_TASK)
					work = (SmartWorkInfo)((TaskInstanceInfo)instance).getWorkInstance().getWork();
				WorkSpaceInfo workSpace = instance.getWorkSpace();
				UserInfo owner = instance.getOwner();
				String targetContent = "", iconType="";
				switch(instance.getType()){
				
				// 업무인스턴스인 경우에는 정보관리업무만 임시저장 기능을 제공한다.
				case Instance.TYPE_WORK:
					if(work.getType() == SmartWork.TYPE_INFORMATION){
						targetContent = "iwork_space.sw?cid=" + ISmartWorks.CONTEXT_PREFIX_IWORK_SPACE + instance.getId();
						iconType = "ico_iworks";
					}
					break;
				
				// 태스크인스턴스인 경우에는 프로세스업무나 일정계획업무가 포함된다.
				case Instance.TYPE_TASK:
					if(work.getType() == SmartWork.TYPE_PROCESS){
						targetContent = "pwork_space.sw?cid=" + ISmartWorks.CONTEXT_PREFIX_PWORK_SPACE + instance.getId();
						iconType = "ico_iworks";
					}else if(work.getType() == SmartWork.TYPE_SCHEDULE){
						targetContent = "swork_space.sw?cid=" + ISmartWorks.CONTEXT_PREFIX_SWORK_SPACE + instance.getId();						
						iconType = "ico_iworks";
					}
					break;
				
				// 이메일인 경우에는 이메일 임시저장함에 저장 관리 된다.
				case Instance.TYPE_MAIL:
					targetContent = "mail_space.sw?folderId=" + MailFolder.ID_DRAFTS + "msgId=" + instance.getId();
					iconType = "ico_mail";					
					break;
				}
%>
				<li>
					<div class="info_img">
						<div class="<%=iconType%>"><%=work.getName()%></div>
					</div>
					<div class="info_list">
						<a href="<%=targetContent %>" ><%=instance.getSubject()%></a>		
						<div class="t_date"><%=instance.getCreatedDate().toLocalString()%></div>
					</div>
				</li>
<%
			}
		}
	}
%>
