$(function() {
	
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
		var lastDate = input.attr('lastDate');
		var target = input.parents('ul');
		var url = input.find(':selected').attr('value');
		var spaceDayly = input.parents('.js_space_dayly_space');
		var spaceWeekly = input.parents('.js_space_weekly_space');
		var spaceMonthly = input.parents('.js_space_monthly_space');
		var spaceInstanceList = input.parents('.js_space_instance_list_page');
		var url = "";
		if(!isEmpty(spaceDayly)) url = ""
		$.ajax({
			url : url,
			data : {},
			success : function(data, status, jqXHR) {
				input.parents('li').remove();
				target.append(data);
			},
			error : function(xhr, ajaxOptions, thrownError){
			}
		});
		return false;
	});
	
});
