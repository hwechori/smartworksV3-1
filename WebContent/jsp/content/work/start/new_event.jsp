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
	function submitForms(e) {
		if ($('form.js_validation_required').validate().form()) {
			var newEvent = $(document.getElementsByName('frmNewEvent'));
			var selectedCom = newEvent
					.find('div.js_selected_communities span.js_community_item');
			var selectedIds = "";
			for ( var i = 0; i < selectedCom.length; i++)
				selectedIds = selectedIds + $(selectedCom[i]).attr('comId')
						+ ";";
			$(document.getElementsByName('hdnRelatedUsers')).attr('value',
					selectedIds);
			var params = $('form').serialize();
			var url = "create_new_event.sw";
			$.ajax({
				url : url,
				type : 'POST',
				data : params,
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
	$('input.js_today_datepicker').datepicker({
		defaultDate : new Date(),
		dateFormat : 'yy.mm.dd'
	});
	$('input.js_current_timepicker').timepicker({
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
					<input class="fieldline space_data date js_today_datepicker" type="text"
						name="txtEventStartDate" readonly="readonly" value="<%=today%>">
				</div>

				<div class="float_left js_start_time">
					<select name="selEventStartTime">
						<%
							{
								boolean isNow = false, isPassed = false;
								DecimalFormat df = new DecimalFormat("00");
								int iCurHour = df.parse(curTime.substring(0, 2)).intValue();
								for (int i = 0; i < 24; i++) {
									String hourString = df.format(i) + ":00";
									String thirtyMinuteString = df.format(i) + ":30";
									if (iCurHour < i && !isPassed)
										isNow = true;
						%>
						<option
							<%if (isNow) {
						isNow = false;
						isPassed = true;%>
							selected <%}%> value="<%=hourString%>"><%=hourString%></option>
						<option><%=thirtyMinuteString%></option>
						<%
							}
							}
						%>
					</select>
				</div>
				<!-- 종료 날짜 추가 내용 -->
				<div class="float_left space_l10 js_end_datetime"
					style='display: none'>
					<div class="float_left">
						- <input name="txtEventEndDate"
							class="fieldline space_data date js_today_datepicker" type="text"
							value="<%=today%>">
					</div>
					<div class="float_left js_end_time">
						<input name="txtEventEndTime"
							class="fieldline space_data js_current_timepicker" type="text" value="<%=curTime%>">
<%-- 						<select name="selEventEndTime">
							<%
								{
									boolean isNow = false, isPassed = false;
									DecimalFormat df = new DecimalFormat("00");
									int iCurHour = df.parse(curTime.substring(0, 2)).intValue();
									for (int i = 0; i < 24; i++) {
										String hourString = df.format(i) + ":00";
										String thirtyMinuteString = df.format(i) + ":30";
										if (iCurHour < i && !isPassed)
											isNow = true;
							%>
							<option
								<%if (isNow) {
						isNow = false;
						isPassed = true;%>
								selected <%}%> value="<%=hourString%>"><%=hourString%></option>
							<option><%=thirtyMinuteString%></option>
							<%
								}
								}
							%>
						</select>
 --%>					</div>
				</div>
				<!-- 종료 날짜 추가 내용 //-->
				<div class="float_left txt_btn">
					<a href="" class="space_l10"
						onclick="$(this).hide().siblings().show().parent().siblings('div.js_end_datetime').toggle();return false;"><fmt:message
							key="common.upload.button.add_eventend" /> </a> <a
						style="display: none" href="" class="space_l10"
						onclick="$(this).hide().siblings().show().parent().siblings('div.js_end_datetime').toggle();return false;"><fmt:message
							key="common.upload.button.delete_eventend" /> </a>
				</div>

				<span class="input_check">
					<input name="chkEventWholeDay" class="js_whole_day" type="checkbox"><label><fmt:message
							key="common.upload.event.whole_day" /></label>
				</span>

				<span class="input_check">
					<input name="chkEventAlarm" type="checkbox"
						value=""
						onclick="$(this).parent().next('div').toggle();return true;" />
					<label><fmt:message key="common.upload.button.set_alarm" /></label>
				</span>
				<!-- 알림 설정 내용 -->
				<div class="float_left space_l5" style="display: none;">
					<select name="selEventAlarmTime">
						<option>
							<fmt:message key="event.alarm.on_time" />
						</option>
						<option>
							<fmt:message key="event.alarm.before_minute">
								<fmt:param>10</fmt:param>
							</fmt:message>
						</option>
						<option>
							<fmt:message key="event.alarm.before_minute">
								<fmt:param>15</fmt:param>
							</fmt:message>
						</option>
						<option selected>
							<fmt:message key="event.alarm.before_minute">
								<fmt:param>30</fmt:param>
							</fmt:message>
						</option>
						<option>
							<fmt:message key="event.alarm.before_hour">
								<fmt:param>1</fmt:param>
							</fmt:message>
						</option>
						<option>
							<fmt:message key="event.alarm.before_hour">
								<fmt:param>2</fmt:param>
							</fmt:message>
						</option>
						<option>
							<fmt:message key="event.alarm.before_hour">
								<fmt:param>4</fmt:param>
							</fmt:message>
						</option>
						<option>
							<fmt:message key="event.alarm.before_hour">
								<fmt:param>24</fmt:param>
							</fmt:message>
						</option>
					</select>
				</div>
				<!-- 알림 설정 내용 //-->
			</div>

			<div class="input_1line">
				<input class="fieldline" name="txtEventPlace" type="text" title=""
					placeholder="<fmt:message key='common.upload.event.place'/>">
			</div>
			<input type="hidden" name="hdnRelatedUsers" />
			<div class="input_1line fieldline js_community_names">
				<div class="js_selected_communities user_sel_area"></div>
				<input class="js_auto_complete" href='community_name.sw' type="text"
					title=""
					placeholder="<fmt:message key='common.upload.event.related_users'/>">
				<div class='js_srch_x'></div>

			</div>
			<div class="js_community_list" style="display: none"></div>

			<div>
				<textarea class="up_textarea" name="txtaEventContent" cols=""
					rows="5">
					<fmt:message key='common.upload.event.content' />
				</textarea>
			</div>
		</form>
		<jsp:include page="/jsp/content/upload/upload_buttons.jsp"></jsp:include>
	</div>
</div>
