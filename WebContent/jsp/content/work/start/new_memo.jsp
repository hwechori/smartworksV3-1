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
	<div class="up_point posit_memo"></div>
	<div class="form_wrap up up_padding">


		<!-- 폼- 확장 -->
		<div class="form_title">
			<div>
				<textarea class="up_textarea" name="" cols="" rows="5" value="">
					<fmt:message key='common.upload.message.memo' />
				</textarea>
			</div>
		</div>
		<jsp:include page="/jsp/content/upload/upload_buttons.jsp"></jsp:include>

	</div>
</div>
