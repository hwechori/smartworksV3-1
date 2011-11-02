FormNumberField = function(contentsContainer, fieldXml, mode, formRuntime, view, opts) {
	this.formFieldId = formRuntime.generateFieldIdByXml(fieldXml);
	this.formRuntime = formRuntime;
	this.view = view;
	this.prefix;
	this.suffix;
	if (!Mis.isNull(opts)) {
		this.prefix = opts["prefix"];
		this.suffix = opts["suffix"];
	}
	var html =  "<div id=\"" + this.formFieldId + "NumberInput\">"; // height: " + heightSize + "px; 
	if(mode == 'viewer'){
		html += "<p class=\"numberFieldP formFieldContentsInputNoborder\" id=\"" + this.formFieldId + "_input\">&nbsp;</p>";
	}else{
		if (this.view) {
			html += "<p class=\"numberFieldP formFieldContentsInputNoborder\" id=\"" + this.formFieldId + "_input\">&nbsp;</p>";	
		}else {
			html += "<input class=\"numberFieldInput formFieldContentsInput numberFieldChangeValue\"";
			html += " id=\"" + this.formFieldId + "_input\" type=\"text\" style=\"width: 100%;\" fieldId='" + fieldXml.getAttribute('id') + "' workspaceId='" + formRuntime.workspaceId + "'/>";				
		}
	}
	html += "</div>";
	
	if (mode == "hidden") {
		jQuery("#" + contentsContainer.id).html(html).hide();
	} else {
		jQuery("#" + contentsContainer.id).html(html);
	}
	
	this.value;
	
	this.input = jQuery("#" + this.formFieldId + "_input");
	this.input.data("field", this);
	this.doValue = function(input) {
		var field = input.data("field");
		var newValue = new String(input.clone().val());
		var floatValue = NumberFormatter.toNumber(newValue, field.prefix, field.suffix);
		if (field.value != floatValue) {
			field.value = floatValue;
			if (field.formRuntime.isMappingEachTime)
				field.formRuntime.refreshDataFields(field.formFieldId);
		}
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