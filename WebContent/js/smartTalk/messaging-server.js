var serverUrl = "http://localhost:8000";
var swContext = "/faye";
var fayeServer = "fayeServer";

var swSubject = {
	SMARTWORKS : "/smartworks",
	COMPANYID : "/Semiteq",
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
	JOIN_CHAT : "JOINCHAT"
};

var http = require('http'), faye = require('faye');
var port = 8000;

var bayeux = new faye.NodeAdapter({
	mount : '/faye',
	timeout : 5
});
var server = http.createServer(function(request, response) {
	response.writeHead(200, {
		'Content-Type' : 'text/plain'
	});
	response.write('Hello, non-Bayeux request');
	response.end();
});

bayeux.attach(server);
server.listen(port);

function getUserId(channel){
	var pos = swSubject.SMARTWORKS.length + swSubject.COMPANYID.length + 1;
	var newChannel = channel.substring(pos).replace(/_/g, '.' );
	return newChannel;
}
bayeux.bind('subscribe', function(clientId, channel) {
	console.log('[  SUBSCRIBE] ' + clientId + ' -> ' + channel);
	var pos = channel.indexOf('@');
	if((pos != -1) && (channel.indexOf('/',pos) == -1)){		
		bayeux.getClient().publish(channel + swSubject.ONLINE, getUserId(channel));
	}
});

bayeux.bind('unsubscribe', function(clientId, channel) {
	console.log('[UNSUBSCRIBE] ' + clientId + ' -> ' + channel);
	var pos = channel.indexOf('@');
	if((pos != -1) && (channel.indexOf('/',pos) == -1)){		
		bayeux.getClient().publish(channel + swSubject.OFFLINE, getUserId(channel));
	}
});

bayeux.bind('disconnect', function(clientId) {
	console.log('[ DISCONNECT] ' + clientId);
});

bayeux.bind('publish', function(clientId, channel, data) {
	console.log('[ PUBLISH] =======================================');
	console.log(channel, data);
	console.log('==================================================')
});


console.log('Listening on ' + port);

function uniqid() {
	var newDate = new Date;
	return newDate.getTime();
};

var serverCallback = function(message) {
	if (message.msgType === msgType.CHAT_REQUEST) {
		var chatterInfos = message.chatterInfos;
		var sender = message.sender.replace(/\./g, '_');
		var chatId = "chatId" + uniqid();
		if (chatterInfos != null && chatterInfos.length > 0) {
			for ( var i = 0; i < chatterInfos.length; i++) {
				if((chatterInfos[i] == null) || (chatterInfos[i].userId == null)) continue;
				bayeux.getClient().publish(swSubject.SMARTWORKS
						+ swSubject.COMPANYID + "/" + chatterInfos[i].userId.replace(/\./g,'_'), {
					msgType : msgType.JOIN_CHAT,
					sender : message.sender,
					chatId : chatId,
					chatterInfos : chatterInfos
				});
			}
		}
	}
};

bayeux.getClient().subscribe(swSubject.SMARTWORKS + swSubject.COMPANYID
		+ swSubject.FAYESERVER, serverCallback);
