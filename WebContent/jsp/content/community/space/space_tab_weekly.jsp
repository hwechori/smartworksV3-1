<%@page import="net.smartworks.model.community.Group"%>
<%@page import="net.smartworks.model.community.Department"%>
<%@page import="net.smartworks.model.instance.info.TaskInstanceInfo"%>
<%@page import="net.smartworks.model.instance.TaskInstance"%>
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
	String contextStr = null;
	if(SmartUtil.isBlankObject(workSpace)) contextStr = "";
	else if(workSpace.getClass().equals(User.class)) contextStr = ISmartWorks.CONTEXT_USER_SPACE;
	else if(workSpace.getClass().equals(Department.class)) contextStr = ISmartWorks.CONTEXT_DEPARTMENT_SPACE;
	else if(workSpace.getClass().equals(Group.class)) contextStr = ISmartWorks.CONTEXT_GROUP_SPACE;

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
				TaskInstanceInfo[][] tasksByDates = smartWorks.getTaskInstancesByDates(contextStr, workSpace.getId(), selectedWeekStart, selectedWeekEnd, 5); 

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
							<%
							if(!SmartUtil.isBlankObject(tasksByDates) && tasksByDates.length >i && !SmartUtil.isBlankObject(tasksByDates[i])){
								session.setAttribute("taskHistories", tasksByDates[i]);
							%>
								<jsp:include page="/jsp/content/community/space/space_task_histories.jsp"></jsp:include>
							<%
							}else{
							%>
								<li class="t_nowork"><fmt:message key="common.message.no_work_task"/></li>
							<%
							}
							%>											
						</ul>
					</div>
					<!-- 5일//-->
				<%
					thisDate = new LocalDate(selectedWeekStart.getTime() + LocalDate.ONE_DAY*(i+1));
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
