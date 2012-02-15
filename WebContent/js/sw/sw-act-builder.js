$(function() {
	
	$('a.js_start_work_service').live('click', function(e) {
		var input = $(e.target);
		var target = $('#content');
		var workId = input.parents('.js_tab_workbench_page').attr('workId');
		$.ajax({
			url : "start_work_service.sw?workId=" + workId,
			success : function(data, status, jqXHR) {
				target.html(data);
			}			
		});
		return false;
	});

	$('a.js_stop_work_service').live('click', function(e) {
		var input = $(e.target);
		var target = $('#content');
		var workId = input.parents('.js_tab_workbench_page').attr('workId');
		$.ajax({
			url : "stop_work_service.sw?workId=" + workId,
			success : function(data, status, jqXHR) {
				target.html(data);
			}			
		});
		return false;
	});

	$('a.js_start_work_editing').live('click', function(e) {
		var input = $(e.target);
		var target = $('#content');
		var workId = input.parents('.js_tab_workbench_page').attr('workId');
		$.ajax({
			url : "start_work_editing.sw?workId=" + workId,
			success : function(data, status, jqXHR) {
				target.html(data);
			}			
		});
		return false;
	});

	$('a.js_stop_work_editing').live('click', function(e) {
		var input = $(e.target);
		var target = $('#content');
		var workId = input.parents('.js_tab_workbench_page').attr('workId');
		$.ajax({
			url : "stop_work_editing.sw?workId=" + workId,
			success : function(data, status, jqXHR) {
				target.html(data);
			}			
		});
		return false;
	});
	
	$('a.js_tab_smart_builder').live('click', function(e) {
		var input = $(e.target);
		var target = $('#content');
		var url = input.attr('href');
		$.ajax({
			url : url,
			success : function(data, status, jqXHR) {
				target.html(data);
			}			
		});
		return false;
	});
	
});
