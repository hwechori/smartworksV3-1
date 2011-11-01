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
								key="content.my_running_instance_list" /></span>
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
					<%
					for(Instance instance : instances){
						String statusImage;
						String statusAlt;
						WorkInstance workInstance = (instance.getClass().equals(WorkInstance.class) ? (WorkInstance)instance : ((TaskInstance)instance).getWorkInstance());
						User owner = workInstance.getOwner();
						SmartWork work = (SmartWork)workInstance.getWork();
						if(instance.getStatus() == Instance.STATUS_RUNNING){
							statusImage = "images/ic_state_ing.jpg";
						}else if(instance.getStatus() == Instance.STATUS_DELAYED_RUNNING){
							statusImage = "images/ic_state_ing.jpg";
						}else if(instance.getStatus() == Instance.STATUS_RETURNED){
							statusImage = "images/ic_state_ing.jpg";
						}else if(instance.getStatus() == Instance.STATUS_RETURNED_DELAYED){
							statusImage = "images/ic_state_ing.jpg";
						}else{
							statusImage = "images/ic_state_ing.jpg";
						}
					%>
					<li class="working_br">
						<div class="pic">
							<img src="<%=statusImage %>" alt="진행중" /> <img
								src="<%=owner.getMidPicture()%>" alt="<%=owner.getLongName() %>" />
						</div>
						<div>
							<span class="t_name"><%=owner.getName()%></span>의 업무가 <span
								class="t_woname">대표이사 승인</span>을 기다리고 있습니다
						</div>
						<div>
							<span class="ico_iworks t_date"><%=work.getFullpathName() %></span> <span
								class="t_bold"><%=workInstance.getSubject() %></span>
						</div>
						<div>
							<span class="t_date"><%=workInstance.getLastModifiedDate().toLocalString() %></span>
						</div>
					</li>
					<%
					}
					%>
				</ul>
			</div>
		</ul>


	</div>
	<div class="portlet_b" style="display: block;"></div>
</div>
<!-- 나의 진행중인 업무 //-->