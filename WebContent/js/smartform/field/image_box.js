SmartWorks.FormRuntime = SmartWorks.FormRuntime || {};

SmartWorks.FormRuntime.ImageBoxBuilder = {};

SmartWorks.FormRuntime.ImageBoxBuilder.build = function(config) {
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
	var $entity = options.entity;
	var $graphic = $entity.children('graphic');
	var picWidth = parseFloat($graphic.attr('pictureWidth'));
	var picHeight = parseFloat($graphic.attr('pictureHeight'));

	var readOnly = $graphic.attr('readOnly') === 'true' || options.mode === 'view';
	var id = $entity.attr('id');
	var name = $entity.attr('name');

	var labelWidth = (isEmpty(options.layoutInstance)) ? parseInt($graphic.attr('labelWidth')) : options.layoutInstance.getLabelWidth(id);
	var valueWidth = 100 - labelWidth;

	var required = $entity[0].getAttribute('required');
	if(required === 'true' && !readOnly){
		$required = $('<span class="essen_n"></span>');
		required = ' class="form_value form_value_max_width sw_required" ';
	}else{
		required = ' class="form_value form_value_max_width" ';
	}

	var picSize = 'style="min-height:20px;width:' + ((picWidth) ? picWidth : 300) + 'px;' + ((picHeight) ? ('height="' + picHeight + 'px;"') : '"' ); 
	var $image = $('<div ' + required + ' style="width:' + valueWidth + '%"><img class="form_value js_auto_picture" ' + picSize + '></img><div>');
	var $label = null;
		
	$label = $('<div class="form_label" style="width:' + labelWidth + '%"><span id="' + id + '"></span></div>').append($required);
	$label.appendTo(options.container);
	$image.appendTo(options.container);	
	if ($graphic.attr('hidden') == 'true'){
		$label.hide();
		$image.hide();		
	}

	if (!readOnly) {
		createUploader(value, $('#'+id), false, true);
	}
	return options.container;

};
SmartWorks.FormRuntime.ImageBoxBuilder.buildEx = function(config){
	var options = {
			container : $('<tr></tr>'),
			fieldId: '',
			fieldName: '',
			groupId: '',
			pictureWidth: 300,
			pictureHeight: 0,
			required: false,
			readOnly: false		
	};
	SmartWorks.extend(options, config);

	var labelWidth = 10;
	if(options.columns >= 1 && options.columns <= 4) labelWidth = 10 * options.columns;
	$formEntity =  $('<formEntity id="' + options.fieldId + '" name="' + options.fieldName + '" systemType="string" required="' + options.required + '" system="false">' +
						'<format type="imageBox" viewingType="imageBox"/>' +
					    '<graphic hidden="false" readOnly="'+ options.readOnly + '" labelWidth="'+ labelWidth + '" pictureWidth="'+ options.pictureWidth + '" pictureHeight="' + options.pictureHeight + '"/>' +
					'</formEntity>');
	var $formCol = $('<td class="form_col js_type_imageBox" fieldid="' + options.fieldId + '"  colspan="1" width="500.61775800946384" rowspan="1">');
	$formCol.appendTo(options.container);
	SmartWorks.FormRuntime.ImageBoxBuilder.build({
			mode : options.readOnly, // view or edit
			container : $formCol,
			entity : $formEntity,
			dataField : SmartWorks.FormRuntime.ImageBoxBuilder.dataField({
				fieldName: options.fieldName,
				formXml: $formEntity,
				groupId: options.groupId
			})
	});
	
};

SmartWorks.FormRuntime.ImageBoxBuilder.serializeObject = function(imageBoxs){
	var fileUploaders = imageBoxs.find('.qq-uploader');
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

SmartWorks.FormRuntime.ImageBoxBuilder.validate = function(imageBoxs){
	if(isEmpty(imageBoxs.find('.sw_required'))) return true;
	var fileUploaders = imageBoxs.find('.qq-uploader');
	var imagesValid = true;
	for(var i=0; i<fileUploaders.length; i++){
		var fileUploader = $(fileUploaders[i]);
		var files = fileUploader.find('.qq-upload-success');
		if(isEmpty(files)){
			fileUploader.parents('.js_type_imageBox:first').find('div.sw_required').addClass("sw_error");
			imagesValid = false;
		}
	}
	return imagesValid;
};

SmartWorks.FormRuntime.ImageBoxBuilder.dataField = function(config){
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
	if(isEmpty($formXml) || isEmpty(fieldId)) return dataField;
	
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
