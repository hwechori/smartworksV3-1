
<!-- Name 			: worklist_by_category.jsp										 	 		-->
<!-- Description	: 좌측의 Navigation Bar의 나의 공간에서 전체업무의 하위 카테고리의 업무들을 보여주는 공간 -->
<!-- Author			: Maninsoft, Inc.															-->
<!-- Created Date	: 2011.9.													 				-->

<%@page import="net.smartworks.util.SmartMessage"%>
<%@page import="net.smartworks.model.work.info.WorkCategoryInfo"%>
<%@page import="net.smartworks.util.SmartUtil"%>
<%@page import="net.smartworks.model.community.User"%>
<%@page import="net.smartworks.model.work.info.WorkInfo"%>
<%@page import="net.smartworks.model.work.info.SmartWorkInfo"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="net.smartworks.service.ISmartWorks"%>
<%@ page import="net.smartworks.model.work.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	// 스마트웍스 서비스들을 사용하기위한 핸들러를 가져온다.
	ISmartWorks smartWorks = (ISmartWorks) request.getAttribute("smartWorks");
	User cUser = SmartUtil.getCurrentUser();
	
	// 서버에서 전달된 카테고리아이디를 가지고 하위 카테고리와 업무들을 가져온다...
	WorkInfo[] works = smartWorks.getAllWorksByCategoryId(request.getParameter("categoryId"));
	String iconType = null, classType = "js_content", workContext = null, targetContent = null;
%>
<fmt:setLocale value="<%=cUser.getLocale() %>" scope="request" />
<fmt:setBundle basename="resource.smartworksMessage" scope="request" />

<ul>
	<%
	if (works != null) {
		for (WorkInfo work : works) {
			if(work.getProvidedBy() == Work.PROVIDED_BY_SYSTEM || work.getProvidedBy() == Work.PROVIDED_BY_APPSTORE) continue;
			workContext = ISmartWorks.CONTEXT_PREFIX_BUILDER_SPACE + work.getId();
			targetContent = "tab_workbench.sw";
			if (work.getType() == SmartWork.TYPE_PROCESS) {
				iconType = ((SmartWorkInfo)work).isRunning() ? "ico_pworks" : "ico_pworks_off";
			} else if (work.getType() == SmartWork.TYPE_INFORMATION) {
				iconType = ((SmartWorkInfo)work).isRunning() ? "ico_iworks" : "ico_iworks_off";
			} else if (work.getType() == SmartWork.TYPE_SCHEDULE) {
				iconType = ((SmartWorkInfo)work).isRunning() ? "ico_sworks" : "ico_sworks_off";
			} else if (work.getType() == WorkCategory.TYPE_CATEGORY) {
				iconType = ((WorkCategoryInfo)work).isRunning() ? "ico_gworks" : "ico_gworks_off";
				targetContent = "worklist_by_category.sw";
			}
			
			// 카테고리가 아닌경우는 업무이니, 클릭하면 업무목록공간으로 이동하게 한다...
			if (work.getType() != WorkCategory.TYPE_CATEGORY) {
	%>
				<li class="work_action_item">
					
					<a href="<%=targetContent%>?cid=<%=workContext%>" class="<%=classType%>">
						<span class="<%=iconType%>"></span><%=work.getName()%><span></span>
					</a>
					<%
					if(work.getProvidedBy()!=Work.PROVIDED_BY_SYSTEM){
						SmartWorkInfo smartWork = (SmartWorkInfo)work;
						String categoryId = (SmartUtil.isBlankObject(smartWork.getMyCategory())) ? "" : smartWork.getMyCategory().getId();
						String groupId = (SmartUtil.isBlankObject(smartWork.getMyGroup())) ? "" : smartWork.getMyGroup().getId();
						String workTypeName = "";
						if(work.getType() == SmartWork.TYPE_INFORMATION) workTypeName = SmartMessage.getString("common.title.information_work");
						else if(work.getType() == SmartWork.TYPE_PROCESS) workTypeName = SmartMessage.getString("common.title.process_work");
						else if(work.getType() == SmartWork.TYPE_SCHEDULE) workTypeName = SmartMessage.getString("common.title.schedule_work");
					%>
						<span class="work_action">
							<span title="<fmt:message key='builder.button.remove_work'/>" class="js_remove_work_definition btn_remove_work_de" workId="<%=work.getId() %>" workName="<%=smartWork.getFullpathName()%>"></span>
							<span title="<fmt:message key='builder.button.change_work'/>" class="js_change_work_definition btn_change_work_de" workId="<%=work.getId() %>" workName="<%=work.getName()%>" workTypeName="<%=workTypeName %>" workDesc="<%=work.getDesc()%>" categoryId="<%=categoryId%>" groupId="<%=groupId%>"></span>
						</span>
					<%
					}
					%>
					
				</li>
				
			<%
			
			// 카테고리인 경우에는 드릴다운하여 하위업무나 카테고리를 선택할수 있게 한다...
			} else {
			%>
				<!--  *** js_drill_down : sw_act_work.js에서 이클래스의 클릭이벤트를 받아서 트리구조르 드릴다운할수 있게 한다.. -->
				<li class="js_drill_down group_action_item">
					<a href="<%=targetContent%>" categoryId="<%=work.getId()%>">
						<span class="<%=iconType%>"></span><span><%=work.getName()%></span>
					</a>
					<%
					if(work.getProvidedBy()!=Work.PROVIDED_BY_SYSTEM){
					%>
						<span class="group_action">
							<span title="<fmt:message key='builder.button.remove_group'/>" class="js_remove_work_category btn_remove_work_ca" categoryId="<%=work.getId() %>" categoryName="<%=work.getName()%>"></span>
							<span title="<fmt:message key='builder.button.text_group'/>" class="js_text_work_category btn_text_work_ca" categoryId="<%=work.getId() %>" categoryName="<%=work.getName()%>" categoryDesc="<%=work.getDesc()%>"></span>
							<span title="<fmt:message key='builder.button.add_work'/>" class="js_add_work_definition btn_add_work_de" parentId="<%=work.getId() %>" parentName="<%=((WorkCategoryInfo)work).getFullPathName()%>"></span>
						</span>
					<%
					}
					%>
					<div class="js_drill_down_target" style="display: none"></div>
				</li>
	<%
			}
		}
	}
	%>
</ul>