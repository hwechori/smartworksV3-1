
<!-- Name 			: start_pwork.jsp											 -->
<!-- Description	: 스마트프로세스와 스마트폼을 이용하여 새 프로세스업무를 시작하는 화면 	 -->
<!-- Author			: Maninsoft, Inc.											 -->
<!-- Created Date	: 2011.9.													 -->

<%@page import="net.smartworks.model.work.ProcessWork"%>
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

//완료버튼 클릭시 start_new_pwork.sw 서비스를 실행하기 위해 submit하는 스크립트..
function submitForms(e) {
	var startPwork = $('.js_start_pwork_page');
	var workId = startPwork.attr('workId');

	// 계획업무로 지정하기가 선택되어 있으면, 계획업무관련 입력필드들을 validation하기위한 클래스를 추가한다.. 
	var scheduleWork = startPwork.find('form[name="frmScheduleWork"]');
	if(scheduleWork.find($('input[name="chkScheduleWork"]')).is(':checked')){
		scheduleWork.addClass('js_validation_required');
	}else{
		scheduleWork.removeClass('js_validation_required');	
	}

	// start_pwork에 있는 활성화되어 있는 모든 입력화면들을 validation하여 이상이 없으면 submit를 진행한다...
	if (SmartWorks.GridLayout.validate(startPwork.find('form.js_validation_required'), $('.js_upload_error_message'))) {
		var forms = startPwork.find('form');
		var paramsJson = {};
		paramsJson['workId'] = workId;
		for(var i=0; i<forms.length; i++){
			var form = $(forms[i]);
			// 폼이 스마트폼이면 formId와 formName 값을 전달한다...
			if(form.attr('name') === 'frmSmartForm'){
				paramsJson['formId'] = form.attr('formId');
				paramsJson['formName'] = form.attr('formName');
			}
			// 폼이름 키값으로 하여 해당 폼에 있는 모든 입력항목들을 JSON형식으로 Serialize 한다...
			paramsJson[form.attr('name')] = mergeObjects(form.serializeObject(), SmartWorks.GridLayout.serializeObject(form));
		}
		console.log(JSON.stringify(paramsJson));
		var url = "start_new_pwork.sw";
		// 서비스요청 프로그래스바를 나타나게 한다....
		var progressSpan = startPwork.find('.js_progress_span');
		smartPop.progressCont(progressSpan);
		// start_new_pwork.sw서비스를 요청한다..
		$.ajax({
			url : url,
			contentType : 'application/json',
			type : 'POST',
			data : JSON.stringify(paramsJson),
			success : function(data, status, jqXHR) {
				// 성공시에 프로그래스바를 제거하고 성공메시지를 보여준다...
				smartPop.closeProgress();
				smartPop.confirm(smartMessage.get("startPWorkSucceed"), 
						function(){
							// 사용자가 해당페이지로 이동하기를 원하면 해당페이지로 이동한다...
							document.location.href = data.href;					
						},
						function(){
							// 사용자가 현재페이지에 있기를 원하면 그대로 있는다...
							document.location.href = document.location.href;
						});
			},
			error : function(e) {
				// 서비스 에러시에는 메시지를 보여주고 현재페이지에 그래도 있는다...
				smartPop.closeProgress();
				smartPop.showInfo(smartPop.ERROR, smartMessage.get("startPWorkError"));
			}
		});
	}
	return;
}

</script>
<%
	// 스마트웍스 서비스들을 사용하기위한 핸들러를 가져온다. 현재사용자 정보도 가져온다..
	ISmartWorks smartWorks = (ISmartWorks) request.getAttribute("smartWorks");
	User cUser = SmartUtil.getCurrentUser();

	// 호출시 전달된 workId값을 가져온다..
	String workId = request.getParameter("workId");
	
	// pwork_list에서 호출이 되었으면 세션어트리뷰트에 smartWork를 설정하기때문에,
	// 확인해서 workId가 같으면 그 object를 이용한다.
	// 그렇지 않으면, workId로 해당정보관리업무 상세정보를 가져온다.
	ProcessWork work = null;
	SmartWork smartWork = (SmartWork)session.getAttribute("smartWork");
	if(!SmartUtil.isBlankObject(smartWork) && smartWork.getId().equals(workId)){
		work = (ProcessWork)smartWork;
	}else{
		work = (ProcessWork)smartWorks.getWorkById(workId);
	}
	
%>
<!--  다국어 지원을 위해, 로케일 및 다국어 resource bundle 을 설정 한다. -->
<fmt:setLocale value="<%=cUser.getLocale() %>" scope="request" />
<fmt:setBundle basename="resource.smartworksMessage" scope="request" />

<div class="form_wrap up mb2 js_form_wrap js_start_pwork_page" workId="<%=workId%>">
	<div class="form_title js_form_header">
		<!-- 해당 업무이름을 표시하는 곳 -->
		<div class="icon_pworks title"><%=work.getFullpathName() %></div>

		<!-- 전자결재, 업무전달 버튼들 -->
		<div class="txt_btn">
			<div class="po_right image_posi">
				<a href="" class="js_toggle_approval_btn"><img src="images/btn_approvep.gif" title="<fmt:message key='common.button.approval'/>" /> </a>
			</div>
			<div class="po_right image_posi">
				<a href="" class="js_toggle_forward_btn"><img src="images/btn_referw.gif" title="<fmt:message key='common.button.forward'/>" /> </a>
			</div>
		</div>
		<div class="solid_line"></div>
	</div>

	<!-- 스마트폼 화면을 필수항목만 또는 모든항목을 표시하게하는 버튼 -->
	<div class="txt_btn txt_btn_height js_form_detail_buttons">
		<div class="po_right">
			<a href="" class="js_toggle_form_detail" requiredOnly="false" workId="<%=workId%>"><fmt:message key="common.upload.button.detail" /> </a>
		</div>
		<div class="po_right" style="display: none">
			<a href="" class="js_toggle_form_detail" requiredOnly="true" workId="<%=workId%>"><fmt:message key="common.upload.button.brief" /> </a>
		</div>
	</div>
	<!-- 스마트폼 화면을 필수항목만 또는 모든항목을 표시하게하는 버튼 //-->

	<!--  전자결재화면이 나타나는 곳 -->
	<div class="js_form_task_approval" style="display:none"></div>
	
	<!-- 업무전달화면이 나타나는 곳 -->
	<div class="js_form_task_forward" style="display:none"></div>

	<!-- 스마트폼에서 해당 업무화면을 그려주는 곳 -->
	<div class="js_form_content js_click_start_form" workType="pwork"></div>
	
	<!-- 업무를 시작할 때 계획업무로 지정하는 화면 -->
	<jsp:include page="/jsp/content/upload/check_schedule_work.jsp"></jsp:include>
	
	<!-- 새업무를 시작하기위한 완료 버튼과 취소 버튼 -->
	<div class="js_upload_buttons"></div>
</div>
