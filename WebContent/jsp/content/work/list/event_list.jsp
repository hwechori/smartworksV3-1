<%@page import="net.smartworks.server.engine.common.util.CommonUtil"%>
<%@page import="net.smartworks.model.report.ChartReport"%>
<%@page import="net.smartworks.model.report.info.ReportInfo"%>
<%@page import="net.smartworks.model.filter.info.SearchFilterInfo"%>
<%@page import="net.smartworks.model.report.Report"%>
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

<script type="text/javascript">
	getIntanceList = function(paramsJson, progressSpan, isGray){
		if(isEmpty(progressSpan))
			progressSpan = $('.js_work_list_title').find('.js_progress_span:first');
		if(isGray)
			smartPop.progressContGray(progressSpan);
		else
			smartPop.progressCont(progressSpan);
		console.log(JSON.stringify(paramsJson));
		var url = "set_instance_list_params.sw";
		$.ajax({
			url : url,
			contentType : 'application/json',
			type : 'POST',
			data : JSON.stringify(paramsJson),
			success : function(data, status, jqXHR) {
				$('#iwork_instance_list_page').html(data);
				smartPop.closeProgress();
			},
			error : function(xhr, ajaxOptions, thrownError) {
				smartPop.closeProgress();
				smartPop.showInfo(smartPop.ERROR, smartMessage.get('iworkListError'));
			}
		});
	};
	
	saveAsSearchFilter = function(filterId){
		var iworkList = $('.js_iwork_list_page');
		var searchFilter = $('.js_search_filter_page');
		var url = "set_iwork_search_filter.sw";
		if(isEmpty(filterId)){
			url = "create_iwork_search_filter.sw";
			searchFilter.find('input[name="txtNewFilterName"]').addClass('required');
		}

		if (!SmartWorks.GridLayout.validate(searchFilter.find('form.js_validation_required'), $('.js_filter_error_message'))) return;

		var paramsJson = {};
		var workId = iworkList.attr('workId');
		var searchFilters = searchFilter.find('form[name="frmSearchFilter"]');
		paramsJson['workId'] = workId;
		if(isEmpty(filterId)) {
			filterId = "";
		}
		paramsJson['txtNewFilterName'] = searchFilter.find('input[name="txtNewFilterName"]').attr('value');
		paramsJson['filterId'] = filterId;

		if(!isEmpty(searchFilters)){
			var searchFilterArray = new Array();
			for(var i=0; i<searchFilters.length; i++){
				var searchFilter = $(searchFilters[i]);
				//if(searchFilter.is(':visible'))
					searchFilterArray.push(searchFilter.serializeObject());
			}
			paramsJson['frmSearchFilters'] = searchFilterArray;
		}
		console.log(JSON.stringify(paramsJson));
		var progressSpan = searchFilter.find('span.js_progress_span:first');
		smartPop.progressCont(progressSpan);
		$.ajax({
			url : url,
			contentType : 'application/json',
			type : 'POST',
			data : JSON.stringify(paramsJson),
			success : function(data, status, jqXHR) {
				$('.js_search_filter_list_box:first').html(data);
				$('a.js_search_filter_close').click();
				smartPop.closeProgress();
				smartPop.showInfo(smartPop.INFORM, smartMessage.get('setFilterSucceed'));
			},
			error : function(xhr, ajaxOptions, thrownError) {
				smartPop.closeProgress();
				if(xhr.status == httpStatus.InternalServerError){
					var message = smartMessage.get(xhr.responseText);
					if(!isEmpty(message)){
						smartPop.showInfo(smartPop.ERROR, message);
						return;
					}
				}
				smartPop.showInfo(smartPop.ERROR, smartMessage.get('setFilterError'));
			}
		});
	};
	
	saveSearchFilter = function(){
		var searchFilter = $('.js_search_filter_page');
		var filterId = searchFilter.attr('filterId');
		saveAsSearchFilter(filterId);
	};

	selectListParam = function(progressSpan, isGray){
		var iworkList = $('.js_iwork_list_page');
		var forms = iworkList.find('form:visible');
		var paramsJson = {};
		var workId = iworkList.attr('workId');
		paramsJson["href"] = "jsp/content/work/list/iwork_instance_list.jsp?workId=" + workId;
		var searchFilters = iworkList.find('form[name="frmSearchFilter"]');
		for(var i=0; i<forms.length; i++){
			var form = $(forms[i]);
			if(form.attr('name') !== "frmSearchFilter" && !(!isEmpty(searchFilters) && form.attr('name') === "frmSearchInstance")){
				paramsJson[form.attr('name')] = mergeObjects(form.serializeObject(), SmartWorks.GridLayout.serializeObject(form));
			}
		}
		if(!isEmpty(searchFilters)){
			var searchFilterArray = new Array();
			for(var i=0; i<searchFilters.length; i++){
				var searchFilter = $(searchFilters[i]);
				if(searchFilter.is(':visible'))
					searchFilterArray.push(searchFilter.find(':visible').serializeObject());
			}
			paramsJson['frmSearchFilters'] = searchFilterArray;
		}
		if(isEmpty(progressSpan)) grogressSpan = iworkList.find('.js_search_filter_page').next('span.js_progress_span:first');
		getIntanceList(paramsJson, progressSpan, isGray);		
	};
</script>
<%
	ISmartWorks smartWorks = (ISmartWorks) request.getAttribute("smartWorks");
	String cid = request.getParameter("cid");
	String wid = request.getParameter("wid");
	session.setAttribute("cid", cid);
	session.setAttribute("wid", wid);
	
	String workId = SmartUtil.getSpaceIdFromContentContext(cid);
	User cUser = SmartUtil.getCurrentUser();
	InformationWork work = (InformationWork) smartWorks.getWorkById(workId);
	session.setAttribute("smartWork", work);
	session.removeAttribute("workInstance");
%>
<fmt:setLocale value="<%=cUser.getLocale() %>" scope="request" />
<fmt:setBundle basename="resource.smartworksMessage" scope="request" />

<!-- 컨텐츠 레이아웃-->
<div class="section_portlet js_event_list_page js_work_list_page" workId=<%=work.getId()%> workSpaceId="<%=wid%>">
	<div class="portlet_t"><div class="portlet_tl"></div></div>
	<div class="portlet_l" style="display: block;">
		<ul class="portlet_r" style="display: block;">

			<!-- 타이틀 -->
			<div class="body_titl">
				<div class="body_titl_iworks title"><%=work.getName()%></div>
				<!-- 우측 버튼 -->
				<div class="txt_btn">
				</div>
				<div class="solid_line"></div>
			</div>
			<!-- 타이틀 -->

			<!-- 목록영역  -->
			<div class="contents_space">
				<div>
					<jsp:include page="/jsp/content/work/report/work_report.jsp">
						<jsp:param value="<%=work.getLastReportId() %>" name="reportId"/>
					</jsp:include>
				</div>

				<!-- 목록보기 -->
				<div>
					<!-- 목록보기 타이틀-->
					<div class="list_title_space js_work_list_title margin_t15">
						<div class="title"><fmt:message key="common.title.instance_list" /></div>
						<div class="titleLineBtns">
							<div class="btnIconsEdit">
								<a href="search_filter.sw?workId=<%=workId%>" class="js_edit_search_filter btnIconsTail"><fmt:message key='filter.button.edit_search_filter' /></a>
							</div>
							<div class="btnIconsCreate">
								<a href="new_iwork.sw?workId=<%=workId%>" class="js_create_new_work btnIconsTail" workId="<%=workId%>"><fmt:message key="common.button.add_new_event"/></a>
							</div>
							<div class="btnIconsExcel">
								<a href="" class="btnIconsTail">이벤트 가져오기</a>
							</div>
						</div>
					
						<div class="titleLineOptions">
							<form name="frmSearchInstance" class="po_left">
								<span class="js_progress_span"></span>
								<div class="srch_wh srch_wsize">
									<input name="txtSearchInstance" class="nav_input" type="text" placeholder="<fmt:message key='search.search_instance' />">
										<button title="<fmt:message key='search.search_instance'/>" onclick="selectListParam($('.js_work_list_title').find('.js_progress_span:first'), false);return false;"></button>
								</div>
							</form>
							<form class="form_space po_left js_form_filter_name" name="frmIworkFilterName">
								<select name="selFilterName" class="js_select_search_filter">
									<option value="<%=SearchFilter.FILTER_ALL_INSTANCES%>" 
										<%if(SmartUtil.isBlankObject(work.getLastFilterId()) || SearchFilter.FILTER_ALL_INSTANCES.equals(work.getLastFilterId())){%> selected <%} %>>
										<fmt:message key='filter.name.all_instances' />
									</option>
									<option value="<%=SearchFilter.FILTER_MY_INSTANCES%>"
										<%if(SearchFilter.FILTER_MY_INSTANCES.equals(work.getLastFilterId())){%> selected <%} %>>
										<fmt:message key='filter.name.my_instances' />
									</option>
									<option value="<%=SearchFilter.FILTER_RECENT_INSTANCES%>"
										<%if(SearchFilter.FILTER_RECENT_INSTANCES.equals(work.getLastFilterId())){%> selected <%} %>>
										<fmt:message key='filter.name.recent_instances' />
									</option>
									<option value="<%=SearchFilter.FILTER_MY_RECENT_INSTANCES%>"
										<%if(SearchFilter.FILTER_MY_RECENT_INSTANCES.equals(work.getLastFilterId())){%> selected <%} %>>
										<fmt:message key='filter.name.my_recent_instances' />
									</option>
									<%
									SearchFilterInfo[] filters = work.getSearchFilters();
									if (filters != null) {
										for (SearchFilterInfo filter : filters) {
											if(SmartUtil.isBlankObject(filter.getId())) continue;
									%>
											<option value="<%=filter.getId()%>" <%if(filter.getId().equals(work.getLastFilterId())){%> selected <%} %>><%=CommonUtil.toNotNull(filter.getName())%></option>
									<%
										}
									}
									%>
								</select>
							</form>
						</div>
					</div>
					<!-- 목록보기 타이틀-->

					<!-- 상세필터 및 새업무등록하기 화면 -->
					<div id="search_filter" class="filter_section js_new_work_form"></div>
					<!-- 상세필터 -->

					<!-- 목록 테이블 -->
					<div class="list_contents">
						<table>
							<tr class="tit_bg" style="height:2px"></tr>
							<tr class="js_calendar_space"></tr>
						</table>
					</div>
					<!-- 목록 테이블 //-->
				</div>
				<!-- 목록 보기 -->
			</div>
			<!-- 목록영역 // -->
		</ul>
	</div>
	<div class="portlet_b" style="display: block;"></div>
</div>
<!-- 컨텐츠 레이아웃//-->

<script type="text/javascript">
$(document).ready(function(){

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
		    today:   smartMessage.get('todayText'),
		    month:    smartMessage.get('monthText'),
		    week:     smartMessage.get('weekText'),
		    day:      smartMessage.get('dayText')
		},
	    events: function(start, end, callback) {
	        $.ajax({
	            url: 'get_events_by_dates.sw',
	            data: {
	            	workSpaceId: $('.js_event_list_page').attr('workSpaceId'),
	            	fromDate: start.format('yyyy.mm.dd'),
	            	toDate: end.format('yyyy.mm.dd')
	            },
	            success: function(data) {
	                var events = [];
	                var eventInstances = data.events;
 	                if(!isEmpty(eventInstances)){
		                for(var i=0; i<eventInstances.length; i++){
		                	var event = eventInstances[i];
		                	var ownerHtml = "";
	                		ownerHtml = event.ownerPicture + '&' + event.ownerName + '&';

	                		events.push({
			                 	id: event.id,
			            		title: ownerHtml + event.name,
			                	start: new Date(event.start),
			                 	end: new Date(event.end),
			                 	allDay: false,
			                 	editable: (event.ownerId === currentUser.userId) ? true : false,
			                  	url: ""
			            	});
		                }
	                }
 					callback(events);
	            }
	        });
	    },
		timeFormat: {
		    agenda: 'H:mm{ - H:mm}',
		    '': 'H(:mm)'
		},
		dayClick: function(date, allDay, jsEvent, view){
			smartPop.createEvent(date);
		},
		eventClick: function(event, jsEvent, view){
			
		},
	    eventRender: function(event, element) {
	    	var title = $(element).find('.fc-event-title');
	    	var titleText = title.html();
	    	var tokens = titleText.split('&amp;');
	    	var titleHtml = (tokens.length==3) ? '<img class="profile_size_s" src="' + tokens[0] + '" title="' + tokens[1] + '"/>  ' +  tokens[2] : tokens[0]; 
	    	title.html(titleHtml);
	    },
		firstDay: 1,
		weekMode: 'liquid',
		columnFormat: columnFormat,
		titleFormat: titleFormat,
		monthNames : monthNames,
		monthNamesShort : monthNamesShort,
		dayNames : dayNames,
		dayNamesShort : dayNamesShort,
		allDayText : smartMessage.get('wholeDayText'),
		axisFormat : 'HH:mm',
		aspectRatio : 1.8,
		defaultEventMinutes : 30
	});	
});
</script>
