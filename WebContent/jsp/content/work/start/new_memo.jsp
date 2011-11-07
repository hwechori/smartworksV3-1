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

<div id="up_memo">
	<div class="up_form">
		<div class="up_form">
			<div class="up_point posit_memo"></div>
			<input class="up" type="text" value=""
				title="<fmt:message key='common.upload.message.memo'/>"
				placeholder="<fmt:message key='common.upload.message.memo'/>">
		</div>
	</div>

	<div class="up_form" style="height: 65px; top: -1px">
		<textarea class="up up_textarea" cols="" rows="5"
			placeholder="<fmt:message key='common.upload.message.memo'/>">
        	</textarea>
	</div>
	<jsp:include page="/jsp/content/upload/upload_buttons.jsp"></jsp:include>
	<!-- 하단 등록,취소 버튼 -->
</div>
