<%@page import="net.smartworks.util.SmartUtil"%>
<%@page import="net.smartworks.model.community.info.UserInfo"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="net.smartworks.service.ISmartWorks"%>
<%@ page import="net.smartworks.model.community.*"%>

<script type="text/javascript">

function updateAvailableChatters(userInfos){
	if(userInfos != null){
		var data = "";
		var length = userInfos.length;
		for(var i=0; i<length; i++){
			data = data + "<a href='' userId='" + userInfos[i].userId + "'><img src='" + userInfos[i].minPicture + "' title='" + userInfos[i].longName + "' /></a>";
		}		
		$("#available_chatter_list").html(data);
	}
}
</script>
<%
	User cUser = SmartUtil.getCurrentUser(request, response);
	ISmartWorks smartWorks = (ISmartWorks) request.getAttribute("smartWorks");
	UserInfo[] chatters = smartWorks.getAvailableChatter(cUser.getCompanyId(), cUser.getId());
%>

<ul>
	<li class="nav_srch">
		<div class="srch srch_wsize">
			<input id="" class="input js_auto_complete" type="text"
				title="<fmt:message key="search.search_available_chatter"/>"
				placeholder="<fmt:message key="search.search_available_chatter"/>"
				href="available_chatter.sw">
			<div class='srch_ico js_srch_x'></div>
		</div>
		<div style="display: none"></div>
	</li>
	<li class="ico_chatpe" id="available_chatter_list">
		<%
			for (UserInfo chatter : chatters) {
		%><a href="" userId="<%=chatter.getId()%>"><img src="<%=chatter.getMinPicture()%>"
		title="<%=chatter.getLongName()%>" /> </a> <%
 	}
 %>
	</li>
</ul>
