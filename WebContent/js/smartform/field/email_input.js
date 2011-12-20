SmartWorks.FormRuntime = SmartWorks.FormRuntime || {};

SmartWorks.FormRuntime.EmailInputBuilder = {};

SmartWorks.FormRuntime.EmailInputBuilder.build = function(config) {
	var options = {
		mode : 'edit', // view or edit
		container : $('<div></div>'),
		entity : null,
		dataField : '',
		layoutInstance : null
	};

	SmartWorks.extend(options, config);
	var value = (options.dataField && options.dataField.value) || '';
	var $entity = options.entity;
	//var $graphic = $entity.children('graphic');
	var $graphic = $entity.children('graphic');
	var readOnly = $graphic.attr('readOnly') === 'true' || options.mode === 'view';
	var id = $entity.attr('id');
	var name = $entity.attr('name');
	
	var labelWidth = options.layoutInstance.getLabelWidth(id);
	var valueWidth = 100 - labelWidth;
	var $label = $('<div class="form_label" style="width:' + labelWidth + '%">' + name + '</div>');
	var required = $entity[0].getAttribute('required');
	if(required === 'true' && !readOnly){
		$('<span class="essen_n"></span>').appendTo($label);
		required = " class='fieldline required email' ";
	}else{
		required = " class='fieldline email' ";
	}
	$label.appendTo(options.container);
	
	var $email = null;
	if(readOnly){
		$email = $('<div class="form_value form_value_max_width" style="width:' + valueWidth + '%"></div>').text(value);
	}else{	
		$email = $('<div class="form_value form_value_max_width" style="width:' + valueWidth + '%"><input type="text" name="' + id + '"' + required + '></div>').attr('value', value);
	}
	if ($graphic.attr('hidden') == 'true'){
		$label.hide();
		$email.hide();		
	}
	$email.appendTo(options.container);

	return options.container;
};

SmartWorks.FormRuntime.EmailInputBuilder.dataField = function(config){
	var options = {
			fieldName: '',
			formXml: '',
			value: ''
	};

	SmartWorks.extend(options, config);
	$formXml = $(options.formXml);
	var dataField = {};
	var fieldId = $formXml.find('formEntity[name="'+options.fieldName+'"]').attr('id');
	if(isZeroLength($formXml) || isEmpty(fieldId)) return dataField;
	
	dataField = {
			id: fieldId,
			value: options.value
	};
	return dataField;
};
