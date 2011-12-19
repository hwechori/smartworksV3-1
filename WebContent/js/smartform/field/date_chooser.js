SmartWorks.FormRuntime = SmartWorks.FormRuntime || {};

SmartWorks.FormRuntime.DateChooserBuilder = {};

SmartWorks.FormRuntime.DateChooserBuilder.build = function(config) {
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
		required = " class='fieldline js_todaypicker required' ";
	}else{
		required = " class='fieldline js_todaypicker' ";
	}
	$label.appendTo(options.container);
	
	var $text = null;
	if(readOnly){
		$text = $('<div class="form_value" fieldId="' + id + '"></div>').text(value);
	}else{	
		$text = $('<div class="form_value"><div class="ico_user_space"><input readonly="readonly" type="text" fieldId="' + id + '" name="' + id + '"' + required + '><span class="ico_date"></span></div></div>').attr('value', value);
	}
	$text.appendTo(options.container);
	
	$.datepicker.setDefaults($.datepicker.regional[currentUser.locale]);
	$('input.js_todaypicker').datepicker({
		defaultDate : new Date(),
		dateFormat : 'yy.mm.dd'
	});
	
	return options.container;
};



