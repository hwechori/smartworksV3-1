	
<!-- Name 			: community.jsp									 					 -->
<!-- Description	: 커뮤너티를 찾는 검색박스에서 key 값을 받아 서버에서 결과를가져와 보여주는 화면   -->
<!-- Author			: Maninsoft, Inc.													 -->
<!-- Created Date	: 2011.9.															 -->

<%@page import="net.smartworks.model.community.info.GroupInfo"%>
<%@page import="net.smartworks.model.community.info.DepartmentInfo"%>
<%@page import="net.smartworks.model.community.info.UserInfo"%>
<%@page import="net.smartworks.model.community.info.WorkSpaceInfo"%>
<%@page import="net.smartworks.util.SmartUtil"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="net.smartworks.service.ISmartWorks"%>
<%@ page import="net.smartworks.model.community.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	// 스마트웍스 서비스들을 사용하기위한 핸들러를 가져온다. 현재사용자 정보도 가져온다.
	ISmartWorks smartWorks = (ISmartWorks) request.getAttribute("smartWorks");
	User cUser = SmartUtil.getCurrentUser();

	// 전달된 키값으로 서버에서 커뮤너티를 찾아주는 기능을 호출한다.
	String key = request.getParameter("key");
	WorkSpaceInfo[] communities = smartWorks.searchCommunity(key);
%>
<!--  다국어 지원을 위해, 로케일 및 다국어 resource bundle 을 설정 한다. -->
<fmt:setLocale value="<%=cUser.getLocale() %>" scope="request" />
<fmt:setBundle basename="resource.smartworksMessage" scope="request" />

<ul>
	<%
	// 검색된 커뮤너티가 있으면 목록을 만들어 보여준다...
	if (communities != null) {
		for (WorkSpaceInfo workSpace : communities) {
			String picName = null, comContext = null, targetContent = null, comName = null, comId = null;
			if (workSpace.getClass() == UserInfo.class) {
				UserInfo user = (UserInfo) workSpace;
				picName = user.getMinPicture();
				comContext = ISmartWorks.CONTEXT_PREFIX_USER_SPACE + user.getId();
				targetContent = "user_space.sw";
				comName = user.getLongName();
				comId = user.getId();
			} else if (workSpace.getClass() == DepartmentInfo.class) {
				DepartmentInfo depart = (DepartmentInfo) workSpace;
				picName = depart.getMinPicture();
				comContext = ISmartWorks.CONTEXT_PREFIX_DEPARTMENT_SPACE + depart.getId();
				targetContent = "department_space.sw";
				comName = depart.getName();
				comId = depart.getId();
			} else if (workSpace.getClass() == GroupInfo.class) {
				GroupInfo group = (GroupInfo) workSpace;
				picName = group.getMinPicture();
				comContext = ISmartWorks.CONTEXT_PREFIX_GROUP_SPACE + group.getId();
				targetContent = "group_space.sw";
				comName = group.getName();
				comId = group.getId();
			}
	%>
			<li>
				<a href="<%=targetContent%>?cid=<%=comContext%>&wid=<%=comId%>" class="js_location">
					<img src="<%=picName%>" class="profile_size_s">
					<span class="nav_sub_area"><%=comName%></span>
				</a>
			</li>
	<%
		}
	
	// 검색된 결과가 없으면, 검색된결과가 없다는 메시지를 보여준다...
	}else{
	%>
		<li>
			<span><fmt:message key="search.message.no_searched_data"/></span>
		</li>
	<%} %>
</ul>
