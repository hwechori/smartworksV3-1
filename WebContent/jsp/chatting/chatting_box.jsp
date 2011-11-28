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
	<div class="top_group">

		<div class="top_area js_chatting_title"></div>

		<!-- 상단우측 아이콘-->
		<div class="txt_btn">
			<div class="ch_right btn_x">
				<a class="js_close_chatting_box" href=""><span> </span> </a>
			</div>

			<div class="ch_right btn_admin">
				<a href=""><span> </span> </a>
			</div>

			<div class="ch_right btn_min">
				<a href=""><span> </span> </a>
			</div>
		</div>
		<!-- 상단 우측 아이콘//-->

	</div>
	<!-- 상단 //-->

	<!-- Body -->
	<div class="chat_body js_chatting_message_list">
		<!-- 시스템 메세지-->
		<div class="js_chatter_status_list"></div>
		<!-- 시스템 메세지//-->

		<!-- 시스템 메세지-->
<!-- 		<div class="msg_section">
			<span class="ic_add_friend"></span>회원님이 <span class="t_name">김선아</span>님을
			추가하셨습니다
		</div>
 -->		<!-- 시스템 메세지//-->

		<!-- 친구 검색, 추가 -->
		<div class="addfriend_section">
			<div class="addf_line js_chatter_names">
				<div class="js_selected_chatters user_sel_area">
					<input class="js_auto_complete" href='chatter_name.sw'
						type="text" title=""
						placeholder="<fmt:message key='common.upload.event.related_users'/>">
					<div class='js_srch_x'></div>

				</div>
			</div>
			<a href="" class="js_add_chatters"><span class="btn_wh"> <span class="Btn01Start"></span> <span
				class="Btn01Center">추가</span> <span class="Btn01End"></span> </span></a>
		</div>
		
		<div class="js_chatter_list chatter_list_area" style="display: none"></div>
			<!-- 친구 검색, 추가//-->

			<!-- 채팅 내용 -->
			<div>
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
	<!-- 채팅 //-->