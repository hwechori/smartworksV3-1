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
	$('input.js_todaypicker').datepicker({
		defaultDate : new Date(),
		dateFormat : 'yy.mm.dd'
	});
</script>
<%
	String operator = request.getParameter("operator");
	String operandValue = request.getParameter("operandValue");
	String operandValueSecond = request.getParameter("operandValueSecond");
	ISmartWorks smartWorks = (ISmartWorks) request.getAttribute("smartWorks");
	User cUser = SmartUtil.getCurrentUser();
	LocalDate date = new LocalDate();
	String today = date.toLocalDateSimpleString();
	String curTime = date.toLocalTimeShortString();
	KeyMap[] dateOpers = ConditionOperator.dateOperators;
%>
<fmt:setLocale value="<%=cUser.getLocale() %>" scope="request" />
<fmt:setBundle basename="resource.smartworksMessage" scope="request" />


<select name="selFilterOperator"
	class="selb_size_sec js_select_filter_operator">
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
		<%if (operator != null && operator.equals(dateOper.getId())) {%>
		selected <%}%>>
		<fmt:message key="<%=dateOper.getKey() %>" />
	</option>
	<%
		}
	%>
</select>

<span class="str_field js_operand_date js_right_operand"
	<%if (!selectedOperType.equals("js_operand_date")) {%> style="display: none"
	<%}%>> <input
	class="inputline form_date_input space_r2 js_todaypicker" type="text"
	name="txtFilterDateOperand" readonly="readonly"
	value="<%if (!SmartUtil.isBlankObject(operandValue) && !operandValue.equals("null")) {%><%=operandValue%><%} else {%><%=today%><%}%>">
	<input class="inputline form_time_input" name="txtFilterTimeOperand"
	type="text"
	value="<%if (!SmartUtil.isBlankObject(operandValueSecond) && !operandValue.equals("null")) {%><%=operandValueSecond%><%} else {%><%=curTime%><%}%>">
</span>
<span class="str_field js_operand_none js_right_operand"
	<%if (!selectedOperType.equals("js_operand_none")) {%> style="display: none"
	<%}%>></span>
<span class="str_field js_operand_number js_right_operand"
	<%if (!selectedOperType.equals("js_operand_number")) {%> style="display: none"
	<%}%>> <input class="inputline number" type="text"
	name="txtFilterTimeOperand" value=""> </span>
<span class="btn_x_grb_posi">
	<button class="btn_x_grb js_remove_condition"></button> </span>