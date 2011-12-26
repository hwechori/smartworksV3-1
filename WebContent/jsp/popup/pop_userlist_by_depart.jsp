<%@page import="net.smartworks.model.community.info.DepartmentInfo"%>
<%@page import="net.smartworks.model.community.Department"%>
<%@page import="net.smartworks.model.community.info.UserInfo"%>
<%@page import="net.smartworks.server.engine.common.util.CommonUtil"%>
<%@page import="net.smartworks.model.community.info.CommunityInfo"%>
<%@page import="net.smartworks.util.SmartUtil"%>
<%@page import="net.smartworks.model.community.User"%>
<%@page import="net.smartworks.model.work.info.WorkInfo"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="net.smartworks.service.ISmartWorks"%>
<%@ page import="net.smartworks.model.work.*"%>
<%
	ISmartWorks smartWorks = (ISmartWorks) request.getAttribute("smartWorks");
	String departmentId = request.getParameter("departmentId");
	CommunityInfo[] communities = smartWorks.getAllComsByDepartmentId(CommonUtil.toNotNull(departmentId), false);
	String iconType = null;
%>

<ul>
	<%
		if (!SmartUtil.isBlankObject(communities)) {
			for (CommunityInfo community : communities) {
				if (community.getClass().equals(UserInfo.class)) {
					UserInfo user = (UserInfo)community;
					if(user.getRole() == User.USER_ROLE_LEADER){
						iconType = "ico_user_leader";
					} else if(user.getRole() == User.USER_ROLE_MEMBER){
						iconType = "ico_user_member";
					}
					%>
					<li><a href="" class="js_pop_select_user" userId="<%=user.getId()%>">
						<span class="<%=iconType%>"></span><%=user.getLongName()%></a>
					</li>
				<%
				} else if (community.getClass().equals(DepartmentInfo.class)) {
					DepartmentInfo department = (DepartmentInfo)community;
					iconType = "ico_depart";
					%>
					<li class="js_drill_down"><a
						href="pop_userlist_by_depart.sw" departmentId="<%=department.getId()%>"><span class="<%=iconType%>"></span>
							<span><%=department.getName()%></span></a>
						<div style="display: none"></div></li>
					<%
				}
			}
		}
	%>
</ul>