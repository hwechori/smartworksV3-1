SmartWorks.FormRuntime = SmartWorks.FormRuntime || {};

SmartWorks.FormRuntime.DateTimeChooserBuilder = {};

SmartWorks.FormRuntime.DateTimeChooserBuilder.build = function(config) {
	var options = {
		mode : 'edit', // view or edit
		container : $('<td></td>'),
		entity : null,
		dataField : '',
		layoutInstance : null,
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
		required = " class='fieldline js_todaytimepicker required' ";
	}else{
		required = " class='fieldline js_todaytimepicker' ";
	}
	$label.appendTo(options.container);
	
	var $text = null;
	if(readOnly){
		$text = $('<div class="form_value form_value_max_width" style="width:' + valueWidth + '%"></div>').text(value);
	}else{	
		$text = $('<div class="form_value form_value_max_width" style="width:' + valueWidth + '%"><div class="ico_fb_space form_datetime_input"><input readonly="readonly" type="text" name="' + id + '"' + required + '><a href="#" class="js_todaytimepicker_button"><span class="ico_fb_time"></span></a></div></div>').attr('value', value);
	}
	if ($graphic.attr('hidden') == 'true'){
		$label.hide();
		$text.hide();		
	}
	$text.appendTo(options.container);

	$.datepicker.setDefaults($.datepicker.regional[currentUser.locale]);
	$.timepicker.setDefaults($.timepicker.regional[currentUser.locale]);
	$('input.js_todaytimepicker').datetimepicker({
		defaultDate : new Date(),
		dateFormat : 'yy.mm.dd',
		timeFormat : 'hh:mm',
		hourGrid: 4,
		minuteGrid: 10,
		onSelect: function(date) {
			if(!isEmpty($('form.js_validation_required').find('.error'))){
				$('form.js_validation_required').validate({ showErrors: showErrors}).form();
			}
	    }
	});
	return options.container;
};

SmartWorks.FormRuntime.DateTimeChooserBuilder.buildEx = function(config){
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
	$formEntity =  $('<formEntity id="' + options.fieldId + '" name="' + options.fieldName + '" systemType="datetime" required="' + options.required + '" system="false">' +
						'<format type="datetimeChooser" viewingType="datetimeChooser"/>' +
					    '<graphic hidden="false" readOnly="'+ options.readOnly +'" labelWidth="'+ labelWidth + '"/>' +
					'</formEntity>');
	var $formCol = $('<td class="form_col js_type_datetimeChooser" fieldid="' + options.fieldId+ '" colspan="1" width="500.61775800946384" rowspan="1">');
	$formCol.appendTo(options.container);
	SmartWorks.FormRuntime.DateTimeChooserBuilder.build({
			mode : options.readOnly, // view or edit
			container : $formCol,
			entity : $formEntity,
			dataField : SmartWorks.FormRuntime.DateTimeChooserBuilder.dataField({
				fieldName: options.fieldName,
				formXml: $formEntity,
				value: options.value				
			})
	});
	
};

SmartWorks.FormRuntime.DateTimeChooserBuilder.dataField = function(config){
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
