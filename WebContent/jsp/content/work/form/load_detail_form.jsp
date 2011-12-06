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
			<td>제 목</td>
			<td colspan="3" class=""><div class="fieldline essen">
					<input id="" type="text" title="" value="">
				</div></td>
		</tr>
		<tr>
			<td>과제명</td>
			<td>
				<div class="ico_space">
					<div class="fieldline">
						<input id="" type="text" title="" value="">
					</div>
					<div class="ico_posi">
						<img src="images/btn_s_search.jpg" />
					</div>
				</div>
			</td>
			<td class="padding_l20">진행단계</td>
			<td>
				<div>
					<form name="form" id="form">
						<select name="jumpMenu" id="jumpMenu"
							onchange="MM_jumpMenu('parent',this,0)" style="width: 100%;">
							<option>계획</option>
							<option>item2</option>
							<option>item3</option>
							<option>item4</option>
						</select>
					</form>
				</div>
			</td>
		</tr>
		<tr>
			<td>작성자</td>
			<td>
				<div class="ico_space">
					<div class="fieldline essen">
						<input id="" type="text" title="" value="">
					</div>
					<div class="ico_posi">
						<img src="images/btn_s_person.png" />
					</div>
				</div>
			</td>
			<td class="padding_l20">작성일자</td>
			<td>
				<div class="ico_space">
					<div class="fieldline essen">
						<input id="" type="text" title="" value="">
					</div>
					<div class="ico_posi">
						<img src="images/btn_s_calendar.png" />
					</div>
				</div>
			</td>
		</tr>
		<tr>
			<td>시작시간</td>
			<td>
				<div class="">
					<form name="form" id="form">
						<select name="jumpMenu" id="jumpMenu" class="essen"
							onchange="MM_jumpMenu('parent',this,0)" style="width: 100%;">
							<option>09:00</option>
							<option>10:00</option>
							<option>item3</option>
							<option>item4</option>
						</select>
					</form>
				</div>
			</td>
			<td class="padding_l20">종료시간</td>
			<td>
				<div class="">
					<form name="form" id="form">
						<select name="jumpMenu" id="jumpMenu" class="essen"
							onchange="MM_jumpMenu('parent',this,0)" style="width: 100%;">
							<option>09:00</option>
							<option>10:00</option>
							<option>item3</option>
							<option>item4</option>
						</select>
					</form>
				</div>
			</td>
		</tr>
		<tr>
			<td>장 소</td>
			<td colspan="3" class=""><div class="fieldline essen">
					<input id="" type="text" title="" value="">
				</div></td>
		</tr>
		<tr>
			<td>내 용</td>
			<td colspan="3" class="">
				<div class="textarea_size">
					<textarea class="up_textarea essen" name="내용" cols="" rows="5"
						value="내용"></textarea>
				</div>
			</td>
		</tr>
		<tr>
			<td>첨부파일</td>
			<td colspan="3" class="">
				<div class="btn_space">
					<div class="fieldline">
						<input id="" type="text" title="" value="">
					</div>

					<div class="btn_wh btn_posi">
						<a href=""> <span class="Btn01Start"></span> <span
							class="Btn01Center">첨부파일</span> <span class="Btn01End"></span> </a>
					</div>
				</div>
			</td>
		</tr>
	</tbody>
</table>
