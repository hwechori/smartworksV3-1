
var loginRetry = {
	interval : 1000,
	max : 3
};

var loggedIn = false;
var loginRetries = 0;
var checkMailInterval = 10000;
var checkingMail = false;
var unreadMessages = -1;
var prefSignature = '';
var prefSignaturePos = 'top';
var prefSendReadReceipt = 'prompt';


function refreshMail() {
	checkingMail = false;
	checkMail();
}

var smartMail = {
	login : function() {
		loggedIn = false;
		$.ajax({
			url : "profiling/login.cl",
			data : {
				username : currentUser.userId,
				password : "jys8804" //currentUser.password
			},
			type : "POST",
			success : function(data, status, jqXHR) {
				loggedIn = true;
				console.log(data);
			},
			error : function(data, status, jqXHR){
				loggedIn = false;
				console.log(data);
				if(loginRetries < loginRetry.max){
					loginRetries++;
					console.log("LOGIN RETRY = " + loginRetries);
					setTimeout(function(){
						smartMail.login();
					}, loginRetry.interval);
				}else{
					console.log("LOGIN RETRY TIMEOUT");
					loginRetries = 0;
				}
			}
		});
	},

	fetchFolders : function(folderId) {
		if(!loggedIn){
			console.log("not logged in yet!!!");
			setTimeout(function(){
				smartMail.fetchFolders(folderId);
			}, 2000);
			return;
		}
		$.ajax({
			url : "webmail/getFolders.cl",
			data : {
				folder : folderId
			},
			type : "POST",
			success : function(data, status, jqXHR) {
				console.log("fetch folders = ", data);
//				$('#my_webmail').html(data);
				if(isEmpty(folderId))
					smartMail.unreadMailCount();
			},
			error : function(data, status, jqXHR){
				console.log("error=", data);
			}
		});
	},

	unreadMailCount : function() {

		console.log("unreadMailCount in.......");
		$.ajax({
			url : "webmail/getUnreadCount.cl",
			data : {},
			type : "GET",
			success : function(data, status, jqXHR) {
				var unreadCount = parseInt(data);
				console.log("unreadCount=", data);
				if (unreadCount != -1) {
					unreadMessages = unreadCount;
				}
			},
			error : function(data, status, jqXHR){
				console.log("error=", data);
				smartMail.checkNewMailExists();
			}
		});
	},
	
	checkNewMailExists : function() {

		if (checkingMail) return;
		checkingMail = true;
		$.ajax({
			url : "webmail/getUnreadCount.cl",
			data : {},
			type : "GET",
			success : function(data, status, jqXHR) {
				checkingMail = false;
				var unreadCount = parseInt(data);
				if (unreadCount > 0 && unreadCount > unreadMessages) {
					unreadMessages = unreadCount;
					console.log("new " + unreadMessages + " messages arrived.....");
//					showNewMessageIndicator();
//					smartMail.checkMail();
				}
				setTimeout(smartMail.checkNewMailExists, checkMailInterval);
			},
			error : function(data, status, jqXHR){
				console.log("error=", data);
			  	checkingMail = false;
				setTimeout(smartMail.checkNewMailExists, checkMailInterval);
			}
		});
	},
	
	checkMail : function(sortItem, sortOrder, noFolders, preSelectId, pageNo) {
		if (checkingMail) return;

		checkingMail = true;
			
		// first determine which e-mail was clicked and save their content HTML in array and vars
		var clicked = new Array();
		var list = Dom.get('mailList');
		var ps = list.getElementsByTagName('p');
		var clickedCounter = 0;
		var clickedAndActive;
		if (ps != null) {
			for (var i=0;i<ps.length;i++) {
				if (ps[i].clicked && ps[i].id.indexOf('Clone') < 0) {
					clicked[clickedCounter] = ps[i].getElementsByTagName('span')[1].innerHTML + ps[i].getElementsByTagName('span')[2].innerHTML;
					clickedCounter++;
					if (ps[i].lastClicked) {
						clickedAndActive = ps[i].getElementsByTagName('span')[1].innerHTML + ps[i].getElementsByTagName('span')[2].innerHTML;
					}
				}
			}
		}
		
		// no go make the operations.fetch the headers.
		var folderName = getCurrentFolder();
		var cfdn = getCurrentFolderDisplayName();
		if(undefined != cfdn) {
			if (cfdn.length > 13) {
				cfdn = cfdn.substr(0,13) + "...";
			}
			Dom.get('inboxTitle1').innerHTML = cfdn;
		}
		var paramData = "folder=" + myEncode(folderName);
		
		if (sortItem != null) {
			if (sortOrder == null || sortOrder == '') {
				sortOrder = 'desc';
			} else if (sortOrder == 'desc') {
				sortOrder = 'asc';
			} else if (sortOrder == 'asc') {
				sortOrder = 'desc';
			}
			paramData += "&mailSort=" + sortItem + "&mailSortDirection=" + sortOrder;
		} 
		if(pageNo != null) paramData += "&pageNo=" + pageNo;
		else paramData += "&pageNo=1";
		var url = "webmail/listHeaders.cl";
		Dom.get('kitwait').style.display = 'block';
	
		var callback = {
		  success: 	function(o) {
				if(o.responseText !== undefined) {
					try {
						var list = Dom.get('mailList');
						list.innerHTML = o.responseText;
						preparePager();
						prepareMailListHeader();
						initPng();
						mailDragInit();
						Dom.get('kitwait').style.display = 'none';

						// re-select the previously clicked ones
						for (var k=0;k<clicked.length;k++) {
							var tmpClicked = findMailPByInnerHTML(clicked[k]);
							if (tmpClicked != null) {
								mailListChangeStyle(tmpClicked,C_LIGHTBLUE,C_BLACK,true,false,1);
							}
						}
						if (clickedAndActive != null&&1==clicked.length) {
							var obj = findMailPByInnerHTML(clickedAndActive);
							if (obj != null) {
								mailListChangeStyle(obj,C_ROYALBLUE,C_WHITE,true,true,1);
								lastClickedId = obj.id.substr(4);
							}
						}
						
						if (preSelectId != null) {
							var obj = Dom.get('mail' + preSelectId);
							if (obj != null) {
								/*
								obj.style.backgroundColor = C_ROYALBLUE;
								obj.style.color = C_WHITE;
								obj.clicked = true;
								obj.getElementsByTagName('span')[0].style.backgroundImage = 'url(images/checked.gif)';
								obj.lastClicked = true;
								lastClickedId = preSelectId;
								*/
								try {mailListClick(null, obj.getElementsByTagName('span')[1], true) } catch (k) {};
							}
						}
		
						// parallelly fetch folders again
						if (noFolders == null || noFolders == false) {
							fetchFolders();
							Dom.get('kitwait').style.display = 'none';
						}
						checkingMail = false;
						// unreadMessages = -1;
					} catch(e) {
						// do nothing sier
					}
				}
		  },
	
		  failure: 	function(o) {
			Dom.get('kitwait').style.display = 'none';
			// showDialog("defaultError");
			checkingMail = false;
		  },
		  argument: [],
		  timeout: 300000
		}
		var request = YAHOO.util.Connect.asyncRequest('POST', url, callback, paramData);
	}
};