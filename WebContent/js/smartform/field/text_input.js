SmartWorks.FormRuntime = SmartWorks.FormRuntime || {};

SmartWorks.FormRuntime.TextInputBuilder = {};

SmartWorks.FormRuntime.TextInputBuilder.build = function(config) {
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
	var multiLines = parseInt($graphic.attr('multipleLines'));
	var readOnly = $graphic.attr('readOnly') === 'true' || options.mode === 'view';
	var id = $entity.attr('id');
	var name = $entity.attr('name');

	var labelWidth = (isEmpty(options.layoutInstance)) ? parseInt($graphic.attr('labelWidth')) : options.layoutInstance.getLabelWidth(id);
	var valueWidth = 100 - labelWidth;
	var $label = $('<div class="form_label" style="width:' + labelWidth + '%"><span>' + name + '</span></div>');
	var required = $entity[0].getAttribute('required');
	if(required === 'true' && !readOnly){
		$label.addClass('required_label');
		required = " class='fieldline required' ";
	}else{
		required = " class='fieldline' ";
	}
	$label.appendTo(options.container);
	
	var $text = null;
	if(readOnly){
		$text = $('<div class="form_value" fieldId="' + id + '" style="width:' + valueWidth + '%"></div>').text(value);
	}else if(multiLines > 1){	
		$text = $('<div class="form_value" style="width:' + valueWidth + '%"><textarea rows="' + multiLines + '" name="' + id + '"' + required + '></textarea></div>');
		$text.find('textarea').attr('value', value);
	}else{
		$text = $('<div class="form_value" style="width:' + valueWidth + '%"><input type="text" name="' + id + '"' + required + ' maxlength="120"></div>');
		$text.find('input').attr('value', value);		
	}
	if ($graphic.attr('hidden') == 'true'){
		$label.hide();
		$text.hide();		
	}
	$text.appendTo(options.container);

	return options.container;
};

SmartWorks.FormRuntime.TextInputBuilder.buildEx = function(config){
	var options = {
			container : $('<tr></tr>'),
			fieldId: '',
			fieldName: '',
			value: '',
			columns: 1,
			colSpan: 1, 
			multiLines: 1,
			required: false,
			readOnly: false		
	};
	SmartWorks.extend(options, config);

	var labelWidth = 10;
	if(options.columns >= 1 && options.columns <= 4 && options.colSpan <= options.columns) labelWidth = 10 * options.columns/options.colSpan;
	$formEntity =  $('<formEntity id="' + options.fieldId + '" name="' + options.fieldName + '" systemType="string" required="' + options.required + '" system="false">' +
						'<format type="textInput" viewingType="textInput"/>' +
					    '<graphic hidden="false" readOnly="'+ options.readOnly +'" labelWidth="'+ labelWidth + '" multipleLines="' + options.multiLines + '"/>' +
					'</formEntity>');
	var $formCol = $('<td class="form_col js_type_textInput" fieldid="' + options.fieldId+ '" colspan="' + options.colSpan + '" width="500.61775800946384" rowspan="1">');
	$formCol.appendTo(options.container);
	SmartWorks.FormRuntime.TextInputBuilder.build({
			mode : options.readOnly, // view or edit
			container : $formCol,
			entity : $formEntity,
			dataField : options.value			
	});
	
};

SmartWorks.FormRuntime.TextInputBuilder.dataField = function(config){
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
