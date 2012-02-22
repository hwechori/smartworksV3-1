
<!-- Name 			: my_all_works.jsp										 	 -->
<!-- Description	: 좌측의 Navigation Bar 의 나의 공간에서 전체업무를 보여주는 공간 	 -->
<!-- Author			: Maninsoft, Inc.											 -->
<!-- Created Date	: 2011.9.													 -->

<%@page import="net.smartworks.model.work.info.WorkCategoryInfo"%>
<%@page import="net.smartworks.model.community.User"%>
<%@page import="net.smartworks.model.work.info.WorkInfo"%>
<%@page import="net.smartworks.util.SmartUtil"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="net.smartworks.service.ISmartWorks"%>
<%@ page import="net.smartworks.model.work.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	// 스마트웍스 서비스들을 사용하기위한 핸들러를 가져온다.
	ISmartWorks smartWorks = (ISmartWorks) request.getAttribute("smartWorks");
	User cUser = SmartUtil.getCurrentUser();

	// 서버에 카테고리아이디(루트를 의미하는 "")를 가지고 하위의 모든 업무카테고리들을 가져온다... 
	WorkInfo[] workCategories = smartWorks.getAllWorksByCategoryId("");
%>

<!--  다국어 지원을 위해, 로케일 및 다국어 resource bundle 을 설정 한다. -->
<fmt:setLocale value="<%=cUser.getLocale() %>" scope="request" />
<fmt:setBundle basename="resource.smartworksMessage" scope="request" />

<ul>
	<%
	if(workCategories != null){
		for (WorkInfo workCategory : workCategories) {
			if(workCategory.getProvidedBy() == Work.PROVIDED_BY_SYSTEM || workCategory.getProvidedBy() == Work.PROVIDED_BY_APPSTORE) continue;
			String iconType = ((WorkCategoryInfo)workCategory).isRunning() ? "ico_cworks" : "ico_cworks_off";
	%>
			<!--  *** js_drill_down : sw_act_work.js에서 이클래스의 클릭이벤트를 받아서 트리구조르 드릴다운할수 있게 한다.. -->
			<li class="js_drill_down ctgr_action_item">
				<a href="worklist_by_category.sw" categoryId="<%=workCategory.getId()%>">
					<span class="<%=iconType%>"></span>
					<span class="nav_subtitl_area"><%=workCategory.getName()%></span>
				</a>
 				<%
				if(!((WorkCategoryInfo)workCategory).isRunning()){
				%>
					<span class="ctgr_action">
						<span title="<fmt:message key='builder.button.remove_category'/>" class="js_remove_work_category btn_im_x" categoryId="<%=workCategory.getId() %>" categoryName="<%=workCategory.getName()%>"></span>
						<span title="<fmt:message key='builder.button.text_category'/>" class="js_text_work_category btn_im_x" categoryId="<%=workCategory.getId() %>" categoryName="<%=workCategory.getName()%>" categoryDesc="<%=workCategory.getDesc()%>"></span>
						<span title="<fmt:message key='builder.button.add_work'/>" class="js_add_work_definition btn_im_x" parentId="<%=workCategory.getId() %>" parentName="<%=((WorkCategoryInfo)workCategory).getFullPathName()%>"></span>
					</span>
				<%
				}
				%>
				<div class="menu_2dep js_drill_down_target" style="display: none"></div>
			</li>
	<%
		}
	}
	%>
</ul>
