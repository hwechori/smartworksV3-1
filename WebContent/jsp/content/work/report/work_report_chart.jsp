<%@page import="net.smartworks.server.engine.common.util.CommonUtil"%>
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
	String strReportType = request.getParameter("reportType");
	String reportId = request.getParameter("reportId");
	User cUser = SmartUtil.getCurrentUser();

	int reportType = Report.TYPE_CHART;
	if (!SmartUtil.isBlankObject(strReportType))
		reportType = Integer.parseInt(strReportType);
	SmartWork work = (SmartWork)session.getAttribute("smartWork");
	String workId = work.getId();
	Report report = null;
	ChartReport chart = null;
	MatrixReport matrix = null;
	if (!SmartUtil.isBlankObject(workId))
		work = (SmartWork) smartWorks.getWorkById(workId);
	if (!SmartUtil.isBlankObject(reportId))
		report = smartWorks.getReportById(reportId);
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

%>
<fmt:setLocale value="<%=cUser.getLocale() %>" scope="request" />
<fmt:setBundle basename="resource.smartworksMessage" scope="request" />

<tr class="js_report_chart_type" <%if(reportType != Report.TYPE_CHART){%> style="display: none" <%} %>>
	<th><fmt:message key="report.chart.type" /></th>
	<td colspan="4" class="">
		<select name="selReportChartType">
			<option chartType="<%=ChartReport.CHART_TYPES_STRING[ChartReport.CHART_TYPE_COLUMN] %>" value="<%=ChartReport.CHART_TYPE_COLUMN%>"
				<%if (chart != null && chart.getChartType() == ChartReport.CHART_TYPE_COLUMN) {%> selected <%}%>>
				<fmt:message key="report.chart.type.column" />
			</option>
			<option chartType="<%=ChartReport.CHART_TYPES_STRING[ChartReport.CHART_TYPE_COLUMN] %>" value="<%=ChartReport.CHART_TYPE_BAR%>"
				<%if (chart != null && chart.getChartType() == ChartReport.CHART_TYPE_BAR) {%> selected <%}%>>
				<fmt:message key="report.chart.type.bar" />
			</option>
			<option chartType="<%=ChartReport.CHART_TYPES_STRING[ChartReport.CHART_TYPE_LINE] %>" value="<%=ChartReport.CHART_TYPE_LINE%>"
				<%if (chart != null && chart.getChartType() == ChartReport.CHART_TYPE_LINE) {%> selected <%}%>>
				<fmt:message key="report.chart.type.line" />
			</option>
			<option chartType="<%=ChartReport.CHART_TYPES_STRING[ChartReport.CHART_TYPE_PIE] %>" value="<%=ChartReport.CHART_TYPE_PIE%>"
				<%if (chart != null && chart.getChartType() == ChartReport.CHART_TYPE_PIE) {%> selected <%}%>>
				<fmt:message key="report.chart.type.pie" />
			</option>
			<option chartType="<%=ChartReport.CHART_TYPES_STRING[ChartReport.CHART_TYPE_AREA] %>" value="<%=ChartReport.CHART_TYPE_AREA%>"
				<%if (chart != null && chart.getChartType() == ChartReport.CHART_TYPE_AREA) {%> selected <%}%>>
				<fmt:message key="report.chart.type.area" />
			</option>
			<option chartType="<%=ChartReport.CHART_TYPES_STRING[ChartReport.CHART_TYPE_GAUGE] %>" value="<%=ChartReport.CHART_TYPE_GAUGE%>"
				<%if (chart != null && chart.getChartType() == ChartReport.CHART_TYPE_GAUGE) {%> selected <%}%>>
				<fmt:message key="report.chart.type.gauge" />
			</option>
			<option chartType="<%=ChartReport.CHART_TYPES_STRING[ChartReport.CHART_TYPE_RADAR] %>" value="<%=ChartReport.CHART_TYPE_RADAR%>"
				<%if (chart != null && chart.getChartType() == ChartReport.CHART_TYPE_RADAR) {%> selected <%}%>>
				<fmt:message key="report.chart.type.radar" />
			</option>
			<option chartType="<%=ChartReport.CHART_TYPES_STRING[ChartReport.CHART_TYPE_SCATTER] %>" value="<%=ChartReport.CHART_TYPE_SCATTER%>"
				<%if (chart != null && chart.getChartType() == ChartReport.CHART_TYPE_SCATTER) {%> selected <%}%>>
				<fmt:message key="report.chart.type.scatter" />
			</option>
		</select>
	</td>
</tr>
<tr>
	<th><fmt:message key="report.title.xaxis" /></th>
	<td class="js_select_chart_axis" colspan="4">
		<select name="selReportXAxis">
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
				<jsp:param name="workType" value="<%=CommonUtil.toNotNull(work.getType()) %>" />			
				<jsp:param name="fieldId" value="<%=CommonUtil.toNotNull(xAxisId) %>" />
			</jsp:include>
		</select>
	
		<%
		String xFieldType = "";
		if (chart != null)
			xFieldType = chart.getXAxis().getType();
		else if (matrix != null)
			xFieldType = matrix.getXAxis().getType();
		String xAxisSelector = null;
		if (chart != null && chart.getXAxisSelector() != null)
			xAxisSelector = chart.getXAxisSelector();
		%>
	
		<span class="js_axis_selector_date" <%if (!xFieldType.equals(FormField.TYPE_DATE) && !xFieldType.equals(FormField.TYPE_DATETIME)) {%> style="display: none" <%}%>>
			<select name="selReportXAxisSelectorDate">
				<%
				for (KeyMap selector : Report.AXIS_SELECTORS_DATE) {
				%>
					<option value="<%=selector.getId()%>"
						<%if (xAxisSelector != null && xAxisSelector.equals(selector.getId())) {%> selected <%}%>>
						<fmt:message key="<%=selector.getKey() %>" />
					</option>
				<%
				}
				%>
			</select>
		</span>
		<span class="js_axis_selector_user" <%if (!xFieldType.equals(FormField.TYPE_USER)) {%> style="display: none" <%}%>>
			<select name="selReportXAxisSelectorUser">
				<%
				for (KeyMap selector : Report.AXIS_SELECTORS_USER) {
				%>
					<option value="<%=selector.getId()%>"
						<%if (xAxisSelector != null && xAxisSelector.equals(selector.getId())) {%> selected <%}%>>
						<fmt:message key="<%=selector.getKey() %>" />
					</option>
				<%
				}
				%>
			</select>
		</span>
		<%
		String xAxisSort = null;
		if (chart != null && chart.getXAxisSort() != null)
			xAxisSort = chart.getXAxisSort();
		%>
		<span>
			<input type="radio" name="rdoReportXAxisSort" value="<%=Report.AXIS_SORT_DESCEND.getId()%>"
				<%if (xAxisSort == null || xAxisSort.equals(Report.AXIS_SORT_DESCEND.getId())) {%> checked <%}%>> 
				<fmt:message key="<%=Report.AXIS_SORT_DESCEND.getKey() %>" /> 
			<input type="radio" name="rdoReportXAxisSort" value="<%=Report.AXIS_SORT_ASCEND.getId()%>"
				<%if (xAxisSort != null && xAxisSort.equals(Report.AXIS_SORT_ASCEND.getId())) {%> checked <%}%>> 
				<fmt:message key="<%=Report.AXIS_SORT_ASCEND.getKey() %>" />
		</span>
	</td>		
</tr>
<tr>
	<th><fmt:message key="report.title.yaxis" /></th>
	<td colspan="4" class="">
		<select name="selReportYAxis">
			<%
			String yAxisId = null;
			if (fields != null) {
				if (chart != null && chart.getYAxis() != null)
					yAxisId = chart.getYAxis().getId();
				for (FormField field : fields) {
			%>
					<option type="<%=field.getPageName()%>" value="<%=field.getId()%>" 
						<%if (yAxisId != null && yAxisId.equals(field.getId())) {%> selected <%}%>><%=field.getName()%>
					</option>
			<%
				}
			}
			%>
			<jsp:include page="/jsp/content/work/field/default_fields.jsp">
				<jsp:param name="workType" value="<%=CommonUtil.toNotNull(work.getType()) %>" />			
				<jsp:param name="fieldId" value="<%=CommonUtil.toNotNull(yAxisId) %>" />
			</jsp:include>
		</select>
		<span>
			<select name="selReportYAxisValue">
				<%
				String value = null;
				if (chart != null && chart.getValueType() != null)
					value = chart.getValueType();
				for (KeyMap valueType : Report.VALUE_TYPES) {
				%>
					<option value="<%=valueType.getId()%>" <%if (value != null && value.equals(valueType.getId())) {%> selected <%}%>>
						<fmt:message key="<%=valueType.getKey() %>" />
					</option>
				<%
				}
				%>
			</select>
		</span>
	</td>	
</tr>
<%
	String zFieldType="", zAxisId=null, zAxisSelector=null, zAxisSort=null, 
			xSecondFieldType="", xSecondAxisId=null, xSecondAxisSelector=null, xSecondAxisSort=null, 
			zSecondFieldType="", zSecondAxisId=null, zSecondAxisSelector=null, zSecondAxisSort=null;
	if (chart != null) {
		if (chart.getZAxis() != null){
			zFieldType = chart.getZAxis().getType();
			zAxisId = chart.getZAxis().getId();
		}
		if (chart.getZAxisSelector() != null)
			zAxisSelector = chart.getZAxisSelector();
		if (chart.getZAxisSort() != null)
			zAxisSort = chart.getZAxisSort();
	}
	if (matrix != null) {
		if (matrix.getXSecondAxis() != null){
			xSecondFieldType = matrix.getXSecondAxis().getType();
			xSecondAxisId = matrix.getXSecondAxis().getId();
		}
		if (matrix.getXSecondAxisSelector() != null)
			xSecondAxisSelector = matrix.getXSecondAxisSelector();
		if (matrix.getXSecondAxisSort() != null)
			xSecondAxisSort = matrix.getXSecondAxisSort();
		if (matrix.getZSecondAxis() != null){
			zSecondFieldType = matrix.getZSecondAxis().getType();
			zSecondAxisId = matrix.getZSecondAxis().getId();
		}
		if (matrix.getZSecondAxisSelector() != null)
			zSecondAxisSelector = matrix.getZSecondAxisSelector();
		if (matrix.getZSecondAxisSort() != null)
			zSecondAxisSort = matrix.getZSecondAxisSort();
	}
%>
<tr class="js_add_chart_zaxis" <%if (zAxisId != null) {%> style="display: none" <%}%>>
	<td colspan="5">
		<a href=""><fmt:message key="report.button.add_zaxis" /></a>
	</td>
</tr>
<tr class="js_chart_zaxis" <%if (SmartUtil.isBlankObject(zAxisId)) {%> style="display: none" <%}%>>
	<th><fmt:message key="report.title.zaxis" /></th>
	<td class="js_select_chart_axis" colspan="4">
		<select name="selReportZAxis">
			<%
			if (fields != null) {
				for (FormField field : fields) {
			%>
					<option type="<%=field.getType()%>" value="<%=field.getId()%>" 
						<%if (zAxisId != null && zAxisId.equals(field.getId())) {%> selected"<%}%>><%=field.getName()%>
					</option>
			<%
				}
			}
			%>
			<jsp:include page="/jsp/content/work/field/default_fields.jsp">
				<jsp:param name="workType" value="<%=CommonUtil.toNotNull(work.getType()) %>" />			
				<jsp:param name="fieldId" value="<%=CommonUtil.toNotNull(zAxisId) %>" />
			</jsp:include>
		</select>
		<span class="js_axis_selector_date" <%if (!zFieldType.equals(FormField.TYPE_DATE) && !zFieldType.equals(FormField.TYPE_DATETIME)) {%> style="display: none" <%}%>>
			<select name="selReportZAxisSelectorDate">
				<%
				for (KeyMap selector : Report.AXIS_SELECTORS_DATE) {
				%>
					<option value="<%=selector.getId()%>" <%if (zAxisSelector != null && zAxisSelector.equals(selector.getId())) {%> selected <%}%>>
						<fmt:message key="<%=selector.getKey() %>" />
					</option>
				<%
				}
				%>
			</select>
		</span>
		<span class="js_axis_selector_user" <%if (!zFieldType.equals(FormField.TYPE_USER)) {%> style="display: none" <%}%>>
			<select name="selReportZAxisSelectorUser">
				<%
				for (KeyMap selector : Report.AXIS_SELECTORS_USER) {
				%>
					<option value="<%=selector.getId()%>" <%if (zAxisSelector != null && zAxisSelector.equals(selector.getId())) {%> selected <%}%>>
						<fmt:message key="<%=selector.getKey() %>" />
					</option>
				<%
				}
				%>
			</select>
		</span>
		<span>
			<input type="radio" name="rdoReportZAxisSort" value="<%=Report.AXIS_SORT_DESCEND.getId()%>"
				<%if (zAxisSort == null || zAxisSort.equals(Report.AXIS_SORT_DESCEND.getId())) {%> checked <%}%>>
				<fmt:message key="<%=Report.AXIS_SORT_DESCEND.getKey() %>" />
			<input type="radio" name="rdoReportZAxisSort" value="<%=Report.AXIS_SORT_ASCEND.getId()%>"
				<%if (zAxisSort != null && zAxisSort.equals(Report.AXIS_SORT_ASCEND.getId())) {%> checked <%}%>>
				<fmt:message key="<%=Report.AXIS_SORT_ASCEND.getKey() %>" />
		</span>
		<span class="js_remove_chart_zaxis"><a class='btn_x_gr' href='' title="<fmt:message key="report.button.remove_zaxis" />">x</a></span>
	</td>
</tr>
<%
	if (reportType == Report.TYPE_MATRIX) {
%>
<tr class="js_add_chart_xsecondaxis" <%if (xSecondAxisId != null) {%> style="display: none" <%}%>>
	<td colspan="5">
		<a href=""><fmt:message key="report.button.add_xsecondaxis" /></a>
	</td>
</tr>
<tr class="js_chart_xsecondaxis" <%if (SmartUtil.isBlankObject(xSecondAxisId)) {%> style="display: none" <%}%>>
	<th><fmt:message key="report.title.xsecondaxis" /></th>
	<td class="js_select_chart_axis" colspan="4">
		<select name="selReportXSecondAxis">
			<%
			if (fields != null) {
				for (FormField field : fields) {
			%>
					<option type="<%=field.getType()%>" value="<%=field.getId()%>" 
						<%if (xSecondAxisId != null && xSecondAxisId.equals(field.getId())) {%> selected"<%}%>><%=field.getName()%>
					</option>
			<%
				}
			}
			%>
			<jsp:include page="/jsp/content/work/field/default_fields.jsp">
				<jsp:param name="workType" value="<%=CommonUtil.toNotNull(work.getType()) %>" />			
				<jsp:param name="fieldId" value="<%=CommonUtil.toNotNull(xSecondAxisId) %>" />
			</jsp:include>
		</select>
		<span class="js_axis_selector_date" <%if (!xSecondFieldType.equals(FormField.TYPE_DATE) && !xSecondFieldType.equals(FormField.TYPE_DATETIME)) {%> style="display: none" <%}%>>
			<select name="selReportXSecondAxisSelectorDate">
				<%
				for (KeyMap selector : Report.AXIS_SELECTORS_DATE) {
				%>
					<option value="<%=selector.getId()%>" <%if (xSecondAxisSelector != null && xSecondAxisSelector.equals(selector.getId())) {%> selected <%}%>>
						<fmt:message key="<%=selector.getKey() %>" />
					</option>
				<%
				}
				%>
			</select>
		</span>
		<span class="js_axis_selector_user" <%if (!xSecondFieldType.equals(FormField.TYPE_USER)) {%> style="display: none" <%}%>>
			<select name="selReportXSecondAxisSelectorUser">
				<%
				for (KeyMap selector : Report.AXIS_SELECTORS_USER) {
				%>
					<option value="<%=selector.getId()%>" <%if (xSecondAxisSelector != null && xSecondAxisSelector.equals(selector.getId())) {%> selected <%}%>>
						<fmt:message key="<%=selector.getKey() %>" />
					</option>
				<%
				}
				%>
			</select>
		</span>
		<span>
			<input type="radio" name="rdoReportXSecondAxisSort" value="<%=Report.AXIS_SORT_DESCEND.getId()%>"
				<%if (xSecondAxisSort == null || xSecondAxisSort.equals(Report.AXIS_SORT_DESCEND.getId())) {%> checked <%}%>>
				<fmt:message key="<%=Report.AXIS_SORT_DESCEND.getKey() %>" /> 
			<input type="radio" name="rdoReportXSecondAxisSort" value="<%=Report.AXIS_SORT_ASCEND.getId()%>"
				<%if (xSecondAxisSort != null && xSecondAxisSort.equals(Report.AXIS_SORT_ASCEND.getId())) {%> checked <%}%>>
				<fmt:message key="<%=Report.AXIS_SORT_ASCEND.getKey() %>" />
		</span>
		<span class="js_remove_chart_xsecondaxis"><a class='btn_x_gr' href='' title="<fmt:message key="report.button.remove_xsecondaxis" />">x</a></span>
	</td>
</tr>

<tr class="js_add_chart_zsecondaxis" style="display: none">
	<td colspan="5">
		<a href=""><fmt:message key="report.button.add_zsecondaxis" /></a>
	</td>
</tr>
<tr class="js_chart_zsecondaxis" <%if (SmartUtil.isBlankObject(zSecondAxisId)) {%> style="display: none" <%}%>>
	<th><fmt:message key="report.title.zsecondaxis" /></th>
	<td class="js_select_chart_axis">
		<select name="selReportZSecondAxis">
			<%
			if (fields != null) {
				for (FormField field : fields) {
			%>
					<option type="<%=field.getType()%>" value="<%=field.getId()%>" 
						<%if (zSecondAxisId != null && zSecondAxisId.equals(field.getId())) {%> selected"<%}%>><%=field.getName()%>
					</option>
			<%
				}
			}
			%>
			<jsp:include page="/jsp/content/work/field/default_fields.jsp">
				<jsp:param name="workType" value="<%=CommonUtil.toNotNull(work.getType()) %>" />			
				<jsp:param name="fieldId" value="<%=CommonUtil.toNotNull(zSecondAxisId) %>" />
			</jsp:include>
		</select>
		<span class="js_axis_selector_date" <%if (!zSecondFieldType.equals(FormField.TYPE_DATE) && !zSecondFieldType.equals(FormField.TYPE_DATETIME)) {%> style="display: none" <%}%>>
			<select name="selReportZSecondAxisSelectorDate">
				<%
				for (KeyMap selector : Report.AXIS_SELECTORS_DATE) {
				%>
					<option value="<%=selector.getId()%>" <%if (zSecondAxisSelector != null && zSecondAxisSelector.equals(selector.getId())) {%> selected <%}%>>
						<fmt:message key="<%=selector.getKey() %>" />
					</option>
				<%
				}
				%>
			</select>
		</span>
		<span class="js_axis_selector_user" <%if (!zSecondFieldType.equals(FormField.TYPE_USER)) {%> style="display: none" <%}%>>
			<select name="selReportZSecondAxisSelectorUser">
				<%
				for (KeyMap selector : Report.AXIS_SELECTORS_USER) {
				%>
					<option value="<%=selector.getId()%>" <%if (zSecondAxisSelector != null && zSecondAxisSelector.equals(selector.getId())) {%> selected <%}%>>
						<fmt:message key="<%=selector.getKey() %>" />
					</option>
				<%
				}
				%>
			</select>
		</span>
		<span>
			<input type="radio" name="rdoReportZSecondAxisSort" value="<%=Report.AXIS_SORT_DESCEND.getId()%>"
				<%if (zSecondAxisSort == null || zSecondAxisSort.equals(Report.AXIS_SORT_DESCEND.getId())) {%> checked <%}%>>
				<fmt:message key="<%=Report.AXIS_SORT_DESCEND.getKey() %>" /> 
			<input type="radio" name="rdoReportZSecondAxisSort" value="<%=Report.AXIS_SORT_ASCEND.getId()%>"
				<%if (zSecondAxisSort != null && zSecondAxisSort.equals(Report.AXIS_SORT_ASCEND.getId())) {%> checked <%}%>>
				<fmt:message key="<%=Report.AXIS_SORT_ASCEND.getKey() %>" />
		</span>
		<span class="js_remove_chart_zsecondaxis"><a class='btn_x_gr' href='' title="<fmt:message key="report.button.remove_zsecondaxis" />">x</a></span>
	</td>
</tr>

<%
	}
%>