<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="net.smartworks.service.ISmartWorks"%>


<div id="up_event">
	<div class="up_form js_upload_input">
		<div class="up_point posit_memo"></div>
		<div class="up_form" style="height: 65px; top: -1px">
			<textarea class="up up_textarea" name="메모를 입력하세요!" cols="" rows="5" 
				placeholder="<fmt:message key='common.upload.message.memo'/>">
        </textarea>
		</div>
	</div>

	<div class="js_upload_form_detail" style="display: none">
		<jsp:include page="/jsp/content/upload/upload_buttons.jsp"></jsp:include>
		<!-- 하단 등록,취소 버튼 -->
	</div>
</div>
<!-- 등록하기- 메모 입력 폼//-->
