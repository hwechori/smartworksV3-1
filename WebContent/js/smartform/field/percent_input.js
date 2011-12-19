SmartWorks.FormRuntime = SmartWorks.FormRuntime || {};

SmartWorks.FormRuntime.PercentInputBuilder = {};

SmartWorks.FormRuntime.PercentInputBuilder.build = function(config) {
	var options = {
		mode : 'edit', // view or edit
		container : $('<div></div>'),
		entity : '',
		dataField : '',
		layoutInstance : null
	};

	SmartWorks.extend(options, config);
	var value = (options.dataField && options.dataField.value) || '';
	$entity = options.entity;
	$graphic = $entity.children('graphic');
	$format = $entity.children('format');

	var readOnly = $graphic.attr('readOnly') == 'true' || options.mode == 'view';
	var id = $entity.attr('id');
	var name = $entity.attr('name');

	var labelWidth = options.layoutInstance.getLabelWidth(id);
	var valueWidth = 100 - labelWidth;
	var $label = $('<div class="form_label" style="width:' + labelWidth + '%">' + name + '</div>');
	var required = $entity[0].getAttribute('required');
	if(required === 'true' && !readOnly){
		$('<span class="essen_n"></span>').appendTo($label);
		required = " class='fieldline required' ";
	}else{
		required = " class='fieldline' ";
	}
	$label.appendTo(options.container);
	
	var percentValue = (value * 100) + '%';
		
	var $percent = null;
	
	if (readOnly) {
		$percent = $('<div class="form_value text_align_r" style="width:' + valueWidth + '%"></div>').text(percentValue);
	} else {
		$percent = $('<div class="form_value" style="width:' + valueWidth + '%"><input class="text_align_r" type="text" name="' + id + '"'  + required + '/></div>')
				.attr('value', percentValue);
	}

	if ($graphic.attr('hidden') == 'true'){
		$label.hide();
		$percent.hide();		
	}
	$percent.appendTo(options.container);
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






