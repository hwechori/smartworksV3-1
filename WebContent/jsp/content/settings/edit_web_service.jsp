<%@page import="net.smartworks.model.service.Variable"%>
<%@page import="net.smartworks.model.service.WebService"%>
<%@page import="net.smartworks.model.approval.Approval"%>
<%@page import="net.smartworks.model.approval.ApprovalLine"%>
<%@page import="net.smartworks.model.community.Community"%>
<%@page import="net.smartworks.model.calendar.CompanyEvent"%>
<%@page import="net.smartworks.model.calendar.CompanyCalendar"%>
<%@page import="net.smartworks.server.engine.common.util.CommonUtil"%>
<%@page import="net.smartworks.model.calendar.WorkHour"%>
<%@page import="net.smartworks.util.LocalDate"%>
<%@page import="net.smartworks.model.calendar.WorkHourPolicy"%>
<%@page import="net.smartworks.model.community.User"%>
<%@page import="net.smartworks.util.SmartUtil"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="net.smartworks.service.ISmartWorks"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	// 스마트웍스 서비스들을 사용하기위한 핸들러를 가져온다. 현재사용자 정보도 가져온다..
	ISmartWorks smartWorks = (ISmartWorks) request.getAttribute("smartWorks");
	User cUser = SmartUtil.getCurrentUser();

	String serviceId = request.getParameter("serviceId");
	WebService webService = new WebService();
	if(!SmartUtil.isBlankObject(serviceId)){
		webService =  smartWorks.getWebServiceById(serviceId);		
		session.setAttribute("webService", webService);
	}
%>
<script type="text/javascript">

	// 근무시간정책을 수정하기 버튼을 클릭하면, 
	// 모든정보를 JSON형식으로 Serialize해서 서버의 set_work_hour_policy.sw 서비스를 호출하여 수정한다.
	function submitForms(e) {
		var editWebService = $('.js_edit_web_service_page');
		if(!editWebService.find('input[name="txtWebServiceWSDL"]').hasClass('sw_fetched')){
			smartPop.showInfo(smartPop.ERROR, smartMessage.get('wsdlNotFetchedError'));
			return;
		}
		if (SmartWorks.GridLayout.validate(editWebService.find('form.js_validation_required'), editWebService.find('.js_profile_error_message'))) {
			var forms = editWebService.find('form');
			var paramsJson = {};
			paramsJson['serviceId'] = editWebService.attr('serviceId');
			for(var i=0; i<forms.length; i++){
				var form = $(forms[i]);
				if(form.attr('name') === 'frmSmartForm'){
					paramsJson['formId'] = form.attr('formId');
					paramsJson['formName'] = form.attr('formName');
				}
				paramsJson[form.attr('name')] = mergeObjects(form.serializeObject(), SmartWorks.GridLayout.serializeObject(form));
			}
			console.log(JSON.stringify(paramsJson));
			
			var url = "set_web_service.sw";
			var serviceId = editWebService.attr('serviceId'); 
			var confirmMessage = smartMessage.get("saveConfirmation");
			if(isEmpty(serviceId)){
				url = "create_web_service.sw";
				confirmMessage = smartMessage.get("createConfirmation")
			}
			smartPop.confirm( confirmMessage, function(){
				var progressSpan = editWebService.find('.js_progress_span');
				smartPop.progressCont(progressSpan);
				$.ajax({
					url : url,
					contentType : 'application/json',
					type : 'POST',
					data : JSON.stringify(paramsJson),
					success : function(data, status, jqXHR) {
						// 사용자정보 수정이 정상적으로 완료되었으면, 현재 페이지에 그대로 있는다.
						smartPop.closeProgress();
						smartPop.showInfo(smartPop.INFORM, isEmpty(serviceId) ? smartMessage.get('createWebServiceSucceed') : smartMessage.get('setWebServiceSucceed'), function(){
							document.location.href = "web_service.sw";					
						});
					},
					error : function(e) {
						smartPop.closeProgress();
						smartPop.showInfo(smartPop.ERROR, isEmpty(serviceId) ? smartMessage.get('createWebServiceError') : smartMessage.get('setWebServiceError'));
					}
				});
			});
		}
	};
	
	function closePage() {
		$('.js_edit_web_service_page').parent().slideUp(500).html('');
	};	
</script>
<fmt:setLocale value="<%=cUser.getLocale() %>" scope="request" />
<fmt:setBundle basename="resource.smartworksMessage" scope="request" />

<div class="form_wrap up up_padding mb2 cb js_edit_web_service_page" serviceId="<%=CommonUtil.toNotNull(serviceId)%>">
	<div class="form_title">
		<%
		if(SmartUtil.isBlankObject(serviceId)){
		%>
			<div class="icon_iworks title_noico"><fmt:message key="settings.title.webservice.new"/></div>
		<%
		}else{
		%>
			<div class="icon_iworks title_noico"><fmt:message key="settings.title.webservice.edit"/></div>
		<%
		}
		%>
		<div class="solid_line cb"></div>
	</div>

	<form name="frmEditWebService" class="form_layout con mb10 js_validation_required">
		<table>
			<tbody class="js_edit_webservice_tbody">
				<tr>
					<th class="required_label" width="20%"><fmt:message key="settings.title.webservice.name"/></th>
					<td colspan="3" width="80%" ><input name="txtWebServiceName" type="text" class="fieldline required" value="<%=CommonUtil.toNotNull(webService.getName())%>"/>
					</td>
				</tr>
				<tr>
					<th><fmt:message key="settings.title.webservice.desc"/></th>
					<td colspan="3"><textarea name="txtaWebServiceDesc" rows="3" class="fieldline"><%=CommonUtil.toNotNull(webService.getDesc()) %></textarea>
					</td>
				</tr>
				<tr>
					<th class="required_label"><fmt:message key="settings.title.webservice.wsdl_uri"/></th>
					<td>
						<div class="btn_fb_space js_webservice_wsdl">
							<input name="txtWebServiceWSDL" <%if(!SmartUtil.isBlankObject(webService.getWsdlUri())){ %>readonly<%} %> class="fieldline required" type="text" value="<%=CommonUtil.toNotNull(webService.getWsdlUri())%>">
							<div class="icon_btn_start po_rbtn">
								<a class="icon_btn_tail js_fetch_webservice_wsdl" <%if(!SmartUtil.isBlankObject(webService.getWsdlUri())){ %>style="display:none"<%} %> href=""><fmt:message key="settings.button.wsdl.fetch"/></a>
								<a class="icon_btn_tail js_change_webservice_wsdl" <%if(SmartUtil.isBlankObject(webService.getWsdlUri())){ %>style="display:none"<%} %> href=""><fmt:message key="settings.button.wsdl.change"/></a>
							</div>
						</div>
					</td>
				</tr>
				<jsp:include page="/jsp/content/settings/wsdl_detail.jsp"><jsp:param value="<%=CommonUtil.toNotNull(serviceId) %>" name="serviceId"/></jsp:include>
			</tbody>
		</table>
	</form>

	<!-- 버튼영역 -->
	<div class="glo_btn_space">
		<!-- 실행시 데이터 유효성 검사이상시 에러메시지를 표시할 공간 -->
		<span class="form_space sw_error_message js_profile_error_message" style="text-align:right; color: red"></span>
		<!--  실행시 표시되는 프로그래스아이콘을 표시할 공간 -->
		<span class="js_progress_span"></span>
		<div class="fr">
			<span class="btn_gray"> 
				<a href="" onclick='submitForms(); return false;'>
					<span class="txt_btn_start"></span>
					<%
					if(SmartUtil.isBlankObject(serviceId)){
					%>
						<span class="txt_btn_center"><fmt:message key="common.button.add_new"/></span> 
					<%
					}else{
					%>
						<span class="txt_btn_center"><fmt:message key="common.button.modify"/></span>
					<%
					}
					%>
					<span class="txt_btn_end"></span>
				</a>
			</span> 
			<span class="btn_gray"> 
				<a href="" onclick='closePage();return false;'>
					<span class="txt_btn_start"></span>
					<span class="txt_btn_center"><fmt:message key="common.button.cancel"/></span> 
					<span class="txt_btn_end"></span>
				</a>
			</span>
		</div>
	</div>
	<!-- 버튼영역 //-->

</div>
<!-- 추가하기 테이블 //-->