SmartWorks.FormRuntime = SmartWorks.FormRuntime || {};

SmartWorks.FormRuntime.UserFieldBuilder = {};

SmartWorks.FormRuntime.UserFieldBuilder.build = function(config) {
	var options = {
		mode : 'edit', // view or edit
		container : $('<td></td>'),
		entity : null,
		dataField : '',
		refreshData : false,
		layoutInstance : null
	};

	SmartWorks.extend(options, config);
	if(!options.refreshData)
		options.container.html('');

	var users = (options.dataField && options.dataField.users) || new Array();

	var $entity = options.entity;
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
		required = " class='fieldline community_names js_community_names sw_required'";
	}else{
		required = " class='fieldline community_names js_community_names'";
	}
	if(!options.refreshData)
		$label.appendTo(options.container);
	
	var $user = null;
	
	var usersHtml = '';
	var href = "user_name.sw";
	var icoClass = ' class="icon_fb_user"';

	if(multiUsers === 'true'){
		for(var i=0; i<users.length; i++)
			usersHtml = usersHtml +  "<span class='js_community_item user_select' comId='" + users[i].userId + "'>" + users[i].longName + "<a class='js_remove_community' href=''>&nbsp;x</a></span>";		
		href = "community_name.sw";
		icoClass = ' class="icon_fb_users"';
	}else if (!isEmpty(users)) {
		usersHtml = "<span class='js_community_item user_select' comId='" + users[0].userId + "'>" + users[0].longName + "<a class='js_remove_community' href=''> x</a></span>";
	}

	var $html = $('<div class="form_value" style="width:' + valueWidth + '%"> <div class="icon_fb_space">\
					<div ' + required + '>\
						' + usersHtml + '\
						<input class="m0 js_auto_complete" style="width:100px" href="' + href + '" type="text">\
					</div>\
					<div class="js_community_list srch_list_nowid" style="display: none"></div><span class="js_community_popup"></span><a href="" class="js_userpicker_button"><span ' + icoClass + '></span></a></div></div>');

	if(readOnly){
		$user = $('<div class="form_value" style="width:' + valueWidth + '%"></div>');
		usersHtml = '';
		for(var i=0; i<users.length; i++) {
			var separator = ', ';
			var href = 'department_space.sw?cid=dp.sp.';
			if(isEmailAddress(users[i].userId)){
				href = 'user_space.sw?cid=us.sp.';
			}else if(users[i].userId.substring(0,6) === "group_"){
				href = 'group_space.sw?cid=gp.sp.';
			}else if(users[i].userId.substring(0,5) === "dept_"){
				href = 'department_space.sw?cid=dp.sp.';
			}
			if(i == users.length - 1)
				separator = '';
			usersHtml = usersHtml + '<a href="' + href + users[i].userId + '"><span>' + users[i].longName + separator + '</span></a>';
		}
		$user.html(usersHtml);
	}else{	
		$user = $html;
	}
	if ($graphic.attr('hidden') == 'true'){
		$label.hide();
		$user.hide();		
	}
	if(!options.refreshData)
		$user.appendTo(options.container);
	else
		options.container.find('.form_value').html($user.children());

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

	var labelWidth = 12;
	if(options.columns >= 1 && options.columns <= 4 && options.colSpan <= options.columns) labelWidth = 12 * options.columns/options.colSpan;
	$formEntity =  $('<formEntity id="' + options.fieldId + '" name="' + options.fieldName + '" systemType="string" required="' + options.required + '" system="false">' +
						'<format type="userField" viewingType="userField"/>' +
					    '<graphic hidden="false" readOnly="'+ options.readOnly +'" labelWidth="'+ labelWidth + '" multipleUsers="' + options.multiUsers+ '"/>' +
					'</formEntity>');
	var $formCol = $('<td class="form_col js_type_userField" fieldid="' + options.fieldId+ '" colspan="' + options.colSpan + '" width="' + options.colSpan/options.columns*100 + '%" rowspan="1">');
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
