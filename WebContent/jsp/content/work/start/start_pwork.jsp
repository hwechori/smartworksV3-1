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

<!-- 폼- 확장 -->
<div id="form_wrap">
	<div id="form_title">
		<div class="ico_pworks title"><%=cWork.getFullpathName()%></div>
		<div class="txt_btn float_left padding_l10">
			<a href=""><fmt:message key="common.upload.button.view_process"/>▼</a>
		</div>
		<div class="txt_btn">
			<div>
				<a href=""><fmt:message key="common.upload.button.forwardee" />
				</a>
			</div>
		</div>
	</div>

	<div id="form_contents">

		<div class="txt_btn padding_r10">
			<div>
				<a class="js_toggle_form_detail" href="load_detail_form.sw?key=<%=cWork.getId()%>"><fmt:message
						key="common.upload.button.detail" /> </a>
			</div>
			<div  style="display:none">
				<a class="js_toggle_form_detail" href="load_brief_form.sw?key=<%=cWork.getId()%>"><fmt:message
						key="common.upload.button.brief" /> </a>
			</div>
		</div>
		<div id="form_import">
			<jsp:include page="/jsp/content/work/form/load_brief_form.jsp"></jsp:include>
		</div>
	</div>
</div>
<!-- 폼- 확장 //-->
<jsp:include page="/jsp/content/upload/upload_buttons.jsp"></jsp:include>
