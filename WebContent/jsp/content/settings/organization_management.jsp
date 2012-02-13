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
					<div class="body_titl_iworks title_noico">조직관리</div>
					<div class="solid_line"></div>
				</div>
				<!-- 타이틀 //-->
				
				<!-- 컨텐츠 -->
				<div class="contents_space">

<!-- 상단 우측버튼 -->					
					<div class="text_align_r"> 부서 "<span class="t_bold">맨인소프트</span>"에 <span class="btnIconsCreate"><a class="btnIconsTail" href="">부서추가</a></span> <span class="btnIconsCreate"><a class="btnIconsTail" href="">구성원추가</a></span></div>
					<!-- 상단 우측 버튼//-->
					
					<div class="boTb">
							<table>
								<tbody>
									<tr>
										<td class="end">조직도</td>
										<td class="end">
										
										<!-- 회사정보 -->
											<div class="gray_style table_nomal600">
												<table>
													<tbody>
														<tr>
															<th class="text_align_c">회사이름</th>
															<td>맨인소프트</td>
														</tr>
													</tbody>
												</table>
												</div>
											<!-- 회사정보//-->
											
											<!-- 부서추가 -->
											<!-- 타이틀 영역 -->
											<div style="display:block">
												<div class="default_title_space">
													<div class="title">부서 추가</div>
												</div>
												<!-- 타이틀 영역 //-->
												
												<div class="boTb">
												<table class="margin_t10">
													<tbody>
														<tr>
															<td width="20%" >상위 부서</td>
															<td width="80%"><input class="fieldline" type="text" title="" value="" /></td>
														</tr>
														<tr>
															<td>부서 이름</td>
															<td><input class="fieldline" type="text" title="" value="" /></td>
														</tr>
													</tbody>
												</table>
											</div>
											
											<!-- Btn -->
											<div class="text_align_r margin_t8">
												<span class="btn_gray">
													<span class="Btn01Start"></span>
													<span class="Btn01Center">저장</span>
													<span class="Btn01End"></span>												</span>											</div>
											<!-- Btn //-->
											</div>
											<!-- 부서추가 //-->
											
											<!-- 부서추가 -->
											<!-- 타이틀 영역 -->
											<div style="display:block">
												<div class="default_title_space">
													<div class="title">사용자 추가</div>
												</div>
												<!-- 타이틀 영역 //-->
												
												<div class="boTb">
												<table class="margin_t10">
													<tbody>
														<tr>
															<td width="20%" >부서별</td>
															<td width="80%">맨인소프트</td>
														</tr>
														<tr>
															<td>이름</td>
															<td><input class="fieldline" type="text" title="" value="" /></td>
														</tr>
														<tr>
															<td>사용자 아이디</td>
															<td>
															<input class="fieldline" type="text" title="" value="" />
															<div class="txt_btn float_left">※ Email을 입력 하세요</div>
															
															<div class="float_right margin_t2">
																<div class="btnIconStart">
																	<a class="btnIconsTail" href="">중복확인</a>
																</div>
															</div>
															</td>
														</tr>
														<tr>
															<td>비밀번호</td>
															<td><input class="fieldline" type="text" title="" value="" /></td>
														</tr>
														<tr>
															<td>비밀번호 확인</td>
															<td><input class="fieldline" type="text" title="" value="" /></td>
														</tr>
														<tr>
															<td>사용자 번호</td>
															<td><input class="fieldline" type="text" title="" value="" /></td>
														</tr>
														<tr>
															<td>직 위</td>
															<td><input class="fieldline" type="text" title="" value="" /></td>
														</tr>
														<tr>
															<td>역 할</td>
															<td>
																<select name="">
																	<option>부서원</option>
																</select>
															</td>
														</tr>
														<tr>
															<td>사용자 수준</td>
															<td><select name="">
																<option>사용자</option>
															</select></td>
														</tr>
														<tr>
															<td>언 어</td>
															<td><select name="">
																<option>한국어</option>
															</select></td>
														</tr>
														<tr>
															<td>내선번호</td>
															<td><input class="fieldline" type="text" title="" value="" /></td>
														</tr>
														<tr>
															<td>휴대번호</td>
															<td><input class="fieldline" type="text" title="" value="" /></td>
														</tr>
													</tbody>
												</table>
											</div>
											
											<!-- Btn -->
											<div class="text_align_r margin_t8">
												<span class="btn_gray">
													<span class="Btn01Start"></span>
													<span class="Btn01Center">저장</span>
													<span class="Btn01End"></span>												</span>											</div>
											<!-- Btn //-->
											</div>
											<!-- 부서추가 //-->										</td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
				<!-- 컨텐츠 //-->
			</ul>
		</div>
		<div class="portlet_b" style="display: block;"></div>
	</div>
	<!-- 컨텐츠 레이아웃//-->
