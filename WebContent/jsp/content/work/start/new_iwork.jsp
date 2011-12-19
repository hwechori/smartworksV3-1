<%@page import="net.smartworks.model.work.SmartForm"%>
<%@page import="net.smartworks.model.work.InformationWork"%>
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
	var sw_validate = SmartWorks.GridLayout.validate($('form[name="frmSmartForm"]'));
	if ($('form.js_validation_required').validate({ showErrors: showErrors}).form() && sw_validate) {
		var scheduleWork = document.getElementsByName('frmScheduleWork');
		if(scheduleWork[0].chkScheduleWork.value === 'on'){
			scheduleWork[0].hdnSchedulePerformer.value = $(scheduleWork[0].txtSchedulePerformer).attr('uid');
		}
		var forms = $('form');
		var paramsJson = {};
		for(var i=0; i<forms.length; i++){
			var form = $(forms[i]);
			if(form.attr('name') === 'frmSmartForm'){
				paramsJson['formId'] = form.attr('formId');
				paramsJson['formName'] = form.attr('formName');
				paramsJson[form.attr('name')] = mergeObjects(form.serializeObject(), SmartWorks.GridLayout.serializeObject(form));

			}else{
				paramsJson[form.attr('name')] = form.serializeObject();				
			}
		}
		console.log(JSON.stringify(paramsJson));
		alert('wait');
		var url = "create_new_iwork.sw";
		$.ajax({
			url : url,
			contentType : 'application/json',
			type : 'POST',
			data : JSON.stringify(paramsJson),
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
	User cUser = SmartUtil.getCurrentUser();
	SmartWork work = (SmartWork)smartWorks.getWorkById(workId);
	
%>
<fmt:setLocale value="<%=cUser.getLocale() %>" scope="request" />
<fmt:setBundle basename="resource.smartworksMessage" scope="request" />

<div class="form_wrap up up_padding margin_b2 js_form_wrap">
	<div class="form_title">
		<div class="ico_iworks title"><%=work.getFullpathName()%></div>
		<div class="txt_btn">
			<div class="po_right image_posi">
				<a href=""><img src="images/btn_approvep.gif" title="<fmt:message key='common.button.approval'/>" /> </a>
			</div>
			<div class="po_right image_posi">
				<a href=""><img src="images/btn_referw.gif" title="<fmt:message key='common.button.forward'/>" /> </a>
			</div>
		</div>
		<div class="solid_line"></div>
	</div>

	<div class="js_form_content" workId="<%=workId%>"></div>
	<jsp:include page="/jsp/content/upload/check_schedule_work.jsp"></jsp:include>
	<!-- 폼- 확장 //-->
	<jsp:include page="/jsp/content/upload/upload_buttons.jsp"></jsp:include>
</div>
