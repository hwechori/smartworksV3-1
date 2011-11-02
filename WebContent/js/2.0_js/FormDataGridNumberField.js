// mis.form.component.
FormDataGridNumberField = function(contentsContainer, fieldXml, row, formRuntime, view, opts) {
	var preGenId = null;
	this.prefix = null;
	this.suffix = null;
	if (!Mis.isNull(opts)) {
		preGenId = opts["preGenId"];
		this.prefix = opts["prefix"];
		this.suffix = opts["suffix"];
	}
	
	this.view = view;
	this.formFieldId;
	if (!Mis.isNull(preGenId)) {
		this.formFieldId = preGenId;
	} else {
		this.formFieldId = formRuntime.generateFieldIdByXml(fieldXml)+ "_" + row;
	}
	
	this.value;
	
	this.input = jQuery("#" + this.formFieldId + "_input");
	this.input.data("field", this);
	this.doValue = function(input) {
		var field = input.data("field");
		var newValue = new String(input.clone().val());
		var floatValue = NumberFormatter.toNumber(newValue, field.prefix, field.suffix);
		if (field.value != floatValue)
			field.value = floatValue;
		input.val(NumberFormatter.format(field.value, field.prefix, field.suffix));
	};
	this.doValue(this.input);
	
	this.getValue = function() {
		return this.value;
	};
	this.setValue = function(value) {
		var floatValue = parseFloat(value);
		if (isNaN(floatValue))
			floatValue = null;
		this.value = floatValue;
		var viewValue = NumberFormatter.format(this.value, this.prefix, this.suffix);
		if (this.view) {
			this.input.html(viewValue);
		} else {
			this.input.val(viewValue);
		}
	};
	this.getName = function() {
		return NumberFormatter.format(this.value);
	};
	this.setName = function(name) {
	};
	/*
	 * */
	this.input.blur(
		function(event) {
			var input = jQuery("#" + event.target.id);
			var field = input.data("field");
			field.doValue(input);
		}
	);
	
	this.input.focus(
		function(event) {
//			var input = jQuery("#" + event.target.id);
//			var field = input.data("field");
//			input.val(field.value);
		}
	);
};