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
	function submitForms() {
		if ($('form.js_validation_required').validate().form()) {
			var params = $('form').serialize();
			var url = "create_new_memo.sw";
			$.ajax({
				url : url,
				type : 'POST',
				data : {
					params : params
				},
				success : function(data, status, jqXHR) {
					alert("success");
				},
				exception : function(e) {
					alert(e);
				}
			});
		} else {
			return;
		}
		return;
	}
	$('input.js_todaypicker').datepicker({
		defaultDate : new Date(),
		dateFormat : 'yy.mm.dd'
	});
</script>

<%
	ISmartWorks smartWorks = (ISmartWorks) request.getAttribute("smartWorks");
	User cUser = SmartUtil.getCurrentUser();
	LocalDate date = new LocalDate();
	String today = date.toLocalDateSimpleString();
	String curTime = date.toLocalTimeShortString();
%>
<fmt:setLocale value="<%=cUser.getLocale() %>" scope="request" />
<fmt:setBundle basename="resource.smartworksMessage" scope="request" />

<div class="up_wrap">
	<div class="up_point posit_event"></div>
	<div class="form_wrap up up_padding">
		<!-- 폼- 확장 -->
		<form name="frmNewEvent" class="form_title js_validation_required">
			<div class="input_1line_first">
				<input class="fieldline required" type="text" name="txtEventName"
					placeholder="<fmt:message key='common.upload.message.event'/>">
			</div>

			<div class="input_1line">
				<div class="float_left">
					<input class="fieldline space_data requried js_todaypicker"
						type="text" name="txtEventStartDate" value="<%=today%>">
				</div>

				<div class="float_left">
					<select name="selEventStartTime">
						<%{ boolean isNow=false, isPassed=false;
						DecimalFormat df = new DecimalFormat("00");
						int iCurHour = df.parse(curTime.substring(0,2)).intValue(); 
						for(int i=0; i<24; i++){
 							String hourString = df.format(i)+":00";
 							String thirtyMinuteString = df.format(i)+":30";
 							if(iCurHour<i && !isPassed) isNow = true;
 						%>
						<option <%if(isNow){ isNow=false; isPassed=true;%> selected <%} %>><%=hourString %></option>
						<option><%=thirtyMinuteString %></option>
						<%}} %>
					</select>
				</div>
				<div class="float_left txt_btn">
					<a href="" class="space_l10"
						onclick="$(this).hide().siblings().show().parent().next('div').toggle(); return false;"><fmt:message
							key="common.upload.button.add_eventend" /> </a> <a
						style="display: none" href="" class="space_l10"
						onclick="$(this).hide().siblings().show().parent().next('div').toggle(); return false;"><fmt:message
							key="common.upload.button.delete_eventend" /> </a>
				</div>
				<!-- 종료 날짜 추가 내용 -->
				<div class="float_left space_l10" style='display: none'>
					<div class="float_left">
						<input name="txtEventEndDate"
							class="fieldline space_data js_todaypicker" type="text"
							value="<%=today%>">
					</div>
					<div class="float_left">
						<select name="selEventEndTime">
						<%{ boolean isNow=false, isPassed=false;
						DecimalFormat df = new DecimalFormat("00");
						int iCurHour = df.parse(curTime.substring(0,2)).intValue(); 
						for(int i=0; i<24; i++){
 							String hourString = df.format(i)+":00";
 							String thirtyMinuteString = df.format(i)+":30";
 							if(iCurHour<i && !isPassed) isNow = true;
 						%>
						<option <%if(isNow){ isNow=false; isPassed=true;%> selected <%} %>><%=hourString %></option>
						<option><%=thirtyMinuteString %></option>
						<%}} %>
						</select>
					</div>
				</div>
				<!-- 종료 날짜 추가 내용 //-->

				<div class="float_left txt_btn">
					<input class="space_l10" name="chkEventAlarm" type="checkbox"
						value="" onclick="$(this).parent().next('div').toggle();" />
					<fmt:message key="common.upload.button.set_alarm" />
				</div>
				<!-- 알림 설정 내용 -->
				<div class="float_left" style="display: none;">
					<select name="selEventAlarmTime">
						<option><fmt:message key="event.alarm.on_time"/></option>
						<option><fmt:message key="event.alarm.before_minute"><fmt:param>10</fmt:param></fmt:message></option>
						<option><fmt:message key="event.alarm.before_minute"><fmt:param>15</fmt:param></fmt:message></option>
						<option selected><fmt:message key="event.alarm.before_minute"><fmt:param>30</fmt:param></fmt:message></option>
						<option><fmt:message key="event.alarm.before_hour"><fmt:param>1</fmt:param></fmt:message></option>
						<option><fmt:message key="event.alarm.before_hour"><fmt:param>2</fmt:param></fmt:message></option>
					</select>
				</div>
				<!-- 알림 설정 내용 //-->

				<div class="float_left txt_btn">
					<input class="space_l10" name="chkEventRepeat"
						onclick="$(this).parent().parent().next('div').toggle();"
						type="checkbox" value="" />
					<fmt:message key="common.upload.button.set_repeat" />
				</div>

			</div>

			<!-- 반복 이벤트 설정 -->
			<div id="form_pop" style='display: none'>
				<div class="input_1line">
					<div class="float_left">
						<select name="selEventRepeatTerm">
							<option>매일</option>
							<option>매주</option>
							<option>매주 월-금</option>
							<option>매월</option>
							<option>매년</option>
						</select>
					</div>
					<div class="float_left space_l10">
						<input id="" class="fieldline" style="width: 19px" type="text"
							value="1"> 주마다
					</div>
					<div class="pos_day">
						<input name="" type="checkbox"><label>월</label> <input
							name="" type="checkbox"><label>화</label> <input name=""
							type="checkbox"><label>수</label> <input name=""
							type="checkbox"><label>목</label> <input name=""
							type="checkbox"><label>금</label> <input name=""
							type="checkbox"><label>토</label> <input name=""
							type="checkbox"><label>일</label>
					</div>
				</div>

				<div class="input_1line">
					<span class=""> <select>
							<option>오전12:30</option>
							<option>오전01:00</option>
							<option>오전01:30</option>
							<option>오전02:00</option>
							<option>오전02:30</option>
					</select> </span> <span class="space_l5"> <select>
							<option>1일 뒤</option>
							<option>2일 뒤</option>
							<option>3일 뒤</option>
							<option>4일 뒤</option>
							<option>5일 뒤</option>
							<option>6일 뒤</option>
							<option>1주 뒤</option>
							<option>2주 뒤</option>
					</select> </span> - <span class="space_l5"> <select>
							<option>오전12:30</option>
							<option>오전01:00</option>
							<option>오전01:30</option>
							<option>오전02:00</option>
							<option>오전02:30</option>
					</select> </span> <span class="pos_day"> <input name="" type="checkbox"><label>종일</label>
					</span>

				</div>
			</div>
			<!-- 반복 이벤트 설정 //-->

			<div class="input_1line">
				<input class="fieldline" id="" type="text" title=""
					placeholder="<fmt:message key='common.upload.event.place'/>">
			</div>
			<div class="input_1line fieldline js_user_names">
				<div class="js_selected_users float_left"></div>
				<input class="js_auto_complete" href='user_name.sw' type="text"
					title=""
					placeholder="<fmt:message key='common.upload.event.related_users'/>">
				<!-- 				<div class='js_srch_x'></div>
 -->
			</div>
			<div class="js_user_list" style="display: none"></div>

			<div>
				<textarea class="up_textarea" cols="" rows="5">
					<fmt:message key='common.upload.event.content' />
				</textarea>
			</div>
		</form>
		<jsp:include page="/jsp/content/upload/upload_buttons.jsp"></jsp:include>
	</div>
</div>
