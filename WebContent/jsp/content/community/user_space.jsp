<%@page import="net.smartworks.util.SmartUtil"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="net.smartworks.service.ISmartWorks"%>
<%
	ISmartWorks smartWorks = (ISmartWorks) request.getAttribute("smartWorks");
	String cid = request.getParameter("cid");

	session.setAttribute("cid", cid);
	session.removeAttribute("wid");
%>

Content for User Space ~!!!! contextId =
<%=session.getAttribute("cid")%>
workSpaceId =
<%=session.getAttribute("wid")%>

		<!--탭-->
		<div class="tab">

			<!--Prev arrow -->
			<a href="" class="btn_arr_prev2"></a> <a href="" class="btn_arr_prev"></a>
			<!--Prev arrow //-->

			<ul>
				<li class="current"><span class="intab"> <a href="#">2011.11.21
							월</a> </span>
				</li>
				<li><span class="intab"> <a href="#">11.22 화</a> </span>
				</li>
				<li><span class="intab"> <a href="#">11.23 수</a> </span>
				</li>
				<li><span class="intab"> <a href="#">11.24 목</a> </span>
				</li>
				<li><span class="intab"> <a href="#">11.25 금</a> </span>
				</li>
				<li><span class="intab"> <a href="#">11.26 <span
							class="t_saturday">토</span> </a> </span>
				</li>
				<li><span class="intab"> <a href="#">11.27 <span
							class="t_sunday">일</span> </a> </span>
				</li>
			</ul>

			<!--Next arrow -->
			<a href="" class="btn_arr_next"></a> <a href="" class="btn_arr_next2"></a>
			<!--Next arrow //-->

			<div class="option_section">

				<span class="sel_date_section"> 2011.11.21 월 <a href=""
					class="btn_calendar"></a> </span> <select>
					<option>일간</option>
					<option>주간</option>
					<option>월간</option>
				</select>
			</div>

		</div>
		<!--탭//-->


		<!-- 컨텐츠 레이아웃-->
		<div class="section_portlet ">
			<div class="portlet_t">
				<div class="portlet_tl"></div>
			</div>
			<div class="portlet_l" style="display: block;">
				<ul class="portlet_r" style="display: block;">

					<!-- 컨텐츠 -->
					<div class="contents_space">

						<!-- 근무시간 전 -->
						<div class="space_section">
							<div class="title">근무시간 전</div>
							<ul>
								<li>
									<div class="det_title">
										<div class="noti_pic">
											<img src="../images/pic_size_48.jpg">
										</div>
										<div class="noti_in_m">
											<span class="t_name">Minashin</span><span class="arr">▶</span><span
												class="ico_division_s">마케팅/디자인팀</span>
											<div>회의록 내용 중 빠진 부분이나 수정할 사항이 있으시면 참석자 누구든 수정해주시기
												바랍니다^^ (메모는 타이틀 성격이 아니기 때문에 볼드가 안들어갑니다.)</div>
											<div>
												<span class="t_date"> 2011.10.13</span> <a href=""><span
													class="repl_write">댓글달기</span> </a>
											</div>
										</div>
									</div>
								</li>

								<li>
									<div class="det_title">
										<div class="noti_pic">
											<img src="../images/pic_size_48_4.jpg">
										</div>
										<div class="noti_in_m">
											<span class="t_name">Minashin</span><span class="arr">▶</span><span
												class="ico_division_s">마케팅/디자인팀</span>
											<div>
												<img class="bu_file" /> <a href="">BT-case.ppt [678kb]</a>
												<strong>하반기 마케팅 기획 및 B2B 마케팅 자료입니다</strong>
											</div>
											<div>관련 설명이 들어갑니다... 없으면 안나오구요~^^ 내용이 많으면
												줄바꿈됩니다...줄바꿔줄바꿔~~줄바꿔줄바꿔~~줄바꿔줄바꿔~~줄바꿔줄바꿔~~줄바꿔줄바꿔~~줄바꿔줄바꿔~~줄바꿔줄바꿔~~줄바꿔줄바꿔~~줄바꿔줄바꿔~~줄바꿔줄바꿔~~줄바꿔줄바꿔~~줄바꿔줄바꿔~~줄바꿔줄바꿔~~줄바꿔줄바꿔~~줄바꿔줄바꿔~~줄바꿔줄바꿔~~</div>
											<div>
												<span class="t_date"> 2011.10.13</span> <a href=""><span
													class="repl_write">댓글달기</span> </a>
											</div>
										</div>
									</div>
								</li>
							</ul>
						</div>
						<!-- 근무시간 전//-->

						<!-- 근무시간 -->
						<div class="space_section margin_t10">
							<div class="title">근무시간</div>

							<ul>
								<li>
									<div class="det_title">
										<div class="noti_pic">
											<img src="../images/pic_size_48.jpg">
										</div>
										<div class="noti_in_m">
											<span class="t_name">Minashin</span><span class="arr">▶</span><span
												class="ico_division_s">마케팅/디자인팀</span>
											<div>메모입니다...메모입니다..</div>
											<div>
												<span class="t_date"> 2011.10.13</span> <a href=""><span
													class="repl_write">댓글달기</span> </a>
											</div>
										</div>
									</div>
								</li>

								<li>
									<div class="det_title">
										<div class="noti_pic">
											<img src="../images/pic_size_48.jpg">
										</div>
										<div class="noti_in_m">
											<span class="t_name">Minashin</span><span class="arr">▶</span><span
												class="ico_division_s">마케팅/디자인팀</span>
											<div>
												<strong>이미지이미지이미지이미지</strong>
												<div>이미지 파일에 대한 설명 내용이 있다면 이 곳에 들어갑니다..</div>
												<div class="imag_area">
													<img src="../images/up_image.jpg" />
												</div>
												<div>
													<span class="t_date"> 2011.10.13</span> <a href=""><span
														class="repl_write">댓글달기</span> </a>
												</div>

												<!-- 댓글 -->
												<div class="replay_point posit_replay"></div>
												<div class="replay_section">

													<div class="list_replay">
														<ul>
															<li><img class="repl_tinfo"><a href=""><strong>7</strong>개의
																		댓글 모두 보기</a>
															</li>
															<li>
																<div class="noti_pic">
																	<img src="../images/pic_size_29.jpg" alt="신민아"
																		align="bottom" />
																</div>
																<div class="noti_in">
																	<span class="t_name">Minashin</span><span
																		class="t_date"> 2011.10.13</span>
																	<div>와우~ 멋져요~</div>
																</div>
															</li>
															<li>
																<div class="noti_pic">
																	<img src="../images/pic_size_29.jpg" alt="신민아"
																		align="bottom" />
																</div>
																<div class="noti_in">
																	<span class="t_name">Minashin</span><span
																		class="t_date"> 2011.10.13</span>
																	<div>재미있었겠네요~</div>
																</div>
															</li>
															<li>
																<div class="det_title">
																	<div class="noti_pic">
																		<img src="../images/pic_size_29.jpg" alt="신민아"
																			align="bottom" />
																	</div>
																	<div class="noti_in">
																		<span class="t_name">Minashin</span><span
																			class="t_date"> 2011.10.13</span>
																		<div>가을이 다 지나가부렀네요~~--;</div>
																	</div>
																</div>
															</li>
														</ul>
													</div>

													<div class="replay_input">
														<textarea class="up_textarea" rows="1" cols=""
															name="txtaEventContent">댓글을 입력하세요!</textarea>
													</div>

												</div>
												<!-- 댓글 //-->

											</div>
										</div>
									</div>
								</li>
							</ul>
						</div>
						<!-- 근무시간//-->

						<!-- 근무시간 후 -->
						<div class="space_section margin_t10">
							<div class="title_off">근무시간 후</div>
						</div>
						<!-- 근무시간 후//-->

					</div>
					<!-- 컨텐츠 //-->

				</ul>
			</div>
			<div class="portlet_b" style="display: block;"></div>
		</div>
		<!-- 컨텐츠 레이아웃//-->
