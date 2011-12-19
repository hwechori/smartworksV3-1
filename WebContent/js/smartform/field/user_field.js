SmartWorks.FormRuntime = SmartWorks.FormRuntime || {};

SmartWorks.FormRuntime.UserFieldBuilder = {};

SmartWorks.FormRuntime.UserFieldBuilder.build = function(config) {
	var options = {
		mode : 'edit', // view or edit
		container : $('<div></div>'),
		entity : null,
		dataField : '',
		layoutInstance : null
	};

	SmartWorks.extend(options, config);
	var longName = (options.dataField && options.dataField.value) || '';
	var userId = (options.dataField && options.dataField.refRecordId) || '';
	var $entity = options.entity;
	//var $graphic = $entity.children('graphic');
	var $graphic = $entity.children('graphic');
	var readOnly = $graphic.attr('readOnly') === 'true' || options.mode === 'view';
	var id = $entity.attr('id');
	var name = $entity.attr('name');
	
	var $label = $('<div class="form_label">' + name + '</div>');
	var labelWidth = options.layoutInstance.getLabelWidth(id);
	var valueWidth = 100 - labelWidth;
	var $label = $('<div class="form_label" style="width:' + labelWidth + '%">' + name + '</div>');
	var required = $entity[0].getAttribute('required');
	if(required === 'true' && !readOnly){
		$('<span class="essen_n"></span>').appendTo($label);
		required = " class='ico_user_space sw_required'";
	}else{
		required = " class='ico_user_space";
	}
	$label.appendTo(options.container);
	
	var $user = null;
	
	var userHtml = '';
	
	if (userId !== "") {
		userHtml = "<span><span class='js_community_item user_select' comId='" + userId + "'>" + longName + "<span class='btn_x_gr'><a class='js_remove_community' href=''> x</a></span></span></span>";
	}

		var $html = $('<div class="form_value" style="width:' + valueWidth + '%"> <div' + required +'>\
					<div class="fieldline js_community_names">\
						<div class="js_selected_communities user_sel_area"></div>\
						<input class="js_auto_complete js_form_user_field" href="community_name.sw" type="text">\
						<div class="js_srch_x"></div>\
					</div>\
					<div class="js_community_list commu_list" style="display: none"></div> <span class="ico_user"></span></div></div>');

	$html.find('.js_selected_communities').html(userHtml);
	
	if(readOnly){
		$user = $('<div class="form_value" style="width:' + valueWidth + '%"><a class="js_pop_user_info" href="pop_user_info.sw?userId=' + userId + '"><span></span></a></div>').text(longName);
	}else{	
		$user = $html;
	}
	$user.appendTo(options.container);

	return options.container;
};

SmartWorks.FormRuntime.UserFieldBuilder.serializeObject = function(userFields){
	var usersJson = {};
	for(var i=0; i<userFields.length; i++){
		var userField = $(userFields[i]);
		usersJson[userField.attr('fieldId')] =  userField.find('.js_community_item:first').attr('comId');
	}
	return usersJson;
};

SmartWorks.FormRuntime.UserFieldBuilder.validate = function(userFields){
	var usersValid = true;
	for(var i=0; i<userFields.length; i++){
		var userField = $(userFields[i]);
		var userId = userField.find('.js_community_item:first').attr('comId');
		if(userId == null || userId === ""){
			userField.find('span.sw_required').addClass("sw_error");
			usersValid = false;
		}
	}
	return usersValid;
};
