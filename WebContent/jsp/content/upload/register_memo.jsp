<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="net.smartworks.service.ISmartWorks"%>


<div id="up_event">
	<div class="up_form js_upload_input">
		<div class="up_point posit_memo"></div>
		<div class="up_form" style="height: 65px; top: -1px">
			<textarea class="up up_textarea" href="new_memo.sw" targetId="start_new_memo" name="메모를 입력하세요!" cols="" rows="5" 
				placeholder="<fmt:message key='common.upload.message.memo'/>">
        </textarea>
		</div>
	</div>

	<div class="js_upload_form_detail" id="start_new_memo">
	</div>
</div>
<!-- 등록하기- 메모 입력 폼//-->
