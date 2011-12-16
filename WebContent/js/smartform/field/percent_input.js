SmartWorks.FormRuntime = SmartWorks.FormRuntime || {};

SmartWorks.FormRuntime.PercentInputBuilder = {};

SmartWorks.FormRuntime.PercentInputBuilder.build = function(config) {
	var options = {
		mode : 'edit', // view or edit
		container : $('<div></div>'),
		entity : '',
		dataField : ''
	};

	SmartWorks.extend(options, config);
	var value = (options.dataField && options.dataField.value) || '';
	$entity = options.entity;
	$graphic = $entity.children('graphic');
	$format = $entity.children('format');

	var readOnly = $graphic.attr('readOnly') == 'true' || options.mode == 'view';
	var id = $entity.attr('id');

	var percentValue = (value * 100) + '%';
	
	
	$html = $('<div class="percent" id="' + id + '_container"></div>');
	var $percent = null;
	
	if (readOnly) {
		$percent = $('<p id="' + id + '_input"></p>').text(percentValue);
	} else {
		$percent = $('<input id="' + id + '_input" type="text" fieldId="' + SmartWorks.generateFormFieldId(options.workspaceId, id) + '"/>')
				.attr('value', percentValue);
	}
	
	$percent.appendTo($html);

	if ($graphic.attr('hidden') == 'true')
		$html.hide();

	$html.appendTo(options.container);

	return options.container;
};

$('.percent input').live('blur', function(e) {
	$input = $(e.target);
	
	var value = $input.attr('value');
	
	value = (value * 100) + '';
	
	var idx = value.lastIndexOf('%');
	
	if(idx === -1)
		$input.attr('value', value + '%');
});

$('.percent input').live('focusin', function(e) {
	$input = $(e.target);
	
	var value = $input.attr('value');
	
	var idx = value.lastIndexOf('%');
	
	if(idx > -1)
		value = value.substring(0, idx);
	
	value = (parseFloat(value) / 100) + '';
	
	$input.attr('value', value);
});



$('.percent input').live('keyup', function(e) {
	var e = window.event || e;
	var keyUnicode = e.charCode || e.keyCode;
	if (e !== undefined) {
		if ((keyUnicode < 48 || keyUnicode > 57)) {
			if (keyUnicode == 190) {
				if (this.value.indexOf('.') != (this.value.length-1) ) {
					var value = this.value;
					this.value = value.substring(0, value.length -1);
				}
			} else {
				var value = this.value;
				this.value = value.substring(0, value.length -1);
			}
		}
	}
});






