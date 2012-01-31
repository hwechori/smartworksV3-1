<%@page import="net.smartworks.model.community.Group"%>
<%@page import="net.smartworks.model.community.Department"%>
<%@page import="net.smartworks.model.instance.info.TaskInstanceInfo"%>
<%@page import="net.smartworks.model.instance.TaskInstance"%>
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
	String contextStr;
	if(SmartUtil.isBlankObject(workSpace)) contextStr = "";
	else if(workSpace.getClass().equals(User.class)) contextStr = ISmartWorks.CONTEXT_USER_SPACE;
	else if(workSpace.getClass().equals(Department.class)) contextStr = ISmartWorks.CONTEXT_DEPARTMENT_SPACE;
	else if(workSpace.getClass().equals(Group.class)) contextStr = ISmartWorks.CONTEXT_GROUP_SPACE;

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
	
	String selectedMonthStr = "";
	LocalDate selectedMonth = null;
	
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
		LocalDate month = new LocalDate(startMonth.getTime());
		for(int i = 0; i<12; i++){
			LocalDate tempMonth = LocalDate.convertLocalMonthWithDiffMonth(month, i);
			if(i==selectedIndex){
				monthStr = tempMonth.toLocalMonthFullString();
				selectedMonthStr = tempMonth.toLocalMonthString();
				selectedMonth = new LocalDate(tempMonth.getTime());
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
			
				<%
				TaskInstanceInfo[][] tasksByWeeks = smartWorks.getTaskInstancesByWeeks(contextStr, workSpace.getId(), selectedMonth, 5); 
				LocalDate weekStart = new LocalDate(selectedMonth.getTime());
				LocalDate nextMonth = LocalDate.convertLocalMonthWithDiffMonth(selectedMonth, 1);
				WorkHourPolicy whp = smartWorks.getCompanyWorkHourPolicy();
				for(int i=0; i<6 && weekStart.getTime()<nextMonth.getTime() && weekStart.getTime() <= today.getTime(); i++){
					weekStart.setFirstDayOfWeek(whp.getFirstDayOfWeek());
					int weekEndDays = whp.getFirstDayOfWeek() - weekStart.getDayOfWeek();
					if(weekEndDays<=0) weekEndDays = weekEndDays + 6;
					else weekEndDays = weekEndDays-1;
					LocalDate weekEnd = new LocalDate(weekStart.getTime() + weekEndDays*LocalDate.ONE_DAY);
					if(weekEnd.getTime() > today.getTime()) weekEnd = new LocalDate(today.getTime());

					String weekTitle = SmartMessage.getString("space.title."+ (i+1) + "week");
					String titleClassStart = ((weekStart.getDayOfWeek()==Calendar.SUNDAY) ? "t_sunday" : (weekStart.getDayOfWeek()==Calendar.SATURDAY) ? "t_saturday" : "");
					String titleClassEnd = ((weekEnd.getDayOfWeek()==Calendar.SUNDAY) ? "t_sunday" : (weekEnd.getDayOfWeek()==Calendar.SATURDAY) ? "t_saturday" : "");
				%>
					<div class="space_section margin_t10">
						<%
						if(weekStart.getTime() == weekEnd.getTime()){
						%>
							<div class="title">
								<%=weekTitle%>(
								<span class="<%=titleClassStart %>"><%=weekStart.toLocalDateShortString() %></span>
								 )
							</div>
						<%
						}else{
						%>
							<div class="title">
								<%=weekTitle%>(
								<span class="<%=titleClassStart %>"><%=weekStart.toLocalDateShortString() %></span>
								 ~ 
								 <span class="<%=titleClassEnd %>"><%=weekEnd.toLocalDateShortString() %></span>
								 )
							</div>
						<%
						}
						%>
						<ul>
							<%
							if(!SmartUtil.isBlankObject(tasksByWeeks) && tasksByWeeks.length >i && !SmartUtil.isBlankObject(tasksByWeeks[i])){
								session.setAttribute("taskHistories", tasksByWeeks[i]);
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
				<%
					weekStart = new LocalDate(weekEnd.getTime() + LocalDate.ONE_DAY);
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
