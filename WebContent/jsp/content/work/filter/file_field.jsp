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
	KeyMap[] stringOpers = ConditionOperator.stringOperators;
%>
<fmt:setLocale value="<%=cUser.getLocale() %>" scope="request" />
<fmt:setBundle basename="resource.smartworksMessage" scope="request" />

<form name="frmFilterFileField">
	<select name="selFilterFileOperator">
		<%
			for (KeyMap stringOper : stringOpers) {
		%>
		<option value="<%=stringOper.getId()%>" <%if (operator!=null && operator.equals(stringOper.getId())) {%> selected <%}%>>
			<fmt:message key="<%=stringOper.getKey() %>" />
		</option>
		<%
			}
		%>
	</select> <input type="text" name="txtFilterFileOperand">
	<div class="float_right space_l10">
		<button class="btn_x_grb"></button>
	</div>
</form>