$(function() {
	
	/*
	 * 좌측 "나의 업무" 박스의 좌측상단에 있는 탭(즐겨찾기, 최근처리, 전체업무)탭들이 class="js_nav_tab_work"로
	 * 지정되어 있으며, 이를 선택하면, 밑에 있는 id="my_works"인 div 영역에 탭에서 지정한 href 의 값을 ajax 로
	 * 호출하여 가져온 값을 보여준다. 그리고, 탭에서 선택된곳에 current 로 지정하고 기타것들은 current 를 제거한다.
	 */
	$('.js_nav_tab_work a').swnavi(
			{
				before : function(event){
					popProgressNavGray($('.js_nav_tab_work span'));
				},
				target : 'my_works',
				after : function(event) {
					$(event.target).addClass('current').siblings().removeClass(
							'current');
					closeProgress();
				}
			});

	/*
	 * 좌측 "나의 커뮤너티" 박스이 좌측상단에 있는 탭(나의 부서, 나의 그룹)탭들이 class="js_nav_tab_com" 로
	 * 지정되어 있으며, 이를 선택하면, 밑에 있는 id="my_communities"로 지정되어있는 div 영억에, 탭에서 지장한
	 * href 의 값을 ajax 호출하여 가져온 값을 보여준다. 그리고, 탭에서 선택된곳에 current 로 지정하고 기타 것들은
	 * current 를 제거한다.
	 */
	$('.js_nav_tab_com a').swnavi(
			{
				before : function(event){
					popProgressNavGray($('.js_nav_tab_com span'));
				},
				target : 'my_communities',
				after : function(event) {
					$(event.target).addClass('current').siblings().removeClass(
							'current');
					closeProgress();
				}
			});

	/*
	 * 어디에서든 class 값이 js_content로 지정된 anchor 가 선택이 되면, anchor 의 href 값으로 ajax 를 호출하여
	 * 가져온 값을 content(메인컨텐트)화면에 보여준다.
	 */
	$('a.js_content').swnavi({
		before : function(event){
			var input = $(event.target);
			if(!isEmpty(input.parents('.js_nav_my_works')) || !isEmpty(input.parents('.js_nav_my_com'))){
				popProgressNavGray(input.parents('li:first').find('span:last'));
			}else if(!isEmpty(input.parents('.js_srch_my_works'))){
				console.log(input.parents('.js_srch_my_works').find('.js_auto_complete'));
				popProgressNav(input.parents('.js_srch_my_works').prev('li span:first'));
			}
		},
		target : 'content',
		after : function(event){
			closeProgress();
		}
	});

	$('a.js_location').live('click', function(e){
		
		var input = $(event.target);
		if(!isEmpty(input.parents('.js_srch_my_com'))){
			popProgressNavGray(input.parents('.js_srch_my_com').prev('li').find('span:last'));
			var target = input.parent().next('div');
			window.location = target.find('.sw_hover:first a').attr('href');
			closeProgress();
		}else if(!isEmpty(input.parents('.js_srch_com_members'))){
			popProgressNavGray(input.parents('.js_srch_com_members').prev('li').find('span:last'));
			var target = input.parent().next('div');
			window.location = target.find('.sw_hover:first a').attr('href');
			closeProgress();
		}
	});

	$('a.js_content_iwork_space').swnavi({
		target : 'content',
		after : function(e){
			var input = $(e.target);
			var workId = input.attr("workId");
			var instId = input.attr("instId");
			var formContent = $('div.js_form_content');
			$.ajax({
				url : "get_form_xml.sw",
				data : {
					workId : workId
				},
				success : function(formXml, status, jqXHR) {
					$.ajax({
						url : "get_record.sw",
						data : {
							workId : workId,
							recordId : instId
						},
						success : function(formData, status, jqXHR) {							
							new SmartWorks.GridLayout({
								target : formContent,
								formXml : formXml,
								formValues : formData.record,
								mode : "view"
							});
						}
					});
				}
			});
		}
	});

	/*
	 * 좌측상단에 있는 알림아이콘들에 설정된 class 속성값들이 js_notice_count이고, 이를 클릭하면 그곳의 href값으로
	 * ajax를 호출하여 가져온 값을 id="notice_message_box"로 지정된 div영역에 보여준다. 실행전에는,
	 * id="notice_message_box"로 지정된곳을 찾아서 먼저 닫고(이전에 실행된화면을 지우기 위해서) 화면이 아래로 펼처지게
	 * 한다. 실행후에는, class="js_notice_message_box'로 지정된 알림아이콘들에서 모든 current를 지우고,
	 * 현재 선택된곳에만 current를 추가한다.
	 */
	$('.js_notice_count a').swnavi({
		target : 'notice_message_box',
		before : function(event) {
			popProgressNav($('div.js_notice_icons_area li:last'));
			$('#notice_message_box').hide();
			$('.js_notice_count').find('a').removeClass('current');
		},
		after : function(event) {
			$(event.target).parents('.js_notice_count:first').find('a')
					.addClass('current');
			closeProgress();
			$('#notice_message_box').show();
		}
	});

	// Notice Message Box 에서 항목의 삭제버튼을 클릭하면 실행되는 기능.
	// 선택된 항목에서, noticeId, noticeType, lastNoticeId 를 가져와서, ajax 호출을 한다.
	// 서버에서는 항목을 삭제하고, 삭제된 상태에서의 10개의 항목을 가져다고 전달해준다.
	$('.js_remove_notice').live('click', function(e) {
		var input = $(e.target).parent('a');
		var noticeId = input.attr('noticeId');
		var noticeType = input.attr('noticeType');
		var lastNoticeId = input.attr('lastNoticeId');
		$.ajax({
			url : "remove_notice_instance.sw",
			data : {
				removeNoticeId : noticeId,
				noticeType : noticeType,
				lastNoticeId : lastNoticeId
			},
			success : function(data, status, jqXHR) {
				$('#notice_message_box').html(data);
			}
		});
		return false;
	});

	/*
	 * 좌측상단에서 알림아이콘을 선택하면 펼쳐지는 message box 의 하단에 있는 close 버튼에 설정된 class 값이
	 * js_close_message이며, 이를 선택하면, message_box를 위로 올려닫는다. 그리고나서, 500ms 가 지난뒤에
	 * 알림아이콘에 있는 current 값들을 지운다(message box가 닫혀지는 시간만큼 기다리기위해...)
	 */
	$('.js_close_message').live('click', function(e) {
		$('#notice_message_box').hide();
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
		var input = $(e.target);
		if(input.hasClass('arr_on')){
			input.removeClass('arr_on').addClass('arr_off');
			input.parent().next().hide();
			
		}else{
			input.removeClass('arr_off').addClass('arr_on');
			input.parent().next().show();
		}
		input.parent().parent().siblings('.js_collapsible').toggle();
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

	$('.js_drill_down').live('click', function(e) {
		var input = $(e.target).parents('li.js_drill_down:first').children('a');
		var target = input.siblings('div');
		var url = input.attr('href');
		var categoryId = input[0].getAttribute("categoryId");
		var groupId = input[0].getAttribute("groupId");
		var departmentId = input[0].getAttribute("departmentId");
		if (url == 'undefined' || (isEmpty(categoryId) && isEmpty(groupId) && isEmpty(departmentId))) {
			return false;
		}
		if(isEmpty($(target).children())){
			if(isEmpty(departmentId))
				popProgressNav(input.find('span:last'));						
			$.ajax({
				url : url,
				data : {
					categoryId : categoryId,
					groupId : groupId,
					departmentId : departmentId
				},
				context : input,
				success : function(data, status, jqXHR) {
					target.show();
					target.html(data);
					target.siblings('li.js_drill_down').find('div').hide();
					target.parents('li.js_drill_down').siblings('li.js_drill_down').find('div').hide();
					if(isEmpty(departmentId))
						closeProgress();											
				},
				error : function(){
					if(isEmpty(departmentId))
						closeProgress();											
				}
			});
		}else{
			target.show();
			target.siblings('li.js_drill_down').find('div').hide();
			target.parents('li.js_drill_down').siblings('li.js_drill_down').find('div').hide();
		}
		return false;
	});
});
