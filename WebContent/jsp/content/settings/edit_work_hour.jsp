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
	
	String policyId = request.getParameter("policyId");
	WorkHourPolicy workHourPolicy = new WorkHourPolicy();
	if(!SmartUtil.isBlankObject(policyId)){
		workHourPolicy =  smartWorks.getWorkHourPolicyById(policyId);
	}

	if(SmartUtil.isBlankObject(policyId)){
		workHourPolicy.setValidFrom(new LocalDate());
	}
%>
<script type="text/javascript">

	// 근무시간정책을 수정하기 버튼을 클릭하면, 
	// 모든정보를 JSON형식으로 Serialize해서 서버의 set_work_hour_policy.sw 서비스를 호출하여 수정한다.
	function submitForms(e) {
		var editWorkHour = $('.js_edit_work_hour_page');
		if (SmartWorks.GridLayout.validate(editWorkHour.find('form.js_validation_required'), editWorkHour.find('.js_profile_error_message'))) {
			var forms = editWorkHour.find('form');
			var paramsJson = {};
			paramsJson['policyId'] = editWorkHour.attr('policyId');
			for(var i=0; i<forms.length; i++){
				var form = $(forms[i]);
				if(form.attr('name') === 'frmSmartForm'){
					paramsJson['formId'] = form.attr('formId');
					paramsJson['formName'] = form.attr('formName');
				}
				paramsJson[form.attr('name')] = mergeObjects(form.serializeObject(), SmartWorks.GridLayout.serializeObject(form));
			}
			console.log(JSON.stringify(paramsJson));
			
			var url = "set_work_hour_policy.sw";
			var policyId = editWorkHour.attr('policyId'); 
			var confirmMessage = smartMessage.get("saveConfirmation");
			if(isEmpty(policyId)){
				url = "create_work_hour_policy.sw";
				confirmMessage = smartMessage.get("createConfirmation")
			}
			smartPop.confirm( confirmMessage, function(){
				var progressSpan = editWorkHour.find('.js_progress_span');
				smartPop.progressCont(progressSpan);
				$.ajax({
					url : url,
					contentType : 'application/json',
					type : 'POST',
					data : JSON.stringify(paramsJson),
					success : function(data, status, jqXHR) {
						// 사용자정보 수정이 정상적으로 완료되었으면, 현재 페이지에 그대로 있는다.
						smartPop.closeProgress();
						smartPop.showInfo(smartPop.INFORM, isEmpty(policyId) ? smartMessage.get('createWorkHourSucceed') : smartMessage.get('setWorkHourSucceed'), function(){
							document.location.href = "company_work_hour.sw";					
						});
					},
					error : function(e) {
						smartPop.closeProgress();
						smartPop.showInfo(smartPop.ERROR, isEmpty(policyId) ? smartMessage.get('createWorkHourError') : smartMessage.get('setWorkHourError'));
					}
				});
			});
		}
	};
	
	function closePage() {
		$('.js_edit_work_hour_page').parent().slideUp(500).html('');
	};	
</script>
<fmt:setLocale value="<%=cUser.getLocale() %>" scope="request" />
<fmt:setBundle basename="resource.smartworksMessage" scope="request" />

<div class="form_wrap up up_padding margin_b2 clear js_edit_work_hour_page" policyId="<%=CommonUtil.toNotNull(policyId)%>">
	<div class="form_title">
		<%
		if(SmartUtil.isBlankObject(policyId)){
		%>
			<div class="ico_iworks title_noico"><fmt:message key="settings.title.company.new_work_hour"/></div>
		<%
		}else{
		%>
			<div class="ico_iworks title_noico"><fmt:message key="settings.title.company.edit_work_hour"/></div>
		<%
		}
		%>
		<div class="solid_line clear"></div>
	</div>

	<form name="frmEditWorkHour" class="form_layout margin_b10 js_validation_required">
		<table>
			<colgroup>
				<col widtd="15%" />
				<col widtd="85%" />
			</colgroup>
			<tbody>
				<tr>
					<td><fmt:message key="settings.title.work_hour.valid_from"/></td>
					<td>
						<div class="ico_fb_space form_date_input">
							<%
							String validFrom = (workHourPolicy.getValidFrom().getTime()!=0) ? workHourPolicy.getValidFrom().toLocalDateSimpleString() : "";
							%>
							<input name="datValidFrom" class="fieldline js_todaypicker" readonly="readonly" type="text" value="<%=validFrom%>">
							<a href="" class="js_todaypicker_button"><span class="ico_fb_date"></span></a>
						</div>					
					</td>
				</tr>
				<tr>
					<td><fmt:message key="settings.title.work_hour.first_day_of_week"/></td>
					<td>
						<select name="selFirstDayOfWeek" class="js_first_day_of_week">
							<%
							for(int i=1; i<8; i++){
							%>
								<option <%if(i==workHourPolicy.getFirstDayOfWeek()) {%>selected<%} %> value="<%=i%>"><%=LocalDate.getDayLocalString(i) %></option>
							<%
							}
							%>
						</select>
					</td>
				</tr>
				<tr>
					<td><fmt:message key="settings.title.work_hour.working_days"/></td>
					<td>
						<select name="selWorkingDays" class="js_working_days">
							<option <%if(workHourPolicy.getWorkingDays() == 4){ %>selected<%} %> value="4">4 <fmt:message key="calendar.title.days"/></option>
							<option <%if(workHourPolicy.getWorkingDays() == 5){ %>selected<%} %> value="5">5 <fmt:message key="calendar.title.days"/></option>
							<option <%if(workHourPolicy.getWorkingDays() == 6){ %>selected<%} %> value="6">6 <fmt:message key="calendar.title.days"/></option>
							<option <%if(workHourPolicy.getWorkingDays() == 7){ %>selected<%} %> value="7">7 <fmt:message key="calendar.title.days"/></option>
						</select>
					</td>
				</tr>
				<%
				WorkHour[] workHours = workHourPolicy.getWorkHours();
				for(int i=1; i<8; i++){
					WorkHour workHour = workHours[i-1];
					if(workHour == null) workHour = new WorkHour();
				%>
					<tr class="js_work_hour" <%if(i<workHourPolicy.getFirstDayOfWeek() || i>=workHourPolicy.getFirstDayOfWeek()+workHourPolicy.getWorkingDays()){ %> style="display:none"<%} %>>
						<td class="end"><%=LocalDate.getDayLocalString(i) %></td>
						<td class="end">
							<span class="float_left mr5"><fmt:message key="settings.title.work_hour.start"/></span>
							<div class="ico_fb_space form_time_input float_left mr10">
								<input name="timWorkStart" class="fieldline js_timepicker workStart" readonly="readonly" type="text" value="<%=LocalDate.convertTimeToString(workHour.getStart()) %>">
								<a href="" class="js_timepicker_button"><span class="ico_fb_time"></span></a>
							</div>
							<span class="float_left mr5"><fmt:message key="settings.title.work_hour.end"/></span>
							<div class="ico_fb_space form_time_input float_left mr10">
								<input name="timWorkEnd" class="fieldline js_timepicker workEnd" readonly="readonly" type="text" name="" value="<%=LocalDate.convertTimeToString(workHour.getEnd()) %>">
								<a href="" class="js_timepicker_button"><span class="ico_fb_time"></span></a>
							</div>
						</td>
					</tr>
				<%
				}
				%>
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
					if(SmartUtil.isBlankObject(policyId)){
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
	smartCommon.liveTimePicker();
</script>
