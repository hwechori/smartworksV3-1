
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
		opacity: 20,
		overlayCss: {backgroundColor:"#fff"},
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

progressOptions = {
		opacity: 20,
		overlayCss: {backgroundColor:"#fff"},
		containerCss:{
			backgroundColor:"#fff",
			borderColor:"#000",
			color: "#000",
			height:200,
			padding:1,
			width:300
		},
		overlayClose: false
	};

var swInfoType = {
	INFO : 'Info',
	WARN : 'Warn',
	ERROR: 'Error'
};
popShowInfo = function(infoType, message){
	if(infoType !== swInfoType.INFO && infoType !== swInfoType.WARN && infoType !== swInfoType.ERROR) infoType = swInfoType.INFO;
	$.modal( '<div class="pop_corner_all pop_section_300">' + 
				'<div class="form_contents margin_t10">' + 
					'<div class="ico_pop_' + infoType + '">' + language.message('popType'+infoType) + '</div>' +
				 	'<div class="pop_notice_section">' + message + '</div>' +
				 '</div>' +
				 '<div class="glo_btn_space">' +
				 	'<div class="float_right">' +
				 		'<span class="btn_gray"> <a onclick="$.modal.close();return false;" href=""> <span class="Btn01Start"></span>' +
				 			'<span class="Btn01Center">' + language.message('buttonClose') + '</span> <span class="Btn01End"></span>' +
				 		'</a> </span>' +
				 	'</div>' +
				 '</div>' +
			  '</div>', showInfoOptions);
};

popConfirm = function(message, onOk, onCancel){
	$.modal( '<div class="pop_corner_all pop_section_300">' + 
				'<div class="form_contents margin_t10">' + 
				 	'<div class="pop_notice_section">' + message + '</div>' +
				 '</div>' +
				 '<div class="glo_btn_space">' +
				 	'<div class="float_right">' +
				 		'<span class="btn_gray"> <a class="js_btn_cancel" href=""> <span class="Btn01Start"></span>' +
				 			'<span class="Btn01Center">' + language.message('buttonCancel') + '</span> <span class="Btn01End"></span>' +
				 		'</a> </span>' +
				 	'</div>' +
				 	'<div class="float_right">' +
			 			'<span class="btn_gray"> <a class="js_btn_ok" href=""> <span class="Btn01Start"></span>' +
			 				'<span class="Btn01Center">' + language.message('buttonConfirm') + '</span> <span class="Btn01End"></span>' +
			 			'</a> </span>' +
			 		'</div>' +
				 '</div>' +
			  '</div>', 
			  {
				opacity: 20,
				overlayCss: {backgroundColor:"#fff"},
				containerCss:{
					backgroundColor:"#fff",
					borderColor:"#000",
					color: "#000",
					height:200,
					padding:1,
					width:500
				},
				overlayClose: false,
				onShow: function(dialog){
					$('.js_btn_ok', dialog.data[0]).live('click', function(){
						if ($.isFunction(onOk)) {
							onOk.apply();
						}
						$.modal.close();
						return false;
					});
					$('.js_btn_cancel', dialog.data[0]).live('click', function(){
						if ($.isFunction(onCancel)) {
							onCancel.apply();
						}
						$.modal.close();
						return false;
					});
				}
			});
};

popProgress = function(message){
	$.modal( '<div class="pop_corner_all pop_section_300">' + 
			'<div class="form_contents margin_t10">' + 
			 	'<div class="pop_notice_section">' + message + '</div>' +
			 '</div>' +
		  '</div>', progressOptions);
	
};

popSelectUser = function(target){
	if(isEmpty(target)) return;
	$.get("pop_select_user.sw", function(data){
		$(data).modal({
			opacity: 20,
			overlayCss: {backgroundColor:"#fff"},
			containerCss:{
				backgroundColor:"#fff",
				borderColor:"#000",
				color: '#000',
				height:500,
				padding:1,
				width:360
			},
			overlayClose: true,
			onOpen: function(dialog){
				onOpenEffect(dialog);
				// TO DO
			},
			onShow: function(dialog){
				$('a.js_pop_select_user').live('click', function(e){
					var input = $(e.target);
					var comId = input.attr('userId');
					var comName = input.text();

					var userField = target.parents('td.js_type_userField');
					var inputTarget = userField.find('input.js_auto_complete');
					if(inputTarget.parents('.sw_required').hasClass('sw_error')){
						inputTarget.parents('.sw_required').removeClass('sw_error');
						$('form.js_validation_required').validate({ showErrors: showErrors}).form();
					}

					var oldHTML = target.html();
					if (oldHTML == null  || (userField.attr('multiUsers') !== 'true'))
						oldHTML = "";
					var communityItems = $(target).find('span.js_community_item');
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
						target.html(newHTML);
					}
					
					$.modal.close();
					return false;
				});
			},
			onClose: function(dialog){
				// TO DO
				onCloseEffect(dialog);
			}
		});
	});
};

popSelectWork = function(target){
	$.get("pop_select_work.sw", function(data){
		$(data).modal({
			opacity: 20,
			overlayCss: {backgroundColor:"#fff"},
			containerCss:{
				backgroundColor:"#fff",
				borderColor:"#000",
				color: '#000',
				height:500,
				padding:1,
				width:360
			},
			overlayClose: true,
			onOpen: function(dialog){
				onOpenEffect(dialog);
				// TO DO
			},
			onShow: function(dialog){
				$('.js_pop_select_work').live( 'click', function(e){
					var input = $(e.target).parents('li:first').children('a');
					$('#form_works').slideUp().slideDown(500);
					$('#upload_work_list').hide().parents(".js_start_work").slideUp();
					if(isEmpty(target)){
						var href = input.attr('href');
						$.get(href,  function(data){
							$('#form_works').html(data);
							var formContent = $('#form_works').find('div.js_form_content');
							var workId = input.attr('workId');
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
								}
							});			
						});
					}else{
					
					}
					$.modal.close();
					return false;
				});
			},
			onClose: function(dialog){
				// TO DO
				onCloseEffect(dialog);
			}
		});
	});
};

popSelectWorkItem = function(formId, target){
	if(isEmpty(formId) || isEmpty(target)) return;
	$.get("pop_select_work_item.sw", {formId: formId}, function(data){
		$(data).modal({
			opacity: 20,
			overlayCss: {backgroundColor:"#fff"},
			containerCss:{
				backgroundColor:"#fff",
				borderColor:"#000",
				color: "#000",
				height:600,
				padding:1,
				width:800
			},
			overlayClose: true,
			onOpen: function(dialog){
				onOpenEffect(dialog);
				// TO DO
			},
			onShow: function(dialog){
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
			},
			onClose: function(dialog){
				// TO DO
				onCloseEffect(dialog);
			}
		});
	});
};

