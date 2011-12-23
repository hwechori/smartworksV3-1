SmartWorks.FormRuntime = SmartWorks.FormRuntime || {};

SmartWorks.FormRuntime.CheckBoxBuilder = {};

SmartWorks.FormRuntime.CheckBoxBuilder.build = function(config) {
	var options = {
		mode : 'edit', // view or edit
		container : $('<div></div>'),
		entity : null,
		dataField : '',
		layoutInstance : null
	};

	SmartWorks.extend(options, config);
	options.container.html('');

	var value = (options.dataField && options.dataField.value) || '';
	var $entity = options.entity;
	//var $graphic = $entity.children('graphic');
	var $graphic = $entity.children('graphic');
	var readOnly = $graphic.attr('readOnly') === 'true' || options.mode === 'view';
	var id = $entity.attr('id');
	var name = $entity.attr('name');

	var labelWidth = (isEmpty(options.layoutInstance)) ? parseInt($graphic.attr('labelWidth')) : options.layoutInstance.getLabelWidth(id);
	var valueWidth = 100 - labelWidth;
	var $label = $('<div class="form_label" style="width:' + labelWidth + '%">' + name + '</div>');
	var required = $entity[0].getAttribute('required');
	if(required === 'true' && !readOnly){
		$('<span class="essen_n"></span>').appendTo($label);
		required = " class='required' ";
	}else{
		required = "";
	}
	$label.appendTo(options.container);

	var checked = (value) ? 'checked' : '' ;
	
	var $check = null;
	if(readOnly){
		$check = $('<div class="form_value form_value_max_width" style="width:' + valueWidth + '%"></div>').text(value);
	}else{	
		$check = $('<div class="form_value form_value_max_width" style="width:' + valueWidth + '%"><input type="checkbox" '+ checked + ' name="' + id + '"' + required +  '><div>');
	}

	if ($graphic.attr('hidden') == 'true'){
		$label.hide();
		$check.hide();		
	}
	$check.appendTo(options.container);

	return options.container;
};

SmartWorks.FormRuntime.CheckBoxBuilder.buildEx = function(config){
	var options = {
			container : $('<tr></tr>'),
			fieldId: '',
			fieldName: '',
			value: '',
			columns: 1,
			required: false,
			readOnly: false		
	};
	SmartWorks.extend(options, config);

	var labelWidth = 10;
	if(options.columns >= 1 && options.columns <= 4) labelWidth = 10 * options.columns;
	$formEntity =  $('<formEntity id="' + options.fieldId + '" name="' + options.fieldName + '" systemType="string" required="' + options.required + '" system="false">' +
						'<format type="checkBox" viewingType="checkBox"/>' +
					    '<graphic hidden="false" readOnly="'+ options.readOnly +'" labelWidth="'+ labelWidth + '"/>' +
					'</formEntity>');
	var $formCol = $('<td class="form_col js_type_checkBox" fieldid="' + options.fieldId+ '" colspan="1" width="500.61775800946384" rowspan="1">');
	$formCol.appendTo(options.container);
	SmartWorks.FormRuntime.CheckBoxBuilder.build({
			mode : options.readOnly, // view or edit
			container : $formCol,
			entity : $formEntity,
			dataField : options.value			
	});
	
};

SmartWorks.FormRuntime.CheckBoxBuilder.dataField = function(config){
	var options = {
			fieldName: '',
			formXml: '',
			value: ''
	};

	SmartWorks.extend(options, config);
	$formXml = $(options.formXml);
	var dataField = {};
	var fieldId = $formXml.find('formEntity[name="'+options.fieldName+'"]').attr('id');
	if(isEmpty($formXml) || isEmpty(fieldId)) return dataField;
	
	dataField = {
			id: fieldId,
			value: options.value
	};
	return dataField;
};
