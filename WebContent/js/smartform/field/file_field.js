SmartWorks.FormRuntime = SmartWorks.FormRuntime || {};

SmartWorks.FormRuntime.FileFieldBuilder = {};

SmartWorks.FormRuntime.FileFieldBuilder.build = function(config) {
	var options = {
		mode : 'view', // view or edit
		container : $('<div></div>'),
		entity : null,
		dataField : '',
		layoutInstance : null
	};

	SmartWorks.extend(options, config);
	options.container.html('');

	var value = (options.dataField && options.dataField.value) || '';
	var isTempfile = (options.dataField && options.dataField.isTempfile) || false;
	var $entity = options.entity;
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
		required = ' class="sw_required"';
	}else{
		required = '';		
	}
	$label.appendTo(options.container);
	
	var $file = null;
		
	$file = $('<div class="form_value form_value_max_width" style="width:' + valueWidth + '%"><span id="' + id + '"' + required + '></span></div>');

	if ($graphic.attr('hidden') == 'true'){
		$label.hide();
		$file.hide();		
	}
	$file.appendTo(options.container);

	if (readOnly) {
		viewFiles(value, $('#'+id));
	} else {
		var fileList = '';
		if(isTempfile){
			fileList = 	(options.dataField && options.dataField.fileList) || '';
		}
		createUploader(value, $('#'+id), true, false, isTempfile, fileList);
	}
	return options.container;

};

SmartWorks.FormRuntime.FileFieldBuilder.buildEx = function(config){
	var options = {
			container : $('<tr></tr>'),
			fieldId: '',
			fieldName: '',
			groupId: '',
			columns: 1,
			required: false,
			readOnly: false		
	};
	SmartWorks.extend(options, config);

	var labelWidth = 10;
	if(options.columns >= 1 && options.columns <= 4) labelWidth = 10 * options.columns;
	$formEntity =  $('<formEntity id="' + options.fieldId + '" name="' + options.fieldName + '" systemType="string" required="' + options.required + '" system="false">' +
						'<format type="fileField" viewingType="fileField"/>' +
					    '<graphic hidden="false" readOnly="'+ options.readOnly +'" labelWidth="'+ labelWidth + '"/>' +
					'</formEntity>');
	var $formCol = $('<td class="form_col js_type_fileField" fieldid="' + options.fieldId+ '" colspan="1" width="500.61775800946384" rowspan="1">');
	$formCol.appendTo(options.container);
	SmartWorks.FormRuntime.FileFieldBuilder.build({
			mode : options.readOnly, // view or edit
			container : $formCol,
			entity : $formEntity,
			dataField : SmartWorks.FormRuntime.FileFieldBuilder.dataField({
				fieldName: options.fieldName,
				formXml: $formEntity,
				groupId: options.groupId
			})
	});
	
};

SmartWorks.FormRuntime.FileFieldBuilder.serializeObject = function(fileFields){
	var fileUploaders = fileFields.find('.qq-uploader');
	var filesJson = {};
	for(var i=0; i<fileUploaders.length; i++){
		var fileUploader = $(fileUploaders[i]);
		var fieldId = fileUploader.parent('span').attr('id');
		var fileJson = { groupId : fileUploader.attr('groupId')};
		var files = fileUploader.find('.qq-upload-success');
		var fileInfos = new Array();
		for(var j=0; j<files.length; j++){
			var file = $(files[j]);
			fileInfos.push({fileId : file.attr('fileId'), fileName : file.attr('fileName'), fileSize : file.attr('fileSize')});
		}
		fileJson['files'] = fileInfos;
		filesJson[fieldId] =  fileJson;
	}
	return filesJson;
};

SmartWorks.FormRuntime.FileFieldBuilder.validate = function(fileFields){
	var fileUploaders = fileFields.find('.sw_required').find('.qq-uploader');
	var filesValid = true;
	for(var i=0; i<fileUploaders.length; i++){
		var fileUploader = $(fileUploaders[i]);
		var files = fileUploader.find('.qq-upload-success');
		if(isEmpty(files)){
			fileUploader.parents('.js_type_fileField:first').find('span.sw_required').addClass("sw_error");
			filesValid = false;
		}
	}
	return filesValid;
};

SmartWorks.FormRuntime.FileFieldBuilder.dataField = function(config){
	var options = {
			fieldName: '',
			formXml: '',
			groupId: '',
			isTempfile: false,
			isMultiple: false,
			isProfile:false,
			fileList: null
	};

	SmartWorks.extend(options, config);
	$formXml = $(options.formXml);
	var dataField = {};
	var fieldId = $formXml.find('formEntity[name="'+options.fieldName+'"]').attr('id');
	if(isEmpty(fieldId)) fieldId = ($formXml.attr("name") === options.fieldName) ? $formXml.attr('id') : "";
	if(isEmpty($formXml) || isEmpty(fieldId)) return dataField;
	dataField = {
			id: fieldId,
			value: options.groupId,
			isTempfile: options.isTempfile,
			isMultiple: options.isMultiple,
			isProfile: options.isProfiel,
			fileList: options.fileList
	};
	return dataField;
};
