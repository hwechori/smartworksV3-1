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
					<div class="body_titl_iworks title_noico">회사 달력</div>
					<div class="solid_line"></div>
				</div>
				<!-- 타이틀 -->
				<!-- 컨텐츠 -->
				<div class="contents_space">
					<!-- 타이틀 영역 -->
					<div class="list_title_space">
						<div class="title">회사 달력 목록</div>
						<!-- 우측버튼 -->
						<div class="titleLineBtns">
							<div class="po_left">
								<select name="">
									<option>전 체</option>
									<option>2010년도</option>
									<option>2011년도</option>
									<option>2012년도</option>
									<option>2013년도</option>
								</select>
							</div>
							<div class="btnIconsCreate"> <a class="btnIconsTail" href="">추가하기</a> </div>
						</div>
						<!-- 우측버튼 //-->
					</div>
					<!-- 타이틀 영역// -->
					<!-- 추가하기 테이블 -->
					<div class="form_wrap up up_padding margin_b2 clear">
						<div class="form_title">
							<div class="ico_iworks title_noico">행사일/휴일 추가</div>
							<div class="solid_line clear"></div>
						</div>
						<div class="form_layout  margin_b10">
							<table>
								<tbody>
									<tr>
										<th width="15%">이 름<span class="essen_n"></span></th>
										<td width="35%"><input class="fieldline" type="text" title="" value="" /></td>
										<th width="15%">구 분</th>
										<td width="35%"><select name="select3" id="select">
												<option>휴 일</option>
											</select>
										</td>
									</tr>
									<tr>
										<th>시작일자<span class="essen_n"></span></th>
										<td><input class="fieldline space_data" type="text" value="2010.11.10">
											<a class="" href=""> <span class="ico_fb_time po_ico_time"></span> </a> </td>
										<th>종료일자<span class="essen_n"></span></th>
										<td><input class="fieldline space_data" type="text" value="2010.11.10">
											<a class="" href=""> <span class="ico_fb_time po_ico_time"></span> </a> </td>
									</tr>
									<tr>
										<th>관련자</th>
										<td colspan="3"><div class="ico_fb_space">
												<div class="fieldline">
													<div class="user_sel_area"></div>
													<input class="" type="text" href="community_name.sw">
													<div class="js_srch_x"></div>
												</div>
												<div class="js_community_list srch_list_nowid" style="display: none"></div>
												<span class="js_community_popup"></span> <a class="js_userpicker_button" href=""> <span class="ico_fb_users"></span> </a> </div></td>
									</tr>
									<tr>
										<th>설 명</th>
										<td colspan="3"><textarea class="fieldline" name="" id="" cols="" rows="5"></textarea>
										</td>
									</tr>
								</tbody>
							</table>
						</div>
						<!-- 버튼영역 -->
						<div class="glo_btn_space">
							<div class="float_right"> <span class="btn_gray"> <span class="Btn01Start"></span> <span class="Btn01Center">저장</span> <span class="Btn01End"></span> </span> <span class="btn_gray"> <span class="Btn01Start"></span> <span class="Btn01Center">취소</span> <span class="Btn01End"></span> </span> </div>
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
								</colgroup>
								<tbody>
									<tr class="tit_bg">
										<th class="r_line">시작일자</th>
										<th class="r_line">종료일자</th>
										<th class="r_line">구 분</th>
										<th class="r_line">이 름</th>
										<th class="r_line">설 명</th>
										<th class="r_line">관련자</th>
										<th>처 리</th>
									</tr>
									<tr>
										<td>2012.01.22</td>
										<td>2012.01.24</td>
										<td>휴일</td>
										<td>설날</td>
										<td>20112년 설날(구정)입니다.모두모두 새해 많이받으세요~</td>
										<td>맨인소프트</td>
										<td><input type="button" class="btn_s_modi"/>
											<input type="button" class="btn_s_del"/></td>
									</tr>
									<tr>
										<td><p>2011.06.06</p></td>
										<td>2011.06.06</td>
										<td>휴일</td>
										<td> 현충일</td>
										<td>공휴일</td>
										<td>맨인소프트</td>
										<td><input type="button" class="btn_s_modi"/>
											<input type="button" class="btn_s_del"/></td>
									</tr>
									<tr>
										<td>2011.04.22</td>
										<td>2011.04.23</td>
										<td>행사일</td>
										<td>사내 춘계 워크샵</td>
										<td>사내 춘계 워크샵 진행 : 2011-04-23, 강촌</td>
										<td>맨인소프트</td>
										<td><input type="button" class="btn_s_modi"/>
											<input type="button" class="btn_s_del"/></td>
									</tr>
									<tr>
										<td>2011.07.13</td>
										<td>2011.07.03</td>
										<td>행사일</td>
										<td>창립기념일</td>
										<td>창립 5주년</td>
										<td>맨인소프트</td>
										<td><input type="button" class="btn_s_modi"/>
											<input type="button" class="btn_s_del"/></td>
									</tr>
								</tbody>
							</table>
							<!-- Paging -->
							<form name="frmInstanceListPaging">
								<div class="paginate"> <strong>1</strong>
									<input type="hidden" value="1" name="hdnCurrentPage">
									<a class="num js_select_current_page" href="">2</a> <a class="num js_select_current_page" href="">3</a> <a class="num js_select_current_page" href="">4</a> <a class="num js_select_current_page" href="">5</a> <a class="num js_select_current_page" href="">6</a> <a class="num js_select_current_page" href="">7</a> <a class="num js_select_current_page" href="">8</a> <a class="num js_select_current_page" href="">9</a> <a class="num js_select_current_page" href="">10</a> <a class="next js_select_paging" title="다음 10개 페이지 "> <span class="spr"></span>
									<input type="hidden" value="false" name="hdnNext10">
									</a> <a class="next_end js_select_paging" title="마지막 페이지 "> <span class="spr">
									<input type="hidden" value="false" name="hdnNextEnd">
									</span> </a> <span class="js_progress_span"></span> </div>
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
