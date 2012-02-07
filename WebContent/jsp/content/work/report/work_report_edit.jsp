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
	String reportId = request.getParameter("reportId");
	User cUser = SmartUtil.getCurrentUser();

	SmartWork work = (SmartWork)session.getAttribute("smartWork");
	String workId = work.getId();
	Report report = null;
	String filterId = "";
	int reportType = Report.TYPE_CHART;
	if (reportId != null) {
		report = smartWorks.getReportById(reportId);
		reportType = report.getType();
		if (report.getSearchFilter() != null)
			filterId = report.getSearchFilter().getId();
	}
%>
<fmt:setLocale value="<%=cUser.getLocale() %>" scope="request" />
<fmt:setBundle basename="resource.smartworksMessage" scope="request" />
<!--  전체 레이아웃 -->
<div class="border_noTopLine">
<form name="frmWorkReport" class="form_contents js_validation_required js_work_report_edit_page" workId="<%=workId%>" reportId="<%=reportId%>">
	<table class="table_nomal js_report_title">
		<tr style="display:none" class="js_work_report_name">
			<th><fmt:message key="report.title.report_name" /><span class="essen_n"></span></th>
			<td colspan="4">
				<input name="txtWorkReportName" type="text" class="fieldline required">
			</td>
		</tr>

		<tr class="js_work_report_type">
			<th><fmt:message key="report.title.report_type" /></th>
			<td colspan="4" class="">
				<input name="rdoWorkReportType" type="radio" value="<%=Report.TYPE_CHART%>"
					href="work_report_chart.sw?reportId=<%=CommonUtil.toNotNull(reportId)%>"
					<%if (reportType == Report.TYPE_CHART) {%> checked <%}%>><fmt:message key="report.type.chart" />
				<input name="rdoWorkReportType" type="radio" value="<%=Report.TYPE_MATRIX%>"
					href="work_report_chart.sw?reportId=<%=CommonUtil.toNotNull(reportId)%>"
					<%if (reportType == Report.TYPE_MATRIX) {%> checked <%}%>><fmt:message key="report.type.matrix" />
				<input name="rdoWorkReportType" type="radio" value="<%=Report.TYPE_TABLE%>"
					href="work_report_table.sw?reportId=<%=CommonUtil.toNotNull(reportId)%>"
					<%if (reportType == Report.TYPE_TABLE) {%> checked <%}%>> <fmt:message key="report.type.table" />
			</td>
		</tr>
	</table>
	<table class="table_nomal js_form_by_report_type">
		<%
		if (reportType == Report.TYPE_CHART || reportType == Report.TYPE_MATRIX) {
		%>
			<jsp:include page="/jsp/content/work/report/work_report_chart.jsp">
				<jsp:param name="reportId" value="<%=CommonUtil.toNotNull(reportId) %>" />
				<jsp:param name="reportType" value="<%=reportType %>" />
			</jsp:include>
		<%
		} else if (reportType == Report.TYPE_TABLE) {
		%>
			<jsp:include page="/jsp/content/work/report/work_report_table.jsp">
				<jsp:param name="reportId" value="<%=CommonUtil.toNotNull(reportId) %>" />
				<jsp:param name="reportType" value="<%=reportType %>" />
			</jsp:include>
		<%
		}
		%>
	</table>

		<table class="table_nomal js_form_by_report_type">
		<tr class="js_report_search_filter">
			<th><fmt:message key="report.title.search_filter" /></th>
			<td colspan="4" class="">
				<select name="selReportFilterName">
					<option value="<%=SearchFilter.FILTER_ALL_INSTANCES%>" <%if(SmartUtil.isBlankObject(filterId) || filterId.equals(SearchFilter.FILTER_ALL_INSTANCES)) {%> selected <%} %> ><fmt:message key='filter.name.all_instances' /></option>
					<option value="<%=SearchFilter.FILTER_MY_INSTANCES%>" <%if(filterId.equals(SearchFilter.FILTER_MY_INSTANCES)) {%> selected <%} %> ><fmt:message key='filter.name.my_instances' /></option>
					<option value="<%=SearchFilter.FILTER_RECENT_INSTANCES%>" <%if(filterId.equals(SearchFilter.FILTER_RECENT_INSTANCES)) {%> selected <%} %> ><fmt:message key='filter.name.recent_instances' /></option>
					<option value="<%=SearchFilter.FILTER_MY_RECENT_INSTANCES%>" <%if(filterId.equals(SearchFilter.FILTER_MY_RECENT_INSTANCES)) {%> selected <%} %> ><fmt:message key='filter.name.my_recent_instances' /></option>
					<%
					SearchFilterInfo[] filters = work.getSearchFilters();
					if (filters != null) {
						for (SearchFilterInfo filter : filters) {
							if(SmartUtil.isBlankObject(filter.getId())) continue;
					%>
						<option value="<%=filter.getId()%>" <%if(filterId.equals(filter.getId())) {%> selected <%} %> ><%=filter.getName()%></option>
					<%
						}
					}
					%>
				</select>
			</td>
		</tr>
	</table>
</form>

<!-- 등록 취소 버튼 -->
<div class="glo_btn_space js_button_space">
	<div class="float_right">
		<span class="btn_gray js_button_save_as"> 
			<a href="" class="js_work_report_saveas"> 
				<span class="Btn01Start"></span> 
				<span class="Btn01Center"><fmt:message key="common.button.save_as"/></span> 
				<span class="Btn01End"></span>
			</a> 
		</span> 
		
		<span class="btn_gray" <%if(SmartUtil.isBlankObject(report) || report.isSystemReport()){ %>style="display:none" <%} %>> 
			<a href="" class="js_work_report_delete"> 
				<span class="Btn01Start"></span> 
				<span class="Btn01Center"><fmt:message key="common.button.delete"/></span> 
				<span class="Btn01End"></span>
			</a> 
		</span> 
		<span class="btn_gray js_button_save"  <%if(!SmartUtil.isBlankObject(report) && report.isSystemReport()){ %>style="display:none" <%} %>> 
			<a href="" class="js_work_report_save"> 
				<span class="Btn01Start"></span> 
				<span class="Btn01Center"><fmt:message key="common.button.save"/></span> 
				<span class="Btn01End"></span>
			</a> 
		</span>

		<span class="btn_gray"> 
			<a href="" class="js_work_report_execute"> 
				<span class="Btn01Start"></span> 
				<span class="Btn01Center"><fmt:message key="common.button.execute"/></span> 
				<span class="Btn01End"></span>
			</a> 
		</span> 
		<span class="btn_gray space_l5">
			<a href="" class="js_work_report_close"> 
				<span class="Btn01Start"></span> 
				<span class="Btn01Center"><fmt:message key="common.button.cancel"/></span> 
				<span class="Btn01End"></span> 
			</a> 
		</span>
	</div>

	<form name="frmAccessPolicy" class="float_right padding_r10 js_validation_required">
		<div class="float_right form_space">	
			<select name="selAccessPolicy">
				<option value="<%=AccessPolicy.LEVEL_PUBLIC%>"><fmt:message key="common.security.access.public"/></option>
				<option value="<%=AccessPolicy.LEVEL_PRIVATE%>"><fmt:message key="common.security.access.private"/></option>
			</select>
		</div>
		<div class="float_right form_space">
			<span class="bu_read margin_t2"></span> 
		</div>
	</form>

	<!--  실행시 표시되는 프로그래스아이콘을 표시할 공간 -->
	<div class="float_right form_space js_progress_span" ></div>
	
	<!-- 실행시 데이터 유효성 검사이상시 에러메시지를 표시할 공간 -->
	<span class="form_space sw_error_message js_report_error_message" style="text-align:right; color: red"></span>
</div>
</div>
<!-- 등록 취소 버튼//-->
