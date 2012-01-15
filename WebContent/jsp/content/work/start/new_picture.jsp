
<!-- Name 			: new_picture.jsp										 -->
<!-- Description	: 스마트폼을 이용하여 새로운 사진을 업로드하는 화면 	 	      	 -->
<!-- Author			: Maninsoft, Inc.										 -->
<!-- Created Date	: 2011.9.												 -->

<%@page import="net.smartworks.model.work.SmartWork"%>
<%@page import="net.smartworks.model.work.Work"%>
<%@page import="net.smartworks.util.SmartUtil"%>
<%@page import="net.smartworks.util.SmartTest"%>
<%@page import="net.smartworks.model.community.User"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="net.smartworks.service.ISmartWorks"%>
<script type="text/javascript">

//완료버튼 클릭시 file_detail_form.sw, get_form_xml.sw, upload_new_picture.sw 서비스들을 실행하기 위해 submit하는 스크립트..
function submitForms(e) {
	var newPicture = $('.js_new_picture_page');

	// new_picture 에 있는 활성화되어 있는 모든 입력화면들을 validation하여 이상이 있으면 리턴한다....
	if(!SmartWorks.GridLayout.validate(newPicture.find('form.js_validation_required'))) return

	var target = newPicture.find('#form_import');

	// 서비스요청 프로그래스바를 나타나게 한다....
	var progressSpan = newPicture.find('.js_progress_span');
	smartPop.progressCont(progressSpan);
	
	// file_detail_form.sw 서비스를 요청한다. 파일상세입력화면...
	$.ajax({
		url : "file_detail_form.sw",
		success : function(data, status, jqXHR) {
			//성공하면 받은 화면을 타겟에 보여준다..
			target.html(data).hide();
			var form = newPicture.find('form[name="frmNewPicture"]');
			var uploader = form.find('.qq-uploader');
			var comments = form.find('textarea[name="txtPictureDesc"]').attr("value");
			var groupId = uploader.attr('groupId');
			var fileList = uploader.find('.qq-upload-list li');
			var fileName = $(fileList[0]).attr('fileName');
			if(isEmpty(fileName))
				fileName = "";
			var formContent = newPicture.find('#form_import').find('div.js_form_content');
			if(!isEmpty(formContent)) {
				
				// 파일상세화면에 보여줄 화면 xml데이터를 서버에서 가져다가 화면을 그린다...
				var workId = formContent.attr('workId');
				$.ajax({
					url : "get_form_xml.sw",
					data : {
						workId : workId
					},
					success : function(formXml, status, jqXHR) {
						
						// 화면 xml을 가져오면 가져온 값과 입력된 사진정보 및 설명값들을 가지고 스마트폼을 이용해 화면을 그린다...
						var formXml = $(formXml);
						new SmartWorks.GridLayout({
							target : formContent,
							formXml : formXml,
							formValues : createFileDataFields({
								formXml : formXml,
								groupId : groupId,
								fileName : fileName,
								fileList : fileList,
								comments : comments								
							}),
							mode : "edit"
						});
						
						// 그려진 화면에 있는 입력화면들을 JSON형식으로 Serialize한다...
						$frmSmartForm = formContent.children('form');
						var forms = newPicture.find('form');
						var paramsJson = {};
						for(var i=0; i<forms.length; i++){
							var form = $(forms[i]);
							if(form.attr('name') === 'frmSmartForm'){
								paramsJson['formId'] = form.attr('formId');
								paramsJson['formName'] = form.attr('formName');
							}else if(form.attr('name') === 'frmNewPicture'){
								continue;
							}
							paramsJson[form.attr('name')] = mergeObjects(form.serializeObject(), SmartWorks.GridLayout.serializeObject(form));
						}
						console.log("JSON", JSON.stringify(paramsJson));
						
						// JSON 데이터를 전송하면서 upload_new_picture.sw 서비스를 호출하여 사진 업로드를 실행한다...
						var url = "upload_new_picture.sw";
						$.ajax({
							url : url,
							contentType : 'application/json',
							type : 'POST',
							data : JSON.stringify(paramsJson),
							success : function(data, status, jqXHR) {
								smartPop.closeProgress();
								smartPop.showInfo(smartPop.INFO, smartMessage.get("uploadPictureSucceed"), function(){
									document.location.href = data.href;
								});
							},
							error : function(e) {
								smartPop.closeProgress();
								smartPop.showInfo(smartPop.ERROR, smartMessage.get("uploadPictureError"));
							}
						});
					}
				});
			}
		}
	});
}
</script>

<%
	// 스마트웍스 서비스들을 사용하기위한 핸들러를 가져온다. 현재사용자 정보도 가져온다..
	ISmartWorks smartWorks = (ISmartWorks) request.getAttribute("smartWorks");
	User cUser = SmartUtil.getCurrentUser();
%>
<!--  다국어 지원을 위해, 로케일 및 다국어 resource bundle 을 설정 한다. -->
<fmt:setLocale value="<%=cUser.getLocale() %>" scope="request" />
<fmt:setBundle basename="resource.smartworksMessage" scope="request" />

<div class="up_wrap js_new_picture_page">
	<div class="up_point posit_file"></div>
	<div class="up up_padding">
		<form name="frmNewPicture" class="form_wrap js_validation_required">
			<!-- 새로운 사진을 업로드하고 설명 정보를 입력하기 위한 화면을 스마트폼을 이용하여 자동으로 그린다... -->
			<!-- js/sw/sw-formFields.js 에 있는 loadNewPictureFields() 함수를 호출하여 그린다. -->
			<div class="js_new_picture_fields" pictureDescTitle="<fmt:message key='common.upload.picture.desc'/>"></div>

			<!-- 업로드 실행시 파일상세정보를 임시로 생성하여 서버로 보내기 위한 곳  -->
			<div id="form_import"></div>
		</form>
		
		<!-- 등록 취소 버튼 -->
		<jsp:include page="/jsp/content/upload/upload_buttons.jsp"></jsp:include>
		<!-- 등록 취소 버튼 //-->
	</div>
</div>