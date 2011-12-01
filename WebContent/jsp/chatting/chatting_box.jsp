<%@page import="net.smartworks.model.instance.info.InstanceInfo"%>
<%@page import="net.smartworks.model.instance.info.TaskInstanceInfo"%>
<%@page import="net.smartworks.model.community.info.UserInfo"%>
<%@page import="net.smartworks.model.instance.info.EventInstanceInfo"%>
<%@page import="net.smartworks.util.SmartUtil"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="net.smartworks.service.ISmartWorks"%>
<%@ page import="net.smartworks.model.community.*"%>
<%@ page import="net.smartworks.model.notice.*"%>
<%@ page import="net.smartworks.model.instance.*"%>
<%@ page import="net.smartworks.model.work.*"%>
<%@ page import="net.smartworks.util.LocalDate"%>
<%
	User cUser = SmartUtil.getCurrentUser(request, response);

	ISmartWorks smartWorks = (ISmartWorks) request.getAttribute("smartWorks");
%>
<!-- 채팅 -->
<div class="chat_section js_chatting_box" style="display: none">
	<!-- 상단 -->
	<div class="top_group js_chatting_header">

		<div class="top_area js_chatting_title"></div>

		<!-- 상단우측 아이콘-->
		<div class="txt_btn js_chatting_title_icons">
			<div class="ch_right btn_x">
				<a class="js_close_chatting_box" href=""><span> </span> </a>
			</div>

			<div class="ch_right btn_addf">
				<a class="js_admin_chatting_box" href=""><span> </span> </a>
			</div>

			<div class="ch_right btn_min">
				<a class="js_min_chatting_box" href=""><span> </span> </a>
			</div>
		</div>
		<!-- 상단 우측 아이콘//-->

	</div>
	<!-- 상단 //-->
	
	<div class="js_chatting_body">
	
		<!-- 친구 검색, 추가 -->
		<div class="js_chatters_search_box addfriend_section" style="display:none">
			<div class="addfriend_group js_chatter_names">
				<div class="addf_line">
					<div class="js_selected_chatters user_sel_area"></div>
					<input class="js_auto_complete" href='chatter_name.sw' type="text"
						title=""
						placeholder="<fmt:message key='common.upload.event.related_users'/>">
					<div class='js_srch_x'></div>
				</div>
				<a href="" class="js_add_chatters"><span class="btn_wh">
						<span class="Btn01Start"></span> <span class="Btn01Center">추가</span>
						<span class="Btn01End"></span> </span> </a>
			</div>

			<div class="js_chatter_list chatter_list_area" style="display: none"></div>
		</div>
		<!-- 친구 검색, 추가//-->
		
		<!-- 시스템 메세지-->
			<div class="js_chatter_status_list"></div>
		<!-- 시스템 메세지//-->
		
		
		<!-- 시스템 메세지-->
		<!-- <div class="msg_section">
			<span class="ic_add_friend"></span>회원님이 <span class="t_name">김선아</span>님을
			추가하셨습니다
		</div>-->
		<!-- 시스템 메세지//-->
		

		<!-- Body -->
		<div class="chat_body js_chatting_message_list">
			<!-- 채팅 내용 -->
			<div class="chat_list">
				<ul>
				</ul>
			</div>
			<!-- 채팅 내용// -->

		</div>
		<!-- Body //-->

		<!-- 입력영역 -->
		<div class="chat_input_section js_chat_input">
			<div class="chat_input_area">
				<textarea class="chat_textarea"></textarea>
			</div>
		</div>
		<!-- 입력영역 //-->
	</div>

</div>
<!-- 채팅 //-->