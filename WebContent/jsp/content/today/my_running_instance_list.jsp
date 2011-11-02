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
	User cUser = SmartUtil.getCurrentUser();

	Instance[] instances = smartWorks.getMyRunningInstances();
%>

<!-- 나의 진행중인 업무 -->
<div id="section_portlet">
	<div class="portlet_t">
		<div class="portlet_tl"></div>
	</div>
	<div class="portlet_l" style="display: block;">
		<ul class="portlet_r" style="display: block;">
			<div id="work_ing">
				<ul>
					<li><span class="tit"><fmt:message
								key="content.my_running_instance_list" /> </span>
					<li class="nav_srch">
						<div class="srch">
							<input id="" class="input js_auto_complete" type="text"
								title="<fmt:message key="search.search_running_instance"/>"
								placeholder="<fmt:message key="search.search_running_instance"/>"
								href="running_instance_list.sw">
							<button title="<fmt:message key='search.search'/>" onclick=""></button>
						</div>
						<div style="display: none"></div>
					</li>
					<li>
						<ul>
							<jsp:include page="/jsp/content/today/more_instance_list.jsp" />
						</ul>
						<div class="js_more_list">
							<a href="more_instance_list.sw">더보기</a>
						</div></li>
				</ul>
			</div>
		</ul>
	</div>
	<div class="portlet_b" style="display: block;"></div>
</div>
<!-- 나의 진행중인 업무 //-->