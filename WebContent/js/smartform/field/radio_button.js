SmartWorks.FormRuntime = SmartWorks.FormRuntime || {};

SmartWorks.FormRuntime.RadioButtonBuilder = {};

SmartWorks.FormRuntime.RadioButtonBuilder.build = function(config) {
	var options = {
		mode : 'edit', // view or edit
		container : $('<div></div>'),
		entity : null,
		value : '',
		dataField : '',
		refreshData : false,
		layoutInstance : null
	};

	SmartWorks.extend(options, config);
	if(!options.refreshData)
		options.container.html('');

	var value = (options.dataField && options.dataField.value) || '';
	var $entity = options.entity;
	var $graphic = $entity.children('graphic');
	var $format = $entity.children('format');

	var readOnly = $graphic.attr('readOnly') == 'true' || options.mode == 'view';
	var id = $entity.attr('id');
	var name = $entity.attr('name');
	
	var labelWidth = (isEmpty(options.layoutInstance)) ? parseInt($graphic.attr('labelWidth')) : options.layoutInstance.getLabelWidth(id);
	var valueWidth = 100 - labelWidth;
	var $label = $('<div class="form_label" style="width:' + labelWidth + '%"><span>' + name + '</span></div>');
	var required = $entity[0].getAttribute('required');
	if(required === 'true' && !readOnly){
		$label.addClass('required_label');
		required = " class='sw_required'";
	}else{
		required = "";
	}
	if(!options.refreshData)
		$label.appendTo(options.container);
	
	var $staticItems = $format.find('list staticItems staticItem');
	var $input_container = $('<div class="form_value" style="width:' + valueWidth + '%"></div>');
	
	var $fieldset = $('<fieldset' + required + '></fieldset>');
	for ( var i = 0; i < $staticItems.length; i++) {
		var $staticItem = $staticItems.eq(i);
		var text = $staticItem.text();
		var checked = (value === text ) ? 'checked' : '' ;

		var $input = $('<input type="radio" ' + checked + ' name="' + id + '" value="' + text + '">' + text + '</input>');
		
		$input.attr('fieldId', id);
		if (readOnly) {
			$input.attr('disabled', 'disabled');
		}
		if ($graphic.attr('hidden') == 'true'){
			$label.hide();
			$input.hide();		
		}
		$input.appendTo($fieldset);
	}
	$fieldset.appendTo($input_container);

	if(!options.refreshData)	
		$input_container.appendTo(options.container);
	else
		options.container.find('.form_value').html($input_container.children());

	if ($graphic.attr('hidden') == 'true') {
		$label.hide();
		$input_container.hide();
	}

	return options.container;
};

SmartWorks.FormRuntime.RadioButtonBuilder.buildEx = function(config){
	var options = {
			container : $('<tr></tr>'),
			fieldId: '',
			fieldName: '',
			value: '',
			columns: 1,
			colSpan: 1, 
			required: false,
			readOnly: false		
	};
	SmartWorks.extend(options, config);

	var labelWidth = 12;
	if(options.columns >= 1 && options.columns <= 4 && options.colSpan <= options.columns) labelWidth = 12 * options.columns/options.colSpan;
	$formEntity =  $('<formEntity id="' + options.fieldId + '" name="' + options.fieldName + '" systemType="string" required="' + options.required + '" system="false">' +
						'<format type="radioButton" viewingType="radioButton"/>' +
					    '<graphic hidden="false" readOnly="'+ options.readOnly +'" labelWidth="'+ labelWidth + '"/>' +
					'</formEntity>');
	var $formCol = $('<td class="form_col js_type_radioButton" fieldid="' + options.fieldId+ '" colspan="' + options.colSpan + '" width="' + options.colSpan/options.columns*100 + '%" rowspan="1">');
	$formCol.appendTo(options.container);
	SmartWorks.FormRuntime.RadioButtonBuilder.build({
			mode : options.readOnly, // view or edit
			container : $formCol,
			entity : $formEntity,
			dataField : options.value			
	});
	
};

SmartWorks.FormRuntime.RadioButtonBuilder.dataField = function(config){
	var options = {
			fieldName: '',
			formXml: '',
			value: ''
	};

	SmartWorks.extend(options, config);
	$formXml = $(options.formXml);
	var dataField = {};
	var fieldId = $formXml.find('formEntity[name="'+options.fieldName+'"]').attr('id');
	if(isEmpty(fieldId)) fieldId = ($formXml.attr("name") === options.fieldName) ? $formXml.attr('id') : "";
	if(isEmpty($formXml) || isEmpty(fieldId)) return dataField;
	
	dataField = {
			id: fieldId,
			value: options.value
	};
	return dataField;
};

SmartWorks.FormRuntime.RadioButtonBuilder.validate = function(radioButtons){
	var radioButtonsValid = true;
	for(var i=0; i<radioButtons.length; i++){
		var radioButton = $(radioButtons[i]);
		var fieldset = radioButton.find('fieldset.sw_required');
		if(isEmpty(fieldset)) continue;
		if(isEmpty(fieldset.find('input:checked'))){
			fieldset.addClass("sw_error");
			radioButtonsValid = false;
		}
	}
	return radioButtonsValid;
};

