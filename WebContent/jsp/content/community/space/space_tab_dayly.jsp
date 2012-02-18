<%@page import="net.smartworks.model.community.Group"%>
<%@page import="net.smartworks.model.community.Department"%>
<%@page import="net.smartworks.model.instance.info.MemoInstanceInfo"%>
<%@page import="net.smartworks.model.instance.info.ImageInstanceInfo"%>
<%@page import="net.smartworks.model.instance.info.FileInstanceInfo"%>
<%@page import="net.smartworks.model.instance.info.EventInstanceInfo"%>
<%@page import="net.smartworks.model.instance.info.BoardInstanceInfo"%>
<%@page import="net.smartworks.model.community.info.WorkSpaceInfo"%>
<%@page import="net.smartworks.model.instance.Instance"%>
<%@page import="net.smartworks.model.work.SocialWork"%>
<%@page import="net.smartworks.model.work.Work"%>
<%@page import="net.smartworks.model.work.SmartWork"%>
<%@page import="net.smartworks.model.instance.info.WorkInstanceInfo"%>
<%@page import="net.smartworks.model.instance.info.TaskInstanceInfo"%>
<%@page import="net.smartworks.model.instance.TaskInstance"%>
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
	String contextStr = null;
	if(SmartUtil.isBlankObject(workSpace)) contextStr = "";
	else if(workSpace.getClass().equals(User.class)) contextStr = ISmartWorks.CONTEXT_USER_SPACE;
	else if(workSpace.getClass().equals(Department.class)) contextStr = ISmartWorks.CONTEXT_DEPARTMENT_SPACE;
	else if(workSpace.getClass().equals(Group.class)) contextStr = ISmartWorks.CONTEXT_GROUP_SPACE;
	
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
	
	TaskInstanceInfo[][] tasksByWorkHours = smartWorks.getTaskInstancesByWorkHours(contextStr, workSpace.getId(), selectedCalendar.getDate(), 10); 
	
%>
<!--  다국어 지원을 위해, 로케일 및 다국어 resource bundle 을 설정 한다. -->
<fmt:setLocale value="<%=cUser.getLocale() %>" scope="request" />
<fmt:setBundle basename="resource.smartworksMessage" scope="request" />

<!--탭-->
<div class="tab js_space_tab_dayly_page" workSpaceId="<%=workSpace.getId() %>" startDate="<%=startDateStr%>">

	<%
	String prevWeekHref = "space_tab_dayly.sw?startDate=" 
			+ (new LocalDate(startDate.getTime()-LocalDate.ONE_DAY*7)).toLocalDateSimpleString()
			+ "&selectedIndex=0";
	String prevDayHref = "space_tab_dayly.sw?startDate=" 
			+ (new LocalDate(startDate.getTime()-LocalDate.ONE_DAY)).toLocalDateSimpleString()
			+ "&selectedIndex=0";
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
			+ "&selectedIndex=6";
	String nextWeekHref = "space_tab_dayly.sw?startDate="
			+ (new LocalDate(startDate.getTime()+LocalDate.ONE_DAY*7)).toLocalDateSimpleString()
			+ "&selectedIndex=6";
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
<div class="section_portlet js_space_dayly_page" contextId="<%=contextStr %>" spaceId="<%=workSpace.getId() %>" >
	<div class="portlet_t">
		<div class="portlet_tl"></div>
	</div>
	<div class="portlet_l" style="display: block;">
		<ul class="portlet_r" style="display: block;">

			<!-- 컨텐츠 -->
			<div class="contents_space">
			
				<%
				String toDateStr = (new LocalDate(selectedCalendar.getDate().getTime() + LocalDate.ONE_DAY)).toLocalDateString2();
				if(selectedCalendar.isHoliday() || selectedCalendar.getWorkHour().getWorkTime()==0){
					String dayTitle = SmartMessage.getString("common.title.holiday") + selectedCalendar.toCompanyEventsString();
				%>
					<!-- 휴일시간 -->
					<div class="space_section js_space_dayly_work_hour" toDate="<%=toDateStr%>">
	 					<div class="title"><%=dayTitle%></div>
						<ul>
							<%
							if(!SmartUtil.isBlankObject(tasksByWorkHours) && tasksByWorkHours.length ==1 && !SmartUtil.isBlankObject(tasksByWorkHours[0])){
								session.setAttribute("taskHistories", tasksByWorkHours[0]);
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
					<!-- 휴일시간 //-->
				<%
				}else{
					String workStartStr = (new LocalDate(selectedCalendar.getDate().getTime() + selectedCalendar.getWorkHour().getStart())).toLocalDateString2();
					String workEndStr = (new LocalDate(selectedCalendar.getDate().getTime() + selectedCalendar.getWorkHour().getEnd())).toLocalDateString2();
				%>				
					<!-- 근무시간 전 -->
					<div class="space_section  js_space_dayly_work_hour" toDate="<%=workStartStr%>">
	 					<div class="title"><fmt:message key="common.title.before_work"/>( ~ <%=LocalDate.convertTimeToString(selectedCalendar.getWorkHour().getStart())%>)</div>
						<ul>
							<%
							if(!SmartUtil.isBlankObject(tasksByWorkHours) && tasksByWorkHours.length==3 && !SmartUtil.isBlankObject(tasksByWorkHours[0])){
								session.setAttribute("taskHistories", tasksByWorkHours[0]);
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
					<!-- 근무시간 전//-->
	
					<!-- 근무시간 -->
					<div class="space_section margin_t10 js_space_dayly_work_hour" toDate="<%=workEndStr%>">
						<div class="title"><fmt:message key="common.title.work_hour"/>(<%=LocalDate.convertTimeToString(selectedCalendar.getWorkHour().getStart())%> ~ <%=LocalDate.convertTimeToString(selectedCalendar.getWorkHour().getEnd())%>)</div>
	
						<ul>
							<%
							if(!SmartUtil.isBlankObject(tasksByWorkHours) && tasksByWorkHours.length ==3 && !SmartUtil.isBlankObject(tasksByWorkHours[1])){
								session.setAttribute("taskHistories", tasksByWorkHours[1]);
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
					<!-- 근무시간//-->
	
					<!-- 근무시간 후 -->
					<div class="space_section margin_t10 js_space_dayly_work_hour" toDate="<%=toDateStr%>">
						<div class="title_off"><fmt:message key="common.title.after_work"/>(<%=LocalDate.convertTimeToString(selectedCalendar.getWorkHour().getEnd())%> ~ )</div>
						<ul>
							<%
							if(!SmartUtil.isBlankObject(tasksByWorkHours) && tasksByWorkHours.length ==3 && !SmartUtil.isBlankObject(tasksByWorkHours[2])){
								session.setAttribute("taskHistories", tasksByWorkHours[2]);
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
