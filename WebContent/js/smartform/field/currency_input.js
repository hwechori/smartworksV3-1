SmartWorks.FormRuntime = SmartWorks.FormRuntime || {};

SmartWorks.FormRuntime.CurrencyInputBuilder = {};

SmartWorks.FormRuntime.CurrencyInputBuilder.build = function(config) {
	var options = {
		mode : 'edit', // view or edit
		container : $('<div></div>'),
		entity : null,
		dataField : '',
		refreshData : false,
		layoutInstance : null
	};

	SmartWorks.extend(options, config);
	if(!options.refreshData)
		options.container.html('');

	var value = (options.dataField && parseFloat(options.dataField.value)) || 0;
	var $entity = options.entity;
	var $graphic = $entity.children('graphic');

	var readOnly = $graphic.attr('readOnly') === 'true' || options.mode === 'view';
	var id = $entity.attr('id');
	var name = $entity.attr('name');
	
	var currency = $entity.children('format').children('currency').text();

	var labelWidth = (isEmpty(options.layoutInstance)) ? parseInt($graphic.attr('labelWidth')) : options.layoutInstance.getLabelWidth(id);
	var valueWidth = 100 - labelWidth;
	var $label = $('<div class="form_label" style="width:' + labelWidth + '%"><span>' + name + '</span></div>');
	var required = $entity[0].getAttribute('required');
	if(required === 'true' && !readOnly){
		$label.addClass('required_label');
		required = " class='js_currency_input fieldline tr required' ";
	}else{
		required = " class='js_currency_input fieldline tr' ";
	}
	if(!options.refreshData)
		$label.appendTo(options.container);
	
	var $currency = null;
	if(readOnly){
		$currency = $('<div class="form_value form_number_input" style="width:' + valueWidth + '%"></div>').text(value).formatCurrency({ symbol: currency ,colorize: true, negativeFormat: '-%s%n', roundToDecimalPlace: -1, eventOnDecimalsEntered: true });
	}else{	
		$currency = $('<div name="' + id + '" class="form_value form_number_input" style="width:' + valueWidth + '%"><input type="text" symbol="' + currency + '"'  + required + '></div>');
		$currency.find('input').attr('value',value).formatCurrency({ symbol: currency ,colorize: true, negativeFormat: '-%s%n', roundToDecimalPlace: -1, eventOnDecimalsEntered: true });
	}
	if ($graphic.attr('hidden') == 'true'){
		$label.hide();
		$currency.hide();		
	}
	if(!options.refreshData){
		$currency.appendTo(options.container);
	}else{
		if(readOnly)
			options.container.find('.form_value').text(value);
		else
			options.container.find('.form_value input').attr('value', value);
	}
		
	return options.container;
};

SmartWorks.FormRuntime.CurrencyInputBuilder.buildEx = function(config){
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
						'<format type="currencyInput" viewingType="currencyInput"/>' +
					    '<graphic hidden="false" readOnly="'+ options.readOnly +'" labelWidth="'+ labelWidth + '"/>' +
					'</formEntity>');
	var $formCol = $('<td class="form_col js_type_currenyInput" fieldid="' + options.fieldId+ '" colspan="' + options.colSpan + '" width="' + options.colSpan/options.columns*100 + '%" rowspan="1">');
	$formCol.appendTo(options.container);
	SmartWorks.FormRuntime.CurrencyInputBuilder.build({
			mode : options.readOnly, // view or edit
			container : $formCol,
			entity : $formEntity,
			dataField : options.value			
	});
	
};

$('input.js_currency_input').live('keyup', function(e) {
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
				if($(this).attr('value') === $(this).attr('symbol') + '0-') $(this).attr('value', '-');				
				var value = $(this).attr('value');
				var firstStr = value.substring(0,1);
				var secondStr = value.substring(1,2);
				var thirdStr = value.substring(2,3);
				if(isEmpty(value) 
						|| (firstStr !== $(this).attr('symbol') && firstStr !== '-' && (firstStr<'0' || firstStr>'9')) 
						|| (firstStr === $(this).attr('symbol') && (secondStr<'0' || secondStr>'9'))
						|| (firstStr === '-' && !isEmpty(secondStr) && secondStr!==$(this).attr('symbol')  && secondStr!=='.' && (secondStr<'0' || secondStr>'9')) 
						|| (firstStr === '-' && secondStr===$(this).attr('symbol') && (thirdStr<'0' || thirdStr>'9'))) 
					$(this).attr('value', 0);
				$(this).formatCurrency({ symbol: $(this).attr('symbol') ,colorize: true, negativeFormat: '-%s%n', roundToDecimalPlace: -1, eventOnDecimalsEntered: true });
		}
	}
	
});


SmartWorks.FormRuntime.CurrencyInputBuilder.dataField = function(config){
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

SmartWorks.FormRuntime.CurrencyInputBuilder.serializeObject = function(currencyInputs){
	var currencyInputsJson = {};
	for(var i=0; i<currencyInputs.length; i++){
		var currencyInput = $(currencyInputs[i]);
		var valueStr = currencyInput.find('input').attr('value');
		currencyInputsJson[currencyInput.attr('fieldId')] = $.parseNumber( valueStr.substring(1, valueStr.length), {format:"-0,000.0", locale: currentUser.locale });
	}
	return currencyInputsJson;
};
