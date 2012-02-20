
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

%>
<!--  다국어 지원을 위해, 로케일 및 다국어 resource bundle 을 설정 한다. -->
<fmt:setLocale value="<%=cUser.getLocale() %>" scope="request" />
<fmt:setBundle basename="resource.smartworksMessage" scope="request" />

<div class="navi_list">
	<div id="m_setting">
		<!-- 내부 메뉴 -->
		<ul>
			<li><a href="" class="js_content"><span class="ico_b1dep"><fmt:message key="space.title.all_items"/></span></a></li>
			<li><a href="" class="js_content"><span class="ico_b1dep"><fmt:message key="space.title.works"/></span></a></li>
			<li><a href="" class="js_content"><span class="ico_b1dep"><fmt:message key="space.title.pictures"/></span></a></li>
			<li><a href="" class="js_content"><span class="ico_b1dep"><fmt:message key="space.title.files"/></span></a></li>
			<li><a href="" class="js_content"><span class="ico_b1dep"><fmt:message key="space.title.events"/></span></a></li>
			<li><a href="" class="js_content"><span class="ico_b1dep"><fmt:message key="space.title.memos"/></span></a></li>
		</ul>
		<!--내부메뉴//-->
	</div>
</div>