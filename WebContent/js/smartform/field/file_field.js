SmartWorks.FormRuntime = SmartWorks.FormRuntime || {};

SmartWorks.FormRuntime.FileFieldBuilder = {};

SmartWorks.FormRuntime.FileFieldBuilder.build = function(config) {
	var options = {
		mode : 'view', // view or edit
		container : $('<div></div>'),
		entity : null,
		dataField : ''
	};

	SmartWorks.extend(options, config);
	var value = (options.dataField && options.dataField.value) || '';
	var $entity = options.entity;
	var $graphic = $entity.children('graphic');

	var readOnly = $graphic.attr('readOnly') === 'true' || options.mode === 'view';
	var id = $entity.attr('id');
	var name = $entity.attr('name');
	
	var $label = $('<label>' + name + '</label>');
	$label.appendTo(options.container);
	
	var $file = null;
		
	$file = $('<span id="' + id + '"></span>');
	$file.appendTo(options.container);
	if (readOnly) {
		viewFiles(value, id);
	} else {
		createUploader(value, id);
	}
//	if(true){
//		console.log($(options.container).find('div.qq-upload-button'));
//		$(options.container).find('div.qq-upload-button').hide();
//	}
	return options.container;
};


