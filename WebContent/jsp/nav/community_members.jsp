
<!-- Name 			: community_members.jsp										 	 -->
<!-- Description	: 좌측의 Navigation Bar 에서 커뮤너티공간인경우 멤버들을 보여주는 공간 	 -->
<!-- Author			: Maninsoft, Inc.												 -->
<!-- Created Date	: 2011.9.														 -->

<%@page import="net.smartworks.model.community.info.DepartmentInfo"%>
<%@page import="net.smartworks.model.community.info.UserInfo"%>
<%@page import="net.smartworks.util.SmartUtil"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="net.smartworks.service.ISmartWorks"%>
<%@ page import="net.smartworks.model.community.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	// 스마트웍스 서비스들을 사용하기위한 핸들러를 가져온다. 현재사용자 정보도 가져온다 
	ISmartWorks smartWorks = (ISmartWorks) request.getAttribute("smartWorks");
	User cUser = SmartUtil.getCurrentUser();

	UserInfo[] members = null;
	DepartmentInfo[] children = null;

	// 호출할때 전달된 cid(Context ID, 패이지 컨택스트를 지정하는 변수) 를 가져옮..
	String cid = request.getParameter("cid");
	if (SmartUtil.isBlankObject(cid))
		cid = ISmartWorks.CONTEXT_HOME;

	String communityId = SmartUtil.getSpaceIdFromContentContext(cid);
	// 공간이 그룹일때와 부서일때를 구분하여 해당 정보를 서버에게 가져온다...
	if (SmartUtil.isSameContextPrefix(ISmartWorks.CONTEXT_PREFIX_GROUP_SPACE, cid)) {
		members = smartWorks.getGroupById(communityId).getMembers();
	} else if (SmartUtil.isSameContextPrefix(ISmartWorks.CONTEXT_PREFIX_DEPARTMENT_SPACE, cid)) {
		Department department = smartWorks.getDepartmentById(communityId);
		members = department.getMembers();
		children = department.getChildren();
	}
%>
<!--  다국어 지원을 위해, 로케일 및 다국어 resource bundle 을 설정 한다. -->
<fmt:setLocale value="<%=cUser.getLocale() %>" scope="request" />
<fmt:setBundle basename="resource.smartworksMessage" scope="request" />

<!-- 커뮤너티 멤버와 검색박스가 있는 헤더  -->
<ul class="nav_tit js_community_members" communityId="<%=communityId%>">

	<!-- 커뮤너티멤버 라벨과 클릭시 아래의 멤버선택트리화면을 접었다 폈다하는 기능 제공  -->
	<!-- *** js_collapse_parent_siblings : sw_act_nav.js 에서 이클래스의 클릭이벤트를 받아서 -->
	<!--            아래의 js_callapsible 클래스를 찾아 toggle 한다 -->
	<li>
		<a href="" class="js_collapse_parent_siblings arr_on"><fmt:message key="nav.communities.community_members" /></a>
		<span></span><!--  프로그래스아이콘이 실행되는 곳 -->
	</li>
	
	<!--  검색박스를 제공하여, 초성검색 기능을 제공 -->
	<li class="nav_srch js_srch_com_members">
		<div class="srch srch_wsize">
			<input id="" class="nav_input js_auto_complete" type="text" title="<fmt:message key='search.search_people'/>"
				placeholder="<fmt:message key='search.search_people'/>" href="community_member.sw">
			<div class='srch_icon js_srch_x'></div>
		</div>
		<!-- nav 검색 리스트 -->
		<div class="nav_srch_list" style="display: none"></div>
		<!-- nav 검색 리스트 -->
	</li>
	<!--  검색박스를 제공하여, 초성검색 기능을 제공 //-->
	
</ul>
<!-- 커뮤너티멤버 와 검색박스가 있는 헤더 // -->

<!--  커뮤너티멤버를 찾을수 있는 트리 화면  -->
<div class='nav_sub_list js_collapsible js_nav_com_members'>
	<!-- 내부 메뉴 -->
	<div id='community_members'>
		<ul>
			<%
			if (members != null) {
				for (UserInfo member : members) {
			%>
					<li>
						<a href="<%=member.getSpaceController() %>?cid=<%=member.getSpaceContextId()%>&wid=<%=member.getId()%>">
							<span class="icon_pe"><img src="<%=member.getMinPicture()%>" class="profile_size_s"></span> 
							<span class="nav_sub_area"><%=member.getLongName()%></span>
						</a>
					</li>
			<%
				}
			}
			%>
			<%
			if (children != null) {
				String contextId = null;
				for (DepartmentInfo department : children) {
					contextId = ISmartWorks.CONTEXT_PREFIX_DEPARTMENT_SPACE + department.getId();
			%>
					<li>
						<a href="<%=department.getSpaceController() %>?cid=<%=department.getSpaceContextId()%>&wid=<%=department.getId()%>">
							<span class="icon_pe"><img src="<%=department.getMinPicture()%>" class="profile_size_s"></span> 
							<span class="nav_sub_area"><%=department.getName()%></span>
						</a>
					</li>
			<%
				}
			}
			%>
		</ul>
	</div>
	<!--내부메뉴//-->
</div>
<!--  커뮤너티멤버를 찾을수 있는 트리 화면 //-->
