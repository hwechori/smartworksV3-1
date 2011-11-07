/*
 * 프로그램명  : /js/homeProcess.js
 * 최초	작성자 : 조형래
 * 최초	작성일 : 2008.06.04
 * 최종	수정자 :
 * 최종	수정일 :
 * 프로그램설명 : 홈 > 프로세스업무에서 사용하는 자바스크립트 모음
 * =========================================================
 * Copyright (c) 2008 Maninsoft, Inc. All rights reserved.
*/
/*
	프로세스 업무 목록 검색 : 내업무함 목록을 검색 조회합니다.
	@param pageNo : 페이지 번호
	@return null
*/
function updateListProcInst(pageNo) {
	if(pageNo != undefined) {
		document.listForm.pageNo.value 	= pageNo;
	}
	var v_filterSelect 		= "";
	var v_filterSearchKey 	= "";
	var v_filterSearchWord 	= "";
	var v_filterSearchUser 	= "";

	var filterSelect  	 = document.getElementsByName("filterSelect");
	var filterSearchKey  = document.getElementsByName("filterSearchKey");
	var filterSearchWord = document.getElementsByName("filterSearchWord");
	var filterSearchUser = document.getElementsByName("filterSearchUser");
	for ( var i = 0 ; i < filterSearchWord.length; i++ ) {
		if(filterSelect[i].value != "" && filterSearchKey[i].value != "" && filterSearchWord[i].value != "") {
			v_filterSelect = v_filterSelect + filterSelect[i].value+";";
			v_filterSearchKey = v_filterSearchKey + filterSearchKey[i].value+";";
			v_filterSearchWord = v_filterSearchWord + filterSearchWord[i].value+";";
			if(filterSearchUser[i].value == null || filterSearchUser[i].value == "") {
				v_filterSearchUser = v_filterSearchUser + "EMPTY;";
			} else {
				v_filterSearchUser = v_filterSearchUser + filterSearchUser[i].value+";";
			}
		}
	}
	try{
		var params = new Array();
		params.push("method=getProcInsts");
		params.push("isAsc=" + $F('isAsc'));
		params.push("order=" + $F('order'));
		params.push("pageNo=" + $F('pageNo'));
		params.push("pageSize=" + $F('pageSize'));
		params.push("processId=" + $F('processId'));
		params.push("searchWord=" + $F('searchWord1'));
		params.push("filterSelect=" + v_filterSelect);
		params.push("filterSearchKey=" + v_filterSearchKey);
		params.push("filterSearchWord=" + v_filterSearchWord);
		
		params.push("filterSearchUser=" + v_filterSearchUser);
		params.push("userId=" + userId);
		params.push("userLanguage=" + defaultLanguage);
		params.push("compId=" + compId);
		params = params.join("&");
		request(getPath() + "/services/portal/homeService.jsp", params, updateListProcInstCallback);
	}catch(e){
		//var ss = warnMessage('경고', '선택하신 업무는 업무정의 수정중 입니다.',locationIndex);
		return false;
	}
}

function updateListProcInstCallback() {
	var xmlDoc = getXmlDOM(getResult());
	var resultXml = SmartXMLUtil.getChildNode(xmlDoc, 'Result');
	var totalSize = resultXml.getAttribute('totalSize');
	if(resultXml.getAttribute('status') == 'OK') {
		var table = $('listTable');
		var tBody = table.getElementsByTagName("tbody")[0];
		removeAllRow(1, table);
		if(totalSize > 0) {
			var procInstXml = SmartXMLUtil.getChildNodes(resultXml, 'procInst');
			for(var i=0; i<procInstXml.length; i++) {
				var procInstId 	= procInstXml[i].getAttribute('procInstId');
				var opSize 		= procInstXml[i].getAttribute('opSize');
				var isNewTask 	= procInstXml[i].getAttribute('isNewTask');
				var status 		= procInstXml[i].getAttribute('status');
				var title 		= SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(procInstXml[i], 'title')).escapeHTML();
				var creator 	= procInstXml[i].getAttribute('creator').escapeHTML();
				var creationDate = procInstXml[i].getAttribute('creationDate');
	
				var lastTaskXml = SmartXMLUtil.getChildNode(procInstXml[i], 'lastTask');
				var taskName 	= SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(lastTaskXml, 'taskName'));
				var assignee 	= lastTaskXml.getAttribute('assignee');
				var assignmentDate = lastTaskXml.getAttribute('assignmentDate');
				
				var delayCheck  = lastTaskXml.getAttribute('delayCheck');
				
				if(opSize > 0)
					title = title + "&nbsp;<font style='font-size:9px' color='fc0c0c'>[<b>"+opSize+"</b>]</font>";

				if(isNewTask == "true")
					title = title + "&nbsp;<img src='../images/ico_new.gif'>";
				
				var statusImage = null;
				if(status == "2") {
						statusImage = new Element('img', {src: '../images/icon/status/state_opened.gif'});
					if(delayCheck == 'T'){
						statusImage = new Element('img', {src: '../images/icon/status/state_delay.gif'});
					}
					
				} else if(status == "3") {
					statusImage = new Element('img', {src: '../images/icon/status/state_finished.gif'});
				}
				
				var tr = new Element('tr', { 'style': 'cursor: pointer', id: procInstId+"tr", procInstId: procInstId }).observe('click', function(){viewProcInst(this)});
				var td1 = new Element('td', { 'align': 'center' }).update(statusImage);
				var td2 = new Element('td', { 'align': 'left' }).update("&nbsp;"+title);
				var td3 = new Element('td', { 'align': 'left'}).update(taskName);
				var td4 = new Element('td', { 'align': 'left'}).update(creator+"/ "+creationDate);
				td4.setAttribute('colspan','2');
				var td5 = new Element('td', { 'align': 'left'}).update(assignee+"/ "+assignmentDate);
				td5.setAttribute('colspan','2');
				tr.appendChild(td1);
				tr.appendChild(td2);
				tr.appendChild(td3);
				tr.appendChild(td4);
				tr.appendChild(td5);
				tBody.appendChild(tr);
			}
	
			var order = $F('order');
			if(order == '') order = "creationDate";
			var tdObj = $(order+"Th");
			var trObj = tdObj.parentNode;
			var thNodes = trObj.getElementsByTagName("th");
			if(thNodes != null) {
				for(var i=0; i<thNodes.length; i++) {
					var thNode = thNodes[i]
					var imgNodes = thNode.getElementsByTagName("img");
					if(imgNodes != null) {
						for(var k=imgNodes.length; k>0 ; k--) {
							var imgNode = imgNodes[k-1];
							if(imgNode.id != "priorityImg") {
								thNode.removeChild(imgNode);
							}
						}
					}
				}
			}
	
			if($F('isAsc') == "false") {
				var img = new Element('img', {src: '../images/bt_down.gif'});
			} else {
				var img = new Element('img', {src: '../images/bt_up.gif'});
			}
			tdObj.appendChild(img);
			var params = new Array();
			params.push("totalSize=" + totalSize);
			params.push("pageSize=" + $F('pageSize'));
			params.push("pageNo=" + $F('pageNo'));
			params.push("funcName=updateListProcInst");
			params = params.join("&");
			send(getPath() + "/common/listPaging.jsp", "pagingTd", params);
		} else {
			send(getPath() + "/common/message.jsp", "pagingTd", "message=NoDisplayList");
		}
	}
	document.listForm.searchWord1.focus();
}

/*
	프로세스 목록 버튼 클릭
	@param obj : 메뉴 td object
	@return null
*/
function clickListProcInst() {
	var params = "";
	if($('searchParams')) {
		params = $F('searchParams');
	}
	update("../proc/procList.jsp", "mainTd", params, updateListProcInst, null, null);
}

/*
	저장된 상세필터로 검색(프로세스) : 저장된 필터로 프로세스 인스턴스 목록을 검색합니다.
	@param null
	@return null
*/
function updateProcCond() {
	var filterId = $F('filterId');
	if(filterId == "DEFAULT") {
		removeAllRow(0, $('filterListTable'));
		$('filterTable').hide();
		$('filterCondRemoveBtn').hide();
		updateListProcInst('1');
	} else {
		var params = new Array();
		$('filterTable').show();
		if(filterId != "ALL" && filterId != "TIME" & filterId != "USER") {
			$('filterCondRemoveBtn').show();
		} else {
			$('filterCondRemoveBtn').hide();
		}
		params.push("method=getProcessInstCond");
		params.push("processId=" + $F('processId'));
		params.push("filterId=" + filterId);
		params.push("userId=" + userId);
		params.push("compId=" + compId);
		params = params.join("&");
		request(getPath() + "/services/portal/homeService.jsp", params, updateProcCondCallBack, null, null, null, null);
	}
}

function updateProcCondCallBack() {
	var xmlDoc = getXmlDOM(getResult());
	var resultXml = SmartXMLUtil.getChildNode(xmlDoc, 'Result');
	if(resultXml.getAttribute('status') == 'OK') {
		var filterXml = SmartXMLUtil.getChildNodes(resultXml, 'filter');
		var table = $('filterListTable');
		document.listForm.filterTitle.value = resultXml.getAttribute('filterTitle');
		removeAllRow(0, table);

		for(var i=0; i<filterXml.length; i++) {
			addFilterProc();
			var filterSelect  	 = document.getElementsByName("filterSelect");
			var filterSearchKey  = document.getElementsByName("filterSearchKey");
			var filterSearchWord = document.getElementsByName("filterSearchWord");
			var filterSearchUser = document.getElementsByName("filterSearchUser");
	
			filterSelect[i].value = filterXml[i].getAttribute('searchSelect');
			changeFilterProc(filterSelect[i]);
	
			filterSearchKey[i].value = filterXml[i].getAttribute('filterKey');
			filterSearchWord[i].value = filterXml[i].getAttribute('filterWord');
			filterSearchUser[i].value = filterXml[i].getAttribute('filterUser');
		}
		updateListProcInst('1');
	}
}

/*
	프로세스업무 필터 조건 추가
	@param null
	@return null
*/
function filterProcDisplay(filterId){
//	if($('filterTable').style.display == 'none'){
//		addFilterProc();
//	}else{
//		closeFilter('FORM');
//	}

	//상세필터 수정 (기존 오류)
	if($('filterTable').style.display == 'none'){
		if(filterId == 'DEFAULT') {
			listForm.filterTitle.value = "";
			addFilterProc();
		} else {
			updateProcCond();
		}
	}else{
		closeFilter2('FORM', listForm.filterId.value);
	}

}

function addFilterProc() {
	$('filterTable').show();
	var filterSelectValueArr = ["", "status", "title", "creationUser", "modificationUser", "creationDate", "modificationDate"];
	var filterSelectNameArr = "";
	var imageDir = "";
	if(defaultLanguage == "KOR") {
		filterSelectNameArr = ["", "상태", "제목", "시작자", "수정자", "시작일자", "처리일자"];
		imageDir = "/";
	} else {
		filterSelectNameArr = ["", "Status", "Subject", "Work Starter", "Modifier", "Start Date", "Finished Date"];
		imageDir = "ENG/";
	}
	var filterListTable = $('filterListTable');
	var tbody = filterListTable.getElementsByTagName("tbody")[0];

	var tr = document.createElement("tr");
	
	var td1 = document.createElement("td");
	var select = createSelectElement("filterSelect", '100');
	select.onchange = function() {changeFilterProc(this);}
	createOptions(select, filterSelectValueArr, filterSelectNameArr);
	td1.appendChild(select);
	
	var td2 = document.createElement("td");
	select = createSelectElement('filterSearchKey', '100');
	td2.appendChild(select);
	
	var td3 = document.createElement("td");
	var input1 = createInputElement('text', 'filterSearchWord', '', '175');
	var input2 = createInputElement('hidden', 'filterSearchUser', '', '0');
	td3.appendChild(input1);
	td3.appendChild(input2);
	
	var td4 = document.createElement("td");
	var img = new Element('img', {src: '../images/'+imageDir+'bt_delete.gif'}).observe('click', function(){ removeFilter(this); }).setStyle({ 'cursor': 'pointer' });;
	td4.appendChild(img);
	
	tr.appendChild(td1);
	tr.appendChild(td2);
	tr.appendChild(td3);
	tr.appendChild(td4);
	
	tbody.appendChild(tr);
}

/*
 * 일정계획업무 시  업무를 시작할수있게 createProcInst로 보내주는 함수.
 * */	
function planCreateProcInst(obj){
	var id = obj.getAttribute('formId');
	var idArray = id.split(';');
	var processId = idArray[0];
	var formId = idArray[1];
	document.getElementById('processId').setAttribute('value', processId);
	document.getElementById('startFormId').setAttribute('value',formId);
	createProcInst('NEW');
}	
	
	
/*
	프로세스 새로만들기 버튼 클릭
	@param null
	@return null
	@ isNew :  기존 프로세스 업무 화면에서 새로만들기버튼을 클릭했는지를 알아봄. 값이 있으면 기존, 없으면 신규.
*/
function createProcInst(isNew) {
	var filterSelect  		= document.getElementsByName("filterSelect");
	var filterSearchKey  	= document.getElementsByName("filterSearchKey");
	var filterSearchWord  	= document.getElementsByName("filterSearchWord");
	var filterSearchUser  	= document.getElementsByName("filterSearchUser");
	//var searchWord  		= $F('searchWord');
	var v_filterSelect = "";
	var v_filterSearchKey = ""; 
	var v_filterSearchWord = "";
	var v_filterSearchUser = "";
	
	for ( var i = 0 ; i < filterSearchWord.length; i++ ) {
		if(filterSelect[i].value != "" && filterSearchKey[i].value != "" && filterSearchWord[i].value != "") {
			v_filterSelect = v_filterSelect + filterSelect[i].value+";";
			v_filterSearchKey = v_filterSearchKey + filterSearchKey[i].value+";";
			v_filterSearchWord = v_filterSearchWord + filterSearchWord[i].value+";";
			if(filterSearchUser[i].value == null || filterSearchUser[i].value == "") {
				v_filterSearchUser = v_filterSearchUser + "EMPTY;";
			} else {
				v_filterSearchUser = v_filterSearchUser + filterSearchUser[i].value+";";
			}
		} 
	}
	var params = new Array();
	params.push("processId=" + $F('processId'));
	params.push("pageNo=" + $F('pageNo'));
	params.push("pageSize=" + $F('pageSize'));
	params.push("filterId=" + $F('filterId'));
	params.push("filterTitle=" + $F('filterTitle'));
	params.push("searchWord=" + $F('searchWord'));
	params.push("order=" + $F('order'));
	params.push("isAsc=" + $F('isAsc'));
	params.push("formId=" + $F('startFormId'));
	
	params.push("filterSelect=" + v_filterSelect);
	params.push("filterSearchKey=" + v_filterSearchKey);
	params.push("filterSearchWord=" + v_filterSearchWord);
	params.push("filterSearchUser=" + v_filterSearchUser);
	params.push("isNew="+isNew);
	params = params.join("&");
	
	FormEnv.loadDataComplete = true;
	
	if(isNew=='NEW'){
		saveCookie("subject","");
		saveCookie("workContentsT","");
		saveCookie("projectNameT","");
		saveCookie("isPublicT","");
		saveCookie("priorityT","");
	}
	var linkUrl = "../proc/procInsert.jsp";
	var pkgType = "";
	var listForm = "";
	try{
		listForm = document.listForm.pkgType;
	}catch(e){
		listForm = "";
	}
	
	if(listForm != "")
		pkgType = document.listForm.pkgType.value;
	else
		pkgType = $F('pkgType');
	
	if(pkgType != 'GANTT'){
		update(linkUrl, "mainTd", params, processStartCallback, "loading", "failed");
	}else{
		update(linkUrl, "mainTd", params, insertContent, "loading", "failed");
	}
	
}
	
function insertContent(){
	var subject = readCookie("subject");
	var workContentsT = readCookie("workContentsT");
	var projectNameT = readCookie("projectNameT");
	var isPublicT = readCookie("isPublicT");
	var priorityT = readCookie("priorityT");
	document.getElementById("subject").setAttribute("value",subject);
	document.getElementById("workContentsT").innerHTML = workContentsT;
	document.getElementById("projectNameT").setAttribute("value", projectNameT);
	var radio = document.viewForm.isPublicT;
	for(var i = 0; i < radio.length; i++){
		if(radio[i].value == isPublicT){
			radio[i].checked = true;
			break;
		}
	}
	var select = document.viewForm.priorityT;
	for(var i = 0; i < select.length; i++){
		if(select[i].value == priorityT){
			select[i].selected = true;
			break;
		}
	}
}
	
function processStartCallback() {
	var formWork = new FormWork("workspace");
	$("workspace")["formWork"] = formWork;
	formWork.initFormRuntime(userId, '../', $F('formId'), 1, $F('processId'), '', 4, 'edit');
	var subject = readCookie("subject");
	var workContentsT = readCookie("workContentsT");
	var projectNameT = readCookie("projectNameT");
	var isPublicT = readCookie("isPublicT");
	var priorityT = readCookie("priorityT");
	document.getElementById("subject").setAttribute("value",subject);
	document.getElementById("workContentsT").innerHTML = workContentsT;
	document.getElementById("projectNameT").setAttribute("value", projectNameT);
	var radio = document.viewForm.isPublicT;
	for(var i = 0; i < radio.length; i++){
		if(radio[i].value == isPublicT){
			radio[i].checked = true;
			break;
		}
	}
	var select = document.viewForm.priorityT;
	for(var i = 0; i < select.length; i++){
		if(select[i].value == priorityT){
			select[i].selected = true;
			break;
		}
	}
}

/*
	프로세스업무 필터 항목을 변경 : 필터 조건에 맞는 연산자와 검색어 입력필드조건을 업데이트 합니다.
	@param obj : 필터 조건 select Object
	@return null
*/
function changeFilterProc(obj) {
	var trNode = obj.parentNode.parentNode;
	var selectNode 	= trNode.getElementsByTagName("select")[0];
	var keyNode = trNode.getElementsByTagName("select")[1];
	var wordTdNode = trNode.getElementsByTagName("td")[2];
	
	var searchKeyValueArr = "";
	var searchKeyNameArr = "";
	var searchWordValueArr = "";
	var searchWordNameArr = "";

	var selectNodeValue = selectNode.value;
	
	if(selectNodeValue == "title") {
		searchKeyValueArr = ["", "=", "!=", "like"];
	} else if(selectNodeValue == "status" ) {
		searchKeyValueArr = ["", "=", "!="];
		searchWordValueArr = ["", "2", "3"];
	} else if(selectNodeValue == "creationUser" || selectNodeValue == "modificationUser" ) {
		searchKeyValueArr = ["", "=", "!="];
	} else if(selectNodeValue == "creationDate" || selectNodeValue == "modificationDate" ) {
		searchKeyValueArr = ["", "datein", "datenotin", "<", ">", "<=", ">="];
	}
	
	if(defaultLanguage == "KOR") {
		if(selectNodeValue == "title") {
			searchKeyNameArr = ["", "같음", "같지 않음", "포함"];
		} else if(selectNodeValue == "status" ) {
			searchKeyNameArr = ["", "같음", "같지 않음"];
			searchWordNameArr = ["", "진행", "완료"];
		} else if(selectNodeValue == "creationUser" || selectNodeValue == "modificationUser" ) {
			searchKeyNameArr = ["", "같음", "같지 않음"];
		} else if(selectNodeValue == "creationDate" || selectNodeValue == "modificationDate" ) {
			searchKeyNameArr = ["", "같음", "같지 않음", "미만", "초과", "이하", "이상"];
		}
	} else {
		if(selectNodeValue == "title") {
			searchKeyNameArr = ["", "Equal", "Not Equal", "Including"];
		} else if(selectNodeValue == "status" ) {
			searchKeyNameArr = ["", "Equal", "Not Equal"];
			searchWordNameArr = ["", "Processing", "Completion"];
		} else if(selectNodeValue == "creationUser" || selectNodeValue == "modificationUser") {
			searchKeyNameArr = ["", "Equal", "Not Equal"];
		} else if(selectNodeValue == "creationDate" || selectNodeValue == "modificationDate") {
			searchKeyNameArr = ["", "Equal", "Not Equal", "Less than", "Excess", "Below", "More than"];
		}
	}

	removeAllOptions(keyNode);
	createOptions(keyNode, searchKeyValueArr, searchKeyNameArr);
	removeChildNodes(wordTdNode, 0);
	
	// 시작일, 처리일
	if(selectNodeValue == "creationDate" || selectNodeValue == "modificationDate" ) {
		var input1 = createInputElement('text', 'filterSearchWord', '', '155');
		input1.onblur = function() {isValidDateYMD(this);};
		wordTdNode.appendChild(input1);
		var img = new Element('img', {src:'../images/icon/dateChooser.gif'}).observe('click', function(){ popupSelectDateModalDialog(this); }).setStyle({ 'cursor': 'pointer' });
		wordTdNode.appendChild(img);
	//생성자, 처리자
	} else if(selectNodeValue == "creationUser" || selectNodeValue == "modificationUser") {
		var input1 = createInputElement('text', 'filterSearchWord', '', '155');
		input1.onclick = function(){ searchUserFilter(this);};
		var img = new Element('img', {src:'../image/form/user.gif'}).observe('click', function(){ searchUserFilter(this); }).setStyle({ 'cursor': 'pointer' });
		wordTdNode.appendChild(input1);
		wordTdNode.appendChild(img);
	// 상태
	} else if(selectNodeValue == "status") {
		var select = createSelectElement("filterSearchWord", '175');
		wordTdNode.appendChild(select);
		createOptions(select, searchWordValueArr, searchWordNameArr);
	// 기타 일반 텍스트
	} else {
	   var input = createInputElement('text', 'filterSearchWord', '', '175');
	   wordTdNode.appendChild(input);
	}
	var input = createInputElement('hidden', 'filterSearchUser', '', '0');
	wordTdNode.appendChild(input);
}

/*
 	프로세스업무 필터 저장 : 프로세스업무 필터조건을 저장합니다.
 	@param null
	@return null
*/
function setProcessInstCond() {
	var v_filterSelect 		= "";
	var v_filterSearchKey 	= "";
	var v_filterSearchWord 	= "";
	var v_filterSearchUser 	= "";

	var filterSelect  	 = document.getElementsByName("filterSelect");
	var filterSearchKey  = document.getElementsByName("filterSearchKey");
	var filterSearchWord = document.getElementsByName("filterSearchWord");
	var filterSearchUser = document.getElementsByName("filterSearchUser");

	for ( var i = 0 ; i < filterSearchWord.length; i++ ) {
		if(filterSelect[i].value != "" && filterSearchKey[i].value != "" && filterSearchWord[i].value != "") {
			v_filterSelect = v_filterSelect + filterSelect[i].value+";";
			v_filterSearchKey = v_filterSearchKey + filterSearchKey[i].value+";";
			v_filterSearchWord = v_filterSearchWord + filterSearchWord[i].value+";";
			if(filterSearchUser[i].value == null || filterSearchUser[i].value == "") {
				v_filterSearchUser = v_filterSearchUser + "EMPTY;";
			} else {
				v_filterSearchUser = v_filterSearchUser + filterSearchUser[i].value+";";
			}
		}
	}

	var params = new Array();
	params.push("method=setProcessInstCond");
	params.push("processId=" + $F('processId'));
	params.push("filterId=" + $F('filterId'));
	params.push("filterTitle=" + $F('filterTitle'));
	params.push("filterSelect=" + v_filterSelect);
	params.push("filterSearchKey=" + v_filterSearchKey);
	params.push("filterSearchWord=" + v_filterSearchWord);
	params.push("filterSearchUser=" + v_filterSearchUser);
	params.push("userId=" + userId);
	params.push("compId=" + compId);
	params = params.join("&");
	request(getPath() + "/services/portal/homeService.jsp", params, setProcessInstCondCallback, null, "notifySaveProgress", null, "warnSaveFailed");
}

function setProcessInstCondCallback() {
	var xmlDoc = getXmlDOM(getResult());
	var resultXml = SmartXMLUtil.getChildNode(xmlDoc, 'Result');
	if(resultXml.getAttribute('status') == 'OK') {
		var selectNode = $('filterId');
		var opts = selectNode.getElementsByTagName("option");
		for(var i=0; i<opts.length; i++) {
			if($F('filterId') == opts[i].getAttribute("value")) {
				//selectNode.removeChild(opts[i]);
				break;
			}
		}
		
		var fieldId = resultXml.getAttribute('filterId');
		var filterTitle = resultXml.getAttribute('filterTitle');
		var option = new Element('option', { 'value': fieldId, 'selected': 'selected'}).update(filterTitle);
		$('filterId').appendChild(option);
		$('filterCondRemoveBtn').show();
		updateListProcInst('1');
	}
}

/*
프로세스업무 필터 삭제 : 프로세스업무 필터조건을 삭제합니다.
@param null
@return null
*/
function removeProcessInstCond() {
	confirmMessage('AreYouSureYouWantToDeleteIt', _removeProcessInstCond);
}

function _removeProcessInstCond() {
	var params = new Array();
	params.push("method=removeProcessInstCond");
	params.push("processId=" + $F('processId'));
	params.push("filterId=" + $F('filterId'));
	params.push("userId=" + userId);
	params.push("compId=" + compId);
	params = params.join("&");
	request(getPath() + "/services/portal/homeService.jsp", params, removeProcessInstCondCallback, null, null, null, null);
}

function removeProcessInstCondCallback() {
	var xmlDoc = getXmlDOM(getResult());
	var resultXml = SmartXMLUtil.getChildNode(xmlDoc, 'Result');
	if(resultXml.getAttribute('status') == 'OK') {
		var filterId = resultXml.getAttribute('filterId');
		var selectNode = $('filterId');
		removeAllRow(0, $('filterListTable'));
		var opts = selectNode.getElementsByTagName("option");
		for(var i=0; i<opts.length; i++) {
			if(filterId == opts[i].getAttribute("value")) {
				selectNode.removeChild(opts[i]);
				break;
			}
		}
		$('filterCondRemoveBtn').hide();
		$('filterTable').hide();
		$('filterTitle').setAttribute("value", "");
		updateListProcInst('1');
	}
}

/*
	프로세스 업무 클릭 : 프로세스업무 인스턴스 목록을 조회합니다.
	@param null
	@return null
*/
function clickListProc() {
	var params = "";
		if($('searchParams'))
			params = $F('searchParams');
		if(params == ''){
			params = document.viewForm.searchParams.value;
		}
	update("../proc/procList.jsp", "mainTd", params, updateListProcInst, null, null);
}

//jk yoon 처리기한 삭제로인한 페이지 변경. 향후 함수 필요없어질것으로 보임.
/*

function procDetailWirte(target , processId , version) {
	if(target == "procDue") {
		$('detailSelected').hide();
		$('procDueTable').show();
		document.getElementById("procDetailTd").style.weight="bold";
		document.getElementById("procDueTd").style.weight="";
		if(!$('procDueAddTd').hasChildNodes()) {
			var params = "processId="+processId+"&version="+version;
			//send("../proc/pertChartAdd.jsp", "procDueAddTd",  params);
			send("../proc/hopeEndTime.jsp", "procDueAddTd",  params);
		}
		$('dueSelected').show();
		$('formIncTb').hide();
		//$('button_approvalTb').hide();
		//if($('ApprovalLineTr')){
			//$('ApprovalLineTr').hide();
		//}
		
	} else {
		$('detailSelected').show();
		$('procDueTable').hide();
		document.getElementById("procDetailTd").style.weight="";
		document.getElementById("procDueTd").style.weight="bold";
		//$('procDetailTable').show();
		$('dueSelected').hide();
		$('formIncTb').show();
		//$('button_approvalTb').show();
	}
}
*/
function procDetailWirte(target , processId , version) {
	if(target == "procDue") {
		$('procDueTable').show();
		if(!$('procDueAddTd').hasChildNodes()) {
			var params = "processId="+processId+"&version="+version;
			//send("../proc/pertChartAdd.jsp", "procDueAddTd",  params);
			send("../proc/hopeEndTime.jsp", "procDueAddTd",  params);
		}else{
			$('procDueTable').hide();
			document.getElementById("procDueAddTd").innerHTML="";
		}
	}
}

/*	jk yoon
 	프로세스 업무 생성 시 업무화면을 보여줍니다.
 	인자값 param 은 "test,test1" 의형식으로 들어옵니다. 구분자 ','
 */
function procDetailWorkPage(param){
	var elementId = param.split(",");
	if(elementId.length != undefined){
		for(var i = 0 ; i < elementId.length ; i++){
			var el = document.getElementById(elementId[i]);
			var state = el.getAttribute("state");
			if(state != "T"){
				el.setAttribute("state", "T");
				$(elementId[i]).hide();
			}else{
				el.setAttribute("state", "F");
				$(elementId[i]).show();
			}
		}
	}
}

/*
	프로세스 업무 완료 버튼 클릭
	@param 
	@return null
*/
function setProcessInst() {

	var form = document.viewForm;
	var subject = $F('subject');
	var receiptTitle = $F('receiptTitle');
	
	var subject = $F('subject');
	var subjectTemp = subject.trim();

	var receiptTitle = $F('receiptTitle');
	var receiptTitleTemp = receiptTitle.trim();

	if(subjectTemp == '' && receiptTitleTemp == '') {
		warnMessage("Youdidnotentertherequireditems", "PleaseEnterATitle");
		return;
		//alert('제목을 입력하세요.');
		
		//if($('procDetailTable'))
		//	$('procDetailTable').show();
		//if($('procDueTable'))
		//	$('procDueTable').hide();
		//document.getElementById("procDetailTd").style.weight="";
		//document.getElementById("procDueTd").style.weight="bold";
	} else {
		//jk yoon 추가 
		var hopeEndTime = "";
		var hopeEndDate = "";
		var requiredDay = "";
		var requiredTime = "";
		var requiredMinute = "";
		
		var name = "";
		var type = "";
		var ref = "";
		var planFrom = "";
		var planTo = "";
		var executionFrom = "";
		var executionTo = "";
		var executionDuration = "";
		var assignee = "";
	
		//if(form.planDuration != null) {
		if(form.hopeEndTime != null) {
			// jk yoon 추가. planDuration 교체.
			
			for ( var i = 0 ; i < form.requiredDay.length; i++ ) {
				requiredDay = requiredDay + form.requiredDay[i].value+" ;";
			}
			
			for ( var i = 0 ; i < form.requiredTime.length; i++ ) {
				requiredTime = requiredTime + form.requiredTime[i].value+" ;";
			}
			
			for ( var i = 0 ; i < form.requiredMinute.length; i++ ) {
				requiredMinute = requiredMinute + form.requiredMinute[i].value+" ;";
			}
			
			for ( var i = 0 ; i < form.hopeEndTime.length; i++ ) {
				var ss = document.getElementById('hopeEndDate0'+i);
				hopeEndDate = hopeEndDate + ss.getAttribute('value')+" ;"; 
			}
			
			for ( var i = 0 ; i < form.hopeEndTime.length; i++ ) {
				hopeEndTime = hopeEndTime + form.hopeEndTime[i].value+" ;";
			}
	
			for ( var i = 0 ; i < form.name.length; i++ ) {
				name = name + form.name[i].value+" ;";
			}
			for ( var i = 0 ; i < form.type.length; i++ ) {
				type = type + form.type[i].value+" ;";
			}
			for ( var i = 0 ; i < form.ref.length; i++ ) {
				ref = ref + form.ref[i].value+" ;";
			}
			for ( var i = 0 ; i < form.planFrom.length; i++ ) {
				planFrom = planFrom + form.planFrom[i].value+" ;";
			}
			for ( var i = 0 ; i < form.planTo.length; i++ ) {
				planTo = planTo + form.planTo[i].value+" ;";
			}
			for ( var i = 0 ; i < form.executionFrom.length; i++ ) {
				executionFrom = executionFrom + form.executionFrom[i].value+" ;";
			}
			for ( var i = 0 ; i < form.executionTo.length; i++ ) {
				executionTo = executionTo + form.executionTo[i].value+" ;";
			}
			for ( var i = 0 ; i < form.executionDuration.length; i++ ) {
				executionDuration = executionDuration + form.executionDuration[i].value+" ;";
			}
			for ( var i = 0 ; i < form.assignee.length; i++ ) {
				assignee = assignee + form.assignee[i].value+" ;";
			}
		}

		if(document.getElementById('refTr').style.display == '') {
			var referenceUserName = $F('referenceUserName');
			var referenceUserNameTemp = referenceUserName.trim();
			if(referenceUserNameTemp==''){
				warnMessage("Youdidnotentertherequireditems", "PleaseReferenceUser");
				return;
			}
		}

		var packageId = $F('packageId');
		var processId = $F('processId');
		
		//jk yoon 프로세스 업무 시작하기시 추가 확인. nameTest.html 참조.
		
		$('workspace')['formWork'].completePrcInit(hopeEndTime, name, type, ref, planFrom, planTo, executionFrom, executionTo, executionDuration, assignee, hopeEndDate, requiredDay, requiredTime, requiredMinute, packageId, processId);
	}
}

/*
	프로세스 삭제
	@param 
	@return null
*/
function removeProcInst() {
	confirmMessage('AreYouSureYouWantToDeleteIt', _removeProcInst);
}
	
function _removeProcInst(){
	var params = new Array();
	params.push("method=removeProcessInst");
	params.push("processInstId=" + $F('procInstId'));
	params = params.join("&");
	request(getPath()+"/services/runtime/executionService.jsp", params, removeProcInstCallback, null, "", null, "");	
}

function removeProcInstCallback(){
	var xmlDoc = getXmlDOM(getResult());
	var resultXml = SmartXMLUtil.getChildNode(xmlDoc, 'Result');
	if(resultXml.getAttribute('status') == 'OK') {
		clickListProc();
	}
}

/*
프로세스업무  내용을 조회합니다
@param obj : 클릭한 TR object
@return null
*/
function viewProcInst(obj) {
	
	var form = document.listForm;
	var filterSelect  		= document.getElementsByName("filterSelect");
	var filterSearchKey  	= document.getElementsByName("filterSearchKey");
	var filterSearchWord  	= document.getElementsByName("filterSearchWord");
	var filterSearchUser  	= document.getElementsByName("filterSearchUser");
	
	var v_filterSelect = "";
	var v_filterSearchKey = "";
	var v_filterSearchWord = "";
	var v_filterSearchUser = "";
	for ( var i = 0 ; i < filterSearchWord.length; i++ ) {
		if(filterSelect[i].value != "" && filterSearchKey[i].value != "" && filterSearchWord[i].value != "") {
			v_filterSelect = v_filterSelect + filterSelect[i].value+";";
			v_filterSearchKey = v_filterSearchKey + filterSearchKey[i].value+";";
			v_filterSearchWord = v_filterSearchWord + filterSearchWord[i].value+";";
			if(filterSearchUser[i].value == null || filterSearchUser[i].value == "") {
				v_filterSearchUser = v_filterSearchUser + "EMPTY;";
			} else {
				v_filterSearchUser = v_filterSearchUser + filterSearchUser[i].value+";";
			}
		}
	}
	var params = new Array();
	params.push("procInstId=" + obj.getAttribute('procInstId'));
	params.push("processId=" + $F('processId'));
	params.push("pageNo=" + $F('pageNo'));
	params.push("pageSize=" + $F('pageSize'));
	params.push("filterId=" + $F('filterId'));
	params.push("filterTitle=" + $F('filterTitle'));
	params.push("searchWord=" + $F('searchWord1'));
	params.push("order=" + $F('order'));
	params.push("isAsc=" + $F('isAsc'));
	params.push("filterSelect=" + v_filterSelect);
	params.push("filterSearchKey=" + v_filterSearchKey);
	params.push("filterSearchWord=" + v_filterSearchWord);
	params.push("filterSearchUser=" + v_filterSearchUser);
	params.push("formType="+$F('pkgType'))
	params = params.join("&");
	var linkUrl = "../proc/procView.jsp";
	//alert(params);
	update(linkUrl, "mainTd", params, null, "loading", "faield");
}

function procAssigneeSetup(assignYn){
	//alert(assignYn);
	if (assignYn == 'N') {
		$('ApprovalLineTr').hide();
		$('button_approvalTb').show();
		$('ApprovalTitleTr').hide();
		$('ApprovalBtnTr').hide();
		$('aprOpenTr').hide();
		$('aprDrafterTr').hide();
		$('aprContentTr').hide();
		$('procTitle').hide();
		$('procSecondLine').hide();
		$('workStartPageId').show();
	} else if (assignYn == 'Y') {
		$('ApprovalLineTr').show();
		$('button_approvalTb').hide();
		$('ApprovalTitleTr').show();
		$('ApprovalBtnTr').show();
		$('aprOpenTr').show();
		$('aprDrafterTr').show();
		$('aprContentTr').show();
		$('procTitle').show();
		$('procSecondLine').show();
		$('workStartPageId').hide();
		//$('commentTd').update(editorInsert("comment", "632", "150"));
		commentInsert();
	}
}

function planToDateSave(params) {
	var planDuration = "";
	var name = "";
	var type = "";
	var ref = "";
	var executionFrom = "";
	var executionTo = "";
	var executionDuration = "";
	var assignee = "";

	if(document.procHistoryForm.planDuration != null && document.procHistoryForm.planDuration != "") {
		if(document.procHistoryForm.planDuration.length > 0) {
			for ( var i = 0 ; i < document.procHistoryForm.planDuration.length; i++ ) {
				planDuration = planDuration + document.procHistoryForm.planDuration[i].value+" ;";
			}

			for ( var i = 0 ; i < document.procHistoryForm.name.length; i++ ) {
				name = name + document.procHistoryForm.name[i].value+" ;";
			}

			for ( var i = 0 ; i < document.procHistoryForm.type.length; i++ ) {
				type = type + document.procHistoryForm.type[i].value+" ;";
			}

			for ( var i = 0 ; i < document.procHistoryForm.ref.length; i++ ) {
				ref = ref + document.procHistoryForm.ref[i].value+" ;";
			}

			for ( var i = 0 ; i < document.procHistoryForm.executionFrom.length; i++ ) {
				executionFrom = executionFrom + document.procHistoryForm.executionFrom[i].value+" ;";
			}

			for ( var i = 0 ; i < document.procHistoryForm.executionTo.length; i++ ) {
				executionTo = executionTo + document.procHistoryForm.executionTo[i].value+" ;";
			}

			for ( var i = 0 ; i < document.procHistoryForm.executionDuration.length; i++ ) {
				executionDuration = executionDuration + document.procHistoryForm.executionDuration[i].value+" ;";
			}

			for ( var i = 0 ; i < document.procHistoryForm.assignee.length; i++ ) {
				assignee = assignee + document.procHistoryForm.assignee[i].value+" ;";
			}
			params = params+"&planDuration="+planDuration+"&name="+name+"&pertType="+type+"&ref="+ref+"&executionFrom="+executionFrom+"&executionTo="+executionTo+"&executionDuration="+executionDuration+"&assignee="+assignee;
			send("../proc/procHistory.jsp", "procHistoryTd",  params);
		}
	}
}

//jk yoon 
/*
* 새일정 계획하기
* 프로세스 업무 계획
* */
function setNewPlanProcess(){
	var formId 			= document.getElementById('formId').getAttribute('value');
	var processId 		= document.getElementById('processId').getAttribute('value');
	var subject 		= document.getElementById('subject').getAttribute('value');
	var workContents 	= $F('workContentsT');
	var workName 		= document.getElementById('workName').getAttribute('value');
	var projectName		= document.getElementById('projectNameT').getAttribute('value');
	var isPublic 		= document.getElementById('isPublicT').getAttribute('value');
	var priority		= $F('priorityT');
	//var reminders		= document.getElementById('reminders').getAttribute('value');
	var performerId		= document.getElementById('performerId').getAttribute('value');
	var willStartDate	= document.getElementById('willStartDate').getAttribute('value');
	var willStartTime	= $F('willStartTime');
	var willEndDate		= document.getElementById('willEndDate').getAttribute('value');
	var willEndTime		= $F('willEndTime');
	var type 			= 'PLANTASK';
	var params = new Array();
	params.push("formId="+formId);
	params.push("processId=" + processId);
	params.push("subject=" + subject);
	params.push("workContents=" + workContents);
	params.push("workName=" + workName);
	params.push("projectName=" + projectName);
	params.push("isPublic=" + isPublic);
	params.push("priority=" + priority);
	//params.push("reminders=" + reminders);
	params.push("performerId=" + performerId);
	params.push("willStartDate=" + willStartDate);
	params.push("willStartTime=" + willStartTime);
	params.push("willEndDate=" + willEndDate);
	params.push("willEndTime=" + willEndTime);
	params.push("type=" + type);
	params.push("sort=prc");
	params = params.join("&");
	
	var subjectTemp = subject.trim();
	
	if(subjectTemp==''|| subject == undefined){
		warnMessage('Warning', 'PleaseEnterATitle'); //제목을 입력하세요.
		//alert('수행자를 선택하세요.');
		return false;
	}
	
	if(performerId == '' || performerId == undefined){
		warnMessage('Warning', 'ChooseAttendant'); //수행자를 선택하세요.
		//alert('수행자를 선택하세요.');
		return false;
	}else if(willStartDate =='' || willStartDate == undefined){
		warnMessage('Warning', 'EnterThePlannedstarttime'); //예상 시작시간을 입력하세요.
		//alert('예상 시작시간을 입력하세요.');
		return false;
	}else if(willEndDate =='' || willEndDate == undefined){
		warnMessage('Warning', 'EnterThePlannedendtime'); //예상 종료시간을 입력하세요.
		//alert('예상 종료시간을 입력하세요.');
		return false;
	}
	request("../services/portal/planRegistService.jsp", params, null, null, "loading");
	location.href='../today/toDayIndex.jsp';
}


/*
 * 탭이동.
 */
function ganttTab(num, el, swf){
	if(num == undefined) num = 1;
	var ulTab = document.getElementById('workTab');
	var tabs = ulTab.childNodes;
	
	if(num==1) viewScope="DAY";
	else if(num==2) viewScope="WEEK";
	else if(num==3) viewScope="MONTH";
	else if(num==4) viewScope="YEAR";
	
	
	for(var i = 0 ; i < tabs.length ; i++){
		if(num == (i+1)){
			tabs[i].setAttribute("class","current");
		}else{
			tabs[i].setAttribute("class","");
		}
	}
	
	var mm = '';
	if (navigator.appName.indexOf("Microsoft") != -1) {
		mm = window['diagramIframe'];
	} else {
		mm =  document['diagramIframe'];
	}
	if(swf == 'GanttViewerApp')
		mm.GanttViewerApp.changeGanttViewScope(viewScope)
	else if(swf == 'SmartWorkbenchEditor')
		mm.SmartWorkbenchEditor.changeGanttViewScope(viewScope)
	else if(swf == 'GanttInstanceViewerApp')
		mm.GanttInstanceViewerApp.changeGanttViewScope(viewScope)
}
/*
 * gantt 날짜 이동.
 */ 
function moveGantt(move, swf){
	var mm = '';
	if (navigator.appName.indexOf("Microsoft") != -1) {
		mm = window['diagramIframe'];
	} else {
		mm =  document['diagramIframe'];
	}
	//alert(swf);
	if(swf == 'GanttViewerApp')
		mm.GanttViewerApp.moveGanttPage(move);
	else if(swf == 'SmartWorkbenchEditor')
		mm.SmartWorkbenchEditor.moveGanttPage(move);
	else if(swf == 'GanttInstanceViewerApp')
		mm.GanttInstanceViewerApp.moveGanttPage(move);
	else if(swf =='GanttTaskListViewerApp')
		mm.GanttTaskListViewerApp.moveGanttPage(move);
} 

/*
 * gantt 기준일 변경. 
 */
function setGanttDate(div, seq, format, func){
//alert('setGanttDate ::::: '+div+'///'+seq+'///'+format+'///'+func);	 
	searchDate(div,seq,format, func);
}
function ganttTest(param){
	//alert('냐하하'+param);
}

/*
 * gantt 배치
 */
function deployGanttPackage(){
	var mm = '';
	if (navigator.appName.indexOf("Microsoft") != -1) {
		mm = window['diagramIframe'];
	} else {
		mm =  document['diagramIframe'];
	}
	mm.SmartWorkbenchEditor.deployGanttPackage();
	alertMessage('CreateTask', 'Schedulingtaskhavebeencreated',null);  //일정계획 업무가 생성 되었습니다.
	//alert('일정계획업무가 생성 되었습니다.');
	location.href = '../main/index.jsp';
}
//ganttProcessCallback(packId, packName, mode="deployGanttPackage", msg){
function ganttProcessCallback(packId, packName, mode, msg){
	//alert('homeProcess.js callBack'+packId+"//"+packName+"//"+mode+"//"+msg);
}
