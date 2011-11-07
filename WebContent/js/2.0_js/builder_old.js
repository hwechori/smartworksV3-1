var selCatId = null;
var selCatSize = 0;
var selGroupId = null;
var selGroupSize = 0;
var selWorkDefId = null;
var selWorkDefType = null;
var selWorkDefIds = new Array();
var selFormId = null;

/**
 * 메뉴전체를 갱신합니다.
 * @param id 기본 선택할 메뉴아이디 (카테고리아이디)
 * @return
 */
function updateMenuListView(id) {
	if (isNull(id))
		id = selCatId;
	
	var url = getPath() + "/builder/gadget/categoryMenuList.jsp";
	var target = "menuListView";
	send(url, target);
	
	if (!isNull(id))
		selectCategory(id);
}
/**
 * 카테고리를 생성하는 대화상자를 띄웁니다.
 * @param name: 이름 기본값
 * @param desc: 설명 기본값
 * @return
 */
function popupCreateCategoryModalDialog() {
	popupNameDescModalDialog("createCategoryForm", createCategory);
}
/**
 * 카테고리를 수정하는 대화상자를 띄웁니다.
 * @param id
 * @return
 */
function popupSetCategoryModalDialog(id) {
	if (isNull(id))
		id = selCatId;
	if (isNull(id)) {
		warnMessage("errorCodeNotSelected");
		return;
	}
	var obj = getCategory(id);
	var name = obj["name"];
	var desc = obj["description"];
	popupNameDescModalDialog("setCategoryForm", setCategory, id, name, desc);
}
/**
 * 카테고리선택 이벤트 시의 처리할 내역입니다.
 * @param id
 * @return
 */
function selectCategory(id) {
	// 1. 업무양식 뷰를 숨깁니다.
	hideFormListView();
	// 2. 에디터를 숨김니다.
	hideEditorView();
	// 3. 선택한메뉴를 갱신합니다.
	updateCategoryMenuView(id);
	// 4. 메인화면을 갱신합니다.
	updateCategoryMainView(id);
}
var updateCategoryMenuView_id;
/**
 * 메뉴를 아이디에 해당하는 카테고리가 선택된 상태로 갱신
 * 하위 업무정의를 리스트 시킴
 * @param id
 * @return
 */
function updateCategoryMenuView(id) {
	updateCategoryMenuView_id = id;
	var url = getPath() + "/services/builder/builderService.jsp";
	//var params = "method=getPackageListByCategory&listType=0&categoryId=" + id + "&pageCount=-1&recordCount=-1";
	var params = new Array();
	params.push("method=getPackageListByCategory");
	params.push("listType=0");
	params.push("categoryId=" + id);
	params.push("pageCount=-1");
	params.push("recordCount=-1");
	params.push("compId=" + compId);
	params = params.join("&");
	request(url, params, updateCategoryMenuViewCallback, null, "loading", null, "failed");
}
function updateCategoryMenuViewCallback() {
	hide("worksMenu_" + selCatId);
	unbold("headMenu_" + selCatId);
	unbold(selGroupId);
	unbold(selWorkDefId);
	if($(selCatId+'CategoryIcon'))
		$(selCatId+'CategoryIcon').setAttribute('src', '../images/icon/category/ic_category_close.gif');

	selCatId = null;
	selCatSize = 0;
	selGroupId = null;
	selGroupSize = 0;
	selWorkDefId = null;
	selWorkDefType = null;
	selFormId = null;
	
	var id = updateCategoryMenuView_id;
	var xmlDoc = getXmlDOM(getResult());
	var resultXml = SmartXMLUtil.getChildNode(xmlDoc, 'Result');
	//alert(SmartXMLUtil.getXMLString(xmlDoc));
	
	// TODO
	var groupSize = 0;
	var groups = SmartXMLUtil.getChildNodes(resultXml, 'category');
	
	if (!isEmpty(groups))
		groupSize = groups.length;

	var workDefSize = 0;
	var workDef = SmartXMLUtil.getChildNodes(resultXml, 'Package');
	var menu = document.getElementById("worksMenu_" + id);
	
	if (!isEmpty(workDef))
		workDefSize = workDef.length;//workDefIds.length;
	
	var table = menu;
	var size = table.rows.length;
	for (var i=0; i<size; i++)
		table.deleteRow(0);
	
	//menu.border = "1";
	var btnTR = menu.insertRow(-1);
	btnTR.id="btnTr"
	var btnTD = document.createElement('td');
	btnTD.style.wordBreak = "break-all";
	if (groupSize > 0 || workDefSize > 0) {		//for FF
		btnTD.colSpan = 3;
	} else {
		btnTD.width = "155";
	}
	btnTD.height = 20;
	btnTD.align = "right";
	btnTD.vAlign = "middle";
	if (id.indexOf('40288afb1b25f00b011b25f3c7950001') > -1) {	//기본업무
		btnTD.innerHTML = '<img src="../images/common/ibt_text.gif"  border="0" onClick="popupSetWorkDefModalDialog()" style="cursor:pointer;"  alt="업무정의 변경">';
	} else {
		btnTD.innerHTML = '<img src="../images/common/ibt_add.gif"  border="0" onClick="popupCreateWorkDefModalDialog(\'' + id + '\')" style="cursor:pointer;" alt="업무정의 추가">&nbsp;' +
						  '<img src="../images/common/ibt_delete.gif"  border="0" onclick="removeWorkDef()" style="cursor:pointer;" alt="업무정의 삭제">&nbsp;' +
						  '<img src="../images/common/ibt_text.gif"  border="0" onClick="popupSetWorkDefModalDialog()" style="cursor:pointer;"  alt="업무정의 변경">&nbsp;' +
						  '<img src="../images/common/ibt_c.gif" onclick="cloneWorkDef()" style="cursor:pointer;"  alt="업무정의 복사">&nbsp;' +
						  '<img src="../images/common/ibt_m.gif" onclick="popupCloneWorkDefModalDialog()" style="cursor:pointer;" alt="다른카테고리 업무정의 복사">';
	}
	btnTR.appendChild(btnTD);

	var imgStr = "";
	selCatSize = workDef.length;

	for (var i=0; i<groupSize; i++){
		var tr = menu.insertRow(-1);
		tr.id = groups[i].getAttribute('objId')
		tr.setAttribute('height', 24);

		var td1 = document.createElement('td');
		var td2 = document.createElement('td');
		var td3 = document.createElement('td');
		
		td1.id=groups[i].getAttribute('objId') + "_td1";
		td2.id=groups[i].getAttribute('objId') + "_td2";
		td3.id=groups[i].getAttribute('objId') + "_td3";

		td1.width = 5;
		td2.width = 24;
		td3.width = 120;

		td2.align = "right";
		td2.vAlign = "middle";

		td3.align = "left";
		td3.vAlign = "middle";

		imgStr = '<img src="../images/icon/category/group_plus.gif" style="cursor:pointer;margin-right: 4px;" style="cursor:pointer;" id="'+groups[i].getAttribute('objId')+'Icon" onClick="selectGroup(\''+groups[i].getAttribute('objId')+'\');">';
		td1.innerHTML = '&nbsp;';
		td2.innerHTML = imgStr;
		td3.innerHTML = '<p style="cursor:pointer;" onClick="selectGroup(\''+groups[i].getAttribute('objId')+'\');">' + groups[i].getAttribute('name') + '</p>';
		tr.appendChild(td1);
		tr.appendChild(td2);
		tr.appendChild(td3);
		
		//자식 업무 TR
		var cTr = menu.insertRow(-1);
		var td = document.createElement('td');
		td.colSpan = 3;
		td.id = groups[i].getAttribute('objId') + '_child';
		cTr.appendChild(td);
	}
	
	for (var i=0; i < workDefSize; i++){
		var workDefId = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(workDef[i], 'packageId'));
		var workDefName = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(workDef[i], 'name'));
		var workDefType = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(workDef[i], 'type'));

		//문서관리, 일정관리, 회사관리, 부서관리, 역할관리, 사용자관리 제외
		if(workDefId.indexOf('pkg_19281471d5c9404392fea653e627da9e') < 0 && workDefId.indexOf('pkg_24245093482e404fae15a7b48a55f854') < 0 && workDefId.indexOf('pkg_fbbd1761c3f144d49337dc38119caa28') < 0 && workDefId.indexOf('pkg_c2156de59c14435bb551c61c1593a442') < 0 && workDefId.indexOf('pkg_df40ac03a33c41d59586e4b201b433fd') < 0 && workDefId.indexOf('pkg_394ea78cec37434d922c73f09ab4b24e') < 0) {
			var tr = menu.insertRow(-1);
			tr.id = workDefId;
			tr.setAttribute('height', 24);
	
			var td3 = document.createElement('td');
			var td4 = document.createElement('td');
			var td5 = document.createElement('td');
	
			td3.id = workDefId + "_td3";
			td4.id = workDefId + "_td4";
			td5.id = workDefId + "_td5";
	
			td3.width = 120;
			td4.width = 24;
			td5.width = 5;
	
			td4.align = "center";
			td4.vAlign = "top";
			td4.style.padding = "3px";
	
			td3.align = "left";
			td3.vAlign = "middle";
	
			if(workDefType == 'PROCESS'){
				imgStr = '<img src=../images/icon/package/ic_process.gif>';
			}else if(workDefType == 'SINGLE'){
				imgStr = '<img src=../images/icon/package/ic_information.gif>';
			}else if(workDefType == 'GANTT'){
	
			}
			td5.innerHTML = '&nbsp;';
			td4.innerHTML = imgStr;
			td3.innerHTML = '<p style="cursor:pointer;" onClick="selectWorkDef(\'' + workDefId + '\', \'' + workDefType + '\');">' + workDefName + '</p>';
			tr.appendChild(td5);
			tr.appendChild(td4);
			tr.appendChild(td3);
		}
	}

	bold("headMenu_" + id);
	selCatId = id;
	selCatSize = groupSize + workDefSize;
	selWorkDefIds = new Array();
	for (var i=0; i<workDefSize; i++) {
		var workDefId = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(workDef[i], 'packageId'));
		selWorkDefIds[i] = workDefId;
	}
	show("worksMenu_" + selCatId);
	$(selCatId+'CategoryIcon').setAttribute('src', '../images/icon/category/ic_category_open.gif');
}
/**
 * 메인화면을 아이디에 해당하는 카테고리의 내역으로 갱신
 * 메인화면에 하위 업무정의가 나열됩니다.
 * @param id
 * @return
 */
function updateCategoryMainView(id) {
	var url = getPath() + "/builder/main.jsp";
	var target = "mainView";
	var params = new Array();
	params.push("id=" + id);
	params = params.join("&");
	update(url, target, params, null, "loading", "failed");
}
var createCategoryParentId;
/**
 * 카테고리를 생성합니다.
 * @param parentId 부모 카테고리 아이디
 * @param name
 * @param desc
 * @return
 */
function createCategory(parentId, name, desc) {
	if (isNull(name))
		name = execute(function() {return document.nameDescForm.name.value;});
	if (isNull(desc))
		desc = execute(function() {return document.nameDescForm.desc.value;});

	name = toValidName(name);
	
	if (isNull(name))
		throw new Error("errorCodeNullName");

	createCategoryParentId = parentId;
	
	var url = getPath() + "/services/common/categoryService.jsp";
	var params = new Array();
	params.push("method=createCategory");
	if (isNull(parentId)) {
		params.push("parentCategoryId=_PKG_ROOT_");
	} else {
		params.push("parentCategoryId=" + parentId);
	}
	params.push("name=" + name);
	params.push("desc=" + desc);
	params.push("compId=" + compId);
	params = params.join("&");
	request(url, params, createCategoryCallback, null, "notifySaveProgress", null , "warnSaveFailed");
	return null;
}
function createCategoryCallback() {
	var parentId = createCategoryParentId;
	
	if (isNull(parentId)) {
		updateMenuListView();
	} else {
		selectCategory(parentId);
	}
}
/**
 * 카테고리를 조회합니다.
 * @param id
 * @return 카테고리 해쉬객체
 */
function getCategory(id) {
	var params = new Array();
	params.push("method=retrieveCategory");
	params.push("categoryId=" + id);
	params.push("compId=" + compId);
	params = params.join("&");
	var xml = request(getPath() + "/services/common/categoryService.jsp", params, null, null, null, null, "failed", false);
	
	var xmlDoc = getXmlDOM(xml.trim());
	var resultXml = SmartXMLUtil.getChildNode(xmlDoc, 'Result');
	//alert(SmartXMLUtil.getXMLString(xmlDoc));
	var obj = {};
	if (resultXml.getAttribute('status') == 'OK') {
		var category = SmartXMLUtil.getChildNode(resultXml, 'category');	
		var categoryName = category.getAttribute('name');
		var categoryDesc = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(category, 'description'));
		obj = {'name' : categoryName, 'description' : categoryDesc};
	} 	
	//var obj = toHashResult(xml);
	return obj;
}
/**
 * 카테고리를 수정합니다.
 * @param id
 * @param name
 * @param desc
 * @return
 */
function setCategory(id, name, desc) {
	if (isNull(id))
		id = execute(function() {return document.nameDescForm.id.value;});
	if (isNull(name))
		name = execute(function() {return document.nameDescForm.name.value;});
	if (isNull(desc))
		desc = execute(function() {return document.nameDescForm.desc.value;});

	name = toValidName(name);
	
	if (isNull(id))
		throw new Error("errorCodeNotSelected");
	if (isNull(name))
		throw new Error("errorCodeNullName");

	var params = new Array();
	params.push("method=updateCategory");
	params.push("categoryId=" + id);
	params.push("name=" + name);
	params.push("desc=" + desc);
	params.push("compId=" + compId);
	params = params.join("&");
	request(getPath() + "/services/common/categoryService.jsp", params, setCategoryCallback, null, "notifySaveProgress", null , "warnSaveFailed");
	return null;
}
function setCategoryCallback() {
	updateMenuListView();
}
/**
 * 카테고리를 삭제합니다.
 * @param id
 * @return
 */
function removeCategory(id) {
	if (isNull(id))
		id = selCatId;
	if (isNull(id)) {
		warnMessage("errorCodeNotSelected");
		return null;
	}
	if (selCatSize > 0) {
		warnMessage('Belongtocategoryaretryingtodeleteapackage');//삭제할려는 카테고리에 속한 패키지가 있습니다.
		return null;
	}

	var url = getPath() + "/services/common/categoryService.jsp";
	var params = new Array();
	params.push("method=deleteCategory");
	params.push("categoryId="+ selCatId);
	params.push("compId=" + compId);
	params = params.join("&");
	request(url, params, removeCategoryCallback, 'confirmDelete', 'notifyDeleteProgress', null, 'warnDeleteFailed'); //삭제하시겠습니까? (확인/취소)
	return null;
}
function removeCategoryCallback(){
	selCatId = null;
	updateMenuListView();
}

var popupCreateGroupModalDialogCategoryId;
/**
 * 그룹을 생성하는 대화상자를 띄웁니다.
 * @param categoryId 부모카테고리 아이디
 * @param name
 * @param desc
 * @return
 */
function popupCreateGroupModalDialog(categoryId, name, desc) {
	popupCreateGroupModalDialogCategoryId = categoryId;
	popupNameDescModalDialog("createGroupForm", createGroup, null, name, desc);
}
/**
 * 그룹을 수정하는 대화상자를 띄웁니다.
 * @param id
 * @return
 */
function popupSetGroupModalDialog(id) {
	if (isNull(id))
		id = selGroupId;
	if (isNull(id)) {
		warnMessage("errorCodeNotSelected");
		return;
	}
		
	var obj = getCategory(id);
	var name = obj["name"];
	var desc = obj["description"];
	popupNameDescModalDialog("setGroupForm", setGroup, id, name, desc);
}
/**
 * 그룹선택 이벤트 시의 처리할 내역입니다.
 * @param id
 * @return
 */
function selectGroup(id) {
	// 업무양식 뷰를 숨깁니다.
	hideFormListView();
	// 에디터를 숨깁니다.
	hideEditorView();
	// 선택한메뉴를 갱신합니다.
	updateGroupMenuView(id);
	// 메인화면을 갱신합니다.
	updateGroupMainView(id);
}
var updateGroupMenuView_id;
/**
 * 아이디에 해당하는 그룹메뉴를 선택된 상태로 갱신합니다.
 * 하위 업무목록이 나타납니다.
 * @param id
 * @return
 */
function updateGroupMenuView(id) {
	updateGroupMenuView_id = id;
	
	var url = getPath() + "/services/builder/builderService.jsp";
	//var params = "method=getPackageListByCategory&categoryId=" + id + "&pageCount=-1&recordCount=-1";
	var params = new Array();
	params.push("method=getPackageListByCategory");
	params.push("categoryId=" + id);
	params.push("pageCount=-1");
	params.push("recordCount=-1");
	params.push("compId=" + compId);
	params = params.join("&");
	
	request(url, params, updateGroupMenuViewCallback, null, "loading", null, "failed");
}
function updateGroupMenuViewCallback() {
	hide("worksMenu_" + selGroupId);
	unbold(selGroupId);
	if($(selGroupId+"Icon"))
		$(selGroupId+"Icon").setAttribute("src", "../images/icon/category/group_plus.gif");
	unbold(selWorkDefId);
	selGroupId = null;
	selGroupSize = 0;
	selWorkDefId = null;
	selWorkDefType = null;
	selFormId = null;

	var id = updateGroupMenuView_id;

	var xmlDoc = getXmlDOM(getResult());
	var resultXml = SmartXMLUtil.getChildNode(xmlDoc, 'Result');

	var workDefSize = 0;
	var workDef = SmartXMLUtil.getChildNodes(resultXml, 'Package');
		
	var cTd = document.getElementById(id + "_child");
	if (cTd != null) {
		var childStr = "";
		if (!isEmpty(workDef)) {
			workDefSize = workDef.length;
			var childStr = "<table id='worksMenu_"+ id +"' cellspacing='0' cellpadding='0' border='0'>";
			for (var i=0; i < workDefSize; i++) {
				
				var workDefId = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(workDef[i], 'packageId'));
				var workDefName = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(workDef[i], 'name'));
				var workDefType = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(workDef[i], 'type'));
				
				if (workDefType == 'PROCESS') {
					var imgStr = '<img src=../images/icon/package/ic_process.gif>';
				} else if(workDefType == 'SINGLE') {
					var imgStr = '<img src=../images/icon/package/ic_information.gif>';
				} else if(workDefType == 'GANTT') {
				}
				childStr += "<tr id =" + workDefId + "><td width='30'>&nbsp;</td>";
				childStr += "<td width='24' align='right' valign='middle' style='padding:3px;'>"+ imgStr +"</td>"; 
				childStr += "<td width='120' align='left' valign='middle'>";
				childStr += "<p style=\"cursor:pointer;\" onClick=\"selectWorkDef(\'" + workDefId + "\', \'" + workDefType + "\');\">" + workDefName + "</p>";
				childStr += "</td>";
				childStr += "</tr>"; 
			}
			childStr = childStr + "</table>";
		}
		cTd.innerHTML = childStr;
	}

	bold(id);
	if($(id+"Icon"))
		$(id+"Icon").setAttribute("src", "../images/icon/category/group_minus.gif");

	selGroupId = id;
	selGroupSize = workDefSize;
	selWorkDefIds = new Array();
	for (var i=0; i<workDefSize; i++) {
		var workDefId = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(workDef[i], 'packageId'));
		selWorkDefIds[i] = workDefId;
	}
	show("worksMenu_" + selGroupId);
}
/**
 * 메인화면을 아이디에 해당하는 그룹의 내역으로 갱신합니다.
 * @param id
 * @return
 */
function updateGroupMainView(id) {
	updateCategoryMainView(id);
}
/**
 * 그룹을 생성합니다.
 * @param categoryId 부모 카테고리아이디
 * @param name
 * @param desc
 * @return
 */
function createGroup(categoryId, name, desc) {
	if (isNull(categoryId))
		categoryId = popupCreateGroupModalDialogCategoryId;
	createCategory(categoryId, name, desc);
}
/**
 * 그룹을 조회합니다.
 * @param id
 * @return 그룹 해쉬객체
 */
//function getGroup(id) {
//	return getCategory(id);
//}
/**
 * 그룹을 수정합니다.
 * @param id
 * @param name
 * @param desc
 * @return
 */
function setGroup(id, name, desc) {
	if (isNull(id))
		id = execute(function() {return document.nameDescForm.id.value;});
	if (isNull(name))
		name = execute(function() {return document.nameDescForm.name.value;});
	if (isNull(desc))
		desc = execute(function() {return document.nameDescForm.desc.value;});

	name = toValidName(name);
	
	if (isNull(id))
		throw new Error("errorCodeNotSelected");
	if (isNull(name))
		throw new Error("errorCodeNullName");

	var params = new Array();
	params.push("method=updateCategory");
	params.push("categoryId=" + id);
	params.push("name=" + name);
	params.push("desc=" + desc);
	params.push("compId=" + compId);
	params = params.join("&");
	request(getPath() + "/services/common/categoryService.jsp", params, setGroupCallback, null, "notifySaveProgress", null , "warnSaveFailed");
	return null;
}
function setGroupCallback() {
	selectCategory(selCatId);
}
/**
 * 그룹을 삭제합니다.
 * @param id
 * @return
 */
function removeGroup(id) {
	if (isNull(id))
		id = selGroupId;
	if (isNull(id)) {
		warnMessage("errorCodeNotSelected");
		return null;
	}
	if (selGroupSize > 0) {
		warnMessage('Belongtocategoryaretryingtodeleteapackage');//삭제할려는 카테고리에 속한 패키지가 있습니다.
		return null;
	}

	var url = getPath() + "/services/common/categoryService.jsp";
	var params = new Array();
	params.push("method=deleteCategory");
	params.push("categoryId="+ id);
	params.push("compId="+ compId);
	params = params.join("&");
	request(url, params, removeGroupCallback, 'confirmDelete', 'notifyDeleteProgress', null, 'warnDeleteFailed'); //삭제하시겠습니까? (확인/취소)
	return null;
}
function removeGroupCallback() {
	selectCategory(selCatId);
}

/**
 * 업무정의를 생성하는 대화상자를 띄웁니다.
 * @param catId
 * @param groupId
 * @return
 */
function popupCreateWorkDefModalDialog(catId, groupId) {
	if (isNull(catId))
		catId = selCatId;
	if (isNull(groupId))
		groupId = selGroupId;
	if (isNull(catId))
		return;
	
	var url = getPath() + "/builder/dialog/createWorkDef.jsp";
	var params = new Array();
	params.push("title=createWorkDefForm");
	params.push("categoryId=" + catId);
	params.push("groupId=" + groupId);
	params = params.join("&"); 
	popupModalDialog(url, params, createWorkDef);
}
/**
 * 업무정의를 수정하는 대화상자를 띄웁니다.
 * @param id
 * @param type
 * @return
 * popupSetWorkDefModalDialog(id, type)
 */
function popupSetWorkDefModalDialog(){
	//if (isNull(id))
	var id = selWorkDefId;
	if (isNull(id)) {
		popupSetGroupModalDialog(id);
		return;
	}
	var obj = getWorkDef(id);
	var name = obj["name"];
	var desc = obj["description"];
	
	popupNameDescModalDialog("setWorkDefForm", setWorkDef, id, name, desc);
}
/**
 * 업무정의를 복사하는 대화상자를 띄웁니다.
 * @return
 */
function popupCloneWorkDefModalDialog() {
	popupWorkDefListModalDialog("cloneWorkDefForm", cloneWorkDef);
}
/**
 * 업무정의를 다른카테고리나 그룹으로 이동하는 대화상자를 띄웁니다.
 * @param id
 * @param type
 * @return
 */
function popupMoveWorkDefModalDialog(id, type) {
	if (isNull(id)) {
		if (isNull(selWorkDefId)) {
			warnMessage("errorCodeNotSelected");
			return;
		}
		id = selWorkDefId;
	}
	
	var url = getPath() + "/builder/dialog/moveWorkDef.jsp";
	var params = new Array();
	params.push("title=moveWorkDefForm");
	params.push("id=" + id);
	params.push("type=" + toNotNull(type));
	params = params.join("&");
	popupModalDialog(url, params, moveWorkDef);
}
/**
 * 업무정의를 다른카테고리로 이동하는 대화상자의 그룹선택 리스트박스를
 * 해당 카테고리의 해당 그룹이 선택된 상태로 갱신합니다. 
 * @param categoryId
 * @param groupId
 * @return
 */
function updateMoveWorkDefForm_group(categoryId, groupId) {
	var url = getPath() + "/builder/categoryCombo.jsp";
	var target = "moveWorkDefForm_groupTd";
	var params = new Array();
	params.push("id=" + groupId);
	params.push("parentId=" + categoryId);
	params.push("ctrlId=moveWorkDefForm_group");
	params.push("ctrlName=group");
	params = params.join("&");
	update(url, target, params);
}
/**
 * 업무정의 선택이벤트 시 처리할 내역입니다.
 * @param id
 * @param type
 * @return
 */
function selectWorkDef(id, type) {
	// 1. 메뉴를 갱신합니다.
	updateWorkDefMenuView(id, type);
	// 2. 메인화면을 갱신합니다.
	updateWorkDefMainView(id, type);
}
/**
 * 메뉴를 아이디에 해당하는 업무정의가 선택된 상태로 갱신합니다.
 * 하위업무화면목록이 나열되도록 차후 개발해야함.(TODO)
 * @param id
 * @param type
 * @return
 */
function updateWorkDefMenuView(id, type) {
	if (isEmpty(selWorkDefIds) || indexOf(selWorkDefIds, id) == -1) {
		hide("worksMenu_" + selGroupId);
		unbold(selGroupId);
		if($(selGroupId+"Icon"))
			$(selGroupId+"Icon").setAttribute("src", "../images/icon/category/group_plus.gif");

		selGroupId = null;
	}
	unbold(selWorkDefId);
	unbold("recentWorkDefList_" + selWorkDefId);
	selWorkDefId = null;
	selWorkDefType = null;
	selFormId = null;

	selWorkDefId = id;
	selWorkDefType = type;
	bold(selWorkDefId);
	bold("recentWorkDefList_" + selWorkDefId);
}
var updateWorkDefMainView_id;
/**
 * 메인화면을 아이디에 해당하는 업무정의 내역으로 갱신합니다.
 * @param id
 * @param type
 * @return
 */
function updateWorkDefMainView(id, type) {
	updateWorkDefMainView_id = id;

	var url = getPath() + "/builder/workDef.jsp";
	var target = "mainView";
	var params = new Array();
	params.push("id=" + id);
	params = params.join("&");
	update(url, target, params, updateWorkDefMainViewCallback, "loading", "failed");
}
function updateWorkDefMainViewCallback() {
	var id = updateWorkDefMainView_id;
	if (getMovie('diagram').reload) {  //for FF 
		getMovie('diagram').reload(id, 1, '','');
	}
	showEditorView();
}
/**
 * 최근작업업무정의 목록을 갱신합니다.
 * @return
 */
function updateRecentWorkDefListView() {
	var url = getPath() + "/builder/gadget/recentWorkDefList.jsp";
	var target = "recentWorkDefListView";
	send(url, target);
}
var createWorkDefCategoryId;
var createWorkDefGroupId;
/**
 * 업무정의를 생성합니다.
 * @param categoryId 소속 카테고리
 * @param groupId 소속 그룹
 * @param type
 * @param name
 * @param desc
 * @return
 */
function createWorkDef(categoryId, groupId, type, name, desc) {
	if (isNull(categoryId))
		categoryId = toNotNull(document.createWorkDefForm.categoryId.value);
	if (isNull(groupId))
		groupId = document.createWorkDefForm.groupId.value;
	if (isNull(type))
		type = toNotNull(document.createWorkDefForm.type.value);
	if (isNull(name))
		name = toNotNull(document.createWorkDefForm.name.value);
	if (isNull(desc))
		desc = toNotNull(document.createWorkDefForm.desc.value);

	if (type == "WORKGROUP") {
		createGroup(categoryId, name, desc);
		return;
	}

	name = toValidName(name);

	if (isNull(categoryId))
		return;
	if (isNull(name)) {
		warnMessage("errorCodeNullName", "checkName");
		return;
	}
	
	createWorkDefCategoryId = categoryId;
	createWorkDefGroupId = groupId;
	
	var url = getPath() + "/services/builder/builderService.jsp";
	var params = new Array();
	params.push("method=createPackage");
	params.push("categoryId=" + (isNull(groupId)? categoryId : groupId));
	params.push("name=" + name);
	params.push("type=" + type);
	params.push("desc=" + desc);
	params.push("compId=" + compId);
	params = params.join("&");
	request(url , params , createWorkDefCallback , null , "inProgress" , null , "failed");
}
function createWorkDefCallback() {
	var categoryId = createWorkDefCategoryId;
	var groupId = createWorkDefGroupId;
	
	updateRecentWorkDefListView();
	
	if (isNull(groupId)) {
		selectCategory(categoryId);
	} else {
		selectGroup(groupId);
	}
}
/**
 * 업무정의를 조회합니다.
 * @param id
  * @return 업무정의 해쉬객체
 */
function getWorkDef(id) {
	var params = new Array();
	params.push('method=getPackage');
	params.push('packageId=' + id);
	params.push('compId=' + compId);
	params = params.join("&");
	//var xml = request(url, params);
	var xml = request(getPath() + "/services/builder/builderService.jsp", params, null, null, null, null, "failed", false);
	var xmlDoc = getXmlDOM(xml.trim());
	//alert(SmartXMLUtil.getXMLString(xmlDoc));
	var resultXml = SmartXMLUtil.getChildNode(xmlDoc, 'Result');
	var obj = {};
	if (resultXml.getAttribute('status') == 'OK') {
		var packageNode = SmartXMLUtil.getChildNode(resultXml, 'Package');
		var packageName = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(packageNode, 'name'));
		var packageDesc = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(packageNode, 'description'));
		obj = {'name' : packageName, 'description' : packageDesc};
	} 	
	return obj;
	//return toHashResult(request(url, params));
}
/**
 * 업무정의를 수정합니다.
 * @param id
 * @param type
 * @param name
 * @param desc
 * @return
 */
function setWorkDef(id, type, name, desc) {
	if (isNull(id))
		id = document.nameDescForm.id.value;
	if (isNull(name))
		name = document.nameDescForm.name.value;
	if (isNull(id))
		throw new Error("errorCodeNullId");
	if (isNull(name))
		throw new Error("errorCodeNullName");
	if (isNull(desc))
		desc = toNotNull(document.nameDescForm.desc.value);

	name = toValidName(name);

	var url = getPath() + "/services/builder/builderService.jsp";
	var params = new Array();
	params.push('method=renamePackage');
	params.push('packageId=' + id);
	params.push('name=' + name);
	params.push('desc=' + desc);
	params.push('compId=' + compId);
	params = params.join("&");
	request(url, params, setWorkDefCallback, null, "inProgress", null, "failed");
}
function setWorkDefCallback(){
	updateRecentWorkDefListView();
	if (!isNull(selGroupId)) {
		selectGroup(selGroupId);
	} else if (!isNull(selCatId)) {
		selectCategory(selCatId);
	}
}
/**
 * 업무정의를 삭제합니다.
 * @param id
 * @param type
 * @return
 */
function removeWorkDef(id, type) {
	if (isNull(id)) {
		if (!isNull(selWorkDefId)) {
			id = selWorkDefId;
		} else if (!isNull(selGroupId)) {
			id = selGroupId;
			type = "WORKGROUP";
		} else {
			warnMessage("errorCodeNotSelected");
			return null;
		}
	}
	
	if (type == "WORKGROUP") {
		removeGroup(id);
		return null;
	}

	var url = getPath() + "/services/builder/builderService.jsp";
	var params = new Array();
	params.push("method=deletePackage");
	params.push("packageId=" + id);
	params.push('compId=' + compId);
	params = params.join("&");
	request(url, params, removeWorkDefCallback, "confirmDelete", "notifyDeleteProgress", null, "warnDeleteFailed");
	//return null;
}
function removeWorkDefCallback() {
	var xmlDoc = getXmlDOM(getResult());
	var resultXml = SmartXMLUtil.getChildNode(xmlDoc, 'Result');
	if (resultXml.getAttribute('status') == 'OK') {
		selWorkDefId = null;
		
		updateRecentWorkDefListView();
		
		if(isNull(selGroupId)) {
			selectCategory(selCatId);
		} else {
			selectGroup(selGroupId);
		}
	} else if(resultXml.getAttribute('status') == "DEPLOYED") {
		warnMessage('failed','Youcannotdeletethebusinessservicedefinition');//서비스중인 업무정의는 삭제할 수 없습니다.;
	}
}
/**
 * 업무정의를 다른카테고리로 이동합니다.
 * @param id
 * @param categoryId 이동할 카테고리 아이디
 * @return
 */
function moveWorkDef(id, categoryId) {
	if (isNull(id))
		id = document.moveWorkDefForm.id.value;
	if (isNull(categoryId))
		categoryId = document.moveWorkDefForm.group.value;
	if (isNull(categoryId))
		categoryId = document.moveWorkDefForm.category.value;
	if (isNull(id))
		throw new Error("errorCodeNullId");
	if (isNull(categoryId))
		throw new Error("errorCodeNullCategoryId");

	var url = getPath() + "/services/builder/builderService.jsp";
	var params = new Array();
	params.push("method=renamePackage");
	params.push("packageId=" + id);
	params.push("categoryId=" + categoryId);
	params.push('compId=' + compId);
	params = params.join("&");
	request(url, params, moveWorkDefCallback, null, "inProgress", null, "failed");
}
function moveWorkDefCallback() {
	updateRecentWorkDefListView();
	selectCategory(selCatId);
}
/**
 * 업무정의를 복제합니다.
 * @param id
 * @param type
 * @param toCategoryId 복제된 업무정의의 소속 카테고리
 * @param toGroupId 복사된 업무정의의 소속 그룹
 * @return
 */
function cloneWorkDef(id, type, toCategoryId, toGroupId){
	if (isNull(id))
		id = execute(function() {return document.workDefListForm.id.value;});
	if (isNull(type))
		type = execute(function() {return document.workDefListForm.type.value;});
	if (isNull(id)) {
		id = selWorkDefId;
		type = selWorkDefType;
	}
	if (isNull(id) || isNull(type)) {
		warnMessage("errorCodeNotSelected"); //복사할 업무정의를 선택하세요
		return;
	}
	
	if (isNull(toCategoryId)) {
		toCategoryId = selCatId;
		toGroupId = selGroupId;
	}
	if (!isNull(toGroupId))
		toCategoryId = toGroupId;

	if (isNull(toCategoryId)) {
		warnMessage("errorCodeNotSelected"); //복사할 업무정의를 선택하세요
		return;
	}
	
	var url = getPath() + "/services/builder/builderService.jsp";
	var params = new Array();
	params.push("method=clonePackage");
	params.push("categoryId=" + toCategoryId);
	params.push("packageId=" + id);
	params.push('compId=' + compId);
	params = params.join("&");
	request(url, params, cloneWorkDefCallback, null, "inProgress", null, "failed");
}
function cloneWorkDefCallback(){
	updateRecentWorkDefListView();
	if (isNull(selGroupId)) {
		selectCategory(selCatId);
	} else {
		selectGroup(selGroupId);
	}
}
var checkInWorkDefId;
var checkInWorkDefType;
/**
 * 업무정의를 수정완료합니다.
 * @param id
 * @param type
 * @return
 */
function checkInWorkDef(id, type){
	checkInWorkDefId = id;
	checkInWorkDefType = type;
	
	var url = getPath() + "/services/builder/builderService.jsp";
	//var params = "method=checkInPackage&packageId=" + id;
	var params = new Array();
	params.push("method=checkInPackage");
	params.push("packageId=" + id);
	params.push("compId=" + compId);
	params = params.join("&")
	
	request(url, params, checkInWorkDefCallback, null, "inProgress", null, "failed");
}
function checkInWorkDefCallback() {
	var id = checkInWorkDefId;
	var type = checkInWorkDefType;
	
	updateRecentWorkDefListView();
	if (isNull(selWorkDefId)) {
		update(getPath() + "/builder/workDefTable.jsp?id=" + id, id+"Td", null, null, "loading", "failed");
	} else {
		selectWorkDef(id, type);
	}
}
var checkOutWorkDefId;
var checkOutWorkDefType;
/**
 * 업무정의 수정을 시작합니다.
 * @param id
 * @param type
 * @return
 */
function checkOutWorkDef(id, type){
	checkOutWorkDefId = id;
	checkOutWorkDefType = type;
	
	var url = getPath() + "/services/builder/builderService.jsp";
	//var params = "method=checkOutPackage&packageId=" + id;
	var params = new Array();
	params.push("method=checkOutPackage");
	params.push("packageId=" + id);
	params.push("compId=" + compId);
	params = params.join("&");
	request(url, params, checkOutWorkDefCallback, null, "inProgress", null, "failed");
}
function checkOutWorkDefCallback() {
	var id = checkOutWorkDefId;
	var type = checkOutWorkDefType;
	
	updateRecentWorkDefListView();
	selectWorkDef(id, type);
}
var deployWorkDef_id;
/**
 * 업무정의를 서비스 시작합니다.
 * @param id
 * @param type
 * @return
 */
function deployWorkDef(id, type) {
	deployWorkDef_id = id;

	var url = getPath() + "/services/builder/builderService.jsp";
	var params = new Array();
	params.push("method=deployPackage");
	params.push("packageId=" + id);
	params.push("compId=" + compId);
	params = params.join("&");
	request(url, params , deployWorkDefCallback, null , "inProgress" , null , "failed");
}
function deployWorkDefCallback() {
	var id = deployWorkDef_id;
	if (isNull(selWorkDefId)) {
		update(getPath() + "/builder/workDefTable.jsp?id=" + id, id+"Td", null, null, "loading", "failed");
	} else {
		update(getPath() + "/builder/workDef.jsp?id=" + id, "mainView", null, null, "loading", "failed");
	}
}
var undeployWorkDefId;
/**
 * 업무정의를 서비스 중지합니다.
 * @param id
 * @param type
 * @return
 */
function undeployWorkDef(id, type) {
	undeployWorkDefId = id;

	var url = getPath() + "/services/builder/builderService.jsp";
	var params = new Array();
	params.push("method=undeployPackage");
	params.push("packageId=" + id);
	params.push("compId=" + compId);
	params = params.join("&");
	request(url , params , undeployWorkDefCallback, "Doyouwanttostop" , "isStopping" , null , "failed");
}
function undeployWorkDefCallback() {
	var id = undeployWorkDefId;
	if (isNull(selWorkDefId)) {
		update(getPath() + "/builder/workDefTable.jsp?id=" + id, id + "Td", null, null, "loading", "failed");
	} else {
		update(getPath() + "/builder/workDef.jsp?id=" + id, "mainView", null, null, "loading", "failed");
	}
}

function updateFormListView(workDefId) {
	if (isNull(workDefId))
		workDefId = selWorkDefId;
	if (isNull(workDefId)) {
		warnMessage("errorCodeNotSelected");
		return;
	}

	clearFormListTable();
	
	var url = getPath() + "/services/builder/builderService.jsp";
	//var params = "method=getFormList&packageId=" + selWorkDefId;
	var params = new Array();
	params.push("method=getFormList");
	params.push("packageId=" + selWorkDefId);
	params.push("compId=" + compId);
	params = params.join("&");
	request(url, params, updateFormListViewCallback, null, "loading", null, "failed");
}
function updateFormListViewCallback() {
	var xmlDoc = getXmlDOM(getResult());
	var resultXml = SmartXMLUtil.getChildNode(xmlDoc, 'Result');
	var formDef = SmartXMLUtil.getChildNodes(resultXml, 'Form');
	var table = document.getElementById("formListTable");
	for (var i=0; i<formDef.length; i++) {
		var formDefId = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(formDef[i], 'formId'));
		var formDefName = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(formDef[i], 'name'));
		var formDefType = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(formDef[i], 'type'));
		updateFormMenu(formDefId, formDefName, formDefType);
	}
}
function clearFormListTable(){
	var table = document.getElementById("formListTable");
	if (table == null || table.rows == null)
		return;
	var size = table.rows.length;
	for (var i=0; i<size; i++)
		table.deleteRow(0);
}
/**
 * 양식을 생성할 대화상자를 띄웁니다.
 * @return
 */
function popupCreateFormModalDialog() {
	popupNameDescModalDialog("setFormForm", createForm, null, null, null, false);
}
/**
 * 양식을 수정할 대화상자를 띄웁니다.
 * @param id
 * @return
 */
function popupSetFormModalDialog(id) {
	if (isNull(id))
		id = selFormId;
	if (isNull(id)) {
		warnMessage("errorCodeNotSelected");
		return;
	}
	
	var obj = getForm(id);
	var name = obj["name"];
	var desc = obj["description"];

	popupNameDescModalDialog("setFormForm", setForm, id, name, desc, false);
}
/**
 * 양식목록 대화상자를 띄웁니다.
 * @param title
 * @param response 완료시 처리할 함수
 * @return
 */
function popupFormListModalDialog(title, response) {
	var url = getPath() + "/builder/dialog/formList.jsp";
	var params = new Array();
	params.push("title=" + toNotNull(title));
	params = params.join("&"); 
	popupModalDialog(url, params, response);
	document.searchFormsForm.searchWord.focus();
}
/**
 * 양식목록을 검색합니다.
 * @param pageNo
 * @return
 */
function searchForms(pageNo) {
	setTimeout("_searchForms(" + pageNo + ")", 10);
}
function _searchForms(pageNo) {
	if (isNull(pageNo))
		pageNo = toNotNull(execute(function() {return document.searchFormsForm.pageNo.value;}));
	var pageSize = toNotNull(execute(function() {return document.searchFormsForm.pageSize.value;}));
	var searchWord = toNotNull(execute(function() {return document.searchFormsForm.searchWord.value;}));
	
	var url = getPath() + "/builder/dialog/formListTable.jsp";
	var target = "formListDiv";
	var params = new Array();
	params.push("pageNo=" + pageNo);
	params.push("pageSize=" + pageSize);
	params.push("searchWord=" + searchWord);
	params = params.join("&");
	update(url, target, params, null, "loading", "failed");
}
/**
 * 양식에 선택 이벤트 발생 시 처리할 내역입니다.
 * @param id
 * @return
 */
function selectForm(id) {
	// 1. 양식메뉴를 갱신합니다.
	updateFormMenuView(id);
	// 2. 양식메인화면을 갱신합니다.
	updateFormMainView(id);
}
/**
 * 양식메뉴를 아이디에 해당하는 양식이 선택된 상태로 갱신합니다.
 * @param id
 * @return
 */
function updateFormMenuView(id) {
	unbold(selFormId);
	selFormId = null;

	bold(id);
	selFormId = id;
}
/**
 * 메인화면을 아이디에 해당하는 양식이 선택된 상태로 갱신합니다.
 * @param id
 * @return
 */
function updateFormMainView(id) {
	getMovie("diagram").goFormEditor(id);
}
/**
 * 양식메뉴를 갱신합니다.
 * 없으면 삽입, 있으면 수정
 * @param id
 * @param name
 * @param type
 * @return
 */
function updateFormMenu(id, name, type) {
	if (isNull(id))
		return;
	
	var obj = document.getElementById(id);
	if (obj == null) {
		if (isNull(name))
			return;
		if (isNull(type))
			type = "NONE";

		var table = document.getElementById("formListTable");
		
		var tr = table.insertRow(-1);
		tr.id = id;
		tr.setAttribute("height", 23);
		
		var i = 0;
		var imgTd = document.createElement("td");
		imgTd.id = id + "_td1";
		imgTd.style.wordBreak = "break-all";
		imgTd.align = "right";
		imgTd.vAlign = "middle";
		imgTd.width = "30";
		imgTd.innerHTML = '&nbsp;<img src="../images/' + (type == "NONE"? 'notUse2' : 'use2') + '.png"  border="0">';
		
		var nameTd = document.createElement('td');
		nameTd.id = id + "_td2";
		nameTd.style.wordBreak = "break-all";
		nameTd.align = "left";
		nameTd.vAlign = "middle";
		nameTd.width = "141";
		nameTd.innerHTML = '<p style="cursor: pointer;" onclick="selectForm(\'' + id + '\');">' + name + '</p>';
		
		tr.appendChild(imgTd);
		tr.appendChild(nameTd);
	} else {
		if (!isNull(type)) {
			var imgTd = document.getElementById(id + "_td1");
			if (imgTd != null)
				imgTd.innerHTML = '&nbsp;<img src="../images/' + (type == "NONE"? 'notUse2' : 'use2') + '.png"  border="0">';
		}
		if (!isNull(name)) {
			var nameTd = document.getElementById(id + "_td2");
			if (nameTd != null)
				nameTd.innerHTML = '<p style="cursor: pointer;" onclick="selectForm(\'' + id + '\');">' + name +'</p>';
		}
	}
}

/**
 * 양식을 생성합니다.
 * @param workDefId 양식이 속할 업무정의의 아이디
 * @param name
 * @param desc
 * @return
 */
function createForm(workDefId, name, desc) {
	// TODO
	getMovie("diagram").addForm();
	setTimeout("updateFormListView()", 50);
}
function createFormCallback() {
	// TODO
}
/**
 * 양식을 조회합니다.
 * @param id
 * @return 양식의 해쉬객체
 */
function getForm(id) {
	var params = new Array();
	params.push('method=getForm');
	params.push('formId=' + id);
	params.push('compId=' + compId);
	params = params.join("&");
	
	var xml = request(getPath() + "/services/builder/builderService.jsp", params, null, null, null, null, "failed", false);
	var xmlDoc = getXmlDOM(xml.trim());
	//alert(SmartXMLUtil.getXMLString(xmlDoc));
	var resultXml = SmartXMLUtil.getChildNode(xmlDoc, 'Result');
	var obj = {};
	if (resultXml.getAttribute('status') == 'OK') {
		var form = SmartXMLUtil.getChildNode(resultXml, 'Form');
		var formName = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(form, 'name'));
		var formDesc = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(form, 'description'));
		obj = {'name' : formName, 'description' : formDesc};
	} 	
	return obj;
	//return toHashResult(request(url, params));
}
/**
 * 양식을 수정합니다.
 * @param id
 * @param name
 * @param desc
 * @return
 */
function setForm(id, name, desc) {
	if (isNull(id))
		id = document.nameDescForm.id.value;
	if (isNull(name))
		name = document.nameDescForm.name.value;
	if (isNull(id))
		throw new Error("errorCodeNullId");
	if (isNull(name))
		throw new Error("errorCodeNullName");

	name = toValidName(name);
	getMovie("diagram").renameForm(id, name);
	
	// TODO
	/*
	var url = getPath() + "/services/builder/builderService.jsp";
	var params = new Array();
	params.push('method=renameForm');
	params.push('formId=' + id);
	params.push('formName=' + name);
	params.push('compId=' + compId);
	params = params.join("&");
	request(url, params, setFormCallback, null, "inProgress", null, "failed");
	*/
}
function setFormCallback() {
	// TODO
}
var removeForm_id;
/**
 * 양식을 삭제합니다.
 * @param id
 * @return
 */
function removeForm(id) {
	if (isNull(id))
		id = selFormId;
	if (isNull(id)) {
		warnMessage("errorCodeNotSelected");
		return;
	}
	// TODO
	if (!confirm("삭제하시겠습니까?"))
		return;
	
	removeForm_id = id;
	getMovie("diagram").removeForm(id);
}
function removeFormCallback() {
	var id = removeForm_id;
	var obj = document.getElementById(id);
	if (obj != null) {
		obj.parentNode.removeChild(obj);
	}
	selFormId = null;
}
/**
 * 양식을 복제합니다.
 * @param id
 * @param toWorkDefId 양식이 속할 업무정의 아이디
 * @return
 */
function cloneForm(id, toWorkDefId) {
	if (isNull(id))
		id = execute(function() {return document.formListForm.id.value;});
	if (isNull(id))
		id = selFormId;
	if (isNull(toWorkDefId))
		toWorkDefId = selWorkDefId;
	if(isNull(id) || isNull(toWorkDefId)) {
		warnMessage("erroCodeNotSelected");
		return;
	}

	var url = getPath() + "/services/builder/builderService.jsp";
	var params = new Array();
	params.push("method=cloneForm");
	params.push("toPackageId=" + toWorkDefId);
	params.push("toVersion=1");
	params.push("formId=" + id);
	params.push("version=1");
	params.push('compId=' + compId);
	params = params.join("&");
	request(url, params, cloneFormCallback, null, "notifyCopyProgress", null, "warnCopyFailed");
}
function cloneFormCallback(){
	var xmlDoc = getXmlDOM(getResult());

	var resultXml = SmartXMLUtil.getChildNode(xmlDoc, 'Result');
	var formDef = SmartXMLUtil.getChildNodes(resultXml, 'Form');
	
	var formDefId = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(formDef[0], 'formId'));
	var formDefName = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(formDef[0], 'name'));

	updateFormMenu(formDefId, formDefName);
	getMovie("diagram").processEditorReload(xmlDoc.xml);
}

/**
 * 양식목록 뷰를 보이게 합니다.
 * @param id
 * @return
 */
function showFormListView(id) {
	show("formListViewDiv");
}
/**
 * 양식목록 뷰를 숨깁니다.
 * @return
 */
function hideFormListView() {
	hide("formListViewDiv");
}
/**
 * 에디터뷰를 보이게 합니다.
 * @return
 */
function showEditorView() {
	var view = document.getElementById("editorView");
	if (view == null)
		return;
	view.height = "760px";
}
/**
 * 에디터뷰를 숨깁니다.
 * @return
 */
function hideEditorView() {
	var view = document.getElementById("editorView");
	if (view == null)
		return;
	view.height = "1px;";
}

/**
 * 에디터 SWF가 새로 로딩되면 호출되는 함수
 * @param status
 * @return
 */
function loadCallback(status){
	if (selWorkDefType == "SINGLE") {
		hideFormListView();
	} else {
		updateFormListView();
		// TODO
		if (status == "DEPLOYED") {
			
		} else {
			
		}
		showFormListView();
	}
}
/**
 * 에디터 SWF에서 양식 추가시 호출되는 함수
 * @return
 */
function addFormAndModify(){
	getMovie("diagram").addFormAndModify();
}
/**
 * 에디터 SWF에서 액티비티에 양식 연결설정 및 연결변경 시 호출되는 함수
 * @param newFormId 액티비티에 새로 연결된 양식의 아이디
 * @param oldFormId 액티비티에 이전에 연결된 양식의 아이디
 * @return
 */
function formChangeCallback(newFormId, oldFormId) {
	updateFormMenu(oldFormId, null, "NONE");
	updateFormMenu(newFormId, null, "USE");
}
/**
 * 에디터 SWF에서 양식 추가, 변경, 삭제 시 호출되는 함수
 * @param id
 * @param name
 * @param mode
 * @return
 */
function formCallback(id, name, mode) {
	var tab = document.getElementById("formListTable");
	if (mode == "addAndModify" || mode == "rename") {
		updateFormMenu(id, name);
	} else if (mode == "remove") {
		removeFormCallback();
	}
}

/**
 * 이름을 유효한 이름으로 변경하여 반환합니다.
 * @param name 변경 전 이름
 * @return 변경 후 이름
 */
function toValidName(name) {
	if (isNull(name))
		return name;
	while (name.indexOf("\"") != -1)
		name = name.replace("\"", " ");
	while (name.indexOf("&") != -1)
		name = name.replace("&", " ");
	return name;
}

 function popupProductListModalDialog() {
	var url = getPath() + "/common/dialog/productList.jsp";
	popupModalDialog(url, null, downLoadProduct);
	document.searchproductForm.searchWord.focus();
}

 function searchProductList(pageNo) {
	setTimeout("_searchProductList(" + pageNo + ")", 10);
}
function _searchProductList(pageNo) {
	if (isNull(pageNo))
		pageNo = toNotNull(execute(function() {return document.productListForm.pageNo.value;}));
	var pageSize = toNotNull(execute(function() {return document.productListForm.pageSize.value;}));
	var searchWord = toNotNull(execute(function() {return document.searchproductForm.searchWord.value;}));
	var searchKey = toNotNull(execute(function() {return document.searchproductForm.searchKey.value;}));
	
	var url = getPath() + "/common/dialog/productListTable.jsp";
	var params = new Array();
	params.push("pageNo=" + pageNo);
	params.push("pageSize=" + pageSize);
	params.push("searchWord=" + searchWord.replace(/\s/g, ""));
	params.push("searchKey=" + searchKey);
	params = params.join("&");
	update(url, "productListDiv", params, null, "loading", "failed");
}
function downLoadProduct(){
	var productCode = execute(function() {return document.searchproductForm.productCode.value;});
	var url = getPath() + "/services/market/marketService.jsp";
	var params = new Array();
	params.push("method=downloadProduct");
	params.push("productCode=" + productCode);
	params.push("userId=" + userId);
	params.push("compId=" + compId);
	params = params.join("&");
	request(url, params, downLoadProductCallback, null, "notifySaveProgress", null, "failed");
}
function downLoadProductCallback(){
	firstLoad();
}

function reOrderCcategory(upDown, categoryId) {
	var params = new Array();
	params.push("method=reOrderCcategory");
	params.push("upDown=" + upDown);
	params.push("categoryId=" + categoryId);
	params.push("userId=" + userId);
	params.push("compId=" + compId);
	params = params.join("&");
	request(getPath() + "/services/builder/builderService.jsp", params, reOrderCcategoryCallback, null, "notifySaveProgress", null, "failed");
}
function reOrderCcategoryCallback() {
	refreshCategory();
}