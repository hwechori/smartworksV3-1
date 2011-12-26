<%@page import="net.smartworks.server.engine.common.util.CommonUtil"%>
<%@page import="net.smartworks.service.impl.SmartWorks"%>
<%@page import="net.smartworks.model.instance.FieldData"%>
<%@page import="net.smartworks.model.community.info.UserInfo"%>
<%@page import="net.smartworks.model.instance.info.IWInstanceInfo"%>
<%@page import="net.smartworks.model.instance.info.InstanceInfoList"%>
<%@page import="net.smartworks.model.instance.info.RequestParams"%>
<%@page import="net.smartworks.model.community.User"%>
<%@page import="net.smartworks.model.work.info.WorkInfo"%>
<%@page import="net.smartworks.util.SmartUtil"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="net.smartworks.service.ISmartWorks"%>
<%@ page import="net.smartworks.model.work.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	ISmartWorks smartWorks = (ISmartWorks) request.getAttribute("smartWorks");

	User cUser = SmartUtil.getCurrentUser();
%>
<fmt:setLocale value="<%=cUser.getLocale() %>" scope="request" />
<fmt:setBundle basename="resource.smartworksMessage" scope="request" />

<!--  전체 레이아웃 -->
<div class="pop_corner_all pop_section_500">

	<!-- 팝업 타이틀 -->
	<div class="form_title">
		<div class="pop_title">업무항목</div>

		<div class="txt_btn">
			<div class="btn_x">
				<a href="" onclick="$.modal.close();return false;">X</a>
			</div>
		</div>

		<div class="solid_line"></div>
	</div>
	<!-- 팝업 타이틀 //-->

	<jsp:include page="/jsp/popup/pop_iwork_instance_list.jsp"></jsp:include>
	
	<!-- 하단버튼영역 -->
	<div class="glo_btn_space">

		<div class="float_right">
			<span class="btn_gray"> <a onclick="$.modal.close();return false;" href=""> <span
					class="Btn01Start"></span> <span class="Btn01Center">닫기</span> <span
					class="Btn01End"></span> </a> </span>
		</div>

	</div>
	<!-- 하단버튼영역 //-->




</div>
<!-- 전체 레이아웃//-->
