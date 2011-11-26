var serverUrl = "http://192.168.0.8:8000";
var swContext = "/faye";
var currentUserId = currentUser.userId;

var swSubject = {
	SMARTWORKS : "/smartworks",
	COMPANYID : "/" + currentUser.companyId,
	USERID : "/" + currentUser.userId.replace(/\./g, '_'),
	BROADCASTING : "/broadcasting",
	FAYESERVER : "/fayeServer"
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
	CHAT_HEARTBEAT : "HEARTBEAT",
	AVAILABLE_CHATTERS : "ACHATTERS"
};

var smartMsgClient = null;
var smartTalk = {
	init : function() {
		var fayeContext = serverUrl + swContext;
		var reconnect = function() {
			console.log("creating Client!!");
			smartMsgClient = new Faye.Client(fayeContext, {
				timeout : 10
			});
			smartMsgClient.disable('autodisconnect');
			smartTalk.startBcastSub();
			smartTalk.startSubOnMe();

			smartMsgClient.bind('transport:down', function() {
				console.log("connection down!!");
				return;
			});
			smartMsgClient.bind('transport:up', function() {
				console.log("connection up!!");
			});
		};
		reconnect();
	},

	subscribe : function(subject, callback) {
		if (smartMsgClient == null)
			return;
		var subscription = smartMsgClient.subscribe(subject, callback);
		return subscription;
	},

	unsubscribe : function(subscription) {
		if (smartMsgClient == null)
			return;
		smartMsgClient.unsubscribe(subscription);
	},

	publish : function(subject, message) {
		if (smartMsgClient == null)
			return;
		smartMsgClient.publish(subject, message);
	},

	startBcastSub : function() {
		smartTalk.subscribe(swSubject.SMARTWORKS + swSubject.COMPANYID
				+ swSubject.BROADCASTING, function(message) {
			if (message.msgType === msgType.BROADCASTING) {
				updateBcastBoard(message.body);
			} else if (message.msgType === msgType.AVAILABLE_CHATTERS) {
				updateAvailableChatters(message.userInfos);
			}
		});

	},

	startSubOnMe : function() {
		smartTalk.subscribe(swSubject.SMARTWORKS + swSubject.COMPANYID
				+ swSubject.USERID, function(message) {
			if (message.msgType === msgType.NOTICE_COUNT) {
				updateNoticeCount(message);
			} else if (message.msgType === msgType.JOIN_CHAT) {
				startChattingWindow(message);
				smartTalk.startSubOnChatId(message.chatId);
			}
		});
	},

	publishBcast : function(message) {
		smartTalk.publish(swSubject.SMARTWORKS + swSubject.COMPANYID
				+ swSubject.BROADCASTING, {
			msgType : msgType.BROADCASTING,
			sender : currentUserId,
			body : message
		});
	},

	publishNoticeCount : function(message) {
		smartTalk.publish(swSubject.SMARTWORKS + swSubject.COMPANYID
				+ swSubject.USERID, {
			msgType : msgType.NOTICE_COUNT,
			sender : currentUserId,
			body : message
		});
	},

	chattingRequest : function(userInfos) {
		smartTalk.publish(swSubject.SMARTWORKS + swSubject.COMPANYID
				+ swSubject.FAYESERVER, {
			msgType : msgType.CHAT_REQUEST,
			sender : currentUserId,
			userInfos : userInfos
		});
	},

	startSubOnChatId : function(chatId) {
		var subscription = smartTalk.subscribe(swSubject.SMARTWORKS
				+ swSubject.COMPANYID + "/" + chatId, function(message) {
			if (message.msgType === msgType.CHAT_HEARTBEAT) {
				if(message.sender === currentUser.userId) return;
				console.log("[HEART-BEAT] user=" + message.sender);
			} else {
				console.log(message);
				receivedMessageOnChatId(message);
			}
		});
		smartTalk.setChatSub(chatId, subscription);
	},

	unsubscribeChatId : function(chatId) {
		smartTalk.unsubscribe(smartTalk.removeChatSub(chatId));
	},

	publishJoinedInChat : function(chatId) {
		smartTalk.publish(swSubject.SMARTWORKS + swSubject.COMPANYID + "/"
				+ chatId, {
			msgType : msgType.JOINED_IN_CHAT,
			sender : currentUserId,
			chatId : chatId
		});
	},

	publishLeaveChat : function(chatId) {
		smartTalk.publish(swSubject.SMARTWORKS + swSubject.COMPANYID + "/"
				+ chatId, {
			msgType : msgType.LEAVE_CHAT,
			sender : currentUserId,
			chatId : chatId
		});
	},

	publishChatMessage : function(chatId, message) {
		console.log(message);
		smartTalk.publish(swSubject.SMARTWORKS + swSubject.COMPANYID + "/"
				+ chatId, {
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
		smartTalk.publish(swSubject.SMARTWORKS + swSubject.COMPANYID + "/"
				+ chatId, {
			msgType : msgType.WRITING_CHAT_MESSAGE,
			chatId : chatId,
			sender : currentUserId
		});
	},

	startHeartBeat : function(chatId) {
		var repeating = function() {
			smartTalk.publish(swSubject.SMARTWORKS + swSubject.COMPANYID + "/"
					+ chatId, {
				msgType : msgType.CHAT_HEARTBEAT,
				sender : currentUserId,
				chatId : chatId
			});
		};
		return setInterval(repeating, 2000);
	},

	sendJoinChat : function(chatId, user) {
		smartTalk.publish(swSubject.SMARTWORKS + swSubject.COMPANYID + "/"
				+ user.replace(/\./g, '_'), {
			msgType : msgType.JOIN_CHAT,
			sender : currentUserId,
			chatId : chatId
		});
	},

	removeChatSub : function(chatId) {
		clearInterval(repeater);
		return subscription;
	},

	setChatSub : function(chatId, subscription) {
		var repeater = smartTalk.startHeartBeat(chatId);

	}
};

$('#available_chatter_list a').live('click', function(e) {
	var input = $(e.target).parent('a');
	var userId = input.attr('userId');
	var img = input.find('img');
	var longName = img.attr('title');
	var minPicture = img.attr('src');
	smartTalk.chattingRequest(new Array({
		userId : currentUserId,
		longName : currentUser.longName,
		minPicture : currentUser.minPicture
	}, {
		userId : userId,
		longName : longName,
		minPicture : minPicture
	}));
	return false;
});
