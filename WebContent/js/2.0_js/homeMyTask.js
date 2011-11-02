/*
 * 프로그램명  : /js/homeMyTask.js
 * 최초	작성자 : 조형래
 * 최초	작성일 : 2008.06.04
 * 최종	수정자 :
 * 최종	수정일 :
 * 프로그램설명 : 홈 > 내 업무함에서 사용하는 자바스크립트 모음
 * =========================================================
 * Copyright (c) 2008 Maninsoft, Inc. All rights reserved.
*/
/*
	내 업무함 목록 검색 : 내업무함 목록을 검색 조회합니다.
	@param pageNo : 페이지 번호, 페이지 번호가 넘어오는 경우는 페이징에서 다른 페이지로 이동할 경우만
	@return null
*/

function updateListMyTask(pageNo) {
	if(pageNo != undefined)
		document.listForm.pageNo.value = pageNo;

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
			v_filterSearchUser = v_filterSearchUser + filterSearchUser[i].value+";";
		}
	}
	
	var params = new Array();
	params.push("method=getTasks");
	params.push("statusType=" + $F('statusType'));
	params.push("isAsc=" + $F('isAsc'));
	params.push("order=" + $F('order'));
	params.push("pageNo=" + $F('pageNo'));
	params.push("pageSize=" + $F('pageSize'));
	params.push("searchWord=" + $F('searchWord'));
	params.push("filterSelect=" + v_filterSelect);
	params.push("filterSearchKey=" + v_filterSearchKey);
	params.push("filterSearchWord=" + v_filterSearchWord);
	params.push("userId=" + userId);
	params.push("userLanguage=" + defaultLanguage);
	params.push("compId=" + compId);
	params = params.join("&");
	request(getPath() + "/services/portal/homeService.jsp", params, updateListMyTaskCallback, null, "loading", null, "failed");
}

function updateListMyTaskCallback() {
	var xmlDoc = getXmlDOM(getResult());
	var resultXml = SmartXMLUtil.getChildNode(xmlDoc, 'Result');
	var totalSize = resultXml.getAttribute('totalSize');
	if(resultXml.getAttribute('status') == 'OK') {
		var table = $('listTable');
		removeAllRow(1, table);
		if(totalSize > 0) {
			var taskXml = SmartXMLUtil.getChildNodes(resultXml, 'task');
			var tBody = table.getElementsByTagName("tbody")[0];
			var statusType = $F('statusType');
			for(var i=0; i<taskXml.length; i++) {
				var taskId = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(taskXml[i], 'taskId'));
				var opSize = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(taskXml[i], 'opSize'));
				var processInstId = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(taskXml[i], 'processInstId'));
				var processName = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(taskXml[i], 'processName')).escapeHTML();
				var processInstStatus = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(taskXml[i], 'processInstStatus'));
				var packageStatus = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(taskXml[i], 'packageStatus'));
				var priority = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(taskXml[i], 'priority'));
				var taskType = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(taskXml[i], 'taskType'));
				var referenceType = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(taskXml[i], 'referenceType'));
				var taskName = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(taskXml[i], 'taskName')).escapeHTML();
				var processInstCreationUserName = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(taskXml[i], 'processInstCreationUserName'));
				var title = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(taskXml[i], 'title')).escapeHTML();
				var referenceId = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(taskXml[i], 'referenceId'));
				var createionDate = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(taskXml[i], 'createionDate'));
				var taskTypeTitle = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(taskXml[i], 'taskTypeTitle')).escapeHTML();
				var executionDate = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(taskXml[i], 'executionDate'));
				var dueDate = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(taskXml[i], 'dueDate'));
				var formId = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(taskXml[i], 'formId'));
				var isNewTask = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(taskXml[i], 'isNewTask'));
				var hasApproval = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(taskXml[i], 'hasApproval'));
				//DEPLOYED
				var tr = null;
				if( packageStatus == "DEPLOYED") {
					tr = new Element('tr', { id: taskId+"tr", taskId: taskId, processInstId: processInstId, taskType: taskType, referenceId: referenceId, formId: formId }).observe('click', function(){ viewMyTask(this); }).setStyle({ 'cursor': 'pointer' });
				} else {
					tr = new Element('tr', { id: taskId+"tr", taskId: taskId, processInstId: processInstId, taskType: taskType, referenceId: referenceId, formId: formId }).observe('click', function(){ viewMyTask(null); }).setStyle({ 'cursor': 'pointer' });
				}

				var priorityTxt = "";
				if(priority == "H") {
					priorityTxt = "<font style='font-weight:bold;FONT-SIZE:12pt' color='#f10000'>!</font>";
				} else if(priority == "L") {
					priorityTxt = "<font style='font-weight:bold;FONT-SIZE:9pt' color='#7c7c7c'>▼</font>";

				} else {
					priorityTxt = "-";
				}
	
				if(processName != "") {
					processName = processName + "/ ";
				}
				
				if(opSize > 0)
					title = title + "&nbsp;<font style='FONT-SIZE:9px' color='#fc0c0c'>[<b>"+opSize+"</b>]</font>";

				if(isNewTask == "true")
					title = title + "&nbsp;<img src='../images/ico_new.gif'>";
	
				var taskTypeImage = null;
				if(statusType == "single") {
					//processName이 없을 경우는 정보관리업무에서 넘어온 것임.
					if( processName != "" && processName != null ) {
						taskTypeImage = new Element('img', {src: '../images/icon/taskType/type_pro_del.gif'});
					} else {
						taskTypeImage = new Element('img', {src: '../images/icon/taskType/type_inf_del.gif'});
					}
				} else if(statusType == "approval") {
					//processName이 없을 경우는 정보관리업무에서 넘어온 것임.
					if( processName != "" && processName != null ) {
						taskTypeImage = new Element('img', {src: '../images/icon/taskType/type_pro_sub.gif'});
					} else {
						taskTypeImage = new Element('img', {src: '../images/icon/taskType/type_inf_sub.gif'});
					}					
				} else {
					//processName이 없을 경우는 정보관리업무에서 넘어온 것임.
					if( processName != "" && processName != null ) {
						if(taskType == "COMMON") {
							taskTypeImage = new Element('img', {src: '../images/icon/taskType/PROCESS.gif'});
						} else if(taskType == "SINGLE") {
							taskTypeImage = new Element('img', {src: '../images/icon/taskType/PROCESS_SINGLE.gif'});
						} else if(taskType == "REFERENCE") {
							if(referenceType == "APPROVAL") {
								taskTypeImage = new Element('img', {src: '../images/icon/taskType/PROCESS_APPROVAL_REFERENCE.gif'});	
							} else {
								taskTypeImage = new Element('img', {src: '../images/icon/taskType/PROCESS_REFERENCE.gif'});
							}
						} else if(taskType == "APPROVAL") {
							taskTypeImage = new Element('img', {src: '../images/icon/taskType/PROCESS_APPROVAL.gif'});
						}
					} else {
						if(taskType == "SINGLE") {
							if(hasApproval == "Y") {
								taskTypeImage = new Element('img', {src: '../images/icon/taskType/FORM_APPROVAL.gif'});
							} else {
								taskTypeImage = new Element('img', {src: '../images/icon/taskType/FORM_SINGLE.gif'});
							}
						} else if(taskType == "REFERENCE") {
							if(referenceType == "APPROVAL") {
								taskTypeImage = new Element('img', {src: '../images/icon/taskType/FORM_APPROVAL_REFERENCE.gif'});	
							} else if(referenceType == "SINGLE") {
								taskTypeImage = new Element('img', {src: '../images/icon/taskType/FORM_SINGLE_REFERENCE.gif'});
							}
						} else if(taskType == "APPROVAL") {
							taskTypeImage = new Element('img', {src: '../images/icon/taskType/FORM_APPROVAL.gif'});
						}					
					}
				}
				var td1 = new Element('td', { 'align': 'center' }).update(priorityTxt);
				var td2 = new Element('td', { 'align': 'center' }).update(taskTypeImage);
				var td3, td4, td5, td6, td7, td8;
				var statusImage = null;
				if(processInstStatus == "2") {
					statusImage = new Element('img', {src: '../images/icon/status/state_opened.gif'});
				} else if(processInstStatus == "3") {
					statusImage = new Element('img', {src: '../images/icon/status/state_finished.gif'});
				}
		
				if(statusType == "opened") {
					td3 = new Element('td', { 'align': 'left' }).update("&nbsp;" + title);
					td4 = new Element('td', { 'align': 'left' }).update("&nbsp;" + processName + taskName);
					td5 = new Element('td', { 'align': 'left' }).update("&nbsp;" + dueDate);
					td6 = new Element('td', { 'align': 'left' }).update("&nbsp;" + processInstCreationUserName + "/ " + createionDate);
				} else {
					td3 = new Element('td', { 'align': 'center' }).update(statusImage);
					td4 = new Element('td', { 'align': 'left' }).update("&nbsp;" + title);
					td5 = new Element('td', { 'align': 'left' }).update("&nbsp;" + processName + taskName);
					td6 = new Element('td', { 'align': 'left' }).update("&nbsp;" + dueDate);
					td7 = new Element('td', { 'align': 'left' }).update("&nbsp;" + processInstCreationUserName + "/ " + createionDate);
					td8 = new Element('td', { 'align': 'left' }).update("&nbsp;" + executionDate);
				}
				tr.appendChild(td1);
				tr.appendChild(td2);
				tr.appendChild(td3);
				tr.appendChild(td4);
				tr.appendChild(td5);
				tr.appendChild(td6);
				if(statusType != "opened") {
					tr.appendChild(td7);
					tr.appendChild(td8);
				}
				tBody.appendChild(tr);
			}
		
			var order = $F('order');
			var tdObj = $(order+'Th');
			var trObj = tdObj.parentNode;

			var thNodes = trObj.getElementsByTagName("th");
			if(thNodes != null) {
				for(var i=0; i<thNodes.length; i++) {
					var thNode = thNodes[i]
					var imgNodes = thNode.getElementsByTagName("img");
					if(imgNodes != null) {
						for(var k=imgNodes.length; k>0 ; k--) {
							var imgNode = imgNodes[k-1];
							if(imgNode.getAttribute("id") != "priorityImg") {
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
			params.push("funcName=updateListMyTask");
			params = params.join("&");
			send(getPath() + "/common/listPaging.jsp", "pagingTd", params);
		} else {
			send(getPath() + "/common/message.jsp", "pagingTd", "message=NoDisplayList");
		}
	}
	//document.listForm.searchWord.focus();
}

/*
	내 업무함 목록 버튼 클릭
	@param obj : 메뉴 td object
	@param statusType : 내 업무함 상태 코드
	@return null
*/
function clickListMyTask(taskId, formId, procInstId, formType, demo) {
	if(demo == null || demo == undefined || demo== "null" || demo == "undefined" || demo == ''){
		var params = "";
		if($('searchParams')) {
			params = $F('searchParams');
		}
		location.href="../main/index.jsp";
		//update("../myTask/myTaskList.jsp", "mainTd", params, updateListMyTask, "loading", "failed");
	}else{
		var params = new Array();
		params.push("referenceId=" + referenceId);
		params.push("formType=" + formType);
		params.push("taskId=" + taskId);
		params.push("procInstId=" + procInstId);
		params.push("statusType=" + "complete");
		params.push("editMode=" + "false");
		params.push("formId=" + formId);
		params.push("pageNo=" + "1");
		params.push("pageSize=" + "5");
		params.push("demo=" + demo);
		params = params.join("&");
		var linkUrl = "../myTask/myTaskView.jsp";
		update(linkUrl, "mainTd", params, viewMyTaskCallback);
	}
}

/*
	내업무함 업무내용을 조회합니다.
	@param obj : 클릭한 목록 TR Object
	@return null
*/
function viewMyTask(obj) {
	if(obj == null) {
		warnMessage('Editing', 'Modifythecurrenttaskisdefiningthebusiness', null); //현재 업무는 업무정의 수정중입니다.
	} else {
		var form = document.listForm;
		var filterSelect  	 = document.getElementsByName("filterSelect");
		var filterSearchKey  = document.getElementsByName("filterSearchKey");
		var filterSearchWord = document.getElementsByName("filterSearchWord");
		//if(searchWord == null || searchWord == undefined){
		//var searchWord = document.getElementByName('searchWord');
		//}
		var status 	= "";
		if(document.getElementById('statusType') !=null && document.getElementById('statusType') !=undefined){
			var status = $F('statusType');
		}
		assigneeView = false;
		approvalSetupView = false;
		
		var v_filterSelect = "";
		var v_filterSearchKey = "";
		var v_filterSearchWord = "";
		for ( var i = 0 ; i < filterSearchWord.length; i++ ) {
			if(filterSelect[i].value != "" && filterSearchKey[i].value != "" && filterSearchWord[i].value != "") {
				v_filterSelect = v_filterSelect + filterSelect[i].value+";";
				v_filterSearchKey = v_filterSearchKey + filterSearchKey[i].value+";";
				v_filterSearchWord = v_filterSearchWord + filterSearchWord[i].value+";";
			}
		}
		//진행중인업무, 완료된 업무 구분
		var statusComplete = obj.getAttribute('statusComplete');
		if(statusComplete=='complete'){
			status = statusComplete;
		}else{
			status = "opened";
		}
		var params = new Array();
		params.push("referenceId=" + obj.getAttribute('referenceId'));
		params.push("formType=" + obj.getAttribute('taskType'));
		params.push("taskId=" + obj.getAttribute('taskId'));
		params.push("procInstId=" + obj.getAttribute('processInstId'));
		params.push("statusType=" + status);
		params.push("editMode=false");
		params.push("formId=" + obj.getAttribute('formId'));
		params.push("pageNo=" + $F('pageNo'));
		params.push("pageSize=" + $F('pageSize'));
		//params.push("searchWord=" + searchWord);
		params.push("filterSelect=" + v_filterSelect);
		params.push("filterSearchKey=" + v_filterSearchKey);
		params.push("filterSearchWord=" + v_filterSearchWord);
		params = params.join("&");
		var linkUrl = "../myTask/myTaskView.jsp";

		//update("/webservice/test.jsp","mainTd");
		if(obj.getAttribute('formId').indexOf("ef_")>-1){
			update(linkUrl, "mainTd", params, null, "loading", "faield");
		}else{
			update(linkUrl, "mainTd", params, viewMyTaskCallback, "loading", "faield");
		}
	}
}
///////////////////////////////////////////////// Demo////////////////////////////////////////////////////////////////////////

function viewMyTaskDemo(obj) {
	if(obj == null) {
		warnMessage('Editing', 'Modifythecurrenttaskisdefiningthebusiness', null); //현재 업무는 업무정의 수정중입니다.
	} else {
		var form = document.listForm;
		var status 	= "";
		if(document.getElementById('statusType') !=null && document.getElementById('statusType') !=undefined){
			var status = $F('statusType');
		}
		assigneeView = false;
		approvalSetupView = false;
		var statusComplete = obj.getAttribute('statusComplete');
		if(statusComplete=='complete'){
			status = statusComplete;
		}else{
			status = "opened";
		}
		var params = new Array();
		params.push("referenceId=" + obj.getAttribute('referenceId'));
		params.push("formType=" + obj.getAttribute('taskType'));
		params.push("taskId=" + obj.getAttribute('taskId'));
		params.push("procInstId=" + obj.getAttribute('processInstId'));
		params.push("statusType=" + status);
		params.push("editMode=false");
		params.push("formId=" + obj.getAttribute('formId'));
		params = params.join("&");
		window.open("../demo/demoIndex.jsp?referenceId="+obj.getAttribute('referenceId')+"&formType="+obj.getAttribute('taskType')+"&taskId="+obj.getAttribute('taskId')+"&procInstId="+obj.getAttribute('processInstId')+"&statusType="+status+"&editMode=false&formId="+obj.getAttribute('formId'));
	}
}

function viewMyTaskDemo2(referenceId, formType, taskId, procInstId, statusType, editMode, formId, demo) {
		var params = new Array();
		params.push("referenceId=" + referenceId);
		params.push("formType=" + formType);
		params.push("taskId=" + taskId);
		params.push("procInstId=" + procInstId);
		params.push("statusType=" + statusType);
		params.push("editMode=" + editMode);
		params.push("formId=" + formId);
		params.push("pageNo=" + "1");
		params.push("pageSize=" + "5");
		params.push("demo=" + demo);
		params = params.join("&");
		var linkUrl = "../myTask/myTaskView.jsp";
		update(linkUrl, "mainTd", params, viewMyTaskCallback);

}
/////////////////////////////////////////////////Demo////////////////////////////////////////////////////////////////////////////////

function viewMyTaskCallback() {
	var formId 	 = $F('formId');
	var taskType = $F('taskType');
	var status 	 = $F('status');
	var referenceId = $F('referenceId');
	var taskId 	= $F('taskId');
	var aprLineId = $F('aprLineId');
	var approvalRequired = $F('approvalRequired');  
	
	if($('commentTd')) {
		$('commentTd').update(editorInsert("comment", "615", "100"));
		createSmartEditor("comment");
	}
	
	if (taskType == "COMMON") {
		if(status == "opened") {
			if(formId != "") {
				var formWork = new FormWork('workspace');
				$('workspace')['formWork'] = formWork;
				formWork.initFormRuntime(userId, '../', formId, '', '', taskId, '1', 'edit');
			}
			if(approvalRequired == "true") {
				addSendTask('APPROVAL', formId, 'true', 'COMMON');
				$('addSendTaskCancelTr').hide();
			}
		} else if(status == "finished" || status =="complete") {
			taskHistoryDetailView(taskId, formId);
		}
	} else if (taskType == "APPROVAL") {
		if(status == "opened") {
			if(formId != "") {
				var formWork = new FormWork('workspace');
				$('workspace')['formWork'] = formWork;
				if(aprLineId != "" && aprLineId != null) {
					formWork.initFormRuntime(userId, '../', formId, '', '', referenceId, '1', 'view');

					var richEditor = editorInsert("referenceComment", "615", "100");
					$('referenceCommentTd').update(richEditor);
					createSmartEditor("referenceComment");

				} else {
					formWork.initFormRuntime(userId, '../', formId, '', '', taskId, '1', 'edit');
				}
			}
		} else {
			//alert(aprLineId +"////"+ referenceId +"////"+ formId);
			if(aprLineId != "" && aprLineId != null) {
				taskHistoryDetailView(referenceId, formId);
			} else {
				taskHistoryDetailView(taskId, formId);
			}
		}
	} else if (taskType == "REFERENCE" || taskType == "reference" ) {
		if (status == "opened") {
			if(formId != "") {
				var formWork = new FormWork('workspace');
				$('workspace')['formWork'] = formWork;//1~5
				formWork.initFormRuntime(userId, '../', formId, '', '', referenceId, '5', 'view');
				var richEditor = editorInsert("referenceComment", "615", "100");
				$('referenceCommentTd').update(richEditor);
				createSmartEditor("referenceComment");
			}
		} else {
			taskHistoryDetailView(referenceId, formId);
		}
	} else if (taskType == "GANTT") {
		if(status == "opened") {
			var formWork = new FormWork('workspace');
			$('workspace')['formWork'] = formWork;
			formWork.initFormRuntime(userId, '../', formId, '', '', taskId, '1', 'edit');
		}
	} else if (taskType == "SINGLE" || taskType == "SINGLESEND") {
		if(status == "opened") {
			if(formId != "") {
				var formWork = new FormWork('workspace');
				$('workspace')['formWork'] = formWork;
				formWork.initFormRuntime(userId, '../', formId, '', '', taskId, '1', 'edit');
			}
		} else {
			taskHistoryDetailView(taskId, formId);
		}
	}
}

/*
	내업무함 필터 조건 추가
	@param null
	@return null
*/
function filterMyTaskDisplay(){
	if($('filterTable').style.display == 'none'){	
		addFilterMyTask();
	}else{
		closeFilter();
	}
}
function addFilterMyTask() {
	$('filterTable').show();
	var filterSelectValueArr = ["", "taskType", "priority", "title", "taskName", "dueDate", "startDate"];
	var filterSelectNameArr = "";
	var imageDir = "";
	if(defaultLanguage == "KOR") {
		filterSelectNameArr = ["", "종류", "중요도", "제목", "태스크명", "처리기한", "할당일"];
		imageDir = "/";
	} else {
		filterSelectNameArr = ["", "Task Type", "Priority", "Subject", "Task Name", "Due Date", "Assigned Date"];
		imageDir = "ENG/";
	}
	var filterListTable = $('filterListTable');
	var tbody = filterListTable.getElementsByTagName("tbody")[0];
	var tr = document.createElement("tr");
	
	var td1 = document.createElement("td");
	var select = createSelectElement("filterSelect", '100');
	select.onchange = function() {changeFilterMyTask(this);}
	createOptions(select, filterSelectValueArr, filterSelectNameArr);
	td1.appendChild(select);
	
	var td2 = document.createElement("td");
	select = createSelectElement('filterSearchKey', '100');
	td2.appendChild(select);
	
	var td3 = document.createElement("td");
	var input1 = createInputElement('text', 'filterSearchWord', '', '175');
	var input2 = createInputElement('hidden', 'filterSearchUser', '', '0');
	input1.setAttribute('class','input');
	td3.appendChild(input1);
	td3.appendChild(input2);
	
	var td4 = document.createElement("td");
	var img = new Element('img', {src: '../images/'+imageDir+'bt_delete.gif'}).observe('click', function(){ removeFilter(this); }).setStyle({ 'cursor': 'pointer' });
	td4.appendChild(img);
	
	tr.appendChild(td1);
	tr.appendChild(td2);
	tr.appendChild(td3);
	tr.appendChild(td4);
	tbody.appendChild(tr);
}
/*
	내 업무함 필터 항목을 변경 : 내업무함 필터 조건에 맞는 연산자와 검색어 입력필드조건을 업데이트 합니다.
 	@param obj : 필터 조건 select Object
 	@return null
*/
function changeFilterMyTask(obj) {
	var trNode 	   = obj.parentNode.parentNode;
	var selectNode = trNode.getElementsByTagName("select")[0];
	var keyNode    = trNode.getElementsByTagName("select")[1];
	var wordTdNode = trNode.getElementsByTagName("td")[2];

	var keyValueArr = "";
	var keyNameArr = "";
	var wordValueArr = "";
	var wordNameArr = "";

	var selectNodeValue = selectNode.value;
	
	if(selectNodeValue == "title" || selectNodeValue == "taskName" ) {
		keyValueArr = ["", "=", "!=", "like"];
	} else if(selectNodeValue == "priority" ) {
		keyValueArr = ["", "=", "!="];
		wordValueArr = ["", "H", "M", "L"];
	} else if(selectNodeValue == "taskType" ) {
		keyValueArr = ["", "=", "!="];
		wordValueArr = ["", "APPROVAL", "SINGLE", "REFERENCE", "COMMON"];
	} else if(selectNodeValue == "startDate" || selectNodeValue == "dueDate" ) {
		keyValueArr = ["", "=", "!=", "<", ">", "<=", ">="];
	}
	
	if(defaultLanguage == "KOR") {
		if(selectNodeValue == "title" || selectNodeValue == "taskName" ) {
			keyNameArr = ["", "같음", "같지 않음", "포함"];
		} else if(selectNodeValue == "priority" ) {
			keyNameArr = ["", "같음", "같지 않음"];
			wordNameArr = ["", "높음", "보통", "낮음"];
		} else if(selectNodeValue == "taskType" ) {
			keyNameArr = ["", "같음", "같지 않음"];
			wordNameArr = ["", "결재업무", "정보관리업무", "참조업무", "할당업무"];
		} else if(selectNodeValue == "startDate" || selectNodeValue == "dueDate" ) {
			keyNameArr = ["", "같음", "같지 않음", "미만", "초과", "이하", "이상"];
		}
	} else {
		if(selectNodeValue == "title" || selectNodeValue == "taskName" ) {
			keyNameArr = ["", "Equal", "Not Equal", "Including"];
		} else if(selectNodeValue == "priority" ) {
			keyNameArr = ["", "Equal", "Not Equal"];
			wordNameArr = ["", "High", "Middle", "Low"];
		} else if(selectNodeValue == "taskType" ) {
			keyNameArr = ["", "Equal", "Not Equal"];
			wordNameArr = ["", "Approval Job", "Info Management Work", "Assigned Job", "Reference Job"];
		} else if(selectNodeValue == "startDate" || selectNodeValue == "dueDate" ) {
			keyNameArr = ["", "Equal", "Not Equal", "Less than", "Excess", "Below", "More than"];
		}
	}

	// 연산자 select option update
	removeAllOptions(keyNode);
	createOptions(keyNode, keyValueArr, keyNameArr);
	removeChildNodes(wordTdNode, 0);

	// 날짜 타입
	if(selectNodeValue == "startDate" || selectNodeValue == "dueDate" ) {
		var input1 = createInputElement('text', 'filterSearchWord', '', '155');
		wordTdNode.appendChild(input1);
		input1.onblur = function() {isValidDateYMD(this);}
		var img = new Element('img', {src:'../images/icon/dateChooser.gif'}).observe('click', function(){ popupSelectDateModalDialog(this); }).setStyle({ 'cursor': 'pointer' });
		wordTdNode.appendChild(img);
	// 중요도, 종류
	} else if(selectNodeValue == "priority" || selectNodeValue == "taskType" ) {
		var select = createSelectElement("filterSearchWord", '175');
		wordTdNode.appendChild(select);
		createOptions(select, wordValueArr, wordNameArr);
   // 기타 일반 텍스트
	} else {
       var input = createInputElement('text', 'filterSearchWord', '', '175');
       wordTdNode.appendChild(input);
   }
   var input = createInputElement('hidden', 'filterSearchUser', '', '0');
   wordTdNode.appendChild(input);
}

//	내업무함 저장 버튼 클릭
function saveTask() {
	$('workspace')['formWork'].save();
}

//	내 업무함 완료 버튼 클릭
function externalFormTaskExecute(taskId){
	var params = new Array();
	params.push("method=externalFormTaskExecute");
	params.push("taskId="+taskId);
	params = params.join("&");
	request(getPath() + "/services/runtime/executionService.jsp", params, planWorkStartCallback, null, "loading");
}
function setTask() {
	try{
		var type = $F('validateType');
		if(type == 'REFERENCE'){
			if($F('referenceTitle') == ''){
				warnMessage("Youdidnotentertherequireditems", "PleaseEnterATitle");
				return;
			}
			if($F('referenceUserName') == ''){
				warnMessage("Youdidnotentertherequireditems", "PleaseReferenceUser");
				return;
			}
			
		}else if(type == 'APPROVAL') {
			if($F('receiptTitle') == ''){
				warnMessage("Youdidnotentertherequireditems", "PleaseEnterATitle");
				return;
			}
			try{
				if(document.getElementsByName("approvalsId") != null) {
					for ( var i = 0 ; i < document.getElementsByName("approvalsId").length; i++ ) {
						if(document.getElementsByName("approvalsId")[i].value != null && document.getElementsByName("approvalsId")[i].value != "") {
							//alert(document.getElementsByName("approvalsId")[i].value);
						}else{
							warnMessage("Youdidnotentertherequireditems", "PleaseApprovalUser");
							return;
						}
					}
				}
				
			}catch(e){}
			
		}else if(type == 'SINGLESEND'){
			if($F('receiptTitle') == ''){
				warnMessage("Youdidnotentertherequireditems", "PleaseEnterATitle");
				return;
			}
			if($F('receiptUser') == ''){
				warnMessage("Youdidnotentertherequireditems", "PleaseConnectUser");
				return;
			}
			if($F('assigneeTaskFormName') == ''){
				warnMessage("Youdidnotentertherequireditems", "PleaseConnectTask");
				return;
			}
		}
	}catch(e){}	
	
	if($F('taskType') == "APPROVAL" && $F('aprLineId') != "") {
		var referenceComment = oEditors.getById['referenceComment'].getIR();
		//if(referenceComment == "" || referenceComment == null) {
			//warnMessage("Youdidnotentertherequireditems", "PleaseEnterAComment2"); //의견을 입력하세요.
		//} else {
		confirmMessage('confirmComplete', _setTask);
		//}
	} else {
		confirmMessage('confirmComplete', _setTask);
	}
}

function _setTask() {
	$('workspace')['formWork'].complete();
}

//	내업무함 업무를 반려합니다
function returnTask() {
	if($F('taskType') == "APPROVAL" && $F('aprLineId') != "") {
		var referenceComment = oEditors.getById['referenceComment'].getIR();
		//if(referenceComment == "" || referenceComment == null) {
			//warnMessage("Youdidnotentertherequireditems", "PleaseEnterAComment2"); //의견을 입력하세요.
		//} else {
			confirmMessage('confirmReturn', _returnTask);
		//}
	} else {
		confirmMessage('confirmReturn', _returnTask);
	}
}
function _returnTask() {
	$('workspace')['formWork'].returnTask();
}

/*
	내업무함 업무를 위임합니다
	@param
	@return null
*/
//function delegateTask(obj) {
//	document.viewForm.delegateUserId.value = obj.userId;
//	confirmMessage('confirmDelegate', _delegateTask);
//}
function delegateTask(userId) {
	document.viewForm.delegateUserId.value = userId;
	confirmMessage('confirmDelegate', _delegateTask);
}
function _delegateTask() {
	releaseModalDialog(false);
	$('workspace')['formWork'].delegateTask();
}

//내업무함 업무를 기안취소합니다.
function cancelTask() {
	confirmMessage('confirmCancelTask', _cancelTask);
}
function _cancelTask() {
	$('workspace')['formWork'].cancelTask();
}

/*
 * 일정계획 업무를 시작한다.
 * jk yoon
 * */
function planWorkStart(taskId){
	var params = new Array();
	params.push('method=planWorkStart');
	params.push('taskId='+taskId);
	params = params.join('&');
	//alert('planWorkStart');
	request(getPath() + "/services/portal/planRegistService.jsp", params, planWorkStartCallback, null, "loading");
}
function planWorkStartCallback(){
	location.href='../today/toDayIndex.jsp';
}