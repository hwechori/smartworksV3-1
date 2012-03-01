
<!-- Name 			: my_all_works.jsp										 	 -->
<!-- Description	: 좌측의 Navigation Bar 의 나의 공간에서 전체업무를 보여주는 공간 	 -->
<!-- Author			: Maninsoft, Inc.											 -->
<!-- Created Date	: 2011.9.													 -->

<%@page import="net.smartworks.model.community.User"%>
<%@page import="net.smartworks.model.work.info.WorkInfo"%>
<%@page import="net.smartworks.util.SmartUtil"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="net.smartworks.service.ISmartWorks"%>
<%@ page import="net.smartworks.model.work.*"%>
<%
	// 스마트웍스 서비스들을 사용하기위한 핸들러를 가져온다.
	ISmartWorks smartWorks = (ISmartWorks) request.getAttribute("smartWorks");

	// 서버에 카테고리아이디(루트를 의미하는 "")를 가지고 하위의 모든 업무카테고리들을 가져온다... 
	WorkInfo[] workCategories = smartWorks.getMyAllWorksByCategoryId("");
%>

<ul>
	<%
	if(workCategories != null){
		for (WorkInfo workCategory : workCategories) {
	%>
			<!--  *** js_drill_down : sw_act_work.js에서 이클래스의 클릭이벤트를 받아서 트리구조르 드릴다운할수 있게 한다.. -->
			<li class="js_drill_down">
				<a href="my_worklist_by_category.sw" categoryId="<%=workCategory.getId()%>">
					<span class="<%=workCategory.getIconClass()%>"></span>
					<span class="nav_subtitl_area"><%=workCategory.getName()%></span>
				</a>
				<div class="menu_2dep js_drill_down_target" style="display: none"></div>
			</li>
	<%
		}
	}
	%>
</ul>
