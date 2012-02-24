<%@page import="net.smartworks.model.filter.info.SearchFilterInfo"%>
<%@page import="net.smartworks.model.work.ProcessWork"%>
<%@page import="net.smartworks.model.work.FormField"%>
<%@page import="net.smartworks.model.work.SmartForm"%>
<%@page import="net.smartworks.model.filter.SearchFilter"%>
<%@page import="net.smartworks.model.community.User"%>
<%@page import="net.smartworks.model.security.EditPolicy"%>
<%@page import="net.smartworks.model.security.WritePolicy"%>
<%@page import="net.smartworks.model.security.AccessPolicy"%>
<%@page import="net.smartworks.model.work.InformationWork"%>
<%@page import="net.smartworks.model.work.SmartWork"%>
<%@page import="net.smartworks.model.work.Work"%>
<%@page import="net.smartworks.util.SmartUtil"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="net.smartworks.service.ISmartWorks"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	ISmartWorks smartWorks = (ISmartWorks) request.getAttribute("smartWorks");
	String cid = request.getParameter("cid");
	String wid = request.getParameter("wid");
	session.setAttribute("cid", cid);
	session.setAttribute("wid", wid);
	
	String spaceId = SmartUtil.getSpaceIdFromContentContext(cid);
	User cUser = SmartUtil.getCurrentUser();

%>
<fmt:setLocale value="<%=cUser.getLocale() %>" scope="request" />
<fmt:setBundle basename="resource.smartworksMessage" scope="request" />

<jsp:include page="/jsp/content/upload/select_upload_action.jsp"></jsp:include>

<!-- 컨텐츠 레이아웃-->
<div class="section_portlet js_space_work_list_page js_event_list_page" spaceId="<%=spaceId%>">
	<div class="portlet_t"><div class="portlet_tl"></div></div>
	<div class="portlet_l" style="display: block;">
		<ul class="portlet_r" style="display: block;">

			<!-- 목록보기 -->
			<div class="contents_space js_calendar_space">
			</div>
		</ul>
	</div>
	<div class="portlet_b" style="display: block;"></div>
</div>
<!-- 컨텐츠 레이아웃//-->

<script type="text/javascript">
$(document).ready(function(){

	var timeOffset = (new Date()).getTimezoneOffset()/60 + parseInt(currentUser.timeOffset);
	var today = new Date();
	today.setTime(today.getTime() + timeOffset*60*60*1000);	

	var columnFormat =  {
		    month: 'dddd',    // Mon
		    week: 'ddd M/d', // Mon 9/7
		    day: 'dddd M/d'  // Monday 9/7
		};
	var titleFormat = {
		    month: 'MMMM yyyy',                             // September 2009
		    week: "MMM d[ yyyy]{ '&#8212;'[ MMM] d yyyy}", // Sep 7 - 13 2009
		    day: 'dddd, MMM d, yyyy'                  // Tuesday, Sep 8, 2009
		};
	var monthNames = ['January', 'February', 'March', 'April', 'May', 'June', 'July',
	                  'August', 'September', 'October', 'November', 'December']; 
	var monthNamesShort = ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun',
	                       'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec']; 
	var dayNames = ['Sunday', 'Monday', 'Tuesday', 'Wednesday',
	                'Thursday', 'Friday', 'Saturday'];
	var dayNamesShort = ['Sun', 'Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat'];
	if(currentUser.locale === 'ko'){
		columnFormat = {
			    month: 'dddd',    // Mon
			    week: 'M월d일 ddd', // Mon 9/7
			    day: 'M월d일 dddd'  // Monday 9/7				
		};
		titleFormat = {
			    month: 'yyyy년 MMMM',                             // September 2009
			    week: "yyyy년 MMM d일{ '&#8212;'[yyyy년][MMM] d일}", // Sep 7 - 13 2009
			    day: 'yyyy년 MMM d일 dddd'                  // Tuesday, Sep 8, 2009
			};
		monthNames = ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'];
		monthNamesShort = ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'];
		dayNames = ['일요일', '월요일', '화요일', '수요일', '목요일', '금요일', '토요일'];
		dayNamesShort = ['일', '월', '화', '수', '목', '금', '토'];
	}
	
	$('.js_calendar_space').fullCalendar({
		header: {
			left: 'prev,next today',
			center: 'title',
			right: 'month,agendaWeek,agendaDay'
		},
		editable: true,
		buttonText : {
		    today:    '오늘',
		    month:    '월',
		    week:     '주',
		    day:      '일'
		},
	    events: [
	             {
	                 title:  'My Event',
	                 start:   '2012-02-24T09:30:00',
	                 allDay: false
	             }
	         ],
		timeFormat: {
		    agenda: 'H:mm{ - H:mm}',
		    '': 'H(:mm)'
		},
		dayClick: function(date, allDay, jsEvent, view){
			
		},
		eventClick: function(event, jsEvent, view){
			
		},
		firstDay: 1,
		weekMode: 'liquid',
		columnFormat: columnFormat,
		titleFormat: titleFormat,
		monthNames : monthNames,
		monthNamesShort : monthNamesShort,
		dayNames : dayNames,
		dayNamesShort : dayNamesShort,
		allDayText : "종일행사",
		axisFormat : 'HH:mm',
		defaultEventMinutes : 30
	});	
});
</script>
