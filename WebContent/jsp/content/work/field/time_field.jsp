
<!-- Name 			: time_field.jsp											 -->
<!-- Description	: 업무목록 페이지들의 상세필터에서 조건이 시간인 항목 화면 			 -->
<!-- Author			: Maninsoft, Inc.											 -->
<!-- Created Date	: 2011.9.													 -->

<%@page import="net.smartworks.model.work.FormField"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="net.smartworks.model.community.User"%>
<%@page import="net.smartworks.util.LocalDate"%>
<%@page import="net.smartworks.model.KeyMap"%>
<%@page import="net.smartworks.model.filter.ConditionOperator"%>
<%@page import="net.smartworks.model.work.SmartWork"%>
<%@page import="net.smartworks.util.SmartUtil"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="net.smartworks.service.ISmartWorks"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<script>
	// 스마트웍스 공통 모듈에서 오늘값을 기본값으로 가지고 있는 Time 선택자를 살린다.
	smartCommon.liveTimePicker();

</script>
<%
	// 스마트웍스 서비스들을 사용하기위한 핸들러를 가져온다. 현재사용자 정보도 가져온다..
	ISmartWorks smartWorks = (ISmartWorks) request.getAttribute("smartWorks");
	User cUser = SmartUtil.getCurrentUser();

	// 호출시에 전달한 operator, operandValue 값들을 가져온다..
	String operator = request.getParameter("operator");
	String operandValue = request.getParameter("operandValue");

	// 현재시간을 가져온다...
	LocalDate date = new LocalDate();
	String curTime = date.toLocalTimeShortString();
	// 날짜 비교에 사용되는 계산자들의 키맵을 가져온다..
	KeyMap[] timeOpers = ConditionOperator.timeOperators;
%>
<!--  다국어 지원을 위해, 로케일 및 다국어 resource bundle 을 설정 한다. -->
<fmt:setLocale value="<%=cUser.getLocale() %>" scope="request" />
<fmt:setBundle basename="resource.smartworksMessage" scope="request" />

<input name="hdnFieldType" type="hidden" value="<%=FormField.TYPE_TIME %>"/>
<!--  좌측의 필드항목과 우측의 값을 계산하는 조건실행을 위한 오퍼레이터 선택박스 -->
<select name="selFilterOperator" class="selb_size_sec">
	<%
	for (KeyMap timeOper : timeOpers) {
	%>
		<option value="<%=timeOper.getId()%>" <%if (operator != null && operator.equals(timeOper.getId())) {%> selected <%}%>><fmt:message key="<%=timeOper.getKey() %>" />
		</option>
	<%
	}
	%>
</select>

<!-- 우측의 날짜를 비교할 수 있은 시간 선택박스 -->
<span class="icon_fb_space fl">
	<input name="selFilterTimeOperand" class="inputline form_time_input js_timepicker required" type="text"
		value="<%if (operandValue != null) {%><%=operandValue%><%} else {%><%=curTime%><%}%>">
	<a href="" class="js_timepicker_button"><span class="icon_fb_time"></span></a>
</span>

<!--  현재 콘디션을 삭제할 수 있는 샂제 버튼 -->
<span class="btn_delete_posi">
	<button class="btn_delete js_remove_condition"></button>
</span>
