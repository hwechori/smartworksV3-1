SmartWorks.FormRuntime = SmartWorks.FormRuntime || {};

SmartWorks.FormRuntime.RichEditorBuilder = {};

SmartWorks.FormRuntime.RichEditorBuilder.build = function(config) {
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
	var $label = $('<span class="form_label" style="width:' + labelWidth + '%">' + name + '</span>');
	var required = $entity[0].getAttribute('required');
	if(required === 'true' && !readOnly){
		$('<span class="essen_n"></span>').appendTo($label);
		required = " class='sw_required' ";
	}else{
		required = "";
	}
	$label.appendTo(options.container);
	
	var $textarea = null;
	if(readOnly){
				$textarea = $('<div class="form_value form_value_max_width" style="width:' + valueWidth + '%"></div>').html(value);
	}else{	
		$textarea = $('<div class="form_value form_value_max_width" style="width:' + valueWidth + '%"><span' + required + '><textarea style="width:100%; height:100%;display:none" id="' + id + '">'+value+'</textarea></span></div>');
	}
	if ($graphic.attr('hidden') == 'true'){
		$label.hide();
		$textarea.hide();		
	}
	$textarea.appendTo(options.container);

	if (!readOnly) {
		var oEditors = [];
		nhn.husky.EZCreator.createInIFrame({
			oAppRef: oEditors,
			elPlaceHolder: id,
			sSkinURI: "smarteditor/SEditorSkinKOR.html",
			fCreator: "createSEditorInIFrame"
		});
	}
	
	return options.container;
};

SmartWorks.FormRuntime.RichEditorBuilder.serializeObject = function(richEditors){
	var richEditorsJson = {};
	for(var i=0; i<richEditors.length; i++){
		var richEditor = $(richEditors[i]);
		console.log(richEditor.find('smartOutput'));
		richEditorsJson[richEditor.attr('fieldId')] = "richEditor";
	}
	return richEditorsJson;
};

SmartWorks.FormRuntime.RichEditorBuilder.validate = function(richEditors){
	var richEditorsValid = true;
	for(var i=0; i<richEditors.length; i++){
		var richEditor = $(richEditors[i]);
		var value = "richEditor";
		if(value == null || value === ""){
			richEditor.find('span.sw_required').addClass("sw_error");
			richEditorsValid = false;
		}
	}
	return richEditorsValid;
};
