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
	var $frmSmartForm = $('form[name="frmSmartForm"]');
	if(isEmpty($frmSmartForm)) {
		var target = $('#form_import');
		$.ajax({
			url : "file_detail_form.sw",
			success : function(data, status, jqXHR) {
				target.html(data).show();
				var form = $('form[name="frmNewFile"]');
				var uploader = form.find('.qq-uploader');
				var comments = form.find('textarea[name="txtaFileDesc"]').text();
				var groupId = uploader.attr('groupId');
				var fileList = uploader.find('.qq-upload-list li');
				var fileName = $(fileList[0]).attr('fileName');
				if(isEmpty(fileName))
					fileName = "";

				var formContent = $('#form_import').find('div.js_form_content');
				if(formContent.length == 1) {
					var workId = formContent.attr('workId');
					$.ajax({
						url : "get_form_xml.sw",
						data : {
							workId : workId
						},
						success : function(formXml, status, jqXHR) {
							var formXml = $(formXml);
							var dataFields = new Array();
							dataFields.push(SmartWorks.FormRuntime.TextInputBuilder.dataField({
								fieldName: '제목',
								formXml: formXml,
								value: fileName								
							}));
							dataFields.push(SmartWorks.FormRuntime.TextInputBuilder.dataField({
								fieldName: '검색어',
								formXml: formXml,
								value : fileName == "" ? currentUser.name : fileName + " " + currentUser.name
							}));
							dataFields.push(SmartWorks.FormRuntime.RefFormFieldBuilder.dataField({
								fieldName: '관리부서',
								formXml: formXml,
								refRecordId: currentUser.departmentId,
								value: currentUser.department
							}));
							dataFields.push(SmartWorks.FormRuntime.UserFieldBuilder.dataField({
								fieldName: '관리담당자',
								formXml: formXml,
								userId: currentUser.userId,
								longName: currentUser.longName
							}));
							dataFields.push(SmartWorks.FormRuntime.RichEditorBuilder.dataField({
								fieldName: '내용',
								formXml: formXml,
								value : comments
							}));
							dataFields.push(SmartWorks.FormRuntime.FileFieldBuilder.dataField({
									fieldName: '첨부파일',
									formXml: formXml,
									groupId: groupId,
									isTempfile: true,
									fileList: fileList
							}));

							var record = {dataFields: dataFields};
							console.log("record", record);
							new SmartWorks.GridLayout({
								target : formContent,
								formXml : formXml,
								formValues : record,
								mode : "edit"
							});
							$frmSmartForm = $('form[name="frmSmartForm"]');
						}
					});
				}
			}
		});
	} else {
		var sw_validate = SmartWorks.GridLayout.validate($frmSmartForm);
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
			console.log("JSON", JSON.stringify(paramsJson));
			
		} else {
			return;
		}
	}
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
	return;
}
</script>

<%
	ISmartWorks smartWorks = (ISmartWorks) request.getAttribute("smartWorks");
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