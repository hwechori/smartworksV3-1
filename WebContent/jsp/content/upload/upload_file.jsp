<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="net.smartworks.service.ISmartWorks"%>


<div id="up_file">
	<div class="up_warp space js_upload_input">
		<div class="up_form">
			<div class="up_point posit_file"></div>
			<input class="up" id="" type="text" title=""
				placeholder="<fmt:message key='common.upload.message.file'/>">
		</div>

		<div class="btn" style="right: 0">
			<a href=""> <span class="Btn01Start"></span> <span
				class="Btn01Center">찾아보기</span> <span class="Btn01End"></span> </a>
		</div>
	</div>

	<div class="js_upload_form_detail" style="display: none">
		<div class="up_form" style="height: 65px;">
			<textarea class="up up_textarea" name="파일에 대한 부연설명을 입력하세요!" cols=""
				rows="5" value="파일에 대한 부연설명을 입력하세요">파일에 대한 부연설명을 입력하세요!
                </textarea>
		</div>

		<div class="txt_btn float_right">
			<div class="">
				<a href="">상세 정보 추가</a>
			</div>
		</div>

		<!-- 상세 정보 추가시 화면 -->
		<div id="form_import">
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
										class="Btn01Center">첨부파일</span> <span class="Btn01End"></span>
									</a>
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
										class="Btn01Center">전체보기</span> <span class="Btn01End"></span>
									</a>
								</div>
							</div>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
		<!-- 상세 정보 추가시 화면 //-->

		<!-- 하단 등록,취소 버튼 -->
		<jsp:include page="/jsp/content/upload/upload_buttons.jsp"></jsp:include>
		<!-- 하단 등록,취소 버튼 -->
	</div>
</div>
