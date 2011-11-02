/*--------------------------------------------------|

| dTree 2.05 | www.destroydrop.com/javascript/tree/ |

|---------------------------------------------------|

| Copyright (c) 2002-2003 Geir Landr\uFFFD          |

|                                                   |

| This script can be used freely as long as all     |

| copyright messages are intact.                    |

|                                                   |

| Updated: 17.04.2003                               |

|--------------------------------------------------*/


// Node object
function Node(id, pid, name, url, title, target, icon, iconOpen, open, objId, packageType, key, catId) {

	//jk yoon key 추가 catId 추가
	this.key = key;
	
	this.catId = catId;
	
	this.id = id;

	this.pid = pid;

	this.name = name;

	this.url = url;

	this.title = title;

	this.target = target;

	this.icon = icon;

	this.iconOpen = iconOpen;

	this._io = open || false;

	this._is = false;

	this._ls = false;

	this._hc = false;

	this._ai = 0;

	this._p;
	this.objId = objId;
	this.packageType = packageType;

};
// Tree object
function dTree(objName, imgRoot, baseImg, objArea, param) {
	this.param = param;
	this.config = {

		target				: null,

		folderLinks			: true,

		useSelection		: true,

		useCookies			: true,

		useLines			: false,

		useIcons			: true,

		useStatusText		: false,

		closeSameLevel		: false,

		inOrder				: false

	};

	this.icon = {

		root				: baseImg || imgRoot + '/dtree/base.gif',

		folder				: imgRoot + '/dtree/folder.gif',

		folderOpen			: imgRoot + '/dtree/folderopen.gif',

		node				: imgRoot + '/dtree/page.gif',

		empty				: imgRoot + '/dtree/empty.gif',

		line				: imgRoot + '/dtree/line.gif',

		join				: imgRoot + '/dtree/join.gif',

		joinBottom			: imgRoot + '/dtree/joinbottom.gif',

		plus				: imgRoot + '/dtree/plus.gif',

		plusBottom			: imgRoot + '/dtree/plusbottom.gif',

		minus				: imgRoot + '/dtree/minus.gif',

		minusBottom			: imgRoot + '/dtree/minusbottom.gif',

		nlPlus				: imgRoot + '/dtree/nolines_plus.gif',

		nlMinus				: imgRoot + '/dtree/nolines_minus.gif'

	};

	this.obj = objName;
	
	this.aNodes = [];
	
	this.aIndent = [];
	
	this.root = new Node(-1);
	
	this.selectedNode = null;
	
	this.selectedFound = false;
	
	this.completed = false;
	
	this.area = objArea || '';

};



// Adds a new node to the node array key 추가
dTree.prototype.add = function(id, pid, name, url, title, target, icon, iconOpen, open, objId, packageType, key, catId) {
	//alert(id+"//"+pid+"//"+name+"//"+url+"//"+title+"//"+target+"//"+icon+"//"+iconOpen+"//"+open);
	this.aNodes[this.aNodes.length] = new Node(id, pid, name, url, title, target, icon, iconOpen, open, objId, packageType, key, catId);

};



// Open/close all nodes
dTree.prototype.openAll = function() {

	this.oAll(true);

};

dTree.prototype.closeAll = function() {

	this.oAll(false);

};



// Outputs the tree to the page
dTree.prototype.toString = function() {

	var str = '<div class="dtree">\n';

	if (document.getElementById) {

		if (this.config.useCookies) this.selectedNode = this.getSelected();

		str += this.addNode(this.root);

	} else str += 'Browser not supported.';

	str += '</div>';

	if (!this.selectedFound) this.selectedNode = null;

	this.completed = true;
	return str;

};



// Creates the tree structure
dTree.prototype.addNode = function(pNode) {

	var str = '';

	var n=0;

	if (this.config.inOrder) n = pNode._ai;

	for (n; n<this.aNodes.length; n++) {

		if (this.aNodes[n].pid == pNode.id) {

			var cn = this.aNodes[n];

			cn._p = pNode;

			cn._ai = n;

			this.setCS(cn);

			if (!cn.target && this.config.target) cn.target = this.config.target;

			if (cn._hc && !cn._io && this.config.useCookies) cn._io = this.isOpen(cn.id);

			if (!this.config.folderLinks && cn._hc) cn.url = null;

			if (this.config.useSelection && cn.id == this.selectedNode && !this.selectedFound) {

					cn._is = true;

					this.selectedNode = n;

					this.selectedFound = true;

			}

			str += this.node(cn, n);

			if (cn._ls) break;

		}

	}
	return str;

};



// Creates the node icon, url and text 트리 그리는 부분.
dTree.prototype.node = function(node, nodeId) {

	var str = '<div class="dTreeNode">' + this.indent(node, nodeId);
	if (this.config.useIcons) {

		if (!node.icon) node.icon = (this.root.id == node.pid) ? this.icon.root : ((node._hc) ? this.icon.folder : this.icon.node);

		if (!node.iconOpen) node.iconOpen = (node._hc) ? this.icon.folderOpen : this.icon.node;

		if (this.root.id == node.pid) {

			node.icon = this.icon.root;

			node.iconOpen = this.icon.root;

		}

		//jk yoon
		
			var arrayImg = ['../images/body/ico_color_process.gif','../images/body/ico_color_info.gif','../images/body/ico_color_schedule.gif'];
			var tflag = false;
			for(var ii = 0; ii < arrayImg.length; ii++){
				if(node.icon==arrayImg[ii]){
					tflag = true;
					break;
				}
			}
			//alert(tflag);
			//alert(tflag+"///"+arrayImg[0]+"///"+arrayImg[1]+"///"+node.icon+"///"+node.key);
			if(this.area =='selectMemberTreeList'){
				var paramValue=node.icon+","+node.id+","+node.name;
				//alert(this.param);
				if(this.param!=="" && this.param!==undefined){
					var pr = this.param.split(";");
					for(var idx = 0; idx<pr.length;idx++){
						//alert(pr[idx]+"///"+node.id);
						if(pr[idx]===node.id){
							checked = "checked";
							break;
						}
					}
				}
				//alert(paramValue);
				str += '<input type="checkbox"  name="dtreeCheck" '+checked+' value="'+paramValue+'" style="vertical-align: middle;" onclick="checkChild(\''+node.id+'\')"/>';
			}else{
				if(tflag){
					if(node.key=="" || node.key ==undefined || node.key =="undefined"){node.key = "GARBAGE";}
					
					if(node.catId=="" || node.catId==undefined || node.catId == "undefined"){node.catId="NO";}
					
					var paramValue = node.pid+","+node.objId+","+node.packageType+","+node.name+","+node.key+","+node.catId+","+node.id;
					//alert(paramValue);
					var checked = "";
					//alert(node.key);
					//alert(this.param);
					//alert(node.objId+"////"+node.url);
					if(this.param!=="" && this.param!==undefined){
						var pr = this.param.split(",");
						for(var idx = 0; idx<pr.length;idx++){
							if(pr[idx]===node.objId){
								checked = "checked";
								break;
							}
						}
					
						str += '<input type="checkbox" id="dtreeCheck" name="dtreeCheck" '+checked+' value="'+paramValue+'" style="vertical-align: middle;"/>';
					}
					//alert(node.id);
				}
			}
			
			str += '<img id="i' + this.obj + nodeId + '" src="' + ((node._io) ? node.iconOpen : node.icon) + '" alt="" /> ';
			
	}

	if (node.url) {
		//alert(node.url);
		if(node.url != 'javascript:'){
			str += '<a id="s' + this.obj + nodeId + '" class="' + ((this.config.useSelection) ? ((node._is ? 'nodeSel' : 'node')) : 'node') + '" href="' + node.url + '"';
		}else{
			str += '<a id="s' + this.obj + nodeId + '" class="' + ((this.config.useSelection) ? ((node._is ? 'nodeSel' : 'node')) : 'node') + '" href="javascript:' + this.obj + '.o(' + nodeId + ');parent.parentIframeSize(\'' + this.area + '\');"';
		}
		if (node.title) str += ' title="' + node.title + '"';
		//if (node.title) str += ' onmouseover="ddrivetip(\'' + node.title + '\', \'#e8eafa\', 180);" onmouseout="hideddrivetip();"';

		if (node.target) str += ' target="' + node.target + '"';

		if (this.config.useStatusText) str += ' onmouseover="window.status=\'' + node.name + '\';return true;" onmouseout="window.status=\'\';return true;" ';

		if (this.config.useSelection && ((node._hc && this.config.folderLinks) || !node._hc))
			
			if (this.area === '') {
				//str += ' onclick="javascript: ' + this.obj + '.s(' + nodeId + ');"';
			} else {
				//str += ' onclick="javascript: ' + this.obj + '.s(' + nodeId + ');parent.parentIframeSize(\'' + this.area + '\');"';
			}
			
		str += '>';
		
	}

	else if ((!this.config.folderLinks || !node.url) && node._hc && node.pid != this.root.id)
		
		if (this.area === '') {
			str += '<a href="javascript: ' + this.obj + '.o(' + nodeId + ');" class="node">';
		} else {
			str += '<a href="javascript: ' + this.obj + '.o(' + nodeId + '); parent.parentIframeSize(\'' + this.area + '\');"';
		}
	str += node.name;
	
	if (node.url || ((!this.config.folderLinks || !node.url) && node._hc)) str += '</a>';
	
	str += '</div>';

	if (node._hc) {

		str += '<div id="d' + this.obj + nodeId + '" class="clip" style="display:' + ((this.root.id == node.pid || node._io) ? 'block' : 'none') + ';">';

		str += this.addNode(node);

		str += '</div>';

	}

	this.aIndent.pop();
	
	//alert(str);

	return str;

};



// Adds the empty and line icons
dTree.prototype.indent = function(node, nodeId) {

	var str = '';

	if (this.root.id != node.pid) {

		for (var n=0; n<this.aIndent.length; n++)

			str += '<img src="' + ( (this.aIndent[n] == 1 && this.config.useLines) ? this.icon.line : this.icon.empty ) + '" alt="" />';
			
		(node._ls) ? this.aIndent.push(0) : this.aIndent.push(1);

		if (node._hc) {
			
			if (this.area === '') {
				str += '<a href="javascript: ' + this.obj + '.o(' + nodeId + ');"><img id="j' + this.obj + nodeId + '" src="';
			} else {
				str += '<a href="javascript: ' + this.obj + '.o(' + nodeId + ');parent.parentIframeSize(\'' + this.area + '\');"><img id="j' + this.obj + nodeId + '" src="';
			}

			if (!this.config.useLines) str += (node._io) ? this.icon.nlMinus : this.icon.nlPlus;

			else str += ( (node._io) ? ((node._ls && this.config.useLines) ? this.icon.minusBottom : this.icon.minus) : ((node._ls && this.config.useLines) ? this.icon.plusBottom : this.icon.plus ) );
			//jk yoon
			str += '" alt="" onfocus="this.blur()" /></a>';

		} else str += '<img src="' + ( (this.config.useLines) ? ((node._ls) ? this.icon.joinBottom : this.icon.join ) : this.icon.empty) + '" alt="" />';
	}
	return str;

};



// Checks if a node has any children and if it is the last sibling
dTree.prototype.setCS = function(node) {

	var lastId;

	for (var n=0; n<this.aNodes.length; n++) {

		if (this.aNodes[n].pid == node.id) node._hc = true;

		if (this.aNodes[n].pid == node.pid) lastId = this.aNodes[n].id;

	}

	if (lastId==node.id) node._ls = true;

};



// Returns the selected node
dTree.prototype.getSelected = function() {

	var sn = this.getCookie('cs' + this.obj);

	return (sn) ? sn : null;

};



// Highlights the selected node
dTree.prototype.s = function(id) {

	if (!this.config.useSelection) return;

	var cn = this.aNodes[id];

	if (cn._hc && !this.config.folderLinks) return;

	if (this.selectedNode != id) {

		if (this.selectedNode || this.selectedNode==0) {

			eOld = document.getElementById("s" + this.obj + this.selectedNode);

			eOld.className = "node";

		}

		eNew = document.getElementById("s" + this.obj + id);

		eNew.className = "nodeSel";

		this.selectedNode = id;

		if (this.config.useCookies) this.setCookie('cs' + this.obj, cn.id);

	}

};



// Toggle Open or close
dTree.prototype.o = function(id) {

	var cn = this.aNodes[id];

	this.nodeStatus(!cn._io, id, cn._ls);

	cn._io = !cn._io;

	if (this.config.closeSameLevel) this.closeLevel(cn);

	if (this.config.useCookies) this.updateCookie();

};



// Open or close all nodes
dTree.prototype.oAll = function(status) {

	for (var n=0; n<this.aNodes.length; n++) {

		if (this.aNodes[n]._hc && this.aNodes[n].pid != this.root.id) {

			this.nodeStatus(status, n, this.aNodes[n]._ls)

			this.aNodes[n]._io = status;

		}
		//parent.parentIframeSize(\'' + this.area + '\');
	}

	if (this.config.useCookies) this.updateCookie();
	
};



// Opens the tree to a specific node
dTree.prototype.openTo = function(nId, bSelect, bFirst) {

	if (!bFirst) {

		for (var n=0; n<this.aNodes.length; n++) {

			if (this.aNodes[n].id == nId) {

				nId=n;

				break;

			}

		}

	}

	var cn=this.aNodes[nId];

	if (cn.pid==this.root.id || !cn._p) return;

	cn._io = true;

	cn._is = bSelect;

	if (this.completed && cn._hc) this.nodeStatus(true, cn._ai, cn._ls);

	if (this.completed && bSelect) this.s(cn._ai);

	else if (bSelect) this._sn=cn._ai;

	this.openTo(cn._p._ai, false, true);
	//parent.parentIframeSize(\'' + this.area + '\');
};



// Closes all nodes on the same level as certain node
dTree.prototype.closeLevel = function(node) {

	for (var n=0; n<this.aNodes.length; n++) {

		if (this.aNodes[n].pid == node.pid && this.aNodes[n].id != node.id && this.aNodes[n]._hc) {

			this.nodeStatus(false, n, this.aNodes[n]._ls);

			this.aNodes[n]._io = false;

			this.closeAllChildren(this.aNodes[n]);

		}

	}
	
}



// Closes all children of a node
dTree.prototype.closeAllChildren = function(node) {

	for (var n=0; n<this.aNodes.length; n++) {

		if (this.aNodes[n].pid == node.id && this.aNodes[n]._hc) {

			if (this.aNodes[n]._io) this.nodeStatus(false, n, this.aNodes[n]._ls);

			this.aNodes[n]._io = false;

			this.closeAllChildren(this.aNodes[n]);

		}

	}

}



// Change the status of a node(open or closed)
dTree.prototype.nodeStatus = function(status, id, bottom) {

	eDiv	= document.getElementById('d' + this.obj + id);

	eJoin	= document.getElementById('j' + this.obj + id);
	//alert(this.obj + id+"//"+eJoin);
	if (this.config.useIcons) {

		eIcon	= document.getElementById('i' + this.obj + id);

		eIcon.src = (status) ? this.aNodes[id].iconOpen : this.aNodes[id].icon;

	}

	eJoin.src = (this.config.useLines)?

	((status)?((bottom)?this.icon.minusBottom:this.icon.minus):((bottom)?this.icon.plusBottom:this.icon.plus)):

	((status)?this.icon.nlMinus:this.icon.nlPlus);

	eDiv.style.display = (status) ? 'block': 'none';
	
};





// [Cookie] Clears a cookie
dTree.prototype.clearCookie = function() {

	var now = new Date();

	var yesterday = new Date(now.getTime() - 1000 * 60 * 60 * 24);

	this.setCookie('co'+this.obj, 'cookieValue', yesterday);

	this.setCookie('cs'+this.obj, 'cookieValue', yesterday);

};



// [Cookie] Sets value in a cookie
dTree.prototype.setCookie = function(cookieName, cookieValue, expires, path, domain, secure) {

	document.cookie =

		escape(cookieName) + '=' + escape(cookieValue)

		+ (expires ? '; expires=' + expires.toGMTString() : '')

		+ (path ? '; path=' + path : '')

		+ (domain ? '; domain=' + domain : '')

		+ (secure ? '; secure' : '');

};



// [Cookie] Gets a value from a cookie
dTree.prototype.getCookie = function(cookieName) {

	var cookieValue = '';

	var posName = document.cookie.indexOf(escape(cookieName) + '=');

	if (posName != -1) {

		var posValue = posName + (escape(cookieName) + '=').length;

		var endPos = document.cookie.indexOf(';', posValue);

		if (endPos != -1) cookieValue = unescape(document.cookie.substring(posValue, endPos));

		else cookieValue = unescape(document.cookie.substring(posValue));

	}

	return (cookieValue);

};



// [Cookie] Returns ids of open nodes as a string
dTree.prototype.updateCookie = function() {

	var str = '';

	for (var n=0; n<this.aNodes.length; n++) {

		if (this.aNodes[n]._io && this.aNodes[n].pid != this.root.id) {

			if (str) str += '.';

			str += this.aNodes[n].id;

		}

	}

	this.setCookie('co' + this.obj, str);

};



// [Cookie] Checks if a node id is in a cookie
dTree.prototype.isOpen = function(id) {

	var aOpen = this.getCookie('co' + this.obj).split('.');

	for (var n=0; n<aOpen.length; n++)

		if (aOpen[n] == id) return true;

	return false;

};



// If Push and pop is not implemented by the browser
if (!Array.prototype.push) {

	Array.prototype.push = function array_push() {

		for(var i=0;i<arguments.length;i++)

			this[this.length]=arguments[i];

		return this.length;

	}

};

if (!Array.prototype.pop) {

	Array.prototype.pop = function array_pop() {

		lastElement = this[this.length-1];

		this.length = Math.max(this.length-1,0);

		return lastElement;

	}

};

function parentLocationIndex(){
	parent.location.href='../main/index.jsp';
}

function setMenuControllCallBack(){
	//releaseModalDialog(false);
	parent.alertMessage('WorkRegistration', 'Workregistrationhasbeencompleted', parentLocationIndex); //업무등록  , 업무등록이 완료되었습니다.
	//alert("업무등록이 완료되었습니다.");
	//releaseModalDialog(true);
	//parent.location.href='../main/index.jsp';
}

//jk yoon  header menu controll


function setMenuControll(menuCnt){
	var check = document.treeForm.dtreeCheck;
	var params = "";
	if(check.length === undefined){
		if(check.checked===true){
			params += check.value;
		}
	}else{
		var j = 0;
		for(var i = 0; i < check.length; i++){
			if(check[i].checked===true){
				if(j!==0) params+=";";
				params += check[i].value;
				j++;
			}
		}
		if(j > menuCnt){
			parent.warnMessage('Warning', '추가 가능한 업무 갯수 는 '+menuCnt+'개 입니다.');
			//alert("최대 추가 업무 갯수를 초과하였습니다.");
			//alert('추가 가능한 업무 갯수 는 '+menuCnt+'개 입니다.');
			return false;
		}
	}
	if(params===""){
		if(check.length === undefined){
			params += check.value;
		}else{
			params += check[0].value;
		}
		var key = document.treeForm.key.value;
		params += ","+key+",";
		params += "DEL";
	}
	
		request(getPath() +"/main/topMenuControll.jsp","params="+params, setMenuControllCallBack);
};

var getMenuControll = function(){
	
};

function workSelect(objId, childFormId){
	var key = objId.substr(0,3);
	parent.toggleConfigMenuTree();

	var subject = parent.document.getElementById("subject").getAttribute("value");
	var workContentsT = parent.document.getElementById("workContentsT").innerHTML;
	var projectNameT = parent.document.getElementById("projectNameT").getAttribute("value");
	var isPublicT = parent.document.viewForm.isPublicT;
	var priorityT = parent.$F('priorityT');
	var isPublic = "";
	for(var i=0;i<isPublicT.length;i++){
		if(isPublicT[i].checked == true){
			isPublic = isPublicT[i].value;
			break;
		}
	}
	
	parent.saveCookie("subject",subject);
	parent.saveCookie("workContentsT",workContentsT);
	parent.saveCookie("projectNameT",projectNameT);
	parent.saveCookie("isPublicT",isPublic);
	parent.saveCookie("priorityT",priorityT);
	
	if(key == 'prc'){
		parent.document.getElementById("processId").setAttribute("value", objId);
		parent.document.getElementById("startFormId").setAttribute("value", childFormId);
		if(childFormId == 'GANTT'){
			parent.document.getElementById("pkgType").setAttribute("value", childFormId);
		}
		parent.createProcInst('PLAN');
	}else{
		parent.createRecord(objId, '../today/workStartPage.jsp','PLAN'); //, '../work/workStartIndex.jsp'
	}
}

function goWorkStartIndex(){
}

/**
 * 
 * @param ids		   
 * @param names		   
 * @param functionName  : 저장 버튼 클릭 후 사용할 functionName
 * @param classfication : 하루, 일주일, 한달 , 일년 구분 
 * @return
 */
function setMemberIds(ids, names, functionName, frameId, treeId, treeListId){
	var check = document.treeForm.dtreeCheck;
	var paramsId = "";
	var paramsName = "";
	if(check.length === undefined){
		if(check.checked===true){
			var temp = check.value;
			var tempArray = temp.split(",");
			paramsId += tempArray[1];
			if(frameId == undefined || frameId==''){
				paramsName += "<img src='"+tempArray[0]+"'/>"+tempArray[2];
			}else{
				paramsName += tempArray[2];
			}
			
		}
	}else{
		var j = 0;
		for(var i = 0; i < check.length; i++){
			if(check[i].checked===true){
				if(j!==0)paramsId+=";";
				var temp = check[i].value;
				var tempArray = temp.split(",");
				paramsId += tempArray[1];
				if(frameId == undefined || frameId==''){
					paramsName += " <img src='"+tempArray[0]+"'/>"+tempArray[2];
				}else{
					if(j!==0)paramsName+=";"
					paramsName += tempArray[2];
				}		
				j++;
			}
		}
	}
	//alert(ids+"//"+names+"//"+functionName+"//"+frameId+"//"+treeId+"//"+treeListId);
	if(frameId == undefined || frameId==''){
		parent.document.getElementById(ids).setAttribute("value", paramsId);
		parent.document.getElementById(names).innerHTML = paramsName;
		parent.toggleSelectMemberTree(ids,names,null,'0',treeId, treeListId);
		(new parent.Function(functionName+'('+"'1'"+');'))(); 
	}else{
		//parent.document.getElementById(frameId).setAttribute("src","../main/configCaster.jsp?ids="+encodeURIComponent(paramsId)+"&names=+"+encodeURIComponent(paramsName));
		parent.document.getElementById(ids).setAttribute("value",paramsId);
		parent.document.getElementById(names).innerHTML = paramsName;
		parent.toggleSelectMemberTree(ids,names,null,'0', treeId, treeListId);
		if(functionName != undefined || functionName != '')
			(new parent.Function(functionName+'('+"'1'"+');'))();
	}
}
 
function checkChild(id){
	//request("../services/portal/dTreeService.jsp","id="+id, checkChildCallback);
}
function checkChildCallback(){
	var xmlDoc = getXmlDOM(getResult());
	var resultXml = SmartXMLUtil.getChildNode(xmlDoc, 'Result');
	if (resultXml.getAttribute('status') == 'OK') {
		var totalIds = resultXml.getAttribute('ids');
	}
}
function noAction(){
	//<div><input type='checkBox' name='check' id='num1'><label for="num1">체크</label></div>
}