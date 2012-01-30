<%@page import="net.smartworks.model.calendar.WorkHourPolicy"%>
<%@page import="net.smartworks.util.SmartMessage"%>
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
	
	String selectedIndexStr = request.getParameter("selectedIndex");
	int selectedIndex = SmartUtil.isBlankObject(selectedIndexStr) ? 4 : Integer.parseInt(selectedIndexStr);

	LocalDate startDate = new LocalDate(today.getTime()-LocalDate.ONE_WEEK*4);
	String startDateStr = request.getParameter("startDate");
	if(!SmartUtil.isBlankObject(startDateStr)){
		LocalDate tempStartDate = LocalDate.convertLocalDateStringToLocalDate(startDateStr);
		if(tempStartDate.getTime()+LocalDate.ONE_WEEK*4 < today.getTime()) startDate = new LocalDate(tempStartDate.getTime());
	}
	LocalDate endDate = new LocalDate(startDate.getTime()+LocalDate.ONE_WEEK*4);
	LocalDate monthLaterDate = new LocalDate(endDate.getTime()+LocalDate.ONE_WEEK*4);

	startDateStr = startDate.toLocalDateSimpleString();
	session.setAttribute("startDate", startDateStr);

	LocalDate selectedWeekStart = null;
	LocalDate selectedWeekEnd = null;
	
%>
<!--  다국어 지원을 위해, 로케일 및 다국어 resource bundle 을 설정 한다. -->
<fmt:setLocale value="<%=cUser.getLocale() %>" scope="request" />
<fmt:setBundle basename="resource.smartworksMessage" scope="request" />

<!--탭-->
<div class="tab js_space_tab_weekly_page"  workSpaceId="<%=workSpace.getId() %>" startDate="<%=startDateStr%>">

	<%
	String prevMonthHref = "space_tab_weekly.sw?startDate=" 
			+ (new LocalDate(startDate.getTime()-LocalDate.ONE_WEEK*5)).toLocalDateSimpleString()
			+ "selectedIndex=0";
	String prevWeekHref = "space_tab_weekly.sw?startDate=" 
			+ (new LocalDate(startDate.getTime()-LocalDate.ONE_WEEK)).toLocalDateSimpleString()
			+ "selectedIndex=0";
	%>
	<a href="<%=prevMonthHref %>" class="btn_arr_prev2 js_space_tab_index"></a> 
	<a href="<%=prevWeekHref %>" class="btn_arr_prev js_space_tab_index"></a>

	<ul>
		<%
		String selectedWeekStr = "";
		String selectedDateStr = "";
		String weekStr = "";
		LocalDate week = new LocalDate(startDate.getTime());
		WorkHourPolicy whp = smartWorks.getCompanyWorkHourPolicy();
		for(int i = 0; i<5; i++){
			LocalDate tempWeek = new LocalDate(week.getTime() + LocalDate.ONE_WEEK*i);
			tempWeek.setFirstDayOfWeek(whp.getFirstDayOfWeek());
			int diffDays = tempWeek.getDayOfWeek() - whp.getFirstDayOfWeek();
			LocalDate weekStart = new LocalDate(tempWeek.getTime() - LocalDate.ONE_DAY*(diffDays<0 ? 7+diffDays : diffDays));
			weekStart.setFirstDayOfWeek(whp.getFirstDayOfWeek());
			LocalDate weekEnd = new LocalDate(weekStart.getTime() + LocalDate.ONE_DAY*6);
			weekEnd.setFirstDayOfWeek(whp.getFirstDayOfWeek());
			String weekTitle = SmartMessage.getString("space.title."+ weekStart.getWeekOfMonth() + "week");
			if(i==selectedIndex){
				weekStr = weekStart.toLocalDateLongString() + " - " + weekEnd.toLocalDateLongString();
				selectedWeekStr = weekStart.toLocalMonthString() + " " + weekStart.getWeekOfMonth() + "W";
				selectedDateStr = weekStart.toLocalDateSimpleString();
				selectedWeekStart = weekStart;
				selectedWeekEnd = weekEnd;
			}else{
				weekStr = weekStart.toLocalMonthShortString() + " " + weekTitle;
			}
			String liClass = (i==selectedIndex) ? "current" : "";
 			String href = "space_tab_weekly.sw?startDate=" + startDateStr + "&selectedIndex=" + i; 
		%>
			<li class="<%=liClass%>"><span class="intab"><a class="js_space_tab_index" href="<%=href %>"><%=weekStr %></a></span></li>
		<%
		}
		%>
	</ul>

	<%
	String nextWeekHref = "space_tab_weekly.sw?startDate=" 
			+ (new LocalDate(startDate.getTime()+LocalDate.ONE_WEEK)).toLocalDateSimpleString()
			+ "selectedIndex=4";
	String nextMonthHref = "space_tab_weekly.sw?startDate="
			+ (new LocalDate(startDate.getTime()+LocalDate.ONE_WEEK*5)).toLocalDateSimpleString()
			+ "selectedIndex=4";
	%>
	<%
	if((endDate.getYear() < today.getYear()) || (endDate.getYear() == today.getYear() && endDate.getWeekOfYear() < today.getWeekOfYear())){
	%>
		<a href="<%=nextWeekHref%>" class="btn_arr_next js_space_tab_index"></a>
		<a href="<%=nextMonthHref %>" class="btn_arr_next2 js_space_tab_index"></a>
	<%
	} 
	%>

	<div class="option_section">
	<div class="option_section">
  		<span class="sel_date_section"><%=selectedWeekStr %><input type="hidden" class="js_space_datepicker" value="<%=selectedDateStr %>"><a href="space_tab_weekly.sw" class="btn_calendar js_space_datepicker_button"></a></span> 
		<select class="js_space_select_scope">
			<option value="space_tab_dayly.sw"><fmt:message key="space.title.tab_dayly"/></option>
			<option selected><fmt:message key="space.title.tab_weekly"/></option>
			<option value="space_tab_monthly.sw"><fmt:message key="space.title.tab_monthly"/></option>
		</select>
	</div>
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

				<%
				CompanyCalendar[] calendars = smartWorks.getCompanyCalendars(selectedWeekStart, selectedWeekEnd);
				LocalDate thisDate = new LocalDate(selectedWeekStart.getTime());
				for(int i=0; i<7 && thisDate.getTime() <= today.getTime(); i++){
					String titleClass = "title";
					if(calendars[i].isHoliday() || calendars[i].getDate().getDayOfWeek()==Calendar.SUNDAY) titleClass = "title t_sunday";
					else if(calendars[i].getDate().getDayOfWeek()==Calendar.SATURDAY) titleClass = "title t_saturday";
				%>
					<!-- 5일 -->					
					<div class="space_section margin_t10">
						<div class="<%=titleClass%>"><%=calendars[i].getDate().toLocalDateLongString() + calendars[i].toCompanyEventsString()%></div>
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
					<!-- 5일//-->
				<%
					thisDate = new LocalDate(selectedWeekStart.getTime() + LocalDate.ONE_DAY*i);
				}
				%>
				<!-- 10일 -->
				<div class="space_section margin_t10">
					<div class="title_off">
						<span class="t_saturday">12월 10일 토요일</span>
					</div>
					<ul>
						<li class="t_nowork">업무가 없습니다</li>
					</ul>
				</div>
				<!-- 10일//-->
			</div>
			<!-- 컨텐츠 //-->

		</ul>
	</div>
	<div class="portlet_b" style="display: block;"></div>
</div>
<!-- 컨텐츠 레이아웃//-->

<script type="text/javascript">
$.datepicker.setDefaults($.datepicker.regional[currentUser.locale]);
$('.js_space_datepicker').datepicker({
	defaultDate : new Date(),
	dateFormat : 'yy.mm.dd',
	onSelect: function(date) {
		var selectedDate = new Date(date);
		var today = new Date();
		if(selectedDate>today){
			smartPop.showInfo(smartPop.WARN, smartMessage.get('spaceOverDateSeleted'));
			return false;
		}
		var input = $(this);
		var target = input.parents('.js_space_instance_list');
		var url = input.next().attr('href');
		var startDate = new Date(selectedDate.toString());
		startDate.setDate(selectedDate.getDate() - 7*4);
		$.ajax({
			url : url,
			data : {
				startDate : startDate.format('yyyy.mm.dd'),
				selectedIndex : 4
			},
			success : function(data, status, jqXHR) {
				target.html(data);
			},
			error : function(xhr, ajaxOptions, thrownError){
			}
		});
	}
});

</script>
