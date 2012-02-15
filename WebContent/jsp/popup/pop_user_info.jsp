<%@page import="net.smartworks.service.impl.SmartWorks"%>
<%@page import="net.smartworks.server.engine.common.util.CommonUtil"%>
<%@page import="net.smartworks.model.KeyMap"%>
<%@page import="net.smartworks.util.LocalDate"%>
<%@page import="net.smartworks.util.LocaleInfo"%>
<%@page import="net.smartworks.model.community.User"%>
<%@page import="net.smartworks.util.SmartUtil"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="net.smartworks.service.ISmartWorks"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	ISmartWorks smartWorks = (ISmartWorks) request.getAttribute("smartWorks");
	User cUser = SmartUtil.getCurrentUser();

	User user = smartWorks.getUserById(request.getParameter("userId"));
%>
<script type="text/javascript">
</script>

<fmt:setLocale value="<%=cUser.getLocale() %>" scope="request" />
<fmt:setBundle basename="resource.smartworksMessage" scope="request" />


<!--  전체 레이아웃 -->
<div class="up_point posit_file"></div>
<div class="pop_corner_all smart_userinfo_section">

	<!-- 팝업 컨텐츠 -->
	<div class="pop_contents">
		<img src="<%=cUser.getOrgPicture() %>" class="profile_size_110 float_left">
		<div class="pop_notice_section">
			<div><%=cUser.getDepartment() %> <span class="smartp_name">cUser.getLongName()</span></div>
			<div class="smartp_info">상세정보</div>
		</div>
	</div>
	<!-- 팝업 컨텐츠 //-->

	<!-- 하단버튼영역 -->
	<div class="smartp_btn_space">
		<div class="float_right">
			<a href=""><span class="pop_ico_mail"></span></a>
			<a href=""><span class="pop_ico_message"></span></a>
			<a href=""><span class="pop_ico_chat"></span></a>
		</div>
	</div>
	<!-- 하단버튼영역 //-->
</div>
<!-- 전체 레이아웃//-->
