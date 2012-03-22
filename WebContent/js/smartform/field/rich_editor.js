SmartWorks.FormRuntime = SmartWorks.FormRuntime || {};

SmartWorks.FormRuntime.RichEditorBuilder = {};

var oEditors = [];
SmartWorks.FormRuntime.RichEditorBuilder.build = function(config) {
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

	var value = (options.dataField && options.dataField.value) || '';
	var $entity = options.entity;
	//var $graphic = $entity.children('graphic');
	var $graphic = $entity.children('graphic');
	var readOnly = $graphic.attr('readOnly') === 'true' || options.mode === 'view';
	var height = $graphic.attr('height');
	var id = $entity.attr('id');
	var name = $entity.attr('name');
	
	var labelWidth = (isEmpty(options.layoutInstance)) ? parseInt($graphic.attr('labelWidth')) : options.layoutInstance.getLabelWidth(id);
	var valueWidth = 100 - labelWidth;
	var $label = $('<span class="form_label" style="width:' + labelWidth + '%"><span>' + name + '</span></div>');
	var required = $entity[0].getAttribute('required');
	if(required === 'true' && !readOnly){
		$label.addClass('required_label');
		required = " class='sw_required js_rich_editor_event' ";
	}else{
		required = "";
	}
	if(!options.refreshData)
		$label.appendTo(options.container);
	
	var $textarea = null;
	if(readOnly){
		$textarea = $('<div class="form_value" style="width:' + valueWidth + '%"></div>').html(value);
	}else{	
		$textarea = $('<div class="form_value" style="width:' + valueWidth + '%"><span' + required + '><textarea style="width:100%; height:' + height + 'px;display:none" id="' + id + '">'+value+'</textarea></span></div>');
	}
	if ($graphic.attr('hidden') == 'true'){
		$label.hide();
		$textarea.hide();		
	}
	if(!options.refreshData){
		$textarea.appendTo(options.container);
		if (!readOnly) {
			nhn.husky.EZCreator.createInIFrame({
				oAppRef: oEditors,
				elPlaceHolder: id,
				sSkinURI: "smarteditor/SEditorSkinKOR.html",
				fCreator: "createSEditorInIFrame"
			});
		}
	}else{
		if(readOnly)
			options.container.find('.form_value').text(value);
		else
			options.container.find('.form_value textarea').attr('value', value);		
	}

	return options.container;
};

SmartWorks.FormRuntime.RichEditorBuilder.buildEx = function(config){
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
						'<format type="richEditor" viewingType="richEditor"/>' +
					    '<graphic hidden="false" readOnly="'+ options.readOnly +'" labelWidth="'+ labelWidth + '"/>' +
					'</formEntity>');
	var $formCol = $('<td class="form_col js_type_richEditor" fieldid="' + options.fieldId+ '" colspan="' + options.colSpan + '" width="' + options.colSpan/options.columns*100 + '%" rowspan="1">');
	$formCol.appendTo(options.container);
	SmartWorks.FormRuntime.RichEditorBuilder.build({
			mode : options.readOnly, // view or edit
			container : $formCol,
			entity : $formEntity,
			dataField : options.value			
	});
	
};

SmartWorks.FormRuntime.RichEditorBuilder.serializeObject = function(richEditors, valueChanged){
	var richEditorsJson = {};
	for(var i=0; i<richEditors.length; i++){
		var richEditor = $(richEditors[i]);
		var id = richEditor.attr('fieldId');
		if(valueChanged && !isEmpty(oEditors) && !isEmpty(oEditors.getById[id])){
			oEditors.getById[id].exec("UPDATE_IR_FIELD", []);
		}
		richEditorsJson[richEditor.attr('fieldId')] = richEditor.find('textarea')[0].value;
	}
	return richEditorsJson;
};

SmartWorks.FormRuntime.RichEditorBuilder.validate = function(richEditors){
	var richEditorsValid = true;
	for(var i=0; i<richEditors.length; i++){
		var richEditor = $(richEditors[i]);
		var id = richEditor.attr('fieldId');
		if(!isEmpty(oEditors)) oEditors.getById[id].exec("UPDATE_IR_FIELD", []);
		var value = richEditor.find('textarea')[0].value;
		var required = richEditor.find('span.sw_required');
		if(!isEmpty(required) && (isEmpty(value) || value === "<br>")){
			richEditor.find('span.sw_required').addClass("sw_error");
			richEditorsValid = false;
		}else{
			richEditor.find('span.sw_required').removeClass("sw_error");
		}
	}
	return richEditorsValid;
};

SmartWorks.FormRuntime.RichEditorBuilder.dataField = function(config){
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
