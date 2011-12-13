SmartWorks.FormRuntime = SmartWorks.FormRuntime || {};

SmartWorks.FormRuntime.RichEditorBuilder = {};

SmartWorks.FormRuntime.RichEditorBuilder.build = function(config) {
	var options = {
		mode : 'edit', // view or edit
		container : $('<div></div>'),
		entity : null,
		value : ''
	};

	SmartWorks.extend(options, config);

	var $entity = options.entity;
	//var $graphic = $entity.children('graphic');
	var $graphic = $entity.children('graphic');
	var readOnly = $graphic.attr('readOnly') === 'true' || options.mode === 'view';
	var id = $entity.attr('id');
	var name = $entity.attr('name');
	
	var $label = $('<label>' + name + '</label>');
	$label.appendTo(options.container);
	
	var $textarea = null;
	console.log(readOnly);
	if(readOnly){
		$textarea = $('<span fieldId="' + id + '"></span>').html(options.value);
	}else{	
		$textarea = $('<textarea style="width:725px; height:300px;display:none" fieldId="' + id + '" name="' + id + '" id="' + id + '" >'+options.value+'</textarea>');
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



