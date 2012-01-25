
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
		$('<span id="sw_overlay_span" style="position:absolute; top:0; left:0; background-color:#000000; width:' + scrollWidth() + 'px; height:' + scrollHeight() + 'px; z-index:10000; display:block; opacity:0.2"></span>').appendTo($(target));
	},
	
	overlayDark : function(target){
		if(isEmpty($(target))) target = $(document.body);
		$('<span id="sw_overlay_span" style="position:absolute; top:0; left:0; background-color:#000000; width:' + scrollWidth() + 'px; height:' + scrollHeight() + 'px; z-index:10000; display:block; opacity:0.5"></span>').appendTo($(target));
	},
	
	closeOverlay : function(){
		$("#sw_overlay_span").remove();
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
						'<div class="ico_pop_' + infoType + '">' + smartMessage.get('popType'+infoType) + '</div>' +
					 	'<div class="pop_notice_section">' + message + '</div>' +
					 '</div>' +
					 '<div class="glo_btn_space">' +
					 	'<div class="float_right">' +
					 		'<span class="btn_gray"> <a class="js_btn_close" href=""> <span class="Btn01Start"></span>' +
					 			'<span class="Btn01Center">' + smartMessage.get('buttonClose') + '</span> <span class="Btn01End"></span>' +
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
					 	'<div class="pop_notice_section margin_t10">' + message + '</div>' +
					 '</div>' +
					 '<div class="glo_btn_space">' +
					 	'<div class="float_right">' +
					 		'<span class="btn_gray"> <a class="js_btn_ok" href=""> <span class="Btn01Start"></span>' +
					 			'<span class="Btn01Center">' + smartMessage.get('buttonConfirm') + '</span> <span class="Btn01End"></span>' +
					 		'</a> </span>' + 
				 			'<span class="btn_gray space_l5"> <a class="js_btn_cancel" href=""> <span class="Btn01Start"></span>' +
				 				'<span class="Btn01Center">'  + smartMessage.get('buttonCancel') + '</span> <span class="Btn01End"></span>' +
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
	
	selectUser : function(userInput, target, width, isMultiUsers){
		if(isEmpty(userInput)) return;
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
						var userField = userInput.parents('.js_type_userField:first');
						var inputTarget = userField.find('input.js_auto_complete:first');
						if(inputTarget.parents('.sw_required').hasClass('sw_error')){
							inputTarget.parents('.sw_required').removeClass('sw_error');
							$('form.js_validation_required').validate({ showErrors: showErrors}).form();
						}

						var oldHTML = userInput.html();
						if (oldHTML == null  || (userField.attr('multiUsers') !== 'true'))
							oldHTML = "";
						var communityItems = $(userInput).find('span.js_community_item:first');
						var isSameId = false;
						for(var i=0; i<communityItems.length; i++){
							var oldComId = $(communityItems[i]).attr('comId');
							if(oldComId !=null && oldComId === comId){
								isSameId = true;
								break;
							}
						}
						if(!isSameId){
							var newHTML = oldHTML + "<span class='js_community_item user_select' comId='" + comId+ "'>"
								+ comName
								+ "<span class='btn_x_gr'><a class='js_remove_community' href=''> x</a></span></span>";
							userInput.html(newHTML);
						}
					};
					
					$('a.js_pop_select_user').die('click');
					$('a.js_pop_select_users').die('click');
					if(isEmpty(isMultiUsers) || isMultiUsers!== 'true'){
						$('a.js_pop_select_user').live('click', function(e){
							var input = $(e.target);
							var comId = input.attr('userId');
							var comName = input.text();
							selectionProc(comId, comName);
							$.modal.close();
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
							$.modal.close();
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
						$('#upload_work_list').hide().parents(".js_start_work").hide();
						var href = input.attr('href');
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
									$('#form_works').show();
									$.modal.close();
									target.html('');											
								},
								onError : function(){
									$.modal.close();
									target.html('');											
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
						$.modal.close();
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
					width:800
				},
				overlayClose: false,
				onShow: function(dialog){
					loadGroupProfileField();
					loadNewGroupFields();
					$('.js_close_new_group').die('click');
					$('.js_close_new_group').live( 'click', function(e){
						$.modal.close();
						return false;
					});
				}
			});
		});
	}
};
