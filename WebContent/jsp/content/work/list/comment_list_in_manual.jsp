<%@page import="net.smartworks.model.community.info.UserInfo"%>
<%@page import="net.smartworks.model.instance.info.CommentInstanceInfo"%>
<%@page import="net.smartworks.model.instance.WorkInstance"%>
<%@page import="net.smartworks.util.LocalDate"%>
<%@page import="net.smartworks.model.instance.CommentInstance"%>
<%@page import="net.smartworks.model.instance.MemoInstance"%>
<%@page import="net.smartworks.model.community.User"%>
<%@page import="net.smartworks.model.security.EditPolicy"%>
<%@page import="net.smartworks.model.security.WritePolicy"%>
<%@page import="net.smartworks.model.security.AccessPolicy"%>
<%@page import="net.smartworks.model.work.InformationWork"%>
<%@page import="net.smartworks.model.work.SmartWork"%>
<%@page import="net.smartworks.model.work.Work"%>
<%@page import="net.smartworks.util.SmartUtil"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="net.smartworks.service.ISmartWorks"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	ISmartWorks smartWorks = (ISmartWorks) request.getAttribute("smartWorks");
	User cUser = SmartUtil.getCurrentUser();

	String workId = request.getParameter("workId");
	int fetchCount = Integer.parseInt(request.getParameter("fetchCount"));
	CommentInstanceInfo[] comments = smartWorks.getRecentCommentsInWorkManual(workId, fetchCount);
%>
<fmt:setLocale value="<%=cUser.getLocale() %>" scope="request" />
<fmt:setBundle basename="resource.smartworksMessage" scope="request" />

<%
if (comments != null) {
	for (CommentInstanceInfo comment : comments) {
		UserInfo commentor = comment.getCommentor();
%>
		<li>
			<div class="noti_pic">
				<a class="js_pop_user_info" href="<%=commentor.getSpaceController() %>?cid=<%=commentor.getSpaceContextId()%>" userId="<%=commentor.getId()%>" profile="<%=commentor.getOrgPicture()%>" userDetail="<%=SmartUtil.getUserDetailInfo(commentor)%>">
					<img src="<%=commentor.getMinPicture()%>" class="profile_size_c"/>
				</a>
			</div>
			<div class="noti_in">
				<a href="<%=commentor.getSpaceController() %>?cid=<%=commentor.getSpaceContextId()%>">
					<span class="t_name"><%=commentor.getLongName()%></span>
				</a>
				<span class="t_date"><%=comment.getLastModifiedDate().toLocalString()%></span>
				<div><%=comment.getComment()%><%if(comment.isNew()){ %><span class="icon_new"></span><%} %></div>
			</div>
		</li>
<%
	}
}
%>
