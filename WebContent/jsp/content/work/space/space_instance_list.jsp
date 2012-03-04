
<!-- Name 			: iwork_space.jsp						 -->
<!-- Description	: 정보관리업무 인스턴스 공간을 표시하는 페이지    -->
<!-- Author			: Maninsoft, Inc.						 -->
<!-- Created Date	: 2011.9.								 -->

<%@page import="net.smartworks.model.instance.info.InstanceInfo"%>
<%@page import="net.smartworks.util.LocalDate"%>
<%@page import="net.smartworks.model.instance.ProcessWorkInstance"%>
<%@page import="net.smartworks.model.instance.WorkInstance"%>
<%@page import="net.smartworks.model.instance.info.TaskInstanceInfo"%>
<%@page import="net.smartworks.model.instance.TaskInstance"%>
<%@page import="net.smartworks.model.work.InformationWork"%>
<%@page import="net.smartworks.model.community.WorkSpace"%>
<%@page import="net.smartworks.model.instance.InformationWorkInstance"%>
<%@page import="net.smartworks.model.work.Work"%>
<%@page import="net.smartworks.model.work.SmartWork"%>
<%@page import="net.smartworks.model.community.User"%>
<%@page import="net.smartworks.util.SmartUtil"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="net.smartworks.service.ISmartWorks"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	// 스마트웍스 서비스들을 사용하기위한 핸들러를 가져온다. 현재사용자 정보도 가져온다..
	ISmartWorks smartWorks = (ISmartWorks) request.getAttribute("smartWorks");
	User cUser = SmartUtil.getCurrentUser();

	WorkInstance workInstance = (WorkInstance)session.getAttribute("workInstance");
	
	InstanceInfo[] subInstances = smartWorks.getSpaceInstancesByDate(workInstance.getId(), new LocalDate(), 20);
	
%>
<fmt:setLocale value="<%=cUser.getLocale() %>" scope="request" />
<fmt:setBundle basename="resource.smartworksMessage" scope="request" />

<div class="js_space_instance_list_page"  contextId="<%=workInstance.getContextId() %>" spaceId="<%=workInstance.getId() %>">	
	<!-- 댓글 영역 -->
	<div class="gr_up_point posit_point"></div>
	<!-- 댓글 목록 -->
	<div class="gr_portlet">
		<div class="gr_portlet_t"><div class="gr_portlet_tl"></div></div>
    	<div class="gr_portlet_l" style="display: block;">
    		<ul class="gr_portlet_r" style="display: block;">
    	    
				<!-- 올리기 -->
				<div class="detail_up_wrap">
					<jsp:include page="/jsp/content/upload/select_upload_action.jsp"></jsp:include>
				</div>
				<!-- 올리기 //-->
	    
				<!-- 목록시작 -->
				<div class="replay">
				    <ul>
				    	<%
						if(!SmartUtil.isBlankObject(subInstances)){
							session.setAttribute("subInstances", subInstances);
						%>
							<jsp:include page="/jsp/content/work/space/space_sub_instances.jsp"></jsp:include>
						<%
						}else{
						%>
							<li class="t_nowork"><fmt:message key="common.message.no_work_task"/></li>
						<%
						}
						%>											
				    </ul>
				</div>
				<!-- 목록 끝 //-->

   		 	</ul>
    	</div>
    	<div class="gr_portlet_b" style="display: block;"></div>
    </div>
  	<!-- 댓글 목록 //-->
  
<!-- 댓글 영역 //-->

	<!-- 목록 버튼 -->
	<div class="" style=" text-align:center">
		<div class="btn_gray" >
	    	<a href="<%=workInstance.getWork().getController() %>?cid=<%=workInstance.getWork().getContextId() %>" class="js_content"> 
	    		<span class="Btn01Start"></span> 
	    		<span class="Btn01Center"><fmt:message key="common.button.list"/></span> 
	    		<span class="Btn01End"></span>
	    	</a>
		</div>
	</div>
	<!-- 목록 버튼//-->
</div>