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
	ISmartWorks smartWorks = (ISmartWorks) request.getAttribute("smartWorks");
	User cUser = SmartUtil.getCurrentUser();
	LocalDate date = new LocalDate();
	String today = date.toLocalDateSimpleString();
	String curTime = date.toLocalTimeShortString();
	KeyMap[] dateOpers = ConditionOperator.dateOperators;
%>
<fmt:setLocale value="<%=cUser.getLocale() %>" scope="request" />
<fmt:setBundle basename="resource.smartworksMessage" scope="request" />


<form name="frmFilterDateField">
	<select name="selFilterDateOperator">
		<%
			for (KeyMap dateOper : dateOpers) {
		%>
		<option value="<%=dateOper.getId()%>" <%if (operator!=null && operator.equals(dateOper.getId())) {%> selected <%}%>>
			<fmt:message key="<%=dateOper.getKey() %>" />
		</option>
		<%
			}
		%>
	</select> <input class="date js_todaypicker" type="text"
		name="txtFilterDateOperand" readonly="readonly" value="<%=today%>">
</form>
<div class="float_right space_l10">
	<button class="btn_x_grb"></button>
</div>
