SmartWorks.FormRuntime = SmartWorks.FormRuntime || {};

SmartWorks.FormRuntime.RefFormFieldBuilder = {};

SmartWorks.FormRuntime.RefFormFieldBuilder.build = function(config) {
	var options = {
		mode : 'edit', // view or edit
		container : $('<div></div>'),
		entity : null,
		dataField : ''
	};
	
	SmartWorks.extend(options, config);
	var value = (options.dataField && options.dataField.value) || '';
	var refForm = (options.dataField && options.dataField.refForm) || '';
	var refFormField = (options.dataField && options.dataField.refFormField) || '';
	var refRecordId = (options.dataField && options.dataField.refRecordId) || '';
	options.container.attr('refForm', refForm).attr('refFormField', refFormField).attr('refRecordId', refRecordId);
	var $entity = options.entity;

	var $graphic = $entity.children('graphic');
	var readOnly = $graphic.attr('readOnly') === 'true' || options.mode === 'view';
	var id = $entity.attr('id');
	var name = $entity.attr('name');
	
	var labelWidth = options.layoutInstance.getLabelWidth(id);
	var valueWidth = 100 - labelWidth;
	var $label = $('<span class="form_label" style="width:' + labelWidth + '%">' + name + '</span>');
	var required = $entity[0].getAttribute('required');
	if(required === 'true' && !readOnly){
		$('<span class="essen_n"></span>').appendTo($label);
		required = " class='sw_required' ";
	}else{
		required = "";
	}
	$label.appendTo(options.container);
	
	var $refForm = null;
	if(readOnly){
		$refForm = $('<span class="form_value" style="width:' + valueWidth + '%"></span>').text(value);
	}else{	
		$refForm = $('<span class="form_value" style="width:' + valueWidth + '%"><span' + required + '>' + value + '</span></span>');
	}
	$refForm.appendTo(options.container);

	return options.container;
};

SmartWorks.FormRuntime.RefFormFieldBuilder.serializeObject = function(refFormFields){
	var refFormsJson = {};
	for(var i=0; i<refFormFields.length; i++){
		var refFormField = $(refFormFields[i]);
		refFormsJson[refFormField.attr('fieldId')] =  {refForm: refFormField.attr('refForm'), refFormField: refFormField.attr('refFormField'), refRecordId: refFormField.attr('refRecordId'), value: refFormField.find('.form_value').text() };
	}
	return refFormsJson;
};

SmartWorks.FormRuntime.RefFormFieldBuilder.validate = function(refFormFields){
	var refFormsValid = true;
	for(var i=0; i<refFormFields.length; i++){
		var refFormField = $(refFormFields[i]).find('span.sw_required');
		var text = refFormField.text();
		if(text == null || text === ""){
			refFormField.addClass("sw_error");
			refFormsValid = false;
		}
	}
	return refFormsValid;
};

