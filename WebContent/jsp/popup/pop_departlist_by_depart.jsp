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
	String departmentId = (String)request.getAttribute("departmentId");
	DepartmentInfo[] departments = (DepartmentInfo[])smartWorks.getAllComsByDepartmentId(CommonUtil.toNotNull(departmentId), true);
	String iconType = null;
%>

<ul>
	<%
	if (!SmartUtil.isBlankObject(departments)) {
		for (DepartmentInfo department : departments) {
			iconType = "icon_depart";
	%>
			<li class="js_drill_down"><a
				href="pop_departlist_by_depart.sw" departmentId="<%=department.getId()%>"><span class="<%=iconType%>"></span>
					<span><%=department.getName()%></span></a>
				<div class="js_drill_down_target" style="display: none"></div>
			</li>
		<%
		}
	}
	%>
</ul>