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
	
	var $label = $('<td>' + name + '</td>');
	if($entity[0].getAttribute('required') === 'true'){
		$('<span class="essen_n"></span>').appendTo($label);
	}
	$label.appendTo(options.container);
	
	var $file = null;
		
	$file = $('<td id="' + id + '"></td>');
	$file.appendTo(options.container);

	if (readOnly) {
		viewFiles(value, $('#'+id));
	} else {
		createUploader(value, $('#'+id));
	}
	return options.container;

};
