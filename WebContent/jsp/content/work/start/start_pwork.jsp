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

	Work work = smartWorks.getWorkById(workId);
	SmartWork cWork = null;
	if(work.getClass().equals(SmartWork.class))
		cWork = (SmartWork)work;
%>
<fmt:setLocale value="<%=cUser.getLocale() %>" scope="request" />
<fmt:setBundle basename="resource.smartworksMessage" scope="request" />

<div>
<%=cWork.getFullpathName() %>
</div>
	<div>
		<a class="js_select_forwardee" href=""><fmt:message key="common.upload.button.forwardee"/></a>
	</div>
	<div>
		<a class="js_select_approval" href=""><fmt:message key="common.upload.button.approval"/></a>
	</div>

<div class="txt_btn js_start_tab_form">
	<div>
		<a href="load_detail_form.sw?key=<%=cWork.getId() %>" ><fmt:message key="common.upload.button.detail"/></a>
	</div>
	<div class="current">
		<a href="load_brief_form.sw?key=<%=cWork.getId() %>" ><fmt:message key="common.upload.button.brief"/></a>
	</div>
	<div>
		<a href="load_process_diagram_viewer.sw?key=<%=cWork.getId() %>" ><fmt:message key="common.upload.button.process"/></a>
	</div>
</div>

<div id="form_import">
<jsp:include page="/jsp/content/work/form/load_brief_form.jsp"></jsp:include>
</div>
<jsp:include page="/jsp/content/upload/check_schedule_work.jsp"></jsp:include>
<jsp:include page="/jsp/content/upload/upload_buttons.jsp"></jsp:include>
