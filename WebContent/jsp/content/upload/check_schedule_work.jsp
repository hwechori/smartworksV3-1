
<!-- Name 			: check_schedule_work.jsp							 -->
<!-- Description	: 새업무를 시작할 때 일정계획업무로 지정하는 화면	      	 -->
<!-- Author			: Maninsoft, Inc.									 -->
<!-- Created Date	: 2011.9.											 -->

<%@page import="java.text.DecimalFormat"%>
<%@page import="net.smartworks.util.LocalDate"%>
<%@page import="net.smartworks.util.SmartUtil"%>
<%@page import="net.smartworks.model.community.User"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="net.smartworks.service.ISmartWorks"%>
<%
	//스마트웍스 서비스들을 사용하기위한 핸들러를 가져온다. 현재사용자 정보도 가져온다..
	ISmartWorks smartWorks = (ISmartWorks) request.getAttribute("smartWorks");
	User cUser = SmartUtil.getCurrentUser();
%>
<!--  다국어 지원을 위해, 로케일 및 다국어 resource bundle 을 설정 한다. -->
<fmt:setLocale value="<%=cUser.getLocale() %>" scope="request" />
<fmt:setBundle basename="resource.smartworksMessage" scope="request" />

<!-- 업무계획하기 -->
<div class="column3">
	<div class="dash_line"></div>
	<form name='frmScheduleWork' class="form_layout">
		<!-- 계획업무를 선택하는 선택박스 -->
		<div class="pr10">
			<input name="chkScheduleWork" class="pl15 js_toggle_schedule_work" type="checkbox"/><fmt:message key="common.upload.button.schedule" />
		</div>
		
		<!-- 계획업무로 선택된경우 계획업무 지정을 위한 화면들을 스마트폼을 이용해 자동으로 그려준다.. -->
		<!--  js_check_schedule_fields : js/sw-formFields.js의 loadCheckScheduleFields()에서 찾아서 폼을 그려준다. -->
		<span style="display:none">
			<div class="js_check_schedule_fields" startDateName="<fmt:message key='common.upload.field.schedule_start_date'/>" endDateName="<fmt:message key='common.upload.field.schedule_end_date'/>" performerName="<fmt:message key="common.uplaod.field.schedule_performer" />"></div>
		</span>
	</form>
</div>
<!-- 업무계획하기 //-->
