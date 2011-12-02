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

<script type="text/javascript">
	function submitForms(e) {
		if ($('form.js_validation_required').validate().form()) {
			var scheduleWork = document.getElementsByName('frmScheduleWork');
			if (scheduleWork[0].chkScheduleWork.value === 'on') {
				scheduleWork[0].hdnSchedulePerformer.value = $(
						scheduleWork[0].txtSchedulePerformer).attr('uid');
			}
			var params = $('form').serialize();
			var url = "create_new_iwork.sw";
			$.ajax({
				url : url,
				type : 'POST',
				data : params,
				success : function(data, status, jqXHR) {
					document.location.href = data.href;
				},
				error : function(e) {
					alert(e);
				}
			});
		} else {
			return;
		}
		return;
	}
</script>
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
%>
<fmt:setLocale value="<%=cUser.getLocale() %>" scope="request" />
<fmt:setBundle basename="resource.smartworksMessage" scope="request" />
<!--  전체 레이아웃 -->
<div class="up_wrap">
	<div class="form_wrap up up_padding">


		<!-- 컨텐츠 -->
		<div class="contents_space">
			<div class="border">

				<div class="list_title_space">
					<div class="title_stat">새 통계분석 만들기</div>
				</div>

				<table class="margin_t10">
					<tbody>
						<tr>
							<td width="11%"><div class="essen_r">제 목</div>
							</td>
							<td width="89%" colspan="3"><div class="fieldline">
									<input id="" type="text" name="txtWorkReportName"
										value="<%if (report != null) {%><fmt:message key='<%=report.getName() %>'/><%}%>">
								</div>
							</td>
						</tr>
						<tr class="js_work_report_type">
							<td>보고서 종류</td>
							<td colspan="3" class=""><input name="rdoWorkReportType"
								type="radio" value="<%=Report.TYPE_CHART%>"
								<%if ((report != null) && (report.getType() == Report.TYPE_CHART)) {%>
								checked <%}%>>차트 <input name="rdoReportType"
								type="radio" value="<%=Report.TYPE_MATRIX%>"
								<%if ((report != null) && (report.getType() == Report.TYPE_MATRIX)) {%>
								checked <%}%>>매트릭스 <input name="rdoReportType"
								type="radio" value="<%=Report.TYPE_TABLE%>"
								<%if ((report != null) && (report.getType() == Report.TYPE_TABLE)) {%>
								checked <%}%>>테이블</td>
						</tr>

						<tr class="js_report_chart_type"
							<%if (report == null || report.getType() != Report.TYPE_CHART) {%>
							style="display: none" <%}%>>
							<td><div class="essen_r">차트 종류</div>
							</td>
							<td colspan="3" class=""><select name="selReportChartType">
									<option value="<%=ChartReport.CHART_TYPE_COLUMN%>"
										<%if (chart != null && chart.getChartType() == ChartReport.CHART_TYPE_COLUMN) {%>
										selected <%}%>>컬럼 차트</option>
									<option value="<%=ChartReport.CHART_TYPE_BAR%>"
										<%if (chart != null && chart.getChartType() == ChartReport.CHART_TYPE_BAR) {%>
										selected <%}%>>바 차트</option>
									<option value="<%=ChartReport.CHART_TYPE_LINE%>"
										<%if (chart != null && chart.getChartType() == ChartReport.CHART_TYPE_LINE) {%>
										selected <%}%>>라인 차트</option>
									<option value="<%=ChartReport.CHART_TYPE_PIE%>"
										<%if (chart != null && chart.getChartType() == ChartReport.CHART_TYPE_PIE) {%>
										selected <%}%>>파이 차트</option>
									<option value="<%=ChartReport.CHART_TYPE_AREA%>"
										<%if (chart != null && chart.getChartType() == ChartReport.CHART_TYPE_AREA) {%>
										selected <%}%>>구역 차트</option>
									<option value="<%=ChartReport.CHART_TYPE_PLOT%>"
										<%if (chart != null && chart.getChartType() == ChartReport.CHART_TYPE_PLOT) {%>
										selected <%}%>>플롯 차트</option>
									<option value="<%=ChartReport.CHART_TYPE_BUBBLE%>"
										<%if (chart != null && chart.getChartType() == ChartReport.CHART_TYPE_BUBBLE) {%>
										selected <%}%>>버블 차트</option>
							</select></td>
						</tr>
						<tr>
							<td><div class="essen_r">X축</div>
							</td>
							<td colspan="3" class=""><select name="selReportXAxis" class="js_select_chart_xaxis">
									<%
										if (fields != null) {
											for (FormField field : fields) {
									%>
									<option type="<%=field.getPageName()%>"
										value="<%=field.getId()%>"><%=field.getName()%></option>
									<%
										}
										}
									%>
									<jsp:include page="/jsp/content/work/field/default_fields.jsp">
										<jsp:param name="type" value="<%=work.getType() %>" /></jsp:include>
							</select>
							<%
							if(chart!=null){
								String fieldType = chart.getXAxis().getType();
								if (fieldType.equals(FormField.TYPE_DATE) || fieldType.equals(FormField.TYPE_DATETIME)) {
							%>
							<select name="selReportXAxisSelectorDate" class="js_xaxis_selector_date">
									<%
										for (KeyMap selector : Report.AXIS_SELECTORS_DATE) {
									%>
									<option value="<%=selector.getId()%>">
										<fmt:message key="<%=selector.getKey() %>" />
									</option>
									<%
										}
									%>
							</select><
							<%
								} else if (fieldType.equals(FormField.TYPE_USER)) {
							%>
							<select name="selReportXAxisSelectorUser" class="js_xaxis_selector_user">
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
							<%
								}
							}
							%>
						</tr>
						<tr>
							<td><div class="essen_r">Y축</div>
							</td>
							<td colspan="3" class=""><select name="selReportYAxis">
									<%
										if (fields != null) {
											for (FormField field : fields) {
									%>
									<option type="<%=field.getPageName()%>"
										value="<%=field.getId()%>"><%=field.getName()%></option>
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
						<tr>
							<td><div class="essen_r">Z축</div>
							</td>
							<td colspan="3" class=""><select name="jumpMenu"
								id="jumpMenu">
									<option>업무처리기간</option>
									<option></option>
							</select></td>
						</tr>
						<tr>
							<td>상세필터</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>


		<!-- 등록 취소 버튼 -->
		<div class="glo_btn_space">

			<div class="float_right padding_r10">
				<span class="btn_gray"> <a href=""> <span
						class="Btn01Start"></span> <span class="Btn01Center">저장</span> <span
						class="Btn01End"></span> </a> </span> <span class="btn_gray space_l5">
					<a href=""> <span class="Btn01Start"></span> <span
						class="Btn01Center">취소</span> <span class="Btn01End"></span> </a> </span>
			</div>

			<div class="float_right padding_r10">

				<form class="float_right form_space">
					<img class="bu_read"> <select>
						<option>전체공개</option>
						<option>비공개</option>
					</select>
				</form>
			</div>
		</div>
		<!-- 등록 취소 버튼//-->
	</div>
</div>
<!-- 전체 레이아웃//-->
