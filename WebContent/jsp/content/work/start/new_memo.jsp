<%@page import="net.smartworks.model.work.SmartWork"%>
<%@page import="net.smartworks.model.work.Work"%>
<%@page import="net.smartworks.util.SmartUtil"%>
<%@page import="net.smartworks.util.SmartTest"%>
<%@page import="net.smartworks.model.community.User"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="net.smartworks.service.ISmartWorks"%>

<script type="text/javascript">
function submitForms() {
	var newMemo = $('.js_new_memo_page');
	if(!SmartWorks.GridLayout.validate(newMemo.find('form.js_validation_required'))) return

	var forms = newMemo.find('form');
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
	var progressSpan = newMemo.find('.js_progress_span');
	smartPop.progressCont(progressSpan);
	var url = "create_new_memo.sw";
	$.ajax({
		url : url,
		contentType : 'application/json',
		type : 'POST',
		data : JSON.stringify(paramsJson),
		success : function(data, status, jqXHR) {
			smartPop.closeProgress();
			smartPop.showInfo(smartPop.INFO, smartMessage.get("createMemoSucceed"), function(){
				document.location.href = data.href;
			});
		},
		error : function(e) {
			smartPop.closeProgress();
			smartPop.showInfo(smartPop.ERROR, smartMessage.get("createMemoError"));
		}
	});
}
</script>

<%
	ISmartWorks smartWorks = (ISmartWorks) request.getAttribute("smartWorks");
	User cUser = SmartUtil.getCurrentUser();
%>
<fmt:setLocale value="<%=cUser.getLocale() %>" scope="request" />
<fmt:setBundle basename="resource.smartworksMessage" scope="request" />

<div class="up_wrap js_new_memo_page">
	<div class="up_point posit_memo"></div>
	<div class="form_wrap up up_padding">

		<!-- 폼- 확장 -->
		<form name='frmNewMemo' class="form_title js_validation_required">
			<div class="js_new_memo_fields" memoNameTitle="<fmt:message key='common.upload.memo.name'/>">
			</div>
		</form>
		<jsp:include page="/jsp/content/upload/upload_buttons.jsp"></jsp:include>

	</div>
</div>