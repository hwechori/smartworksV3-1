SmartWorks.FormRuntime = SmartWorks.FormRuntime || {};

SmartWorks.FormRuntime.DateTimeChooserBuilder = {};

SmartWorks.FormRuntime.DateTimeChooserBuilder.build = function(config) {
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
		required = " class='fieldline js_todaytimepicker required' ";
	}else{
		required = " class='fieldline js_todaytimepicker' ";
	}
	$label.appendTo(options.container);
	
	var $text = null;
	if(readOnly){
		$text = $('<div class="form_value" fieldId="' + id + '"></div>').text(value);
	}else{	
		$text = $('<div class="form_value"><input readonly="readonly" type="text" fieldId="' + id + '" name="' + id + '"' + required + '></div>').attr('value', value);
	}
	$text.appendTo(options.container);

	$.datepicker.setDefaults($.datepicker.regional[currentUser.locale]);
	$.timepicker.setDefaults($.timepicker.regional[currentUser.locale]);
	$('input.js_todaytimepicker').datetimepicker({
		defaultDate : new Date(),
		dateFormat : 'yy.mm.dd',
		timeFormat: 'hh:mm',
		hourGrid: 4,
		minuteGrid: 10,
	});
	
	return options.container;
};



