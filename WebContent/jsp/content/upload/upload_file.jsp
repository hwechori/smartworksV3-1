<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="net.smartworks.service.ISmartWorks"%>


<div id="up_file">
	<div class="up_warp space js_upload_input">
		<div class="up_form">
			<div class="up_point posit_file"></div>
			<input class="up" id="" type="text" title=""
				placeholder="<fmt:message key='common.upload.message.file'/>">
		</div>

		<div class="btn" style="right: 0">
			<a href=""> <span class="Btn01Start"></span> <span
				class="Btn01Center"><fmt:message key="common.button.attach_file"/></span> <span class="Btn01End"></span> </a>
		</div>
	</div>

	<div class="js_upload_form_detail" style="display: none">
		<div class="up_form" style="height: 65px;">
			<textarea class="up up_textarea" name="<fmt:message key="common.upload.message.file_desc"/>" cols=""
				rows="5" value="<fmt:message key="common.upload.message.file_desc"/>"><fmt:message key="common.upload.message.file_desc"/>
                </textarea>
		</div>

		<div class="txt_btn float_right">
			<div class="">
				<a href="" onclick="$(this).parent().parent().next('div').toggle();return false;"><fmt:message key="common.upload.button.file_detail"/></a>
			</div>
		</div>

		<!-- 상세 정보 추가시 화면 -->
		<div id="form_import" style="display:none">
			<jsp:include page="/jsp/content/work/form/file_detail_form.jsp"></jsp:include>
		</div>
		<!-- 상세 정보 추가시 화면 //-->

		<!-- 하단 등록,취소 버튼 -->
		<jsp:include page="/jsp/content/upload/upload_buttons.jsp"></jsp:include>
		<!-- 하단 등록,취소 버튼 -->
	</div>
</div>
