<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="net.smartworks.service.ISmartWorks"%>

<div class="txt_btn">
	<div class="current">
		<a href="">간단히</a>
	</div>
	<div>
		<a href="">자세히</a>
	</div>
	<div>
		<a href="">프로세스 보기</a>
	</div>
</div>

<div id="form_import">
	<table>
		<colgroup>
			<col class="item">
			<col class="field">
			<col class="item">
			<col class="field">
		</colgroup>
		<tbody>
			<tr>신제품 기획 TFT > TFT 회의록
			</tr>
			<tr>
				<th>제 목</th>
				<td colspan="3" class=""><div class="fieldline">
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
							<img src="images/btn_s_search.jpg" />
						</div>
					</div>
				</td>
				<th>진행단계</th>
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
				<th>작성자</th>
				<td>
					<div class="ico_space">
						<div class="fieldline">
							<input id="" type="text" title="" value="">
						</div>
						<div class="ico_posi">
							<img src="images/btn_s_person.png" />
						</div>
					</div>
				</td>
				<th>작성일자</th>
				<td>
					<div class="ico_space">
						<div class="fieldline">
							<input id="" type="text" title="" value="">
						</div>
						<div class="ico_posi">
							<img src="images/btn_s_calendar.png" />
						</div>
					</div>
				</td>
			</tr>
			<tr>
				<th>시작시간</th>
				<td>
					<div class="">
						<form name="form" id="form">
							<select name="jumpMenu" id="jumpMenu"
								onchange="MM_jumpMenu('parent',this,0)" style="width: 100%;">
								<option>09:00</option>
								<option>10:00</option>
								<option>item3</option>
								<option>item4</option>
							</select>
						</form>
					</div>
				</td>
				<th>종료시간</th>
				<td>
					<div class="">
						<form name="form" id="form">
							<select name="jumpMenu" id="jumpMenu"
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
				<td colspan="3" class=""><div class="fieldline">
						<input id="" type="text" title="" value="">
					</div></td>
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
</div>

<div id="form_default">
	<input name="" type="checkbox" value="" />업무계획
	<div class="">
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

	<div class="up_form" style="height: 65px;">
		<textarea class="up up_textarea" name="업무에 대한 부연설명을 입력하세요!" cols=""
			rows="5" value="업무에 대한 부연설명을 입력하세요">업무에 대한 부연설명을 입력하세요!
                </textarea>
	</div>


</div>

<jsp:include page="/jsp/content/upload/upload_buttons.jsp"></jsp:include>