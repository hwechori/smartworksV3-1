SmartWorks.FormRuntime = SmartWorks.FormRuntime || {};

SmartWorks.FormRuntime.PercentInputBuilder = {};

SmartWorks.FormRuntime.PercentInputBuilder.build = function(config) {
	var options = {
		mode : 'edit', // view or edit
		container : $('<div></div>'),
		entity : '',
		dataField : '',
		layoutInstance : null
	};

	SmartWorks.extend(options, config);
	options.container.html('');

	var value = (options.dataField && parseFloat(options.dataField.value)) || 0;
	$entity = options.entity;
	$graphic = $entity.children('graphic');
	$format = $entity.children('format');

	var readOnly = $graphic.attr('readOnly') == 'true' || options.mode == 'view';
	var id = $entity.attr('id');
	var name = $entity.attr('name');

	var labelWidth = (isEmpty(options.layoutInstance)) ? parseInt($graphic.attr('labelWidth')) : options.layoutInstance.getLabelWidth(id);
	var valueWidth = 100 - labelWidth;
	var $label = $('<div class="form_label" style="width:' + labelWidth + '%"><span>' + name + '</span></div>');
	var required = $entity[0].getAttribute('required');
	if(required === 'true' && !readOnly){
		$label.addClass('required_label');
		required = " class='js_percent_input fieldline text_align_r required' ";
	}else{
		required = " class='js_percent_input fieldline text_align_r' ";
	}
	$label.appendTo(options.container);
	
	var percentValue = value + '%';
		
	var $percent = null;
	
	if (readOnly) {
		$percent = $('<div class="form_value form_number_input" style="width:' + valueWidth + '%"></div>').text(percentValue);
	} else {
		$percent = $('<div name="' + id + '" class="form_value form_number_input" style="width:' + valueWidth + '%"><input type="text"' + required + '/></div>');
		$percent.find('input').attr('value', percentValue);
	}

	if ($graphic.attr('hidden') == 'true'){
		$label.hide();
		$percent.hide();		
	}
	$percent.appendTo(options.container);
	return options.container;
};

$('input.js_percent_input').live('blur', function(e) {
	$input = $(e.target);
	
	var value = $input.attr('value');
	
	value = ($.parseNumber(value, {format: "-0,000.0", locale: currentUser.locale}) * 100) + '';
	
	var idx = value.lastIndexOf('%');
	
	if(idx === -1)
	$input.attr('value', $.formatNumber(value, {format: "-#,###.#", locale: currentUser.locale}) + '%');
});

$('input.js_percent_input').live('focusin', function(e) {
	$input = $(e.target);
	
	var value = $input.attr('value');
	
	var idx = value.lastIndexOf('%');
	
	if(idx > -1)
		value = value.substring(0, idx);
	
	value = ($.parseNumber(value, {format: "-0,000.0", locale: currentUser.locale}) / 100) + '';
	
	$input.attr('value', $.formatNumber(value, {format: "-#,###.#", locale: currentUser.locale}));
});

$('input.js_percent_input').live('keyup', function(e) {
	var e = window.event || e;
	var keyUnicode = e.charCode || e.keyCode;
	if (e !== undefined) {
		switch (keyUnicode) {
			case 16: break; // Shift
			case 17: break; // Ctrl
			case 18: break; // Alt
			case 27: this.value = ''; break; // Esc: clear entry
			case 35: break; // End
			case 36: break; // Home
			case 37: break; // cursor left
			case 38: break; // cursor up
			case 39: break; // cursor right
			case 40: break; // cursor down
			case 78: break; // N (Opera 9.63+ maps the "." from the number key section to the "N" key too!) (See: http://unixpapa.com/js/key.html search for ". Del")
			case 110: break; // . number block (Opera 9.63+ maps the "." from the number block to the "N" key (78) !!!)
			case 190: break; // .
			default:
				if($(this).attr('value') === '0-') $(this).attr('value', '-');
				var value = $(this).attr('value');
				var firstStr = value.substring(0,1);
				var secondStr = value.substring(1,2);
				if(value !== '-' && value !== '.')
					if(isEmpty(value) || (firstStr !== '-' && firstStr !== '.' && (firstStr<'0' || firstStr>'9')) || (((firstStr === '-' && secondStr !== '.') || firstStr === '.') && (secondStr<'0' || secondStr>'9'))){
						$(this).attr('value', 0);
					}
				$(this).formatCurrency({ symbol: '' , colorize: true, negativeFormat: '-%s%n', roundToDecimalPlace: -1, eventOnDecimalsEntered: true });
		}
	}
});

SmartWorks.FormRuntime.PercentInputBuilder.buildEx = function(config){
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

	var labelWidth = 10;
	if(options.columns >= 1 && options.columns <= 4 && options.colSpan <= options.columns) labelWidth = 10 * options.columns/options.colSpan;
	$formEntity =  $('<formEntity id="' + options.fieldId + '" name="' + options.fieldName + '" systemType="string" required="' + options.required + '" system="false">' +
						'<format type="percentInput" viewingType="percentInput"/>' +
					    '<graphic hidden="false" readOnly="'+ options.readOnly +'" labelWidth="'+ labelWidth + '"/>' +
					'</formEntity>');
	var $formCol = $('<td class="form_col js_type_percentInput" fieldid="' + options.fieldId+ '" colspan="' + options.colSpan + '" width="500.61775800946384" rowspan="1">');
	$formCol.appendTo(options.container);
	SmartWorks.FormRuntime.PercentInputBuilder.build({
			mode : options.readOnly, // view or edit
			container : $formCol,
			entity : $formEntity,
			dataField : options.value			
	});
	
};

SmartWorks.FormRuntime.PercentInputBuilder.dataField = function(config){
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

SmartWorks.FormRuntime.PercentInputBuilder.serializeObject = function(percentInputs){
	var percentInputsJson = {};
	for(var i=0; i<percentInputs.length; i++){
		var percentInput = $(percentInputs[i]);
		var valueStr = percentInput.find('input').attr('value');
		percentInputsJson[percentInput.attr('fieldId')] = $.parseNumber( valueStr.substring(0, valueStr.length-1), {format:"-0,000.0", locale: currentUser.locale });
	}
	return percentInputsJson;
};

