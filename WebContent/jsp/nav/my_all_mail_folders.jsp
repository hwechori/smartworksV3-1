
<!-- Name 			: my_all_mail_folders.jsp										 -->
<!-- Description	: 좌측의 Navigation Bar 의  메일에서 메일폴더들을 가져다 보여주는 화면 	 -->
<!-- Author			: Maninsoft, Inc.												 -->
<!-- Created Date	: 2011.9.														 -->

<%@page import="net.smartworks.model.mail.MailFolder"%>
<%@page import="net.smartworks.model.community.User"%>
<%@page import="net.smartworks.model.work.info.WorkInfo"%>
<%@page import="net.smartworks.util.SmartUtil"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="net.smartworks.service.ISmartWorks"%>
<%@ page import="net.smartworks.model.work.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	// 스마트웍스 서비스들을 사용하기위한 핸들러를 가져온다. 현재사용자 정보도 가져온다 
	ISmartWorks smartWorks = (ISmartWorks) request.getAttribute("smartWorks");
	User currentUser = SmartUtil.getCurrentUser();

	// 메일서버에서 현재사용자의 폴더정보들을 가져온다...
	MailFolder[] folders = smartWorks.getMailFoldersById("");;
%>
<!--  다국어 지원을 위해, 로케일 및 다국어 resource bundle 을 설정 한다. -->
<fmt:setLocale value="<%=currentUser.getLocale() %>" scope="request" />
<fmt:setBundle basename="resource.smartworksMessage" scope="request" />

<ul>
	<%
	if(folders != null){
		for (MailFolder folder : folders) {
	%>
			<li>
				<!--  모든폴더에 공통으로 필요한 html -->
				<a href="mail_list.sw?cid=<%=folder.getId()%>" class="js_content" folderId="<%=folder.getId()%>"> 

					<%
					// 받은편지함인 경우  
					if(folder.getType() == MailFolder.TYPE_SYSTEM_INBOX){
					%>
						<span class="ico_pe"><img class="ico_mail_inbox"></span> 
						<span class=""><fmt:message key="mail.title.folder.inbox"/></span>
						<%if (folder.getUnreadItemCount() > 0) {%><span>(<%=folder.getUnreadItemCount()%>)</span><%}%>						
					<%
					// 보낸 편지함이니 경우 
					}else if(folder.getType() == MailFolder.TYPE_SYSTEM_SENT){
					%>
						<span class="ico_pe"><img class="ico_mail_sent"></span> 
						<span class=""><fmt:message key="mail.title.folder.sent"/></span>
						<%if (folder.getUnreadItemCount() > 0) {%><span>(<%=folder.getUnreadItemCount()%>)</span><%}%>						
					<%
					// 휴지통인 경우 
					}else if(folder.getType() == MailFolder.TYPE_SYSTEM_TRASH){
					%>
						<span class="ico_pe"><img class="ico_mail_trash"></span> 
						<span class=""><fmt:message key="mail.title.folder.trash"/></span>
						<%if (folder.getUnreadItemCount() > 0) {%><span>(<%=folder.getUnreadItemCount()%>)</span><%}%>						
					<%
					// 임시보관함인 경우  
					}else if(folder.getType() == MailFolder.TYPE_SYSTEM_DRAFTS){
					%>
						<span class="ico_pe"><img class="ico_mail_drafts"></span> 
						<span class=""><fmt:message key="mail.title.folder.drafts"/></span>
						<%if (folder.getUnreadItemCount() > 0) {%><span>(<%=folder.getUnreadItemCount()%>)</span><%}%>						
					<%
					// 스팸함인 경우 
					}else if(folder.getType() == MailFolder.TYPE_SYSTEM_JUNK){
					%>
						<span class="ico_pe"><img class="ico_mail_junk"></span> 
						<span class="nav_subtitl_area"><fmt:message key="mail.title.folder.junk"/></span>
						<%if (folder.getUnreadItemCount() > 0) {%><span>(<%=folder.getUnreadItemCount()%>)</span><%}%>						
					<%
					// 사용자 정의 폴더인 경우  
					}else if(folder.getType() == MailFolder.TYPE_USER){
					%>
						<span class="ico_pe"><img class="ico_mail_folder_add"></span> 
						<span class=""><%=folder.getName()%></span>
						<%if (folder.getUnreadItemCount() > 0) {%><span>(<%=folder.getUnreadItemCount()%>)</span><%}%>						
					<%
					}
					%>
				</a>
			</li>
	<%
		}
	}
	%>
</ul>
