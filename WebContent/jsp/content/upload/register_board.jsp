<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="net.smartworks.service.ISmartWorks"%>


<div id="up_board">
	<div class="up_form up_size js_upload_input">
		<div class="up_point posit_event"></div>
		<input class="up" id="" type="text"
			title="<fmt:message key='common.upload.message.board'/>"
			placeholder="<fmt:message key='common.upload.message.board'/>">
	</div>

	<div class="js_upload_form_detail" style="display: none">
		<div class="up_form" style="height: 65px;">
			<textarea class="up up_textarea" cols="" rows="5"
				placeholder="<fmt:message key='common.upload.message.board'/>">
			</textarea>
		</div>
		<!-- 하단 등록,취소 버튼 -->
		<jsp:include page="/jsp/content/upload/upload_buttons.jsp"></jsp:include>
	</div>
</div>
