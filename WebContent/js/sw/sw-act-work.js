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
		input.parents('.up_icon_list').find('a').addClass('current');
		var target = $('#upload_form_box');
		var url = input.attr('href');
		$.ajax({
			url : url,
			data : {},
			success : function(data, status, jqXHR) {
				target.html(data).slideDown(500);
				if(!isEmpty(target.find('form[name="frmNewFile"]'))){
					loadNewFileFields();
				}else if(!isEmpty(target.find('form[name="frmNewPicture"]'))){
					loadNewPictureFields();							
				}else if(!isEmpty(target.find('form[name="frmNewEvent"]'))){
					loadNewEventFields();
				}else if(!isEmpty(target.find('form[name="frmNewMemo"]'))){
					loadNewMemoFields();
				}else if(!isEmpty(target.find('form[name="frmNewBoard"]'))){
					loadNewBoardFields();
				}
			},
			error : function(xhr, ajaxOptions, thrownError){
				
			}
		});
		return false;
	});

	$('a.js_cancel_action').live('click',function(e) {
		var input = $('.js_select_action').find('a:first');
		$('.js_select_action').find('a').removeClass('current');
		input.parents('.up_icon_list').find('a').addClass('current');
		var target = $('#upload_form_box');
		var url = input.attr('href');
		$.ajax({
			url : url,
			data : {},
			success : function(data, status, jqXHR) {
				target.html(data).slideDown(500);
				if(!isEmpty(target.find('form[name="frmNewFile"]'))){
					loadNewFileFields();
				}else if(!isEmpty(target.find('form[name="frmNewPicture"]'))){
					loadNewPictureFields();							
				}else if(!isEmpty(target.find('form[name="frmNewEvent"]'))){
					loadNewEventFields();
				}else if(!isEmpty(target.find('form[name="frmNewMemo"]'))){
					loadNewMemoFields();
				}else if(!isEmpty(target.find('form[name="frmNewBoard"]'))){
					loadNewBoardFields();
				}
			},
			error : function(xhr, ajaxOptions, thrownError){
				
			}
		});
		return false;
	});

	/*
	 * 새업무시작하기에서, 처음나오는 입력창을 클릭하면 실행되는 이벤트로, 우측에 전체업무찾기 버튼을 보여준다.
	 */
	$('.js_start_work').live( 'click', function(e) {
		$(e.target).parents('div.js_start_work:first').find(
						'#all_work_btn').show();
	});

	/*
	 * 세업무시작하기에서, 입력창에 값을 입력하여 나오는 검색결과를 선택하면 실행되는 이벤트로, 검색결과항목의 href값으로 ajax를
	 * 실행하여 가져온 값으로 id가 form_works 인 곳 화면을 그려서, 아래로 펼쳐준다.
	 */
	$('.js_select_work').swnavi({
		before : function(event) {
			smartPop.progressCenter();
			$('#form_works').html('').hide();
			$(event.target).parents('#upload_work_list').hide().parents(".js_start_work").hide();
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
					$('#form_works').show();
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
	
	$('a.js_create_new_work').live('click', function(e) {
		var input = $(e.target);
		var target = input.parents('.js_iwork_list_page').find('div.js_new_work_form');
		var url = input.attr('href');
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
					var manualTasksHolder = pworkManual.find(".js_manual_tasks_holder");
					var manualTasks = manualTasksHolder.find(".js_manual_tasks");
					var placeHolderTask = manualTasks.find('.js_manual_task_placeholder').hide();
					var left = manualTasks.position().left;
					var width = manualTasks.width();
					var remainingWidth = width+left;

					var tasksRight = manualTasksHolder.width();
					var tasks = manualTasks.find(".js_manual_task");
					for(var i=0; i<tasks.length; i++){
						var task = $(tasks[i]);
						if(task.position().left+task.width()>tasksRight)
							break;
					}
					if(tasks.length>0 && i<tasks.length && i>=0){
						var task = $(tasks[i]);
						placeHolderTask.remove().width(task.width()).show().insertBefore(task);
					}

					var manualLeft = pworkManual.find('.js_manual_tasks_left');	
					var manualRight = pworkManual.find('.js_manual_tasks_right');	
					if(left<0)
						manualLeft.show();
					else
						manualLeft.hide();
					remainingWidth = manualTasks.width()+left;
					if(remainingWidth <= manualTasksHolder.width())
						manualRight.hide();
					else
						manualRight.show();		
					
					pworkManual.find('a.js_select_task_manual:first img').click();
					
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
		var manualTasks = manualTasksHolder.find(".js_manual_tasks");
		var left = manualTasks.position().left;
		var target = $("#"+input.attr("taskId"));
		var target_point = $(target).find("div.up_point:first");
		target_point.css({"left": (input.position().left + left + input.width()/2 + 30) + "px"});
		$(target).show().siblings('div.js_task_manual').hide();
		return false;
	});
	
	$('a.js_manual_tasks_right').live('click', function(e){
		var input = $(e.target).parents('a:first');
		var manualTasksHolder = input.parents('.js_pwork_manual_page').find('.js_manual_tasks_holder');
		var manualTasks = manualTasksHolder.find(".js_manual_tasks");
		var placeHolderTask = manualTasks.find('.js_manual_task_placeholder').hide();
		var left = manualTasks.position().left;
		var width = manualTasks.width();
		var remainingWidth = width+left;
		if(remainingWidth>manualTasksHolder.width()){
			remainingWidth = remainingWidth - manualTasksHolder.width();
			if(remainingWidth>0 && remainingWidth<=manualTasksHolder.width()/2){
				left = left - remainingWidth;
			}else{
				left = left - manualTasksHolder.width()/2;
			}	
		}
		
		var tasks = manualTasks.find(".js_manual_task");
		for(var i=0; i<tasks.length; i++){
			var task = $(tasks[i]);
			if(task.position().left+left>=0 )
				break;
		}
		if(tasks.length>0 && i<tasks.length)
			left = -$(tasks[i]).position().left;
		
		var tasksRight = manualTasksHolder.width() - left;
		for(var i=0; i<tasks.length; i++){
			var task = $(tasks[i]);
			if(task.position().left+task.width()>tasksRight)
				break;
		}
		if(tasks.length>0 && i<tasks.length && i>=0){
			var task = $(tasks[i]);
			placeHolderTask.remove().width(task.width()).show().insertBefore(task);
		}
		manualTasks.css({"left": left + "px"});
		var manualLeft = input.parents('.js_pwork_manual_page').find('.js_manual_tasks_left');
		if(left<0)
			manualLeft.show();
		else
			manualLeft.hide();
		remainingWidth = manualTasks.width()+left;
		if(remainingWidth <= manualTasksHolder.width())
			input.hide();
		else
			input.show();	

		for(var i=0; i<tasks.length; i++){
			var task = $(tasks[i]);
			if(task.position().left>tasksRight && i>1){
				$(tasks[i-1]).find('img').click();
				break;
			}
		}
		if(tasks.length>0 && i==tasks.length){
			$(tasks[tasks.length-1]).find('img').click();
		}

		return false;
	});
	
	$('a.js_manual_tasks_left').live('click', function(e){
		var input = $(e.target).parents('a:first');
		var manualTasksHolder = input.parents('.js_pwork_manual_page').find('.js_manual_tasks_holder');
		var manualTasks = manualTasksHolder.find(".js_manual_tasks");
		var placeHolderTask = manualTasks.find('.js_manual_task_placeholder').hide();
		var left = manualTasks.position().left;
		var width = manualTasks.width();
		var remainingWidth = -left;
		if(remainingWidth>0){
			if(remainingWidth<=manualTasksHolder.width()/2){
				left = left + remainingWidth;
			}else{
				left = left + manualTasksHolder.width()/2;
			}	
		}
		var tasks = manualTasks.find(".js_manual_task");
		for(var i=0; i<tasks.length; i++){
			var task = $(tasks[i]);
			if(task.position().left+left>=0 )
				break;
		}
		if(tasks.length>0 && i<tasks.length){
			left = -$(tasks[i]).position().left;
		}
		var tasksRight = manualTasksHolder.width() - left;
		for(var i=0; i<tasks.length; i++){
			var task = $(tasks[i]);
			if(task.position().left+task.width()>tasksRight)
				break;
		}
		if(tasks.length>0 && i<tasks.length && i>=0){
			var task = $(tasks[i]);
			placeHolderTask.remove().width(task.width()).show().insertBefore(task);
		}

		manualTasks.css({"left": left + "px"});
		if(left<0)
			input.show();
		else
			input.hide();
		remainingWidth = manualTasks.width()+left;
		var manualRight = input.parents('.js_pwork_manual_page').find('.js_manual_tasks_right');
		if(remainingWidth <= manualTasksHolder.width())
			manualRight.hide();
		else
			manualRight.show();

		for(var i=0; i<tasks.length; i++){
			var task = $(tasks[i]);
			if(task.position().left+left>=0 ){
				$(tasks[i]).find('img').click();
				break;
			}
		}

		return false;
	});
	
	$('a.js_select_task_instance').live("click", function(e){
		smartPop.progressCenter();
		var input = $(e.target).parents('a');
		var pworkSpace = input.parents('.js_pwork_space_page');
		var workId = pworkSpace.attr("workId");
		var formId = input.attr("formId");
		var formMode = input.attr("formMode");
		var instId = input.attr("taskInstId");
		var formContent = $('div.js_form_content');
		new SmartWorks.GridLayout({
			target : formContent,
			mode : formMode,
			workId : workId,
			formId : formId,
			taskInstId : instId,
			onSuccess : function(){
				smartPop.closeProgress();																
			},
			onError : function(){
				smartPop.closeProgress();
				
			}
		});
		if(formMode==="edit"){
			pworkSpace.find('.js_btn_complete').show();
			pworkSpace.find('.js_btn_return').show();
			pworkSpace.find('.js_btn_reassign').show();
			pworkSpace.find('.js_btn_temp_save').show();
		}else{
			pworkSpace.find('.js_btn_complete').hide();
			pworkSpace.find('.js_btn_return').hide();
			pworkSpace.find('.js_btn_reassign').hide();
			pworkSpace.find('.js_btn_temp_save').hide();			
		}
		return false;
	});

	$('a.js_instance_tasks_right').live('click', function(e){
		var input = $(e.target).parents('a:first');
		var instanceTasksHolder = input.parents('.js_pwork_space_page').find('.js_instance_tasks_holder');
		var instanceTasks = instanceTasksHolder.find(".js_instance_tasks");
		var placeHolderTask = instanceTasks.find('.js_instance_task_placeholder').hide();
		var left = instanceTasks.position().left;
		var width = instanceTasks.width();
		var remainingWidth = width+left;
		if(remainingWidth>instanceTasksHolder.width()){
			remainingWidth = remainingWidth - instanceTasksHolder.width();
			if(remainingWidth>0 && remainingWidth<=instanceTasksHolder.width()/2){
				left = left - remainingWidth;
			}else{
				left = left - instanceTasksHolder.width()/2;
			}	
		}
		
		var tasks = instanceTasks.find(".js_instance_task");
		for(var i=0; i<tasks.length; i++){
			var task = $(tasks[i]);
			if(task.position().left+left>=0 )
				break;
		}
		if(tasks.length>0 && i<tasks.length)
			left = -$(tasks[i]).position().left;
		
		var tasksRight = instanceTasksHolder.width() - left;
		for(var i=0; i<tasks.length; i++){
			var task = $(tasks[i]);
			if(task.position().left+task.width()>tasksRight){
				break;
			}
		}
		if(tasks.length>0 && i<tasks.length && i>=0){
			var task = $(tasks[i]);
			placeHolderTask.remove().width(task.width()).show().insertBefore(task);
		}
		
		instanceTasks.css({"left": left + "px"});
		var instanceLeft = input.parents('.js_pwork_space_page').find('.js_instance_tasks_left');
		if(left<0)
			instanceLeft.show();
		else
			instanceLeft.hide();
		remainingWidth = instanceTasks.width()+left;
		if(remainingWidth <= instanceTasksHolder.width())
			input.hide();
		else
			input.show();		

		for(var i=0; i<tasks.length; i++){
			var task = $(tasks[i]);
			if(task.position().left>tasksRight && i>1){
				$(tasks[i-1]).find('img').click();
				break;
			}
		}
		if(tasks.length>0 && i==tasks.length){
			$(tasks[tasks.length-1]).find('img').click();
		}

		return false;
	});
	
	$('a.js_instance_tasks_left').live('click', function(e){
		var input = $(e.target).parents('a:first');
		var instanceTasksHolder = input.parents('.js_pwork_space_page').find('.js_instance_tasks_holder');
		var instanceTasks = instanceTasksHolder.find(".js_instance_tasks");
		var placeHolderTask = instanceTasks.find('.js_instance_task_placeholder').hide();
		var left = instanceTasks.position().left;
		var width = instanceTasks.width();
		var remainingWidth = -left;
		if(remainingWidth>0){
			if(remainingWidth<=instanceTasksHolder.width()/2){
				left = left + remainingWidth;
			}else{
				left = left + instanceTasksHolder.width()/2;
			}	
		}
		var tasks = instanceTasks.find(".js_instance_task");
		for(var i=0; i<tasks.length; i++){
			var task = $(tasks[i]);
			if(task.position().left+left>=0 )
				break;
		}
		if(tasks.length>0 && i<tasks.length){
			left = -$(tasks[i]).position().left;
		}
		var tasksRight = instanceTasksHolder.width() - left;
		for(var i=0; i<tasks.length; i++){
			var task = $(tasks[i]);
			if(task.position().left+task.width()>tasksRight)
				break;
		}
		if(tasks.length>0 && i<tasks.length && i>=0){
			var task = $(tasks[i]);
			placeHolderTask.remove().width(task.width()).show().insertBefore(task);
		}

		instanceTasks.css({"left": left + "px"});
		if(left<0)
			input.show();
		else
			input.hide();
		remainingWidth = instanceTasks.width()+left;
		var instanceRight = input.parents('.js_pwork_space_page').find('.js_instance_tasks_right');
		if(remainingWidth <= instanceTasksHolder.width())
			instanceRight.hide();
		else
			instanceRight.show();

		for(var i=0; i<tasks.length; i++){
			var task = $(tasks[i]);
			if(task.position().left+left>=0 ){
				$(tasks[i]).find('img').click();
				break;
			}
		}
		
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

	$('a.js_pop_all_works').live('click', function(e) {
		var startWork = $(e.target).parents('.js_start_work');
		var target = startWork.find('.js_all_work_popup');
		var width = startWork.find('.js_auto_complete:first').parent().width();
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

});
