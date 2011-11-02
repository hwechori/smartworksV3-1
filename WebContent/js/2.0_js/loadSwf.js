function loadSwf(serverPath, appName, flashVars){
//alert('loadSwf//'+flashVars+"/////"+serverPath+"/////"+appName);
	var htm = '';
		htm = '<object type="application:x-shockwave-flash" classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000"';
		htm = htm + 'id="' + appName + '" width="100%" height="100%"';
		htm = htm + 'codebase="http://fpdownload.macromedia.com/get/flashplayer/current/swflash.cab">';
		htm = htm + '<param name="src" value="../swf/'+ serverPath + appName + '.swf" />';
		htm = htm + '<param name="quality" value="high" />';
		htm = htm + '<param name="wmode" value="transparent">';
		htm = htm + '<param name="bgcolor" value="#ffffff" />';
		htm = htm + '<param name="allowScriptAccess" value="sameDomain" />';
		htm = htm + '<param name="flashVars" value="' + flashVars + '" />';
		htm = htm + '<embed src="../swf/' + serverPath + appName + '.swf" wmode="transparent" quality="high" bgcolor="#ffffff"';
		htm = htm + '	width="100%" height="100%" name="VinoTester" align="middle"';
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
}

/**
 * alert *.swf file call
 * 경고메시지창인 *swf 화면을 사용자 화면에 보여주기위해,
 * function loadSwf() 보다 동적으로 사용하기 위해,
 * @param serverPath : 디렉토리 위치
 * @param appName    : Object 상단에  보여주고자 하는 fineName 
 * @param width      : 화면의 좌-우 크기
 * @param height     : 화면의 상-하 크기
 */
function loadAlertSwf(serverPath, appName, width , height){
	var htm = '';
		htm = '<object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000"';
		htm = htm + 'id="' + appName + '" width="' + width + '" height="' + height + '"';
		htm = htm + 'codebase="http://fpdownload.macromedia.com/get/flashplayer/current/swflash.cab">';
		htm = htm + '<param name="movie" value="../swf/'+ serverPath + appName + '.swf" />';
		htm = htm + '<param name="quality" value="high" />';
		htm = htm + '<param name="bgcolor" value="#ffffff" />';
		htm = htm + '<param name="wmode" value="transparent" />';
		htm = htm + '<param name="allowScriptAccess" value="sameDomain" />';
		htm = htm + '<embed src="../swf/'+ serverPath + appName + '.swf" quality="high" bgcolor="#ffffff"';
		htm = htm + '	width="' + width + '" height="' + height + '" name="' + appName+ '" align="middle" play="true"';
		htm = htm + '	loop="false" quality="high" allowScriptAccess="sameDomain"';
		htm = htm + '	type="application/x-shockwave-flash"';
		htm = htm + '	pluginspage="http://www.adobe.com/go/getflashplayer">';
		htm = htm + '</embed>';
		htm = htm + '</object>';
		document.write(htm);
}

function getMovie(movieName) {
	if (navigator.appName.indexOf("Microsoft") != -1) {
		return window[movieName];
	} else {
		return document[movieName];
	}
}