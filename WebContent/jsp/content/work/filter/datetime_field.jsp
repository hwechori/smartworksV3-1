<%@page import="java.text.DecimalFormat"%>
<%@page import="net.smartworks.model.community.User"%>
<%@page import="net.smartworks.util.LocalDate"%>
<%@page import="net.smartworks.model.filter.KeyMap"%>
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
	User cUser = SmartUtil.getCurrentUser(request);
	LocalDate date = new LocalDate();
	String today = date.toLocalDateSimpleString();
	String curTime = date.toLocalTimeShortString();
	KeyMap[] dateOpers = ConditionOperator.dateOperators;
%>
<fmt:setLocale value="<%=cUser.getLocale() %>" scope="request" />
<fmt:setBundle basename="resource.smartworksMessage" scope="request" />


<select name="selFilterDateTimeOperator" class="selb_size_sec">
	<%
		for (KeyMap dateOper : dateOpers) {
	%>
	<option value="<%=dateOper.getId()%>"
		<%if (operator != null && operator.equals(dateOper.getId())) {%>
		selected <%}%>>
		<fmt:message key="<%=dateOper.getKey() %>" />
	</option>
	<%
		}
	%>
</select>
<span class="str_field">
	<input class="inputline date_input space_r2 js_todaypicker"
	type="text" name="txtFilterDateOperand" readonly="readonly"
	value="<%if (operandValue != null) {%><%=operandValue%><%} else {%><%=today%><%}%>">
	<input class="inputline time_input" name="txtFilterTimeOperand" type="text"
	value="<%if (operandValueSecond != null) {%><%=operandValueSecond%><%} else {%><%=curTime%><%}%>">
</span>
<span class="btn_x_grb_posi">
	<button class="btn_x_grb js_remove_condition"></button> </span>