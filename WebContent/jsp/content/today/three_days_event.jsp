<%@page import="net.smartworks.model.community.info.DepartmentInfo"%>
<%@page import="net.smartworks.model.community.info.GroupInfo"%>
<%@page import="net.smartworks.model.community.info.WorkSpaceInfo"%>
<%@page import="net.smartworks.model.community.info.UserInfo"%>
<%@page import="net.smartworks.model.instance.info.EventInstanceInfo"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="net.smartworks.service.ISmartWorks"%>
<%@ page import="net.smartworks.model.calendar.*"%>
<%@ page import="net.smartworks.util.*"%>
<%@ page import="net.smartworks.model.instance.*"%>
<%@ page import="net.smartworks.model.community.*"%>
<%
	ISmartWorks smartWorks = (ISmartWorks) request.getAttribute("smartWorks");
	User cUser = SmartUtil.getCurrentUser();
	String cid = request.getParameter("cid");
	if (cid == null)
		session.setAttribute("cid", ISmartWorks.CONTEXT_HOME);
	else
		session.setAttribute("cid", cid);
	String wid = request.getParameter("wid");
	if (wid == null)
		session.setAttribute("wid", cUser.getId());
	else
		session.setAttribute("wid", wid);

	CompanyCalendar[] threeDaysCC = smartWorks.getCompanyCalendars(new LocalDate(), 3);
	LocalDate today = threeDaysCC[0].getDate();
	LocalDate tomorrow = threeDaysCC[1].getDate();
	EventInstanceInfo[] events = smartWorks.getEventInstances(new LocalDate(), 10);
%>

<!-- 이벤트,공지 포틀릿 -->	
	 <div class="section_portlet">
	 <div class="portlet_t">
      <div class="portlet_tl"></div>
    </div>
        
    <div class="portlet_l" style="display: block;">
    <ul class="portlet_r" style="display: block;">
	
	<!-- Date -->
    <div class="date_section">
        <span class="date_start"></span>
        <span class="date_center">
            <span class="date"><%=today.toLocalDateString()%></span>
            <span class="t_red">
			 <%
			 	if (threeDaysCC[0].getCompanyEvents().length > 0) {
			 %> ( <%
			 	}
			 	CompanyEvent[] cesToday = threeDaysCC[0].getCompanyEvents();
			 	CompanyEvent[] cesTomorrow = threeDaysCC[1].getCompanyEvents();
			 	for (int i = 0; i < cesToday.length; i++) {
			 		if (i != 0) {
			 %>, <%
			 	}
			 %><%=cesToday[i].getName()%> <%
			 	}
			 %> <%
			 	if (threeDaysCC[0].getCompanyEvents().length > 0) {
			 %>)<%
			 	}
			 %>
			 </span> 
			 <%=today.toLocalTimeString()%>
        </span>
        <span class="date_end"></span>
    </div>
    <!-- Date //-->
	
	
			<!-- 이벤트 목록 영역 -->
			<div class="event_space">
				<ul>
					<%
						for (int cnt = 0; cnt < threeDaysCC.length; cnt++) {
					%>
					<li class="float_left">
						<div class="event">
							<div class="event_t">
								<div class="event_t_l"></div>
							</div>
							<div class="event_l" style="display: block;">
								<ul class="event_r" style="display: block;">
									<%
										if (cnt == 0) {
									%>
									<li class="line_dashed center"><span class="t_bold"><fmt:message
												key='content.threedays.today' /> </span> <%=today.toLocalDateShortString()%></li>
									<%
										} else if (cnt == 1) {
									%>
									<li class="line_dashed center"><span class="t_bold"><fmt:message
												key='content.threedays.tomorrow' /> </span> <%=tomorrow.toLocalDateShortString()%></li>
									<%
										} else if (cnt == 2) {
									%>
									<li class="line_dashed center"><span class="t_bold"><fmt:message
												key='content.threedays.after' /> </span>
									</li>
									<%
										}
									%>
									<li><span class="t_red"> <%
 	for (int i = 0; (cnt == 0) && (i < cesToday.length); i++) {
 			if (i != 0) {
 %>, <%
 	}
 %><%=cesToday[i].getName()%> <%
 	}
 %> <%
 	for (int i = 0; (cnt == 1) && (i < cesTomorrow.length); i++) {
 			if (i != 0) {
 %>, <%
 	}
 %><%=cesTomorrow[i].getName()%> <%
 	}
 %> </span>
									</li>
									<%
										if (events != null) {
												for (EventInstanceInfo event : events) {
													if (((cnt == 0) && today.isSameDate(event.getStart())) || ((cnt == 1) && tomorrow.isSameDate(event.getStart()))
															|| ((cnt == 2) && tomorrow.isAfterDate(event.getStart()))) {
														UserInfo owner = event.getOwner();
														String userContext = ISmartWorks.CONTEXT_PREFIX_USER_SPACE + owner.getId();
														String commContext = null;
														String targetContent = null;
														String eventContext = ISmartWorks.CONTEXT_PREFIX_EVENT_SPACE + event.getId();
														WorkSpaceInfo workSpace = event.getWorkSpace();
														if (workSpace != null && workSpace.getClass() == GroupInfo.class) {
															targetContent = "group_space.sw";
															commContext = ISmartWorks.CONTEXT_PREFIX_GROUP_SPACE + workSpace.getId();
														} else if (event.getWorkSpace() != null && workSpace.getClass() == DepartmentInfo.class) {
															targetContent = "department_space.sw";
															commContext = ISmartWorks.CONTEXT_PREFIX_DEPARTMENT_SPACE + workSpace.getId();
														}
														if (cnt < 2) {
									%>
									<li><span class="t_gbold"><%=event.getStart().toLocalTimeShortString()%></span>
										<%
											} else {
										%>
									
									<li><span class="t_gbold"><%=event.getStart().toLocalString()%></span>
										<%
											}
															if (!owner.getId().equals(cUser.getId())) {
										%> <span class="t_name"><a
											href="user_space.sw?cid=<%=userContext%>"><%=owner.getLongName()%></a>
									</span><span class="arr">▶</span> <%
 	}
 %> <%
 	if (!workSpace.getId().equals(owner.getId())) {
 %> <span class="ico_division_s"><a
											href="<%=targetContent%>?cid=<%=commContext%>"><%=workSpace.getName()%></a>
									</span> <%
 	}
 %><a
										href="event_space.sw?cid=<%=eventContext%>&wid=<%=workSpace.getId()%>"><%=event.getSubject()%></a>
									</li>
									<%
										}
												}
											}
									%>
								</ul>
							</div>
							<div class="event_b" style="display: block;"></div>
						</div></li>
					<%
						}
					%>
				</ul>
				<!-- 공지사항 -->
				<jsp:include page="/jsp/content/today/recent_board_list.jsp" />
				<!--공지사항//-->
			</div>
			<!-- 이벤트 목록 영역 //-->
		</ul>
	</div>
	<div class="portlet_b" style="display: block;"></div>
</div>
<!-- 이벤트,공지 포틀릿//-->
