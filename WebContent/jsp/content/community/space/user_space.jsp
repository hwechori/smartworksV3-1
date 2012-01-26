<%@page import="net.smartworks.model.community.User"%>
<%@page import="net.smartworks.util.SmartUtil"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="net.smartworks.service.ISmartWorks"%>
<%
	// 스마트웍스 서비스들을 사용하기위한 핸들러를 가져온다. 현재사용자 정보도 가져온다..
	ISmartWorks smartWorks = (ISmartWorks) request.getAttribute("smartWorks");
	User cUser = SmartUtil.getCurrentUser();
	
	String cid = request.getParameter("cid");
	String userId = SmartUtil.getSpaceIdFromContentContext(cid);

	User user = (cUser.getId().equals(userId)) ? cUser : smartWorks.getUserById(userId);

	session.setAttribute("cid", cid);
	session.removeAttribute("wid");
	session.setAttribute("user", user);
%>

<jsp:include page="/jsp/content/upload/select_upload_action.jsp"></jsp:include>

<jsp:include page="/jsp/content/community/space/tab_dayly.jsp"></jsp:include>