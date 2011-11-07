<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="net.smartworks.service.ISmartWorks"%>


<div id="up_board">
	<div class="up_form up_size js_upload_input">
		<div class="up_point posit_event"></div>
		<input class="up" href="new_board.sw" targetId="start_new_board" type="text" value=""
			title="<fmt:message key='common.upload.message.board'/>"
			placeholder="<fmt:message key='common.upload.message.board'/>">
	</div>

	<div class="js_upload_form_detail" id="start_new_board">
	</div>
</div>
