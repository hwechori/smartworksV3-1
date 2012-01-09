$('.js_more_list').live('click', function(e) {
	var anchor = $(e.target);
	var base_ul = anchor.parent().prev('ul');
	$.ajax({
		url : anchor.attr('href'),
		data : {
		// last_id : null
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
