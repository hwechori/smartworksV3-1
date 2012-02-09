<%@page import="net.smartworks.model.work.SmartWork"%>
<%@page import="net.smartworks.model.work.InformationWork"%>
<%@page import="net.smartworks.model.community.User"%>
<%@page import="net.smartworks.util.SmartUtil"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="net.smartworks.service.ISmartWorks"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	// 스마트웍스 서비스들을 사용하기위한 핸들러를 가져온다. 현재사용자 정보도 가져온다..
	ISmartWorks smartWorks = (ISmartWorks) request.getAttribute("smartWorks");
	User cUser = SmartUtil.getCurrentUser();
	
	String cid = request.getParameter("cid");
	String workId = SmartUtil.getSpaceIdFromContentContext(cid);

	SmartWork work = (SmartWork) smartWorks.getWorkById(workId);
	boolean isEditable = (!work.isRunning() && !work.isEditing()); 

	session.setAttribute("cid", cid);
	session.removeAttribute("wid");
	session.setAttribute("smartWork", work);

%>
<fmt:setLocale value="<%=cUser.getLocale() %>" scope="request" />
<fmt:setBundle basename="resource.smartworksMessage" scope="request" />

<!-- 컨텐츠 레이아웃-->
    <div class="section_portlet js_smart_builder_space_page" workId="<%=workId%>" isEditable="<%=isEditable%>">
	<div class="portlet_t"><div class="portlet_tl"></div></div>
	<div class="portlet_l" style="display: block;">
		<ul class="portlet_r" style="display: block;">
			<!-- 타이틀 -->
			<div class="body_titl">
				<div class="body_titl_iworks title"><%=work.getName()%></div>
				<!-- 우측 버튼 -->
				<div class="txt_btn"><%=work.getFullpathName() %></div>
				<!-- 우측 버튼 //-->
				<div class="solid_line"></div>
			</div>
			<!-- 타이틀 -->

			<div class="define_space js_smart_workbench_editor" style="height:612px;"></div>

		<div class="portlet_b" style="display: block;"></div>
	</div> 
<!-- 컨텐츠 레이아웃//-->
<script type="text/javascript">
	var smartBuilderSpace = $('.js_smart_builder_space_page');
	var workId = smartBuilderSpace.attr("workId");
	var target = smartBuilderSpace.find('.js_smart_workbench_editor');
	loadSmartBuilder( target,{
		packageId : workId
	});
</script>
