<%@page import="java.text.DecimalFormat"%>
<%@page import="net.smartworks.util.LocalDate"%>
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
	var newEvent = $('.js_new_event_page');
	if(!SmartWorks.GridLayout.validate(newEvent.find('form.js_validation_required'))) return
	var forms = newEvent.find('form');
	var paramsJson = {};
	for(var i=0; i<forms.length; i++){
		var form = $(forms[i]);
		if(form.attr('name') === 'frmSmartForm'){
			paramsJson['formId'] = form.attr('formId');
			paramsJson['formName'] = form.attr('formName');
		}else if(form.attr('name') === 'frmNewFile'){
			continue;
		}
		paramsJson[form.attr('name')] = mergeObjects(form.serializeObject(), SmartWorks.GridLayout.serializeObject(form));
	}
	console.log(JSON.stringify(paramsJson));
	var progressSpan = newEvent.find('.js_progress_span');
	smartPop.progressCont(progressSpan);
	var url = "create_new_event.sw";
	$.ajax({
		url : url,
		contentType : 'application/json',
		type : 'POST',
		data : JSON.stringify(paramsJson),
		success : function(data, status, jqXHR) {
			smartPop.closeProgress();
			smartPop.showInfo(smartPop.INFO, smartMessage.get("createEventSucceed"), function(){
				document.location.href = data.href;
			});
		},
		error : function(e) {
			smartPop.closeProgress();
			smartPop.showInfo(smartPop.ERROR, smartMessage.get("createEventError"));
		}
	});
}
</script>

<%
	ISmartWorks smartWorks = (ISmartWorks) request.getAttribute("smartWorks");
	User cUser = SmartUtil.getCurrentUser();
	LocalDate date = new LocalDate();
	String today = date.toLocalDateSimpleString();
	String curTime = date.toLocalTimeShortString();
%>
<fmt:setLocale value="<%=cUser.getLocale() %>" scope="request" />
<fmt:setBundle basename="resource.smartworksMessage" scope="request" />

<div class="up_wrap js_new_event_page">
	<div class="up_point posit_event"></div>
	<div class="form_wrap up up_padding">
		<!-- 폼- 확장 -->
		<form name="frmNewEvent" class="form_title js_validation_required">
			<div class="js_new_event_fields" eventNameTitle="<fmt:message key='common.upload.event.name'/>" 
				startDateTitle="<fmt:message key='common.upload.event.start_date'/>" endDateTitle="<fmt:message key='common.upload.event.end_date'/>"  alarmPolicyTitle="<fmt:message key='common.upload.button.set_alarm'/>"
				placeTitle="<fmt:message key='common.upload.event.place'/>" relatedUsersTitle="<fmt:message key='common.upload.event.related_users'/>" 
				contentTitle="<fmt:message key='common.upload.event.content' />">
			</div>

		</form>
		<jsp:include page="/jsp/content/upload/upload_buttons.jsp"></jsp:include>
	</div>
</div>
