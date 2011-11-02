var path = null;
function getPath() {
	if (path != null)
		return path;
	var host = location.host;
	var offset = location.href.indexOf(host) + host.length;
	path = location.href.substring(offset, location.href.indexOf("/", offset + 1));
	return path;
}

ResponseMessage = function(method, parameters, responseText, resultXML) {
	this.method = method;
	this.parameters = parameters;
	this.responseText = responseText;
	this.responseXML = null;
	if (Mis.isNull(resultXML)) {
		try {
			this.responseXML = Mis.toDocument(responseText);
		} catch(e) {
		}
	} else {
		this.responseXML = resultXML;
	}
};

Array.prototype.remove = function(from, to) {
	var rest = this.slice((to || from) + 1 || this.length);
	this.length = from < 0 ? this.length + from : from;
	return this.push.apply(this, rest);
};

var MisConfig = {
	popupNotification_url: getPath() + "/component/maninsoft/example/dialog/notification.jsp",
	popupConfirmation_url: getPath() + "/component/maninsoft/example/dialog/confirmation.jsp",
	popupWarning_url: getPath() + "/component/maninsoft/example/dialog/warning.jsp"
};

document.write("<div id=\"misDiv\" style=\"position: absolute; z-index: 100;\"></div>");

var Mis = {
	// private
	id: 0,
	// private
	paramMap: new Object(),
	// private
	resultMap: new Object(),
	// private
	map: new Object(),
	
	getPath: function() {
		return getPath();
	},
	isNull: function(param) {
		if (param == null)
			return true;
		if (param instanceof Array)
			return false;
		var tempParam = null;
		if (param instanceof String) {
			tempParam = param;
		} else {
			try {
				tempParam = new String(param);
			} catch(e) {
				return false;
			}
		}
		if (tempParam == "true" || tempParam == "false" || tempParam == "0" || tempParam =="1" )
			return false;
		return param == "" || param == "null" || param == "NaN" || param == "undefined";
	},
	isEmpty: function(param) {
		if (param == null)
			return true;
		try {
			return param.length <= 0;
		} catch (e) {
		}
		return true;
	},
	toNull: function(param) {
		return Mis.isNull(param)? null : param;
	},
	toNotNull: function(param) {
		return Mis.toDefault(param, "");
	},
	toDefault: function(param, defaultValue) {
		return Mis.isNull(param)? defaultValue : param;
	},
	toHash: function(str, deli) {
		var hash = new Object();
		if (Mis.isNull(str))
			return hash;
		// TODO
		return hash;
	},
	toBoolean: function(param, defaultValue) {
		if (Mis.isNull(param))
			return Mis.toBoolean(defaultValue, false);
		if (param == true || param == "true" || param == "yes" || param == "on")
			return true;
		return false;
	},
	toDocument: function(xml) {
		var doc = null;
		if (window.DOMParser) {
			var parser = new DOMParser();
			doc = parser.parseFromString(xml, "text/xml");
		} else if (window.ActiveXObject) {
			doc = new ActiveXObject("Microsoft.XMLDOM");
			doc.async = "false";
			doc.loadXML(xml);
		} else {
			throw new Error("This browser is not supported.");
		}
		return doc;
	},
	toString: function(obj) {
		if (Mis.isNull(obj))
			return null;
		
		if (Object.isString(obj))
			return obj;
		
		try {
			if (typeof XMLSerializer != "undefined"){
				return (new XMLSerializer()).serializeToString(obj);
			} else if (obj.xml) {
				return obj.xml;
			}
		} catch (e) {
		}
		
		try {
			return new String(obj);
		} catch (e) {
		}
		
		return null;
	},
	indexOf: function(array, obj) {
		var objIndex = -1;
		if (Mis.isEmpty(array) || Mis.isNull(obj))
			return objIndex;
		for (var i=0; i<array.length; i++) {
			if (array[i] != obj)
				continue;
			objIndex = i;
			break;
		}
		return objIndex;
	},
	remove: function(array, obj) {
		var objIndex = Mis.indexOf(array, obj);
		if (objIndex == -1)
			return;
		array.remove(objIndex);
	},
	
	show: function(id) {
		var obj = document.getElementById(id);
		if (obj == null)
			return;
		obj.style.display = "block";
	},
	hide: function(id) {
		var obj = document.getElementById(id);
		if (obj == null)
			return;
		obj.style.display = "none";
	},
	
	// private
	modalDialogIds: new Array(),
	//private
	modalDialogIndex: 0,
	// private
	createModalDialog: function() {
		Mis.modalDialogIndex = Mis.modalDialogIndex + 5;
		var id = "modalDialog" + Mis.modalDialogIndex;
		var div = document.getElementById("misDiv");
		if (div == null)
			return null;
		
		var body = document.body;
		var width = body.scrollWidth;
		var height = body.scrollHeight;
		if (height < body.offsetHeight)
			height = body.offsetHeight;
		var left = 0;
		var top = 0;
		var divStr = "<div id=\""+id+"\" style=\"padding: 0px 0px 0px 0px;";
		divStr += " width: " + width + "px; height: " + height + "px; left: " + left + "px; top: " + top + "px; position: absolute; z-index: " + Mis.modalDialogIndex + "; display: none;\">";
		divStr += "<div style=\"background-color: #bbbbbb; opacity: .30; filter: alpha(opacity=30); -moz-opacity: 0.3;";
		divStr += " width: 100%; height: 100%; position: absolute; z-index: -1; left: " + left + "; top: " + top + ";";
		divStr += " padding: 0px 0px 0px 0px; overflowX: hidden; overflowY: hidden;\">";
		divStr += "</div>";
		divStr += "<div id=\"" + id + "Scope\" style=\"position: absolute;\"></div>";
		divStr += "</div>";
		div.innerHTML = div.innerHTML + divStr;
		
		Mis.hide(id);
		
		return id;
	},
	getModalDialogId: function(callback, opts) {
		// 대화상자 생성
		var id = Mis.createModalDialog();
		
		// 컨텍스트 저장
		Mis.modalDialogIds.push(id);
		if (!Mis.isNull(callback))
			Mis.map[id + "_callback"] = callback;
		
		if (opts != null) {
			var minTime = opts["minTime"];
			
			if (!Mis.isNull(minTime)) {
				Mis.map[id + "_date"] = new Date();
				Mis.map[id + "_minTime"] = minTime;
			}
		}
		
		return id;
	},
	releaseModalDialog: function (isOk, opts) {
		var id = null;
		if (opts != null) {
			var tmpId = Mis.toNull(opts["id"]);
			if (!Mis.isNull(tmpId))
				id = tmpId;
		}
		
		if (Mis.isNull(id)) {
			id = Mis.modalDialogIds.pop();
		} else {
			Mis.remove(Mis.modalDialogIds, id);
		}
		
		// 반환함수
		var callback = Mis.map[id + "_callback"];
		// 팝업 최소시간
		var date = Mis.map[id + "_date"];
		var minTime = Mis.map[id + "_minTime"];
		var delay = null;
		if (!Mis.isNull(date) && !Mis.isNull(minTime))
			delay = minTime - (new Date().getTime() - date.getTime());
		
		// 대화상자 해제
		if (Mis.isNull(delay) || delay <= 0) {
			Mis._releaseModalDialog(isOk, id, callback);
		} else {
			var releaseFunction = function() {Mis._releaseModalDialog(isOk, id, callback);};
			setTimeout(releaseFunction, delay);
		}
	},
	// private
	_releaseModalDialog: function(isOk, id, callback) {
		isOk = Mis.toBoolean(isOk, false);
		
		// 반환함수 처리
		if (!Mis.isNull(callback)) {
			if (isOk) {
				try {
					Mis.call(callback);
				} catch (e) {
					Mis.modalDialogIds.push(id);
					// TODO error
					return;
				}
			}
			Mis.map[id + "_date"] = null;
			Mis.map[id + "_minTime"] = null;
			Mis.map[id + "_callback"] = null;
		}
		
		// 대화상자 숨기기
		Mis.hideModalDialog(id);
	},
	// private
	showModalDialog: function(id) {
		var scope = document.getElementById(id + "Scope");
		if (scope == null)
			return;
		
		Mis.show(id);
		
		scope.style.left = document.documentElement.offsetWidth/2 - scope.offsetWidth/2;
		scope.style.top = document.body.scrollTop + document.body.clientHeight/2 - scope.offsetHeight/2;
	},
	// private
	hideModalDialog: function(id) {
		var div = document.getElementById(id);
		var scope = document.getElementById(id + "Scope");
		if (scope != null)
			scope.innerHTML = "";
		if (div != null)
			div.innerHTML = "";
		Mis.hide(id);
	},
	
	popupModalDialog: function(url, params, callback, opts) {
		if (Mis.isNull(url))
			return null;
		
		// 옵션 설정
		var preScript = null;
		var minTime = null;
		if (opts != null) {
			preScript = Mis.toNull(opts["preScript"]);
			minTime = Mis.toNull(opts["minTime"]);
		}
		
		// 대화상자 띄우기
		var modalOpts = null;
		if (!Mis.isNull(minTime)) {
			modalOpts = new Object();
			modalOpts["minTime"] = minTime;
		}
		var id = Mis.getModalDialogId(callback, modalOpts);
		var updateOpts = new Object();
		if (preScript != null) {
			updateOpts["callback"] = function() {Mis.showModalDialog(id); Mis.call(preScript);};
		} else {
			updateOpts["callback"] = function() {Mis.showModalDialog(id);};
		}
		Mis.update(url, params, id + "Scope", updateOpts);
		
		return id;
	},
	
	popupNotification: function(msg, callback, opts) {
		var params = new Object();
		params["message"] = msg;
		
		var minTime = null;
		if (!Mis.isNull(opts)) {
			minTime = opts["minTime"];
		}
		
		if (Mis.isNull(minTime))
			minTime = 1000;
		
		var popupOpts = new Object();
		popupOpts["minTime"] = minTime;
		
		return Mis.popupModalDialog(MisConfig.popupNotification_url, params, callback, popupOpts);
	},
	releaseNotification: function(isOk, opts) {
		Mis.releaseModalDialog(isOk, opts);
	},
	popupConfirmation: function(msg, callback, opts) {
		
	},
	releaseConfirmation: function(isOk, opts) {
		
	},
	popupWarning: function(msg, detail, callback, opts) {
		
	},
	releaseWarning: function(isOk, opts) {
		
	},

	getChildNode: function(xml, name) {
		if (!(xml.hasChildNodes))
			return null;
			
		for (var x=0; x<xml.childNodes.length; x++) {
			if(xml.childNodes[x].nodeName == name)
				return xml.childNodes[x];
		}
		
		return null;
	},
	
	escapeTextarea: function(str) {
		if (Mis.isNull(str))
			return str;
		str = str.replace(/&/g,'&amp;');
		return str;
	},
	
	// private
	getId: function(params) {
		var id = null;
		if (params != null)
			id = params["mis_service_id"];
		if (Mis.isNull(id)) {
			Mis.id++;
			id = Mis.id;
			if (params == null)
				params = new Object();
			params["mis_service_id"] = id;
		}
		return id;
	},
	getNotificationId: function(id) {
		return Mis.map[id + "_notiId"];
	},
	setNotificationId: function(id, notiId) {
		Mis.map[id + "_notiId"] = notiId;
	},
	releaseNotificationId: function(id, isOk) {
		var notiId = Mis.getNotificationId(id);
		if (Mis.isNull(notiId))
			return;
		
		Mis.setNotificationId(id, null);
		
		var opts = new Object();
		opts["id"] = notiId;
		Mis.releaseNotification(isOk, opts);
	},
	// private
	getParameters: function(id) {
		return Mis.paramMap[id];
	},
	// private
	setParameters: function(id, parameters, overwrite) {
		overwrite = Mis.toBoolean(overwrite);
		if (!overwrite && !Mis.isNull(Mis.paramMap[id]))
			return;
		Mis.paramMap[id] = parameters;
	},
	// private
	releaseParameters: function(id) {
		if (Mis.isNull(id))
			return;
		Mis.paramMap[id] = null;
	},
	
	request: function(url, params, callback, opts) {
		var id = null;
		var error = null;
		var asynchronous = false;
		
		try {
			params = Mis.toDefault(params, new Object);
			id = Mis.getId(params);
			
			var confirm = null;
			var progress = null;
			var complete = null;
			
			if (!Mis.isNull(opts)) {
				confirm = Mis.toDefault(opts["confirm"], confirm);
				progress = Mis.toDefault(opts["progress"], progress);
				complete = Mis.toDefault(opts["complete"], complete);
				error = Mis.toDefault(opts["error"], error);
				if (Mis.isNull(confirm) && Mis.isNull(progress) && Mis.isNull(complete)) {
					asynchronous = Mis.toDefault(opts["asynchronous"], asynchronous);
				} else {
					opts["asynchronous"] = true;
				}
			}
			
			Mis.setParameters(id, {url: url, params: params, callback: callback, opts: opts});
			
			// 확인 대화상자
			
			// 진행중 대화상자
			
			// 실행
			new Ajax.Request(url, {
						method: "post", parameters: params, asynchronous: asynchronous, 
						onComplete: Mis.onRequestComplete, onException: Mis.onServiceException});
			
		} catch (e) {
			Mis.releaseParameters(id);
			throw e;
		}
		
		// 결과 처리
		if (asynchronous)
			return null;
		var result = Mis.resultMap[id];
		if (Mis.isNull(result))
			return null;
		Mis.resultMap[id] = null;
		return result;
	},
	onRequestComplete: function(res) {
		var id = null;
		var params = null;
		try {
			params = res.request.parameters;
			id = params["mis_service_id"];
			var responseText = res.responseText;
			var responseXML = res.responseXML;
			var isResponseTextNull = Mis.isNull(responseText);
			var isResponseXMLNull = Mis.isNull(responseXML);
			if (isResponseTextNull && isResponseXMLNull) {
				
			} else {
				if (isResponseTextNull) {
					responseText = responseXML.xml;
				} else if (isResponseXMLNull) {
					try {
						responseXML = Mis.toDocument(responseText);
					} catch (e1) {
					}
				}
				if (!isResponseXMLNull || !Mis.isNull(responseXML)) {
					var root = responseXML.documentElement;
					if (!Mis.isNull(root)) {
						var status = root.getAttribute("status");
						if (status == "failure" || status == "failed" || status == "fail" || status == "Failed") {
							// TODO
//							var errorCode = Mis.getErrorCode(result);
//							warnMessage(error, errorCode);
							throw new Error("Error.");
						}
					}
				}
			}
			var paramMap = Mis.paramMap[id];
			var opts = paramMap["opts"];
			var callback = paramMap["callback"];
			var asynchronous = false;
			if (!Mis.isNull(opts))
				asynchronous = Mis.toDefault(opts["asynchronous"], asynchronous);
			var result = new ResponseMessage("request", paramMap, responseText, responseXML);
			if (!Mis.isNull(callback)) {
				try {
					Mis.call(callback, result);
				} catch (e) {
				}
			}
			if (!asynchronous)
				Mis.resultMap[id] = result;
		} catch (e) {
			// TODO
			throw e;
		} finally {
			Mis.releaseNotificationId(id, true);
			Mis.releaseParameters(id);
		}
	},
	
	update: function(url, params, targetId, opts) {
		var id = null;
		var error = null;
		try {
			if (Mis.isNull(url))
				return;
			
			var progress = null;
			if (!Mis.isNull(opts)) {
				progress = Mis.toNull(opts["progress"]);
				error = Mis.toNull(opts["error"]);
			}
			
			// get id
			params = Mis.toDefault(params, new Object());
			id = Mis.getId(params);
			
			// set parameters
			Mis.setParameters(id, {url: url, params: params, targetId: targetId, opts: opts});
			
			// progress
			if (!Mis.isNull(progress)) {
				opts["progress"] = null;
				var notiId = Mis.popupNotification(progress);
				Mis.setNotificationId(id, notiId);
				Mis.update(url, params, targetId, opts);
				return;
			}
			
			// update
			if (!Mis.isNull(targetId)) {
				var target = document.getElementById(targetId);
				if (!Mis.isNull(target))
					target.innerHTML = "";
			}
			var updater = new Ajax.Updater({success: targetId}, url, {
									method: "post", parameters: params, asynchronous: true, 
									onComplete: Mis.onUpdateComplete, onException: Mis.onServiceException});
		} catch (e) {
			Mis.releaseNotificationId(id, false);
			Mis.releaseParameters(id);
		}
	},
	
	onUpdateComplete: function(res) {
		var id = null;
		try {
			var params = res.request.parameters;
			
			id = Mis.getId(params);
			// TODO
			var paramMap = Mis.getParameters(id);
			if (!Mis.isNull(paramMap)) {
				var opts = paramMap["opts"];
				if (!Mis.isNull(opts)) {
					var callback = opts["callback"];
					if (!Mis.isNull(callback)) {
						try {
							Mis.call(callback, new ResponseMessage("update", paramMap, res.responseText));
						} catch (e) {
						}
					}
				}
			}
			
		} catch (e) {
		} finally {
			Mis.releaseNotificationId(id, true);
			Mis.releaseParameters(id);
		}
	},
	
	call: function(func, param, param1, param2, param3, param4) {
		if (Mis.isNull(func))
			return;
		
		var funcStr = new String(func);
		if (funcStr.include("function")) {
			Mis._call(func, param, param1, param2, param3, param4);
		} else if (funcStr.include(" ") || funcStr.include("	") || funcStr.include("(") || funcStr.include(";")) {
			eval(func);
		} else {
			Mis._call(func, param, param1, param2, param3, param4);
		}
	},
	// private
	_call: function(func, param, param1, param2, param3, param4) {
		if (!Mis.isNull(param4)) {
			func(param, param1, param2, param3, param4);
		} else if (!Mis.isNull(param3)) {
			func(param, param1, param2, param3);
		} else if (!Mis.isNull(param2)) {
			func(param, param1, param2);
		} else if (!Mis.isNull(param1)) {
			func(param, param1);
		} else if (!Mis.isNull(param)) {
			func(param);
		} else {
			func();
		}
	},
	
	onServiceException: function(res, e) {
		var id = null;
		try {
			var parameters = res.request.parameters;
			id = Mis.getId(parameters);
			
			var error = null;
			var params = Mis.getParameters(id);
			if (!Mis.isNull(params))
				error = params["error"];
			
			if (!Mis.isNull(error))
				Mis.popupWarning(error, e.name + ": " + e.message);
			
		} catch (e) {
		} finally {
			Mis.releaseNotificationId(id, false);
			Mis.releaseParameters(id);
		}
	}
};