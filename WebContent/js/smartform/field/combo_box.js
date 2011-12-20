SmartWorks.FormRuntime = SmartWorks.FormRuntime || {};

SmartWorks.FormRuntime.ComboBoxBuilder = {};

SmartWorks.FormRuntime.ComboBoxBuilder.build = function(config) {
	var options = {
		mode : 'edit', // view or edit
		container : $('<div></div>'),
		entity : null,
		dataField : '',
		layoutInstance : null
	};

	SmartWorks.extend(options, config);
	var value = (options.dataField && options.dataField.value) || '';
	var $entity = options.entity;
	var $graphic = $entity.children('graphic');
	var $format = $entity.children('format');

	var readOnly = $graphic.attr('readOnly') == 'true' || options.mode == 'view';
	var id = $entity.attr('id');
	var name = $entity.attr('name');
	
	var labelWidth = options.layoutInstance.getLabelWidth(id);
	var valueWidth = 100 - labelWidth;
	var $label = $('<div class="form_label" style="width:' + labelWidth + '%">' + name + '</div>');
	var required = $entity[0].getAttribute('required');
	if(required === 'true' && !readOnly){
		$('<span class="essen_n"></span>').appendTo($label);
		required = " class='form_select_box required' ";
	}else{
		required = " class='form_select_box' ";		
	}
		
	$label.appendTo(options.container);
	
	var $staticItems = $format.find('list staticItems staticItem');
	

	var $input = $('<div class="form_value" style="width:' + valueWidth + '%"><select name="' + id + '"' + required + '></select><div>');

	$input.attr('fieldId', id);
	if (readOnly) {
		$input.attr('disabled', 'disabled');
	}else{
		required = "";
	}
	
	for ( var i = 0; i < $staticItems.length; i++) {
		var $staticItem = $staticItems.eq(i);
		var text = $staticItem.text();
		var selected = (value === text ) ? 'selected' : '' ;

		$option = $('<option value="' + text + '" ' + selected + '>'+text+'</option>');
		
		$option.appendTo($input.find('select'));
	}
	$input.appendTo(options.container);

	if ($graphic.attr('hidden') == 'true') {
		$label.hide();
		$input.hide();
	}
	return options.container;
};
