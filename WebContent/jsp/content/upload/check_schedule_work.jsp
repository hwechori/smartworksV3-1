<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="net.smartworks.service.ISmartWorks"%>

<!-- 업무계획하기 -->
<div class="form_add_a">
	<div class="dash_line"></div>
	<div class="input_1line">
		<div class="float_left padding_r10">
			<input name="chkScheduleWork" type="checkbox" value="" onclick="$(this).parent().next('form').toggle();"/><fmt:message key="common.upload.button.schedule" />
		</div>

		<form name='frmScheduleWork' style='display:none'>
			<div class="float_left" style="">
				<input class="fieldline space_data" type="text" value="2010.11.10" title="">
			</div>
			<div class="float_left">
				<select>
					<option>09:00</option>
					<option>10:00</option>
					<option>11:00</option>
					<option>12:00</option>
				</select>
			</div>
			<div class="float_left tx_space">~</div>
			<div class="float_left">
				<input class="fieldline space_data" type="text" value="2010.11.10" title="">
			</div>
			<div class="float_left">
				<select>
					<option>09:00</option>
					<option>10:00</option>
					<option>11:00</option>
					<option>12:00</option>
				</select>
			</div>


			<div class="float_left">
				<div class="float_left title">수행자</div>
				<div class="float_left">
					<input class="fieldline space_data" type="text" value="" title="">
				</div>
				<img src="images/btn_s_person.png" width="21" height="20" />
			</div>
		</form>

	</div>
</div>
<!-- 업무계획하기 //-->
