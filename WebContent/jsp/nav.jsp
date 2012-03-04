
<!-- Name 			: nav.jsp										 		 -->
<!-- Description	: 화면 왼쪽의 Navigation Bar 를 구성하는 화면  				 -->
<!-- Author			: Y.S. JUNG												 -->
<!-- Created Date	: 2011.9.												 -->

<%@page import="net.smartworks.util.SmartUtil"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
		cid = ISmartWorks.CONTEXT_PREFIX_HOME + cUser.getId();
	String wid = request.getParameter("wid");
	if (SmartUtil.isBlankObject(wid))
		wid = cUser.getId();
	WorkSpace workSpace = smartWorks.getWorkSpaceById(wid);
%>

	<!-- 현재공간의 사진및 정보를 나타낸다..  -->
	<div class="personal_info">
		<jsp:include page="/jsp/nav/space_profile.jsp" />
	</div>
	<!-- 현재공간의 사진및 정보를 나타낸다.. // -->

	<%
	// 페이지 컨텍스트가 커뮤너티 공간인데 사용자 공간이 아니면, 커뮤너티 멤버들의 정보를 보여준다...
	if (!SmartUtil.getSpaceIdFromContentContext(cid).equals(cUser.getId())){		
		if(!workSpace.getClass().equals(User.class)) {
	%>
			<div class="nav_list">
				<jsp:include page="/jsp/nav/community_wall.jsp" />
			</div>	
			<div class="nav_list">
				<jsp:include page="/jsp/nav/community_members.jsp" />
			</div>
	<%
		}else{
	%>
			<div class="nav_list">
				<jsp:include page="/jsp/nav/user_wall.jsp" />
			</div>	
	<%
		}
	// 커뮤너티공간이 아니면서 워크스페이스가 없거나 워크스페이스가 현재 사용자이면,
	// 나의 업무, 나의 커뮤너티, 메일 함들을 보여준다....
	} else if (SmartUtil.isBlankObject(wid) || wid.equals(cUser.getId())) {
	%>
		<div class="nav_list">
			<jsp:include page="/jsp/nav/user_wall.jsp" >
				<jsp:param value="<%=cid %>" name="cid"/>
			</jsp:include>
		</div>	
		<div class="nav_list">
			<jsp:include page="/jsp/nav/works.jsp" />
		</div>
		<div class="nav_list">
			<jsp:include page="/jsp/nav/communities.jsp" />
		</div>
		<div class="nav_list">
			<jsp:include page="nav/mail.jsp" />
		</div>
	<%
	}
	%>	