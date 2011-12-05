<%@page import="net.smartworks.model.report.MatrixReport"%>
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
	String strReportType = request.getParameter("reportType");
	String reportId = request.getParameter("reportId");
	User cUser = SmartUtil.getCurrentUser(request, response);

	int reportType = -1;
	if (strReportType != null && !strReportType.equals(""))
		reportType = Integer.parseInt(strReportType);
	SmartWork work = null;
	Report report = null;
	ChartReport chart = null;
	MatrixReport matrix = null;
	if (workId != null)
		work = (SmartWork) smartWorks.getWorkById(cUser.getCompanyId(), cUser.getId(), workId);
	if (reportId != null)
		report = smartWorks.getReportById(cUser.getCompanyId(), cUser.getId(), reportId);
	if (report != null && report.getType() == Report.TYPE_CHART) {
		chart = (ChartReport) report;
	}
	if (report != null && report.getType() == Report.TYPE_MATRIX) {
		chart = (ChartReport) report;
		matrix = (MatrixReport) report;
	}

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
	else if (matrix != null)
		fieldType = matrix.getXAxis().getType();
%>
<fmt:setLocale value="<%=cUser.getLocale() %>" scope="request" />
<fmt:setBundle basename="resource.smartworksMessage" scope="request" />

<tr class="js_report_chart_type"
	<%if (reportType != Report.TYPE_CHART) {%> style="display: none" <%}%>>
	<td><div class="essen_r">
			<fmt:message key="report.chart.type" />
		</div></td>
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
	</select>
	</td>
</tr>
<tr>
	<td><div class="essen_r">
			<fmt:message key="report.title.xaxis" />
		</div>
	</td>
	<td colspan="3" class="js_select_chart_axis"><select
		name="selReportXAxis">
			<%
				String xAxisId = null;
				if (fields != null) {
					if (chart != null && chart.getXAxis() != null)
						xAxisId = chart.getXAxis().getId();
					for (FormField field : fields) {
			%>
			<option type="<%=field.getType()%>" value="<%=field.getId()%>"
				<%if (xAxisId != null && xAxisId.equals(field.getId())) {%> selected
				<%}%>><%=field.getName()%></option>
			<%
				}
				}
			%>
			<jsp:include page="/jsp/content/work/field/default_fields.jsp">
				<jsp:param name="fieldId" value="<%=xAxisId %>" /></jsp:include>
	</select>
	</td>
	<td class="js_axis_selector_date"
		<%String xAxisSelector = null;
			if (chart != null && chart.getXAxisSelector() != null)
				xAxisSelector = chart.getXAxisSelector();
			if (!fieldType.equals(FormField.TYPE_DATE) && !fieldType.equals(FormField.TYPE_DATETIME)) {%>
		style="display: none" <%}%>><select
		name="selReportXAxisSelectorDate">
			<%
				for (KeyMap selector : Report.AXIS_SELECTORS_DATE) {
			%>
			<option value="<%=selector.getId()%>"
				<%if (xAxisSelector != null && xAxisSelector.equals(selector.getId())) {%>
				selected <%}%>>
				<fmt:message key="<%=selector.getKey() %>" />
			</option>
			<%
				}
			%>
	</select>
	</td>
	<td class="js_axis_selector_user"
		<%if (!fieldType.equals(FormField.TYPE_USER)) {%>
		style="display: none" <%}%>><select
		name="selReportXAxisSelectorUser">
			<%
				for (KeyMap selector : Report.AXIS_SELECTORS_USER) {
			%>
			<option value="<%=selector.getId()%>"
				<%if (xAxisSelector != null && xAxisSelector.equals(selector.getId())) {%>
				selected <%}%>>
				<fmt:message key="<%=selector.getKey() %>" />
			</option>
			<%
				}
			%>
	</select>
	</td>
	<%
		String xAxisSort = null;
		if (chart != null && chart.getXAxisSort() != null)
			xAxisSort = chart.getXAxisSort();
	%>
	<td><input type="radio" name="rdoReportXAxisSort"
		value="<%=Report.AXIS_SORT_DESCEND.getId()%>"
		<%if (xAxisSort != null && xAxisSort.equals(Report.AXIS_SORT_DESCEND.getId())) {%>
		checked <%}%>> <fmt:message
			key="<%=Report.AXIS_SORT_DESCEND.getKey() %>" /> <input type="radio"
		name="rdoReportXAxisSort" value="<%=Report.AXIS_SORT_ASCEND.getId()%>"
		<%if (xAxisSort != null && xAxisSort.equals(Report.AXIS_SORT_ASCEND.getId())) {%>
		checked <%}%>> <fmt:message
			key="<%=Report.AXIS_SORT_ASCEND.getKey() %>" /></td>
</tr>
<tr>
	<td><div class="essen_r">
			<fmt:message key="report.title.yaxis" />
		</div>
	</td>
	<td colspan="3" class=""><select name="selReportYAxis">
			<%
				String yAxisId = null;
				if (fields != null) {
					if (chart != null && chart.getYAxis() != null)
						yAxisId = chart.getYAxis().getId();
					for (FormField field : fields) {
			%>
			<option type="<%=field.getPageName()%>" value="<%=field.getId()%>"
				<%if (yAxisId != null && yAxisId.equals(field.getId())) {%> selected
				<%}%>><%=field.getName()%></option>
			<%
				}
				}
			%>
			<jsp:include page="/jsp/content/work/field/default_fields.jsp">
				<jsp:param name="fieldId" value="<%=yAxisId %>" /></jsp:include>
	</select>
	</td>
	<td><select name="selReportYAxisValue">
			<%
				String value = null;
				if (chart != null && chart.getValueType() != null)
					value = chart.getValueType();
				for (KeyMap valueType : Report.VALUE_TYPES) {
			%>
			<option value="<%=valueType.getId()%>"
				<%if (value != null && value.equals(valueType.getId())) {%> selected
				<%}%>>
				<fmt:message key="<%=valueType.getKey() %>" />
			</option>
			<%
				}
			%>
	</select>
	</td>
</tr>
<%
	String zAxisId=null, zAxisSelector=null, zAxisSort=null, xSecondAxisId=null, xSecondAxisSelector=null, xSecondAxisSort=null, zSecondAxisId=null, zSecondAxisSelector=null, zSecondAxisSort=null;
	if (chart != null) {
		if (chart.getZAxis() != null)
			zAxisId = chart.getZAxis().getId();
		if (chart.getZAxisSelector() != null)
			zAxisSelector = chart.getZAxisSelector();
		if (chart.getZAxisSort() != null)
			zAxisSort = chart.getZAxisSort();
	}
	if (matrix != null) {
		if (matrix.getXSecondAxis() != null)
			xSecondAxisId = matrix.getXSecondAxis().getId();
		if (matrix.getXSecondAxisSelector() != null)
			xSecondAxisSelector = matrix.getXSecondAxisSelector();
		if (matrix.getXSecondAxisSort() != null)
			xSecondAxisSort = matrix.getXSecondAxisSort();
		if (matrix.getZSecondAxis() != null)
			zSecondAxisId = matrix.getZSecondAxis().getId();
		if (matrix.getZSecondAxisSelector() != null)
			zSecondAxisSelector = matrix.getZSecondAxisSelector();
		if (matrix.getZSecondAxisSort() != null)
			zSecondAxisSort = matrix.getZSecondAxisSort();
	}
%>
<tr class="js_toggle_chart_zaxis" <%if (zAxisId != null) {%>
	style="display: none" <%}%>>
	<td><fmt:message key="report.button.add_zaxis" />
	</td>
</tr>
<tr class="js_toggle_chart_zaxis" <%if (zAxisId == null) {%>
	style="display: none" <%}%>>
	<td><fmt:message key="report.button.remove_zaxis" />
	</td>
</tr>
<tr class="js_chart_zaxis" <%if (zAxisId == null) {%>
	style="display: none" <%}%>>
	<td><div class="essen_r">
			<fmt:message key="report.title.zaxis" />
		</div>
	</td>
	<td colspan="3" class="js_select_chart_axis"><select
		name="selReportZAxis">
			<%
				if (fields != null) {
					for (FormField field : fields) {
			%>
			<option type="<%=field.getType()%>" value="<%=field.getId()%>"
				<%if (zAxisId != null && zAxisId.equals(field.getId())) {%>
				selected"<%}%>><%=field.getName()%></option>
			<%
				}
				}
			%>
			<jsp:include page="/jsp/content/work/field/default_fields.jsp">
				<jsp:param name="fieldId" value="<%=zAxisId %>" /></jsp:include>
	</select>
	</td>
	<td class="js_axis_selector_date"
		<%if (!fieldType.equals(FormField.TYPE_DATE) && !fieldType.equals(FormField.TYPE_DATETIME)) {%>
		style="display: none" <%}%>><select
		name="selReportZAxisSelectorDate">
			<%
				for (KeyMap selector : Report.AXIS_SELECTORS_DATE) {
			%>
			<option value="<%=selector.getId()%>"
				<%if (zAxisSelector != null && zAxisSelector.equals(selector.getId())) {%>
				selected <%}%>>
				<fmt:message key="<%=selector.getKey() %>" />
			</option>
			<%
				}
			%>
	</select>
	</td>
	<td class="js_axis_selector_user"
		<%if (!fieldType.equals(FormField.TYPE_USER)) {%>
		style="display: none" <%}%>><select
		name="selReportZAxisSelectorUser">
			<%
				for (KeyMap selector : Report.AXIS_SELECTORS_USER) {
			%>
			<option value="<%=selector.getId()%>"
				<%if (zAxisSelector != null && zAxisSelector.equals(selector.getId())) {%>
				selected <%}%>>
				<fmt:message key="<%=selector.getKey() %>" />
			</option>
			<%
				}
			%>
	</select>
	</td>
	<td><input type="radio" name="rdoReportZAxisSort"
		value="<%=Report.AXIS_SORT_DESCEND.getId()%>"
		<%if (zAxisSort != null && zAxisSort.equals(Report.AXIS_SORT_DESCEND.getId())) {%>
		checked <%}%>> <fmt:message
			key="<%=Report.AXIS_SORT_DESCEND.getKey() %>" /> <input type="radio"
		name="rdoReportZAxisSort" value="<%=Report.AXIS_SORT_ASCEND.getId()%>"
		<%if (zAxisSort != null && zAxisSort.equals(Report.AXIS_SORT_ASCEND.getId())) {%>
		checked <%}%>> <fmt:message
			key="<%=Report.AXIS_SORT_ASCEND.getKey() %>" /></td>
</tr>
<%
	if (reportType == Report.TYPE_MATRIX && matrix != null) {
%>
<tr class="js_toggle_chart_xsecondaxis" <%if (xSecondAxisId != null) {%>
	style="display: none" <%}%>>
	<td><fmt:message key="report.button.add_xsecondaxis" />
	</td>
</tr>
<tr class="js_toggle_chart_xsecondaxis" <%if (xSecondAxisId == null) {%>
	style="display: none" <%}%>>
	<td><fmt:message key="report.button.remove_xsecondaxis" />
	</td>
</tr>
<tr class="js_chart_xsecondaxis" <%if (xSecondAxisId == null) {%>
	style="display: none" <%}%>>
	<td><div class="essen_r">
			<fmt:message key="report.title.xsecondaxis" />
		</div>
	</td>
	<td colspan="3" class="js_select_chart_axis"><select
		name="selReportXSecondAxis">
			<%
				if (fields != null) {
						for (FormField field : fields) {
			%>
			<option type="<%=field.getType()%>" value="<%=field.getId()%>"
				<%if (xSecondAxisId != null && xSecondAxisId.equals(field.getId())) {%>
				selected"<%}%>><%=field.getName()%></option>
			<%
				}
					}
			%>
			<jsp:include page="/jsp/content/work/field/default_fields.jsp">
				<jsp:param name="fieldId" value="<%=xSecondAxisId %>" /></jsp:include>
	</select>
	</td>
	<td class="js_axis_selector_date"
		<%if (!fieldType.equals(FormField.TYPE_DATE) && !fieldType.equals(FormField.TYPE_DATETIME)) {%>
		style="display: none" <%}%>><select
		name="selReportXSecondAxisSelectorDate">
			<%
				for (KeyMap selector : Report.AXIS_SELECTORS_DATE) {
			%>
			<option value="<%=selector.getId()%>"
				<%if (xSecondAxisSelector != null && xSecondAxisSelector.equals(selector.getId())) {%>
				selected <%}%>>
				<fmt:message key="<%=selector.getKey() %>" />
			</option>
			<%
				}
			%>
	</select>
	</td>
	<td class="js_axis_selector_user"
		<%if (!fieldType.equals(FormField.TYPE_USER)) {%>
		style="display: none" <%}%>><select
		name="selReportXSecondAxisSelectorUser">
			<%
				for (KeyMap selector : Report.AXIS_SELECTORS_USER) {
			%>
			<option value="<%=selector.getId()%>"
				<%if (xSecondAxisSelector != null && xSecondAxisSelector.equals(selector.getId())) {%>
				selected <%}%>>
				<fmt:message key="<%=selector.getKey() %>" />
			</option>
			<%
				}
			%>
	</select>
	</td>
	<td><input type="radio" name="rdoReportXSecondAxisSort"
		value="<%=Report.AXIS_SORT_DESCEND.getId()%>"
		<%if (xSecondAxisSort != null && xSecondAxisSort.equals(Report.AXIS_SORT_DESCEND.getId())) {%>
		checked <%}%>> <fmt:message
			key="<%=Report.AXIS_SORT_DESCEND.getKey() %>" /> <input type="radio"
		name="rdoReportXSecondAxisSort" value="<%=Report.AXIS_SORT_ASCEND.getId()%>"
		<%if (xSecondAxisSort != null && xSecondAxisSort.equals(Report.AXIS_SORT_ASCEND.getId())) {%>
		checked <%}%>> <fmt:message
			key="<%=Report.AXIS_SORT_ASCEND.getKey() %>" /></td>
</tr>
<tr class="js_toggle_chart_zsecondaxis" <%if (zSecondAxisId != null) {%>
	style="display: none" <%}%>>
	<td><fmt:message key="report.button.add_zsecondaxis" />
	</td>
</tr>
<tr class="js_toggle_chart_zsecondaxis" <%if (zSecondAxisId == null) {%>
	style="display: none" <%}%>>
	<td><fmt:message key="report.button.remove_zsecondaxis" />
	</td>
</tr>
<tr class="js_chart_zsecondaxis" <%if (zSecondAxisId == null) {%>
	style="display: none" <%}%>>
	<td><div class="essen_r">
			<fmt:message key="report.title.zsecondaxis" />
		</div>
	</td>
	<td colspan="3" class="js_select_chart_axis"><select
		name="selReportZSecondAxis">
			<%
				if (fields != null) {
						for (FormField field : fields) {
			%>
			<option type="<%=field.getType()%>" value="<%=field.getId()%>"
				<%if (zSecondAxisId != null && zSecondAxisId.equals(field.getId())) {%>
				selected"<%}%>><%=field.getName()%></option>
			<%
				}
					}
			%>
			<jsp:include page="/jsp/content/work/field/default_fields.jsp">
				<jsp:param name="fieldId" value="<%=zSecondAxisId %>" /></jsp:include>
	</select>
	</td>
	<td class="js_axis_selector_date"
		<%if (!fieldType.equals(FormField.TYPE_DATE) && !fieldType.equals(FormField.TYPE_DATETIME)) {%>
		style="display: none" <%}%>><select
		name="selReportZSecondAxisSelectorDate">
			<%
				for (KeyMap selector : Report.AXIS_SELECTORS_DATE) {
			%>
			<option value="<%=selector.getId()%>"
				<%if (zSecondAxisSelector != null && zSecondAxisSelector.equals(selector.getId())) {%>
				selected <%}%>>
				<fmt:message key="<%=selector.getKey() %>" />
			</option>
			<%
				}
			%>
	</select>
	</td>
	<td class="js_axis_selector_user"
		<%if (!fieldType.equals(FormField.TYPE_USER)) {%>
		style="display: none" <%}%>><select
		name="selReportZSecondAxisSelectorUser">
			<%
				for (KeyMap selector : Report.AXIS_SELECTORS_USER) {
			%>
			<option value="<%=selector.getId()%>"
				<%if (zSecondAxisSelector != null && zSecondAxisSelector.equals(selector.getId())) {%>
				selected <%}%>>
				<fmt:message key="<%=selector.getKey() %>" />
			</option>
			<%
				}
			%>
	</select>
	</td>
	<td><input type="radio" name="rdoReportZSecondAxisSort"
		value="<%=Report.AXIS_SORT_DESCEND.getId()%>"
		<%if (zSecondAxisSort != null && zSecondAxisSort.equals(Report.AXIS_SORT_DESCEND.getId())) {%>
		checked <%}%>> <fmt:message
			key="<%=Report.AXIS_SORT_DESCEND.getKey() %>" /> <input type="radio"
		name="rdoReportZSecondAxisSort" value="<%=Report.AXIS_SORT_ASCEND.getId()%>"
		<%if (zSecondAxisSort != null && zSecondAxisSort.equals(Report.AXIS_SORT_ASCEND.getId())) {%>
		checked <%}%>> <fmt:message
			key="<%=Report.AXIS_SORT_ASCEND.getKey() %>" /></td>
</tr>

<%
	}
%>