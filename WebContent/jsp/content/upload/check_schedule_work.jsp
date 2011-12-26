<%@page import="java.text.DecimalFormat"%>
<%@page import="net.smartworks.util.LocalDate"%>
<%@page import="net.smartworks.util.SmartUtil"%>
<%@page import="net.smartworks.model.community.User"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="net.smartworks.service.ISmartWorks"%>
<script type="text/javascript">
$.datepicker.setDefaults($.datepicker.regional[currentUser.locale]);
$.timepicker.setDefaults($.timepicker.regional[currentUser.locale]);
$('input.js_todaytimepicker').datetimepicker({
	defaultDate : new Date(),
	dateFormat : 'yy.mm.dd',
	timeFormat : 'hh:mm',
	hourGrid: 4,
	minuteGrid: 10,
	onSelect: function(date) {
		if(!isEmpty($('form.js_validation_required').find('.error'))){
			$('form.js_validation_required').validate({ showErrors: showErrors}).form();
		}
    }
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
	<form name='frmScheduleWork' class="input_1line">
		<div class="float_left padding_r10">
			<input name="chkScheduleWork" type="checkbox" onclick="$(this).parent().next('span').toggle();loadCheckScheduleFields();"/><fmt:message key="common.upload.button.schedule" /></div>
		<span class="float_left" style='display: none'>
			<div class="js_check_schedule_fields" startDateName="<fmt:message key='common.upload.field.schedule_start_date'/>" endDateName="<fmt:message key='common.upload.field.schedule_end_date'/>" performerName="<fmt:message key="common.uplaod.field.schedule_performer" />"></div>
		</span>
	</form>
</div>
<!-- 업무계획하기 //-->
