<%@page import="java.text.DecimalFormat"%>
<%@page import="net.smartworks.util.LocalDate"%>
<%@page import="net.smartworks.util.SmartUtil"%>
<%@page import="net.smartworks.model.community.User"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="net.smartworks.service.ISmartWorks"%>

<script>
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

<!-- 업무계획하기 -->
<div class="form_add_a">
	<div class="dash_line"></div>
	<form name='frmScheduleWork' class="input_1line js_validation_required">
		<div class="float_left padding_r10">
			<input name="chkScheduleWork" type="checkbox"
				onclick="$(this).parent().next('div').toggle();" />
			<fmt:message key="common.upload.button.schedule" />
		</div>

		<div style='display: none'>
			<div class="float_left">
				<input class="fieldline space_data date js_todaypicker"
					type="text" name="txtScheduleStartDate" readonly="readonly" value="<%=today%>">
			</div>

			<div class="float_left js_start_time">
				<select name="selScheduleStartTime">
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
			<div class="float_left tx_space">-</div>
			<div class="float_left">
				<input class="fieldline space_data date js_todaypicker"
					type="text" name="txtScheduleEndDate" readonly="readonly" value="<%=today%>">
			</div>

			<div class="float_left js_start_time">
				<select name="selScheduleEndTime">
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


			<div class="float_left">
				<div class="float_left title">
					<fmt:message key="common.uplaod.field.schedule_performer" />
				</div>
				<div class="float_left">
					<input name="hdnSchedulePerformer" type="hidden">
					<input name="txtSchedulePerformer"
						class="fieldline space_data " type="text"
						value="<%=cUser.getLongName()%>" uid="<%=cUser.getId() %>" readonly="readonly">
				</div>
				<img src="images/btn_s_person.png" width="21" height="20" />
			</div>
		</div>

	</form>
</div>
<!-- 업무계획하기 //-->
