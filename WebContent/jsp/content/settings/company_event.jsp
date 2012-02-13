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
					<div class="js_new_company_calendar"></div>
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
