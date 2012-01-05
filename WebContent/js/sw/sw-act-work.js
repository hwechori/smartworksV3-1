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
			popProgressCenter();
			$('#form_works').slideUp().slideDown(500);
			$(event.target).parents('#upload_work_list').hide().parents(".js_start_work").slideUp();
		},
		target : 'form_works',
		after : function(event) {
			var input = $(event.target).parents('li:first').children('a');
			var formContent = $('#form_works').find('div.js_form_content');
			var workId = input.attr('workId');
			var workType = formContent.attr("workType");
			$.ajax({
				url : "get_form_xml.sw",
				data : {
					workId : workId
				},
				success : function(formXml, status, jqXHR) {
					console.log(formXml);
					new SmartWorks.GridLayout({
						target : formContent,
						formXml : formXml,
						mode : "edit"
					});
					closeProgress();
				},
				error : function(){
					closeProgress();
				}				
			});			
		}
	});

	$('a.js_create_new_work').live('click', function(e) {
		var input = $(e.target);
		var target = input.parents('div.js_work_list_title:first').siblings('div.js_new_work_form');
		var url = input.attr('href');
		$.ajax({
			url : url,
			data : {},
			success : function(data, status, jqXHR) {
				target.html(data).slideDown(500);
				var formContent = target.find('div.js_form_content');
				var workId = input.attr('workId');
				$.ajax({
					url : "get_form_xml.sw",
					data : {
						workId : workId
					},
					success : function(formXml, status, jqXHR) {
						new SmartWorks.GridLayout({
							target : formContent,
							formXml : formXml,
							mode : "edit"
						});
					}
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
	$('a.js_toggle_form_detail').swnavi(
		{
			target : 'form_import',
			after : function(event) {
				var input = $(event.target);
				input.parents('div.js_file_detail_form').parent().prev().slideToggle(500);
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
						}
					});
				}
			}
		});

	$('a.js_view_work_manual').live('click', function(e){
		var input = $(e.target);
		input.parents("div.js_content_div:first").next('#work_manual').slideToggle(500);
		input.hide();
		input.siblings().show();
		return false;
	});

	$('a.js_select_task_manual').live('click', function(e){
		var input = $(e.target).parents('a.js_select_task_manual:first');
		var target = $("#"+input.attr("taskId"));
		var target_point = $(target).find("div.up_point:first");
		target_point.css({"left": (input.position().left + 20) + "px"});
		$(target).show().siblings('div.js_task_manual').hide();
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
		popSelectWork(target, width);
		return false;
	});

	$('a.js_pop_user_info').live('click', function(e) {
		var input = $(e.target);
		var left = input.parents('td:first').position().left;
		var top = input.parents('td:first').position().top;
		input.popupWindow({ 
			width:600,
			height:600,
			top:top, 
			left:left
		}); 
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
		popSelectUser(userInput, target, width, isMultiUsers);
		return false;
	});

	$('a.js_workitempicker_button').live('click', function(e) {
		var target = $(e.target).parents('td.js_type_refFormField:first');
		var formId = target.attr('refForm');
		popSelectWorkItem(formId, target);
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
		$.ajax({
			url : 'append_task_forward.sw',
			data : {},
			success : function(data, status, jqXHR) {
				target.html(data).slideToggle(500);
				loadTaskForwardFields();
			}
		});
		return false;
	});

});
