$(function() {

	var refreshRecord = function(input, refreshData){
		var newIwork = input.parents('.js_new_iwork_page');
		var startPwork = input.parents('.js_start_pwork_page');
		var iworkSpace =input.parents('.js_iwork_space_page');
		var pworkSpace = input.parents('.js_iwork_space_page');
		var workId = "", target = [], recordId = "", taskInstId = "";
		if(!isEmpty(newIwork)){
			workId = newIwork.attr('workId');
			target = newIwork.find('.js_form_content');		
		}else if(!isEmpty(startPwork)){
			workId = startPwork.attr('workId');
			target = startPwork.find('.js_form_content');
		}else if(!isEmpty(iworkSpace)){
			workId = iworkSpace.attr('workId');
			recordId = iworkSpace.attr('instId');
			target = iworkSpace.find('.js_form_content');			
		}else if(!isEmpty(pworkSpace)){
			workId = pworkSpace.attr('workId');
			recordId = pworkSpace.attr('instId');
			taskInstId = pworkSpace.attr('taskInstId');
			target = pworkSpace.find('.js_form_content');						
		}
		refreshData['workId'] = workId;
		refreshData['recordId'] = recordId;
		console.log(JSON.stringify(refreshData));
		new SmartWorks.GridLayout({
			target : target,
			mode : "edit",
			workId : workId,
			recordId : recordId,
			taskInstId : taskInstId,
			refreshData : refreshData,
			onSuccess : function(){
			}
		});
	};
		
	$('form[name="frmSmartForm"] .form_value > input').live('change', function(e) {
		var input = $(e.target);
		var forms = input.parents('form[name="frmSmartForm"]');
		var paramsJson = {};
		for(var i=0; i<forms.length; i++){
			var form = $(forms[i]);
			
			// 폼이 스마트폼이면 formId와 formName 값을 전달한다...
			if(form.attr('name') === 'frmSmartForm'){
				paramsJson['formId'] = form.attr('formId');
				paramsJson['formName'] = form.attr('formName');
			}
			
			// 폼이름 키값으로 하여 해당 폼에 있는 모든 입력항목들을 JSON형식으로 Serialize 한다...
			paramsJson[form.attr('name')] = mergeObjects(form.serializeObject(), SmartWorks.GridLayout.serializeObject(form));
		}
		refreshRecord(input, paramsJson);
	});

	$('form[name="frmSmartForm"] .form_value > select').live('change', function(e) {
		var input = $(e.target);
		var forms = input.parents('form[name="frmSmartForm"]');
		var paramsJson = {};
		for(var i=0; i<forms.length; i++){
			var form = $(forms[i]);
			
			// 폼이 스마트폼이면 formId와 formName 값을 전달한다...
			if(form.attr('name') === 'frmSmartForm'){
				paramsJson['formId'] = form.attr('formId');
				paramsJson['formName'] = form.attr('formName');
			}
			
			// 폼이름 키값으로 하여 해당 폼에 있는 모든 입력항목들을 JSON형식으로 Serialize 한다...
			paramsJson[form.attr('name')] = mergeObjects(form.serializeObject(), SmartWorks.GridLayout.serializeObject(form));
		}
		refreshRecord(input, paramsJson);
	});
	
	$('form[name="frmSmartForm"] .form_value input.js_currency_input').live('blur', function(e) {
		var input = $(e.target);
		var forms = input.parents('form[name="frmSmartForm"]');
		var paramsJson = {};
		for(var i=0; i<forms.length; i++){
			var form = $(forms[i]);
			
			// 폼이 스마트폼이면 formId와 formName 값을 전달한다...
			if(form.attr('name') === 'frmSmartForm'){
				paramsJson['formId'] = form.attr('formId');
				paramsJson['formName'] = form.attr('formName');
			}
			
			// 폼이름 키값으로 하여 해당 폼에 있는 모든 입력항목들을 JSON형식으로 Serialize 한다...
			paramsJson[form.attr('name')] = mergeObjects(form.serializeObject(), SmartWorks.GridLayout.serializeObject(form));
		}
		refreshRecord(input, paramsJson);
	});

	$('form[name="frmSmartForm"] .form_value input.js_number_input').live('blur', function(e) {
		var input = $(e.target);
		var forms = input.parents('form[name="frmSmartForm"]');
		var paramsJson = {};
		for(var i=0; i<forms.length; i++){
			var form = $(forms[i]);
			
			// 폼이 스마트폼이면 formId와 formName 값을 전달한다...
			if(form.attr('name') === 'frmSmartForm'){
				paramsJson['formId'] = form.attr('formId');
				paramsJson['formName'] = form.attr('formName');
			}
			
			// 폼이름 키값으로 하여 해당 폼에 있는 모든 입력항목들을 JSON형식으로 Serialize 한다...
			paramsJson[form.attr('name')] = mergeObjects(form.serializeObject(), SmartWorks.GridLayout.serializeObject(form));
		}
		refreshRecord(input, paramsJson);
	});

	$('form[name="frmSmartForm"] .form_value input.js_percent_input').live('blur', function(e) {
		var input = $(e.target);
		var forms = input.parents('form[name="frmSmartForm"]');
		var paramsJson = {};
		for(var i=0; i<forms.length; i++){
			var form = $(forms[i]);
			
			// 폼이 스마트폼이면 formId와 formName 값을 전달한다...
			if(form.attr('name') === 'frmSmartForm'){
				paramsJson['formId'] = form.attr('formId');
				paramsJson['formName'] = form.attr('formName');
			}
			
			// 폼이름 키값으로 하여 해당 폼에 있는 모든 입력항목들을 JSON형식으로 Serialize 한다...
			paramsJson[form.attr('name')] = mergeObjects(form.serializeObject(), SmartWorks.GridLayout.serializeObject(form));
		}
		refreshRecord(input, paramsJson);
	});

	$('form[name="frmSmartForm"] .form_value .js_community_names').live('change', function(e) {
		var input = $(e.target);
		var forms = input.parents('form[name="frmSmartForm"]');
		var paramsJson = {};
		for(var i=0; i<forms.length; i++){
			var form = $(forms[i]);
			
			// 폼이 스마트폼이면 formId와 formName 값을 전달한다...
			if(form.attr('name') === 'frmSmartForm'){
				paramsJson['formId'] = form.attr('formId');
				paramsJson['formName'] = form.attr('formName');
			}
			
			// 폼이름 키값으로 하여 해당 폼에 있는 모든 입력항목들을 JSON형식으로 Serialize 한다...
			paramsJson[form.attr('name')] = mergeObjects(form.serializeObject(), SmartWorks.GridLayout.serializeObject(form));
		}
		refreshRecord(input, paramsJson);
	});

	$('form[name="frmSmartForm"] .form_value input.js_todaypicker').live('change', function(e) {
		var input = $(e.target);
		var forms = input.parents('form[name="frmSmartForm"]');
		var paramsJson = {};
		for(var i=0; i<forms.length; i++){
			var form = $(forms[i]);
			
			// 폼이 스마트폼이면 formId와 formName 값을 전달한다...
			if(form.attr('name') === 'frmSmartForm'){
				paramsJson['formId'] = form.attr('formId');
				paramsJson['formName'] = form.attr('formName');
			}
			
			// 폼이름 키값으로 하여 해당 폼에 있는 모든 입력항목들을 JSON형식으로 Serialize 한다...
			paramsJson[form.attr('name')] = mergeObjects(form.serializeObject(), SmartWorks.GridLayout.serializeObject(form));
		}
		refreshRecord(input, paramsJson);
	});

	$('form[name="frmSmartForm"] .form_value input.js_todaytimepicker').live('change', function(e) {
		var input = $(e.target);
		var forms = input.parents('form[name="frmSmartForm"]');
		var paramsJson = {};
		for(var i=0; i<forms.length; i++){
			var form = $(forms[i]);
			
			// 폼이 스마트폼이면 formId와 formName 값을 전달한다...
			if(form.attr('name') === 'frmSmartForm'){
				paramsJson['formId'] = form.attr('formId');
				paramsJson['formName'] = form.attr('formName');
			}
			
			// 폼이름 키값으로 하여 해당 폼에 있는 모든 입력항목들을 JSON형식으로 Serialize 한다...
			paramsJson[form.attr('name')] = mergeObjects(form.serializeObject(), SmartWorks.GridLayout.serializeObject(form));
		}
		refreshRecord(input, paramsJson);
	});

	$('form[name="frmSmartForm"] .form_value input.js_timepicker').live('change', function(e) {
		var input = $(e.target);
		var forms = input.parents('form[name="frmSmartForm"]');
		var paramsJson = {};
		for(var i=0; i<forms.length; i++){
			var form = $(forms[i]);
			
			// 폼이 스마트폼이면 formId와 formName 값을 전달한다...
			if(form.attr('name') === 'frmSmartForm'){
				paramsJson['formId'] = form.attr('formId');
				paramsJson['formName'] = form.attr('formName');
			}
			
			// 폼이름 키값으로 하여 해당 폼에 있는 모든 입력항목들을 JSON형식으로 Serialize 한다...
			paramsJson[form.attr('name')] = mergeObjects(form.serializeObject(), SmartWorks.GridLayout.serializeObject(form));
		}
		refreshRecord(input, paramsJson);
	});

	$('form[name="frmSmartForm"] .js_refFormField').live('change', function(e) {
		var input = $(e.target);
		var forms = input.parents('form[name="frmSmartForm"]');
		var paramsJson = {};
		for(var i=0; i<forms.length; i++){
			var form = $(forms[i]);
			
			// 폼이 스마트폼이면 formId와 formName 값을 전달한다...
			if(form.attr('name') === 'frmSmartForm'){
				paramsJson['formId'] = form.attr('formId');
				paramsJson['formName'] = form.attr('formName');
			}
			
			// 폼이름 키값으로 하여 해당 폼에 있는 모든 입력항목들을 JSON형식으로 Serialize 한다...
			paramsJson[form.attr('name')] = mergeObjects(form.serializeObject(), SmartWorks.GridLayout.serializeObject(form));
		}
		refreshRecord(input, paramsJson);
	});

});
