/**
 * Today Image location Information
 * @param divisionCode	: 중요도,프로세스,프로세스 구분
 * @param imgCode		: 이미지 구분
 * @return
 */
/*TODO
 * 
 * */
var getTodayImgControl = function (divisionCode,imgCode){
//	alert(divisionCode+'///'+ imgCode);
	var imgsrc = "";
	if(divisionCode=="importance"){
		switch(imgCode){
			case "H": imgsrc="../images/label_high.gif";
				break;
			default : imgsrc="";
				break; 
		}
	}else if(divisionCode=="process"){
		switch(imgCode){
		case "SINGLE": imgsrc="../images/icon/package/ic_information.gif";
			break;  
		case "APPROVAL" : imgsrc="../images/type_pro_del.gif";
			break;
		case "REFERENCE" : imgsrc="../images/type_inf_del_ref.gif"; 
			break;
		case "COMMON" : imgsrc="../images/icon/package/ic_process.gif";
			break;
		case "PRCAPPROVAL" : imgsrc="../images/icon/taskType/type_pro_sub.gif";
			break;
		case "FRMAPPROVAL" : imgsrc="../images/icon/taskType/type_inf_sub.gif";
			break;
		case "COLORINFO" : imgsrc="../images/body/ico_color_info.gif";
			break;
		case "COLORPROCESS" : imgsrc="../images/body/ico_color_process.gif";
			break;
		case "COLORSCHEDULE" : imgsrc="../images/body/ico_color_schedule.gif";
			break;
		case "GRAYINFO" : imgsrc="../images/body/ico_gray_info.gif";
			break;
		case "GRAYPROCESS" : imgsrc="../images/body/ico_gray_process.gif";
			break;
		case "GRAYSCHEDULE" : imgsrc="../images/body/ico_gray_schedule.gif";
			break;	
		case "4" : imgsrc="../images/type_pro_sub.gif";
			break;
		case "5" : imgsrc="../images/ype_pro_rec.gif";
			break;
		case "6" : imgsrc="../images/type_pro_ref.gif";
			break;
		case "7" : imgsrc="../images/type_inf_del_rec.gif";
			break;
		case "8" : imgsrc="../images/type_pro_del_rec.gif";
			break;
		case "9" : imgsrc="../images/type_inf_del_ref.gif";
			break;
		case "10" : imgsrc="../images/type_pro_del_ref.gif";
			break;
		case "11" : imgsrc="../images/type_inf_sub_rec.gif";
			break;
		case "12" : imgsrc="../images/type_pro_sub_rec.gif";
			break;
		case "13" : imgsrc="../images/type_inf_sub_ref.gif";
			break;
		case "14" : imgsrc="../images/type_pro_sub_ref.gif";
			break;
		default : imgsrc="";
			break;
		}
	}else if(divisionCode=="dept"){
		switch(imgCode){
		case "TEAM" : imgsrc="../images/ico_team.gif";
			break;
		case "DEPT" : imgsrc="../images/ico_depart.gif";
			break;
		default : imgsrc="../images/ico_team.gif";
			break;
		}
	}else if(divisionCode == "status"){
		
		switch(imgCode){
		case "GOING" : imgsrc="../images/cstate_going.gif";
			break;
		case "DELAY" : imgsrc="../images/cstate_delay.gif";
			break;
		case "COMPLETE" : imgsrc="../images/cstate_complete.gif";
			break;
		case "SCHEDULE" : imgsrc="../images/cstate_yet.gif";
			break;
		case "RETURN" : imgsrc="../images/cstate_return.gif";
			break;
		default : imgsrc="../images/cstate_going.gif";
			break;
		}
	}
	return imgsrc;
}

/**
 * today scheduled tasks DIV control
 * 
 * @param element : 선택된 DIV id element
 * @return
 */
var prearrangedDivControl = function(pageNo,element, pagingDivid){
	var listTdItems = jQuery(element).select('td');
	var imageId     = element.substr(0, element.length-3) + "Tb";
	var listTrItems = $(element).select('tr');
	
	if($(element).style.display == "" ){
		jQuery('#'+imageId).find('img').attr({src:'../images/btn_tabdown.gif',alt:'닫기'});
		new Effect.multiple(listTrItems, Effect.Fade);
		$(element).hide();
	}else{
		jQuery('#'+imageId).find('img').attr({src:'../images/btn_tabup.gif',alt:'열기'});
		getIntendedTasks(pageNo ,element , pagingDivid);
		//new Effect.multiple(listTrItems, Effect.Appear);
		new Effect.SlideDown(element);
		$(element).show();
	}
}

/**
 * intended Work list Call<kor>예정된업무</kor>
 * 
 * @param intendedType	: "이번주, 다음주, 2주후, 3추후"
 * @return
 */
var functionName = "";
function getIntendedTasks(pageNo,workDivid, pageingDivid){
	if(pageNo != undefined){
		$('pageNo').value = pageNo;
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
			v_filterSearchUser = v_filterSearchUser + filterSearchUser[i].value+";";
		}
	}
	
	functionName = "getIntendedTasks";
	var params = new Array();
	params.push("method=intendedTasks");
	params.push("workDivid="+workDivid);
	params.push("pageingDivid="+pageingDivid);
	params.push("statusType=opened");
	params.push("searchWord=" + $F('searchWord'));
	params.push("filterSelect=" + v_filterSelect);
	params.push("filterSearchKey=" + v_filterSearchKey);
	params.push("filterSearchWord=" + v_filterSearchWord);
	params.push("filterSearchUser=" + v_filterSearchUser);
	params.push("pageNo=" + pageNo);
	params = params.join("&");
	linkUrl = getPath()+"/services/portal/todayService.jsp";
	request(linkUrl , params , setTodayTasksCallback , null , 'loading' , null , 'failed', false);
}

/**
 * <kor>진행중인 업무</kor>
 * @param pageNo
 * @return
 */
function inProgressWork(pageNo){
	if(pageNo != undefined){
		$('pageNo').value = pageNo;
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
			v_filterSearchUser = v_filterSearchUser + filterSearchUser[i].value+";";
		}
	}
	functionName = "inProgressWork";
	var params = new Array();
	params.push("method=inProgressWork");
	params.push("workDivid=inProgressWorkDiv");
	params.push("pageingDivid=pagingTd");
	params.push("statusType=opened");
	params.push("searchWord=" + $F('searchWord1'));
	params.push("filterSelect=" + v_filterSelect);
	params.push("filterSearchKey=" + v_filterSearchKey);
	params.push("filterSearchWord=" + v_filterSearchWord);
	params.push("filterSearchUser=" + v_filterSearchUser);
	params.push("pageNo=" + pageNo);
	params.push("pageSize=" + $F('pageSize'));
	
	params = params.join("&");
	linkUrl = getPath()+"/services/portal/todayService.jsp";
	request(linkUrl , params , setTodayTasksCallback , null , null , null , 'failed', false);
}

/**
 * <kor>지연된 업무</kor>
 * @param pageNo
 * @return
 */
function delayedWrok(pageNo){
	
	if(pageNo != undefined){
		$('pageNo').value = pageNo;
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
			v_filterSearchUser = v_filterSearchUser + filterSearchUser[i].value+";";
		}
	}
	
	functionName = "delayedWrok";
	var params = new Array();
	params.push("method=delayedTasks");
	params.push("workDivid=delayedTasksDiv");
	params.push("pageingDivid=delayedPagingDiv");
	params.push("statusType=opened");
	params.push("searchWord=" + $F('searchWord1'));
	params.push("filterSelect=" + v_filterSelect);
	params.push("filterSearchKey=" + v_filterSearchKey);
	params.push("filterSearchWord=" + v_filterSearchWord);
	params.push("filterSearchUser=" + v_filterSearchUser);
	params.push("pageNo=" + pageNo);
	params.push("pageSize=" + $F('pageSize'));
	
	params = params.join("&");
	
	linkUrl = getPath()+"/services/portal/todayService.jsp";
	request(linkUrl , params , setTodayTasksCallback , null , null , null , 'failed', false);
}


function setTodayTasksCallback(){
	var xmlDoc = getXmlDOM(getResult());
	var resultXml 		= SmartXMLUtil.getChildNode(xmlDoc, 'Result');
	var totalSize 		= resultXml.getAttribute("totalSize");
	var pageingDivid  	= resultXml.getAttribute('pageingDivid');
	var planTask     	= resultXml.getAttribute('planTask');
		
	var IE = document.all ? 1 : 0;
	var workDivid = "";
	if(IE){
		workDivid = resultXml.getElementsByTagName('workDivid').nextNode().text;
		//workDivid = resultXml.getElementsByTagName('workDivid')[0].text;
	} else {
		workDivid = resultXml.getElementsByTagName('workDivid')[0].textContent;
	}
	
	if(resultXml.getAttribute('status') == 'OK') {
		
		var intendedXml    = SmartXMLUtil.getChildNodes(resultXml, 'TodayTasks');
		var workDividXml   = SmartXMLUtil.getChildNodes(resultXml, 'workDivid');

		var theDiv    = $(workDivid);
		var theTbody  = theDiv.getElementsByTagName("tbody")[0];
		var theLength = theTbody.childNodes.length;
		for(var i=0;i< theLength; i++){
			theTbody.removeChild(theTbody.firstChild);
		}

		var divId = document.getElementById(workDivid);
		var tbody = divId.getElementsByTagName("tbody")[0];
		if(intendedXml.length > 0){
			for(var i = 0 ; i < intendedXml.length ; i ++){
				var taskId  			  = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(intendedXml[i], 'taskId'));
				var taskType  			  = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(intendedXml[i], 'taskType'));
				var imgTaskType			  = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(intendedXml[i], 'imgTaskType'));
				
				var priority  	 	      = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(intendedXml[i], 'priority'));
				var titleSummary		  = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(intendedXml[i], 'titleSummary'));
				var title  				  = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(intendedXml[i], 'title'));
				var processInstId 		  = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(intendedXml[i], 'processInstId'));
				var packageStatus 		  = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(intendedXml[i], 'packageStatus'));
				var formId		  		  = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(intendedXml[i], 'formId'));
				var referenceId 		  = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(intendedXml[i], 'referenceId'));
				var workName 	          = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(intendedXml[i], 'workName'));
				var realWorkName 	      = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(intendedXml[i], 'realWorkName'));
				var teams 	       	      = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(intendedXml[i], 'teams'));
				var expectStartDate		  = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(intendedXml[i], 'expectStartDate'));
				var expectEndDate		  = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(intendedXml[i], 'expectEndDate'));
				var realStartDate 		  = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(intendedXml[i], 'realStartDate'));
				var assignee 		      = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(intendedXml[i], 'assignee'));
				var realEndDate 		  = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(intendedXml[i], 'realEndDate'));
				var approvalType 		  = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(intendedXml[i], 'approvalType'));
				var workStatus   		  = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(intendedXml[i], 'workStatus'));
				
				var prcImgType = imgTaskType;
				
				if(expectStartDate == null){
					expectStartDate = "..";
				}
				if(realStartDate == null){
					realStartDate = "..";
				}
				var tr = null;
				
				if(imgTaskType == 'COMMON'){
					prcImgType = 'GRAYPROCESS';
				}else if(imgTaskType == 'GANTT'){
					prcImgType = 'GRAYSCHEDULE';
				}else if(imgTaskType == 'SINGLE'){
					prcImgType = 'GRAYINFO';
				}
				
				if (packageStatus == "DEPLOYED") {
					if(imgTaskType == 'COMMON'){
						prcImgType = 'COLORPROCESS';
					}else if(imgTaskType == 'GANTT'){
						prcImgType = 'COLORSCHEDULE';
					}else if(imgTaskType == 'SINGLE'){
						prcImgType = 'COLORINFO';
					}
					
					if(planTask == 11){
						if (formId.indexOf(";")>-1){
							tr = new Element('tr', { id: taskId+"tr", formId: formId}).observe('click', function() {planCreateProcInst(this)}).setStyle({ 'cursor':'pointer'});	
						} else {
							tr = new Element('tr', { id: taskId+"tr", taskId: taskId, processInstId: processInstId, taskType: taskType, referenceId: referenceId, formId: formId }).observe('click', function(){ viewMyTask(this); }).setStyle({ 'cursor': 'pointer' });
						}
					}else{
						if (formId.indexOf(";")>-1){
							var form = formId.split(";");
							tr = new Element('tr', { id: taskId+"tr", taskId: taskId, processInstId: processInstId, taskType: taskType, referenceId: referenceId, formId: form[1] }).observe('click', function(){ viewMyTask(this); }).setStyle({ 'cursor': 'pointer' });
						}else{
							tr = new Element('tr', { id: taskId+"tr", taskId: taskId, processInstId: processInstId, taskType: taskType, referenceId: referenceId, formId: formId }).observe('click', function(){ viewMyTask(this); }).setStyle({ 'cursor': 'pointer' });
						}
					}
				} else {
					if(planTask == 11){
						if (formId.indexOf(";")>-1){					
							tr = new Element('tr', { id: taskId+"tr", formId: formId}).observe('click', function() {planCreateProcInst(this)}).setStyle({ 'cursor':'pointer'});	
						} else {
							tr = new Element('tr', { id: taskId+"tr", taskId: taskId, processInstId: processInstId, taskType: taskType, referenceId: referenceId, formId: formId }).observe('click', function(){ viewMyTask(null); }).setStyle({ 'cursor': 'pointer' });
						}
					}else{
						if (formId.indexOf(";")>-1){
							var form = formId.split(";");
							tr = new Element('tr', { id: taskId+"tr", taskId: taskId, processInstId: processInstId, taskType: taskType, referenceId: referenceId, formId: form[1] }).observe('click', function(){ viewMyTask(this); }).setStyle({ 'cursor': 'pointer' });
						}else{
							tr = new Element('tr', { id: taskId+"tr", taskId: taskId, processInstId: processInstId, taskType: taskType, referenceId: referenceId, formId: formId }).observe('click', function(){ viewMyTask(this); }).setStyle({ 'cursor': 'pointer' });
						}
					}
				}
			
				var td0 = document.createElement("td");
				var td1 = document.createElement("td");
				var td2 = document.createElement("td");
				//var td3 = document.createElement("td");
				var td4 = document.createElement("td");
				var td5 = document.createElement("td");
				var td6 = document.createElement("td");
				var td7 = document.createElement("td");

				td0.setAttribute("style","text-align:center; color:#767676; padding:5px 0; width:25px;");
				td1.setAttribute("style","text-align:center; color:#767676; padding:5px 0; width:35px;");
				td2.setAttribute("style","text-align:left; color:#767676; padding:5px 0; ");
				//td3.setAttribute("style","text-align:left; color:#767676; padding:5px 0; width:20px;");
				td4.setAttribute("style","text-align:left; color:#767676; padding:5px 0; width:100px;");
				td5.setAttribute("style","text-align:left; color:#767676; padding:5px 0; width:150px;");
				td6.setAttribute("style","text-align:center; color:#767676; padding:5px 0; width:65px;");
				td7.setAttribute("style","text-align:center; color:#767676; padding:5px 0; width:65px;");

				
				var importanceImg = new Element('img', {src: this.getTodayImgControl("importance", priority )});							
				var processImg    = document.createElement("img");
				var deptImg       = document.createElement("img");
				var workStatusImg = new Element('img', {src: this.getTodayImgControl("status", workStatus )});
				processImg.setAttribute("style", "width:15px; height:16px; vertical-align:middle; margin:0;");
				
				if(approvalType == 'prc'){
					prcImgType = 'PRCAPPROVAL';
				}else if(approvalType == 'frm'){
					prcImgType = 'FRMAPPROVAL';
				}
				processImg.src 	  = this.getTodayImgControl("process", prcImgType );
				deptImg.src 	  =	this.getTodayImgControl("dept", assignee );
				deptImg.setAttribute('style','vertical-align:middle;');
				td1.setAttribute("style", "text-align:center;");
				td2.setAttribute("title", title);
				td2.setAttribute("alt", title);
				//td3.setAttribute("style", "text-align:right;");
				td4.setAttribute("style", "text-align:center;");
				td5.setAttribute("style", "text-align:center;");
				td5.setAttribute("title", realWorkName);
				td5.setAttribute("alt", realWorkName);
					
				td0.appendChild(workStatusImg);
				td1.appendChild(processImg);
				td2.appendChild(priority != "H" ? document.createTextNode(""):importanceImg);
				//td2.appendChild(document.createTextNode(titleSummary));
				td2.appendChild(document.createTextNode(title));
				//td3.appendChild(deptImg);
				td4.appendChild(deptImg);
				td4.appendChild(document.createTextNode(' '+teams));
				//td5.appendChild(document.createTextNode(workName));
				td5.appendChild(document.createTextNode(realWorkName));
				td6.appendChild(document.createTextNode(expectStartDate));

				if (workDivid == "delayedTasksDiv"){
					td7.appendChild(document.createTextNode(expectEndDate));
				} else {
					td7.appendChild(document.createTextNode(realStartDate));
				}
				
				tr.appendChild(td0);
				tr.appendChild(td1);
				tr.appendChild(td2);
				//tr.appendChild(td3);
				tr.appendChild(td4);
				tr.appendChild(td5);
				tr.appendChild(td6);
				tr.appendChild(td7);
				tbody.appendChild(tr);
			}
			var parameters = "\,'"+workDivid+"\',"+"\'"+pageingDivid+"\'";
			var params = new Array();
			params.push("totalSize=" + totalSize);
			params.push("pageSize=" + $F('pageSize'));
			params.push("pageNo=" + $F('pageNo'));
			params.push("funcName="+functionName);
			params.push("parameters="+parameters);
			params = params.join("&");
			send(getPath() + "/common/listPaging.jsp", pageingDivid , params);
			
		}else{
			var tr = document.createElement("tr");
			var td = document.createElement("td");
			
			td.setAttribute("colspan","8");
			td.setAttribute("style", "height:30px; padding-left: 15px");
			var userLanguage = $F("userLanguage");
			if(userLanguage == 'ENG'){
				td.appendChild(document.createTextNode("No Display List"));
			}else{
				td.appendChild(document.createTextNode("업무가 없습니다."));
			}
			tr.appendChild(td);
			tbody.appendChild(tr);
		}
	}
}


/*
 * Test 참조
 */
function duplicationcheckMessage(userName, userId, saveMode, type, duplicationCheck, tableId , messageType){
	var selectTheUser = document.getElementById(tableId);
	var tBody = selectTheUser.getElementsByTagName("tbody")[0];
	
	if(duplicationCheck != 'true') {
		var tr = document.createElement('tr');
		tr.id = userId + tableId + "_select_userTr";
		tr.setAttribute("height", 24);
		tr.style.cursor = "pointer";
		
		var td = document.createElement("td");
		td.setAttribute("bgColor" , "#FFFFFF");
		td.setAttribute("align" , "left");
		td.style.padding = "5";
		td.id = userId + tableId + "_select_Td";

		td.appendChild(document.createTextNode(userName));
		tr.appendChild(td);
		//tr.onclick = function(){eval("getDeptListClick('"+ userId +"','"+ type +"', this)")};
		tBody.appendChild(tr);
		getDeptListClick(userId, type, tr);
	} else {
		var message = '중복 되었습니다.';
		var messageTypeValue = "";
		
		if(messageType == 'DEPT') {
			messageTypeValue = 'Departmentisalreadyregistered'; //이미 등록된  부서입니다.
		} else {
			messageTypeValue = 'Userisalreadyregistered'; //이미 등록된  사용자입니다.
		}
		warnMessage(message , messageTypeValue);
	}
}