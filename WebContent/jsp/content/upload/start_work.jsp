<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="net.smartworks.service.ISmartWorks"%>

<!-- 등록하기- 새업무 입력 폼-->
<div id="up_works">
	<div class="up_warp space js_start_work">
		<div class="up_form">
			<div class="up_point posit_works"></div>
			<input class="up js_auto_complete" id="" type="text" href="work_name_list.sw"
				placeholder="<fmt:message key='common.upload.message.work'/>">
		</div>
		<div class="btn" id="all_work_btn" style="right: 0;display:none">
			<a href=""> <span class="Btn01Start"></span> <span
				class="Btn01Center"><fmt:message key="common.upload.button.all_works"/></span> <span class="Btn01End"></span> </a>
		</div>
	</div>
	<div id="upload_work_list" style="display:none"></div>

	<div class="js_upload_form_detail" id="start_work_form" style="display: none">
	</div>
</div>

