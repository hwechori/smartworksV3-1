
<!-- Name 			: my_departments.jsp										 -->
<!-- Description	: 좌측의 Navigation Bar의 나의 커뮤너티에서 나의 부서들을 보여주는 공간-->
<!-- Author			: Y.S. JUNG													 -->
<!-- Created Date	: 2011.9.													 -->

<%@page import="net.smartworks.util.SmartUtil"%>
<%@page import="net.smartworks.model.community.info.DepartmentInfo"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="net.smartworks.service.ISmartWorks"%>
<%@ page import="net.smartworks.model.community.*"%>
<%
	// 스마트웍스 서비스들을 사용하기위한 핸들러를 가져온다.
	ISmartWorks smartWorks = (ISmartWorks) request.getAttribute("smartWorks");

	// 서버에 현재사용자의 모든 부서(상위부서들 포함)들을  가져온다... 
	DepartmentInfo[] departments = smartWorks.getMyDepartments();
%>

<ul>
	<%
	if (departments != null) {
		for (DepartmentInfo department : departments) {
			String departmentContext = ISmartWorks.CONTEXT_PREFIX_DEPARTMENT_SPACE + department.getId();
	%>
			<li>
				<a href="department_space.sw?cid=<%=departmentContext%>" title="<%=department.getDesc()%>">
					<span class="ico_pe"><img src="<%=department.getMinPicture()%>" class="profile_size_s"></span> 
					<span class="nav_subtitl_area"><%=department.getName()%></span>
				</a>
			</li>
	<%
		}
		}
	%>
</ul>
