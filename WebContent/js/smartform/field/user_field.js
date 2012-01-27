SmartWorks.FormRuntime = SmartWorks.FormRuntime || {};

SmartWorks.FormRuntime.UserFieldBuilder = {};

SmartWorks.FormRuntime.UserFieldBuilder.build = function(config) {
	var options = {
		mode : 'edit', // view or edit
		container : $('<td></td>'),
		entity : null,
		dataField : '',
		layoutInstance : null
	};

	SmartWorks.extend(options, config);
	options.container.html('');

	var users = (options.dataField && options.dataField.users) || new Array();

	var $entity = options.entity;
	//var $graphic = $entity.children('graphic');
	var $graphic = $entity.children('graphic');
	var readOnly = $graphic.attr('readOnly') === 'true' || options.mode === 'view';
	var multiUsers = $graphic.attr('multipleUsers');
	options.container.attr('multiUsers', multiUsers);
	var id = $entity.attr('id');
	var name = $entity.attr('name');
	
	var labelWidth = (isEmpty(options.layoutInstance)) ? parseInt($graphic.attr('labelWidth')) : options.layoutInstance.getLabelWidth(id);
	var valueWidth = 100 - labelWidth;
	var $label = $('<div class="form_label" style="width:' + labelWidth + '%"><span>' + name + '</span></div>');
	var required = $entity[0].getAttribute('required');
	if(required === 'true' && !readOnly){
		$label.addClass('required_label');
		required = " class='fieldline js_community_names sw_required'";
	}else{
		required = " class='fieldline js_community_names'";
	}
	$label.appendTo(options.container);
	
	var $user = null;
	
	var usersHtml = '';
	var href = "user_name.sw";
	var icoClass = ' class="ico_fb_user"';

	if(multiUsers === 'true'){
		for(var i=0; i<users.length; i++)
			usersHtml = usersHtml +  "<span><span class='js_community_item user_select' comId='" + users[i].userId + "'>" + users[i].longName + "<span class='btn_x_gr'><a class='js_remove_community' href=''> x</a></span></span></span>";		
		href = "community_name.sw";
		icoClass = ' class="ico_fb_users"';
	}else if (!isEmpty(users)) {
		usersHtml = "<span><span class='js_community_item user_select' comId='" + users[0].userId + "'>" + users[0].longName + "<span class='btn_x_gr'><a class='js_remove_community' href=''> x</a></span></span></span>";
	}

	var $html = $('<div class="form_value" style="width:' + valueWidth + '%"> <div class="ico_fb_space">\
					<div ' + required + '">\
						<div class="js_selected_communities user_sel_area"></div>\
						<input class="js_auto_complete" href="' + href + '" type="text">\
						<div class="js_srch_x"></div>\
					</div>\
					<div class="js_community_list srch_list_nowid" style="display: none"></div><span class="js_community_popup"></span><a href="" class="js_userpicker_button"><span ' + icoClass + '></span></a></div></div>');

	$html.find('.js_selected_communities').html(usersHtml);
	
	if(readOnly){
		$user = $('<div class="form_value" style="width:' + valueWidth + '%"></div>');
		usersHtml = '';
		for(var i=0; i<users.length; i++) {
			var separator = ', ';
			if(i == users.length - 1)
				separator = '';
			usersHtml = usersHtml + '<a class="js_pop_user_info" href="pop_user_info.sw?userId=' + users[i].userId + '"><span>' + users[i].longName + separator + '</span></a>';
		}
		$user.html(usersHtml);
	}else{	
		$user = $html;
	}
	if ($graphic.attr('hidden') == 'true'){
		$label.hide();
		$user.hide();		
	}
	$user.appendTo(options.container);

	return options.container;
};

SmartWorks.FormRuntime.UserFieldBuilder.buildEx = function(config){
	var options = {
			container : $('<tr></tr>'),
			fieldId: '',
			fieldName: '',
			users: new Array(), //{userId: '',longName: '}
			columns: 1,
			colSpan: 1,
			multiUsers: false,
			required: false,
			readOnly: false		
	};
	SmartWorks.extend(options, config);

	var labelWidth = 10;
	if(options.columns >= 1 && options.columns <= 4 && options.colSpan <= options.columns) labelWidth = 10 * options.columns/options.colSpan;
	$formEntity =  $('<formEntity id="' + options.fieldId + '" name="' + options.fieldName + '" systemType="string" required="' + options.required + '" system="false">' +
						'<format type="userField" viewingType="userField"/>' +
					    '<graphic hidden="false" readOnly="'+ options.readOnly +'" labelWidth="'+ labelWidth + '" multipleUsers="' + options.multiUsers+ '"/>' +
					'</formEntity>');
	var $formCol = $('<td class="form_col js_type_userField" fieldid="' + options.fieldId+ '" colspan="' + options.colSpan + '" width="500.61775800946384" rowspan="1">');
	$formCol.appendTo(options.container);
	SmartWorks.FormRuntime.UserFieldBuilder.build({
			mode : options.readOnly, // view or edit
			container : $formCol,
			entity : $formEntity,
			dataField : SmartWorks.FormRuntime.UserFieldBuilder.dataField({
				fieldName: options.fieldName,
				formXml: $formEntity,
				users : options.users
			})
	});
	
};

SmartWorks.FormRuntime.UserFieldBuilder.serializeObject = function(userFields){
	var usersJson = {};
	for(var i=0; i<userFields.length; i++){
		var userField = $(userFields[i]);
		var fieldId = userField.attr('fieldId');
		var userList = userField.find('.js_community_item');
		var users = new Array();
		for(var j=0; j<userList.length; j++)
			users.push({
				id : $(userList[j]).attr('comId'),
				name : userList[j].childNodes[0].nodeValue
			});
		usersJson[fieldId] =  {users: users};
	}
	return usersJson;
};

SmartWorks.FormRuntime.UserFieldBuilder.validate = function(userFields){
	var usersValid = true;
	for(var i=0; i<userFields.length; i++){
		var userField = $(userFields[i]);
		var userId = userField.find('.js_community_item:first').attr('comId');
		var required = userField.find('div.sw_required');
		if(!isEmpty(required) && isBlank(userId)){
			userField.find('div.sw_required').addClass("sw_error");
			usersValid = false;
		}
	}
	return usersValid;
};

SmartWorks.FormRuntime.UserFieldBuilder.dataField = function(config){
	var options = {
			fieldName: '',
			formXml: '',
			users: new Array() //{userId: '',longName: ''}
	};

	console.log("options.users :::: ", options.users);
	SmartWorks.extend(options, config);
	$formXml = $(options.formXml);
	var dataField = {};
	
	var fieldId = $formXml.find('formEntity[name="'+options.fieldName+'"]').attr('id');
	if(isEmpty(fieldId)) fieldId = ($formXml.attr("name") === options.fieldName) ? $formXml.attr('id') : "";
	if(isEmpty($formXml) || isEmpty(fieldId)) return dataField;
	dataField = {
			id: fieldId,
			users : options.users
	};
	return dataField;
};
