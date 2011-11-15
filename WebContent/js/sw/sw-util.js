 var Request = {	
 	parameter: function(name) {
		return this.parameters()[name];
 	},
 	
 	parameters: function() {
 		var result = {};
 		var url = window.location.href;
 		var parameters = url.slice(url.indexOf('?') + 1).split('&');
 		
 		for(var i = 0;  i < parameters.length; i++) {
 			var parameter = parameters[i].split('=');
 			result[parameter[0]] = parameter[1];
 		}
 		return result;
 	}
 };
 
	function setCookie() {
		var id;
		id = document.loginForm.j_username.value;
		var todayDate = new Date();
		todayDate.setDate(todayDate.getDate() + 365);			
		document.cookie = "smartWorks=on; expires=" + todayDate.toGMTString()+ "; path=/" ; 
		document.cookie = "smartWorksid="+ id +";  expires=" + todayDate.toGMTString()+ "; path=/" ; 
	}
	function unSetCookie() {
		var todayDate = new Date();
		todayDate.setDate(todayDate.getDate() + 365);
		document.cookie = "smartWorks=off; expires=" + todayDate.toGMTString()+ "; path=/" ; 
		document.cookie = "smartWorksid=;  expires=" + todayDate.toGMTString()+ "; path=/" ; 
	}
	function cookieVal(cookieName) {
		thisCookie = document.cookie.split("; ");
		for(i=0; i<thisCookie.length; i++){
			if(cookieName == thisCookie[i].split("=")[0]) {
				return thisCookie[i].split("=")[1];
			}
		}
		return "x";
	}
