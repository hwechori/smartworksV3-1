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

	$('a.js_select_new_work_report').live('click', function(e) {
		var input = $(e.target);
		var target = input.next('div.js_new_work_report');
		var url = input.attr('href');
//		var progressSpan = input.parents('.js_work_report:first').find('span.js_progress_span');
//		smartPop.progressCont(progressSpan);						
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

	$('a.js_edit_work_report').live('click', function(e) {
		var input = $(e.target);
		var workReport = input.parents('div.js_work_report_page');
		var target = workReport.find('div.js_work_report_edit');
		var url = input.attr('href');
		var progressSpan = input.parent().next('span.js_progress_span');
		var reportId = workReport.find('select[name="selMyReportList"]').attr('value');
		smartPop.progressCont(progressSpan);
		console.log(url);
		$.ajax({
			url : url,
			data : {
				reportId: reportId
			},
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

	$('a.js_work_report_close').live('click', function(e) {
		$(e.target).parents('.js_work_report_edit').slideUp().html('');
		return false;
	});

	
	$('a.js_work_report_execute').live('click', function(e) {
		var forms = $(e.target).parents('.js_work_report_edit').find('form');
		if (SmartWorks.GridLayout.validate(forms)) {
			var paramsJson = {};
			var workReportEdit = forms.find('.js_work_report_edit_page');
			paramsJson['workId'] = workReportEdit.attr('workId');
			for(var i=0; i<forms.length; i++){
				var form = $(forms[i]);
				var visibleForm = form.find(':visible');
				paramsJson[form.attr('name')] = mergeObjects(visibleForm.serializeObject(), SmartWorks.GridLayout.serializeObject(visibleForm));
			}
			console.log(JSON.stringify(paramsJson));
			var url = "get_report_data_by_def.sw";
			smartPop.progressCont($(e.target).parents('.js_work_report_edit').find('form[name="frmAccessPolicy"]').nextAll('.js_progress_span'));
			$.ajax({
				url : url,
				contentType : 'application/json',
				type : 'POST',
				data : JSON.stringify(paramsJson),
				success : function(data, status, jqXHR) {
					var reportType = forms.find('input[name="rdoWorkReportType"]').attr('value');
					var chartType = forms.find('select[name="selReportChartType"]').find('option:selected').attr('chartType');
					smartPop.closeProgress();
					smartChart.loadWithData(reportType, data, chartType, false, "chart_target");
 				},
				error : function(e) {
					smartPop.closeProgress();
					smartPop.showInfo(smartPop.ERROR, smartMessage.get("createReportError"));
				}
			});
		
		}
		return false;
	});

	$('a.js_work_report_save').live('click', function(e) {
		var workReportEdit = $(e.target).parents('.js_work_report_edit');
		var forms = workReportEdit.find('form');
		if (SmartWorks.GridLayout.validate(forms)) {
			var paramsJson = {};
			var workReportEditPage = workReportEdit.find('.js_work_report_edit_page');
			paramsJson['workId'] = workReportEditPage.attr('workId');
			console.log('workId=', workReportEditPage.attr('workId'));
			var url = "create_new_work_report.sw";
			if(workReportEdit.find("input.js_work_report_name").not(':visible')){
				paramsJson['reportId'] = workReportEditPage.attr('reportId');
				url = "set_work_report.sw";
			}
				
			for(var i=0; i<forms.length; i++){
				var form = $(forms[i]);
				var visibleForm = form.find(':visible');
				paramsJson[form.attr('name')] = mergeObjects(visibleForm.serializeObject(), SmartWorks.GridLayout.serializeObject(visibleForm));
			}
			console.log(JSON.stringify(paramsJson));
			smartPop.progressCont($(e.target).parents('.js_work_report_edit').find('form[name="frmAccessPolicy"]').nextAll('.js_progress_span'));
			$.ajax({
				url : url,
				contentType : 'application/json',
				type : 'POST',
				data : JSON.stringify(paramsJson),
				success : function(data, status, jqXHR) {
					$('.js_work_report_list_box:first').html(data);
					$('a.js_work_report_close').click();
					smartPop.closeProgress();
					smartPop.showInfo(smartPop.INFORM, smartMessage.get('setReportSucceed'));
 				},
				error : function(e) {
					smartPop.closeProgress();
					smartPop.showInfo(smartPop.ERROR, smartMessage.get("createReportError"));
				}
			});
		
		}
		return false;
	});

	$('a.js_work_report_delete').live('click', function(e) {
		var paramsJson = {};
		var workReportEdit = $(e.target).parents('.js_work_report_edit_page');
		paramsJson['workId'] = workReportEdit.attr('workId');
		paramsJson['reportId'] = workReportEdit.attr('reportId');
		console.log(JSON.stringify(paramsJson));
		smartPop.progressCont($(e.target).parents('.js_work_report_edit').find('form[name="frmAccessPolicy"]').nextAll('.js_progress_span'));
		$.ajax({
			url : "remove_work_report.sw",
			contentType : 'application/json',
			type : 'POST',
			data : JSON.stringify(paramsJson),
			success : function(data, status, jqXHR) {
				$('.js_work_report_list_box:first').html(data);
				$('a.js_work_report_close').click();
				smartPop.closeProgress();
				smartPop.showInfo(smartPop.INFORM, smartMessage.get('setReportSucceed'));
			},
			error : function(e) {
				smartPop.closeProgress();
				smartPop.showInfo(smartPop.ERROR, smartMessage.get("createReportError"));
			}
		});
		
		return false;
	});

	$('a.js_work_report_saveas').live('click', function(e) {
		var input = $(e.target).hide();
		var workReport = input.parents('.js_work_report_page:first');
		workReport.find('.js_button_save_as').hide();
		workReport.find('.js_button_save').show();
		workReport.find('.js_work_report_name').show();
		
		return false;
	});

	$('select.js_select_work_report').live('change', function(e) {
		var input = $(e.target);
		var workReport = $('div.js_work_report_page');
		var target = workReport.find('div.js_work_report_view');
		var url = input.attr('href');
		var reportType = workReport.attr("reportType");
		var selected = input.children('option:selected');
		var reportId = selected.attr('value');
		if(reportId==="none"){
			target.slideUp().html('');
			workReport.find('div.js_work_report_edit').slideUp().html('');
			return false;
		}
		var chartType = selected.attr('chartType');
		var progressSpan = input.parent().next('span.js_progress_span');
		smartPop.progressCont(progressSpan);						
		$.ajax({
			url : url,
			data : {
				chartType: chartType
			},
			success : function(data, status, jqXHR) {
				target.html(data).slideDown(500);
				smartChart.load(parseInt(reportType), reportId, chartType, false, "chart_target");
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
