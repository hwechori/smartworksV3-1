<%@ page contentType="text/html; charset=utf-8"%>
<!-- 폼- 업무 입력 후 -->
<table>
		<tr>
			<th class="essen_n">제 목</th>
			<td colspan="3">
					<input class="fieldline" id="" type="text" title="" value="" >
				</td>
		</tr>
		<tr>
			<th class="essen_n">과제명</th>
			<td class="before_icon">
				<div class="ico_space">

						<input class="fieldline" id="" type="text" title="" value="">

					<div class="ico_posi">
						<img src="images/btn_s_search.png" />
					</div>
				</div>
			</td>
			<th class="space_tit">진행단계</th>
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
			<th class="essen_n">작성자</th>
			<td class="before_icon">
				<div class="ico_space">
						<input class="fieldline" id="" type="text" title="" value="">
					<div class="ico_posi">
						<img src="images/btn_s_person.png" />
					</div>
				</div>
			</td>
			<th class="essen_n">작성일자</th>
			<td>
				<div class="ico_space">
						<input class="fieldline" id="" type="text" title="" value="">
					<div class="ico_posi">
						<img src="images/btn_s_calendar.png" />
					</div>
				</div>
			</td>
		</tr>
		<tr>
			<th class="essen_n">내 용</th>
			<td colspan="3">
					<textarea class="up_textarea" name="내용" cols="" rows="5"
						value="내용"></textarea>
			</td>
		</tr>
		<tr>
			<th class="space_tit">첨부파일</th>
			<td colspan="3" class="">
				<div class="btn_space">
						<input class="fieldline" id="" type="text" title="" value="">
					<div class="btn_wh btn_posi">
						<a href=""> <span class="Btn01Start"></span> <span
							class="Btn01Center">첨부파일</span> <span class="Btn01End"></span> </a>
					</div>
				</div>
			</td>
		</tr>
	</tbody>
</table>
