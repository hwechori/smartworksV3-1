<%@page import="net.smartworks.util.SmartUtil"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="net.smartworks.service.ISmartWorks"%>
<%
	ISmartWorks smartWorks = (ISmartWorks) request.getAttribute("smartWorks");
	
	session.setAttribute("cid", ISmartWorks.CONTEXT_DASHBOARD);
	session.removeAttribute("wid");
	
%>

		<!-- 컨텐츠 레이아웃-->
		<div class="section_portlet">
			<div class="portlet_t">
				<div class="portlet_tl"></div>
			</div>
			<div class="portlet_l" style="display: block;">
				<ul class="portlet_r" style="display: block;">

					<!-- 타이틀 -->
					<div class="body_titl">
						<div class="body_titl_iworks title_noico">근무시간 정책</div>
						<div class="solid_line"></div>
					</div>
					<!-- 타이틀 -->

					<!-- 컨텐츠 -->
					<div class="contents_space">

						<!-- 타이틀 영역 -->
						<div class="list_title_space">
							<div class="title">근무시간정책 목록</div>

							<!-- 우측버튼 -->
							<div class="titleLineBtns">
								<div class="btnIconsCreate">
									<a class="btnIconsTail" href="">추가하기</a>
								</div>
							</div>
							<!-- 우측버튼 //-->
						</div>
						<!-- 타이틀 영역// -->

						<!-- 추가하기 테이블 -->
						<div class="form_wrap up up_padding margin_b2 clear">
							<div class="form_title">
								<div class="ico_iworks title_noico">근무시간정책 추가</div>
								<div class="solid_line"></div>
							</div>

							<div class="form_layout  margin_b10">
								<table>
									<colgroup>
										<col widtd="50px" />
										<col widtd="40%" />
										<col widtd="50px" />
										<col widtd="40%" />
									</colgroup>
									<tbody>
										<tr>
											<td class="r_line">적용일자</td>
											<td colspan="3"><input class="fieldline space_data"
												type="text" value="2010.11.10">
											</td>
										</tr>
										<tr>
											<td class="r_line">주 시작일자</td>
											<td class="r_line"><select>
													<option>월요일</option>
											</select></td>
											<td class="r_line">주근무일</td>
											<td><select>
													<option>5일</option>
											</select></td>
										</tr>
										<tr>
											<td class="r_line">월요일</td>
											<td colspan="3">근무시작 <select>
													<option>오전 8:30</option>
											</select> 근무종료 <select>
													<option>오후 6:00</option>
											</select></td>
										</tr>
										<tr>
											<td class="r_line">화요일</td>
											<td colspan="3">근무시작 <select name="select">
													<option>오전 8:30</option>
											</select> 근무종료 <select name="select2">
													<option>오후 6:00</option>
											</select>
											</td>
										</tr>
										<tr>
											<td class="r_line">수요일</td>
											<td colspan="3">근무시작 <select name="select3">
													<option>오전 8:30</option>
											</select> 근무종료 <select name="select3">
													<option>오후 6:00</option>
											</select>
											</td>
										</tr>
										<tr>
											<td class="r_line">목요일</td>
											<td colspan="3">근무시작 <select name="select4">
													<option>오전 8:30</option>
											</select> 근무종료 <select name="select4">
													<option>오후 6:00</option>
											</select>
											</td>
										</tr>
										<tr>
											<td class="end r_line">금요일</td>
											<td colspan="3" class="end">근무시작 <select name="select5">
													<option>오전 8:30</option>
											</select> 근무종료 <select name="select5">
													<option>오후 6:00</option>
											</select>
											</td>
										</tr>
									</tbody>
								</table>
							</div>

							<!-- 버튼영역 -->
							<div class="glo_btn_space">
								<div class="float_right">
									<span class="btn_gray"> <span class="Btn01Start"></span>
										<span class="Btn01Center">저장</span> <span class="Btn01End"></span>
									</span> <span class="btn_gray"> <span class="Btn01Start"></span>
										<span class="Btn01Center">삭제</span> <span class="Btn01End"></span>
									</span>
								</div>
							</div>
							<!-- 버튼영역 //-->

						</div>
						<!-- 추가하기 테이블 //-->

						<!-- 근무정책 목록 -->
						<div class="list_contents">
							<div>
								<table>
									<colgroup>
										<col width="" />
										<col width="" />
										<col width="" />
										<col width="" />
										<col width="" />
										<col width="" />
										<col width="" />
										<col width="" />
										<col width="" />
										<col width="" />
										<col width="" />
									</colgroup>
									<tbody>
										<tr class="tit_bg">
											<th class="r_line">적용 시작일</th>
											<th class="r_line">주 시작일</th>
											<th class="r_line">주 근무일</th>
											<th class="r_line">월요일</th>
											<th class="r_line">화요일</th>
											<th class="r_line">수요일</th>
											<th class="r_line">목요일</th>
											<th class="r_line">금요일</th>
											<th class="r_line">토요일</th>
											<th class="r_line">일요일</th>
											<th>처 리</th>
										</tr>
										<tr>
											<td>2007.01.01</td>
											<td>월요일</td>
											<td>5일</td>
											<td>08:30~<br /> 18:00</td>
											<td>08:30~<br /> 18:00</td>
											<td>08:30~<br /> 18:00</td>
											<td>08:30~<br /> 18:00</td>
											<td>08:30~<br /> 18:00</td>
											<td>&nbsp;</td>
											<td>&nbsp;</td>
											<td>
												<div>편집</div>
												<div>삭제</div></td>
										</tr>

									</tbody>
								</table>

								<!-- Paging -->
								<form name="frmInstanceListPaging">
									<div class="paginate">
										<strong>1</strong> <input type="hidden" value="1"
											name="hdnCurrentPage"> <a
											class="num js_select_current_page" href="">2</a> <a
											class="num js_select_current_page" href="">3</a> <a
											class="num js_select_current_page" href="">4</a> <a
											class="num js_select_current_page" href="">5</a> <a
											class="num js_select_current_page" href="">6</a> <a
											class="num js_select_current_page" href="">7</a> <a
											class="num js_select_current_page" href="">8</a> <a
											class="num js_select_current_page" href="">9</a> <a
											class="num js_select_current_page" href="">10</a> <a
											class="next js_select_paging" title="다음 10개 페이지 "> <span
												class="spr"></span> <input type="hidden" value="false"
												name="hdnNext10">
										</a> <a class="next_end js_select_paging" title="마지막 페이지 "> <span
												class="spr"> <input type="hidden" value="false"
													name="hdnNextEnd">
											</span> </a> <span class="js_progress_span"></span>
									</div>
								</form>
								<!-- Paging//-->
							</div>

						</div>
						<!-- 근무정책 목록 //-->

					</div>
					<!-- 컨텐츠 //-->

				</ul>
			</div>
			<div class="portlet_b" style="display: block;"></div>
		</div>
		<!-- 컨텐츠 레이아웃//-->
