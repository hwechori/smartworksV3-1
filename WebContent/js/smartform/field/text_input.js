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
	
	var $label = $('<td>' + name + '</td>');
	if($entity[0].getAttribute('required') === 'true'){
		$('<span class="essen_n"></span>').appendTo($label);
	}
	$label.appendTo(options.container);
	
	var $text = null;
	if(readOnly){
		$text = $('<td fieldId="' + id + '"></td>').text(value);
	}else{	
		$text = $('<td><input type="text" class="fieldline" fieldId="' + id + '" name="' + id + '"></td>').attr('value', value);
	}
	$text.appendTo(options.container);

	return options.container;
};