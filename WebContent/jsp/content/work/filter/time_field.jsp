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

<form name="frmFilterTimeField">
	<select name="selFilterTimeOperator">
		<%
			for (KeyMap dateOper : dateOpers) {
		%>
		<option value="<%=dateOper.getId()%>" <%if (operator!=null && operator.equals(dateOper.getId())) {%> selected <%}%>>
			<fmt:message key="<%=dateOper.getKey() %>" />
		</option>
		<%
			}
		%>
	</select> <select name="selFilterTimeOperand">
		<%
			{
				boolean isNow = false, isPassed = false;
				DecimalFormat df = new DecimalFormat("00");
				int iCurHour = df.parse(curTime.substring(0, 2)).intValue();
				for (int i = 0; i < 24; i++) {
					String hourString = df.format(i) + ":00";
					String thirtyMinuteString = df.format(i) + ":30";
					if (iCurHour < i && !isPassed)
						isNow = true;
		%>
		<option <%if (isNow) {
						isNow = false;
						isPassed = true;%>
			selected <%}%> value="<%=hourString%>"><%=hourString%></option>
		<option><%=thirtyMinuteString%></option>
		<%
			}
			}
		%>
	</select>
	<div class="float_right space_l10">
		<button class="btn_x_grb"></button>
	</div>
</form>