<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="net.smartworks.service.ISmartWorks"%>

<table id="glo_btn_space">
	<colgroup>
		<col class="field_btn">
		<col class="item_btn">
		<col class="item_btn">
		<col class="field_btn">
	</colgroup>
	<tbody>
		<tr>
			<td></td>
			<td><span class="btn_wh"> <a href=""> <span
						class="Btn01Start"></span> <span class="Btn01Center">등록</span> <span
						class="Btn01End"></span> </a> </span>
			</td>
			<td><span class="btn_wh"> <a href=""> <span
						class="Btn01Start"></span> <span class="Btn01Center">취소</span> <span
						class="Btn01End"></span> </a> </span>
			</td>
			<td>
				<form name="form" id="" class="float_right">
					<select name="jumpMenu" id="jumpMenu"
						onchange="MM_jumpMenu('parent',this,0)">
						<option>스마트웍스닷넷 3.0 TFT</option>
						<option>하이닉스-위험관리지수 TFT</option>
						<option>하이닉스-특허관리 TFT</option>
					</select>
				</form>

				<form name="form" id="" class="float_right form_space">
					<select name="jumpMenu" id="jumpMenu"
						onchange="MM_jumpMenu('parent',this,0)">
						<option>나의 공간</option>
						<option>나의 부서</option>
						<option>나의 그룹</option>
					</select>
				</form>

				<form name="form" id="" class="float_right form_space">
					<select name="jumpMenu" id="jumpMenu"
						onchange="MM_jumpMenu('parent',this,0)">
						<option>전체공개</option>
						<option>비공개</option>
					</select>
				</form>
			</td>
		</tr>
	</tbody>
</table>
