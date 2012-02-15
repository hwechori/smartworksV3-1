$(function() {
	
	var timeOffset = (new Date()).getTimezoneOffset()/60 + parseInt(currentUser.timeOffset);
	var today = new Date();
	today.setTime(today.getTime() + timeOffset*60*60*1000);
	function updateNowString(){
		var now = new Date();
		now.setTime(now.getTime() + timeOffset*60*60*1000);
		if(!(today.getFullYear() == now.getFullYear() && today.getMonth() == now.getMonth() && today.getDate() == now.getDate())){
			today = new Date();
			today.setTime(today.getTime() + timeOffset*60*60*1000);
			$.ajax({url : "localdate_string.sw", success : function(data, status, jqXHR) {
					$('.js_now_date_string').html(data);
				}
			});
		}	
		$('.js_now_time_string').html(now.format("TT h:MM:ss"));		
		setTimeout(function(){
			updateNowString();
		}, 1000);
	};
	updateNowString();

	$('a.js_space_tab_index').live('click',function(e) {
		var input = $(e.target).parents('a:first');
		if(isEmpty(input)) input = $(e.target);
		var target = input.parents('.js_space_instance_list');
		var url = input.attr('href');
		$.ajax({
			url : url,
			data : {},
			success : function(data, status, jqXHR) {
				target.html(data);
			},
			error : function(xhr, ajaxOptions, thrownError){
			}
		});
		return false;
	});

	$('a.js_space_datepicker_button').live('click', function(e) {
		var input = $(e.target);
		input.parents('.js_space_instance_list').find('.js_space_datepicker').datepicker("show");
		return false;
	});

	$('select.js_space_select_scope').live('change',function(e) {
		var input = $(e.target);
		var target = input.parents('.js_space_instance_list');
		var url = input.find(':selected').attr('value');
		$.ajax({
			url : url,
			data : {},
			success : function(data, status, jqXHR) {
				target.html(data);
			},
			error : function(xhr, ajaxOptions, thrownError){
			}
		});
		return false;
	});
	
	$('a.js_space_more_history').live('click',function(e) {
		var input = $(e.target);
		var fromDate = input.attr('lastDate');
		var target = input.parents('ul:first');
		var spaceDayly = input.parents('.js_space_dayly_page');
		var spaceWeekly = input.parents('.js_space_weekly_page');
		var spaceMonthly = input.parents('.js_space_monthly_page');
		var spaceInstanceList = input.parents('.js_space_instance_list_page');
		var smartcaster = input.parents('.js_smartcaster_page');
		var spacePage = [];
		var toDate = "";
		if(!isEmpty(spaceDayly)){
			spacePage = spaceDayly;
			toDate = input.parents('.js_space_dayly_work_hour').attr('toDate');
		}else if(!isEmpty(spaceWeekly)){
			spacePage = spaceWeekly;
			toDate = input.parents('.js_space_weekly_day').attr('toDate');
		}else if(!isEmpty(spaceMonthly)){
			spacePage = spaceMonthly;
			toDate = input.parents('.js_space_monthly_week').attr('toDate');
		}else if(!isEmpty(spaceInstanceList)){
			spacePage = spaceInstanceList;
		}else if(!isEmpty(smartcaster)){
			$.ajax({
				url : "more_smartcast.sw",
				data : {
					fromDate : fromDate,
					maxSize : 20
				},
				success : function(data, status, jqXHR) {
					input.parents('li:first').remove();
					target.append(data);
				},
				error : function(xhr, ajaxOptions, thrownError){
				}
			});
			return false;
		}
		
		var contextId = spacePage.attr('contextId');
		var spaceId = spacePage.attr('spaceId');		
		$.ajax({
			url : "more_space_task_histories.sw",
			data : {
				contextId : contextId,
				spaceId : spaceId,
				fromDate : fromDate,
				toDate : toDate,
				maxSize : 20
			},
			success : function(data, status, jqXHR) {
				input.parents('li:first').remove();
				target.append(data);
			},
			error : function(xhr, ajaxOptions, thrownError){
			}
		});
		return false;
	});
	
	$('a.js_view_instance_diagram').live('click',function(e) {
		var input = $(e.target);
		input.parent().hide().next().show();
		var pworkSpace = input.parents('.js_pwork_space_page');
		var target = pworkSpace.find('.js_process_instance_viewer');
		var instanceId = pworkSpace.attr('instId');
		loadInstanceViewer(target, {
				instanceId : instanceId
		});
		target.show();
		return false;
	});

	$('a.js_close_instance_diagram').live('click',function(e) {
		var input = $(e.target);
		input.parent().hide().prev().show();
		var pworkSpace = input.parents('.js_pwork_space_page');
		var target = pworkSpace.find('.js_process_instance_viewer');
		target.hide().html('');
		return false;
	});
	
	var userInfoTimer = null;
	$('a.js_pop_user_info').live('mouseenter', function(e){
		if(userInfoTimer!=null){
			clearTimeout(userInfoTimer);
			userInfoTimer = null;
		}
		var input = $(e.target).parent();
		var picture = input.find('img');
		var top = picture.offset().top+ picture.height();
		var scrollHeight = $(window).scrollTop() + window.innerHeight;
		var directionUp = true;
		var popUserInfo = $('#sw_pop_user_info');
		if((top+popUserInfo.height()) > scrollHeight){
			top = picture.offset().top;
			directionUp = false;
		}
		var left = picture.offset().left + picture.width()/2;
		smartPop.showUserInfo(input, top, left, directionUp);		
	});

	$('a.js_pop_user_info').live('mouseleave', function(e){
		userInfoTimer = setTimeout(function(){
			smartPop.closeUserInfo();
			userInfoTimer = null;
		}, 300);
	});
	
	$('#sw_pop_user_info').live('mouseenter', function(e){
		if(userInfoTimer!=null){
			clearTimeout(userInfoTimer);
			userInfoTimer = null;
		}		
	});

	$('#sw_pop_user_info').live('mouseleave', function(e){
		userInfoTimer = setTimeout(function(){
			smartPop.closeUserInfo();
			userInfoTimer = null;
		}, 300);
	});
});
