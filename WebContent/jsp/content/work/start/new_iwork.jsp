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
		if(scheduleWork[0].chkScheduleWork.value === 'on'){
			scheduleWork[0].hdnSchedulePerformer.value = $(scheduleWork[0].txtSchedulePerformer).attr('uid');
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
	String companyId = (String) session.getAttribute("companyId");
	String userId = (String) session.getAttribute("userId");
	
	ISmartWorks smartWorks = (ISmartWorks) request.getAttribute("smartWorks");
	String workId = request.getParameter("workId");
	User cUser = SmartUtil.getCurrentUser();

	Work work = smartWorks.getWorkById(companyId, workId);
	SmartWork cWork = null;
	if (work.getClass().equals(SmartWork.class))
		cWork = (SmartWork) work;
%>
<fmt:setLocale value="<%=cUser.getLocale() %>" scope="request" />
<fmt:setBundle basename="resource.smartworksMessage" scope="request" />

<!-- 폼- 확장 -->
<div class="form_wrap up up_padding">
	<div class="form_title">
		<div class="ico_iworks title"><%=cWork.getFullpathName()%></div>
		<div class="txt_btn">
			<div>
				<a href=""><img src="images/btn_approvep.gif" title="<fmt:message key='common.button.approval'/>" /> </a>
			</div>
			<div>
				<a href=""><img src="images/btn_referw.gif" title="<fmt:message key='common.button.forward'/>" /> </a>
			</div>
		</div>
		<div class="solid_line"></div>
	</div>

	<form name='frmNewIWork' class="form_contents js_validation_required">

		<div class="txt_btn">
			<div>
				<a class="js_toggle_form_detail"
					href="load_detail_form.sw?key=<%=cWork.getId()%>"><fmt:message
						key="common.upload.button.detail" /> </a>
			</div>
			<div style="display: none">
				<a class="js_toggle_form_detail"
					href="load_brief_form.sw?key=<%=cWork.getId()%>"><fmt:message
						key="common.upload.button.brief" /> </a>
			</div>
		</div>
		<div id="form_import">
			<jsp:include page="/jsp/content/work/form/load_brief_form.jsp"></jsp:include>
		</div>
	</form>
	<jsp:include page="/jsp/content/upload/check_schedule_work.jsp"></jsp:include>
	<!-- 폼- 확장 //-->
	<jsp:include page="/jsp/content/upload/upload_buttons.jsp"></jsp:include>
</div>