
<!-- Name 			: my_favorite_works.jsp				 					 -->
<!-- Description	: 현재사용자의 자주가는 업무들을 보여주는 화면  					 -->
<!-- Author			: Maninsoft, Inc.										 -->
<!-- Created Date	: 2011.9.												 -->

<%@page import="net.smartworks.util.SmartUtil"%>
<%@page import="net.smartworks.model.community.User"%>
<%@page import="net.smartworks.model.work.info.SmartWorkInfo"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="net.smartworks.service.ISmartWorks"%>
<%@ page import="net.smartworks.model.work.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	// 스마트웍스 서비스들을 사용하기위한 핸들러를 가져온다. 현재사용자 정보도 가져온다 
	ISmartWorks smartWorks = (ISmartWorks) request.getAttribute("smartWorks");
	User cUser = SmartUtil.getCurrentUser();

	// 서버에서 현재사용자의 자주가는 업무들을 가져온다...
	SmartWorkInfo[] works = smartWorks.getMyFavoriteWorks();
%>
<fmt:setLocale value="<%=cUser.getLocale() %>" scope="request" />
<fmt:setBundle basename="resource.smartworksMessage" scope="request" />

<ul>
	<%
	if (works != null) {
		for (SmartWorkInfo work : works) {
			%>
			<li class="fvrt_item js_favorite_works">
				<a href="<%=work.getController()%>?cid=<%=work.getContextId()%>" class="js_content" title="<%=work.getFullpathName()%>">
					<span class="<%=work.getIconClass()%>"></span>
					<span><%=work.getName()%></span>
				</a>
				<div class="check_option"><div title="<fmt:message key='common.button.delete'/>" class="js_check_favorite_work btn_im_x" workId="<%=work.getId() %>"></div></div>
			</li>
		<%
			}
		}
		%>
</ul>