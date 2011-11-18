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
	ISmartWorks smartWorks = (ISmartWorks) request.getAttribute("smartWorks");
	User cUser = SmartUtil.getCurrentUser();
	KeyMap[] numberOpers = ConditionOperator.numberOperators;
%>
<fmt:setLocale value="<%=cUser.getLocale() %>" scope="request" />
<fmt:setBundle basename="resource.smartworksMessage" scope="request" />

<form name="frmFilterNumberField">
	<select name="selFilterNumberOperator">
		<%
			for (KeyMap numberOper : numberOpers) {
		%>
		<option value="<%=numberOper.getId()%>" <%if (operator!=null && operator.equals(numberOper.getId())) {%> selected <%}%>>
			<fmt:message key="<%=numberOper.getKey() %>" />
		</option>
		<%
			}
		%>
	</select> <input type="text" name="txtFilterNumberOperand">
	<div class="float_right space_l10">
		<button class="btn_x_grb"></button>
	</div>
</form>