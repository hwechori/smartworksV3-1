SmartWorks.FormFieldBuilder = {};
SmartWorks.FormFieldBuilder.build = function(mode, $target, $entity, dataField) {
	var type = $entity.find('format').attr('type');
	switch(type) {
	case 'checkBox' :
		SmartWorks.FormRuntime.CheckBoxBuilder.build({
			mode : mode, // view or edit
			container : $target,
			entity : $entity,
			dataField : dataField
		});
		return;		
	case 'comboBox' :
		SmartWorks.FormRuntime.ComboBoxBuilder.build({
			mode : mode, // view or edit
			container : $target,
			entity : $entity,
			dataField : dataField
		});
		return;		
	case 'currencyInput' :
		SmartWorks.FormRuntime.CurrencyInputBuilder.build({
			mode : mode, // view or edit
			container : $target,
			entity : $entity,
			dataField : dataField
		});
		return;		
	case 'dateChooser' :
		SmartWorks.FormRuntime.DateChooserBuilder.build({
			mode : mode, // view or edit
			container : $target,
			entity : $entity,
			dataField : dataField
		});
		return;
	case 'emailIDInput' :
		SmartWorks.FormRuntime.EmailInputBuilder.build({
			mode : mode, // view or edit
			container : $target,
			entity : $entity,
			dataField : dataField
		});
		return;
	case 'fileField' :
		SmartWorks.FormRuntime.FileFieldBuilder.build({
			mode : mode, // view or edit
			container : $target,
			entity : $entity,
			dataField : dataField
		});
		return;
	case 'numberInput' :
		SmartWorks.FormRuntime.NumberInputBuilder.build({
			mode : mode, // view or edit
			container : $target,
			entity : $entity,
			dataField : dataField
		});
		return;
	case 'percentInput' :
		SmartWorks.FormRuntime.PercentInputBuilder.build({
			mode : mode, // view or edit
			container : $target,
			entity : $entity,
			dataField : dataField
		});
		return;
	case 'radioButton' :
		SmartWorks.FormRuntime.RadioButtonBuilder.build({
			mode : mode, // view or edit
			container : $target,
			entity : $entity,
			dataField : dataField
		});
		return;
	case 'richEditor' :
		SmartWorks.FormRuntime.RichEditorBuilder.build({
			mode : mode, // view or edit
			container : $target,
			entity : $entity,
			dataField : dataField
		});
		return;
	case 'textInput' :
		SmartWorks.FormRuntime.TextInputBuilder.build({
			mode : mode, // view or edit
			container : $target,
			entity : $entity,
			dataField : dataField
		});
		return;
	case 'timeField' :
		SmartWorks.FormRuntime.TimeChooserBuilder.build({
			mode : mode, // view or edit
			container : $target,
			entity : $entity,
			dataField : dataField
		});
		return;
	case 'userField' :
		SmartWorks.FormRuntime.UserFieldBuilder.build({
			mode : mode, // view or edit
			container : $target,
			entity : $entity,
			dataField : dataField
		});
		return;	
	case 'dateTimeField' :
		SmartWorks.FormRuntime.DateTimeChooserBuilder.build({
			mode : mode, // view or edit
			container : $target,
			entity : $entity,
			dataField : dataField
		});
		return;	
	default :
		SmartWorks.FormRuntime.TextInputBuilder.build({
			mode : mode, // view or edit
			container : $target,
			entity : $entity,
			dataField : dataField
		});
		return;
	};
};