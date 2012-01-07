$(function() {
	$('select.js_select_filter_operand').live('change', function(e) {
		var input = $(e.target);
		var pageName = input.children('option:selected').attr('page');
		var url = pageName + ".sw";
		var target = input.next('span.js_filter_operator');
		$.ajax({
			url : url,
			data : {},
			success : function(data, status, jqXHR) {
				target.html(data).show();
			}
		});
		return false;
	});

	$('select.js_select_filter_operator').live('change', function(e) {
		var input = $(e.target);
		var target = input.children('option:selected').attr('type');
		input.siblings('span.' + target).show().siblings('span.js_right_operand').hide();
		return false;
	});
	
	$('a.js_edit_search_filter').live('click', function(e) {
		var input = $(e.target).parent();
		smartPop.progressContGray(input.next('span:first'));
		var target = $('#search_filter');
		var url = input.attr('href') + "&filterId=" + $('form[name="frmIworkFilterName"]').children('select').attr('value');
		$.ajax({
			url : url,
			data : {},
			success : function(data, status, jqXHR) {
				target.html(data);
				target.slideDown(500);
				input.hide();
				smartPop.closeProgress();
			},
			error : function(){
				smartPop.closeProgress();						
			}
		});
		return false;
	});

	
	$('a.js_select_paging').live("click", function(e){
		var input = $(e.target).parents('a.js_select_paging');
		input.find('input').attr('value', 'true');
		var progressSpan = input.siblings('span.js_progress_span:first');
		selectListParam(progressSpan, false);
		return false;
	});
	
	$('a.js_select_current_page').live("click", function(e){
		var input = $(e.target);
		var progressSpan = input.siblings('span.js_progress_span:first');
		input.siblings('input[name="hdnCurrentPage"]').attr('value', input.text());
		selectListParam(progressSpan, false);
		return false;
	});
	
	$('.js_select_page_size').live("change", function(e){
		var input = $(e.target);
		var progressSpan = input.siblings('span.js_progress_span:first');
		selectListParam(progressSpan, false);
		return false;
	});
	
	$('a.js_select_field_sorting').live('click', function(e){
		var input = $(e.target);
		var sortingField = $('form[name="frmSortingField"]').find('input[name="hdnSortingFieldId"]');
		var sortingIsAscending = $('form[name="frmSortingField"]').find('input[name="hdnSortingIsAscending"]');
		if(sortingField.attr('value') === input.attr('fieldId')){
			var isAscending = sortingIsAscending.attr('value');
			sortingIsAscending.attr('value', (isAscending === "true") ? "false" : "true");
		}else{
			sortingField.attr('value', input.attr('fieldId'));
			sortingIsAscending.attr('value', 'false');
		}
		var progressSpan = input.siblings('.js_progress_span:first');
		selectListParam(progressSpan, false);
		return false;
	});

	$('.js_select_search_filter').live('change', function(e){
		$('#search_filter').slideUp(500).html('');
		$('a.js_edit_search_filter').show();
		var progressSpan = $('.js_edit_search_filter').next('span.js_progress_span:first');
		selectListParam(progressSpan, true);
		return false;		
	});
	
	$('a.js_search_filter_close').live('click', function(e) {
		$('#search_filter').slideUp(500).html('');
		$('a.js_edit_search_filter').show();
		return false;
	});

	$('a.js_search_filter_execute').live("click", function(e){
		if (!SmartWorks.GridLayout.validate($('form.js_validation_required'))) return false;
		var progressSpan = $('.js_search_filter').find('span.js_progress_span:first');
		selectListParam(progressSpan, false);
		return false;
	});	

	$('a.js_search_filter_save').live("click", function(e){
		saveSearchFilter();
		return false;
	});	

	$('a.js_search_filter_saveas').live("click", function(e){
		saveAsSearchFilter();
		return false;
	});	

});
