Array.prototype.remove = function(idx){
	var temp = new Array();
	var i = this.length;
	while(i > idx){
		var kk = this.pop();
		temp.push(kk);
		i--;
	}

	for(var i=temp.length - 2; i>=0; i--){
		this.push(temp[i]);
	}
}

function startCdataTag(){
	return "<![CDATA[";
}

function endCdataTag(){
	return "]]>";
}

function deleteRow(obj){
	//obj.parentNode.parentNode.removeNode(true);
	var tagetObj = obj.parentNode.parentNode;
	tagetObj.parentNode.removeChild(tagetObj);
}

function changeReportFilterSelect(obj) {
	var trNode = obj.parentNode.parentNode;
	var filterSelect 	= trNode.getElementsByTagName("select")[0];
	var filterSearchKey = trNode.getElementsByTagName("select")[1];
	var filterSearchWordTd = trNode.getElementsByTagName("td")[2];

	var searchKeyValueArr = "";
	var searchKeyNameArr = "";
	var searchWordValueArr = "";
	var searchWordNameArr = "";
	var imageDir = "";

	if(defaultLanguage == "KOR") {
		if(filterSelect.value == "name" ) {
			searchKeyValueArr = ["", "=", "!=", "like"];
			searchKeyNameArr = ["", "같음", "같지 않음", "포함"];
		} else if(filterSelect.value == "type" ) {
			searchKeyValueArr = ["", "=", "!="];
			searchKeyNameArr = ["", "같음", "같지 않음"];
			searchWordValueArr = ["", "GRID", "MATRIX", "LINE_CHART", "PIE_CHART", "AREA_CHART", "COLUMN_CHART", "BAR_CHART"];
			searchWordNameArr = ["", "테이블", "매트릭스", "선 차트", "파이 차트", "영역 차트", "컬럼 차트", "막대 차트"];
		} else if(filterSelect.value == "enabledYn" ) {
			searchKeyValueArr = ["", "=", "!="];
			searchKeyNameArr = ["", "같음", "같지 않음"];
			searchWordValueArr = ["", "Y", "N"];
			searchWordNameArr = ["", "Y", "N"];
		} else if(filterSelect.value == "creationDate") {
			searchKeyValueArr = ["", "datein", "datenotin", "<", ">", "<=", ">="];
			searchKeyNameArr = ["", "같음", "같지 않음", "미만", "초과", "이하", "이상"];
		} else if(filterSelect.value == "creationUser") {
			searchKeyValueArr = ["", "=", "!="];
			searchKeyNameArr = ["", "같음", "같지 않음"];
		}
	} else {
		if(filterSelect.value == "name" ) {
			searchKeyValueArr = ["", "=", "!=", "like"];
			searchKeyNameArr = ["", "Equal", "Not Equal", "Including"];
		} else if(filterSelect.value == "type" ) {
			searchKeyValueArr = ["", "=", "!="];
			searchKeyNameArr = ["", "Equal", "Not Equal"];
			searchWordValueArr = ["", "GRID", "MATRIX", "LINE_CHART", "PIE_CHART", "AREA_CHART", "COLUMN_CHART", "BAR_CHART"];
			searchWordNameArr = ["", "Table", "Matrix", "Line Chart", "Pie Chart", "Area Chart", "Column Chart", "Bar Chart"];
		} else if(filterSelect.value == "enabledYn" ) {
			searchKeyValueArr = ["", "=", "!="];
			searchKeyNameArr = ["", "Equal", "Not Equal"];
			searchWordValueArr = ["", "Y", "N"];
			searchWordNameArr = ["", "Y", "N"];
		} else if(filterSelect.value == "creationDate" ) {
			searchKeyValueArr = ["", "datein", "datenotin", "<", ">", "<=", ">="];
			searchKeyNameArr = ["", "datein", "datenotin", "Less than", "Excess", "Below", "More than"];
		} else if(filterSelect.value == "creationUser") {
			searchKeyValueArr = ["", "=", "!="];
			searchKeyNameArr = ["", "Equal", "Not Equal"];
		}
	}

	//script.js : select에 속해 있는 옵션 삭제
	removeAllOptions(filterSearchKey);

	//script.js : select에 option추가
	createOptions(filterSearchKey, searchKeyValueArr, searchKeyNameArr);

	//script.js : 자식노드 삭제
	removeChildNodes(filterSearchWordTd, 0);

	// 날짜 타입
	if(filterSelect.value == "creationDate") {
		var input1 = createInputElement('text', 'filterSearchWord', '', '155');
		filterSearchWordTd.appendChild(input1);
		input1.onblur = function() {isValidDateYMD(this);}

		var img = document.createElement("img");
		img.setAttribute("src", "../images/icon/dateChooser.gif");
		filterSearchWordTd.appendChild(img);
		Element.setStyle(img, {padding: '1px'});
		img.onclick = function() {popupSelectDateModalDialog(this)};
	// 작성자
	} else if(filterSelect.value == "creationUser") {
		var input1 = createInputElement('text', 'filterSearchWord', '', '155');
		input1.onclick = function(){ searchUserFilter(this);};
		filterSearchWordTd.appendChild(input1);
   		var img = document.createElement("img");
   		img.setAttribute("src", "../image/form/user.gif");
   		filterSearchWordTd.appendChild(img);
   		Element.setStyle(img, {padding: '1px'});
   		img.observe('click', function() {searchUserFilter(this)});
	// 보고서 종류, 사용유무
	} else if(filterSelect.value == "type" || filterSelect.value == "enabledYn" ) {
		var select = createSelectElement("filterSearchWord", '175');
		filterSearchWordTd.appendChild(select);
		createOptions(select, searchWordValueArr, searchWordNameArr);
   // 기타 일반 텍스트
	} else {
       var input = createInputElement('text', 'filterSearchWord', '', '175');
       filterSearchWordTd.appendChild(input);
   }
   var input = createInputElement('hidden', 'filterSearchUser', '', '0');
   filterSearchWordTd.appendChild(input);
}

// 상세필터 조건 추가.
/*
function addReportFilter() {
	document.getElementById("filterTable").style.display = "";
	var filterSelectValueArr = ["", "name", "type", "creationUser", "creationDate", "enabledYn"];
	var filterSelectNameArr = "";
	var imageDir = "";
	if(defaultLanguage == "KOR") {
		filterSelectNameArr = ["", "제목", "보고서 종류", "작성자", "작성일자", "사용유무"];
		imageDir = "/";
	} else {
		filterSelectNameArr = ["", "Subject", "Type of Report", "Written By", "Date", "Use"];
		imageDir = "ENG/";
	}
	var filterListTable = document.getElementById("filterListTable");
	var tbody = filterListTable.getElementsByTagName("tbody")[0];
	var tr = document.createElement("tr");

	var td1 = document.createElement("td");
	var select = createSelectElement("filterSelect", '175');
	select.onchange = function() {changeReportFilterSelect(this);}

	//script.js : select에 option추가
	createOptions(select, filterSelectValueArr, filterSelectNameArr);
	td1.appendChild(select);

	var td2 = document.createElement("td");
	select = createSelectElement('filterSearchKey', '175');
	td2.appendChild(select);

	var td3 = document.createElement("td");
	var input1 = createInputElement('text', 'filterSearchWord', '', '175');
	var input2 = createInputElement('hidden', 'filterSearchUser', '', '0');
	td3.appendChild(input1);
	td3.appendChild(input2);

	var td4 = document.createElement("td");
	td4.innerHTML = "<img src='../images/"+imageDir+"bt_delete.gif' style='cursor: pointer;' onclick='removeFilter(this);' >";

	tr.appendChild(td1);
	tr.appendChild(td2);
	tr.appendChild(td3);
	tr.appendChild(td4);

	tbody.appendChild(tr);
}
 * */

function updateReportList(pageNo) {
	if(pageNo != undefined) {
		document.listForm.pageNo.value 	= pageNo;
	}
	var v_filterSelect = "";
	var v_filterSearchKey = "";
	var v_filterSearchWord = "";
	var v_filterSearchUser = "";

	var filterSelect  		= document.getElementsByName("filterSelect");
	var filterSearchKey  	= document.getElementsByName("filterSearchKey");
	var filterSearchWord  	= document.getElementsByName("filterSearchWord");
	var filterSearchUser = document.getElementsByName("filterSearchUser");

	for ( var i = 0 ; i < filterSearchWord.length; i++ ) {
		if(filterSelect[i].value != "" && filterSearchKey[i].value != "" && filterSearchWord[i].value != "" ) {
			v_filterSelect = v_filterSelect + filterSelect[i].value+";";
			v_filterSearchKey = v_filterSearchKey + filterSearchKey[i].value+";";
			v_filterSearchWord = v_filterSearchWord + filterSearchWord[i].value+";";

			if(filterSelect[i].value == "creationUser" && filterSearchUser[i].value != ""){
				v_filterSearchUser = v_filterSearchUser + filterSearchUser[i].value+";";
			}else{
				v_filterSearchUser 	= v_filterSearchUser + "EMPTYVALUE;";
			}
		}
	}
	
	var params = new Array(); 
	params.push("method=getReports");
	params.push("filterSelect=" + v_filterSelect);
	params.push("filterSearchKey=" + v_filterSearchKey);
	params.push("filterSearchWord=" + v_filterSearchWord);
	params.push("filterSearchUser=" + v_filterSearchUser);
	params.push("isAsc=" + $('isAsc').getValue());
	params.push("order=" + $('order').getValue());
	params.push("pageNo=" + $('pageNo').getValue());
	params.push("pageSize=" + $('pageSize').getValue());
	params.push("searchWord=" + $('searchWord').getValue());
	params.push("userId=" + userId);
	params.push("userLanguage=" + defaultLanguage);
	params.push("compId=" + compId);
	params = params.join("&");
	request(getPath() + "/services/portal/reportService.jsp" , params , updateReportListCallBack, null , 'loading', null , 'failed');
}
function updateReportListCallBack() {
	var xmlDoc = getXmlDOM(getResult());
	var resultXml = SmartXMLUtil.getChildNode(xmlDoc, 'Result');
	var totalSize = resultXml.getAttribute('totalSize');
	if(resultXml.getAttribute('status') == 'OK') {
		var reportXml = SmartXMLUtil.getChildNodes(resultXml, 'Report');
		var table = $('listTable');
		var tBody = table.getElementsByTagName("tbody")[0];
		removeAllRow(1, table);
		var totalSize = resultXml.getAttribute('totalSize');
		for(var i=0; i<reportXml.length; i++) {
			var reportId = reportXml[i].getAttribute('reportId');
			var title = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(reportXml[i], 'title'));
			var formId = reportXml[i].getAttribute('formId');
			var creationUserId = reportXml[i].getAttribute('creationUserId');
			var creationUserName = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(reportXml[i], 'creationUserName'));
			var creationDate = reportXml[i].getAttribute('creationDate');
			var isEnabled = reportXml[i].getAttribute('isEnabled');
			var categoryName = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(reportXml[i], 'categoryName'));
			var formName = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(reportXml[i], 'formName'));
			var reportType = reportXml[i].getAttribute('reportType');
			var reportTypeName = reportXml[i].getAttribute('reportTypeName');
			var isNew = reportXml[i].getAttribute('isNew');
			if(isNew == "true")
				title = title + "&nbsp;<img src='../images/ico_new.gif'>";
			//var tr = new Element('tr', { 'style': 'cursor: pointer', reportId: reportId, id: reportId+"tr"});
			var tr = new Element('tr', { 'style': 'cursor: pointer', id: reportId});
			tr.observe('click', function(){viewReport(this);});

			var td1 = new Element('td', { 'align': 'left' }).update("&nbsp;"+title);
			var td2 = new Element('td', { 'align': 'left' }).update("&nbsp;"+categoryName);
			var td3 = new Element('td', { 'align': 'left'}).update("&nbsp;"+formName);
			var td4 = new Element('td', { 'align': 'left'}).update("&nbsp;"+reportTypeName);
			var td5 = new Element('td', { 'align': 'left'}).update("&nbsp;"+isEnabled);
			var td6 = new Element('td', { 'align': 'left'}).update("&nbsp;"+creationUserName+"/ "+creationDate);

			tr.appendChild(td1);
			tr.appendChild(td2);
			tr.appendChild(td3);
			tr.appendChild(td4);
			tr.appendChild(td5);
			tr.appendChild(td6);
			tBody.appendChild(tr);

		}
		var order = document.listForm.order.value;
		var tdObj = document.getElementById(order+"Th");
		var trObj = tdObj.parentNode;
		var thNodes = trObj.getElementsByTagName("th");
		if(thNodes != null) {
			for(var i=0; i<thNodes.length; i++) {
				var thNode = thNodes[i]
				var imgNodes = thNode.getElementsByTagName("img");
				if(imgNodes != null) {
					for(var k=imgNodes.length; k>0 ; k--) {
						thNode.removeChild(imgNodes[k-1]);
					}
				}
			}
		}
		if(document.listForm.isAsc.value == "false") {
			//tdObj.innerHTML = tdObj.outerHTML + "<img src=../images/bt_down.gif>";
			tdObj.innerHTML += "<img src=../images/bt_down.gif>";
		} else {
			//tdObj.innerHTML = tdObj.outerHTML + "<img src=../images/bt_up.gif>";
			tdObj.innerHTML += "<img src=../images/bt_up.gif>";
		}

		var params = new Array();
		params.push("totalSize=" + totalSize);
		params.push("pageSize=" + $('pageSize').getValue());
		params.push("pageNo=" + $('pageNo').getValue());
		params.push("targetTd=pagingTd");
		params.push("funcName=updateReportList");
		params = params.join("&");
		update(getPath() + "/common/listPaging.jsp", "pagingTd", params, null, "", "");
	}	
}

// 상세필터 검색
function reportFilterSearch(selectMsg, keyMsg, wordMsg) {
	var form = document.listForm;

	var pageSize = form.pageSize.value;

	var params = "";
	var v_filterSelect = "";
	var v_filterSearchKey = "";
	var v_filterSearchWord = "";
	var v_filterSearchUser = "";

	var filterSelect  		= document.getElementsByName("filterSelect");
	var filterSearchKey  	= document.getElementsByName("filterSearchKey");
	var filterSearchWord  	= document.getElementsByName("filterSearchWord");
	var filterSearchUser = document.getElementsByName("filterSearchUser");

	for ( var i = 0 ; i < filterSearchWord.length; i++ ) {
		if(filterSelect[i].value != "" && filterSearchKey[i].value != "" && filterSearchWord[i].value != "" ) {
			v_filterSelect = v_filterSelect + filterSelect[i].value+";";
			v_filterSearchKey = v_filterSearchKey + filterSearchKey[i].value+";";
			v_filterSearchWord = v_filterSearchWord + filterSearchWord[i].value+";";

			if(filterSelect[i].value == "creationUser" && filterSearchUser[i].value != ""){
				v_filterSearchUser = v_filterSearchUser + filterSearchUser[i].value+";";
			}else{
				v_filterSearchUser 	= v_filterSearchUser + "EMPTYVALUE;";
			}
		}
	}
	params = "pageSize="+pageSize+"&filterSelect="+v_filterSelect+"&filterSearchKey="+v_filterSearchKey+"&filterSearchWord="+v_filterSearchWord+"&filterSearchUser="+v_filterSearchUser;
	send("../report/reportList.jsp", "mainTd",  params);
}


// 닫기 클릭시 parameter 값은 필요하지 않음.
function reportFilterClose() {
	send("../report/reportList.jsp", "mainTd",  "");
}

//상세 조건 삭제 Case1
function reportFilterDel(obj){
	var filterSearchWord  	= document.getElementsByName("filterSelect");
	if( filterSearchWord.length > 1) {
		//obj.parentNode.parentNode.removeNode(true);
		var tagetObj = obj.parentNode.parentNode;
		tagetObj.parentNode.removeChild(tagetObj);
	}
}

function changeCatgory(formId) {
	var categoryId = document.getElementById("categoryId").value;
	var params = new Array(); 
	params.push("method=getFormsAndGroups");
	params.push("categoryId=" + categoryId);
	params.push("userId=" + userId);
	params.push("userLanguage=" + defaultLanguage);
	params.push("compId=" + compId);
	params = params.join("&");
	request(getPath() + "/services/portal/reportService.jsp", params, changeCatgoryCallback, null, "", null, "");
}

function changeCatgoryCallback(transport) {
	var xmlDoc = getXmlDOM(getResult());
	var resultXml = SmartXMLUtil.getChildNode(xmlDoc, 'Result');
	if(resultXml.getAttribute('status') == 'OK') {
		// 그룹
		var groupXml = SmartXMLUtil.getChildNodes(resultXml, 'category');
		var selectBox = document.getElementById("groupId");
		var options = selectBox.getElementsByTagName("option");
		for(var i=options.length-1; i>-1 ; i--) {
			options[i].parentNode.removeChild(options[i]);
		}
		// 그룹 select box 옵션 추가
		var newOption = document.createElement("OPTION");
		selectBox.appendChild(newOption);
		for(var i=0; i<groupXml.length; i++) {
			//var groupId   = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(groupXml[i], 'objId'));
			//var groupName = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(groupXml[i], 'name'));
			var groupId   = groupXml[i].getAttribute('objId')
			var groupName = groupXml[i].getAttribute('name')
			newOption = document.createElement("OPTION");
			newOption.value = groupId;
			newOption.appendChild(document.createTextNode(groupName)); 
			selectBox.appendChild(newOption);
		}

		// 정보관리업무
		var formXml = SmartXMLUtil.getChildNodes(resultXml, 'Form');
		var selectBox = document.getElementById("formId");
		// 정보관리업무 select box 옵션 초기화
		var options = selectBox.getElementsByTagName("option");
		for(var i=options.length-1; i>-1 ; i--) {
			options[i].parentNode.removeChild(options[i]);
		}
		// 정보관리업무 select box 옵션 추가
		var newOption = document.createElement("OPTION");
		selectBox.appendChild(newOption);

		for(var i=0; i<formXml.length; i++) {
			var formId   = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(formXml[i], 'formId'));
			var formName = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(formXml[i], 'name'));
			newOption = document.createElement("OPTION");
			newOption.value = formId;
			newOption.appendChild(document.createTextNode(formName)); 
			selectBox.appendChild(newOption);
		}
		//필드항목 테이블 초기화
		removeAllRow(1, document.getElementById("formFieldTable"));
		//필터항목 테이블 초기화
		removeAllRow(1, document.getElementById("reportFilterTable"));
		//설정한 항목 테이블 초기화
		removeAllRow(1, document.getElementById("reportContentTable1"));
		removeAllRow(1, document.getElementById("reportContentTable2"));
		removeAllRow(1, document.getElementById("reportContentTable3"));
	}
}

function changeGroup() {
	var groupId = document.getElementById("groupId").value;
	//그룹을 선택했을 경우
	if(groupId != null && groupId != "") {
		var params = new Array(); 
		params.push("method=getForms");
		params.push("categoryId=" + groupId);
		params.push("userId=" + userId);
		params.push("userLanguage=" + defaultLanguage);
		params.push("compId=" + compId);
		params = params.join("&");
		
		request(getPath() + "/services/portal/reportService.jsp", params, changeGroupCallBack, null, "", null, "");
	//그룹을 공백으로 선택하면 해당그룹의 카테고리에 속한 정보관리업무 목록 가져오기
	} else {
		changeCatgory('');
	}
}

function changeGroupCallBack() {
	var xmlDoc = getXmlDOM(getResult());
	var resultXml = SmartXMLUtil.getChildNode(xmlDoc, 'Result');
	if(resultXml.getAttribute('status') == 'OK') {

		var selectBox = document.getElementById("groupId");
		var options = selectBox.getElementsByTagName("option");
		var formXml = SmartXMLUtil.getChildNodes(resultXml, 'Form');
		var selectBox = document.getElementById("formId");
		// 정보관리업무 select box 옵션 초기화
		var options = selectBox.getElementsByTagName("option");
		for(var i=options.length-1; i>-1 ; i--) {
			options[i].parentNode.removeChild(options[i]);
		}
		// 정보관리업무 select box 옵션 추가
		var newOption = document.createElement("OPTION");
		selectBox.appendChild(newOption);

		for(var i=0; i<formXml.length; i++) {
			var formId   = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(formXml[i], 'formId'));
			var formName = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(formXml[i], 'name'));
			newOption = document.createElement("OPTION");
			newOption.value = formId;
			newOption.appendChild(document.createTextNode(formName)); 
			selectBox.appendChild(newOption);
		}
		//필드항목 테이블 초기화
		removeAllRow(1, document.getElementById("formFieldTable"));
		//필터항목 테이블 초기화
		removeAllRow(1, document.getElementById("reportFilterTable"));
		//설정한 항목 테이블 초기화
		removeAllRow(1, document.getElementById("reportContentTable1"));
		removeAllRow(1, document.getElementById("reportContentTable2"));
		removeAllRow(1, document.getElementById("reportContentTable3"));
	}
}

//////////////////////////////////////////테이블설정 시작////////////////////////////////////////////////
//테이블보고서 설정 정보를 바인딩시키는 함수.
var selectedObj;
var selectedFieldId;
var selectedFieldName;
var selectedFieldType;
var selectedFormatType;

var fieldArr = new Array();
var selectDataFieldCnt = 0;
var FormFieldArr = new Array();
function changeForm() {
	var params = new Array(); 
	params.push("method=getFields");
	params.push("formId=" + document.getElementById("formId").value);
	params.push("userId=" + userId);
	params.push("userLanguage=" + defaultLanguage);
	params.push("compId=" + compId);
	params = params.join("&");
	
	request(getPath() + "/services/portal/reportService.jsp", params, changeFormCallBack, null, "", null, "");
	//xmlHTTP("../services/runtime/searchingService.jsp", params, changeFormCallBack);
}

function changeFormCallBack() {
	var xmlDoc = getXmlDOM(getResult());
	var resultXml = SmartXMLUtil.getChildNode(xmlDoc, 'Result');
	if(resultXml.getAttribute('status') == 'OK') {
		//필드항목 테이블 초기화
		removeAllRow(1, document.getElementById("formFieldTable"));
		//필터항목 테이블 초기화
		removeAllRow(1, document.getElementById("reportFilterTable"));
		//설정한 항목 테이블 초기화
		removeAllRow(1, document.getElementById("reportContentTable1"));
		removeAllRow(1, document.getElementById("reportContentTable2"));
		removeAllRow(1, document.getElementById("reportContentTable3"));

		var FormFieldXml = SmartXMLUtil.getChildNodes(resultXml, 'FormField');
		var fieldTable = document.getElementById("formFieldTable");
		//alert('FormFieldXml.length : ' + FormFieldXml.length);
		for(var i=0; i<FormFieldXml.length; i++) {
			var fieldId   = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(FormFieldXml[i], 'id'));
			var fieldName = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(FormFieldXml[i], 'name'));
			var fieldType = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(FormFieldXml[i], 'type'));
//			var systemName = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(FormFieldXml[i], 'systemName'));
			var typeName = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(FormFieldXml[i], 'typeName'));
			var formatType = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(FormFieldXml[i], 'formatType'));
			var fieldTable 		= document.getElementById("formFieldTable");
			FormFieldArr[i] = [fieldId, fieldName, fieldType, typeName, formatType];
			//alert('formatType : ' + formatType)
			if(formatType != "textArea" && formatType != "richEditor" && formatType != "dataGrid") {
				var tr = fieldTable.insertRow(-1);
				tr.id = fieldId + "_fieldTr";
				tr.setAttribute("height", 24);
				tr.style.cursor = "pointer";

				var td1 = document.createElement("td");
				var td2 = document.createElement("td");
				
				td1.setAttribute("bgColor", "#FFFFFF");
				td2.setAttribute("bgColor", "#FFFFFF");
				
				td1.id = fieldId + "_fieldTd1";
				td2.id = fieldId + "_fieldTd2";
				
				tr.fieldId 		= fieldId;
				tr.fieldName 	= fieldName;
				tr.type 		= fieldType;
				tr.formatType 	= formatType;
				tr.onclick = function(){eval("cellClick(this)")};
				
				td1.innerHTML = "&nbsp;"+fieldName+"<input type='hidden' name='fieldId' value='"+fieldId+"'>";
				td2.innerHTML = "&nbsp;"+typeName;

				tr.appendChild(td1);
				tr.appendChild(td2);
				//tr.observe('click', function(){cellClick(this)});
			}
			
		}
		selectedObj = null;
		selectedFieldId = null;
		selectedFieldName = null;
		selectedFieldType = null;
		selectedFormatType = null;
		selectDataFieldCnt = 0;
		fieldArr = new Array();

		//상세필터
		conditionAdd();
	}
}

//보고서 종류를 변경하였을때 처리하는 함수.
function chartTypeChange() {
	//document.reportForm.reportType.value === 'chartType';
	reportTypeChange();
}
function reportTypeChange(){

	var form = document.reportForm;
	var chartType;
	//필드항목 테이블 초기화
	removeAllRow(1, document.getElementById("reportContentTable1"));
	removeAllRow(1, document.getElementById("reportContentTable2"));
	removeAllRow(1, document.getElementById("reportContentTable3"));

	fieldArr = new Array();
	
		
	if (form.reportType.value === 'GRID'){
		chartType = "GRID";
        send("../report/sample/gridSample.jsp?type=GRID","reportSample");
        document.getElementById("fieldAddBtn1").style.display = "";
        document.getElementById("fieldAddBtn2").style.display = "none";
        document.getElementById("fieldAddBtn3").style.display = "none";

        document.getElementById("reportContentTable1").style.display = "";
        document.getElementById("reportContentTable2").style.display = "none";
        document.getElementById("reportContentTable3").style.display = "none";

        document.getElementById("chartTypes").style.display = "none";

	} else if (form.reportType.value === 'MATRIX'){
		chartType = "MATRIX";
        send("../report/sample/chartSample.jsp?type=MATRIX","reportSample");
        document.getElementById("fieldAddBtn1").style.display = "";
        document.getElementById("fieldAddBtn2").style.display = "";
        document.getElementById("fieldAddBtn3").style.display = "";

        document.getElementById("reportContentTable1").style.display = "";
        document.getElementById("reportContentTable2").style.display = "";
        document.getElementById("reportContentTable3").style.display = "";

        document.getElementById("chartTypes").style.display = "none";

	} else if (form.reportType.value === 'chartType'){
		chartType = form.chartTypes.value;
        document.getElementById("fieldAddBtn1").style.display = "";
        document.getElementById("fieldAddBtn2").style.display = "";

        document.getElementById("reportContentTable1").style.display = "";
        document.getElementById("reportContentTable2").style.display = "";

        document.getElementById("chartTypes").style.display = "";

        if(reportForm.chartTypes.value == "COLUMN_CHART"){
            //document.getElementById("fieldAddBtn3").style.display = "";
            document.getElementById("reportContentTable3").style.display = "";
            send("../report/sample/chartSample.jsp?type=COLUMN_CHART","reportSample");
    	} else if(reportForm.chartTypes.value == "BAR_CHART"){
            //document.getElementById("fieldAddBtn3").style.display = "";
            document.getElementById("reportContentTable3").style.display = "";
            send("../report/sample/chartSample.jsp?type=BAR_CHART","reportSample");
    	} else if(reportForm.chartTypes.value == "LINE_CHART"){
            //document.getElementById("fieldAddBtn3").style.display = "";
            document.getElementById("reportContentTable3").style.display = "";
            send("../report/sample/chartSample.jsp?type=LINE_CHART","reportSample");
    	} else if(reportForm.chartTypes.value == "AREA_CHART"){
            //document.getElementById("fieldAddBtn3").style.display = "";
            document.getElementById("reportContentTable3").style.display = "";
            send("../report/sample/chartSample.jsp?type=AREA_CHART","reportSample");
    	} else if(reportForm.chartTypes.value == "PIE_CHART"){
            //document.getElementById("fieldAddBtn3").style.display = "none";
            document.getElementById("reportContentTable3").style.display = "none";
            send("../report/sample/chartSample.jsp?type=PIE_CHART","reportSample");
        }

	}
}

function conditionAdd() {
	if(document.getElementById("formId").value != null && document.getElementById("formId").value != "") {
		var params = new Array(); 
		params.push("method=getFields");
		params.push("formId=" + document.getElementById("formId").value);
		params.push("userId=" + userId);
		params.push("userLanguage=" + defaultLanguage);
		params.push("compId=" + compId);
		params = params.join("&");
		
		request(getPath() + "/services/portal/reportService.jsp", params, conditionAddCallBack, null, "", null, "");
	}
}
function conditionAddCallBack() {
	var xmlDoc = getXmlDOM(getResult());
	var resultXml = SmartXMLUtil.getChildNode(xmlDoc, 'Result');
	if(resultXml.getAttribute('status') == 'OK') {
		
		var lang = document.getElementById("userLanguage").value;
		var imageDir = "";
		if(lang == "KOR") {
			imageDir = "";
		} else {
			imageDir = "ENG/";
		}

		var FormFieldXml = SmartXMLUtil.getChildNodes(resultXml, 'FormField');
		var fieldTable = document.getElementById("formFieldTable");

		//상세필터
		var reportFilterTable = document.getElementById("reportFilterTable");
		var tr = reportFilterTable.insertRow(-1);
		tr.id = selectDataFieldCnt + "_reportFilterTr";
		tr.setAttribute("height", 27);

		var td1 = document.createElement("td");
		var td2 = document.createElement("td");
		var td3 = document.createElement("td");
		var td4 = document.createElement("td");

		td1.setAttribute("bgColor", "#FFFFFF");
		td2.setAttribute("bgColor", "#FFFFFF");
		td3.setAttribute("bgColor", "#FFFFFF");
		td4.setAttribute("bgColor", "#FFFFFF");

		td1.align = "center";
		td2.align = "center";
		td3.align = "center";
		td4.align = "center";

		td1.id = selectDataFieldCnt + "_reportFieldTd1";
		td2.id = selectDataFieldCnt + "_reportFieldTd2";
		td3.id = selectDataFieldCnt + "_reportFieldTd3";
		td4.id = selectDataFieldCnt + "_reportFieldTd4";

		var newSelect = document.createElement('select');
		newSelect.style.width = "150";

		newSelect.id = "filterSelect";//dataFilterField
		newSelect.name = "filterSelect";
		newSelect.filterCnt = selectDataFieldCnt;
		newSelect.onchange = function(){ filterDateFieldChange(this); };
		td1.appendChild(newSelect);

		var newOption = document.createElement('option');
		newOption.value = "";
		newOption.appendChild(document.createTextNode(""));
		newSelect.appendChild(newOption);
		
		for(var i=0; i<FormFieldXml.length; i++) {
			var fieldId   = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(FormFieldXml[i], 'id'));
			var fieldName = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(FormFieldXml[i], 'name'));
			var fieldType = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(FormFieldXml[i], 'type'));
//			var systemName = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(FormFieldXml[i], 'systemName'));
			var typeName = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(FormFieldXml[i], 'typeName'));
			var formatType = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(FormFieldXml[i], 'formatType'));

			newOption = document.createElement('option');
			newOption.value = fieldId+"$"+fieldType;
			newOption.appendChild(document.createTextNode(fieldName));
			newSelect.appendChild(newOption);
		}
		td2.innerHTML = "<select id='operator' name='operator' style='width:150px'><option value=''></option></select>";
		td3.innerHTML = "<input type='text' name='filterSearchWord' value='' style='width:140px'>";
		td4.innerHTML = "<img src='../images/"+imageDir+"bt_delete.gif' onclick='removeFilter(this)' style='margin-bottom: 0px;cursor: pointer'>";
		
		tr.appendChild(td1);
		tr.appendChild(td2);
		tr.appendChild(td3);
		tr.appendChild(td4);
		selectDataFieldCnt = selectDataFieldCnt+1;
	}
}

function filterDateFieldChange(obj) {
	//var dataField = document.getElementById("dataField_"+obj.filterCnt);
	var filterCnt = obj.filterCnt;

	var operator = document.getElementById(filterCnt + "_reportFieldTd2");
	var filterValue = document.getElementById(filterCnt + "_reportFieldTd3");
	

	var filterSearchKey = "";
	var filterSearchWord = "";

	var dataFieldValue = obj.value;//8$string$c8

	var a = dataFieldValue.indexOf('$',0);
	var selectLength = dataFieldValue.length;
	var fieldId = dataFieldValue.substring(0, a);
	var type = dataFieldValue.substring(a+1, selectLength);

	var typeLength = type.length;
	var typeIndex = type.indexOf('$', 0);
	selectName = type.substring(typeIndex+1, typeLength);
//	var type = type.substring(0, typeIndex);
	if(defaultLanguage == 'KOR') {
		if(selectName == "creator" || selectName == "modifier") {
//			filterSearchKey = "<select name='operator' style='width:150px'><option></option><option value='='>같음</option><option value='!='>같지 않음</option></select>";
//			filterSearchWord = "<input type='hidden' name='filterSearchUser'><input name='filterSearchWord' type='text' value='' style='width:118px;height:21px;' onclick='searchUserFilter(this);' readOnly><img src='../image/form/user.gif' border='0'onclick='searchUserFilter(this);' style='cursor: pointer;vertical-align:top;margin:3px;'>";
		} else {
			if(type == "string") {
				filterSearchKey = "<select name='operator' id='operator' style='width:150px'><option></option><option value='='>같음</option><option value='!='>같지 않음</option><option value='like'>포함</option></select>";
				filterSearchWord = "<input type='hidden' name='filterSearchUser'><input name='filterSearchWord' type='text' value='' style='width:140px;height:21px;'/>";
			} else if(type == "datetime") {
				filterSearchKey = "<select name='operator' id='operator' style='width:150px'><option></option><option value='datein'>같음</option><option value='datenotin'>같지 않음</option><option value='<'>미만</option><option value='>'>초과</option><option value='<='>이하</option><option value='>='>이상</option></select>";
				filterSearchWord = "<input name='filterSearchWord' value='' style='width:118px;height:21px;' maxLength='10' onclick='popupSelectDateModalDialog(this);'><input type='hidden' name='filterSearchUser'><img src='../images/icon/dateChooser.gif' border='0' onclick='searchDateFilter(this);' style='cursor: pointer;vertical-align:top;margin:3px;'>";
			} else if(type == "time") {
				filterSearchKey = "<select name='operator' id='operator' style='width:150px'><option></option><option value='datein'>같음</option><option value='datenotin'>같지 않음</option><option value='<'>미만</option><option value='>'>초과</option><option value='<='>이하</option><option value='>='>이상</option></select>";
				filterSearchWord = "<input type='hidden' name='filterSearchUser'><select name='filterSearchWord' id='filterSearchWord' style='width:140px'>"
				+ "<option value='00:00'>AM 00:00</option>"
				+ "<option value='00:30'>AM 00:30</option>"
				+ "<option value='01:00'>AM 01:00</option>"
				+ "<option value='01:30'>AM 01:30</option>"
				+ "<option value='02:00'>AM 02:00</option>"
				+ "<option value='02:30'>AM 02:30</option>"
				+ "<option value='03:00'>AM 03:00</option>"
				+ "<option value='03:30'>AM 03:30</option>"
				+ "<option value='04:00'>AM 04:00</option>"
				+ "<option value='04:30'>AM 04:30</option>"
				+ "<option value='05:00'>AM 05:00</option>"
				+ "<option value='05:30'>AM 05:30</option>"
				+ "<option value='06:00'>AM 06:00</option>"
				+ "<option value='06:30'>AM 06:30</option>"
				+ "<option value='07:00'>AM 07:00</option>"
				+ "<option value='07:30'>AM 07:30</option>"
				+ "<option value='08:00'>AM 08:00</option>"
				+ "<option value='08:30'>AM 08:30</option>"
				+ "<option value='09:00'>AM 09:00</option>"
				+ "<option value='09:30'>AM 09:30</option>"
				+ "<option value='10:00'>AM 10:00</option>"
				+ "<option value='10:30'>AM 10:30</option>"
				+ "<option value='11:00'>AM 11:00</option>"
				+ "<option value='11:30'>AM 11:30</option>"
				+ "<option value='12:00'>PM 12:00</option>"
				+ "<option value='12:30'>PM 12:30</option>"
				+ "<option value='13:00'>PM 01:00</option>"
				+ "<option value='13:30'>PM 01:30</option>"
				+ "<option value='14:00'>PM 02:00</option>"
				+ "<option value='14:30'>PM 02:30</option>"
				+ "<option value='15:00'>PM 03:00</option>"
				+ "<option value='15:30'>PM 03:30</option>"
				+ "<option value='16:00'>PM 04:00</option>"
				+ "<option value='16:30'>PM 04:30</option>"
				+ "<option value='17:00'>PM 05:00</option>"
				+ "<option value='17:30'>PM 05:30</option>"
				+ "<option value='18:00'>PM 06:00</option>"
				+ "<option value='18:30'>PM 06:30</option>"
				+ "<option value='19:00'>PM 07:00</option>"
				+ "<option value='19:30'>PM 07:30</option>"
				+ "<option value='20:00'>PM 08:00</option>"
				+ "<option value='20:30'>PM 08:30</option>"
				+ "<option value='21:00'>PM 09:00</option>"
				+ "<option value='21:30'>PM 09:30</option>"
				+ "<option value='22:00'>PM 10:00</option>"
				+ "<option value='22:30'>PM 10:30</option>"
				+ "<option value='23:00'>PM 11:00</option>"
				+ "<option value='23:30'>PM 11:30</option>"
				+ "</select>";
			} else if(type == "number") {
				filterSearchKey = "<select name='operator' id='operator' style='width:150px'><option></option><option value='='>같음</option><option value='!='>같지 않음</option><option value='<'>미만</option><option value='>'>초과</option><option value='<='>이하</option><option value='>='>이상</option></select>";
				filterSearchWord = "<input type='hidden' name='filterSearchUser'><input name='filterSearchWord' type='text' value='' style='width:140px;height:21px;' onblur='checknumber(this)' />";
			} else {
				filterSearchKey = "<select name='operator' id='operator' style='width:150px'><option></option><option value='='>같음</option><option value='!='>같지 않음</option><option value='like'>포함</option></select>";
				filterSearchWord = "<input type='hidden' name='filterSearchUser'><input name='filterSearchWord' type='text' value='' style='width:140px;height:21px;'/>";
			}
		}
	} else {
		if(selectName == "creator" || selectName == "modifier") {
//			filterSearchKey = "<select name='filterSearchKey' style='width:150px'><option></option><option value='='>Equal</option><option value='!='>Not Equal</option></select>";
//			filterSearchWord = "<input type='hidden' name='filterSearchUser'><input name='filterSearchWord' type='text' value='' style='width:118px' onclick='searchUserFilter(this);' readOnly><img src='../image/form/user.gif' border='0' onclick='searchUserFilter(this);' style='cursor: pointer;vertical-align:top;margin:3px;'>";
		} else {
			if(type == "string") {
				filterSearchKey = "<select name='operator' id='operator' style='width:150px'><option></option><option value='='>Equal</option><option value='!='>Not Equal</option><option value='like'>Including</option></select>";
				filterSearchWord = "<input type='hidden' name='filterSearchUser'><input name='filterSearchWord' type='text' value='' style='width:140px;height:21px;'/>";
			} else if(type == "datetime") {
				filterSearchKey = "<select name='operator' id='operator' style='width:150px'><option></option><option value='datein'>Equal</option><option value='datenotin'>Not Equal</option><option value='<'>Less than</option><option value='>'>Excess</option><option value='<='>Below</option><option value='>='>More than</option></select>";
				filterSearchWord = "<input name='filterSearchWord' value='' style='width:118px;height:21px;' maxLength='10' onclick='popupSelectDateModalDialog(this);'><input type='hidden' name='filterSearchUser'><img src='../images/icon/dateChooser.gif' border='0' onclick='searchDateFilter(this);' style='cursor: pointer;vertical-align:top;margin:3px;'>";
			} else if(type == "time") {
				filterSearchKey = "<select name='operator' id='operator' style='width:150px'><option></option><option value='datein'>Equal</option><option value='datenotin'>Not Equal</option><option value='<'>Less than</option><option value='>'>Excess</option><option value='<='>Below</option><option value='>='>More than</option></select>";
				filterSearchWord = "<input type='hidden' name='filterSearchUser'><select name='filterSearchWord' id='filterSearchWord' style='width:140px'>"
					+ "<option value='00:00'>AM 00:00</option>"
					+ "<option value='00:30'>AM 00:30</option>"
					+ "<option value='01:00'>AM 01:00</option>"
					+ "<option value='01:30'>AM 01:30</option>"
					+ "<option value='02:00'>AM 02:00</option>"
					+ "<option value='02:30'>AM 02:30</option>"
					+ "<option value='03:00'>AM 03:00</option>"
					+ "<option value='03:30'>AM 03:30</option>"
					+ "<option value='04:00'>AM 04:00</option>"
					+ "<option value='04:30'>AM 04:30</option>"
					+ "<option value='05:00'>AM 05:00</option>"
					+ "<option value='05:30'>AM 05:30</option>"
					+ "<option value='06:00'>AM 06:00</option>"
					+ "<option value='06:30'>AM 06:30</option>"
					+ "<option value='07:00'>AM 07:00</option>"
					+ "<option value='07:30'>AM 07:30</option>"
					+ "<option value='08:00'>AM 08:00</option>"
					+ "<option value='08:30'>AM 08:30</option>"
					+ "<option value='09:00'>AM 09:00</option>"
					+ "<option value='09:30'>AM 09:30</option>"
					+ "<option value='10:00'>AM 10:00</option>"
					+ "<option value='10:30'>AM 10:30</option>"
					+ "<option value='11:00'>AM 11:00</option>"
					+ "<option value='11:30'>AM 11:30</option>"
					+ "<option value='12:00'>PM 12:00</option>"
					+ "<option value='12:30'>PM 12:30</option>"
					+ "<option value='13:00'>PM 01:00</option>"
					+ "<option value='13:30'>PM 01:30</option>"
					+ "<option value='14:00'>PM 02:00</option>"
					+ "<option value='14:30'>PM 02:30</option>"
					+ "<option value='15:00'>PM 03:00</option>"
					+ "<option value='15:30'>PM 03:30</option>"
					+ "<option value='16:00'>PM 04:00</option>"
					+ "<option value='16:30'>PM 04:30</option>"
					+ "<option value='17:00'>PM 05:00</option>"
					+ "<option value='17:30'>PM 05:30</option>"
					+ "<option value='18:00'>PM 06:00</option>"
					+ "<option value='18:30'>PM 06:30</option>"
					+ "<option value='19:00'>PM 07:00</option>"
					+ "<option value='19:30'>PM 07:30</option>"
					+ "<option value='20:00'>PM 08:00</option>"
					+ "<option value='20:30'>PM 08:30</option>"
					+ "<option value='21:00'>PM 09:00</option>"
					+ "<option value='21:30'>PM 09:30</option>"
					+ "<option value='22:00'>PM 10:00</option>"
					+ "<option value='22:30'>PM 10:30</option>"
					+ "<option value='23:00'>PM 11:00</option>"
					+ "<option value='23:30'>PM 11:30</option>"
					+ "</select>";
			} else if(type == "number") {
				filterSearchKey = "<select name='operator' id='operator' style='width:150px'><option></option><option value='='>Equal</option><option value='!='>Not Equal</option><option value='<'>Less than</option><option value='>'>Excess</option><option value='<='>Below</option><option value='>='>More than</option></select>";
				filterSearchWord = "<input type='hidden' name='filterSearchUser'><input name='filterSearchWord' type='text' value='' style='width:140px;height:21px;' onblur='checknumber(this)' />";
			} else {
				filterSearchKey = "<select name='operator' id='operator' style='width:150px'><option></option><option value='='>Equal</option><option value='!='>Not Equal</option><option value='like'>Including</option></select>";
				filterSearchWord = "<input type='hidden' name='filterSearchUser'><input name='filterSearchWord' type='text' value='' style='width:140px;height:21px;'/>";
			}
		}
	}
	operator.innerHTML = filterSearchKey;
	filterValue.innerHTML = filterSearchWord;
}

function cellClick(fieldObj) {
	selectedFieldId = fieldObj.fieldId;
	selectedFieldName = fieldObj.fieldName;
	selectedFieldType = fieldObj.type;
	selectedFormatType = fieldObj.formatType;

	var fieldObjId = fieldObj.id;
	if (selectedObj != null && selectedObj != fieldObj) {
		selectedObj.style.fontWeight  = "";
	}
	selectedObj = fieldObj;
	selectedObj.style.fontWeight  = "bold";
}

// 보고서 항목 추가
function reportFieldAdd(cnt) {
	var form = document.reportForm;
	if(selectedFieldId != null && selectedFieldId != "") {
		var addYn = false;
		for(var i=0; i<fieldArr.length; i++) {
			if(selectedFieldId == fieldArr[i][0] && cnt == fieldArr[i][1]) {
				addYn = true;
				break;
			}
		}
		if(addYn == false) {
			
			var lang = document.getElementById("userLanguage").value;
			var imageDir = "";
			if(lang == "KOR") {
				imageDir = "";
			} else {
				imageDir = "ENG/";
			}
			
			var chartType;
			var valueSelect = "";
			if (form.reportType.value === 'GRID'){
				chartType = "GRID";
		    } else if (form.reportType.value === 'MATRIX') {
		    	chartType = "MATRIX";
			    if(cnt ==3) {
			    	valueSelect = "<select name='functionType3' id='functionType3'>";
			    	if(selectedFormatType == "numberInput" || selectedFormatType == "currencyInput" || selectedFormatType == "percentInput") {
			    		if(defaultLanguage == "KOR") {
				    		valueSelect = valueSelect + "<option value='count'>갯수</option>";
				    		valueSelect = valueSelect + "<option value='sum'>합</option>";
				    		valueSelect = valueSelect + "<option value='max'>최대값</option>";
				    		valueSelect = valueSelect + "<option value='min'>최소값</option>";
				    		valueSelect = valueSelect + "<option value='avg'>평균</option>";
			    		} else {
				    		valueSelect = valueSelect + "<option value='count'>Count</option>";
				    		valueSelect = valueSelect + "<option value='sum'>Sum</option>";
				    		valueSelect = valueSelect + "<option value='max'>Maximum</option>";
				    		valueSelect = valueSelect + "<option value='min'>Minimum</option>";
				    		valueSelect = valueSelect + "<option value='avg'>Average</option>";
			    		}
			    	} else {
			    		if(defaultLanguage == "KOR") {
				    		valueSelect = valueSelect + "<option value='count'>갯수</option>";
			    		} else {
				    		valueSelect = valueSelect + "<option value='count'>Count</option>";
			    		}
			    	}
			    	valueSelect = valueSelect + "</select>";
		    	}
		    } else if (form.reportType.value === 'chartType'){
		    	chartType = form.chartTypes.value;
			    if(cnt ==1) {
			    	valueSelect = "<select name='functionType1' id='functionType1'>";
			    	if(selectedFormatType == "numberInput" || selectedFormatType == "currencyInput" || selectedFormatType == "percentInput") {
			    		if(defaultLanguage == "KOR") {
				    		valueSelect = valueSelect + "<option value='count'>갯수</option>";
				    		valueSelect = valueSelect + "<option value='sum'>합</option>";
				    		valueSelect = valueSelect + "<option value='max'>최대값</option>";
				    		valueSelect = valueSelect + "<option value='min'>최소값</option>";
				    		valueSelect = valueSelect + "<option value='avg'>평균</option>";
			    		} else {
				    		valueSelect = valueSelect + "<option value='count'>Count</option>";
				    		valueSelect = valueSelect + "<option value='sum'>Sum</option>";
				    		valueSelect = valueSelect + "<option value='max'>Maximum</option>";
				    		valueSelect = valueSelect + "<option value='min'>Minimum</option>";
				    		valueSelect = valueSelect + "<option value='avg'>Average</option>";
			    		}
			    	} else {
			    		if(defaultLanguage == "KOR") {
				    		valueSelect = valueSelect + "<option value='count'>갯수</option>";
			    		} else {
				    		valueSelect = valueSelect + "<option value='count'>Count</option>";
			    		}
			    	}
			    	valueSelect = valueSelect + "</select>";
		    	}
		    }
			//차트일 경우 3번 항목이 1개만 되도록 기존에 추가된 것은 삭제
			if (form.reportType.value === 'chartType') {
				removeAllRow(1, document.getElementById("reportContentTable"+cnt));
			}
			var reportContentTable = document.getElementById("reportContentTable"+cnt);

			var tr = reportContentTable.insertRow(-1);
			tr.id = selectedFieldId + "_reportFieldTr_" + cnt;
			tr.setAttribute("height", 24);

			var td1 = document.createElement("td");
			var td2 = document.createElement("td");
			var td3 = document.createElement("td");

			td1.setAttribute("bgColor", "#FFFFFF");
			td1.setAttribute("colSpan", 2);
			td2.setAttribute("bgColor", "#FFFFFF");
			td2.align = "center";
			td3.setAttribute("bgColor", "#FFFFFF");
			td3.align = "center";

			td1.id = selectedFieldId + "_reportFieldTd1";
			td2.id = selectedFieldId + "_reportFieldTd2";
			var td1Text = "&nbsp;"+selectedFieldName+"&nbsp;&nbsp;&nbsp;"+valueSelect;
		    td1Text = td1Text + "<input type='hidden' name='fieldId"+cnt+"' value='"+selectedFieldId+"'>";
		    td1Text = td1Text + "<input type='hidden' name='fieldName"+cnt+"' value='"+selectedFieldName+"'>";
		    td1Text = td1Text + "<input type='hidden' name='fieldType"+cnt+"' value='"+selectedFieldType+"'>";
		    td1Text = td1Text + "<input type='hidden' name='fieldFormatType"+cnt+"' value='"+selectedFormatType+"'>";

		    td1.innerHTML = td1Text
			td2.innerHTML = "<img src='../images/"+imageDir+"bt_delete.gif' onclick='reportFieldDel(\""+selectedFieldId+"\", \""+cnt+"\")' style='margin-bottom: 0px;'>";
		    td3.innerHTML = "<img src='../images/common/bt_1up.gif' onclick='reportItemMove(this, \""+cnt+"\", \"UP\");' style='cursor: pointer;'>&nbsp;&nbsp;&nbsp;<img src='../images/common/bt_1dn.gif' onclick='reportItemMove(this, \""+cnt+"\", \"DOWN\");' style='cursor: pointer;'>";

			tr.appendChild(td1);
			tr.appendChild(td2);
			tr.appendChild(td3);

			fieldArr[i] = [selectedFieldId, cnt];
		}
	}
}

function reportFieldDel(fieldId, cnt) {
	//document.getElementById(fieldId+"_reportFieldTr_" + cnt).removeNode(true);
	var tagetObj = document.getElementById(fieldId+"_reportFieldTr_" + cnt);
	tagetObj.parentNode.removeChild(tagetObj);
	var fieldCnt = null;
	for(var i=0; i<fieldArr.length; i++) {
		if(fieldId == fieldArr[i][0] && cnt == fieldArr[i][1]) {
			fieldCnt = i;
			break;
		}
	}
	fieldArr.remove(fieldCnt);
}

/*
	새로 만들기 : createReport()
*/
function createReport(params) {
	update("../report/reportInsert.jsp", "mainTd", params, null, "loading", "failed");
}

/*
	보고서 조회: viewReport()
*/
function viewReport(obj) {
	var reportId;
	if(typeof obj == "object") {
		reportId = obj.id;
	} else {
		reportId = obj;
	}

	var v_filterSelect = "";
	var v_filterSearchKey = "";
	var v_filterSearchWord = "";
	var v_filterSearchUser = "";

	var filterSelect  		= document.getElementsByName("filterSelect");
	var filterSearchKey  	= document.getElementsByName("filterSearchKey");
	var filterSearchWord  	= document.getElementsByName("filterSearchWord");
	var filterSearchUser = document.getElementsByName("filterSearchUser");

	for ( var i = 0 ; i < filterSearchWord.length; i++ ) {
		if(filterSelect[i].value != "" && filterSearchKey[i].value != "" && filterSearchWord[i].value != "" ) {
			v_filterSelect = v_filterSelect + filterSelect[i].value+";";
			v_filterSearchKey = v_filterSearchKey + filterSearchKey[i].value+";";
			v_filterSearchWord = v_filterSearchWord + filterSearchWord[i].value+";";

			if(filterSelect[i].value == "creationUser" && filterSearchUser[i].value != ""){
				v_filterSearchUser = v_filterSearchUser + filterSearchUser[i].value+";";
			}else{
				v_filterSearchUser 	= v_filterSearchUser + "EMPTYVALUE;";
			}
		}
	}
	
	var isAsc = "";
	var order = "";
	var pageNo = "";
	var pageSize = "";
	var searchWord = "";

	if($('isAsc'))
		isAsc = $F('isAsc');
	if($('order'))
		order = $F('order');
	if($('pageNo'))
		pageNo = $F('pageNo');
	if($('pageSize'))
		pageSize = $F('pageSize');
	if($('searchWord'))
		searchWord = $F('searchWord');
	
	var params = new Array(); 
	params.push("filterSelect=" + v_filterSelect);
	params.push("filterSearchKey=" + v_filterSearchKey);
	params.push("filterSearchWord=" + v_filterSearchWord);
	params.push("filterSearchUser=" + v_filterSearchUser);
	params.push("isAsc=" + isAsc);
	params.push("order=" + order);
	params.push("pageNo=" + pageNo);
	params.push("pageSize=" + pageSize);
	params.push("searchWord=" + searchWord);
	params.push("userId=" + userId);
	params.push("reportId=" + reportId);
	params = params.join("&");
	update("../report/reportView.jsp", "mainTd", params, viewReportCallBack, "loading", "failed");
}
function viewReportCallBack() {
	var reportId = $('reportId').getValue();
	var gadgetType = $('gadgetType').getValue();
	var formId = $('formId').getValue();
	var chartDisplayArea = $('chartDisplayArea');
	if(gadgetType == "GRID") {
		send("../report/reportGrid.jsp", "chartDisplayArea", "formId="+formId+"&reportId="+reportId+"&targetTd=chartDisplayArea");
	} else {
		chartDisplayArea.innerHTML = "<iframe id='chartIframe' width='716' height='500' frameborder='0' marginheight='0' marginwidth='0' scrolling='no' src='../report/reportChart.jsp?userId="+userId+"&reportId="+reportId+"&language="+defaultLanguage+"'></iframe>";
	}
}
/*
	보고서 저장 : reportSave(), reportSaveCallBack()
*/
function reportSave(nextPage) {
	document.reportForm.nextPage.value=nextPage;
	if(document.getElementById("formId").value == null || document.getElementById("formId").value == "") {
		warnMessage('Youdidnotentertherequireditems', 'errorCodeNullContent');
	} else if(document.reportForm.reportName.value == null || document.reportForm.reportName.value == ""){
		warnMessage('Youdidnotentertherequireditems', 'errorCodeNullContent');
	} else if(document.reportForm.categoryId.value == null || document.reportForm.categoryId.value == ""){
		warnMessage('Youdidnotentertherequireditems', 'errorCodeNullContent');
	} else {
		var chartXml = "";
		var categoryId 	= document.getElementById("categoryId").value;
		var formId 		= document.getElementById("formId").value;
		var groupId 	= document.getElementById("groupId").value;
		var refFormId 	= "";
		var reportName	= document.getElementById("reportName").value;

		var remarkId 	= "";
		var remarkName 	= "";

		var valueInfoId   = "";
		var valueInfoName = "";
		var valueInfoUnit = "";
		var valueInfoType = "";
		var functionType  = "";
		var groupInfoId	  = "";
		var groupInfoName = "";

		var columnIds   = "";
		var columnNames = "";

		var XFieldIds 	= "";
		var XFieldNames = "";
		var YFieldIds 	= "";
		var YFieldNames = "";
		
		var measure_id 			 = "";
		var measure_name 		 = "";
		var measure_functionType = "";
		var measure_minValue  	 = "";
		var measure_maxValue 	 = "";
		var measure_unit 		 = "";

		var chartType;
		if (document.reportForm.reportType.value === 'GRID'){
			chartType = "GRID";
			columnIds 	= document.getElementsByName("fieldId1");
			columnNames = document.getElementsByName("fieldName1");
			
			if (columnIds.length <= 0) { 
				warnMessage('Youdidnotentertherequireditems', 'errorCodeNullContent');
				return;
			}

	    } else if (document.reportForm.reportType.value === 'MATRIX'){
	    	chartType = "MATRIX";
	    	if(document.reportForm.fieldId2 != null) {
	    		groupInfoId 	= document.reportForm.fieldId2.value;
	    	}
	    	if(document.reportForm.fieldName2 != null) {
	    		groupInfoName 	= document.reportForm.fieldName2.value;
	    	}

	    	XFieldIds 	= document.getElementsByName("fieldId1");
	    	XFieldNames = document.getElementsByName("fieldName1");
	    	YFieldIds 	= document.getElementsByName("fieldId2");
	    	YFieldNames = document.getElementsByName("fieldName2");
    	
	    	measure_id 			 = document.getElementsByName("fieldId3");
	    	measure_name 		 = document.getElementsByName("fieldName3");
	    	measure_functionType = document.getElementsByName("functionType3");
	    	measure_unit 		 = document.getElementsByName("fieldFormatType3");
	    	
	    	if (XFieldIds.length <= 0 || YFieldIds.length <=0 || measure_id.length <= 0) { 
				warnMessage('Youdidnotentertherequireditems', 'errorCodeNullContent');
				return;
			}
	    	
	    } else if (document.reportForm.reportType.value === 'chartType') {
	    	chartType 	= document.reportForm.chartTypes.value;

	    	if(document.reportForm.fieldId1 != null) {
	    		valueInfoId 	= document.reportForm.fieldId1.value;
	    	}
	    	if(document.reportForm.fieldName1 != null) {
	    		valueInfoName 	= document.reportForm.fieldName1.value;
	    	}
	    	if(document.reportForm.fieldFormatType1 != null) {
	    		valueInfoUnit 	= document.reportForm.fieldFormatType1.value;
	    	}	    	
	    	if(document.reportForm.fieldType1 != null) {
	    		valueInfoType 	= document.reportForm.fieldType1.value;
	    	}
	    	if(document.reportForm.functionType1 != null) {
	    		functionType 	= document.reportForm.functionType1.value;
	    	}
	    	
	    	if(document.reportForm.fieldId2 != null) {
	    		groupInfoId 	= document.reportForm.fieldId2.value;
	    	}
	    	if(document.reportForm.fieldName2 != null) {
	    		groupInfoName 	= document.reportForm.fieldName2.value;
	    	}

	    	if(document.reportForm.fieldId3 != null) {
	    		remarkId 	= document.reportForm.fieldId3.value;
	    	}
	    	if(document.reportForm.fieldName3 != null) {
	    		remarkName 	= document.reportForm.fieldName3.value;
	    	}
	    	if (valueInfoId === "" ||  groupInfoId === "") { 
				warnMessage('Youdidnotentertherequireditems', 'errorCodeNullContent');
				return;
			}
	    	
	    }

		if(chartType == null || chartType == ""){
			return;
		}

		var coditionColumnId 	= document.getElementsByName("filterSelect");
		var conditionColumnName = "";//document.getElementsByName("dataFieldName");
		var conditionValue 		= document.getElementsByName("filterSearchWord");
		var comparison 			= document.getElementsByName("operator");

		var chartXml="";
		var returnData="";
		var saveMeasureCount = 0;
		var saveXAxisCount = 0;
		var saveYAxisCount = 0;

		chartXml = '<Gadget formId="'+formId+'" type="'+chartType+'" categoryId="'+categoryId+'" refFormId="'+refFormId+'">' + '\n';
		chartXml += '	<name>'+startCdataTag() + reportName+endCdataTag() + '</name>' + '\n';
		chartXml += '	<remark id="'+remarkId+'">' + '\n';
		chartXml += '		<name>'+startCdataTag() + remarkName + endCdataTag()+'</name>' + '\n';
		chartXml += '	</remark>' + '\n';

		chartXml += '	<valueInfo id="'+valueInfoId+'">' + '\n';
		chartXml += '		<name>'+startCdataTag() + valueInfoName +endCdataTag()+'</name>' + '\n';
		chartXml += '		<unit>'+startCdataTag() + valueInfoUnit + endCdataTag()+'</unit>' + '\n';
		chartXml += '		<dataType>'+startCdataTag()+  valueInfoType + endCdataTag()+'</dataType>' + '\n';
		chartXml += '		<filter functionType="'+ functionType +'" minValue="" maxValue=""/>' + '\n';
		chartXml += '	</valueInfo>' + '\n';

		chartXml += '	<groupInfo id="'+ groupInfoId +'">' + '\n';
		chartXml += '		<name>'+startCdataTag() + groupInfoName + endCdataTag() +'</name>' + '\n';
		chartXml += '		<filter inclusion="">' + '\n';
		chartXml += '			<elements></elements>' + '\n';
		chartXml += '		</filter>' + '\n';
		chartXml += '	</groupInfo>' + '\n';

		chartXml += '	<columns>' + '\n';
		for(var k=0; k<columnIds.length; k++){
			chartXml += '		<column id="' + columnIds[k].value + '">' + '\n';
			chartXml += '			<name>'+startCdataTag() + columnNames[k].value + endCdataTag()+'</name>' + '\n';
			chartXml += '		</column>' + '\n';
		}
		chartXml += '	</columns>' + '\n';

		//매트릭스 X축
		chartXml += '	<xAxisInfo>' + '\n';
		for(var k=0; k<XFieldIds.length; k++){
			if(XFieldIds[k].value!=null && XFieldIds[k].value!="" && XFieldIds[k].value!="null"){
				chartXml += '<axis id="' + XFieldIds[k].value + '">';
				chartXml +=		'<name>' + startCdataTag() + XFieldNames[k].value + endCdataTag() + '</name>';
				chartXml +=		'<filter inclusion="">';
				chartXml +=			'<elements></elements>';
				chartXml +=		'</filter>';
				chartXml += '</axis>';
				saveXAxisCount++;
			}
		}
		chartXml += '	</xAxisInfo>' + '\n';

		//매트릭스 Y축
		chartXml += '	<yAxisInfo>' + '\n';
		for(var s=0; s<YFieldIds.length; s++){
			if(YFieldIds[s].value!=null && YFieldIds[s].value!="" && YFieldIds[s].value!="null"){
				chartXml += '<axis id="' + YFieldIds[s].value + '">';
				chartXml +=		'<name>' + startCdataTag() + YFieldNames[s].value + endCdataTag() + '</name>';
				chartXml +=		'<filter inclusion="">';
				chartXml +=			'<elements></elements>';
				chartXml +=		'</filter>';
				chartXml += '</axis>';
				saveYAxisCount++;
			}
		}
		chartXml += '	</yAxisInfo>' + '\n';

		//매트릭스 measure
		chartXml += '	<measureInfo>' + '\n';
		for(var j=0; j<measure_id.length; j++){
			if(measure_id[j].value!=null && measure_id[j].value!="" && measure_id[j].value!="null"){
				chartXml += '<measure id="' + measure_id[j].value + '">';
				chartXml +=		'<name>' + startCdataTag()+measure_name[j].value+endCdataTag() + '</name>';
				chartXml +=		'<filter functionType="' + measure_functionType[j].value + '" minValue=""  maxValue="" />';
				chartXml +=		'<unit>' + startCdataTag()+measure_unit[j].value+endCdataTag() + '</unit>';
				chartXml += '</measure>';
				saveMeasureCount++;
			}
		}
		if(saveMeasureCount==1 && saveXAxisCount!=0 && saveYAxisCount!=0){
			chartXml += '	<measureCheck>'+startCdataTag()+'N'+endCdataTag()+'</measureCheck>' + '\n';
		} else {
			if(saveXAxisCount==0 || saveYAxisCount==0){
				if(saveXAxisCount==0)
					chartXml += '	<measureCheck>'+startCdataTag()+'C'+endCdataTag()+'</measureCheck>' + '\n';
				else
					chartXml += '	<measureCheck>'+startCdataTag()+'R'+endCdataTag()+'</measureCheck>' + '\n';
			}else{
				chartXml += '	<measureCheck>'+startCdataTag() + 'C' + endCdataTag()+'</measureCheck>' + '\n';
			}
		}
		chartXml += '	</measureInfo>' + '\n';

		//상세 필터
		chartXml += '	<conditions>' + '\n';
		for(var i=0; i<coditionColumnId.length; i++){

			var a = coditionColumnId[i].value.indexOf('$',0);
			var selectLength = coditionColumnId[i].value.length;
			var columnId = coditionColumnId[i].value.substring(0, a);
			var type = coditionColumnId[i].value.substring(a+1, selectLength);

			var typeLength = type.length;
			var typeIndex = type.indexOf('$',0);
			var columnName = type.substring(typeIndex+1, typeLength);
			type = type.substring(0, typeIndex);
			if(columnId != "" && conditionValue[i].value != "" && comparison[i].value != "") {
				chartXml += '		<condition name="condition_' + i +'">' + '\n';
				chartXml += '			<columnId>'+ startCdataTag() + columnId + endCdataTag() +'</columnId>' + '\n';
				chartXml += '			<columnName>'+columnName+'</columnName>' + '\n';
				chartXml += '			<columnType>'+type+'</columnType>' + '\n';
				chartXml += '			<conditionValue>'+conditionValue[i].value+'</conditionValue>' + '\n';
				chartXml += '			<comparison>'+startCdataTag()+comparison[i].value+endCdataTag()+'</comparison>' + '\n';
				chartXml += '		</condition>' + '\n';
			}
		}
		chartXml += '		<conditionsRelation>AND</conditionsRelation>' + '\n';
		chartXml += '	</conditions>' + '\n';
		chartXml += '</Gadget>';
		var reportId = "";
		if($('reportId'))
			reportId = $F('reportId')
		var params = new Array(); 
		params.push("method=setReport");
		params.push("reportId="+reportId);
		params.push("userId="+userId);
		params.push("reportName="+reportName);
		params.push("reportType="+chartType);
		params.push("formId="+formId);
		params.push("content="+chartXml);
		params.push("compId="+compId);
		params.push("DashBoardType="+DashBoardType);
		params = params.join("&");
		
		request(getPath() + "/services/portal/reportService.jsp" , params , reportSaveCallBack, null , 'notifySaveProgress' , null , 'warnSaveFailed');
	}
}
function reportSaveCallBack() {
    var response = getXmlDOM(getResult());
    var result = SmartXMLUtil.getChildNode(response, 'Result');
    if(result.getAttribute('status') == 'OK') {
    	notifyMessageResult();
    	//jk yoon 수정
    	var formName = $('formName').getValue();
    	
    	var fArray = formName.split(",");
    	
    	/* 넘어온 값. 연락처가 아닌경우 
    	 * 	fName = "frm";
			fName += ","+catId;
			fName += ","+id;
    	 * */
    	
    	if(formName === '연락처'){
    		hdTabControll(4);
    		clickWorkDef("40288afb1b25f00b011b25f3c7950001",null,"frm_contact_SYSTEM","SINGLE");
    	}else if(fArray[0]==='frm'){
    		clickWorkDef(fArray[1],null,fArray[2],"SINGLE");
    	}
    	/*
    	var nextPage = $('nextPage').getValue();
    	var gadgetId = result.getAttribute('gadgetId');
    	
    	if(nextPage == "VIEW") {
    		update("../report/reportView.jsp", "mainTd", $F('searchParams')+"&reportId="+gadgetId, viewReportCallBack, "loading", "failed");
    	} else {
    		update("../report/reportList.jsp", "mainTd", $F('searchParams'), updateReportList, "loading", "failed");
    	}
    	send("../main/recentWorks.jsp", "recentWorksTd", "");
    	*/
    } else {
    	notifyMessageResult();
    }
}

/*
	보고서 수정 : reportEdit(reportId), reportEditCallBack()
	function request(url, params, response, confirm, progress, complete, error, isAsync) {
}
		jk yoon formName 추가
*/
function editReport(reportId, formName) {
	var searchParams = "";
	if($('searchParams'))
		searchParams = $F('searchParams');
	var params = "reportId="+reportId+searchParams+"&formName="+formName;
	update("../report/reportEdit.jsp", "mainTd", params, _editReport, "loading");
}
function _editReport() {
	var reportId = $F('reportId');
	
	var params = new Array(); 
	params.push("method=getReport");
	params.push("reportId="+reportId);
	params.push("userId="+userId);
	params.push("compId="+compId);
	params = params.join("&");
		
	request(getPath() + "/services/portal/reportService.jsp", params, editReportCallBack, null, null, null, null);
}
function editReportCallBack() {
	var xmlDoc = getXmlDOM(getResult());
	var resultXml = SmartXMLUtil.getChildNode(xmlDoc, 'Result');
	if(resultXml.getAttribute('status') == 'OK') {
		/* 공통 */
		var form = document.reportForm;
		var reportName 	= SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(resultXml, 'reportName'));
		var reportId 	= SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(resultXml, 'reportId'));
		var formId 		= SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(resultXml, 'formId'));
		form.reportName.value = reportName;

		/* 저장한 카테고리 아이디로 그룹, 정보관리업무 목록 가져오기 */
		changeCatgory(formId);

		/* 저장한 그룹이 선택 되어지도록, 그룹이 추가되기전 보고서는 없음. */
		var groupId = "";
		if(SmartXMLUtil.getChildNode(resultXml, 'groupId') != null) {
			groupId = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(resultXml, 'groupId'));
		}
		
		var groupSelect = document.getElementById("groupId");
		for(var i=0; i<groupSelect.length; i++) {
			if(groupSelect[i].value == groupId) {
				groupSelect[i].selected = true;
			}
		}
		
		//var groupOptions = groupSelect.getElementsByTagName("option");
		//for(var i=0; i<groupOptions.length; i++) {
		//	var groupOption = groupOptions[i];
		//	var optValue = groupOption.getAttribute("value");
		//	if(optValue == groupId) {
		//		groupOption.setAttribute("selected", "selected");
		//	}
		//}

		/* 그룹아이디가 존재할 경우 해당 그룹에 해당하는 정보관리 업무 목록 가져오기 */
		if(groupId != null && groupId != "" && groupId != "undefined") {
			changeGroup();
		}

		/* 저장한 정보관리업무가  선택 되어지도록 */
		var formSelect = document.getElementById("formId");
		for(var i=0; i<formSelect.length; i++) {
			if(formSelect[i].value == formId) {
				formSelect[i].selected = true;
			}
		}
		
		//var formOptions	= formSelect.getElementsByTagName("option");
		//for(var i=0; i<formOptions.length; i++) {
		//	var formOption = formOptions[i];
		//	var optValue = formOption.getAttribute("value");
		//	if(optValue == formId) {
		//		formOption.setAttribute("selected", "selected");
		//	}
		//}

		/* 저장한 폼아이디에 해당하는 필드 정보 가져오기 */
		changeForm();
		/* 저장한 보고서 종류가 선택 되어 지도록 */
		var reportType = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(resultXml, 'gadgetType'));
		if(reportType == "GRID") {
			form.reportType.selectedIndex = 1;
		} else if(reportType == "MATRIX") {
			form.reportType.selectedIndex = 2;
		} else {
			form.reportType.selectedIndex = 3;
			var chartSelect = document.getElementById("chartTypes");
			for(var i=0; i<chartSelect.length; i++) {
				if(chartSelect[i].value == reportType) {
					chartSelect[i].selected = true;
				}
			}
		}
		/* 해당 보고서 종류에 따라서 화면 보여주기 */
		reportTypeChange();

		/* 저장한 필터 조건 가져오기 */
		removeAllRow(1, document.getElementById("reportFilterTable"));
		var conditionsXml = SmartXMLUtil.getChildNode(SmartXMLUtil.getChildNode(SmartXMLUtil.getChildNode(resultXml, 'content'), 'Gadget'), 'conditions');
		var conditionXml  = SmartXMLUtil.getChildNodes(conditionsXml, 'condition');
		for(var i=0; i<conditionXml.length; i++) {
			conditionAdd();
			var columnId 		= SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(conditionXml[i], 'columnId'));
			var columnName 		= SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(conditionXml[i], 'columnName'));
			var columnType 		= SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(conditionXml[i], 'columnType'));
			var conditionValue 	= SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(conditionXml[i], 'conditionValue'));
			var comparison 		= SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(conditionXml[i], 'comparison'));

			/* 필터 항목이 선택 되도록 */
			var filterKey 	 = columnId+"$"+columnName;
			var filterSelect = document.getElementsByName("filterSelect")[i];
			for(var k=0; k<filterSelect.length; k++) {
				if(filterSelect[k].value == filterKey) {
					filterSelect[k].selected = true;
				}
			}
			filterDateFieldChange(document.getElementsByName("filterSelect")[i]);			

			/* 연산자가 선택되도록 */
			var operatorSelect = document.getElementsByName("operator")[i].options;
			for(var k=0; k<operatorSelect.length; k++) {
				if(operatorSelect[k].value == comparison) {
					operatorSelect[k].selected = true;
				}
			}

			/* 값이 나오도록 */
			var filterValues = document.getElementsByName("filterSearchWord");
			filterValues[i].value = conditionValue;		
		}

		/* 그리드 일 경우 저장한 항목 가져오기 */
		if(form.reportType.value === 'GRID') {
			var columnsXml = SmartXMLUtil.getChildNode(SmartXMLUtil.getChildNode(SmartXMLUtil.getChildNode(resultXml, 'content'), 'Gadget'), 'columns');
			var columnXml  = SmartXMLUtil.getChildNodes(columnsXml, 'column');
			for(var i=0; i<columnXml.length; i++) {
				var columnId = columnXml[i].getAttribute('id');
				for(var k=0; k<FormFieldArr.length; k++) {
					if(FormFieldArr[k][0] == columnId) {
						selectedFieldId 	= FormFieldArr[k][0];
						selectedFieldName 	= FormFieldArr[k][1];
						selectedFieldType 	= FormFieldArr[k][2];
						selectedFormatType 	= FormFieldArr[k][4];
						reportFieldAdd('1');
					}
				}
			}
		}

		/* 매트릭스 일 경우 저장한 항목 가져오기 X축 가져오기 */
		if(form.reportType.value === 'MATRIX') {
			var xAxisInfoXml = SmartXMLUtil.getChildNode(SmartXMLUtil.getChildNode(SmartXMLUtil.getChildNode(resultXml, 'content'), 'Gadget'), 'xAxisInfo');
			var axisXml  	 = SmartXMLUtil.getChildNodes(xAxisInfoXml, 'axis');
			for(var i=0; i<axisXml.length; i++) {
				var axisId 	= axisXml[i].getAttribute('id');
				for(var k=0; k<FormFieldArr.length; k++) {
					if(FormFieldArr[k][0] == axisId) {
						selectedFieldId 	= FormFieldArr[k][0];
						selectedFieldName 	= FormFieldArr[k][1];
						selectedFieldType 	= FormFieldArr[k][2];
						selectedFormatType 	= FormFieldArr[k][4];
						reportFieldAdd('1');
					}
				}
			}			

			/* Y축 가져오기 */
			var yAxisInfoXml = SmartXMLUtil.getChildNode(SmartXMLUtil.getChildNode(SmartXMLUtil.getChildNode(resultXml, 'content'), 'Gadget'), 'yAxisInfo');
			var axisXml  	 = SmartXMLUtil.getChildNodes(yAxisInfoXml, 'axis');
			for(var i=0; i<axisXml.length; i++) {
				var axisId 	= axisXml[i].getAttribute('id');
				for(var k=0; k<FormFieldArr.length; k++) {
					if(FormFieldArr[k][0] == axisId) {
						selectedFieldId 	= FormFieldArr[k][0];
						selectedFieldName 	= FormFieldArr[k][1];
						selectedFieldType 	= FormFieldArr[k][2];
						selectedFormatType 	= FormFieldArr[k][4];
						reportFieldAdd('2');
					}
				}
			}

			/* measure */
			var measureInfoXml = SmartXMLUtil.getChildNode(SmartXMLUtil.getChildNode(SmartXMLUtil.getChildNode(resultXml, 'content'), 'Gadget'), 'measureInfo');
			var measureXml     = SmartXMLUtil.getChildNodes(measureInfoXml, 'measure');
			for(var i=0; i<measureXml.length; i++) {
				var functionType = SmartXMLUtil.getChildNode(measureXml[i], 'filter').getAttribute('functionType');
				var measureId 	 = measureXml[i].getAttribute('id');
				for(var k=0; k<FormFieldArr.length; k++) {
					if(FormFieldArr[k][0] == measureId) {
						selectedFieldId 	= FormFieldArr[k][0];
						selectedFieldName 	= FormFieldArr[k][1];
						selectedFieldType 	= FormFieldArr[k][2];
						selectedFormatType 	= FormFieldArr[k][4];
						reportFieldAdd('3');
					}
				}
				var functionTypeSelect = document.getElementsByName("functionType3")[i];
				for(var k=0; k<functionTypeSelect.length; k++) {
					if(functionTypeSelect[k].value == functionType) {
						functionTypeSelect[k].selected = true;
					}
				}
			}
		}

		/*차트일 경우 Y축 */
		if(form.reportType.value === 'chartType') {
			var valueInfoXml = SmartXMLUtil.getChildNode(SmartXMLUtil.getChildNode(SmartXMLUtil.getChildNode(resultXml, 'content'), 'Gadget'), 'valueInfo');
			var valueInfoId  = valueInfoXml.getAttribute('id');
			var functionType = SmartXMLUtil.getChildNode(valueInfoXml, 'filter').getAttribute('functionType');
			for(var k=0; k<FormFieldArr.length; k++) {
				if(FormFieldArr[k][0] == valueInfoId) {
					selectedFieldId 	= FormFieldArr[k][0];
					selectedFieldName 	= FormFieldArr[k][1];
					selectedFieldType 	= FormFieldArr[k][2];
					selectedFormatType 	= FormFieldArr[k][4];
					reportFieldAdd('1');
				}
			}
			var functionTypeSelect = document.getElementById("functionType1");
			for(var k=0; k<functionTypeSelect.length; k++) {
				if(functionTypeSelect[k].value == functionType) {
					functionTypeSelect[k].selected = true;
				}
			}

			/* X축 */
			var groupInfoXml = SmartXMLUtil.getChildNode(SmartXMLUtil.getChildNode(SmartXMLUtil.getChildNode(resultXml, 'content'), 'Gadget'), 'groupInfo');
			var groupInfoId  = groupInfoXml.getAttribute('id');
			for(var k=0; k<FormFieldArr.length; k++) {
				if(FormFieldArr[k][0] == groupInfoId) {
					selectedFieldId 	= FormFieldArr[k][0];
					selectedFieldName 	= FormFieldArr[k][1];
					selectedFieldType 	= FormFieldArr[k][2];
					selectedFormatType 	= FormFieldArr[k][4];
					reportFieldAdd('2');
				}
			}

			/* measure */
			var remarkXml = SmartXMLUtil.getChildNode(SmartXMLUtil.getChildNode(SmartXMLUtil.getChildNode(resultXml, 'content'), 'Gadget'), 'remark');
			var remarkId  = remarkXml.getAttribute('id');
			for(var k=0; k<FormFieldArr.length; k++) {
				if(FormFieldArr[k][0] == remarkId) {
					selectedFieldId 	= FormFieldArr[k][0];
					selectedFieldName 	= FormFieldArr[k][1];
					selectedFieldType 	= FormFieldArr[k][2];
					selectedFormatType 	= FormFieldArr[k][4];
					reportFieldAdd('3');
				}
			}
		}
	}
}

/*
	보고서  삭제 : removeReport(reportId), reportRemoveCallback()
*/
function removeReport() {
	confirmMessage('AreYouSureYouWantToDeleteIt', _removeReport);
}
function _removeReport() {
	var params = new Array(); 
	params.push("method=removeReport");
	params.push("reportId="+$F('reportId'));
	params.push("userId="+userId);
	params.push("compId="+compId);
	params = params.join("&");
	request(getPath() + "/services/portal/reportService.jsp", params , removeReportCallback, null, "notifyDeleteProgress", null, "warnDeleteFailed");
}
function removeReportCallback() {
	var xmlDoc = getXmlDOM(getResult());
	var resultXml = SmartXMLUtil.getChildNode(xmlDoc, 'Result');
	if(resultXml.getAttribute('status') == 'OK') {
		clickBaseWorkDef(null,'../report/reportList.jsp');
	}
}

/*
	메인화면에 가젯 추가 : addGadget(reportId), addGadgetCallBack()
*/
function addGadget(reportId){
	var params = new Array(); 
	params.push("method=addGadget");
	params.push("reportId="+reportId);
	params.push("userId="+userId);
	params.push("compId="+compId);
	params = params.join("&");
	request(getPath() + "/services/portal/reportService.jsp", params, addGadgetCallBack, null, 'notifySaveProgress', null, 'warnSaveFailed');
}
function addGadgetCallBack() {
	var xmlDoc = getXmlDOM(getResult());
	var resultXml = SmartXMLUtil.getChildNode(xmlDoc, 'Result');
	if(resultXml.getAttribute('status') == 'OK') {
		var params = $F('searchParams');
		update("../report/reportList.jsp", "mainTd", params, updateReportList, "loading", "failed");
	}
}

function reportItemMove(obj, cnt, upDown) {
	
	//alert('obj : ' + obj);
	//alert('cnt : ' + cnt);
	//alert('upDown : ' + upDown);
	
	var imgNode = obj;
	var trNode = obj.parentNode.parentNode;
	var tbodyNode = trNode.parentNode;
	
	var trNodes = tbodyNode.getElementsByTagName("tr");
	var i=0;
	for(i=0; i<trNodes.length; i++) {
		if(trNode == trNodes[i])
			break;
	}
	
	//alert('trNodes.length : ' + trNodes.length);
	//var i = 0;
	if(upDown == "UP") {
		if (i > 0) {
			if(navigator.appName.indexOf('Microsoft') > -1) {
				tbodyNode.moveRow(i-1, i);
			} else {
				if (i==1) { return; }
				var toRow = tbodyNode.insertRow(i-1);
				var newTrNodes = tbodyNode.getElementsByTagName("tr");
				newTrNodes[i-1].innerHTML = trNodes[i+1].innerHTML;
				tbodyNode.deleteRow(i+1);
			}
		}
	} else {
		if (i < trNodes.length-1) {		
			if(navigator.appName.indexOf('Microsoft') > -1) {
				tbodyNode.moveRow(i, i+1);
			} else {
				var toRow = tbodyNode.insertRow(i+2);
				var newTrNodes = tbodyNode.getElementsByTagName("tr");
				newTrNodes[i+2].innerHTML = trNodes[i].innerHTML;
				tbodyNode.deleteRow(i);
			}
		}
	}
	
//	var intClickedIndex = getClickedObjectIndex( pObject ); 
//	var intObjLength  = 3 
//	if( ( intClickedIndex == 0 && pOrderFlag == "UP" ) || ( intClickedIndex == ( intObjLength - 1 ) && pOrderFlag == "DOWN" ) ) 
//		return; 
//
//	intRowIndex  = intClickedIndex; 
//
//	objTable  = document.getElementById("t1"); 
//	if( pOrderFlag == "UP" ) 
//		objTable.moveRow( intRowIndex - 1 , intRowIndex ); 
//	else 
//		objTable.moveRow( intRowIndex , intRowIndex + 1 ); 	
}

function clickListReport(menuType) {
	if(menuType == '../report/reportList.jsp'){
		clickBaseWorkDef(null,'../report/reportList.jsp');
	}else{
		// jk yoon 수정
		var formName = $('formName').getValue();
		//alert(formName);
		var fArray = formName.split(",");
		if(fArray[0] === '연락처'){
			hdTabControll(4);
			clickWorkDef("40288afb1b25f00b011b25f3c7950001",null,"frm_contact_SYSTEM","SINGLE");
		}else if(fArray[0]==='frm'){
			clickWorkDef(fArray[1],null,fArray[2],"SINGLE");
		}else if(fArray[0]==='prc'){
			clickWorkDef(fArray[1],null,fArray[2],"PROCESS");
			//prc,297ef0ed29d8991c0129e458550e00a0,prc_e21775ee553647d9801bd50b6fa31548,body_title_proces.png,기본업무 > 보고서 > 프로세스,prc_e21775ee553647d9801bd50b6fa31548
		}else{
			clickBaseWorkDef(null,'../report/reportList.jsp');
		}
		//else{
		//	var params = $F('searchParams');
		//	update("../report/reportList.jsp", "mainTd", params, updateReportList, "loading", "failed");
		//}
	}
}




//20100910 ksy 추가 (새보고서 부분)

function createReport2(params) {
	var form = document.reportForm;
	if(form != undefined && form != null && form != 'undefined'){
		saveCookie("subject",document.reportForm.reportName.value);
	}
	update("../report/reportInsert_new.jsp", "mainTd", params, createReport2Callback, "loading", "failed");
}

function createReport2Callback(){
	var subject = readCookie("subject");
	document.reportForm.reportName.value = subject;
	saveCookie("subject","");
}

function reportTypeChangeNew(value,categoryId){
	var form = document.reportForm;
	form.reportTypehidden.value = value;
	var chartType;
	//필드항목 테이블 초기화
	//removeAllRow(1, document.getElementById("reportContentTable1"));
	//removeAllRow(1, document.getElementById("reportContentTable2"));
	/*
	if(form.reportId.value!=""){
		removeAllRow(1, document.getElementById("reportFilterTable"));
	}
	 * */

	if (value === 'GRID'){
		chartType = "GRID";
        send("../report/sample/gridSample.jsp?type=GRID","reportSample");

        document.getElementById("reportContentTable1").style.display = "none";
        document.getElementById("reportContentTable2").style.display = "none";
        document.getElementById("reportContentTable3").style.display = "";
        	document.getElementById("chartTypes").style.display = "none";

	} else if (value === 'MATRIX'){
		chartType = "MATRIX";
        send("../report/sample/chartSample.jsp?type=MATRIX","reportSample");

        document.getElementById("reportContentTable1").style.display = "none";
        document.getElementById("reportContentTable2").style.display = "";
        document.getElementById("reportContentTable3").style.display = "none";
        	document.getElementById("chartTypes").style.display = "none";

	} else{
		chartType = 'CHART';

        document.getElementById("reportContentTable1").style.display = "";
        document.getElementById("reportContentTable2").style.display = "none";
        document.getElementById("reportContentTable3").style.display = "none";
        //if(document.getElementById("reportId").value!=""){
        	document.getElementById("chartTypes").style.display = "";
        //}
        if(form.chartTypes.value == "COLUMN_CHART"){
            send("../report/sample/chartSample.jsp?type=COLUMN_CHART","reportSample");
    	} else if(form.chartTypes.value == "BAR_CHART"){
            send("../report/sample/chartSample.jsp?type=BAR_CHART","reportSample");
    	} else if(form.chartTypes.value == "LINE_CHART"){
            send("../report/sample/chartSample.jsp?type=LINE_CHART","reportSample");
    	} else if(form.chartTypes.value == "AREA_CHART"){
            send("../report/sample/chartSample.jsp?type=AREA_CHART","reportSample");
    	} else if(form.chartTypes.value == "PIE_CHART"){
            send("../report/sample/chartSample.jsp?type=PIE_CHART","reportSample");
        }
	}
//alert($F('type') +'////'+ $F('formId'));
	if ($F('type') == 'true' && $F('formId') != '')
		changeFormNew();
	else
		changeFormCallBackPrc();
}

function changeFormNew() {
	var params = new Array(); 
	params.push("method=getFields");
	params.push("formId=" + document.getElementById("formId").value);
	params.push("userId=" + userId);
	params.push("userLanguage=" + defaultLanguage);
	params.push("compId=" + compId);
	params = params.join("&");
	
	request(getPath() + "/services/portal/reportService.jsp", params, changeFormCallBackNew);
	//xmlHTTP("../services/runtime/searchingService.jsp", params, changeFormCallBack);
}

function changeFormCallBackNew() {
	var form = document.reportForm;
	var reportType = form.reportTypehidden.value;
	var xmlDoc = getXmlDOM(getResult());
	var resultXml = SmartXMLUtil.getChildNode(xmlDoc, 'Result');
	if(resultXml.getAttribute('status') == 'OK') {

		var FormFieldXml = SmartXMLUtil.getChildNodes(resultXml, 'FormField');
		var fieldTable = document.getElementById("formFieldTable");
		//alert('FormFieldXml.length : ' + FormFieldXml.length);
		var selectBoxX = '';
		var selectBoxY = '';
		var selectBoxZ = '';
		var selectBoxX1 = '';
		var selectBoxX2 = '';
		var selectBoxY1 = '';
		var selectBoxY2 = '';
		var matrixValue = '';
		
		var options1 = '';
		var options2 = '';
		var options3 = '';
		var options4 = '';
		var options5 = '';
		
		selectBoxX = document.getElementById("YAxis");
		selectBoxY = document.getElementById("XAxis");
		selectBoxZ = document.getElementById("ZAxis");
		
		removeAllOptions(selectBoxX);
		removeAllOptions(selectBoxY);
		removeAllOptions(selectBoxZ);
		
		options1 = document.createElement('option');
		options2 = document.createElement('option');
		options3 = document.createElement('option');
		
		options1.value = "";
		options1.appendChild(document.createTextNode(""));
		options2.value = "";
		options2.appendChild(document.createTextNode(""));
		options3.value = "";
		options3.appendChild(document.createTextNode(""));
		
		selectBoxX.appendChild(options1);
		selectBoxY.appendChild(options2);
		selectBoxZ.appendChild(options3);
		
		
		selectBoxX1 = document.getElementById("X1Axis");
		selectBoxX2 = document.getElementById("X2Axis");
		selectBoxY1 = document.getElementById("Y1Axis");
		selectBoxY2 = document.getElementById("Y2Axis");
		matrixValue = document.getElementById("matrixValue");
		
		removeAllOptions(selectBoxX1);
		removeAllOptions(selectBoxX2);
		removeAllOptions(selectBoxY1);
		removeAllOptions(selectBoxY2);
		removeAllOptions(matrixValue);
		
		options1 = document.createElement('option');
		options2 = document.createElement('option');
		options3 = document.createElement('option');
		options4 = document.createElement('option');
		options5 = document.createElement('option');
		
		options1.value = "";
		options1.appendChild(document.createTextNode(""));
		options2.value = "";
		options2.appendChild(document.createTextNode(""));
		options3.value = "";
		options3.appendChild(document.createTextNode(""));
		options4.value = "";
		options4.appendChild(document.createTextNode(""));
		options5.value = "";
		options5.appendChild(document.createTextNode(""));
		
		selectBoxX1.appendChild(options1);
		selectBoxX2.appendChild(options2);
		selectBoxY1.appendChild(options3);
		selectBoxY2.appendChild(options4);
		matrixValue.appendChild(options5);
		
		removeAllRow(1, document.getElementById("GridNoUseList"));
		removeAllRow(1, document.getElementById("GridUseList"));
		
		for(var i=0; i<FormFieldXml.length; i++) {
			var fieldId   = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(FormFieldXml[i], 'id'));
			var fieldName = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(FormFieldXml[i], 'name'));
			var fieldType = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(FormFieldXml[i], 'type'));
//			var systemName = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(FormFieldXml[i], 'systemName'));
			var typeName = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(FormFieldXml[i], 'typeName'));
			var formatType = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(FormFieldXml[i], 'formatType'));
			var fieldTable 		= document.getElementById("formFieldTable");

			FormFieldArr[i] = [fieldId, fieldName, fieldType, typeName, formatType];
			if(formatType != "textArea" && formatType != "richEditor" && formatType != "dataGrid") {
				if(reportType == 'MATRIX'){
					options1 = document.createElement('option');
					options2 = document.createElement('option');
					options3 = document.createElement('option');
					options4 = document.createElement('option');
					options5 = document.createElement('option');
					
					options1.value = fieldId;
					options1.appendChild(document.createTextNode(fieldName));
					options2.value = fieldId;
					options2.appendChild(document.createTextNode(fieldName));
					options3.value = fieldId;
					options3.appendChild(document.createTextNode(fieldName));
					options4.value = fieldId;
					options4.appendChild(document.createTextNode(fieldName));
					options5.value = fieldId;
					options5.appendChild(document.createTextNode(fieldName));
					
					selectBoxX1.appendChild(options1);
					selectBoxX2.appendChild(options2);
					selectBoxY1.appendChild(options3);
					selectBoxY2.appendChild(options4);
					matrixValue.appendChild(options5);
					
				}else if(reportType == 'GRID'){
					var fieldTable 		= document.getElementById("GridNoUseList");

					FormFieldArr[i] = [fieldId, fieldName, fieldType, typeName, formatType];
					if(formatType != "textArea" && formatType != "richEditor" && formatType != "dataGrid") {
						var tr = fieldTable.insertRow(-1);
						tr.id = fieldId + "_fieldTr";
						tr.setAttribute("height", 24);
						tr.style.cursor = "pointer";

						var td1 = document.createElement("td");
						
						td1.setAttribute("bgColor", "#ececec");

						td1.setAttribute("style", "font-size:12px; font-family:'돋움',Dotum,Tahoma; width:400px; padding-left:10px; padding-right:10px; over-flow:hidden;");
						
						td1.id = fieldId + "_fieldTd1";
						
						tr.fieldId 		= fieldId;
						tr.fieldName 	= fieldName;
						tr.type 		= fieldType;
						tr.formatType 	= formatType;
						tr.onclick = function(){eval("cellClickNew(this)")};
					   	
						td1.innerHTML = "&nbsp;"+fieldName+"<input type='hidden' name='fieldId' value='"+fieldId+"'>"+"&nbsp;("+typeName+")";

						tr.appendChild(td1);
					}
				}else {
					options1 = document.createElement('option');
					options2 = document.createElement('option');
					options3 = document.createElement('option');
					options1.value = fieldId;
					options1.appendChild(document.createTextNode(fieldName));
					options2.value = fieldId;
					options2.appendChild(document.createTextNode(fieldName));
					options3.value = fieldId;
					options3.appendChild(document.createTextNode(fieldName));
					
					form.YAxisName.value = fieldName;
					form.YAxisType.value = fieldType;
					form.YAxisFormatType.value = formatType;
					form.XAxisName.value = fieldName;
					form.ZAxisName.value = fieldName;
					
					
					selectBoxX.appendChild(options1);
					selectBoxY.appendChild(options2);
					selectBoxZ.appendChild(options3);
				}
			}
		}
		selectedObj = null;
		selectedFieldId = null;
		selectedFieldName = null;
		selectedFieldType = null;
		selectedFormatType = null;
		selectDataFieldCnt = 0;
		fieldArr = new Array();

		
		//상세필터
		conditionAdd();
	}
}

/*
보고서 저장 : reportSaveNew(), reportSaveCallBackNew()
*/
function reportSaveNew(nextPage) {
	var reportForm = document.reportForm; 
	document.reportForm.nextPage.value=nextPage;
	var checkType = $F('checkType');
	
	if(checkType == 'one'){
		if(document.getElementById("formId").value == null || document.getElementById("formId").value == "") {
				warnMessage('Youdidnotentertherequireditems', 'errorCodeNullContent');
				return;
		} else if(document.reportForm.categoryId.value == null || document.reportForm.categoryId.value == ""){
				warnMessage('Youdidnotentertherequireditems', 'errorCodeNullContent');
				return;
		}
	} else if(document.reportForm.reportName.value == null || document.reportForm.reportName.value == ""){
		warnMessage('Youdidnotentertherequireditems', 'errorCodeNullContent');
		return;
	}
		var chartXml = "";
		var categoryId 	= document.getElementById("categoryId").value;
		var formId 		= document.getElementById("formId").value;
		var groupId 	= document.getElementById("groupId").value;
		var refFormId 	= "";
		var reportName	= document.getElementById("reportName").value;
		var remarkId 	= "";
		var remarkName 	= "";
	
		var valueInfoId   = "";
		var valueInfoName = "";
		var valueInfoUnit = "";
		var valueInfoType = "";
		var functionType  = "";
		var groupInfoId	  = "";
		var groupInfoName = "";
	
		var columnIds   = "";
		var columnNames = "";
	
		var XFieldIds 	= "";
		var XFieldNames = "";
		var YFieldIds 	= "";
		var YFieldNames = "";
	
		var measure_id 			 = "";
		var measure_name 		 = "";
		var measure_functionType = "";
		var measure_minValue  	 = "";
		var measure_maxValue 	 = "";
		var measure_unit 		 = "";
		
		var X1Axis 	= "";
		var X2Axis = "";
		var Y1Axis 	= "";
		var Y2Axis = "";
		var matrixValue = "";
	
		var chartType;
		var reportType = '';
		
		var groupInfoSub = "";
		var remarkSub = "";
		
		var DashBoardTypes = document.getElementsByName("reportDashboardType");
		var DashBoardType = 'Y';
		for(var d=0;d<DashBoardTypes.length;d++){
			if(DashBoardTypes[d].checked){
				DashBoardType =DashBoardTypes[d].value; 
			}
		}
		
		var reportT = document.getElementsByName('reportType');
		if(reportT[0].checked){reportType = 'CHART';}
		else if(reportT[1].checked){reportType = 'MATRIX';}
		else if(reportT[2].checked){reportType = 'GRID';}
		if (reportType == 'GRID'){
			chartType = "GRID";
			columnIds 	= document.getElementsByName("gridFieldId");
			columnNames = document.getElementsByName("gridFieldName");
			
			if (columnIds.length <= 0) { 
				warnMessage('Youdidnotentertherequireditems', 'errorCodeNullContent');
				return;
			}
	
	    } else if (reportType == 'MATRIX'){
	    	chartType = "MATRIX";
	    	if(document.reportForm.fieldId2 != null) {
	    		groupInfoId 	= document.reportForm.fieldId2.value;
	    	}
	    	if(document.reportForm.fieldName2 != null) {
	    		groupInfoName 	= document.reportForm.fieldName2.value;
	    	}
	
	    	X1Axis 	= document.getElementById("X1Axis");
	    	X2Axis = document.getElementById("X2Axis");
	    	Y1Axis 	= document.getElementById("Y1Axis");
	    	Y2Axis = document.getElementById("Y2Axis");
	    	matrixValue = document.getElementById("matrixValue");
	    	
	    	if (X1Axis === "" ||  Y1Axis === "" ||  matrixValue === "") { 
				warnMessage('Youdidnotentertherequireditems', 'errorCodeNullContent');
				return;
			}
	    	
	    } else if (reportType == 'CHART') {
	    	//기본으로 컬럼 차트 저장 보고서 기본정보 저장후 차트 및 필터부분 저장
	    	
	    	//if(reportForm.reportId.value==''){
	    	//	chartType 	= 'COLUMN_CHART';
	    	//}else{
	    		chartType 	= reportForm.chartTypes.value;;
	    	//}
	    	
	    	if(document.reportForm.YAxis != null) {
	    		valueInfoId 	= document.reportForm.YAxis.value;
	    	}
	    	if(document.reportForm.YAxisName != null) {
	    		valueInfoName 	= document.reportForm.YAxisName.value;
	    	}
	    	if(document.reportForm.YAxisFormatType != null) {
	    		valueInfoUnit 	= document.reportForm.YAxisFormatType.value;
	    	}	    	
	    	if(document.reportForm.YAxisType != null) {
	    		valueInfoType 	= document.reportForm.YAxisType.value;
	    	}
	    	if(document.reportForm.YAxisFunction != null) {
	    		functionType 	= document.reportForm.YAxisFunction.value;
	    	}
	    	
	    	if(document.reportForm.XAxis != null) {
	    		groupInfoId 	= document.reportForm.XAxis.value;
	    	}
	    	if(document.reportForm.XAxisName != null) {
	    		groupInfoName 	= document.reportForm.XAxisName.value;
	    	}
	
	    	if(document.reportForm.ZAxis != null) {
	    		remarkId 	= document.reportForm.ZAxis.value;
	    	}
	    	if(document.reportForm.ZAxisName != null) {
	    		remarkName 	= document.reportForm.ZAxisName.value;
	    	}
	    	
	    	if (valueInfoId === "" ||  groupInfoId === "") { 
				warnMessage('Youdidnotentertherequireditems', 'errorCodeNullContent');
				return;
			}
	    	if(document.reportForm.XAxisSub != null) {
	    		if(document.reportForm.XAxisSub.value != ''){
		    		groupInfoSub = groupInfoName;
		    		groupInfoName = document.reportForm.XAxisSub.value;
	    		}
	    		
	    	}
	    	if(document.reportForm.ZAxisSub != null) {
	    		remarkSub = remarkName;
	    		remarkName = document.reportForm.ZAxisSub.value;
	    	}
	    }
		
		if(remarkSub!='' && groupInfoSub!='' && remarkSub == groupInfoSub){
			warnMessage('Equal', 'xAxisZAxisDifferent');
			return;
		}
		
		var coditionColumnId 	= document.getElementsByName("filterSelect");
		var conditionColumnName = "";//document.getElementsByName("dataFieldName");
		var conditionValue 		= document.getElementsByName("filterSearchWord");
		var comparison 			= document.getElementsByName("operator");
	//alert(coditionColumnId.length+'///'+conditionValue.length+'///'+comparison.length);
		
		var chartXml="";
		var returnData="";
		var saveMeasureCount = 0;
		var saveXAxisCount = 0;
		var saveYAxisCount = 0;
	
		chartXml = '<Gadget formId="'+formId+'" type="'+chartType+'" categoryId="'+categoryId+'" refFormId="'+refFormId+'">' + '\n';
		chartXml += '	<name>'+startCdataTag() + reportName+endCdataTag() + '</name>' + '\n';
		chartXml += '	<remark id="'+remarkId+'">' + '\n';
		chartXml += '		<remarkSubInfo>'+ remarkSub +'</remarkSubInfo>\n';
		chartXml += '		<name>'+startCdataTag() + remarkName + endCdataTag()+'</name>' + '\n';
		chartXml += '	</remark>' + '\n';
	
		chartXml += '	<valueInfo id="'+valueInfoId+'">' + '\n';
		chartXml += '		<name>'+startCdataTag() + valueInfoName +endCdataTag()+'</name>' + '\n';
		chartXml += '		<unit>'+startCdataTag() + valueInfoUnit + endCdataTag()+'</unit>' + '\n';
		chartXml += '		<dataType>'+startCdataTag()+  valueInfoType + endCdataTag()+'</dataType>' + '\n';
		chartXml += '		<filter functionType="'+ functionType +'" minValue="" maxValue=""/>' + '\n';
		chartXml += '	</valueInfo>' + '\n';
	
		
		chartXml += '	<groupInfo id="'+ groupInfoId +'">' + '\n';
		chartXml += '		<groupSubInfo>'+ groupInfoSub +'</groupSubInfo>\n';
		chartXml += '		<name>'+startCdataTag() + groupInfoName + endCdataTag() +'</name>' + '\n';
		chartXml += '		<filter inclusion="">' + '\n';
		chartXml += '			<elements></elements>' + '\n';
		chartXml += '		</filter>' + '\n';
		chartXml += '	</groupInfo>' + '\n';
	
		chartXml += '	<columns>' + '\n';
		for(var k=0; k<columnIds.length; k++){
			chartXml += '		<column id="' + columnIds[k].value + '">' + '\n';
			chartXml += '			<name>'+startCdataTag() + columnNames[k].value + endCdataTag()+'</name>' + '\n';
			chartXml += '		</column>' + '\n';
		}
		chartXml += '	</columns>' + '\n';
	
		//매트릭스 X축
		chartXml += '	<xAxisInfo>' + '\n';
		
		var x1AxisId = X1Axis.value;
		var x1AxisSub = reportForm.X1AxisSub.value;
		var x1AxisName = reportForm.X1AxisName.value;
		if(x1AxisSub != ''){
			x1AxisSub = x1AxisName;
			x1AxisName = reportForm.X1AxisSub.value;
		}
		
		var x2AxisId = X2Axis.value;
		var x2AxisSub = reportForm.X2AxisSub.value;
		var x2AxisName = reportForm.X2AxisName.value;
		if(x2AxisSub != ''){
			x2AxisSub = x2AxisName;
			x2AxisName = reportForm.X2AxisSub.value;
		}
		
		if(reportType=='MATRIX'){
			chartXml += '<axis id="' + x1AxisId + '">';
			chartXml += 	'<x1AxisSubInfo>'+ x1AxisSub +'</x1AxisSubInfo>\n';			
			chartXml +=		'<name>' + startCdataTag() + x1AxisName + endCdataTag() + '</name>';
			chartXml +=		'<filter inclusion="">';
			chartXml +=			'<elements></elements>';
			chartXml +=		'</filter>';
			chartXml += '</axis>';
			if(X2Axis.Value != ''){
				chartXml += '<axis id="' + x2AxisId + '">';
				chartXml += 	'<x2AxisSubInfo>'+ x2AxisSub +'</x2AxisSubInfo>\n';
				chartXml +=		'<name>' + startCdataTag() + x2AxisName + endCdataTag() + '</name>';
				chartXml +=		'<filter inclusion="">';
				chartXml +=			'<elements></elements>';
				chartXml +=		'</filter>';
				chartXml += '</axis>';
			}
		}
		chartXml += '	</xAxisInfo>' + '\n';
		
		
		//매트릭스 Y축
		chartXml += '	<yAxisInfo>' + '\n';
		if(reportType=='MATRIX'){
			chartXml += '<axis id="' + Y1Axis.value + '">';
			chartXml +=		'<name>' + startCdataTag() + reportForm.Y1AxisName.value + endCdataTag() + '</name>';
			chartXml +=		'<filter inclusion="">';
			chartXml +=			'<elements></elements>';
			chartXml +=		'</filter>';
			chartXml += '</axis>';
			if(Y2Axis.Value != ''){
				chartXml += '<axis id="' + Y2Axis.value + '">';
				chartXml +=		'<name>' + startCdataTag() + reportForm.Y2AxisName.value + endCdataTag() + '</name>';
				chartXml +=		'<filter inclusion="">';
				chartXml +=			'<elements></elements>';
				chartXml +=		'</filter>';
				chartXml += '</axis>';
			}
		}
		chartXml += '	</yAxisInfo>' + '\n';
	
		var matrixValueId = matrixValue.value;
		var matrixValueSub = reportForm.matrixValueSub.value;
		var matrixValueName = reportForm.matrixValueName.value;
		if(matrixValueSub != ''){
			matrixValueSub = matrixValueName;
			matrixValueName = reportForm.matrixValueSub.value;
		}
		
		//매트릭스 measure
		chartXml += '	<measureInfo>' + '\n';
				chartXml += '<measure id="' + matrixValueId+ '">';
				chartXml += 	'<measureSubInfo>'+ matrixValueSub +'</measureSubInfo>\n';
				chartXml +=		'<name>' + startCdataTag()+ matrixValueName +endCdataTag() + '</name>';
				chartXml +=		'<filter functionType="' + reportForm.matrixValueFunction.value + '" minValue=""  maxValue="" />';
				chartXml +=		'<unit>' + startCdataTag()+reportForm.matrixValueFormatType.value+endCdataTag() + '</unit>';
				chartXml += '</measure>';

				chartXml += '	<measureCheck>'+startCdataTag()+'N'+endCdataTag()+'</measureCheck>' + '\n';
		chartXml += '	</measureInfo>' + '\n';
	
		//상세 필터
		chartXml += '	<conditions>' + '\n';
		if(coditionColumnId.length > 0){
			for(var i=0; i<coditionColumnId.length; i++){
				var a = coditionColumnId[i].value.indexOf('$',0);
				var selectLength = coditionColumnId[i].value.length;
				var columnId = coditionColumnId[i].value.substring(0, a);
				var type = coditionColumnId[i].value.substring(a+1, selectLength);
		
				var typeLength = type.length;
				var typeIndex = type.indexOf('$',0);
				var columnName = type.substring(typeIndex+1, typeLength);
				type = type.substring(0, typeIndex);
				if(columnId != "" && conditionValue[i].value != "" && comparison[i].value != "") {
					chartXml += '		<condition name="condition_' + i +'">' + '\n';
					chartXml += '			<columnId>'+ startCdataTag() + columnId + endCdataTag() +'</columnId>' + '\n';
					chartXml += '			<columnName>'+columnName+'</columnName>' + '\n';
					chartXml += '			<columnType>'+type+'</columnType>' + '\n';
					chartXml += '			<conditionValue>'+conditionValue[i].value+'</conditionValue>' + '\n';
					chartXml += '			<comparison>'+startCdataTag()+comparison[i].value+endCdataTag()+'</comparison>' + '\n';
					chartXml += '		</condition>' + '\n';
				}
			}
		}
		chartXml += '		<conditionsRelation>AND</conditionsRelation>' + '\n';
		chartXml += '	</conditions>' + '\n';
		chartXml += '</Gadget>';
		var reportId = "";
		if($('reportId'))
			reportId = $F('reportId');
		
		
		// jk 추가 보고서.
		var XAxisOrder = $F('XAxisOrder'); // 차트인경우 x축 order by asc/desc
		var ZAxisOrder = $F('ZAxisOrder');// 차트인경우 z축 order by asc/desc
		var X1AxisOrder = $F('X1AxisOrder');// 매트릭스인경우 x1축 order by asc/desc
		var X2AxisOrder = $F('X2AxisOrder');// 매트릭스인경우 x2축 order by asc/desc
		var Y1AxisOrder = $F('Y1AxisOrder');// 매트릭스인경우 y1축 order by asc/desc
		var Y2AxisOrder = $F('Y2AxisOrder');// 매트릭스인경우 y2축 order by asc/desc
		var matrixValueOrder = $F('matrixValueOrder');// 매트릭스인경우 z축 order by asc/desc
		
		var period = $F('period'); //all-week-month-quarter-year-specified ,, specified 일경우 periodBefore 와 periodAfter 를 조합하여 넘김.
		var periodBefore = $F('periodBefore');
		var periodAfter = $F('periodAfter');
		if(period == 'specified')
			period = periodBefore+'/'+periodAfter;
		
		
		var params = new Array(); 
		params.push("method=setReport");
		params.push("reportId="+reportId);
		params.push("userId="+userId);
		params.push("reportName="+reportName);
		params.push("reportType="+chartType);
		params.push("formId="+formId);
		params.push("content="+chartXml);
		params.push("compId="+compId);
		params.push("DashBoardType="+DashBoardType);
		
		var formatType = '';
		if($F('type') != 'true')
			formatType = 'PROCESS';
		else
			formatType = 'SINGLE';
		
		params.push("type="+formatType); // one 일때 정보관리업무/프로세스업무 구분 'SINGLE' 'PROCESS'
		params.push("checkType="+checkType); // one / all / process / gantt / single /
		params.push("XAxisOrder="+XAxisOrder); //차트일경우 X축 order by
		params.push("ZAxisOrder="+ZAxisOrder); //차트일경우 Z축 order by
		params.push("X1AxisOrder="+X1AxisOrder); // 매트릭스일 경우 X1 축 order by
		params.push("X2AxisOrder="+X2AxisOrder); // 매트릭스일 경우 X2 축 order by
		params.push("Y1AxisOrder="+Y1AxisOrder); // 매트릭스일 경우 Y1 축 order by
		params.push("Y2AxisOrder="+Y2AxisOrder); // 매트릭스일 경우 Y2 축 order by
		params.push("matrixValueOrder="+matrixValueOrder); // 매트릭스일 경우 z축 order by
		
		params.push("period="+period); // all / week / month / quarter / year / specified
		params = params.join("&");
		request(getPath() + "/services/portal/reportService.jsp" , params , reportSaveCallBackNew, null , 'notifySaveProgress' , null , 'warnSaveFailed');
}
function reportSaveCallBackNew() {
	var response = getXmlDOM(getResult());
	var result = SmartXMLUtil.getChildNode(response, 'Result');
	if(result.getAttribute('status') == 'OK') {
		notifyMessageResult();
		//jk yoon 수정
		var formName = $('formName').getValue();
		
		var fArray = formName.split(",");
		clickBaseWorkDef(null,'../report/reportList.jsp');
		//editReportNew(result.getAttribute("gadgetId"),formName,result.getAttribute("createUser"),result.getAttribute("createDate"));
		
	} else {
		notifyMessageResult();
	}
}

//각각 셀렉트 박스 선택시 name , type, functionType 설정해주는 부분
function selectBoxfunction(formId,name,type){
	var form = document.reportForm;
	var reportType = form.reportTypehidden.value;
	var xmlDoc = getXmlDOM(getResult());
	var resultXml = SmartXMLUtil.getChildNode(xmlDoc, 'Result');
	if(resultXml.getAttribute('status') == 'OK') {

		var FormFieldXml = SmartXMLUtil.getChildNodes(resultXml, 'FormField');
		var fieldTable = document.getElementById("formFieldTable");
				
		for(var i=0; i<FormFieldXml.length; i++) {
			var fieldId   = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(FormFieldXml[i], 'id'));
			if(formId==fieldId){
				var fieldName = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(FormFieldXml[i], 'name'));
				var fieldType = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(FormFieldXml[i], 'type'));
				var typeName = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(FormFieldXml[i], 'typeName'));
				var formatType = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(FormFieldXml[i], 'formatType'));
				var fieldTable 		= document.getElementById("formFieldTable");
	
				FormFieldArr[i] = [fieldId, fieldName, fieldType, typeName, formatType];
				if(formatType != "textArea" && formatType != "richEditor" && formatType != "dataGrid") {
					if(reportType == 'CHART'){
						if(name=='YAxis'){
							form.YAxisName.value = fieldName;
							form.YAxisType.value = fieldType;
							form.YAxisFormatType.value = formatType;
						}else if(name=='XAxis'){
							form.XAxisName.value = fieldName;
						}else if(name=='ZAxis'){
							form.ZAxisName.value = fieldName;
						}
					}else if(reportType == 'MATRIX'){
						if(name=='X1Axis'){
							form.X1AxisName.value = fieldName;
						}else if(name=='X2Axis'){
							form.X2AxisName.value = fieldName;
						}else if(name=='Y1Axis'){
							form.Y1AxisName.value = fieldName;
						}else if(name=='Y2Axis'){
							form.Y2AxisName.value = fieldName;
						}else if(name=='matrixValue'){
							form.matrixValueName.value = fieldName;
							form.matrixValueType.value = fieldType;
							form.matrixValueFormatType.value = formatType;
						}
					}else if(reportType == 'GRID'){
					}
				}
			}
		}
		
	}
	
	var lang = form.userLanguage.value;
	var xf = '';
	var countTxt = 'Count'; 	if(lang=='KOR'){countTxt = '갯수';}
	var sumTxt = 'Sum';		if(lang=='KOR'){sumTxt = '합';}
	var maxTxt = 'Maximum';	if(lang=='KOR'){maxTxt = '최대값';}
	var minTxt = 'Minimum';	if(lang=='KOR'){minTxt = '최소값';}
	var avgTxt = 'Average';	if(lang=='KOR'){avgTxt = '평균';}
	
	var options ='';
	var chartType;
	var valueSelect = "";
	var selectedFormatType ='';
		if (type === 'MATRIX') {
				selectedFormatType = form.matrixValueFormatType.value;
		    	if(selectedFormatType == "numberInput" || selectedFormatType == "currencyInput" || selectedFormatType == "percentInput") {
			    	xf = document.getElementById("matrixValueFunction");
			    	removeAllOptions(xf);
					
					options = document.createElement('option');
					options.value = "count";
					options.appendChild(document.createTextNode(countTxt));
					xf.appendChild(options);
					options = document.createElement('option');
					options.value = "sum";
					options.appendChild(document.createTextNode(sumTxt));
					xf.appendChild(options);
					options = document.createElement('option');
					options.value = "max";
					options.appendChild(document.createTextNode(maxTxt));
					xf.appendChild(options);
					options = document.createElement('option');
					options.value = "min";
					options.appendChild(document.createTextNode(minTxt));
					xf.appendChild(options);
					options = document.createElement('option');
					options.value = "avg";
					options.appendChild(document.createTextNode(minTxt));
					xf.appendChild(options);
		    	}else{
		    		xf = document.getElementById("matrixValueFunction");
		    		removeAllOptions(xf);
					
					options = document.createElement('option');
					options.value = "count";
					options.appendChild(document.createTextNode(countTxt));
					xf.appendChild(options);
		    	}
		    } else if (type === 'CHART'){
		    	selectedFormatType = form.YAxisFormatType.value;
		    	if(selectedFormatType == "numberInput" || selectedFormatType == "currencyInput" || selectedFormatType == "percentInput") {
			    	xf = document.getElementById("YAxisFunction");
			    	removeAllOptions(xf);
					
					options = document.createElement('option');
					options.value = "count";
					options.appendChild(document.createTextNode(countTxt));
					xf.appendChild(options);
					options = document.createElement('option');
					options.value = "sum";
					options.appendChild(document.createTextNode(sumTxt));
					xf.appendChild(options);
					options = document.createElement('option');
					options.value = "max";
					options.appendChild(document.createTextNode(maxTxt));
					xf.appendChild(options);
					options = document.createElement('option');
					options.value = "min";
					options.appendChild(document.createTextNode(minTxt));
					xf.appendChild(options);
					options = document.createElement('option');
					options.value = "avg";
					options.appendChild(document.createTextNode(minTxt));
					xf.appendChild(options);
		    	}else{
		    		xf = document.getElementById("YAxisFunction");
		    		removeAllOptions(xf);
					
					options = document.createElement('option');
					options.value = "count";
					options.appendChild(document.createTextNode(countTxt));
					xf.appendChild(options);
		    	}
								
		    }
}

//보고서 항목 추가
function reportFieldAddGrid() {
	var form = document.reportForm;
	if(selectedFieldId != null && selectedFieldId != "") {
			var chartType;
			var valueSelect = "";
			var reportContentTable = document.getElementById("GridUseList");
			var tr = reportContentTable.insertRow(-1);
			tr.id = selectedFieldId + "_reportFieldTrUse";
		    tr.fieldId 		= selectedFieldId;
			tr.fieldName 	= selectedFieldName;
			tr.type 		= selectedFieldType;
			tr.formatType 	= selectedFormatType;
			tr.setAttribute("height", 24);
			tr.setAttribute("class","reportContentTable3_ColumnList");
			var td1 = document.createElement("td");
			var td2 = document.createElement("td");
			var td3 = document.createElement("td");

			td1.setAttribute("colSpan", 2);
			
			td1.setAttribute("style", "font-size:12px; font-family:'돋움',Dotum,Tahoma; min-width:40px;");
			td2.setAttribute("style", "font-size:12px; font-family:'돋움',Dotum,Tahoma; width:300px; padding-left:10px; padding-right:10px; over-flow:hidden;");
			td3.setAttribute("style", "font-size:12px; font-family:'돋움',Dotum,Tahoma; width:20px; padding-left:10px; padding-right:10px;");
			
			td2.align = "center";
			td3.align = "center";
			td1.id = selectedFieldId + "_reportFieldTd1";
			td2.id = selectedFieldId + "_reportFieldTd2";
			var td1Text = "&nbsp;"+selectedFieldName+"&nbsp;&nbsp;&nbsp;"+valueSelect;
		    td1Text = td1Text + "<input type='hidden' name='gridFieldId' value='"+selectedFieldId+"'>";
		    td1Text = td1Text + "<input type='hidden' name='gridFieldName' value='"+selectedFieldName+"'>";
		    td1Text = td1Text + "<input type='hidden' name='gridFieldType' value='"+selectedFieldType+"'>";
		    td1Text = td1Text + "<input type='hidden' name='gridFieldFormatType' value='"+selectedFormatType+"'>";
		    //td1.innerHTML = td1Text;
			//td2.innerHTML = "<img src='../images/bt_delete.gif' onclick='reportFieldDel(\""+selectedFieldId+"\")' style='margin-bottom: 0px;'>";
		    //td3.innerHTML = "<img src='../images/common/bt_1up.gif' onclick='reportItemMove(this, \"UP\");' style='cursor: pointer;'>&nbsp;&nbsp;&nbsp;<img src='../images/common/bt_1dn.gif' onclick='reportItemMove(this,  \"DOWN\");' style='cursor: pointer;'>";
		    
		    td1.innerHTML = "<img src='../images/body/up_normal.jpg' onclick='reportItemMoveGrid(this, \"UP\");' style='cursor: pointer;'>&nbsp;<img src='../images/body/down_normal.jpg' onclick='reportItemMoveGrid(this,  \"DOWN\");' style='cursor: pointer;'>";
			td2.innerHTML = td1Text;
		    td3.innerHTML = "<img src='../images/body/del_hover.jpg' onclick='reportFieldDelGrid(this)' style='cursor: pointer;'>";
			tr.appendChild(td1);
			tr.appendChild(td2);
			tr.appendChild(td3);
			if(selectedObj==null){
				var tagetObj = document.getElementById(selectedFieldId+"_fieldTr");
			}else{
				var tagetObj = document.getElementById(selectedObj.id);
			}
			tagetObj.parentNode.removeChild(tagetObj);

	}
}

function cellClickNew(fieldObj) {
	selectedFieldId = fieldObj.fieldId;
	selectedFieldName = fieldObj.fieldName;
	selectedFieldType = fieldObj.type;
	selectedFormatType = fieldObj.formatType;

	var fieldObjId = fieldObj.id;
	if (selectedObj != null && selectedObj != fieldObj) {
		selectedObj.style.fontWeight  = "";
	}
	selectedObj = fieldObj;
	selectedObj.style.fontWeight  = "bold";
}


function reportFieldDelGrid(obj) {
	var trNode = obj.parentNode.parentNode;
	
	selectedFieldId = trNode.fieldId;
	selectedFieldName = trNode.fieldName;
	selectedFieldType = trNode.type;
	selectedFormatType = trNode.formatType;

	var fieldObjId = trNode.id;
	
	var tagetObj = document.getElementById(fieldObjId);
	tagetObj.parentNode.removeChild(tagetObj);
	var fieldCnt = null;
	for(var i=0; i<fieldArr.length; i++) {
		if(fieldId == fieldArr[i][0] && cnt == fieldArr[i][1]) {
			fieldCnt = i;
			break;
		}
	}
	fieldArr.remove(fieldCnt);
	
	var fieldTable 		= document.getElementById("GridNoUseList");
	FormFieldArr[i] = [selectedFieldId, selectedFieldName, selectedFieldType, selectedFieldType, selectedFormatType];
	if(selectedFormatType != "textArea" && selectedFormatType != "richEditor" && selectedFormatType != "dataGrid") {
		var tr = fieldTable.insertRow(-1);
		tr.id = selectedFieldId + "_fieldTr";
		tr.setAttribute("height", 24);
		tr.style.cursor = "pointer";

		var td1 = document.createElement("td");
		
		td1.setAttribute("bgColor", "#ececec");
		
		td1.id = selectedFieldId + "_fieldTd1";
		
		tr.fieldId 		= selectedFieldId;
		tr.fieldName 	= selectedFieldName;
		tr.type 		= selectedFieldType;
		tr.formatType 	= selectedFormatType;
		tr.onclick = function(){eval("cellClickNew(this)")};
	   	
		td1.innerHTML = "&nbsp;"+selectedFieldName+"<input type='hidden' name='fieldId' value='"+selectedFieldId+"'>"+"&nbsp;("+selectedFieldType+")";

		tr.appendChild(td1);
	}
	
}
function reportItemMoveGrid(obj, upDown) {
	var imgNode = obj;
	var trNode = obj.parentNode.parentNode;
	var tbodyNode = trNode.parentNode;
	
	var trNodes = tbodyNode.getElementsByTagName("tr");
	var i=0;
	for(i=0; i<trNodes.length; i++) {
		if(trNode == trNodes[i])
			break;
	}
	if(upDown == "UP") {
		if (i > 1) {
			if(navigator.appName.indexOf('Microsoft') > -1) {
				tbodyNode.moveRow(i-1, i);
			} else {
				if (i==1) { return; }
				var toRow = tbodyNode.insertRow(i-1);
				var newTrNodes = tbodyNode.getElementsByTagName("tr");
				newTrNodes[i-1].innerHTML = trNodes[i+1].innerHTML;
				tbodyNode.deleteRow(i+1);
			}
		}
	} else {
		if (i < trNodes.length-1) {		
			if(navigator.appName.indexOf('Microsoft') > -1) {
				tbodyNode.moveRow(i, i+1);
			} else {
				var toRow = tbodyNode.insertRow(i+2);
				var newTrNodes = tbodyNode.getElementsByTagName("tr");
				newTrNodes[i+2].innerHTML = trNodes[i].innerHTML;
				tbodyNode.deleteRow(i);
			}
		}
	}
}

/*보고서 수정부분*/
function editReportNew(reportId, formName, createUser, createDate) {
	var searchParams = "";
	if($('searchParams'))
		searchParams = $F('searchParams');
	var params = "reportId="+reportId+searchParams+"&formName="+formName+"&createUser="+createUser+"&createDate="+createDate;
	update("../report/reportEdit_new.jsp", "mainTd", params, _editReportNew, "loading");
}
function _editReportNew() {
	var reportId = $F('reportId');
	var params = new Array(); 
	params.push("method=getReport");
	params.push("reportId="+reportId);
	params.push("userId="+userId);
	params.push("compId="+compId);
	params = params.join("&");
	
	request(getPath() + "/services/portal/reportService.jsp", params, editReportCallBackNew, null, null, null, null);
}
function editReportCallBackNew() {
	var xmlDoc = getXmlDOM(getResult());
	var resultXml = SmartXMLUtil.getChildNode(xmlDoc, 'Result');
	if(resultXml.getAttribute('status') == 'OK') {
		/* 공통 */
		var form = document.reportForm;
		var reportName 	= SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(resultXml, 'reportName'));
		var reportId 	= SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(resultXml, 'reportId'));
		var formId 		= SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(resultXml, 'formId'));
		var reportDashboardType 		= SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(resultXml, 'reportDashboardType'));
		

		var xAxisOrder = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(resultXml, 'xaxisOrder')); 
		var zAxisOrder = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(resultXml, 'zaxisOrder'));
		var x1AxisOrder = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(resultXml, 'x1AxisOrder')); 
		var x2AxisOrder = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(resultXml, 'x2AxisOrder')); 
		var y1AxisOrder = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(resultXml, 'y1AxisOrder')); 
		var y2AxisOrder = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(resultXml, 'y2AxisOrder')); 
		
		var matrixValueOrder = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(resultXml, 'matrixValueOrder'));
		
		var period = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(resultXml, 'period'));
		var checkType = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(resultXml, 'checkType'));

		if(xAxisOrder == 'asc') form.XAxisOrders[0].checked = true;
		else if(xAxisOrder == 'desc') form.XAxisOrders[1].checked = true;
		form.XAxisOrder.value = xAxisOrder;
		
		if(zAxisOrder == 'asc') form.ZAxisOrders[0].checked = true;
		else if(zAxisOrder == 'desc') form.ZAxisOrders[1].checked = true;
		form.ZAxisOrder.value = zAxisOrder;
		
		if(x1AxisOrder == 'asc') form.X1AxisOrders[0].checked = true;
		else if(x1AxisOrder == 'desc') form.X1AxisOrders[1].checked = true;
		form.X1AxisOrder.value = x1AxisOrder;
		
		if(x2AxisOrder == 'asc') form.X2AxisOrders[0].checked = true;
		else if(x2AxisOrder == 'desc') form.X2AxisOrders[1].checked = true;
		form.X2AxisOrder.value = x2AxisOrder;
		
		if(y1AxisOrder == 'asc') form.Y1AxisOrders[0].checked = true;
		else if(y1AxisOrder == 'desc') form.Y1AxisOrders[1].checked = true;
		form.Y1AxisOrder.value = y1AxisOrder;
		
		if(y2AxisOrder == 'asc') form.Y2AxisOrders[0].checked = true;
		else if(y2AxisOrder == 'desc') form.Y2AxisOrders[1].checked = true;
		form.Y2AxisOrder.value = y2AxisOrder;
		
		if(matrixValueOrder == 'asc') form.matrixValueOrders[0].checked = true;
		else if(matrixValueOrder == 'desc') form.matrixValueOrders[1].checked = true;
		form.matrixValueOrder.value = matrixValueOrder;
		
		if(period == 'all') form.periodR[0].checked = true;
		else if(period == 'week') form.periodR[1].checked = true;
		else if(period == 'month') form.periodR[2].checked = true;
		else if(period == 'quarter') form.periodR[3].checked = true;
		else if(period == 'year') form.periodR[4].checked = true;
		else if(period == 'specified') form.periodR[5].checked = true;
		
		form.period.value = period;
		form.reportName.value = reportName;
		form.checkType.value = checkType;
		
		
		//alert(checkType+'//');
		
		/* 저장한 카테고리 아이디로 그룹, 정보관리업무 목록 가져오기 */
		changeCatgory(formId);

		/* 저장한 그룹이 선택 되어지도록, 그룹이 추가되기전 보고서는 없음. */
		var groupId = "";
		if(SmartXMLUtil.getChildNode(resultXml, 'groupId') != null) {
			groupId = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(resultXml, 'groupId'));
		}

		
		var groupSelect = document.getElementById("groupId");
		for(var i=0; i<groupSelect.length; i++) {
			if(groupSelect[i].value == groupId) {
				groupSelect[i].selected = true;
			}
		}
		
		//var groupOptions = groupSelect.getElementsByTagName("option");
		//for(var i=0; i<groupOptions.length; i++) {
		//	var groupOption = groupOptions[i];
		//	var optValue = groupOption.getAttribute("value");
		//	if(optValue == groupId) {
		//		groupOption.setAttribute("selected", "selected");
		//	}
		//}

		/* 그룹아이디가 존재할 경우 해당 그룹에 해당하는 정보관리 업무 목록 가져오기 */
		if(groupId != null && groupId != "" && groupId != "undefined") {
			changeGroup();
		}

		/* 저장한 정보관리업무가  선택 되어지도록 */
		var formSelect = document.getElementById("formId");
		for(var i=0; i<formSelect.length; i++) {
			if(formSelect[i].value == formId) {
				formSelect[i].selected = true;
			}
		}
		
		//var formOptions	= formSelect.getElementsByTagName("option");
		//for(var i=0; i<formOptions.length; i++) {
		//	var formOption = formOptions[i];
		//	var optValue = formOption.getAttribute("value");
		//	if(optValue == formId) {
		//		formOption.setAttribute("selected", "selected");
		//	}
		//}
		/* 현황판종류  */
		
		var reportboardTypes = document.getElementsByName("reportDashboardType");
		for(var d=0;d<reportboardTypes.length;d++){
			/*현재는 기본만 사용하고 있음 메인대쉬보드 설정 후 밑의 코드 사용*/
			if(reportDashboardType!='Y'){
				reportboardTypes[0].checked='checked';
			}
			/*
			if(reportboardTypes[d].value==reportDashboardType){
				reportboardTypes[d].checked='checked';
			}
			 */
		}
				

		/* 저장한 보고서 종류가 선택 되어 지도록 */
		var reportType = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(resultXml, 'gadgetType'));
		if(reportType == "GRID") {
			form.reportType[2].checked = true;
			//form.reportType.selectedIndex = 1;
		} else if(reportType == "MATRIX") {
			form.reportType[1].checked = true;
			//form.reportType.selectedIndex = 2;
		} else {
			form.reportType[0].checked = true;
			//form.reportType.selectedIndex = 3;
			var chartSelect = document.getElementById("chartTypes");
			for(var i=0; i<chartSelect.length; i++) {
				if(chartSelect[i].value == reportType) {
					chartSelect[i].selected = true;
					chartTypeChangeNew();
				}
			}
		}
		/* 저장한 폼아이디에 해당하는 필드 정보 가져오기 */
		changeFormNew();
		/* 해당 보고서 종류에 따라서 화면 보여주기 */
		reportTypeChangeNew(reportType);
		/* 저장한 필터 조건 가져오기 */
try{removeAllRow(1, document.getElementById("reportFilterTable"));}catch(e){}
		var conditionsXml = SmartXMLUtil.getChildNode(SmartXMLUtil.getChildNode(SmartXMLUtil.getChildNode(resultXml, 'content'), 'Gadget'), 'conditions');
		var conditionXml  = SmartXMLUtil.getChildNodes(conditionsXml, 'condition');
//alert('123 === '+conditionXml.length+'/////'+reportType);
		for(var i=0; i<conditionXml.length; i++) {
			//conditionAdd();
			if(i!=0) addReportFilter();
			var columnId 		= SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(conditionXml[i], 'columnId'));
			var columnName 		= SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(conditionXml[i], 'columnName'));
			var columnType 		= SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(conditionXml[i], 'columnType'));
			var conditionValue 	= SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(conditionXml[i], 'conditionValue'));
			var comparison 		= SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(conditionXml[i], 'comparison'));
			
			if(i==0 && columnType == 'date'){
				var input = document.getElementsByName("filterSearchWord")[0];
				input.setAttribute('style','width:120px;cursor:pointer;');
				input.setAttribute('onclick','searchDate("filterSearchWord","0")');
			}else if(columnType == 'date'){
				var input = document.getElementsByName("filterSearchWord")[i];
				input.setAttribute('style','width:120px;cursor:pointer;');
				input.setAttribute('onclick','searchDate("filterSearchWordfilterTextTd'+addReportFilterIdx+'","0")');
			}
			
			/* 필터 항목이 선택 되도록 */
			var filterKey 	 = columnId+"$"+columnType+"$"+columnName;
			var filterSelect = document.getElementsByName("filterSelect")[i];
			//alert(filterKey+'///'+columnType);
			for(var k=0; k<filterSelect.length; k++) {
				if(filterSelect[k].value == filterKey) {
					filterSelect[k].selected = true;
				}
			}
			//try{filterDateFieldChange(document.getElementsByName("filterSelect")[i]);}catch(e){}			
			/* 연산자가 선택되도록 */
			var operatorSelect = document.getElementsByName("operator")[i].options;
			for(var k=0; k<operatorSelect.length; k++) {
				if(operatorSelect[k].value == comparison) {
					operatorSelect[k].selected = true;
				}
			}

			/* 값이 나오도록 */
			var filterValues = document.getElementsByName("filterSearchWord");
			filterValues[i].value = conditionValue;		
		}
		/* 그리드 일 경우 저장한 항목 가져오기 */
		if(reportType == 'GRID') {
			var columnsXml = SmartXMLUtil.getChildNode(SmartXMLUtil.getChildNode(SmartXMLUtil.getChildNode(resultXml, 'content'), 'Gadget'), 'columns');
			var columnXml  = SmartXMLUtil.getChildNodes(columnsXml, 'column');
			for(var i=0; i<columnXml.length; i++) {
				var columnId = columnXml[i].getAttribute('id');
				for(var k=0; k<FormFieldArr.length; k++) {
					if(FormFieldArr[k][0] == columnId) {
						selectedFieldId 	= FormFieldArr[k][0];
						selectedFieldName 	= FormFieldArr[k][1];
						selectedFieldType 	= FormFieldArr[k][2];
						selectedFormatType 	= FormFieldArr[k][4];
						reportFieldAddGrid();
					}
				}
			}
		}
		/* 매트릭스 일 경우 저장한 항목 가져오기 X축 가져오기 */
		if(reportType == 'MATRIX') {
			var xAxisInfoXml = SmartXMLUtil.getChildNode(SmartXMLUtil.getChildNode(SmartXMLUtil.getChildNode(resultXml, 'content'), 'Gadget'), 'xAxisInfo');
			var axisXml  	 = SmartXMLUtil.getChildNodes(xAxisInfoXml, 'axis');
			
			var X1AxisSelect = document.getElementById("X1Axis");
			x1AxisChange(axisXml[0].getAttribute('id'));
			for(var k=0; k<X1AxisSelect.length; k++) {
				if(X1AxisSelect[k].value == axisXml[0].getAttribute('id')) {
					X1AxisSelect[k].selected = true;
				}
			}
			for(var k=0; k<FormFieldArr.length; k++) {
				if(FormFieldArr[k][0] == axisXml[0].getAttribute('id')) {
					form.X1AxisName.value 	= FormFieldArr[k][1];
				}
			}
			if(axisXml.length>1){
				var X2AxisSelect = document.getElementById("X2Axis");
				x2AxisChange(axisXml[1].getAttribute('id'));
				for(var k=0; k<X2AxisSelect.length; k++) {
					if(X2AxisSelect[k].value == axisXml[1].getAttribute('id')) {
						X2AxisSelect[k].selected = true;
					}
				}
				for(var k=0; k<FormFieldArr.length; k++) {
					if(FormFieldArr[k][0] == axisXml[1].getAttribute('id')) {
						form.X2AxisName.value 	= FormFieldArr[k][1];
					}
				}
			}
			var axisSubXml = SmartXMLUtil.getChildNode(axisXml[0], 'x1AxisSubInfo');
			var axisSubId = axisSubXml.firstChild.nodeValue;
			var axisSubNameXml = SmartXMLUtil.getChildNode(axisXml[0], 'name');
			var axisSubName = axisSubNameXml.firstChild.nodeValue;
			var x1A1Select = document.getElementById('x1A1');
			var x1A2Select = document.getElementById('x1A2');
			if(axisSubId!=''){
				for(var k=0; k < x1A1Select.length; k++){
					if(x1A1Select[k].value == axisSubId) {
						x1A1Select[k].selected = true;
					}
				}
				
				for(var k=0; k < x1A2Select.length; k++){
					if(x1A2Select[k].value == axisSubId) {
						x1A2Select[k].selected = true;
					}
				}
				form.X1AxisName.value = axisSubId;
				form.X1AxisSub.value = axisSubName;
			}
			
			var axis2SubXml = SmartXMLUtil.getChildNode(axisXml[1], 'x2AxisSubInfo');
			var axis2SubId = axis2SubXml.firstChild.nodeValue;
			
			var axis2SubNameXml = SmartXMLUtil.getChildNode(axisXml[1], 'name');
			var axis2SubName = axis2SubNameXml.firstChild.nodeValue;
			
			var x2A1Select = document.getElementById('x2A1');
			var x2A2Select = document.getElementById('x2A2');
			if(axis2SubId!=''){
				for(var k=0; k < x2A1Select.length; k++){
					if(x2A1Select[k].value == axis2SubId) {
						x2A1Select[k].selected = true;
					}
				}
				
				for(var k=0; k < x2A2Select.length; k++){
					if(x2A2Select[k].value == axis2SubId) {
						x2A2Select[k].selected = true;
					}
				}
				form.X2AxisName.value = axis2SubId;
				form.X2AxisSub.value = axis2SubName;
			}
			
			
			/* Y축 가져오기 */
			var yAxisInfoXml = SmartXMLUtil.getChildNode(SmartXMLUtil.getChildNode(SmartXMLUtil.getChildNode(resultXml, 'content'), 'Gadget'), 'yAxisInfo');
			var axisXml  	 = SmartXMLUtil.getChildNodes(yAxisInfoXml, 'axis');
			var yAxisNameXml = SmartXMLUtil.getChildNode(axisXml[0], 'name');
			var yAxisName = yAxisNameXml.firstChild.nodeValue;
			form.Y1AxisName.value = yAxisName;
			var y2AxisNameXml = SmartXMLUtil.getChildNode(axisXml[1], 'name');
			var y2AxisName = y2AxisNameXml.firstChild.nodeValue;
			form.Y2AxisName.value = y2AxisName;
			var Y1AxisSelect = document.getElementById("Y1Axis");
			for(var k=0; k<Y1AxisSelect.length; k++) {
				if(Y1AxisSelect[k].value == axisXml[0].getAttribute('id')) {
					Y1AxisSelect[k].selected = true;
				}
			}
			for(var k=0; k<FormFieldArr.length; k++) {
				if(FormFieldArr[k][0] == axisXml[0].getAttribute('id')) {
					form.Y1AxisName.value 	= FormFieldArr[k][1];
				}
			}
			if(axisXml.length>1){
				var Y2AxisSelect = document.getElementById("Y2Axis");
				for(var k=0; k<Y2AxisSelect.length; k++) {
					if(Y2AxisSelect[k].value == axisXml[1].getAttribute('id')) {
						Y2AxisSelect[k].selected = true;
					}
				}
				for(var k=0; k<FormFieldArr.length; k++) {
					if(FormFieldArr[k][0] == axisXml[1].getAttribute('id')) {
						form.Y2AxisName.value 	= FormFieldArr[k][1];
					}
				}
			}
			

			/* measure */
			var measureInfoXml = SmartXMLUtil.getChildNode(SmartXMLUtil.getChildNode(SmartXMLUtil.getChildNode(resultXml, 'content'), 'Gadget'), 'measureInfo');
			var measureXml     = SmartXMLUtil.getChildNodes(measureInfoXml, 'measure');
			var functionType = SmartXMLUtil.getChildNode(measureXml[0], 'filter').getAttribute('functionType');
			var matrixValueSelect = document.getElementById("matrixValue");
			matrixValueChange(measureXml[0].getAttribute('id'));
			
			for(var k=0; k<matrixValueSelect.length; k++) {
				if(matrixValueSelect[k].value == measureXml[0].getAttribute('id')) {
					matrixValueSelect[k].selected = true;
					selectBoxfunction(matrixValueSelect[k].value,'matrixValue','MATRIX');
				}
			}
			for(var k=0; k<FormFieldArr.length; k++) {
				if(FormFieldArr[k][0] == measureXml[0].getAttribute('id')) {
					form.matrixValueName.value 	= FormFieldArr[k][1];
					form.matrixValueType.value 	= FormFieldArr[k][2];
					form.matrixValueFormatType.value 	= FormFieldArr[k][4];
				}
			}
			var functionTypeSelect = document.getElementsByName("matrixValueFunction");
			for(var k=0; k<functionTypeSelect.length; k++) {
				if(functionTypeSelect[k].value == functionType) {
					functionTypeSelect[k].selected = true;
				}
			}
			
			var measureXmlSubInfoXml = SmartXMLUtil.getChildNode(measureXml[0], 'measureSubInfo');
			//alert(remarkSubInfoXml.xml);
			var measureXmlSubInfoId = measureXmlSubInfoXml.firstChild.nodeValue;
			var measureNameXml = SmartXMLUtil.getChildNode(measureXml[0], 'name');
			var measureName = measureNameXml.firstChild.nodeValue;
			var matrixValueA1 = document.getElementById('matrixValueA1');
			var matrixValueA2 = document.getElementById('matrixValueA2');
			if(measureXmlSubInfoId!=''){
				for(var k=0; k < matrixValueA1.length; k++){
					if(matrixValueA1[k].value == measureXmlSubInfoId) {
						matrixValueA1[k].selected = true;
					}
				}
				
				for(var k=0; k < matrixValueA2.length; k++){
					if(matrixValueA2[k].value == measureXmlSubInfoId) {
						matrixValueA2[k].selected = true;
					}
				}
				form.matrixValueSub.value = measureName;
				form.matrixValueName.value = measureXmlSubInfoId;
			}
			
			
		}
		/*차트일 경우 Y축 */
		if(reportType != 'MATRIX' && reportType != 'GRID') {
			var valueInfoXml = SmartXMLUtil.getChildNode(SmartXMLUtil.getChildNode(SmartXMLUtil.getChildNode(resultXml, 'content'), 'Gadget'), 'valueInfo');
			var valueInfoId  = valueInfoXml.getAttribute('id');
			var functionType = SmartXMLUtil.getChildNode(valueInfoXml, 'filter').getAttribute('functionType');

			var valueNameXml = SmartXMLUtil.getChildNode(valueInfoXml, 'name');
			var valueName = valueNameXml.firstChild.nodeValue;
			
			var YAxisSelect = document.getElementById("YAxis");
			for(var k=0; k<YAxisSelect.length; k++) {
				//alert(YAxisSelect[k].value +'////'+ valueInfoId);
				if(YAxisSelect[k].value == valueInfoId) {
					YAxisSelect[k].selected = true;
					selectBoxfunction(YAxisSelect[k].value,'YAxis','CHART');
				}
			}
			for(var k=0; k<FormFieldArr.length; k++) {
				if(FormFieldArr[k][0] == valueInfoId) {
					form.YAxisName.value 	= FormFieldArr[k][1];
					form.YAxisType.value 	= FormFieldArr[k][2];
					form.YAxisFormatType.value 	= FormFieldArr[k][4];
				}
			}
			var functionTypeSelect = document.getElementsByName("YAxisFunction");
			for(var k=0; k<functionTypeSelect.length; k++) {
				if(functionTypeSelect[k].value == functionType) {
					functionTypeSelect[k].selected = true;
				}
			}
			
			if(form.YAxisName.value == ''){
				//alert(valueName);
				form.YAxisName.value = valueName;
			}
			

			/* X축 */
			var groupInfoXml = SmartXMLUtil.getChildNode(SmartXMLUtil.getChildNode(SmartXMLUtil.getChildNode(resultXml, 'content'), 'Gadget'), 'groupInfo');
			var groupInfoId  = groupInfoXml.getAttribute('id');
			
			xAxisChange(groupInfoId);
			var XAxisSelect = document.getElementById("XAxis");
			for(var k=0; k<XAxisSelect.length; k++) {
				if(XAxisSelect[k].value == groupInfoId) {
					XAxisSelect[k].selected = true;
				}
			}
			for(var k=0; k<FormFieldArr.length; k++) {
				if(FormFieldArr[k][0] == groupInfoId) {
					form.XAxisName.value 	= FormFieldArr[k][1];
				}
			}
			
			var groupSubInfoXml = SmartXMLUtil.getChildNode(groupInfoXml, 'groupSubInfo');
			var groupSubInfoId = groupSubInfoXml.firstChild.nodeValue;
			
			var groupSubNameXml = SmartXMLUtil.getChildNode(groupInfoXml, 'name');
			var groupSubName = groupSubNameXml.firstChild.nodeValue;
			
			var xA1Select = document.getElementById('xA1');
			var xA2Select = document.getElementById('xA2');
			if(groupSubInfoId!=''){
				for(var k=0; k < xA1Select.length; k++){
					if(xA1Select[k].value == groupSubInfoId) {
						xA1Select[k].selected = true;
					}
				}
				
				for(var k=0; k < xA2Select.length; k++){
					if(xA2Select[k].value == groupSubInfoId) {
						xA2Select[k].selected = true;
					}
				}
				form.XAxisName.value = groupSubInfoId;
				form.XAxisSub.value = groupSubName;
			}
			
			
			/* measure */
			var remarkXml = SmartXMLUtil.getChildNode(SmartXMLUtil.getChildNode(SmartXMLUtil.getChildNode(resultXml, 'content'), 'Gadget'), 'remark');
			var remarkId  = remarkXml.getAttribute('id');
			zAxisChange(remarkId);
			var ZAxisSelect = document.getElementById("ZAxis");
			for(var k=0; k<ZAxisSelect.length; k++) {
				if(ZAxisSelect[k].value == remarkId) {
					ZAxisSelect[k].selected = true;
				}
			}
			for(var k=0; k<FormFieldArr.length; k++) {
				if(FormFieldArr[k][0] == remarkId) { 
					form.ZAxisName.value 	= FormFieldArr[k][1];
				}
			}
			
			var remarkSubInfoXml = SmartXMLUtil.getChildNode(remarkXml, 'remarkSubInfo');
			//alert(remarkSubInfoXml.xml);
			var remarkSubInfoId = remarkSubInfoXml.firstChild.nodeValue;
			
			var remarkSubNameXml = SmartXMLUtil.getChildNode(remarkXml, 'name');
			var remarkSubName = remarkSubNameXml.firstChild.nodeValue;
			
			
			var zA1Select = document.getElementById('zA1');
			var zA2Select = document.getElementById('zA2');
			if(remarkSubInfoId!=''){
				for(var k=0; k < zA1Select.length; k++){
					if(zA1Select[k].value == remarkSubInfoId) {
						zA1Select[k].selected = true;
					}
				}
				
				for(var k=0; k < zA2Select.length; k++){
					if(zA2Select[k].value == remarkSubInfoId) {
						zA2Select[k].selected = true;
					}
				}
				form.ZAxisSub.value = remarkSubName;
				form.ZAxisName.value = remarkSubInfoId;
			}
			
			
		}
	}
}

function chartTypeChangeNew() {
	if(reportForm.chartTypes.value == "COLUMN_CHART"){
        document.getElementById("chartZAxis").style.display = "";
	} else if(reportForm.chartTypes.value == "BAR_CHART"){
		document.getElementById("chartZAxis").style.display = "";
	} else if(reportForm.chartTypes.value == "LINE_CHART"){
		document.getElementById("chartZAxis").style.display = "";
	} else if(reportForm.chartTypes.value == "AREA_CHART"){
		document.getElementById("chartZAxis").style.display = "";
	} else if(reportForm.chartTypes.value == "PIE_CHART"){
		document.getElementById("chartZAxis").style.display = "none";
    }
}

function addFilterReport(){
	if(document.getElementById("filterTable").style.display=='none'){
		document.getElementById("filterTable").style.display='';
		var filterSelect = document.getElementsByName("filterSelect");
		if (filterSelect.length == 0) {
			conditionAdd();
		}
	}else{
		document.getElementById("filterTable").style.display='none';
	}
}


//메인 대쉬보드 개발전 체크가 한가지만 되도록 해주는 부분 20100917_Ksy
function selectDashBoardType(value){
	var types = document.getElementsByName("reportDashboardType");
	if(value=='default'){
		if(types[0].checked){
			if(types[1].checked){
				types[1].checked='';
			}
		}
	}else if(value=='main'){
		if(types[1].checked){
			if(types[0].checked){
				types[0].checked='';
			}
		}
	}
}

// jk 보고서 상세필터 추가.
var addReportFilterIdx = 0;
function addReportFilter() {
	addReportFilterIdx++;
	$('filterTable').show();
	var filterSelectValueArr = ["", "categoryId$string$업무카테고리", "workGroup$string$업무그룹", "workName$string$업무이름", "workType$string$업무타입", "workTitle$string$업무제목","projectName$string$프로젝트명", "isPublic$string$공개여부", "priority$string$중요도", "taskName$string$태스크명", "tskAssignee$string$담당자", "assigneeDept$string$담당자부서", "tskAssignDate$string$할당일", "tskPerformer$string$처리자", "performerDept$string$처리자부서", "tskExecuteDate$date$업무처리시간", "tskType$string$업무타입", "tskStatus$string$업무상태", "tskExpectStartDate$date$예정시작시간", "tskExpectEndDate$date$예정종료시간", "tskRealStartDate$date$실제시작시간", "tskRealEndDate$date$실제종료시간"];
	var filterSelectNameArr = "";
	var searchKeyArr = ["","=","!=","like"];
	var searchKeyArrName = ["","같음","같지 않음","포함"];
	var imageDir = "";
	if(defaultLanguage == "KOR") {
		filterSelectNameArr = ["", "업무카테고리", "업무그룹", "업무이름", "업무타입", "업무제목", "프로젝트명", "공개여부", "중요도", "태스크명", "담당자", "담당자부서", "할당일", "처리자", "처리자부서", "업무처리시간", "업무타입", "업무상태", "예정시작시간", "예정종료시간", "실제시작시간", "실제종료시간"];
		imageDir = "/";
		searchKeyArrName = ["","같음","같지 않음","포함"];
	} else {
		filterSelectNameArr = ["", "Work Category", "Work Group", "Work Definition Name", "Work Type", "Work Title", "Project Name", "Open to the Public?", "Priority", "Task Name", "Person In Charge", "Personnel Department", "Assigned Date", "Performer", " Performer Department", "Work Procesing Time", "Work Procesing Type", "Work Procesing Status", "Planned Start Time", "Planned Finish Time", "Real Start Time", "Real Finish Time"];
		imageDir = "ENG/";
		searchKeyArrName = ["","=","!=","like"];
	}
	var tbody = document.getElementById("filterTbody");
	var tr = document.createElement("tr");
	var td1 = document.createElement("td");
	var select = createSelectElement("filterSelect", '120');
	select.setAttribute("onchange","filterChange(this.value,'filterTextTd"+addReportFilterIdx+"','"+imageDir+"')");
	
	createOptions(select, filterSelectValueArr, filterSelectNameArr);
	td1.appendChild(select);
	var td2 = document.createElement("td");
	select = createSelectElement('operator', '120');
	createOptions(select, searchKeyArr, searchKeyArrName);
	td2.appendChild(select);
	var td3 = document.createElement("td");
	td3.setAttribute("id", "filterTextTd"+addReportFilterIdx);
	var input1 = createInputElement('text', 'filterSearchWord', '', '120');
		input1.setAttribute("class","input");
		input1.setAttribute('id','filterSearchWordfilterTextTd'+addReportFilterIdx);
	var img1 = document.createElement("img");
		img1.setAttribute("src", "../images/"+imageDir+"btn_del.gif");
		img1.setAttribute("style", "cursor: pointer; vertical-align: middle;");
		img1.setAttribute("onclick","removeFilter(this);");
	td3.appendChild(input1);
	td3.appendChild(img1);

	td1.setAttribute("style","border:0;");
	td2.setAttribute("style","border:0;");
	td3.setAttribute("style","border:0;");
	
	tr.appendChild(td1);
	tr.appendChild(td2);
	tr.appendChild(td3);

	tbody.appendChild(tr);
}

function chartSelect(){
	if(reportForm.chartTypes.value == "COLUMN_CHART"){
	    send("../report/sample/chartSample.jsp?type=COLUMN_CHART","reportSample");
	} else if(reportForm.chartTypes.value == "BAR_CHART"){
	    send("../report/sample/chartSample.jsp?type=BAR_CHART","reportSample");
	} else if(reportForm.chartTypes.value == "LINE_CHART"){
	    send("../report/sample/chartSample.jsp?type=LINE_CHART","reportSample");
	} else if(reportForm.chartTypes.value == "AREA_CHART"){
	    send("../report/sample/chartSample.jsp?type=AREA_CHART","reportSample");
	} else if(reportForm.chartTypes.value == "PIE_CHART"){
	    send("../report/sample/chartSample.jsp?type=PIE_CHART","reportSample");
	}
}
function changeChartWork(value){
	if(value == 'one'){
		$('treeSpan').show();
	}else{
		$('treeSpan').hide();
	}
	$('checkType').value = value;
}

function showReportPage(page){
	var params = new Array();
	params.push("nextPage="+page);
	params = params.join("&");
	update("../report/reportInsert_new.jsp","mainTd",params);
}


function changeFormCallBackPrc() {
	$('periodTable').show();
	var form = document.reportForm;
	var reportType = form.reportTypehidden.value;
	var selectBoxX = '';
	var selectBoxY = '';
	var selectBoxZ = '';
	var selectBoxX1 = '';
	var selectBoxX2 = '';
	var selectBoxY1 = '';
	var selectBoxY2 = '';
	var matrixValue = '';
	
	selectBoxX = document.getElementById("XAxis");
	selectBoxY = document.getElementById("YAxis");
	selectBoxZ = document.getElementById("ZAxis");
	selectBoxX1 = document.getElementById("X1Axis");
	selectBoxX2 = document.getElementById("X2Axis");
	matrixValue = document.getElementById("matrixValue");
	selectBoxY1 = document.getElementById("Y1Axis");
	selectBoxY2 = document.getElementById("Y2Axis");
	
	removeAllOptions(selectBoxX);
	removeAllOptions(selectBoxY);
	removeAllOptions(selectBoxZ);
	removeAllOptions(selectBoxX1);
	removeAllOptions(selectBoxX2);
	removeAllOptions(selectBoxY1);
	removeAllOptions(selectBoxY2);
	removeAllOptions(matrixValue);

	var valueArr = [];
	var nameArr = [];
	
	if(defaultLanguage == 'KOR'){
		valueArr = ['','x1','x2','x3','x4'];
		nameArr = ['','업무처리 기간','업무처리 담당자','업무이름','업무처리 유형'];
	}else{
		valueArr = ['','x1','x2','x3','x4'];
		nameArr = ['','업무처리 기간','업무처리 담당자','업무이름','업무처리 유형'];
	}
		
	createOptions(selectBoxX, valueArr, nameArr);
	createOptions(selectBoxX1, valueArr, nameArr);
	createOptions(selectBoxX2, valueArr, nameArr);
	valueArr = ['','z1','z2','z3','z4'];
	createOptions(selectBoxZ, valueArr, nameArr);
	createOptions(matrixValue, valueArr, nameArr);
	
	valueArr = ['','y1','y2','y3','y4','y5','y6','y7'];
	nameArr = ['','총 처리건수','총 처리시간','평균 처리건수','평균 처리시간','최소 처리건수','최대 처리건수','최대 처리시간'];

	createOptions(selectBoxY, valueArr, nameArr);
	
	createOptions(selectBoxY1, valueArr, nameArr);
	createOptions(selectBoxY2, valueArr, nameArr);
	
	removeAllRow(1, document.getElementById("GridNoUseList"));
	removeAllRow(1, document.getElementById("GridUseList"));
	
	$('XAxisSpan').hide();	
	
	selectedObj = null;
	selectedFieldId = null;
	selectedFieldName = null;
	selectedFieldType = null;
	selectedFormatType = null;
	selectDataFieldCnt = 0;
	fieldArr = new Array();

}


function periodChange(value){
	if(value == 'specified'){
		$('periodSpan').show();
	}else{
		$('periodSpan').hide();
	}
	$('period').value = value;
}

function xAxisChange(value){
	if(value == 'x1'){
		$('xA2').hide();
		$('XAxisSpan').hide();
		$('XAxisText').hide();
		$('xA1').show();
	}else if(value == 'x2'){
		$('xA1').hide();
		$('XAxisText').hide();
		$('xA2').show();
		$('XAxisSpan').show();
	}else if(value == 'x3'){
		$('xA1').hide();
		$('XAxisText').hide();
		$('xA2').hide();
		$('XAxisSpan').show();
		document.reportForm.XAxisName.value=value;
	}else if(value == 'x4'){
		$('xA1').hide();
		$('xA2').hide();
		$('XAxisSpan').hide();
		$('XAxisText').show();
		document.reportForm.XAxisName.value=value;
	}
}

function zAxisChange(value){
	if(value == 'z1'){
		$('zA2').hide();
		$('ZAxisSpan').hide();
		$('ZAxisText').hide();
		$('zA1').show();
	}else if(value == 'z2'){
		$('zA1').hide();
		$('ZAxisText').hide();
		$('zA2').show();
		$('ZAxisSpan').show();
	}else if(value == 'z3'){
		$('zA1').hide();
		$('ZAxisText').hide();
		$('zA2').hide();
		$('ZAxisSpan').show();
		document.reportForm.ZAxisName.value=value;
	}else if(value == 'z4'){
		$('zA1').hide();
		$('zA2').hide();
		$('ZAxisSpan').hide();
		$('ZAxisText').show();
		document.reportForm.ZAxisName.value=value;
	}
}

function x1AxisChange(value){
	if(value == 'x1'){
		$('x1A2').hide();
		$('X1AxisSpan').hide();
		$('X1AxisText').hide();
		$('x1A1').show();
	}else if(value == 'x2'){
		$('x1A1').hide();
		$('X1AxisText').hide();
		$('x1A2').show();
		$('X1AxisSpan').show();
	}else if(value == 'x3'){
		$('x1A1').hide();
		$('X1AxisText').hide();
		$('x1A2').hide();
		$('X1AxisSpan').show();
		document.reportForm.X1AxisName.value=value;
	}else if(value == 'x4'){
		$('x1A1').hide();
		$('x1A2').hide();
		$('X1AxisSpan').hide();
		$('X1AxisText').show();
		document.reportForm.X1AxisName.value=value;
	}
}

function x2AxisChange(value){
	if(value == 'x1'){
		$('x2A2').hide();
		$('X2AxisSpan').hide();
		$('X2AxisText').hide();
		$('x2A1').show();
	}else if(value == 'x2'){
		$('x2A1').hide();
		$('X2AxisText').hide();
		$('x2A2').show();
		$('X2AxisSpan').show();
	}else if(value == 'x3'){
		$('x2A1').hide();
		$('X2AxisText').hide();
		$('x2A2').hide();
		$('X2AxisSpan').show();
		document.reportForm.X2AxisName.value=value;
	}else if(value == 'x4'){
		$('x2A1').hide();
		$('x2A2').hide();
		$('X2AxisSpan').hide();
		$('X2AxisText').show();
		document.reportForm.X2AxisName.value=value;
	}
}


function matrixValueChange(value){
	if(value == 'z1'){
		$('matrixValueA2').hide();
		$('matrixValueSpan').hide();
		$('matrixValueText').hide();
		$('matrixValueA1').show();
	}else if(value == 'z2'){
		$('matrixValueA1').hide();
		$('matrixValueText').hide();
		$('matrixValueA2').show();
		$('matrixValueSpan').show();
	}else if(value == 'z3'){
		$('matrixValueA1').hide();
		$('matrixValueText').hide();
		$('matrixValueA2').hide();
		$('matrixValueSpan').show();
		document.reportForm.matrixValueName.value=value;
	}else if(value == 'z4'){
		$('matrixValueA1').hide();
		$('matrixValueA2').hide();
		$('matrixValueSpan').hide();
		$('matrixValueText').show();
		document.reportForm.matrixValueName.value=value;
	}
}


function filterChange(option, id, imgDir){
	var td = $(id);
	td.innerHTML = "";
	var input = document.createElement('input');
	input.setAttribute('type','text');
	input.setAttribute('class','input');
	input.setAttribute('name','filterSearchWord');
	input.setAttribute('id','filterSearchWord'+id);
	input.setAttribute('style','width:120px;');
	
	var img1 = document.createElement("img");
	img1.setAttribute("src", "../images/"+imgDir+"btn_del.gif");
	img1.setAttribute("style", "cursor: pointer; vertical-align: middle;");
	img1.setAttribute("onclick","removeFilter(this);");
	if(option.indexOf('$date$')>-1){
		input.setAttribute('style','width:120px;cursor:pointer;');
		input.setAttribute('onclick','searchDate("filterSearchWord'+id+'","0")');
	}
	td.appendChild(input);
	if(id!='filterTextTd')
		td.appendChild(img1);
}
function x2A12xisChange(opt, flag){
	var x1AxisName = document.reportForm.X1AxisName.value;
	var x2AxisName = document.reportForm.X2AxisName.value;	
	if(flag == 'true'){
		if(opt.substring(1) == x2AxisName.substring(1)){
			$('X1Axis').selectedIndex = 0;
			$('x1A1').selectedIndex = 0;
			$('x1A2').selectedIndex = 0;
			document.reportForm.X1AxisName.value="";
			document.reportForm.X1AxisSub.value = "";
			warnMessage('Equal', 'x1AxisX2AxisDifferent');
			return;
		}
	}else{
		if(opt.substring(1) == x1AxisName.substring(1)){
			$('X2Axis').selectedIndex = 0;
			$('x2A1').selectedIndex = 0;
			$('x2A2').selectedIndex = 0;
			document.reportForm.X2AxisName.value="";
			document.reportForm.X2AxisSub.value = "";
			warnMessage('Equal', 'x1AxisX2AxisDifferent');
			return;
		}
	}
}
 
function y2AxisChange(opt, flag){
	var y1AxisName = document.reportForm.Y1AxisName.value;
	var y2AxisName = document.reportForm.Y2AxisName.value;
	
	if(flag == 'true'){
		if(opt == y2AxisName){
			$('Y1Axis').selectedIndex = 0;
			document.reportForm.Y1AxisName.value="";
			warnMessage('Equal', 'y1AxisY2AxisDifferent');
			return;
		}
	}else{
		if(opt == y1AxisName){
			$('Y2Axis').selectedIndex = 0;
			document.reportForm.Y2AxisName.value="";
			warnMessage('Equal', 'y1AxisY2AxisDifferent');
			return;
		}
	}
}
function zAChange(opt, flag){
	var xAxisName = document.reportForm.XAxisName.value;
	var zAxisName = document.reportForm.ZAxisName.value;
	if(flag == 'true'){
		if(opt.substring(1) == zAxisName.substring(1)){
			$('XAxis').selectedIndex = 0;
			$('xA1').selectedIndex = 0;
			$('xA2').selectedIndex = 0;
			document.reportForm.XAxisName.value="";
			document.reportForm.XAxisSub.value="";
			warnMessage('Equal', 'xAxisZAxisDifferent');
			return;
		}
	}else{
		if(opt.substring(1) == xAxisName.substring(1)){
			$('ZAxis').selectedIndex = 0;
			$('zA1').selectedIndex = 0;
			$('zA2').selectedIndex = 0;
			document.reportForm.ZAxisName.value="";
			document.reportForm.ZAxisSub.value="";
			warnMessage('Equal', 'xAxisZAxisDifferent');
			return;
		}
	}
}

function viewTypeCall(viewType){
	var chartTypeValue = $('chartTypeValue').getValue();
	if(chartTypeValue == ''){
		chartTypeValue = 'CHART';
		$('chartTypeValue').setValue('CHART');
	}else if(chartTypeValue == 'CHART'){
		chartTypeValue = 'MATRIX';
		$('chartTypeValue').setValue('MATRIX');
	}else if(chartTypeValue == 'MATRIX'){
		chartTypeValue = 'CHART';
		$('chartTypeValue').setValue('CHART');
	}
	var reportId = $('reportId').getValue();
	var gadgetType = $('gadgetType').getValue();
	var formId = $('formId').getValue();
	var chartDisplayArea = $('chartDisplayArea');
	if(gadgetType == "GRID") {
		send("../report/reportGrid.jsp", "chartDisplayArea", "formId="+formId+"&reportId="+reportId+"&targetTd=chartDisplayArea");
	} else {
		chartDisplayArea.innerHTML = "<iframe id='chartIframe' width='716' height='500' frameborder='0' marginheight='0' marginwidth='0' scrolling='no' src='../report/reportChart.jsp?userId="+userId+"&reportId="+reportId+"&language="+defaultLanguage+"&viewType="+chartTypeValue+"'></iframe>";
	}
}