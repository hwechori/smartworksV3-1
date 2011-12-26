
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

selectWorkItemOptions = {
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
		},
		onClose: function(dialog){
			// TO DO
			onCloseEffect(dialog);
		}
	};

selectWorkOptions = {
		opacity: 20,
		overlayCss: {backgroundColor:"#fff"},
		containerCss:{
			backgroundColor:"#fff",
			borderColor:"#000",
			color: "#000",
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
		},
		onClose: function(dialog){
			// TO DO
			console.log(dialog);
			alert('wait');
			onCloseEffect(dialog);
		}
	};

selectUserOptions = {
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
		},
		onClose: function(dialog){
			// TO DO
			onCloseEffect(dialog);
		}
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
					$(dialog.data[0]).find('.js_btn_ok').live('click', function(){
						if ($.isFunction(onOk)) {
							onOk.apply();
						}
						$.modal.close();
						return false;
					});
					$(dialog.data[0]).find('.js_btn_cancel').live('click', function(){
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
