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
	options.container.html('');

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
	
	var labelWidth = (isEmpty(options.layoutInstance)) ? parseInt($graphic.attr('labelWidth')) : options.layoutInstance.getLabelWidth(id);
	var valueWidth = 100 - labelWidth;
	var $label = $('<div class="form_label" style="width:' + labelWidth + '%"><span>' + name + '</span></div>');
	var required = $entity[0].getAttribute('required');
	if(required === 'true' && !readOnly){
		$label.addClass('required_label');
		required = " class='fieldline sw_required' ";
	}else{
		required = "class='fieldline' ";
	}
	$label.appendTo(options.container);
	
	var $refForm = null;
	if(readOnly){
		$refForm = $('<div class="form_value form_value_max_width" style="width:' + valueWidth + '%"></div>').text(value);
	}else{	
		$refForm = $('<div class="form_value form_value_max_width" style="width:' + valueWidth + '%"><div class="ico_fb_space"><input readonly="readonly" type="text" name="' + id + '"' + required + '><a href="#" class="js_workitempicker_button"><span class="ico_fb_work"></span></a></div></div>');
		$refForm.find('input').attr('value', value);
	}
	if ($graphic.attr('hidden') == 'true'){
		$label.hide();
		$refForm.hide();		
	}
	$refForm.appendTo(options.container);

	return options.container;
};

SmartWorks.FormRuntime.RefFormFieldBuilder.buildEx = function(config){
	var options = {
			container : $('<tr></tr>'),
			fieldId: '',
			fieldName: '',
			refFormId: '',
			refFormFieldId: '',
			refRecordId: '',
			value: '',
			columns: 1,
			required: false,
			readOnly: false		
	};
	SmartWorks.extend(options, config);

	var labelWidth = 10;
	if(options.columns >= 1 && options.columns <= 4) labelWidth = 10 * options.columns;
	$formEntity =  $('<formEntity id="' + options.fieldId + '" name="' + options.fieldName + '" systemType="string" required="' + options.required + '" system="false">' +
						'<format type="refFormField" viewingType="refFormField"/>' +
				        	'<refForm id="'+ options.refFormId +'" ver="0">' +
								'<name>null</name><category id="null">null</category><field id="' + refFormFieldId + '"></field>' +
							'</refForm>' +
					    '<graphic hidden="false" readOnly="'+ options.readOnly +'" labelWidth="'+ labelWidth + '"/>' +
					'</formEntity>');
	var $formCol = $('<td class="form_col js_type_refFormField" fieldid="' + options.fieldId+ '" colspan="1" width="500.61775800946384" rowspan="1">');
	$formCol.appendTo(options.container);
	SmartWorks.FormRuntime.RefFormFieldBuilder.build({
			mode : options.readOnly, // view or edit
			container : $formCol,
			entity : $formEntity,
			dataField : SmartWorks.FormRuntime.RefFormFieldBuilder.dataField({
				fieldName: options.fieldName,
				formXml: $formEntity,
				dataField: SmartWorks.FormRuntime.RefFormFieldBuilder.dataField({
					fieldName: options.fieldName,
					formXml: $formEntity,
					refRecordId: options.refRecordId,
					value: options.value					
				})				
			})
	});
	
};

SmartWorks.FormRuntime.RefFormFieldBuilder.serializeObject = function(refFormFields){
	var refFormsJson = {};
	for(var i=0; i<refFormFields.length; i++){
		var refFormField = $(refFormFields[i]);
		refFormsJson[refFormField.attr('fieldId')] =  {refForm: refFormField.attr('refForm'), refFormField: refFormField.attr('refFormField'), refRecordId: refFormField.attr('refRecordId'), value: refFormField.find('input').attr('value')};
	}
	return refFormsJson;
};

SmartWorks.FormRuntime.RefFormFieldBuilder.validate = function(refFormFields){
	var refFormsValid = true;
	for(var i=0; i<refFormFields.length; i++){
		var refFormField = $(refFormFields[i]).find('input.sw_required');
		var value = refFormField.attr('value');
		var refRecordId = $(refFormFields[i]).attr('refRecordId');
		if(isEmpty(value) || isEmpty(refRecordId)){
			refFormField.addClass("sw_error");
			refFormsValid = false;
		}
	}
	return refFormsValid;
};

SmartWorks.FormRuntime.RefFormFieldBuilder.dataField = function(config){
	var options = {
			fieldName: '',
			formXml: '',
			refRecordId: '',
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
			refRecordId: options.refRecordId,
			value: options.value
	};
	return dataField;
};
