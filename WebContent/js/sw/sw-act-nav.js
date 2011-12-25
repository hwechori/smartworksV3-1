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

	$('.js_drill_down').live('click', function(e) {
		var input = $(e.target).parents('li.js_drill_down:first').children('a');
		var target = input.siblings('div');
		var url = input.attr('href');
		var categoryId = input[0].getAttribute("categoryId");
		var groupId = input[0].getAttribute("groupId");
		if (url == 'undefined' || (isEmpty(categoryId) && isEmpty(groupId))) {
			return false;
		}
		if(isEmpty($(target).children())){
			$('div.js_nav_my_works').showLoading();						
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
					$('div.js_nav_my_works').hideLoading();											
				},
				error : function(){
					$('div.js_nav_my_works').hideLoading();											
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
