
<!-- Name 			: start_work.jsp												 -->
<!-- Description	: 새업무를 등록하기 위해 업무를 검색하거나 트리에서 선택하는 화면	      	 -->
<!-- Author			: Maninsoft, Inc.												 -->
<!-- Created Date	: 2011.9.														 -->

<%@page import="net.smartworks.util.SmartUtil"%>
<%@page import="net.smartworks.model.community.User"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="net.smartworks.service.ISmartWorks"%>
<%
	// 스마트웍스 서비스들을 사용하기위한 핸들러를 가져온다. 현재사용자 정보도 가져온다..
	ISmartWorks smartWorks = (ISmartWorks) request.getAttribute("smartWorks");
	User cUser = SmartUtil.getCurrentUser();
%>
<!--  다국어 지원을 위해, 로케일 및 다국어 resource bundle 을 설정 한다. -->
<fmt:setLocale value="<%=cUser.getLocale() %>" scope="request" />
<fmt:setBundle basename="resource.smartworksMessage" scope="request" />

<!-- 새업무등록하기위한 업무 검색과 업무선택 트리 화면들 -->
<div class="up_wrap js_start_work_page">
	<div class="up_point posit_works js_up_pointer"></div>
	<div class="start_worksinput">

		<!-- 업무검색을 위한 자동완성검색 -->
		<div class="input_size srch">
			<input class="js_auto_complete" type="text" href="work_name.sw" placeholder="<fmt:message key='common.upload.message.work'/>">
			<div class="srch_icon_w js_icon_white js_pop_all_works"></div>
		</div>

		<!-- 업무트리 팝업을 위한 버튼 -->
		<%-- <div class="btn_gray btn_right" id="all_work_btn">
			<a href="" class="js_pop_all_works"> 
				<span class="Btn01Start"></span> 
				<span class="Btn01Center"><fmt:message key="common.upload.button.all_works" /> </span> 
				<span class="Btn01End"></span>
			</a>
		</div> --%>

		<!-- 업무트리가 나타나는 곳 -->
		<span class="js_all_work_popup"></span>
		
		<!--검색 자동완성어 리스트-->
		<div class="srch_list" id="upload_work_list" style="display: none"></div>

	</div>
</div>
<!-- 새업무등록하기위한 업무 검색과 업무선택 트리 화면들 //-->
<div class="up_wrap" style="display: none">
	<div class="up_point posit_works js_up_pointer"></div>
	<!-- 선택된 업무 화면이 나타나는 곳 -->
	<div class="js_upload_form_detail" id="form_works" ></div>
</div>
