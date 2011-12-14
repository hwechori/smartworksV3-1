SmartWorks.FormRuntime = SmartWorks.FormRuntime || {};

SmartWorks.FormRuntime.EmailInputBuilder = {};

SmartWorks.FormRuntime.EmailInputBuilder.build = function(config) {
	var options = {
		mode : 'edit', // view or edit
		container : $('<div></div>'),
		entity : null,
		value : ''
	};

	SmartWorks.extend(options, config);

	var $entity = options.entity;
	//var $graphic = $entity.children('graphic');
	var $graphic = $entity.children('graphic');
	var readOnly = $graphic.attr('readOnly') === 'true' || options.mode === 'view';
	var id = $entity.attr('id');
	var name = $entity.attr('name');
	
	var $label = $('<label>' + name + '</label>');
	$label.appendTo(options.container);
	
	var $email = null;
	if(readOnly){
		$email = $('<span fieldId="' + id + '"></span>').text(options.value);
	}else{	
		$email = $('<input type="text" class="email js_email_input" fieldId="' + id + '" name="' + id + '">').attr('value', options.value);
	}
	$email.appendTo(options.container);

	return options.container;
};





