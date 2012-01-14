$('.js_more_list').live('click', function(e) {
	var anchor = $(e.target);
	var base_ul = anchor.parent().prev('ul');
	var runningPage = input.find('.js_my_running_instance_list_page');
	var lastDate = runningPage.find('.js_running_instance_item').attr('dateValue');
	var assignedOnly = runningPage.find('a.js_view_assigned_instances').hasClass('current');
	var instanceCount;
	if(assignedOnly)
		instanceCount = runningPage.find('a.js_view_assigned_instances').attr('instanceCount');
	else
		instanceCount = runningPage.find('a.js_view_my_running_instances').attr('instanceCount');
	if(instanceCount > runningPage.length)
		runningPage.find('.js_more_list').show();
	else
		runningPage.find('.js_more_list').hide();
	$.ajax({
		url : anchor.attr('href'),
		data : {
			lastDate : lastDate,
			assignedOnly : assignedOnly
		},
		success : function(data, status, jqXHR) {
			$(data).appendTo(base_ul);
		},
		error : function(xhr, ajaxOptions, thrownError){
			
		}
	});

	return false;
});

$(window).scroll(
		function() {
			var more_anchor = $('#work_ing .js_more_list a');
			if ($(window).scrollTop() == $(document).height()
					- $(window).height()
					&& (!isEmpty(more_anchor) && !more_anchor.isWaiting)) {
				more_anchor.isWaiting = true;
				setTimeout(function() {
					if ($(window).scrollTop() == $(document).height()
							- $(window).height())
						more_anchor.trigger('click');
					more_anchor.isWaiting = false;
				}, 2000);
			}
		});
