<%@ page contentType="text/html; charset=utf-8"%>
<!-- 폼- 업무 입력 후 -->
<table>
		<tr>
			<td>제 목 <span class="essen_n"></span></td>
			<td colspan="3">
					<input class="fieldline" id="" type="text" title="" value="" >
				</td>
		</tr>
		<tr>
			<td width="12%">과제명<span class="essen_n"></span></td>
			<td width="38%" class="before_icon">
				<div class="ico_space">

						<input class="fieldline" id="" type="text" title="" value="">

					<div class="ico_posi">
						<img src="images/btn_s_search.png" />
					</div>
				</div>
			</td>
			<td width="12%">진행단계</td>
			<td width="38%">
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
			<td>작성자<span class="essen_n"></span></td>
			<td class="before_icon">
				<div class="ico_space">
						<input class="fieldline" id="" type="text" title="" value="">
					<div class="ico_posi">
						<img src="images/btn_s_person.png" />
					</div>
				</div>
			</td>
			<td>작성일자<span class="essen_n"></span></td>
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
			<td>내 용<span class="essen_n"></span></td>
			<td colspan="3">
					<textarea class="up_textarea" name="내용" cols="" rows="5"
						value="내용"></textarea>
			</td>
		</tr>
		<tr>
			<td>첨부파일</td>
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
