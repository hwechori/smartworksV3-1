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
					<div class="body_titl_iworks title_noico">결재선 관리</div>
					<div class="solid_line"></div>
				</div>
				<!-- 타이틀 -->
				<!-- 컨텐츠 -->
				<div class="contents_space">
					<!-- 타이틀 영역 -->
					<div class="list_title_space">
						<div class="title">결재선 목록</div>
						<!-- 우측버튼 -->
						<div class="titleLineBtns">
							<div class="btnIconsCreate"> <a class="btnIconsTail" href="">추가하기</a> </div>
						</div>
						<!-- 우측버튼 //-->
					</div>
					<!-- 타이틀 영역// -->
					<!-- 추가하기 테이블 -->
					<div class="form_wrap up up_padding margin_b2 clear">
						<div class="form_title">
							<div class="ico_iworks title_noico">결재선 추가</div>
							<div class="solid_line clear"></div>
						</div>
						<div class="form_layout  margin_b10">
							<table>
								<tbody>
									<tr>
										<th width="20%">결재선 이름 <span class="essen_n"></span></th>
										<td colspan="3" width="80%" ><input name="" type="text" class="fieldline"/>
										</td>
									</tr>
									<tr>
										<th>설 명</th>
										<td colspan="3"><textarea name="" id="" cols="" rows="3" class="fieldline"></textarea>
										</td>
									</tr>
									<tr>
										<th>결재레벨 <span class="essen_n"></span></th>
										<td colspan="3"><select>
												<option>3 단 </option>
											</select>
										</td>
									</tr>
									<tr>
										<th>결재 단계 이름</th>
										<td width="26%"><input name="input" type="text" class="fieldline"/></td>
										<td width="26%"><input name="input2" type="text" class="fieldline"/></td>
										<td width="26%"><input name="input3" type="text" class="fieldline"/></td>
									</tr>
									<tr>
										<th>결재자</th>
										<td><select name="select" id="select">
												<option>기안시 지정</option>
											</select>
										</td>
										<td><select name="select2" id="select2">
												<option>기안시 지정</option>
											</select></td>
										<td><select name="select3" id="select3">
												<option>기안시 지정</option>
											</select></td>
									</tr>
									<tr>
										<th>평균 소요시간</th>
										<td><input name="" type="text" class="fieldline" style="width:30px"/>
											일
											<input name="" type="text" class="fieldline" style="width:20px"/>
											시간
											<input name="" type="text" class="fieldline" style="width:20px"/>
											분 </td>
										<td><input name="input4" type="text" class="fieldline" style="width:30px"/>
											일
											<input name="input4" type="text" class="fieldline" style="width:20px"/>
											시간
											<input name="input4" type="text" class="fieldline" style="width:20px"/>
											분 </td>
										<td><input name="input5" type="text" class="fieldline" style="width:30px"/>
											일
											<input name="input5" type="text" class="fieldline" style="width:20px"/>
											시간
											<input name="input5" type="text" class="fieldline" style="width:20px"/>
											분 </td>
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
								<tbody>
									<tr class="tit_bg">
										<th width="28%" class="r_line">결재선 이름</th>
										<th width="27%" class="r_line">설 명</th>
										<th width="27%" class="r_line">결재 레벨</th>
										<th width="18%">처 리</th>
									</tr>
									<tr>
										<td>연구소 라인결재</td>
										<td>&nbsp;</td>
										<td>2단</td>
										<td class="text_align_c"><input type="button" class="btn_s_modi"/>
											<input type="button" class="btn_s_del"/>
										</td>
									</tr>
									<tr>
										<td>3단 결재</td>
										<td>검토-승인-확인</td>
										<td>3단</td>
										<td class="text_align_c"><input type="button" class="btn_s_modi"/>
											<input type="button" class="btn_s_del"/></td>
									</tr>
									<tr>
										<td>1단</td>
										<td>&nbsp;</td>
										<td>1단</td>
										<td class="text_align_c"><input type="button" class="btn_s_modi"/>
											<input type="button" class="btn_s_del"/></td>
									</tr>
									<tr>
										<td>2단 결재</td>
										<td>검토-최종승인</td>
										<td>2단</td>
										<td class="text_align_c"><input type="button" class="btn_s_modi"/>
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
