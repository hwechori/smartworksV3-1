SmartWorks.FormRuntime = SmartWorks.FormRuntime || {};

SmartWorks.FormRuntime.TimeChooserBuilder = {};

SmartWorks.FormRuntime.TimeChooserBuilder.build = function(config) {
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
		required = " class='fieldline js_timepicker required' ";
	}else{
		required = " class='fieldline js_timepicker' ";
	}
	$label.appendTo(options.container);
	
	var $text = null;
	if(readOnly){
		$text = $('<div class="form_value" fieldId="' + id + '"></div>').text(value);
	}else{	
		$text = $('<div class="form_value"><div class="ico_user_space"><input readonly="readonly" type="text" fieldId="' + id + '" name="' + id + '"' + required + '><span class="ico_time"></span></div></div>').attr('value', value);
	}
	$text.appendTo(options.container);

	$.timepicker.setDefaults($.timepicker.regional[currentUser.locale]);
	$('input.js_timepicker').timepicker({
		timeFormat: 'hh:mm',
		hourGrid: 4,
		minuteGrid: 10,
	});
	
	return options.container;
};




