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

	$('a.js_search_filter').live('click', function(e) {
		$('#content').showLoading();
		var input = $(e.target).parent();
		var target = $('#search_filter');
		var url = input.attr('href') + "&filterId=" + $('form[name="frmIworkFilterName"]').children('select').attr('value');
		$.ajax({
			url : url,
			data : {},
			success : function(data, status, jqXHR) {
				target.html(data);
//				var condition = $(target).find('form.js_new_condition');
//				var newCondition = condition.clone().removeClass("js_new_condition");
//				condition.parent().append(newCondition.show());
				target.slideDown(500);
				input.hide();
				$('#content').hideLoading();
			},
			error : function(){
				$('#content').hideLoading();						
			}
		});
		return false;
	});

	$('a.js_search_filter_close').live('click', function(e) {
		$('#search_filter').slideUp(500).html('');
		$('a.js_search_filter').show();
		return false;
	});

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
		$('#content').showLoading();						
		var input = $(e.target);
		var target = input.parents('div.js_work_report').siblings('div.js_work_report_form');
		var url = input.attr('href');
		$.ajax({
			url : url,
			data : {},
			success : function(data, status, jqXHR) {
				target.html(data).slideDown(500);
				$('#content').hideLoading();						
			},
			error : function(){
				$('#content').hideLoading();						
			}
		});
		return false;
	});

	$('select.js_select_work_report').live('change', function(e) {
		$('#content').showLoading();						
		var input = $(e.target);
		var target = input.parents('div.js_work_report').siblings('div.js_work_report_form');
		var url = input.attr('href')
		var selected = input.children('option:selected');
		var reportId = selected.attr('value');
		var reportType = selected.attr('reportType');
		var reportName = selected.html();
		var chartType = selected.attr('chartType');
		$.ajax({
			url : url,
			data : {reportId: reportId, reportType: reportType, reportName: reportName, chartType: chartType},
			success : function(data, status, jqXHR) {
				var chartTarget = target.html(data).find('div.js_work_report_view');
				smartChart.load(reportId, chartType, false, "chart_target");
				target.slideDown(500);
				$('#content').hideLoading();						
			},
			error : function(){
				$('#content').hideLoading();						
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
		var url = input.attr('url');
		var reportType = input.attr('value');
		$.ajax({
			url : url,
			data : {reportType : reportType },
			success : function(data, status, jqXHR) {
				target.html(data).show();
			}
		});
		return false;
	});

	$('td.js_select_chart_axis select').live('change', function(e) {
		var input = $(e.target);		
		var type = input.children('option:selected').attr('type');
		var targetDate = input.parents('td.js_select_chart_axis:first').next('td.js_axis_selector_date:first');
		var targetUser = targetDate.next('td.js_axis_selector_user:first');
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
		input.next('tr.js_chart_zaxis:first').slideDown(500);
		return false;
	});
	$('td.js_remove_chart_zaxis a').live('click', function(e){
		var target = $(e.target).parents('tr.js_chart_zaxis:first').hide().prev('tr.js_add_chart_zaxis:first').show();
		return false;
	});
	$('tr.js_add_chart_xsecondaxis a').live('click', function(e) {
		var input = $(e.target).parents('tr.js_add_chart_xsecondaxis:first').hide();
		input.next('tr.js_chart_xsecondaxis:first').slideDown(500);
		return false;
	});
	$('td.js_remove_chart_xsecondaxis a').live('click', function(e){
		var target = $(e.target).parents('tr.js_chart_xsecondaxis:first').hide().prev('tr.js_add_chart_xsecondaxis:first').show();
		return false;
	});
	$('tr.js_add_chart_zsecondaxis a').live('click', function(e) {
		var input = $(e.target).parents('tr.js_add_chart_zsecondaxis:first').hide();
		input.next('tr.js_chart_zsecondaxis:first').slideDown(500);
		return false;
	});
	$('td.js_remove_chart_zsecondaxis a').live('click', function(e){
		var target = $(e.target).parents('tr.js_chart_zsecondaxis:first').hide().prev('tr.js_add_chart_zsecondaxis:first').show();
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
				error : function(){
					$('#content').hideLoading();											
				}
			});
		}
		return false;
	});
});
