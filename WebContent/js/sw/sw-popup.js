
onOpenEffect = function(dialog){
	dialog.overlay.fadeIn('slow', function () {
		dialog.container.slideDown('slow', function () {
			dialog.data.fadeIn('slow');
		});
	});	
};

onCloseEffect = function(dialog){
	dialog.data.fadeOut('slow', function () {
		dialog.container.slideUp('slow', function () {
			dialog.overlay.fadeOut('slow', function () {
				$.modal.close(); // must call this!
			});
		});
	});
};

showInfoOptions = {
	opacity: 50,
	overlayCss: {backgroundColor:"#000"},
	containerCss:{
		backgroundColor:"#fff",
		borderColor:"#000",
		color: "#000",
		height:200,
		padding:1,
		width:500
	},
	overlayClose: false
};

smartPop = {
		
	INFO : 'Info',
	WARN : 'Warn',
	ERROR: 'Error',

	overlay : function(target){
		if(isEmpty($(target))) target = $(document.body);
		$('<span id="sw_overlay_span" style="position:absolute; top:0; left:0; background-color:#000000; width:' + $(document).width() + 'px; height:' + $(document).height() + 'px; z-index:10000; display:block; opacity:0.2"></span>').appendTo($(target));
	},
	
	overlayDark : function(target){
		if(isEmpty($(target))) target = $(document.body);
		$('<span id="sw_overlay_span" style="position:absolute; top:0; left:0; background-color:#000000; width:' + $(document).width() + 'px; height:' + $(document).height() + 'px; z-index:10000; display:block; opacity:0.5"></span>').appendTo($(target));
	},
	
	closeOverlay : function(){
		$("#sw_overlay_span").remove();
	},
	
	closeUserInfo : function(){
		smartPop.closeOverlay();
		$('#sw_pop_user_info').hide();		
	},

	showUserInfo : function(input, top, left, directionUp){
		var userId = input.attr("userId");
		var profile = input.attr("profile");
		var userDetail = input.attr("userDetail");		
		var popUserInfo = $('#sw_pop_user_info');
		if(!isEmpty(popUserInfo)){
			popUserInfo.show();
		}else{
			$('<div id="sw_pop_user_info" style="z-index:10001; position:absolute; left:' + left + 'px; top:' + top + 'px;">' +
					'<div class="up_point" style="left: 10px; top: 1px; position: relative;display:none;"></div>' + 
					'<div class="pop_corner_all smart_userinfo_section">' + 
						'<div class="pop_contents">' + 
							'<img src="' + profile + '" class="profile_size_110 fl">' + 
							' <div class="pop_notice_section js_user_information"></div>' +
						'</div>' +
						'<div class="smartp_btn_space">' +
							'<div class="fr">' +
								'<a href="" class="js_send_mail_to_user" userId="' + userId + '"><span class="pop_icon_mail"></span></a>' +
								'<a href="" class="js_leave_message_for_user" userId="' + userId + '"><span class="pop_icon_message"></span></a>' + 
								'<a href="" class="js_start_chat_with_user" userId="' + userId + '"><span class="pop_icon_chat"></span></a>' +
							'</div>' +
						'</div>' +
					'</div>' +
					'<div class="up_point_b" style="left: 10px; position: relative;display:none;"></div>' +
			'</div>').appendTo($(document.body));

			popUserInfo = $('#sw_pop_user_info');

			$('#sw_pop_user_info .js_send_mail_to_user').live('click', function(){
				alert('Send mail to user!!');
				popUserInfo.hide();
				return false;
			});
			$('#sw_pop_user_info .js_leave_message_for_user').live('click', function(){
				alert('Leave message for user!!');
				popUserInfo.hide();
				return false;
			});
			$('#sw_pop_user_info .js_start_chat_with_user').live('click', function(){
				alert('Start chat with user!!');
				popUserInfo.hide();
				return false;
			});
		}
		popUserInfo.find('.js_user_information').html(userDetail);
		if(directionUp){
			popUserInfo.find('.up_point_b').hide();
			popUserInfo.find('.up_point').show();
		}else{
			popUserInfo.find('.up_point').hide();
			popUserInfo.find('.up_point_b').show();
		}
		if(!directionUp)
			top = top - popUserInfo.height();
		popUserInfo.css({"top": top + "px", "left": left + "px"});

	},
	
	closeFilesDetail : function(){
		smartPop.closeOverlay();
		$('#sw_pop_files_detail').hide();		
	},

	showFilesDetail : function(input, top, left){
		var filesDetail = input.attr("filesDetail");
		var popFilesDetail = $('#sw_pop_files_detail');
		if(!isEmpty(popFilesDetail)){
			popFilesDetail.show();
		}else{
			$('<div id="sw_pop_files_detail" style="z-index:10001; position:absolute; left:' + left + 'px; top:' + top + 'px;">' +
					'<div class="pop_corner_all pop_contents js_files_detail">' + filesDetail +
					'</div>' +
			'</div>').appendTo($(document.body));
		}
		popFilesDetail.find('.js_files_detail').html(filesDetail);
		popFilesDetail.css({"top": top + "px", "left": left + "px"});

	},
	
	closeInfo : function(){
		smartPop.closeOverlay();
		$('#sw_pop_show_info').remove();		
	},

	showInfo : function(infoType, message, onClose){
		if(infoType !== smartPop.INFO && infoType !== smartPop.WARN && infoType !== smartPop.ERROR) infoType = smartPop.INFO;
		smartPop.overlayDark();
		$('<div id="sw_pop_show_info" style="z-index:10001; position:absolute;" class="pop_corner_all smart_pop_section">' + 
					'<div class="pop_contents">' + 
						'<div class="icon_pop_' + infoType + '">' + smartMessage.get('popType'+infoType) + '</div>' +
					 	'<div class="pop_notice_section">' + message + '</div>' +
					 '</div>' +
					 '<div class="glo_btn_space">' +
					 	'<div class="fr">' +
					 		'<span class="btn_gray"> <a class="js_btn_close" href=""> <span class="txt_btn_start"></span>' +
					 			'<span class="txt_btn_center">' + smartMessage.get('buttonClose') + '</span> <span class="txt_btn_end"></span>' +
					 		'</a> </span>' +
					 	'</div>' +
					 '</div>' +
				  '</div>').appendTo($(document.body)).center();
		$('#sw_pop_show_info .js_btn_close').die('click');
		$('#sw_pop_show_info .js_btn_close').live('click', function(){
			if ($.isFunction(onClose)) {
				onClose.apply();
			}
			smartPop.closeInfo();
			return false;
		});
	},
	
	closeConfirm : function(){
		smartPop.closeOverlay();
		$('#sw_pop_confirm').remove();
	},
	
	confirm : function(message, onOk, onCancel){
		smartPop.overlayDark();
		$('<div id="sw_pop_confirm" class="pop_corner_all smart_pop_section" style="z-index:10001; position:absolute;">' + 
					'<div class="pop_contents">' + 
					 	'<div class="pop_notice_section mt10">' + message + '</div>' +
					 '</div>' +
					 '<div class="glo_btn_space">' +
					 	'<div class="fr">' +
					 		'<span class="btn_gray"> <a class="js_btn_ok" href=""> <span class="txt_btn_start"></span>' +
					 			'<span class="txt_btn_center">' + smartMessage.get('buttonConfirm') + '</span> <span class="txt_btn_end"></span>' +
					 		'</a> </span>' + 
				 			'<span class="btn_gray ml5"> <a class="js_btn_cancel" href=""> <span class="txt_btn_start"></span>' +
				 				'<span class="txt_btn_center">'  + smartMessage.get('buttonCancel') + '</span> <span class="txt_btn_end"></span>' +
				 			'</a> </span>' +
				 		'</div>' +
					 '</div>' +
				  '</div>').appendTo($(document.body)).center(); 

		$('#sw_pop_confirm .js_btn_ok').die('click');
		$('#sw_pop_confirm .js_btn_cancel').die('click');
		$('#sw_pop_confirm .js_btn_ok').live('click', function(){
			if ($.isFunction(onOk)) {
				onOk.apply();
			}
			smartPop.closeConfirm();
			return false;
		});
		
		$('#sw_pop_confirm .js_btn_cancel').live('click', function(){
			if ($.isFunction(onCancel)) {
				onCancel.apply();
			}
			smartPop.closeConfirm();
			return false;
		});
	},

	progressTarget : "",
	progressCenter : function(){
		$('<img class="js_progress_icon" src="images/load_wh.gif"/>').appendTo($(document));
		smartPop.overlay();
	},
	
	progressCont : function(target){
		smartPop.progressTarget= target;
		$('<img class="js_progress_icon" src="images/load_wh.gif"/>').appendTo(target);
		smartPop.overlay();
	},
	progressContGray : function(target){
		smartPop.progressTarget= target;
		$('<img class="js_progress_icon" src="images/load_wh_02.gif" align="bottom"/>').appendTo(target);
		smartPop.overlay();
	},
	progressNav : function(target){
		smartPop.progressTarget= target;
		$('<img class="js_progress_icon" src="images/load_gr.gif" align="bottom"/>').appendTo(target);
		smartPop.overlay();
	},
	progressNavGray : function(target){
		smartPop.progressTarget= target;
		$('<img class="js_progress_icon" src="images/load_gr_02.gif" align="bottom"/>').appendTo(target);
		smartPop.overlay();
	},

	closeProgress : function(){
		smartPop.closeOverlay();
		if(!isEmpty(smartPop.progressTarget))
			smartPop.progressTarget.find('.js_progress_icon').remove();
	},
	
	close : function(){
		$.modal.close();
	},
	
	selectUser : function(communityItems, target, width, isMultiUsers){
		target.html('');
		var conWidth = (!isEmpty(width) && width>0) ? width : 360;
		$.get("pop_select_user.sw?multiUsers="+isMultiUsers, function(data){
			$(data).modal({
				appendTo: target,
				opacity: 0,
				autoPosition: false,
				fixed: false,
				overlayCss: {backgroundColor:"#000"},
				containerCss:{
					width: conWidth
				},
				overlayClose: true,
				onShow: function(dialog){

					var selectionProc = function(comId, comName){
						var userField = target.parents('.js_type_userField:first');
						var inputTarget = userField.find('input.js_auto_complete:first');
						if(inputTarget.parents('.sw_required').hasClass('sw_error')){
							inputTarget.parents('.sw_required').removeClass('sw_error');
							$('form.js_validation_required').validate({ showErrors: showErrors}).form();
						}

						if (isEmpty(communityItems) || (!isEmpty(userField) && userField.attr('multiUsers') !== 'true'))
							communityItems.remove();
						var isSameId = false;
						for(var i=0; i<communityItems.length; i++){
							var oldComId = $(communityItems[i]).attr('comId');
							if(oldComId !=null && oldComId === comId){
								isSameId = true;
								break;
							}
						}
						if(!isSameId){
							$("<span class='js_community_item user_select' comId='" + comId+ "'>" + comName
									+ "<a class='js_remove_community' href=''>&nbsp;x</a></span>").insertBefore(inputTarget);
						}
						inputTarget.focus();
						userField.find('.js_community_names').change();
					};
					
					$('a.js_pop_select_user').die('click');
					$('a.js_pop_select_users').die('click');
					if(isEmpty(isMultiUsers) || isMultiUsers!== 'true'){
						$('a.js_pop_select_user').live('click', function(e){
							var input = $(e.target);
							var comId = input.attr('userId');
							var comName = input.text();
							selectionProc(comId, comName);
							smartPop.close();
							target.html('');
							return false;
						});
					}else{
						$('a.js_pop_select_users').live('click', function(e){
							var selections = $('form[name="frmUserSelections"]').find('input.js_checkbox:checked');
							if(isEmpty(selections)) return false;
							
							for(var i=0; i<selections.length; i++){
								var selection = $(selections[i]);
								var comId = selection.attr('value');
								var comName = selection.attr("comName");
								selectionProc(comId, comName);
							}
							smartPop.close();
							target.html('');
							return false;
						});
					}
				}
			});
		});
	},

	selectWork : function(target, width){
		target.html('');
		var conWidth = (!isEmpty(width) && width>0) ? width : 360;
		$.get("pop_select_work.sw", function(data){
			$(data).modal({
				appendTo: target,
				opacity: 0,
				autoPosition: false,
				fixed: false,
				overlayCss: {backgroundColor:"#000"},
				containerCss:{
					width:conWidth
				},
				overlayClose: true,
				onShow: function(dialog){
					$('.js_pop_select_work').die('click');
					$('.js_pop_select_work').live( 'click', function(e){
						var input = $(e.target).parents('li:first').find('a');
						$('#form_works').html('').hide();
						$('#upload_work_list').hide().parents(".js_start_work_page").hide();
						var href = input.attr('href');
						smartPop.progressCenter();
						$.get(href,  function(data){
							$('#form_works').html(data);
							var formContent = $('#form_works').find('div.js_form_content');
							var workId = input.attr('workId');
							new SmartWorks.GridLayout({
								target : formContent,
								mode : "edit",
								requiredOnly : 'true',
								workId : workId,
								onSuccess : function(){
									$('#form_works').show().parent().show();
									smartPop.close();
									target.html('');
									smartPop.closeProgress();
								},
								onError : function(){
									smartPop.close();
									target.html('');											
									smartPop.closeProgress();
								}
							});
						});
						return false;
					});
				}
			});
		});
	},

	selectWorkItem : function(formId, target){
		console.log('formId=', formId, ', target=', target);
		if(isEmpty(formId) || isEmpty(target)) return;
		$.get("pop_select_work_item.sw", {formId: formId}, function(data){
			$(data).modal({
				opacity: 50,
				overlayCss: {backgroundColor:"#000"},
				containerCss:{
					height:500,
					width:800
				},
				overlayClose: false,
				onShow: function(dialog){
					$('.js_pop_select_work_item').die('click');
					$('.js_pop_select_work_item').live( 'click', function(e){
						var input = $(e.target);
						var recordId = input.attr('instId');
						var fieldId = target.attr('refFormField');
						var keyField = input.parents('tbody').find('tr.js_instance_list_header').find('th[fieldId="'+fieldId+'"]');
						var keyPos = keyField.prevAll('th').length;
						var value = $(input.parents('tr').find('td')[keyPos]).find('a').text();
						target.attr('refRecordId', recordId);
						var inputTarget = target.find('input');
						inputTarget[0].value = value;
						if(inputTarget.hasClass('sw_required') && inputTarget.hasClass('sw_error')){
							inputTarget.removeClass('sw_error');
							$('form.js_validation_required').validate({ showErrors: showErrors}).form();
						}
						target.change();
						smartPop.close();
						return false;
					});
				}
			});
		});
	},
	
	createGroup : function(){
		$.get("pop_new_group.sw", function(data){
			$(data).modal({
				opacity: 50,
				overlayCss: {backgroundColor:"#000"},
				containerCss:{
					height:500,
					width:600
				},
				overlayClose: false,
				onShow: function(dialog){
					loadGroupProfileField();
					loadNewGroupFields();
					$('.js_close_new_group').die('click');
					$('.js_close_new_group').live( 'click', function(e){
						smartPop.close();
						return false;
					});
				}
			});
		});
	},

	createWorkCategory : function(categoryId, categoryName, categoryDesc){
		$.get("pop_new_category.sw?categoryId="+ categoryId + "&categoryName=" + categoryName + "&categoryDesc=" + categoryDesc, function(data){
			$(data).modal({
				opacity: 10,
				overlayCss: {backgroundColor:"#000"},
				containerCss:{
					height:200,
					width:460
				},
				overlayClose: false,
				onShow: function(dialog){
					$('.js_close_new_category').die('click');
					$('.js_close_new_category').live( 'click', function(e){
						smartPop.close();
						return false;
					});
				}
			});
		});
	},

	createWorkDefinition : function(parentId, parentName, workId, workName, workTypeName, workDesc, categoryId, groupId){
		var url = "pop_new_work_definition.sw?parentId="+parentId+"&parentName="+parentName + "&workId=" + workId 
						+ "&workName=" + workName + "&workTypeName=" + workTypeName + "&workDesc=" + workDesc + "&categoryId=" + categoryId + "&groupId=" + groupId;
		$.get( url, function(data){
			$(data).modal({
				opacity: 10,
				overlayCss: {backgroundColor:"#000"},
				containerCss:{
					height:300,
					width:560
				},
				overlayClose: false,
				onShow: function(dialog){
					$('.js_close_new_work').die('click');
					$('.js_close_new_work').live( 'click', function(e){
						smartPop.close();
						return false;
					});
				}
			});
		});
	},

	downloadFromAppstore : function(formId, target){
		if(isEmpty(formId) || isEmpty(target)) return;
		$.get("pop_download_from_appstore.sw", {formId: formId}, function(data){
			$(data).modal({
				opacity: 50,
				overlayCss: {backgroundColor:"#000"},
				containerCss:{
					height:500,
					width:800
				},
				overlayClose: false,
				onShow: function(dialog){
					$('.js_pop_select_work_item').die('click');
					$('.js_pop_select_work_item').live( 'click', function(e){
						var input = $(e.target);
						var recordId = input.attr('instId');
						var fieldId = target.attr('refFormField');
						var keyField = input.parents('tbody').find('tr.js_instance_list_header').find('th[fieldId="'+fieldId+'"]');
						var keyPos = keyField.prevAll('th').length;
						var value = $(input.parents('tr').find('td')[keyPos]).find('a').text();
						target.attr('refRecordId', recordId);
						var inputTarget = target.find('input');
						inputTarget[0].value = value;
						if(inputTarget.hasClass('sw_required') && inputTarget.hasClass('sw_error')){
							inputTarget.removeClass('sw_error');
							$('form.js_validation_required').validate({ showErrors: showErrors}).form();
						}
						smartPop.close();
						return false;
					});
				}
			});
		});
	},

	createEvent : function(startDate){
		$.get("pop_new_event.sw", function(data){
			$(data).modal({
				opacity: 50,
				overlayCss: {backgroundColor:"#000"},
				containerCss:{
					height:300,
					width:800
				},
				overlayClose: false,
				onShow: function(dialog){
					loadNewEventFields(startDate);
				}
			});
		});
	}	
	
};
