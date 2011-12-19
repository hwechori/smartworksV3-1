SmartWorks.FormRuntime = SmartWorks.FormRuntime || {};

SmartWorks.FormRuntime.RefFormFieldBuilder = {};

SmartWorks.FormRuntime.RefFormFieldBuilder.build = function(config) {
	var options = {
		mode : 'edit', // view or edit
		container : $('<div></div>'),
		entity : null,
		dataField : '',
		layoutInstance : null
	};
	
	SmartWorks.extend(options, config);
	var $entity = options.entity;
	var $refForm = $entity.find('refForm');	
	var $refFormField = $refForm.find('field');	
	var refRecordId = (options.dataField && options.dataField.refRecordId) || '';
	var value = (options.dataField && options.dataField.value) || '';
	options.container.attr('refForm', $refForm.attr('id')).attr('refFormField', $refFormField.attr('id')).attr('refRecordId', refRecordId);

	var $graphic = $entity.children('graphic');
	var readOnly = $graphic.attr('readOnly') === 'true' || options.mode === 'view';
	var id = $entity.attr('id');
	var name = $entity.attr('name');
	
	var labelWidth = options.layoutInstance.getLabelWidth(id);
	var valueWidth = 100 - labelWidth;
	var $label = $('<div class="form_label" style="width:' + labelWidth + '%">' + name + '</span>');
	var required = $entity[0].getAttribute('required');
	if(required === 'true' && !readOnly){
		$('<span class="essen_n"></span>').appendTo($label);
		required = " class='fieldline sw_required' ";
	}else{
		required = "class='fieldline' ";
	}
	$label.appendTo(options.container);
	
	var $refForm = null;
	if(readOnly){
		$refForm = $('<div class="form_value form_value_max_width" style="width:' + valueWidth + '%"></div>').text(value);
	}else{	
		$refForm = $('<div class="form_value form_value_max_width" style="width:' + valueWidth + '%"><div class="ico_fb_space"><input readonly="readonly" type="text" name="' + id + '"' + required + '><span class="ico_fb_work"></span></div></div>');
	}
	if ($graphic.attr('hidden') == 'true'){
		$label.hide();
		$refForm.hide();		
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
		var refFormField = $(refFormFields[i]).find('input.sw_required');
		var text = refFormField.text();
		if(text == null || text === ""){
			refFormField.addClass("sw_error");
			refFormsValid = false;
		}
	}
	return refFormsValid;
};

