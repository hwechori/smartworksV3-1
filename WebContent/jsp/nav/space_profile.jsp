
<!-- Name 			: space_profile.jsp								 				 -->
<!-- Description	: 화면 왼쪽의 Navigation Bar 에서 현재공간의 프로파일및 정보를 보여준다... -->
<!-- Author			: Maninsoft, Inc.												 -->
<!-- Created Date	: 2011.9.														 -->

<%@page import="net.smartworks.util.SmartUtil"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="net.smartworks.service.ISmartWorks"%>
<%@ page import="net.smartworks.model.community.*"%>
<%
	// 스마트웍스 서비스들을 사용하기위한 핸들러를 가져온다. 현재사용자 정보도 가져온다 
	ISmartWorks smartWorks = (ISmartWorks) request.getAttribute("smartWorks");
	User cUser = SmartUtil.getCurrentUser();

	// 호출할때 전달된 cid(Context ID, 패이지 컨택스트를 지정하는 변수), 
	// wid(WorkSpace Id, 공간을 저정하는 변수) 를 가져옮..
	String cid = request.getParameter("cid");
	if (SmartUtil.isBlankObject(cid))
		cid = ISmartWorks.CONTEXT_HOME;
	String wid = request.getParameter("wid");
	if (SmartUtil.isBlankObject(wid))
		wid = cUser.getId();

	Group thisGroup = null;
	Department thisDepartment = null;
	User thisUser = null;
	String spaceId = SmartUtil.getSpaceIdFromContentContext(cid);
	
	// 전달된 스페이스가 그룹, 부서, 사용자중 어떤것인지 판단하여 해당 클래수로 캐스팅한다...
	if (SmartUtil.isSameContextPrefix(ISmartWorks.CONTEXT_PREFIX_GROUP_SPACE, cid)) {
		thisGroup = (Group) smartWorks.getWorkSpaceById(spaceId);
	} else if (SmartUtil.isSameContextPrefix(ISmartWorks.CONTEXT_PREFIX_DEPARTMENT_SPACE, cid)) {
		thisDepartment = (Department) smartWorks.getWorkSpaceById(spaceId);
	} else if (SmartUtil.isSameContextPrefix(ISmartWorks.CONTEXT_PREFIX_USER_SPACE, cid)) {
		thisUser = (User) smartWorks.getWorkSpaceById(spaceId);
	
	// 스페이스가 없는 경우에는 워크스페이스가 현재사용자가 아니면 그 워크스페이스로 이동할 수 있게 한다...
	} else if (!wid.equals(cUser.getId())) {
		WorkSpace workSpace = smartWorks.getWorkSpaceById(wid);
		if (SmartUtil.isBlankObject(workSpace)) {
			thisUser = SmartUtil.getCurrentUser();
		} else if (workSpace.getClass() == User.class) {
			thisUser = (User) workSpace;
		} else if (workSpace.getClass() == Group.class) {
			thisGroup = (Group) workSpace;
		} else if (workSpace.getClass() == Department.class) {
			thisDepartment = (Department) workSpace;
		}

	// 위의 모든 경우에 해당되지 않으면, 현재사용자 공간으로 이동한다...
	} else {
		thisUser = SmartUtil.getCurrentUser();
	}
%>

<ul>
	<%
	// 그룹인경우....
	if (thisGroup != null) {
	%>
		<li><img class="profile_size_66" src="<%=thisGroup.getOrgPicture()%>"></li>
		<li><%=thisGroup.getName()%><br /> <b><%=thisGroup.getDesc()%></b><br />
			<fmt:message key="group.text.leader" /> : <%=thisGroup.getLeader().getLongName()%><br />
		</li>
	<%
	// 부서인경우....
	} else if (thisDepartment != null) {
	%>
		<li><img class="profile_size_66" src="<%=thisDepartment.getOrgPicture()%>"></li>
		<li><%=thisDepartment.getName()%><br /> <b><%=thisDepartment.getDesc()%></b><br />
			<fmt:message key="department.text.head" /> : <%=thisDepartment.getHead() == null ? "" : thisDepartment.getHead().getLongName()%><br />
		</li>
	<%
	// 사용자인 경우....
	} else if (thisUser != null) {
	%>
		<li><img class="profile_size_66" src="<%=thisUser.getOrgPicture()%>"></li>
		<li><%=thisUser.getPosition()%><br /> <b><%=thisUser.getName()%></b><br />
			<%=thisUser.getDepartment()%><br />
		</li>
	<%
	}
	%>
</ul>
