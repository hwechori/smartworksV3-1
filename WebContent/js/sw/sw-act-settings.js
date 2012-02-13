$(function() {
	
	$('a.js_new_work_hour').live('click', function(e) {
		var input = $(e.target);
		var target = input.parents('.js_company_work_hour_page').find('div.js_new_work_hour');
		$.ajax({
			url : "edit_work_hour.sw",
			success : function(data, status, jqXHR) {
				target.html(data).slideDown(500);
			}			
		});
		return false;
	});

	$('.js_edit_work_hour').live('click', function(e) {
		var input = $(e.target);
		var target = input.parents('.js_company_work_hour_page').find('div.js_new_work_hour');
		var policyId = input.parents('.js_edit_work_hour').attr('policyId');
		$.ajax({
			url : "edit_work_hour.sw?policyId=" + policyId,
			success : function(data, status, jqXHR) {
				target.html(data).slideDown(500);
			}			
		});
		return false;
	});

	$('.js_delete_work_hour').live('click', function(e) {
		var input = $(e.target);
		
		smartPop.confirm(smartMessage.get("removeConfirmation"), function(){
			var policyId = input.parents('.js_edit_work_hour').attr('policyId');
			var paramsJson = {};
			paramsJson['policyId'] = policyId;
			console.log(JSON.stringify(paramsJson));
			$.ajax({
				url : "remove_work_hour_policy.sw",
				contentType : 'application/json',
				type : 'POST',
				data : JSON.stringify(paramsJson),
				success : function(data, status, jqXHR) {
					smartPop.showInfo(smartPop.INFORM, smartMessage.get('removeWorkHourSucceed'), function(){
						document.location.href = "company_work_hour.sw";					
					});					
				},
				error : function(e) {
					// 서비스 에러시에는 메시지를 보여주고 현재페이지에 그래도 있는다...
					smartPop.showInfo(smartPop.ERROR, smartMessage.get("removeWorkHourError"), function(){
					});
					
				}
				
			});
		});
		return false;
	});

	$('select.js_first_day_of_week').live('change', function(e) {
		var input = $(e.target);
		var editWorkHour = input.parents('.js_edit_work_hour_page');
		var firstDay = parseInt(input.attr('value'));
		var workingDays = parseInt(editWorkHour.find('.js_working_days').attr('value'));
		var workHours = editWorkHour.find('.js_work_hour');
		for(var i=0; i<workHours.length; i++){
			var workHour = $(workHours[i]);
			if(i+1<firstDay || i+1>firstDay+workingDays-1){
				workHour.find('.workStart').attr('value', '00:00');
				workHour.find('.workEnd').attr('value', '00:00');
				workHour.hide();
			}else{
				if(workHour.find('.workStart').attr('value') === "00:00") workHour.find('.workStart').attr('value', '09:00');
				if(workHour.find('.workEnd').attr('value') === "00:00") workHour.find('.workEnd').attr('value', '18:00');
				workHour.show();
			}
		}
		
		return false;
	});

	$('select.js_working_days').live('change', function(e) {
		var input = $(e.target);
		var editWorkHour = input.parents('.js_edit_work_hour_page');
		var workingDays = parseInt(input.attr('value'));
		var firstDay = parseInt(editWorkHour.find('.js_first_day_of_week').attr('value'));
		var workHours = editWorkHour.find('.js_work_hour');
		for(var i=0; i<workHours.length; i++){
			var workHour = $(workHours[i]);
			if(i+1<firstDay || i+1>firstDay+workingDays-1){
				workHour.find('.workStart').attr('value', '00:00');
				workHour.find('.workEnd').attr('value', '00:00');
				workHour.hide();
			}else{
				if(workHour.find('.workStart').attr('value') === "00:00") workHour.find('.workStart').attr('value', '09:00');
				if(workHour.find('.workEnd').attr('value') === "00:00") workHour.find('.workEnd').attr('value', '18:00');
				workHour.show();
			}
		}
		
		return false;
	});
});
