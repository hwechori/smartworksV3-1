SmartWorks.FormRuntime = SmartWorks.FormRuntime || {};

SmartWorks.FormRuntime.DepartmentFieldBuilder = {};

SmartWorks.FormRuntime.DepartmentFieldBuilder.build = function(config) {
	var options = {
		mode : 'edit', // view or edit
		container : $('<td></td>'),
		entity : null,
		dataField : '',
		layoutInstance : null
	};

	SmartWorks.extend(options, config);
	options.container.html('');

	var departments = (options.dataField && options.dataField.departments) || new Array();

	var $entity = options.entity;
	//var $graphic = $entity.children('graphic');
	var $graphic = $entity.children('graphic');
	var readOnly = $graphic.attr('readOnly') === 'true' || options.mode === 'view';
	var id = $entity.attr('id');
	var name = $entity.attr('name');
	
	var labelWidth = (isEmpty(options.layoutInstance)) ? parseInt($graphic.attr('labelWidth')) : options.layoutInstance.getLabelWidth(id);
	var valueWidth = 100 - labelWidth;
	var $label = $('<div class="form_label" style="width:' + labelWidth + '%">' + name + '</div>');
	var required = $entity[0].getAttribute('required');
	if(required === 'true' && !readOnly){
		$label.addClass('required_label');
		required = " class='fieldline js_community_names sw_required'";
	}else{
		required = " class='fieldline js_community_names'";
	}
	$label.appendTo(options.container);
	
	var $department = null;
	
	var departmentsHtml = '';
	var hideStyle = '';

	if (!isEmpty(departments)) {
		departmentsHtml = "<span><span class='js_community_item user_select' comId='" + departments[0].departmentId + "'>" + departments[0].departmentName + "<span class='btn_x_gr'><a class='js_remove_community' href=''> x</a></span></span></span>";
		hideStyle = ' style="display:none" ';
	}

	var $html = $('<div class="form_value form_value_max_width" style="width:' + valueWidth + '%"> <div class="ico_fb_space">\
					<div ' + required + '">\
						<div class="js_selected_communities user_sel_area"></div>\
						<input class="js_auto_complete" href="community_name.sw" type="text"' + hideStyle + '>\
						<div class="js_srch_x"' + hideStyle + '></div>\
					</div>\
					<div class="js_community_list commu_list" style="display: none"></div><a href="#" class="js_departpicker_button"><span class="ico_fb_user"></span></a></div></div>');

	$html.find('.js_selected_communities').html(usersHtml);
	
	if(readOnly){
		$user = $('<div class="form_value form_value_max_width" style="width:' + valueWidth + '%"></div>');
		departmentsHtml = '';
		for(var i=0; i<users.length; i++)
			departmentsHtml = departmentsHtml + '<a class="js_pop_depart_info" href="pop_depart_info.sw?departmentId=' + departments[i].departmentId + '"><span>' + departments[i].departmentName + '</span></a>';
		$department.html(departmentsHtml);
	}else{	
		$department = $html;
	}
	if ($graphic.attr('hidden') == 'true'){
		$label.hide();
		$department.hide();		
	}
	$department.appendTo(options.container);

	return options.container;
};

SmartWorks.FormRuntime.DepartmentFieldBuilder.buildEx = function(config){
	var options = {
			container : $('<tr></tr>'),
			fieldId: '',
			fieldName: '',
			departments: new Array(), //{departmentId: '',departmentName: '}
			columns: 1,
			required: false,
			readOnly: false		
	};
	SmartWorks.extend(options, config);

	var labelWidth = 10;
	if(options.columns >= 1 && options.columns <= 4) labelWidth = 10 * options.columns;
	$formEntity =  $('<formEntity id="' + options.fieldId + '" name="' + options.fieldName + '" systemType="string" required="' + options.required + '" system="false">' +
						'<format type="departmentField" viewingType="departmentField"/>' +
					    '<graphic hidden="false" readOnly="'+ options.readOnly +'" labelWidth="'+ labelWidth + '"/>' +
					'</formEntity>');
	var $formCol = $('<td class="form_col js_type_departmentField" fieldid="' + options.fieldId+ '" colspan="1" width="500.61775800946384" rowspan="1">');
	$formCol.appendTo(options.container);
	SmartWorks.FormRuntime.DepartmentFieldBuilder.build({
		mode : options.readOnly, // view or edit
		container : $formCol,
		entity : $formEntity,
		dataField : SmartWorks.FormRuntime.DepartmentFieldBuilder.dataField({
			fieldName: options.fieldName,
			formXml: $formEntity,
			departments : options.departments
		})
	});
	
};

SmartWorks.FormRuntime.DepartmentFieldBuilder.serializeObject = function(departmentFields){
	var departmentsJson = {};
	for(var i=0; i<departmentFields.length; i++){
		var departmentField = $(departmentFields[i]);
		var fieldId = departmentField.attr('fieldId');
		var departmentList = departmentField.find('.js_community_item');
		var departments = new Array();
		for(var j=0; j<departmentList.length; j++)
			departments.push(departmentList.attr('comId'));
		departmentsJson[fieldId] =  {departments: departments};
	}
	return departmentsJson;
};

SmartWorks.FormRuntime.DepartmentFieldBuilder.validate = function(departmentFields){
	var departmentsValid = true;
	for(var i=0; i<departmentFields.length; i++){
		var departmentField = $(departmentFields[i]);
		var departmentId = departmentField.find('.js_community_item:first').attr('comId');
		if(isBlank(departmentId)){
			departmentField.find('div.sw_required').addClass("sw_error");
			departmentsValid = false;
		}
	}
	return departmentsValid;
};

SmartWorks.FormRuntime.DepartmentFieldBuilder.dataField = function(config){
	var options = {
			fieldName: '',
			formXml: '',
			departments: new Array() //{departmentId: '',departmentName: ''}
	};

	SmartWorks.extend(options, config);
	$formXml = $(options.formXml);
	var dataField = {};
	
	var fieldId = $formXml.find('formEntity[name="'+options.fieldName+'"]').attr('id');
	if(isEmpty(fieldId)) fieldId = ($formXml.attr("name") === options.fieldName) ? $formXml.attr('id') : "";
	if(isEmpty($formXml) || isEmpty(fieldId)) return dataField;
	dataField = {
			id: fieldId,
			departments : options.departments
	};
	return dataField;
};
