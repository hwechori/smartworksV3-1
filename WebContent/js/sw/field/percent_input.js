SmartWorks.FormRuntime = SmartWorks.FormRuntime || {};

SmartWorks.FormRuntime.PercentInputBuilder = {};

SmartWorks.FormRuntime.PercentInputBuilder.build = function(config) {
	var options = {
		mode : 'view', // view or edit
		container : $('<div></div>'),
		entityXml : '',
		workspaceId : '',
		id : '',
		suffix : '%',
		value : ''
	};

	SmartWorks.extend(options, config);

	$entity = $(options.entityXml);
	$graphic = $entity.children('graphic');
	$format = $entity.children('format');

	var readOnly = $graphic.attr('readOnly') == 'true' || options.mode == 'view';
	var id = $entity.attr('id');

	$html = $('<div class="percent" id="' + id + '_container"></div>');
	var $percent = null;
	
	if (readOnly) {
		$percent = $('<p id="' + id + '_input"></p>').text(options.value);
	} else {
		$percent = $('<input id="' + id + '_input" type="text" fieldId="' + SmartWorks.generateFormFieldId(options.workspaceId, id) + '"/>')
				.attr('value', options.value);
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
	var idx = value.lastIndexOf('%');
	
	if(idx === -1)
		$input.attr('value', value + '%');
});