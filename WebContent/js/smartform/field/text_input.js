SmartWorks.FormRuntime = SmartWorks.FormRuntime || {};

SmartWorks.FormRuntime.TextInputBuilder = {};

SmartWorks.FormRuntime.TextInputBuilder.build = function(config) {
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
	if(required === 'true'){
		$('<span class="essen_n"></span>').appendTo($label);
		required = " class='fieldline required' ";
	}else{
		required = " class='fieldline' ";
	}
	$label.appendTo(options.container);
	
	var $text = null;
	if(readOnly){
		$text = $('<div class="form_value" fieldId="' + id + '" style="width:' + valueWidth + '%"></div>').text(value);
	}else{	
		$text = $('<div class="form_value" style="width:' + valueWidth + '%"><input type="text" fieldId="' + id + '" name="' + id + '"' + required + '></div>').attr('value', value);
	}
	$text.appendTo(options.container);

	return options.container;
};