SmartWorks.FormRuntime = SmartWorks.FormRuntime || {};

SmartWorks.FormRuntime.TextInputBuilder = {};

SmartWorks.FormRuntime.TextInputBuilder.build = function(config) {
	var options = {
		mode : 'edit', // view or edit
		container : $('<div></div>'),
		entity : null,
		dataField : ''
	};

	SmartWorks.extend(options, config);

	var value = (options.dataField && options.dataField.value) || '';
	var $entity = options.entity;
	//var $graphic = $entity.children('graphic');
	var $graphic = $entity.children('graphic');
	var readOnly = $graphic.attr('readOnly') === 'true' || options.mode === 'view';
	var id = $entity.attr('id');
	var name = $entity.attr('name');
	
	var $label = $('<label>' + name + '</label>');
	$label.appendTo(options.container);
	
	var $text = null;
	if(readOnly){
		$text = $('<span fieldId="' + id + '"></span>').text(value);
	}else{	
		$text = $('<input type="text" fieldId="' + id + '" name="' + id + '">').attr('value', value);
	}
	$text.appendTo(options.container);

	return options.container;
};