
var serverUrl = "http://localhost:8000";
var swContext = "/faye";
var smartWorksSubject = "/smartworks";
var bcastSubject = "/broadcasting";
var smartMsgClient = null;
var smartTalk = {
		init : function(){
			var fayeContext = serverUrl + swContext;
			smartMsgClient = new Faye.Client(fayeContext, {
				timeout : 120
			});
			smartMsgClient.disable('autodisconnect');
		},

		subscribe : function(subject, callback){
			if(smartMsgClient == null) return;
			var subscription = smartMsgClient.subscribe(subject, callback);
			return subscription;			
		},

		unsubscribe : function(subscription){
			if(smartMsgClient == null) return;
			smartMsgClient.unsubscribe(subscription);
		},

		publish : function(subject, message){
			if(smartMsgClient == null) return;
			smartMsgClient.publish(subject, message);			
		},

		startBcastSub : function(){
			alert(Session.userId);
			smartTalk.subscribe(smartWorksSubject + '/maninsoft' + bcastSubject, function(message) {
				if(message.msgType === 'BCAST'){
					$('#marBroadcastingBoard').html(message.body);
				}
			});
			
		},
		
		startSubOnMe : function(){
			smartTalk.subscribe(smartWorksSubject + '/maninsoft' +  '/ysjung@maninsoft_co_kr', function(message){
				if(message.msgType === 'NCOUNT'){
					var type = message.body.type;
					var count = message.body.count;
					var data = "<span></span>";
					if(count>0)
					data = "<em class='num_ic'>" + count + "<span></span></em>";
					
					if(type == 0){
						$('#notification_count').html(data);
					}else if(type == 1){
						$('#message_count').html(data);
					}else if(type == 2){
						$('#comment_count').html(data);
					}else if(type == 3){
						$('#assigned_count').html(data);
					}else if(type == 4){
						$('#mailbox_count').html(data);
					}else if(type == 5){
						$('#savedbox_count').html(data);
					}
				}else if(message.msgType === ''){
					
				}
			});
		},
		
		publishBcast : function(message){
			smartTalk.publish(smartWorksSubject +  '/maninsoft' + bcastSubject, {msgType : 'BCAST', sender : 'ysjung@maninsoft.co.kr', body : message});
		},
		
		publishNoticeCount : function(message){
			smartTalk.publish(smartWorksSubject +  '/maninsoft' + '/ysjung@maninsoft_co_kr', {msgType : 'NCOUNT', sender : 'ysjung@maninsoft.co.kr', body : message});
		}		
};
