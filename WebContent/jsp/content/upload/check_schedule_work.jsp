<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="net.smartworks.service.ISmartWorks"%>

<!-- 업무계획하기 -->
<div id="form_add_a">
	<div class="input_1line">
		<div class="checkbox float_left padding_r10">
			<input name="" type="checkbox" value="" onclick="$(this).parent().next('div').toggle();"/><fmt:message key="common.upload.button.schedule" />
		</div>

		<div style="display: none">
			<div class="fieldline space_date float_left" style="">
				<input id="" type="text" value="2010.11.10" title="">
			</div>
			<div class="float_left">
				<select name="jumpMenu" id="jumpMenu"
					onchange="MM_jumpMenu('parent',this,0)" style="width: 100%;">
					<option>09:00</option>
					<option>10:00</option>
					<option>11:00</option>
					<option>12:00</option>
				</select>
			</div>
			<div class="float_left tx_space">~</div>
			<div class="fieldline space_date float_left">
				<input id="" type="text" value="2010.11.10" title="">
			</div>
			<div class="float_left">
				<select name="jumpMenu" id="jumpMenu"
					onchange="MM_jumpMenu('parent',this,0)" style="width: 100%;">
					<option>09:00</option>
					<option>10:00</option>
					<option>11:00</option>
					<option>12:00</option>
				</select>
			</div>


			<div class="float_left">
				<div class="float_left title">수행자</div>
				<div class="fieldline space_date float_left">
					<input id="" type="text" value="" title="">
				</div>
				<img src="images/btn_s_person.png" width="21" height="20" />
			</div>
		</div>

	</div>
</div>
<!-- 업무계획하기 //-->
