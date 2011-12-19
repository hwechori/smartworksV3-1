SmartWorks.FormRuntime = SmartWorks.FormRuntime || {};

SmartWorks.FormRuntime.RichEditorBuilder = {};

SmartWorks.FormRuntime.RichEditorBuilder.build = function(config) {
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
	
	var $label = $('<div class="form_label">' + name + '</div>');
	var required = $entity[0].getAttribute('required');
	if(required === 'true'){
		$('<span class="essen_n"></span>').appendTo($label);
		required = " class='required' ";
	}else{
		required = "";
	}
	$label.appendTo(options.container);
	
	var $textarea = null;
	if(readOnly){
		$textarea = $('<div class="form_value" fieldId="' + id + '" id="'+id+'"></div>').html(value);
	}else{	
		$textarea = $('<div class="form_value"><textarea style="width:100%; height:100%;display:none" fieldId="' + id + '" name="' + id + '" id="' + id + '"' + required + '>'+value+'</textarea></div>');
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



