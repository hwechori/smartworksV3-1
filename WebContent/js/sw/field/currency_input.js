SmartWorks.FormRuntime = SmartWorks.FormRuntime || {};

SmartWorks.FormRuntime.CurrencyInputBuilder = {};

SmartWorks.FormRuntime.CurrencyInputBuilder.build = function(config) {
	var options = {
		mode : 'view', // view or edit
		container : $('<div></div>'),
		entity : null,
		value : ''
	};

	SmartWorks.extend(options, config);

	var $entity = options.entity;
	var $graphic = $entity.children('graphic');

	var readOnly = $graphic.attr('readOnly') === 'true' || options.mode === 'view';
	var id = $entity.attr('id');
	var name = $entity.attr('name');
	
	var $label = $('<label>' + name + '</label>');
	$label.appendTo(options.container);
	
	var $currency = null;
	if(readOnly){
		$currency = $('<p fieldId="' + id + '"></p>').text(options.value);
	}else{	
		$currency = $('<input type="text" fieldId="' + id + '" name="' + id + '">').attr('value', options.value);
	}
	$currency.appendTo(options.container);

	return options.container;
};