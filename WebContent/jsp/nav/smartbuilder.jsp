
<!-- Name 			: settings.jsp										 		 -->
<!-- Description	: 화면 왼쪽의 Navigation Bar 를 구성하는 화면  				 -->
<!-- Author			: Y.S. JUNG												 -->
<!-- Created Date	: 2011.9.												 -->

<%@page import="net.smartworks.util.SmartUtil"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="net.smartworks.service.ISmartWorks"%>
<%@ page import="net.smartworks.model.community.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	// 스마트웍스 서비스들을 사용하기위한 핸들러를 가져온다. 현재사용자 정보도 가져온다 
	ISmartWorks smartWorks = (ISmartWorks) request.getAttribute("smartWorks");
	User cUser = SmartUtil.getCurrentUser();

	// 호출할때 전달된 cid(Context ID, 패이지 컨택스트를 지정하는 변수), 
	// wid(WorkSpace Id, 공간을 저정하는 변수) 를 가져옮..
	String cid = request.getParameter("cid");
	if (SmartUtil.isBlankObject(cid))
		cid = ISmartWorks.CONTEXT_HOME;
%>
<!--  다국어 지원을 위해, 로케일 및 다국어 resource bundle 을 설정 한다. -->
<fmt:setLocale value="<%=cUser.getLocale() %>" scope="request" />
<fmt:setBundle basename="resource.smartworksMessage" scope="request" />

<div id="nav">
	<!-- Nav Title -->
	<div class="personal_info">
		<ul>
			<li class="setting"></li>
			<li class="margin_t25"><span class="t_nav">스마트 빌더</span></li>
		</ul>
	</div>
	<!-- Nav Title//-->
	<!-- Nav List -->
	<div class="nav_list">
		<div class="navi_list">		
			<div class="categ_link">
				<a title="앱스토어에서 내려받기" href=""><span class="btn_apps"></span></a>
				<a title="카테고리 추가" href=""><span class="btn_cate_add"></span></a>
			</div>

			<div id="all_works">
				<jsp:include page="/jsp/nav/all_works.jsp"></jsp:include>
			</div>
		</div>
	</div>
	<!-- Nav List//-->
</div>
