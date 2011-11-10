<%@page import="net.smartworks.model.work.SmartWork"%>
<%@page import="net.smartworks.model.work.Work"%>
<%@page import="net.smartworks.util.SmartUtil"%>
<%@page import="net.smartworks.util.SmartTest"%>
<%@page import="net.smartworks.model.community.User"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="net.smartworks.service.ISmartWorks"%>
<%
	ISmartWorks smartWorks = (ISmartWorks) request.getAttribute("smartWorks");
	User cUser = SmartUtil.getCurrentUser();
%>
<fmt:setLocale value="<%=cUser.getLocale() %>" scope="request" />
<fmt:setBundle basename="resource.smartworksMessage" scope="request" />

<div class="up_wrap">
	<div class="up_point posit_file"></div>
	<div class="up up_padding">
		<!-- 폼- 확장 -->
		<div id="form_wrap">
			<div class="js_file_brief_form">
				<div class="up_form textarea_size">
					<textarea class="up up_textarea" rows="5"
						placeholder="<fmt:message
						key="common.upload.message.file_desc" />"><fmt:message
						key="common.upload.message.file_desc" /></textarea>
				</div>

				<div class="btn_space">
					<input type="file" name="">
				</div>
			</div>
			<div class="txt_btn js_file_detail_form">
				<div>
					<a class="js_toggle_file_detail" href="file_detail_form.sw"><fmt:message
							key="common.upload.button.view_file_detail" /> </a>
				</div>
				<div style="display: none">
					<a class="js_toggle_file_detail" href=""><fmt:message
							key="common.upload.button.close_file_detail" /> </a>
				</div>
			</div>

			<!-- 상세 정보 추가시 화면 -->
			<div id="file_detail" style="display: none"></div>
			<!-- 상세 정보 추가시 화면 //-->
		</div>

		<!-- 하단 등록,취소 버튼 -->
		<jsp:include page="/jsp/content/upload/upload_buttons.jsp"></jsp:include>
		<!-- 하단 등록,취소 버튼 -->
	</div>
</div>