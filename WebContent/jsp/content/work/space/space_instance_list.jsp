
<!-- Name 			: iwork_space.jsp						 -->
<!-- Description	: 정보관리업무 인스턴스 공간을 표시하는 페이지    -->
<!-- Author			: Maninsoft, Inc.						 -->
<!-- Created Date	: 2011.9.								 -->

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
	
	String instId = request.getParameter("instId");
	String workId = request.getParameter("workId");
%>
<fmt:setLocale value="<%=cUser.getLocale() %>" scope="request" />
<fmt:setBundle basename="resource.smartworksMessage" scope="request" />
	
	<!-- 댓글 영역 -->
	<div class="gr_up_point posit_point"></div>
	<!-- 댓글 목록 -->
	<div class="gr_portlet">
		<div class="gr_portlet_t"><div class="gr_portlet_tl"></div></div>
    	<div class="gr_portlet_l" style="display: block;">
    		<ul class="gr_portlet_r" style="display: block;">
    	    
				<!-- 올리기 -->
				<div class="detail_up_wrap">
					<jsp:include page="/jsp/content/upload/select_upload_action.jsp">
						<jsp:param value="<%=ISmartWorks.SPACE_TYPE_WORK_INSTANCE %>" name="spaceType"/>
					</jsp:include>
				</div>
				<!-- 올리기 //-->
	    
				<!-- 목록시작 -->
				<div class="replay">
				    <ul>
					    <li class="dash_line">
					        <div class="det_title">
					            <div class="noti_pic"><img src="images/pic_size_29.jpg" alt="신민아" align="bottom"/></div>
					            <div class="noti_in">
					                <span class="t_name">Minashin</span><span class="arr">▶</span><span class="ico_division_s">마케팅/디자인팀</span><span class="t_date"> 2011.10.13</span>
					                <div>회의록 내용 중 빠진 부분이나 수정할 사항이 있으시면 참석자 누구든 수정해주시기 바랍니다^^</div>
					            </div>
					        </div>
					    </li>
					    <li>
					        <div class="det_title">
					            <div class="noti_pic"><img src="images/pic_size_29.jpg" alt="신민아" align="bottom"/></div>
					            <div class="noti_in">
					                <span class="t_name">Minashin</span><span class="arr">▶</span><span class="ico_division_s">마케팅/디자인팀</span><span class="t_date"> 2011.10.13</span>
					                <div>회의록 내용 중 빠진 부분이나 수정할 사항이 있으시면 참석자 누구든 수정해주시기 바랍니다^^</div>
					            </div>
					        </div>
					    </li>
					    <li class="end">
					        <div class="det_title">
					            <div class="noti_pic"><img src="images/pic_size_29.jpg" alt="신민아" align="bottom"/></div>
					            <div class="noti_in">
					                <span class="t_name">Minashin</span><span class="arr">▶</span><span class="ico_division_s">마케팅/디자인팀</span><span class="t_date"> 2011.10.13</span>
					                <div>회의록 내용 중 빠진 부분이나 수정할 사항이 있으시면 참석자 누구든 수정해주시기 바랍니다^^</div>
					            </div>
					        </div>
					    </li>
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
	    	<a href="" class="js_goto_iwork_list"> 
	    		<span class="Btn01Start"></span> 
	    		<span class="Btn01Center"><fmt:message key="common.button.list"/></span> 
	    		<span class="Btn01End"></span>
	    	</a>
		</div>
	</div>
	<!-- 목록 버튼//-->
