

function loadFlash(target, appName, params){
	var htm = 	'<object type="application:x-shockwave-flash" classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000"' +
					'id="' + appName + '" width="100%" height="100%"' + 'codebase="http://fpdownload.macromedia.com/get/flashplayer/current/swflash.cab">' +
					'<param name="src" value="resources/flash/' + appName + '.swf" />' +
					'<param name="quality" value="high" />' +
					'<param name="wmode" value="transparent">' +
					'<param name="bgcolor" value="#ffffff" />' +
					'<param name="allowScriptAccess" value="sameDomain" />' +
					'<param name="flashVars" value="' + params + '" />' +
					'<embed src="resources/flash/' + appName + '.swf" wmode="transparent" quality="high" bgcolor="#ffffff"' +
						'width="100%" height="100%" name="VinoTester" align="middle" play="true" loop="false" quality="high" allowScriptAccess="sameDomain"' +
						'type="application/x-shockwave-flash" pluginspage="http://www.adobe.com/go/getflashplayer" flashVars="' + params + '">' +
					'</embed>' +
				'</object>';
		
	$(target).html(htm);
	
};

function selectActivity(act) {
	parent.selectActivity(act);
};

function loadCallback(status){
	parent.document.getElementById("diagramIframe").setAttribute("height",status);
};

function ganttProcessCallback(packId, packName, mode, msg){
	//alert('diagramObm.jsp callBack'+packId+"//"+packName+"//"+mode+"//"+msg);
};

function dateCallback(startDate, endDate){
	//alert(startDate);
	var dueDate = startDate +" ~ "+ endDate;
	parent.document.getElementById('dueDateDiv').innerHTML = dueDate;
	parent.viewChartStartDate();
	//parent.document.getElementById('fromDate').setAttribute('value','');
};

function pagingCallback(totalPages, currentPage){
	parent.pagingVchart(totalPages, currentPage);
};

function fullScreenCallback(param){
	//if(param == 'NormalScreen'){
		parent.openerRefresh();
	//}
};
