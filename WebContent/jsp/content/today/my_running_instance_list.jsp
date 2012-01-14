
<!-- Name 			: my_running_instance_list.jsp										 -->
<!-- Description	: 현재사용자에게 할당된 업무나, 현재사용자가 시작한 진행중인 업무들을 보여주는 화면 -->
<!-- Author			: Maninsoft, Inc.													 -->
<!-- Created Date	: 2011.9.															 -->

<%@page import="net.smartworks.model.instance.RunningCounts"%>
<%@page import="net.smartworks.util.SmartUtil"%>
<%@page import="net.smartworks.model.community.User"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="net.smartworks.service.ISmartWorks"%>
<%
	// 스마트웍스 서비스들을 사용하기위한 핸들러를 가져온다. 현재사용자 정보도 가져온다 
 	ISmartWorks smartWorks = (ISmartWorks) request.getAttribute("smartWorks");
	User cUser = SmartUtil.getCurrentUser();
 
	// 현재사용자의 진행중인 업무들의 갯수(전체업무, 할당업무)를 가져온다.
	RunningCounts runningCounts = smartWorks.getMyRunningInstancesCounts();
%>
<!--  다국어 지원을 위해, 로케일 및 다국어 resource bundle 을 설정 한다. -->
<fmt:setLocale value="<%=cUser.getLocale() %>" scope="request" />
<fmt:setBundle basename="resource.smartworksMessage" scope="request" />

<!-- 나의 진행중인 업무 -->
<div class="section_portlet js_my_running_instance_list_page">
	<div class="portlet_t"><div class="portlet_tl"></div></div>
	<div class="portlet_l" style="display: block;">
		<ul class="portlet_r" style="display: block;">
			<div id="work_ing">		
				<div class="titl_section">
				
					<!-- 타이틀을 나타내는 곳 -->
					<div class="tit padding_r10"><fmt:message key="content.my_running_instance_list" /></div>					
					<!-- 타이틀을 나타내는 곳 // -->
					
					<!-- 자동완성 검색창과 검색결과 리스트 공간 -->
					<div class="nav_srch padding_b2">
						<div class="srch_wh srch_wsize2">
							<input id="" class="nav_input js_auto_complete" type="text" title="<fmt:message key="search.search_running_instance"/>"
								placeholder="<fmt:message key="search.search_running_instance"/>" href="my_running_instance.sw">
							<button title="<fmt:message key='search.search'/>" onclick=""></button>
						</div>
						<div style="display: none"></div>
					</div>
					<!-- 자동완성 검색창과 검색결과 리스트 공간 //-->
					
					<!-- 전체/할당업무만의 갯수와 선택버튼들 -->
					<div class="txt_btn float_right js_instance_counts">
						<div class="po_right">
							<a href="" class="current js_view_my_running_instances" instanceCount="<%=runningCounts.getTotal()%>"><fmt:message key="content.my_running_instance_count"/> <span class="t_red_bold js_all_running_count">[<%=runningCounts.getTotal() %>]</span></a> | <a href="" class="js_view_assigned_instances" instanceCount="<%=runningCounts.getAssignedOnly()%>"><fmt:message key="content.my_running_assigned_count"/> <span class="t_red_bold js_assigned_count">[<%=runningCounts.getAssignedOnly() %>]</span></a>
						</div>
					</div>
					<!-- 전체/할당업무만의 갯수와 선택버튼들 //-->
					
				</div>
				
				<!-- 진행중인 업무목록 및 더보기 버튼 -->
				<div class="solid_line"></div>
				<table><jsp:include page="/jsp/content/today/more_instance_list.jsp" /></table>
				<!-- 진행중인 업무목록 및 더보기 버튼 //-->
				<!-- 더보기 버튼 -->
				<%if(runningCounts.getTotal() > 20){ %>
					<div class="js_more_list"><a href="more_instance_list.sw"><fmt:message key="content.more_running_instance"/></a></div>
				<%} %>
				<!-- 더보기 버튼 !!-->
	
			</div>
		</ul>
	</div>
	<div class="portlet_b" style="display: block;"></div>
</div>
<!-- 나의 진행중인 업무 //-->
