<%@page import="net.smartworks.model.instance.info.InstanceInfo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="net.smartworks.model.work.SmartWork"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="net.smartworks.service.ISmartWorks"%>
<%@ page import="net.smartworks.model.calendar.*"%>
<%@ page import="net.smartworks.util.*"%>
<%@ page import="net.smartworks.model.instance.*"%>
<%@ page import="net.smartworks.model.community.*"%>
<%
	ISmartWorks smartWorks = (ISmartWorks) request.getAttribute("smartWorks");
	User cUser = SmartUtil.getCurrentUser(request, response);

	InstanceInfo[] instances = smartWorks.getMyRunningInstances(cUser.getCompanyId(), cUser.getId());
%>

<!-- 나의 진행중인 업무 -->
<div class="section_portlet">
	<div class="portlet_t">
		<div class="portlet_tl"></div>
	</div>
	<div class="portlet_l" style="display: block;">
		<ul class="portlet_r" style="display: block;">
			<div id="work_ing">
		
			<div class="titl_section">
				<div class="tit padding_r10">
				<fmt:message
									key="content.my_running_instance_list" />
				</div>
				
				<div class="txt_btn float_left">
					<div class="po_left"><a href="">전체 <span class="t_red_bold">[10]</a></span> | <a href="">할당업무만 <span class="t_red_bold">[4]</a></span></div>
				</div>
				
				<!-- 검색 -->
				<div class="nav_srch padding_b2">
				<div class="srch">
						<input id="" class="input js_auto_complete" type="text"
							title="<fmt:message key="search.search_running_instance"/>"
							placeholder="<fmt:message key="search.search_running_instance"/>"
							href="my_running_instance.sw">
						<button title="<fmt:message key='search.search'/>" onclick=""></button>
				</div>
				<!-- 검색 //-->
				
				<div style="display: none"></div>
				</div>
				
				<div class="txt_btn float_right"><a href="">시간순▼</a></div>
				
			</div>
			
			<!-- 라인  -->
			<div class="solid_line"></div>
			
						<ul>
							<jsp:include page="/jsp/content/today/more_instance_list.jsp" />
						</ul>
						<div class="js_more_list">
							<a href="more_instance_list.sw">더보기</a>
						</div>
			</div>
		</ul>
	</div>
	<div class="portlet_b" style="display: block;"></div>
</div>
<!-- 나의 진행중인 업무 //-->
