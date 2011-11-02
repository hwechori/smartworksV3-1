/*
 * 프로그램명  : /js/Potal.js
 * 최초	작성자 : 조형래
 * 최초	작성일 : 2008.06.04
 * 최종	수정자 :
 * 최종	수정일 :
 * 프로그램설명 : 홈에서 사용하는 자바스크립트 모음
 * =========================================================
 * Copyright (c) 2008 Maninsoft, Inc. All rights reserved.
 */
var prevMenu = null;
var prevGroup = null;
var prevGroupId = null;

var mainSelCatId = null;
var mainSelGroupId = null;
var setTimeCaster = null;

/*
 * 처리할 업무 건수를 업데이트 합니다 @param @return null
 */
var builderIndexYn;
function updateTaskCount() {
	var params = new Array();
	params.push("method=getTaskSize");
	params.push("countType=1");
	params.push("userId=" + userId);
	params.push("compId=" + compId);
	params = params.join("&");
	request(getPath() + "/services/portal/homeService.jsp", params,	updateTaskCountCallback);
}
function updateTaskCountCallback() {
	var xmlDoc = getXmlDOM(getResult());
	var resultXml = SmartXMLUtil.getChildNode(xmlDoc, 'Result');
	if (resultXml.getAttribute('status') == 'OK') {
		var totalSize = resultXml.getAttribute('totalSize');
		$('myToDoListCount').update(totalSize);
	}
}

/*
 내 업무함 메뉴 클릭
 @param obj : 메뉴 td object
 @param statusType : 내 업무함 상태 코드
 @return null
 */
function clickMenuMyTask(obj, statusType) {
	if (prevMenu != null && prevMenu != obj) {
		prevMenu.style.fontWeight = "";
	}
	prevMenu = obj;
	prevMenu.style.fontWeight = "bold";
	params = "&statusType=" + statusType;
	update("../myTask/myTaskList.jsp", "mainTd", params, updateListMyTask,
			"loading", "failed");
}

/*
 기본 메뉴(보고서, 일정) 클릭 : 기본업무에 속한(일정, 보고서)목록을 조회합니다.
 @param obj : 메뉴 td object
 @param linkUrl : 기본업무 링크 주소
 @return null
 */
function clickBaseWorkDef(obj, linkUrl) {
	if (prevMenu != null && prevMenu != obj) {
		prevMenu.style.fontWeight = "";
	}
	
	if(obj != null){
		prevMenu = obj;
		prevMenu.style.fontWeight = "bold";
	}

	if (linkUrl == "../report/reportList.jsp") { //보고서
		update(linkUrl, "mainTd", null, updateReportList, "loading", "failed");
	} else { //일정
		update(linkUrl, "mainTd", null, null, "loading", "failed");
	}
}

/*
 카테고리 클릭 : 홈 메뉴 카테고리에 속한 그룹과 업무 정의를 조회합니다.
 @param categoryId : 카테고리 아이디
 @return null
 */
function clickCategory(categoryId) {
	update("../main/leftMenuChild.jsp", "workCategoryTd", "categoryId="
			+ categoryId, null, "loading", "failed");
}

/*
 그룹 클릭 : 그룹에 속한 업무정의를 조회합니다
 @param obj : 그룹 td object
 @param groupId : 그룹 아이디
 @return null
 */
function clickGroup(obj, groupId) {
	if (prevMenu != null) {
		prevMenu.style.fontWeight = "";
	}

	if (prevGroup != null && prevGroup != obj) {
		prevGroup.style.fontWeight = "";
	}

	if (document.getElementById(prevGroupId + "WorkGroupList") != null
			&& document.getElementById(prevGroupId + "WorkGroupList") != document
					.getElementById(groupId + "WorkGroupList")) {
		document.getElementById(prevGroupId + "WorkGroupList").style.display = "none";
	}

	if (prevGroupId != null && prevGroupId != "")
		$(prevGroupId + "Icon").setAttribute("src",
				"../images/icon/category/group_plus.gif");

	if (groupId != null && groupId != "")
		$(groupId + "Icon").setAttribute("src",
				"../images/icon/category/group_minus.gif");

	if (prevGroupId == groupId)
		$(prevGroupId + "Icon").setAttribute("src",
				"../images/icon/category/group_plus.gif");

	prevGroup = obj;
	prevGroupId = groupId;
	prevGroup.style.fontWeight = "bold";

	if (document.getElementById(groupId + "WorkGroupList").style.display == "") {
		document.getElementById(groupId + "WorkGroupList").style.display = "none";
	} else {
		document.getElementById(groupId + "WorkGroupList").style.display = "";
	}
}

/*
 업무정의 클릭: 업무정의 목록을 조회합니다.
 @param obj : 메뉴 td object
 @param workDefType : 업무정의 종류(정보관리업무, 프로세스업무)
 @param workDefId : 업무정의 아이디(정보관리업무 아이디, 프로세스업무 아이디)
 @param groupChild : 기본업무 링크 주소
 @return null
 */
// function clickWorkDef(obj, workDefType, workDefId, groupChild) {
// if (prevMenu != null && prevMenu != obj) {
// prevMenu.style.fontWeight = "";
// }
// updateTaskCount();
// prevMenu = obj;
// //alert(obj);
// prevMenu.style.fontWeight = "bold";
// if (groupChild == "N") {
// if (prevGroup != null && prevGroup != obj) {
// prevGroup.style.fontWeight = "";
// if($(prevGroupId+"Icon")) {
// $(prevGroupId+"Icon").setAttribute("src",
// "../images/icon/category/group_plus.gif");
// } else {
// prevGroup = null;
// prevGroupId = null;
// }
// prevGroup = null;
// prevGroupId = null;
// }
// if (document.getElementById(prevGroupId+"WorkGroupList") != null) {
// document.getElementById(prevGroupId+"WorkGroupList").style.display = "none";
// }
// }
// if(workDefType == "SINGLE") {
// update("../form/formList.jsp", "mainTd", "id="+workDefId, updateListRecord,
// "loading", "failed");
// } else if(workDefType == "PROCESS") {
// update("../proc/procList.jsp", "mainTd", "processId="+workDefId,
// updateListProcInst, "loading", "failed");
// }
// }
// jk yoon 수정. catId 추가.
//menuOnClick.add("javascript:location.href=\'../builder/builderIndex.jsp?pInfo=1\'"); 
 
function clickWorkDef(catId, groupId, workDefId, workDefType) {
	 //if(builderIndexYn == true){
	//	 location.href='../builder/tskIndex.jsp?catId='+catId+'&groupId='+groupId+'&workDefId='+workDefId+'&workDefType='+workDefType+'&hdTab='+hdTab+'&hdTabAuth='+hdTabAuth+'&hdTabLanguage='+hdTabLanguage;
	 //}else{
	 
	if ($('builderMenuTree').style.display != 'none') {
		$('builderMenuTree').hide();
	}

		mainSelCatId = catId;
		mainSelGroupId = groupId;
		builderStatusYn = false;
		var params = "id=" + workDefId;
		params += "&catId=" + catId;
		if (workDefType == "SINGLE") {
			$('pageNo').value='1';
			update("../form/formList.jsp", "mainTd", params, updateListRecord,
					null, "failed");
		} else if (workDefType == "PROCESS" || workDefType == "GANTT") {
				update("../proc/procList.jsp", "mainTd", "processId=" + workDefId+"&pkgType="+workDefType,
					updateListProcInst, null, "failed");
		}
		$('mainMenuTree').style.display = 'none';
	// }
}
///////////////////////////////////////////Demo/////////////////////////////////////////////////////////////////////////
function clickWorkDefDemo1(catId, groupId, workDefId, workDefType) {
		mainSelCatId = catId;
		mainSelGroupId = groupId;
		builderStatusYn = false;
		var params = "id=" + workDefId;
		params += "&catId=" + catId;
		if (workDefType == "SINGLE") {
			update("../form/formList.jsp", "mainTd", params, updateListRecord);
		} else if (workDefType == "PROCESS" || workDefType == "GANTT") {
			update("../proc/procList.jsp", "mainTd", "processId=" + workDefId,
					updateListProcInst);
		}
		$('mainMenuTree').style.display = 'none';
}
function clickWorkDefDemo(obj) {
	var catId = obj.getAttribute('catId');
	var groupId = obj.getAttribute('groupId');
	var workDefId = obj.getAttribute('workDefId');
	var workDefType = obj.getAttribute('workDefType');

	window.open("../demo/demoIndex.jsp?catId=" + catId + "&groupId="
			+ groupId + "&workDefId=" + workDefId + "&workDefType="
			+ workDefType+"&type=workCategoryDemo");
}
function clickWorkDefcategoryDemo(catId, groupId, workDefId, workDefType) {
	window.open("../demo/demoIndex.jsp?catId=" + catId + "&groupId="
			+ groupId + "&workDefId=" + workDefId + "&workDefType="
			+ workDefType +"&type=workCategoryDemo");
}
///////////////////////////////////////////Demo// //////////////////////////////////////////////////////////////////////
/*
 * 목록 정렬 : 목록을 새 항목으로 정렬합니다. @param type : 내업무함, 정보관리업무, 프로세스업무, 보고서 @param
 * order : 정렬 항목 @return null
 */
function updateListOrder(type, order) {

	var tdObj = document.getElementById(order + "Th");
	var trObj = tdObj.parentNode;
	if ($F('order') == order) {
		if ($F('isAsc') == "false") {
			document.listForm.isAsc.value = "true";
		} else {
			document.listForm.isAsc.value = "false";
		}
	} else {
		document.listForm.order.value = order;
		document.listForm.isAsc.value = "false";
	}
	var thNodes = trObj.getElementsByTagName("th");
	if (thNodes != null) {
		for ( var i = 0; i < thNodes.length; i++) {
			var thNode = thNodes[i]
			var imgNodes = thNode.getElementsByTagName("img");
			if (imgNodes != null) {
				for ( var k = imgNodes.length; k > 0; k--) {
					var imgNode = imgNodes[k - 1];
					if (imgNode.getAttribute("id") != "priorityImg") {
						thNode.removeChild(imgNode);
					}
				}
			}
		}
	}

	if ($F('isAsc') == "false") {
		var img = new Element('img', {
			src : '../images/bt_down.gif'
		});
	} else {
		var img = new Element('img', {
			src : '../images/bt_up.gif'
		});
	}
	tdObj.appendChild(img);

	if (type == "MYTASK") {
		updateListMyTask('1');
	} else if (type == "PROCESS") {
		updateListProcInst('1');
	} else if (type == "REPORT") {
		updateReportList('1');
	} else if (type == "FORM") {
		updateListRecord('1');
	}

}

/*
 필터 조건 삭제 :  필터 조건을 삭제합니다.
 @param obj : 삭제 버튼 이미지 Object
 @return null
 */
function removeFilter(obj) {
	var tagetObj = obj.parentNode.parentNode;
	tagetObj.parentNode.removeChild(tagetObj);
	// obj.parentNode.parentNode.removeNode(true);
	var filterSelect = document.getElementsByName("filterSelect");
	if (filterSelect.length == 0) {
		if ($('filterTable'))
			$('filterTable').hide();
	}
}

/*
 상세필터 닫기 버튼 클릭
 @param type : 내업무함, 정보관리업무, 프로세스업무, 보고서
 @return null
 */
function closeFilter(type) {
	removeAllRow(0, $('filterListTable'));
	if ($('filterId'))
		$('filterId').value='';
	$('filterTable').hide();
	if (type == "MYTASK") {
		updateListMyTask('1');
	} else if (type == "PROCESS") {
		updateListProcInst('1');
	} else if (type == "REPORT") {
		updateReportList('1');
	} else if (type == "FORM") {
		//updateListRecord('1');
		$('filterTable').style.display == 'none'
	} else if (type == "SCHEDULE") {
		clickBaseWorkDef($('scheduleTd'), $F('linkUrl'));
	}
}
function closeFilter2(type, filterId) {
	removeAllRow(0, $('filterListTable'));
	if ($('filterId'))
		$('filterId').value='';
	$('filterTable').hide();
	if (type == "MYTASK") {
		updateListMyTask('1');
	} else if (type == "PROCESS") {
		//updateListProcInst('1');
		//상세필더 닫기를 부르면 모든항목(기본조건)으로 돌아감.
		$('filterId').value = "DEFAULT";		
		updateProcCond();
	} else if (type == "REPORT") {
		updateReportList('1');
	} else if (type == "FORM") {
		//updateListRecord('1');
		//상세필더 닫기를 부르면 모든항목(기본조건)으로 돌아감.
		$('filterId').value = "DEFAULT";
		updateRecordCond();
		//document.listForm.filterId.value = filterId;
		//$('filterTable').style.display == 'none';
	} else if (type == "SCHEDULE") {
		clickBaseWorkDef($('scheduleTd'), $F('linkUrl'));
	}
}
/*
 필터 날짜를 선택합니다.
 @param obj : 날짜 선택 이미지 Object
 @return null
 */
function popupSelectDateModalDialog(obj) {
	var tableNode = obj.parentNode.parentNode.parentNode;
	var trNode = obj.parentNode.parentNode;
	var selectNode = trNode.getElementsByTagName("select")[0];
	var selectNodes = tableNode.getElementsByTagName("select");
	var seq = 0;
	var fieldName = "";
	for ( var i = 0; i < selectNodes.length; i++) {
		if (selectNodes[i].getAttribute("name") == "filterSelect") {
			if (selectNodes[i] == selectNode) {
				break;
			}
			seq++;
		}
	}
	searchDate("filterSearchWord", seq);
}

/*
 날짜 선택과 관련된 함수 목록
 1. searchDate(fieldId, seq), _searchDate : 달력 팝업 생성
 2. searchUser(pageNo), searchUsersCallback() : 날짜 검색
 3. insertDate(this) : 사용자 팝업에서 선택 버튼을 눌렀을 경우
 */
function searchDate(fieldId, seq) {
	var url = getPath() + "/common/dialog/selectDate.jsp";
	popupModalDialog(url, "", "");
	/*
	 * var dimensions = $("modalContentDiv").getDimensions(); var width =
	 * dimensions.width; var height = dimensions.height; var left =
	 * (screen.width) ? (screen.width-width)/2 : 0; var top = (screen.height) ?
	 * (screen.height-height)/2 : 0; var position = "top: "+top+";left:
	 * "+left+";width: "+width+";height: "+height;
	 */
	var today = new Date();
	document.getElementById("searchYear").value = today.getFullYear();
	document.getElementById("searchMonth").value = today.getMonth() + 1;
	document.getElementById("fieldId").value = fieldId;
	document.getElementById("seq").value = seq;
	_searchDate(0);
}
function _searchDate(searchWord) {
	//달력 만들기
	var selectDateTable = $('selectDateTable');
	removeAllRow(1, selectDateTable);
	var tBody = selectDateTable.getElementsByTagName("tbody")[0];
	for ( var i = 0; i < 6; i++) {
		var trElm = document.createElement("tr");
		trElm.setAttribute("style", "height:25px;");
		/*
		var trElm = new Element('tr', {
			'height' : '25'
		});
		 * */
		for ( var d = 0; d < 7; d++) {

			var tdElm = document.createElement("td");
			tdElm.setAttribute("style", "text-align:right; background-color:#ffffff");
			tdElm.id = "td" + i.toString() + d.toString();
			/*
			var tdElm = new Element('td', {
				'align' : 'right',
				'bgColor' : 'FFFFFF',
				id : "td" + i.toString() + d.toString()
			});
			 * */
			trElm.appendChild(tdElm);
		}
		tBody.appendChild(trElm);
	}

	var today = new Date();
	var nowDate = today.getDate();
	var nowYear = today.getFullYear();
	var nowMonth = today.getMonth() + 1;

	var searchYear = $F('searchYear');
	var searchMonth = $F('searchMonth');
	searchWord = Number(searchWord);
	if (searchWord != 0) {
		if (searchWord == 12) {
			searchYear = Number(searchYear) + 1;
		} else if (searchWord == -12) {
			searchYear = Number(searchYear) - 1;
		} else {
			searchMonth = Number(searchMonth) + Number(searchWord);
			if (searchMonth == 13) {
				searchYear = Number(searchYear) + 1;
				searchMonth = 1;
			} else if (searchMonth == 0) {
				searchYear = Number(searchYear) - 1;
				searchMonth = 12;
			}
		}
	}

	var searchText = "<img src='../images/c_arrow_1.gif' border='0' style='cursor:pointer;margin:-4px;' onclick='_searchDate(\"-12\");'>";
	searchText = searchText + "&nbsp;" + searchYear + "&nbsp;";
	searchText = searchText
			+ "<img src='../images/c_arrow_2.gif' border='0' style='cursor:pointer;margin:-4px;' onclick='_searchDate(\"12\");'>&nbsp;&nbsp;&nbsp;";
	searchText = searchText
			+ "<img src='../images/c_arrow_1.gif' border='0' style='cursor:pointer;margin:-4px;' onclick='_searchDate(\"-1\");'>";
	searchText = searchText + "&nbsp;" + searchMonth + "&nbsp;";
	searchText = searchText
			+ "<img src='../images/c_arrow_2.gif' border='0' style='cursor:pointer;margin:-4px;' onclick='_searchDate(\"1\");'>";
	$('searchDateTd').update(searchText);
	$('searchYear').setAttribute("value", searchYear);
	$('searchMonth').setAttribute("value", searchMonth);

	var lastMonthLastDay = new Date(searchYear, searchMonth - 1, 0).getDate();// 저번달
	// 마지막
	// 날짜
	var currentMonthLastDay = new Date(searchYear, searchMonth, 0).getDate(); // 이번달
	// 마지막
	// 날짜

	var currentFirstDayOfWeek = new Date(searchYear, searchMonth - 1, 1)
			.getDay(); // 이번달 1일 요일(0 ~ 6) 예) 0 : 일요일, 1 : 월요일, ... , 6 : 토요일
	var currentLastDayOfWeek = new Date(searchYear, searchMonth, 1).getDay(); // 이번달
	// 마지막
	// 날짜
	// 요일(0
	// ~ 6)
	// 예) 0
	// :
	// 일요일,
	// 1 :
	// 월요일,
	// ...
	// , 6
	// :
	// 토요일

	var specialDays = [ "1.1", "3.1", "5.5", "6.6", "8.15", "10.3", "12.25" ];

	// 달력 첫번째 라인 저번달 마지막날까지만 찍기
	for ( var i = 0; i < currentFirstDayOfWeek; i++) {
		var dateElm = document.getElementById("td0" + i);
		var insertYear;
		var insertMonth;
		var insertDay;
		if (searchMonth == 1) {
			insertYear = Number(searchYear) - 1;
			insertMonth = 12;
		} else {
			insertYear = searchYear;
			insertMonth = Number(searchMonth) - 1;
		}
		if (insertMonth < 10) {
			insertMonth = "0" + insertMonth;
		}
		insertDay = lastMonthLastDay - currentFirstDayOfWeek + i + 1;
		var searchDate = insertYear + "-" + insertMonth + "-" + insertDay;
		var text = "<div onclick='insertDate(\"" + searchDate
				+ "\")' style='cursor: pointer;'><font color='#CCCCCC'>"
				+ insertDay + "</font></div>";
		dateElm.innerHTML = text;
	}

	//이번달 1일부터 찍기
	var k = 0
	for ( var i = 1; i < currentMonthLastDay + 1; i++) {
		var dateElm = document.getElementById("td" + k.toString()
				+ ((i + currentFirstDayOfWeek - 1) % 7).toString());
		if (dateElm != null) {
			var insertYear = searchYear;
			var insertMonth = searchMonth;
			if (insertMonth < 10) {
				insertMonth = "0" + insertMonth;
			}
			if (i < 10) {
				insertDay = "0" + i;
			} else {
				insertDay = i;
			}

			var bgColor = "#FFFFFF";
			if (i == nowDate && Number(insertYear) == nowYear
					&& Number(searchMonth) == nowMonth)
				bgColor = "#F3E7BE";

			var searchDate = insertYear + "-" + insertMonth + "-" + insertDay;
			var style = "#666666";
			if ((currentFirstDayOfWeek + i) % 7 == 1) {
				style = "red";
			} else if ((currentFirstDayOfWeek + i) % 7 == 0) {
				style = "blue";
			}
			for ( var s = 0; s < specialDays.length; s++) {
				if (specialDays[s] == (searchMonth + "." + i)) {
					style = "red";
					break;
				}
			}
			var text = "<div onclick='insertDate(\"" + searchDate
					+ "\")' style='cursor:pointer;'><font color='" + style
					+ "'>" + i + "</font></div>";
			dateElm.innerHTML = text;
//			dateElm.setAttribute("bgColor", bgColor);
			dateElm.setAttribute('style','text-align:right;background-color:'+bgColor);
		}
		if ((currentFirstDayOfWeek + i) % 7 == 0) {
			k++;
		}
	}

	//마지막주 채우기
	for ( var i = 0; i < (7 - currentLastDayOfWeek) % 7; i++) {
		var dateElm = document.getElementById("td" + k + (currentLastDayOfWeek + i));
		var insertYear = searchYear;
		var insertMonth = Number(searchMonth) + 1;
		var insertDay = i + 1;

		if (searchMonth == 12) {
			insertYear = Number(searchYear) + 1;
			insertMonth = 1;
		}

		if (insertMonth < 10)
			insertMonth = "0" + insertMonth;
		if (insertDay < 10)
			insertDay = "0" + insertDay;

		var searchDate = insertYear + "-" + insertMonth + "-" + insertDay;
		var text = "<div onclick='insertDate(\"" + searchDate
				+ "\")' style='cursor:pointer;'><font color='#CCCCCC'>"
				+ (i + 1) + "</font></div>";
		dateElm.innerHTML = text;
	}
	if (currentLastDayOfWeek == 0) {
		removeAllRow(k + 1, selectDateTable);
	} else {
		removeAllRow(k + 2, selectDateTable);
	}
}
function insertDate(date) {
	var fieldId = $F('fieldId');
	var seq = $F('seq');
	if (seq == "-1") {
		$(fieldId).setAttribute("value", date);
	} else {
		document.getElementsByName(fieldId)[seq].value = date;
	}
	releaseModalDialog(false);
}

/**
 * 부서, 사용자, 프로젝트팀
 * @param selInputId : id value field
 * @param selInputName : name value field
 * @param seq : seq
 * @param mode : dept, user(dept+user), team(dept+team), all(dept+user+team), form
 * @param type : single, multi
 * @param opt : delegate (위임, only user, single), form (form, only user, single)
 * @return
 */
function selectTree(selInputId, selInputName, seq, mode, type, opt) {
	if ($(selInputName)) {
		$(selInputName).blur();
	}

	var selInputIdValue = "";
	var selInputNameValue = "";

	if ($(selInputId)) {
		selInputIdValue = $(selInputId).value;
	}
	if ($(selInputName)) {
		selInputNameValue = $(selInputName).value;
	}

	var url = getPath() + "/common/dialog/selectOrgTree.jsp";
	var params = new Array();
	params.push("mode=" + mode);
	params.push("selInputId=" + selInputId);
	params.push("selInputName=" + selInputName);
	params.push("selInputIdValue=" + selInputIdValue);
	params.push("selInputNameValue=" + selInputNameValue);
	params.push("seq=" + seq);
	params.push("type=" + type);
	params.push("opt=" + opt);
	params = params.join("&");
	if (type === 'multi') {
		popupModalDialog(url, params, selectedMulti);
	} else {
		popupModalDialog(url, params, "");
	}
	//document.manSearchForm.searchWord.focus();
}
function selectedDept(deptId, deptName) {
	var selInputName = document.selTreeForm.selInputName.value;
	var selInputId = document.selTreeForm.selInputId.value;
	var seq = document.selTreeForm.seq.value;
	var mode = document.selTreeForm.mode.value;
	var type = document.selTreeForm.type.value;

	if (seq == "") {
		document.getElementsByName(selInputName)[0].value = deptName;
		document.getElementsByName(selInputId)[0].value = deptId;
	} else {
		document.getElementsByName(selInputName)[seq].value = deptName;
		document.getElementsByName(selInputId)[seq].value = deptId;
	}

	releaseModalDialog(false);
}
function checkedDept(deptId, deptName) {
	var selInputNameValue = document.selTreeForm.selInputNameValue.value;
	var selInputValue = document.selTreeForm.selInputValue.value;
	if (selInputValue.indexOf(deptId) >= 0) {
		selInputValue = selInputValue.replaceAll(deptId + ';', '');
		selInputNameValue = selInputNameValue.replaceAll(deptName + ";", '');
	} else {
		selInputNameValue += deptName + ";";
		selInputValue += deptId + ";";
	}

	document.selTreeForm.selInputNameValue.value = selInputNameValue;
	document.selTreeForm.selInputValue.value = selInputValue;
}
function selectedUser(userId, userPosition, userName, opt) {
	if (opt === 'delegate') { //위임
		delegateTask(userId);
		return;
	}

	var selInputName = document.selTreeForm.selInputName.value;
	var selInputId = document.selTreeForm.selInputId.value;
	var seq = document.selTreeForm.seq.value;
	var mode = document.selTreeForm.mode.value;
	var type = document.selTreeForm.type.value;

	if (opt === 'form') {
		var userField = FormUserUtil.getFormUserByUserFieldId(selInputId);
		if (userField != null) {
			userField.setValue(userId);
			userField.setName(userPosition + " " + userName);
		}
		releaseModalDialog(false);
		return;
	}

	if (mode == "user") {
		if (seq == "") {
			document.getElementsByName(selInputName)[0].value = userPosition
					+ " " + userName;
			document.getElementsByName(selInputId)[0].value = userId;
		} else {
			document.getElementsByName(selInputName)[seq].value = userPosition
					+ " " + userName;
			document.getElementsByName(selInputId)[seq].value = userId;
		}

		if (selInputId != "approvalsId" && selInputId != "subTaskAssignee") {
			if (document.getElementById("assigneeTaskTr") != null) {
				document.getElementById("assigneeTaskTr").style.display = "";
			}
		}
	}
	releaseModalDialog(false);
}
function checkedUser(userId, userPosition, userName) {
	var selInputNameValue = document.selTreeForm.selInputNameValue.value;
	var selInputValue = document.selTreeForm.selInputValue.value;
	if (selInputValue.indexOf(userId) >= 0) {
		selInputValue = selInputValue.replaceAll(userId + ';', '');
		selInputNameValue = selInputNameValue.replaceAll(userPosition + ' '	+ userName + ";", '');
	} else {
		selInputNameValue += userPosition + " " + userName + ";";
		selInputValue += userId + ";";
	}

	document.selTreeForm.selInputNameValue.value = selInputNameValue;
	document.selTreeForm.selInputValue.value = selInputValue;
}
function selectedMulti() {
	var selInputName = document.selTreeForm.selInputName.value;
	var selInputId = document.selTreeForm.selInputId.value;
	//var seq = document.selTreeForm.seq.value;
	var seq = $F('seq');
	
	var selInputNameValue = document.selTreeForm.selInputNameValue.value;
	var selInputValue = document.selTreeForm.selInputValue.value;

	if (seq == "") {
		document.getElementsByName(selInputName)[0].value = selInputNameValue;
		document.getElementsByName(selInputId)[0].value = selInputValue;
	} else {
		document.getElementsByName(selInputName)[seq].value = selInputNameValue;
		document.getElementsByName(selInputId)[seq].value = selInputValue;
	}
}

/**
 * 삭제예정 (2010-03-29)
 * @return
 */
// /*
// 사용자(단수) 선택과 관련된 함수 목록
// 1. selectUser(userInputId, userInputName, seq) : 사용자 팝업 생성
// 2. searchUser(pageNo), searchUsersCallback() : 사용자 검색
// 3-1. insertUser(this) : 사용자 팝업에서 선택 버튼을 눌렀을 경우
// 3-2. delegateTask(this) : 내 업무함 위임
// */
// function selectUser(userInputId, userInputName, seq, mode) {
// var url = getPath() + "/common/dialog/selectUser.jsp";
// var params = new Array();
// params.push("mode="+mode);
// params.push("userInputId=" + userInputId);
// params.push("userInputName=" + userInputName);
// params.push("seq=" + seq);
// params = params.join("&");
// popupModalDialog(url, params, "");
// document.manSearchForm.searchWord.focus();
// searchUser('1');
// }
// function searchUser(pageNo) {
// if(pageNo == "undefined")
// pageNo = 1;
// document.manSearchForm.pageNo.value = pageNo;
// var searchWord = document.manSearchForm.searchWord.value;
// var typeNotIns = "SYSTEM;";
// var params = new Array();
// params.push("method=getUsers");
// params.push("searchWord=" + searchWord);
// params.push("typeNotIns=" + typeNotIns);
// params.push("pageNo=" + pageNo);
// params.push("userId=" + userId);
// params.push("pageSize=10");
// params.push("compId=" + compId);
// params = params.join("&");
// request(getPath() + "/services/portal/homeService.jsp", params,
// searchUserCallback, null, null, null, null);
// }
// function searchUserCallback() {
// var xmlDoc = getXmlDOM(getResult());
// var resultXml = SmartXMLUtil.getChildNode(xmlDoc, 'Result');
// var totalSize = resultXml.getAttribute('totalSize');
//	
// var pageNo = document.manSearchForm.pageNo.value;
// var pageSize = document.manSearchForm.pageSize.value;
// var mode = document.manSearchForm.mode.value;
// var userInputName = document.manSearchForm.userInputName.value;
// var userInputId = document.manSearchForm.userInputId.value;
// var seq = document.manSearchForm.seq.value;
//	
// if(resultXml.getAttribute('status') == 'OK') {
// var userXml = SmartXMLUtil.getChildNodes(resultXml, 'User');
// var selectUserTable = $('selectUserTable');
// removeAllRow(1, selectUserTable);
// var tbody = selectUserTable.getElementsByTagName("tbody")[0];
// for(var i=0; i<userXml.length; i++) {
// var userId = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(userXml[i],
// 'id'));
// var deptName = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(userXml[i],
// 'deptName'));
// var userName = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(userXml[i],
// 'userName'));
// var position = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(userXml[i],
// 'position'));
// var email = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(userXml[i],
// 'email'));
//
// var tr = new Element('tr', {id: userId + "_userTr", userId: userId, userName:
// userName, position: position}).setStyle({ 'height': '24', 'cursor':
// 'pointer', 'backgroundColor': '#FFFFFF' });
// // 위임
// if(mode == "DELEGATE") {
// tr.observe('click', function(){ delegateTask(this); });
// } else {
// tr.observe('click', function(){ insertUser(this); });
// }
//
// var td1 = new Element('td', { id: userId+"_Td1" }).setStyle({ 'paddingLeft':
// '5px' }).update(userName);
// var td2 = new Element('td', { id: userId+"_Td2" }).setStyle({ 'paddingLeft':
// '5px' }).update(deptName+"/&nbsp;"+position);
// var td3 = new Element('td', { id: userId+"_Td3" }).setStyle({ 'paddingLeft':
// '5px' }).update(email);
// tr.appendChild(td1);
// tr.appendChild(td2);
// tr.appendChild(td3);
// tbody.appendChild(tr);
// }
//		
// var params = new Array();
// params.push("totalSize=" + totalSize);
// params.push("pageSize=10");
// params.push("pageNo=" + pageNo);
// params.push("funcName=searchUser");
// params = params.join("&");
// send("../common/listPaging.jsp", "dialogPopPagingTd", params);
// }
// }
// function insertUser(obj) {
// var userId = obj.userId;
// var userName = obj.userName;
// var position = obj.position;
// var mode = document.manSearchForm.mode.value;
// var userInputName = document.manSearchForm.userInputName.value;
// var userInputId = document.manSearchForm.userInputId.value;
// var seq = document.manSearchForm.seq.value;
// var pageNo = document.manSearchForm.pageNo.value;
//	
// if(mode == "user") {
// if(seq == "") {
// document.getElementsByName(userInputName)[0].value = position+" "+userName;
// document.getElementsByName(userInputId)[0].value = userId;
// } else {
// document.getElementsByName(userInputName)[seq].value = position+" "+userName;
// document.getElementsByName(userInputId)[seq].value = userId;
// }
//		
// if(userInputId != "approvalsId" && userInputId != "subTaskAssignee") {
// if(document.getElementById("assigneeTaskTr") != null) {
// document.getElementById("assigneeTaskTr").style.display = "";
// }
// }
// } else {
// var userField = FormUserUtil.getFormUserByUserFieldId(userInputId);
// if(userField != null){
// userField.setValue(userId);
// userField.setName(position+" "+userName);
// }
// }
// releaseModalDialog(false);
// }
// /*
// 사용자(복수) 선택과 관련된 함수 목록
// 1. selectUsers(userInputId, userInputName, seq) : 사용자 팝업 생성
// 2. searchUsers(pageNo), searchUsersCallback() : 사용자 검색
// 3. checkUser(seq, userId, userName) : 사용자 목록에서 체크 박스 선택
// 4. insertUsers() : 사용자 팝업에서 선택 버튼을 눌렀을 경우
// */
// var usersArr = new Array();
// function selectUsers(userInputId, userInputName, seq) {
// var url = getPath() + "/common/dialog/selectUsers.jsp";
// var userIds = document.getElementsByName(userInputId)[seq].value;
// var userNames = document.getElementsByName(userInputName)[seq].value;
// if(userIds != "" && userNames != "" ) {
// var userIdsArr = userIds.split(';');
// var userNamesArr = userNames.split(';');
// usersArr = new Array();
// for(var i=0; i<userIdsArr.length; i++) {
// usersArr[i] = [userIdsArr[i], userNamesArr[i]];
// }
// }
// var params = new Array();
// params.push("userInputId=" + userInputId);
// params.push("userInputName=" + userInputName);
// params.push("userIds=" + userIds);
// params.push("userNames=" + userNames);
// params.push("seq=" + seq);
// params = params.join("&");
// popupModalDialog(url, params, insertUsers);
// document.manSearchForm.searchWord.focus();
// searchUsers('1');
// }
// function searchUsers(pageNo) {
// document.manSearchForm.pageNo.value = pageNo;
// var searchWord = document.manSearchForm.searchWord.value;
// var typeNotIns = "SYSTEM;";
//	
// var params = new Array();
// params.push("method=getUsers");
// params.push("searchWord=" + searchWord);
// params.push("typeNotIns=" + typeNotIns);
// params.push("pageNo=" + pageNo);
// params.push("userId=" + userId);
// params.push("pageSize=10");
// params.push("compId=" + compId);
// params = params.join("&");
// request(getPath() + "/services/portal/homeService.jsp", params,
// searchUsersCallback, null, null, null, null);
// }
// function searchUsersCallback() {
// var xmlDoc = getXmlDOM(getResult());
// var resultXml = SmartXMLUtil.getChildNode(xmlDoc, 'Result');
// var totalSize = resultXml.getAttribute('totalSize');
// var pageNo = document.manSearchForm.pageNo.value;
// var pageSize = document.manSearchForm.pageSize.value;
//	
// if(resultXml.getAttribute('status') == 'OK') {
//	
// var userXml = SmartXMLUtil.getChildNodes(resultXml, 'User');
// var selectUserTable = $('selectUserTable');
// removeAllRow(1, selectUserTable);
// var tBody = selectUserTable.getElementsByTagName("tbody")[0];
//
// for(var i=0; i<userXml.length; i++) {
// var userId = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(userXml[i],
// 'id'));
// var deptName = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(userXml[i],
// 'deptName'));
// var userName = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(userXml[i],
// 'userName'));
// var position = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(userXml[i],
// 'position'));
// var email = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(userXml[i],
// 'email'));
//	
// var td0Text = "<input type='checkbox' name='ids'
// onClick='checkUser(\""+i+"\", \""+ userId +"\", \""+position +" " +
// userName+"\");' style='border:none;' onfocus='this.blur()'>";
//	
// for(var k=0; k<usersArr.length; k++) {
// if(userId == usersArr[k][0]) {
// td0Text = "<input type='checkbox' name='ids' onClick='checkUser(\""+i+"\",
// \""+ userId +"\", \""+position +" "+userName+"\");' checked='checked'
// style='border:none;' onfocus='this.blur()'>";
// break;
// }
// }
//
// var tr = new Element('tr', {id: userId + "_userTr", userId: userId, userName:
// userName, position: position}).setStyle({ 'height': '24', 'cursor':
// 'pointer', 'backgroundColor': '#FFFFFF' });
// var td1 = new Element('td').setStyle({ 'align': 'center' }).update(td0Text);
// var td2 = new Element('td').setStyle({ 'paddingLeft': '5px'
// }).update(userName);
// var td3 = new Element('td').setStyle({ 'paddingLeft': '5px'
// }).update(position+"/&nbsp;"+deptName);
// var td4 = new Element('td').setStyle({ 'paddingLeft': '5px' }).update(email);
// tr.appendChild(td1);
// tr.appendChild(td2);
// tr.appendChild(td3);
// tr.appendChild(td4);
// tBody.appendChild(tr);
// }
//	
// var params = new Array();
// params.push("totalSize=" + totalSize);
// params.push("pageSize=10");
// params.push("pageNo=" + pageNo);
// params.push("targetTd=pagingTd");
// params.push("funcName=searchUsers");
// params = params.join("&");
// send("../common/listPaging.jsp", "pagingTd", params);
// }
// }
// function checkUser(seq, userId, userName) {
// var userNames = document.manSearchForm.userNames.value;
// var userIds = document.manSearchForm.userIds.value;
//	
// var ids = document.getElementsByName("ids");
// if(ids[seq].checked) {
// var addYn = false;
// for(var i=0; i<usersArr.length; i++) {
// if(userId == usersArr[i][0]) {
// addYn = true;
// break;
// }
// }
// if(addYn == false) {
// usersArr[usersArr.length] = [userId, userName];
// }
// userNames = userNames + userName + ";";
// userIds = userIds + userId + ";";
// } else {
// for(var i=0; i<usersArr.length; i++) {
// if(userId == usersArr[i][0]) {
// usersArr.remove(i);
// }
// }
// userNames = userNames.replace(userName+";", '');
// userIds = userIds.replace(userId+";", '');
// }
//	
// document.manSearchForm.userNames.value = userNames;
// document.manSearchForm.userIds.value = userIds;
// }
// function insertUsers() {
// var userInputName = document.manSearchForm.userInputName.value;
// var userInputId = document.manSearchForm.userInputId.value;
// var seq = document.manSearchForm.seq.value;
//	
// var userNames = document.manSearchForm.userNames.value;
// var userIds = document.manSearchForm.userIds.value;
//	
// if(seq == "") {
// document.getElementsByName(userInputName)[0].value = userNames;
// document.getElementsByName(userInputId)[0].value = userIds;
// } else {
// document.getElementsByName(userInputName)[seq].value = userNames;
// document.getElementsByName(userInputId)[seq].value = userIds;
// }
// usersArr = new Array();
// }
function showHistory() {
	if ($('historyTd').visible()) {
		$('historyTd').hide();
	} else {
		$('historyTd').show();
	}
}

function showReply() {
	if ($('replyTd').visible()) {
		$('replyTd').hide();
	} else {
		$('replyTd').show();
	}
}
//jk yoon len 추가
function searchUserFilter(obj, len) {
	var tableNode = obj.parentNode.parentNode.parentNode;
	var trNode = obj.parentNode.parentNode;
	var selectNode = trNode.getElementsByTagName("select")[0];
	var selectNodes = tableNode.getElementsByTagName("select");
	var seq = 0;
	var fieldName = "";
	// alert(len);
	seq = len;
	/*
	 * for(var i=0; i<selectNodes.length; i++) {
	 * //alert(selectNodes[i].getAttribute("idx"));
	 * if(selectNodes[i].getAttribute("name") == "filterSelect") {
	 * if(selectNodes[i] == selectNode) { break; } } seq++; }
	 */
	// alert(seq);
	selectTree("filterSearchUser", "filterSearchWord", seq, "user", 'single');
}

function searchUsersFilter(obj) {
	var tableNode = obj.parentNode.parentNode.parentNode;
	var trNode = obj.parentNode.parentNode;
	var selectNode = trNode.getElementsByTagName("select")[0];
	var selectNodes = tableNode.getElementsByTagName("select");
	var seq = 0;
	var fieldName = "";
	for ( var i = 0; i < selectNodes.length; i++) {
		if (selectNodes[i].getAttribute("name") == "filterSelect") {
			if (selectNodes[i] == selectNode) {
				break;
			}
			seq++;
		}
	}
	selectTree('filterSearchUser', 'filterSearchWord', seq, 'user', 'multi');
}

/*
 function searchUserFilter(obj) {
 var tableNode 	= obj.parentNode.parentNode.parentNode;
 var trNode 		= obj.parentNode.parentNode;
 var selectNode 	= trNode.getElementsByTagName("select")[0];
 var selectNodes = tableNode.getElementsByTagName("select");
 var seq = 0;
 var fieldName = "";
 for(var i=0; i<selectNodes.length; i++) {
 if(selectNodes[i].getAttribute("name") == "filterSelect") {
 if(selectNodes[i] == selectNode) {
 break;
 }
 seq++;
 }
 }
 selectUser("filterSearchUser", "filterSearchWord", seq, "user");
 }

 function searchUsersFilter(obj) {
 var tableNode 	= obj.parentNode.parentNode.parentNode;
 var trNode 		= obj.parentNode.parentNode;
 var selectNode 	= trNode.getElementsByTagName("select")[0];
 var selectNodes = tableNode.getElementsByTagName("select");
 var seq = 0;
 var fieldName = "";
 for(var i=0; i<selectNodes.length; i++) {
 if(selectNodes[i].getAttribute("name") == "filterSelect") {
 if(selectNodes[i] == selectNode) {
 break;
 }
 seq++;
 }
 }
 selectUsers("filterSearchUser", "filterSearchWord", seq);
 }
 */

/*
 * 업무 이력 내용을 조회합니다. @param taskId : 태스크 아이디 @param formId : 태스크 폼 아이디 @param
 * taskType : 태스크 종류 @return null
 */
function viewHistoryDetail(taskId, formId, taskType, taskRef) {
	if ($(taskId + "commentTd")) {
		var commentTrNode = $(taskId + "commentTd");
	}
	if ($(taskId + "historyDetailTd")) {
		var historyDetailTd = $(taskId + "historyDetailTd");
	}
	var imageTrNode = $(taskId + "imageTd");
	var detailTrNode = $(taskId + "detailTd");
	var detailSubTrNode = $(taskId + "detailSubTd");
	var ApprovalTrNode = $(taskId + "ApprovalTd");
	var params = "taskId=" + taskId + "&userId=" + userId;

	if (detailTrNode.visible()) {
		if (commentTrNode) {
			commentTrNode.hide();
		}
		if (historyDetailTd) {
			historyDetailTd.hide();
		}
		if (detailSubTrNode) {
			detailSubTrNode.hide();
		}
		imageTrNode.hide();
		ApprovalTrNode.hide();
		detailTrNode.hide();
	} else {
		if (commentTrNode) {
			commentTrNode.show();
		}
		if (historyDetailTd) {
			historyDetailTd.show();
		}
		if (detailSubTrNode) {
			detailSubTrNode.show();
		}
		imageTrNode.show();
		ApprovalTrNode.show();
		detailTrNode.show();

		if (!detailTrNode.hasChildNodes()) {
			var formWork = new FormWork(taskId + "detailTd");
			if (taskType == "APPROVAL") {
				formWork.initFormRuntime(userId, '../', formId, '', '',
						taskRef, '1', 'view');
			} else {
				formWork.initFormRuntime(userId, '../', formId, '', '', taskId,
						'1', 'view');
			}

		}
		if (commentTrNode) {
			if (!detailTrNode.hasChildNodes()) {
				send("../common/referecneComment.jsp", taskId + "commentTd",
						params);
			}
		}
	}

	if (taskType == "GANTT") {
		send("../gantt/ganttExecutionDate.jsp", "executionDate" + taskId,
				params);
	}
}

/*
 댓글을 삭제합니다
 @param opinionId : 댓글 아이디
 @return null
 */
function removeReply(opinionId) {
	//document.reply.opinionId.value = opinionId;
	alertMessage("delete", "Deleted", _removeReply(opinionId));
	//confirmMessage('AreYouSureYouWantToDeleteIt', _removeReply(opinionId));// 삭제 하시겠습니까?
}
function _removeReply(opinionId) {
	//var opinionId = document.reply.opinionId.value;
	var params = new Array();
	params.push("method=removeOpinion");
	params.push("opinionId=" + opinionId);
	params.push("userId=" + userId);
	params.push("compId=" + compId);
	params = params.join("&");
	request(getPath() + "/services/portal/homeService.jsp", params,
			removeReplyCallback(opinionId), null, "", null, "");
}
function removeReplyCallback(opinionId) {
	var xmlDoc = getXmlDOM(getResult());
	var resultXml = SmartXMLUtil.getChildNode(xmlDoc, 'Result');
	//var opinionId = document.reply.opinionId.value;
	if (resultXml.getAttribute('status') == 'OK') {
		var dataTr = $('replyContentTr' + opinionId);
		// dataTr.removeNode(true);
		dataTr.parentNode.removeChild(dataTr);
		//document.reply.opinionId.value = "";
	}
}

/*
 댓글을 저장합니다
 @param null
 @return null
 */
function setReply() {
	var opinionStr = document.getElementById('opinionStr').value;// $F('opinionStr');
	var procInstId = document.getElementById('procOpInstId').value;// $F('procInstId');
	var workDefType = document.getElementById('workDefType').value;// $F('workDefType');
	var replyFormId = document.getElementById('replyFormId').value;// $F('domainId');
	if (opinionStr == "" || opinionStr == null) {
		warnMessage("Youdidnotentertherequireditems", "PleaseEnterAComment");
	} else {
		var params = new Array();
		params.push("method=setOpinion");
		params.push("userId=" + userId);
		params.push("opinionStr=" + opinionStr);
		params.push("procInstId=" + procInstId);
		params.push("workDefType=" + workDefType);
		params.push("replyFormId=" + replyFormId);
		params.push("compId=" + compId);
		params = params.join("&");
		request(getPath() + "/services/portal/homeService.jsp", params,
				setReplyCallback, null, "notifySaveProgress", null,
				"warnSaveFailed");
	}
}
function setReplyCallback() {
	var xmlDoc = getXmlDOM(getResult());
	var resultXml = SmartXMLUtil.getChildNode(xmlDoc, 'Result');
	var opinionStr = document.getElementById('opinionStr').value;
	if (resultXml.getAttribute('status') == 'OK') {
		var opinionId = resultXml.getAttribute('opinionId');
		var creator = resultXml.getAttribute('creator');
		var writtenTime = resultXml.getAttribute('writtenTime');
		var replyTable = $('replyTable');
		var tBody = replyTable.getElementsByTagName("tbody")[0];

		var tr1 = new Element('tr', {
			id : "replyContentTr" + opinionId
		}).setStyle( {
			'height' : '23'
		});
		var td1 = new Element('td', {
			'align' : 'left'
		}).update(opinionStr
				+ "&nbsp;<img src='../images/ico_new.gif' border='0'>");
		var td2 = new Element('td', {
			'align' : 'left'
		}).update(creator);
		var td3 = new Element('td', {
			'align' : 'left'
		}).update(writtenTime);
		var td4 = new Element('td', {
			'align' : 'left'
		});
		var img = new Element('img', {src : '../images/close.gif'}).observe('click', function() {removeReply(opinionId);}).setStyle( {'cursor' : 'pointer'});
		td4.appendChild(img);
		tr1.appendChild(td1);
		tr1.appendChild(td2);
		tr1.appendChild(td3);
		tr1.appendChild(td4);
		if (tBody.getElementsByTagName("tr").length > 0) {
			tBody.insertBefore(tr1, tBody.getElementsByTagName("tr")[0]);
		} else {
			tBody.appendChild(tr1);
		}
		document.getElementById('opinionStr').innerHTML = "";

	}
}

/*
 최근 처리 항목 클릭 : 최근처리항목 업무 내용을 조회합니다.
 @param formId : 해당 업무의 formId
 @param version : 해당 업무의 version
 @param id : 해당업무의 recordId 또는 taskid
 @param teyp : 해당업무의 업무 타입
 */
var recentWorkClickId;
var recentWorkClickFormId;
var recentWorkClickType;
function recentWorkClick(formId, id, type) {
	recentWorkClickId = id;
	recentWorkClickFormId = formId;
	recentWorkClickType = type;
	if (type == "GRID" || type == "MATRIX" || type == "COLUMN_CHART"
			|| type == "BAR_CHART" || type == "LINE_CHART"
			|| type == "AREA_CHART" || type == "PIE_CHART") {
		viewReport(id);
	} else {
		var params;
		var linkUrl;
		if (type == "COMMON") {
			params = "taskId=" + id + "&formType=" + type
					+ "&statusType=finished";
			linkUrl = "../myTask/myTaskView.jsp";
			update(linkUrl, "mainTd", params, null, "loading", "failed");
		} else if (type == "GANTT") {
			params = "formId=" + formId + "&taskId=" + id + "&formType=" + type;
			linkUrl = "../myTask/myTaskView.jsp";
			update(linkUrl, "mainTd", params, null, "loading", "failed");
		} else if (type == "SINGLESEND" || type == "SINGLE") {
			params = "taskId=" + id + "&formType=" + type
					+ "&statusType=finished";
			linkUrl = "../myTask/myTaskView.jsp";
			update(linkUrl, "mainTd", params, null, "loading", "failed");
		} else if (type == "APPROVAL") {
			params = "taskId=" + id + "&formType=" + type
					+ "&statusType=finished";
			linkUrl = "../myTask/myTaskView.jsp";
			update(linkUrl, "mainTd", params, null, "loading", "failed");
		} else {
			params = "formId=" + formId + "&recordId=" + id + "&formType="
					+ type;
			linkUrl = "../form/formView.jsp";
			update(linkUrl, "mainTd", params, recentWorkClickCallback,
					"loading", "failed");
		}
	}
}
function recentWorkClickCallback() {
	var formWork = new FormWork("workspace");
	$("workspace")["formWork"] = formWork;
	formWork.initFormRuntime(userId, "../", recentWorkClickFormId, "1", "",
			recentWorkClickId, "2", "view");
}

function getBounds(tag) {
	var ret = new Object();
	if (document.all) {
		var rect = tag.getBoundingClientRect();
		ret.left = rect.left
				+ (document.documentElement.scrollLeft || document.body.scrollLeft);
		ret.top = rect.top
				+ (document.documentElement.scrollTop || document.body.scrollTop);
		ret.width = rect.right - rect.left;
		ret.height = rect.bottom - rect.top;
	} else {
		var box = tag.getBoundingClientRect();
		ret.left = box.x;
		ret.top = box.y;
		ret.width = box.width;
		ret.height = box.height;
	}
	return ret;
}

var setTimeClose;
function filePopUp(fileGroupId, e, ImgId) {
	clearTimeout(setTimeClose);

	var imagePosition = getBounds(document.getElementById(ImgId));
	var imgLeft = imagePosition.left;
	var imgTop = imagePosition.top;
	var imgWidth = imagePosition.width;
	var imgHeight = imagePosition.height;

	var filePopUpTop = imgTop + 'px';
	var filePopUpLeft = imgLeft + imgWidth + 'px';

	document.getElementById("fileDownLoadDiv").style.left = filePopUpLeft;
	document.getElementById("fileDownLoadDiv").style.top = filePopUpTop;
	var parameters = "groupId=" + fileGroupId;
	send("../common/filePop.jsp", "fileDownLoadDiv", parameters);
	document.getElementById("fileDownLoadDiv").style.display = "";
}

function downLoad(fileId) {
	var form = document.fileListForm;
	form.fileId.value = fileId;
	form.action = "../servlet/download?fileId=" + fileId + "&userId=" + userId;
	form.target = "ajaxFrame";
	form.submit();
}

ie4 = document.all
ns = (document.layers) ? 1 : 0;

if (ns) {
	window.captureEvents(Event.MOUSEMOVE);
	function nsMouse(evnt) {
		Ypos = evnt.pageY + document.body.scrollTop;
		Xpos = evnt.pageX + document.body.scrollLeft;
	}
	window.onMouseMove = nsMouse;
} else if (ie4) {
	function ieMouse() {
		Ypos = event.y + document.body.scrollTop;
		Xpos = event.x + document.body.scrollLeft;
	}
	document.onmousemove = ieMouse;
}

function fileMouseOut(e) {
	var divTop = document.getElementById("fileDownLoadDiv").offsetTop;
	var divLeft = document.getElementById("fileDownLoadDiv").offsetLeft;

	var divHeight = document.getElementById("fileDownLoadDiv").offsetHeight;
	var divWidth = document.getElementById("fileDownLoadDiv").offsetWidth;

	if (Ypos > (divTop + divHeight - 20) || Ypos < divTop
			|| Xpos > (divLeft + divWidth) || Xpos < divLeft) {
		setTimeClose = setTimeout("fileClose()", 500);
	}
}

function fileClose() {
	document.getElementById("fileDownLoadDiv").style.display = "none";
	document.getElementById("fileDownLoadDiv").innerHTML = "";
}

function filterShow() {
	$('filterTable').show();
}

document
		.write("<div id=fileDownLoadDiv style='position:absolute;top:-100px;width=250;height=50;z-index:3;display:none'></div>");

function createSubTask(taskId) {
	document.getElementById("subTaskCreateTr").style.display = "";
}

function subTaskAdd() {
	var superForm = document.viewForm.superForm.value;
	var subTaskAssignee = document.viewForm.subTaskAssignee.value;
	var superRecordId = document.viewForm.superRecordId.value;
	var packageType = document.viewForm.packageType.value;
	var subTaskProcessId = document.viewForm.subTaskProcessId.value;

	if (subTaskAssignee == null || subTaskAssignee == "") {
		warnMessage('Youdidnotentertherequireditems', 'errorCodeNullContent');
	} else if (superForm == null || superForm == "") {
		warnMessage('Youdidnotentertherequireditems', 'errorCodeNullContent');
	} else {
		var params = new Array();
		params.push("method=executeSubTask");
		params.push("superForm=" + superForm);
		params.push("subTaskAssignee=" + subTaskAssignee);
		params.push("userId=" + userId);
		params.push("superRecordId=" + superRecordId);
		params.push("packageType=" + packageType);
		params.push("processId=" + subTaskProcessId);
		params = params.join("&");

		if (packageType == "SINGLE") {
			popupModalDialog(getPath() + "/common/dialog/subTaskInsert.jsp",
					params, subTaskSingleComplete);
			var formWork = new FormWork('subTaskDetailTd');
			$('subTaskDetailTd')['formWork'] = formWork;
			formWork.initFormRuntime(userId, '../', superForm, '1', '', '',
					'3', 'edit');
		} else if (packageType == "PROCESS") {
			popupModalDialog(getPath() + "/common/dialog/subTaskInsert.jsp",
					params, subTaskProcessComplete);
			var formWork = new FormWork('subTaskDetailTd');
			$('subTaskDetailTd')['formWork'] = formWork;
			formWork.initFormRuntime(userId, '../', superForm, '1',
					subTaskProcessId, '', 4, 'edit');
		}
	}
}
function subTaskSingleComplete() {
	var superForm = document.viewForm.superForm.value;
	var subTaskAssignee = document.viewForm.subTaskAssignee.value;
	var superRecordId = document.viewForm.superRecordId.value;
	var packageType = document.viewForm.packageType.value;
	var superDomainId = document.viewForm.superDomainId.value;

	// _sucessMsg, _failedMsg, _referenceUserId, _referenceComment, _taskType,
	// _referenceId , _executionFrom , _executionTo, 8
	// _domainId, _nextPage, _tag, _params, _recordId, _receiptFormId,
	// _approvalsId, _approvalType, _approvalName
	$('subTaskDetailTd')['formWork'].complete('', '', '', '', 'subTaskSingle',
			'', '', '', superDomainId, 'dialogPop', '', '', '', superForm, '',
			'', '');

	document.getElementById("subTaskCreateTr").style.display = "none";
	document.viewForm.subTaskAssigneeName.value = "";
	document.viewForm.subTaskAssignee.value = "";
	document.viewForm.packageName.value = "";
	document.viewForm.superForm.value = "";
	document.viewForm.superDomainId.value = "";
	document.viewForm.packageType.value = "";
	document.viewForm.subTaskProcessId.value = "";
}
function subTaskProcessComplete() {
	var superForm = document.viewForm.superForm.value;
	var subTaskAssignee = document.viewForm.subTaskAssignee.value;
	var superRecordId = document.viewForm.superRecordId.value;
	var packageType = document.viewForm.packageType.value;
	var superDomainId = document.viewForm.superDomainId.value;

	$('subTaskDetailTd')['formWork'].complete('', '', '', '', 'subTaskSingle',
			'', '', '', superDomainId, 'dialogPop', '', '', '', superForm, '',
			'', '');

	document.getElementById("subTaskCreateTr").style.display = "none";
	document.viewForm.subTaskAssigneeName.value = "";
	document.viewForm.subTaskAssignee.value = "";
	document.viewForm.packageName.value = "";
	document.viewForm.superForm.value = "";
	document.viewForm.superDomainId.value = "";
	document.viewForm.packageType.value = "";
	document.viewForm.subTaskProcessId.value = "";
}

function insertWorkDef() {
	var type = document.workDefListForm.type.value;
	var formId = document.workDefListForm.formId.value;
	var processId = document.workDefListForm.processId.value;
	var workDefName = document.workDefListForm.workDefName.value;

	document.viewForm.superForm.value = formId;
	document.viewForm.packageType.value = type;
	document.viewForm.subTaskProcessId.value = processId;
	document.viewForm.packageName.value = workDefName;
}

function refFormListView(refFormId, refRecordId, targetTd) {
	if (document.getElementById(targetTd).hasChildNodes()) {
		if (document.getElementById(targetTd).style.display == "none") {
			document.getElementById(targetTd).style.display = "";
		} else {
			document.getElementById(targetTd).style.display = "none";
		}
	} else {
		document.getElementById(targetTd).style.display = "";
		var params = "id=" + refFormId + "&refRecordId=" + refRecordId
				+ "&targetTd=" + targetTd;
		send("../form/refRecordList.jsp", targetTd, params);
	}
}
/**
 * 작성업무 ViewType
 * @return
 */
function finishedTaskFormView() {
	if (document.getElementById("finishedTaskFormTd").style.display == "none")
		document.getElementById("finishedTaskFormTd").style.display = "block";
	else
		document.getElementById("finishedTaskFormTd").style.display = "none";
}

function refFormDetailView(formId, recordId) {
	var url = getPath() + "/common/referenceTaskView.jsp";
	var params = '?formId=' + formId + '&recordId=' + recordId;
	popupModalDialog(url, params);

	var formWork = new FormWork(formId+"taskView");
	formWork.initFormRuntime('', '../', formId, '', '', recordId, '2', 'view');

	// window.showModalDialog("../common/referenceTaskView.jsp?formId="+formId+"&recordId="+recordId,
	// window,
	// "dialogWidth: 760px; dialogHeight: 400px; dialogTop:50px;
	// dialogLeft:50px; center: yes; help: no; status: no; scroll: yes;
	// resizable: no");
}

function simpleSearch(linkUrl, params) {
	var form = document.listForm;
	var searchWord = "";
	var pageSize = "";

	if (form.searchWord != null) {
		searchWord = form.searchWord1.value;
	}
	if (form.pageSize != null) {
		pageSize = form.pageSize.value;
	}
	params = params + "&searchWord=" + searchWord + "&pageSize=" + pageSize;
	update(linkUrl, "mainTd", params, null, "loading", "failed");
}
function _simpleSearch(searchWord, pageSize, linkUrl, params) {
	params = params + "&searchWord=" + searchWord + "&pageSize=" + pageSize;
	update(linkUrl, "mainTd", params, null, "loading", "failed");
}

function pageSizeChange(linkUrl, params) {
	form = document.listForm;
	var searchWord = "";
	var pageSize = "";

	if (form.searchWord != null) {
		searchWord = form.searchWord1.value;
	}
	if (form.pageSize != null) {
		pageSize = form.pageSize.value;
	}
	params = "searchWord=" + searchWord + "&pageSize=" + pageSize + params;
	update(linkUrl, "mainTd", params, null, "loading", "failed");
}

function defaultfilter(linkUrl, params, filterId) {
	params = params + "&filterId=" + filterId;
	update(linkUrl, "mainTd", params, null, "loading", "failed");
}

function scheudleFilterDel(delMsg, nextUrl, params) {
	var form = document.listForm;
	var filterId = "";
	if (form.filterId != null) {
		filterId = form.filterId.value;
	}

	if (confirm(delMsg)) {
		params = params + "&filterSaveYn=D&filterId=" + filterId;
		update(nextUrl, "mainTd", params, null, "loading", "failed");
	}
}

function scheduleFilterSearch(selectMsg, keyMsg, wordMsg, nextUrl, params) {
	var form = document.listForm;
	var v_filterSelect = "";
	var v_filterSearchKey = "";
	var v_filterSearchWord = "";
	var v_filterSearchUserName = "";

	var filterSelect = document.getElementsByName("filterSelect");
	var filterSearchKey = document.getElementsByName("filterSearchKey");
	var filterSearchWord = document.getElementsByName("filterSearchWord");
	var filterSearchUser = document.getElementsByName("filterSearchUser");

	v_filterSelect = filterSelect[0].value;
	v_filterSearchKey = filterSearchKey[0].value;
	v_filterSearchWord = filterSearchWord[0].value;
	v_filterSearchUser = filterSearchUser[0].value;
	params = params + "&filterSelect=" + v_filterSelect + "&filterSearchKey="
			+ v_filterSearchKey + "&filterSearchWord=" + v_filterSearchWord
			+ "&filterSearchUser=" + v_filterSearchUser;
	update(nextUrl, "mainTd", params, null, "loading", "failed");
}

function gadgetMoreClick(formId) {
	var linkUrl = "../form/formList.jsp";
	var params = "id=" + formId;
	update(linkUrl, "mainTd", params, updateListRecord, "loading", "failed");
}

function calSearch(year, month) {
	var linkUrl = "../main/calendar.jsp?year=" + year + "&month=" + month;
	update(linkUrl, "calendarTd", null, null, "loading", "failed");
}

function setPicCookie(imageName, defaultLanguage) {
	var todayDate = new Date();
	todayDate.setDate(todayDate.getDate() + 365);

	document.cookie = "smartWorksCompanyLogo=on; expires="
			+ todayDate.toGMTString() + "; path=/";
	document.cookie = "smartWorksCompanyLogoName=" + imageName + ";  expires="
			+ todayDate.toGMTString() + "; path=/";

	document.cookie = "smartWorksLanguage=on; expires="
			+ todayDate.toGMTString() + "; path=/";
	document.cookie = "smartWorksLanguageName=" + defaultLanguage
			+ ";  expires=" + todayDate.toGMTString() + "; path=/";
}

function onClickTag(linkUrl, tagName) {
	var params = "tagName=" + tagName;
	update(linkUrl, "mainTd", params, null, "loading", "failed");
}

function topSearchClick(searchWordMsg) {
	var searchWord = document.getElementById('topSearchWord').value;
	if (isNull(searchWord)) {
		warnMessage("errorCodeNullValue", "checkValue");
		return;
	}

	var params = "searchWord=" + searchWord;
	setTimeout("_topSearchClick('" + params + "')", 50);
}
function _topSearchClick(params) {
	var linkUrl = "../main/topSearchResult.jsp";
	update(linkUrl, "mainTd", params, null, "loading", "failed");
}

function schMenuClick(targetTd, linkUrl) {
	send(linkUrl, targetTd);
}

function scheduleMonth(year, month, targetTd, linkUrl, params) {
	params = params + "&year=" + year + "&month=" + month;
	update(linkUrl, targetTd, params, null, "loading", "failed");
}

function calendarWeek(linkUrl, searchDate, params) {
	params = params + "&searchDate=" + searchDate;
	update(linkUrl, "mainTd", params, null, "loading", "failed");
}

function showDetailHistory(taskId, statusType, procInstId, mode, formType,
		formId, userId, returnUrl, recordId, params) {
	params = params + "&taskId=" + taskId + "&statusType=" + statusType
			+ "&procInstId=" + procInstId + "&mode=" + mode + "&formType="
			+ formType + "&formId=" + formId + "&returnUrl=" + returnUrl
			+ "&recordId=" + recordId;
	update("../myTask/myTaskView.jsp", "mainTd", params, null, "loading",
			"failed");
}

function trimText(str) {
	var i, j = 0;
	var objstr;

	for (i = 0; i < str.length; i++) {
		if (str.charAt(i) == ' ')
			j = j + 1;
		else
			break;
	}

	str = str.substring(j, str.length - j + 1);
	i, j = 0;
	for (i = str.length - 1; i >= 0; i--) {
		if (str.charAt(i) == ' ')
			j = j + 1;
		else
			break;
	}
	return str.substring(0, str.length - j);
}

function postDel(formId, recordId, formType, workItemId, tagName, delMsg) {
	var params = "tagName=" + tagName + "&formId=" + formId + "&recordId="
			+ recordId + "&formType=" + formType + "&workItemId=" + workItemId
			+ "&saveMode=DEL";

	if (confirm("(" + tagName + ")" + delMsg)) {
		send("../common/tagList.jsp", "tagListTd", params);
		send("../main/tag.jsp", "tagTd", "");
	}
}

function procPlanView(viewTable) {
	if (viewTable == "procPlanHistoryTable") {
		document.getElementById("procExecutionHistoryTable").style.display = "none";
		document.getElementById("procPlanHistoryTable").style.display = "";
		if (document.getElementById("procViewSaveBtn") != null) {
			document.getElementById("procViewSaveBtn").style.display = "";
		}
		document.getElementById("procPlanHistoryTd").style.fontWeight = "bold";
		document.getElementById("procExecutionHistoryTd").style.fontWeight = "";
	} else {
		document.getElementById("procExecutionHistoryTable").style.display = "";
		document.getElementById("procPlanHistoryTable").style.display = "none";
		document.getElementById("procExecutionHistoryTd").style.fontWeight = "bold";
		document.getElementById("procPlanHistoryTd").style.fontWeight = "";

	}
}

function topPackageSearch(searchWord, searchCatId) {
	var params = "searchWord=" + searchWord + "&searchCatId=" + searchCatId;
	send("../main/topSearchResult.jsp", "mainTd", params);
}

function scheduleFilterSave(inputMsg, nextUrl, params) {
	var form = document.listForm;

	var filterTitle = form.filterTitle.value;

	var v_filterSelect = document.getElementsByName("filterSelect")[0].value;
	var v_filterSearchKey = document.getElementsByName("filterSearchKey")[0].value;
	var v_filterSearchWord = document.getElementsByName("filterSearchWord")[0].value;
	var v_filterSearchUser = document.getElementsByName("filterSearchUser")[0].value;

	if (filterTitle == null || filterTitle == "") {
		if(inputMsg!=undefined)
			alert(inputMsg);
	} else if (v_filterSearchWord == null || v_filterSearchWord == "") {

	} else {
		params = params + "&filterSaveYn=Y&filterTitle=" + filterTitle
				+ "&filterSelect=" + v_filterSelect + "&filterSearchKey="
				+ v_filterSearchKey + "&filterSearchWord=" + v_filterSearchWord
				+ "&filterSearchUser=" + v_filterSearchUser;
		send(nextUrl, "mainTd", params);
	}
}

function selectForm(frmName, formId) {
	if (formId == '') {
		$('selectDifferentTaskTd').show();
		var url = getPath() + "/common/dialog/selectForm.jsp";
		var params = new Array();
		params.push("frmName=" + frmName);
		params = params.join("&");
		popupModalDialog(url, params, "");
		document.searchForm.searchWord.focus();
		searchForms('1');
	} else {
		$('selectDifferentTaskTd').hide();
		document.getElementById("receiptFormId").value = formId;
		document.getElementById("assigneeTaskFormName").value = "";
	}
}
function searchForms(pageNo) {
	if (pageNo == "undefined")
		pageNo = 1;
	document.searchForm.pageNo.value = pageNo;
	var searchWord = document.searchForm.searchWord.value;
	var params = new Array();
	params.push("method=getForms");
	params.push("searchWord=" + searchWord);
	params.push("pageNo=" + pageNo);
	params.push("userId=" + userId);
	params.push("pageSize=10");
	params.push("compId=" + compId);
	params = params.join("&");
	request(getPath() + "/services/portal/homeService.jsp", params,
			searchFormCallback, null, null, null, null);
}
function searchForms2(pageNo) {
	if (pageNo == "undefined")
		pageNo = 1;
	document.searchForm.pageNo.value = pageNo;
	var searchWord = document.searchForm.searchWord.value;
	var params = new Array();
	params.push("method=getForms");
	params.push("searchWord=" + searchWord);
	params.push("pageNo=" + pageNo);
	params.push("userId=" + userId);
	params.push("pageSize=10");
	params.push("compId=" + compId);
	params.push("userLanguage="+defaultLanguage);
	params = params.join("&");
	request(getPath() + "/services/portal/homeService.jsp", params,
			searchFormCallback, null, null, null, null);
}
function searchFormCallback() {
	var xmlDoc = getXmlDOM(getResult());
	var resultXml = SmartXMLUtil.getChildNode(xmlDoc, 'Result');
	var totalSize = resultXml.getAttribute('totalSize');
	var pageNo = document.searchForm.pageNo.value;
	if (resultXml.getAttribute('status') == 'OK') {
		var userXml = SmartXMLUtil.getChildNodes(resultXml, 'form');
		var formListTable = $('formListTable');

		removeAllRow(1, formListTable);
		var tbody = formListTable.getElementsByTagName("tbody")[0];
		for ( var i = 0; i < userXml.length; i++) {
			var formId = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(
					userXml[i], 'formId'));
			var formName = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(
					userXml[i], 'formName'));
			var categoryName = SmartXMLUtil.getNodeData(SmartXMLUtil
					.getChildNode(userXml[i], 'categoryName'));

			var tr = new Element('tr', {
				formId : formId,
				formName : formName
			});
			tr.setStyle( {
				'height' : '24',
				'cursor' : 'pointer',
				'backgroundColor' : '#FFFFFF'
			});
			tr.observe('click', function() {
				insertForm(this);
			});

			var td1 = new Element('td').setStyle( {
				'paddingLeft' : '5px'
			}).update(categoryName);
			var td2 = new Element('td').setStyle( {
				'paddingLeft' : '5px'
			}).update(formName);
			tr.appendChild(td1);
			tr.appendChild(td2);
			tbody.appendChild(tr);
		}

		var params = new Array();
		params.push("totalSize=" + totalSize);
		params.push("pageSize=10");
		params.push("pageNo=" + pageNo);
		params.push("funcName=searchForms2");
		params = params.join("&");
		send("../common/listPaging.jsp", "dialogPopPagingTd", params);
	}
}
function insertForm(obj) {
	var formId = obj.formId;
	var formName = obj.formName;
	document.getElementById('receiptFormId').setAttribute('value',formId);
	document.getElementById('assigneeTaskFormName').setAttribute('value',formName);
	//document.viewForm.receiptFormId.value = formId;
	//document.viewForm.assigneeTaskFormName.value = formName;

	releaseModalDialog(false);
}

function unifiedSearch(url, target, params, type) {
	if ($(target).style.display == "none") {
		if (type == "form") {
			send(url, target, params);
		} else if (type == "proc") {
			send(url, target, params);
		}
		$(target).style.display = "block";
	} else if ($(target).style.display == "block") {
		$(target).style.display = "none";
	}
}

/**
 * 버튼 두번 클릭으로 인한 여러개 글 등록 방지 스크립트
 * @return
 */
var checkCount = 0;
function checkClick() {
	if (checkCount <= 1) {
		checkCount++;
		return true;
	} else {
		warn('', 'Double click was');
		return false;
	}
}

function showReport(formId, reportId, reportType) {
	if ($(reportId + "Td").visible()) {
		$(reportId + "Td").hide();
		$(reportId + "imageTd").hide();
		$(reportId + "BtnTd").hide();
	} else {
		$(reportId + "Td").show();
		$(reportId + "BtnTd").show();
		$(reportId + "imageTd").show();
		if (!$(reportId + "Td").hasChildNodes()) {
			if (reportType == "GRID") {
				send("../report/reportGrid.jsp", reportId + "Td", "formId="
						+ formId + "&reportId=" + reportId + "&targetTd="
						+ reportId + "Td");
			} else {
				//20100927 수정 width=714 -> width=100%
				$(reportId + "Td").innerHTML = "<iframe id='chartIframe' width='100%' height='500' frameborder='0' marginheight='0' marginwidth='0' scrolling='no' src='../report/reportChart.jsp?userId="
						+ userId
						+ "&reportId="
						+ reportId
						+ "&language="
						+ defaultLanguage + "'></iframe>";
			}
		}
	}
}

var historyFormId = "";
var historyTaskId = "";
function taskHistoryDetailView(taskId, formId) {
	if ($(taskId + "HistoryTr").visible()) {
		$(taskId + "HistoryTr").hide();
		//$(taskId + "HistoryMeta").hide();
	} else {
		historyFormId = formId;
		historyTaskId = taskId;
		if ($(taskId + "HistoryTr"))
			$(taskId + "HistoryTr").show();
		
		//if ($(taskId + "HistoryMeta"))
		//	$(taskId + "HistoryMeta").show();
		
		FormEnv.loadDataComplete = true;
		
		if(formId.indexOf("ef_")>-1){
			update("../common/taskHistoryDetail.jsp", taskId + "HistoryTd",
					"taskId=" + taskId, null,
					"loading", "failed");
		}else{
			if ($(taskId + "HistoryTd")) {
				update("../common/taskHistoryDetail.jsp", taskId + "HistoryTd",
						"taskId=" + taskId, taskHistoryDetailViewCallback);
			}
		}
		
	}
}

function taskHistoryDetailViewCallback() {

	var formWork = new FormWork(historyTaskId + 'FormTd');
	//jk 1 이던 mode 를 5로 변경
	formWork.initFormRuntime(userId, '../', historyFormId, '', '', historyTaskId, '5', 'view');
}

function addSendTask(type, formId, aprLine, taskType) {
	var params = new Array();
	params.push("addTaskType=" + type);
	params.push("formId=" + formId);
	params.push("aprLine=" + aprLine);
	params.push("taskType=" + taskType);
	params = params.join("&");
	if (taskType == "FORM") {
		if (type == "CANCEL") {
			if ($('infoTaskExeTable'))
				$('infoTaskExeTable').hide();
			if ($('viewTable'))
				$('viewTable').show();
			if ($('editTable'))
				$('editTable').hide();
		} else {
			if ($('infoTaskExeTable'))
				$('infoTaskExeTable').show();
			if ($('viewTable'))
				$('viewTable').hide();
			if ($('editTable'))
				$('editTable').hide();
		}
	}

	if (type == "APPROVAL") {
		if ($('aprDetailTable')) {
			$('aprDetailTable').show();
			update(getPath() + "/common/addTask.jsp", "aprDetailTd", params,
					commentInsert, null, null);
		}
		if ($('titleTable'))
			$('titleTable').hide();
	} else if (type == "SINGLESEND") {
		if ($('aprDetailTable')) {
			$('aprDetailTable').show();
			update(getPath() + "/common/addTask.jsp", "aprDetailTd", params,
					commentInsert, null, null);
		}
		if ($('titleTable'))
			$('titleTable').hide();
	} else if (type == "REFERENCE") {
		if ($('aprDetailTable')) {
			$('aprDetailTable').show();
			update(getPath() + "/common/addTask.jsp", "aprDetailTd", params,
					commentInsert, null, null);
		}
		if ($('titleTable'))
			$('titleTable').hide();
	} else if (type == "CANCEL") {
		if ($('aprDetailTable'))
			$('aprDetailTable').hide();
		if ($('titleTable'))
			$('titleTable').show();

	}
}

function commentInsert() {
	var richEditor = editorInsert("comment", "625", "150");
	$('commentTd').update(richEditor);
	createSmartEditor("comment");
}

/**
 * 업무 전달 (SmartEditor 생성)
 * @param editorId
 * @return
 */
function createSmartEditor(editorId) {
	if(oEditors != null){
		for ( var i = 0; i < oEditors.length; i++) { //같은 이름의 에디터 객체 삭제
			if (oEditors.getById[editorId]) {
				oEditors.splice(i, 1);
			}
		}
	}
	var editorSkinURI = getPath() + "/smarteditor/SEditorSkinKOR.html";
	if (defaultLanguage === "ENG") {
		editorSkinURI = getPath() + "/smarteditor/SEditorSkinENG.html";
	}
	nhn.husky.EZCreator.createInIFrame( {
		oAppRef : oEditors,
		elPlaceHolder : editorId,
		sSkinURI : editorSkinURI,
		fCreator : "createSEditorInIFrame"
	});
}

/**
 * 업무 전달 (Editor textarea 생성)
 * @param fieldId
 * @param width
 * @param height
 * @param content
 * @return
 */
function editorInsert(fieldId, width, height, content) {
	var html = '<textarea id="' + fieldId + '" name="' + fieldId
			+ '" style="width:100%;height:' + height
			+ 'px;display:none;"></textarea>';
	return html;
}

var menuXml = null;

var selectCategoryId = "";
var selectGroupId = "";
function menuLoad(categoryId, groupId) {
	selectCategoryId = categoryId;
	selectGroupId = groupId;
	if (categoryId == null || categoryId == "") {
		var params = new Array();
		params.push("method=getMenus");
		params.push("userId=" + userId);
		params.push("compId=" + compId);
		params = params.join("&");
		request("../services/portal/homeService.jsp", params, _menuLoad, null,
				"loading", null, "failed");
	} else {
		menuLoadCallback();
	}
}
function _menuLoad() {
	menuXml = getXmlDOM(getResult());
	var resultXml = SmartXMLUtil.getChildNode(menuXml, 'Result');
	if (resultXml.getAttribute('status') == 'OK') {
		menuLoadCallback();
		var normalCategoryId = compId === 'Maninsoft' ? '40288afb1b25f00b011b25f3c7950001'
				: '40288afb1b25f00b011b25f3c7950001_' + compId;
		menuLoad(normalCategoryId, ''); // 초기 펼침 (기본업무)
	}
}
function menuLoadCallback() {
	var resultXml = SmartXMLUtil.getChildNode(menuXml, 'Result');
	var categoryListTable = $('categoryList');
	var categoryListTbody = categoryListTable.getElementsByTagName('tbody')[0];

	if (resultXml.getAttribute('status') == 'OK') {
		removeAllRow(0, categoryListTable);
		var categoryXml = SmartXMLUtil.getChildNodes(resultXml, 'category');
		for ( var i = 0; i < categoryXml.length; i++) {
			var categoryId = SmartXMLUtil.getNodeData(SmartXMLUtil
					.getChildNode(categoryXml[i], 'categoryId'));
			var categoryName = SmartXMLUtil.getNodeData(
					SmartXMLUtil.getChildNode(categoryXml[i], 'categoryName'))
					.escapeHTML();
			var catTr;
			if (selectCategoryId == categoryId) {
				catTr = new Element('tr', {
					'style' : 'cursor: pointer;font: bold',
					id : categoryId
				}).observe('click', function() {
					menuLoad(this.getAttribute('id'), '')
				});
			} else {
				catTr = new Element('tr', {
					'style' : 'cursor: pointer;',
					id : categoryId
				}).observe('click', function() {
					menuLoad(this.getAttribute('id'), '')
				});
			}
			/*
			 if(selectCategoryId != 'baseMenu' && selectCategoryId != '') {
			 $('baseMenu').hide();
			 $('baseMenuTitleTr').style.fontWeight  = "";
			 $('baseMenuIcon').setAttribute('src', '../images/icon/basic/ic_basicworks.gif');
			 } else {
			 $('baseMenu').show();
			 $('baseMenuTitleTr').style.fontWeight  = "bold";
			 $('baseMenuIcon').setAttribute('src', '../images/icon/basic/ic_basicworks_open.gif');
			 }
			 */
			var catImg = null;
			if (selectCategoryId == categoryId) {
				if (categoryId.indexOf('40288afb1b25f00b011b25f3c7950001') > -1) { //기본업무
					if (categoryName === "기본") {
						categoryName = defaultLanguage === 'KOR' ? '기본업무'
								: 'General Work';
					}
					catImg = new Element('img', {
						src : '../images/icon/basic/ic_basicworks_open.gif'
					});
				} else {
					catImg = new Element('img', {
						src : '../images/icon/category/ic_category_open.gif'
					});
				}
			} else {
				if (categoryId.indexOf('40288afb1b25f00b011b25f3c7950001') > -1) { //기본업무
					if (categoryName === "기본") {
						categoryName = defaultLanguage === 'KOR' ? '기본업무'
								: 'General Work';
					}
					catImg = new Element('img', {
						src : '../images/icon/basic/ic_basicworks.gif',
						title : categoryId
					});
				} else {
					catImg = new Element('img', {
						src : '../images/icon/category/ic_category_close.gif'
					});
				}
			}
			var catTd1 = new Element(
					'td',
					{
						'style' : 'cursor: pointer;height: 30px;border-top-width: 1px; border-top-style: solid; border-top-color: #D2DAE9;'
					}).update('&nbsp;');
			var catTd2 = new Element(
					'td',
					{
						'style' : 'cursor: pointer;border-top-width: 1px; border-top-style: solid; border-top-color: #D2DAE9;'
					}).update(categoryName);
			var catTd3 = new Element(
					'td',
					{
						'style' : 'cursor: pointer;border-top-width: 1px; border-top-style: solid; border-top-color: #D2DAE9;'
					});

			catTd3.appendChild(catImg);
			catTr.appendChild(catTd1);
			catTr.appendChild(catTd2);
			catTr.appendChild(catTd3);
			categoryListTbody.appendChild(catTr);

			if (selectCategoryId === categoryId) {
				var groupTr = new Element('tr');
				var groupTd = new Element('td', {
					colSpan : 3
				});
				var groupTable = new Element('table');
				var groupTbody = new Element('tbody');

				// 카테고리에 속한 그룹
				var groupXml = SmartXMLUtil.getChildNodes(categoryXml[i],
						'group');
				var packageXml = SmartXMLUtil.getChildNodes(categoryXml[i],
						'package');
				if (i == 0) {
					if (packageXml != null) {
						firstPackageLength = packageXml.length;
					}
				}

				for ( var k = 0; k < groupXml.length; k++) {
					var groupId = SmartXMLUtil.getNodeData(SmartXMLUtil
							.getChildNode(groupXml[k], 'groupId'));
					var groupName = SmartXMLUtil
							.getNodeData(
									SmartXMLUtil.getChildNode(groupXml[k],
											'groupName')).escapeHTML();
					var gTr;
					if (i == 0 && k == 0) {
						fristCategoryId = categoryId;
						fristGroupId = groupId;
					}
					var gImg = null;
					if (selectGroupId == groupId) {
						gTr = new Element('tr', {
							'style' : 'cursor: pointer;font: bold',
							id : groupId,
							categoryId : categoryId
						}).observe('click', function() {
							menuLoad(this.getAttribute('categoryId'), this
									.getAttribute('id'))
						});
						gImg = new Element('img', {
							src : '../images/icon/category/group_minus.gif'
						});
					} else {
						gTr = new Element('tr', {
							'style' : 'cursor: pointer;',
							id : groupId,
							categoryId : categoryId
						}).observe('click', function() {
							menuLoad(this.getAttribute('categoryId'), this
									.getAttribute('id'))
						});
						gImg = new Element('img', {
							src : '../images/icon/category/group_plus.gif'
						});
					}
					var gTd1 = new Element('td', {
						'style' : 'cursor: pointer;height: 24px;width: 5px;'
					}).update("&nbsp;");
					var gTd2 = new Element('td', {
						'style' : 'cursor: pointer;width: 20px;'
					});
					gTd2.appendChild(gImg);
					var gTd3 = new Element('td', {
						'style' : 'cursor: pointer;width: 146px;'
					}).update(groupName);
					gTr.appendChild(gTd1);
					gTr.appendChild(gTd2);
					gTr.appendChild(gTd3);
					groupTbody.appendChild(gTr);

					// 그룹에 속한 패키지 목록
					var groupPackageTr = new Element('tr');
					if (selectGroupId == groupId) {
						groupPackageTr.show();
					} else {
						groupPackageTr.hide();
					}
					var groupPackageTd = new Element('td', {
						colSpan : 3
					});
					var groupPackageTable = new Element('table');
					var groupPackageTbody = new Element('tbody');
					var groupPackageXml = SmartXMLUtil.getChildNodes(
							groupXml[k], 'package');
					for ( var j = 0; j < groupPackageXml.length; j++) {
						var packageId = SmartXMLUtil.getNodeData(SmartXMLUtil
								.getChildNode(groupPackageXml[j], 'packageId'));
						var packageType = SmartXMLUtil
								.getNodeData(SmartXMLUtil.getChildNode(
										groupPackageXml[j], 'packageType'));
						var packageName = SmartXMLUtil.getNodeData(
								SmartXMLUtil.getChildNode(groupPackageXml[j],
										'packageName')).escapeHTML();
						var isNewRecord = SmartXMLUtil
								.getNodeData(SmartXMLUtil.getChildNode(
										groupPackageXml[j], 'isNewRecord'));

						var objId = "";
						if (packageType == "SINGLE") {
							objId = SmartXMLUtil
									.getNodeData(SmartXMLUtil.getChildNode(
											groupPackageXml[j], 'formId'));
						} else if (packageType == "PROCESS") {
							objId = SmartXMLUtil.getNodeData(SmartXMLUtil
									.getChildNode(groupPackageXml[j],
											'processId'));
						}

						var pTr = new Element('tr', {
							'style' : 'cursor: pointer;',
							id : packageId,
							packageType : packageType,
							objId : objId
						}).observe('click', function() {
							clickWorkDef(this,
									this.getAttribute('packageType'), this
											.getAttribute('objId'), 'Y')
						});
						var pTd1 = new Element(
								'td',
								{
									'style' : 'cursor: pointer;height: 22px;width: 20px;'
								}).update("&nbsp;");
						var pTd2 = new Element('td', {
							'style' : 'cursor: pointer;width: 20px;'
						});
						var pImg;
						if (packageType == "PROCESS") {
							pImg = new Element('img', {
								src : '../images/icon/package/ic_process.gif'
							});
						} else {
							pImg = new Element(
									'img',
									{
										src : '../images/icon/package/ic_information.gif'
									});
						}
						pTd2.appendChild(pImg);
						if (isNewRecord == "true") {
							packageName = packageName
									+ "<img src='../images/ic_new02.gif' style='margin-left:2px;'>";
						}
						var pTd3 = new Element('td', {
							'style' : 'cursor: pointer;width: 131px;'
						}).update(packageName);
						pTr.appendChild(pTd1);
						pTr.appendChild(pTd2);
						pTr.appendChild(pTd3);
						groupPackageTbody.appendChild(pTr);
					}
					groupPackageTable.appendChild(groupPackageTbody);
					groupPackageTd.appendChild(groupPackageTable);
					groupPackageTr.appendChild(groupPackageTd);
					groupTbody.appendChild(groupPackageTr);
				}

				if (categoryId.indexOf('40288afb1b25f00b011b25f3c7950001') > -1) { //기본업무
					for ( var k = 0; k < arrBaseObj.length; k++) {

						var packageId = arrBaseObj[k].packageId;
						var packageType = arrBaseObj[k].packageType;
						var packageName = arrBaseObj[k].packageName;
						var isNewRecord = arrBaseObj[k].isNewRecord;
						var objId = arrBaseObj[k].objId;
						var packageImg = arrBaseObj[k].packageImg;

						var pTr;
						if (packageId === 'frm_schedule_SYSTEM') { //일정
							pTr = new Element('tr', {
								'style' : 'cursor: pointer;',
								id : packageId,
								packageType : packageType,
								objId : objId
							}).observe('click', function() {
								clickBaseWorkDef(this,
										'../baseWork/scheduleMonth.jsp')
							});
						} else if (packageId === 'report') {
							pTr = new Element('tr', {
								'style' : 'cursor: pointer;',
								id : packageId,
								packageType : packageType,
								objId : objId
							}).observe('click', function() {
								clickBaseWorkDef(this,
										'../report/reportList.jsp')
							});
						} else {
							pTr = new Element('tr', {
								'style' : 'cursor: pointer;',
								id : packageId,
								packageType : packageType,
								objId : objId
							}).observe('click', function() {
								clickWorkDef(this, this
										.getAttribute('packageType'), this
										.getAttribute('objId'), 'N')
							});
						}
						var pTd1 = new Element(
								'td',
								{
									'style' : 'cursor: pointer;height: 22px;width: 5px;'
								}).update("&nbsp;");
						var pTd2 = new Element('td', {
							'style' : 'cursor: pointer;width: 20px;'
						});

						var pImg = new Element('img', {
							src : packageImg
						});

						pTd2.appendChild(pImg);
						if (isNewRecord == "true") {
							packageName = packageName
									+ "<img src='../images/ic_new02.gif' style='margin-left:2px;'>";
						}
						var pTd3 = new Element('td', {
							'style' : 'cursor: pointer;width: 146px;'
						}).update(packageName);
						pTr.appendChild(pTd1);
						pTr.appendChild(pTd2);
						pTr.appendChild(pTd3);
						groupTbody.appendChild(pTr);
					}

				} else {
					//카테고리에 속한 패키지
					for ( var k = 0; k < packageXml.length; k++) {
						var packageId = SmartXMLUtil.getNodeData(SmartXMLUtil
								.getChildNode(packageXml[k], 'packageId'));
						var packageType = SmartXMLUtil.getNodeData(SmartXMLUtil
								.getChildNode(packageXml[k], 'packageType'));
						var packageName = SmartXMLUtil.getNodeData(
								SmartXMLUtil.getChildNode(packageXml[k],
										'packageName')).escapeHTML();
						var isNewRecord = SmartXMLUtil.getNodeData(SmartXMLUtil
								.getChildNode(packageXml[k], 'isNewRecord'));
						var objId = "";
						if (packageType == "SINGLE") {
							objId = SmartXMLUtil.getNodeData(SmartXMLUtil
									.getChildNode(packageXml[k], 'formId'));
						} else if (packageType == "PROCESS") {
							objId = SmartXMLUtil.getNodeData(SmartXMLUtil
									.getChildNode(packageXml[k], 'processId'));
						}

						var pTr = new Element('tr', {
							'style' : 'cursor: pointer;',
							id : packageId,
							packageType : packageType,
							objId : objId
						}).observe('click', function() {
							clickWorkDef(this,
									this.getAttribute('packageType'), this
											.getAttribute('objId'), 'N')
						});
						var pTd1 = new Element(
								'td',
								{
									'style' : 'cursor: pointer;height: 22px;width: 5px;'
								}).update("&nbsp;");
						var pTd2 = new Element('td', {
							'style' : 'cursor: pointer;width: 20px;'
						});
						var pImg;
						if (packageType == "PROCESS") {
							pImg = new Element('img', {
								src : '../images/icon/package/ic_process.gif'
							});
						} else {
							pImg = new Element(
									'img',
									{
										src : '../images/icon/package/ic_information.gif'
									});
						}
						pTd2.appendChild(pImg);
						if (isNewRecord == "true") {
							packageName = packageName
									+ "<img src='../images/ic_new02.gif' style='margin-left:2px;'>";
						}
						var pTd3 = new Element('td', {
							'style' : 'cursor: pointer;width: 146px;'
						}).update(packageName);
						pTr.appendChild(pTd1);
						pTr.appendChild(pTd2);
						pTr.appendChild(pTd3);
						groupTbody.appendChild(pTr);
					}
				}

				groupTable.appendChild(groupTbody);
				groupTd.appendChild(groupTable);
				groupTr.appendChild(groupTd);
				categoryListTbody.appendChild(groupTr);
			}
		}
	}
}
function updateScheduleByCond(linkUrl) {
	var params = new Array();
	params.push("filterId=" + $F('filterId'));
	params = params.join("&");
	update(linkUrl, "mainTd", params, null, "loading", "failed");
}

function updateMonthSchedule(year, month) {
	var v_filterSelect = "";
	var v_filterSearchKey = "";
	var v_filterSearchWord = "";
	var v_filterSearchUser = "";

	var filterSelect = document.getElementsByName("filterSelect");
	var filterSearchKey = document.getElementsByName("filterSearchKey");
	var filterSearchWord = document.getElementsByName("filterSearchWord");
	var filterSearchUser = document.getElementsByName("filterSearchUser");
	for ( var i = 0; i < filterSearchWord.length; i++) {
		if (filterSelect[i].value != "" && filterSearchKey[i].value != ""
				&& filterSearchWord[i].value != "") {
			v_filterSelect = v_filterSelect + filterSelect[i].value + "###";
			v_filterSearchKey = v_filterSearchKey + filterSearchKey[i].value
					+ "###";
			v_filterSearchWord = v_filterSearchWord + filterSearchWord[i].value
					+ "###";
			if (filterSearchUser[i].value == null
					|| filterSearchUser[i].value == "") {
				v_filterSearchUser = v_filterSearchUser + "EMPTY###";
			} else {
				v_filterSearchUser = v_filterSearchUser
						+ filterSearchUser[i].value + "###";
			}
		}
	}
	var params = new Array();
	params.push("year=" + year);
	params.push("month=" + month);
	params.push("searchWord=" + $F('searchWord'));
	params.push("filterSelect=" + encodeURIComponent(v_filterSelect));
	params.push("filterSearchKey=" + encodeURIComponent(v_filterSearchKey));
	params.push("filterSearchWord=" + encodeURIComponent(v_filterSearchWord));
	params.push("filterSearchUser=" + encodeURIComponent(v_filterSearchUser));
	params = params.join("&");
	update("../baseWork/scheduleMonth.jsp", "mainTd", params, null, "loading",
			"failed");
}
function updateWeekSchedule(searchDate) {
	var v_filterSelect = "";
	var v_filterSearchKey = "";
	var v_filterSearchWord = "";
	var v_filterSearchUser = "";

	var filterSelect = document.getElementsByName("filterSelect");
	var filterSearchKey = document.getElementsByName("filterSearchKey");
	var filterSearchWord = document.getElementsByName("filterSearchWord");
	var filterSearchUser = document.getElementsByName("filterSearchUser");
	for ( var i = 0; i < filterSearchWord.length; i++) {
		if (filterSelect[i].value != "" && filterSearchKey[i].value != ""
				&& filterSearchWord[i].value != "") {
			v_filterSelect = v_filterSelect + filterSelect[i].value + "###";
			v_filterSearchKey = v_filterSearchKey + filterSearchKey[i].value
					+ "###";
			v_filterSearchWord = v_filterSearchWord + filterSearchWord[i].value
					+ "###";
			if (filterSearchUser[i].value == null
					|| filterSearchUser[i].value == "") {
				v_filterSearchUser = v_filterSearchUser + "EMPTY###";
			} else {
				v_filterSearchUser = v_filterSearchUser
						+ filterSearchUser[i].value + "###";
			}
		}
	}
	var params = new Array();
	params.push("searchDate=" + searchDate);
	params.push("searchWord=" + $F('searchWord'));
	params.push("filterSelect=" + encodeURIComponent(v_filterSelect));
	params.push("filterSearchKey=" + encodeURIComponent(v_filterSearchKey));
	params.push("filterSearchWord=" + encodeURIComponent(v_filterSearchWord));
	params.push("filterSearchUser=" + encodeURIComponent(v_filterSearchUser));
	params = params.join("&");
	update("../baseWork/scheduleWeek.jsp", "mainTd", params, null, "loading",
			"failed");
}
function updateDaySchedule(searchDate) {
	var v_filterSelect = "";
	var v_filterSearchKey = "";
	var v_filterSearchWord = "";
	var v_filterSearchUser = "";

	var filterSelect = document.getElementsByName("filterSelect");
	var filterSearchKey = document.getElementsByName("filterSearchKey");
	var filterSearchWord = document.getElementsByName("filterSearchWord");
	var filterSearchUser = document.getElementsByName("filterSearchUser");
	for ( var i = 0; i < filterSearchWord.length; i++) {
		if (filterSelect[i].value != "" && filterSearchKey[i].value != ""
				&& filterSearchWord[i].value != "") {
			v_filterSelect = v_filterSelect + filterSelect[i].value + "###";
			v_filterSearchKey = v_filterSearchKey + filterSearchKey[i].value
					+ "###";
			v_filterSearchWord = v_filterSearchWord + filterSearchWord[i].value
					+ "###";
			if (filterSearchUser[i].value == null
					|| filterSearchUser[i].value == "") {
				v_filterSearchUser = v_filterSearchUser + "EMPTY###";
			} else {
				v_filterSearchUser = v_filterSearchUser
						+ filterSearchUser[i].value + "###";
			}
		}
	}
	var params = new Array();
	params.push("searchDate=" + searchDate);
	params.push("searchWord=" + $F('searchWord'));
	params.push("filterSelect=" + encodeURIComponent(v_filterSelect));
	params.push("filterSearchKey=" + encodeURIComponent(v_filterSearchKey));
	params.push("filterSearchWord=" + encodeURIComponent(v_filterSearchWord));
	params.push("filterSearchUser=" + encodeURIComponent(v_filterSearchUser));
	params = params.join("&");
	update("../baseWork/scheduleDay.jsp", "mainTd", params, null, "loading",
			"failed");
}
function updateListSchedule() {
	var v_filterSelect = "";
	var v_filterSearchKey = "";
	var v_filterSearchWord = "";
	var v_filterSearchUser = "";

	var filterSelect = document.getElementsByName("filterSelect");
	var filterSearchKey = document.getElementsByName("filterSearchKey");
	var filterSearchWord = document.getElementsByName("filterSearchWord");
	var filterSearchUser = document.getElementsByName("filterSearchUser");
	for ( var i = 0; i < filterSearchWord.length; i++) {
		if (filterSelect[i].value != "" && filterSearchKey[i].value != ""
				&& filterSearchWord[i].value != "") {
			v_filterSelect = v_filterSelect + filterSelect[i].value + "###";
			v_filterSearchKey = v_filterSearchKey + filterSearchKey[i].value
					+ "###";
			v_filterSearchWord = v_filterSearchWord + filterSearchWord[i].value
					+ "###";
			if (filterSearchUser[i].value == null
					|| filterSearchUser[i].value == "") {
				v_filterSearchUser = v_filterSearchUser + "EMPTY###";
			} else {
				v_filterSearchUser = v_filterSearchUser
						+ filterSearchUser[i].value + "###";
			}
		}
	}
	var params = new Array();
	params.push("searchDate=" + searchDate);
	params.push("searchWord=" + $F('searchWord'));
	params.push("filterSelect=" + encodeURIComponent(v_filterSelect));
	params.push("filterSearchKey=" + encodeURIComponent(v_filterSearchKey));
	params.push("filterSearchWord=" + encodeURIComponent(v_filterSearchWord));
	params.push("filterSearchUser=" + encodeURIComponent(v_filterSearchUser));
	params = params.join("&");
	update("../baseWork/scheduleList.jsp", "mainTd", params, null, "loading",
			"failed");
}
function setScheduleCond() {
	var v_filterSelect = "";
	var v_filterSearchKey = "";
	var v_filterSearchWord = "";
	var v_filterSearchUser = "";

	var filterSelect = document.getElementsByName("filterSelect");
	var filterSearchKey = document.getElementsByName("filterSearchKey");
	var filterSearchWord = document.getElementsByName("filterSearchWord");
	var filterSearchUser = document.getElementsByName("filterSearchUser");
	for ( var i = 0; i < filterSearchWord.length; i++) {
		if (filterSelect[i].value != "" && filterSearchKey[i].value != ""
				&& filterSearchWord[i].value != "") {
			v_filterSelect = v_filterSelect + filterSelect[i].value + "###";
			v_filterSearchKey = v_filterSearchKey + filterSearchKey[i].value
					+ "###";
			v_filterSearchWord = v_filterSearchWord + filterSearchWord[i].value
					+ "###";
			if (filterSearchUser[i].value == null
					|| filterSearchUser[i].value == "") {
				v_filterSearchUser = v_filterSearchUser + "EMPTY###";
			} else {
				v_filterSearchUser = v_filterSearchUser
						+ filterSearchUser[i].value + "###";
			}
		}
	}

	var filterId = $F('filterId');
	if (filterId.length < 8)
		filterId = "";
	var params = new Array();
	params.push("filterSaveYn=Y");
	params.push("searchWord=" + $F('searchWord'));
	params.push("filterTitle=" + $F('filterTitle'));
	params.push("filterId=" + filterId);
	params.push("filterSelect=" + encodeURIComponent(v_filterSelect));
	params.push("filterSearchKey=" + encodeURIComponent(v_filterSearchKey));
	params.push("filterSearchWord=" + encodeURIComponent(v_filterSearchWord));
	params.push("filterSearchUser=" + encodeURIComponent(v_filterSearchUser));
	params = params.join("&");
	update($F('linkUrl'), "mainTd", params, null, "loading", "failed");
}

function removeScheduleCond() {
	confirmMessage('AreYouSureYouWantToDeleteIt', _removeScheduleCond);// 삭제
	// 하시겠습니까?
}

function _removeScheduleCond() {
	var params = new Array();
	params.push("filterSaveYn=D");
	params.push("filterId=" + $F('filterId'));
	params = params.join("&");
	update($F('linkUrl'), "mainTd", params, null, "loading", "failed");
}

/*
 * jkYoon 
 * header.jsp 부분 메뉴 클릭시 이미지를 변경합니다.
 * 전체보기시 이미지 변경.
 * */

var hdTabControll = function(tab, auth,language) {
	hdTab = tab;
	hdTabAuth = auth;
	hdTabLanguage = language;
	var ul = document.getElementById("hdUl");
	var imageLanguage = '';
	if(language=='ENG'){
		imageLanguage='ENG/';
	}
	
	//var size = ul.childNodes.length;
	var size = ul.getAttribute("size");
	var idx = 7;
	
	var ep1 = "";
	var ep2 = "";
	var ep3 = "";
	var ep4 = "";
	var ep5 = "";
	var ep6 = "";
	var ep7 = "";
	
		if (tab === 1)
			ep1 = "_w";
		else if (tab === 2)
			ep2 = "_w";
		else if (tab === 3)
			ep3 = "_w";
		else if (tab === 4)
			ep4 = "_w";
		else if (tab === 5)
			ep5 = "_w";
		else if (tab === 6)
			ep6 = "_w";
		else if (tab === 7)
			ep7 = "_w";
		
		document.getElementById("topMenu1").innerHTML = '<img src="../images/header/'+imageLanguage+'btnim_today' + ep1 + '.gif">';
		document.getElementById("topMenu2").innerHTML = '<img src="../images/header/'+imageLanguage+'btnim_workad' + ep2 + '.gif">';
		document.getElementById("topMenu3").innerHTML = '<img src="../images/header/'+imageLanguage+'btnim_sche' + ep3 + '.gif">';
		document.getElementById("topMenu4").innerHTML = '<img src="../images/header/'+imageLanguage+'btnim_address' + ep4 + '.gif">';

		document.getElementById("topMenu5").innerHTML = '<img src="../images/header/'+imageLanguage+'btnim_board' + ep5 + '.gif">';
		document.getElementById("topMenu6").innerHTML = '<img src="../images/header/'+imageLanguage+'btnim_memo' + ep6 + '.gif">';
		document.getElementById("topMenu7").innerHTML = '<img src="../images/header/'+imageLanguage+'btnim_data' + ep7 + '.gif">';
		
		if (size > idx) {
			for ( var jj = idx; jj < size; jj++) {
				var ix = jj + 1;
				// jk yoon 클릭 이미지 확인용 alert
				//alert(idx+"///"+size+"///"+tab+"///"+jj+"//"+ix);
					var type = document.getElementById('li_'+ix).getAttribute("type"); 
						//ul.childNodes[jj].getAttribute("type");
					if (tab == ix) {
						if (type === 'SINGLE') {
							document.getElementById("topMenu" + ix).innerHTML = '<img src="../images/header/btnim_inform_w.gif">';
						} else if (type === 'PROCESS') {
							document.getElementById("topMenu" + ix).innerHTML = '<img src="../images/header/btnim_proces_w.gif">';
						} else if (type === 'GANTT') {
							document.getElementById("topMenu" + ix).innerHTML = '<img src="../images/header/btnim_sche_w.gif">';
						}
					} else {
						if (type === 'SINGLE') {
							document.getElementById("topMenu" + ix).innerHTML = '<img src="../images/header/btnim_inform.gif">';
						} else if (type === 'PROCESS') {
							document.getElementById("topMenu" + ix).innerHTML = '<img src="../images/header/btnim_proces.gif">';
						} else if (type === 'GANTT') {
							document.getElementById("topMenu" + ix).innerHTML = '<img src="../images/header/btnim_sche.gif">';
						}
					}
			}
		}
};
var refreshMainMenuTreeParam;
var refreshMainMenuTreeKey;
function refreshMainMenuTree(){
	$('mainMenuTreeList').contentWindow.location.href = "../main/mainMenuTree.jsp?catId="
		+ mainSelCatId
		+ "&groupId="
		+ mainSelGroupId
		+ "&param="
		+ refreshMainMenuTreeParam + "&key=" + refreshMainMenuTreeKey;
}

function toggleMainMenuTree(param, key) {
	if ($('mainMenuTree').style.display === 'none') {
		refreshMainMenuTreeParam = param;
		refreshMainMenuTreeKey = key;
		if($('mainMenuTreeList').contentWindow.location.href == 'about:blank'){
			$('mainMenuTreeList').contentWindow.location.href = "../main/mainMenuTree.jsp?catId="
				+ mainSelCatId
				+ "&groupId="
				+ mainSelGroupId
				+ "&param="
				+ param + "&key=" + key;
		}
		$('mainMenuTree').style.display = 'block';
		builderStatusYn = false;
	} else {
		$('mainMenuTree').style.display = 'none';
	}
}

function toggleMainMenuTree2(param, key) {
	/**/
	if ($('mainMenuTree2').style.display === 'none') {
		refreshMainMenuTreeParam = param;
		refreshMainMenuTreeKey = key;
		if($('mainMenuTreeList2').contentWindow.location.href == 'about:blank'){
			/*
			$('mainMenuTreeList2').contentWindow.location.href = "../main/mainMenuTree.jsp?catId="
				+ mainSelCatId
				+ "&groupId="
				+ mainSelGroupId
				+ "&param="
				+ param + "&key=" + key;
			 */
		}
		$('mainMenuTree2').style.display = 'block';
	} else {
		$('mainMenuTree2').style.display = 'none';
	}
}


// jk yoon 
function clickAddSendTask(type, formId) {
	document.getElementById("subjectDiv").style.display = 'none';
	addSendTask(type, formId, 'false', 'FORM');
}
function cancleClickAddSendTask(type, formId) {
	document.getElementById("subjectDiv").style.display = 'block';
	addSendTask(type, formId, '', '');

}
function clickProcAssigneeSetup(key) {
	document.getElementById("subjectDiv").style.display = 'none';
	procAssigneeSetup(key);
}


function toggleSelectMemberTree(hiddenId, viewName, functionName, frameId, treeId, treeListId) {
	var param;
	if (frameId == undefined || frameId == '' || frameId == 'undefined') {
		param = document.getElementById(hiddenId).getAttribute("value");
	}
	if ($(treeId).style.display == 'none') {
		$(treeListId).contentWindow.location.href = "../common/selectMemberTree.jsp" 
				+ "?selInputId="+ hiddenId
				+ "&selInputName="+ viewName
				+ "&param="+ param
				+ "&functionName=" + functionName 
				+ "&frameId=" + frameId
				+ "&treeId=" + treeId
				+ "&treeListId=" + treeListId;
		$(treeId).style.display = '';
	} else {
		$(treeId).style.display = 'none';
	}
}

/**
 * <doc>결재선 선택 리스트 보여주기 </doc>
 * @param pageNo  : 페이징 값
 * @return
 */
function approvalTypeListOpen(pageNo, searchWord) {

	$('approvalType').show();
	$('approvalType').style.left = "100";
	$('approvalType').style.top = "100";
	$('approvalType').style.width = "100";
	$('approvalType').style.height = "100";
	var searchWords = "";
	if (pageNo != undefined) {
		$('pageNo').value = pageNo;
	}
	if(searchWord != undefined){
		searchWords = searchWord;
	}
	var params = new Array();
	params.push("pageNo="+$F('pageNo'));
	params.push("searchWord="+searchWords);
	params = params.join("&");
	var linkUrl = getPath() + "/common/approvalTypeList.jsp";
	update(linkUrl, "approvalTypeList", params, null, null, "failed", false);

}
/**
 * 결재선 선택 리스트 닫기 
 * @return
 */
function approvalTypeListClose() {
	$('approvalType').hide();
}

/**
 * 
 * @param objId			: approval ObjId
 * @return
 */
function approvalLineReset(objId, level, approvalLineName) {
	var linkUrl = getPath() + "/common/approvalLineReset.jsp?objId=" + objId
			+ "&level=" + level;
	update(linkUrl, "approvalLineResetTd", null, approvalTypeListClose, null,
			"failed", false);

	var colFirst, colSecond = "";
	switch (level) {
	case "1":
		colFirst = "70%";
		colSecond = "30%";
		break;
	case "2":
		colFirst = "60%";
		colSecond = "40%";
		break;
	case "3":
		colFirst = "50%";
		colSecond = "50%";
		break;
	case "4":
		colFirst = "35%";
		colSecond = "65%";
		break;
	case "5":
		colFirst = "20%";
		colSecond = "80%";
		break;
	default:
		colFirst = "50%";
		colSecond = "50%";
		break;
	}

	$('approvalLineName').firstChild.nodeValue = approvalLineName;
	jQuery("#approvalLineResetDiv").find('col:eq(0)').width(colFirst);
	jQuery("#approvalLineResetDiv").find('col:eq(1)').width(colSecond);

	// jQuery("#approvalLineResetDiv col:first").width('70%');
	// jQuery("#approvalLineResetDiv col:last").width('70%');
}

/*
 * caster 설정창
 */
// 전체 검색 
 var toSearch = function() {
		var searchText = $F("searchText");
		var jumpMenu = $F("jumpMenu");
		var formId = $F("casterFormId");
		var params = new Array();
		params.push("searchText="+searchText);
		params.push("jumpMenu="+jumpMenu);
		params.push("formId="+formId);
		params = params.join("&");
		request("../services/portal/configFilterCasterService.jsp",params, requestCaster, null, null, null, null);
	}
// 메세지 전달
var toMessage = function() {
		var ids = document.getElementById("referenceUser").getAttribute("value");
		if (ids == "" || ids == null || ids == 'null') {
			warnMessage('Warning', 'SelectUser'); //사용자를 선택하세요.
			//alert("사용자를 선택하세요");
			return false;
		}
		var msg = document.getElementById("msg").innerHTML;
		var params = new Array();
		params.push("ids=" + ids);
		params.push("msg=" + msg);
		params = params.join("&");
		request("../services/portal/toMessageService.jsp", params, requestCasterToMessage, null, "notifySendProgress");
	}
//메세지 새로고침
function requestCasterToMessage() {
	update('../main/caster.jsp', 'casterArea', null, saveBeforeResetCasterToMessage);
}
function saveBeforeResetCasterToMessage(){
	requestCasterContents($F('casterrefreshTime'));
}
//  user 이름 클릭시 메세지 보내기
function setMessageId(id, name) {
	document.getElementById('msg').focus();
	document.getElementById('referenceUser').setAttribute('value', id);
	document.getElementById('referenceUserName').innerHTML = name;
}
// 검색창 open 
function openConfigCaster() {
	var jumpMenu = $F('jumpMenu');
	var formId = document.getElementById('casterFormId').getAttribute('value');
	var div = document.getElementById('configCaster');
	if (div.style.display == 'none') {
		$('configCaster').show();
	} else {
		$('configCaster').hide();
	}
	var params = new Array();
	params.push("jumpMenu="+jumpMenu);
	params.push("formId="+formId);
	params = params.join("&");
	update('../main/configCaster.jsp', 'configCaster', params);
}
// 사용자 정의 저장
function casterConfigSave() {
	var ids = document.getElementById("casterUserId").getAttribute("value");
	if (ids == null || ids == 'null' || ids == ''){
		ids = "default";
	}
	var jumpMenu =$F('jumpMenu');
	var formId = document.getElementById("casterFormId").getAttribute("value");
	var toSaveWord = document.getElementById("casterFilterSave").getAttribute("value");
	if (toSaveWord == null || toSaveWord == "" || toSaveWord == undefined || toSaveWord == 'undefined'){
		warnMessage('Warning', 'PleaseEnterATitle2');
		return false;
	}
	var casterCounts = $F('casterLineSize');
	var refreshTime = $F('casterRefreshTime');
	
	var params = new Array();
	params.push("ids=" + ids);
	params.push("formId=" + formId);
	params.push("casterCounts=" + casterCounts);
	params.push("refreshTime=" + refreshTime);
	params.push("toSaveWord=" + toSaveWord);
	params = params.join("&");
	request("../services/portal/configFilterCasterService.jsp",params, requestCaster, null, 'ItsBingPreserved', null, null);
}
// 사용자 정의 삭제
function casterRemoveRecond() {
	confirmMessage('AreYouSureYouWantToDeleteIt', _casterRemoveRecond);
}
function _casterRemoveRecond() {
	var jumpMenu = $F('jumpMenu');
	var formId = $F('formId');
	var checkRecordCond = $F('checkRecordCond');	
	var params = new Array();
	if (jumpMenu == 'baseSearch' || jumpMenu == '' || jumpMenu == undefined || jumpMenu == null || jumpMenu == ""){
		//alert('삭제할수 없습니다');
		//return false;
		warnMessage('Warning', 'Youcannotdeletethedefaultsearch'); //기본 검색은 삭제 할 수 없습니다.
		return false;
	}
	params.push("jumpMenu="+jumpMenu);
	params.push("formId="+formId);
	params.push("checkRecordCond="+checkRecordCond);
	params = params.join("&");
	request("../services/portal/configFilterCasterService.jsp",params, requestCaster, null, 'notifyDeleteProgress', null, null);
}
// 자동 새로고침
function requestCasterContents(casterrefreshTime1) {

	var time = casterrefreshTime1;
	if(time == '' || time == undefined || time == 'undefined' || time == null || time == 'null'){
		time = 30;
		casterrefreshTime1 = 30;
	}
	time = time * 60 * 1000;
	clearTimeout(setTimeCaster);
	update('../main/casterContents.jsp', 'casterH');
	setTimeCaster = setTimeout("requestCasterContents("+casterrefreshTime1+")", time);
}
function requestCaster() {
	update('../main/caster.jsp', 'casterArea', null, saveBeforeResetCaster);
}
function saveBeforeResetCaster(){
	requestCasterContents($F('casterrefreshTime'));
}
// 사용자 정의 검색
function updateSearch() {
	var formId = document.getElementById("casterFormId").getAttribute("value");
	var jumpMenu = $F('jumpMenu');
	var searchText = $F("searchText");
	var params = new Array();
	params.push("jumpMenu="+jumpMenu);
	params.push("formId="+formId);
	params.push("searchText="+searchText);
	params = params.join("&");
	request("../services/portal/configFilterCasterService.jsp",params, requestCasterCallBack, null, null, null, null);
}
function requestCasterCallBack() {
	var xmlDoc = getXmlDOM(getResult());
	var resultXml = SmartXMLUtil.getChildNode(xmlDoc, 'Result');
	if (resultXml.getAttribute('status') == 'OK') {
		var casterrefreshTime1 = resultXml.getAttribute('casterrefreshTime');
		document.getElementById('casterrefreshTime').setAttribute("value", casterrefreshTime1);
		requestCaster();

/*		if(casterrefreshTime1 == "")
			casterrefreshTime1 = 1;
		var time = casterrefreshTime1;
		time =  time * 60 * 1000;		
		clearTimeout(setTimeCaster);
		
		update('../main/casterContents.jsp', 'casterH');
		setTimeCaster = setTimeout("requestCasterContents("+casterrefreshTime1+")", time);*/

	}
}
function msgDelete(taskId, type) {
	var taskObjId = taskId;
	var msgType = type;
	var params = new Array();
	params.push("taskObjId=" + taskObjId);
	params.push("msgType=" + msgType);
	params = params.join("&");
	request("../main/casterContents.jsp",params, requestCaster, null, 'notifyDeleteProgress', null, null);
}

function enterDown(evt){
    var ev = (window.event)?event.keyCode:evt.keyCode;
	if(ev == 13){
		toMessage();
	}
}
function clearevent() {
	var ce = document.getElementById('searchText').setAttribute('value', "");
}
function castersearch(evt) {
	var ev = (window.event) ? event.keyCode : evt.keyCode;
	if (ev == 13) {
		updateSearch();
	}
}
function setDueDate(dueDate, dueDateTime){
	if($F(dueDate)==""){
		warnMessage('Warning', 'PleaseSelectStartDate'); //업무시작일 을 선택하세요.
		//alert("업무시작일을 선택하세요.");
		return false;
	}
	var date =$F(dueDate)+" "+$F(dueDateTime)+":00";
	var params = new Array();
	params.push("language="+$F('userLanguage'));
	params.push("userId="+$F('userId'));
	params.push("packId="+$F('packageId'));
	params.push("packVer=1");
	params.push("compId="+$F('compId'));
	params.push("diagramId=SmartWorkbenchEditor");
	params.push("dueDate="+date);
	params.push("serviceUrl="+$F('serviceUrl'));
	params = params.join("&");
	update("../common/diagram.jsp","smartWorkbenchEditorTd",params);
}

function saveCookie(key, value){
	document.cookie = key +"="+escape(value);
}

function readCookie(key){
	var str = document.cookie;

	var start = str.indexOf(key);
	if(start == -1)
		return "";

	start = start + key.length+1;
	end = str.indexOf(";",start);

	if(end==-1)
		end = str.length;

	var str2 = str;
	str = str.substring(start, end);
	str2 = str2.substring(start-1,start);
	if(str2 != "="){
		str = "";
	}
	return unescape(str);
}
function removeCookie(key){
	var expDate = new Date();
	expDate.setTime(expDate.getTime()-1);

	var cookieVal = readCookie(key);
	if(cookieVal !=null){
		saveCookie(key, cookieVal, expDate);
	}
} 

function locationIndex(){
	location.href='../main/index.jsp';
}

function popProjectTeam(fieldName, fieldId, isAddTask){
	//$('projectTeamDiv').show();
	var params = new Array();
	params.push('fieldName='+fieldName);
	params.push('fieldId='+fieldId);
	params.push('isAddTask='+isAddTask);
	params = params.join('&');
	if(isAddTask == '1'){
		document.getElementById('projectTeamDivAddTask').style.display='block';
		update('../workStart/popup/projectTeamPopup.jsp','projectTeamTdAddTask',params);
	}else{
		document.getElementById('projectTeamDiv').style.display='block';
		update('../workStart/popup/projectTeamPopup.jsp','projectTeamTd',params);
	}
}

function hidePopProjectTeam(isAddTask){
	//$('projectTeamDiv').hide();
	if(isAddTask == '1'){
		document.getElementById('projectTeamDivAddTask').style.display='none';
	}else{
		document.getElementById('projectTeamDiv').style.display='none';
	}
}
function projectTeamInput(fieldName, projectName, fieldId, projectId, isAddTask){
	document.getElementById(fieldName).setAttribute("value", projectName);
	document.getElementById(fieldId).setAttribute("value", projectId);
	hidePopProjectTeam(isAddTask);
}
function goProjectTeamPopup(pageNo, fieldName, fieldId, searchWord) {
	var params = new Array();
	params.push("pageNo="+pageNo);
	params.push("fieldName="+fieldName);
	params.push("fieldId="+fieldId);
	if(searchWord != undefined || searchWord != null)
		params.push("searchWord="+searchWord);
	params = params.join("&");
//alert(params);	
	update("../workStart/popup/projectTeamPopup.jsp", "projectTeamTd", params, null, "loading", "failed");
}
function selectForm2(frmName, formId) {
	if (formId == '') {
		$('selectDifferentTaskTd').show();
		var url = getPath() + "/common/dialog/selectForm.jsp";
		var params = new Array();
		params.push("frmName=" + frmName);
		params = params.join("&");
		popupModalDialog(url, params, "");
		document.searchForm.searchWord.focus();
		searchForms2('1');
	} else {
		$('selectDifferentTaskTd').hide();
		document.getElementById("receiptFormId").value = formId;
		document.getElementById("assigneeTaskFormName").value = "";
	}
}
function searchWorker(elementId, selectId, type, mode, seq, opt) {
	var keyCode = checkSearchWorkerKey();
	if(keyCode == 40){
		$(selectId).focus();
		$(selectId).selectedIndex = 0;
	}else{
		var staff = $F(elementId);
		var params = new Array();
		params.push("staff="+staff);
		params.push("type="+type);
		params.push("mode="+mode);
		params.push("seq="+seq);
		params.push("opt="+opt);
		params = params.join("&");
		$('searchWorkerId').show();
		update("../services/portal/searchWorker.jsp", "searchWorkerId", params);
	}
}
function checkSearchWorkerKey(e){
	var keyCode;
	if(window.event) keyCode = window.event.keyCode;
	else if(e) keyCode = e.which;
	return keyCode;
}
function insertWorker(type, mode, seq, opt) {
	if (type != "multi") {
		var select = document.getElementById('searchStaff');
		var id = select[select.selectedIndex].value;
		var name = select[select.selectedIndex].text;
		try{
			var inId = document.selTreeForm.selInputId.value;
			var userField = FormUserUtil.getFormUserByUserFieldId(inId);
			var selInputName = document.selTreeForm.selInputName.value;
			var selInputId = document.selTreeForm.selInputId.value;
			
			if (userField != null) {
				userField.setValue(id);
				userField.setName(name);
				releaseModalDialog(false);
				  return;
			}
		}catch(e){}		
		//alert(selInputId+'//'+selInputName+'//'+mode+'//'+seq+'//'+id+'//'+name);
		if (mode == "user") {
			if(opt =='delegate'){
				selectedUser(id,'',name,'delegate');
				return;
			}else{
				if (seq == "") {
					document.getElementsByName(selInputName)[0].value = name;
					document.getElementsByName(selInputId)[0].value = id;
				} else {
					document.getElementsByName(selInputName)[seq].value = name;
					document.getElementsByName(selInputId)[seq].value = id;
				}
				if (selInputId != "approvalsId" && selInputId != "subTaskAssignee") {
					if(document.getElementById("assigneeTaskTr") != null) {
						document.getElementById("assigneeTaskTr").style.display = "";
					}
				}
			}
		}
		releaseModalDialog(false);
	} else {
		
		var name = document.getElementById('selInputNameValue').value;
		var id = document.getElementById('selInputValue').value;	
		
		if (name == '' || name == undefined || name == null){
			var select = document.getElementById('searchStaff');
			var id = select[select.selectedIndex].value;
			var name = select[select.selectedIndex].text;
			
			var id = id + ";";
			var name = name + ";";
			
			document.getElementById('selInputNameValue').focus();
			document.getElementById('selInputValue').setAttribute('value', id);
			document.getElementById('selInputNameValue').innerHTML = name;
			document.getElementById('searchW').setAttribute('value','');
			document.getElementById('searchWorkerId').hide();
			document.getElementById('searchW').focus();
			
		} else {
			var select = document.getElementById('searchStaff');
			var ids = select[select.selectedIndex].value;
			var names = select[select.selectedIndex].text;
			
			id = id+ids+";";
			name = name+names+";";
			
			document.getElementById('selInputNameValue').focus();
			document.getElementById('selInputValue').setAttribute('value', id);
			document.getElementById('selInputNameValue').innerHTML = name;
			document.getElementById('searchW').setAttribute('value','');
			document.getElementById('searchWorkerId').hide();
			document.getElementById('searchW').focus();
		}
	}
}

function enterDowns(evt, type, mode, seq, opt){
    var ev = (window.event)?event.keyCode:evt.keyCode;
	if(ev == 13){
		if (type != "multi") {
			var select = document.getElementById('searchStaff');
			var id = select[select.selectedIndex].value;
			var name = select[select.selectedIndex].text;
			try{
				var inId = document.selTreeForm.selInputId.value;
				var userField = FormUserUtil.getFormUserByUserFieldId(inId);
				var selInputName = document.selTreeForm.selInputName.value;
				var selInputId = document.selTreeForm.selInputId.value;
				if (userField != null) {
					userField.setValue(id);
					userField.setName(name);
					releaseModalDialog(false);
					  return;
				}
			}catch(e){}
			if (mode == "user") {
				if(opt =='delegate'){
					selectedUser(id,'',name,'delegate');
					return;
				}else{
					if (seq == "") {
						document.getElementsByName(selInputName)[0].value = name;
						document.getElementsByName(selInputId)[0].value = id;
					} else {
						document.getElementsByName(selInputName)[seq].value = name;
						document.getElementsByName(selInputId)[seq].value = id;
					}
	
					if (selInputId != "approvalsId" && selInputId != "subTaskAssignee") {
						if (document.getElementById("assigneeTaskTr") != null) {
							document.getElementById("assigneeTaskTr").style.display = "";
						}
					}
				}
			}
			releaseModalDialog(false);
		} else {
			var name = document.getElementById('selInputNameValue').value;
			var id = document.getElementById('selInputValue').value;	
			if (name == '' || name == undefined || name == null){
				var select = document.getElementById('searchStaff');
				var id = select[select.selectedIndex].value;
				var name = select[select.selectedIndex].text;
				var id = id + ";";
				var name = name + ";";
				document.getElementById('selInputNameValue').focus();
				document.getElementById('selInputValue').setAttribute('value', id);
				document.getElementById('selInputNameValue').innerHTML = name;
				document.getElementById('searchW').setAttribute('value','');
				document.getElementById('searchWorkerId').hide();
				document.getElementById('searchW').focus();
			} else {
				var select = document.getElementById('searchStaff');
				var ids = select[select.selectedIndex].value;
				var names = select[select.selectedIndex].text;
				id = id+ids+";";
				name = name+names+";";
				document.getElementById('selInputNameValue').focus();
				document.getElementById('selInputValue').setAttribute('value', id);
				document.getElementById('selInputNameValue').innerHTML = name;
				document.getElementById('searchW').setAttribute('value','');
				document.getElementById('searchWorkerId').hide();
				document.getElementById('searchW').focus();
			}
		}
	}
}

function subTaskHistoryDetailView(objId, procId, procInstId){
	if($(objId+'HistoryTr').style.display == 'none'){
		$(objId+'HistoryTr').show();
		var params = new Array();
		params.push('processId='+procId);
		params.push('procInstId='+procInstId);
		params.push('type=sub');
		params= params.join("&");
		update("../proc/procHistory.jsp", objId+"HistoryTd",params);
	}else{
		$(objId+'HistoryTr').hide();
	}
}

function goParentTaskProcess(processId,procInstId,pkgType){
	hdTabControll(0,null,null);
	var params = new Array();
	params.push("procInstId=" + procInstId);
	params.push("processId=" + processId);
	params.push("formType="+pkgType);
	params = params.join("&");
	var linkUrl = "../proc/procView.jsp";
	update(linkUrl, "mainTd", params, null, "loading", "faield");
}

function diagramViewYn(lan){
	var altTitleOpen = "";
	var altTitleClose = "";
	if(lan == 'KOR'){
		altTitleOpen = "프로세스 다이어그램 열기";
		altTitleClose = "프로세스 다이어그램 닫기";
	}else{
		altTitleOpen = "diagram open";
		altTitleClose = "diagram close";
	}

	if($('diagramTd').style.display == 'none'){
		$('diagramTd').show();
		$('diagramIcon').src = "../images/close_diagram.gif";
		$('diagramIcon').setAttribute("alt",altTitleClose);
		$('diagramIcon').setAttribute("title",altTitleClose);
		
	}else{
		$('diagramTd').hide();
		$('diagramIcon').src = "../images/open_diagram.gif";
		$('diagramIcon').setAttribute("alt",altTitleOpen);
		$('diagramIcon').setAttribute("title",altTitleOpen);
	}
}

function dashboardViewYn(lan){
	var altTitleOpen = "";
	var altTitleClose = "";
	if(lan == 'KOR'){
		altTitleOpen = "현황판 열기";
		altTitleClose = "현황판 닫기";
	}else{
		altTitleOpen = "dashboard open";
		altTitleClose = "dashboard close";
	}
	if($('dashboardTr').style.display == 'none'){
		$('dashboardTr').show();
		$('dashboardIcon').src = "../images/close_diagram.gif";
		$('dashboardIcon').setAttribute("alt",altTitleClose);
		$('dashboardIcon').setAttribute("title",altTitleClose);
		
	}else{
		$('dashboardTr').hide();
		$('dashboardIcon').src = "../images/open_diagram.gif";
		$('dashboardIcon').setAttribute("alt",altTitleOpen);
		$('dashboardIcon').setAttribute("title",altTitleOpen);
	}
}

//////////////////////////////////////////////Demo// ////////////////////////////////////////////////////////////////////
function updateSearchDemo() {
	var formId = document.getElementById("casterFormId").getAttribute("value");
	var jumpMenu = $F('jumpMenu');
	var searchText = $F("searchText");
	var params = new Array();
	params.push("jumpMenu=" + jumpMenu);
	params.push("formId=" + formId);
	params.push("searchText=" + searchText);
	params = params.join("&");
	request("../services/portal/configFilterCasterService.jsp", params,
			requestCasterDemo, null, null, null, null);
}
var toSearchDemo = function() {
	var searchText = $F("searchText");
	var jumpMenu = $F("jumpMenu");
	var formId = $F("casterFormId");
	var params = new Array();
	params.push("searchText=" + searchText);
	params.push("jumpMenu=" + jumpMenu);
	params.push("formId=" + formId);
	params = params.join("&");
	request("../services/portal/configFilterCasterService.jsp", params,
			requestCasterDemo, null, null, null, null);
}
function requestCasterContentsDemo(casterrefreshTime1) {
	var time = casterrefreshTime1;
	if (time == '' || time == undefined || time == 'undefined' || time == null
			|| time == 'null') {
		time = 30;
	}
	time = time * 60 * 1000;
	update('../demo/casterContentsDemo.jsp', 'casterH');
	setTimeout("requestCasterContentsDemo(" + casterrefreshTime1 + ")", time);
}
function requestCasterDemo() {
	update('../demo/caster.jsp', 'casterArea', null, saveBeforeResetCasterDemo);
}
function saveBeforeResetCasterDemo() {
	requestCasterContentsDemo($F('casterrefreshTime'));
}
function openConfigCasterDemo() {
	var jumpMenu = $F('jumpMenu');
	var formId = document.getElementById('casterFormId').getAttribute('value');
	var div = document.getElementById('casterDownPopup');
	if (div.style.display == 'none') {
		$('casterDownPopup').show();
	} else {
		$('casterDownPopup').hide();
	}
	var params = new Array();
	params.push("jumpMenu=" + jumpMenu);
	params.push("formId=" + formId);
	params = params.join("&");
	update('../demo/configCasterDemo.jsp', 'casterDownPopup', params);
}
function serachword(evt) {
	var ev = (window.event) ? event.keyCode : evt.keyCode;
	if (ev == 13) {
		var formId = document.getElementById('casterFormId').getAttribute(
				'value');
		var jumpMenu = $F('jumpMenu');
		var searchText = $F('searchText');
		var params = new Array();
		params.push("jumpMenu=" + jumpMenu);
		params.push("formId=" + formId);
		params.push("searchText=" + searchText);
		params = params.join("&");
		request("../services/portal/configFilterCasterService.jsp", params,
				requestCasterDemo, null, null, null, null);
	}
}
function clearSearch() {
	document.getElementById('searchText').setAttribute('value', "");
}
function setMessageIds(id, name) {

	//document.getElementById('msg').focus();
	document.getElementById('selectOrgtreeId').setAttribute('value', id);
	document.getElementById('referenceUserName').innerHTML = name;
}
function setting() {
	var div = document.getElementById('selectorgtree');
	if(div.style.display == 'none') {
		$('selectorgtree').show();
		$('dtreeBoxList').contentWindow.location.href = "orgTreeListDemo.jsp";
	}else{
		$('selectorgtree').hide();
	}
}
function settingCancel() {
	$('selectorgtree').hide();
}
function setNames(id, name){
	var names = document.getElementById('importBoxName').innerHTML;
	var ids  = document.getElementById('selectOrgtreeId').getAttribute('value');
	if(names == null || names == undefined || names == ""){
		document.getElementById('importBoxName').innerHTML = name;
		document.getElementById('selectOrgtreeId').setAttribute('value', id);
	}else{
		var setnames = names + ";" + name;
		var setids = ids + ";" + id;
		document.getElementById('importBoxName').innerHTML = setnames;
		document.getElementById('selectOrgtreeId').setAttribute('value', setids);
	}
}
function settingConfirm(){
	$('selectorgtree').hide();
	var names = document.getElementById('importBoxName').innerHTML;
	document.getElementById('referenceUserName').innerHTML = names;
}

function msgDown(evt) {
	var ev = (window.event) ? event.keyCode : evt.keyCode;
	if (ev == 13) {
		toMessageDemo();
	}
}

var toMessageDemo = function() {
	var ids = document.getElementById("selectOrgtreeId").getAttribute("value");
	if (ids == "" || ids == null || ids == 'null') {
		warnMessage('Warning', 'SelectUser'); // 사용자를 선택하세요.
		return false;
	}
	var msg = $F("msgContent");
	var params = new Array();
	params.push("ids=" + ids);
	params.push("msg=" + msg);
	params = params.join("&");
	request("../services/portal/toMessageService.jsp", params, requestCasterToMessageDemo, null, "notifySendProgress");
}
function requestCasterToMessageDemo() {
	update('../demo/caster.jsp', 'casterArea', null, saveBeforeResetCasterToMessageDemo);
}
function saveBeforeResetCasterToMessageDemo() {
	requestCasterContentsDemo($F('casterrefreshTime'));
}
function casterConfigSaveDemo() {
	var ids = document.getElementById("casterUserId").getAttribute("value");
	if (ids == null || ids == 'null' || ids == '') {
		ids = "default";
	}
	var jumpMenu = $F('jumpMenu');
	var formId = document.getElementById("casterFormId").getAttribute("value");
	var toSaveWord = $F("casterFilterSave");
	if (toSaveWord == null || toSaveWord == "" || toSaveWord == undefined
			|| toSaveWord == 'undefined') {
		//warnMessage('Warning', 'PleaseEnterATitle2');
		alert("Please Enter Config Name");
		return false;
	}
	var casterCounts = $F('casterLineSize');
	var refreshTime = $F('casterRefreshTime');

	var params = new Array();
	params.push("ids=" + ids);
	params.push("formId=" + formId);
	params.push("casterCounts=" + casterCounts);
	params.push("refreshTime=" + refreshTime);
	params.push("toSaveWord=" + toSaveWord);
	params = params.join("&");
	request("../services/portal/configFilterCasterService.jsp", params, requestCasterDemo, null, null, null, null);
}
function chageWorkCategory(selectContent) {
	var params = new Array();
	if(selectContent == "caster"){
		params.push("casterArea="+"caster");
		params = params.join("&");
	}else if (selectContent == "workcategory"){
		params.push("casterArea="+"workcategory");
		params = params.join("&");
	}
	location.href="../demo/casterDemoIndex.jsp?"+params;
}
/////////////////////////////////////////////Demo// ////////////////////////////////////////////////////////////////////
function parsing(responseXml) {
	var xml = SmartXMLUtil.getXML(responseXml);
	var auth_token = SmartXMLUtil.getChildNode(xml, 'result');
	auth_token = SmartXMLUtil.getNodeData(auth_token);
	var params = new Array();
	params.push("auth_token="+auth_token);
	params = params.join("&");
	request("../demo/clearvale.jsp", params, callback, null, null, null, null);
}
function callback(){
}

function openNewRecord(param){
	var url = "../common/popNewRecord.jsp";
	releaseModalDialog(true);
	popupModalDialog(url, param);
//param용	
//	var url = getPath() + "/common/referenceTaskList.jsp";
//	var params = '?formId=' + this.refFormId + '&fieldId=' + this.refFormFieldId + '&formFieldId=' + id + '&mode=form';
//	popupModalDialog(url, params);
	
	//window.open('../common/newRecord.jsp'+param, '', 'width=700px, height=500px, scrollbars=yes,resizable=yes');
}
function paging(pageNo) {
	document.listForm.pageNo.value = pageNo;
	document.listForm.submit();
}

function referencePaging(pageNo,totalSize,pageSize,formId, fieldId, formFieldId){
	var url = "../common/referenceTaskList.jsp";
	var params = '?formId=' + formId + '&fieldId=' + fieldId + '&formFieldId=' + formFieldId + '&mode=form&pageNo='+pageNo+'&totalSize='+totalSize+'&pageSize='+pageSize;
	releaseModalDialog(true);
	popupModalDialog(url, params);
}
function updateRecordList(formId, fieldId, formFieldId, totalSize){
	var url = "../common/referenceTaskList.jsp";
	var params = '?formId=' + formId + '&fieldId=' + fieldId + '&formFieldId=' + formFieldId + '&mode=form&pageNo=&totalSize='+totalSize+'&pageSize=&searchWord='+$F('searchWordRef');
	releaseModalDialog(true);
	popupModalDialog(url, params);
}

function enterDownRef(evt,formId, fieldId, formFieldId, totalSize){
	var ev = (window.event) ? event.keyCode : evt.keyCode;
	if (ev == 13) {
		updateRecordList(formId, fieldId, formFieldId, totalSize);
	}
}

function listClick (recordId, formFieldId) {
	var fieldValue = $F('realValue_' + recordId);
	fieldValue = fieldValue.replace(/@@@@@/gi,"'");
	var refField = FormRefUtil.getFormRefByRefFieldId(formFieldId);
	if(refField != null){
		refField.setValue(recordId);
		refField.setName(fieldValue);
		var formRuntime = jQuery("#workspace").data("FormRuntime");
		formRuntime.refreshCombo();
	}
	releaseModalDialog(true);
}

function entDown(){
	var ev = (window.event)?event.keyCode:evt.keyCode;
		if(ev == 13){	
			approvalTypeListOpen(1, $F("popSearchWord"));
		}
}

function insertId(opt){
	$('searchWorkerId').hide();
	var ids = document.selTreeForm.searchW.value;
	var type = document.selTreeForm.type.value;
	
	if(type == 'single'){
		selectedUser(ids, '', ids,opt);
	}else{
		checkedUser(ids, '', ids);
	}
}

// excel

function excelDownFormList() {
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
	params.push("filterSearchWord=" +  escape(encodeURI(v_filterSearchWord, "UTF-8")));
	params.push("filterSearchUser=" + v_filterSearchUser);
	params.push("userId=" + userId);
	params.push("userLanguage=" + defaultLanguage);
	params.push("compId=" + compId);
	params = params.join("&");
	
	var width = "320";
	var height= "80";
	var LeftPosition = (screen.width) ? (screen.width-width)/2 : 0;
	var TopPosition = (screen.height) ? (screen.height-height)/2-50 : 0;
		
	window.open("../form/excelExportFormList.jsp?"+params, '', 'width=100px, height=100px,left='+LeftPosition+',top='+TopPosition+',scrollbars=no,resizable=yes');
	//update("../form/excelExportFormList.jsp", "", params, updateListRecord, "", "");
}


function excelDownProcList() {
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
		params.push("filterSearchWord=" +  escape(encodeURI(v_filterSearchWord, "UTF-8")));
		
		params.push("filterSearchUser=" + v_filterSearchUser);
		params.push("userId=" + userId);
		params.push("userLanguage=" + defaultLanguage);
		params.push("compId=" + compId);
		params = params.join("&");
		
		var width = "320";
		var height= "80";	
		var LeftPosition = (screen.width) ? (screen.width-width)/2 : 0;
		var TopPosition = (screen.height) ? (screen.height-height)/2-50 : 0;
		
		window.open("../proc/excelExportProcList.jsp?"+params, '', 'width=100px, height=100px,left='+LeftPosition+',top='+TopPosition+', scrollbars=no,resizable=yes');
		//request(getPath() + "/services/portal/homeService.jsp", params, updateListProcInstCallback);
	}catch(e){
		//var ss = warnMessage('경고', '선택하신 업무는 업무정의 수정중 입니다.',locationIndex);
		return false;
	}
}

function checkBytes(event) {

    var evtObject = document.reply.opinionStr;

    if(evtObject.addEventListener) {
        evtObject.addEventListener("keypress", isKeyPress, false); 
    } else if(evtObject.attachEvent) {
        evtObject.attachEvent("onkeyup", isKeyPress);
    }
}

function isKeyPress(e) {

	var length = 0;
	var opinionValue = document.getElementById('opinionStr').value;
	var temp = opinionValue;
	var escTemp;
	if(temp != "" && temp != null) {
		for(var i=0; i<temp.length; i++) {
			if(temp.charAt(i) != escape(temp.charAt(i))) {
				escTemp = escape(temp.charAt(i));
				if(escTemp.length >= 6) {
					length += 2;
				} else {
					length += 1;
				}
			} else {
				length += 1;
			}
		}
	}

	if(length > 4000) {
		alert("제한글자수(4000byte)를 초과하였습니다.");
		return;
	}

    document.getElementById('byteCheck').innerHTML = length + "/4000 (byte)";
}

function downloadExcelForm(categoryName, formId, formName) {

	var loadType = "2";

	var form = document.listForm;
	var params = new Array();
	params.push("formId=" + formId);
	params = params.join("&");
	update("../form/downloadExcelForm.jsp", "mainTd", params, viewRecordCallBack, "loading", "failed");
	//update("../form/formView.jsp", "mainTd", params, viewRecordCallBack, "loading", "failed");
}

function viewRecordCallBack() {
	var loadType = $F('loadType');
	var formId = $F('formId');
	var recordId = $F('recordId');
	var version = $F('version');
	if(loadType == "2") {
		var formWork = new FormWork('workspace');
		$('workspace')['formWork'] = formWork;
		formWork.initFormRuntime(userId, '../', formId, version, '', recordId, loadType, 'downLoadForm');
	}
}

function goIndex() {
	location.href = "../main/index.jsp";
}