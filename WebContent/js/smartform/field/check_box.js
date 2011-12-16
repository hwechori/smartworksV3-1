SmartWorks.FormRuntime = SmartWorks.FormRuntime || {};

SmartWorks.FormRuntime.CheckBoxBuilder = {};

SmartWorks.FormRuntime.CheckBoxBuilder.build = function(config) {
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
	
	var $label = $('<label>' + name + '</label>');
	$label.appendTo(options.container);

	var checked = (value) ? 'checked' : '' ;
	
	var $check = null;
	if(readOnly){
		$check = $('<span></span>').text(value);
	}else{	
		$check = $('<input type="checkbox" '+ checked +' fieldId="' + id + '" name="' + id + '">');
	}
	$check.appendTo(options.container);

	return options.container;
};