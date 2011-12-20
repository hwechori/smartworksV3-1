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
		var url = "upload_new_file.sw";
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
	String workId = SmartWork.WORK_ID_FILE_MANAGEMENT;
	User cUser = SmartUtil.getCurrentUser();
%>
<fmt:setLocale value="<%=cUser.getLocale() %>" scope="request" />
<fmt:setBundle basename="resource.smartworksMessage" scope="request" />

<div class="up_wrap">
	<div class="up_point posit_file"></div>
	<div class="up up_padding">
		<!-- 폼- 확장 -->
		<form name="frmNewFile" class="form_wrap js_validation_required">
			<div class="form_title" class="js_file_brief_form">

				<textarea class="up_textarea" name='txtaFileDesc' rows="5" placeholder="<fmt:message key="common.upload.message.file_desc" />"></textarea>

				<div class="btn_gray padding_t5 js_file_uploader">
 				</div>
			</div>
			<div class="form_contents">
				<div class="txt_btn txt_btn_height js_file_detail_form">
					<div>
						<a class="js_toggle_form_detail" href="file_detail_form.sw"><fmt:message
								key="common.upload.button.view_file_detail" /> </a>
					</div>
					<div style="display: none">
						<a class="js_toggle_form_detail" href="empty_content.sw"><fmt:message
								key="common.upload.button.close_file_detail" /> </a>
					</div>
				</div>

				<!-- 상세 정보 추가시 화면 -->
				<div id="form_import"></div>
				<!-- 상세 정보 추가시 화면 //-->
			</div>
			<!-- 하단 등록,취소 버튼 -->
			<jsp:include page="/jsp/content/upload/upload_buttons.jsp"></jsp:include>
			<!-- 하단 등록,취소 버튼 -->
	</form>
</div>
</div>