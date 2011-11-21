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
	ISmartWorks smartWorks = (ISmartWorks) request.getAttribute("smartWorks");
	User cUser = SmartUtil.getCurrentUser(request);
	KeyMap[] numberOpers = ConditionOperator.numberOperators;
%>
<fmt:setLocale value="<%=cUser.getLocale() %>" scope="request" />
<fmt:setBundle basename="resource.smartworksMessage" scope="request" />

<select name="selFilterNumberOperator" class="selb_size_sec">
	<%
		for (KeyMap numberOper : numberOpers) {
	%>
	<option value="<%=numberOper.getId()%>"
		<%if (operator != null && operator.equals(numberOper.getId())) {%>
		selected <%}%>>
		<fmt:message key="<%=numberOper.getKey() %>" />
	</option>
	<%
		}
	%>
</select>
<span class="str_field"><input class="inputline" type="text"
	name="txtFilterNumberOperand" value="<%if(operandValue!=null){ %><%=operandValue%><%}%>"> </span>
<span class="btn_x_grb_posi">
	<button class="btn_x_grb js_remove_condition"></button> </span>