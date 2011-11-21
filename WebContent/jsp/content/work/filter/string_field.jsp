<%@page import="java.net.URLDecoder"%>
<%@page import="net.smartworks.model.community.User"%>
<%@page import="net.smartworks.util.LocalDate"%>
<%@page import="net.smartworks.model.filter.KeyMap"%>
<%@page import="net.smartworks.model.filter.ConditionOperator"%>
<%@page import="net.smartworks.model.work.SmartWork"%>
<%@page import="net.smartworks.util.SmartUtil"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="net.smartworks.service.ISmartWorks"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	String operator = request.getParameter("operator");
	String operandValue = request.getParameter("operandValue");
	if(operandValue != null) operandValue = URLDecoder.decode(operandValue, "UTF-8");
	ISmartWorks smartWorks = (ISmartWorks) request.getAttribute("smartWorks");
	User cUser = SmartUtil.getCurrentUser(request);
	KeyMap[] stringOpers = ConditionOperator.stringOperators;
%>
<fmt:setLocale value="<%=cUser.getLocale() %>" scope="request" />
<fmt:setBundle basename="resource.smartworksMessage" scope="request" />

<select name="selFilterStringOperator" class="selb_size_sec">
	<%
		for (KeyMap stringOper : stringOpers) {
	%>
	<option value="<%=stringOper.getId()%>"
		<%if (operator != null && operator.equals(stringOper.getId())) {%>
		selected <%}%>>
		<fmt:message key="<%=stringOper.getKey() %>" />
	</option>
	<%
		}
	%>
</select>
<span class="str_field"> <input class="inputline" type="text"
	name="txtFilterStringOperand" value="<%if(operandValue!=null){ %><%=operandValue%><%}%>"> </span>
<span class="btn_x_grb_posi">
	<button class="btn_x_grb js_remove_condition"></button> </span>