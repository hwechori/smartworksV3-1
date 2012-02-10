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
										<div class="body_titl_iworks title_noico">메일 설정</div>
										<div class="solid_line"></div>
								</div>
								<!-- 타이틀 //-->
								<!-- 컨텐츠 -->
								<div class="contents_space">
										
										<!-- 목록영역 -->										
										<div class="boTb">
												<table>
												<colgroup>
													<col width="20%" />
																<col width="80%" />
												</colgroup>
													<tbody>
													<tr>
																	<td>메일 호스트</td>
																				<td><input class="fieldline" type="text" title="" value="" /></td>
																</tr>
													<tr>
															<td>계정이름</td>
															<td><input class="fieldline" type="text" title="" value="" /></td>
													</tr>
														<tr>
															<td>패쓰워드</td>
															<td><input class="fieldline" type="text" title="" value="" /></td>
													</tr>
														<tr>
															<td>업무 메일링 여부</td>
															<td>
																<input type="checkbox" name="" id="" />
															</td>
													</tr>
														<tr>
															<td>저장 후 테스트</td>
															<td>
																<input type="checkbox" name="" id="" />
															</td>
													</tr>
																</tbody>
												</table>
										</div>
										
										<div class="text_align_r margin_t5"> <span class="btn_gray"> <span class="Btn01Start"></span> <span class="Btn01Center">저장</span> <span class="Btn01End"></span> </span> </div>
										<!-- 목록영역 //-->
								</div>
						</ul>
			</div>
				<div class="portlet_b" style="display: block;"></div>
		</div>
		<!-- 컨텐츠 레이아웃//-->
