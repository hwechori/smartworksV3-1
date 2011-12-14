SmartWorks.FormRuntime = SmartWorks.FormRuntime || {};

SmartWorks.FormRuntime.UserFieldBuilder = {};

SmartWorks.FormRuntime.UserFieldBuilder.build = function(config) {
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
	
	var $user = null;
	
	var userHtml = '';
	
	if (options.value.userId) {
		userHtml = "<span class='js_community_item user_select' comId='" + options.value.userId + "'>" + options.value.longName + "<span class='btn_x_gr'><a class='js_remove_community' href=''> x</a></span></span>";
	}

	var $html = $('<input type="hidden" name="hdnRelatedUsers" />\
					<div class="input_1line fieldline js_community_names">\
						<div class="js_selected_communities user_sel_area"></div>\
						<input class="js_auto_complete js_form_user_field" href="community_name.sw" type="text">\
						<div class="js_srch_x"></div>\
					</div>\
					<div class="js_community_list" style="display: none"></div>');

	$html.find('.js_selected_communities').html(userHtml);
	
	if(readOnly){
		$user = $('<a class="js_pop_user_info" href="pop_user_info.sw?userId=' + options.value.userId + '"><span fieldId="' + id + '"></span></a>').text(options.value.longName);
	}else{	
		//$user = $('<a href="pop_user_info.sw?userId=' + options.value.userId + '" target="_blank"><input type="text" fieldId="' + id + '" name="' + id + '"></a>').attr('value', options.value.longName);
		$user = $html;
	}
	$user.appendTo(options.container);

	return options.container;
};