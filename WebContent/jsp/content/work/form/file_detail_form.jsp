<%@ page contentType="text/html; charset=utf-8"%>
<div id="form_contents">
	<table>
		<colgroup>
			<col class="item">
			<col class="field">
			<col class="item">
			<col class="field">
		</colgroup>
		<tbody>
			<tr>
				<th>제 목</th>
				<td colspan="3" class=""><div class="fieldline">
						<input id="" type="text" title="" value="">
					</div></td>
			</tr>
			<tr>
				<th>검색어</th>
				<td colspan="3" class=""><div class="fieldline">
						<input id="" type="text" title="" value="">
					</div></td>
			</tr>
			<tr>
				<th>관리부서</th>
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
				<th>관리담당자</th>
				<td>
					<div class="">
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
				<th>내 용</th>
				<td colspan="3" class="">
					<div class="up_form" style="height: 65px;">
						<textarea class="up up_textarea" name="내용" cols="" rows="5"
							value="내용"></textarea>
					</div>
				</td>
			</tr>
			<tr>
				<th>첨부파일</th>
				<td class="">
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

				<th>등록위치</th>
				<td>
					<div class="btn_space">
						<div class="fieldline">
							<input id="" type="text" title="" value="">
						</div>

						<div class="btn_wh btn_posi">
							<a href=""> <span class="Btn01Start"></span> <span
								class="Btn01Center">전체보기</span> <span class="Btn01End"></span> </a>
						</div>
					</div>
				</td>
			</tr>
		</tbody>
	</table>
</div>