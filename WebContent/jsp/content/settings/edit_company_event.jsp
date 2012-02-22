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
	
	String eventId = request.getParameter("eventId");
	CompanyEvent event = new CompanyEvent();
	event.setPlannedStart(new LocalDate());
	event.setPlannedEnd(new LocalDate());
	if(!SmartUtil.isBlankObject(eventId)){
		event =  smartWorks.getCompanyEventById(eventId);
	}

%>
<script type="text/javascript">

	// 근무시간정책을 수정하기 버튼을 클릭하면, 
	// 모든정보를 JSON형식으로 Serialize해서 서버의 set_work_hour_policy.sw 서비스를 호출하여 수정한다.
	function submitForms(e) {
		var editCompanyEvent = $('.js_edit_company_event_page');
		if (SmartWorks.GridLayout.validate(editCompanyEvent.find('form.js_validation_required'), editCompanyEvent.find('.js_profile_error_message'))) {
			var forms = editCompanyEvent.find('form');
			var paramsJson = {};
			paramsJson['eventId'] = editCompanyEvent.attr('eventId');
			for(var i=0; i<forms.length; i++){
				var form = $(forms[i]);
				if(form.attr('name') === 'frmSmartForm'){
					paramsJson['formId'] = form.attr('formId');
					paramsJson['formName'] = form.attr('formName');
				}
				paramsJson[form.attr('name')] = mergeObjects(form.serializeObject(), SmartWorks.GridLayout.serializeObject(form));
 			}
			console.log(JSON.stringify(paramsJson));
			
			var url = "set_company_event.sw";
			var eventId = editCompanyEvent.attr('eventId'); 
			var confirmMessage = smartMessage.get("saveConfirmation");
			if(isEmpty(eventId)){
				url = "create_company_event.sw";
				confirmMessage = smartMessage.get("createConfirmation")
			}
			smartPop.confirm( confirmMessage, function(){
				var progressSpan = editCompanyEvent.find('.js_progress_span');
				smartPop.progressCont(progressSpan);
				$.ajax({
					url : url,
					contentType : 'application/json',
					type : 'POST',
					data : JSON.stringify(paramsJson),
					success : function(data, status, jqXHR) {
						// 사용자정보 수정이 정상적으로 완료되었으면, 현재 페이지에 그대로 있는다.
						smartPop.closeProgress();
						smartPop.showInfo(smartPop.INFORM, isEmpty(eventId) ? smartMessage.get('createCompanyEventSucceed') : smartMessage.get('setCompanyEventSucceed'), function(){
							document.location.href = "company_event.sw";					
						});
					},
					error : function(e) {
						smartPop.closeProgress();
						smartPop.showInfo(smartPop.ERROR, isEmpty(eventId) ? smartMessage.get('createCompanyEventError') : smartMessage.get('setCompanyEventError'));
					}
				});
			});
		}
	};
	
	function closePage() {
		$('.js_edit_company_event_page').parent().slideUp(500).html('');
	};	
</script>
<fmt:setLocale value="<%=cUser.getLocale() %>" scope="request" />
<fmt:setBundle basename="resource.smartworksMessage" scope="request" />

<div class="form_wrap up up_padding margin_b2 clear js_edit_company_event_page" eventId="<%=CommonUtil.toNotNull(eventId)%>">
	<div class="form_title">
		<%
		if(SmartUtil.isBlankObject(eventId)){
		%>
			<div class="ico_iworks title_noico"><fmt:message key="settings.title.company.new_event"/></div>
		<%
		}else{
		%>
			<div class="ico_iworks title_noico"><fmt:message key="settings.title.company.edit_event"/></div>
		<%
		}
		%>
		<div class="solid_line clear"></div>
	</div>

	<form name="frmEditCompanyEvent" class="form_layout con margin_b10 js_validation_required">
		<table>
			<tbody>
				<tr>
					<th width="15%"><fmt:message key="settings.title.company_event.name"/><span class="essen_n"></span></th>
					<td width="35%"><input name="txtEventName" class="fieldline required" type="text" value="<%=CommonUtil.toNotNull(event.getName()) %>" /></td>
					<th width="15%"><fmt:message key="settings.title.company_event.is_holiday"/></th>
					<td width="35%"><input name="chkIsHoliday" type="checkbox" <%if(event.isHoliday()){ %>checked<%} %>></td>
				</tr>
				<tr>
					<th><fmt:message key="settings.title.company_event.start_date"/><span class="essen_n"></span></th>
					<td>
						<div class="ico_fb_space form_date_input">
							<input name="datStartDate" class="fieldline js_todaypicker required" readonly="readonly" type="text" value="<%=event.getPlannedStart().toLocalDateSimpleString()%>">
							<a href="" class="js_todaypicker_button"><span class="ico_fb_date"></span></a>
						</div>
					</td>					
					<th><fmt:message key="settings.title.company_event.end_date"/><span class="essen_n"></span></th>
					<td>
						<div class="ico_fb_space form_date_input">
							<input name="datEndDate" class="fieldline js_todaypicker required" readonly="readonly" type="text" value="<%=event.getPlannedEnd().toLocalDateSimpleString()%>">
							<a href="" class="js_todaypicker_button"><span class="ico_fb_date"></span></a>
						</div>					
					</td>
				</tr>
				<tr>
					<th><fmt:message key="settings.title.company_event.related_users"/></th>
					<td colspan="3">
						<div class="js_type_userField" fieldId="usrRelatedUsers" multiUsers="true">
							<div class="ico_fb_space form_value" >
								<div class="fieldline js_community_names">
									<div class="js_selected_communities user_sel_area">
										<%
										if(!SmartUtil.isBlankObject(event.getRelatedUsers())){
											for(Community community : event.getRelatedUsers()){
												String comName = "";
												if(community.getClass().equals(User.class)){
													comName = ((User)community).getLongName();
												}else{
													comName = community.getName();
												}
										%>
												<span>
													<span class='js_community_item user_select' comId="<%=community.getId()%>"><%=comName %><span class='btn_x_gr'>
														<a class='js_remove_community' href=''> x</a>
													</span></span>
												</span>
										<%
											}
										}
										%>
									</div>
									<input class="js_auto_complete" href="community_name.sw" type="text">
									<div class="js_srch_x"></div>
								</div>
								<div class="js_community_list srch_list_nowid" style="display: none"></div>
								<span class="js_community_popup"></span>
								<a href="" class="js_userpicker_button"><span class="ico_fb_users"></span></a>
							</div>
						</div>
					</td>
				</tr>
			</tbody>
		</table>
	</form>

	<!-- 버튼영역 -->
	<div class="glo_btn_space">
		<!-- 실행시 데이터 유효성 검사이상시 에러메시지를 표시할 공간 -->
		<span class="form_space sw_error_message js_profile_error_message" style="text-align:right; color: red"></span>
		<!--  실행시 표시되는 프로그래스아이콘을 표시할 공간 -->
		<span class="js_progress_span"></span>
		<div class="float_right">
			<span class="btn_gray"> 
				<a href="" onclick='submitForms(); return false;'>
					<span class="Btn01Start"></span>
					<%
					if(SmartUtil.isBlankObject(eventId)){
					%>
						<span class="Btn01Center"><fmt:message key="common.button.add_new"/></span> 
					<%
					}else{
					%>
						<span class="Btn01Center"><fmt:message key="common.button.modify"/></span>
					<%
					}
					%>
					<span class="Btn01End"></span>
				</a>
			</span> 
			<span class="btn_gray"> 
				<a href="" onclick='closePage();return false;'>
					<span class="Btn01Start"></span>
					<span class="Btn01Center"><fmt:message key="common.button.cancel"/></span> 
					<span class="Btn01End"></span>
				</a>
			</span>
		</div>
	</div>
	<!-- 버튼영역 //-->

</div>
<!-- 추가하기 테이블 //-->

<script type="text/javascript">
	smartCommon.liveTodayPicker();
</script>
