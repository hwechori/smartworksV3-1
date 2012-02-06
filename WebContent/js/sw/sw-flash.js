

function loadFlash(target, appName, params){
	console.log('target=', target);
	console.log('appName=', appName);
	console.log('params=', params);
	var htm = 	'<object type="application:x-shockwave-flash" classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000"' +
					'id="' + appName + '" width="100%" height="100%"' + 'codebase="http://fpdownload.macromedia.com/get/flashplayer/current/swflash.cab">' +
					'<param name="src" value="resources/flash/' + appName + '.swf" />' +
					'<param name="quality" value="high" />' +
					'<param name="wmode" value="transparent">' +
					'<param name="bgcolor" value="#ffffff" />' +
					'<param name="allowScriptAccess" value="always" />' +
					'<param name="flashVars" value="' + params + '" />' +
					'<embed src="resources/flash/' + appName + '.swf" wmode="transparent" quality="high" bgcolor="#ffffff"' +
						'width="100%" height="100%" name="VinoTester" align="middle" play="true" loop="false" quality="high" allowScriptAccess="sameDomain"' +
						'type="application/x-shockwave-flash" pluginspage="http://www.adobe.com/go/getflashplayer" flashVars="' + params + '">' +
					'</embed>' +
				'</object>';
	$(target).html(htm);	
};

function getServiceUrl() {
	var splitArray = window.location.href.split('/');
//	return splitArray[0] + '//' + splitArray[2] + '/';
	return 'http://dev.smartworks.net/';
};

function getGeneralParams(){
	return 	'serviceUrl=' + getServiceUrl() + 
			'&compId=' + currentUser.companyId + 
			'&userId=' + currentUser.userId + 
			'&defaultLanguage=' + currentUser.locale;	
};

function loadSmartBuilder(target, params){
	var options = {
		packageId : '',
		packageVersion : '1',
		dueDate : '' //"2010-10-01 00:00:00"
	};
	SmartWorks.extend(options, params);
	loadFlash(target, 'SmartWorkbenchEditor_debug', getGeneralParams() 
												+ '&packId=' + options.packageId 
												+ '&packVer=' + options.packageVersion
												+ '&dueDate=' + options.dueDate);
};

function loadInstanceViewer(target, params){
	var options = {
			instanceId : ''
	};
	SmartWorks.extend(options, params);
	loadFlash(target, 'InstanceViewerApp', getGeneralParams() 
											+ '&prcInstId=' + options.instanceId);
};

function loadDiagramViewerApp(target, params){
	var options = {
			processId : '',
			version : '1'
	};
	SmartWorks.extend(options, params);
	loadFlash(target, 'DiagramViewerApp', getGeneralParams() 
											+ '&processId=' + options.processId 
											+ '&version=' + options.version);
};

function loadGanttViewer(target, params){
	var options = {
			processId : '',
			version : '1',
			contentWidth : '654.0'
	};
	loadFlash(target, 'GanttViewerApp', getGeneralParams() 
											+ '&processId=' + options.processId 
											+ '&version=' + options.version
											+ '&contentWidth=' + options.contentWidth);
};

function loadGanttInstanceViewer(target, params){
	var options = {
			instanceId : ''
		};
	SmartWorks.extend(options, params);
	loadFlash(target, 'GanttInstanceViewerApp', getGeneralParams() 
												+ '&prcInstId=' + options.instanceId);
};

function loadGanttTaskListViewerApp(target, params){
	var options = {
			formDate : '', //"2010-06-28 00:00:00"
			viewScope : 'MONTH', // 'DAY', 'WEEK', 'MONTH'
			conditions : '',
			pageSize : '20'
	};
	SmartWorks.extend(options, params);
	loadFlash(target, 'GanttTaskListViewerApp', getGeneralParams() 
												+ '&fromDate=' + options.fromDate,
												+ '&viewScope=' + options.viewScope,
												+ '&conditions=' + options.conditions,
												+ '&pageSize=' + options.pageSize);

};

function loadChartGadget(target, params){
	loadFlash(target, 'ChartGadgetApp', params);
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
