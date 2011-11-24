<%@page import="net.smartworks.util.SmartUtil"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="net.smartworks.service.ISmartWorks"%>
<%
	ISmartWorks smartWorks = (ISmartWorks) request.getAttribute("smartWorks");
	String cid = request.getParameter("cid");
	if (cid == null)
		cid = ISmartWorks.CONTEXT_HOME;
	String wid = request.getParameter("wid");
	if (wid == null)
		wid = SmartUtil.getCurrentUser(request, response).getId();
%>


<div id="upload" class="js_select_action">
	<div class="up_works up_icon_list">
		<a class="current" href="start_work.sw"><fmt:message key='common.upload.work' />
		</a>
	</div>
	<div class="up_file up_icon_list">
		<a href="new_file.sw"><fmt:message key='common.upload.file' /> </a>
	</div>
	<div class="up_event up_icon_list">
		<a href="new_event.sw"><fmt:message key='common.upload.event' />
		</a>
	</div>
	<div class="up_memo up_icon_list">
		<a href="new_memo.sw"><fmt:message key='common.upload.memo' /> </a>
	</div>
	<div class="up_board up_icon_list">
		<a href="new_board.sw"><fmt:message key='common.upload.board' />
		</a>
	</div>
</div>


<!-- 등록하기 -->
<div class="js_upload_form" id="upload_form_box">
	<jsp:include page="/jsp/content/upload/start_work.jsp" />
</div>
<!-- 등록하기//-->
