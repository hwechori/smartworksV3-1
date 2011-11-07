var prevMenu = null;
var menuXml = null;
var firstPackageId = "";
var firstPackageType = "";
var firstPackageProcess = "";
var firstPackageLength = 0;
var fristCategoryId = "";
var fristGroupId = "";

var selectCategoryId = "";
var selectGroupId = "";


/*
	clickCategory(categoryId) : 왼쪽 메뉴 카테고리를 클릭했을 경우.
*/
function clickMenu(categoryId, groupId) {
	selectCategoryId = categoryId;
	selectGroupId = groupId;
	if(categoryId == null || categoryId == "") {
		var params = new Array();
		params.push("method=getCategorys");
		params.push("userId=" + userId);
		params.push("compId=" + compId);
		params = params.join("&");
		request("../services/market/marketService.jsp", params, _clickMenu, null, "loading", null, "failed");
	} else {
		clickMenuCallback();
	}

}
function _clickMenu() {
	menuXml = getXmlDOM(getResult());
	var resultXml = SmartXMLUtil.getChildNode(menuXml, 'Result');
	if(resultXml.getAttribute('status') == 'OK') {
		clickMenuCallback();
	}
}
function clickMenuCallback() {
	var resultXml = SmartXMLUtil.getChildNode(menuXml, 'Result');
	//var categoryListTable = $('categoryList');
	//var categoryListTbody = categoryListTable.getElementsByTagName('tbody')[0];

	if(resultXml.getAttribute('status') == 'OK') {
		//removeAllRow(0, categoryListTable);
		var categoryXml = SmartXMLUtil.getChildNodes(resultXml, 'category');
		
		for(var i=0; i<categoryXml.length; i++) {
			var categoryId = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(categoryXml[i], 'categoryId'));
			var categoryName = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(categoryXml[i], 'categoryName')).escapeHTML();
			/*
			var catTr;
			if(selectCategoryId == categoryId || (i == 0 && (selectCategoryId == "" || selectCategoryId == null))) {
				catTr = new Element('tr', {'style': 'cursor: pointer;font: bold', id: categoryId}).observe('click', function(){clickMenu(this.getAttribute('id'), '')});
			} else {
				catTr = new Element('tr', {'style': 'cursor: pointer;', id: categoryId}).observe('click', function(){clickMenu(this.getAttribute('id'), '')});
			}

			var catTd1 = new Element('td', {'style': 'cursor: pointer;height: 30px;border-top-width: 1px; border-top-style: solid; border-top-color: #D2DAE9;'}).update('&nbsp;');
			var catTd2 = new Element('td', {'style': 'cursor: pointer;border-top-width: 1px; border-top-style: solid; border-top-color: #D2DAE9;'}).update(categoryName);
			var catTd3 = new Element('td', {'style': 'cursor: pointer;border-top-width: 1px; border-top-style: solid; border-top-color: #D2DAE9;'});
			var catImg = null;
			if(selectCategoryId == categoryId || (i == 0 && (selectCategoryId == "" || selectCategoryId == null))) {
				catImg = new Element('img', {src: '../images/icon/category/ic_category_open.gif'});
			} else {
				catImg = new Element('img', {src: '../images/icon/category/ic_category_close.gif'});
			}
			//catTd3.appendChild(catImg);
			//catTr.appendChild(catTd1);
			//catTr.appendChild(catTd2);
			//catTr.appendChild(catTd3);
			categoryListTbody.appendChild(catTr);*/
			if(selectCategoryId == categoryId || (i == 0 && (selectCategoryId == "" || selectCategoryId == null))) {
				var groupTr = new Element('tr');
				var groupTd = new Element('td', {colSpan: 3});
				var groupTable = new Element('table');
				var groupTbody = new Element('tbody');
				
				//카테고리에 속한 그룹
				var groupXml = SmartXMLUtil.getChildNodes(categoryXml[i], 'group');
				var packageXml = SmartXMLUtil.getChildNodes(categoryXml[i], 'Package');
				if(i == 0) {
					if(packageXml != null) {
						firstPackageLength = packageXml.length;
					}
				}

				for(var k=0; k<groupXml.length; k++) {
					var groupId = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(groupXml[k], 'groupId'));
					var groupName = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(groupXml[k], 'groupName')).escapeHTML();
					var gTr;
					if(i ==0 && k ==0) {
						fristCategoryId = categoryId;
						fristGroupId = groupId;
					}
					/*
					var gImg = null;
					if(selectGroupId == groupId) {
						gTr = new Element('tr', {'style': 'cursor: pointer;font: bold', id: groupId, categoryId: categoryId}).observe('click', function(){clickMenu(this.getAttribute('categoryId'), this.getAttribute('id'))});
						gImg = new Element('img', {src: '../images/icon/category/group_minus.gif'});
					} else {
						gTr = new Element('tr', {'style': 'cursor: pointer;', id: groupId, categoryId: categoryId}).observe('click', function(){clickMenu(this.getAttribute('categoryId'), this.getAttribute('id'))});
						gImg = new Element('img', {src: '../images/icon/category/group_plus.gif'});
					}
					var gTd1 = new Element('td', {'style': 'cursor: pointer;height: 24px;width: 5px;'}).update("&nbsp;");
					var gTd2 = new Element('td', {'style': 'cursor: pointer;width: 20px;'});
					gTd2.appendChild(gImg);
					var gTd3 = new Element('td', {'style': 'cursor: pointer;width: 146px;'}).update(groupName);
					gTr.appendChild(gTd1);
					gTr.appendChild(gTd2);
					gTr.appendChild(gTd3);
					groupTbody.appendChild(gTr);*/
					
					// 그룹에 속한 패키지 목록
					var groupPackageTr = new Element('tr');
					if(selectGroupId == groupId) {
						groupPackageTr.show();
					} else {
						groupPackageTr.hide();
					}					
					var groupPackageTd = new Element('td', {colSpan: 3});
					var groupPackageTable = new Element('table');
					var groupPackageTbody = new Element('tbody');
					var groupPackageXml = SmartXMLUtil.getChildNodes(groupXml[k], 'Package');
					for(var j=0; j<groupPackageXml.length; j++) {
						var packageId = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(groupPackageXml[j], 'packageId'));
						var packageType = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(groupPackageXml[j], 'packageType'));
						var packageName = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(groupPackageXml[j], 'packageName')).escapeHTML();
						var processId = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(groupPackageXml[j], 'processId'));
						/*
						var pTr = new Element('tr', {'style': 'cursor: pointer;', id: packageId, packageType: packageType, processId: processId}).observe('click', function(){clickPackage(this.getAttribute('id'), this.getAttribute('packageType'), this.getAttribute('processId'))});
						var pTd1 = new Element('td', {'style': 'cursor: pointer;height: 22px;width: 20px;'}).update("&nbsp;");
						var pTd2 = new Element('td', {'style': 'cursor: pointer;width: 20px;'});
						var pImg;
						if(packageType == "PROCESS") {
							pImg = new Element('img', {src: '../images/icon/package/ic_process.gif'});
						} else {
							pImg = new Element('img', {src: '../images/icon/package/ic_information.gif'});
						}
						pTd2.appendChild(pImg);
						var pTd3 = new Element('td', {'style': 'cursor: pointer;width: 131px;'}).update(packageName);
						pTr.appendChild(pTd1);
						pTr.appendChild(pTd2);
						pTr.appendChild(pTd3);
						groupPackageTbody.appendChild(pTr);
						*/
						if(firstPackageLength == 0) {
							if(i == 0 && k == 0 && j == 0) {
								firstPackageId = packageId;
								firstPackageType = packageType;
								firstPackageProcess = processId;
							}
						}
					}
					//groupPackageTable.appendChild(groupPackageTbody);
					//groupPackageTd.appendChild(groupPackageTable);
					//groupPackageTr.appendChild(groupPackageTd);
					//groupTbody.appendChild(groupPackageTr);
				}
				
				//카테고리에 속한 패키지
				for(var k=0; k<packageXml.length; k++) {
					var packageId = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(packageXml[k], 'packageId'));
					var packageType = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(packageXml[k], 'packageType'));
					var packageName = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(packageXml[k], 'packageName')).escapeHTML();
					var processId = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(packageXml[k], 'processId'));
					/*
					var pTr = new Element('tr', {'style': 'cursor: pointer;', id: packageId, packageType: packageType, processId: processId}).observe('click', function(){clickPackage(this.getAttribute('id'), this.getAttribute('packageType'), this.getAttribute('processId'))});
					var pTd1 = new Element('td', {'style': 'cursor: pointer;height: 22px;width: 5px;'}).update("&nbsp;");
					var pTd2 = new Element('td', {'style': 'cursor: pointer;width: 20px;'});
					var pImg;
					if(packageType == "PROCESS") {
						pImg = new Element('img', {src: '../images/icon/package/ic_process.gif'});
					} else {
						pImg = new Element('img', {src: '../images/icon/package/ic_information.gif'});
					}
					pTd2.appendChild(pImg);
					var pTd3 = new Element('td', {'style': 'cursor: pointer;width: 146px;'}).update(packageName);
					pTr.appendChild(pTd1);
					pTr.appendChild(pTd2);
					pTr.appendChild(pTd3);
					groupTbody.appendChild(pTr);
					*/
					if(i == 0 && k == 0 ) {
						firstPackageId = packageId;
						firstPackageType = packageType;
						firstPackageProcess = processId;
					}
				}				
				
				//groupTable.appendChild(groupTbody);
				//groupTd.appendChild(groupTable);
				//groupTr.appendChild(groupTd);
				//categoryListTbody.appendChild(groupTr);
			}
			
		}

		if( selectCategoryId == "" || selectCategoryId == null ) {
			if(firstPackageLength > 0) {
				clickPackage(firstPackageId, firstPackageType, firstPackageProcess);
			} else {
				if(fristCategoryId != "" && fristCategoryId != null & firstPackageId != "" && firstPackageId != null) {
					firstPackageClick(fristCategoryId, fristGroupId, firstPackageId, firstPackageType, firstPackageProcess);
				}
			}
		}
	}
}
function firstPackageClick(fristCategoryId, fristGroupId, firstPackageId, firstPackageType, firstPackageProcess) {
	clickMenu(fristCategoryId, fristGroupId);
	clickPackage(firstPackageId, firstPackageType, firstPackageProcess);
}

var prevRefPackage = null;
var prevRefForm = null;
var editorArrs = null;
var refFormDescArrs = null;
var formDescArrs = null;

var selectedPackageId = null;
var selectedPackageType = null;
var selectedProcessId = null;

function clickPackage(packageId, packageType, processId) {
	selectedPackageId = packageId;
	selectedPackageType = packageType;
	selectedProcessId = processId;
	_clickPackage();
	//update("../shareBasket/shareBasketContent.jsp", "mainTd", "", _clickPackage, "loading", "failed");
}

function _clickPackage() {
	var packageId 	= selectedPackageId;
	var packageType = selectedPackageType;
	var processId 	= selectedProcessId;
	var obj = $(packageId);
	if(prevMenu != obj) {
		obj.style.fontWeight  = "bold";
		if(prevMenu != null)
			prevMenu.style.fontWeight  = "";
	}
	prevMenu = obj;
	
	//$('refPackageTitleTr').hide();
	$('businessTypes').setAttribute("value", "");
	$('business').setAttribute("value", "");
	var params = new Array();
	params.push("method=getPackage");
	params.push("userId=" + userId);
	params.push("userLanguage=" + defaultLanguage);
	params.push("packageId=" + packageId);
	params.push("packageType=" + packageType);
	params.push("processId=" + processId);
	params.push("compId=" + compId);
	params = params.join("&");
	request(getPath() + "/services/market/marketService.jsp", params, clickPackageCallBack, null, "loading", null, "failed");
}
function clickPackageCallBack() {
	var xmlDoc = getXmlDOM(getResult());
	var resultXml = SmartXMLUtil.getChildNode(xmlDoc, 'Result');

	editorArrs = new Array();
	oEditors = [];
	refFormDescArrs = new Array();
	formDescArrs = new Array();
	var editorNum = 0;
	
	if(resultXml.getAttribute('status') == 'OK') {
		
		$("manualguideTd").innerHTML = "<input type=\"file\" id=\"manualguide\" name=\"manualguide\" size=\"53\">";
		$("movieguideTd").innerHTML = "<input type=\"file\" id=\"movieguide\" name=\"movieguide\" size=\"53\">";
		$("ref_task").innerHTML = "";
		
		var packageXml = SmartXMLUtil.getChildNode(resultXml, 'package');
		var categoryName = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(packageXml, 'categoryName')).escapeHTML();
		var packageId = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(packageXml, 'packageId'));
		var packageName = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(packageXml, 'packageName'));
		var description = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(packageXml, 'description'));
		var packageTypeName = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(packageXml, 'packageTypeName'));
		var packageType = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(packageXml, 'packageType'));
		var processId = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(packageXml, 'processId'));
		var isFile = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(packageXml, 'isFile'));
		var packageImgHeight = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(packageXml, 'imgHeight'));
		$('formListTable').show();
		$('packageId').setAttribute('value', packageId);
		$('packageType').setAttribute('value', packageType);
		$('name').setAttribute('value', packageName);
		$('refPkgNames').setAttribute('value', '');
		//$('shareBasketTitle').update("공유관리소&nbsp;&gt;&nbsp;"+categoryName+"&nbsp;&gt;&nbsp;"+packageName);
		$('packageTypeNameTd').update(packageTypeName);
		$('uploadBtn').show();
		if(defaultLanguage=='ENG'){
			$('guideTitleTd').update("User Guide&nbsp;("+packageName+")");
		}else{
			$('guideTitleTd').update("사용자 가이드&nbsp;("+packageName+")");
		}
		var packageImageTd = $('packageImageTd');
		packageImageTd.innerHTML = "";
		removeChildNodes($('descriptionTd'), 0);

		var textarea = new Element('textarea', {name: 'description', id: 'description', 'style': 'width: 97%;height: 70;'});
		textarea.update(description);
		
		$('descriptionTd').update(textarea);
		
		var packageIcon = $('packageIcon');
		if(packageType == "PROCESS") {
			var image = null;
			if(isFile == "true") {
				image = new Element('img', {src: '../systemImages/workDef/'+packageId+'/'+processId+'_tn.png'});
			} else {
				image = new Element('img', {src: '../images/shareBasket/ic_noimage.gif'});
			}
			packageImageTd.appendChild(image);
			packageIcon.setAttribute("src", "../images/icon/package/ic_process.gif");
		} else {
			packageIcon.setAttribute("src", "../images/icon/package/ic_information.gif");
		}
		if(packageType == "PROCESS") {
			$('processId').setAttribute("value", processId);
		}

		$('packageNameTd').update(packageName.escapeHTML());
		
		//패키징 속한 화면 목록(배치된 것만) 
		var formXml = SmartXMLUtil.getChildNodes(resultXml, 'form');
		formListTable = $('formListTable');
		removeAllRow(0, formListTable);
		var tBody = formListTable.getElementsByTagName('tbody')[0];
		if(packageType == "PROCESS") {
			var procTr = new Element('tr', {id: processId+'tr', 'style': 'padding: 5px 0px 5px 0px;'});
			var procTd1 = new Element('td', {align: 'left', vAlign: 'top', bgColor: '#FFFFFF', 'style': 'font: bold;padding-left: 15px;'}).update("<img src='../images/icon/bt_wscreen.gif'>&nbsp;"+packageName+"<br>");
			var img;
			isFile = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(packageXml, 'isFile'));
			if(isFile == "true") {	
				img = new Element('img', {src: '../systemImages/workDef/'+packageId+'/'+processId+'.png', 'style': 'border: #cccccc 1px solid;margin-top: 3px;'});
				img.setAttribute("width", "315");
				img.setAttribute("height", packageImgHeight);
				imgHeight = packageImgHeight;
			} else {
				img = new Element('img', {src: '../images/shareBasket/ic_noimageB.jpg', width:'315', 'style': 'margin-top: 6px;'});
				imgHeight = 212;
			}

			img.setAttribute('style', 'padding-left: 20px;');
			procTd1.appendChild(img);
			var procTd2 = new Element('td', {id:'processGuideTd', vAlign: 'top', align: 'left', 'bgColor': '#FFFFFF'});
			var textedit = ''; var modiedit = '';
			if(defaultLanguage=='ENG'){
				textedit = 'Text'; modiedit = 'Editor';
			}else{
				textedit = '텍스트'; modiedit = '편집기';
			}
			var changeMode = "<input type='radio' id='processGuideradio' name='processGuideradio' value='editor' style='border:none' checked='checked'>&nbsp;"+textedit;
			changeMode = changeMode + "&nbsp;<input type='radio' id='processGuideradio' name='processGuideradio' value='text' style='border:none' onclick='textareaMode(\"richeditor\", \"processGuide\", \"410\", \""+imgHeight+"\")'>"+modiedit;

			var processGuideDiv1 = new Element('div', {id: 'processGuideDiv1', 'imgHeight': imgHeight}).update(changeMode);//.observe('click', function(){textareaMode('richeditor', 'processGuide', '365', this.getAttribute('imgHeight'))});
			var processGuideDiv2 = new Element('div', {id: 'processGuideDiv2'});

			procTd2.appendChild(processGuideDiv1);
			procTd2.appendChild(processGuideDiv2);
			var textarea = new Element('textarea', {name: 'processGuide', id: 'processGuide', cols: '50', 'style': 'width: 97%; height: ' + imgHeight + 'px'});
			textarea.update(description);
			processGuideDiv2.appendChild(textarea);

			editorArrs[editorNum] = ['processGuide', 'text'];
			editorNum = editorNum + 1;
			
			procTr.appendChild(procTd1);
			procTr.appendChild(procTd2);
			tBody.appendChild(procTr);

			var lintTr = new Element('tr');
			var lineTd = new Element('td', {colSpan : 2, height: '1px', 'style': 'background-image: url(../images/shareBasket/sub_co_line.jpg) ; background-repeat:repeat-x'});
			lintTr.appendChild(lineTd);
			tBody.appendChild(lintTr);
		}
		for(var i=0; i<formXml.length; i++) {
			var formId = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(formXml[i], 'formId'));
			var formName = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(formXml[i], 'formName'));
			var formCreator = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(formXml[i], 'formCreator'));
			var formDescription = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(formXml[i], 'formDescription'));
			var formCreationDate = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(formXml[i], 'formCreationDate'));
			var isFile = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(formXml[i], 'isFile'));
			var imgHeight = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(formXml[i], 'imgHeight'));

			var tr = new Element('tr', {id: formId+'tr', 'style': 'padding: 5px 0px 5px 0px;'});
			var td1 = new Element('td', {align: 'left', vAlign: 'top', 'bgColor': '#FFFFFF', 'style': 'font:bold;padding-left: 15px;'}).update("<img src='../images/icon/bt_wscreen.gif'>&nbsp;"+formName+"<br>");
			var input1 = createInputElement('hidden', 'formIds', formId);
			var input2 = createInputElement('hidden', 'formNames', formName);
			td1.appendChild(input1);
			td1.appendChild(input2);

			var img;
			var textAreaRows = "7";
			var paddingTop = 19;
			if(formId == "SYSTEMFORM") {
				img = new Element('img', {src: '../systemImages/workDef/SYSTEMFORM.png', 'style': 'border: #cccccc 1px solid;margin-top: 7px;'});
				img.setAttribute("width", "315");
				paddingTop = 20;
				imgHeight = 266;
			} else {
				if(isFile == "true") {	
					img = new Element('img', {src: '../systemImages/workDef/'+packageId+'/'+formId+'.png', 'style': 'border: #cccccc 1px solid;margin-top: 6px;'});
					img.setAttribute("width", "315");
					imgHeight = Number(imgHeight) + 5;
					paddingTop = 20;
				} else {
					img = new Element('img', {src: '../images/shareBasket/ic_noimageB.jpg', width:'315', 'style': 'margin-top: 6px;'});
					imgHeight = 213;
				}
			}

			if(imgHeight < 160)
				imgHeight = 160;

			td1.appendChild(img);

			var td2 = new Element('td', {id: 'formDescription'+formId+'Td', vAlign: 'top', align: 'left', 'bgColor': '#FFFFFF'});
			var fieldId = 'formDescription'+formId;
			if(defaultLanguage=='ENG'){
				textedit = 'Text'; modiedit = 'Editor';
			}else{
				textedit = '텍스트'; modiedit = '편집기';
			}
			var changeMode = "<input type='radio' id='"+fieldId+"radio' name='"+fieldId+"radio' value='editor' style='border:none' checked='checked'>&nbsp;"+textedit;
			changeMode = changeMode + "&nbsp;<input type='radio' id='"+fieldId+"radio' name='"+fieldId+"radio' value='text' style='border:none' onclick='textareaMode(\"richeditor\", \""+fieldId+"\", \"410\", \""+imgHeight+"\")';>"+modiedit;

			var div1 = new Element('div', {id: 'formDescription'+formId+'Div1', 'formId': formId, 'imgHeight': imgHeight}).update(changeMode);//.observe('click', function(){textareaMode('richeditor', 'formDescription'+this.getAttribute('formId'), '365', this.getAttribute('imgHeight'))});
			var div2 = new Element('div', {id: 'formDescription'+formId+'Div2'});
			var textarea = new Element('textarea', {name: fieldId, id: fieldId, 'style': 'width: 97%; height: ' + imgHeight + 'px'}).update(formDescription);

			div2.appendChild(textarea);
			
			td2.appendChild(div1);
			td2.appendChild(div2);

			editorArrs[editorNum] = ["formDescription"+formId, 'text'];
			editorNum = editorNum + 1;

			formDescArrs[i] = ["formDescription"+formId];
			
			if(packageType == "SINGLE") {

				if(isFile == "true") {
					img = new Element('img', {src: '../systemImages/workDef/'+packageId+'/'+formId+'_tn.png'});
				} else {
					img = new Element('img', {src: '../images/shareBasket/ic_noimage.gif'});
				}
				packageImageTd.appendChild(img);

			}
			if(packageType == "SINGLE") {
				$('formId').setAttribute("value", formId);
			}			
			
			tr.appendChild(td1);
			tr.appendChild(td2);
			tBody.appendChild(tr);

			if((formXml.length-1) > i) {
				var lintTr = new Element('tr');
				var lineTd = new Element('td', {colSpan : 2, height: '1px', 'style': 'background-image: url(../images/shareBasket/sub_co_line.jpg) ; background-repeat:repeat-x'});
				lintTr.appendChild(lineTd);
				tBody.appendChild(lintTr);
			}
		}
		//해당 패키지 연관 업무 목록
		var refPackageXml = SmartXMLUtil.getChildNodes(resultXml, 'refPackage');
		var formListTable = $('refFormListTable');
		removeAllRow(0, formListTable);
		var refPackageTable = $('refPackageTable');
		removeAllRow(0, refPackageTable);
		if(refPackageXml.length > 0) {
			$('refFormTr').show();
			var srcXSL = Mis.getPath() + "/shareBasket/refTree.xsl";
			if(defaultLanguage=='ENG'){
				srcXSL = Mis.getPath() + "/shareBasket/refTreeEng.xsl";
			}
			var srcXML = Mis.getPath() + "/shareBasket/refTree.jsp?objId=" + packageId;//result.responseXML;
			//document.write(Mis.getPath() + "/shareBasket/refTree.jsp?objId=" + packageId);
			var xml = loadXMLDoc(srcXML);
			var xsl = loadXMLDoc(srcXSL);
			displayResult(xml, xsl, "ref_task");
			closeXMLDoc(srcXML);
			closeXMLDoc(xsl);			
		} else {
			$('refFormTr').hide();
		}
		
		for(var i=0; i<refPackageXml.length; i++) {
			//연결업무 상단 테이블
			var refPackageId = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(refPackageXml[i], 'packageId'));
			var refCategoryName = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(refPackageXml[i], 'categoryName'));
			var refPackageName = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(refPackageXml[i], 'packageName'));
			var refPackageDesc = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(refPackageXml[i], 'description'));
			var refPackageTypeName = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(refPackageXml[i], 'packageTypeName'));
			//연결업무 업무 가이드 테이블
			var refPackageFormXml = SmartXMLUtil.getChildNodes(refPackageXml[i], 'form');
			for(var k=0; k<refPackageFormXml.length; k++) {
				tbody = refPackageTable.getElementsByTagName("tbody")[0];
				var formId = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(refPackageFormXml[k], 'formId'));
				var formName = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(refPackageFormXml[k], 'formName'));
				var formCreator = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(refPackageFormXml[k], 'formCreator'));
				var formDescription = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(refPackageFormXml[k], 'formDescription'));
				var formCreationDate = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(refPackageFormXml[k], 'formCreationDate'));
				var isFile = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(refPackageFormXml[k], 'isFile'));
				var imgHeight = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(refPackageFormXml[k], 'imgHeight'));
				var tr = new Element('tr', {id: refPackageId+'refFormTr', 'style': 'padding: 5px 0px 5px 0px;display: none;'});
				var td1 = new Element('td', {align: 'left', vAlign: 'top', 'bgColor': '#FFFFFF', 'style': 'font:bold;padding-left: 15px;'}).update("<img src='../images/icon/bt_wscreen.gif'>&nbsp;"+formName+"<br>");
				var img;
				var paddingTop = 19;
				
				if(isFile == "true") {	
					img = new Element('img', {src: '../systemImages/workDef/'+refPackageId+'/'+formId+'.png', 'style': 'border: #cccccc 1px solid;margin-top: 7px;'});
					img.setAttribute("width", "315");
					paddingTop = 20;
				} else {
					img = new Element('img', {src: '../images/shareBasket/ic_noimageB.jpg', width: '315', 'style': 'margin-top: 6px;'});
					imgHeight = 212;
				}
				td1.appendChild(img);

				if(imgHeight < 160)
					imgHeight = 160;
				
				var input1 = createInputElement('hidden', 'refFormIds', formId);
				var input2 = createInputElement('hidden', 'refPackageIds', refPackageId);
				var input3 = createInputElement('hidden', 'refFormNames', formName);
				td1.appendChild(input1);
				td1.appendChild(input2);
				td1.appendChild(input3);
				var td2Id = "refFormDescription"+formId;
				var td2 = new Element('td', {id: td2Id+'Td', vAlign: 'top', align: 'left', 'bgColor': '#FFFFFF'});
				var fieldId = 'refFormDescription'+formId;
				if(defaultLanguage=='ENG'){
					textedit = 'Text'; modiedit = 'Editor';
				}else{
					textedit = '텍스트'; modiedit = '편집기';
				}
				var changeMode = "<input type='radio' id='"+fieldId+"radio' name='"+fieldId+"radio' value='editor' style='border:none' checked='checked'>&nbsp;"+textedit;
				changeMode = changeMode + "&nbsp;<input type='radio' id='"+fieldId+"radio' name='"+fieldId+"radio' value='text' style='border:none' onclick='textareaMode(\"richeditor\", \""+td2Id+"\", \"410\", \""+imgHeight+"\")'>"+modiedit;

				var div1 = new Element('div', {id: 'refFormDescription'+formId+'Div1', 'formId': formId, 'imgHeight': imgHeight}).update(changeMode);//.observe('click', function(){textareaMode('richeditor', 'refFormDescription'+this.getAttribute('formId'), '365', this.getAttribute('imgHeight'))});
				var div2 = new Element('div', {id: 'refFormDescription'+formId+'Div2'});
				var textarea = new Element('textarea', {name: fieldId, id: fieldId, 'style': 'width: 410px; height: ' + imgHeight + 'px'}).update(formDescription);
				div2.appendChild(textarea);

				td2.appendChild(div1);
				td2.appendChild(div2);

				tr.appendChild(td1);
				tr.appendChild(td2);

				editorArrs[editorNum] = [td2Id, 'text'];
				editorNum = editorNum + 1;

				refFormDescArrs[i] = [td2Id];

				if(packageType == "SINGLE") {
					$('formId').setAttribute("value", formId);
				}			
				
				tbody.appendChild(tr);
			}
		}
		$('mainTd').show();
		showPackage('main');
	}
}

function textareaMode(textmode, fieldId, width, height) {
		
	var td = $(fieldId+'Td');
	var div1 = new Element('div', {id: fieldId+'Div1'});
	var div2 = new Element('div', {id: fieldId+'Div2'});
	
	if(textmode == "richeditor") {
		var content = $F(fieldId);
		removeChildNodes(td, 0);
		if(defaultLanguage=='ENG'){
			textedit = 'Text'; modiedit = 'Editor';
		}else{
			textedit = '텍스트'; modiedit = '편집기';
		}
		var changeMode = "<input type='radio' id='"+fieldId+"radio' name='"+fieldId+"radio' value='editor' style='border:none' onclick='textareaMode(\"textarea\", \""+fieldId+"\", \""+width+"\", \""+height+"\")'>&nbsp;"+textedit;
		changeMode = changeMode + "&nbsp;<input type='radio' id='"+fieldId+"radio' name='"+fieldId+"radio' value='text' style='border:none' checked='checked'>"+modiedit;
		div1.update(changeMode);//.observe('click', function(){textareaMode('textarea', fieldId, width, height)});	
/*
		var textEditor = new FCKeditor(fieldId, width, height, "SmartWorks", content);
		textEditor.Config["CustomConfigurationsPath"] = getPath() + "/js/lang/FCKeditor_" + defaultLanguage + ".js";
		textEditor.BasePath = getPath() + "/FCKedit/";
		var html = textEditor.CreateHtml();
		div2.update(html);
*/
		for (var i=0; i<editorArrs.length; i++) {
			if (fieldId == editorArrs[i][0]) {
				editorArrs[i] = [fieldId, 'editor'];
			}
		}
		
		content = content.escapeHTML();
		
		height = height - 15;	//editor size
				
		var textarea = new Element('textarea', {name: fieldId, id: fieldId, 'style': 'width: 410px; height: ' + height + 'px; display: none;'}).update(content);
		div2.appendChild(textarea);
				
		td.appendChild(div1);
		td.appendChild(div2);
		
		var editorSkinURI = getPath() + "/smarteditor/SEditorSkinKOR.html";
		if (defaultLanguage === "ENG") {
			editorSkinURI = getPath() + "/smarteditor/SEditorSkinENG.html";
		}
		nhn.husky.EZCreator.createInIFrame({
			oAppRef: oEditors,
			elPlaceHolder: fieldId,
			sSkinURI: editorSkinURI,
			fCreator: "createSEditorInIFrame"
		});
		
	} else if(textmode == "textarea") {
		//var content = FCKeditorAPI.GetInstance(fieldId).GetXHTML(true);
		var content = oEditors.getById[fieldId].getIR();
		removeChildNodes(td, 0);
		if(defaultLanguage=='ENG'){
			textedit = 'Text'; modiedit = 'Editor';
		}else{
			textedit = '텍스트'; modiedit = '편집기';
		}
		var changeMode = "<input type='radio' id='"+fieldId+"radio' name='"+fieldId+"radio' value='editor' style='border:none' checked='checked'>&nbsp;"+textedit;
		changeMode = changeMode + "&nbsp;<input type='radio' id='"+fieldId+"radio' name='"+fieldId+"radio' value='text' style='border:none' onclick='textareaMode(\"richeditor\", \""+fieldId+"\", \""+width+"\", \""+height+"\")'>"+modiedit;
		div1.update(changeMode);//.observe('click', function(){textareaMode('richeditor', fieldId, width, height)});
		content = content.escapeHTML();
		var textarea = new Element('textarea', {name: fieldId, id: fieldId, 'style': 'height: '+height+'px; width:'+width+'px'}).update(content);
		div2.appendChild(textarea);
		
		td.appendChild(div1);
		td.appendChild(div2);
		
		for(var i=0; i<editorArrs.length; i++) {
			if(fieldId == editorArrs[i][0]) {
				editorArrs[i] = [fieldId, 'text'];
				oEditors.splice(i, 1);
			}
		}
		
	}
	
}

function showPackage(psImgId) {
	if(psImgId != null && psImgId != "") {
		var refPackageTable = $('refPackageTable');
		var refPackageTr = refPackageTable.getElementsByTagName('tr');
		if(refPackageTr != null && refPackageTr.length > 0) {
			var links = $("ref_task").getElementsByTagName("li");
			for (var i = 0; i < links.length; i++) {
				links[i].style.fontWeight  = "";
			}
			$("link_"+psImgId).style.fontWeight  = "bold";
		}
	}
	
	$('refPackageTd').hide();
	$('formListTable').show();
	var packageId = $F('packageId');
	var obj = $(packageId+'RefTr');
	if(prevRefPackage != obj) {
		obj.style.fontWeight  = "bold";
		if(prevRefPackage != null)
			prevRefPackage.style.fontWeight  = "";
	}
	prevRefPackage = obj;

	var params = new Array();
	params.push("method=getPackageInfo");
	params.push("userId=" + userId);
	params.push("userLanguage=" + defaultLanguage);
	params.push("packageId=" + $F('packageId'));
	params.push("compId=" + compId);
	params = params.join("&");
	request(getPath() + "/services/market/marketService.jsp", params, showPackageCallBack, null, null, null, null);
}
function showPackageCallBack() {
	var xmlDoc = getXmlDOM(getResult());
	var resultXml = SmartXMLUtil.getChildNode(xmlDoc, 'Result');
	if(resultXml.getAttribute('status') == 'OK') {
		var packageXml = SmartXMLUtil.getChildNode(resultXml, 'package');
		var categoryName = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(packageXml, 'categoryName'));
		var packageId = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(packageXml, 'packageId'));
		var packageName = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(packageXml, 'packageName'));
		var description = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(packageXml, 'description'));
		var packageTypeName = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(packageXml, 'packageTypeName'));
		var packageType = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(packageXml, 'packageType'));
		var description = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(packageXml, 'description'));
		var refPackageTable = $('refPackageTable');
		if(defaultLanguage=='ENG'){
			$('guideTitleTd').update("User Guide&nbsp;("+packageName+")");
		}else{
			$('guideTitleTd').update("사용자 가이드&nbsp;("+packageName+")");
		}
	}	
}

function clickRefPackage(packageId, psImgId) {

	$('refPackageTd').show();
	$('formListTable').hide();

	var links = $("ref_task").getElementsByTagName("li");
	for (var i = 0; i < links.length; i++) {
		links[i].style.fontWeight  = "";
	}
	$("link_"+psImgId).style.fontWeight  = "bold";
	
	var obj = $(packageId+'RefTr');
	if(prevRefPackage != obj) {
		obj.style.fontWeight  = "bold";
		if(prevRefPackage != null)
			prevRefPackage.style.fontWeight  = "";
	}
	prevRefPackage = obj;

	var objForm = $(packageId+'refFormTr');
	if(prevRefForm != objForm) {
		objForm.show();
		if(prevRefForm != null)
			prevRefForm.hide();
	}
	prevRefForm = objForm;
	
	var params = new Array();
	params.push("method=getPackageInfo");
	params.push("userId=" + userId);
	params.push("userLanguage=" + defaultLanguage);
	params.push("packageId=" + packageId);
	params.push("compId=" + compId);
	params = params.join("&");
	request(getPath() + "/services/market/marketService.jsp", params, clickRefPackageCallBack, null, null, null, null);
}
function clickRefPackageCallBack() {
	var xmlDoc = getXmlDOM(getResult());
	var resultXml = SmartXMLUtil.getChildNode(xmlDoc, 'Result');
	if(resultXml.getAttribute('status') == 'OK') {
		var packageXml = SmartXMLUtil.getChildNode(resultXml, 'package');
		var categoryName = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(packageXml, 'categoryName'));
		var packageId = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(packageXml, 'packageId'));
		var packageName = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(packageXml, 'packageName'));
		var description = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(packageXml, 'description'));
		var packageTypeName = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(packageXml, 'packageTypeName'));
		var packageType = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(packageXml, 'packageType'));
		var description = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(packageXml, 'description'));
		var refPackageTable = $('refPackageTable');
		if(defaultLanguage=='ENG'){
			$('guideTitleTd').update("User Guide&nbsp;("+packageName+")");
		}else{
			$('guideTitleTd').update("사용자 가이드&nbsp;("+packageName+")");
		}
	}
}

function uploadBasket() {

	var warnMsg = "";
	var formName = document.getElementsByName("formNames");
	var formNames = "";
	if($F('name') == null || $F('name') == "")
		warnMsg = warnMsg + " 공유이름,";

	var description = document.shareBasketForm.description.value;
	if(description == null || description == "")
		warnMsg = warnMsg + " 업무설명 내용,";

	if($F('businessTypes') == null || $F('businessTypes') == "")
		warnMsg = warnMsg + " 업무설명 분류-업종별,";

	if($F('business') == null || $F('business') == "")
		warnMsg = warnMsg + " 업무설명 분류-업무별,";

	if($F('packageType') == "PROCESS") {
		var processGuideValue = "";

		for(var i=0; i<editorArrs.length; i++) {
			if(editorArrs[i][0] == 'processGuide') {
				if(editorArrs[i][1] == 'text') {
					processGuideValue = document.shareBasketForm.processGuide.value;
				} else {
					//processGuideValue = FCKeditorAPI.GetInstance ('processGuide').GetXHTML(true);
					oEditors.getById[editorArrs[i][0]].exec("UPDATE_IR_FIELD", []);
					processGuideValue = oEditors.getById[editorArrs[i][0]].getIR();
				}
			}
		}
		if(processGuideValue == null || processGuideValue == "")
			warnMsg = warnMsg + " 업무가이드 설명,";
	}

	for(var i=0; i<editorArrs.length; i++) {
		var formDescription = "";
		if(editorArrs[i][0].substring(0, 15) == 'formDescription') {
			if(editorArrs[i][1] == 'text') {
				formDescription = $F(editorArrs[i][0]);
			} else {
				//formDescription = FCKeditorAPI.GetInstance (editorArrs[i][0]).GetXHTML(true);
				oEditors.getById[editorArrs[i][0]].exec("UPDATE_IR_FIELD", []);
				formDescription = oEditors.getById[editorArrs[i][0]].getIR();
			}
			if(formDescription == null || formDescription == "") {
				warnMsg = warnMsg + " 업무가이드 설명,";
				$('formListTable').show();
				$('refPackageTd').hide();
				break;
			}
		}
	}

	if(warnMsg != "") {
		warnMsg = warnMsg.substring(1, warnMsg.length);
		warnMsg = warnMsg.substring(0, warnMsg.lastIndexOf(","));
		warnMsg = "(" + warnMsg + ")을 입력하세요.";
		warnMessage("Youdidnotentertherequireditems", warnMsg);
		return false;
	} else {
		confirmMessage('WouldYouLikeToApplyForShares', uploadBasketCallBack);
		//uploadBasketCallBack();
	}
}

function uploadBasketCallBack() {
	var refPkgNames = document.getElementsByName("refPackageName");
	var refNames = "";
	for(var i=0; i<refPkgNames.length; i++) {
		refNames = refNames + refPkgNames[i].value+"@@@";
	}

	var formId = document.getElementsByName("formIds");
	var formIds = "";
	for(var i=0; i<formId.length; i++) {
		formIds = formIds + formId[i].value+"@@@";
	}	

	var formName = document.getElementsByName("formNames");
	var formNames = "";
	
	for(var i=0; i<formName.length; i++) {
		formNames = formNames + formName[i].value+"@@@";
	}

	var description = document.shareBasketForm.description.value;
/*
	if(editorArrs[0][0] == 'description') {
		if(editorArrs[0][1] == 'text') {
			description = document.shareBasketForm.description.value;
		} else {
			//description = FCKeditorAPI.GetInstance ('description').GetXHTML(true);
			oEditors.getById[editorArrs[0][0]].exec("UPDATE_IR_FIELD", []);
			description = oEditors.getById[editorArrs[0][0]].getIR();
		}
	}
*/
	var formDescriptions = "";
	for(var i=0; i<editorArrs.length; i++) {
		var formDescription = "";
		if(editorArrs[i][0].substring(0, 15) == 'formDescription') {
			if(editorArrs[i][1] == 'text') {
				formDescription = $F(editorArrs[i][0]);
			} else {
				//formDescription = FCKeditorAPI.GetInstance (editorArrs[i][0]).GetXHTML(true);
				oEditors.getById[editorArrs[i][0]].exec("UPDATE_IR_FIELD", []);
				formDescription = oEditors.getById[editorArrs[i][0]].getIR();
			}
			formDescriptions = formDescriptions + formDescription+"@@@";
		}
	}

	var refFormIds = document.getElementsByName("refFormIds");
	var refFormId = "";
	for(var i=0; i<refFormIds.length; i++) {
		refFormId = refFormId + refFormIds[i].value+"@@@";
	}	

	var refFormNames = document.getElementsByName("refFormNames");
	var refFormName = "";
	for(var i=0; i<refFormNames.length; i++) {
		refFormName = refFormName + refFormNames[i].value+"@@@";
	}

	var refFormDescriptions = "";
	for(var i=0; i<editorArrs.length; i++) {
		var refFormDescription = "";
		if(editorArrs[i][0].substring(0, 18) == 'refFormDescription') {
			if(editorArrs[i][1] == 'text') {
				refFormDescription = $F(editorArrs[i][0]);
			} else {
				//refFormDescription = FCKeditorAPI.GetInstance(editorArrs[i][0]).GetXHTML(true);
				oEditors.getById[editorArrs[i][0]].exec("UPDATE_IR_FIELD", []);
				refFormDescription = oEditors.getById[editorArrs[i][0]].getIR();
			}
			refFormDescriptions = refFormDescriptions + refFormDescription+"&nbsp;@@@";
		}
	}

	var refPackageIds = document.getElementsByName("refPackageIds");
	var refPackageId = "";
	for(var i=0; i<refPackageIds.length; i++) {
		refPackageId = refPackageId + refPackageIds[i].value+"@@@";
	}	
	var params = new Array();
	params.push("packageIdArr=" + encodeURIComponent($F('packageId')+"@@@"));
	
	params.push("company=" + $F('company'));
	params.push("description=" + encodeURIComponent(description));
	params.push("name=" + encodeURIComponent($F('name')));
	params.push("packageType=" + $F('packageType'));
	params.push("processId=" + $F('processId'));
	params.push("formId=" + $F('formId'));
	params.push("business=" + $F('business'));
	params.push("businessTypes=" + $F('businessTypes'));

	if($F('packageType') == "PROCESS") {
		var processGuideValue = "";

		for(var i=0; i<editorArrs.length; i++) {
			if(editorArrs[i][0] == 'processGuide') {
				if(editorArrs[i][1] == 'text') {
					processGuideValue = document.shareBasketForm.processGuide.value;
				} else {
					//processGuideValue = FCKeditorAPI.GetInstance ('processGuide').GetXHTML(true);
					oEditors.getById[editorArrs[i][0]].exec("UPDATE_IR_FIELD", []);
					processGuideValue = oEditors.getById[editorArrs[i][0]].getIR();
				}
			}
		}
		params.push("processGuide=" + encodeURIComponent(processGuideValue));
	}
	params.push("formIds=" + formIds);
	params.push("formNames=" + encodeURIComponent(formNames));
	params.push("formDescriptions=" + encodeURIComponent(formDescriptions));
	params.push("refFormId=" + refFormId);
	params.push("refPackageId=" + refPackageId);
	params.push("refFormName=" + encodeURIComponent(refFormName));
	params.push("refFormDescription=" + encodeURIComponent(refFormDescriptions));
	params = params.join("&");
	$('refPkgNames').setAttribute("value", refNames);
	update("../shareBasket/shareBasketUpLoadPost.jsp", "tempTd", params, _uploadBasket, "", "");
}
function _uploadBasket() {
	document.shareBasketForm.target="uploadTarget";
	document.shareBasketForm.submit();
	notifyMessage('UPLOADBASKET', null, null, null);
}

function _uploadBasketCallBack(result) {

	if(result == "OK") {
		alertMessage('SharefinishedAppStore', 'SmartWorksnetcheckAppStore', locationReload); // 앱스토어에 공유하기 완료    ,  스마트웍스닷넷 앱스토어에서 확인하세요.
	} else {
		warnMessage('SharefailsAppStore', 'SmartWorksnetAppStoreuploadfailed', locationReload);  //앱스토어에 공유하기 실패  ,  스마트웍스닷넷 앱스토어로 업로드가 실패하였습니다.
	}
	
}

function locationReload(){
	location.reload();
}