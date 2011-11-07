<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="net.smartworks.service.ISmartWorks"%>


<div id="up_file">
	<div class="up_warp space js_upload_input">
		<div class="up_form">
			<div class="up_point posit_file"></div>
			<input class="up" href="new_file.sw" targetId="start_new_file" type="text" title=""
				placeholder="<fmt:message key='common.upload.message.file'/>">
		</div>

		<div class="btn" style="right: 0">
			<a href=""> <span class="Btn01Start"></span> <span
				class="Btn01Center"><fmt:message key="common.button.attach_file"/></span> <span class="Btn01End"></span> </a>
		</div>
	</div>

	<div class="js_upload_form_detail" id="start_new_file">
	</div>
</div>
