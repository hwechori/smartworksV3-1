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
		<div class="form_wrap">
			<div class="form_title" class="js_file_brief_form">

				<textarea class="up_textarea" rows="5"
					placeholder="<fmt:message
						key="common.upload.message.file_desc" />">
					<fmt:message key="common.upload.message.file_desc" />
				</textarea>

				<div class="btn_gray padding_t5">
					<a href=""> <span class="Btn01Start"></span> <span
						class="Btn01Center"><fmt:message
								key='common.upload.button.find_file' /> </span> <span class="Btn01End"></span>
					</a>
				</div>

			</div>
			<div class="txt_btn txt_btn_height js_file_detail_form">
				<div>
					<a class="js_toggle_file_detail" href="file_detail_form.sw"><fmt:message
							key="common.upload.button.view_file_detail" /> </a>
				</div>
				<div style="display: none">
					<a class="js_toggle_file_detail" href=""><fmt:message
							key="common.upload.button.close_file_detail" /> </a>
				</div>
			</div>

			<div class="form_contents">
				<!-- 상세 정보 추가시 화면 -->
				<div id="file_detail" class='form_' style="display: none"></div>
				<!-- 상세 정보 추가시 화면 //-->
			</div>
			<!-- 하단 등록,취소 버튼 -->
			<jsp:include page="/jsp/content/upload/upload_buttons.jsp"></jsp:include>
			<!-- 하단 등록,취소 버튼 -->
		</div>
	</div>