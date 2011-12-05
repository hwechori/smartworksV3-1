var serverUrl = "http://localhost:8000";
var swContext = "/faye";
var currentUserId = currentUser.userId;
var userStatus = {
	ONLINE : "online",
	OFFLINE : "offline",
	LEAVED : "leaved"
};

var swSubject = {
	SMARTWORKS : "/smartworks",
	COMPANYID : "/" + currentUser.companyId,
	USERID : "/" + currentUser.userId.replace(/\./g, '_'),
	BROADCASTING : "/broadcasting",
	FAYESERVER : "/fayeServer",
	ONLINE : "/online",
	OFFLINE : "/offline",
	ALL : "/*"
};

var msgType = {
	BROADCASTING : "BCAST",
	NOTICE_COUNT : "NCOUNT",
	CHAT_REQUEST : "CHATREQ",
	JOIN_CHAT : "JOINCHAT",
	JOINED_IN_CHAT : "JOINEDCHAT",
	LEAVE_CHAT : "LEAVECHAT",
	CHAT_MESSAGE : "CHATTING",
	WRITING_CHAT_MESSAGE : "WRITING",
	CHATTERS_INVITED : "CHTSINVITED",
	AVAILABLE_CHATTERS : "ACHATTERS"
};

var smartMsgClient = null;

var chatManager = {
	//
	// chatList[] : {
	//		chatId,
	//		subscription,
	//		users[] : {
	//			userId,
	//			longName,
	//			minPicture,
	//			status,
	//			onlineSub,
	//			offlineSub,
	//			}
	//		}
	//
	chatList : new Array(),
	chatById : function(chatId) {
		for ( var i = 0; i < chatManager.chatList.length; i++)
			if (chatManager.chatList[i].chatId === chatId)
				return chatManager.chatList[i];
		return null;
	},
	removeChat : function(chatId){
		for(var i=0; i<chatManager.chatList.length; i++){
			if(chatManager.chatList[i].chatId === chatId){
				chatManager.chatList.splice(i,1);
				break;
			}
		}
		return chatManager.chatList;
	},	
	removeChatter : function(chatId, chatter){
		var chat = chatManager.chatById(chatId);
		if(!chat) return;
		var users = chat.users;
		for(var i=0; i<users.length; i++){
			if(users[i].userId === chatter){
				users.splice(i,1);
				break;
			}
		}
		return users;
	},	
	updateChatStatus : function(userId, status) {
		var chatListFound = new Array();
		for ( var i = 0; i < chatManager.chatList.length; i++) {
			for ( var j = 0; j < chatManager.chatList[i].users.length; j++) {
				if (chatManager.chatList[i].users[j].userId === userId && chatManager.chatList[i].users[j].status !== status) {
					chatManager.chatList[i].users[j].status = status;
					chatListFound.push(chatManager.chatList[i]);
					continue;
				}
			}
		}
		return chatListFound;
	},
	chatterInfosOnline : function(chatId) {
		var chat = chatManager.chatById(chatId);
		var chatterInfos = new Array();
		if(!chat) return chatterInfos;
		for ( var i = 0; i < chat.users.length; i++)
			if (chat.users[i].status === userStatus.ONLINE)
				chatterInfos.push({userId : chat.users[i].userId, longName : chat.users[i].longName, status : chat.users[i].status});				
		return chatterInfos;
	},
	chatterInfos : function(chatId) {
		var chat = chatManager.chatById(chatId);
		var chatterInfos = new Array();
		if(!chat) return chatterInfos;
		for ( var i = 0; i < chat.users.length; i++)
			chatterInfos.push({userId : chat.users[i].userId, longName : chat.users[i].longName, status : chat.users[i].status});				
		return chatterInfos;
	},
	chatterInfo : function(chatId, userId) {
		var chat = chatManager.chatById(chatId);
		if(!chat) return null;
		for ( var i = 0; i < chat.users.length; i++)
			if(chat.users[i].userId === userId)
				return {userId : chat.users[i].userId, longName : chat.users[i].longName, status : chat.users[i].status};
		return null;
	},
	chatters : function(userId){
		var chatters = new Array();
		for(var i=0; i<chatManager.chatList.length; i++){
			users = chatManager.chatList[i].users;
			for(var j=0; j<users.length; j++){
				if(users[j].userId === userId)
					chatters.push(users[j]);
			}
		}
		return chatters;
	},
	
	onlineSub : function(userId){
		chatters = chatManager.chatters(userId);
		for(var i=0; i<chatters.length; i++){
			if(chatters[i].onlineSub != null) return chatters[i].onlineSub;
		}
		return null;
	},
	
	offlineSub : function(userId){
		chatters = chatManager.chatters(userId);
		for(var i=0; i<chatters.length; i++){
			if(chatters[i].offlineSub != null) return chatters[i].offlineSub;
		}
		return null;
	},
	
	isSameChat : function(chatterInfos){
		for(var i=0; i<chatManager.chatList.length; i++){
			var users = chatManager.chatList[i].users;
			if(users.length == chatterInfos.length){
				for(var j=0; j<users.length; j++){
					for(var k=0; k<chatterInfos.length; k++){
						if(users[j].userId === chatterInfos[k].userId)
							break;
					}
					if(k==chatterInfos.length) break;
				}
				if(j==users.length) return true;
			}
		}
		return false;
	}
};

var smartTalk = {
	myChannel : function(subject) {
		return swSubject.SMARTWORKS + swSubject.COMPANYID + subject;
	},
	
	init : function() {
		var fayeContext = serverUrl + swContext;
		var reconnect = function() {
			console.log("creating Client!!");
			smartMsgClient = new Faye.Client(fayeContext, {
				timeout : 5
			});
//			smartMsgClient.disable('autodisconnect');
			smartTalk.startBcastSub();
			smartTalk.startSubOnMe();

			smartMsgClient.bind('transport:down', function() {console.log("connection down!!"); return;});
			smartMsgClient.bind('transport:up', function() {console.log("connection up!!");});
		};
		reconnect();
	},

	subscribe : function(channel, callback) {
		if (smartMsgClient == null)
			return;
		var subscription = smartMsgClient.subscribe(channel, callback);
		return subscription;
	},

	publish : function(channel, message) {
		if (smartMsgClient == null)
			return;
		smartMsgClient.publish(channel, message);
	},

	startBcastSub : function() {
		smartTalk.subscribe(smartTalk.myChannel(swSubject.BROADCASTING), function(message) {
			if (message.msgType === msgType.BROADCASTING)
				updateBcastBoard(message.body);
			else if (message.msgType === msgType.AVAILABLE_CHATTERS) 
				updateAvailableChatters(message.userInfos);
		});

	},

	startSubOnMe : function() {
		smartTalk.subscribe(smartTalk.myChannel(swSubject.USERID), function(message) {
					if (message.msgType === msgType.NOTICE_COUNT){
						updateNoticeCount(message);
					} else if (message.msgType === msgType.JOIN_CHAT){
						smartTalk.startSubOnChatId(message);
						startChattingWindow(message);
					}
				});
	},

	publishBcast : function(message) {
		smartTalk.publish(smartTalk.myChannel(swSubject.BROADCASTING), {
			msgType : msgType.BROADCASTING,
			sender : currentUserId,
			body : message
		});
	},

	publishNoticeCount : function(message) {
		smartTalk.publish(smartTalk.myChannel(swSubject.USERID), {
			msgType : msgType.NOTICE_COUNT,
			sender : currentUserId,
			body : message
		});
	},

	chattingRequest : function(chatterInfos) {
		if(chatManager.isSameChat(chatterInfos)) return;
		if((chatterInfos.length == 2) && (chatterInfos[0].userId === chatterInfos[1].userId)) return;
		smartTalk.publish(smartTalk.myChannel(swSubject.FAYESERVER), {
			msgType : msgType.CHAT_REQUEST,
			sender : currentUserId,
			chatterInfos : chatterInfos
		});
	},

	dataOnChatId : function(message){
		var type = message.msgType;
		var chatId = message.chatId;
		var sender = message.sender;
		var chatList = chatManager.updateChatStatus(sender, userStatus.ONLINE);
		for ( var i = 0; i < chatList.length; i++) {
			var chatId = chatList[i].chatId;
			var chatterInfo = chatManager.chatterInfo(chatId, sender);
			if(chatterInfo != null) updateChatterStatus(chatId, chatterInfo, userStatus.ONLINE);
		}

		if (type === msgType.JOINED_IN_CHAT) {
			
		} else if (type === msgType.LEAVE_CHAT) {
			if(sender !== currentUser.userId){
				var chatterInfo = chatManager.chatterInfo(chatId, sender);
				var chatterList = chatManager.removeChatter(chatId, sender);
				updateChattingBoxTitle(chatId, chatterList);
				updateChatterStatus(chatId, chatterInfo, userStatus.LEAVED);
			}
		} else if (type === msgType.WRITING_CHAT_MESSAGE) {

		} else if (type === msgType.CHAT_MESSAGE) {
				receivedMessageOnChatId(message);
		} else if( type === msgType.CHATTERS_INVITED){
			if(sender !== currentUser.userId){
				var chatterInfos = message.chatterInfos;
				var users = chatManager.chatById(chatId).users;
				for ( var i = 0; i < chatterInfos.length; i++) {
					var chatterInfo = chatterInfos[i];
					if(chatManager.chatterInfo(chatId, chatterInfo.userId)!=null) continue;
					var userInfo = {
							userId : chatterInfo.userId,
							longName : chatterInfo.longName,
							status : userStatus.OFFLINE,
							onlineSub : null,
							offlineSub : null
						};
					users.push(userInfo);
					userInfo.onlineSub = chatManager.onlineSub(chatterInfo.userId);
					if(!userInfo.onlineSub)
						userInfo.onlineSub = smartTalk.subscribe(smartTalk.myChannel("/"
							+ chatterInfo.userId.replace(/\./g, '_')
							+ swSubject.ONLINE), smartTalk.subOnChatterOnline);
					userInfo.offlineSub = chatManager.offlineSub(chatterInfo.userId);
					if(!userInfo.offlineSub)	
						userInfo.offlineSub = smartTalk.subscribe(smartTalk.myChannel("/"
							+ chatterInfo.userId.replace(/\./g, '_')
							+ swSubject.OFFLINE), smartTalk.subOnChatterOffline);
					updateChatterStatus(chatId, chatterInfo, userStatus.OFFLINE);
				}
				updateChattingBoxTitle(chatId, chatterInfos);
			}
		}
	},
	
	subOnChatterOnline : function(userId){
		var chatList = chatManager.updateChatStatus(userId, userStatus.ONLINE);
		for ( var i = 0; i < chatList.length; i++) {
			var chatId = chatList[i].chatId;
			smartTalk.sendJoinChat(chatId, userId,
					chatManager.chatterInfos(chatId));
			var chatterInfo = chatManager.chatterInfo(chatId, userId);
			if(chatterInfo != null) updateChatterStatus(chatId, chatterInfo, userStatus.ONLINE);
		}
		console.log("ONLINE : " + userId);		
	},
	
	subOnChatterOffline : function(userId){
		var chatList = chatManager.updateChatStatus(userId, userStatus.OFFLINE);
		for ( var i = 0; i < chatList.length; i++) {
			var chatId = chatList[i].chatId;
			var chatterInfo = chatManager.chatterInfo(chatId, userId);
			if(chatterInfo != null) updateChatterStatus(chatId, chatterInfo, userStatus.OFFLINE);
		}
		console.log("OFFLINE : " + userId);		
	},
	
	startSubOnChatId : function(message) {
		var chat = chatManager.chatById(message.chatId);
		if(chat != null) return;
		
		var users = new Array();
		for(var i=0; i<message.chatterInfos.length; i++){
			var chatterInfo = message.chatterInfos[i];
			users.push({userId: chatterInfo.userId, longName : chatterInfo.longName, 
							minPicture : chatterInfo.minPicture, status : userStatus.OFFLINE, onlineSub : null, offlineSub : null});
		}
		chat = { chatId : message.chatId, subscription : null, users : users};
		chatManager.chatList.push(chat);

		chat.subscription = smartTalk.subscribe(smartTalk.myChannel("/" + message.chatId), smartTalk.dataOnChatId); 
		for ( var i = 0; i < users.length; i++) {
			var chatterInfo = users[i];
			if ((chatterInfo.userId === currentUser.userId) || chatterInfo.userId === message.sender){
				chatterInfo.status = userStatus.ONLINE;
			}else{
				chatterInfo.onlineSub = chatManager.onlineSub(chatterInfo.userId);
				if(!chatterInfo.onlineSub)
					chatterInfo.onlineSub = smartTalk.subscribe(smartTalk.myChannel("/"
						+ chatterInfo.userId.replace(/\./g, '_')
						+ swSubject.ONLINE), smartTalk.subOnChatterOnline);
				chatterInfo.offlineSub = chatManager.offlineSub(chatterInfo.userId);
				if(!chatterInfo.offlineSub)	
					chatterInfo.offlineSub = smartTalk.subscribe(smartTalk.myChannel("/"
						+ chatterInfo.userId.replace(/\./g, '_')
						+ swSubject.OFFLINE), smartTalk.subOnChatterOffline);
			}
		}
		smartTalk.publishJoinedChat(message.chatId);
		console.log(chatManager.chatList);
	},

	stopSubOnChatId : function(chatId) {
		var chat = chatManager.chatById(chatId);
		var users = chat.users;
		for(var i=0; i<users.length; i++){
			var user = users[i];
			var chatters = chatManager.chatters(user.userId);
			if(chatters==1){
				smartMsgClient.unsubscribe(user.onlineSub);
				smartMsgClient.unsubscribe(user.offlineSub);				
			}
		}
		smartTalk.publishLeavingChat(chatId);
		smartMsgClient.unsubscribe(chat.subscription);
		chatManager.removeChat(chatId);
		console.log(chatManager.chatList);
	},

	publishChatMessage : function(chatId, message) {
		smartTalk.publish(smartTalk.myChannel("/"
				+ chatId), {
			msgType : msgType.CHAT_MESSAGE,
			senderInfo : {
				userId : currentUserId,
				minPicture : currentUser.minPicture,
				longName : currentUser.longName
			},
			chatId : chatId,
			chatMessage : message
		});
	},

	publishWritingStatus : function(chatId) {
		smartTalk.publish(smartTalk.myChannel("/"
				+ chatId), {
			msgType : msgType.WRITING_CHAT_MESSAGE,
			chatId : chatId,
			sender : currentUserId
		});
	},

	publishJoinedChat : function(chatId) {
		smartTalk.publish(smartTalk.myChannel("/"
				+ chatId), {
			msgType : msgType.JOINED_IN_CHAT,
			chatId : chatId,
			sender : currentUserId
		});
	},

	publishChattersInvited : function(chatId, chatterInfos) {
		smartTalk.publish(smartTalk.myChannel("/"
				+ chatId), {
			msgType : msgType.CHATTERS_INVITED,
			chatId : chatId,
			sender : currentUserId,
			chatterInfos : chatterInfos
		});
	},

	publishLeavingChat : function(chatId) {
		smartTalk.publish(smartTalk.myChannel("/"
				+ chatId), {
			msgType : msgType.LEAVE_CHAT,
			chatId : chatId,
			sender : currentUserId
		});
	},

	sendJoinChat : function(chatId, user, chatterInfos) {
		smartTalk.publish(smartTalk.myChannel("/"
				+ user.replace(/\./g, '_')), {
			msgType : msgType.JOIN_CHAT,
			sender : currentUserId,
			chatId : chatId,
			chatterInfos : chatterInfos
		});
	},

	addJoinChatters : function(chatId, chatterInfos) {
		var users = chatManager.chatById(chatId).users;
		var newChatterInfos = new Array();
		for ( var i = 0; i < chatterInfos.length; i++) {
			if(chatManager.chatterInfo(chatId, chatterInfos[i].userId)!=null) continue;
			var chatterInfo = chatterInfos[i];
			newChatterInfos.push(chatterInfo);
			var userInfo = {
					userId : chatterInfo.userId,
					longName : chatterInfo.longName,
					status : userStatus.OFFLINE,
					onlineSub : null,
					offlineSub : null
				};
			users.push(userInfo);
			userInfo.onlineSub = chatManager.onlineSub(chatterInfo.userId);
			if(!userInfo.onlineSub)
				userInfo.onlineSub = smartTalk.subscribe(smartTalk.myChannel("/"
					+ chatterInfo.userId.replace(/\./g, '_')
					+ swSubject.ONLINE), smartTalk.subOnChatterOnline);
			userInfo.offlineSub = chatManager.offlineSub(chatterInfo.userId);
			if(!userInfo.offlineSub)	
				userInfo.offlineSub = smartTalk.subscribe(smartTalk.myChannel("/"
					+ chatterInfo.userId.replace(/\./g, '_')
					+ swSubject.OFFLINE), smartTalk.subOnChatterOffline);
			updateChatterStatus(chatId, chatterInfo, userStatus.OFFLINE);
		}
		var userInfos = new Array();
		for(var i=0; i<users.length; i++){
			userInfos.push({ userId : users[i].userId, longName : users[i].longName, minPicture : users[i].minPicture});
		}
		
		smartTalk.publishChattersInvited(chatId, userInfos);
		
		for(var i=0; i<newChatterInfos.length; i++){
			if(newChatterInfos[i].userId != currentUser.userId)
				smartTalk.sendJoinChat(chatId, newChatterInfos[i].userId, userInfos);
		}
		
		updateChattingBoxTitle(chatId, users);		
	}
};
