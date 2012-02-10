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
										<div class="body_titl_iworks title_noico">회사일반</div>
										<div class="solid_line"></div>
								</div>
								<!-- 타이틀 //-->
								<!-- 컨텐츠 -->
								<div class="contents_space">
										<div class="gray_style table_nomal600">
												<table>
														<colgroup>
														<col width="30%" />
														<col width="70%" />
														</colgroup>
														<tbody>
																<tr>
																		<th class="text_align_c">회사이름</th>
																		<td>맨인소프트</td>
																</tr>
														</tbody>
												</table>
										</div>
										<!-- 목록영역 -->
										<div class="default_title_space padding_t20">
												<div class="title">회사로고 설정</div>
										</div>
										
										<div class="boTb">
												<table>
														<colgroup>
														<col width="20%" />
														<col width="80%" />
														</colgroup>
														<tbody>
																<tr>
																		<td rowspan="2">회사로고</td>
																		<td><img src="../images/logo_compay.gif" width="130" height="35" /> <span class="t_s11" style="vertical-align:bottom">(크기:130 x 35 픽셀, 배경색:검정색을 권장합니다)</span></td>
																</tr>
																<tr>
																		<td><input class="fieldline" type="text" title="" value="" /></td>
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
