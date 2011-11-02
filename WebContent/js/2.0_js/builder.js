var selCatId = null;
var selCatSize = 0;
var selCatName = null;
var selGroupId = null;
var selGroupSize = 0;
var selGroupName = null;
var setGroupName = null;
var setObjId = null;
var setPkgType = null;
var setPkgId = null;
var setPkgName = null;

var selWorkDefId = null;
var selWorkDefType = null;
var selWorkDefName = null;
var setLanguage = null;

var selFormId = null;
var hdTab=null;
var hdTabAuth=null;
var hdTabLanguage=null;
function toggleBuilderMenuTree() {
	if ($('builderMenuTree').style.display === 'none') {
		$('builderMenuTreeList').contentWindow.location.href = "../builder/builderMenuTreeList.jsp?selCatId=" + selCatId + "&selGroupId=" + selGroupId;
		//$('builderMenuTreeList').contentWindow.location.reload();
		$('builderMenuTree').style.display = 'block';
	} else {
		$('builderMenuTree').style.display = 'none';
	}
}


function toggleShareMenuTree() {
	if ($('shareMenuTree').style.display === 'none') {
		$('shareMenuTreeList').contentWindow.location.href = "shareMenuTreeList.jsp?";
		$('shareMenuTree').style.display = 'block';
	} else {
		$('shareMenuTree').style.display = 'none';
	}
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
	
	var url = getPath() + "/services/common/categoryService.jsp";
	var params = new Array();
	params.push("method=createCategory");
	if (isNull(parentId)) {
		params.push("parentCategoryId=_PKG_ROOT_");
		selCatId = null;
		selCatSize = 0;
		selCatName = null;
	} else {
		params.push("parentCategoryId=" + parentId);
		selCatId = parentId;
		selCatSize = 0;
		selCatname = name;
	}
	params.push("name=" + name);
	params.push("desc=" + desc);
	params.push("compId=" + compId);
	params = params.join("&");
	request(url, params, createCategoryCallback, null, "notifySaveProgress", null , "warnSaveFailed");
	return null;
}
function createCategoryCallback() {
	selectCategory(selCatId, selCatSize, selCatName);
	$('builderMenuTreeList').contentWindow.location.href = "../builder/builderMenuTreeList.jsp";
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

	if (!isNull(selGroupId)) {
		removeGroup(selGroupId);
		return;
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
	selCatSize = 0;
	selCatName = null;
	selectCategory(selCatId, selCatSize, selCatName);
	$('builderMenuTreeList').contentWindow.location.href = "../builder/builderMenuTreeList.jsp";
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
	
	if (!isNull(selGroupId)) {
		popupSetGroupModalDialog(selGroupId);
		return;
	}
	
	var obj = getCategory(id);
	var name = obj["name"];
	var desc = obj["description"];
	popupNameDescModalDialog("setCategoryForm", setCategory, id, name, desc);
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
	selCatName = name;	
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
	selectCategory(selCatId, selCatSize, selCatName);
	$('builderMenuTreeList').contentWindow.location.href = "../builder/builderMenuTreeList.jsp";
}

/**
 * 카테고리선택 이벤트 시의 처리할 내역입니다.
 * @param id
 * @return
 */
 
 var builderStatusYn;
function selectCategory(catId, catSize, catName, groupId, groupSize, groupName, pkgId, pkgType, pkgName) {
	 
	 selCatId = catId;
	 selCatSize = catSize;
	 selCatName = catName;
	 
	 //selCatName="+selCatName+"&selCatId="+selCatId+"&noBuilderIdx=T'";
	 var params = new Array();
	 params.push("selCatName="+selCatName);
	 params.push("selCatId="+selCatId);
	 params.push("noBuilderIdx=T");
	 params = params.join("&");
	 
	 if(!builderStatusYn){
		 update("../builder/builderMain.jsp","mainTd",params, null, "loading");
		 //document.headerForm.action = "javascript:location.href='../builder/builderIndex.jsp?selCatName="+selCatName+"&selCatId="+selCatId+"&noBuilderIdx=T'";
		 //document.headerForm.submit();
	 }else{
		 if (typeof groupId === 'undefined') {
			 selGroupId = null;
		 } else {
			 selGroupId = groupId;
		 }
		 
		 if (typeof groupSize === 'undefined') {
			 selGroupSize = 0;
		 } else {
			 selGroupSize = groupSize;
		 }
		 
		 if (typeof groupName === 'undefined') {
			 selGroupName = null;
		 } else {
			 selGroupName = groupName;
		 }
		 
		 if (typeof pkgId === 'undefined') {
			 selWorkDefId = null;
		 } else {
			 selWorkDefId = pkgId;
		 }
		 
		 if (typeof pkgType === 'undefined') {
			 selWorkDefType = null;
		 } else {
			 selWorkDefType = pkgType;
		 }
		 
		 if (typeof pkgName === 'undefined') {
			 selWorkDefName = null;
		 } else {
			 selWorkDefName = pkgName;
		 }
		 if (selCatName !== null) {
			 $('catNameInfo').innerHTML = "&nbsp;&gt;&nbsp;" + selCatName;
		 } else {
			 $('catNameInfo').innerHTML = "";
		 }
		 if (selGroupName !== null) {
			 $('groupNameInfo').innerHTML = "&nbsp;&gt;&nbsp;" + selGroupName;
		 } else {
			 $('groupNameInfo').innerHTML = "";
		 }
		 
		 if (selWorkDefName !== null) {
			 $('pkgNameInfo').innerHTML = "&nbsp;&gt;&nbsp;" + selWorkDefName;
		 } else {
			 $('pkgNameInfo').innerHTML = "";
		 }
		 hideEditorView(); 
	 }
}

/**
 * <pre>공유관리소 카테고리선택</pre>
 * @param catId
 * @param catSize
 * @param catName
 * @param groupId
 * @param groupSize
 * @param groupName
 * @param pkgId
 * @param pkgType
 * @param pkgName
 * @return
 */
function selectShareCategory(catId, catSize, catName, groupId, groupSize, groupName, pkgId, pkgType, pkgName) {
	 selCatId = catId;
	 selCatSize = catSize;
	 selCatName = catName;
	 if (typeof groupId === 'undefined') {
		 selGroupId = null;
	 } else {
		 selGroupId = groupId;
	 }
	 
	 if (typeof groupSize === 'undefined') {
		 selGroupSize = 0;
	 } else {
		 selGroupSize = groupSize;
	 }
	 
	 if (typeof groupName === 'undefined') {
		 selGroupName = null;
	 } else {
		 selGroupName = groupName;
	 }
	 
	 if (typeof pkgId === 'undefined') {
		 selWorkDefId = null;
	 } else {
		 selWorkDefId = pkgId;
	 }
	 
	 if (typeof pkgType === 'undefined') {
		 selWorkDefType = null;
	 } else {
		 selWorkDefType = pkgType;
	 }
	 
	 if (typeof pkgName === 'undefined') {
		 selWorkDefName = null;
	 } else {
		 selWorkDefName = pkgName;
	 }
	 if (selCatName !== null) {
		 $('catNameInfo').innerHTML = "&nbsp;&gt;&nbsp;" + selCatName;
	 } else {
		 $('catNameInfo').innerHTML = "";
	 }
	 if (selGroupName !== null) {
		 $('groupNameInfo').innerHTML = "&nbsp;&gt;&nbsp;" + selGroupName;
	 } else {
		 $('groupNameInfo').innerHTML = "";
	 }
	 
	 if (selWorkDefName !== null) {
		 $('pkgNameInfo').innerHTML = "&nbsp;&gt;&nbsp;" + selWorkDefName;
	 } else {
		 $('pkgNameInfo').innerHTML = "";
	 }
	 $('shareMenuTreeList').contentWindow.location.href = "shareMenuTreeList.jsp?selCatId=" + selCatId + "&selGroupId=" + selGroupId;
}
 
 function firstLoad(language) {
		if(language =='undefined' || language == undefined) language = this.setLanguage;
		//alert(language+'///'+ this.setLanguage);
		var domain = document.domain;
		try{
			var port = window.location.port;
			if(port == '80'){
				port = '';
			}
		}catch(e){
			port = '';
		}
		domain = domain+':'+port;
		var flashVars = "serviceUrl=http://"+domain+"/&userId="+userId+"&compId="+compId+"&defaultLanguage="+language+"&packId="+this.setPkgId+"&packVer=1";
		loadSWF(getPath(), flashVars, document.getElementById("editorView"));
 }     
 
 
 var updateWorkDefMainViewCallbackFlag;
//jk builderIndex에서 시작하는것인지를 알기위한 변수.
function selectWorkDef(catId, catSize, catName, groupId, groupSize, groupName, pkgId, pkgType, pkgName, objId, language) {
	this.selCatSize = catSize;
	this.selGroupSize = groupSize;
	 this.selCatId = catId;
	 this.selCatName = catName;
	 this.selGroupId = groupId;
	 this.setGroupName = groupName;
	 this.setPkgId = pkgId;
	 this.setPkgType = pkgType;
	 this.setPkgName = pkgName;
	 this.setObjId = objId;	 
	 
	 this.setLanguage = language;
	 
	 	updateWorkDefMainViewCallbackFlag = true;
		builderIndexYn = true;
		builderStatusYn = true;
		firstLoad(language);
		updateWorkDefMainView(pkgId, pkgType, pkgName, catId,catName,groupId,groupName,objId);
		//refreshManageMenuTree();
}

/**
 * <pre>공유관리소 업무선택</pre>
 * @param catId
 * @param catSize
 * @param catName
 * @param groupId
 * @param groupSize
 * @param groupName
 * @param pkgId
 * @param pkgType
 * @param pkgName
 * @param objId
 * @return
 */
function selectShareWorkDef(catId, catSize, catName, groupId, groupSize, groupName, pkgId, pkgType, pkgName, objId) {
	clickPackage(pkgId, pkgType, objId);
}

/**
 * 메인화면을 아이디에 해당하는 업무정의 내역으로 갱신합니다.
 * @param id
 * @param type
 * @return
 jk
 */
function updateWorkDefMainView(pkgId, pkgType, pkgName, catId,catName,groupId,groupName,objId) {
	selWorkDefId = pkgId;
	selWorkDefType = pkgType;
	selWorkDefName = pkgName;
	
	 this.selCatId = catId;
	 this.selCatName = catName;
	 this.selGroupId = groupId;
	 this.setGroupName = groupName;
	 this.setPkgId = pkgId;
	 this.setPkgType = pkgType;
	 this.setPkgName = pkgName;
	 this.setObjId = objId;	 
	var url = getPath()+"/builder/workDefTable.jsp";
	var target = "mainView";
	var params = new Array();
	params.push("id=" + selWorkDefId);
	params = params.join("&");
	
	$('catNameInfo').innerHTML = "";
	$('groupNameInfo').innerHTML = "";
	$('pkgNameInfo').innerHTML = "";
	update(url, target, params, updateWorkDefMainViewCallback);
}

function updateWorkDefMainViewCallback() {
	var id = selWorkDefId;
	if (getMovie('diagram').reload) {  //for FF
		getMovie('diagram').reload(id, 1, '','');
	}
	var showEditorViewYn = showEditorView();

	if(showEditorViewYn){
		if(this.updateWorkDefMainViewCallbackFlag){
			this.updateWorkDefMainViewCallbackFlag = false;
			//sleep(1000);
			//alert(getMovie('diagram'));
			request(null,null,flexBuilderLoad,null,'loading');
		}
	}
}
 
function flexBuilderLoad(){
	var id = selWorkDefId;
	if (getMovie('diagram').reload) {
		getMovie('diagram').reload(id, 1, '','');
	}	
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
	if (isNull(catId)) {
		warnMessage("errorCodeNotSelected");
		return null;
	}
	
	var url = getPath() + "/builder/dialog/createWorkDef.jsp";
	var params = new Array();
	params.push("title=createWorkDefForm");
	params.push("categoryId=" + catId);
	params.push("groupId=" + groupId);
	params = params.join("&");
	popupModalDialog(url, params, createWorkDef);
}
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
	
	var url = getPath() + "/services/builder/builderService.jsp";
	var params = new Array();
	params.push("method=createPackage");
	params.push("categoryId=" + (isNull(groupId)? categoryId : groupId));
	params.push("name=" + name);
	params.push("type=" + type);
	params.push("desc=" + desc);
	params.push("compId=" + compId);
	params = params.join("&");
	//jk yoon
	//alert(params);
	request(url , params , createWorkDefCallback , null , "inProgress" , null , "failed");
}
function createWorkDefCallback() {
	if (isNull(selGroupId)) {
		selectCategory(selCatId, selCatSize+1, selCatName, selGroupId, selGroupSize, selGroupName);
	} else {
		selectCategory(selCatId, selCatSize, selCatName, selGroupId, selGroupSize+1, selGroupName);
	}
	$('builderMenuTreeList').contentWindow.location.href = "../builder/builderMenuTreeList.jsp?selCatId=" + selCatId + "&selGroupId=" + selGroupId;
}

/**
* 그룹을 생성합니다.
* @param categoryId 부모 카테고리아이디
* @param name
* @param desc
* @return
*/
function createGroup(categoryId, name, desc) {
	createCategory(categoryId, name, desc);
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
	selGroupName = name;
	
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
	selectCategory(selCatId, selCatSize, selCatName, selGroupId, selGroupSize, selGroupName);
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
	selGroupId = null;
	selGroupSize = 0;
	selGroupName = null;
	selectCategory(selCatId, selCatSize, selCatName, selGroupId, selGroupSize, selGroupName);
}

/**
* 업무정의를 수정하는 대화상자를 띄웁니다.
* @param id
* @param type
* @return
* popupSetWorkDefModalDialog(id, type)
*/
function popupSetWorkDefModalDialog(){
	var id = selWorkDefId;
	
	var obj = getWorkDef(id);
	var name = obj["name"];
	var desc = obj["description"];
	
	popupNameDescModalDialog("setWorkDefForm", setWorkDef, id, name, desc);
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
	selWorkDefName = name;
	
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
	selectWorkDef(selCatId, selCatSize, selCatName, selGroupId, selGroupSize, selGroupName, selWorkDefId, selWorkDefType, selWorkDefName, setObjId,setLanguage);
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
	
	selCatSize = selCatSize + 1;
	if (isNull(toCategoryId)) {
		toCategoryId = selCatId;
		toGroupId = selGroupId;
	}
	if (!isNull(toGroupId)) {
		toCategoryId = toGroupId;
		selGroupSize = selGroupSize + 1;
		selCatSize = selCatSize - 1;
	}

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
	selectCategory(selCatId, selCatSize, selCatName, selGroupId, selGroupSize, selGroupName);
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
	params.push("objId=" + this.setObjId);
	params = params.join("&");
	request(url, params, moveWorkDefCallback, null, "inProgress", null, "failed");
}
function moveWorkDefCallback() {
	selectCategory(selCatId, selCatSize, selCatName, selGroupId, selGroupSize, selGroupName);
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
 * 업무정의를 복사하는 대화상자를 띄웁니다.
 * @return
 */
function popupCloneWorkDefModalDialog() {
	if (isNull(selCatId)) {
		warnMessage("errorCodeNotSelected");
		return null;
	}
	popupWorkDefListModalDialog("cloneWorkDefForm", cloneWorkDef);
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
		if(isNull(selGroupId)) {
			selectCategory(selCatId, selCatSize-1, selCatName, selGroupId, selGroupSize, selGroupName);
		} else {
			selectCategory(selCatId, selCatSize, selCatName, selGroupId, selGroupSize-1, selGroupName);
		}
	} else if(resultXml.getAttribute('status') == "DEPLOYED") {
		warnMessage('failed','Youcannotdeletethebusinessservicedefinition');//서비스중인 업무정의는 삭제할 수 없습니다.;
	}
}

var pakageId = "";
var contentType = "";

/**
 * '편집완료' 시 저장에 관한 확인
 * @param id
 * @param type
 */
function checkInWorkDef(id, type){

	pakageId = id;
	contentType = type;

	//alert(pakageId);
	//alert(contentType);
	//if(confirm('저장 후 완료하시겠습니까?')) {
	//	if(type == 'PROCESS') {
	//		saveProcessContent();
	//	} else {
	//		saveFormContent();
	//	}
	//} else {
		_checkInWorkDef(pakageId, contentType);
	//}
}

function saveProcessContent() {

	var url = getPath() + "/services/builder/builderService.jsp";
	var params = new Array();
	params.push("method=saveProcessContent");
	params = params.join("&");
	request(url, params, saveProcessContentCallback, null, "inProgress", null, "failed");
}

function saveProcessContentCallback() {
	_checkInWorkDef(pakageId, contentType);
}

function saveFormContent() {
	var url = getPath() + "/services/builder/builderService.jsp";
	var params = new Array();
	params.push("method=saveFormContent");
	params = params.join("&");
	request(url, params, saveFormContentCallback, null, "inProgress", null, "failed");
}

function saveFormContentCallback() {
	_checkInWorkDef(pakageId, contentType);
}

/**
 * 업무정의를 편집을 완료합니다.
 * @param id
 * @param type
 * @return
 */
function _checkInWorkDef(id, type){

	var url = getPath() + "/services/builder/builderService.jsp";
	var params = new Array();
	params.push("method=checkInPackage");
	params.push("packageId=" + id);
	params.push("compId=" + compId);
	params = params.join("&");

	request(url, params, checkInWorkDefCallback, null, "inProgress", null, "failed");
}

function checkInWorkDefCallback() {
	selectWorkDef(selCatId, selCatSize, selCatName, selGroupId, selGroupSize, selGroupName, selWorkDefId, selWorkDefType, selWorkDefName, setObjId,setLanguage);
}

/**
 * 업무정의 편집을 시작합니다.
 * @param id
 * @param type
 * @return
 */
function checkOutWorkDef(id, type){
	var url = getPath() + "/services/builder/builderService.jsp";
	var params = new Array();
	params.push("method=checkOutPackage");
	params.push("packageId=" + id);
	params.push("compId=" + compId);
	params = params.join("&");
	request(url, params, checkOutWorkDefCallback, null, "inProgress", null, "failed");
}
function checkOutWorkDefCallback() {
	selectWorkDef(selCatId, selCatSize, selCatName, selGroupId, selGroupSize, selGroupName, selWorkDefId, selWorkDefType, selWorkDefName,setObjId,setLanguage);
}

/**
 * 업무정의를 서비스 시작합니다.
 * @param id
 * @param type
 * @return
 */
function deployWorkDef(id, type) {
	var url = getPath() + "/services/builder/builderService.jsp";
	var params = new Array();
	params.push("method=deployPackage");
	params.push("packageId=" + id);
	params.push("compId=" + compId);
	params.push("type=" + type);
	params = params.join("&");
	request(url, params , deployWorkDefCallback, null , "inProgress" , null , "failed");
}
function deployWorkDefCallback() {
	
	var xmlDoc = getXmlDOM(getResult());
	var resultXml = SmartXMLUtil.getChildNode(xmlDoc, 'Result');
	if (resultXml.getAttribute('deployCheck') == 'FAIL') {
		warnMessage('Warning', 'NoWrittenWorkViewInformation');
		return false;
	}else{
		selectWorkDef(selCatId, selCatSize, selCatName, selGroupId, selGroupSize, selGroupName, selWorkDefId, selWorkDefType, selWorkDefName,setObjId,setLanguage);
		//refreshManageMenuTree();
	}
}

/**
 * 업무정의를 서비스 중지합니다.
 * @param id
 * @param type
 * @return
 */
function undeployWorkDef(id, type) {
	var url = getPath() + "/services/builder/builderService.jsp";
	var params = new Array();
	params.push("method=undeployPackage");
	params.push("packageId=" + id);
	params.push("compId=" + compId);
	params = params.join("&");
	request(url , params , undeployWorkDefCallback, "Doyouwanttostop" , "isStopping" , null , "failed");
}
function undeployWorkDefCallback() {
	selectWorkDef(selCatId, selCatSize, selCatName, selGroupId, selGroupSize, selGroupName, selWorkDefId, selWorkDefType, selWorkDefName,setObjId,setLanguage);
	//refreshManageMenuTree();	
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

/**
* 에디터뷰를 보이게 합니다.
* @return
*/
function showEditorView() {
	var mainView = document.getElementById("mainView");
	mainView.style.display = "";
	var view = document.getElementById("editorView");
	view.style.overflow = 'hidden';
	if (view == null)
		return;
	view.height = "760px";
	view.style.display = "block";
	$('builderMenuTree').style.display = 'none';
	return true;
}
/**
* 에디터뷰를 숨깁니다.
* @return
*/
function hideEditorView() {
	var mainView = document.getElementById("mainView");
	mainView.style.display = "none";
	var view = document.getElementById("editorView");
	if (view == null)
		return;
	//view.height = "1px;";
	view.style.display = "none";
	//$('builderMenuTree').style.display = 'block';
	//$('builderMenuTreeList').contentWindow.location.href = "builderMenuTreeList.jsp?selCatId=" + selCatId + "&selGroupId=" + selGroupId;
}

/**
* 에디터 SWF가 새로 로딩되면 호출되는 함수 (SWF 안으로 포함됨)
* @param status
* @return
*/
this.loadStatusHeight = 0;
this.fullMode = false;
this.fullModeHeight = 0;
function loadCallback(status){
//alert(status);
	var view = document.getElementById("editorView");
	if(this.fullMode){
		if(this.fullModeHeight < status)
			view.height = this.fullModeHeight
		else
			view.height = status;
	}else{
		view.height = status;
	}
	this.loadStatusHeight = status;
	view.style.overflow = 'hidden';
	if (selWorkDefType == "SINGLE") {
		hideFormListView();
	} else {
		updateFormListView();
		// TODO
		if (status == "DEPLOYED") {
		} else {
		}
		//showFormListView();
	}
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

function updateFormListView(workDefId) {
	if (isNull(workDefId))
		workDefId = selWorkDefId;
	if (isNull(workDefId)) {
		warnMessage("errorCodeNotSelected");
		return;
	}

	clearFormListTable();
	
	var url = getPath() + "/services/builder/builderService.jsp";
	var params = new Array();
	params.push("method=getFormList");
	params.push("packageId=" + selWorkDefId);
	params.push("compId=" + compId);
	params = params.join("&");
	request(url, params, updateFormListViewCallback, null, "loading", null, "failed");
	//request(url, params, null, null, "loading", null, "failed");
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
		imgTd.align = "center";
		imgTd.vAlign = "middle";
		imgTd.width = "30";
		imgTd.innerHTML = '&nbsp;<img src="../images/' + (type == "NONE"? 'notUse2' : 'use2') + '.png"  border="0">';
		
		var nameTd = document.createElement('td');
		nameTd.id = id + "_td2";
		nameTd.style.wordBreak = "break-all";
		nameTd.align = "left";
		nameTd.vAlign = "middle";
		//nameTd.width = "141";
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
	getMovie("diagram").removeForm(id);
}
function removeFormCallback() {
	var id = selFormId;
	var obj = document.getElementById(id);
	if (obj != null) {
		obj.parentNode.removeChild(obj);
	}
	selFormId = null;
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
}
function setFormCallback() {
	// TODO
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
	firstLoad(this.setLanguage);
}




//////////////////////// 이하 확인 후 삭제 (2010-04-23)
/**
 * 양식을 생성할 대화상자를 띄웁니다.
 * @return
 */
function popupCreateFormModalDialog() {
	popupNameDescModalDialog("setFormForm", createForm, null, null, null, false);
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

function goBuilder(){
	var pkgId = this.setPkgId;
	var pkgType = this.setPkgType;
	var pkgName = this.setPkgName;
	var objId = this.setObjId;
	var catId = this.selCatId;
	var catName = this.selCatName;
	var groupId = this.selGroupId;
	var groupName = this.setGroupName;
	$('editorView').show();
	
	$('catNameInfo').innerHTML = "";
	$('groupNameInfo').innerHTML = "";
	$('pkgNameInfo').innerHTML = "";
	updateWorkDefMainView(pkgId, pkgType, pkgName, catId,catName,groupId,groupName,objId);
}

function goWorkShare(){
	var params = new Array();
	params.push("type="+this.setPkgType);
	params.push("pkgName="+this.setPkgName);
	params.push("catName="+this.setCatName);
	params = params.join("&");
	$('editorView').hide();
	$('catNameInfo').innerHTML = "";
	$('groupNameInfo').innerHTML = "";
	$('pkgNameInfo').innerHTML = "";
	update("../shareBasket/shareBasketContent.jsp","mainView",params,goClickPackage);
}

function goClickPackage(){
	var objId = this.setObjId;
	var pkgId = this.setPkgId;
	var pkgType = this.setPkgType;
	clickPackage(pkgId, pkgType, objId);
}
function goWorkConfig(){
	var objId = this.setObjId;
	var catId = this.selCatId;
	var catName = this.selCatName;
	var groupId = this.selGroupId;
	var groupName = this.setGroupName;
	var objName = this.setPkgName;
	var pkgType = this.setPkgType;
	$('editorView').hide();
	$('catNameInfo').innerHTML = "";
	$('groupNameInfo').innerHTML = "";
	$('pkgNameInfo').innerHTML = "";
	
	changePackage(catId, catName, groupId, groupName, objId, objName, pkgType);
}
var refreshManageMenuTreePInfo;

function refreshManageMenuTree(){
	$('builderMenuTreeList').contentWindow.location.href = "../builder/builderMenuTreeList.jsp?selCatId=" + selCatId + "&selGroupId=" + selGroupId +"&pInfo=" + refreshManageMenuTreePInfo;
}

function manageMenuTree(pInfo) {
	if ($('builderMenuTree').style.display === 'none') {
		refreshManageMenuTreePInfo = pInfo;
		if(!builderStatusYn){
			var params = new Array();
			params.push("noBuilderIdx=T");
			params = params.join("&");
			update("../builder/builderMain.jsp","mainTd",params, null, null);
			if($('builderMenuTreeList').contentWindow.location.href == 'about:blank'){
				$('builderMenuTreeList').contentWindow.location.href = "../builder/builderMenuTreeList.jsp?selCatId=" + selCatId + "&selGroupId=" + selGroupId +"&pInfo=" + pInfo;
			}
			$('builderMenuTree').style.display = 'block';
			builderStatusYn = true;
		}else{
			if($('builderMenuTreeList').contentWindow.location.href == 'about:blank'){
				$('builderMenuTreeList').contentWindow.location.href = "../builder/builderMenuTreeList.jsp?selCatId=" + selCatId + "&selGroupId=" + selGroupId +"&pInfo=" + pInfo;
			}
			$('builderMenuTree').style.display = 'block';
		}
	} else {
		$('builderMenuTree').style.display = 'none';
	}
}
function fullScreenCallback(param){
	if(param == 'FullScreen'){
		$('defaultDiv').hide();
		$('casterArea').hide();
		$('headerWrap').hide();
		$('casterButton').hide();
		$('jyc_contents_title').hide();
		//$('footerWrap').hide();
		var view = document.getElementById("editorView");
		var body = document.body;
		window.scrollTo(0,0)
		if(this.loadStatusHeight < (body.offsetHeight-50))
			view.height = this.loadStatusHeight + 'px'; 
		else
			view.height = (body.offsetHeight-50)+'px';
		view.width = $('mainContentsArea').offsetWidth;
		   body.style.overflow="hidden";
		this.fullMode = true;
		this.fullModeHeight = body.offsetHeight-50;
		//window.open("../builder/fullScreenBuilder.jsp?pkgId="+this.setPkgId+"&pkgType="+this.setPkgType+"&pkgName="+this.setPkgName+"&catId="+this.selCatId+"&catName="+this.selCatName+"&groupId="+this.selGroupId+"&objId="+this.setObjId,"","menubar=no, toolbar=no, location=no, status=no, fullscreen");
	}else{
		$('defaultDiv').show();
		$('casterArea').show();
		$('headerWrap').show();
		$('casterButton').show();
		$('jyc_contents_title').show();
		//$('footerWrap').show();
		var body = document.body;
		   body.style.overflow="auto";
		   
		this.fullMode = false;
	}
}

