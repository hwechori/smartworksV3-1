
<!-- Name 			: worklist_by_category.jsp										 	 		-->
<!-- Description	: 좌측의 Navigation Bar의 나의 공간에서 전체업무의 하위 카테고리의 업무들을 보여주는 공간 -->
<!-- Author			: Maninsoft, Inc.															-->
<!-- Created Date	: 2011.9.													 				-->

<%@page import="net.smartworks.util.SmartUtil"%>
<%@page import="net.smartworks.model.community.User"%>
<%@page import="net.smartworks.model.work.info.WorkInfo"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="net.smartworks.service.ISmartWorks"%>
<%@ page import="net.smartworks.model.work.*"%>
<%
	// 스마트웍스 서비스들을 사용하기위한 핸들러를 가져온다.
	ISmartWorks smartWorks = (ISmartWorks) request.getAttribute("smartWorks");
	
	// 서버에서 전달된 카테고리아이디를 가지고 하위 카테고리와 업무들을 가져온다...
	WorkInfo[] works = smartWorks.getMyAllWorksByCategoryId(request.getParameter("categoryId"));
	String iconType = null, classType = "js_content", workContext = null, targetContent = null;
%>

<ul>
	<%
	if (works != null) {
		for (WorkInfo work : works) {
			if (work.getType() == SmartWork.TYPE_PROCESS) {
				iconType = "ico_pworks";
				workContext = ISmartWorks.CONTEXT_PREFIX_PWORK_LIST + work.getId();
				targetContent = "pwork_list.sw";
			} else if (work.getType() == SmartWork.TYPE_INFORMATION) {
				iconType = "ico_iworks";
				workContext = ISmartWorks.CONTEXT_PREFIX_IWORK_LIST + work.getId();
				targetContent = "iwork_list.sw";
			} else if (work.getType() == SmartWork.TYPE_SCHEDULE) {
				iconType = "ico_sworks";
				workContext = ISmartWorks.CONTEXT_PREFIX_SWORK_LIST + work.getId();
				targetContent = "swork_list.sw";
			} else if (work.getType() == WorkCategory.TYPE_CATEGORY) {
				iconType = "ico_gworks";
				targetContent = "worklist_by_category.sw";
			}
			
			// 카테고리가 아닌경우는 업무이니, 클릭하면 업무목록공간으로 이동하게 한다...
			if (work.getType() != WorkCategory.TYPE_CATEGORY) {
	%>
				<li>
					<a href="<%=targetContent%>?cid=<%=workContext%>" class="<%=classType%>">
						<span class="<%=iconType%>"></span><%=work.getName()%><span></span>
					</a>
				</li>
			<%
			
			// 카테고리인 경우에는 드릴다운하여 하위업무나 카테고리를 선택할수 있게 한다...
			} else {
			%>
				<!--  *** js_drill_down : sw_act_work.js에서 이클래스의 클릭이벤트를 받아서 트리구조르 드릴다운할수 있게 한다.. -->
				<li class="js_drill_down">
					<a href="<%=targetContent%>" categoryId="<%=work.getId()%>">
						<span class="<%=iconType%>"></span><span><%=work.getName()%></span>
					</a>
					<div style="display: none"></div>
				</li>
	<%
			}
		}
	}
	%>
</ul>