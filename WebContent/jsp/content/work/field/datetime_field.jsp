
<!-- Name 			: datetime_field.jsp											 -->
<!-- Description	: 업무목록 페이지들의 상세필터에서 조건이 날짜및 시간인 항목 화면 			 -->
<!-- Author			: Maninsoft, Inc.												 -->
<!-- Created Date	: 2011.9.														 -->

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
	// 스마트웍스 공통 모듈에서 오늘값을 기본값으로 가지고 있는 DateTime 선택자를 살린다.
	smartCommon.liveTodayTimePicker();
	
</script>
<%
	// 스마트웍스 서비스들을 사용하기위한 핸들러를 가져온다. 현재사용자 정보도 가져온다.. 
	ISmartWorks smartWorks = (ISmartWorks) request.getAttribute("smartWorks");
	User cUser = SmartUtil.getCurrentUser();

	// 호출시에 전달한 operator, operandValue, operandValueSecond 값들을 가져온다..
	String operator = request.getParameter("operator");
	String operandValue = request.getParameter("operandValue");
	String operandValueSecond = request.getParameter("operandValueSecond");
	
	// 오늘과 현재시간을 가져온다...
	LocalDate date = new LocalDate();
	String today = date.toLocalDateTimeSimpleString();
	// 날짜 비교에 사용되는 계산자들의 키맵을 가져온다..
	KeyMap[] dateOpers = ConditionOperator.dateOperators;
%>
<!--  다국어 지원을 위해, 로케일 및 다국어 resource bundle 을 설정 한다. -->
<fmt:setLocale value="<%=cUser.getLocale() %>" scope="request" />
<fmt:setBundle basename="resource.smartworksMessage" scope="request" />

<!--  좌측의 필드항목과 우측의 값을 계산하는 조건실행을 위한 오퍼레이터 선택박스 -->
<select name="selFilterOperator" class="selb_size_sec js_select_filter_operator">
	<%
	String operType = "";
	String selectedOperType = "js_operand_date";
	if (!SmartUtil.isBlankObject(dateOpers)) {
		if(SmartUtil.isBlankObject(operator)) operator = dateOpers[0].getId();
		if (operator.equals(ConditionOperator.RECENT_DAYS.getId()) || operator.equals(ConditionOperator.TODAY.getId())
				|| operator.equals(ConditionOperator.THIS_WEEK.getId()) || operator.equals(ConditionOperator.THIS_MONTH.getId())
				|| operator.equals(ConditionOperator.THIS_QUARTER.getId()) || operator.equals(ConditionOperator.THIS_HALF_YEAR.getId())
				|| operator.equals(ConditionOperator.THIS_YEAR.getId())) {
			selectedOperType = "js_operand_none";
		} else if (operator.equals(ConditionOperator.RECENT_SOME_DAYS.getId()) || operator.equals(ConditionOperator.RECENT_SOME_MONTHS.getId())) {
			selectedOperType = "js_operand_number";
		} else {
			selectedOperType = "js_operand_date";
		}
	}
	for (KeyMap dateOper : dateOpers) {
		String operId = dateOper.getId();
		if (operId.equals(ConditionOperator.RECENT_DAYS.getId()) || operId.equals(ConditionOperator.TODAY.getId())
				|| operId.equals(ConditionOperator.THIS_WEEK.getId()) || operId.equals(ConditionOperator.THIS_MONTH.getId())
				|| operId.equals(ConditionOperator.THIS_QUARTER.getId()) || operId.equals(ConditionOperator.THIS_HALF_YEAR.getId())
				|| operId.equals(ConditionOperator.THIS_YEAR.getId())) {
			operType = "js_operand_none";
		} else if (operId.equals(ConditionOperator.RECENT_SOME_DAYS.getId()) || operId.equals(ConditionOperator.RECENT_SOME_MONTHS.getId())) {
			operType = "js_operand_number";
		} else {
			operType = "js_operand_date";
		}
	%>
		<option value="<%=dateOper.getId()%>" type="<%=operType%>"
			<%if (operator != null && operator.equals(dateOper.getId())) {%> selected <%}%>><fmt:message key="<%=dateOper.getKey() %>" />
		</option>
	<%
	}
	%>
</select>
<!--  좌측의 필드항목과 우측의 값을 계산하는 조건실행을 위한 오퍼레이터 선택박스 //-->

<!-- 우측의 날짜시간을 비교할 수 있은 날짜시간 선택박스 -->
<span class="ico_fb_space str_field js_operand_date js_right_operand"
	<%if (!selectedOperType.equals("js_operand_date")) {%> style="display: none" <%}%>> 
	<input class="inputline  js_todaytimepicker required" type="text" name="txtFilterDateOperand" readonly="readonly"
		value="<%if (!SmartUtil.isBlankObject(operandValue) && !operandValue.equals("null")) {%><%=operandValue%><%} else {%><%=today%><%}%>">
	<a href="" class="js_todaytimepicker_button"><span class="ico_fb_time"></span></a>
</span>

<!--  가운데 계산자(오퍼레이터)가 지정된 시간들(오늘, 최근 5일등..)을 가지고 있는 경우에는 우측 값을 필요없음 -->
<span class="str_field js_operand_none js_right_operand" <%if (!selectedOperType.equals("js_operand_none")) {%> style="display: none"<%}%>>
</span>

<!--  가운데 계산자(오퍼레이터)가 숫자는 지정된 않고 의미만 가지고 있는 경우(최근 몇일, 최근 몇개월 등...)에는 숫자를 입력하는 박스 필요 -->
<span class="str_field js_operand_number js_right_operand" <%if (!selectedOperType.equals("js_operand_number")) {%> style="display: none"<%}%>>
	<input class="inputline required positiveNumber" type="text" name="txtFilterTimeOperand" value=""> 
</span>

<!--  현재 콘디션을 삭제할 수 있는 샂제 버튼 -->
<span class="btn_x_grb_posi">
	<button class="btn_x_grb js_remove_condition"></button>
</span>

