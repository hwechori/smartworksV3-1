<%@page import="java.net.URLDecoder"%>
<%@page import="net.smartworks.model.community.User"%>
<%@page import="net.smartworks.util.LocalDate"%>
<%@page import="net.smartworks.model.KeyMap"%>
<%@page import="net.smartworks.model.filter.ConditionOperator"%>
<%@page import="net.smartworks.model.work.SmartWork"%>
<%@page import="net.smartworks.util.SmartUtil"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="net.smartworks.service.ISmartWorks"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	String operator = request.getParameter("operator");
	String operandValue = request.getParameter("operandValue");
	ISmartWorks smartWorks = (ISmartWorks) request.getAttribute("smartWorks");
	User cUser = SmartUtil.getCurrentUser(request);
	KeyMap[] generalOpers = ConditionOperator.generalOperators;
%>
<fmt:setLocale value="<%=cUser.getLocale() %>" scope="request" />
<fmt:setBundle basename="resource.smartworksMessage" scope="request" />

<select name="selFilterBooleanOperator" class="selb_size_sec">
	<%
		for (KeyMap generalOper : generalOpers) {
	%>
	<option value="<%=generalOper.getId()%>"
		<%if (operator != null && operator.equals(generalOper.getId())) {%>
		selected <%}%>>
		<fmt:message key="<%=generalOper.getKey() %>" />
	</option>
	<%
		}
	%>
</select>
<span class="str_field"><select name="txtFilterBooleanOperand">
		<option value="true" <%if((operandValue != null) && operandValue.equals("true")){%> selected<%} %>>
			<fmt:message key="filter.operand.true" />
		</option>
		<option value="false" <%if((operandValue != null) && operandValue.equals("false")){%> selected<%} %>>
			<fmt:message key="filter.operand.false" />
		</option>
</select> </span>
<span class="btn_x_grb_posi">
	<button class="btn_x_grb js_remove_condition"></button> </span>