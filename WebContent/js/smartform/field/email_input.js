SmartWorks.FormRuntime = SmartWorks.FormRuntime || {};

SmartWorks.FormRuntime.EmailInputBuilder = {};

SmartWorks.FormRuntime.EmailInputBuilder.build = function(config) {
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
	
	var $label = $('<div class="form_label">' + name + '</div>');
	var required = $entity[0].getAttribute('required');
	if(required === 'true' && !readOnly){
		$('<span class="essen_n"></span>').appendTo($label);
		required = " class='fieldline required email' ";
	}else{
		required = " class='fieldline email' ";
	}
	$label.appendTo(options.container);
	
	var $email = null;
	if(readOnly){
		$email = $('<div class="form_value" fieldId="' + id + '"></div>').text(value);
	}else{	
		$email = $('<div class="form_value"><input type="text" fieldId="' + id + '" name="' + id + '"' + required + '></div>').attr('value', value);
	}
	$email.appendTo(options.container);

	return options.container;
};





