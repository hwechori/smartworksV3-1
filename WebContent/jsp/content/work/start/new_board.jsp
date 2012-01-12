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
	var newBoard = $('js_new_board_page');
	if(!SmartWorks.GridLayout.validate(newBoard.find('form.js_validation_required'))) return

	var forms = newBoard.find('form');
	var paramsJson = {};
	for(var i=0; i<forms.length; i++){
		var form = $(forms[i]);
		paramsJson[form.attr('name')] = mergeObjects(form.serializeObject(), SmartWorks.GridLayout.serializeObject(form));
	}
	console.log(JSON.stringify(paramsJson));
	var progressSpan = newBoard.find('.js_progress_span');
	smartPop.progressCont(progressSpan);
	var url = "create_new_board.sw";
	$.ajax({
		url : url,
		contentType : 'application/json',
		type : 'POST',
		data : JSON.stringify(paramsJson),
		success : function(data, status, jqXHR) {
			smartPop.closeProgress();
			document.location.href = data.href;
		},
		error : function(e) {
			smartPop.closeProgress();
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
<div class="up_wrap js_new_board_page">
	<div class="up_point posit_board"></div>
	<div class="form_wrap up up_padding">


		<!-- 폼- 확장 -->
		<form name="frmNewBoard" class="form_title js_validation_required">
			<div class="js_new_board_fields" boardNameTitle="<fmt:message key='common.upload.board.name'/>" boardDetailsTitle="<fmt:message key='common.upload.board.details'/>" boardFilesTitle="<fmt:message key='common.upload.board.files'/>">
			</div>
		</form>
		<jsp:include page="/jsp/content/upload/upload_buttons.jsp"></jsp:include>
	</div>
</div>