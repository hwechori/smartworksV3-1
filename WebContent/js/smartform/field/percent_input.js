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
	var name = $entity.attr('name');

	var $label = $('<div class="form_label">' + name + '</div>');
	var required = $entity[0].getAttribute('required');
	if(required === 'true' && !readOnly){
		$('<span class="essen_n"></span>').appendTo($label);
		required = " class='fieldline required' ";
	}else{
		required = " class='fieldline' ";
	}
	$label.appendTo(options.container);
	

	var percentValue = (value * 100) + '%';
	
	
	$html = $('<td class="percent" id="' + id + '_container"></td>');
	var $percent = null;
	
	if (readOnly) {
		$percent = $('<div id="' + id + '_input"></div>').text(percentValue);
	} else {
		$percent = $('<div class="form_value"><input class="text_align_r" id="' + id + '" type="text" fieldId="' + SmartWorks.generateFormFieldId(options.workspaceId, id) + '"' + required + '/></div>')
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






