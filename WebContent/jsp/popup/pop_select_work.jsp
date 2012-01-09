<%@page import="net.smartworks.model.community.User"%>
<%@page import="net.smartworks.model.work.info.WorkInfo"%>
<%@page import="net.smartworks.util.SmartUtil"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="net.smartworks.service.ISmartWorks"%>
<%@ page import="net.smartworks.model.work.*"%>
<%
	ISmartWorks smartWorks = (ISmartWorks) request.getAttribute("smartWorks");
%>
<!--  전체 레이아웃 -->
<div class="pop_corner_all">

	<!-- 팝업 컨텐츠 -->
	<div class="form_contents">
		<div class="user_list_area">
			<jsp:include page="/jsp/popup/pop_worklist_by_category.jsp"></jsp:include>
		</div>
	</div>
	<!-- 팝업 컨텐츠 //-->
</div>
<!-- 전체 레이아웃//-->