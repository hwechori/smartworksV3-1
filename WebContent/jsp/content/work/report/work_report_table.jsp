<%@page import="net.smartworks.model.KeyMap"%>
<%@page import="net.smartworks.model.work.InformationWork"%>
<%@page import="net.smartworks.model.work.FormField"%>
<%@page import="net.smartworks.model.report.ChartReport"%>
<%@page import="net.smartworks.model.report.Report"%>
<%@page import="net.smartworks.model.work.SmartWork"%>
<%@page import="net.smartworks.model.work.Work"%>
<%@page import="net.smartworks.util.SmartUtil"%>
<%@page import="net.smartworks.util.SmartTest"%>
<%@page import="net.smartworks.model.community.User"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="net.smartworks.service.ISmartWorks"%>

<%
	ISmartWorks smartWorks = (ISmartWorks) request.getAttribute("smartWorks");
	String workId = request.getParameter("workId");
	String reportId = request.getParameter("reportId");
	User cUser = SmartUtil.getCurrentUser(request, response);

	SmartWork work = null;
	Report report = null;
	ChartReport chart = null;
	if (workId != null)
		work = (SmartWork) smartWorks.getWorkById(cUser.getCompanyId(), cUser.getId(), workId);
	if (reportId != null)
		report = smartWorks.getReportById(cUser.getCompanyId(), cUser.getId(), reportId);
	if (report != null && report.getType() == Report.TYPE_CHART)
		chart = (ChartReport) report;

	FormField[] fields = null;
	if ((work != null) && (work.getType() == SmartWork.TYPE_INFORMATION)) {
		InformationWork informationWork = (InformationWork) work;
		if (informationWork.getForm() != null) {
			fields = informationWork.getForm().getFields();
		}
	} else {
		fields = new FormField[] {};
	}

	String fieldType = "";
	if (chart != null)
		fieldType = chart.getXAxis().getType();
%>
<fmt:setLocale value="<%=cUser.getLocale() %>" scope="request" />
<fmt:setBundle basename="resource.smartworksMessage" scope="request" />
<tr class="js_report_chart_type"
	<%if (report == null || report.getType() != Report.TYPE_CHART) {%>
	style="display: none" <%}%>>
	<td><div class="essen_r">
			<fmt:message key="report.chart.type" />
		</div>
	</td>
	<td colspan="3" class=""><select name="selReportChartType">
			<option value="<%=ChartReport.CHART_TYPE_COLUMN%>"
				<%if (chart != null && chart.getChartType() == ChartReport.CHART_TYPE_COLUMN) {%>
				selected <%}%>>
				<fmt:message key="report.chart.type.column" />
			</option>
			<option value="<%=ChartReport.CHART_TYPE_BAR%>"
				<%if (chart != null && chart.getChartType() == ChartReport.CHART_TYPE_BAR) {%>
				selected <%}%>>
				<fmt:message key="report.chart.type.bar" />
			</option>
			<option value="<%=ChartReport.CHART_TYPE_LINE%>"
				<%if (chart != null && chart.getChartType() == ChartReport.CHART_TYPE_LINE) {%>
				selected <%}%>>
				<fmt:message key="report.chart.type.line" />
			</option>
			<option value="<%=ChartReport.CHART_TYPE_PIE%>"
				<%if (chart != null && chart.getChartType() == ChartReport.CHART_TYPE_PIE) {%>
				selected <%}%>>
				<fmt:message key="report.chart.type.pie" />
			</option>
			<option value="<%=ChartReport.CHART_TYPE_AREA%>"
				<%if (chart != null && chart.getChartType() == ChartReport.CHART_TYPE_AREA) {%>
				selected <%}%>>
				<fmt:message key="report.chart.type.area" />
			</option>
			<option value="<%=ChartReport.CHART_TYPE_PLOT%>"
				<%if (chart != null && chart.getChartType() == ChartReport.CHART_TYPE_PLOT) {%>
				selected <%}%>>
				<fmt:message key="report.chart.type.plot" />
			</option>
			<option value="<%=ChartReport.CHART_TYPE_BUBBLE%>"
				<%if (chart != null && chart.getChartType() == ChartReport.CHART_TYPE_BUBBLE) {%>
				selected <%}%>>
				<fmt:message key="report.chart.type.bubble" />
			</option>
	</select></td>
</tr>
<tr>
	<td><div class="essen_r">
			<fmt:message key="report.title.xaxis" />
		</div></td>
	<td colspan="3" class="js_select_chart_axis"><select
		name="selReportXAxis">
			<%
				if (fields != null) {
					for (FormField field : fields) {
			%>
			<option type="<%=field.getType()%>" value="<%=field.getId()%>"><%=field.getName()%></option>
			<%
				}
				}
			%>
			<jsp:include page="/jsp/content/work/field/default_fields.jsp">
				<jsp:param name="type" value="<%=work.getType() %>" /></jsp:include>
	</select></td>
	<td class="js_axis_selector_date"
		<%if (!fieldType.equals(FormField.TYPE_DATE) && !fieldType.equals(FormField.TYPE_DATETIME)) {%>
		style="display: none" <%}%>><select
		name="selReportXAxisSelectorDate">
			<%
				for (KeyMap selector : Report.AXIS_SELECTORS_DATE) {
			%>
			<option value="<%=selector.getId()%>">
				<fmt:message key="<%=selector.getKey() %>" />
			</option>
			<%
				}
			%>
	</select></td>
	<td class="js_axis_selector_user"
		<%if (!fieldType.equals(FormField.TYPE_USER)) {%>
		style="display: none" <%}%>><select
		name="selReportXAxisSelectorUser">
			<%
				for (KeyMap selector : Report.AXIS_SELECTORS_USER) {
			%>
			<option value="<%=selector.getId()%>">
				<fmt:message key="<%=selector.getKey() %>" />
			</option>
			<%
				}
			%>
	</select></td>
</tr>
<tr>
	<td><div class="essen_r">
			<fmt:message key="report.title.yaxis" />
		</div></td>
	<td colspan="3" class=""><select name="selReportYAxis">
			<%
				if (fields != null) {
					for (FormField field : fields) {
			%>
			<option type="<%=field.getPageName()%>" value="<%=field.getId()%>"><%=field.getName()%></option>
			<%
				}
				}
			%>
			<jsp:include page="/jsp/content/work/field/default_fields.jsp">
				<jsp:param name="type" value="<%=work.getType() %>" /></jsp:include>
	</select></td>
	<td><select name="selReportYAxisValue">
			<%
				for (KeyMap valueType : report.VALUE_TYPES) {
			%>
			<option value="<%=valueType.getId()%>">
				<fmt:message key="<%=valueType.getKey() %>" />
			</option>
			<%
				}
			%>
	</select></td>
</tr>
<tr class="js_toggle_chart_zaxis">
	<td><fmt:message key="report.button.add_zaxis" /></td>
</tr>
<tr class="js_toggle_chart_zaxis" style="display: none">
	<td><fmt:message key="report.button.remove_zaxis" /></td>
</tr>
<tr class="js_chart_zaxis">
	<td><div class="essen_r">
			<fmt:message key="report.title.zaxis" style="display:none" />
		</div></td>
	<td colspan="3" class="js_select_chart_axis"><select
		name="selReportZAxis">
			<%
				if (fields != null) {
					for (FormField field : fields) {
			%>
			<option type="<%=field.getType()%>" value="<%=field.getId()%>"><%=field.getName()%></option>
			<%
				}
				}
			%>
			<jsp:include page="/jsp/content/work/field/default_fields.jsp">
				<jsp:param name="type" value="<%=work.getType() %>" /></jsp:include>
	</select></td>
	<td class="js_axis_selector_date"
		<%if (!fieldType.equals(FormField.TYPE_DATE) && !fieldType.equals(FormField.TYPE_DATETIME)) {%>
		style="display: none" <%}%>><select
		name="selReportZAxisSelectorDate">
			<%
				for (KeyMap selector : Report.AXIS_SELECTORS_DATE) {
			%>
			<option value="<%=selector.getId()%>">
				<fmt:message key="<%=selector.getKey() %>" />
			</option>
			<%
				}
			%>
	</select></td>
	<td class="js_axis_selector_user"
		<%if (!fieldType.equals(FormField.TYPE_USER)) {%>
		style="display: none" <%}%>><select
		name="selReportZAxisSelectorUser">
			<%
				for (KeyMap selector : Report.AXIS_SELECTORS_USER) {
			%>
			<option value="<%=selector.getId()%>">
				<fmt:message key="<%=selector.getKey() %>" />
			</option>
			<%
				}
			%>
	</select></td>
</tr>
