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
	String workId = request.getParameter("workId");
	User cUser = SmartUtil.getCurrentUser();

	SmartWork work = null;
	if (workId != null)
		work = (SmartWork) smartWorks.getWorkById(workId);
%>
<fmt:setLocale value="<%=cUser.getLocale() %>" scope="request" />
<fmt:setBundle basename="resource.smartworksMessage" scope="request" />
<!--  전체 레이아웃 -->

<div class="form_wrap up up_padding js_new_work_report_page" workId="<%=workId %>">
	<!-- 컨텐츠 -->
	<div class="form_title">
		<div class=" po_left"><fmt:message key="report.title.new_report" /></div>
		<div class="solid_line"></div>
	</div>
	<div class="js_work_report_edit">
		<jsp:include page="/jsp/content/work/report/work_report_edit.jsp">
			<jsp:param value="<%=workId %>" name="workId"/>
		</jsp:include>
	</div>
	<div class="js_work_report_view" style="display:none">
	</div>
</div>
<!-- 전체 레이아웃//-->
