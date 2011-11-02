FormUser = function(contentsContainer, fieldXml, mode, formRuntime) {
	this.formFieldId = formRuntime.generateFieldIdByXml(fieldXml);
	this.formRuntime = formRuntime;
	
	var formatXml = SmartXMLUtil.getChildNode(fieldXml, 'format');
  	var formatType = formatXml.getAttribute('type');
	
	var div = document.createElement("div");
	div.id = formRuntime.generateFieldIdByXml(fieldXml) + "_userField_input";			
	Element.setStyle(div, {verticalAlign : "middle"});
	
	var formFieldUniqueId = formRuntime.generateFieldIdByXml(fieldXml);
	var html;
	if (mode == "hidden") {
		html  = "<input class=\"formFieldContentsInput\" id=\"" + formFieldUniqueId + "_input\" type=\"hidden\"  value=\"\" style=\"\"/>";
		html += "<img id=\"" + formFieldUniqueId + "_userField\" style=\"cursor:pointer;display:none;visible:hidden;\" src=\"" + FormEnv.userRefIcon + "\"></img>";
		html += "<input id=\"" + formFieldUniqueId + "_userField_value\" type=\"hidden\" value=\"\" style=\"\"/>";
	} else {
		html  = "<table width='100%' height=100% border = 0 cellPadding = 0 cellSpacing = 0 class='formFieldInnerTable' style='width:100%;height:100%'>";
		html += "	<tr>";
		html += "		<td valign='middle' width='*' >";
		html += "			<input class=\"formFieldContentsInput formFieldCondValue\" readOnly onKeyUp=\"javascript:lookupAjax(this.id)\" id=\"" + formFieldUniqueId + "_input\" style=\"width:100%\"  value=\"\" fieldId='" + fieldXml.getAttribute('id') + "' workspaceId='" + formRuntime.workspaceId + "'/>";
		html += "		</td>";
		html += "		<td style=\"\" width='5' ></td>";		
		html += "		<td width='38px' align='left'>";
		html += "			<img style=\"cursor:pointer;vertical-align:middle;\" src=\"" + FormEnv.userRefIcon + "\"  id=\"" + formFieldUniqueId + "_userField\"></img>";
		html += "			<input id=\"" + formFieldUniqueId + "_userField_value\" type=\"hidden\" value=\"\"/>";
		html += "			<img src=\"../images/close.gif\" onclick=\"$('"+formFieldUniqueId+"_input').value='';$('"+formFieldUniqueId+"_userField_value').value='';\" style=\"cursor: pointer; vertical-align: middle;\"/>";
		html += "		</td>";
		html += "	</tr>";
		html += "</table>";			
	}
	
	div.innerHTML = html;
	
	contentsContainer.appendChild(div);
	
	this.valueField = $(formFieldUniqueId + "_userField_value");
	this.nameField = $(formFieldUniqueId + "_input");
	this.btnField = $(formFieldUniqueId + "_userField");
	this.btnField['user'] = this;
	
	this.input = jQuery("#" + this.formFieldId + "_input");
	this.input.data("field", this);
	
	this.getValue = function() {
		return this.valueField.value;
	};
	this.setValue = function(value){
		this.valueField.value = value;
	};
	this.getName = function(){
		return this.nameField.value;
	};
	this.setName = function(name){
		this.nameField.value = name;
		MisFormUtil.checkValidate(this.nameField.id);
	};
	
	this.popupSelectUserModalDialog = function(id){
		//selectUser(id, '', '', 'form');
		selectTree(id, '', '', 'user', 'single', 'form');
	};
	Element.observe(this.btnField, 'click', function(event) {
		event.target['user'].popupSelectUserModalDialog(event.target.id);
	});
	
	this.input.change(function(event) {
		var input = jQuery("#" + event.target.id);
		var field = input.data("field");
		field.setValue("");
	});
};