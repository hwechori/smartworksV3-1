SmartWorks.FormRuntime = SmartWorks.FormRuntime || {};

SmartWorks.FormRuntime.DateChooserBuilder = {};

SmartWorks.FormRuntime.DateChooserBuilder.build = function(config) {
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
	
	var $text = null;
	if(readOnly){
		$text = $('<span fieldId="' + id + '"></span>').text(options.value);
	}else{	
		$text = $('<input class="fieldline js_todaypicker" readonly="readonly" type="text" fieldId="' + id + '" name="' + id + '">').attr('value', options.value);
	}
	$text.appendTo(options.container);
	
	$.datepicker.setDefaults($.datepicker.regional[currentUser.locale]);
	$('input.js_todaypicker').datepicker({
		defaultDate : new Date(),
		dateFormat : 'yy.mm.dd'
	});
	
	return options.container;
};



