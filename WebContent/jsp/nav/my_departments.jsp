<%@page import="net.smartworks.util.SmartUtil"%>
<%@page import="net.smartworks.model.community.info.DepartmentInfo"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="net.smartworks.service.ISmartWorks"%>
<%@ page import="net.smartworks.model.community.*"%>

<%
	User cUser = SmartUtil.getCurrentUser(request, response);

	ISmartWorks smartWorks = (ISmartWorks) request.getAttribute("smartWorks");
	DepartmentInfo[] departments = smartWorks.getMyDepartments(cUser.getCompanyId(), cUser.getId());
%>

<ul>
	<%
		if (departments != null) {
			for (DepartmentInfo department : departments) {
				String departmentContext = ISmartWorks.CONTEXT_PREFIX_DEPARTMENT_SPACE + department.getId();
	%>
	<li>
	<a
		href="department_space.sw?cid=<%=departmentContext%>" title="<%=department.getDesc()%>">
			<span class="ico_pe"><img src="<%=department.getMinPicture()%>" width="20" height="20" border="0"></span> 
			<span class="nav_subtitl_area"><%=department.getName()%></span></a>
	</li>
	<%
		}
		}
	%>
</ul>
