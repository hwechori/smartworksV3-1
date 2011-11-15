<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="net.smartworks.service.ISmartWorks"%>
<%@ page import="net.smartworks.model.community.*"%>

<%
	String companyId = (String) session.getAttribute("companyId");
	String userId = (String) session.getAttribute("userId");
	
	ISmartWorks smartWorks = (ISmartWorks) request.getAttribute("smartWorks");
	Department[] departments = smartWorks.getMyDepartments(companyId, userId);
%>

<ul>
	<%
		for (Department department : departments) {
			String departmentContext = ISmartWorks.CONTEXT_PREFIX_DEPARTMENT_SPACE + department.getId();
	%>
	<li class="ico_depart"><a
		href="department_space.sw?cid=<%=departmentContext%>"><%=department.getName()%></a>
	</li>
	<%
		}
	%>
</ul>
