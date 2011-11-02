FormFileField = function(contentsContainer, formEntityXml, mode, formRuntime, contentWidth, formatType, fitToScreen){
	this.mode = mode;
	// save info
	this.modelXml = formEntityXml;
	this.formFieldId = formRuntime.generateFieldIdByXml(formEntityXml);
	var formatXml = SmartXMLUtil.getChildNode(formEntityXml, 'format');
  	var formatType = formatXml.getAttribute('type');
	
	this.fileuploadForm = null;
	try{
	var contentsDivContainer = new Element("div");
	contentsDivContainer.id = this.formFieldId + "_fileuploadDiv";			
	//Element.setStyle(contentsDivContainer, {verticalAlign : "top", position: "relative"});
	Element.setStyle(contentsContainer, {verticalAlign : "top"});
//	Element.setStyle(contentsContainer, {width : contentWidth + "px"});

	var fileFieldContentsHTML = "";		

	fileFieldContentsHTML += "<table id=\"" + this.formFieldId + "_fileList\" class=\"fileListTable\" border = 0 cellPadding = 0 cellSpacing = 0>";
	if(mode == 'hidden'){	
		fileFieldContentsHTML += "	<tr class=\"fileListTableHeader fileListTableRow\">";
		fileFieldContentsHTML += "		<td class=\"fileListTableNormal fileListTableCol\" colspan=\"3\">" + FormLang.fileFieldNoFile + "</td>";
		fileFieldContentsHTML += "	</tr>";
	}
	fileFieldContentsHTML += "</table>";
		
	new Insertion.Bottom(contentsDivContainer, fileFieldContentsHTML);

	// add to parent html element 
	contentsContainer.appendChild(contentsDivContainer);
	
		if(mode != 'hidden'){	
			var fileuploadForm = new Element("form");
			fileuploadForm.id = this.formFieldId + "_fileuploadForm";
			fileuploadForm.action = "/smartserver/services/portal/documentService.jsp?method=createFileXml&userId=" + FormEnv.userId;
			fileuploadForm.method = "post";
			fileuploadForm.encoding = "multipart/form-data";
	
			var uploadEle = new Element('input', {type : "file"});
			uploadEle.id = this.formFieldId + "_upload";
			
			if (formatType === 'imageBox') {
				uploadEle.size = '1';
				uploadEle.addClassName("fileInputImage");
			} else {
				uploadEle.addClassName("fileInput");
				uploadEle.size = "30";
			}
			uploadEle.addClassName("formFileFieldInput");
			
			fileuploadForm.setStyle({margin: "0px", padding: "0px", border : "0px"});
			
			uploadEle.setAttribute("fieldId", this.modelXml.getAttribute('id'));
			uploadEle.setAttribute("workspaceId", formRuntime.workspaceId);
	
			uploadEle.name = "upload";
			Element.setStyle(uploadEle, {width : "100%"});
			
			fileuploadForm.appendChild(uploadEle);
			contentsDivContainer.appendChild(fileuploadForm);
			this.fileuploadForm = fileuploadForm;
		}	
	}catch(e){
		alert(e.message);
	}
	// html component save
	contentsDivContainer['file'] = this;

	this.groupId = "";
	
	// upload event
	this.upload = function(fieldId) {
		FormFileFieldUtil.currentFieldId = fieldId;
		davidjc.AjaxFileUpload.initialise(this.doBeforeUpload, this.doAfterUpload, fieldId);
	}
	
	this.doBeforeUpload = function() {
		// document.getElementById("ajaxFileUploadForm_upload").disabled = true;
	};
		
	this.doAfterUpload = function (success, data) {
		if (success) {
			var result = SmartXMLUtil.getChildNode(data, 'Result');
			if(result.getAttribute('status') == 'OK'){
				var item = SmartXMLUtil.getChildNode(result, 'item');
				var formFileFieldObj = document.getElementById(FormFileFieldUtil.currentFieldId + "_fileuploadDiv")["file"];
				//alert('groupId : ' + item.getAttribute("groupId"));
				formFileFieldObj.setName(item.getAttribute("groupId"));
				formFileFieldObj.setValue(item.getAttribute("groupId"));
				document.getElementById(formFileFieldObj.formFieldId + "_fileuploadForm").action = "/smartserver/services/portal/documentService.jsp?method=createFileXml&userId=" + FormEnv.userId+ "&groupId=" + formFileFieldObj.groupId;
				document.getElementById(formFileFieldObj.formFieldId + "_fileuploadForm").innerHTML = "";
				
				var uploadEle = new Element('input', {type : "file"});
				uploadEle.id = formFileFieldObj.formFieldId + "_upload";
				if (formatType === 'imageBox') {
					uploadEle.size = '1';
					uploadEle.addClassName("fileInputImage");
				} else {
					//jk
					uploadEle.size = "30";
					uploadEle.addClassName("fileInput");
				}
				uploadEle.addClassName("formFileFieldInput");
				
				uploadEle.name = "upload";
				Element.setStyle(uploadEle, {width : "100%"});
				
				document.getElementById(formFileFieldObj.formFieldId + "_fileuploadForm").appendChild(uploadEle);
				document.getElementById(formFileFieldObj.formFieldId + "_fileuploadForm").reset();
				// formFileFieldObj.loadDocumnetInfo(formFileFieldObj.formFieldId);
			} else {
			}
		}
	};	
	

	
	// form ref value return  
	this.getValue = function(){
		return this.groupId;
	};
	// form ref name return 
	this.getName = function(){
		return this.groupId;
	};
	// form ref value set  
	this.setValue = function(value){
		this.groupId = value;
		if(this.fileuploadForm != null)
			this.fileuploadForm.action = "/smartserver/services/portal/documentService.jsp?method=createFileXml&userId=" + FormEnv.userId + "&groupId=" + this.groupId;
	};
	
	// form ref name set
	this.setName = function(name){
		this.groupId = name;
		this.loadDocumnetInfo(this.formFieldId);
	};

	this.loadDocumnetInfo = function(fieldId) {
		if(this.groupId != ""){
			new Ajax.Request("/smartserver/services/portal/documentService.jsp?method=findFileGroup&userId=" + FormEnv.userId + "&groupId=" + this.groupId, {
			  method: 'get',
			  onSuccess: function(transport) {
				var fieldId = transport.request.options['fieldId'];
				var fileTable = $(fieldId + "_fileList");
				while(fileTable.rows.length > 0){
					fileTable.deleteRow(fileTable.rows.length - 1);
				}
					  
			  	var resultXml = transport.responseXML;
			  	var result = SmartXMLUtil.getChildNode(resultXml, 'Result');
			    
			    var fileFieldContentsHTML = "";

			    new Insertion.Bottom(fileTable,fileFieldContentsHTML);
	
			    if(result.getAttribute('status') == 'OK'){
					if(result.getAttribute('totalCount') == "0"){
						var formFileFieldObj = document.getElementById(FormFileFieldUtil.currentFieldId + "_fileuploadDiv")["file"];
						formFileFieldObj.setName("");
						formFileFieldObj.setValue("");
						if(mode == 'hidden'){	
				    		new Insertion.Bottom($(fieldId + "_fileList"), "<td class=\"fileListTableNormal fileListTableCol\" colspan=\"3\" align=\"center\">" + FormLang.fileFieldNoFile + "</td>");
				    	}
				    }else{
						var fileXmls = SmartXMLUtil.getChildNodes(result, 'File');
						for(var i = 0 ; i < fileXmls.length ; i++){
							try{
								transport.request.options['fileField'].makeFileRow(fileXmls[i], fieldId, fileTable.insertRow(-1));
								//jk
							}catch(e){
								//alert(e);
							}
						}
				    }
				}else{
					new Insertion.Bottom($(fieldId + "_fileList"), "<td class=\"fileListTableHeaderSpecial fileListTableCol\" colspan=\"3\">" + FormLang.fileFieldErrorService + "</td>");
				}
				
			  },
			  onFailure: function(e){
			  	//alert(e.message);
			  },
			  onException : function(e){
			  	//alert(e.message);
			  },
			  fieldId : fieldId,
			  fileField : this
			});
		}
	};

	this.makeFileRow = function(fileXml, fieldId, row){
		var fileId = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(fileXml, 'id'));
		var fileName = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(fileXml, 'fileName'));
		var fileType = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(fileXml, 'fileType'));
		var size = this.makeSizeString(parseInt(SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(fileXml, 'fileSize'))));
		var filePath = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(fileXml, 'filePath'));

		var nameTd = row.insertCell(row.cells.length);
		nameTd.setAttribute("class", "fileListTableNomal fileListTableCol fileListName");
		row.appendChild(nameTd);

		var newItem = document.createElement("div");
		newItem.setAttribute("style", "margin-top:5px;");

		if (formatType === 'imageBox') {
			nameTd.innerHTML = "<img id='" + fieldId + "_img' width='100%' vspace='6' src='/smartserver/servlet/download?fileId=" + fileId + "&userId=" + FormEnv.userId + "'>";
			var originWidth = $(fieldId + "_img").width;
			var imageWidth = 0;
			if (fitToScreen) {    //화면에 맞춤
				imageWidth = contentWidth-12;
			} else {              
				if (originWidth <= contentWidth-12) {
					if (originWidth <= 28) {
						imageWidth = contentWidth-12;
					} else {
						imageWidth = originWidth;
					}
				} else {
					imageWidth = contentWidth-12;
				}
			}
			$(fieldId + "_img").width = imageWidth;
		} else {
			//var nameA = new Element("a", {href : "/smartserver/servlet/download?fileId=" + fileId + "&userId=" + FormEnv.userId}).update(fileName + '&nbsp;[' + size + ']');
			var extension = this.getFileExtension(fileName);
			var imgSrc = this.getExtensionImage(extension);

			var nameA = '<img src=/smartserver/images/icon/fileImage/icon_'+ imgSrc + ' style="vertical-align:top;"> ' + '<a href=/smartserver/servlet/download?fileId=' + fileId + '&userId=' + FormEnv.userId + '>' + fileName + '</a>' + '&nbsp;[' + size + ']';

			newItem.innerHTML = nameA;
			nameTd.appendChild(newItem);
			var docSpace;
			var fileInputDiv = document.getElementById(this.formFieldId+"FileInput");
			var fileuploadDiv = document.getElementById(this.formFieldId+"_fileuploadDiv");
			var id = this.formFieldId.substr(0,32);
			var spaceHeight;
			var fileListHeight = document.getElementById(this.formFieldId+'_fileList').offsetHeight;
			try{
				if(fileInputDiv!=null)
					fileInputDiv.style.height = (fileuploadDiv.offsetHeight)+'px';
				try{
					//docSpace.style.height = (spaceHeight+fileListHeight)+'px';
					//jk
					//docSpace.style.height = $('workspace_docSpace').offsetHeight + 12+'px';
					var formFieldsRowId = $(this.formFieldId+"_innerTd").getAttribute('formFieldsRowId');
					var formFieldsRowIds = $(formFieldsRowId).childNodes;
					for(var ii = 0 ; ii < formFieldsRowIds.length; ii++){
						var fieldIdx = formFieldsRowIds[ii].getAttribute('fieldId');
						$(fieldIdx+"_label").style.height = $(formFieldsRowId).offsetHeight;
					}
					try{
						if(historyTaskId != '') {
							$(historyTaskId+"FormTd_docSpace").style.height = $(historyTaskId+"FormTd_formFieldsSpace").offsetHeight -12;
						} else {
							docSpace = document.getElementById('workspace_docSpace');
							spaceHeight = document.getElementById('workspace_formFieldsSpace').offsetHeight-12;
							docSpace.style.height = spaceHeight+'px';
						}
					}catch(e){}
					
				}catch(e){
					spaceHeight = document.getElementById(id+'HistoryTd').offsetHeight;
					document.getElementById(id+'HistoryTd').style.height = (spaceHeight+15)+'px';
					document.getElementById(id+'HistoryTd').style.marginTop = '0px';
					document.getElementById(id+'HistoryTd').style.verticalAlign = '0px';
				}
			}catch(e){
				//alert(e);
			}
		}
	
		if(this.mode != 'hidden'){	
			var removeBtn;
			if (formatType === 'imageBox') {
				removeBtn = new Element("img", {name : fieldId, src : "/smartserver/image/form/close.gif", width : "12px", height : "12px", vspace : "6" });
			} else {
				removeBtn = new Element("img", {name : fieldId, src : "/smartserver/image/form/close.gif", width : "12px", height : "12px"});
			}
					
			if (formatType === 'imageBox') {
				$(fieldId + "_upload").style.display = 'none';
			} else {
				nameTd.appendChild(document.createTextNode(' '));
			}
						
			/*removeTd.appendChild(removeBtn);	*/
			removeBtn.addClassName("formFileFieldRemoveBtn");

			newItem.appendChild(removeBtn);

			nameTd.appendChild(newItem);

			removeBtn["fileId"] = fileId;
			removeBtn["fieldId"] = fieldId;
		}
		return row;
	};
	this.makeSizeString = function(size){
		var sizeStr = "";
		
		if(size > 1000000000 ){
			sizeStr = parseInt(size / 1000000000) + "GB";
		}else if(size > 1000000){
			sizeStr = parseInt(size / 1000000) + "MB";
		}else if(size > 1000){
			sizeStr = parseInt(size / 1000) + "KB";
		}else{
			sizeStr = size + "byte";
		}
		return sizeStr;
	};
	
	this.removeFile = function(fileId, fieldId){
		var url = "/smartserver/services/portal/documentService.jsp?method=deleteFile&userId=" + FormEnv.userId + "&fileId=" + fileId;
		new Ajax.Request(url, {
			  method: 'get',
			  onSuccess: function(transport) {
				var resultXml = transport.responseXML;
			  	var result = SmartXMLUtil.getChildNode(resultXml, 'Result');
			    
			    if(result.getAttribute('status') == 'OK'){
				}else{
				}
				transport.request.options['fileField'].loadDocumnetInfo(transport.request.options['fieldId']);
				var fileInputDiv = document.getElementById(fieldId+"FileInput");
				fileInputDiv.style.height = fileInputDiv.offsetHeight - 12 +'px';
				$('workspace_docSpace').style.height = $('workspace_docSpace').offsetHeight - 12+'px';
				
				var formFieldsRowId = $(fieldId+"_innerTd").getAttribute('formFieldsRowId');
				var formFieldsRowIds = $(formFieldsRowId).childNodes;
				for(var ii = 0 ; ii < formFieldsRowIds.length; ii++){
					var fieldIdx = formFieldsRowIds[ii].getAttribute('fieldId');
					$(fieldIdx+"_label").style.height = fileInputDiv.offsetHeight - 12 +'px';
				}
				
				
			  },
			  onFailure: function(e){
			  	//alert(e.message);
			  },
			  onException : function(e){
			  	//alert(e.message);
			  },
			  fieldId : fieldId,
			  fileField : this
			});
	};
	
};

var FormFileFieldUtil = {
	currentFieldId : null,
	getFormFileByUid : function(uid){		
		return FormFileFieldUtil.getFormFileByFieldId(uid + "_fileuploadDiv");
	},
	getFormFileByFieldId : function(id){
		var formFileField = $(id);
		if(formFileField != null & formFileField != "undefined"){
			return formFileField['file'];
		}
		return null;
	}
};

Event.addBehavior.reassignAfterAjax = true;

Event.addBehavior({
  ".formFileFieldRemoveBtn:click" : function(e) {
  	var formField = FormFileFieldUtil.getFormFileByUid(e.target.name);
	formField.removeFile(e.target["fileId"], e.target["fieldId"]);
	$(e.target["fieldId"] + "_upload").style.display = 'block';
  },
  ".formFileFieldInput:change" : function(e) {
	var fileObj = e.srcElement || e.target;
	var filePath = fileObj.value;
	var fileType = filePath.substring(filePath.lastIndexOf('.')+1, filePath.length).toUpperCase();
	if (fileObj.size === 1) {   //formatType : imageBox (gif, jpg only)
		if (!(fileType === 'GIF' || fileType === 'JPG' || fileType === 'JPEG')) { 
			warnMessage('errorCodeinvalidImage', 'INPUT_VALIDIMAGE');
			return;
		}
	}
	
	var fieldId = e.target.id.substr(0, e.target.id.length - 7);
	document.getElementById(fieldId + "_fileuploadDiv")['file'].upload(fieldId);
  }
});                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             