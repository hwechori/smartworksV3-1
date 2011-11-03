<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="net.smartworks.service.ISmartWorks"%>

<div id="form_default">
	<input onclick="$(this).next('div').toggle();" name="" type="checkbox" value="" />
	<fmt:message key="common.upload.button.schedule"/>
	<div style="display:none">
		<table>
			<colgroup>
				<col class="item">
				<col class="field">
				<col class="item">
				<col class="field">
			</colgroup>

			<tbody>
				<tr>
					<th>계획 시간</th>
					<td>
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
						<div class="float_left">~</div>
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
					</td>
					<th>수행자</th>
					<td>
						<div class="fieldline space_date float_left">
							<input id="" type="text" value="" title="">
						</div> <img src="images/btn_s_person.png" width="21" height="20" /></td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
