<%@ page contentType="text/html; charset=utf-8"%>

<!-- 폼- 업무 입력 후 -->
<table>
	<colgroup>
		<col class="item">
		<col class="field">
		<col class="item">
		<col class="field">
	</colgroup>
	<tbody>
		<tr>
			<td>제 목<span class="essen_n"></span></td>
			<td colspan="3">
					<input class="fieldline" id="" type="text" title="" value="">
			</td>
		</tr>
		<tr>
			<td>과제명<span class="essen_n"></span></td>
			<td>
				<input class="fieldline" id="" type="text" title="" value="">
				<img src="images/btn_s_search.jpg" />
			</td>
			<td>진행단계<span class="essen_n"></span></td>
			<td>
				<form name="form" id="form">
					<select name="jumpMenu" id="jumpMenu"
						onchange="MM_jumpMenu('parent',this,0)" style="width: 100%;">
						<option>계획</option>
						<option>item2</option>
						<option>item3</option>
						<option>item4</option>
					</select>
				</form>
			</td>
		</tr>
		<tr>
			<td>작성자<span class="essen_n"></span></td>
			<td>
				<input class="fieldline" id="" type="text" title="" value="">
				<img src="images/btn_s_person.png" />
			</td>
			<td>작성일자<span class="essen_n"></span></td>
			<td>
				<input class="fieldline" id="" type="text" title="" value="">
				<img src="images/btn_s_calendar.png" />
			</td>
		</tr>
		<tr>
			<td>시작시간<span class="essen_n"></span></td>
			<td>
					<form name="form" id="form">
						<select name="jumpMenu" id="jumpMenu" class="essen"
							onchange="MM_jumpMenu('parent',this,0)" style="width: 100%;">
							<option>09:00</option>
							<option>10:00</option>
							<option>item3</option>
							<option>item4</option>
						</select>
					</form>
			</td>
			<td>종료시간<span class="essen_n"></span></td>
			<td>
					<form name="form" id="form">
						<select name="jumpMenu" id="jumpMenu"
							onchange="MM_jumpMenu('parent',this,0)" style="width: 100%;">
							<option>09:00</option>
							<option>10:00</option>
							<option>item3</option>
							<option>item4</option>
						</select>
					</form>
			</td>
		</tr>
		<tr>
			<td>장 소<span class="essen_n"></span></td>
			<td colspan="3">
					<input class="fieldline" id="" type="text" title="" value="">
				</td>
		</tr>
		<tr>
			<td>내 용<span class="essen_n"></span></td>
			<td colspan="3">
					<textarea class="up_textarea" name="내용" cols="" rows="5"
						value="내용"></textarea>
			</td>
		</tr>
		<tr>
			<td>첨부파일<span class="essen_n"></span></td>
			<td colspan="3" class="">

						<input class="fieldline" id="" type="text" title="" value="">
					<div class="btn_wh btn_posi">
						<a href=""> <span class="Btn01Start"></span> <span
							class="Btn01Center">첨부파일</span> <span class="Btn01End"></span> </a>
					</div>

			</td>
		</tr>
	</tbody>
</table>
