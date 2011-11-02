// mis.form.component.
FormDataGridRefField = function(contentsContainer, formEntityXml, row, mode, formRuntime, contentWidth, isAdd, preGenId) {
	if(isAdd){
		this.formFieldId =  preGenId;
	}else{
		this.formFieldId = formRuntime.generateFieldIdByXml(formEntityXml)+ "_" + row;
		this.formRuntime = formRuntime;
	}
	
	var formatXml = SmartXMLUtil.getChildNode(formEntityXml, 'format');
	var refFormXml = SmartXMLUtil.getChildNode(formatXml, 'refForm');
	var refFormFieldXml = SmartXMLUtil.getChildNode(refFormXml, 'field');
	var formFieldId;
	if(isAdd) {
		formFieldId =  preGenId;
	} else {
		formFieldId = formRuntime.generateFieldIdByXml(formEntityXml)+ "_" + row;
	}
	
	this.refFormId = refFormXml.getAttribute('id');
	this.refFormVer = refFormXml.getAttribute('ver');
	this.refFormFieldId = refFormFieldXml.getAttribute('id');
	
	this.valueField = $(formFieldId + "_refField_value");
	this.nameField = $(formFieldId + "_input");
	this.btnField = $(formFieldId + "_refField");
	this.btnField['ref'] = this;
	
	this.input = jQuery("#" + this.formFieldId + "_input");
	this.input.data("field", this);
	
	this.openRefWindow = function(id) {
		if (Mis.isNull(this.refFormId) || Mis.isNull(this.refFormFieldId)) {
			warnMessage("errorCodeNotConfiguredFormLink", "askAdmin");
			return;
		}
		var url = getPath() + "/common/referenceTaskList.jsp";
		var params = '?formId=' + this.refFormId + '&fieldId=' + this.refFormFieldId + '&formFieldId=' + id + '&mode=form';
		popupModalDialog(url, params);
		
		//window.open('../common/referenceTaskList.jsp?formId=' + this.refFormId + '&fieldId=' + this.refFormFieldId + '&formFieldId=' + id + '&mode=form', '', 'width=650px, height=500px, scrollbars=yes,resizable=yes');		
	};
	Element.observe(this.btnField, 'click', function(e){
		e.target['ref'].openRefWindow(e.target.id);
	});
	
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
	
	this.input.change(function(event) {
		var input = jQuery("#" + event.target.id);
		var field = input.data("field");
		field.setValue("");
	});
};