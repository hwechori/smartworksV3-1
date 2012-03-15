
<!-- Name 			: new_event.jsp									 -->
<!-- Description	: 스마트폼을 이용하여 새 이벤트를 등록하는 화면 	      	 -->
<!-- Author			: Maninsoft, Inc.								 -->
<!-- Created Date	: 2011.9.										 -->

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

//완료버튼 클릭시 create_new_event.sw 서비스를 실행하기 위해 submit하는 스크립트..
function submitForms() {
	var newEvent = $('.js_new_event_page');

	// new_event 에 있는 활성화되어 있는 모든 입력화면들을 validation하여 이상이 없으면 submit를 진행한다...
	if(!SmartWorks.GridLayout.validate(newEvent.find('form.js_validation_required'), $('.js_upload_error_message'))) return

	var form = newEvent.find('form[name="frmNewEvent"]');
	var name = form.find('input[name="txtEventName"]').attr("value");
	var startDate = form.find('input[name="txtEventStartDate"]').attr("value");
	var endDate = form.find('input[name="txtEventEndDate"]').attr("value");
	var alarmPolicy = form.find('select[name="selEventAlarmPolicy"]').attr("value");
	var place = form.find('input[name="txtEventPlace"]').attr("value");
	var relatedUserField = form.find('.js_type_userField .js_community_item');
	var relatedUsers = new Array();
	for(var i=0; i<relatedUserField.length; i++){
		relatedUsers.push({
			userId : $(relatedUserField[i]).attr('comId'),
			longName : relatedUserField[i].childNodes[0].nodeValue
		});
	}
	var content = form.find('textarea[name="txtEventContent"]').attr("value");
	var formContent = newEvent.find('.js_hidden_form_content');
	
	if(!isEmpty(formContent)) {

		var workId = newEvent.attr('workId');
		$.ajax({
			url : "get_form_xml.sw",
			data : {
				workId : workId
			},
			success : function(formXml, status, jqXHR) {

				// 화면 xml을 가져오면 가져온 값과 입력된 설명값들을 가지고 스마트폼을 이용해 화면을 그린다...
				var formXml = $(formXml);
				new SmartWorks.GridLayout({
					target : formContent,
					formXml : formXml,
					formValues : createEventDataFields({
						formXml : formXml,
						name : name,
						startDate : startDate,
						endDate : endDate,
						alarmPolicy : alarmPolicy,
						place : place,
						relatedUsers : relatedUsers,
						content : content
					}),
					mode : "edit"
				});
				// 그려진 화면에 있는 입력화면들을 JSON형식으로 Serialize한다...
				var forms = newEvent.find('form');
				var paramsJson = {};
				for(var i=0; i<forms.length; i++){
					var form = $(forms[i]);
					// 폼이 스마트폼이면 formId와 formName 값을 전달한다...
					if(form.attr('name') === 'frmSmartForm'){
						paramsJson['formId'] = form.attr('formId');
						paramsJson['formName'] = form.attr('formName');
					}else if(form.attr('name') === 'frmNewEvent'){
						continue;
					}
					// 폼이름 키값으로 하여 해당 폼에 있는 모든 입력항목들을 JSON형식으로 Serialize 한다...
					paramsJson[form.attr('name')] = mergeObjects(form.serializeObject(), SmartWorks.GridLayout.serializeObject(form));
				}
				console.log(JSON.stringify(paramsJson));
				// 서비스요청 프로그래스바를 나타나게 한다....
				var progressSpan = newEvent.find('.js_progress_span');
				smartPop.progressCont(progressSpan);
				var url = "create_new_event.sw";
				// create_new_event.sw서비스를 요청한다..
				$.ajax({
					url : url,
					contentType : 'application/json',
					type : 'POST',
					data : JSON.stringify(paramsJson),
					success : function(data, status, jqXHR) {
						// 성공시에 프로그래스바를 제거하고 성공메시지를 보여준다...
						smartPop.closeProgress();
						smartPop.showInfo(smartPop.INFO, smartMessage.get("createEventSucceed"), function(){
							document.location.href = data.href;
						});
					},
					error : function(e) {
						// 서비스 에러시에는 메시지를 보여주고 현재페이지에 그래도 있는다...
						smartPop.closeProgress();
						smartPop.showInfo(smartPop.ERROR, smartMessage.get("createEventError"));
					}
				});
			}
		});
	}
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

<div class="up_wrap js_new_event_page" workId="<%=SmartWork.ID_EVENT_MANAGEMENT%>">
	<div class="up_point pos_works js_up_pointer"></div>
	<div class="form_wrap up up_padding">
		<!-- 폼- 확장 -->
		<form name="frmNewEvent" class="js_validation_required js_click_start_form">
			<!-- 새로운 이벤트를 등록하기 위한 입력화면을 스마트폼을 이용하여 자동으로 그린다.. -->
			<!-- js_new_event_fields :  js/sw/sw-formFields.js 에서 loadNewEventFields()가 찾아서 이벤트입력화면을 이곳에 그려준다.. -->
			<div class="js_new_event_fields" eventNameTitle="<fmt:message key='common.upload.event.name'/>" placeHolderTitle="<fmt:message key='common.upload.message.event'/>"
				startDateTitle="<fmt:message key='common.upload.event.start_date'/>" endDateTitle="<fmt:message key='common.upload.event.end_date'/>"  alarmPolicyTitle="<fmt:message key='common.upload.button.set_alarm'/>"
				placeTitle="<fmt:message key='common.upload.event.place'/>" relatedUsersTitle="<fmt:message key='common.upload.event.related_users'/>" 
				contentTitle="<fmt:message key='common.upload.event.content' />">
			</div>
		</form>
		<div class="js_hidden_form_content" style="display:none">
		</div>
		<!-- 새이벤트를 등록하기위한 완료 버튼과 취소 버튼 -->
		<div class="js_upload_buttons"></div>
	</div>
</div>
<script>
	loadNewEventFields();
</script>