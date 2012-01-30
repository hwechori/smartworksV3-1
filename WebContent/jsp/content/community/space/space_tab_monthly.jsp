<%@page import="net.smartworks.model.community.WorkSpace"%>
<%@page import="java.util.Calendar"%>
<%@page import="net.smartworks.model.calendar.CompanyCalendar"%>
<%@page import="net.smartworks.model.community.User"%>
<%@page import="net.smartworks.util.SmartUtil"%>
<%@page import="net.smartworks.util.LocalDate"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="net.smartworks.service.ISmartWorks"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	ISmartWorks smartWorks = (ISmartWorks) request.getAttribute("smartWorks");
	User cUser = SmartUtil.getCurrentUser();

	WorkSpace workSpace = (WorkSpace)session.getAttribute("workSpace");

	LocalDate today =  LocalDate.convertLocalDateStringToLocalDate((new LocalDate()).toLocalDateSimpleString());
	LocalDate thisMonth = LocalDate.convertLocalMonthWithDiffMonth(today, 0);
	
	String selectedIndexStr = request.getParameter("selectedIndex");
	int selectedIndex = SmartUtil.isBlankObject(selectedIndexStr) ? 11 : Integer.parseInt(selectedIndexStr);

	LocalDate startMonth = LocalDate.convertLocalMonthWithDiffMonth(today, -11);
	String startDateStr = request.getParameter("startDate");
	if(!SmartUtil.isBlankObject(startDateStr)){
		LocalDate tempStartDate = LocalDate.convertLocalMonthStringToLocalDate(startDateStr);
		if(LocalDate.convertLocalMonthWithDiffMonth(tempStartDate, 11).getTime() < today.getTime())
			startMonth = LocalDate.convertLocalMonthWithDiffMonth(tempStartDate, 0);
	}
	if(SmartUtil.isBlankObject(startDateStr)) startDateStr = startMonth.toLocalDateSimpleString();
	LocalDate endMonth =LocalDate.convertLocalMonthWithDiffMonth(startMonth, 11);
	LocalDate yearLaterMonth = LocalDate.convertLocalMonthWithDiffMonth(endMonth, 11);

	session.setAttribute("startDate", startDateStr);
	
%>
<!--  다국어 지원을 위해, 로케일 및 다국어 resource bundle 을 설정 한다. -->
<fmt:setLocale value="<%=cUser.getLocale() %>" scope="request" />
<fmt:setBundle basename="resource.smartworksMessage" scope="request" />

<!--탭-->
<div class="tab js_space_tab_monthly_page"  workSpaceId="<%=workSpace.getId() %>" startDate="<%=startDateStr%>">

	<%
	String prevYearHref = "space_tab_monthly.sw?startDate=" 
			+ (LocalDate.convertLocalMonthWithDiffMonth(startMonth, -12)).toLocalDateSimpleString()
			+ "selectedIndex=0";
	String prevMonthHref = "space_tab_monthly.sw?startDate=" 
			+ (LocalDate.convertLocalMonthWithDiffMonth(startMonth, -1)).toLocalDateSimpleString()
			+ "selectedIndex=0";
	%>
	<a href="<%=prevYearHref %>" class="btn_arr_prev2 js_space_tab_index"></a> 
	<a href="<%=prevMonthHref %>" class="btn_arr_prev js_space_tab_index"></a>

	<ul>
		<%
		String monthStr = "";
		String selectedMonthStr = "";
		LocalDate month = new LocalDate(startMonth.getTime());
		for(int i = 0; i<12; i++){
			LocalDate tempMonth = LocalDate.convertLocalMonthWithDiffMonth(month, i);
			if(i==selectedIndex){
				monthStr = tempMonth.toLocalMonthFullString();
				selectedMonthStr = tempMonth.toLocalMonthString();
			}else{
				monthStr = tempMonth.toLocalMonthShortString();
			}
			String liClass = (i==selectedIndex) ? "current" : "";
 			String href = "space_tab_monthly.sw?startDate=" + startDateStr + "&selectedIndex=" + i; 
		%>
			<li class="<%=liClass%>"><span class="intab"><a class="js_space_tab_index" href="<%=href %>"><%=monthStr %></a></span></li>
		<%
		}
		%>
	</ul>

	<%
	String nextMonthHref = "space_tab_monthly.sw?startDate=" 
			+ LocalDate.convertLocalMonthWithDiffMonth(startMonth, 1).toLocalDateSimpleString()
			+ "selectedIndex=11";
	String nextYearHref = "space_tab_monthly.sw?startDate=" 
			+ LocalDate.convertLocalMonthWithDiffMonth(startMonth, 12).toLocalDateSimpleString()
			+ "selectedIndex=11";
	%>
	<%
	if(endMonth.getTime() < thisMonth.getTime()){
	%>
		<a href="<%=nextMonthHref%>" class="btn_arr_next js_space_tab_index"></a>
		<a href="<%=nextYearHref %>" class="btn_arr_next2 js_space_tab_index"></a>
	<%
	} 
	%>

	<div class="option_section">
  		<span class="sel_date_section"><%=selectedMonthStr %><input type="hidden" class="js_space_datepicker" value="<%=selectedMonthStr%>.01"><a href="space_tab_monthly.sw" class="btn_calendar js_space_datepicker_button"></a></span> 
		<select class="js_space_select_scope">
			<option value="space_tab_dayly.sw"><fmt:message key="space.title.tab_dayly"/></option>
			<option value="space_tab_weekly.sw"><fmt:message key="space.title.tab_weekly"/></option>
			<option selected><fmt:message key="space.title.tab_monthly"/></option>
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

				<!-- 1주 -->
				<div class="space_section">
					<div class="title">
						12.1 목요일 ~ 12.4 <span class="t_sunday">일요일</span>
					</div>
					<ul>
						<li class="t_nowork">업무가 없습니다</li>
					</ul>
				</div>
				<!-- 1주//-->

				<!-- 2주 -->
				<div class="space_section margin_t10">
					<div class="title">
						12.5 월요일</span> ~ 12.11 <span class="t_sunday">일요일</span>
					</div>
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
											class="repl_write">댓글달기</span>
										</a>
									</div>
								</div>
							</div></li>

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
												class="repl_write">댓글달기</span>
											</a>
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
															<span class="t_name">Minashin</span><span class="t_date">
																2011.10.13</span>
															<div>와우~ 멋져요~</div>
														</div></li>
													<li>
														<div class="noti_pic">
															<img src="../images/pic_size_29.jpg" alt="신민아"
																align="bottom" />
														</div>
														<div class="noti_in">
															<span class="t_name">Minashin</span><span class="t_date">
																2011.10.13</span>
															<div>재미있었겠네요~</div>
														</div></li>
													<li>
														<div class="det_title">
															<div class="noti_pic">
																<img src="../images/pic_size_29.jpg" alt="신민아"
																	align="bottom" />
															</div>
															<div class="noti_in">
																<span class="t_name">Minashin</span><span class="t_date">
																	2011.10.13</span>
																<div>가을이 다 지나가부렀네요~~--;</div>
															</div>
														</div></li>
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
							</div></li>
					</ul>
				</div>
				<!-- 2주//-->

				<!-- 3주 -->
				<div class="space_section margin_t10">
					<div class="title_off">
						12.12 월요일 ~ 12.18 <span class="t_sunday">일요일</span>
					</div>
				</div>
				<!-- 3주//-->

				<!-- 4주 -->
				<div class="space_section margin_t10">
					<div class="title_off">
						12.19 월요일 ~ 12.24 <span class="t_sunday">일요일</span>
					</div>
				</div>
				<!-- 4주//-->

				<!-- 5주 -->
				<div class="space_section margin_t10">
					<div class="title_off">
						12.25 월요일 ~ 12.31 <span class="t_sunday">일요일</span>
					</div>
				</div>
				<!-- 5주//-->

			</div>
			<!-- 컨텐츠 //-->

		</ul>
	</div>
	<div class="portlet_b" style="display: block;"></div>
</div>
<!-- 컨텐츠 레이아웃//-->

<script type="text/javascript">
	$.datepicker.setDefaults($.datepicker.regional[currentUser.locale]);
	$('.js_space_datepicker').datepicker(
			{
				defaultDate : new Date(),
				dateFormat : 'yy.mm.dd',
				onSelect : function(date) {
					var selectedMonth = new Date(date);
					var today = new Date();
					var thisMonth = new Date(today.getFullYear(), today.getMonth());
					if (selectedMonth.getTime() > thisMonth.getTime()) {
						smartPop.showInfo(smartPop.WARN, smartMessage
								.get('spaceOverDateSeleted'));
						return false;
					}
					var input = $(this);
					var target = input.parents('.js_space_instance_list');
					var url = input.next().attr('href');
					var startMonth = new Date(selectedMonth.toString());
					startMonth.setMonth(selectedMonth.getMonth() - 11, 1);
					console.log('selected=', selectedMonth.toDateString(),
							'start=', startMonth.toDateString());
					$.ajax({
						url : url,
						data : {
							startDate : startMonth.format('yyyy.mm.dd'),
							selectedIndex : 11
						},
						success : function(data, status, jqXHR) {
							target.html(data);
						},
						error : function(xhr, ajaxOptions, thrownError) {
						}
					});
				}
			});
</script>
