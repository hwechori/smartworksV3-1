SmartWorks.FormFieldBuilder = {};
SmartWorks.FormFieldBuilder.build = function(mode, $target, $entity) {
	var type = $entity.find('format').attr('type');

	switch(type) {
	case 'radioButton' :
		SmartWorks.FormRuntime.RadioButtonBuilder.build({
			mode : mode, // view or edit
			container : $target,
			entity : $entity
		});
		return;
	default :
		SmartWorks.FormRuntime.CurrencyInputBuilder.build({
			mode : mode, // view or edit
			container : $target,
			entity : $entity
		});
		return;
	};
};