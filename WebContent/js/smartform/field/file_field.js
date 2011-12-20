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
	var value = (options.dataField && options.dataField.value) || '';
	var isTempfile = (options.dataField && options.dataField.isTempfile) || '';
	var $entity = options.entity;
	var $graphic = $entity.children('graphic');

	var readOnly = $graphic.attr('readOnly') === 'true' || options.mode === 'view';
	var id = $entity.attr('id');
	var name = $entity.attr('name');
	
	var labelWidth = options.layoutInstance.getLabelWidth(id);
	var valueWidth = 100 - labelWidth;
	var $label = $('<span class="form_label" style="width:' + labelWidth + '%">' + name + '</span>');
	var required = $entity[0].getAttribute('required');
	if(required === 'true' && !readOnly){
		$('<span class="essen_n"></span>').appendTo($label);
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
	} else if(isTempfile==='true'){
		loadTempFiles(value, $('#'+id), {
			fileId : (options.dataField && options.dataField.fileId) || '',
			fileName : (options.dataField && options.dataField.fileName) || '',
			fileText : (options.dataField && options.dataField.fileText) || '',
			fileSize : (options.dataField && options.dataField.fileSize) || 0		
		});
	} else {
		createUploader(value, $('#'+id), true, false);
	}
	return options.container;

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
		if(files.length == 0){
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
			fileId: '',
			fileName: '',
			fileText: '',
			fileSize: 0,
			isMultiple: false,
			isProfile:false
	};

	SmartWorks.extend(options, config);
	$formXml = $(options.formXml);
	var dataField = {};
	var fieldId = $formXml.find('formEntity[name="'+options.fieldName+'"]').attr('id');
	if(isZeroLength($formXml) || isEmpty(fieldId)) return dataField;
	
	dataField = {
			id: fieldId,
			value: options.groupId,
			isTempfile: options.isTempfile,
			fileId: options.fileId,
			fileName: options.fileName,
			fileText: options.fileText,
			fileSize: options.fileSize,
			isMultiple: options.isMultiple,
			isProfile: options.isProfiel
	};
	return dataField;
};
