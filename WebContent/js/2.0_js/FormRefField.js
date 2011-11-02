// mis.form.component.
FormRef = function(container, fieldXml, mode, formRuntime) {
	this.formFieldId = formRuntime.generateFieldIdByXml(fieldXml);
	this.formRuntime = formRuntime;
	
	var formatXml = SmartXMLUtil.getChildNode(fieldXml, 'format');
	
	var refFormXml = SmartXMLUtil.getChildNode(formatXml, 'refForm');
	var refFormFieldXml = SmartXMLUtil.getChildNode(refFormXml, 'field');
	var formFieldId = formRuntime.generateFieldIdByXml(fieldXml);
	
	this.refFormId = refFormXml.getAttribute('id');
	this.refFormVer = refFormXml.getAttribute('ver');
	this.refFormFieldId = refFormFieldXml.getAttribute('id');
	
	var div = document.createElement("div");
	div.id = formFieldId + "_refField_input";			
	Element.setStyle(div, {verticalAlign : "middle"});
	var html;		
	if (mode == 'hidden') {
		html = "<input class=\"formFieldContentsInput\" id=\"" + formFieldId + "_input\" type=\"hidden\" value=\"\"/>";
		html += "<img id=\"" + formFieldId + "_refField\" style=\"cursor:pointer;display:none;visible:hidden;\" src=\"" + FormEnv.formRefIcon + "\"></img>";
		html += "<input id=\"" + formFieldId + "_refField_value\" type=\"hidden\" value=\"\"/>";
	} else {
		html = "<table width='100%' border = 0 cellPadding = 0 cellSpacing = 0 class='formFieldInnerTable'>";
		html += "	<tr>";
		html += "		<td valign='middle' width='*'>";
		html += "			<input class=\"formFieldContentsInput formFieldCondValue\" id=\"" + formFieldId + "_input\" style=\"width:100%\" value=\"\" fieldId='" + fieldXml.getAttribute('id') + "' workspaceId='" + formRuntime.workspaceId + "'/>";
		html += "		</td>";
		html += "		<td style=\"\" width='5' ></td>";
		html += "		<td style=\"\" width='38px' >";
		html += "			<img id=\"" + formFieldId + "_refField\" style=\"cursor:pointer;vertical-align: middle;\" src=\"" + FormEnv.formRefIcon + "\" ></img>";
		html += "			<input id=\"" + formFieldId + "_refField_value\" type=\"hidden\" value=\"\"/>";
		html += "			<img src=\"../images/close.gif\" onclick=\"$('"+formFieldId+"_input').value='';$('"+formFieldId+"_refField_value').value='';\" style=\"cursor: pointer; vertical-align: middle;\"/>";
		html += "		</td>";
		html += "	</tr>";
		html += "</table>";
	}
	div.innerHTML = html;
	container.appendChild(div);
	
	this.valueField = $(formFieldId + "_refField_value");
	this.nameField = $(formFieldId + "_input");
	this.btnField = $(formFieldId + "_refField");
	this.btnField['ref'] = this;
	
	this.input = jQuery("#" + this.formFieldId + "_input");
	this.input.data("field", this);
	
	this.getValue = function(){
		return this.valueField.value;
	};
	this.setValue = function(value) {
		this.valueField.value = value;
	};
	this.getName = function(){
		return this.nameField.value;
	};
	this.setName = function(name){
		this.nameField.value = name;
		MisFormUtil.checkValidate(this.nameField.id);
	};

	this.openRefWindow = function(id) {
		if (Mis.isNull(this.refFormId) || Mis.isNull(this.refFormFieldId)) {
			warnMessage("errorCodeNotConfiguredFormLink", "askAdmin");
			return;
		}
			var url = getPath() + "/common/referenceTaskList.jsp";
			var params = '?formId=' + this.refFormId + '&fieldId=' + this.refFormFieldId + '&formFieldId=' + id + '&mode=form';
			popupModalDialog(url, params);
			
		//window.open('../common/referenceTaskList.jsp?formId=' + this.refFormId + '&fieldId=' + this.refFormFieldId + '&formFieldId=' + id + '&mode=form', '', 'width=650, height=500, scrollbars=auto,resizable=yes');		
	};
	Element.observe(this.btnField, 'click', function(e){
		e.target['ref'].openRefWindow(e.target.id);
	});
	
	this.input.change(function(event) {
		var input = jQuery("#" + event.target.id);
		var field = input.data("field");
		field.setValue("");
	});
};

/*
var FormRefUtil = {
	getFormRefByUid : function(uid){		
		return FormRefUtil.getFormRefByRefFieldId(uid + "_refField");
	},
	getFormRefByRefFieldId : function(id){
		var formFieldBtn = $(id);
		if(formFieldBtn != null & formFieldBtn != "undefined"){
			return formFieldBtn['ref'];
		}
		return null;
	},
	init : function(id, refFormId, refFormVer, recordId){
		var formWork = new FormWork(id);
		$(id)['formWork'] = formWork;
		formWork.initFormRuntime(FormEnv.userId, FormEnv.serviceUrl, refFormId, refFormVer, '', recordId, '2', 'view');
	}
};
*/