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

<script type="text/javascript">
function receivedMessageOnChatId(message){
	var chatId = message.chatId;
	var senderInfo = message.senderInfo;
	var chatMessage = message.chatMessage;
	var currentTime = "09:21";
	var target = $('#'+chatId).find('div.js_chatting_message_list');
	if(message.msgType === msgType.JOINED_IN_CHAT){
		
	}else if(message.msgType === msgType.LEAVE_CHAT){
		
	}else if(message.msgType === msgType.WRITING_CHAT_MESSAGE){
		
	}else if(message.msgType === msgType.CHAT_MESSAGE){
		var data = "<li><div class='noti_pic'><img align='bottom' src='" + senderInfo.minPicture + "' title='" + senderInfo.longName + "'></div><div class='noti_in'><div>"
					+ chatMessage + "<span class='t_date' >" + currentTime + "</span></div></div></li>";
		target.find('ul').append(data);
	}
}
$('div.js_chatting_message_list textarea').live('keypress', function(e){
	if(e.keyCode == 13){
		var input = $(e.target);
		var chatId = input.parents('div.js_chatting_box:first').attr('id');
		var message = input.attr('value');
		if(message != null && message !== "" && message !== " "){
			smartTalk.publishChatMessage(chatId, message);
		}
		console.log(message);
		input.removeAttr('value');
		return false;
	}
});
</script>
<%
	User cUser = SmartUtil.getCurrentUser(request, response);

	ISmartWorks smartWorks = (ISmartWorks) request.getAttribute("smartWorks");
%>
<!-- 채팅 -->
<div class="chat_section js_chatting_list_box">
	<!-- 상단 -->
	<div class="top_group">

		<div class="top_area js_chatting_title"></div>

		<!-- 상단우측 아이콘-->
		<div class="txt_btn">
			<div class="po_right">
				<a href=""> <img class="btn_x"> </a>
			</div>

			<div class="po_right">
				<a href=""> <img class="btn_admin"> </a>
			</div>

			<div class="po_right">
				<a href=""> <img class="btn_min"> </a>
			</div>
		</div>
		<!-- 상단 우측 아이콘//-->

	</div>
	<!-- 상단 //-->
	
	<!-- Body -->
	<div class="chat_body js_chatting_message_list">
		<div>
			<ul>
			</ul>
		</div>

		<div class="chat_input_area">
			<textarea class="chat_textarea" name="txtaChatMessage" rows="2" cols=""></textarea>
		</div>
	</div>
	<!-- Body //-->


</div>
<!-- 채팅 //-->

