<%@page import="net.smartworks.util.LocalDate"%>
<%@page import="net.smartworks.model.instance.info.TaskInstanceInfo"%>
<%@page import="net.smartworks.util.SmartUtil"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="net.smartworks.service.ISmartWorks"%>
<%
	ISmartWorks smartWorks = (ISmartWorks) request.getAttribute("smartWorks");

	session.setAttribute("cid", ISmartWorks.CONTEXT_SMARTCASTER);
	session.removeAttribute("wid");
	
%>

<!-- 새업무, 사진, 파일, 이벤트... 을 올리는 화면 -->
<jsp:include page="/jsp/content/upload/select_upload_action.jsp" />
<!-- 새업무, 사진, 파일, 이벤트... 을 올리는 화면 //-->
<!-- 컨텐츠 레이아웃-->

<div class="section_portlet js_smartcaster_page">
	<div class="portlet_t">
		<div class="portlet_tl"></div>
	</div>
	<div class="portlet_l" style="display: block;">
		<ul class="portlet_r" style="display: block;">
			<jsp:include page="/jsp/content/more_smartcast.jsp"></jsp:include>
		</ul>
	</div>
	<div class="portlet_b" style="display: block;"></div>
</div>
<!-- 컨텐츠 레이아웃//-->
