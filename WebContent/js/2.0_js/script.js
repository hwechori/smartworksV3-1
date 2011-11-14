var notifyMessage_url = getPath() + "/common/dialog/notification.jsp";
var confirmMessage_url = getPath() + "/common/dialog/confirmation.jsp";
var warnMessage_url = getPath() + "/common/dialog/warning.jsp";
var alertMessage_url = getPath() + "/common/dialog/alert.jsp";
var requestDefault_url = getPath() + "/common/SmartApi.jsp";
var popupSendMailModalDialog_url = getPath() + "/common/dialog/sendMail.jsp";
var popupNameDescModalDialog_url = getPath() + "/common/dialog/nameDesc.jsp";
var popupWorkDefListModalDialog_url = getPath() + "/common/dialog/workDefList.jsp";
var searchWorkDefs_url = getPath() + "/common/dialog/workDefListTable.jsp";
var searchWorkDefs_target = "workDefListDiv";

var noHeaderBuilderYn = false;

var path = null;
function getPath() {
	if (path != null)
		return path;
	var host = location.host;
	var offset = location.href.indexOf(host) + host.length;
	path = location.href.substring(offset, location.href.indexOf("/", offset + 1));
	return path;
}
/*
String.prototype.startsWith = function(str) {
	return (this.match("^"+str)==str);
};
*/
function isNull(param) {
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
		} catch (e) {
			return false;
		}
	}
	if (tempParam == "true" || tempParam == "false" || tempParam == "0" || tempParam =="1" )
		return false;
	return param == "" || param == "null" || param == "undefined";
}
function toNull(param) {
	return isNull(param)? null : param;
}
function toNotNull(param) {
	return isNull(param)? "" : param;
}
function toDefault(param, defaultResult) {
	return isNull(param)? defaultResult : param;
}
function isEmpty(param) {
	try {
		return param.length <= 0;
	} catch (e) {
	}
	return true;
}
function toBoolean(param, defaultValue) {
	if (isNull(param))
		return toBoolean(defaultValue, false);
	if (param == true || param == "true" || param == "yes" || param == "on")
		return true;
	return false;
}
Array.prototype.remove = function(from, to) {
	var rest = this.slice((to || from) + 1 || this.length);
	this.length = from < 0 ? this.length + from : from;
	return this.push.apply(this, rest);
};
function add(array, obj) {
	if (isNull(array))
		array = new Array();
	array[array.length] = obj;
	return array;
}
function indexOf(array, obj) {
	var objIndex = -1;
	if (isEmpty(array) || isNull(obj))
		return objIndex;
	for (var i=0; i<array.length; i++) {
		if (array[i] != obj)
			continue;
		objIndex = i;
		break;
	}
	return objIndex;
}
function remove(array, obj) {
	var objIndex = indexOf(array, obj);
	if (objIndex == -1)
		return;
	array.remove(objIndex);
}
function put(array, obj) {
	array = add(array, obj);
	return array;
}
function pop(array) {
	if (isEmpty(array))
		return null;
	var obj = array[array.length-1];
	array.remove(array.length-1);
	return obj;
}
function show(id) {
	var obj = document.getElementById(id);
	if (obj == null)
		return;
	
	obj.style.display = "block";
	var scope = document.getElementById(id + "Content");
	if (scope == null)
		return;

	//scope.style.left = document.body.clientWidth/2 - scope.offsetWidth/2 + "px"; //no dtd
	//scope.style.top = document.body.clientHeight/2 - scope.offsetHeight/2 + "px";
	scope.style.left = document.documentElement.offsetWidth/2 - scope.offsetWidth/2 + "px";	//use dtd
	
	if(!noHeaderBuilderYn){
		//원본
		scope.style.top = document.documentElement.scrollTop + document.documentElement.clientHeight/2 - scope.offsetHeight/2 + "px";
	}else{
		//법무
		scope.style.top = document.documentElement.scrollTop + document.documentElement.clientHeight/2 - scope.offsetHeight/2 + 300 +"px";
	}
}
function hide(id) {
	var obj = document.getElementById(id);
	if (obj == null)
		return
	obj.style.display = "none";
}
function bold(id) {
	var obj = document.getElementById(id);
	if (obj == null)
		return;
	obj.style.fontWeight = "bold";
}
function unbold(id) {
	var obj = document.getElementById(id);
	if (obj == null)
		return;
	obj.style.fontWeight = "";
}

function execute(func, defaultValue, error) {
	var ret = null;
	try {
		ret = toDefault(func(), defaultValue);
	} catch (e) {
		if (!isNull(error))
			warnMessage(error, e.message);
	} finally {
		if (isNull(ret))
			ret = toNull(defaultValue);
	}
	return ret;
}

function getXmlDOM(xmlval) {
	var xmlDoc;
	if(window.DOMParser) {//파이어 폭스
		var parser = new DOMParser();
		xmlDoc = parser.parseFromString(xmlval, "text/xml");
		return xmlDoc;
	} else if(window.ActiveXObject) {
		xmlDoc = new ActiveXObject("Microsoft.XMLDOM");
		xmlDoc.async = "false";
		xmlDoc.loadXML(xmlval);
		return xmlDoc;
	} else {
		alert('문자열로부터 XML DOM을 만들 수 없습니다.');
		return null;
	}
}

/**
 * 중복 함수 제거 (2010-03-30)
 */
//function toDocument(xmlStr) {
//	var doc;
//	if (window.DOMParser) {
//		var parser = new DOMParser();
//		doc = parser.parseFromString(xmlStr, "text/xml");
//	} else if(window.ActiveXObject) {
//		doc = new ActiveXObject("Microsoft.XMLDOM");
//		doc.async = "false";
//		doc.loadXML(xmlStr);
//	} else {
//		alert("문자열로부터 XML DOM을 만들 수 없습니다.");
//		return null;
//	}
//	return doc;
//}
/**
 * IE 전용 로직 제거 (2010-03-30)
 * @param rootElem
 * @return
 */
//function cleanWhitespace(element) {
//    //element = document.getElementById(element);
//    var node = element.firstChild;
//    while (node) {
//      var nextNode = node.nextSibling;
//      if (node.nodeType == 3 && !/\S/.test(node.nodeValue))
//        element.removeChild(node);
//      node = nextNode;
//    }
//    return element;
//}
//function getFirstChild(node) {
//	//var node = cleanWhitespace(node);
//	var child = node.firstChild;
//	while (child.nodeType != 1)
//		child = child.nextSibling;
//	return child;
//}
//function unwrapResult(result) {
//	var doc = getXmlDOM(result);
//	//alert(SmartXMLUtil.getXMLString(doc));
//	var root = doc.documentElement;
//	var status = root.getAttribute("status");
//	if (status == "failure" || status == "failed" || status == "fail" || status == "Failed")
//		throw new Error(getErrorCode(root));
//	var obj = getFirstChild(root);
//	return obj;
//}
//function toHash(node) {
//	//var node = cleanWhitespace(node);
//	var attrs = node.attributes;
//	var elems = node.childNodes;
//	if (isEmpty(attrs) && isEmpty(elems))
//		return null;
//		
//	var result = new Object();
//	if (!isEmpty(attrs)) {
//		//alert(attrs.length);
//		for (var i=0; i<attrs.length; i++) {
//			var attr = attrs[i];
//			result[attr.nodeName] = attr.nodeValue;
//		}
//	}
//	if (!isEmpty(elems)) {
//		//alert(elems.length);
//		for (var i=0; i<elems.length; i++) {
//			var elem = elems[i];
//			if (elem.nodeType != 1)
//				continue;
//			result[elem.nodeName] = elem.text; //elem.firstChild.nodeValue;
//		}
//	}
//	return result;
//}
//function toHashResult(result) {
//	return toHash(unwrapResult(result));
//}
//function getErrorCode(rootElem) {
//	var exc = getFirstChild(rootElem);
//	var errorCode = exc.getAttribute("errorCode");
//	if (isNull(errorCode))
//		errorCode = exc.text;
//	return errorCode;
//}

function getErrorCode(rootElem) {
	var	errorCode = rootElem.firstChild.firstChild.nodeValue;
	return errorCode;
}


document.write("<iframe id=\"tmpFrame\" name=\"tmpFrame\" style=\"display: none;\"></iframe>");
document.write("<div id=\"divDiv\" style=\"position: absolute; z-index: 100;\"></div>");
var notiDivIds = new Array();
var modalDivIds = new Array();
var modalDivFuncs = new Object();
var modalIndex = 0;
function getModalDialog(response, isNoti) {
//	while (document.getElementById("modalDiv" + modalIndex) != null && document.getElementById("modalDiv" + modalIndex).style.display == "block")
//		modalIndex++;
	modalIndex = modalIndex + 5;
	var id = "modalDiv" + modalIndex;
	if (isNull(response))
		response = "null";
	var nextModalDiv = document.getElementById(id);
	if (nextModalDiv == null)
		createModalDialog(id, modalIndex);
	var nextModalDivTd = document.getElementById(id + "Content");
	if (nextModalDivTd != null)
		nextModalDivTd.innerHTML = "";
	if (isNoti) {
		notiDivIds = put(notiDivIds, id);
		modalDivFuncs[id] = response;
	} else {
		modalDivIds = put(modalDivIds, id);
		modalDivFuncs[id] = response;
	}
	return id;
}
function releaseModalDialog(isOk, id, isNoti, delay) {
	
	isOk = toBoolean(isOk);
	isNoti = toBoolean(isNoti);
	if (isNoti) {
		if (isNull(id))
			id = pop(notiDivIds);
		else
			remove(notiDivIds, id);
	} else {
		if (isNull(id))
			id = pop(modalDivIds);
		else
			remove(modalDivIds, id)
	}
	if (isNull(id))
		return null;
	var func = modalDivFuncs[id];
	modalDivFuncs[id] = null;
	if (isNull(delay) || delay <= 0) {
		postReleaseModalDialog(id, isNoti, isOk, func);
	} else {
		var method = "postReleaseModalDialog('" + id + "', " + isNoti + ", " + isOk + ", " + func +  ")";
		setTimeout(method, delay);
	}
	return id;
}
function postReleaseModalDialog(id, isNoti, isOk, func) {
	if (isOk && !isNull(func)) {
		try {
			func();
		} catch (e) {
			if (!isNoti) {
				modalDivFuncs[id] = func;
				modalDivIds = put(modalDivIds, id);
			}
			warnMessage(e.name, e.message);
			if (isNoti)
				hideModalDialog(id);
			return;
		}
	}
	hideModalDialog(id);
}
function hideModalDialog(id) {
	var div = document.getElementById(id);
	var td= document.getElementById(id + "Content");
	if (td != null)
		td.innerHTML = "";
	if (div != null)
		div.innerHTML = "";
	hide(id);

	// 업무처리 화면위에 div를 띄웠다가 없앴을 경우 select 활성화(IE6.0이하에서는 select가 항상 위에 옴)	
/*
	try {
		if(navigator.userAgent.indexOf("MSIE 6") != -1 || navigator.userAgent.indexOf("MSIE 5") != -1) {
			var selects = document.getElementsByTagName("select");
			var length = selects.length;
			for (i=0; i<length; i++){
				var obj = selects[i];
				obj.style.display = "";
			}
		}
	} catch (e) {
		return;
	}
*/
}
var modalZIndex = 50;
function createModalDialog(id, zIndex, width, height, left, top) {
	modalZIndex ++;
	if (isNull(id))
		return null;
	var divDiv = document.getElementById("divDiv");
	if (divDiv == null)
		return null;
	if (isNull(zIndex))
		zIndex = modalZIndex;
	if (isNull(width))
		width = document.body.scrollWidth;//"100%";
	if (isNull(height)) {
		height = document.body.scrollHeight;//"100%";
		if (height < document.body.offsetHeight) {
			height = document.body.offsetHeight;
		}
	}
	if (isNull(left))
		left = 0;
	if (isNull(top))
		top = document.body.scrollTop;
	var cttZIndex = zIndex + 3;
	var tdId = id + "Content";
/*
	var divStr = "<div id=\""+id+"\" style=\"";
	divStr += "width: "+width+"; height: "+height+"; position: absolute; z-index: "+zIndex+"; left: "+left+"; top: "+top+"; text-align: \"center\" display: none;\">";
	divStr += "<div style=\"background-color: #ffffff; opacity: .30; filter: alpha(opacity=30); -moz-opacity: 0.3;";
	divStr += "width: "+width+"; height: "+height+"; position: absolute; z-index: -1; left: 0px; top: 0px\">";
	divStr += "</div>";
//	divStr += "<iframe id="HelpShim"  scrolling="no" frameborder="0" style="left: 20px; position: absolute; top: 20px; z-index:1; width:200px;height:100px;"></iframe>";
	divStr += "<table cellpadding=\"0\" cellspacing=\"0\" style=\"width: 100%; height: 100%;\"><tr><td id=\""+tdId+"\" style=\"text-align: center;\"></td></tr></table>";
	divStr += "</div>";
*/	
	var divStr = "<div id=\""+id+"\" style=\"padding: 0px 0px 0px 0px;";
	divStr += "width: " + width + "px; height: " + height + "px; left: " + left + "px; top: " + top + "px; position: absolute; z-index: " + zIndex + "; display: none;\">";
	divStr += "<div style=\"background-color: #ffffff; opacity: .30; filter: alpha(opacity=30); -moz-opacity: 0.3;";
	divStr += "width: 100%; height: 100%; position: absolute; z-index: -1;";
	divStr += "padding: 0px 0px 0px 0px; overflowX: hidden; overflowY: hidden;\">";
	divStr += "</div>";
	divStr += "<div id=\"" + tdId + "\" style=\"position: absolute;\"></div>";
	divStr += "</div>";
	divDiv.innerHTML += divStr;
	
	hide(id);
	return id;
}
function popupModalDialog(url, params, response) {
	var modalId = getModalDialog(response);
	var modalTdId = modalId + "Content";
	send(url, modalTdId, params);
	show(modalId);
	//IE6.0이하에서는 select가 항상 위에 옴
/*	
	try {
		if(navigator.userAgent.indexOf("MSIE 6") != -1 || navigator.userAgent.indexOf("MSIE 5") != -1) {
			var selects = document.getElementsByTagName("select");
			var length = selects.length;
			for (i=0; i<length; i++){
				var obj = selects[i];
				obj.style.display = "none";
			}
		}
	} catch (e) {
		return;
	}
*/
}
function sleep(delay) {
	var start = new Date().getTime();
	while (new Date().getTime() < start + delay)
		;
}

var notifyMessageDates;
var notifyMessageMinTimes;
function notifyMessage(msg, minTime, response, style) {
	var modalId = getModalDialog(response, true);
	var url = notifyMessage_url;
	var modalTdId = modalId + "Content";
	var params = new Array();
	params.push("message=" + toNotNull(msg));
	params.push("style=" + toNotNull(style));
	params = params.join("&");
	if (isNull(minTime))
		minTime = 1000;
	notifyMessageDates = put(notifyMessageDates, new Date());
	notifyMessageMinTimes = put(notifyMessageMinTimes, minTime);
	send(url, modalTdId, params);
	show(modalId);
	return modalId;
}
function notifyMessageResult(isOk, id) {
	if (isOk == null || isOk == "undefined")
		isOk = true;
	var minTime = pop(notifyMessageMinTimes);
	var date = pop(notifyMessageDates);
	var rest;
	if (!isNull(minTime))
		rest = minTime - (new Date().getTime() - date.getTime());
	releaseModalDialog(isOk, id, true, rest);
}

function confirmMessage(msg, response) {
	var modalId = getModalDialog(response);
	var url = confirmMessage_url;
	var modalTdId = modalId + "Content";
	var params = new Array();
	params.push("message=" + toNotNull(msg));
	params = params.join("&");
	send(url, modalTdId, params);
	show(modalId);
	//IE6.0이하에서는 select가 항상 위에 옴
/*
	try {
		if(navigator.userAgent.indexOf("MSIE 6") != -1 || navigator.userAgent.indexOf("MSIE 5") != -1) {
			var selects = document.getElementsByTagName("select");
			var length = selects.length;
			for (i=0; i<length; i++){
				var obj = selects[i];
				obj.style.display = "none";
			}
		}
	} catch (e) {
		return;
	}
*/	
	return modalId;
}
function confirmMessageResult(isOk) {
	releaseModalDialog(isOk);
}

function warnMessage(msg, detail, response) {
	var modalId = getModalDialog(response);
	var url = warnMessage_url;
	var modalTdId = modalId + "Content";
	var params = new Array();
	params.push("message=" + toNotNull(msg));
	params.push("detail=" + toNotNull(detail));
	params = params.join("&");
	send(url, modalTdId, params);
	show(modalId);
	return modalId;
}
function warnMessageResult(isOk) {
	if (isOk == null || isOk == "undefined")
		isOk = true;
	releaseModalDialog(isOk);
}

function alertMessage(msg, detail, response) {
	var modalId = getModalDialog(response);
	var url = alertMessage_url;
	var modalTdId = modalId + "Content";
	var params = new Array();
	params.push("message=" + toNotNull(msg));
	params.push("detail=" + toNotNull(detail));
	params = params.join("&");
	
	send(url, modalTdId, params);
	show(modalId);
	return modalId;
}
function alertMessage_url(isOk) {
	if (isOk == null || isOk == "undefined")
		isOk = true;
	releaseModalDialog(isOk);
}

function getParameter(params, key) {
	if (params instanceof Object) {
		
	} else {
	}
}
function setParameter(params, key, value) {
	if (isNull(params) || isNull(key))
		return;
	if (params instanceof Object) {
		params[key] = value;
	} else {
		params += "&" + key + "=" + value;
	}
}

var requestUrl = null;
var requestParams = null;
var requestResponse = null;
var requestProgress = null;
var requestComplete = null;
var requestError = null;
var requestResult = null;
var requestResultXml = null;
var requestNotiId = null;
function request(url, params, response, confirm, progress, complete, error, isAsync) {
	//alert("request : "+url+" || param : "+params+" || response : "+response);
	// 확인 대화상자
	if (!isNull(confirm)) {
		try {
			requestParamsNull();
			if (!isNull(url))
				requestUrl = url;
			if (!isNull(params))
				requestParams = params;
			if (!isNull(response))
				requestResponse = response;
			if (!isNull(progress))
				requestProgress = progress;
			if (!isNull(complete))
				requestComplete = complete;
			if (!isNull(error))
				requestError = error;
			confirmMessage(confirm, request);
		} catch (e) {
			onRequestException(null, e);
		}
		return getResult();
	}
	
	// 진행중 대화상자
	if (isNull(progress) && !isNull(requestProgress))
		progress = requestProgress;
	requestProgress = null;
	if (!isNull(progress)) {
		try {
			if (!isNull(url))
				requestUrl = url;
			if (!isNull(params))
				requestParams = params;
			if (!isNull(response))
				requestResponse = response;
			if (!isNull(complete))
				requestComplete = complete;
			if (!isNull(error))
				requestError = error;
			requestNotiId = notifyMessage(progress, null, requestResponse);
			requestResponse = null;
			request(requestUrl, requestParams, null, null, null, requestComplete, requestError, true);
		} catch (e) {
			onRequestException(null, e);
		}
		return getResult();
	}
	
	// 실행
	try {
		if (isNull(url) && !isNull(requestUrl))
			url = requestUrl;
		if (isNull(params) && !isNull(requestParams))
			params = requestParams;
		if (!isNull(response))
			requestResponse = response;
		if (!isNull(complete))
			requestComplete = complete;
		if (!isNull(error))
			requestError = error;
		if (isNull(url))
			url = requestDefault_url;
		var parameters = null;
		if (!isNull(requestNotiId)) {
			if (params instanceof Object) {
				parameters = params;
				params = null;
			} else {
				parameters = new Object();
			}
			parameters["notifyMessageId"] = requestNotiId;
		}
		//alert(url+"//"+params);
		var ajaxReq = new Ajax.Request(url, {method: "post", postBody: params, parameters: parameters, onComplete: onRequestResponse, onException: onRequestException, asynchronous: isAsync});
	} catch (e) {
		onRequestException(null, e);
	}
	return getResult();
}
function getResult() {
	return requestResult;
}
function getResultXml() {
	return requestResultXml;
}
function requestParamsNull() {
	requestUrl = null;
	requestParams = null;
	requestResponse = null;
	requestProgress = null;
	requestComplete = null;
	requestError = null;
}
function onRequestResponse(res) {
	var isOk = false;
	var parameters = null;
	try {
		parameters = res.request.parameters;
		requestResult = res.responseText;
		requestResultXml = res.responseXML;
		var error = requestError;
		var response = requestResponse;
		requestParamsNull();
		if (!isNull(error) && !isNull(requestResult)) {
			try {
				var doc = getXmlDOM(requestResult.trim());
				var root = doc.documentElement;
				var status = root.getAttribute("status");
				if (status == "failure" || status == "failed" || status == "fail" || status == "Failed") {
					var errorCode = getErrorCode(root);
					warnMessage(error, errorCode);
					return;
				}
			} catch (e) {
			}
		}
		
		isOk = true;
		if (isNull(response))
			return;
		response();
	} catch (e) {
	} finally {
		var notiId = null;
		if (!isNull(parameters) && !isNull(parameters["notifyMessageId"])) {
			notiId = parameters["notifyMessageId"];
		} else {
			notiId = requestNotiId;
		}
		notifyMessageResult(isOk, notiId);
		requestNotiId = null;
	}
}
function onRequestException(res, e) {
	try {
		var error = requestError;
		requestParamsNull();
		if (isNull(error))
			return;
		warnMessage(error, e.name + ": " + e.message);
	} catch (e) {
	} finally {
		requestResult = null;
		requestResultXml = null;
		notifyMessageResult(false, requestNotiId);
		requestNotiId = null;
	}
}

var updateResponse;
var updateError;
var updateNotiId;
function update(url, targetId, params, response, progress, error, isAsync) {

	if (isNull(url))
		return;
	//isAsync = toBoolean(isAsync);
	
/*	if (!isNull(progress)) {
		try {
			updateNotiId = notifyMessage(progress, 0, response);
			update(url, targetId, params, null, null, error, true);
		} catch (e) {
			onUpdateException(null, e);
		}
		return;
	}*/
	try {
		updateResponse = null;
		updateError = null;
		if (!isNull(response))
			updateResponse = response;
		if (!isNull(error))
			updateError = error;
		if (!isNull(targetId)) {
			var target = document.getElementById(targetId);
			if (!isNull(target))
				target.innerHTML = "";
		}
		if (isNull(params)) {
			var updater = new Ajax.Updater({success: targetId}, url, {method: "get", asynchronous: isAsync, onComplete: onUpdateResponse, onException: onUpdateException});
		} else {
			var updater = new Ajax.Updater({success: targetId}, url, {method: "post", asynchronous: isAsync, parameters: params, onComplete: onUpdateResponse, onException: onUpdateException});
		}
	} catch (e) {
		onUpdateException(null, e);
	}
}
function onUpdateResponse(res) {
	var isOk = false;
	try {
		var response = updateResponse;
		isOk = true;
		if (isNull(response))
			return;
		updateResponse = null;
		response();
	} catch (e) {
	} finally {
		notifyMessageResult(isOk, updateNotiId);
	}
}
function onUpdateException(res, e) {
	try {
		var error = updateError;
		if (isNull(error))
			return;
		updateError = null;
		//warnMessage(error, e.name + ": " + e.message);
	} catch (e) {
	} finally {
		notifyMessageResult(false, updateNotiId);
	}
}

function send(url, targetId, params, response, isAsync) {
	if (isNull(url))
		return;
	isAsync = toBoolean(isAsync);
	if (isNull(response))
		response = null;
	try {
		if (isNull(params)) {
			var updater = new Ajax.Updater({success: targetId}, url, {method: "get", asynchronous: isAsync, onComplete: response, onException: onSendException});
		} else {
			var updater = new Ajax.Updater({success: targetId}, url, {method: "post", asynchronous: isAsync, parameters: params, onComplete: response, onException: onSendException});
		}
	} catch (e) {
		throw e;
	} finally {
		
	}
}
function onSendException(res, e) {
	try {
		warnMessage(e.name, e.message);
	} catch (e) {
	} finally {
	}
}

/**
 * 삭제예정 (2010-03-29)
 */
//function getUserId() {
//	var result = request(null, "method=getUserId");
//	var doc = getXmlDOM(result);
//	var root = doc.documentElement;
//	var status = root.getAttribute("status");
//	if (status == "failure" || status == "failed" || status == "fail" || status == "Failed")
//		throw new Error(getErrorCode(root));
//	return root.text;
//}
//function getUser(id) {
//	var result = request(null, "method=getUser&id="+id);
//	return toHashResult(result);
//}


function popupNameDescModalDialog(title, response, id, name, desc, isEnableDesc) {
	var url = popupNameDescModalDialog_url;
	var params = new Array();
	params.push("title=" + toNotNull(title));
	params.push("id=" + toNotNull(id));
	params.push("name=" + toNotNull(name));
	params.push("desc=" + toNotNull(desc));
	params.push("isEnableDesc=" + toNotNull(isEnableDesc));
	params = params.join("&");
	popupModalDialog(url, params, response);
}

function popupWorkDefListModalDialog(title, response, type, status) {
	var url = popupWorkDefListModalDialog_url;
	var params = new Array();
	params.push("title=" + toNotNull(title));
	params.push("type=" + toNotNull(type));
	params.push("status=" + toNotNull(status));
	params = params.join("&"); 
	popupModalDialog(url, params, response);
	document.searchWorkDefsForm.searchWord.focus();
}
function searchWorkDefs(pageNo) {
	setTimeout("_searchWorkDefs(" + pageNo + ")", 10);
}
function _searchWorkDefs(pageNo) {
	if (isNull(pageNo))
		pageNo = toNotNull(execute(function() {return document.searchWorkDefsForm.pageNo.value;}));
	var pageSize = toNotNull(execute(function() {return document.searchWorkDefsForm.pageSize.value;}));
	var searchWord = toNotNull(execute(function() {return document.searchWorkDefsForm.searchWord.value;}));
	var type = toNotNull(execute(function() {return document.searchWorkDefsForm.type.value;}));
	
	var url = searchWorkDefs_url;
	var target = searchWorkDefs_target;
	var params = new Array();
	params.push("pageNo=" + pageNo);
	params.push("pageSize=" + pageSize);
	params.push("searchWord=" + searchWord);
	params.push("type=" + type);
	params = params.join("&");
	update(url, target, params, null, "loading", "failed");
}

function isValidMail(mail) {
	if(isNull(mail))
 		return false;
	var splitted = mail.match("^(.+)@(.+)$");
	if(isNull(splitted) || isEmpty(splitted))
		return false;
	if(splitted[1] != null ){
		var regexp_user=/^\"?[\w-_\.]*\"?$/;
		if(splitted[1].match(regexp_user) == null)
			return false;
	}
	if(splitted[2] != null){
		var regexp_domain=/^[\w-\.]*\.[A-Za-z]{2,4}$/;
		if(splitted[2].match(regexp_domain) == null){
	 		var regexp_ip =/^\[\d{1,3}\.\d{1,3}\.\d{1,3}\.\d{1,3}\]$/;
	 		if(splitted[2].match(regexp_ip) == null) 
	 			return false;
 		}
	 return true;
	}
	return false;
}
function popupSendMailModalDialog(subject, from, to, cc, content) {
	var url = popupSendMailModalDialog_url;
	var params = new Array();
	params.push("subject=" + toNotNull(subject));
	params.push("from=" + toNotNull(from));
	params.push("to=" + toNotNull(to));
	params.push("cc=" + toNotNull(cc));
	params.push("content=" + toNotNull(content));
	params = params.join("&");
	popupModalDialog(url, params, sendMail);
}
function sendMail(subject, from, to, cc, content) {
	if (isNull(subject))
		subject = execute(function() {return document.sendMailForm.subject.value;});
	if (isNull(from))
		from = execute(function() {return document.sendMailForm.from.value;});
	if (isNull(to))
		to = execute(function() {return document.sendMailForm.to.value;});
	if (isNull(cc))
		cc = execute(function() {return document.sendMailForm.cc.value;});
	if (isNull(content))
		content = execute(function() {return document.sendMailForm.content.value;});
	
	if (isNull(subject)) {
		throw new Error("errorCodeNullSubject");
	} else if (isNull(from)) {
		throw new Error("errorCodeNullMailFrom");
	} else if (isNull(to)) {
		throw new Error("errorCodeNullMailTo");
	} else if (isNull(content)) {
		throw new Error("errorCodeNullContent");
	}
	
	var params = new Array();
	params.push("method=sendMail");
	params.push("subject=" + toNotNull(subject));
	params.push("from=" + toNotNull(from));
	params.push("to=" + toNotNull(to));
	params.push("cc=" + toNotNull(cc));
	params.push("content=" + toNotNull(content));
	params = params.join("&");
	request(null, params, null, null, "notifySendProgress", null, "warnSendFailed");
}
	
var prevColor = null;
function onObjectOver(obj, color) {
	if (obj == null)
		return;
	prevColor = obj.style.backgroundColor;
	obj.style.backgroundColor = color;
}
function onObjectOut(obj) {
	if (obj == null || prevColor == null)
		return;
	obj.style.backgroundColor = prevColor;
}

//function time() {
//	if (!document.layers && !document.all && !document.getElementById)
//		return;
//
//	var Digital = new Date();
//	var hours = Digital.getHours();
//	var minutes = Digital.getMinutes();
//	var seconds = Digital.getSeconds();
//
//	var dn = "PM";
//	if (hours < 12)
//		dn = "AM";
//	if (hours > 12)
//		hours = hours - 12;
//	if (hours == 0)
//		hours = 12;
//	if (minutes <= 9)
//		minutes = "0" + minutes;
//	if (seconds <= 9)
//		seconds = "0" + seconds;
//
//	var timeStr = dn + " " + hours + ":" + minutes + ":" + seconds;
//	document.getElementById("timeSpan").innerHTML = timeStr;
//	setTimeout("time()", 1000);
//}

function time() {
	if (!document.layers && !document.all && !document.getElementById)
		return;

	var Digital = new Date();
	var hours = Digital.getHours();
	var minutes = Digital.getMinutes();
	var seconds = Digital.getSeconds();
	
	if (minutes <= 9)
		minutes = "0" + minutes;
	if (seconds <= 9)
		seconds = "0" + seconds;

	var timeStr = hours + ":" + minutes + ":" + seconds;
	document.getElementById("timeSpan").innerHTML = timeStr;
	setTimeout("time()", 1000);
}
	
function newXmlHttp() {
	try {
		if (window.XMLHttpRequest) {
			return new XMLHttpRequest();
		} else {
			return new ActiveXObject("Microsoft.XMLHTTP");
		}
	} catch (e) {
		return null;
	}
}

function sendPost(url, targetId, params, handler, isAsync) {
	if (isNull(url))
		return;
	if (isNull(isAsync))
		isAsync = false;
	var updater = new Ajax.Updater({success: targetId}, url, {method: "post", asynchronous: isAsync, postBody: params, onSuccess: handler});	
}

function isNodeOpened(id) {
	var child = document.getElementById(id + "Child");
	if (child == null || child.style.display == "none")
		return false;
	return true;
}

function onNodeClicked(id, url) {
	if (id == null)
		return;
	
	// The node clicked
	var node = document.getElementById(id);
	// The node children space
	var td = document.getElementById(id + "Td");
	// The node children table
	var child = document.getElementById(id + "Child");
	
	if (child == null) {
		if (url != null) {
			if (td == null) {
				var table = document.getElementById(id + "Table");
				if (table != null) {
					var row = table.insertRow(-1);
					row.insertCell();
					var cell = row.insertCell();
					cell.id = id + "Td";
				}
			}
			//alert(url);
			send(url, id + "Td");
		}
	} else {
		//alert(url);
		if (child.style.display == "block") {
			child.style.display = "none";
		} else {
			child.style.display = "block";
		}
	}
}

var prevTabId  = null;
function onTabClicked(id, url, targetId) {

	if(targetId == "processListId" && prevTabId == null) {
		prevTabId = "history";
	}
			
	if (prevTabId != null) {
		var prevTabLeft = document.getElementById(prevTabId + "Left");
		var prevTab = document.getElementById(prevTabId);
		var prevTabRight = document.getElementById(prevTabId + "Right");
		prevTabLeft.style.background = "url('"+getPath()+"/image/tab_nor_01.PNG')";
		prevTab.style.background = "url('"+getPath()+"/image/tab_nor_03.PNG')";
		prevTabRight.style.background = "url('"+getPath()+"/image/tab_nor_02.PNG')";
	}
	
	var tabLeft = document.getElementById(id + "Left");
	var tab = document.getElementById(id);
	var tabRight = document.getElementById(id + "Right");
	tabLeft.style.background = "url('"+getPath()+"/image/tab_sel_01.PNG')";
	tab.style.background = "url('"+getPath()+"/image/tab_sel_03.PNG')";
	tabRight.style.background = "url('"+getPath()+"/image/tab_sel_02.PNG')";
	
	prevTabId = id;
	if (url == null)
		return;
	if (targetId == null)
		targetId = "mainTd";
	send(url, targetId);
}

function getMovie(name) {
	var movie;
	//movie = document.getElementById(name);
	if (navigator.appName.indexOf("Microsoft") == -1) {
		movie = document[name];
	} else {
		movie = window[name];
	}
	return movie;
}

function loadSWF(path, flashVars, objTd){
	var obj = '<object type="application:x-shockwave-flash" classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000"';
		obj += 'id="diagram" bgcolor="#ffffff" width="100%" height="100%" codebase="http://fpdownload.macromedia.com/pub/shockwave/cabs/flash/swflash.cab">';
		obj += '<param name="movie" value="' + path + '/swf/SmartWorkbenchEditor.swf"/>';
		obj += '<param name="flashVars" value="' + flashVars +'"/>';
		obj += '<param name="allowScriptAccess" value="allowScriptAccess"/>';
		obj += '<embed src="' + path + '/swf/SmartWorkbenchEditor.swf" wmode="transparent" quality="high" ';
		obj += 'bgcolor="#ffffff" width="100%" height="100%" ';
		obj += 'name="diagram" id="diagram" align="middle" play="true" loop="false" quality="high" allowScriptAccess="sameDomain" ';
		obj += 'type="application/x-shockwave-flash" pluginspage="http://www.adobe.com/go/getflashplayer" ';
		obj += 'flashVars="' + flashVars +'"/><param name="WMODE" value="TRANSPARENT"></embed>';
		obj += '</object>';
		objTd.innerHTML = obj;
}

function insertFlash(id, swfName, width, height, dns, wmode, bgColor, q, align) {
	document.write('<object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000"');
	document.write('codebase="http://fpdownload.macromedia.com/get/flashplayer/current/swflash.cab#version=8,0,22,0" ');
	document.write('id="'+id+'" WIDTH="' + width + '" HEIGHT="' + height + '" ALIGN="'+align+'">');
	document.write('<PARAM NAME="movie" VALUE="'+ swfName +'">');
	document.write('<PARAM NAME="quality" VALUE="'+q+'">');
	document.write('<PARAM NAME="bgcolor" VALUE="'+bgColor+'">');
	document.write('<PARAM NAME="wmode" VALUE="'+wmode+'">');
	document.write('<PARAM NAME="allowScriptAccess" VALUE="'+dns+'">');
	document.write('<EMBED id="' + id + '" SRC="'+ swfName +'"  NAME="'+id+'"');
	document.write(' WIDTH="' + width + '" HEIGHT="' + height + '" QUALITY="'+q+'" BGCOLOR="'+bgColor+'"');
	document.write(' ALLOWSCRIPTACCESS="'+dns+'" ALIGN="'+align+'" WMODE="'+wmode+'" TYPE="application/x-shockwave-flash" ');
	document.write(' PLUGINSPAGE="http://www.macromedia.com/go/getflashplayer" >');
	document.write('</EMBED>');
	document.write('</object>');
}
function insertSwf(id, path, flashVars, height) {
	if (height == null || height == "")
		height = "100%";
	
	var htm = "";
	htm = '<object type="application:x-shockwave-flash" classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000"';
	htm = htm + 'id="' + id + '" width="100%" height="' + height + '"';
	htm = htm + 'codebase="http://fpdownload.macromedia.com/get/flashplayer/current/swflash.cab">';
	htm = htm + '<param name="src" value="'+ path + '" />';
	htm = htm + '<param name="quality" value="high" />';
	htm = htm + '<param name="wmode" value="transparent">';
	htm = htm + '<param name="bgcolor" value="#ffffff" />';
	htm = htm + '<param name="allowScriptAccess" value="sameDomain" />';
	htm = htm + '<param name="flashVars" value="' + flashVars + '" />';
	htm = htm + '<embed src="' + path + '" wmode="transparent" quality="high" bgcolor="#ffffff"';
	htm = htm + '	width="100%" height="' + height + '" name="VinoTester" align="middle"';
	htm = htm + '	play="true"';
	htm = htm + '	loop="false"';
	htm = htm + '	quality="high"';
	htm = htm + '	allowScriptAccess="sameDomain"';
	htm = htm + '	type="application/x-shockwave-flash"';
	htm = htm + '	pluginspage="http://www.adobe.com/go/getflashplayer"';
	htm = htm + '	flashVars="' + flashVars + '">';
	htm = htm + '</embed>';
	htm = htm + '</object>';
	document.write(htm);
	/*
	if (targetId == null || targetId == "") {
		document.write(htm);
	} else {
		var target = document.getElementById(targetId);
		if (target != null) {
			var obj = document.createElement(htm);
			target.appendChild(obj);
		}
	}
	*/
}

function getText(el) {
  var text = "";
  if (el != null) {
    if (el.childNodes) {
      for (var i = 0; i < el.childNodes.length; i++) {
        var childNode = el.childNodes[i];
        if (childNode.nodeValue != null) {
          text = text + childNode.nodeValue;
        }
      }
    }
  }
  return text;
}

function reDefineSelectSingleNode(){
	if( document.implementation.hasFeature("XPath", "3.0") ) 
	{ 
	   // prototying the XMLDocument 
	   XMLDocument.prototype.selectSingleNode = function(cXPathString, xNode) 
	   { 
	      if( !xNode ) { xNode = this; } 
	      var xItems = this.selectNodes(cXPathString, xNode);
	      if( xItems.length > 0 ) 
	      { 
	         return xItems[0];
	      } 
	      else 
	      { 
	         return null;
	      } 
	   } 
	   
	   // prototying the Element 
	   Element.prototype.selectSingleNode = function(cXPathString) 
	   {	
	      if(this.ownerDocument.selectSingleNode) 
	      { 
	         return this.ownerDocument.selectSingleNode(cXPathString, this);
	      } 
	      else{throw "For XML Elements Only";} 
	   } 
	}		
}

function reDefineSelectNodes(){
	if( document.implementation.hasFeature("XPath", "3.0") ) 
	{ 
	   // prototying the XMLDocument 
	   XMLDocument.prototype.selectNodes = function(cXPathString, xNode) 
	   { 
	      if( !xNode ) { xNode = this; } 
	      var oNSResolver = this.createNSResolver(this.documentElement) 
	      var aItems = this.evaluate(cXPathString, xNode, oNSResolver, 
	                   XPathResult.ORDERED_NODE_SNAPSHOT_TYPE, null) 
	      var aResult = [];
	      for( var i = 0; i < aItems.snapshotLength; i++) 
	      { 
	         aResult[i] =  aItems.snapshotItem(i);
	      } 
	      return aResult;
	   } 
	   // prototying the Element 
	   Element.prototype.selectNodes = function(cXPathString) 
	   { 
	      if(this.ownerDocument.selectNodes) 
	      { 
		     return this.ownerDocument.selectNodes(cXPathString, this);
	      } 
	      else{throw "For XML Elements Only";} 
	   } 
	} 
}

function checknumber(obj){
	var digits="0123456789";
	var str = obj.value;
	for (var i=0; i < str.length; i++){
		temp = str.substring(i,i+1)
		if (digits.indexOf(temp) == -1){
			alert("숫자만 입력 하세요");
			obj.value = "";
			obj.focus();
			return false;
  		}
	}
	return true;
}

//날짜 체크 t document.formName.fileldName
function check_yymmdd(t){
	var msg  = "";
	var yy   = "";
	var mm   = "";
	var dd   = "";
	var result = false;
	var dd_max  = new Array(31,28,31,30,31,30,31,31,30,31,30,31);

	dd_max[1] = leapYear(yy);

	var temp = "";
	var sep = new Array(".","-","/"," ");

	if(t.value != ""){
		if(t.value.length == 10){
			for(i=0;i<4;i++){
				temp = t.value.split(sep[i]);
				if(temp != t.value){
					yy = temp[0];
					mm = temp[1];
					dd = temp[2];
					break;
				}
			}
		} else if(t.value.length == 8) {
			yy = t.value.substring(0,4);
			mm = t.value.substring(4,6);
			dd = t.value.substring(6,8);
		} else {
		    t.value = "";
			msg = "날짜8자리를 정확하게 입력하십시오\n ex)20000707,2000/07/07,2000-07-07,..";
		}
		if(msg == "") {
			if(isNaN(parseInt(yy,10))||isNaN(parseInt(mm,10))||isNaN(parseInt(dd,10))){
				msg = "년도/월/일을 숫자로 정확히 입력하십시오";
			} else {
				if ((( parseInt(yy,10) % 4 == 0 ) && ( parseInt(yy,10) % 100 != 0 )) || (parseInt(yy,10) % 400 == 0 )) {
					dd[1] = 29;
			    }
				if((parseInt(dd,10) > (dd_max[parseInt(mm,10)-1]))||(parseInt(dd,10) < 1)) {
					msg = "그달에 존재하지않는 날짜입니다 ";
				}
				if( (parseInt(mm,10) > 12)||(parseInt(mm,10) < 1)){
					msg = " 존재하지않는 월입니다 ";
				}
				if(parseInt(yy,10) < 1) {
				    msg = " 존재하지않는 년도입니다 ";
				}
			}
		}
		if(msg == "") {
		    t.value = yy + "-" + mm + "-" + dd;
		    result = true;
		} else {
		    t.value = "";
		    t.focus();
			alert(msg);
			result = false;
		}
	}
	return result;
}

function leapYear(year) {
	if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0)	return 29;
	return 28;
}


function replaceStr(str, oldStr, newStr) {
	var strValue = "";
	for(i=0; i < str.length; i++) {
		temp = str.substring(i,i+1)
		temp = temp.replace(oldStr, newStr);
		strValue = strValue+temp;
	}
	return strValue;
}

// 이메일 Check		-------------------------------------------------------------------------------------
function emailCheck(obj){
	var result = "true";
	if (obj.value == "" || obj.value == null){
		alert("이메일 주소를 입력하세요.");
		obj.focus();
		result = "false";
	} else {
		var email_addr = obj.value;
		var location1 = obj.value.indexOf('@',0) +1;
		if (location1 == 0){
			alert("이메일 주소를 정확히 입력하세요.") ;
			obj.value = "" ;
			obj.focus();
			result = "false";
		} else{
			var location2= obj.value.indexOf('.',0)+1;
			if (location2 == 0) {
				alert("이메일 주소를 정확히 입력하세요.");
				obj.value = "" ;
				obj.focus();
				result = "false";
			}
		}
		var i, strTestemail01;
		strTestemail01 = email_addr;
		if(strTestemail01.charAt(email_addr.length-1)=='@' || strTestemail01.charAt(email_addr.length-1)=='.'){
			alert("이메일 주소를 정확히 입력하세요.");
			obj.value = "" ;
			obj.focus();
			result = "false";
		}
		for (i=0; i<email_addr.length; i++){
			if( strTestemail01.charAt(i) >= 'a' && strTestemail01.charAt(i) <= 'z' )
				continue;
			if( strTestemail01.charAt(i) >= 'A' && strTestemail01.charAt(i) <= 'Z' )
				continue;
			if( strTestemail01.charAt(i) >='0' && strTestemail01.charAt(i) <='9')
				continue;
			if( strTestemail01.charAt(i) == '-' || strTestemail01.charAt(i) == '_' ||  strTestemail01.charAt(i) == '@' ||  strTestemail01.charAt(i) == '.')
				continue;
			alert("이메일 주소를 정확히 입력하세요.");
			obj.value = "" ;
			obj.focus();
			result = "false";
		}
	}
	return result;
}

// 이메일 Check		-------------------------------------------------------------------------------------
function emailCheckBoolean(obj){
	var result = "true";
	if (obj.value == "" || obj.value == null){
		obj.focus();
		result = "false";
	} else {
		var email_addr = obj.value;
		var location1 = obj.value.indexOf('@',0) +1;
		if (location1 == 0){
			obj.value = "" ;
			obj.focus();
			result = "false";
		} else{
			var location2= obj.value.indexOf('.',0)+1;
			if (location2 == 0) {
				obj.value = "" ;
				obj.focus();
				result = "false";
			}
		}
		var i, strTestemail01;
		strTestemail01 = email_addr;
		if(strTestemail01.charAt(email_addr.length-1)=='@' || strTestemail01.charAt(email_addr.length-1)=='.'){
			obj.value = "" ;
			obj.focus();
			result = "false";
		}
		for (i=0; i<email_addr.length; i++){
			if( strTestemail01.charAt(i) >= 'a' && strTestemail01.charAt(i) <= 'z' )
				continue;
			if( strTestemail01.charAt(i) >= 'A' && strTestemail01.charAt(i) <= 'Z' )
				continue;
			if( strTestemail01.charAt(i) >='0' && strTestemail01.charAt(i) <='9')
				continue;
			if( strTestemail01.charAt(i) == '-' || strTestemail01.charAt(i) == '_' ||  strTestemail01.charAt(i) == '@' ||  strTestemail01.charAt(i) == '.')
				continue;
			obj.value = "" ;
			obj.focus();
			result = "false";
		}
	}
	return result;
}
	
//날짜 체크 t document.formName.fileldName
function isValidDateYMD(obj){
	var msg  = "";
	var yy   = "";
	var mm   = "";
	var dd   = "";
	var dd_max  = new Array(31,28,31,30,31,30,31,31,30,31,30,31);

	dd_max[1] = leapYear(yy);

	var temp = "";
	var sep = new Array(".","-","/"," ");

	var t = obj;


	if(t.value != ""){
		if(t.value.length == 10){
			for(i=0;i<4;i++){
				temp = t.value.split(sep[i]);
				if(temp != t.value){
					yy = temp[0];
					mm = temp[1];
					dd = temp[2];
					break;
				}
			}
		} else if(t.value.length == 8) {
			yy = t.value.substring(0,4);
			mm = t.value.substring(4,6);
			dd = t.value.substring(6,8);
		} else {
		    t.value = "";
			msg = "날짜8자리를 정확하게 입력하십시오\n ex)20000707,2000/07/07,2000-07-07,..";
		}
		if(msg == "") {
			if(isNaN(parseInt(yy,10))||isNaN(parseInt(mm,10))||isNaN(parseInt(dd,10))){
				msg = "년도/월/일을 숫자로 정확히 입력하십시오";
			} else {
				if ((( parseInt(yy,10) % 4 == 0 ) && ( parseInt(yy,10) % 100 != 0 )) || (parseInt(yy,10) % 400 == 0 )) {
					dd[1] = 29;
			    }
				if((parseInt(dd,10) > (dd_max[parseInt(mm,10)-1]))||(parseInt(dd,10) < 1)) {
					msg = "그달에 존재하지않는 날짜입니다 ";
				}
				if( (parseInt(mm,10) > 12)||(parseInt(mm,10) < 1)){
					msg = " 존재하지않는 월입니다 ";
				}
				if(parseInt(yy,10) < 1) {
				    msg = " 존재하지않는 년도입니다 ";
				}
			}
		}
		if(msg == "") {
		    t.value = yy + "-" + mm + "-" + dd;
			return true;
		} else {
		    t.value = "";
		    t.focus();
			alert(msg);
			return false;
		}
	}
}

function removeAllRow(count, table){
   	var tableRowsLength = table.rows.length;
   	if(tableRowsLength > 0) {
		for(var i=tableRowsLength; i>count; i--){
	   		table.deleteRow(i-1);
	   	}
   	}
}

function createInputElement(type, name, value, width){
	if(!type) {
		return null;
	}
	if(!name) {
		return null;
	}
	if(!value) {
		value="";
	}
	
	var elementObj = null;
	// IE
	try{
		elementObj = document.createElement("<input type='"+type+"' name='"+name+"' value='"+value+"' style='width: "+width+"px;'>");
	// IE외
	}catch(e){
		elementObj = document.createElement('input');
		elementObj.type = type;
		elementObj.name = name;
		elementObj.value = value;
		elementObj.style.width = width+'px';
		//Element.setStyle(elementObj, {width: width});
	}
	return elementObj;
}

function createSelectElement(name, width){
	if(!name) {
		return null;
	}
	
	var elementObj = null;
	// IE
	try{
		elementObj = document.createElement("<select name='"+name+"' style='width: "+width+"px;'></select>");
	// IE외
	}catch(e){
		elementObj = document.createElement('select');
		elementObj.name = name;
		elementObj.style.width = width+'px';
		//Element.setStyle(elementObj, {width: width});
	}
	return elementObj;
}

function createOptions(selectNode, valueArray, nameArray) {
	for(var i=0; i < valueArray.length; i++) {
		var option = document.createElement("option");
		option.value = valueArray[i];
		selectNode.appendChild(option);
		option.appendChild(document.createTextNode(nameArray[i]));
	}
}


function removeAllOptions(selectNode) {
	var options = selectNode.getElementsByTagName("option");
	for(var i=options.length-1; i>-1 ; i--) {
		selectNode.removeChild(options[i]);
	}	
}

function removeChildNodes(parentNode, seq) {
	if(!seq)
		seq = 0;
	if(parentNode.hasChildNodes()) {
		for(var i=parentNode.childNodes.length; i>seq; i--) {
			var childNode = parentNode.childNodes.item(i-1);
			parentNode.removeChild(childNode);
		}
	}
}

function goAppStore() {
	if (location.host.indexOf('localhost') > -1 || location.host.indexOf('127.0.0.1') > -1 || location.host.indexOf('192.168.0.') > -1) {
		alertMessage('AppStore', 'LocalSmartWorksnetcannotsigntheAppStore', null);  //로컬 스마트웍스에서는 앱스토어에 로그인 하실 수 없습니다.
		//alert('로컬 스마트웍스에서는 앱스토어에 로그인 하실 수 없습니다.');
		return;
	}
	window.open('../shareBasket/goAppStore.jsp', 'appStore');
}

function setPng24(psImgObj) {	//for png in ie6 
	psImgObj.width = psImgObj.height = 1;
	psImgObj.className = psImgObj.className.replace(/\bpng24\b/i,'');
	psImgObj.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(src='"+ psImgObj.src +"',sizingMethod='image');";
	psImgObj.src = "";
	return "";
}

function setEmbed() {			//embed script(flash, etc)
	var obj;
	var parameter;
	var embed;
	var html;
	var allParameter;
	var clsid;
	var codebase;
	var pluginspace;
	var embedType;
	var src;
	var width;
	var height;
	var objId;
	
	// Main function
	this.init = function(getType , s ,w , h) {
		switch (getType) {
			case "flash":
				clsid = "D27CDB6E-AE6D-11cf-96B8-444553540000";
				codebase = "http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,29,0";
				pluginspage = "http://www.macromedia.com/go/getflashplayer";
				embedType = "application/x-shockwave-flash";
				break;
			default:
		}

		parameter = "<param name='movie' value='"+ s + "'>\n";
		parameter += "<param name='quality' value='high'>\n";

		src = s;
		width = w;
		height = h;
		objId = objId;
	};

	// Get parameters
	this.parameter = function(parm , value) {
		parameter += "<param name='" + parm + "' value='" + value + "'>\n";
		allParameter += " " + parm + "='" + value + "'";
	};

	// Show function
	this.show = function() {
		if (clsid) {
			obj = "<object classid=\"clsid:" + clsid + "\" codebase=\"" + codebase + "\" width='" + width + "' height='" + height + "'>\n";
		}
		embed = "<embed id=\"diagram\" src='" + src + "' pluginspage='" + pluginspage + "' type='" + embedType + "' width='" + width + "' height='" + height + "'" + allParameter + "></embed>\n";
		if (obj) {
			embed += "</object>\n";
		}
		html = obj + parameter + embed;
		document.write(html);
	};
}

/**
* 아이프레임 리사이즈
*/
function parentIframeSize(idname){
	iframeSize(idname);
}
function iframeSize(idname) {
	document.getElementById(idname).style.height = 0 + "px";
	var parentFrameObj = document.getElementById(idname);
	var iframeHeight = parentFrameObj.contentWindow.document.body.scrollHeight + 10;
	document.getElementById(idname).style.height = iframeHeight + "px";
}

function isEMail(obj){
	var str = obj.value;
	if (str == "") return true;
	emailEx1 = /[A-Za-z0-9_\-]@[A-Za-z0-9_\-]+\.[A-Za-z]+/;
	emailEx2 = /[A-Za-z0-9_\-]@[A-Za-z0-9_\-]+\.[A-Za-z0-9_\-]+\.[A-Za-z]+/;
	emailEx3 = /[A-Za-z0-9_\-]@[A-Za-z0-9_\-]+\.[A-Za-z0-9_\-]+\.[A-Za-z0-9_\-]+\.[A-Za-z]+/;
	if (emailEx1.test(str)) { return true; }
	if (emailEx2.test(str)) { return true; }
	if (emailEx3.test(str)) { return true; }
	//alert ('전자우편이 형식에 맞지 않습니다. \n\n 예) webmaster@naver.com');

	warnMessage('errorCodeinvalidMail', 'INPUT_VALIDEMAIL');

	obj.value = '';
	obj.focus();
	return false;
}

String.prototype.trim = function() {
	//return this.replace(/(^[ \f\n\r\t]*)|([ \f\n\r\t]*$)/g, "");
	return this.replace(/^\s+|\s+$/g, '');
};
String.prototype.replaceAll = function(str1, str2) {
	var temp_str = "";
	if (this.trim() != "" && str1 != str2) {
		temp_str = this.trim();
		while (temp_str.indexOf(str1) > -1) {
			temp_str = temp_str.replace(str1, str2);
		}
	}
	return temp_str;
};

function goPagingNormal(jspPath, targetTd, params) {
	update(jspPath, targetTd, params, null, 'loading');
}

function viewCaster() {
	if (document.getElementById('casterArea').style.width == '1px') {
		document.getElementById('casterArea').style.display = '';
		document.getElementById('casterArea').style.width = '312px';
		document.getElementById('casterButton').style.display = 'none';
		
		var params = new Array();
			params.push("state=show");
			params = params.join("&");
			request('../common/casterSession.jsp',params);
	} else {
		document.getElementById('casterArea').style.display = 'none';
		document.getElementById('casterArea').style.width = '1px';
		document.getElementById('casterButton').setAttribute("style","display:inline;position: absolute;top:113px; right:10px; width:100%; text-align:right;z-index:100;z-index:500;");
		document.getElementById('btn_caster').src = "../images/cast_btn_open.png";
		var params = new Array();
			params.push("state=none");
			params = params.join("&");
			request('../common/casterSession.jsp',params);
		//document.getElementById('casterButton').innerHTML = "<img id=\"btn_caster\" src=\"../images/cast_btn_open.png\" alt=\"open caster\" title=\"open caster\">";
	}
}

function trueReleaseModalDialog(){
	releaseModalDialog(true);
	popupModalDialog(FormEnv.url, FormEnv.params);
}