<%@page import="net.smartworks.model.mail.MailFolder"%>
<%@page import="net.smartworks.model.community.User"%>
<%@page import="net.smartworks.model.work.info.WorkInfo"%>
<%@page import="net.smartworks.util.SmartUtil"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="net.smartworks.service.ISmartWorks"%>
<%@ page import="net.smartworks.model.work.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	ISmartWorks smartWorks = (ISmartWorks) request.getAttribute("smartWorks");
	User currentUser = SmartUtil.getCurrentUser();
	MailFolder[] folders = smartWorks.getMailFoldersById("");;
%>
<fmt:setLocale value="<%=currentUser.getLocale() %>" scope="request" />
<fmt:setBundle basename="resource.smartworksMessage" scope="request" />

<ul>
	<%
	if(folders != null){
		for (MailFolder folder : folders) {
	%>
	<li>
		<a href="mail_list.sw?cid=<%=folder.getId()%>" class="js_content" 
			folderId="<%=folder.getId()%>"> <span class="ico_iworks"></span> 
			<%
			if(folder.getType() == MailFolder.TYPE_SYSTEM_INBOX){
			%>
				<span class="nav_subtitl_area"><fmt:message key="mail.title.folder.inbox"/>
				<%
				if (folder.getUnreadItemCount() > 0) {
				%>
					<span>(<%=folder.getUnreadItemCount()%>)</span>
				<%
				}
				%>
				</span>
			<%
			}else if(folder.getType() == MailFolder.TYPE_SYSTEM_SENT){
			%>
				<span class="nav_subtitl_area"><fmt:message key="mail.title.folder.sent"/>
				<%
				if (folder.getUnreadItemCount() > 0) {
				%>
					<span>(<%=folder.getUnreadItemCount()%>)</span>
				<%
				}
				%>
				</span>
			<%
			}else if(folder.getType() == MailFolder.TYPE_SYSTEM_TRASH){
			%>
				<span class="nav_subtitl_area"><fmt:message key="mail.title.folder.trash"/>
				<%
				if (folder.getUnreadItemCount() > 0) {
				%>
					<span>(<%=folder.getUnreadItemCount()%>)</span>
				<%
				}
				%>
				</span>
			<%
			}else if(folder.getType() == MailFolder.TYPE_SYSTEM_DRAFTS){
			%>
				<span class="nav_subtitl_area"><fmt:message key="mail.title.folder.drafts"/>
				<%
				if (folder.getUnreadItemCount() > 0) {
				%>
					<span>(<%=folder.getUnreadItemCount()%>)</span>
				<%
				}
				%>
				</span>
			<%
			}else if(folder.getType() == MailFolder.TYPE_SYSTEM_JUNK){
			%>
				<span class="nav_subtitl_area"><fmt:message key="mail.title.folder.junk"/>
				<%
				if (folder.getUnreadItemCount() > 0) {
				%>
					<span>(<%=folder.getUnreadItemCount()%>)</span>
				<%
				}
				%>
				</span>
			<%
			}else if(folder.getType() == MailFolder.TYPE_USER){
			%>
				<span class="nav_subtitl_area"><%=folder.getName()%>
				<%
				if (folder.getUnreadItemCount() > 0) {
				%>
					<span>(<%=folder.getUnreadItemCount()%>)</span>
				<%
				}
				%>
				</span>
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
