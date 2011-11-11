/*
 * 프로그램명  : /js/homeForm.js
 * 최초	작성자 : 조형래
 * 최초	작성일 : 2008.06.04
 * 최종	수정자 :
 * 최종	수정일 :
 * 프로그램설명 : 홈 > 정보관리업무에서 사용하는 자바스크립트 모음
 * =========================================================
 * Copyright (c) 2008 Maninsoft, Inc. All rights reserved.
*/
/*
	정보관리 업무 클릭 : 정보관리업무 레코드 목록을 조회합니다.
	@param null
	@return null
*/

function updateListRecord(pageNo) {
	if(pageNo != undefined){
		$('pageNo').value = pageNo;
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
	var params = new Array();
	params.push("method=getRecords");
	params.push("isAsc=" + $F('isAsc'));
	params.push("order=" + $F('order'));
	params.push("pageNo=" + $F('pageNo'));
	params.push("pageSize=" + $F('pageSize'));
	params.push("formId=" + $F('formId'));
	params.push("filterTitle=" + $F('filterTitle'));
	params.push("searchWord=" + $F('searchWord1'));
	params.push("filterSelect=" + v_filterSelect);
	params.push("filterSearchKey=" + v_filterSearchKey);
	params.push("filterSearchWord=" + v_filterSearchWord);
	params.push("filterSearchUser=" + v_filterSearchUser);
	params.push("userId=" + userId);
	params.push("userLanguage=" + defaultLanguage);
	params.push("compId=" + compId);
	params = params.join("&");
	//alert(params);
	request(getPath() + "/services/portal/homeService.jsp", params, updateListRecordCallback, null, "loading", null,null);	
}

function updateListRecordCallback() {
	var xmlDoc = getXmlDOM(getResult());
	var resultXml = SmartXMLUtil.getChildNode(xmlDoc, 'Result');
	var totalSize = resultXml.getAttribute('totalSize');
	var formId = $F('formId');
	if(resultXml.getAttribute('status') == 'OK') {
		var table = $('listTable');
		var tBody = table.getElementsByTagName("tbody")[0];
		removeAllRow(1, table);
		if(totalSize > 0) {
			var recordsXml = SmartXMLUtil.getChildNodes(resultXml, 'Record');
			//alert(SmartXMLUtil.getXMLString(resultXml));
			for(var i=0; i<recordsXml.length; i++) {
				var recordId = recordsXml[i].getAttribute('recordId');
				var isNew 	 = recordsXml[i].getAttribute('isNew');
				var opSize 	 = recordsXml[i].getAttribute('opSize');
				var modificationUser = recordsXml[i].getAttribute('modificationUser');
				var modificationDate = recordsXml[i].getAttribute('modificationDate');
				//var recordType = recordsXml[i].getAttribute('recordType');

				var fieldXml = SmartXMLUtil.getChildNodes(recordsXml[i], 'field');
				var tr = new Element('tr', { 'style': 'cursor: pointer;', formId : formId, recordId: recordId }).observe('click', function(){viewRecord(this.getAttribute('formId'), this.getAttribute('recordId'))});
				
				//var typeTd = new Element('td', {'align': 'center'}).update(recordType);
				//tr.appendChild(typeTd);

				for(var k=0; k<fieldXml.length; k++) {
					var data = SmartXMLUtil.getNodeData(fieldXml[k]).escapeHTML();
					var tdAlign = fieldXml[k].getAttribute('tdAlign');
					var viewingType = fieldXml[k].getAttribute('viewingType');
					if(viewingType == "fileField" && data != "") {
						//alert(data);
						data = "<img src='../images/file.gif' border='0' id='"+data+"' onmouseover='filePopUp(\""+data+"\", event, \""+data+"\")' onmouseout='setTimeout(\"fileMouseOut(event)\", 0)';>";
					}

					if(data == "" || data == null)
						data = "&nbsp;";
					if(k == 0 && opSize > 0)
						data = data + "&nbsp;<font style='font-size:9px' color='fc0c0c'>[<b>"+opSize+"</b>]</font>";
					if(isNew == "true" && k == 0)
						data = data + "&nbsp;<img src='../images/ico_new.gif'>";

					var td = new Element('td', {'align': tdAlign, 'style': 'padding-left: 5px;'}).update(data);
					tr.appendChild(td);
				}

				var dateTd = new Element('td', {'align': 'left'}).update(modificationUser+"/ "+modificationDate);
				dateTd.setAttribute('colspan','2');
				tr.appendChild(dateTd);
				tBody.appendChild(tr);
			}
			var order = $F('order') === 'createdtime' ? 'modifiedtime' : $F('order'); //$F('order');
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
			params.push("funcName=updateListRecord");
			params = params.join("&");
			send(getPath() + "/common/listPaging.jsp", "pagingTd", params);
		} else {
			send(getPath() + "/common/message.jsp", "pagingTd", "message=NoDisplayList");
		}
	}else if(resultXml.getAttribute('status') == 'DEFAULT'){
	}else{
		//var ss = warnMessage('Warning', '선택하신 업무는 업무정의 수정중 입니다.',locationIndex);
		//return false;
	}
	//document.listForm.searchWord1.focus();
}

// 신규 인자값 추가 (기존 업무 화면에서의 신규업무시작과 업무선택하기후 신규업무시작을 구분하기위함.)
function createRecord(formId, nextPage, isNew) {

	if(nextPage == undefined)
		nextPage = "../form/formList.jsp";

	var loadType = "3";

	var form = document.listForm;

	var v_filterSelect = "";
	var v_filterSearchKey = "";
	var v_filterSearchWord = "";
	var v_filterSearchUser = "";
	var mainTitle = "";

	if(form != null) {
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
	}
	
	var pageNo = "";
	var pageSize = "";
	var filterId = "";
	var searchWord = "";
	var order = "";
	var isAsc = "";
	var filterTitle = "";
	if($('pageNo'))
		pageNo = $F('pageNo');
	if($('pageSize'))
		pageSize = $F('pageSize');
	if($('filterId'))
		filterId = $F('filterId');
	if($('searchWord'))
		searchWord = $F('searchWord');
	if($('order'))
		order = $F('order');
	if($('isAsc'))
		isAsc = $F('isAsc');
	if($('filterTitle'))
		filterTitle = $F('filterTitle');
	
	/*if($F('mainTitle'))
		mainTitle = $F('mainTitle');*/

	// jk yoon 시작 버튼 클릭시 시간.
	var d = new Date();
	//alert(d);

	var params = new Array();
	params.push("nextPage=" + nextPage);
	params.push("formId=" + formId);
	params.push("pageNo=" + pageNo);
	params.push("pageSize=" + pageSize);
	params.push("filterId=" + filterId);
	params.push("filterTitle=" + filterTitle);
	params.push("searchWord=" + searchWord);
	params.push("order=" + order);
	params.push("isAsc=" + isAsc);
	params.push("filterSelect=" + v_filterSelect);
	params.push("filterSearchKey=" + v_filterSearchKey);
	params.push("filterSearchWord=" + v_filterSearchWord);
	params.push("filterSearchUser=" + v_filterSearchUser);
	params.push("isNew=" + isNew);
	params.push("startTime=" + d.getTime());
	params.push("mainTitle=" + mainTitle);
	params = params.join("&");
	if(isNew=='NEW'){
		saveCookie("subject","");
		saveCookie("workContentsT","");
		saveCookie("projectNameT","");
		saveCookie("isPublicT","");
		saveCookie("priorityT","");
	}
	FormEnv.comBoMode = false;
	FormEnv.loadDataComplete = true;
	update("../testData/test1.jsp", "mainTd", params, createRecordCallBack, "loading", "failed");
}
function createRecordCallBack() {
	//var loadType = $F('loadType');
	var formId = $F('formId');
	//var recordId = $F('recordId');
	//var version = $F('version');
	var version = "version3";
	var formWork = new FormWork('workspace');
	console.dir(formWork);
	console.dir($('workspace'));
	try {
		$('workspace')['formWork'] = formWork;
	} catch (e) {
		console.log(e.message);
	}
	/*var plan = $F('plan');
	if(plan == 'PLAN'){
		formWork.initFormRuntime(userId, '../', formId, version, '', '', '3', 'view');
	}else{*/
		formWork.initFormRuntime(userId, '../', formId, version, '', '', '3', 'edit');
	/*}*/
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

function viewRecord(formId, recordId, nextPage) {
	if(nextPage == undefined)
		nextPage = "../form/formList.jsp";

	assigneeView = false;
	approvalSetupView = false;
	infoTaskView = false;
	var loadType = "2";
	if(recordId == null || recordId == ""){
		loadType = "3";
	}

	var form = document.listForm;
	var v_filterSelect = "";
	var v_filterSearchKey = "";
	var v_filterSearchWord = "";
	var v_filterSearchUser = "";
	if(form != null) {
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
	}
	var pageNo = "";
	var pageSize = "";
	var filterId = "";
	var searchWord = "";
	var order = "";
	var isAsc = "";
	var filterTitle = "";
	if($('pageNo'))
		pageNo = $F('pageNo');
	if($('pageSize'))
		pageSize = $F('pageSize');
	if($('filterId'))
		filterId = $F('filterId');
	if($('searchWord'))
		searchWord = $F('searchWord');
	if($('order'))
		order = $F('order');
	if($('isAsc'))
		isAsc = $F('isAsc');
	if($('filterTitle'))
		filterTitle = $F('filterTitle');
	var params = new Array();
	params.push("nextPage=" + nextPage);
	params.push("formId=" + formId);
	params.push("filterTitle=" + filterTitle);
	params.push("recordId=" + recordId);
	params.push("pageNo=" + pageNo);
	params.push("pageSize=" + pageSize);
	params.push("filterId=" + filterId);
	params.push("searchWord=" + searchWord);
	params.push("order=" + order);
	params.push("isAsc=" + isAsc);
	params.push("filterSelect=" + v_filterSelect);
	params.push("filterSearchKey=" + v_filterSearchKey);
	params.push("filterSearchWord=" + v_filterSearchWord);
	params.push("filterSearchUser=" + v_filterSearchUser);
	params = params.join("&");
	update("../form/formView.jsp", "mainTd", params, viewRecordCallBack, "loading", "failed");
}
function viewRecordCallBack() {
	var loadType = $F('loadType');
	var formId = $F('formId');
	var recordId = $F('recordId');
	var version = $F('version');
	if(loadType == "2") {
		var formWork = new FormWork('workspace');
		$('workspace')['formWork'] = formWork;
		formWork.initFormRuntime(userId, '../', formId, version, '', recordId, loadType, 'view');
	} else if(loadType == "3") {
		viewMode = 'insert';
		var formWork = new FormWork('workspace');
		$('workspace')['formWork'] = formWork;
		formWork.initFormRuntime(userId, '../', formId, version, '', '', loadType, 'edit');
	}
}

/*
	저장된 상세필터로 검색 : 저장된 필터로 정보관리업무 Record 목록을 검색합니다.
	@param null
	@return null
*/
function updateRecordCond() {

	var filterId = $F('filterId');
	if(filterId == "DEFAULT") {
		removeAllRow(0, $('filterListTable'));
		$('filterTable').hide();
		$('filterCondRemoveBtn').hide();
		updateListRecord('1');
	} else {
		var params = new Array();
		$('filterTable').show();
		if(filterId != "ALL" && filterId != "TIME" & filterId != "USER") {
			$('filterCondRemoveBtn').show();
		} else {
			$('filterCondRemoveBtn').hide();
		}
		params.push("method=getRecordCond");
		params.push("formId=" + $F('formId'));
		params.push("filterId=" + filterId);
		params.push("userId=" + userId);
		params.push("compId=" + compId);
		params = params.join("&");
		request(getPath() + "/services/portal/homeService.jsp", params, updateRecordCondCallBack, null, null, null, null);
	}
}
function updateRecordCondCallBack() {
	var xmlDoc = getXmlDOM(getResult());
	var resultXml = SmartXMLUtil.getChildNode(xmlDoc, 'Result');
	if(resultXml.getAttribute('status') == 'OK') {
		var filterXml = SmartXMLUtil.getChildNodes(resultXml, 'filter');
		var table = $('filterListTable');
		document.listForm.filterTitle.value = resultXml.getAttribute('filterTitle');
		removeAllRow(0, table);

		for(var i=0; i<filterXml.length; i++) {
			addFilterForm();
			var filterSelect  	 = document.getElementsByName("filterSelect");
			var filterSearchKey  = document.getElementsByName("filterSearchKey");
			var filterSearchWord = document.getElementsByName("filterSearchWord");
			var filterSearchUser = document.getElementsByName("filterSearchUser");

			filterSelect[i].value = filterXml[i].getAttribute('searchSelect');
			changeFilterForm(filterSelect[i]);
			filterSearchKey[i].value = filterXml[i].getAttribute('filterKey');
			filterSearchWord[i].value = filterXml[i].getAttribute('filterWord');
			filterSearchUser[i].value = filterXml[i].getAttribute('filterUser');
		}

		if(filterXml.length == 0)
			addFilterForm();
		updateListRecord('1');
	}
}


/*
	정보관리업무 필터 조건 추가
	@param null
	@return null
*/
function filterFormDisplay(filterId){
	if($('filterTable').style.display == 'none'){
		if(filterId == 'DEFAULT') {
			listForm.filterTitle.value = "";
			addFilterForm();
		} else {
			updateRecordCond();
		}
	}else{
		closeFilter2('FORM', listForm.filterId.value);
	}
}

function addFilterForm() {
	var params = new Array();
	$('filterTable').show();
	params.push("method=getFilterFields");
	params.push("formId=" + $F('formId'));
	params.push("userId=" + userId);
	params.push("userLanguage=" + defaultLanguage);
	params.push("compId=" + compId);
	params = params.join("&");
	request(getPath() + "/services/portal/homeService.jsp", params, addFilterFormCallBack, null, null, null, null);	
}
function addFilterFormCallBack() {
	var xmlDoc = getXmlDOM(getResult());
	var resultXml = SmartXMLUtil.getChildNode(xmlDoc, 'Result');
	if(resultXml.getAttribute('status') == 'OK') {
		var fieldXml = SmartXMLUtil.getChildNodes(resultXml, 'field');
		var filterSelectValueArr = new Array();
		var filterSelectNameArr = new Array();
		filterSelectValueArr[0] = [""];
		filterSelectNameArr[0] = [""];

		for(var i=0; i<fieldXml.length; i++) {
			var optValue = fieldXml[i].getAttribute('optValue')
			var optName = fieldXml[i].getAttribute('optName')
			filterSelectValueArr[i+1] = [optValue];
			filterSelectNameArr[i+1] = [optName];
		}
		
		var filterListTable = $('filterListTable');
		var tbody = filterListTable.getElementsByTagName("tbody")[0];
		var imageDir = "";
		if(defaultLanguage == "KOR") {
			imageDir = "/";
		} else {
			imageDir = "ENG/";
		}
		//jk yoon
		var len = filterListTable.rows.length;
		
		var tr = document.createElement("tr");
		var td1 = document.createElement("td");
		var select = createSelectElement("filterSelect", '100');
		select.onchange = function() {changeFilterForm(this,len);}
		createOptions(select, filterSelectValueArr, filterSelectNameArr);
		td1.appendChild(select);
		// jk yoon td style width 조정
		td1.style.width = "103";
		td1.style.textAlign = "left";
		var td2 = document.createElement("td");
		select = createSelectElement('filterSearchKey', '100');
		td2.style.width = "103";
		td2.style.textAlign = "left";
		td2.appendChild(select);
		var td3 = document.createElement("td");
		var input1 = createInputElement('text', 'filterSearchWord', '', '175');
		var input2 = createInputElement('hidden', 'filterSearchUser', '', '0');
		input1.setAttribute('class','input');
		td3.style.width = "180";
		td3.style.textAlign = "left";
		td3.appendChild(input1);
		td3.appendChild(input2);
		
		//alert(len);
		//td3.setAttribute("idx", len);
		//alert(td3.getAttribute("idx")+".//////");
		var td4 = document.createElement("td");
		td4.style.width="36px";
		var img = new Element('img', {src: '../images/'+imageDir+'bt_delete.gif'}).observe('click', function(){ removeFilter(this); }).setStyle({ 'cursor': 'pointer' });;
		td4.appendChild(img);
		td4.style.textAlign = "left";
		tr.appendChild(td1);
		tr.appendChild(td2);
		tr.appendChild(td3);
		tr.appendChild(td4);
		tbody.appendChild(tr);
	}
}
//jk yoon len 추가.
function changeFilterForm(obj, len) {
	//alert(len);
	var trNode = obj.parentNode.parentNode;
	var selectNode 	= trNode.getElementsByTagName("select")[0];
	var keyNode = trNode.getElementsByTagName("select")[1];
	var wordTdNode = trNode.getElementsByTagName("td")[2];
	var searchKeyValueArr = "";
	var searchKeyNameArr = "";
	var searchWordValueArr = "";
	var searchWordNameArr = "";
	var selectNodeValue = selectNode.value;
	
	var formId = $F('formId');
	var indexLength = selectNodeValue.indexOf('$', 0);
	var selectLength = selectNodeValue.length;
	
	//alert(selectLength);
	var fieldType = selectNodeValue.substring(indexLength+1, selectLength);
	var fieldId = selectNodeValue.substring(0, indexLength);

	if(fieldId == "userid" && formId == "frm_schedule_SYSTEM") {
		searchKeyValueArr = ["like"];
	} else if(fieldId == "accessLevel" && formId == "frm_schedule_SYSTEM") {
		searchKeyValueArr = ["", "=", "!="];
	} else if(fieldId == "creator" || fieldId == "modifier") {
		searchKeyValueArr = ["", "=", "!="];
	} else {
		if(fieldType == "string") {
			searchKeyValueArr = ["", "=", "!=", "like"];
		} else if(fieldType == "number" || fieldType == "time") {
			searchKeyValueArr = ["", "=", "!=", "<", ">", "<=", ">="];
		} else if(fieldType == "datetime" ) {
			searchKeyValueArr = ["", "datein", "datenotin", "<", ">", "<=", ">="];
		} else {
			searchKeyValueArr = ["", "=", "!=", "like"];
		}		
	}
	
	if(defaultLanguage == "KOR") {
		if(fieldId == "userid" && formId == "frm_schedule_SYSTEM") {
			searchKeyNameArr = ["포함"];
		} else if(fieldId == "accessLevel" && formId == "frm_schedule_SYSTEM") {
			searchKeyNameArr = ["", "같음", "같지 않음"];
		} else if(fieldId == "creator" || fieldId == "modifier") {
			searchKeyNameArr = ["", "같음", "같지 않음", "포함"];
		} else {
			if(fieldType == "string") {
				searchKeyNameArr = ["", "같음", "같지 않음", "포함"];
			} else if(fieldType == "number" || fieldType == "datetime" || fieldType == "time") {
				searchKeyNameArr = ["", "같음", "같지 않음", "미만", "초과", "이하", "이상"];
			} else {
				searchKeyNameArr = ["", "같음", "같지 않음", "포함"];
			}
		}
	} else {
		if(fieldId == "userid" && formId == "frm_schedule_SYSTEM") {
			searchKeyNameArr = ["Including"];
		} else if(fieldId == "accessLevel" && formId == "frm_schedule_SYSTEM") {
			searchKeyNameArr = ["", "Equal", "Not Equal"];
		} else if(fieldId == "creator" || fieldId == "modifier") {
			searchKeyNameArr = ["", "Equal", "Not Equal", "Including"];
		} else {
			if(fieldType == "string") {
				searchKeyNameArr = ["", "Equal", "Not Equal", "Including"];
			} else if(fieldType == "number" || fieldType == "datetime" || fieldType == "time") {
				searchKeyNameArr = ["", "Equal", "Not Equal", "Less than", "Excess", "Below", "More than"];
			} else {
				searchKeyNameArr = ["", "Equal", "Not Equal", "Including"];
			}
		}
	}
	
	if(fieldType == "time") {
		searchWordValueArr = ["00:00", "00:30", "01:00", "01:30", "02:00", "02:30", "03:00", "03:30", "04:00", "04:30", "05:00", "05:30", "06:00", "06:30", "07:00", "07:30", "08:00", "08:30", "09:00", "09:30", "10:00", "10:30", "11:00", "11:30", "12:00", "12:30", "13:00", "13:30", "14:00", "14:30", "15:00", "15:30", "16:00", "16:30", "17:00", "17:30", "18:00", "18:30", "19:00", "19:30", "20:00", "20:30", "21:00", "21:30", "22:00", "22:30", "23:00", "23:30" ];
		searchWordNameArr = ["AM 00:00", "AM 00:30", "AM 01:00", "AM 01:30", "AM 02:00", "AM 02:30", "AM 03:00", "AM 03:30", "AM 04:00", "AM 04:30", "AM 05:00", "AM 05:30", "AM 06:00", "AM 06:30", "AM 07:00", "AM 07:30", "AM 08:00", "AM 08:30", "AM 09:00", "AM 09:30", "AM 10:00", "AM 10:30", "AM 11:00", "AM 11:30", "PM 12:00", "PM 12:30", "PM 01:00", "PM 01:30", "PM 02:00", "PM 02:30", "PM 03:00", "PM 03:30", "PM 04:00", "PM 04:30", "PM 05:00", "PM 05:30", "PM 06:00", "PM 06:30", "PM 07:00", "PM 07:30", "PM 08:00", "PM 08:30", "PM 09:00", "PM 09:30", "PM 10:00", "PM 10:30", "PM 11:00", "PM 11:30"];
	} else if(fieldId == "accessLevel" && formId == "frm_schedule_SYSTEM") {
		searchWordValueArr = ["공개", "비공개"];
		searchWordNameArr = ["공개", "비공개"];
	}
	
	removeAllOptions(keyNode);
	createOptions(keyNode, searchKeyValueArr, searchKeyNameArr);
	removeChildNodes(wordTdNode, 0);

	if(fieldId == "userid" && formId == "frm_schedule_SYSTEM") {
		var input1 = createInputElement('text', 'filterSearchWord', '', '155');
		//jk yoon len 추가
		input1.onclick = function(){ searchUsersFilter(this,len);};
		var img = new Element('img', {src:'../image/form/user.gif'}).observe('click', function(){ searchUsersFilter(this,len); }).setStyle({ 'cursor': 'pointer' });
		wordTdNode.style.width="180";
		wordTdNode.appendChild(input1);
		wordTdNode.appendChild(img);
	} else if(fieldId == "accessLevel" && formId == "frm_schedule_SYSTEM") {
		var select = createSelectElement('filterSearchWord', '175');
		createOptions(select, searchWordValueArr, searchWordNameArr);
		wordTdNode.style.width="180";
		wordTdNode.appendChild(select);		
	} else if(fieldId == "creator" || fieldId == "modifier") {
		var input1 = createInputElement('text', 'filterSearchWord', '', '155');
		input1.onclick = function(){ searchUserFilter(this,len);};
		var img = new Element('img', {src:'../image/form/user.gif'}).observe('click', function(){ searchUserFilter(this, len); }).setStyle({ 'cursor': 'pointer' });
		var span = document.createElement("span");
		span.style.display = "inline";
		span.appendChild(input1);
		span.appendChild(img);
		wordTdNode.style.width="180";
		
		wordTdNode.appendChild(span);
		//wordTdNode.appendChild(input1);
		//wordTdNode.appendChild(img);
	} else {
		wordTdNode.style.width="180";
		if(fieldType == "string") {
		   var input = createInputElement('text', 'filterSearchWord', '', '175');
		   wordTdNode.appendChild(input);
		} else if(fieldType == "number") {
		   var input = createInputElement('text', 'filterSearchWord', '', '175');
		   input.onblur = function() {checknumber(this);};
		   wordTdNode.appendChild(input);
		} else if(fieldType == "time") {
			var select = createSelectElement('filterSearchWord', '175');
			createOptions(select, searchWordValueArr, searchWordNameArr);
			wordTdNode.appendChild(select);
		} else if(fieldType == "datetime") {
			var input1 = createInputElement('text', 'filterSearchWord', '', '155');
			input1.onblur = function() {isValidDateYMD(this);};
			wordTdNode.appendChild(input1);
			var img = new Element('img', {src:'../images/icon/dateChooser.gif'}).observe('click', function(){ popupSelectDateModalDialog(this); }).setStyle({ 'cursor': 'pointer' });
			wordTdNode.appendChild(img);
		} else {
		   var input = createInputElement('text', 'filterSearchWord', '', '175');
		   wordTdNode.appendChild(input);
		}
	}	
	var input = createInputElement('hidden', 'filterSearchUser', '', '220');
	wordTdNode.appendChild(input);	
}

/*
	정보관리업무 필터 저장 : 필터조건을 저장합니다.
	@param null
	@return null
*/
function setRecordCond() {
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
	params.push("method=setRecordCond");
	params.push("formId=" + $F('formId'));
	params.push("filterId=" + $F('filterId'));
	params.push("filterTitle=" + $F('filterTitle'));
	params.push("filterSelect=" + v_filterSelect);
	params.push("filterSearchKey=" + v_filterSearchKey);
	params.push("filterSearchWord=" + v_filterSearchWord);
	params.push("filterSearchUser=" + v_filterSearchUser);
	params.push("userId=" + userId);
	params.push("compId=" + compId);
	params = params.join("&");
	request(getPath() + "/services/portal/homeService.jsp", params, setRecordCondCallback, null, "notifySaveProgress", null, "warnSaveFailed");
}
function setRecordCondCallback() {
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
		updateListRecord('1');
	}
}

/*
	정보관리업무 필터 삭제 : 프로세스업무 필터조건을 삭제합니다.
	@param null
	@return null
*/
function removeRecordCond() {
	confirmMessage('AreYouSureYouWantToDeleteIt', _removeRecordCond);
}
function _removeRecordCond() {
	var params = new Array();
	params.push("method=removeRecordCond");
	params.push("formId=" + $F('formId'));
	params.push("filterId=" + $F('filterId'));
	params.push("userId=" + userId);
	params.push("compId=" + compId);
	params = params.join("&");
	request(getPath() + "/services/portal/homeService.jsp", params, removeRecordCondCallback, null, null, null, null);
}
function removeRecordCondCallback() {
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
		updateListRecord('1');
	}
}

/*
	정보관리업무 완료
	@param 
	@return null
*/
function setRecord() {
	var errorTxt = "";

	try{
		var vision = $('workStartVisionOnOff').style.display;
		if(vision != 'none'){
			var subject = $F('subject');
			var subjectTemp = subject.trim();
			if(subjectTemp==''){
				warnMessage("Youdidnotentertherequireditems", "PleaseEnterATitle");
				return;
			}
		}
		var type = $F('validateType');
		if(document.getElementById("subjectDiv").style.display == 'none') {
			if(type == 'REFERENCE'){
				
				var referenceTitle = $F('referenceTitle');
				var referenceTitleTemp = referenceTitle.trim();
				if(referenceTitleTemp==''){
					warnMessage("Youdidnotentertherequireditems", "PleaseEnterATitle");
					return;
				}
				var referenceUserName = $F('referenceUserName');
				var referenceUserNameTemp = referenceUserName.trim();
				if(referenceUserNameTemp==''){
					warnMessage("Youdidnotentertherequireditems", "PleaseReferenceUser");
					return;
				}
			}else if(type == 'APPROVAL') {
				var errorTxt2 = "";
				try {
					var receiptTitle = $F('receiptTitle');
					var receiptTitleTemp = receiptTitle.trim();
					if(receiptTitleTemp==''){
						warnMessage("Youdidnotentertherequireditems", "PleaseEnterATitle");
						return;
					}
					if(document.getElementsByName("approvalsId") != null) {
						for ( var i = 0 ; i < document.getElementsByName("approvalsId").length; i++ ) {
							if(document.getElementsByName("approvalsId")[i].value != null && document.getElementsByName("approvalsId")[i].value != "") {
								//alert(document.getElementsByName("approvalsId")[i].value);
							} else {
								warnMessage("Youdidnotentertherequireditems", "PleaseApprovalUser");
								return;
							}
						}
					}
				} catch(e) {
					errorTxt2 = "Error description: " + e.description + "\n\n";
					errorTxt2 += "Click OK to Continue. \n\n";
					alert(errorTxt2);
					return;
				}
			}else if(type == 'SINGLESEND'){
				var receiptTitle = $F('receiptTitle');
				var receiptTitleTemp = receiptTitle.trim();
				if(receiptTitleTemp==''){
					warnMessage("Youdidnotentertherequireditems", "PleaseEnterATitle");
					return;
				}
				var receiptUser = $F('receiptUser');
				var receiptUserTemp = receiptUser.trim();
				if(receiptUserTemp==''){
					warnMessage("Youdidnotentertherequireditems", "PleaseConnectUser");
					return;
				}
				
				var assigneeTaskFormName = $F('assigneeTaskFormName');
				var assigneeTaskFormNameTemp = assigneeTaskFormName.trim();
				if(assigneeTaskFormNameTemp==''){
					warnMessage("Youdidnotentertherequireditems", "PleaseConnectTask");
					return;
				}
			}
		}
	}catch(e){
/*		errorTxt = "Error description: " + e.description + "\n\n";
		errorTxt += "Click OK to Continue. \n\n";
		alert(errorTxt);
		return;*/
	}
	$('workspace')['formWork'].complete();
}

function setRecordTest(){
	//alert(oEditors.getById['comment'].getIR());
}

/*
	편집모드로 전환합니다.
	@param
	@return null
*/
function formFormWorkEidt() {
		$('titleTable').style.display = "";
		FormEnv.comBoMode =true;
		FormEnv.loadDataComplete = true;
	
		var d = new Date();
		document.getElementById('startTime').setAttribute('value', d.getTime());
		$('workspace')['formWork'].switchMode('edit', userId);
		infoTaskView = false;
		viewMode = 'edit';
	
	//jk yoon 추가
	//$('workStartPageViewId').style.display='none';
	//$('workStartPageId').style.display='block';
	
}

/*
	조회모드로 전환합니다.
	@param
	@return null
*/
function formFormWorkView() {
	FormEnv.loadDataComplete = true;
	$('titleTable').style.display = "none";
	$('workspace')['formWork'].switchMode('view', userId);
	infoTaskView = false;
	viewMode = 'view';
	//jk yoon 추가
	//$('workStartPageId').style.display='none';
	//$('workStartPageViewId').style.display='block';
}

/*
	정보관리업무 삭제
	@param
	@return null
*/
function removeRecord() {
	confirmMessage('AreYouSureYouWantToDeleteIt', _removeRecord);
}
function _removeRecord(){
	$('workspace')['formWork'].remove();
}
	
/*
	프로세스 업무 클릭 : 프로세스업무 인스턴스 목록을 조회합니다.
	@param null
	@return null
*/

function clickListForm(nextPage) {
	if(nextPage==undefined || nextPage == null || nextPage == 'undefined'){
		nextPage = '../form/formList.jsp';
	}
	var params = "";
	if($('searchParams'))
		params = $F('searchParams');

	if(params == ''){
		params = document.viewForm.searchParams.value;
	}
	FormEnv.loadDataComplete = true;	
	
	if(nextPage == "../form/formList.jsp") {
		update(nextPage, "mainTd", params, updateListRecord, "", "");
	} else {
		update(nextPage, "mainTd", params, null, "", "");
	}
}
	
function infoToTaskSend() {
	var approvalsId = "";
	var approvalType = "";
	var approvalName = "";

	if(document.getElementsByName("approvalsId") != null) {
		for ( var i = 0 ; i < document.getElementsByName("approvalsId").length; i++ ) {
			if(document.getElementsByName("approvalsId")[i].value != null && document.getElementsByName("approvalsId")[i].value != "") {
				approvalsId = approvalsId + document.getElementsByName("approvalsId")[i].value + ";";
			}
		}
	}
	if(document.getElementsByName("approvalType") != null) {
		for ( var i = 0 ; i < document.getElementsByName("approvalType").length; i++ ) {
			if(document.getElementsByName("approvalType")[i].value != null && document.getElementsByName("approvalType")[i].value != "") {
				approvalType = approvalType + document.getElementsByName("approvalType")[i].value + ";";
			}
		}
	}
	if(document.getElementsByName("approvalName") != null) {
		for ( var i = 0 ; i < document.getElementsByName("approvalName").length; i++ ) {
			if(document.getElementsByName("approvalName")[i].value != null && document.getElementsByName("approvalName")[i].value != "") {
				approvalName = approvalName + document.getElementsByName("approvalName")[i].value + ";";
			}
		}
	}
	$('workspace')['formWork'].infoToTaskSave( approvalsId, approvalType, approvalName);
}	

function approvalSetup() {
	if(approvalSetupView == false) {
		if(document.getElementById("infoTaskTable") != null) {
			document.getElementById("infoTaskTable").style.display = "";
		}
		if(document.getElementById("infoTaskExeTable") != null) {
			document.getElementById("infoTaskExeTable").style.display = "";
		}
		if(document.getElementById("viewTable") != null) {
			document.getElementById("viewTable").style.display = "none";
		}

		document.getElementById("assignSubjectTr").style.display = "";
		document.getElementById("ApprovalLineTr").style.display = "";

		document.getElementById("AssigneeTr").style.display = "none";
		document.getElementById("assigneeTaskTr").style.display = "none";
		document.getElementById("referenceUserTr").style.display = "none";

		assigneeView = true;
		approvalSetupView = true;
	} else if(approvalSetupView == true) {
		document.getElementById("assignSubjectTr").style.display = "none";
		document.getElementById("AssigneeTr").style.display = "none";
		document.getElementById("assigneeTaskTr").style.display = "none";
		document.getElementById("ApprovalLineTr").style.display = "none";
		if(document.getElementById("referenceUserTr") != null) {
			document.getElementById("referenceUserTr").style.display = "none";
		}
		if(document.getElementById("infoTaskTable") != null) {
			document.getElementById("infoTaskTable").style.display = "none";
		}
		if(document.getElementById("infoTaskExeTable") != null) {
			Element.hide($('infoTaskExeTable'));
		}
		if(document.getElementById("viewTable") != null) {
			Element.show($('viewTable'));
		}

		assigneeView = false;
		approvalSetupView = false;
	}
}

function assigneeSetup() {
	if(assigneeView == false) {
		document.getElementById("assignSubjectTr").style.display = "";
		document.getElementById("AssigneeTr").style.display = "";

		if(document.getElementById("receiver").value != null && document.getElementById("receiver").value  != "") {
			document.getElementById("assigneeTaskTr").style.display = "";
		} else {
			document.getElementById("assigneeTaskTr").style.display = "none";
		}

		if(approvalSetupView == false){
			if(document.getElementById("ApprovalLineTr") != null) {
				document.getElementById("ApprovalLineTr").style.display = "";
			}
		}
		if(document.getElementById("referenceUserTr") != null) {
			document.getElementById("referenceUserTr").style.display = "";
		}
		if(document.getElementById("infoTaskTable") != null) {
			document.getElementById("infoTaskTable").style.display = "";
		}
		if(document.getElementById("infoTaskExeTable") != null) {
			document.getElementById("infoTaskExeTable").style.display = "";
		}
		if(document.getElementById("viewTable") != null) {
			document.getElementById("viewTable").style.display = "none";
		}
		if(document.getElementById("editTable") != null) {
			document.getElementById("editTable").style.display = "none";
		}

		assigneeView = true;
		approvalSetupView = true;
	} else if(assigneeView == true) {
		document.getElementById("assignSubjectTr").style.display = "none";
		document.getElementById("AssigneeTr").style.display = "none";
		document.getElementById("assigneeTaskTr").style.display = "none";
		if(document.getElementById("ApprovalLineTr") != null) {
			document.getElementById("ApprovalLineTr").style.display = "none";
		}
		if(document.getElementById("referenceUserTr") != null) {
			document.getElementById("referenceUserTr").style.display = "none";
		}
		if(document.getElementById("infoTaskTable") != null) {
			document.getElementById("infoTaskTable").style.display = "none";
		}

		assigneeView = false;
		approvalSetupView = false;
		infoToTaskHide('view');
		if(viewMode != "insert") {
			$('workspace')['formWork'].switchMode(viewMode, userId);
		}
	}
}


/**
 * approval 과 deliver show Controller 
 * @param tableId :
 * @param type    : 필요시 업무 전달과 결재 업무를 구분하여, 내용 초기화
 * @return
 */
function addWork(type){
	 if(type == "CANCEL") {
		 $('approvalTable').hide();
		 $('addWorkBtnTable').show();
		 $('singleTable').hide();
		 if($('infoTaskExeTable'))
			 $('infoTaskExeTable').hide();
		 if($('editTable'))
			 $('editTable').hide();
		 if($('viewTable'))
			 $('viewTable').show();
	 } else if(type == "APPROVAL") {
		 $('approvalTable').show();
		 $('addWorkBtnTable').hide();
		 $('singleTable').hide();
		 if($('infoTaskExeTable'))
			 $('infoTaskExeTable').show();
		 if($('editTable'))
			 $('editTable').hide();
		 if($('viewTable'))
			 $('viewTable').hide();
	 } else if(type == "SINGLE") {
		 $('approvalTable').hide();
		 $('addWorkBtnTable').hide();
		 $('singleTable').show();
		 if($('infoTaskExeTable'))
			 $('infoTaskExeTable').show();
		 if($('editTable'))
			 $('editTable').hide();
		 if($('viewTable'))
			 $('viewTable').hide();
	 }
}

/**
 * approval, Deliver Value 초기화
 * @param type : 필요시 업무 전달과 결재 업무를 구분하여, 내용 초기화
 * @return
 */
function valueInitialization(type){
	if (!document.getElementsByTagName){
		return false;
	}
		 			
	var obj = document.getElementsByTagName('input');
	for(var i = 0 ; i < obj.length ; i++ ){
		if(obj[i].getAttribute('type') == 'text' ){
			obj[i].value = "";
			if(i == 5){
				break;
			}
		}
	}
}
/**
 * 
 * @param formId    : formId 혹은 ProcessId
 * @param recordId
 * @param type
 * @return
 */
function topSearchFormDetailView(formId, recordId , type) {
	if(type == 'form') {
	    var params = new Array();
	    params.push('formId=' + formId);
	    params.push('recordId=' + recordId);
	    params = params.join('&');
		//window.open("../common/topSearchDetailFormView.jsp?"+params , "" , "width=770 , height=700 , toolbar=no, location=no , status=no, menubar=no , scrollbars=yes , resizable=no");
		window.showModalDialog("../common/topSearchDetailFormView.jsp?"+params , window,
		"dialogWidth: 800px; dialogHeight: 600px; dialogTop:50px; dialogLeft:50px; center: yes; help: no; status: no; scroll: yes; resizable: no");
	} else if(type == 'proc') {
		var params = new Array();
	    params.push('procInstId=' + formId);
	    params = params.join('&');
	    //window.open("../common/topSearchDetailProcView.jsp?"+params , "" , "width=770 , height=700 , toolbar=no, location=no , status=no, menubar=no , scrollbars=yes , resizable=no");
	    window.showModalDialog("../common/topSearchDetailProcView.jsp?"+params , window,
		"dialogWidth: 800px; dialogHeight: 600px; dialogTop:50px; dialogLeft:50px; center: yes; help: no; status: no; scroll: yes; resizable: no");
	}
}

function finishedTaskView(taskId, procInstId) {
	
	var url = "../common/procViewPopUp.jsp";
	var params = 'taskId='+taskId+'&procInstId='+procInstId;
	//releaseModalDialog(true);
	popupModalDialog(url, params);
	
	//window.showModalDialog("../common/procViewPopUp.jsp?taskId="+taskId+"&procInstId="+procInstId, window, "dialogWidth: 800px; dialogHeight: 600px; dialogTop:50px; dialogLeft:50px; center: yes; help: no; status: no; scroll: yes; resizable: no");
}	

function finishedTaskList(processId, recordId) {
	if($("finishedTask"+processId).visible()) {
		$("finishedTask"+processId).hide();
	} else {
		if($("finishedTask"+processId).hasChildNodes()) {
			$("finishedTask"+processId).show();
		} else {
			$("finishedTask"+processId).show();
			update("../form/finishedTask.jsp", "finishedTask"+processId, "processId="+processId+"&recordId="+recordId,null, "loading", "failed");
		}
	}
}

/*
* 새일정 계획하기
* 정보관리 업무 계획
* */
function setNewPlanForm(){
	var formId 			= document.getElementById('formId').getAttribute('value');
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
	//params.push("processId=" + processId);
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
	params.push("sort=frm");
	params = params.join("&");
	
	var subjectTemp = subject.trim();
	
	if(subjectTemp==''|| subject == undefined){
		warnMessage('Warning', 'PleaseEnterATitle'); //제목을 입력하세요.
		return false;
	}
	
	if(performerId == '' || performerId == undefined){
		warnMessage('Warning', 'ChooseAttendant'); //수행자를 선택하세요.
		return false;
	}else if(willStartDate =='' || willStartDate == undefined){
		warnMessage('Warning', 'EnterThePlannedstarttime'); //예상 시작시간을 입력하세요.
		return false;
	}else if(willEndDate =='' || willEndDate == undefined){
		warnMessage('Warning', 'EnterThePlannedendtime'); //예상 종료시간을 입력하세요.
		return false;
	}
	
	request("../services/portal/planRegistService.jsp", params, null, null, "loading");
	location.href='../today/toDayIndex.jsp';
}

//화면 프린트
function printView() {

	sWidth = screen.availWidth/2 - 350;
	sHeight = screen.availHeight/2 - 300;
	newWin = window.open("../common/printPage.jsp", "printPage","toolbar=no,location=no,status=yes,directories=no,menubar=no,scrollbars=yes,resizable=yes,width=850,height=760,top="+sHeight+",left="+sWidth);
	newWin.focus(); 

}