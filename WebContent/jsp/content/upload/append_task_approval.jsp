<%@page import="java.text.DecimalFormat"%>
<%@page import="net.smartworks.util.LocalDate"%>
<%@page import="net.smartworks.util.SmartUtil"%>
<%@page import="net.smartworks.model.community.User"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="net.smartworks.service.ISmartWorks"%>
<%
	ISmartWorks smartWorks = (ISmartWorks) request.getAttribute("smartWorks");
	User cUser = SmartUtil.getCurrentUser();
%>
<fmt:setLocale value="<%=cUser.getLocale() %>" scope="request" />
<fmt:setBundle basename="resource.smartworksMessage" scope="request" />

<!-- 업무계획하기 -->
<div class="form_add_a">
	<form name='frmTaskForward' class="input_1line js_validation_required">
		<span class="fl">
			<div class="js_task_approval_fields" subjectTitle="<fmt:message key='common.forward.title.subject'/>" forwardeeTitle="<fmt:message key='common.forward.title.forwardee'/>" CommentsTitle="<fmt:message key="common.forward.title.comments" />"></div>
		</span>
	</form>
	<div class="dash_line"></div>
</div>
<!-- 업무계획하기 //-->
