$(function() {
	/*
	 * 검색 입력창에서 사용하는 것으로, 값을 입력하고 500ms이상 정지하고 있으면 입렵박스의 href값으로 ajax를 호출하여, 가져온
	 * 값을, js_start_work class(새업무시작하기에서 업무검색하는 입력창)는 id가 upload_work_list인 곳에
	 * 보여주고, 그렇지 않으면 내부모와 같은 수준에 있는 div 영역에 보여준다.
	 */
	var requestedValue = "";
	var timeoutId = null;
	$('input.js_auto_complete').live('keyup', function(e) {
		if(e.keyCode>=9 && e.keyCode<=45) return;
		var input = $(e.target);
		var listWidth = input.parent().outerWidth();
		var startWork = input.parents('div.js_start_work_page');
		var chatter_name = input.parents('div.js_chatter_names');
		var communityId = input.parents('ul.js_community_members').attr('communityId');
		var target;
		if (!isEmpty(startWork)){
			target = startWork.find('#upload_work_list');
			listWidth = input.parent().outerWidth();
		}else if(!isEmpty(chatter_name)){
			target = chatter_name.siblings('div.js_chatter_list');
		}else{
			target = input.parent().next('div');
		}
		var url = input.attr('href');
		var lastValue = input[0].value;
		if(timeoutId != null) clearTimeout(timeoutId);
		timeoutId = setTimeout(function() {
			timeoutId = null;
			var currentValue = input[0].value;
			if (lastValue === currentValue && currentValue !== requestedValue) {
				requestedValue = currentValue;
				$.ajax({
					url : url,
					data : {
						key : input[0].value,
						communityId : communityId
					},
					context : input,
					success : function(data, status, jqXHR) {
						target.html(data).width(listWidth);
						target.show();
					},
					error : function(xhr, ajaxOptions, thrownError){
					}
				});
			} else {
			}
		}, 500);
	});

	/*
	 * 검색 입력창에서 검색을 하고나서, 포커스가 다른곳으로 이동을 하면, 500ms후에 검색결과 창을 숨긴다.
	 */
	$('input.js_auto_complete').live('focusout', function(e) {
		var input = $(e.target);
		input[0].value = '';
		requestedValue = "";
		var startWork = input.parents('div.js_start_work_page');
		var user_name = input.parents('div.js_community_names');
		var chatter_name = input.parents('div.js_chatter_names');
		var target;
		if (!isEmpty(startWork))
			target = startWork.find('#upload_work_list');
		else if (!isEmpty(user_name))
			target = user_name.next('div');
		else if(!isEmpty(chatter_name))
			target = chatter_name.nextAll('div.js_chatter_list');
		else
			target = input.parent().nextAll('div');
		setTimeout(function() {
			var searchButton = input.next('div');
			if(searchButton.hasClass('js_icon_white'))
				searchButton.addClass('srch_icon_w');
			target.html('').hide();
		}, 500);
	});
	
	$('input.js_auto_complete').live('keydown', function(e) {
		if(e.which == $.ui.keyCode.UP || e.which == $.ui.keyCode.DOWN  ){
			var input = $(e.target);
			var startWork = input.parents('div.js_start_work_page');
			var chatter_name = input.parents('div.js_chatter_names');

			var target = input.parent().next('div');
			if(!isEmpty(startWork)) target =  startWork.find('#upload_work_list');
			else if(!isEmpty(chatter_name)) target = chatter_name.siblings('div.js_chatter_list');

			var list = target.find('li');
			if(isEmpty(list)) return;
			var sw_hover = target.find('.sw_hover');
			if(e.which == $.ui.keyCode.DOWN){
				if(isEmpty(sw_hover) || isEmpty(sw_hover.next()))
					$(list[0]).addClass('sw_hover').siblings().removeClass('sw_hover');					
				else
					sw_hover.next().first().addClass('sw_hover').siblings().removeClass('sw_hover');
				
			}else if(e.which == $.ui.keyCode.UP){
				if(isEmpty(sw_hover) || isEmpty(sw_hover.prev()))
					$(list[list.length-1]).addClass('sw_hover').siblings().removeClass('sw_hover');					
				else
					sw_hover.prev().first().addClass('sw_hover').siblings().removeClass('sw_hover');					
			}
		}else if(e.which == $.ui.keyCode.ENTER){
			var input = $(e.target);
			var startWork = input.parents('div.js_start_work_page');
			var chatter_name = input.parents('div.js_chatter_names');

			var target = input.parent().next('div');
			if(!isEmpty(startWork)) target =  startWork.find('#upload_work_list');
			else if(!isEmpty(chatter_name)) target = chatter_name.siblings('div.js_chatter_list');
			target.find('.sw_hover:first a').click();
			input.focusout();
		}
	});
	
	$('.nav_srch_list').find('li').live('hover', function(e){
		$(e.target).parents('li:first').addClass('sw_hover').siblings().removeClass('sw_hover');
	});
	
	$('#upload_work_list').find('li').live('hover', function(e){
		$(e.target).parents('li:first').addClass('sw_hover').siblings().removeClass('sw_hover');
	});
	
	$('div.js_chatter_list').find('li').live('hover', function(e){
		$(e.target).parents('li:first').addClass('sw_hover').siblings().removeClass('sw_hover');
	});

	$('div.js_srch_x').live('click', function(e) {
		var input = $(e.target).prev();
		input.value = "";
		input.next('div').removeClass('btn_x').addClass('srch_icon');
		return false;
	});

	$('.js_select_community').live( 'click', function(e) {
		var input = $(e.target);
		if(!input.hasClass('js_select_community')) input.parents('.js_select_community:first');
		var comName = input.attr('comName');
		var comId = input.attr('comId');
		var communityItems = input.parents('.js_community_list').prev().find('.js_community_item');				
		var userField = input.parents('.js_type_userField');
		var inputTarget = userField.find('input.js_auto_complete');
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
		return false;
	});

	$('.js_remove_community').live('click', function(e) {
		var input = $(e.target);
		
		var userField = input.parents('.js_type_userField');
		if(!isEmpty(userField) && userField.attr('multiUsers') !== 'true') {
			var inputTarget = userField.find('input.js_auto_complete');
			inputTarget.show();
			inputTarget.next('.js_srch_x').show();
		}
		var selected_users = input.parents('.js_selected_communities');
		input.parents('span.js_community_item').remove();
		selected_users.next().focus();
		return false;
	});
});
