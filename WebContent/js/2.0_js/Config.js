
/**
 * 프로그램명  : /js/Config.js
 * 최초	작성자 : 조형래
 * 최초	작성일 : 2008.10.23
 * 최종	수정자 : 안상길
 * 최종	수정일 : 2009.04.07
 * 프로그램설명 : 설정에서 사용하는 자바스크립트 일원화
 */
function changePackage(catId, catName, groupId, groupName, objId, objName, pkgType) {
	var	params = "catId=" + catId + "&catName=" + catName + "&objId="+objId+"&objName="+objName+"&pkgType="+pkgType;
	if (groupId != "" && groupId != null) {
		params += "&groupId=" + groupId + "&groupName=" + groupName;
	}
	if(objId !=	"" && objId	!= null) {
		update("../config/authContent.jsp", "mainView", params, null, "loading", "failed");
	}
}
function hideConfigTree(){
	$('configMenuTree').style.display = 'none';
}
 
/**
 * 권한 저장
 * 
 * @param mode	     : 수정 저장 삭제 조회 종류
 * @param permission : 전체 선택 
 * @param objId 	 : 폼아이디
 */
function setModeSave(mode, permission, objId) {
	var params = new Array(); 
	var objTable = document.getElementById(mode+"_authListTable");
	
	if(permission == "PUB_SELECT"){
		objTable.style.display = "";
		var treeArea = 'readTreeList';
		if (mode === 'R') {
			treeArea = 'readTreeList';
		} else if (mode === 'W') {
			treeArea = 'writeTreeList';
		} else if (mode === 'M') {
			treeArea = 'modifyTreeList';
		} else if (mode === 'D') {
			treeArea = 'delTreeList';
		}
		document.getElementById(treeArea).src = getPath() + '/config/authDeptList.jsp?treeArea=' + treeArea;
	} else {
		objTable.style.display = "none";
	}
	
	params.push("method=setModeSave");
	params.push("mode="+mode);
	params.push("permission="+permission);
	params.push("objId="+objId);
	params.push("userId="+userId);
	params.push("compId="+compId);
	params = params.join("&");
	request(getPath() + "/services/portal/configService.jsp" , params , null , null , 'notifySaveProgress' , null , 'warnSaveFailed');
}

/**
 * 1.read Radio button choice
 * @param openCd
 * @param formId
 * @return
 */
function taskRead(openCd , formId){
	if(openCd == 'S') {
		document.getElementById("authReadTable").style.display = "";
	} else {
		document.getElementById("authReadTable").style.display = "none";
	}	
}

/**
 * 2. write Radio button choice
 * @param openCd
 * @param formId
 * @return
 */
function taskWrite(openCd , formId) {
	if(openCd == 'S') {
		document.getElementById("authWriteTable").style.display = "";
	} else {
		document.getElementById("authWriteTable").style.display = "none";
	}
}

/**
 * 3.modify Radio button choice
 * @param openCd
 * @param formId
 * @return
 */
function taskModify(openCd , formId) {
	if(openCd == 'S') {
		document.getElementById("authModifyTable").style.display = "";
	} else {
		document.getElementById("authModifyTable").style.display = "none";
	}
}

/**
 * etc. 클릭한 글 굵게
 * @param obj
 * @param deptId
 * @param type
 * @param seq
 * @return
 */ 
function getDeptListClick(deptId, type, obj) {
	 //alert('123'+obj);
	if (typeof obj === 'object') {
		if (prevMenu !=	null &&	prevMenu !=	obj) {
			prevMenu.style.fontWeight  = "";
		}
		prevMenu = obj;
		prevMenu.style.fontWeight  = "bold";
	}
	
	document.taskModifyForm.deptId.value = deptId;
	document.taskModifyForm.authType.value = type;	
}
 
/**
 * 드래그시 Bold char 로 변경됨
 * @param tbId
 * @return
 */
function bold(tbId){
	f = document.getElementById(tbId);
	if(f.contentDocument){
		src_doc  = f.contentDocument;
		id= src_doc.title;
	}
}

/**
 * user and department Move Contents
 * @param formId  : 폼아이디 혹은 프로세스 아이디 값
 * @param itemCd  : 선택 추가 혹은 삭제 ( ud , uc )
 * @param type    : 권한 타입( 조회:R , 작성:W , 수정:M , 삭제:D )
 * @param tableId : 테이블 아이디 값
 * @return
 */
function setAuthMove(itemCd , type , tableId) {
	var	form = document.taskModifyForm;
	var	params = new Array();
	params.push("method=saveAuthInfo");
	params.push("objId=" + form.formId.value);
	params.push("deptId=" + form.deptId.value);
	//params.push("title=" + form.title.value);
	params.push("saveMode=" + itemCd);
	params.push("authType="+form.authType.value);
	params.push("type=" + type);
	params.push("tableId=" + tableId);
	params.push("userId="+userId);
	params.push("compId=" + compId);
	params = params.join("&");
	linkUrl = getPath()+"/services/portal/configService.jsp";
	
	if(type == 'R') {
		if(form.deptId.value !=	null ||	form.deptId.value != "") {
			request(linkUrl , params , setAuthMoveCallback , null , 'notifySaveProgress' , null , 'warnSaveFailed');
		}
	} else  if(type == 'W'){
		if(form.deptId.value !=	null ||	form.deptId.value != "") {
			request(linkUrl , params , setAuthMoveCallback , null , 'notifySaveProgress' , null , 'warnSaveFailed');
		}
	} else  if(type == 'M'){
		if(form.deptId.value !=	null ||	form.deptId.value != "") {
			request(linkUrl , params , setAuthMoveCallback , null , 'notifySaveProgress' , null , 'warnSaveFailed');
		}
	}else  if(type == 'D'){
		if(form.deptId.value !=	null ||	form.deptId.value != "") {
			request(linkUrl , params , setAuthMoveCallback , null , 'notifySaveProgress' , null , 'warnSaveFailed');
		}
	}
}
function setAuthMoveCallback() {
	var xmlDoc = getXmlDOM(getResult());
	var resultXml = SmartXMLUtil.getChildNode(xmlDoc, 'Result');
	if(resultXml.getAttribute('status') == 'OK') {
		var userXml   = SmartXMLUtil.getChildNodes(resultXml, 'UserInfo');
		var userName  = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(userXml[0], 'name'));
		var userId    = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(userXml[0], 'id'));
		var saveMode  = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(userXml[0], 'saveMode'));
		var type   			   = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(userXml[0], 'type'));
		var duplicationCheck   = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(userXml[0], 'duplicationCheck'));
		var tableId   		   = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(userXml[0], 'tableId'));
		var messageType 	   = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(userXml[0], 'messageType'));
		
		var selectTheUser = document.getElementById(tableId);
		var tBody = selectTheUser.getElementsByTagName("tbody")[0];
		if(saveMode == "UC") {
			duplicationcheckMessage2(userName, userId, saveMode, type, duplicationCheck, tableId, messageType);
		} else if(saveMode == "UD") {
		    if (tBody.hasChildNodes()) {
		    	tBody.removeChild(document.getElementById(userId + tableId + "_select_userTr"));       //tbl.removeChild(tbl.firstChild);  
			}
		}
	}
}

/**
 * 
 * @param userName
 * @param userId
 * @param saveMode
 * @param type
 * @param duplicationCheck
 * @param tableId
 * @return
 */
function duplicationcheckMessage2(userName, userId, saveMode, type, duplicationCheck, tableId , messageType){
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
		tr.setAttribute('onclick',"getDeptListClick('"+ userId +"','"+ type +"', this)");
		//tr.onclick = function(){eval("getDeptListClick('"+ userId +"','"+ type +"', "+tr+")")};
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

/**
 * 버튼, 한국어, 외국어 분별
 * @param language
 * @return
 */
function imageLanguageType(language){
	var imageLanguage = "";
	if(language != "KOR"){
		imageLanguage = language + "/";
	}
	return imageLanguage;
}

/**
 * 조직관리 부서추가/수정 폼 로드 후 부서목록창 모탈 팝업으로 등장
 * @return
 */
function setDeptAddForm(type, language, isRoot) {

	var imageLanguage = imageLanguageType(language);
	if(type == 'deptAdd') {
		document.getElementById("deptTitleName").innerHTML = userLanguage === 'KOR' ? "부서추가" : "Add Department";
	}
	
	document.getElementById("logoInfoTb").style.display = "none";
	//document.getElementById("mailingInfoTb").style.display = "none";
	document.getElementById("deptInfoTb").style.display = "";
	document.getElementById("userInfoTb").style.display = "none";
	document.getElementById("userInfoModifyTb").style.display = "none";
		
	var saveImage = "<img src='../images/" + imageLanguage + "btn_save.gif' border='0' onclick='setDeptSave();' style='cursor:pointer;'>";
	document.getElementById("deptSaveControlValue").innerHTML = saveImage;

	if (document.viewForm.deptName.value !== '') {
		document.viewForm.parentName.value = document.viewForm.deptName.value;
		document.viewForm.deptName_forUserAdd.value = document.viewForm.deptName.value;
	} else {
		document.viewForm.parentName.value = document.viewForm.deptName_forUserAdd.value;
	}

	document.viewForm.parentId.value = document.viewForm.deptId.value;
	document.viewForm.deptName.value = '';
	document.viewForm.deptName.focus();
}
 
/**
 * 조직관리 부서 신규 저장, 부서저장후 화면 Refresh  
 * @return
 */
function setDeptSave() {
	var form = document.viewForm;
	if(form.parentId.value == null || form.parentId.value == "") {
		warnMessage('Youdidnotentertherequireditems', 'SelecttheDivision');
		return;
	} else if(form.deptName.value == null || form.deptName.value == "") {
		warnMessage('Youdidnotentertherequireditems', 'EnterDepartment'); 
		form.deptName.focus();
		return;
	}
	var params = new Array();
	params.push("companyId=" + compId);
	params.push("type=" + form.type.value);
	params.push("deptName=" + encodeURIComponent(form.deptName.value));
	params.push("parentId=" + form.parentId.value);
	params.push("method=deptInfoCMD");
	params.push("saveStyle=create");
	params.push("userId="+userId);
	params.push("compId="+compId);
	params = params.join("&");
	linkUrl = getPath()+"/services/portal/configService.jsp";
	request(linkUrl ,  params , setDeptSaveCallback  , null , "loading" , null ,"failed");
}
function setDeptSaveCallback(){
	document.viewForm.deptName.value ="";
	document.getElementById('deptTreeList').src = getPath() + '/config/orgDeptList.jsp?parentId=' + document.viewForm.parentId.value;
	//document.getElementById('deptTreeList').src = getPath() + '/config/orgTreeList.jsp?parentId=' + document.viewForm.parentId.value;
}

/**
 * 조직관리 조직도를 클릭 했을 경우 조직에 속한 사원을 보여준다.
 * 부서정보도 같이 보여줌 ( 수정 및 삭제 기능)
 * @param deptId
 * @param parentId
 * @param companyId
 * @return
 */
function getDeptClick(deptId, parentId, companyId, img) {
	var params = new Array();
	params.push("deptId="+deptId);
	params.push("companyId="+companyId);
	params.push("parentId="+parentId);
	params.push("method=getDeptClick");
	params.push("userId="+userId);
	params.push("compId="+compId);
	params.push("deptImg="+img);
	params = params.join("&");
	linkUrl = getPath()+"/services/portal/configService.jsp";
	
	document.getElementById("deptImg").setAttribute("value", img);
	
	//request(linkUrl ,  params , getDeptClickCallback , null , "loading" , null ,"failed");
	request(linkUrl ,  params , getDeptClickCallback , null ,null , null);
}
 
function getDeptClickCallback() {
	
	document.getElementById("addButtonTb").style.display  = "";
	document.getElementById("logoInfoTb").style.display = "";
	//document.getElementById("mailingInfoTb").style.display = "block";
	document.getElementById("deptInfoTb").style.display  = "";
	document.getElementById("userInfoTb").style.display  = "none";
	document.getElementById("userInfoModifyTb").style.display = "none";
	document.getElementById("deptTitleName").innerHTML = userLanguage === 'KOR' ? "부서정보" : "Department Info";
	
	var xmlDoc = getXmlDOM(getResult());
	var resultXml = SmartXMLUtil.getChildNode(xmlDoc, "Result");

	if(resultXml.getAttribute('status') == 'OK') {
		var deptInfoXml        = SmartXMLUtil.getChildNodes(resultXml, 'deptInfo');
		var deptName 	       = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(deptInfoXml[0], 'deptName'));
		var parentDeptName     = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(deptInfoXml[0], 'parentDeptName'));
		var deptUserCountValue = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(deptInfoXml[0], 'deptUserCountValue'));
		var deptId 			   = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(deptInfoXml[0], 'deptId'));
		var parentId 		   = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(deptInfoXml[0], 'parentId'));
		var companyId 		   = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(deptInfoXml[0], 'companyId'));
		var warningMessage 	   = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(deptInfoXml[0], 'warningMessage'));
		
		document.viewForm.parentName.value = parentDeptName;
		document.viewForm.deptName.value   = deptName;
		document.viewForm.deptId.value     = deptId;
		document.viewForm.parentId.value   = parentId;
		document.viewForm.companyId.value  = companyId;
		
		document.getElementById("addDeptName").innerHTML = document.viewForm.deptName.value;
		
		var imageLanguage = imageLanguageType($F("userLanguage"));	
		if (document.viewForm.parentId.value !== 'Root' && document.viewForm.parentId.value !== 'root') {
			
			document.getElementById("logoInfoTb").style.display = "none";
			//document.getElementById("mailingInfoTb").style.display = "none";
			document.getElementById("deptInfoTb").style.display  = "";
			
			var saveImage   = "<img src='../images/"+ imageLanguage +"btn_save.gif'   border='0' style='cursor:pointer' onclick='setDeptModify();'>";
			var deleteImage = "<img src='../images/"+ imageLanguage +"btn_del.gif' border='0' style='cursor:pointer' onClick='removeDept(\"" + deptUserCountValue + "\",\"" + warningMessage + "\");'>";
			document.getElementById("deptSaveControlValue").innerHTML = saveImage + "&nbsp;&nbsp;" + deleteImage;
			
		} else {
			
			document.getElementById("logoInfoTb").style.display = "";
			//document.getElementById("mailingInfoTb").style.display = "";
			document.getElementById("deptInfoTb").style.display  = "none";
			
			document.getElementById("deptInfoTb").style.display  = "none";
			document.getElementById("deptSaveControlValue").innerHTML = "";
		}
	} else {
		document.getElementById("deptInfoTb").style.display			 = "none";
	}
}

/**
 * 조직관리 사용자 추가 폼을 로드한다.
 * 
 * @param deptId
 * @param companyId
 * @param parentId
 * @return
 */
function setUserFormOpen(userSize, licenseSize) {
	 //20인까지는 무상
	 //if(userSize > 20 && userSize >= licenseSize) {
		 //alert("사용이 허가된 사용자를 초과하셨습니다. \n라이센스를 갱신하세요.");
	 //} else {
	 	document.getElementById("logoInfoTb").style.display = "none";
	 	//document.getElementById("mailingInfoTb").style.display = "none";
		document.getElementById("deptInfoTb").style.display  = "none";
		document.getElementById("userInfoTb").style.display = "";
		document.getElementById("userInfoModifyTb").style.display = "none";
		
		if (document.viewForm.deptName.value !== '') {
			document.viewForm.parentName.value = document.viewForm.deptName.value;
		} else {
			document.viewForm.parentName.value = document.viewForm.deptName_forUserAdd.value;
		}
		var deptImg = document.getElementById("deptImg").getAttribute("value");
		if(deptImg == 'undefined') deptImg = "../images/dept_company.gif";
		var addUserDeptName = "<img src = '"+deptImg+"' align='absmiddle'> "+document.viewForm.parentName.value;
		
		document.viewForm.parentId.value = document.viewForm.deptId.value;
		
		document.getElementById("addUserDeptName").innerHTML = addUserDeptName;
		
		//document.viewForm.addUserDeptName.value = document.viewForm.parentName.value;
		
		document.viewForm.addUserName.value="";
		document.viewForm.addUserId.value="";
		document.viewForm.addUserPasswd.value="";
		document.viewForm.addUserPasswd1.value="";
		document.viewForm.addUserEmpNo.value="";
		document.viewForm.addUserPosition.value="";
		document.viewForm.addUserName.focus();
	 //}
}

function status() {
	var swStatus = document.getElementById("swStatus");
	if (swStatus == null || swStatus.innerHTML != "reloading") {
		setTimeout("status()", 5000);
	} else {
		alert('창을 닫아주세요.');
		window.close();
	}
}

/*
 * 미확인
 */
function popupUpdateModalDialog() {
	window.showModalDialog(getPath() + "/config/updatePopup.jsp", window, "dialogWidth: 800px; dialogHeight: 600px; center: yes; help: no; status: no; scroll: no; resizable: no");
}

function reload() {
	if (!confirm("다시시작하시겠습니까? (1분소요예상)"))
		return;
	var swStatus = document.getElementById("swStatus");
	if (swStatus != null) {
		swStatus.innerHTML = "reloading";
	}
	send("reload.jsp", null, null, null, true);
}

/**
 * 좌측	메뉴 클릭
 */
var	prevMenu = null;
function menuClick(obj,	linkUrl) {
	var	objId =	obj.id;
	if (prevMenu !=	null &&	prevMenu !=	obj) {
		//prevMenu.style.fontWeight  = "";
		prevMenu.setAttribute('class','choose');
		//prevMenu.className = 'normal';
	}
	prevMenu = obj;
	//prevMenu.style.fontWeight  = "bold";
	prevMenu.setAttribute('class','select');
	//prevMenu.className = 'select';
	if (objId === 'compInfo') {
		update(linkUrl, "mainView", null, compInfoListHour, "loading", "failed");
	} else if(objId === 'webService') {
		update(linkUrl, "mainView", null, showWebServiceList, "loading", "failed");
	} else if(objId === 'extBusinessScreen') {
		update(linkUrl, "mainView", null, showExternalBusinessScreenList, "loading", "failed");
	} else if(objId ==='org') {
		var params = new Array();
		params.push("noHeaderBuilderYn=true")
		update(linkUrl, "mainView", params, null, "loading", "failed");
	} else {
		update(linkUrl, "mainView", null, null, "loading", "failed");
	}
	//alert('menuClick out');
}

/**
 * 사용자목록 클릭시 나타나는 이벤트로 클릭한 사용자의 정보를 보여줌
 * 
 * @param id       : 사용자 아이디
 * @param parentId : 상위부서 아이디
 * @return
 */
function getUserEditForm(id, parentId) {//orgUserEdit(id, linkUrl, parentId) {
	var params = new Array();
	params.push("id=" +  id);
	params.push("parentId=" +  parentId);
	params.push("method=getUserEditForm");
	params.push("userId=" + userId);
	params.push("compId="+compId);
	params = params.join("&");
	
	var linkurl = getPath() + "/services/portal/configService.jsp";
	request(linkurl , params , getUserEditFormCallBack , null , null , null);	
}

function getUserEditFormCallBack() {
	
	document.getElementById("addButtonTb").style.display  = "";
	document.getElementById("logoInfoTb").style.display = "none";
	//document.getElementById("mailingInfoTb").style.display = "none";
	document.getElementById("deptInfoTb").style.display  = "none";
	document.getElementById("userInfoTb").style.display  = "none";
	document.getElementById("userInfoModifyTb").style.display = "";
	
	var xmlDoc = getXmlDOM(getResult());
	var resultXml = SmartXMLUtil.getChildNode(xmlDoc, "Result");
	
	if(resultXml.getAttribute('status') == 'OK') {
		var userListXml  = SmartXMLUtil.getChildNodes(resultXml, 'UserInfo');
		var userId 	     = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(userListXml[0], 'id'));
		var userName 	 = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(userListXml[0], 'name'));
		var password 	 = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(userListXml[0], 'password'));
		var password1 	 = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(userListXml[0], 'password1'));
		var deptName 	 = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(userListXml[0], 'deptName'));
		var empNo		 = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(userListXml[0], 'empNo'));
		var position 	 = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(userListXml[0], 'position'));
		var roleId 		 = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(userListXml[0], 'roleId'));
		var authId 		 = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(userListXml[0], 'authId'));
		var language 	 = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(userListXml[0], 'language'));
		var email 		 = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(userListXml[0], 'email'));
		var deptId		 = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(userListXml[0], 'deptId'));
		var retirementYn = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(userListXml[0], 'retirementYn'));
		var extension = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(userListXml[0], 'extension'));
		var cellPhone = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(userListXml[0], 'cellPhone'));
		document.viewForm.modifyName.value = userName;
		document.viewForm.modifyPasswd.value  = password;
		document.viewForm.modifyPasswd1.value = password;
		document.viewForm.userInfoModifyDeptName.value = deptName;
		document.viewForm.modifyDeptId.value = deptId;
		document.viewForm.modifyUserEmpNo.value = empNo;
		document.viewForm.modifyPosition.value = position;
		document.viewForm.modifyEmail.value = email;
		document.viewForm.userId.value = userId;
		document.viewForm.modifyExtension.value = extension;
		document.viewForm.modifyCellPhone.value = cellPhone;
		
		document.viewForm.deptId.value = deptId;
		document.viewForm.deptName.value = deptName;
		document.getElementById("addDeptName").innerHTML = document.viewForm.deptName.value;
		
		document.getElementById("modifyUserId_Td").innerHTML   = '&nbsp;' + userId;
		
		var authSelect = document.getElementById("authId");
		var opts = authSelect.getElementsByTagName("option");
		for(var i=0; i<opts.length; i++) {
			var opt = opts[i];
			if(opt.getAttribute("value") == authId) {
				opt.setAttribute("selected", "selected");
				break;
			}
		}
		
		var roleIdSelect = document.getElementById("roleId");
		var roleOptions  = roleIdSelect.getElementsByTagName("option");
		for(var i=0; i < roleOptions.length ; i++){
			var opt = roleOptions[i];
			if(opt.getAttribute("value") == roleId) {
				opt.setAttribute("selected", "selected");
				break;
			}
		}
		
		var languageSelect = document.getElementById("language");
		var languageOptions  = languageSelect.getElementsByTagName("option");
		for(var i=0; i < languageOptions.length ; i++){
			var opt = languageOptions[i];
			if(opt.getAttribute("value") == language) {
				opt.setAttribute("selected", "selected");
				break;
			}
		}
		//jk
		var retirementYnRbt = document.getElementsByName('retirementYn');
		for(var ii=0;ii<retirementYnRbt.length;ii++){
			if(retirementYnRbt[ii].value == retirementYn){
				retirementYnRbt[ii].checked = true;
				break;
			}else if(retirementYn == null && retirementYnRbt[ii].value == 'N'){
				retirementYnRbt[ii].checked = true;
			}else if(retirementYnRbt[ii].value == 'N'){
				retirementYnRbt[ii].checked = true;
			}
		}
		
		var imgLanguage = imageLanguageType($F("userLanguage"));
		var deleteImage = "<img src='../images/"+ imgLanguage +"btn_del.gif' border='0' onclick='removeUser(\""+userId+"\");' style='cursor:pointer;'>";
		var saveImage   = "<img src='../images/"+ imgLanguage +"btn_save.gif' border='0' onclick='setUserModify();' style='cursor:pointer;'>";
		document.getElementById("modifyUserInfoButton_Td").innerHTML = saveImage + "&nbsp&nbsp" + deleteImage;
	}
}

/**
 * 아이디 체크
 * 사용자 입력시(추가할때 Id 체크 함수, 입력된 Text 가 Email)인지 확인한다. 
 * 중복된 아이디 인지, 아닌지 판별
 * @param type : 중복체크 종류 ( default : 기본 , modalDoalog : 모달창에서 새로 검색할 경우 ) 
 */
function getIdCheck(type) {
	var form = document.viewForm;
	if(type == "default"){
		if( form.addUserId.value == null || form.addUserId.value == "" ) {
			warnMessage('Youdidnotentertherequireditems', 'INPUT_YOURID');
			form.addUserId.focus();
			return;
		} else {
			if(emailCheckBoolean(document.viewForm.addUserId) == "true") {
				var params = "id=" + form.addUserId.value;
				popupIdCheckModalDialog(params);
			} else {
				warnMessage('', 'PleaseusetheemailID');
				form.addUserId.value = "";
				form.addUserId.focus();
				return;
			}
		}
	}else if(type == "modalDialog") {
		form.addUserId.value = "";
		if( document.checkForm.differentId.value == null || document.checkForm.differentId.value == "" ) {
			warnMessage('Youdidnotentertherequireditems', 'INPUT_YOURID');
			document.checkForm.differentId.focus();
			return false;
		} else {
			if(emailCheckBoolean(document.checkForm.differentId) == "true") {
				var param ="id=" + document.checkForm.differentId.value;
				releaseModalDialog(true);
				popupIdCheckModalDialog(param);
			} else {
				warnMessage('', 'PleaseusetheemailID');
				document.checkForm.differentId.value = "";
				document.checkForm.differentId.focus();
				return false;			
			}
		}
	}
}

/**
 * 사용자 추가시 아이디 중복확인 팝업 당이얼 로그를 열기 위한 이벤트
 * @param params
 * @return
 */
function popupIdCheckModalDialog(params){
	var linkurl = getPath() + "/config/idCheck.jsp";
	popupModalDialog(linkurl , params);
}

/**
 * 중복체크후 사용하고자 하는아이디를 부모 화면에 재입력 할때
 * @return
 */
function setUseId() {
	document.viewForm.checkYn.value = "Y";
	document.viewForm.addUserId.value = document.checkForm.id.value;
	document.viewForm.userId.value = document.checkForm.id.value;
	self.opener = self;
	releaseModalDialog(true);
}

/**
 * 사용자 신규 저장(구성원추가) 
 * 필수 항목 확인후, 내용 저장
 */ 
function setUserCreate() {
	var form = document.viewForm;
	var addUserId = form.addUserId.value;
	var deptId = form.deptId.value;
	var parentId = form.parentId.value;
	
	if( form.addUserName.value == null || form.addUserName.value == "" ) {
		warnMessage('Youdidnotentertherequireditems', 'INPUT_YOURNAME');
		form.addUserName.focus();
		return false;
	} else if( addUserId == null || addUserId == "" ) {
		warnMessage('', 'INPUT_YOURID');
		form.addUserId.focus();
		return false;
	} else if( emailCheckBoolean(document.viewForm.addUserId) == "false" ) {
		warnMessage('', 'PleaseusetheemailID');
		form.addUserId.value="";
		form.addUserId.focus();
		return false;
	} else if( form.checkYn.value == null || form.checkYn.value == "" ) {
		warnMessage('', 'NowcheckIDduplication');
		return false;
	} else if( form.addUserPasswd.value == null || form.addUserPasswd.value == "" ) {
		warnMessage('Youdidnotentertherequireditems', 'PleaseEnterYourPassword');
		form.addUserPasswd.focus();
		return false;
	} else if( form.addUserPasswd1.value == null || form.addUserPasswd1.value == "" ) {
		warnMessage('', 'PleaseEnterYourPasswordAgain');
		form.addUserPasswd1.focus();
		return false;
	} else if( form.addUserPasswd.value != form.addUserPasswd1.value ) {
		warnMessage('', 'PleaseCheckYourPassword2');
		form.addUserPasswd.value = "";
		form.addUserPasswd1.value = "";
		form.addUserPasswd.focus();
		return false;
	} else {
		if(emailCheck(document.viewForm.addUserId) == "true") {
			var params = new Array();
			params.push("deptId="     +form.deptId.value);
			params.push("id="    +addUserId);
			params.push("name="      +form.addUserName.value);
			params.push("passwd="    +form.addUserPasswd.value);
			params.push("authId="    +form.addUserAuthId.value);
			params.push("empNo="  	 +form.addUserEmpNo.value);
			params.push("position="  +form.addUserPosition.value);
			params.push("email="     +form.addUserId.value);
			params.push("language="  +form.addUserLanguage.value);
			params.push("roleId="    +form.addUserRoleId.value);
			params.push("companyId=" +compId);
			params.push("parentId="  +form.parentId.value);
			params.push("deptName="  +form.deptName.value);
			params.push("method=setUserInfoSave");
			params.push("saveYn=C");
			params.push("userId=" + userId);
			params.push("compId="+compId);
			params.push("extension="  +form.extension.value);
			params.push("cellPhone="  +form.cellPhone.value);
			params = params.join("&");	
			var linkUrl = getPath() + "/services/portal/configService.jsp";
			request(linkUrl , params , orgUserCreateCallback , null , "notifySaveProgress", null , "failed" );
		} else {
			form.checkYn.value = "";
			return false;
		}
	}
}
function orgUserCreateCallback(){
	document.getElementById('deptTreeList').src = getPath() + '/config/orgDeptList.jsp?parentId=' + document.viewForm.parentId.value;
	//document.getElementById('deptTreeList').src = getPath() + '/config/orgTreeList.jsp?parentId=' + document.viewForm.parentId.value;
}

/**
 * Name : 사용자 수정저장
 * Doc  : 조직관리 > 사용자 수정 저장
 *        사용자의 정보를 수정한뒤 저장.
 */ 
function setUserModify() {
	var form = document.viewForm;
	if( form.modifyName.value == null || form.modifyName.value == "" ) {
		warnMessage('Youdidnotentertherequireditems', 'INPUT_YOURNAME');
		form.modifyName.focus();
		return false;
	} else if( form.modifyPasswd.value == null || form.modifyPasswd.value == "" ) {
		warnMessage('Youdidnotentertherequireditems', 'PleaseEnterYourPassword');
		form.modifyPasswd.focus();
		return false;
	} else if( form.modifyPasswd1.value == null || form.modifyPasswd1.value == "" ) {
		warnMessage('', 'PleaseEnterYourPasswordAgain');
		form.modifyPasswd1.focus();
		return false;
	} else if( form.modifyPasswd.value != form.modifyPasswd1.value ) {
		warnMessage('', 'PleaseCheckYourPassword2');
		form.modifyPasswd.value = "";
		form.modifyPasswd1.value = "";
		form.modifyPasswd.focus();
		return false;
	} else {
		if(emailCheckBoolean(document.viewForm.modifyEmail) == "true") {
			
			var radio = document.getElementsByName('retirementYn');
			var retirement = "";
			for(var ii=0;ii<radio.length;ii++){
				if(radio[ii].checked)
					retirement = radio[ii].value; 
			}
			
			var params = new Array();
			params.push("id="        + form.userId.value);
			params.push("deptId="    + form.modifyDeptId.value);
			params.push("name="      + form.modifyName.value);
			params.push("passwd="  	 + form.modifyPasswd.value);
			params.push("companyId=" + compId);
			params.push("empNo="  + form.modifyUserEmpNo.value);
			params.push("position="  + form.modifyPosition.value);
			params.push("email="     + form.modifyEmail.value);
			params.push("authId="    + form.authId.value);
			params.push("language="  + form.language.value);
			params.push("roleId="    + form.roleId.value);
			params.push("parentId="  + form.parentId.value);
			params.push("deptName="  + form.userInfoModifyDeptName.value);
			params.push("retirementYn="  + retirement);
			params.push("method=setUserInfoSave");
			params.push("saveYn=U");
			params.push("userId=" + userId);
			params.push("compId="+compId);
			params.push("extension="  +form.modifyExtension.value);
			params.push("cellPhone="  +form.modifyCellPhone.value);
 			params = params.join("&");
			var linkUrl = getPath() + "/services/portal/configService.jsp";
			request(linkUrl , params , setUserModifyCallback , null , "notifySaveProgress", null , "failed" );
		}
	}
}
function setUserModifyCallback(){
	document.getElementById('deptTreeList').src = getPath() + '/config/orgDeptList.jsp?parentId=' + document.viewForm.parentId.value;
	//document.getElementById('deptTreeList').src = getPath() + '/config/orgTreeList.jsp?parentId=' + document.viewForm.parentId.value;
}

/**
 * 조직관리 사용자 삭제 , 부서에 속한 사용자 삭제
 * @param id
 * @return
 */
function removeUser(id) {
	var linkUrl = getPath() + "/services/portal/configService.jsp";;
	var params = new Array();
	params.push("method=setUserInfoSave");
	params.push("id=" + id);
	params.push("saveYn=D");
	params.push("userId=" + userId);
	params.push("compId="+compId);
	params = params.join("&");
	
	request( linkUrl , params, removeUserCallback, "confirmDelete" , "notifyDeleteProgress", null, "warnDeleteFailed");
}
function removeUserCallback() {
	document.getElementById('deptTreeList').src = getPath() + '/config/orgDeptList.jsp?parentId=' + document.viewForm.parentId.value;
	//document.getElementById('deptTreeList').src = getPath() + '/config/orgTreeList.jsp?parentId=' + document.viewForm.parentId.value;
	document.getElementById("addButtonTb").style.display  = "none";
	document.getElementById("deptInfoTb").style.display  = "none";
	document.getElementById("userInfoTb").style.display = "none";
	document.getElementById("userInfoModifyTb").style.display = "none";
}

/**
 * 조직관리 부서 삭제
 * 부서정보를 모두 삭제함, 소속된 부서원이 있을경우 삭제 되지 않음, 부서 삭제 후 화면 Refresh
 * 
 * @param userYn         : 부서원이 있는지 없는지 체크 (Y : 부서원 있음 , N : 부서원 없음 )
 * @param warningMessage : (areadyUser: , areadyDept:)
 * @return
 */
function removeDept(userYn , warningMessage) {
	var form = document.viewForm;
	if(userYn == 'noValue') {
		var params = new Array();
		params.push("deptId="+form.deptId.value);
		params.push("saveStyle=delete");
		params.push("method=deptInfoCMD");
		params.push("userId=" + userId);
		params.push("compId="+compId);
		params = params.join("&");
		
		var linkUrl = getPath() + "/services/portal/configService.jsp";
		request(linkUrl , params , removeDeptCallback , 'confirmDelete' , 'notifyDeleteProgress' , null , 'failed' );
	} else {
		warnMessage('', 'departmentemployeesareon');
	}
}
function removeDeptCallback(){
	document.getElementById('deptTreeList').src = getPath() + '/config/orgDeptList.jsp?parentId=' + document.viewForm.parentId.value;
	//document.getElementById('deptTreeList').src = getPath() + '/config/orgTreeList.jsp?parentId=' + document.viewForm.parentId.value;
	document.getElementById("addButtonTb").style.display  = "none";
	document.getElementById("deptInfoTb").style.display  = "none";
	document.getElementById("userInfoTb").style.display = "none";
	document.getElementById("userInfoModifyTb").style.display = "none";
}

/**
 * 조직관리, 부서이름 수정 후 저장
 * @return 
 */
function setDeptModify() {
	var form = document.viewForm;
	var params = new Array();
	if(form.deptName.value == null || form.deptName.value == "") {
		warnMessage('Youdidnotentertherequireditems', 'EnterDepartment');
		form.deptName.focus();
	} else {
		params.push("companyId="+form.companyId.value);
		params.push("type=BASIC");
		params.push("deptName="+encodeURIComponent(form.deptName.value));
		params.push("parentId="+form.parentId.value);
		params.push("deptId="+form.deptId.value);
		params.push("saveStyle=deptModify");
		params.push("method=deptInfoCMD");
		params.push("userId=" + userId);
		params.push("compId="+compId);
		params = params.join("&");
		
		var linkUrl = getPath() + "/services/portal/configService.jsp";
		request( linkUrl , params , setDeptModifyCallback , null , "loading" , null, "failed" );
	}
}
function setDeptModifyCallback(){
	document.getElementById('deptTreeList').src = getPath() + '/config/orgDeptList.jsp?parentId=' + document.viewForm.parentId.value;
	//document.getElementById('deptTreeList').src = getPath() + '/config/orgTreeList.jsp?parentId=' + document.viewForm.parentId.value;
}

/**
 * 업무설정관리 컨텐츠 선택 
 * 
 * @param controlTdId
 * @param beforeControlTdId
 * @param linkUrl
 * @param title
 * @param tdId
 * @return
 */
function authContentWork(controlTdId, beforeControlTdId, linkUrl , title, tdId){
	if(document.myTaskContentForm.objId.value == ""){
		warnMessage('','errorCodeNotSelected');      //업무를 먼저 선택하셔야 합니다.;
	}else{
		var	objId =	document.myTaskContentForm.objId.value;
		var	objName	= document.getElementById(objId).firstChild.nodeValue;
		var	params = "&objId="+objId+"&objName="+objName+"&title="+title;
		$(controlTdId).hide();
		$(beforeControlTdId).show();
		send(linkUrl, tdId,	params);
	}
}

function authContentWorkClose(controlTdId, beforeControlTdId, contentTdId){
	$(controlTdId).hide();
	$(beforeControlTdId).show();
	document.getElementById(contentTdId).innerHTML = '';
}

function changeSub(linkUrl)	{
	var	pkgId =	document.myTaskContentForm.myTaskPkgSelect.value;
	var	params = "categoryId="+pkgId;
	send(linkUrl, "myTaskSubProcess",  params);
}

function changeSubView(linkUrl)	{
	var	formId = document.myTaskContentForm.myTaskFormSelect.value;
	var	formName = document.getElementById(formId).firstChild.nodeValue;
	var	params = "formId="+formId+"&formName="+formName;
	if(formId != ""	&& formId != null) {
		send(linkUrl, "formItemModifyTd",  params);
		send("../config/taskMetaInfo.jsp", "metaInfoTd",  params);
	}
}

function changeTaskSubView(linkUrl)	{
	var	formId = document.myTaskContentForm.myTaskFormSelect.value;
	var	formName = document.getElementById(formId).firstChild.nodeValue;
	var	params = "formId="+formId+"&formName="+formName;
	if(formId != ""	&& formId != null) {
		send(linkUrl, "taskModifyTd",  params);
	}
}


/**
 * 업무설정관리 보이는 항목, 보이지 않는 항목 클릭 이벤트
 * 
 * @param obj
 * @param formId
 * @param itemCd
 * @param id
 * @param fieldId
 * @param fieldName
 * @param tableWidth :
 * @param viewYn
 * @param fieldCnt   : itemOrder
 * @return
 */
function itemListClick(obj , formId	, itemCd , id ,	fieldId, fieldName,	tableWidth , viewYn	, fieldCnt)	{

	var	objId =	obj.id;
	if (prevMenu !=	null &&	prevMenu !=	obj) {
		prevMenu.style.fontWeight  = "";
	}
	prevMenu = obj;
	prevMenu.style.fontWeight  = "bold";
	var	form = document.taskModifyForm;
	form.formId.value 		= formId;
	form.itemCd.value 		= itemCd;
	form.id.value 			= id;
	form.fieldId.value 		= fieldId;
	this.fieldName = fieldName.replaceAll("`", "'");
	form.fieldName.value 	= this.fieldName;
	form.tableWidth.value 	= tableWidth;
	form.viewYn.value 		= viewYn;
	form.fieldCnt.value		= fieldCnt;
}


/*jk yoon 업무설정관리*/
function checkSave(save){
	var fCheck = document.taskModifyForm.formCheck;
	//alert(fCheck);
	
	document.taskModifyForm.checkSaveType.value = save;
	var str = "";
	if(fCheck.length == undefined){
		str = fCheck.value;
	}else{
		var j = 0;
		for(var i=0; i < fCheck.length;i++){
			if(fCheck[i].checked == true){
				if(j!=0) str += ",";
				str += fCheck[i].value;
				j++;
			}
		}
	}
	document.taskModifyForm.checkSave.value = str;
	//alert(document.taskModifyForm.checkSave.value);
}
	

 
/**
 * 정보관리 업무설정 : 보이는 항목과 보이지 않는 항목
 * @param linkUrl : pageUrl
 * @param itemCd  : 상위로, 혹은 하위로 / 보이게, 안보이게
 * @return
 */
function taskItemMove(linkUrl,itemCd) {
	var	param =	"";
	var	form = document.taskModifyForm;
	//alert(form.formCheck);
	
	//jk yoon 
	var fCheck = form.formCheck;
	
	//alert(fCheck);
	//document.taskModifyForm.checkSaveType.value = itemCd;
	var str = "";
	if(fCheck != undefined){
		if(fCheck.length == undefined){
			str = fCheck.value;
		}else{
			var j = 0;
			for(var i=0; i < fCheck.length;i++){
				if(fCheck[i].checked == true){
					if(j!=0) str += ";";
					str += fCheck[i].value;
					j++;
				}
			}
		}
	}
	//alert(str);
	if(form.viewYn.value ==""){
		if(str!="") form.viewYn.value = 'Y';
		else form.viewYn.value = 'N';
	}
	var objId = form.formId.value;
	var id = form.id.value;
	var fieldId = form.fieldId.value;
	var fieldName = form.fieldName.value;
	var tableWidth = form.tableWidth.value;
	var fieldCnt = form.fieldCnt.value;
	
	var params = new Array();
	params.push("objId="+form.formId.value);
	params.push("itemCd="+itemCd);
	params.push("id="+id);
	params.push("fieldId="+fieldId);
	params.push("fieldName="+fieldName);
	params.push("tableWidth="+tableWidth);
	params.push("fieldCnt="+fieldCnt);
	params.push("param="+str);
	params = params.join("&");
	
	//alert($F('titleFieldId') +"///"+ fieldId);
	if(form.viewYn.value ==	'N'	&& itemCd == 'plusItem') {
		if(form.id.value !=	"" && form.id.value	!= null) {
			send(linkUrl, "authContent_taskFormModify_td",	params);
		}
		itemListClick( document.getElementById(fieldId) , objId , 'minusItem' , id , fieldId, fieldName, tableWidth , 'Y' , fieldCnt);
	} else if(form.viewYn.value	== 'Y' && itemCd ==	'minusItem') {
		//alert(form.id.value+"////");
		if($F('titleFieldId') == fieldId){
			warnMessage('Warning', 'Keyentrydoesnotgototheinvisibleitem'); //키 항목은 안보이는 항목으로 이동이 불가 합니다.
			//alert('키 항목은 안보이는 항목으로 이동이 불가 합니다.');
			return false;
		}
		if(form.id.value !=	"" && form.id.value	!= null) {
			//if(str!=""){
				send(linkUrl, "authContent_taskFormModify_td",	params);
			//}
		}
			
		//itemListClick( document.getElementById(fieldId) , objId , 'plusItem' , id , fieldId, fieldName, tableWidth , 'N' , fieldCnt);
	} else if(form.viewYn.value	== 'Y' && itemCd ==	'upItem') {
		if(form.id.value !=	"" && form.id.value	!= null) {
			send(linkUrl, "authContent_taskFormModify_td",	params);
		}
		itemListClick( document.getElementById(fieldId) , objId , 'plusItem' , id , fieldId, fieldName, tableWidth , 'Y' , fieldCnt);
	} else if(form.viewYn.value	== 'Y' && itemCd ==	'downItem')	{
		if(form.id.value !=	"" && form.id.value	!= null) {
			send(linkUrl, "authContent_taskFormModify_td",	params);
		}
		itemListClick( document.getElementById(fieldId) , objId , 'plusItem' , id , fieldId, fieldName, tableWidth , 'Y' , fieldCnt);
	}
}

function taskFormKeySave(linkUrl,formId) {
	var	param =	"";
	var	form = document.taskModifyForm;
	params = "objId="+formId;
	params = params	+ "&itemCd=keyField";
	//params = params	+ "&titleFieldId="+form.titleFieldId.value;
	var radio = form.formCheck;
	var checkKey="";
	if(radio.length != undefined){
		for(var i = 0; i < radio.length; i++){
			if(radio[i].checked == true){
				checkKey = radio[i].value;
				break;
			}
		}
	}else{
		checkKey = radio.value;
	}
	//alert(checkKey+"//"+linkUrl+"//"+formId);
	params = params	+ "&titleFieldId="+checkKey;
	params = params	+ "&formName="+form.formName.value;
	if(checkKey != "" && checkKey != null) {
		send(linkUrl, "authContent_taskFormModify_td",  params);
	}
}

function popUp(){
	var width = "320";
	var height= "80";
	var LeftPosition = (screen.width) ? (screen.width-width)/2 : 0;
	var TopPosition = (screen.height) ? (screen.height-height)/2 : 0;
	window.open('logoPopup.jsp', 'companyLogoImage', 'width='+width+', height='+height+',left='+LeftPosition+',top='+TopPosition+', scrollbars=no, menubar=no, toolbar=no, status=no');
}

function refreshPic(fileName) {
	document.getElementById("logoImage").innerHTML = "<img src='../systemImages/logo/"+fileName+"?dummyData="+new Date().getTime()+"' width='153' height='21' border='0' onClick='popUp()' style='cursor:pointer;'>";
	document.getElementById("topLogoImage").innerHTML = "<img src='../systemImages/logo/"+fileName+"?dummyData="+new Date().getTime()+"' width='153' height='21' border='0'>";
}

/**
 * 로고 저장, 화면 좌측 상단의 로고를 변경,
 * <gif> <jpg> <png> <jpeg> 형식이 아닐경우 Error 
 */
function logoSave() {
	var form = document.compInfoForm//document.companyEditForm;
	var companyLogo = form.companyLogo.value;
	var extension = companyLogo.substring( companyLogo.lastIndexOf(".")+1, companyLogo.length ).toLowerCase();
	if(extension == "gif" || extension == "jpg" || extension == "jpeg" || extension == "png") {
		form.action = "logoPopup.jsp";
		form.target = "ajaxFrame";
		form.submit();
	} else {
		warnMessage('', 'fileformatsaresupported');
		//form.picture.value = "";
	}
}

var setMailingInfoIsTest;
function setMailingInfo(host, username, password, taskMailMode, isTest) {
	if (isNull(host))
		host = document.compInfoForm.host.value;
	if (isNull(username))
		username = document.compInfoForm.username.value;
	if (isNull(password))
		password = document.compInfoForm.password.value;
	if (isNull(taskMailMode))
		taskMailMode = document.compInfoForm.taskMailMode.checked;
	if (isNull(isTest))
		isTest = document.compInfoForm.isTest.checked;
	
	if (!toBoolean(taskMailMode))
		taskMailMode = "none";
	setMailingInfoIsTest = isTest
	
	var params = "method=setMailingInfo";
	params += "&host=" + host;
	params += "&username=" + username;
	params += "&password=" + password;
	params += "&taskMailMode=" + taskMailMode;
	request(null, params, setMailingInfoCallback, "confirmSave", "notifySaveProgress", null, "warnSaveFailed");
}
function setMailingInfoCallback() {
	if (!toBoolean(setMailingInfoIsTest))
		return;
	
	var email = userId;
	//try {
	//	var user = getUser(getUserId());
	//	if (user != null)
	//		email = user["email"];
	//} catch (e) {
	//}
	popupSendMailModalDialog("[SmartWorks] Mailing Test", email, email, null, "Mailing setting has been changed.");
}

//compInfo List
function compInfoListHour() {
	update("../config/workHourList.jsp", "workHourList", null, compInfoListCalendar, "loading", "failed");
}
function compInfoListCalendar() {
	update("../config/workCalendarList.jsp", "workCalendarList", null, compInfoListApprovalLine, "loading", "failed");
}
function compInfoListApprovalLine() {
	update("../config/approvalLineList.jsp", "approvalLineList", null, null, "loading", "failed");
}

//Work-Hour Policy
function workHourWrite() {
	update("../config/workHourWrite.jsp", "mainView", null, changeWorkTime, "loading", "failed");
}
function workHourList() {
	menuClick(document.getElementById('compInfo'),'../config/compInfoContent.jsp');
	//update("../config/workHourList.jsp", "workHourList", null, null, "loading", "failed");
}
function setWorkHourSave() {
	var form = document.workHourViewForm;
	
	//var startDayOfWeekValue = "1";
	//for (var i = 0; i < form.startDayOfWeek.length; i++) {
	//	if (form.startDayOfWeek[i].checked) {
	//		startDayOfWeekValue = form.startDayOfWeek[i].value;
	//	}
	//}
	
	var params = new Array();
	params.push("method=workHourSave");
	params.push("startDayOfWeek="+form.startDayOfWeek.value);
	params.push("validFromDate="+form.validFromDate.value);
	//params.push("validToDate="+form.validToDate.value);
	params.push("workingDays="+form.workingDays.value);
	params.push("startSunday=" + ($('workTimeTr01').style.display == '' ? form.startSunday.value : '00:00'));
	params.push("endSunday=" + ($('workTimeTr01').style.display == '' ? form.endSunday.value : '00:00'));
	params.push("startMonday=" + ($('workTimeTr02').style.display == '' ? form.startMonday.value : '00:00'));
	params.push("endMonday=" + ($('workTimeTr02').style.display == '' ? form.endMonday.value : '00:00'));
	params.push("startTuesday=" + ($('workTimeTr03').style.display == '' ? form.startTuesday.value : '00:00'));
	params.push("endTuesday=" + ($('workTimeTr03').style.display == '' ? form.endTuesday.value : '00:00'));
	params.push("startWednesday=" + ($('workTimeTr04').style.display == '' ? form.startWednesday.value : '00:00'));
	params.push("endWednesday=" + ($('workTimeTr04').style.display == '' ? form.endWednesday.value : '00:00'));
	params.push("startThursday=" + ($('workTimeTr05').style.display == '' ? form.startThursday.value : '00:00'));
	params.push("endThursday=" + ($('workTimeTr05').style.display == '' ? form.endThursday.value : '00:00'));
	params.push("startFriday=" + ($('workTimeTr06').style.display == '' ? form.startFriday.value : '00:00'));
	params.push("endFriday=" + ($('workTimeTr06').style.display == '' ? form.endFriday.value : '00:00'));
	params.push("startSaturday=" + ($('workTimeTr07').style.display == '' ? form.startSaturday.value : '00:00'));
	params.push("endSaturday=" + ($('workTimeTr07').style.display == '' ? form.endSaturday.value : '00:00'));
	params.push("userId="+userId);
	params.push("compId="+compId);
	params = params.join("&");

	linkUrl = getPath()+"/services/portal/configService.jsp";
	request(linkUrl, params, setWorkHourSaveCallback, null, "loading", null, "failed");	
}

function setWorkHourSaveCallback() {
	//goWorkHourPage(1);
	menuClick(document.getElementById('compInfo'),'../config/compInfoContent.jsp');
}

function goWorkHourPage(pageNo) {
	var params = "pageNo=" + pageNo;
	//update("../config/workHourList.jsp", "workHourList", params, null, "loading", "failed");
	menuClick(document.getElementById('compInfo'),'../config/compInfoContent.jsp');
	
}

function workHourDelete(objId,lang) {
	var del = "정말 삭제하시겠습니까?";
	if(lang == 'ENG'){
		del = "Do you want to delete?";
	}
	if (confirm(del)) {
		var params = new Array();
		params.push("method=workHourDelete");
		params.push("objId="+objId);
		params.push("userId="+userId);
		params.push("compId="+compId);
		params = params.join("&");
		linkUrl = getPath()+"/services/portal/configService.jsp";
		request(linkUrl, params, workHourDeleteCallback, null, "loading", null, "failed");
	}
}

function workHourDeleteCallback() {
	goWorkHourPage(document.workHourListForm.pageNo.value);
}

function workHourModify(objId) {
	var params = new Array();
	params.push("objId="+objId);
	params.push("pageNo="+document.workHourListForm.pageNo.value);
	params = params.join("&");
	update("../config/workHourModify.jsp", "mainView", params, changeWorkTime, "loading", "failed");
}

function setWorkHourModifySave() {
	var form = document.workHourViewForm;
	
	//var startDayOfWeekValue = "1";
	//for (var i = 0; i < form.startDayOfWeek.length; i++) {
	//	if (form.startDayOfWeek[i].checked) {
	//		startDayOfWeekValue = form.startDayOfWeek[i].value;
	//	}
	//}
	
	var params = new Array();
	params.push("method=workHourModifySave");
	params.push("startDayOfWeek="+form.startDayOfWeek.value);
	params.push("validFromDate="+form.validFromDate.value);
	//params.push("validToDate="+form.validToDate.value);
	params.push("workingDays="+form.workingDays.value);
	params.push("startSunday=" + ($('workTimeTr01').style.display == '' ? form.startSunday.value : '00:00'));
	params.push("endSunday=" + ($('workTimeTr01').style.display == '' ? form.endSunday.value : '00:00'));
	params.push("startMonday=" + ($('workTimeTr02').style.display == '' ? form.startMonday.value : '00:00'));
	params.push("endMonday=" + ($('workTimeTr02').style.display == '' ? form.endMonday.value : '00:00'));
	params.push("startTuesday=" + ($('workTimeTr03').style.display == '' ? form.startTuesday.value : '00:00'));
	params.push("endTuesday=" + ($('workTimeTr03').style.display == '' ? form.endTuesday.value : '00:00'));
	params.push("startWednesday=" + ($('workTimeTr04').style.display == '' ? form.startWednesday.value : '00:00'));
	params.push("endWednesday=" + ($('workTimeTr04').style.display == '' ? form.endWednesday.value : '00:00'));
	params.push("startThursday=" + ($('workTimeTr05').style.display == '' ? form.startThursday.value : '00:00'));
	params.push("endThursday=" + ($('workTimeTr05').style.display == '' ? form.endThursday.value : '00:00'));
	params.push("startFriday=" + ($('workTimeTr06').style.display == '' ? form.startFriday.value : '00:00'));
	params.push("endFriday=" + ($('workTimeTr06').style.display == '' ? form.endFriday.value : '00:00'));
	params.push("startSaturday=" + ($('workTimeTr07').style.display == '' ? form.startSaturday.value : '00:00'));
	params.push("endSaturday=" + ($('workTimeTr07').style.display == '' ? form.endSaturday.value : '00:00'));
	params.push("objId="+form.objId.value);
	params.push("userId="+userId);
	params.push("compId="+compId);
	params = params.join("&");

	linkUrl = getPath()+"/services/portal/configService.jsp";
	request(linkUrl, params, setWorkHourModifySaveCallback, null, "loading", null, "failed");	
}

function setWorkHourModifySaveCallback() {
	//goWorkHourPage(document.workHourViewForm.pageNo.value);
	menuClick(document.getElementById('compInfo'),'../config/compInfoContent.jsp');
}

function changeWorkTime() {
	var form = document.workHourViewForm;
	var startDayOfWeekValue = form.startDayOfWeek.value;
	var workingDaysValue = form.workingDays.value;
	
	//for IE
	var startSundaySelectedIndex = $('startSunday').selectedIndex;
	var endSundaySelectedIndex = $('endSunday').selectedIndex;
	var startMondaySelectedIndex = $('startMonday').selectedIndex;
	var endMondaySelectedIndex = $('endMonday').selectedIndex;
	var startTuesdaySelectedIndex = $('startTuesday').selectedIndex;
	var endTuesdaySelectedIndex = $('endTuesday').selectedIndex;
	var startWednesdaySelectedIndex = $('startWednesday').selectedIndex;
	var endWednesdaySelectedIndex = $('endWednesday').selectedIndex;
	var startThursdaySelectedIndex = $('startThursday').selectedIndex;
	var endThursdaySelectedIndex = $('endThursday').selectedIndex;
	var startFridaySelectedIndex = $('startFriday').selectedIndex;
	var endFridaySelectedIndex = $('endFriday').selectedIndex;
	var startSaturdaySelectedIndex = $('startSaturday').selectedIndex;
	var endSaturdaySelectedIndex = $('endSaturday').selectedIndex;
	
	var clone = [];
	for (var i = 1; i < 8; i++) {
		$('workTimeTr0' + i).style.display = '';
		clone.push({'parentNode' : $('workTimeTr0' + i).parentNode, 'cloneNode' : $('workTimeTr0' + i).cloneNode(true)});
		$('workTimeTr0' + i).parentNode.removeChild($('workTimeTr0' + i));
	}

	for (var i = startDayOfWeekValue-1; i < parseInt(startDayOfWeekValue) + 6; i++) {	
		var idx = (i % 7) + 1;
		if (i < parseInt(startDayOfWeekValue) + parseInt(workingDaysValue) - 1) {
			clone[idx-1].cloneNode.style.display = '';
		} else {
			clone[idx-1].cloneNode.style.display = 'none';
		}
		clone[idx-1].parentNode.appendChild(clone[idx-1].cloneNode);
	}
	
	//for IE
	$('startSunday').selectedIndex = startSundaySelectedIndex;
	$('endSunday').selectedIndex = endSundaySelectedIndex;
	$('startMonday').selectedIndex = startMondaySelectedIndex;
	$('endMonday').selectedIndex = endMondaySelectedIndex;
	$('startTuesday').selectedIndex = startTuesdaySelectedIndex;
	$('endTuesday').selectedIndex = endTuesdaySelectedIndex;
	$('startWednesday').selectedIndex = startWednesdaySelectedIndex;
	$('endWednesday').selectedIndex = endWednesdaySelectedIndex;
	$('startThursday').selectedIndex = startThursdaySelectedIndex;
	$('endThursday').selectedIndex = endThursdaySelectedIndex;
	$('startFriday').selectedIndex = startFridaySelectedIndex;
	$('endFriday').selectedIndex = endFridaySelectedIndex;
	$('startSaturday').selectedIndex = startSaturdaySelectedIndex;
	$('endSaturday').selectedIndex = endSaturdaySelectedIndex;
	
}


//Work-Calendar Policy
function workCalendarWrite() {
	var form = document.workCalendarListForm;
	var params = "psYear=" + form.psYear.value;
	update("../config/workCalendarWrite.jsp", "mainView", params, null, "loading", "failed");
}
function workCalendarList() {
//	var form = document.workCalendarListForm;
//	var params = "psYear=" + form.psYear.value;
//	update("../config/workCalendarList.jsp", "workCalendarList", params, null, "loading", "failed");
menuClick(document.getElementById('compInfo'),'../config/compInfoContent.jsp');
}
function searchWorkCalendarList() {
	var form = document.workCalendarListForm;
	var params = "psYear=" + form.psYear.value;
	update("../config/workCalendarList.jsp", "workCalendarList", params, null, "loading", "failed");
}

function setWorkCalendarSave() {
	var form = document.workCalendarViewForm;
	
	if (form.name.value == null || form.name.value == "") {
		warnMessage('Youdidnotentertherequireditems', 'INPUT_NAME');
		form.name.focus();
		return false;
	}
	
	var params = new Array();
	params.push("method=workCalendarSave");
	params.push("name="+form.name.value);
	params.push("type="+form.type.value);
	params.push("startDay="+form.startDay.value);
	params.push("endDay="+form.endDay.value);
	params.push("description="+form.description.value);
	params.push("referenceUser="+form.referenceUser.value);
	params.push("userId="+userId);
	params.push("compId="+compId);
	params = params.join("&");
	
	//params = {method: workCalendarSave}
	
	linkUrl = getPath()+"/services/portal/configService.jsp";
	request(linkUrl, params, setWorkCalendarSaveCallback, null, "loading", null, "failed");	
}

function setWorkCalendarSaveCallback() {
	//goWorkCalendarPage(1);
	menuClick(document.getElementById('compInfo'),'../config/compInfoContent.jsp');
}

function goWorkCalendarPage(pageNo) {
	//	var params = "pageNo=" + pageNo;
	//	var form = document.workCalendarListForm;
	//	params += "&psYear=" + form.psYear.value;
	//	update("../config/workCalendarList.jsp", "workCalendarList", params, null, "loading", "failed");
	menuClick(document.getElementById('compInfo'),'../config/compInfoContent.jsp');

}

function workCalendarDelete(objId,lang) {
	var del = "정말 삭제하시겠습니까?";
	if(lang == 'ENG'){
		del = "Do you want to delete?";
	}
	if (confirm(del)) {
		var params = new Array();
		params.push("method=workCalendarDelete");
		params.push("objId="+objId);
		params.push("userId="+userId);
		params.push("compId="+compId);
		params = params.join("&");
		linkUrl = getPath()+"/services/portal/configService.jsp";
		request(linkUrl, params, workCalendarDeleteCallback, null, "loading", null, "failed");
	}
}

function workCalendarDeleteCallback() {
	//goWorkCalendarPage(document.workCalendarListForm.pageNo.value);
	menuClick(document.getElementById('compInfo'),'../config/compInfoContent.jsp');
}

function workCalendarModify(objId) {
	var params = new Array();
	params.push("objId="+objId);
	params.push("pageNo="+document.workCalendarListForm.pageNo.value);
	params = params.join("&");
	update("../config/workCalendarModify.jsp", "mainView", params, null, "loading", "failed");
}

function setWorkCalendarModifySave() {
	var form = document.workCalendarViewForm;
	
	if (form.name.value == null || form.name.value == "") {
		warnMessage('Youdidnotentertherequireditems', 'INPUT_NAME');
		form.name.focus();
		return false;
	}
	
	var params = new Array();
	params.push("method=workCalendarModifySave");
	params.push("name="+form.name.value);
	params.push("type="+form.type.value);
	params.push("startDay="+form.startDay.value);
	params.push("endDay="+form.endDay.value);
	params.push("description="+form.description.value);
	params.push("objId="+form.objId.value);
	params.push("referenceUser="+form.referenceUser.value);
	params.push("userId="+userId);
	params.push("compId="+compId);
	params = params.join("&");
	linkUrl = getPath()+"/services/portal/configService.jsp";
	request(linkUrl, params, setWorkCalendarModifySaveCallback, null, "loading", null, "failed");	
}

function setWorkCalendarModifySaveCallback() {
	//goWorkCalendarPage(document.workCalendarViewForm.pageNo.value);
	menuClick(document.getElementById('compInfo'),'../config/compInfoContent.jsp');
}

function openUserPopup (userId) {
	var params = "viewUserId=" + userId;
	popupModalDialog(getPath() + '/form/personInfo.jsp', params);
}


//ProjectTeam Management
function projectTeamWrite() {
	update("../config/projectTeamWrite.jsp", "projectTeamWrite", null, null, "loading", "failed");
}
function projectTeamList() {
	update("../config/projectTeamList.jsp", "mainView", null, null, "loading", "failed");
}
function setProjectTeamSave() {
	var form = document.projectTeamViewForm;
	
	if (form.name.value == null || form.name.value == "") {
		warnMessage('Youdidnotentertherequireditems', 'INPUT_TEAMNAME');
		form.name.focus();
		return false;
	}
	
	if (form.teamLeader.value == null || form.teamLeader.value == "") {
		warnMessage('Youdidnotentertherequireditems', 'INPUT_TEAMLEADER');
		//form.teamLeader.focus();
		return false;
	}
	
	if (form.teamDept.value == null || form.teamDept.value == "") {
		warnMessage('Youdidnotentertherequireditems', 'INPUT_DEPARTMENT');
		//form.teamDept.focus();
		return false;
	}
	
	if (form.referenceUser.value == null || form.referenceUser.value == "") {
		warnMessage('Youdidnotentertherequireditems', 'INPUT_MEMBERS');
		//form.referenceUser.focus();
		return false;
	}
	
	var params = new Array();
	params.push("method=projectTeamSave");
	params.push("name="+form.name.value);
	params.push("teamLeader="+form.teamLeader.value);
	params.push("teamDept="+form.teamDept.value);
	params.push("teamDept="+form.teamDept.value);
	params.push("referenceUser="+form.referenceUser.value);	
	
	// jk yoon select 에서 radio 로 변경.
	//params.push("isPublic="+form.isPublic.value);
	//params.push("state="+form.state.value);
	var iP = form.isPublic;
	if(iP[0].checked==true) params.push("isPublic="+iP[0].value);
	else params.push("isPublic="+iP[1].value);
	
	var st = form.state;
	if(st[0].checked==true) params.push("state="+st[0].value);
	else params.push("state="+st[1].value);
	
	params.push("description="+form.description.value);
	params.push("userId="+userId);
	params.push("compId="+compId);
	params = params.join("&");
	
	linkUrl = getPath()+"/services/portal/configService.jsp";
	request(linkUrl, params, setProjectTeamSaveCallback, null, "loading", null, "failed");	
}
function setProjectTeamSaveCallback() {
	goProjectTeamPage(1);
}
function goProjectTeamPage(pageNo) {
	var params = "pageNo=" + pageNo;
	update("../config/projectTeamList.jsp", "mainView", params, null, "loading", "failed");
}
function projectTeamDelete(objId,lang) {
	var del = "정말 삭제하시겠습니까?";
	if(lang == 'ENG'){
		del = "Do you want to delete?";
	}
	if (confirm(del)) {
		var params = new Array();
		params.push("method=projectTeamDelete");
		params.push("objId="+objId);
		params.push("userId="+userId);
		params.push("compId="+compId);
		params = params.join("&");
		linkUrl = getPath()+"/services/portal/configService.jsp";
		request(linkUrl, params, projectTeamDeleteCallback, null, "loading", null, "failed");
	}
}

function projectTeamDeleteCallback() {
	goProjectTeamPage(document.projectTeamListForm.pageNo.value);
}
function projectTeamModify(objId) {
	var params = new Array();
	params.push("objId="+objId);
	params.push("pageNo="+document.projectTeamListForm.pageNo.value);
	params = params.join("&");
	update("../config/projectTeamModify.jsp", "projectTeamWrite", params, null, "loading", "failed");
}
function setProjectTeamModifySave() {

	var form = document.projectTeamViewForm;

	if (form.name.value == null || form.name.value == "") {
		warnMessage('Youdidnotentertherequireditems', 'INPUT_TEAMNAME');
		form.name.focus();
		return false;
	}
	
	if (form.teamLeader.value == null || form.teamLeader.value == "") {
		warnMessage('Youdidnotentertherequireditems', 'INPUT_TEAMLEADER');
		//form.teamLeader.focus();
		return false;
	}
	
	if (form.teamDept.value == null || form.teamDept.value == "") {
		warnMessage('Youdidnotentertherequireditems', 'INPUT_DEPARTMENT');
		//form.teamDept.focus();
		return false;
	}
	
	if (form.referenceUser.value == null || form.referenceUser.value == "") {
		warnMessage('Youdidnotentertherequireditems', 'INPUT_MEMBERS');
		//form.referenceUser.focus();
		return false;
	}
	
	var params = new Array();
	params.push("method=projectTeamModifySave");
	params.push("name="+form.name.value);
	params.push("teamLeader="+form.teamLeader.value);
	params.push("teamDept="+form.teamDept.value);
	params.push("teamDept="+form.teamDept.value);
	params.push("referenceUser="+form.referenceUser.value);	
	
	// jk yoon select 에서 radio 로 변경.
	//params.push("isPublic="+form.isPublic.value);
	//params.push("state="+form.state.value);
	
	var iP = form.isPublic;
	if(iP[0].checked==true) params.push("isPublic="+iP[0].value);
	else params.push("isPublic="+iP[1].value);
	
	var st = form.state;
	if(st[0].checked==true) params.push("state="+st[0].value);
	else params.push("state="+st[1].value);
	
	
	params.push("description="+form.description.value);
	params.push("objId="+form.objId.value);
	params.push("userId="+userId);
	params.push("compId="+compId);

	params = params.join("&");
	linkUrl = getPath()+"/services/portal/configService.jsp";
	request(linkUrl, params, setProjectTeamModifySaveCallback, null, "loading", null, "failed");	
}
function setProjectTeamModifySaveCallback() {
	goProjectTeamPage(document.projectTeamViewForm.pageNo.value);
}


//Approval Line Management
function approvalLineWrite() {
	update("../config/approvalLineWrite.jsp", "mainView", null, changeApprovalLine, "loading", "failed");
	

}
function approvalLineList() {
	//update("../config/approvalLineList.jsp", "approvalLineList", null, null, "loading", "failed");
	//menuClick(document.getElementById('compInfo'),'../config/compInfoContent.jsp');
	menuClick(document.getElementById('approvalLine'),'../config/approvalLineList.jsp');
}
function setApprovalLineSave() {
	var form = document.approvalLineViewForm;
	
	if (form.approvalLineName.value == null || form.approvalLineName.value == "") {
		warnMessage('Youdidnotentertherequireditems', 'EntertheApprovalLineName');
		form.approvalLineName.focus();
		return false;
	}
	
	var params = new Array();
	params.push("method=approvalLineDefSave");
	params.push("approvalLineName="+form.approvalLineName.value);
	params.push("level="+form.level.value);
	params.push("description="+form.description.value);
	params.push("name01="+form.name01.value);
	params.push("type01="+form.type01.value);
	params.push("fix01="+form.fix01.value);
	params.push("name02="+form.name02.value);
	params.push("type02="+form.type02.value);
	params.push("fix02="+form.fix02.value);
	params.push("name03="+form.name03.value);
	params.push("type03="+form.type03.value);
	params.push("fix03="+form.fix03.value);
	params.push("name04="+form.name04.value);
	params.push("type04="+form.type04.value);
	params.push("fix04="+form.fix04.value);
	params.push("name05="+form.name05.value);
	params.push("type05="+form.type05.value);
	params.push("fix05="+form.fix05.value);
	params.push("userId="+userId);
	params.push("compId="+compId);
	// jk yoon 추가
	params.push("day01="+form.day01.value);
	params.push("time01="+form.time01.value);
	params.push("minute01="+form.minute01.value);
	params.push("day02="+form.day02.value);
	params.push("time02="+form.time02.value);
	params.push("minute02="+form.minute02.value);
	params.push("day03="+form.day03.value);
	params.push("time03="+form.time03.value);
	params.push("minute03="+form.minute03.value);
	params.push("day04="+form.day04.value);
	params.push("time04="+form.time04.value);
	params.push("minute04="+form.minute04.value);
	params.push("day05="+form.day05.value);
	params.push("time05="+form.time05.value);
	params.push("minute05="+form.minute05.value);
	
	
	params = params.join("&");

	linkUrl = getPath()+"/services/portal/configService.jsp";
	request(linkUrl, params, setApprovalLineSaveCallback, null, "loading", null, "failed");	
}
function setApprovalLineSaveCallback() {
	var obj;
	if($('compInfo')){
		obj = document.getElementById('compInfo');
	}else{
		var el = document.createElement("span");
			//el.setAttribute("id", "compInfo");
			el.setAttribute("id", "approvalLine");
		obj = el;
	}
	//menuClick(obj,'../config/compInfoContent.jsp');
	menuClick(obj,'../config/approvalLineList.jsp');
}
function goApprovalLinePage(pageNo) {
	//var params = "pageNo=" + pageNo;
	//update("../config/approvalLineList.jsp", "approvalLineList", params, null, "loading", "failed");
	//menuClick(document.getElementById('compInfo'),'../config/compInfoContent.jsp');
	menuClick(document.getElementById('approvalLine'),'../config/approvalLineList.jsp');
}
function approvalLineDelete(objId,lang) {
	var del = "정말 삭제하시겠습니까?";
	if(lang == 'ENG'){
		del = "Do you want to delete?";
	}
	if (confirm(del)) {
		var params = new Array();
		params.push("method=approvalLineDefDelete");
		params.push("objId="+objId);
		params.push("userId="+userId);
		params.push("compId="+compId);
		params = params.join("&");
		linkUrl = getPath()+"/services/portal/configService.jsp";
		request(linkUrl, params, approvalLineDeleteCallback, null, "loading", null, "failed");
	}
}
function approvalLineDeleteCallback() {
	//goApprovalLinePage(document.approvalLineListForm.pageNo.value);
	//menuClick(document.getElementById('compInfo'),'../config/compInfoContent.jsp');
	menuClick(document.getElementById('approvalLine'),'../config/approvalLineList.jsp');
}
function approvalLineModify(objId) {
	var params = new Array();
	params.push("objId="+objId);
	params.push("pageNo="+document.approvalLineListForm.pageNo.value);
	params = params.join("&");
	update("../config/approvalLineModify.jsp", "mainView", params, changeApprovalLine, "loading", "failed", false);
}
function setApprovalLineModifySave() {
	var form = document.approvalLineViewForm;
	
	if (form.approvalLineName.value == null || form.approvalLineName.value == "") {
		warnMessage('Youdidnotentertherequireditems', 'EntertheApprovalLineName');
		form.approvalLineName.focus();
		return false;
	}
	
	var params = new Array();
	params.push("method=approvalLineDefModifySave");
	params.push("approvalLineName="+form.approvalLineName.value);
	params.push("level="+form.level.value);
	params.push("description="+form.description.value);
	params.push("name01="+form.name01.value);
	params.push("type01="+form.type01.value);
	params.push("fix01="+form.fix01.value);
	params.push("name02="+form.name02.value);
	params.push("type02="+form.type02.value);
	params.push("fix02="+form.fix02.value);
	params.push("name03="+form.name03.value);
	params.push("type03="+form.type03.value);
	params.push("fix03="+form.fix03.value);
	params.push("name04="+form.name04.value);
	params.push("type04="+form.type04.value);
	params.push("fix04="+form.fix04.value);
	params.push("name05="+form.name05.value);
	params.push("type05="+form.type05.value);
	params.push("fix05="+form.fix05.value);
	params.push("userId="+userId);
	params.push("compId="+compId);
	params.push("objId="+form.objId.value);
	params = params.join("&");
		
	linkUrl = getPath()+"/services/portal/configService.jsp";
	request(linkUrl, params, setApprovalLineModifySaveCallback, null, "loading", null, "failed");	
}
function setApprovalLineModifySaveCallback() {
	//goApprovalLinePage(document.approvalLineViewForm.pageNo.value);
	//menuClick(document.getElementById('compInfo'),'../config/compInfoContent.jsp');
	menuClick(document.getElementById('approvalLine'),'../config/approvalLineList.jsp');
}
function changeApprovalLine() {
	var form = document.approvalLineViewForm;
	var level = form.level.value;
	var width = 100/level;	//for FF
	for (var i = 1; i <= 5; i++) {
		$('view0' + i).style.display = 'none';
		$('app0' + i).style.display = 'none';
		$('time_0' + i).style.display = 'none';
	}
	for (var i = 1; i <= level; i++) {
		$('view0' + i).style.display = '';
		$('app0' + i).style.display = '';
		$('time_0' + i).style.display = '';		
		$('view0' + i).style.width = width + '%';
	}
}

function keyupLevelName(event) {
	var ev = window.event || event;
	var upElement = ev.target || ev.srcElement;
	var idx = upElement.id.slice(-1);
	//$('viewName0' + idx).innerHTML = upElement.value;
}

function changeLevelType(event) {
	var ev = window.event || event;
	var changeElement = ev.target || ev.srcElement;
	var idx = changeElement.id.slice(-1);
	
	var strChange = '';
	if (changeElement.value === '1') {
		strChange = '기안시 지정';
		$('fixHidden0' + idx).style.display = 'none';
	} else if (changeElement.value === '2') {
		strChange = '기안자 부서장';
		$('fixHidden0' + idx).style.display = 'none';
	} else if (changeElement.value === '3') {	
		strChange = '결재자 직접지정';
		$('fixHidden0' + idx).style.display = 'inline';
	} 
	
	//$('viewType0' + idx).innerHTML = '[' + strChange + ']';
}


function fixChangeLevelType(event) {
	var ev = window.event || event;
	var changeElement = ev.target || ev.srcElement;
	var idx = changeElement.id.slice(-1);
	
	$('viewType0' + idx).innerHTML = '[' + changeElement.value + ']';
}


function toggleConfigMenuTree() {
	if ($('configMenuTree').style.display === 'none') {
		$('configMenuTreeList').contentWindow.location.href="../common/workTreeList.jsp";
		$('configMenuTree').style.display = 'block';
	} else {
		$('configMenuTree').style.display = 'none';
	}
}

function approvalLineAdd(){
	
}

//나의 정보관리 관련 함수들.
function refreshImgPic(fileName){
	parent.document.getElementById("picture").src = "../systemImages/userPicture/"+fileName+"?dummyData="+new Date().getTime();
}

// 내정보관리 저장
function setMyInfo() {
	if (!validateSetMyInfo())
		return;
	var name = document.myInfoForm.name.value;
	var empNo = document.myInfoForm.empNo.value;
	var password = document.myInfoForm.password.value;
	var language = document.myInfoForm.language.value;
	var mail = document.myInfoForm.mail.value;
	var extension = document.myInfoForm.extension.value;
	var cellPhone = document.myInfoForm.cellPhone.value;

	var params = new Array();
	params.push("method=setMyInfo");
	params.push("name=" + name);
	params.push("empNo=" + empNo);
	params.push("password=" + password);
	params.push("language=" + language);
	params.push("mail=" + mail);
	params.push("extension=" + extension);
	params.push("cellPhone=" + cellPhone);
	params = params.join("&");
	request(null, params, setMyInfoCallback, null, "notifySaveProgress", null, "warnSaveFailed");
}
function validateSetMyInfo() {
	var name = document.myInfoForm.name.value;
	var password = document.myInfoForm.password.value;
	var password2 = document.myInfoForm.password2.value;
	var mail = document.myInfoForm.mail.value;

	var message;
	var detail;
	if (isNull(name)) {
		message = "errorCodeNullName";
		detail = "checkName";
	} else if (isNull(password)) {
		message = "errorCodeNullPassword";
		detail = "checkPassword";
	} else if (isNull(password2)) {
		message = "errorCodeNullPassword";
		detail = "checkPassword";
	} else if (password != password2) {
		message = "errorCodeWrongPassword";
		detail = "checkPassword";
	} else if (isNull(mail)) {
		message = "errorCodeNullMail";
		detail = "checkMail";
	}
	
	if (isNull(message) && isNull(detail))
		return true;
	
	warnMessage(message, detail);
	return false;
}
function setMyInfoCallback() {
	location.reload();
}

function setPicCookie(userLanguage) {
	var todayDate = new Date();
	todayDate.setDate(todayDate.getDate() + 365);
	document.cookie = "smartWorksLanguage=on; expires=" + todayDate.toGMTString()+ "; path=/" ;
	document.cookie = "smartWorksLanguageName="+ userLanguage +";  expires=" + todayDate.toGMTString()+ "; path=/" ;
}

function imgSave() {
	var form = document.myInfoForm;
	var picture = form.picture.value;
	var extension = picture.substring( picture.lastIndexOf(".")+1, picture.length ).toLowerCase();
	if(extension == "gif" || extension == "jpg" || extension == "jpeg" || extension == "png") {
		//request('picturePopup.jsp',form,refreshImgPic);
		form.action = "thumbnailPro.jsp";
		form.target = "ajaxFrame";
		form.submit();
	} else {
		warnMessage('fileformatsaresupported', 'detail', '', '');//gif, jpg, png, jpeg 파일 형식만 지원합니다.
		form.picture.value = "";
	}
}

function popUpMyInfo(){
	$('myInfoDiv').show();
	update('../myInfo/myInfoContent.jsp','myInfoDiv');
}

function closeMyInfo(){
	$('myInfoDiv').hide();
}

function loadWsdl(){
	var uri = $F('wsdlUri');
	var params = new Array();
	params.push("wsdlUri="+uri);
	params.push("method=loadWsdl");
	params = params.join("&");
	
	resetInputParts('inputPart','web');
	resetInputParts('outputPart','web');
	loadOperation();
	
	request("../services/portal/webService.jsp" , params , loadWsdlCallback);
}
function loadWsdlCallback(){
	//var xmlDoc = getXmlDOM(getResult());
	
	var result = getResult();
	var subResult = result.substring(result.indexOf('<Result'));
	var xmlDoc = getXmlDOM(subResult);
	
	var resultXml = SmartXMLUtil.getChildNode(xmlDoc, 'Result');
	if(resultXml.getAttribute('status') == 'OK') {
		var portTypes = resultXml.getAttribute('portTypes');
		var select = document.getElementById('ports');
		var opt = portTypes.split(";");
		
		var idx = 0;
		select.length = opt.length+1;
		select.options[idx].value="";
		select.options[idx].text = "선택";
		select[0].selected = true;
		idx++;
		for(var i = 0 ; i < opt.length; i++){
			select.options[idx].value = opt[i];
			select.options[idx].text = opt[i];
			idx++;
		}
	}
}

function loadOperation(){
	var portName = $F('ports');
	var uri = $F('wsdlUri');
	var params = new Array();
	params.push("wsdlUri="+uri);
	params.push("portName="+portName);
	params.push("method=loadOperation");
	params = params.join("&");
	request("../services/portal/webService.jsp" , params , loadOperationCallback);
}

function loadOperationCallback(){
	//var xmlDoc = getXmlDOM(getResult());
	var result = getResult();
	var subResult = result.substring(result.indexOf('<Result'));
	var xmlDoc = getXmlDOM(subResult);
	var resultXml = SmartXMLUtil.getChildNode(xmlDoc, 'Result');
	if(resultXml.getAttribute('status') == 'OK') {
		var operations = resultXml.getAttribute('operations');
		var select = document.getElementById('operation');
		var opt = operations.split(";");
		var idx = 0;
		select.length = opt.length+1;
		select.options[idx].value="";
		select.options[idx].text = "선택";
		select[0].selected = true;
		idx++;
		for(var i = 0 ; i < opt.length; i++){
			select.options[idx].value = opt[i];
			select.options[idx].text = opt[i];
			idx++;
		}
	}
}

function loadInputParts(){
	var portName = $F('ports');
	var uri = $F('wsdlUri');
	var operationName = $F('operation');
	var params = new Array();
	params.push("wsdlUri="+uri);
	params.push("portName="+portName);
	params.push("operationName="+operationName);
	params.push("method=loadInputParts");
	params = params.join("&");
	
	resetInputParts('inputPart','web');
	
	request("../services/portal/webService.jsp" , params , loadInputPartsCallback);
}

function loadInputPartsCallback(){
	//var xmlDoc = getXmlDOM(getResult());
	var result = getResult();
	var subResult = result.substring(result.indexOf('<Result'));
	var xmlDoc = getXmlDOM(subResult);	
	var resultXml = SmartXMLUtil.getChildNode(xmlDoc, 'Result');
	var inputPartTable = document.getElementById('inputPartTable');
	if(resultXml.getAttribute('status') == 'OK') {
		var inputPart = resultXml.getAttribute('inputPart');
		
		var inputPartArray = inputPart.split(';');
		
		if(inputPartArray.length>0){
			var inputId = "";
			var inputType = "";
			var ix = 0;
			for(var i = 0 ; i < inputPartArray.length; i++){
				var partArray = inputPartArray[i].split(',');
				var partId = partArray[0];
				var partType = partArray[1];
				
				if(ix!=0){ inputId += ";"; inputType += ";";}
				inputId += partId;
				inputType += partType;
				ix++;
				var tr = document.createElement('tr');
				var td1 = document.createElement('td');
				var td2 = document.createElement('td');
				var td3 = document.createElement('td');
				td1.innerHTML = "<input type='text' name='inputPart' id='inputPart"+i+"' style='width:99%' class='input'>";
				td2.appendChild(document.createTextNode(partId));
				td3.appendChild(document.createTextNode(partType));
				tr.appendChild(td1);
				tr.appendChild(td2);
				tr.appendChild(td3);
				inputPartTable.appendChild(tr);
			}
			document.getElementById('inputPartIds').setAttribute('value', inputId);
			document.getElementById('inputPartTypes').setAttribute('value', inputType);
		}
	}else{
		var tr = document.createElement('tr');
		var td1 = document.createElement('td');
		td1.setAttribute('colspan', '3');
		td1.appendChild(document.createTextNode('입력변수가 없습니다.'));
		tr.appendChild(td1);
		inputPartTable.appendChild(tr);
	}
	loadOutputParts();
}

function loadOutputParts(){
	var portName = $F('ports');
	var uri = $F('wsdlUri');
	var operationName = $F('operation');
	var params = new Array();
	params.push("wsdlUri="+uri);
	params.push("portName="+portName);
	params.push("operationName="+operationName);
	params.push("method=loadOutputParts");
	params = params.join("&");
	resetOutputParts('outputPart','web');	
	request("../services/portal/webService.jsp" , params , loadOutputPartsCallback);
}

function loadOutputPartsCallback(){
	//var xmlDoc = getXmlDOM(getResult());
	var result = getResult();
	var subResult = result.substring(result.indexOf('<Result'));
	var xmlDoc = getXmlDOM(subResult);
	var resultXml = SmartXMLUtil.getChildNode(xmlDoc, 'Result');
	var outputPartTable = document.getElementById('outputPartTable');

	if(resultXml.getAttribute('status') == 'OK') {
		var inputPart = resultXml.getAttribute('outputPart');
		
		var inputPartArray = inputPart.split(';');
		
		if(inputPartArray.length>0){
			var outputId = "";
			var outputType = "";
			var xi = 0;
			for(var i = 0 ; i < inputPartArray.length; i++){
				var partArray = inputPartArray[i].split(',');
				var partId = partArray[0];
				var partType = partArray[1];
	
				if(xi!=0){ outputId += ";"; outputType += ";";}
				outputId += partId;
				outputType += partType;
				xi++;
				
				var tr = document.createElement('tr');
				var td1 = document.createElement('td');
				var td2 = document.createElement('td');
				var td3 = document.createElement('td');
				td1.innerHTML = "<input type='text' name='outputPart' id='outputPart"+i+"' style='width:99%' class='input'>";
				td2.appendChild(document.createTextNode(partId));
				td3.appendChild(document.createTextNode(partType));
				tr.appendChild(td1);
				tr.appendChild(td2);
				tr.appendChild(td3);
				outputPartTable.appendChild(tr);
			}
			document.getElementById('outputPartIds').setAttribute('value', outputId);
			document.getElementById('outputPartTypes').setAttribute('value', outputType);
		}
	}else{
		var tr = document.createElement('tr');
		var td1 = document.createElement('td');
		td1.setAttribute('colspan', '3');
		td1.appendChild(document.createTextNode('입력변수가 없습니다.'));
		tr.appendChild(td1);
		outputPartTable.appendChild(tr);
	}
}

function saveWebService(){
	var objId = $F('objId');
	var serviceName = $F('serviceName');
	var wsdlUri = $F('wsdlUri');
	var ports = $F('ports');
	var operation = $F('operation');
	var contents = $F('contents');
	
	if(serviceName == ''){alertMessage('webService', 'EntertheServiceName'); return false;} //서비스 이름을 입력하세요.
	if(wsdlUri == ''){alertMessage('webService', 'EntertheWSDLURI'); return false;}  //WSDL URI을 입력하세요.
	if(ports == ''){alertMessage('webService', 'SelectPort'); return false;} //포트를 선택하세요.
	if(operation == ''){alertMessage('webService', 'SelectOperation'); return false;} //오퍼레이션을 선택하세요.
	
	var inputPartTable = document.getElementById('inputPartTable');
	var inputs = inputPartTable.getElementsByTagName('input');
	
	var inputPartTable = document.getElementById('outputPartTable');
	var outputs = inputPartTable.getElementsByTagName('input');
	var inputPart = "";
	var outputPart = "";
	
	var inputPartId = $F('inputPartIds');
	var outputPartId = $F('outputPartIds');
	var inputPartType = $F('inputPartTypes');
	var outputPartType = $F('outputPartTypes');
	
	if(inputs != undefined){
		var ix = 0;
		for(var i = 0; i < inputs.length; i++){
			if(ix!=0) inputPart += ";";
			inputPart += inputs[i].getAttribute('value');
			ix++;
		}
	}
	if(outputs != undefined){
		var xi = 0; 
		for(var i = 0; i < outputs.length; i++){
			if(xi!=0) outputPart += ";";
			outputPart += outputs[i].getAttribute('value');
			xi++;
		}
	}
	
	var params = new Array();
		params.push("serviceName="+serviceName);
		params.push("wsdlUri="+wsdlUri);
		params.push("portName="+ports);
		params.push("operationName="+operation);
		params.push("inputValName="+inputPart);
		params.push("outputValName="+outputPart);
		params.push("inputPartId="+inputPartId);
		params.push("outputPartId="+outputPartId);
		params.push("inputPartType="+inputPartType);
		params.push("outputPartType="+outputPartType);
		params.push("contents="+contents);
		params.push("objId="+objId);
		params.push("method=saveOperation");
		params = params.join("&");
		request("../services/portal/webService.jsp" , params , saveOperationCallback);
}

function saveOperationCallback(){
	alertMessage('webService', 'SaveCompleted', reloadPosition); //저장이 완료되었습니다.
}
function reloadPosition(){
	menuClick(document.getElementById('webService'),'../config/webServiceMng.jsp');
}
function webServiceList(pageNo){
	if(pageNo == undefined) pageNo = $F('pageNo');
	
	var userLanguage = $F('userLanguage');
	
	var params = new Array();
	params.push("pageNo="+pageNo);
	params.push("pageSize="+$F('pageSize'));
	params.push("method=webServiceList");
	params = params.join("&");
	
	$('pageNo').value = pageNo;
	
	var table = document.createElement('table');
	table.setAttribute('width', '100%');
	table.setAttribute('id', 'webServiceListTable');
	var tr = document.createElement('tr');
	var td1 = document.createElement('th');
	var td2 = document.createElement('th');
	var td3 = document.createElement('th');
	var td4 = document.createElement('th');
	var td5 = document.createElement('th');
	var td6 = document.createElement('th');
	td1.setAttribute('style', 'width:15%');
	td2.setAttribute('style', 'width:');
	td3.setAttribute('style', 'width:25%');
	td4.setAttribute('style', 'width:8%');
	td5.setAttribute('style', 'width:8%');
	td6.setAttribute('style', 'width:85px');
	if(userLanguage=='ENG'){
		td1.appendChild(document.createTextNode('Service Name'));	
		td2.appendChild(document.createTextNode('Description'));
		td3.appendChild(document.createTextNode('WSDL URI'));
		td4.appendChild(document.createTextNode('Port'));
		td5.appendChild(document.createTextNode('Operation'));
		td6.appendChild(document.createTextNode('Handling'));
	}else{
		td1.appendChild(document.createTextNode('서비스이름'));	
		td2.appendChild(document.createTextNode('설명'));
		td3.appendChild(document.createTextNode('WSDL URI'));
		td4.appendChild(document.createTextNode('포트'));
		td5.appendChild(document.createTextNode('오퍼레이션'));
		td6.appendChild(document.createTextNode('처리'));
	}
	tr.appendChild(td1);
	tr.appendChild(td2);
	tr.appendChild(td3);
	tr.appendChild(td4);
	tr.appendChild(td5);
	tr.appendChild(td6);
	table.appendChild(tr);
	var div = document.getElementById('webServiceListTableDiv');
	div.innerHTML = "";
	div.appendChild(table);
	var pagingDiv = document.createElement('div');
	pagingDiv.setAttribute('id', 'pagingDiv');
	div.appendChild(pagingDiv);
	request("../services/portal/webService.jsp",params, webServiceListCallback);
}
function webServiceListCallback(){
	//var xmlDoc = getXmlDOM(getResult());
	var result = getResult();
	var subResult = result.substring(result.indexOf('<Result'));
	var xmlDoc = getXmlDOM(subResult);
	var resultXml = SmartXMLUtil.getChildNode(xmlDoc, 'Result');
	var totalSize = resultXml.getAttribute("totalSize");
	var webServiceListTable = document.getElementById('webServiceListTable');
	
	var userLanguage = $F('userLanguage');
	
	if (resultXml.getAttribute('status') == 'OK') {
		var serviceXml = SmartXMLUtil.getChildNodes(resultXml, 'webServices');
		if(serviceXml.length!=0){
			for(var i = 0; i<serviceXml.length; i++){
				var webServiceName = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(serviceXml[i], 'webServiceName'));
				var description = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(serviceXml[i], 'description'));
				var wsdlAddress = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(serviceXml[i], 'wsdlAddress'));
				var portName = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(serviceXml[i], 'portName'));
				var operationName = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(serviceXml[i], 'operationName'));
				var objId = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(serviceXml[i], 'objId'));
				
				var tr = document.createElement('tr');
				var td1 = document.createElement('td');
				var td2 = document.createElement('td');
				var td3 = document.createElement('td');
				var td4 = document.createElement('td');
				var td5 = document.createElement('td');
				var td6 = document.createElement('td');
				
				var imgLanguage = $F('imageLanguage');
				
				var str = "<img src='../images/"+imgLanguage+"btn_modi.gif' onclick='modifyWebService(\""+objId+"\")' style='cursor:pointer; vartical-align:middel;'></img>"
						+ "<img src='../images/"+imgLanguage+"bt_delete.gif' onclick='deleteWebService(\""+objId+"\")' style='cursor:pointer; vartical-align:middel;'></img>";
				
				tr.setAttribute('style', 'vertical-align:top;');
				td1.appendChild(document.createTextNode(webServiceName));
				td2.appendChild(document.createTextNode(description));
				td3.appendChild(document.createTextNode(wsdlAddress));
				td4.appendChild(document.createTextNode(portName));
				td5.appendChild(document.createTextNode(operationName));
				td6.innerHTML = str; 
				
				tr.appendChild(td1);
				tr.appendChild(td2);
				tr.appendChild(td3);
				tr.appendChild(td4);
				tr.appendChild(td5);
				tr.appendChild(td6);
				webServiceListTable.appendChild(tr);
			}
			var params = new Array();
			//alert(functionName);
			params.push("totalSize=" + totalSize);
			params.push("pageSize=" + $F('pageSize'));
			params.push("pageNo=" + $F('pageNo'));
			params.push("funcName=webServiceList");
			params = params.join("&");
			send(getPath() + "/common/listPaging.jsp", "pagingDiv", params);
		}else{
			var tr = document.createElement('tr');
			var td1 = document.createElement('td');
			td1.setAttribute('colspan', '6');
			if(userLanguage == 'ENG'){
				td1.appendChild(document.createTextNode('No Display List.'));
			}else{
				td1.appendChild(document.createTextNode('리스트가 없습니다.'));
			}
			tr.appendChild(td1);
			webServiceListTable.appendChild(tr);
		}
		
	}else{
		var tr = document.createElement('tr');
		var td1 = document.createElement('td');
		td1.setAttribute('colspan', '6');
		if(userLanguage == 'ENG'){
			td1.appendChild(document.createTextNode('No Display List.'));
		}else{
			td1.appendChild(document.createTextNode('리스트가 없습니다.'));
		}
		tr.appendChild(td1);
		webServiceListTable.appendChild(tr);
	}
}

function showWebServiceList(){
	webServiceList();
}

function showExternalBusinessScreenList(){
	externalBusinessScreenList();
}

function modifyWebService(objId){
	writeDivShow();
	resetInputParts('inputPart','web');
	resetOutputParts('outputPart','web');
	
	var params = new Array();
	params.push("objId="+objId);
	params.push("method=modifyWebService");
	params = params.join("&");
	$('objId').value=objId;
	request("../services/portal/webService.jsp",params, modifyWebServiceCallback);
}

function deleteWebService(objId){
	var params = new Array();
	params.push("objId="+objId);
	params.push("method=deleteWebService");
	params = params.join("&");
	request("../services/portal/webService.jsp",params, deleteWebServiceCallback);
}
function deleteWebServiceCallback(){
	alertMessage('webService', 'DeleteCompleted', reloadPosition);
}

function modifyWebServiceCallback(){
	//var xmlDoc = getXmlDOM(getResult());
	var result = getResult();
	var subResult = result.substring(result.indexOf('<Result'));
	var xmlDoc = getXmlDOM(subResult);	
	
	var resultXml = SmartXMLUtil.getChildNode(xmlDoc, 'Result');
	var outputPartTable = document.getElementById('outputPartTable');
	var inputPartTable = document.getElementById('inputPartTable');
	if(resultXml.getAttribute('status') == 'OK') {
		var serviceName = resultXml.getAttribute('serviceName');
		var wsdlAddress = resultXml.getAttribute('wsdlAddress');
		var portName = resultXml.getAttribute('portName');
		var operationName = resultXml.getAttribute('operationName');
		var description = resultXml.getAttribute('description');
		$('ports').length = 1;
		$('operation').length = 1;
		
		$('serviceName').value = serviceName;
		$('wsdlUri').value = wsdlAddress;
		$('ports').options[0].text = portName;
		$('ports').options[0].value = portName;
		$('operation').options[0].value = operationName;
		$('operation').options[0].text = operationName;
		$('contents').value = description;
		
		var inputVals = SmartXMLUtil.getChildNodes(resultXml, 'inputVals');
		var outputVals = SmartXMLUtil.getChildNodes(resultXml, 'outputVals');
		if(inputVals.length>0){
			var inputPartIds = "";
			var inputPartTypes = "";
			
			for(var i = 0; i<inputVals.length; i++){
				var inputValId = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(inputVals[i], 'inputValId'));
				var inputValName = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(inputVals[i], 'inputValName'));
				var inputValType = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(inputVals[i], 'inputValType'));
				
				var tr = document.createElement('tr');
				var td1 = document.createElement('td');
				var td2 = document.createElement('td');
				var td3 = document.createElement('td');
				td1.innerHTML = "<input type='text' name='inputPart' id='inputPart"+i+"' style='width:99%' class='input' value='"+inputValName+"'>";
				td2.appendChild(document.createTextNode(inputValId));
				td3.appendChild(document.createTextNode(inputValType));
				tr.appendChild(td1);
				tr.appendChild(td2);
				tr.appendChild(td3);
				inputPartTable.appendChild(tr);
				if(i!=0){ 
					inputPartIds += ";";
					inputPartTypes += ";";
				}
				inputPartIds += inputValId;
				inputPartTypes += inputValType;
			}
			$('inputPartIds').value = inputPartIds;
			$('inputPartTypes').value = inputPartTypes;
		}
		if(outputVals.length>0){
			var outputPartIds = "";
			var outputPartTypes = "";
			for(var i = 0; i<outputVals.length; i++){
				var outputValId = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(outputVals[i], 'outputValId'));
				var outputValName = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(outputVals[i], 'outputValName'));
				var outputValType = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(outputVals[i], 'outputValType'));
				var tr = document.createElement('tr');
				var td1 = document.createElement('td');
				var td2 = document.createElement('td');
				var td3 = document.createElement('td');
				td1.innerHTML = "<input type='text' name='outputPart' id='outputPart"+i+"' style='width:99%' class='input' value='"+outputValName+"'>";
				td2.appendChild(document.createTextNode(outputValId));
				td3.appendChild(document.createTextNode(outputValType));
				tr.appendChild(td1);
				tr.appendChild(td2);
				tr.appendChild(td3);
				outputPartTable.appendChild(tr);
				if(i!=0){ 
					outputPartIds += ";";
					outputPartTypes += ";";
				}
				outputPartIds += outputValId;
				outputPartTypes += outputValType;
			}
			$('outputPartIds').value = outputPartIds;
			$('outputPartTypes').value = outputPartTypes;
		}
	}

}

 function resetInputParts(id, web){
	 var inputPartTd = document.getElementById(id+'Td');
		inputPartTd.innerHTML = '';
		
		var userLanguage = $F('userLanguage');
		//var div = document.createElement('div');
		//div.setAttribute('style', 'height:50px; overflow-y: auto; overflow-x:hidden;');
		var table = document.createElement('table');
		table.setAttribute('width', '100%');
		table.setAttribute('id', id+'Table');
		var tr = document.createElement('tr');
		var td1 = document.createElement('th');
		var td2 = document.createElement('th');
		var td3 = document.createElement('th');
		td1.setAttribute('style', 'width:33%');
		td2.setAttribute('style', 'width:33%');
		if(userLanguage == 'ENG'){
			td1.appendChild(document.createTextNode('Parameter Name'));	
		}else{
			td1.appendChild(document.createTextNode('변수이름'));	
		}
		td2.appendChild(document.createTextNode('Element Name'));
		td3.appendChild(document.createTextNode('Element Type'));
		
		if(id == 'editMode' || id == 'findMode'){
			var td4 = document.createElement('th');
			td3.setAttribute('style', 'width:');
			td4.setAttribute('style', 'width:10px');
			
			var img = document.createElement('img');
			img.src = '../images/icon/category/group_plus.gif';
			img.setAttribute('alt', '행 추가');
			img.setAttribute('title', '행 추가');
			img.setAttribute('style', 'cursor:pointer;');
			img.setAttribute("onclick","addExtBusinessScreenRow('"+id+"')");
			
			td4.appendChild(img);
			tr.appendChild(td1);
			tr.appendChild(td2);
			tr.appendChild(td3);
			tr.appendChild(td4);
		}else{
			td3.setAttribute('style', 'width:');
			tr.appendChild(td1);
			tr.appendChild(td2);
			tr.appendChild(td3);
		}
		
		if(web != undefined && web != '' && web != 'undefined'){
			table.appendChild(tr);
		}else{
			var tbody = document.createElement('tbody');
			tbody.setAttribute('id',id+'TableTbody');
			tbody.appendChild(tr);
			table.appendChild(tbody);
		}
		//table.appendChild(tr);
		//div.appendChild(table);
		inputPartTd.appendChild(table);
 }
 
 function addExtBusinessScreenRow(id){
	var table = $(id+'Table');
	var nodes = table.childNodes;
	var idx = nodes.length-1;
	var tbody = $(id+'TableTbody');
	
	var tr = document.createElement('tr');
	var td1 = document.createElement('td');
	var td2 = document.createElement('td');
	var td3 = document.createElement('td');
	var td4 = document.createElement('td');
	td1.setAttribute('style', 'width:;');
	td2.setAttribute('style', 'width:;');
	td3.setAttribute('style', 'width:;');
	td4.setAttribute('style', 'width:10px;');
	
	var input1 = "<input type='text' name='"+id+"valueName' value='' class='input' style='width:100%'>";
	var input2 = "<input type='text' name='"+id+"elementName' value='' class='input' style='width:100%'>";
	
	var select =  "<select id='"+id+"elementType' name='"+id+"elementType' class='input' style='width:100%; height:20px;'>"
				+ "<option value='radioButton'>radioButton</option>"
				+ "<option value='comboBox'>comboBox</option>"
				+ "<option value='checkBox'>checkBox</option>"
				+ "<option value='dateChooser'>dateChooser</option>"
				+ "<option value='userField'>userField</option>"
				+ "<option value='timeField'>timeField</option>"
				+ "<option value='numberInput'>numberInput</option>"
				+ "<option value='currencyInput'>currencyInput</option>"
				+ "<option value='percentInput'>percentInput</option>"
				+ "<option value='emailIDInput'>emailIDInput</option>"
				+ "<option value='text'>text</option>"
				+ "</select>";
	
	//var input3 = "<input type='text' name='"+id+"elementType' value='' class='input' style='width:100%'>";
	
	var img = document.createElement('img');
	img.src = '../images/icon/category/group_minus.gif';
	img.setAttribute('alt', '행 삭제');
	img.setAttribute('title', '행 삭제');
	img.setAttribute('style', 'cursor:pointer;');
	//img.style.cursor = 'pointer';
	img.setAttribute('onclick','delExtBusinessScreenRow(\''+id+'\',\''+idx+'\')');
	
	td1.innerHTML = input1;	
	td2.innerHTML = input2;
	td3.innerHTML = select;
	td4.appendChild(img);
	
	tr.setAttribute('id', id+idx)
	tr.appendChild(td1);
	tr.appendChild(td2);
	tr.appendChild(td3);
	tr.appendChild(td4);
	tbody.appendChild(tr);
	//table.appendChild(tr);
 }
 
 function delExtBusinessScreenRow(id, idx){
	 $(id+idx).remove();
	 //$(id+'Table').removeRow(idx);
 }
 
 function resetOutputParts(id, web){
	 var outputPartTd = document.getElementById(id+'Td');
		outputPartTd.innerHTML = '';
		
		var userLanguage = $F('userLanguage');
		//var div = document.createElement('div');
		//div.setAttribute('style', 'height:50px; overflow-y: auto; overflow-x:hidden;');
		var table = document.createElement('table');
		table.setAttribute('width', '100%');
		table.setAttribute('id', id+'Table');
		var tr = document.createElement('tr');
		var td1 = document.createElement('th');
		var td2 = document.createElement('th');
		var td3 = document.createElement('th');
		td1.setAttribute('style', 'width:33%');
		td2.setAttribute('style', 'width:33%');
		td3.setAttribute('style', 'width:');
		if(userLanguage == 'ENG'){
			td1.appendChild(document.createTextNode('Parameter Name'));	
		}else{
			td1.appendChild(document.createTextNode('변수이름'));	
		}
		td2.appendChild(document.createTextNode('Element Name'));
		td3.appendChild(document.createTextNode('Element Type'));
		
		if(id == 'editMode' || id == 'findMode' || id == 'returnMode'){
			var td4 = document.createElement('th');
			td4.setAttribute('style', 'width:10px');
			
			var img = document.createElement('img');
			img.src = '../images/icon/category/group_plus.gif';
			img.setAttribute('alt', '행 추가');
			img.setAttribute('title', '행 추가');
			img.setAttribute('style', 'cursor:pointer;');
			img.setAttribute("onclick","addExtBusinessScreenRow('"+id+"')");
			
			td4.appendChild(img);
			tr.appendChild(td1);
			tr.appendChild(td2);
			tr.appendChild(td3);
			tr.appendChild(td4);
		}else{
			tr.appendChild(td1);
			tr.appendChild(td2);
			tr.appendChild(td3);
		}
		
		
		if(web != undefined && web != '' && web != 'undefined'){
			table.appendChild(tr);
		}else{
			var tbody = document.createElement('tbody');
			tbody.setAttribute('id',id+'TableTbody');
			tbody.appendChild(tr);
			table.appendChild(tbody);
		}
		
		//div.appendChild(table);
		outputPartTd.appendChild(table);
 }
 
 function externalBusinessScreenList(pageNo){
		if(pageNo == undefined) pageNo = $F('pageNo');
		var userLanguage = $F('userLanguage');
		var params = new Array();
		params.push("pageNo="+pageNo);
		params.push("pageSize="+$F('pageSize'));
		params.push("method=externalBusinessScreenList");
		params = params.join("&");
		
		$('pageNo').value = pageNo;
		
		var table = document.createElement('table');
		table.setAttribute('width', '100%');
		table.setAttribute('id', 'externalBusinessScreenListTable');
		
		var thead = document.createElement('thead');
		
		var tr = document.createElement('tr');
		var td1 = document.createElement('th');
		var td2 = document.createElement('th');
		var td3 = document.createElement('th');
		var td4 = document.createElement('th');
		var td5 = document.createElement('th');
		var td6 = document.createElement('th');
		td1.setAttribute('style', 'width:15%');
		td2.setAttribute('style', 'width:');
		td3.setAttribute('style', 'width:25%');
		td4.setAttribute('style', 'width:8%');
		td5.setAttribute('style', 'width:8%');
		td6.setAttribute('style', 'width:85px');
		if(userLanguage == 'ENG'){
			td1.appendChild(document.createTextNode('Application Name'));	
			td2.appendChild(document.createTextNode('Description'));
			td3.appendChild(document.createTextNode('URL'));
			td4.appendChild(document.createTextNode('Edit Method'));
			td5.appendChild(document.createTextNode('View Method'));
			td6.appendChild(document.createTextNode('Handling'));
		}else{
			td1.appendChild(document.createTextNode('업무화면 이름'));	
			td2.appendChild(document.createTextNode('설명'));
			td3.appendChild(document.createTextNode('URL'));
			td4.appendChild(document.createTextNode('편집 Method'));
			td5.appendChild(document.createTextNode('조회 Method'));
			td6.appendChild(document.createTextNode('처리'));
		}
		tr.appendChild(td1);
		tr.appendChild(td2);
		tr.appendChild(td3);
		tr.appendChild(td4);
		tr.appendChild(td5);
		tr.appendChild(td6);
		thead.appendChild(tr);
		table.appendChild(thead);
		
		var tbody = document.createElement('tbody');
		tbody.setAttribute('id', 'externalBusinessScreenListTableTbody');
		table.appendChild(tbody);
		
		var div = document.getElementById('externalBusinessScreenListTableDiv');
		div.innerHTML = "";
		div.appendChild(table);
		var pagingDiv = document.createElement('div');
		pagingDiv.setAttribute('id', 'pagingDiv');
		div.appendChild(pagingDiv);
		
		request("../services/portal/webService.jsp",params, externalBusinessScreenListCallback);
	}
	function externalBusinessScreenListCallback(){
var result = getResult();
var subResult = result.substring(result.indexOf('<Result'));
var xmlDoc = getXmlDOM(subResult);
		var resultXml = SmartXMLUtil.getChildNode(xmlDoc, 'Result');

		var totalSize = resultXml.getAttribute("totalSize");
		var externalBusinessScreenListTable = document.getElementById('externalBusinessScreenListTable');
		var externalBusinessScreenListTableTbody = $('externalBusinessScreenListTableTbody');
		var userLanguage = $F('userLanguage');
		var imgLanguage = $F('imgLanguage');
		if (resultXml.getAttribute('status') == 'OK') {
			var serviceXml = SmartXMLUtil.getChildNodes(resultXml, 'externalBusinessScreen');
			if(serviceXml.length!=0){
				for(var i = 0; i<serviceXml.length; i++){
					var externalBusinessScreenName = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(serviceXml[i], 'externalBusinessScreenName'));
					var description = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(serviceXml[i], 'description'));
					var url = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(serviceXml[i], 'url'));
					var editMethod = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(serviceXml[i], 'editMethod'));
					var findMethod = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(serviceXml[i], 'findMethod'));
					var objId = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(serviceXml[i], 'objId'));
					var tr = document.createElement('tr');
					var td1 = document.createElement('td');
					var td2 = document.createElement('td');
					var td3 = document.createElement('td');
					var td4 = document.createElement('td');
					var td5 = document.createElement('td');
					var td6 = document.createElement('td');
					var str = "<img src='../images/"+imgLanguage+"btn_modi.gif' onclick='modifyExternalBusinessScreen(\""+objId+"\")' style='cursor:pointer; vartical-align:middle;'></img>" +
							  "<img src='../images/"+imgLanguage+"bt_delete.gif' onclick='deleteExternalBusinessScreen(\""+objId+"\")' style='cursor:pointer; vartical-align:middle;'></img>";
					tr.setAttribute('style', 'vertical-align:top;');
					td1.appendChild(document.createTextNode(externalBusinessScreenName));
					td2.appendChild(document.createTextNode(description));
					td3.appendChild(document.createTextNode(url));
					td4.appendChild(document.createTextNode(editMethod));
					td5.appendChild(document.createTextNode(findMethod));
					td6.innerHTML = str; 
					tr.appendChild(td1);
					tr.appendChild(td2);
					tr.appendChild(td3);
					tr.appendChild(td4);
					tr.appendChild(td5);
					tr.appendChild(td6);
					externalBusinessScreenListTableTbody.appendChild(tr);
					//externalBusinessScreenListTable.appendChild(tr);
				}
				var params = new Array();
				//alert(functionName);
				params.push("totalSize=" + totalSize);
				params.push("pageSize=" + $F('pageSize'));
				params.push("pageNo=" + $F('pageNo'));
				params.push("funcName=externalBusinessScreenList");
				params = params.join("&");
				send(getPath() + "/common/listPaging.jsp", "pagingDiv", params);
			}else{
				var tr = document.createElement('tr');
				var td1 = document.createElement('td');
				td1.setAttribute('colspan', '6');
				if(userLanguage == 'ENG'){
					td1.appendChild(document.createTextNode('No Display List.'));
				}else{
					td1.appendChild(document.createTextNode('리스트가 없습니다.'));
				}
				tr.appendChild(td1);
				externalBusinessScreenListTableTbody.appendChild(tr);
				//externalBusinessScreenListTable.appendChild(tr);
			}
			
		}else{
			var tr = document.createElement('tr');
			var td1 = document.createElement('td');
			td1.setAttribute('colspan', '6');
			if(userLanguage == 'ENG'){
				td1.appendChild(document.createTextNode('No Display List.'));
			}else{
				td1.appendChild(document.createTextNode('리스트가 없습니다.'));
			}
			tr.appendChild(td1);
			externalBusinessScreenListTableTbody.appendChild(tr);
			//externalBusinessScreenListTable.appendChild(tr);
		}
	}
 
	function modifyExternalBusinessScreen(objId){
		resetInputParts('editMode');
		resetOutputParts('findMode');
		resetOutputParts('returnMode');
		writeDivShow();
		var params = new Array();
		params.push("objId="+objId);
		params.push("method=modifyExternalBusinessScreen");
		params = params.join("&");
		$('objId').value=objId;
		request("../services/portal/webService.jsp",params, modifyExternalBusinessScreenCallback);
	}

	function deleteExternalBusinessScreen(objId){
		var params = new Array();
		params.push("objId="+objId);
		params.push("method=deleteExternalBusinessScreen");
		params = params.join("&");
		request("../services/portal/webService.jsp",params, deleteExternalBusinessScreenCallback);
	}
	function deleteExternalBusinessScreenCallback(){
		alertMessage('ExternalWebApplicationManagement', 'DeleteCompleted', reloadExternalPosition); //삭제가 완료되었습니다.
	}

	function reloadExternalPosition(){
		menuClick(document.getElementById('extBusinessScreen'),'../config/externalBusinessScreenMng.jsp');
	}
	
	function modifyExternalBusinessScreenCallback(){
		//var xmlDoc = getXmlDOM(getResult());
		var result = getResult();
		var subResult = result.substring(result.indexOf('<Result'));
		var xmlDoc = getXmlDOM(subResult);
		var resultXml = SmartXMLUtil.getChildNode(xmlDoc, 'Result');
		var editModeTable = document.getElementById('editModeTable');
		var findModeTable = document.getElementById('findModeTable');
		var returnModeTable = document.getElementById('returnModeTable');
		if(resultXml.getAttribute('status') == 'OK') {
			var externalBusinessScreenName = resultXml.getAttribute('externalBusinessScreenName');
			var url = resultXml.getAttribute('url');
			var editMethod = resultXml.getAttribute('editMethod');
			var findMethod = resultXml.getAttribute('findMethod');
			var description = resultXml.getAttribute('description');
			
			
			$('businessScreenName').value = externalBusinessScreenName;
			$('url').value = url;
			$('editModeMethod').value = editMethod;
			$('findModeMethod').value = findMethod;
			$('contents').value = description;
			
			var editMethod = SmartXMLUtil.getChildNodes(resultXml, 'editMethod');
			var viewMethod = SmartXMLUtil.getChildNodes(resultXml, 'viewMethod');
			var returnMethod = SmartXMLUtil.getChildNodes(resultXml, 'returnMethod');
			if(editMethod.length>0){
				var editMethodIds = "";
				var editMethodTypes = "";
				
				for(var i = 0; i<editMethod.length; i++){
					var editMethodValId = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(editMethod[i], 'editMethodId'));
					var editMethodValName = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(editMethod[i], 'editMethodName'));
					var editMethodValType = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(editMethod[i], 'editMethodType'));
					
					var tr = document.createElement('tr');
					var td1 = document.createElement('td');
					var td2 = document.createElement('td');
					var td3 = document.createElement('td');
					var td4 = document.createElement('td');

					td1.innerHTML = "<input type='text' name='editMethodName' id='editMethodName"+i+"' style='width:99%' class='input' value="+editMethodValName+">";
					td2.innerHTML = "<input type='text' name='editMethodId' id='editMethodId"+i+"' style='width:99%' class='input' value="+editMethodValId+">";
					td3.innerHTML =   "<select id=editMethodType"+i+"' name='editMethodType' class='input' style='width:100%; height:20px;'>"
									+ "<option value='radioButton'"+(editMethodValType=='radioButton'?'selected':'')+">radioButton</option>"
									+ "<option value='comboBox'"+(editMethodValType=='comboBox'?'selected':'')+">comboBox</option>"
									+ "<option value='checkBox'"+(editMethodValType=='checkBox'?'selected':'')+">checkBox</option>"
									+ "<option value='dateChooser'"+(editMethodValType=='dateChooser'?'selected':'')+">dateChooser</option>"
									+ "<option value='userField'"+(editMethodValType=='userField'?'selected':'')+">userField</option>"
									+ "<option value='timeField'"+(editMethodValType=='timeField'?'selected':'')+">timeField</option>"
									+ "<option value='numberInput'"+(editMethodValType=='numberInput'?'selected':'')+">numberInput</option>"
									+ "<option value='currencyInput'"+(editMethodValType=='currencyInput'?'selected':'')+">currencyInput</option>"
									+ "<option value='percentInput'"+(editMethodValType=='percentInput'?'selected':'')+">percentInput</option>"
									+ "<option value='emailIDInput'"+(editMethodValType=='emailIDInput'?'selected':'')+">emailIDInput</option>"
									+ "<option value='text'"+(editMethodValType=='text'?'selected':'')+">text</option>"
									+ "</select>"; 
						//"<input type='text' name='editMethodType' id='editMethodType"+i+"' style='width:99%' class='input' value="+editMethodValType+">";
					
					var img = document.createElement('img');
					img.src = '../images/icon/category/group_minus.gif';
					img.setAttribute('alt', '행 삭제');
					img.setAttribute('title', '행 삭제');
					img.setAttribute('style', 'cursor:pointer;');
					img.setAttribute('onclick','delExtBusinessScreenRow(\'editMode\',\''+i+'\')');
					
					td4.appendChild(img);
					tr.setAttribute('id', 'editMode'+i);
					tr.appendChild(td1);
					tr.appendChild(td2);
					tr.appendChild(td3);
					tr.appendChild(td4);
					$('editModeTableTbody').appendChild(tr);
					//editModeTable.appendChild(tr);
				}
			}
			if(viewMethod.length>0){
				var viewMethodIds = "";
				var viewMethodTypes = "";
				for(var i = 0; i<viewMethod.length; i++){
					var viewMethodId = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(viewMethod[i], 'viewMethodId'));
					var viewMethodName = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(viewMethod[i], 'viewMethodName'));
					var viewMethodType = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(viewMethod[i], 'viewMethodType'));
					
					var tr = document.createElement('tr');
					var td1 = document.createElement('td');
					var td2 = document.createElement('td');
					var td3 = document.createElement('td');
					var td4 = document.createElement('td');
					td1.innerHTML = "<input type='text' name='viewMethodName' id='viewMethodName"+i+"' style='width:99%' class='input' value="+viewMethodName+">";
					td2.innerHTML = "<input type='text' name='viewMethodId' id='viewMethodId"+i+"' style='width:99%' class='input' value="+viewMethodId+">";
					
					td3.innerHTML =   "<select id=viewMethodType"+i+"' name='viewMethodType' class='input' style='width:100%; height:20px;'>"
									+ "<option value='radioButton'"+(viewMethodType=='radioButton'?'selected':'')+">radioButton</option>"
									+ "<option value='comboBox'"+(viewMethodType=='comboBox'?'selected':'')+">comboBox</option>"
									+ "<option value='checkBox'"+(viewMethodType=='checkBox'?'selected':'')+">checkBox</option>"
									+ "<option value='dateChooser'"+(viewMethodType=='dateChooser'?'selected':'')+">dateChooser</option>"
									+ "<option value='userField'"+(viewMethodType=='userField'?'selected':'')+">userField</option>"
									+ "<option value='timeField'"+(viewMethodType=='timeField'?'selected':'')+">timeField</option>"
									+ "<option value='numberInput'"+(viewMethodType=='numberInput'?'selected':'')+">numberInput</option>"
									+ "<option value='currencyInput'"+(viewMethodType=='currencyInput'?'selected':'')+">currencyInput</option>"
									+ "<option value='percentInput'"+(viewMethodType=='percentInput'?'selected':'')+">percentInput</option>"
									+ "<option value='emailIDInput'"+(viewMethodType=='emailIDInput'?'selected':'')+">emailIDInput</option>"
									+ "<option value='text'"+(viewMethodType=='text'?'selected':'')+">text</option>"
									+ "</select>"; 
					
					//td3.innerHTML = "<input type='text' name='viewMethodType' id='viewMethodType"+i+"' style='width:99%' class='input' value="+viewMethodType+">";
					
					var img = document.createElement('img');
					img.src = '../images/icon/category/group_minus.gif';
					img.setAttribute('alt', '행 삭제');
					img.setAttribute('title', '행 삭제');
					img.setAttribute('style', 'cursor:pointer;');
					img.setAttribute('onclick','delExtBusinessScreenRow(\'viewMode\',\''+i+'\')');
					
					td4.appendChild(img);
					tr.setAttribute('id', 'viewMode'+i);
					tr.appendChild(td1);
					tr.appendChild(td2);
					tr.appendChild(td3);
					tr.appendChild(td4);
					$('findModeTableTbody').appendChild(tr);
					//findModeTable.appendChild(tr);
				}
			}
			
			if(returnMethod.length>0){
				var returnMethodIds = "";
				var returnMethodTypes = "";
				for(var i = 0; i<returnMethod.length; i++){
					var returnMethodId = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(returnMethod[i], 'returnMethodId'));
					var returnMethodName = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(returnMethod[i], 'returnMethodName'));
					var returnMethodType = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(returnMethod[i], 'returnMethodType'));
					
					var tr = document.createElement('tr');
					var td1 = document.createElement('td');
					var td2 = document.createElement('td');
					var td3 = document.createElement('td');
					var td4 = document.createElement('td');
					td1.innerHTML = "<input type='text' name='returnMethodName' id='returnMethodName"+i+"' style='width:99%' class='input' value="+returnMethodName+">";
					td2.innerHTML = "<input type='text' name='returnMethodId' id='returnMethodId"+i+"' style='width:99%' class='input' value="+returnMethodId+">";
					td3.innerHTML =   "<select id=returnMethodType"+i+"' name='returnMethodType' class='input' style='width:100%; height:20px;'>"
									+ "<option value='radioButton'"+(returnMethodType=='radioButton'?'selected':'')+">radioButton</option>"
									+ "<option value='comboBox'"+(returnMethodType=='comboBox'?'selected':'')+">comboBox</option>"
									+ "<option value='checkBox'"+(returnMethodType=='checkBox'?'selected':'')+">checkBox</option>"
									+ "<option value='dateChooser'"+(returnMethodType=='dateChooser'?'selected':'')+">dateChooser</option>"
									+ "<option value='userField'"+(returnMethodType=='userField'?'selected':'')+">userField</option>"
									+ "<option value='timeField'"+(returnMethodType=='timeField'?'selected':'')+">timeField</option>"
									+ "<option value='numberInput'"+(returnMethodType=='numberInput'?'selected':'')+">numberInput</option>"
									+ "<option value='currencyInput'"+(returnMethodType=='currencyInput'?'selected':'')+">currencyInput</option>"
									+ "<option value='percentInput'"+(returnMethodType=='percentInput'?'selected':'')+">percentInput</option>"
									+ "<option value='emailIDInput'"+(returnMethodType=='emailIDInput'?'selected':'')+">emailIDInput</option>"
									+ "<option value='text'"+(returnMethodType=='text'?'selected':'')+">text</option>"
									+ "</select>"; 
					
					var img = document.createElement('img');
					img.src = '../images/icon/category/group_minus.gif';
					img.setAttribute('alt', '행 삭제');
					img.setAttribute('title', '행 삭제');
					img.setAttribute('style', 'cursor:pointer;');
					img.setAttribute('onclick','delExtBusinessScreenRow(\'returnMode\',\''+i+'\')');
					td4.appendChild(img);
					
					tr.setAttribute('id', 'returnMode'+i);
					tr.appendChild(td1);
					tr.appendChild(td2);
					tr.appendChild(td3);
					tr.appendChild(td4);
					$('returnModeTableTbody').appendChild(tr);
					//returnModeTable.appendChild(tr);
				}
			}
		}
	}
 
	function saveExternalBusinessScreenService(){
		var objId = $F('objId');
		var businessScreenName = $F('businessScreenName');
		var url = $F('url');
		var editModeMethod = $F('editModeMethod');
		var findModeMethod = $F('findModeMethod');
		var contents = $F('contents');
		
		if(businessScreenName == ''){alertMessage('ExternalWebApplicationManagement', 'EntertheApplicationName'); return false;} //외부업무화면 이름을 입력하세요.
		if(url == ''){alertMessage('ExternalWebApplicationManagement', 'EntertheURL'); return false;} //URL을 입력하세요.
		if(editModeMethod == ''){alertMessage('ExternalWebApplicationManagement', 'EntertheEditModeMethod'); return false;}  //편집모드 메서드를 입력하세요.
		if(findModeMethod == ''){alertMessage('ExternalWebApplicationManagement', 'EntertheViewModeMethod'); return false;}  //조회모드 메서드를 입력하세요.
		
		var editModeTable = document.getElementById('editModeTable');
		var findModeTable = document.getElementById('findModeTable');
		var returnModeTable = document.getElementById('returnModeTable');
		
		var editModeName = "";
		var editModeId = "";
		var editModeType = "";
		var findModeName = "";
		var findModeId = "";
		var findModeType = "";
		
		var returnModeName = "";
		var returnModeId = "";
		var returnModeType = "";
		if($('editModeTableTbody').childNodes.length > 1){
			var inputs = editModeTable.getElementsByTagName('input');
			var select = editModeTable.getElementsByTagName('select');
			var editMethodNameArray = editModeTable.getElementsByTagName('editMethodName');
			var editMethodIdArray = editModeTable.getElementsByTagName('editMethodId');
			var editMethodTypeArray = editModeTable.getElementsByTagName('editMethodType');
			var ix = 0;
			var idx = 0;
			var idx2 = 0;
			for(var i = 0; i < $('editModeTableTbody').childNodes.length-1; i++){
				if(ix!=0){ 
					editModeName += ";";
					editModeId += ";";
					editModeType += ";";
				}
				editModeName += inputs[idx++].getAttribute('value');
				editModeId += inputs[idx++].getAttribute('value');
				//editModeType += select[idx2++].getAttribute('value');
				var selectBox = select[idx2++];
				for(var ii = 0; ii<selectBox.length; ii++){
					if(selectBox[ii].selected == true){ editModeType += selectBox[ii].value; break;} 
				}
				ix++;
			}
			var editModeNameArray = editModeName.split(';');
			var editModeTypeArray = editModeType.split(';');
			var editModeIdArray = editModeId.split(';');
			if(editModeNameArray.length == editModeTypeArray.length && editModeTypeArray.length == editModeIdArray.length){
			}else{
				alertMessage('ExternalWebApplicationManagement', 'ThevalueofavariablefieldinEditModeismissing'); return false;  //편집모드 변수필드에 값이 누락되었습니다.
			}
		}
		if($('findModeTableTbody').childNodes.length > 1){
			var inputs = findModeTable.getElementsByTagName('input');
			var select = findModeTable.getElementsByTagName('select');
			var findMethodNameArray = findModeTable.getElementsByTagName('findMethodName');
			var findMethodIdArray = findModeTable.getElementsByTagName('findMethodId');
			var findMethodTypeArray = findModeTable.getElementsByTagName('findMethodType');
			var ix = 0;
			var idx = 0;
			var idx2 = 0;
			for(var i = 0; i < $('findModeTableTbody').childNodes.length-1; i++){
				if(ix!=0){ 
					findModeName += ";";
					findModeId += ";";
					findModeType += ";";
				}
				findModeName += inputs[idx++].getAttribute('value');
				findModeId += inputs[idx++].getAttribute('value');
				
				var selectBox = select[idx2++];
				for(var ii = 0; ii<selectBox.length; ii++){
					if(selectBox[ii].selected == true){ findModeType += selectBox[ii].value; break;} 
				}
				
				//findModeType += inputs[idx++].getAttribute('value');
				ix++;
			}
			var findModeNameArray = findModeName.split(';');
			var findModeTypeArray = findModeType.split(';');
			var findModeIdArray = findModeId.split(';');
			if(findModeNameArray.length == findModeTypeArray.length && findModeTypeArray.length == findModeIdArray.length){
			}else{
				alertMessage('ExternalWebApplicationManagement', 'ThevalueofavariablefieldinViewModeismissing'); return false;  //조회모드 변수필드에 값이 누락되었습니다.
			}
		}
		if($('returnModeTableTbody').childNodes.length > 1){
			var inputs = returnModeTable.getElementsByTagName('input');
			var select = returnModeTable.getElementsByTagName('select');
			var returnMethodNameArray = findModeTable.getElementsByTagName('returnMethodName');
			var returnMethodIdArray = findModeTable.getElementsByTagName('returnMethodId');
			var returnMethodTypeArray = findModeTable.getElementsByTagName('returnMethodType');
			var ix = 0;
			var idx = 0;
			var idx2 = 0;
			for(var i = 0; i < $('returnModeTableTbody').childNodes.length-1; i++){
				if(ix!=0){ 
					returnModeName += ";";
					returnModeId += ";";
					returnModeType += ";";
				}
				
				returnModeName += inputs[idx++].getAttribute('value');
				returnModeId += inputs[idx++].getAttribute('value');
				//alert(returnModeName);
				
				var selectBox = select[idx2++];
				for(var ii = 0; ii<selectBox.length; ii++){
					if(selectBox[ii].selected == true){ returnModeType += selectBox[ii].value; break;} 
				}
				
				ix++;
			}
			var returnModeNameArray = returnModeName.split(';');
			var returnModeTypeArray = returnModeType.split(';');
			var returnModeIdArray = returnModeId.split(';');
			if(returnModeNameArray.length == returnModeTypeArray.length && returnModeTypeArray.length == returnModeIdArray.length){
			}else{
				alertMessage('ExternalWebApplicationManagement', 'ThevalueofavariablefieldinReturnModeismissing'); return false;  //반환모드 변수필드에 값이 누락되었습니다.
			}
		}
		
		
		var params = new Array();
			params.push("businessScreenName="+businessScreenName);
			params.push("url="+url);
			params.push("editModeMethod="+editModeMethod);
			params.push("findModeMethod="+findModeMethod);
			params.push("editModeName="+editModeName);
			params.push("editModeId="+editModeId);
			params.push("editModeType="+editModeType);
			params.push("findModeName="+findModeName);
			params.push("findModeId="+findModeId);
			params.push("findModeType="+findModeType);
			params.push("returnModeName="+returnModeName);
			params.push("returnModeId="+returnModeId);
			params.push("returnModeType="+returnModeType);
			params.push("contents="+contents);
			params.push("objId="+objId);
			params.push("method=saveExternalBusinessScreenService");
			params = params.join("&");
			request("../services/portal/webService.jsp" , params , saveExternalBusinessScreenServiceCallback);
	}
	function saveExternalBusinessScreenServiceCallback(){
		alertMessage('ExternalWebApplicationManagement', 'SaveCompleted', reloadExternalPosition); //저장이 완료되었습니다.
	}
	function writeDivShow(){
		$('writeDiv').show();
	}
	function writeDivHide(){
		$('writeDiv').hide();
	}
	function addExternalScreenView(){
		resetInputParts('editMode');
		resetOutputParts('findMode');
		resetOutputParts('returnMode');
		$('objId').setAttribute('value','');
		$('businessScreenName').setAttribute('value','')
		$('url').setAttribute('value','')
		$('editModeMethod').setAttribute('value','')
		$('findModeMethod').setAttribute('value','')
		$('contents').innerHTML ="";
		writeDivShow();
	}
	
	function toggleReportWorkTree(treeId, treeListId, targetUrl) {
		if ($(treeId).style.display === 'none') {
			$(treeListId).contentWindow.location.href=targetUrl;
			$(treeId).style.display = 'block';
		} else {
			$(treeId).style.display = 'none';
		}
	}
	
	function webserviceWriteDivShow(){
		resetInputParts('outputPart','web');
		resetInputParts('inputPart','web');
		$('ports').length = 1;
		$('operation').length = 1;
		
		$('serviceName').value = '';
		$('wsdlUri').value = '';
		$('ports').options[0].text = '';
		$('ports').options[0].value = '';
		$('operation').options[0].value = '';
		$('operation').options[0].text = '';
		$('contents').value = '';
		writeDivShow();
	}