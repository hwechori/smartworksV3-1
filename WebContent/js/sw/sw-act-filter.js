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
			},
			error : function(xhr, ajaxOptions, thrownError){
				
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
		var input = $(e.target);
		smartPop.progressCont(input.next('span:first'));
		var target = $('#search_filter');
		var url = input.attr('href') + "&filterId=" + $('form.js_form_filter_name').children('select').attr('value');
		$.ajax({
			url : url,
			data : {},
			success : function(data, status, jqXHR) {
				target.html(data);
				target.slideDown(500);
				input.parent().hide();
				smartPop.closeProgress();
			},
			error : function(xhr, ajaxOptions, thrownError){
				smartPop.closeProgress();
			}
		});
		return false;
	});

	
	$('a.js_select_paging').live("click", function(e){
		$('#search_filter').slideUp(500).html('');
		var input = $(e.target).parents('a.js_select_paging');
		input.find('input').attr('value', 'true');
		var progressSpan = input.siblings('span.js_progress_span:first');
		selectListParam(progressSpan, false);
		return false;
	});
	
	$('a.js_select_current_page').live("click", function(e){
		var input = $(e.target);
		$('#search_filter').slideUp(500).html('');
		var progressSpan = input.siblings('span.js_progress_span:first');
		input.siblings('input[name="hdnCurrentPage"]').attr('value', input.text());
		selectListParam(progressSpan, false);
		return false;
	});
	
	$('.js_select_page_size').live("change", function(e){
		var input = $(e.target);
		$('#search_filter').slideUp(500).html('');
		var progressSpan = input.siblings('span.js_progress_span:first');
		selectListParam(progressSpan, false);
		return false;
	});
	
	$('a.js_select_field_sorting').live('click', function(e){
		var input = $(e.target);
		$('#search_filter').slideUp(500).html('');
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
		$('a.js_edit_search_filter').parent().show();
		var progressSpan = $('.js_edit_search_filter').next('span.js_progress_span:first');
		selectListParam(progressSpan, false);
		return false;		
	});
	
	$('a.js_search_filter_close').live('click', function(e) {
		$('#search_filter').slideUp(500).html('');
		$('a.js_edit_search_filter').parent().show();
		return false;
	});

	$('a.js_search_filter_execute').live("click", function(e){
		if (!SmartWorks.GridLayout.validate($('form.js_validation_required'), $('.js_filter_error_message'))) return false;
		var progressSpan = $('.js_search_filter_page').find('span.js_progress_span:first');
		selectListParam(progressSpan, false);
		return false;
	});	

	$('a.js_search_filter_delete').live("click", function(e){
		smartPop.confirm(smartMessage.get("removeConfirmation"), function(){
			var iworkList = $('.js_iwork_list_page');
			var workId = iworkList.attr('workId');
			var searchFilter = $('.js_search_filter_page');
			var filterId = searchFilter.attr('filterId');

			var paramsJson = {};
			paramsJson['workId'] = workId;
			paramsJson['filterId'] = filterId;
			console.log(JSON.stringify(paramsJson));
			$.ajax({
				url : "remove_iwork_search_filter.sw",
				contentType : 'application/json',
				type : 'POST',
				data : JSON.stringify(paramsJson),
				success : function(data, status, jqXHR) {
					smartPop.showInfo(smartPop.INFORM, smartMessage.get('removeFilterSucceed'), function(){
						document.location.href = "iwork_list.sw?cid=iw.li." + workId;
					});					
				},
				error : function(e) {
					// 서비스 에러시에는 메시지를 보여주고 현재페이지에 그래도 있는다...
					smartPop.showInfo(smartPop.ERROR, smartMessage.get("removeFilterError"), function(){
					});
				}
			});
		});
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
