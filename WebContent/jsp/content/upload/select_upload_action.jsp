<%@page import="net.smartworks.util.SmartUtil"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="net.smartworks.service.ISmartWorks"%>
<%
	ISmartWorks smartWorks = (ISmartWorks) request
			.getAttribute("smartWorks");
	String cid = request.getParameter("cid");
	if (cid == null)
		cid = ISmartWorks.CONTEXT_HOME;
	String wid = request.getParameter("wid");
	if (wid == null)
		wid = SmartUtil.getCurrentUser().getId();
%>


<div id="upload" class="js_select_action">
	<div class="up_works up_icon_list">
		<a class="current" id="action_work" href=""><fmt:message
				key='common.upload.work' /> </a>
	</div>
	<div class="up_file up_icon_list">
		<a id="action_file" href="new_file.sw"><fmt:message
				key='common.upload.file' /> </a>
	</div>
	<div class="up_event up_icon_list">
		<a id="action_event" href="new_event.sw"><fmt:message
				key='common.upload.event' /> </a>
	</div>
	<div class="up_memo up_icon_list">
		<a id="action_memo" href="new_memo.sw"><fmt:message
				key='common.upload.memo' /> </a>
	</div>
	<div class="up_board up_icon_list">
		<a id="action_board" href="new_board.sw"><fmt:message
				key='common.upload.board' /> </a>
	</div>
</div>


<!-- 새업무 등록 -->
<div class="js_upload_form" id="action_work_box">
	<jsp:include page="/jsp/content/upload/start_work.jsp" />
</div>
<!-- 새업무 등록 //-->
<!-- 파일 올리기  -->
<div class="js_upload_form" id="action_file_box" style="display: none">
</div>
<!-- 파일 올리기  //-->
<!-- 이벤트 등록 -->
<div class="js_upload_form" id="action_event_box" style="display: none"></div>
<!-- 이벤트 등록 //-->
<!-- 메모 등록 -->
<div class="js_upload_form" id="action_memo_box" style="display: none">
</div>
<!-- 메모 등록 //-->
<!-- 공지 등록 -->
<div class="js_upload_form" id="action_board_box" style="display: none"></div>
<!-- 공지 등록 //-->

<!-- 등록하기//-->
