<%@page import="net.smartworks.model.calendar.CompanyEvent"%>
<%@page import="net.smartworks.util.SmartMessage"%>
<%@page import="net.smartworks.model.calendar.WorkHourPolicy"%>
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
	int selectedIndex = SmartUtil.isBlankObject(selectedIndexStr) ? 6 : Integer.parseInt(selectedIndexStr);

	LocalDate startDate = new LocalDate(today.getTime()-LocalDate.ONE_DAY*6);
	String startDateStr = request.getParameter("startDate");
	if(!SmartUtil.isBlankObject(startDateStr)){
		LocalDate tempStartDate = LocalDate.convertLocalDateStringToLocalDate(startDateStr);
		if(tempStartDate.getTime()+LocalDate.ONE_DAY*6 < today.getTime()) startDate = new LocalDate(tempStartDate.getTime());
	}
	LocalDate endDate = new LocalDate(startDate.getTime()+LocalDate.ONE_DAY*6);
	LocalDate weekLaterDate = new LocalDate(endDate.getTime()+LocalDate.ONE_DAY*6);
	
	CompanyCalendar[] calendars = (!SmartUtil.isBlankObject(startDateStr) && startDateStr.equals((String)session.getAttribute("startDate")))
									? (CompanyCalendar[])session.getAttribute("calendars") : smartWorks.getCompanyCalendars(startDate, endDate);
	startDateStr = startDate.toLocalDateSimpleString();
	session.setAttribute("startDate", startDateStr);
	session.setAttribute("calendars", calendars);
	
	CompanyCalendar selectedCalendar = calendars[selectedIndex];
	WorkHourPolicy whp = smartWorks.getCompanyWorkHourPolicy();
	selectedCalendar.setWorkHour(whp.getWorkHour(selectedCalendar.getDate().getDayOfWeek()));
	
%>
<!--  다국어 지원을 위해, 로케일 및 다국어 resource bundle 을 설정 한다. -->
<fmt:setLocale value="<%=cUser.getLocale() %>" scope="request" />
<fmt:setBundle basename="resource.smartworksMessage" scope="request" />

<!--탭-->
<div class="tab js_space_tab_dayly_page" workSpaceId="<%=workSpace.getId() %>" startDate="<%=startDateStr%>">

	<%
	String prevWeekHref = "space_tab_dayly.sw?startDate=" 
			+ (new LocalDate(startDate.getTime()-LocalDate.ONE_DAY*7)).toLocalDateSimpleString()
			+ "selectedIndex=0";
	String prevDayHref = "space_tab_dayly.sw?startDate=" 
			+ (new LocalDate(startDate.getTime()-LocalDate.ONE_DAY)).toLocalDateSimpleString()
			+ "selectedIndex=0";
	%>
	<a href="<%=prevWeekHref %>" class="btn_arr_prev2 js_space_tab_index"></a> 
	<a href="<%=prevDayHref %>" class="btn_arr_prev js_space_tab_index"></a>

	<ul>
		<%
		String selectedDateStr = "";
		for(int i = 0; i<calendars.length; i++){
			String dateStr = (i==selectedIndex) 
								? calendars[i].getDate().toLocalDateString() : calendars[i].getDate().toLocalDateShortString();
			if(i==selectedIndex) selectedDateStr = calendars[i].getDate().toLocalDateSimpleString();
			String liClass = (i==selectedIndex) ? "current" : "";
			int dayOfWeek = calendars[i].getDate().getDayOfWeek();
			String spanClass = ((calendars[i].isHoliday() || dayOfWeek==Calendar.SUNDAY) ? "t_sunday" : (dayOfWeek==Calendar.SATURDAY) ? "t_saturday" : "");
 			String href = "space_tab_dayly.sw?startDate=" + startDateStr + "&selectedIndex=" + i; 
		%>
			<li class="<%=liClass%>"><span class="intab"><a class="js_space_tab_index" href="<%=href %>"><span class="<%=spanClass%>"><%=dateStr %></span></a></span></li>
		<%
		}
		%>
	</ul>
	<%
	String nextDayHref = "space_tab_dayly.sw?startDate=" 
			+ (new LocalDate(startDate.getTime()+LocalDate.ONE_DAY)).toLocalDateSimpleString()
			+ "selectedIndex=6";
	String nextWeekHref = "space_tab_dayly.sw?startDate="
			+ (new LocalDate(startDate.getTime()+LocalDate.ONE_DAY*7)).toLocalDateSimpleString()
			+ "selectedIndex=6";
	%>
	<%
	if(!endDate.isSameDate(today)){
	%>
		<a href="<%=nextDayHref%>" class="btn_arr_next js_space_tab_index"></a>
		<a href="<%=nextWeekHref %>" class="btn_arr_next2 js_space_tab_index"></a>
	<%
	} 
	%>

	<div class="option_section">
  		<span class="sel_date_section"><%=selectedDateStr%><input type="hidden" class="js_space_datepicker" value="<%=selectedDateStr%>"><a href="space_tab_dayly.sw" class="btn_calendar js_space_datepicker_button"></a></span> 
		<select class="js_space_select_scope">
			<option selected value="space_tab_dayly.sw?startDate=<%=selectedDateStr%>&selectedIndex=6"><fmt:message key="space.title.tab_dayly"/></option>
			<option value="space_tab_weekly.sw"><fmt:message key="space.title.tab_weekly"/></option>
			<option value="space_tab_monthly.sw"><fmt:message key="space.title.tab_monthly"/></option>
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
			
				<%
				if(selectedCalendar.isHoliday() || selectedCalendar.getWorkHour().getWorkTime()==0){
					String dayTitle = SmartMessage.getString("common.title.holiday") + selectedCalendar.toCompanyEventsString();
				%>
					<!-- 휴일시간 -->
					<div class="space_section">
	 					<div class="title"><%=dayTitle%></div>
						<ul>
							<li>
								<div class="det_title">
									<div class="noti_pic">
										<img src="../images/pic_size_48.jpg">
									</div>
									<div class="noti_in_m">
										<span class="t_name">Minashin</span><span class="arr">▶</span><span
											class="ico_division_s">마케팅/디자인팀</span>
										<div>회의록 내용 중 빠진 부분이나 수정할 사항이 있으시면 참석자 누구든 수정해주시기 바랍니다^^
											(메모는 타이틀 성격이 아니기 때문에 볼드가 안들어갑니다.)</div>
										<div>
											<span class="t_date"> 2011.10.13</span> <a href=""><span
												class="repl_write">댓글달기</span> </a>
										</div>
									</div>
								</div></li>
	
							<li>
								<div class="det_title">
									<div class="noti_pic">
										<img src="../images/pic_size_48_4.jpg">
									</div>
									<div class="noti_in_m">
										<span class="t_name">Minashin</span><span class="arr">▶</span><span
											class="ico_division_s">마케팅/디자인팀</span>
										<div>
											<img class="bu_file" /> <a href="">BT-case.ppt [678kb]</a> <strong>하반기
												마케팅 기획 및 B2B 마케팅 자료입니다</strong>
										</div>
										<div>관련 설명이 들어갑니다... 없으면 안나오구요~^^ 내용이 많으면
											줄바꿈됩니다...줄바꿔줄바꿔~~줄바꿔줄바꿔~~줄바꿔줄바꿔~~줄바꿔줄바꿔~~줄바꿔줄바꿔~~줄바꿔줄바꿔~~줄바꿔줄바꿔~~줄바꿔줄바꿔~~줄바꿔줄바꿔~~줄바꿔줄바꿔~~줄바꿔줄바꿔~~줄바꿔줄바꿔~~줄바꿔줄바꿔~~줄바꿔줄바꿔~~줄바꿔줄바꿔~~줄바꿔줄바꿔~~</div>
										<div>
											<span class="t_date"> 2011.10.13</span> <a href=""><span
												class="repl_write">댓글달기</span> </a>
										</div>
									</div>
								</div></li>
						</ul>
					</div>
					<!-- 휴일시간 //-->
				<%
				}else{
				%>				
					<!-- 근무시간 전 -->
					<div class="space_section">
	 					<div class="title"><fmt:message key="common.title.before_work"/>( ~ <%=LocalDate.convertTimeToString(selectedCalendar.getWorkHour().getStart())%>)</div>
						<ul>
							<li>
								<div class="det_title">
									<div class="noti_pic">
										<img src="../images/pic_size_48.jpg">
									</div>
									<div class="noti_in_m">
										<span class="t_name">Minashin</span><span class="arr">▶</span><span
											class="ico_division_s">마케팅/디자인팀</span>
										<div>회의록 내용 중 빠진 부분이나 수정할 사항이 있으시면 참석자 누구든 수정해주시기 바랍니다^^
											(메모는 타이틀 성격이 아니기 때문에 볼드가 안들어갑니다.)</div>
										<div>
											<span class="t_date"> 2011.10.13</span> <a href=""><span
												class="repl_write">댓글달기</span> </a>
										</div>
									</div>
								</div></li>
	
							<li>
								<div class="det_title">
									<div class="noti_pic">
										<img src="../images/pic_size_48_4.jpg">
									</div>
									<div class="noti_in_m">
										<span class="t_name">Minashin</span><span class="arr">▶</span><span
											class="ico_division_s">마케팅/디자인팀</span>
										<div>
											<img class="bu_file" /> <a href="">BT-case.ppt [678kb]</a> <strong>하반기
												마케팅 기획 및 B2B 마케팅 자료입니다</strong>
										</div>
										<div>관련 설명이 들어갑니다... 없으면 안나오구요~^^ 내용이 많으면
											줄바꿈됩니다...줄바꿔줄바꿔~~줄바꿔줄바꿔~~줄바꿔줄바꿔~~줄바꿔줄바꿔~~줄바꿔줄바꿔~~줄바꿔줄바꿔~~줄바꿔줄바꿔~~줄바꿔줄바꿔~~줄바꿔줄바꿔~~줄바꿔줄바꿔~~줄바꿔줄바꿔~~줄바꿔줄바꿔~~줄바꿔줄바꿔~~줄바꿔줄바꿔~~줄바꿔줄바꿔~~줄바꿔줄바꿔~~</div>
										<div>
											<span class="t_date"> 2011.10.13</span> <a href=""><span
												class="repl_write">댓글달기</span> </a>
										</div>
									</div>
								</div></li>
						</ul>
					</div>
					<!-- 근무시간 전//-->
	
					<!-- 근무시간 -->
					<div class="space_section margin_t10">
						<div class="title"><fmt:message key="common.title.work_hour"/>(<%=LocalDate.convertTimeToString(selectedCalendar.getWorkHour().getStart())%> ~ <%=LocalDate.convertTimeToString(selectedCalendar.getWorkHour().getEnd())%>)</div>
	
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
													class="repl_write">댓글달기</span> </a>
											</div>
	
											<!-- 댓글 -->
											<div class="replay_point posit_replay"></div>
											<div class="replay_section">
	
												<div class="list_replay">
													<ul>
														<li><img class="repl_tinfo"><a href=""><strong>7</strong>개의
																댓글 모두 보기</a></li>
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
					<!-- 근무시간//-->
	
					<!-- 근무시간 후 -->
					<div class="space_section margin_t10">
						<div class="title_off"><fmt:message key="common.title.after_work"/>(<%=LocalDate.convertTimeToString(selectedCalendar.getWorkHour().getEnd())%> ~ )</div>
					</div>
					<!-- 근무시간 후//-->
				<%
				}
				%>

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
		startDate.setDate(selectedDate.getDate() - 6);
		$.ajax({
			url : url,
			data : {
				startDate : startDate.format('yyyy.mm.dd'),
				selectedIndex : 6
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
