<%@page import="net.smartworks.model.report.info.ReportInfo"%>
<%@page import="net.smartworks.model.security.AccessPolicy"%>
<%@page import="net.smartworks.model.filter.info.SearchFilterInfo"%>
<%@page import="net.smartworks.model.filter.SearchFilter"%>
<%@page import="net.smartworks.server.engine.common.util.CommonUtil"%>
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
	User cUser = SmartUtil.getCurrentUser();

	SmartWork work = (SmartWork)session.getAttribute("smartWork");
	String workId = work.getId();
	String lastReportId = work.getLastReportId();
	Report lastReport = null;
	int lastReportType = -1;
	String lastChartType = null;
	if(lastReportId != null){
		lastReport = smartWorks.getReportById(lastReportId);
		lastReportType = lastReport.getType();
		if(lastReport.getType() == Report.TYPE_CHART) lastChartType = ((ChartReport)lastReport).getChartTypeInString();
	}
%>
<fmt:setLocale value="<%=cUser.getLocale() %>" scope="request" />
<fmt:setBundle basename="resource.smartworksMessage" scope="request" />
<!--  전체 레이아웃 -->
<div class="js_work_report_page mt15" workId="<%=workId %>" reportId="<%=lastReportId%>" reportType="<%=lastReportType %>" chartType="<%=lastChartType%>">
	<div class="list_title_space solid_line_sb">
		<div class="title"><fmt:message key="report.title.report" /></div>
		<div class="titleLineOptions">
			<select name="selMyReportList" class="js_select_work_report" href="work_report_view.sw?workId=<%=workId%>&workType=<%=work.getType()%>">							
				<option value="<%=Report.REPORT_ID_NONE %>" 
					<%if(SmartUtil.isBlankObject(lastReportId) || lastReportId.equals(Report.REPORT_ID_NONE)){ %> selected <%} %>>
					<fmt:message key="report.title.no_report" />
				</option>
				<%
				Report[] defaultReports = null;
				if(work.getType() == SmartWork.TYPE_INFORMATION) defaultReports =  ChartReport.DEFAULT_CHARTS_INFORMATION;
				else if(work.getType() == SmartWork.TYPE_PROCESS) defaultReports =  ChartReport.DEFAULT_CHARTS_PROCESS;
				else if(work.getType() == SmartWork.TYPE_SCHEDULE) defaultReports =  ChartReport.DEFAULT_CHARTS_SCHEDULE;
				if (defaultReports != null) {
					for (Report report : defaultReports) {
						String chartType = null;
						if(report.getType() == Report.TYPE_CHART) chartType = ((ChartReport)report).getChartTypeInString();
				%>
						<option value="<%=report.getId()%>" reportType="<%=report.getType()%>" <%if(chartType!=null){ %>chartType="<%=chartType%>"<%}%>
							<%if(report.getId().equals(lastReportId)){ %> selected <%} %>>
							<fmt:message key="<%=report.getName()%>" />
						</option>
				<%
					}
				}
				ReportInfo[] reports = work.getReports();
				if (reports != null) {
					for (ReportInfo report : reports) {
						String chartType = report.getChartTypeInString();
						if(SmartUtil.isBlankObject(report.getId())) continue;
				%>
						<option value="<%=report.getId()%>" reportType="<%=report.getType()%>" <%if(chartType!=null){ %>chartType="<%=chartType%>"<%}%>
							<%if(report.getId().equals(lastReportId)){ %> selected <%} %>><%=report.getName()%>
						</option>
				<%
					}
				}
				%>
			</select>
			
		</div>
		<div class="titleLineBtns">
			<span class="po_left js_progress_span"></span>
			
			<div class="btnIconsEdit">
				<a href="work_report_edit.sw" class="js_edit_work_report btnIconsTail"><fmt:message key="report.button.edit_report"/></a>
			</div>
		</div>
	</div>
	
	<div>
		<!-- 컨텐츠 -->
		<div class="js_work_report_edit" style="display:none"></div>
		<div class="js_work_report_view border_noTopLine" style="display:none">
			<%
			if(!SmartUtil.isBlankObject(lastReport)){
			%>
				<jsp:include page="/jsp/content/work/report/work_report_view.jsp">
					<jsp:param value="<%=lastChartType %>" name="chartType"/>
				</jsp:include>
				<script type="text/javascript">
					var workReport = $('.js_work_report_page');
					var reportId = workReport.attr("reportId");
					var reportType = workReport.attr("reportType");
					var chartType = workReport.attr("chartType");
					smartChart.load(parseInt(reportType), reportId, chartType, false, "chart_target");
	
				</script>
			<%} %>
		</div>
	</div>
</div>	

<!-- 전체 레이아웃//-->
