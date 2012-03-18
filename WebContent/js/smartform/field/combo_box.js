SmartWorks.FormRuntime = SmartWorks.FormRuntime || {};

SmartWorks.FormRuntime.ComboBoxBuilder = {};

SmartWorks.FormRuntime.ComboBoxBuilder.build = function(config) {
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
		required = " class='form_select_box required' ";
	}else{
		required = " class='form_select_box' ";		
	}
		
	$label.appendTo(options.container);
	
	var $staticItems = $format.find('list staticItems staticItem');
	
	var $input = $('<div class="form_value" style="width:' + valueWidth + '%"><select name="' + id + '"' + required + '></select><div>');

	$input.attr('fieldId', id);
	if (readOnly) {
		$input.find('select').attr('disabled', 'disabled');
	}else{
		required = "";
	}
	
	for ( var i = 0; i < $staticItems.length; i++) {
		var $staticItem = $staticItems.eq(i);
		var text = $staticItem.text();
		var selected = (value === text ) ? 'selected' : '' ;

		$option = $('<option value="' + text + '" ' + selected + '>'+text+'</option>');
		
		$option.appendTo($input.find('select'));
	}
	$input.appendTo(options.container);

	if ($graphic.attr('hidden') == 'true') {
		$label.hide();
		$input.hide();
	}
	return options.container;
};

SmartWorks.FormRuntime.ComboBoxBuilder.buildEx = function(config){
	var options = {
			container : $('<tr></tr>'),
			fieldId: '',
			fieldName: '',
			value: '',
			staticItems : [],
			columns: 1,
			colSpan: 1,
			required: false,
			readOnly: false		
	};
	SmartWorks.extend(options, config);

	var staticList = "";
	if(!isEmpty(options.staticItems)){
		staticList = '<list type="" refCodeCategoryId="null" refCodeCategoryName="null" listType="static"><staticItems>';
			for(var i=0; i<options.staticItems.length; i++)
				staticList = staticList + '<staticItem>' + options.staticItems[i] + '</staticItem>';
		staticList = staticList + '</staticItems></list>';		
	}

	var labelWidth = 12;
	if(options.columns >= 1 && options.columns <= 4 && options.colSpan <= options.columns) labelWidth = 12 * options.columns/options.colSpan;
	$formEntity =  $('<formEntity id="' + options.fieldId + '" name="' + options.fieldName + '" systemType="string" required="' + options.required + '" system="false">' +
						'<format type="comboBox" viewingType="comboBox">' + staticList + '</format>' + 
					    '<graphic hidden="false" readOnly="'+ options.readOnly +'" labelWidth="'+ labelWidth + '"/>' +
					'</formEntity>');
	var $formCol = $('<td class="form_col js_type_comboBox" fieldid="' + options.fieldId+ '" colspan="' + options.colSpan +  '" width="' + options.colSpan/options.columns*100 + '%" rowspan="1">');
	$formCol.appendTo(options.container);
	SmartWorks.FormRuntime.ComboBoxBuilder.build({
			mode : options.readOnly, // view or edit
			container : $formCol,
			entity : $formEntity,
			dataField : options.value,
			staticItems : options.staticItems
	});
	
};

SmartWorks.FormRuntime.ComboBoxBuilder.dataField = function(config){
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
