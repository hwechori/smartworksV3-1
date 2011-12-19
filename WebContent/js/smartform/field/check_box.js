SmartWorks.FormRuntime = SmartWorks.FormRuntime || {};

SmartWorks.FormRuntime.CheckBoxBuilder = {};

SmartWorks.FormRuntime.CheckBoxBuilder.build = function(config) {
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
	//var $graphic = $entity.children('graphic');
	var $graphic = $entity.children('graphic');
	var readOnly = $graphic.attr('readOnly') === 'true' || options.mode === 'view';
	var id = $entity.attr('id');
	var name = $entity.attr('name');

	var labelWidth = options.layoutInstance.getLabelWidth(id);
	var valueWidth = 100 - labelWidth;
	var $label = $('<div class="form_label" style="width:' + labelWidth + '%">' + name + '</div>');
	var required = $entity[0].getAttribute('required');
	if(required === 'true' && !readOnly){
		$('<span class="essen_n"></span>').appendTo($label);
		required = " class='required' ";
	}else{
		required = "";
	}
	$label.appendTo(options.container);

	var checked = (value) ? 'checked' : '' ;
	
	var $check = null;
	if(readOnly){
		$check = $('<div class="form_value" style="width:' + valueWidth + '%"></div>').text(value);
	}else{	
		$check = $('<div class="form_value" style="width:' + valueWidth + '%"><input type="checkbox" '+ checked + ' name="' + id + '"' + required +  '><div>');
	}

	if ($graphic.attr('hidden') == 'true'){
		$label.hide();
		$check.hide();		
	}
	$check.appendTo(options.container);

	return options.container;
};
