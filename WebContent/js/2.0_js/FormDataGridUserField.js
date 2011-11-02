FormDataGridUserField = function(contentsContainer, fieldXml, row, mode, formRuntime, contentWidth, isAdd, preGenId){
	if(isAdd){
		this.formFieldId =  preGenId;
	}else{
		this.formFieldId = formRuntime.generateFieldIdByXml(fieldXml)+ "_" + row;
		this.formRuntime = formRuntime;
	}
	
	var formFieldUniqueId;
	if(isAdd){
		formFieldUniqueId =  preGenId;
	}else{
		formFieldUniqueId = formRuntime.generateFieldIdByXml(fieldXml)+ "_" + row;
	}
	
	this.valueField = $(formFieldUniqueId + "_userField_value");
	this.nameField = $(formFieldUniqueId + "_input");
	this.btnField = $(formFieldUniqueId + "_userField");
	this.btnField['user'] = this;
	
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
	
	this.popupSelectUserModalDialog = function(id){
		//selectUser(id, '', '', 'form');
		selectTree(id, '', '', 'user', 'single', 'form');
	};
	Element.observe(this.btnField, 'click', function(e){
		e.target['user'].popupSelectUserModalDialog(e.target.id);
	});
	
	this.input.change(function(event) {
		var input = jQuery("#" + event.target.id);
		var field = input.data("field");
		field.setValue("");
	});
};