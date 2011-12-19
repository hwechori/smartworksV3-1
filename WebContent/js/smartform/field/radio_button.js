SmartWorks.FormRuntime = SmartWorks.FormRuntime || {};

SmartWorks.FormRuntime.RadioButtonBuilder = {};

SmartWorks.FormRuntime.RadioButtonBuilder.build = function(config) {
	var options = {
		mode : 'edit', // view or edit
		container : $('<div></div>'),
		entity : null,
		value : '',
		dataField : ''
	};

	SmartWorks.extend(options, config);

	var value = (options.dataField && options.dataField.value) || '';
	var $entity = options.entity;
	var $graphic = $entity.children('graphic');
	var $format = $entity.children('format');

	var readOnly = $graphic.attr('readOnly') == 'true' || options.mode == 'view';
	var id = $entity.attr('id');
	var name = $entity.attr('name');
	
	var $label = $('<div class="form_label">' + name + '</div>');
	var required = $entity[0].getAttribute('required');
	if(required === 'true'){
		$('<span class="essen_n"></span>').appendTo($label);
		required = " class='required' ";
	}else{
		required = "";
	}
	$label.appendTo(options.container);
	
	var $staticItems = $format.find('list staticItems staticItem');
	var $input_container = $('<td></td>');
	
	for ( var i = 0; i < $staticItems.length; i++) {
		var $staticItem = $staticItems.eq(i);
		var text = $staticItem.text();
		var checked = (value === text ) ? 'checked' : '' ;

		console.dir(checked);
		
		var $input = $('<div class="form_value"><input type="radio" ' + checked + ' name="' + id + '" value="' + text + '"' + required + '>' + text + '</input><div>');
		
		$input.attr('fieldId', id);
		if (readOnly) {
			$input.attr('disabled', 'disabled');
		}
		$input.appendTo($input_container);
	}

	$input_container.appendTo(options.container);

	if ($graphic.attr('hidden') == 'true') {
		$label.hide();
		$input_container.hide();
	}

	return options.container;
};
