
<!-- Name 			: community_members.jsp										 	 -->
<!-- Description	: 좌측의 Navigation Bar 에서 커뮤너티공간인경우 멤버들을 보여주는 공간 	 -->
<!-- Author			: Maninsoft, Inc.												 -->
<!-- Created Date	: 2011.9.														 -->

<%@page import="net.smartworks.model.work.SmartWork"%>
<%@page import="net.smartworks.model.work.Work"%>
<%@page import="net.smartworks.model.community.info.DepartmentInfo"%>
<%@page import="net.smartworks.model.community.info.UserInfo"%>
<%@page import="net.smartworks.util.SmartUtil"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="net.smartworks.service.ISmartWorks"%>
<%@ page import="net.smartworks.model.community.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	// 스마트웍스 서비스들을 사용하기위한 핸들러를 가져온다. 현재사용자 정보도 가져온다 
	ISmartWorks smartWorks = (ISmartWorks) request.getAttribute("smartWorks");
	User cUser = SmartUtil.getCurrentUser();

	String cid = request.getParameter("cid");
	String wid = request.getParameter("wid");
	session.setAttribute("cid", cid);
	session.setAttribute("wid", wid);	
	WorkSpace workSpace = smartWorks.getWorkSpaceById(wid);
	
%>
<!--  다국어 지원을 위해, 로케일 및 다국어 resource bundle 을 설정 한다. -->
<fmt:setLocale value="<%=cUser.getLocale() %>" scope="request" />
<fmt:setBundle basename="resource.smartworksMessage" scope="request" />

<div class="navi_list noline" style="display:block">
	<div id="m_setting">
		<!-- 내부 메뉴 -->				
		<ul>
			<li>
				<%
				if(workSpace.getClass().equals(Group.class)){				
				%>
					<a href="<%=workSpace.getSpaceController() %>?cid=<%=workSpace.getSpaceContextId()%>" class="js_content"><span class="js_collapse_detail arr_off float_left"></span><span class="icon_user_space"><fmt:message key="space.title.group.all_items"/></span></a>
				<%
				}else if(workSpace.getClass().equals(Department.class)){				
				%>
					<a href="<%=workSpace.getSpaceController() %>?cid=<%=workSpace.getSpaceContextId()%>" class="js_content"><span class="js_collapse_detail arr_off float_left"></span><span class="icon_user_space"><fmt:message key="space.title.department.all_items"/></span></a>
				<%
				}
				%>
			</li>
		</ul>
		<ul style="display:none">
			<li><a href="<%=Work.CONTROLLER_WORK_LIST %>?cid=<%=ISmartWorks.CONTEXT_ALL_WORKS_LIST %>&wid=<%=workSpace.getId() %>" class="js_content"><span class="<%=Work.ICON_CLASS_ALL_WORKS%>"></span><span><fmt:message key="space.title.works"/></span></a></li>
			<li><a href="<%=Work.CONTROLLER_IMAGE_LIST %>?cid=<%=ISmartWorks.CONTEXT_PREFIX_IMAGE_LIST + SmartWork.ID_FILE_MANAGEMENT%>&wid=<%=workSpace.getId() %>" class="js_content"><span class="<%=Work.ICON_CLASS_IMAGE_WORKS%>"></span><span><fmt:message key="space.title.pictures"/></span></a></li>
			<li><a href="<%=Work.CONTROLLER_FILE_LIST %>?cid=<%=ISmartWorks.CONTEXT_PREFIX_FILE_LIST + SmartWork.ID_FILE_MANAGEMENT%>&wid=<%=workSpace.getId() %>" class="js_content"><span class="<%=Work.ICON_CLASS_FILE_WORKS%>"></span><span><fmt:message key="space.title.files"/></span></a></li>
			<li><a href="<%=Work.CONTROLLER_EVENT_LIST %>?cid=<%=ISmartWorks.CONTEXT_PREFIX_EVENT_LIST + SmartWork.ID_EVENT_MANAGEMENT%>&wid=<%=workSpace.getId() %>" class="js_content"><span class="<%=Work.ICON_CLASS_EVENT_WORKS%>"></span><span><fmt:message key="space.title.events"/></span></a></li>
			<li><a href="<%=Work.CONTROLLER_MEMO_LIST %>?cid=<%=ISmartWorks.CONTEXT_PREFIX_MEMO_LIST + SmartWork.ID_MEMO_MANAGEMENT%>&wid=<%=workSpace.getId() %>" class="js_content"><span class="<%=Work.ICON_CLASS_MEMO_WORKS%>"></span><spa><fmt:message key="space.title.memos"/></span></a></li>
			<li><a href="<%=Work.CONTROLLER_BOARD_LIST %>?cid=<%=ISmartWorks.CONTEXT_PREFIX_BOARD_LIST + SmartWork.ID_BOARD_MANAGEMENT%>&wid=<%=workSpace.getId() %>" class="js_content"><span class="<%=Work.ICON_CLASS_BOARD_WORKS%>"></span><spa><fmt:message key="space.title.boards"/></span></a></li>
		</ul>
		<!--내부메뉴//-->
	</div>
</div>
