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
	if (work.getClass().equals(SmartWork.class))
		cWork = (SmartWork) work;
%>
<fmt:setLocale value="<%=cUser.getLocale() %>" scope="request" />
<fmt:setBundle basename="resource.smartworksMessage" scope="request" />

<div id="form_works">
	<table>
		<colgroup>
			<col class="item">
			<col class="field">
			<col class="item">
			<col class="field">
		</colgroup>
		<tbody>
			<tr>
				<th colspan="2"><%=cWork.getFullpathName()%></th>
				<td colspan="2">
					<div class="txt_btn">
						<div>
							<a class="js_select_forwardee" href=""><fmt:message
									key="common.upload.button.forwardee" /> </a>
						</div>
						<div>
							<a class="js_select_approval" href=""><fmt:message
									key="common.upload.button.approval" /> </a>
						</div>
					</div></td>
			</tr>
			<tr>
				<td colspan="4" class="solid_line"></td>
			</tr>
			<tr class="js_start_tab_form">
				<td colspan="4">
					<div class="txt_btn">
						<div>
							<a href="load_detail_form.sw?key=<%=cWork.getId()%>"><fmt:message
									key="common.upload.button.detail" /> </a>
						</div>
						<div class="current">
							<a href="load_brief_form.sw?key=<%=cWork.getId()%>"><fmt:message
									key="common.upload.button.brief" /> </a>
						</div>
					</div>
	<div id="form_import">
		<jsp:include page="/jsp/content/work/form/load_brief_form.jsp"></jsp:include>
	</div>
				</td>
			</tr>
		</tbody>
	</table>
</div>
	<jsp:include page="/jsp/content/upload/check_schedule_work.jsp"></jsp:include>
