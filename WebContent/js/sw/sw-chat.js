

	function updateChattingBoxTitle(chatId, chatterInfos){
		var title = "";
		var chatterList = new Array();
		if (chatterInfos != null && chatterInfos.length > 0) {
			for ( var i = 0, j = 0; i < chatterInfos.length; i++) {
				if (chatterInfos[i].userId !== currentUser.userId)
					chatterList[j++] = chatterInfos[i];
			}
			title = chatterList[0].longName;
			if (chatterList.length > 2) {
				title = title + "외 " + (chatterList.length - 1) + "명";
			} else {
				for ( var i = 1; i < chatterList.length; i++) {
					title = title + "," + chatterList[i].longName;
				}
				title = title + "님";
			}
		}
		$('#'+chatId).find('div.js_chatting_title').html(title);
		
	}

	function startChattingWindow(message) {
		var chatId = message.chatId;
		var chatterInfos = message.chatterInfos;
		$.ajax({
			url : "chatting_box.sw",
			data : {},
			success : function(data, status, jqXHR) {
				var target = $('div.js_chatting_box_list');
				var chattingBox = $(data);
				chattingBox.attr("id", chatId);
				target.append(chattingBox);
				updateChattingBoxTitle(chatId, chatterInfos);
				for(var i=0; i<chatterInfos.length; i++)
					updateChatterStatus(chatId, chatterInfos[i], chatterInfos[i].status);
				chattingBox.slideDown(1000);
			}
		});
	}

	function receivedMessageOnChatId(message) {
		var chatId = message.chatId;
		var senderInfo = message.senderInfo;
		var chatMessage = message.chatMessage;
		var date = new Date();
		var currentTime = date.getMonth() + "." + date.getDate() + " " + date.getHours() + ":" + date.getMinutes();
		var target = $('#' + chatId).find('div.js_chatting_message_list');
		var data = "<li><div class='noti_pic'><img src='" + senderInfo.minPicture + "' title='" + senderInfo.longName + "'></div><div class='noti_in'><div>"
			+ chatMessage
			+ "<span class='t_date' >"
			+ currentTime
			+ "</span></div></div></li>";
		target.find('ul').append(data);
	}
	
	function writingStatusOnChatId(chatId, sender){
	}

	function updateChatterStatus(chatId, chatterInfo, status){
		var userId = chatterInfo.userId;
		var longName = chatterInfo.longName;
		var target = $('#'+chatId).find('div.js_chatter_status_list');
		var statusList = target.children();
		for(var i=0; i<statusList.length; i++ ){
			if($(statusList[i]).attr('userId') === userId){
				$(statusList[i]).remove();
			}
		}
		if(status === userStatus.ONLINE){
		}else if(status === userStatus.OFFLINE){
			var data  = "<div class='msg_section' userId='" + userId + "'><span class='t_name'>"
			+ longName + "</span>님은 오프라인이므로 쪽지로 보내집니다</div>";
			target.append(data);
		}		
	}

	$('#available_chatter_list a').live('click', function(e) {
		var input = $(e.target).parent('a');
		var userId = input.attr('userId');
		var img = input.find('img');
		var longName = img.attr('title');
		smartTalk.chattingRequest(new Array({
			userId : currentUserId,
			longName : currentUser.longName,
		}, {
			userId : userId,
			longName : longName,
		}));
		return false;
	});

	$('a.js_close_chatting_box').live('click', function(e){
		var input = $(e.target);
		input.parents('div.js_chatting_box:first').remove();
		return false;
	});

	$('a.js_add_chatters').live('click', function(e){
		var input = $(e.target);
		var chatId = input.parents('div.js_chatting_box:first').attr('id');
		var target = input.parents('a.js_add_chatters').siblings('div.js_chatter_names').children('div.js_selected_chatters');
		var chatterList = target.children('span.js_chatter_item');
		var chatterInfos = new Array();
		for(var i=0; i<chatterList.length; i++){
			var chatter = $(chatterList[i]);
			chatterInfos.push({userId : chatter.attr('comId'), longName : chatter.attr('comName')}); 
		}
		chatterList.remove();
		smartTalk.addJoinChatters(chatId, chatterInfos);
		return false;
	});

	$('div.js_chat_input textarea').live('keypress', function(e) {
		if (e.keyCode == 13) {
			var input = $(e.target);
			var chatId = input.parents('div.js_chatting_box:first').attr('id');
			var message = input.attr('value');
			if (message != null && message !== "" && message !== " ") {
				smartTalk.publishChatMessage(chatId, message);
			}
			input.removeAttr('value');
			return false;
		}
	});

	$('div.js_chat_input textarea').live('focusin', function(e) {		
		var input = $(e.target);
		var chatId = input.parents('div.js_chatting_box:first').attr('id');
		smartTalk.publishWritingStatus(chatId);
	});
	
	$('.js_select_chatter').live('click', function(e) {
		var input = $(e.target);
		var comName = input.attr('comName');
		var comId = input.attr('comId');
		var target = input.parents('div.js_chatter_list').siblings('div.js_selected_chatters');
		var oldHTML = target.html();
		if (oldHTML == null)
			oldHTML = "";
		var chatterItems = $(target).find('span.js_chatter_item');
		var isSameId = false;
		for(var i=0; i<chatterItems.length; i++){
			var oldComId = $(chatterItems[i]).attr('comId');
			if(oldComId !=null && oldComId === comId){
				isSameId = true;
				break;
			}
		}
		if(!isSameId){
			var newHTML = oldHTML
				+ "<span class='js_chatter_item user_select' comId='"
				+ comId
				+ "'>"
				+ comName
				+ "<span class='btn_x_gr'><a class='js_remove_chatter' href=''> x</a></span></span>";
			target.html(newHTML);
		}
		target.next().focus();
		return false;
	});

	$('.js_remove_chatter').live('click', function(e) {
		var input = $(e.target);
		var selected_users = input.parents('div.js_selected_chatters');
		input.parents('span.js_chatter_item').remove();
		selected_users.next().focus();
		return false;
	});
	