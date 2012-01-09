$(function() {

	$('button.js_remove_condition').live('click', function(e) {
		$(e.target).parents('form.js_filter_condition:first').remove();
		return false;
	});

	$('img.js_add_condition').live('click', function(e) {
		var target = $(e.target).parents('div.js_search_filter').find('form.js_filter_condition').parent();
		var newCondition = target.find('form.js_new_condition:first').clone().show().removeClass('js_new_condition');
		target.append(newCondition.show());
		return false;
	});

	$('a.js_new_work_report').live('click', function(e) {
		var input = $(e.target);
		var target = input.parents('div.js_work_report').siblings('div.js_work_report_form');
		var url = input.attr('href');
		var progressSpan = input.parents('.js_work_report:first').find('span.js_progress_span');
		smartPop.progressCont(progressSpan);						
		$.ajax({
			url : url,
			data : {},
			success : function(data, status, jqXHR) {
				target.html(data).slideDown(500);
				smartPop.closeProgress();						
			},
			error : function(xhr, ajaxOptions, thrownError){
				smartPop.closeProgress();						
			}
		});
		return false;
	});

	$('a.js_close_work_report').live('click', function(e) {
		$(e.target).parents('.js_work_report_page').hide().html('');
		return false;
	});

	$('select.js_select_work_report').live('change', function(e) {
		var input = $(e.target);
		var target = input.parents('div.js_work_report').siblings('div.js_work_report_form');
		var url = input.attr('href')
		var selected = input.children('option:selected');
		var reportId = selected.attr('value');
		var reportType = selected.attr('reportType');
		var reportName = selected.html();
		var chartType = selected.attr('chartType');
		var progressSpan = input.parents('.js_work_report:first').find('span.js_progress_span');
		smartPop.progressCont(progressSpan);						
		$.ajax({
			url : url,
			data : {reportId: reportId, reportType: reportType, reportName: reportName, chartType: chartType},
			success : function(data, status, jqXHR) {
				var chartTarget = target.html(data).find('div.js_work_report_view');
				smartChart.load(reportId, chartType, false, "chart_target");
				target.slideDown(500);
				smartPop.closeProgress();						
			},
			error : function(xhr, ajaxOptions, thrownError){
				smartPop.closeProgress();						
			}

		});
		
		return false;
	});

	$('select.js_change_chart_type').live('change', function(e) {
		var input = $(e.target);
		var chartType = input.attr('value');
		$('#chart_target').html("");
		smartChart.reload(chartType, false);
		return false;
	});

	$('tr.js_work_report_type td').live('change', function(e) {
		var input = $(e.target);
		var target = input.parents('table.js_report_title').next('table.js_form_by_report_type');
		var url = input.attr('href');
		var reportType = input.attr('value');
		$.ajax({
			url : url,
			data : {reportType : reportType },
			success : function(data, status, jqXHR) {
				target.html(data).show();
			},
			error : function(xhr, ajaxOptions, thrownError){
				
			}
		});
		return false;
	});

	$('td.js_select_chart_axis select').live('change', function(e) {
		var input = $(e.target);		
		var type = input.children('option:selected').attr('type');
		var targetDate = input.nextAll('.js_axis_selector_date:first');
		var targetUser = input.nextAll('.js_axis_selector_user:first');
		if(type === "dateChooser" || type ==="dateTimeChooser"){
			targetDate.show();
			targetUser.hide();
		}else if(type === "userField"){
			targetDate.hide();
			targetUser.show();
		}else{
			targetDate.hide();
			targetUser.hide();			
		}
		return false;
	});

	$('tr.js_add_chart_zaxis a').live('click', function(e) {
		var input = $(e.target).parents('tr.js_add_chart_zaxis:first').hide();
		input.next('tr.js_chart_zaxis').show();
		var secondZaxis = input.nextAll('tr.js_chart_zsecondaxis:first');
		if(secondZaxis.not(":visible") && secondZaxis.prevAll('tr.js_report_chart_type').not(':visible'))
			secondZaxis.prev('tr.js_add_chart_zsecondaxis').show();
		return false;
	});
	$('.js_remove_chart_zaxis a').live('click', function(e){
		$(e.target).parents('tr.js_chart_zaxis:first').hide().prev('tr.js_add_chart_zaxis').show();
		$(e.target).parents('tr.js_chart_zaxis:first').nextAll('tr.js_add_chart_zsecondaxis:first').hide().next('tr.js_chart_zsecondaxis').hide();
		return false;
	});
	$('tr.js_add_chart_xsecondaxis a').live('click', function(e) {
		var input = $(e.target).parents('tr.js_add_chart_xsecondaxis:first').hide();
		input.next('tr.js_chart_xsecondaxis').show();
		return false;
	});
	$('.js_remove_chart_xsecondaxis a').live('click', function(e){
		$(e.target).parents('tr.js_chart_xsecondaxis:first').hide().prev('tr.js_add_chart_xsecondaxis').show();
		return false;
	});
	$('tr.js_add_chart_zsecondaxis a').live('click', function(e) {
		var input = $(e.target).parents('tr.js_add_chart_zsecondaxis:first').hide();
		input.next('tr.js_chart_zsecondaxis').show();
		return false;
	});
	$('.js_remove_chart_zsecondaxis a').live('click', function(e){
		$(e.target).parents('tr.js_chart_zsecondaxis:first').hide().prev('tr.js_add_chart_zsecondaxis').show();
		return false;
	});
	$('tr.js_toggle_chart_search_filter a').live('click', function(e) {
		var input = $(e.target).parent('td');
		var target = input.parent().next('tr.js_chart_search_filter');
		var actionType = input.attr('actionType');
		if(actionType!=null && actionType === "remove"){
			target.hide();
			input.hide().siblings().show();
		}else{
			$('#content').showLoading();						
			var url = input.parent().attr('url');
			$.ajax({
				url : url,
				data : {},
				success : function(data, status, jqXHR) {
					target.html(data).show();
					input.hide().siblings().show();
					$('#content').hideLoading();						
				},
				error : function(xhr, ajaxOptions, thrownError){
					$('#content').hideLoading();											
				}
			});
		}
		return false;
	});
});
