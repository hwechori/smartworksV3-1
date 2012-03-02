
<!-- Name 			: community_members.jsp										 	 -->
<!-- Description	: 좌측의 Navigation Bar 에서 커뮤너티공간인경우 멤버들을 보여주는 공간 	 -->
<!-- Author			: Maninsoft, Inc.												 -->
<!-- Created Date	: 2011.9.														 -->

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
	String spaceId = SmartUtil.getSpaceIdFromContentContext(cid);
	
%>
<!--  다국어 지원을 위해, 로케일 및 다국어 resource bundle 을 설정 한다. -->
<fmt:setLocale value="<%=cUser.getLocale() %>" scope="request" />
<fmt:setBundle basename="resource.smartworksMessage" scope="request" />

<ul class="navi_tit_default">
	<li>
		<%
				if(SmartUtil.getSpaceIdFromContentContext(cid).equals(cUser.getId())){				
				%>
					<a href="user_space.sw?cid=<%=cid %>" class="js_content"><span class="js_collapse_detail arr_off"></span><fmt:message key="space.title.my.all_items"/></a>
				<%
				}else{				
				%>
					<a href="user_space.sw?cid=<%=cid %>" class="js_content"><span class="js_collapse_detail arr_off"></span><fmt:message key="space.title.user.all_items"/></a>
				<%
				}
				%>
	</li>
</ul>

<div class="navi_list" style="display:block">
	<div id="m_setting">
		<!-- 내부 메뉴 -->				
					<ul>
						<li><a href="space_work_list.sw?cid=<%=cid %>" class="js_content"><span class="ico_mywork"></span><span><fmt:message key="space.title.works"/></span></a></li>
						<li><a href="space_picture_list.sw?cid=<%=cid %>" class="js_content"><span class="ico_mypicture"></span><span><fmt:message key="space.title.pictures"/></span></a></li>
						<li><a href="space_file_list.sw?cid=<%=cid %>" class="js_content"><span class="ico_myfile"></span><span><fmt:message key="space.title.files"/></span></a></li>
						<li><a href="space_event_list.sw?cid=<%=cid %>" class="js_content"><span class="ico_myevent"></span><span><fmt:message key="space.title.events"/></span></a></li>
						<li><a href="space_memo_list.sw?cid=<%=cid %>" class="js_content"><span class="ico_mymemo"></span><spa><fmt:message key="space.title.memos"/></span></a></li>
					</ul>
		<!--내부메뉴//-->
	</div>
</div>
