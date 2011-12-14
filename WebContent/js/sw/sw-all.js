$(function() {
	/*
	 * 좌측 "나의 업무" 박스의 좌측상단에 있는 탭(즐겨찾기, 최근처리, 전체업무)탭들이 class="js_nav_tab_work"로
	 * 지정되어 있으며, 이를 선택하면, 밑에 있는 id="my_works"인 div영역에 탭에서 지정한 href의 값을 ajax로
	 * 호출하여 가져온 값을 보여준다. 그리고, 탭에서 선택된곳에 current로 지정하고 기타것들은 current를 제거한다.
	 */
	$('.js_nav_tab_work a').swnavi(
			{
				target : 'my_works',
				after : function(event) {
					$(event.target).addClass('current').siblings().removeClass(
							'current');
				}
			});

	/*
	 * 좌측 "나의 커뮤너티" 박스이 좌측상단에 있는 탭(나의 부서, 나의 그룹)탭들이 class="js_nav_tab_com"d로
	 * 지정되어 있으며, 이를 선택하면, 밑에 있는 id="my_communities"로 지정되어있는 div영억에, 탭에서 지장한
	 * href의 값을 ajax 호출하여 가져온 값을 보여준다. 그리고, 탭에서 선택된곳에 current로 지정하고 기타 것들은
	 * current를 제거한다.
	 */
	$('.js_nav_tab_com a').swnavi(
			{
				target : 'my_communities',
				after : function(event) {
					$(event.target).addClass('current').siblings().removeClass(
							'current');
				}
			});

	/*
	 * 어디에서든 class 값이 js_content로 지정된 anchor가 선택이 되면, anchor의 href값으로 ajax를 호출하여
	 * 가져온 값을 content(메인컨텐트)화면에 보여준다.
	 */
	$('a.js_content').swnavi({
		target : 'content'
	});

	/*
	 * 좌측상단에 있는 알림아이콘들에 설정된 class속성값들이 js_notice_count이고, 이를 클릭하면 그곳의 href값으로
	 * ajax를 호출하여 가져온 값을 id="notice_message_box"로 지정된 div영역에 보여준다. 실행전에는,
	 * id="notice_message_box"로 지정된곳을 찾아서 먼저 닫고(이전에 실행된화면을 지우기 위해서) 화면이 아래로 펼처지게
	 * 한다. 실행후에는, class="js_notice_message_box'로 지정된 알림아이콘들에서 모든 current를 지우고,
	 * 현재 선택된곳에만 current를 추가한다.
	 */
	$('.js_notice_count a').swnavi(
			{
				target : 'notice_message_box',
				before : function(event) {
					$('#notice_message_box').hide();
					$('#notice_message_box').slideDown();
				},
				after : function(event) {
					$('.js_notice_count').find('a').removeClass('current');
					$(event.target).parents('.js_notice_count:first').find('a')
							.addClass('current');
				}
			});

	/*
	 * 좌측상단에서 알림아이콘을 선택하면 펼쳐지는 message box의 하단에 있는 close버튼에 설정된 class값이
	 * js_close_message이며, 이를 선택하면, message_box를 위로 올려닫는다. 그리고나서, 500ms 가 지난뒤에
	 * 알림아이콘에 있는 current값들을 지운다(message box가 닫혀지는 시간만큼 기다리기위해...)
	 */
	$('.js_close_message').live('click', function(e) {
		$('#notice_message_box').slideUp();
		setTimeout(function() {
			$('.js_notice_count').find('a').removeClass('current');
		}, 500);
		return false;
	});

	/*
	 * js_collase_parent_siblings class를 가지고있는 항목을 선택하면 부모와 같은 수준에 있는 곳에서
	 * js_collapsible class를 찾아서, 위로 닫고 아래로 여는것을 한번씩 실행해준다.
	 */
	$('.js_collapse_parent_siblings').live('click', function(e) {
		$(e.target).parent().parent().siblings('.js_collapsible').toggle();
		return false;
	});

	/*
	 * js_collase_siblings class를 가지고있는 항목을 선택하면 현재와 같은 수준에 있는 곳에서
	 * js_collapsible class를 찾아서, 위로 닫고 아래로 여는것을 한번씩 실행해준다.
	 */
	$('.js_collapse_siblings').live('click', function(e) {
		$(e.target).siblings('.js_collapsible').toggle();
		return false;
	});

	/*
	 * 검색 입력창에서 사용하는 것으로, 값을 입력하고 500ms이상 정지하고 있으면 입렵박스의 href값으로 ajax를 호출하여, 가져온
	 * 값을, js_start_work class(새업무시작하기에서 업무검색하는 입력창)는 id가 upload_work_list인 곳에
	 * 보여주고, 그렇지 않으면 내부모와 같은 수준에 있는 div 영역에 보여준다.
	 */
	$('input.js_auto_complete').live('keyup', function(e) {
		var input = $(e.target);
		var start_work = input.parents('div.js_start_work');
		var chatter_name = input.parents('div.js_chatter_names');
		var target;
		if (input[0].value.length > 0)
			input.next('div').removeClass('srch_ico').addClass('btn_im_x');
		if (start_work.length > 0)
			target = start_work.find('#upload_work_list');
		else if(chatter_name.length>0)
			target = chatter_name.siblings('div.js_chatter_list');
		else
			target = input.parent().next('div');
		var url = input.attr('href');
		var lastValue = input[0].value;
		setTimeout(function() {
			var currentValue = input[0].value;

			if (lastValue === currentValue) {
				$.ajax({
					url : url,
					data : {
						key : input[0].value
					},
					context : input,
					success : function(data, status, jqXHR) {
						target.show();
						target.html(data);
					}
				});
			} else {
			}
		}, 500);
	});

	/*
	 * 검색 입력창에서 검색을 하고나서, 포커스가 다른곳으로 이동을 하면, 500ms후에 검색결과 창을 숨긴다.
	 */
	$('input.js_auto_complete').live('focusout', function(e) {
		var input = $(e.target);
		var start_work = input.parents('div.js_start_work');
		var user_name = input.parents('div.js_community_names');
		var chatter_name = input.parents('div.js_chatter_names');
		var target;
		if (start_work.length)
			target = start_work.find('#upload_work_list');
		else if (user_name.length)
			target = user_name.next('div');
		else if(chatter_name.length)
			target = chatter_name.siblings('div.js_chatter_list');
		else
			target = input.parent().siblings('div');
		setTimeout(function() {
			input[0].value = '';
			input.next('div').removeClass('btn_im_x').addClass('srch_ico');
			target.hide();
		}, 500);
	});

	$('input.js_auto_complete').live('keydown', function(e) {
		if(e.keyCode == 40){
			var nextDivLis = $(e.target).parent().next('div').find('li');
			if(nextDivLis.length > 0){
				$(nextDivLis[0]).select().focus();
			}
		}
	});

	$('div.js_srch_x').live('click', function(e) {
		var input = $(e.target).prev();
		input.value = "";
		input.next('div').removeClass('btn_im_x').addClass('srch_ico');
		return false;
	});

	$('.js_select_action a').live(
			'click',
			function(e) {
				var input = $(e.target);
				$('.js_select_action').find('a').removeClass('current');
				input.parents('.up_icon_list').find('a').addClass('current')
						.attr('id');
				var target = $('#upload_form_box');
				var url = input.attr('href');
				$.ajax({
					url : url,
					data : {},
					success : function(data, status, jqXHR) {
						target.html(data).slideDown(500);
					}
				});
				return false;
			});
	$('select.js_select_filter_operand').live(
			'change',
			function(e) {
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

	$('select.js_select_filter_operator').live(
			'change',
			function(e) {
				var input = $(e.target);
				var target = input.children('option:selected').attr('type');
				input.siblings('span.' + target).show().siblings('span.js_right_operand').hide();
				return false;
			});

	$('a.js_search_filter').live(
			'click',
			function(e) {
				var input = $(e.target).parent();
				var target = $('#search_filter');
				var url = input.attr('href');
				$.ajax({
					url : url,
					data : {},
					success : function(data, status, jqXHR) {
						target.html(data);
						var condition = $(target).find('form.js_new_condition');
						var newCondition = condition.clone().removeClass("js_new_condition");
						condition.parent().append(newCondition.show());
						target.slideDown(500);
					}
				});
				return false;
			});

	$('select.js_select_filter').live(
			'change',
			function(e) {
				var input = $(e.target);
				var target = $('#search_filter');
				var url = input.attr('href') + "&filterId=" + input.children('option:selected').attr('value');
				$.ajax({
					url : url,
					data : {},
					success : function(data, status, jqXHR) {
						target.html(data).slideDown(500);
					}
				});
				return false;
			});

	$('button.js_remove_condition').live(
			'click',
			function(e) {
				$(e.target).parents('form.js_filter_condition:first').remove();
				return false;
			});

	$('img.js_add_condition').live(
			'click',
			function(e) {
				var target = $(e.target).parents('div.js_search_filter').find('form.js_filter_condition').parent();
				var newCondition = target.find('form.js_new_condition:first').clone().show().removeClass('js_new_condition');
				target.append(newCondition.show());
				return false;
			});

	/*
	 * 새업무시작하기에서, 처음나오는 입력창을 클릭하면 실행되는 이벤트로, 우측에 전체업무찾기 버튼을 보여준다.
	 */
	$('.js_start_work').live(
			'click',
			function(e) {
				$(e.target).parents('div.js_start_work:first').find(
						'#all_work_btn').show();
			});

	/*
	 * 세업무시작하기에서, 입력창에 값을 입력하여 나오는 검색결과를 선택하면 실행되는 이벤트로, 검색결과항목의 href값으로 ajax를
	 * 실행하여 가져온 값으로 id가 start_work_form인 곳 화면을 그려서, 아래로 펼쳐준다.
	 */
	$('.js_select_work').swnavi(
			{
				target : 'form_works',
				before : function(event) {
					$('#form_works').slideUp().slideDown(500);
					$(event.target).parents('#upload_work_list').hide()
							.parents(".js_start_work").slideUp();
				}
			});

	$('a.js_create_new_work').live('click', function(e) {
		var input = $(e.target);
		var target = input.parents('div.js_work_list_title:first').siblings('div.js_new_work_form');
		var url = input.attr('href');
		$.ajax({
			url : url,
			data : {},
			success : function(data, status, jqXHR) {
				target.html(data).slideDown(500);
				var formContent = target.find('div.js_form_content');
				var workId = formContent.attr('workId');
				$.ajax({
					url : "get_form_xml.sw",
					data : {
						workId : workId
					},
					success : function(formXml, status, jqXHR) {
						console.log(formXml);
						console.log(status);
						console.log(jqXHR);
						new SmartWorks.GridLayout({
							target : formContent,
							formXml : formXml
						});
					}
				});			
			}
		});
		return false;
	});

	$('a.js_new_work_report').live('click', function(e) {
		var input = $(e.target);
		var target = input.parents('div.js_work_report').siblings('div.js_work_report_form');
		var url = input.attr('href');
		$.ajax({
			url : url,
			data : {},
			success : function(data, status, jqXHR) {
				target.html(data).slideDown(500);
			}
		});
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
		$.ajax({
			url : url,
			data : {reportId: reportId, reportType: reportType, reportName: reportName, chartType: chartType},
			success : function(data, status, jqXHR) {
				var chartTarget = target.html(data).find('div.js_work_report_view');
				smartChart.load(reportId, chartType, false, "chart_target");
				target.slideDown(500);
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
			var url = input.parent().attr('url');
			$.ajax({
				url : url,
				data : {},
				success : function(data, status, jqXHR) {
					target.html(data).show();
					input.hide().siblings().show();
				}
			});
		}
		return false;
	});

	$('.js_select_community')
	.live(
			'click',
			function(e) {
				var input = $(e.target);
				
				var comName = input.attr('comName');
				var comId = input.attr('comId');
				var target = input.parents('div.js_community_list').prev()
						.find('div.js_selected_communities');
				
				console.log(target.siblings('input.js_auto_complete'));
				target.siblings('input.js_auto_complete').value = '';
				
				var inputTarget = target.siblings('input.js_form_user_field');
				console.log(inputTarget);
				if(inputTarget.length == 1) {
					inputTarget.hide();
					inputTarget.next('div.js_srch_x').hide();
				}
				var oldHTML = target.html();
				if (oldHTML == null)
					oldHTML = "";
				var communityItems = $(target).find('span.js_community_item');
				var isSameId = false;
				for(var i=0; i<communityItems.length; i++){
					var oldComId = $(communityItems[i]).attr('comId');
					if(oldComId !=null && oldComId === comId){
						isSameId = true;
						break;
					}
				}
				if(!isSameId){
					var newHTML = oldHTML
						+ "<span class='js_community_item user_select' comId='"
						+ comId
						+ "'>"
						+ comName
						+ "<span class='btn_x_gr'><a class='js_remove_community' href=''> x</a></span></span>";
					target.html(newHTML);
				}
				target.next().focus();
				return false;
			});

	$('.js_remove_community').live('click', function(e) {
		var input = $(e.target);
		
		var inputTarget = input.parents('div.js_selected_communities').siblings('input.js_form_user_field');
		
		if (inputTarget.length == 1) {
			inputTarget.show();
			inputTarget.next('div.js_srch_x').show();
		}
		var selected_users = input.parents('div.js_selected_communities');
		input.parents('span.js_community_item').remove();
		selected_users.next().focus();
		return false;
	});


	$('input.js_whole_day').live('click', function(e){
		var input = $(e.target);
		input.parent().siblings('div.js_start_time').toggle();
		var endtime = input.parent().siblings('div.js_end_datetime').find('div.js_end_time').hide();
		if(input[0].checked) endtime.hide();
		else endtime.show();
	});
	$('a.js_toggle_form_detail').swnavi(
			{
				target : 'form_import',
				after : function(event) {
					var input = $(event.target);
					input.parents('div.js_file_detail_form').parent().prev()
							.slideToggle(500);
					input.parent().toggle().siblings().toggle();
				}
			});

	$('a.js_view_work_manual').live('click', function(e){
		var input = $(e.target);
		input.parents("div.js_content_div:first").next('#work_manual').slideToggle(500);
		input.hide();
		input.siblings().show();
		return false;
	});

	$('a.js_select_task_manual').live('click', function(e){
		var input = $(e.target).parents('a.js_select_task_manual:first');
		var target = $("#"+input.attr("taskId"));
		var target_point = $(target).find("div.up_point:first");
		target_point.css({"left": (input.position().left + 20) + "px"});
		$(target).show().siblings('div.js_task_manual').hide();
		return false;
	});

	$('.js_drill_down').live('click', function(e) {
		var input = $(e.target).parents('li.js_drill_down:first').children('a');
		var target = input.siblings('div');
		var url = input.attr('href');
		var categoryId = input[0].getAttribute("categoryId");
		var groupId = input[0].getAttribute("groupId");
		if (url == 'undefined' || (categoryId == null && groupId == null)) {
			return false;
		}
		if($(target).children().length == 0){
			$.ajax({
				url : url,
				data : {
					categoryId : categoryId,
					groupId : groupId,
				},
				context : input,
				success : function(data, status, jqXHR) {
					target.show();
					target.html(data);
					target.siblings('li.js_drill_down').find('div').hide();
					target.parents('li.js_drill_down').siblings('li.js_drill_down').find('div').hide();
				}
			});
		}else{
			target.show();
			target.siblings('li.js_drill_down').find('div').hide();
			target.parents('li.js_drill_down').siblings('li.js_drill_down').find('div').hide();
		}
		return false;
	});

	$('input.js_file_upload').live('change', function(e) {
		var input = $(e.target);
		var newInput = document.createElement( 'input' );
		newInput.type = 'file';
		$(newInput).addClass('js_file_upload');
		
		input.parent().add( newInput);
//		e.target.style.display = 'none';
		var target = input.parent().next('div.js_selected_files');
		var oldHTML = target.html();
		if (oldHTML == null)
			oldHTML = "";		
		var newHTML = oldHTML
		+ "<span class='js_file_item user_select' >"
		+ input[0].value
		+ "<span class='btn_x_gr'><a class='js_remove_file' href=''> x</a></span></span>";
		target.html(newHTML);
		$(target).find('span.js_file_item').add(e.target);
	});

	$('.qq-delete-text').live('click', function(e) {
		$.ajax({
			url : "delete_file.sw",
			data : {
				fileId : $(e.target).parent('li').attr('fileId')
			},
			type : "POST",
			context : this,
			success : function(data, status, jqXHR) {
				$(e.target).parent().remove();
			}
		});
	});

	$('.qq-upload-file').live('click', function(e) {
		$.ajax({
			url : "download_file.sw",
			data : {
				fileId : $(e.target).parent('li').attr('fileId')
			},
			type : "GET",
			context : this,
			success : function(data, status, jqXHR) {
			}
		});
	});
	
	$('a.js_pop_user_info').live('click', function(e) {
		var input = $(e.target);
		var left = input.parents('td:first').position().left;
		var top = input.parents('td:first').position().top;
		input.popupWindow({ 
			width:600,
			height:600,
			top:top, 
			left:left
		}); 
		return false;
	});
	
});
