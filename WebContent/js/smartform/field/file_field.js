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
	var $entity = options.entity;
	var $graphic = $entity.children('graphic');

	var readOnly = $graphic.attr('readOnly') === 'true' || options.mode === 'view';
	var id = $entity.attr('id');
	var name = $entity.attr('name');
	
	var $label = $('<div class="form_label">' + name + '</div>');
	if($entity[0].getAttribute('required') === 'true'){
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
		
	$file = $('<div class="form_value" style="width:' + valueWidth + '%"><span id="' + id + '"' + required + '></span></div>');
	$file.appendTo(options.container);

	if (readOnly) {
		viewFiles(value, $('#'+id));
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
			fileInfos.push({fileId : file.attr('fileId')}, {fileName : file.attr('fileName')});
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
