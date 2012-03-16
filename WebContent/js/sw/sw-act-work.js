$(function() {
	
	var autoPictures = $('img.js_auto_picture');
	console.log("autoPictures", autoPictures);
	if(!isEmpty(autoPictures)) {
		for(var i=0; i<autoPictures.length; i++) {			
			createUploader(null, $(autoPictures[i]).next().find('div.js_file_uploader'), false, true);
		}		
	}

	var autoLoadProfiles = $('div.js_auto_load_profile');
	if(!isEmpty(autoLoadProfiles)) {
		for(var i=0; i<autoLoadProfiles.length; i++) {			
			loadMyProfileField();
		}		
	}

	$('.js_select_action a').live('click',function(e) {
		var input = $(e.target);
		$('.js_select_action').find('a').removeClass('current');
		var currentAction = input.parents('.up_icon_list');
		currentAction.find('a').addClass('current');
		var url = input.attr('href');
		var target = $('.js_upload_form');
		$.ajax({
			url : url,
			data : {},
			success : function(data, status, jqXHR) {
				target.html(data).show();
				target.find('.js_up_pointer').css({"left": currentAction.position().left + currentAction.outerWidth()/2 + "px"});
			},
			error : function(xhr, ajaxOptions, thrownError){
				
			}
		});
		return false;
	});

	$('a.js_cancel_action').live('click',function(e) {
		var input = $('.js_select_action').find('a:first');
		$('.js_select_action').find('a').removeClass('current');
		var currentAction = input.parents('.up_icon_list');
		currentAction.find('a').addClass('current');
		var target = $('.js_upload_form');
		var url = input.attr('href');
		$.ajax({
			url : url,
			data : {},
			success : function(data, status, jqXHR) {
				target.html(data).show();
				$(data).find('.js_up_pointer').css({"left": (currentAction.position().left + currentAction.outerWidth()/2) + "px"});
			},
			error : function(xhr, ajaxOptions, thrownError){
				
			}
		});
		return false;
	});
	
	$('.js_click_start_form').live('click', function(e){
		var input = $(e.target).parents('.js_click_start_form:first');
		var newMemo = input.parents('.js_new_memo_page');
		var newPicture = input.parents('.js_new_picture_page');
		var newFile = input.parents('.js_new_file_page');
		var newEvent = input.parents('.js_new_event_page');
		var newBoard = input.parents('.js_new_board_page');
		var newIWork = input.parents('.js_new_iwork_page');
		var startPWork = input.parents('.js_start_pwork_page');
		var planSWork = input.parents('.js_plan_swork_page');
		var workId = "";
		var target = [];
		if(!isEmpty(newMemo)){
			input.find('textarea').removeClass('bn').addClass('up_textarea');
			newMemo.find('form[name="frmNewMemo"]').addClass('form_title');
			workId = newMemo.attr('workId');
			target = newMemo.find('.js_upload_buttons');
		}else if(!isEmpty(newPicture)){
			newPicture.find('tr').show();
			newPicture.find('form[name="frmNewPicture"]').addClass('form_title');
			workId = newPicture.attr('workId');
			target = newPicture.find('.js_upload_buttons');
		}else if(!isEmpty(newFile)){
			newFile.find('td[fieldId="txtFileField"] .form_label').show();
			newFile.find('tr').show();
			newFile.find('.js_file_detail_form').show();
			newFile.find('form[name="frmNewFile"]').addClass('form_title');
			workId = newFile.attr('workId');
			target = newFile.find('.js_upload_buttons');
		}else if(!isEmpty(newEvent)){
			newEvent.find('td[fieldId="txtEventName"] .form_label').show();
			newEvent.find('td[fieldId="txtEventName"] .form_value input').addClass('fieldline');
			newEvent.find('tr').show();
			newEvent.find('form[name="frmNewEvent"]').addClass('form_title');
			workId = newEvent.attr('workId');
			target = newEvent.find('.js_upload_buttons');
		}else if(!isEmpty(newBoard)){
			newBoard.find('td[fieldId="txtBoardName"] .form_label').show();
			newBoard.find('td[fieldId="txtBoardName"] .form_value input').addClass('fieldline');
			newBoard.find('tr').show();
			newBoard.find('form[name="frmNewBoard"]').addClass('form_title');
			workId = newBoard.attr('workId');
			target = newBoard.find('.js_upload_buttons');
		}else if(!isEmpty(newIWork)){
			workId = newIWork.attr('workId');
			target = newIWork.find('.js_upload_buttons');
		}else if(!isEmpty(startPWork)){
			workId = startPWork.attr('workId');
			target = startPWork.find('.js_upload_buttons');
		}else if(!isEmpty(planSWork)){
			workId = planSWork.attr('workId');
			target = planSWork.find('.js_upload_buttons');
		}
		if(!isEmpty(target.html())) return true;
		$.ajax({
			url : 'upload_buttons.sw',
			data : {
				workId : workId
			},
			success : function(data, status, jqXHR) {
				target.html(data);
			},
			error : function(xhr, ajaxOptions, thrownError){
				
			}
		});			
		return true;
	});

	/*
	 * 세업무시작하기에서, 입력창에 값을 입력하여 나오는 검색결과를 선택하면 실행되는 이벤트로, 검색결과항목의 href값으로 ajax를
	 * 실행하여 가져온 값으로 id가 form_works 인 곳 화면을 그려서, 아래로 펼쳐준다.
	 */
	$('.js_select_work').swnavi({
		before : function(event) {
			smartPop.progressCenter();
			$('#form_works').html('');
			$(event.target).parents(".js_start_work_page").hide();
		},
		target : 'form_works',
		after : function(event) {
			var input = $(event.target).parents('li:first').children('a');
			var formContent = $('#form_works').find('div.js_form_content');
			var workId = input.attr('workId');
			new SmartWorks.GridLayout({
				target : formContent,
				mode : "edit",
				requiredOnly : "true",
				workId : workId,
				onSuccess : function(){
					$('#form_works').parent().show();
					smartPop.closeProgress();					
				},
				onError : function(){
					smartPop.closeProgress();					
				}
			});
		}
	});

	$('.js_toggle_form_detail').live('click', function(event){
		var input = $(event.target);
		input.parent().hide().siblings().show();
		var formContent = $('#form_works').find('div.js_form_content');
		if(isEmpty(formContent)) formContent = input.parents('.js_iwork_list_page').find('div.js_form_content');
		var workId = input.attr('workId');
		var requiredOnly = input.attr('requiredOnly');
		formContent.html('');
		new SmartWorks.GridLayout({
			target : formContent,
			mode : "edit",
			requiredOnly : requiredOnly,						
			workId : workId
		});
		return false;
	});
	
	$('input.js_toggle_schedule_work').live('click', function(e) {
		var input = $(e.target);
		var target = $(e.target).parent().next('span');
		if(input.is(':checked')){
			loadCheckScheduleFields();
			target.show();
		}else{
			target.find('.js_check_schedule_fields').html('');
			target.hide();
		}
	});
	
	var ACCESS_LEVEL_CUSTOM = '2';
	$('select.js_select_access_level').live('change', function(e) {
		var input = $(e.target);
		var target = input.parents('.js_upload_buttons_page').find('.js_access_level_custom');
		var accessLevel = input.attr('value');
		if(accessLevel === ACCESS_LEVEL_CUSTOM)
			target.show();
		else
			target.hide();
	});
	
	$('select.js_select_work_space').live('change', function(e) {
		var input = $(e.target);
		var target = input.parents('.js_upload_buttons_page').find('input[name="selWorkSpaceType"]');
		target.attr('value', input.find('option:selected').attr('workSpaceType'));
	});
	
	$('a.js_create_new_work').live('click', function(e) {
		var input = $(e.target);
		var url = input.attr('href');
		var target = input.parents('.js_work_list_page').find('div.js_new_work_form');
		$('a.js_search_filter_close').click();
		$.ajax({
			url : url,
			data : {},
			success : function(data, status, jqXHR) {
				target.html(data).slideDown(500);
				var formContent = target.find('div.js_form_content');
				var workId = input.attr('workId');
				new SmartWorks.GridLayout({
					target : formContent,
					mode : "edit",
					requiredOnly : "true",
					workId : workId
				});
			}
			
		});
		return false;
	});

	$('input.js_whole_day').live('click', function(e){
		var input = $(e.target);
		input.parent().siblings('div.js_start_time').toggle();
		var endtime = input.parent().siblings('div.js_end_datetime').find('div.js_end_time').hide();
		if(input[0].checked) endtime.hide();
		else endtime.show();
	});
	$('a.js_toggle_file_detail').swnavi(
		{
			target : 'form_import',
			after : function(event) {
				var input = $(event.target);
				input.parents('.js_file_detail_form').parent().prev().slideToggle(500);
				input.parent().toggle().siblings().toggle();
				var form = input.parents('form[name="frmNewFile"]');
				var uploader = form.find('.qq-uploader');
				var comments = form.find('textarea[name="txtFileDesc"]').attr("value");
				var groupId = uploader.attr('groupId');
				var fileList = uploader.find('.qq-upload-list li');
				var fileName = $(fileList[0]).attr('fileName');
				if(isEmpty(fileName))
					fileName = "";

				$('#error_message_span').html("");
				
				var formContent = $('#form_import').find('div.js_form_content');
				if(!isEmpty(formContent)) {
					var workId = formContent.attr('workId');
					$.ajax({
						url : "get_form_xml.sw",
						data : {
							workId : workId
						},
						success : function(formXml, status, jqXHR) {
							var record = createFileDataFields({
									formXml : formXml,
									groupId : groupId,
									fileName : fileName,
									fileList : fileList,
									comments : comments								
							});
							console.log("record", record);
							new SmartWorks.GridLayout({
								target : formContent,
								formXml : formXml,
								formValues : record,
								mode : "edit"
							});
						},
						error : function(xhr, ajaxOptions, thrownError){
							
						}
					});
				}
			}
		});

	$('a.js_view_work_manual').live('click', function(e){
		var input = $(e.target);
		var target = input.parents("div.js_work_list_page").find('#work_manual').slideToggle(500);
		input.hide();
		input.siblings().show();

		var href = input.attr('href');
		if(isEmpty(href)){
			target.html('');
		}else{
			var progressSpan = input.parent().next('span.js_progress_span');
			smartPop.progressCont(progressSpan);
			$.ajax({
				url : href,
				data : {},
				success : function(data, status, jqXHR) {
					target.html(data);
					var pworkManual = $('.js_pwork_manual_page');
					if(isEmpty(pworkManual)){
						smartPop.closeProgress();
						return;
					}
					var manualTasksHolder = pworkManual.find(".js_manual_tasks_holder");
					var manualTasks = manualTasksHolder.find(".js_manual_tasks");
					var manualTasksRight = pworkManual.find('.js_manual_tasks_right');
					pworkManual.find('.js_manual_tasks_left').hide();
					for(var i=0; i<manualTasks.length; i++){
						var manualTask = $(manualTasks[i]);
						if(manualTask.position().top>=manualTask.height())
							break;
					}
					if(i<manualTasks.length)
						manualTasksRight.show();
					else
						manualTasksRight.hide();
					
					pworkManual.find('a.js_select_task_manual:first div:first').click();
					
					smartPop.closeProgress();
				},
				error : function(xhr, ajaxOptions, thrownError){
					smartPop.closeProgress();					
				}
			});
		}
		return false;
	});

	$('a.js_select_task_manual').live('click', function(e){
		var input = $(e.target).parents('a.js_select_task_manual:first');
		var manualTasksHolder = input.parents('.js_pwork_manual_page').find('.js_manual_tasks_holder');
		
		var target = $("#"+input.attr("taskId"));
		var target_point = $(target).find("div.up_point:first");
		var selectedManualTask = input.parents('.js_manual_task');
		target_point.css({"left": (selectedManualTask.position().left + selectedManualTask.outerWidth()/2) + "px"});
		$(target).show().siblings('div.js_task_manual').hide();
		return false;
	});
	
	$('a.js_manual_tasks_right').live('click', function(e){
		var input = $(e.target).parents('a:first');
		var pworkManual = input.parents('.js_pwork_manual_page');
		var manualTasksHolder = pworkManual.find('.js_manual_tasks_holder');
		var manualLeft = pworkManual.find('.js_manual_tasks_left');	
		var manualRight = pworkManual.find('.js_manual_tasks_right');

		var tasksVisible = manualTasksHolder.find(".js_manual_task:visible");
		var viewWidth = manualTasksHolder.width();
		var tasksOverflew = new Array();
		for(var i=0; i<tasksVisible.length; i++){
			var task  =$(tasksVisible[i]);
			if(task.position().top>=task.height())
				tasksOverflew.push(tasksVisible[i]);
		}
		if(isEmpty(tasksOverflew) || tasksOverflew.length==0){
			manualRight.hide();
			return false;
		}

		var overflewWidth = 0;
		for(var i=0; i<tasksOverflew.length; i++){
			overflewWidth = overflewWidth + $(tasksOverflew[i]).outerWidth() + 10;
			if(overflewWidth>viewWidth/2) break;
		}

		for(var i=0; i<tasksVisible.length && overflewWidth>0; i++){
			var task = $(tasksVisible[i]);
			overflewWidth = overflewWidth - task.outerWidth() - 10;
			task.hide();
		}

		var tasksHidden = manualTasksHolder.find(".js_manual_task:hidden");
		if(isEmpty(tasksHidden))
			manualLeft.hide();
		else
			manualLeft.show();
		
		tasksVisible = manualTasksHolder.find(".js_manual_task:visible");
		for(var i=0; i<tasksVisible.length; i++){
			var task = $(tasksVisible[i]);
			if(task.position().top>=task.height())
				break;
		}
		if(tasksVisible.length==0 || i==tasksVisible.length){
			manualRight.hide();
		}else{
			manualRight.show();
		}
		
		if(tasksVisible.length>0)
			$(tasksVisible[i-1]).find('div:first').click();
		return false;
	});
	
	$('a.js_manual_tasks_left').live('click', function(e){

		var input = $(e.target).parents('a:first');
		var pworkManual = input.parents('.js_pwork_manual_page');
		var manualTasksHolder = pworkManual.find('.js_manual_tasks_holder');
		var manualLeft = pworkManual.find('.js_manual_tasks_left');	
		var manualRight = pworkManual.find('.js_manual_tasks_right');

		var tasksHidden = manualTasksHolder.find(".js_manual_task:hidden");
		var viewWidth = manualTasksHolder.width();
		if(isEmpty(tasksHidden) || tasksHidden.length==0){
			manualLeft.hide();
			return false;
		}

		var hiddenWidth = 0;
		for(var i=tasksHidden.length-1; i>=0; i--){
			var task = $(tasksHidden[i]).show();
			hiddenWidth = hiddenWidth + task.outerWidth() + 10;
			if(hiddenWidth>viewWidth/2) break;
		}

		if(i>0)
			manualLeft.show();
		else
			manualLeft.hide();
		
		tasksVisible = manualTasksHolder.find(".js_manual_task:visible");
		for(var i=0; i<tasksVisible.length; i++){
			var task = $(tasksVisible[i]);
			if(task.position().top>=task.height())
				break;
		}
		if(tasksVisible.length==0 || i==tasksVisible.length){
			manualRight.hide();
		}else{
			manualRight.show();
		}

		if(tasksVisible.length>0)
			$(tasksVisible[0]).find('div:first').click();
		return false;
	});
	
	$('a.js_select_task_instance').live("click", function(e){
		smartPop.progressCenter();
		var input = $(e.target).parents('a');
		clickOnTask(input);
		return false;
	});

	$('a.js_instance_tasks_right').live('click', function(e){
		var input = $(e.target).parents('a:first');
		var pworkSpace = input.parents('.js_pwork_space_page');
		var instanceTasksHolder = pworkSpace.find('.js_instance_tasks_holder');
		var instanceLeft = pworkSpace.find('.js_instance_tasks_left');	
		var instanceRight = pworkSpace.find('.js_instance_tasks_right');

		var tasksVisible = instanceTasksHolder.find(".js_instance_task:visible");
		var arrowsVisible = instanceTasksHolder.find('.js_instance_task_arrow:visible');
		var viewWidth = instanceTasksHolder.width();
		var tasksOverflew = new Array();
		for(var i=0; i<tasksVisible.length; i++){
			var task  =$(tasksVisible[i]);
			if(task.position().top>=task.height())
				tasksOverflew.push(tasksVisible[i]);
		}
		if(isEmpty(tasksOverflew) || tasksOverflew.length==0){
			instanceRight.hide();
			return false;
		}

		var overflewWidth = 0;
		for(var i=0; i<tasksOverflew.length; i++){
			overflewWidth = overflewWidth + $(tasksOverflew[i]).outerWidth() + $(arrowsVisible[0]).outerWidth() + 10;
			if(overflewWidth>viewWidth/2) break;
		}

		for(var i=0; i<tasksVisible.length && overflewWidth>0; i++){
			var task = $(tasksVisible[i]);
			var arrow = $(arrowsVisible[i]);
			overflewWidth = overflewWidth - task.outerWidth() - arrow.outerWidth() - 10;
			task.hide();
			arrow.hide();
		}

		var tasksHidden = instanceTasksHolder.find(".js_instance_task:hidden");
		if(isEmpty(tasksHidden))
			instanceLeft.hide();
		else
			instanceLeft.show();
		
		tasksVisible = instanceTasksHolder.find(".js_instance_task:visible");
		for(var i=0; i<tasksVisible.length; i++){
			var task = $(tasksVisible[i]);
			if(task.position().top>=task.height())
				break;
		}
		if(tasksVisible.length==0 || i==tasksVisible.length){
			instanceRight.hide();
		}else{
			instanceRight.show();
		}
		
		if(tasksVisible.length>0)
			$(tasksVisible[i-1]).find('img:first').click();
		return false;
	});
	
	$('a.js_instance_tasks_left').live('click', function(e){
		
		var input = $(e.target).parents('a:first');
		var pworkSpace = input.parents('.js_pwork_space_page');
		var instanceTasksHolder = pworkSpace.find('.js_instance_tasks_holder');
		var instanceLeft = pworkSpace.find('.js_instance_tasks_left');	
		var instanceRight = pworkSpace.find('.js_instance_tasks_right');

		var tasksHidden = instanceTasksHolder.find(".js_instance_task:hidden");
		var arrowsHidden = instanceTasksHolder.find('.js_instance_task_arrow:hidden');
		var viewWidth = instanceTasksHolder.width();
		if(isEmpty(tasksHidden) || tasksHidden.length==0){
			instanceLeft.hide();
			return false;
		}

		var hiddenWidth = 0;
		for(var i=tasksHidden.length-1; i>=0; i--){
			var task = $(tasksHidden[i]).show();
			var arrow = $(arrowsHidden[i]).show();
			hiddenWidth = hiddenWidth + task.outerWidth() + arrow.outerWidth() + 10;
			if(hiddenWidth>viewWidth/2) break;
		}

		if(i>0)
			instanceLeft.show();
		else
			instanceLeft.hide();
		
		tasksVisible = instanceTasksHolder.find(".js_instance_task:visible");
		for(var i=0; i<tasksVisible.length; i++){
			var task = $(tasksVisible[i]);
			if(task.position().top>=task.height())
				break;
		}
		if(tasksVisible.length==0 || i==tasksVisible.length){
			instanceRight.hide();
		}else{
			instanceRight.show();
		}

		if(tasksVisible.length>0)
			$(tasksVisible[0]).find('img:first').click();
		return false;
	});

	$('a.js_modify_iwork_instance').live('click', function(e){
		var input = $(e.target);
		var iworkSpace = input.parents('.js_iwork_space_page');
		var workId = iworkSpace.attr("workId");
		var instId = iworkSpace.attr("instId");
		var formContent = iworkSpace.find('div.js_form_content');
		formContent.html('');
		formContent.removeClass('list_contents');			
		new SmartWorks.GridLayout({
			target : formContent,
			mode : "edit",
			workId : workId,
			recordId : instId
		});
		iworkSpace.find('.js_btn_modify').hide();
		iworkSpace.find('.js_btn_delete').hide();
		iworkSpace.find('.js_btn_save').show();
		iworkSpace.find('.js_btn_cancel').show();
		return false;
	});

	$('a.js_cancel_iwork_instance').live('click', function(e){
		var input = $(e.target);
		var iworkSpace = input.parents('.js_iwork_space_page');
		var workId = iworkSpace.attr("workId");
		var instId = iworkSpace.attr("instId");
		var formContent = iworkSpace.find('div.js_form_content');
		iworkSpace.find('.js_form_task_approval').hide().html('');
		iworkSpace.find('.js_form_task_forward').hide().html('');
		iworkSpace.find('.js_form_task_email').hide().html('');
		formContent.html('');
		formContent.addClass('list_contents');
		new SmartWorks.GridLayout({
			target : formContent,
			mode : "view",
			workId : workId,
			recordId : instId
		});
		showErrors();
		iworkSpace.find('.js_btn_modify').show().siblings().hide();
		iworkSpace.find('.js_btn_delete').show();
		return false;
	});

	$('a.js_save_iwork_instance').live('click', function(e){
		var input = $(e.target);
		var iworkSpace = input.parents('.js_iwork_space_page');
		var workId = iworkSpace.attr("workId");
		var instId = iworkSpace.attr("instId");
		var formContent = iworkSpace.find('div.js_form_content');
		// iwork_instance 에 있는 활성화되어 있는 모든 입력화면들을 validation하여 이상이 없으면 submit를 진행한다...
		if (!SmartWorks.GridLayout.validate(iworkSpace.find('form.js_validation_required'), $('.js_space_error_message'))) return false;
		
		smartPop.confirm(smartMessage.get("saveConfirmation"), function(){
			var forms = iworkSpace.find('form');
			var paramsJson = {};
			paramsJson['workId'] = workId;
			paramsJson['instanceId'] = instId;
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
			console.log(JSON.stringify(paramsJson));
			var url = "set_iwork_instance.sw";
			
			// 서비스요청 프로그래스바를 나타나게 한다....
			var progressSpan = iworkSpace.find('.js_progress_span');
			smartPop.progressCont(progressSpan);
			
			// set_iwork_instance.sw서비스를 요청한다..
			$.ajax({
				url : url,
				contentType : 'application/json',
				type : 'POST',
				data : JSON.stringify(paramsJson),
				success : function(data, status, jqXHR) {
					
					// 성공시에 프로그래스바를 제거하고 성공메시지를 보여준다...
					smartPop.closeProgress();
					smartPop.showInfo(smartPop.INFO, smartMessage.get("setIWorkInstanceSucceed"), function(){
						// 서비스요청 프로그래스바를 나타나게 한다....
						var progressSpan = iworkSpace.find('.js_progress_span');
						smartPop.progressCont(progressSpan);
						formContent.html('');
						formContent.addClass('list_contents');
						new SmartWorks.GridLayout({
							target : formContent,
							mode : "view",
							workId : workId,
							recordId : instId,
							onSuccess : function(){
								iworkSpace.find('.js_btn_modify').show();
								iworkSpace.find('.js_btn_delete').show();
								iworkSpace.find('.js_btn_save').hide();
								iworkSpace.find('.js_btn_cancel').hide();
								smartPop.closeProgress();								
							},
							onError : function(){
								smartPop.closeProgress();																
							}
						});
					});
				},
				error : function(e) {
					// 서비스 에러시에는 메시지를 보여주고 현재페이지에 그래도 있는다...
					smartPop.closeProgress();
					smartPop.showInfo(smartPop.ERROR, smartMessage.get("setIWorkInstanceError"), function(){
						return false;
					});
					
				}
			});
		},
		function(){
			return false;
		});
		return false;
	});

	$('a.js_forward_iwork_instance').live('click', function(e){
		var input = $(e.target);
		var iworkSpace = input.parents('.js_iwork_space_page');
		var workId = iworkSpace.attr("workId");
		var instId = iworkSpace.attr("instId");
		// iwork_instance 에 있는 활성화되어 있는 모든 입력화면들을 validation하여 이상이 없으면 submit를 진행한다...
		if (!SmartWorks.GridLayout.validate(iworkSpace.find('.js_form_task_forward form'), $('.js_space_error_message'))) return false;
		
		smartPop.confirm(smartMessage.get("forwardConfirmation"), function(){
			var forms = iworkSpace.find('.js_form_task_forward form');
			var paramsJson = {};
			paramsJson['workId'] = workId;
			paramsJson['instanceId'] = instId;
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
			console.log(JSON.stringify(paramsJson));
			var url = "forward_iwork_instance.sw";
			
			// 서비스요청 프로그래스바를 나타나게 한다....
			var progressSpan = iworkSpace.find('.js_progress_span');
			smartPop.progressCont(progressSpan);
			
			// set_iwork_instance.sw서비스를 요청한다..
			$.ajax({
				url : url,
				contentType : 'application/json',
				type : 'POST',
				data : JSON.stringify(paramsJson),
				success : function(data, status, jqXHR) {
					
					// 성공시에 프로그래스바를 제거하고 성공메시지를 보여준다...
					smartPop.closeProgress();
					smartPop.showInfo(smartPop.INFO, smartMessage.get("forwardIWorkInstanceSucceed"), function(){
						iworkSpace.find('.js_form_task_forward').hide().html('');
						iworkSpace.find('.js_btn_save').show().siblings().hide();						
						iworkSpace.find('.js_btn_modify').show();						
						return false;
					});
				},
				error : function(e) {
					// 서비스 에러시에는 메시지를 보여주고 현재페이지에 그래도 있는다...
					smartPop.closeProgress();
					smartPop.showInfo(smartPop.ERROR, smartMessage.get("forwardIWorkInstanceError"), function(){
						return false;
					});
					
				}
			});
		},
		function(){
			return false;
		});
		return false;
	});

	$('a.js_delete_iwork_instance').live('click', function(e){
		smartPop.confirm(smartMessage.get('removeConfirmation'), function(){
			var input = $(e.target);
			var iworkSpace = input.parents('.js_iwork_space_page');
			var workId = iworkSpace.attr("workId");
			var instId = iworkSpace.attr("instId");
			var paramsJson = {};
			paramsJson['workId'] = workId;
			paramsJson['instanceId'] = instId;
			console.log(JSON.stringify(paramsJson));
			var url = "remove_iwork_instance.sw";
			
			// 서비스요청 프로그래스바를 나타나게 한다....
			var progressSpan = iworkSpace.find('.js_progress_span');
			smartPop.progressCont(progressSpan);
			
			// set_iwork_instance.sw서비스를 요청한다..
			$.ajax({
				url : url,
				contentType : 'application/json',
				type : 'POST',
				data : JSON.stringify(paramsJson),
				success : function(data, status, jqXHR) {
					
					// 성공시에 프로그래스바를 제거하고 성공메시지를 보여준다...
					smartPop.closeProgress();
					smartPop.showInfo(smartPop.INFO, smartMessage.get("removeIWorkInstanceSucceed"), 
							function(){
								// 정보관리업무 목록 페이지로 이동한다.....
								document.location.href = "iwork_list.sw?cid=iw.li." + workId;					
							});
				},
				error : function(e) {
					// 서비스 에러시에는 메시지를 보여주고 현재페이지에 그래도 있는다...
					smartPop.closeProgress();
					smartPop.showInfo(smartPop.ERROR, smartMessage.get("removeIWorkInstanceError"), function(){
						return false;
					});
					
				}
			});
			
		},
		function(){
			return false;
		});
		return false;
	});

	$('a.js_perform_task_instance').live('click', function(e){
		var input = $(e.target).parents('a.js_perform_task_instance');
		var pworkSpace = input.parents('.js_pwork_space_page');
		var workId = pworkSpace.attr("workId");
		var instId = pworkSpace.attr("instId");
		var formContent = pworkSpace.find('div.js_form_content');
		var taskInstId = formContent.attr("taskInstId");
		// iwork_instance 에 있는 활성화되어 있는 모든 입력화면들을 validation하여 이상이 없으면 submit를 진행한다...
		if (!SmartWorks.GridLayout.validate(formContent.find('form.js_validation_required'), $('.js_space_error_message'))) return false;
		
		smartPop.confirm(smartMessage.get("performConfirmation"), function(){
			var forms = formContent.find('form');
			var paramsJson = {};
			paramsJson['workId'] = workId;
			paramsJson['instanceId'] = instId;
			paramsJson['taskInstId'] = taskInstId;
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
			console.log(JSON.stringify(paramsJson));
			var url = "perform_task_instance.sw";
			
			// 서비스요청 프로그래스바를 나타나게 한다....
			var progressSpan = pworkSpace.find('.js_progress_span');
			smartPop.progressCont(progressSpan);
			
			// perform_task_instance.sw서비스를 요청한다..
			$.ajax({
				url : url,
				contentType : 'application/json',
				type : 'POST',
				data : JSON.stringify(paramsJson),
				success : function(data, status, jqXHR) {
					
					// 성공시에 프로그래스바를 제거하고 성공메시지를 보여준다...
					smartPop.closeProgress();
					smartPop.showInfo(smartPop.INFO, smartMessage.get("performTaskInstanceSucceed"), function(){
						document.location.href = "pwork_list.sw?cid=pw.li." + workId;
						return;
					});
				},
				error : function(e) {
					// 서비스 에러시에는 메시지를 보여주고 현재페이지에 그래도 있는다...
					smartPop.closeProgress();
					smartPop.showInfo(smartPop.ERROR, smartMessage.get("performTaskInstanceError"), function(){
						return;
					});
					
				}
			});
		},
		function(){
			return false;
		});
		return false;
	});

	$('a.js_return_task_instance').live('click', function(e){
		var input = $(e.target).parents('a.js_return_task_instance');
		var pworkSpace = input.parents('.js_pwork_space_page');
		var workId = pworkSpace.attr("workId");
		var instId = pworkSpace.attr("instId");
		var formContent = pworkSpace.find('div.js_form_content');
		var taskInstId = formContent.attr("taskInstId");
		
		smartPop.confirm(smartMessage.get("returnConfirmation"), function(){
			var forms = formContent.find('form');
			var paramsJson = {};
			paramsJson['workId'] = workId;
			paramsJson['instanceId'] = instId;
			paramsJson['taskInstId'] = taskInstId;
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
			console.log(JSON.stringify(paramsJson));
			var url = "return_task_instance.sw";
			
			// 서비스요청 프로그래스바를 나타나게 한다....
			var progressSpan = pworkSpace.find('.js_progress_span');
			smartPop.progressCont(progressSpan);
			
			// perform_task_instance.sw서비스를 요청한다..
			$.ajax({
				url : url,
				contentType : 'application/json',
				type : 'POST',
				data : JSON.stringify(paramsJson),
				success : function(data, status, jqXHR) {
					
					// 성공시에 프로그래스바를 제거하고 성공메시지를 보여준다...
					smartPop.closeProgress();
					smartPop.showInfo(smartPop.INFO, smartMessage.get("returnTaskInstanceSucceed"), function(){
						document.location.href = "pwork_list.sw?cid=pw.li." + workId;
						return;
					});
				},
				error : function(e) {
					// 서비스 에러시에는 메시지를 보여주고 현재페이지에 그래도 있는다...
					smartPop.closeProgress();
					smartPop.showInfo(smartPop.ERROR, smartMessage.get("returnTaskInstanceError"), function(){
						return;
					});
					
				}
			});
		},
		function(){
			return false;
		});
		return false;
	});

	$('a.js_temp_save_task_instance').live('click', function(e){
		var input = $(e.target).parents('a.js_temp_save_task_instance');
		var pworkSpace = input.parents('.js_pwork_space_page');
		var workId = pworkSpace.attr("workId");
		var instId = pworkSpace.attr("instId");
		var formContent = pworkSpace.find('div.js_form_content');
		var taskInstId = formContent.attr("taskInstId");
		
		smartPop.confirm(smartMessage.get("tempSaveConfirmation"), function(){
			var forms = formContent.find('form');
			var paramsJson = {};
			paramsJson['workId'] = workId;
			paramsJson['instanceId'] = instId;
			paramsJson['taskInstId'] = taskInstId;
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
			console.log(JSON.stringify(paramsJson));
			var url = "temp_save_task_instance.sw";
			
			// 서비스요청 프로그래스바를 나타나게 한다....
			var progressSpan = pworkSpace.find('.js_progress_span');
			smartPop.progressCont(progressSpan);
			
			// perform_task_instance.sw서비스를 요청한다..
			$.ajax({
				url : url,
				contentType : 'application/json',
				type : 'POST',
				data : JSON.stringify(paramsJson),
				success : function(data, status, jqXHR) {
					
					// 성공시에 프로그래스바를 제거하고 성공메시지를 보여준다...
					smartPop.closeProgress();
					smartPop.showInfo(smartPop.INFO, smartMessage.get("tempSaveTaskInstanceSucceed"), function(){
						return;
					});
				},
				error : function(e) {
					// 서비스 에러시에는 메시지를 보여주고 현재페이지에 그래도 있는다...
					smartPop.closeProgress();
					smartPop.showInfo(smartPop.ERROR, smartMessage.get("tempSaveTaskInstanceError"), function(){
						return;
					});
					
				}
			});
		},
		function(){
			return false;
		});
		return false;
	});

	$('a.js_reassign_task_instance').live('click', function(e){
		var input = $(e.target).parents('a.js_reassign_task_instance');
		var pworkSpace = input.parents('.js_pwork_space_page');
		var workId = pworkSpace.attr("workId");
		var instId = pworkSpace.attr("instId");
		var formContent = pworkSpace.find('div.js_form_content');
		var taskInstId = formContent.attr("taskInstId");
		
		smartPop.confirm(smartMessage.get("reassignConfirmation"), function(){
			var forms = formContent.find('form');
			var paramsJson = {};
			paramsJson['workId'] = workId;
			paramsJson['instanceId'] = instId;
			paramsJson['taskInstId'] = taskInstId;
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
			console.log(JSON.stringify(paramsJson));
			var url = "reassign_task_instance.sw";
			
			// 서비스요청 프로그래스바를 나타나게 한다....
			var progressSpan = pworkSpace.find('.js_progress_span');
			smartPop.progressCont(progressSpan);
			
			// perform_task_instance.sw서비스를 요청한다..
			$.ajax({
				url : url,
				contentType : 'application/json',
				type : 'POST',
				data : JSON.stringify(paramsJson),
				success : function(data, status, jqXHR) {
					
					// 성공시에 프로그래스바를 제거하고 성공메시지를 보여준다...
					smartPop.closeProgress();
					smartPop.showInfo(smartPop.INFO, smartMessage.get("reassignTaskInstanceSucceed"), function(){
						document.location.href = "pwork_list.sw?cid=pw.li." + workId;
						return;
					});
				},
				error : function(e) {
					// 서비스 에러시에는 메시지를 보여주고 현재페이지에 그래도 있는다...
					smartPop.closeProgress();
					smartPop.showInfo(smartPop.ERROR, smartMessage.get("reassignTaskInstanceError"), function(){
						return;
					});
					
				}
			});
		},
		function(){
			return false;
		});
		return false;
	});

	$('input.js_file_upload').live('change', function(e) {
		var input = $(e.target);
		var newInput = document.createElement( 'input' );
		newInput.type = 'file';
		$(newInput).addClass('js_file_upload');
		
		input.parent().add( newInput);
//		e.target.style.display = 'none';
		var target = input.parent().next('div.js_selected_files');
		var oldHTML = target.html();
		if (oldHTML == null)
			oldHTML = "";		
		var newHTML = oldHTML
		+ "<span class='js_file_item user_select' >"
		+ input[0].value
		+ "<span class='btn_x_gr'><a class='js_remove_file' href=''> x</a></span></span>";
		target.html(newHTML);
		$(target).find('span.js_file_item').add(e.target);
	});

	$('.qq-delete-text').live('click', function(e) {
		$.ajax({
			url : "delete_file.sw",
			data : {
				fileId : $(e.target).parent('li').attr('fileId'),
				fileName : $(e.target).siblings('a').attr('filename')
			},
			type : "POST",
			context : this,
			success : function(data, status, jqXHR) {
				$(e.target).parent().remove();
			},
			error : function(xhr, ajaxOptions, thrownError){
				
			}
		});
		return false;
	});

	$('a.js_copy_address').zclip({
        path:'js/jquery/ZeroClipboard.swf',
        copy: function(){
        	return $(location).attr('href');
        	},
        beforeCopy: null,
        afterCopy:null
    });

	$('.js_pop_all_works').live('click', function(e) {
		var startWork = $(e.target).parents('.js_start_work_page');
		var target = startWork.find('.js_all_work_popup');
		var width = startWork.find('.js_auto_complete:first').parent().outerWidth();
		smartPop.selectWork(target, width);
		return false;
	});

	$('a.js_todaypicker_button').live('click', function(e) {
		var input = $(e.target).parent();
		input.prev('.js_todaypicker').datepicker("show");
		return false;
	});

	$('a.js_timepicker_button').live('click', function(e) {
		var input = $(e.target).parent();
		input.prev('.js_timepicker').timepicker("show");
		return false;
	});
	
	$('a.js_todaytimepicker_button').live('click', function(e) {
		var input = $(e.target).parent();
		input.prev('.js_todaytimepicker').datetimepicker("show");
		return false;
	});

	$('a.js_userpicker_button').live('click', function(e) {
		var userField = $(e.target).parents('.js_type_userField:first');
		var userInput = userField.find('.js_selected_communities:first');
		var target = userField.find('.js_community_popup:first');
		var width = userField.find('.form_value').find('div:first').width();
		var isMultiUsers = userField.attr('multiUsers');
		smartPop.selectUser(userInput, target, width, isMultiUsers);
		return false;
	});

	$('a.js_workitempicker_button').live('click', function(e) {
		var target = $(e.target).parents('td.js_type_refFormField:first');
		var formId = target.attr('refForm');
		smartPop.selectWorkItem(formId, target);
		return false;
	});
	
	$('.js_type_radioButton input').live('click', function(e){
		var target = $(e.target).parents('.js_type_radioButton').find('.sw_required');
		if(target.hasClass('sw_error')){
			target.removeClass('sw_error');
			$('form.js_validation_required').validate({ showErrors: showErrors}).form();
		}
	});

	$('a.js_toggle_forward_btn').live('click',function(e) {
		var input = $(e.target);
		var target = input.parents('.js_form_header').siblings('.js_form_task_forward');
		if(target.is(':visible')){
			target.hide().html('');
			var iworkSpace = input.parents('.js_iwork_space_page');
			if(!isEmpty(iworkSpace)){
				iworkSpace.find('.js_btn_save').show().siblings().hide();						
				iworkSpace.find('.js_btn_modify').show();						
			}
			return false;
		}
		$.ajax({
			url : 'append_task_forward.sw',
			data : {},
			success : function(data, status, jqXHR) {
				target.html(data).show();
				loadTaskForwardFields();
				var iworkSpace = input.parents('.js_iwork_space_page');
				if(!isEmpty(iworkSpace)){
					iworkSpace.find('.js_btn_do_forward').show().siblings().hide();
					iworkSpace.find('.js_btn_cancel').show();						
				}
			},
			error : function(xhr, ajaxOptions, thrownError){
				
			}
		});
		return false;
	});

	$('a.js_view_my_running_instances').live('click',function(e) {
		var input = $(e.target);
		input.addClass('current').siblings().removeClass('current');
		var target = input.parents('.js_my_running_instance_list_page').find('table');  
		$.ajax({
			url : 'more_instance_list.sw',
			data : {
				assignedOnly : false
			},
			success : function(data, status, jqXHR) {
				target.html(data);
			},
			error : function(xhr, ajaxOptions, thrownError){
				
			}
		});
		return false;
	});

	$('a.js_view_assigned_instances').live('click',function(e) {
		var input = $(e.target);
		input.addClass('current').siblings().removeClass('current');
		var target = input.parents('.js_my_running_instance_list_page').find('table');  
		$.ajax({
			url : 'more_instance_list.sw',
			data : {
				assignedOnly : true
			},
			success : function(data, status, jqXHR) {
				target.html(data);
			},
			error : function(xhr, ajaxOptions, thrownError){
				
			}
		});
		return false;
	});
	
	var filesDetailTimer = null;
	$('.js_pop_files_detail').live('mouseenter', function(e){
		if(filesDetailTimer!=null){
			clearTimeout(filesDetailTimer);
			filesDetailTimer = null;
		}
		var input = $(e.target);
		var picture = input;
		var top = picture.offset().top+ picture.height() + 5;
		var left = picture.offset().left + picture.width() + 5;
		smartPop.showFilesDetail(input, top, left);		
	});

	$('.js_pop_files_detail').live('mouseleave', function(e){
		filesDetailTimer = setTimeout(function(){
			smartPop.closeFilesDetail();
			filesDetailTimer = null;
		}, 300);
	});
	
	$('#sw_pop_files_detail').live('mouseenter', function(e){
		if(filesDetailTimer!=null){
			clearTimeout(filesDetailTimer);
			filesDetailTimer = null;
		}		
	});

	$('#sw_pop_files_detail').live('mouseleave', function(e){
		filesDetailTimer = setTimeout(function(){
			smartPop.closeFilesDetail();
			filesDetailTimer = null;
		}, 300);
	});
	

});
