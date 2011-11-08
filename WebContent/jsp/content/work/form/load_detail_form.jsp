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
			<th colspan="2">신제품 기획 TFT > TFT 회의록</th>
			<td colspan="2">
				<div class="txt_btn">
					<div>
						<a href="">참조자 지정</a>
					</div>
					<div>
						<a href="">전자결재</a>
					</div>
				</div>
			</td>
		</tr>
		<tr>
			<td colspan="4" class="solid_line"></td>
		</tr>
		<tr>
			<td colspan="4">
				<div class="txt_btn">
					<div>
						<a href="">프로세스 보기</a>
					</div>
					<div>
						<a href="">자세히</a>
					</div>
					<div class="current">
						<a href="">간단히</a>
					</div>
				</div>
			</td>
		</tr>
		<tr>
			<th>제 목</th>
			<td colspan="3" class=""><div class="fieldline essen">
					<input id="" type="text" title="" value="">
				</div></td>
		</tr>
		<tr>
			<th>과제명</th>
			<td>
				<div class="ico_space">
					<div class="fieldline">
						<input id="" type="text" title="" value="">
					</div>
					<div class="ico_posi">
						<img src="../images/btn_s_search.jpg" />
					</div>
				</div>
			</td>
			<th class="padding_l">진행단계</th>
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
			<th>작성자</th>
			<td>
				<div class="ico_space">
					<div class="fieldline essen">
						<input id="" type="text" title="" value="">
					</div>
					<div class="ico_posi">
						<img src="../images/btn_s_person.png" />
					</div>
				</div>
			</td>
			<th class="padding_l">작성일자</th>
			<td>
				<div class="ico_space">
					<div class="fieldline essen">
						<input id="" type="text" title="" value="">
					</div>
					<div class="ico_posi">
						<img src="../images/btn_s_calendar.png" />
					</div>
				</div>
			</td>
		</tr>
		<tr>
			<th>시작시간</th>
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
			<th class="padding_l">종료시간</th>
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
			<th>장 소</th>
			<td colspan="3" class=""><div class="fieldline essen">
					<input id="" type="text" title="" value="">
				</div></td>
		</tr>
		<tr>
			<th>내 용</th>
			<td colspan="3" class="">
				<div class="up_form" style="height: 60px;">
					<textarea class="up up_textarea essen" name="내용" cols="" rows="5"
						value="내용"></textarea>
				</div>
			</td>
		</tr>
		<tr>
			<th>첨부파일</th>
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

