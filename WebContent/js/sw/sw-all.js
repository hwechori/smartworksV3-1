$(document).ready(
		function() {
			/*
			 * 좌측 "나의 업무" 박스의 좌측상단에 있는 탭(즐겨찾기, 최근처리, 전체업무)탭들이
			 * class="js_nav_tab_work"로 지정되어 있으며, 이를 선택하면, 밑에 있는 id="my_works"인
			 * div영역에 탭에서 지정한 href의 값을 ajax로 호출하여 가져온 값을 보여준다. 그리고, 탭에서 선택된곳에
			 * current로 지정하고 기타것들은 current를 제거한다.
			 */
			$('.js_nav_tab_work a').swnavi(
					{
						target : 'my_works',
						after : function(event) {
							$(event.target).addClass('current').siblings()
									.removeClass('current');
						}
					});

			/*
			 * 좌측 "나의 커뮤너티" 박스이 좌측상단에 있는 탭(나의 부서, 나의 그룹)탭들이
			 * class="js_nav_tab_com"d로 지정되어 있으며, 이를 선택하면, 밑에 있는
			 * id="my_communities"로 지정되어있는 div영억에, 탭에서 지장한 href의 값을 ajax 호출하여
			 * 가져온 값을 보여준다. 그리고, 탭에서 선택된곳에 current로 지정하고 기타 것들은 current를 제거한다.
			 */
			$('.js_nav_tab_com a').swnavi(
					{
						target : 'my_communities',
						after : function(event) {
							$(event.target).addClass('current').siblings()
									.removeClass('current');
						}
					});

			/*
			 * 어디에서든 class 값이 js_content로 지정된 anchor가 선택이 되면, anchor의 href값으로
			 * ajax를 호출하여 가져온 값을 content(메인컨텐트)화면에 보여준다.
			 */
			$('a.js_content').swnavi({
				target : 'content'
			});

			/*
			 * 좌측상단에 있는 알림아이콘들에 설정된 class속성값들이 js_notice_count이고, 이를 클릭하면 그곳의
			 * href값으로 ajax를 호출하여 가져온 값을 id="notice_message_box"로 지정된 div영역에
			 * 보여준다. 실행전에는, id="notice_message_box"로 지정된곳을 찾아서 먼저 닫고(이전에 실행된화면을
			 * 지우기 위해서) 화면이 아래로 펼처지게 한다. 실행후에는, class="js_notice_message_box'로
			 * 지정된 알림아이콘들에서 모든 current를 지우고, 현재 선택된곳에만 current를 추가한다.
			 */
			$('.js_notice_count a').swnavi(
					{
						target : 'notice_message_box',
						before : function(event) {
							$('#notice_message_box').hide();
							$('#notice_message_box').slideDown();
						},
						after : function(event) {
							$('.js_notice_count').find('a').removeClass(
									'current');
							$(event.target).parents('.js_notice_count:first')
									.find('a').addClass('current');
						}
					});

			/*
			 * 좌측상단에서 알림아이콘을 선택하면 펼쳐지는 message box의 하단에 있는 close버튼에 설정된 class값이
			 * js_close_message이며, 이를 선택하면, message_box를 위로 올려닫는다. 그리고나서, 500ms
			 * 가 지난뒤에 알림아이콘에 있는 current값들을 지운다(message box가 닫혀지는 시간만큼 기다리기위해...)
			 */
			$('.js_close_message').live('click', function(e) {
				$('#notice_message_box').slideUp();
				setTimeout(function() {
					$('.js_notice_count').find('a').removeClass('current');
				}, 500);
				return false;
			});

			/*
			 * js_collase_parent_siblings class를 가지고있는 항목을 선택하면 부모와 같은 수준에 있는
			 * 곳에서 js_collapsible class를 찾아서, 위로 닫고 아래로 여는것을 한번씩 실행해준다.
			 */
			$('.js_collapse_parent_siblings').live(
					'click',
					function(e) {
						$(e.target).parent().siblings('.js_collapsible')
								.slideToggle(500);
					});

			/*
			 * js_collase_siblings class를 가지고있는 항목을 선택하면 현재와 같은 수준에 있는 곳에서
			 * js_collapsible class를 찾아서, 위로 닫고 아래로 여는것을 한번씩 실행해준다.
			 */
			$('.js_collapse_siblings').live('click', function(e) {
				$(e.target).siblings('.js_collapsible').slideToggle(500);
			});

			/*
			 * 검색 입력창에서 사용하는 것으로, 값을 입력하고 500ms이상 정지하고 있으면 입렵박스의 href값으로 ajax를
			 * 호출하여, 가져온 값을, js_start_work class(새업무시작하기에서 업무검색하는 입력창)는 id가
			 * upload_work_list인 곳에 보여주고, 그렇지 않으면 내부모와 같은 수준에 있는 div 영역에 보여준다.
			 */
			$('input.js_auto_complete').live('keyup', function(e) {
				var input = $(e.target);
				var start_work = input.parents('div.js_start_work');
				var target;
				if (start_work.length > 0)
					target = start_work.next('#upload_work_list');
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
				var user_name = input.parents('div.js_user_name');
				var target;
				if (start_work.length > 0)
					target = start_work.next('#upload_work_list');
				else if (user_name.length > 0)
					target = user_name.next('div');
				else
					target = input.parent().siblings('div');
				setTimeout(function() {
					input[0].value = '';
					target.hide();
				}, 500);
			});

			/*
			 * 새업무시작하는 화면에서 "간단히"와 "자세히" 텝에 설정된 class값으로, 탭을 선택하면 href값으로 ajax를
			 * 호출하여 id form_import인 곳에 보여준다. 그리고나서, 선택된 곳에 current를 지정하고, 나머지에는
			 * current를 제거한다.
			 */
			$('.js_start_tab_form a').swnavi(
					{
						target : 'form_import',
						after : function(event) {
							$(event.target).parent().addClass('current')
									.siblings().removeClass('current');
						}
					});

			$('.js_select_action li a')
			.live(
					'click',
					function(e) {
						var input = $(e.target);
						$('.js_upload_form').hide();
						$('.js_upload_form_detail').hide();
						$('.js_select_action').find('a').removeClass(
								'current');
						var targetId = input.parents('li:first')
								.find('a').addClass('current').attr(
										'id');
						var target = $('#' + targetId + '_box');
						$('.js_start_work input').removeAttr('value');
						
						if(targetId === "action_work"){
							target.slideDown(500).find('.js_start_work input').show();
						}else{
							var url = input.attr('href');
							$.ajax({
								url : url,
								data : {},
								success : function(data, status, jqXHR) {
									target.html(data);
								},
								complete : function(){
									target.slideDown(500);
								}
							});
						}
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
			 * 세업무시작하기에서, 입력창에 값을 입력하여 나오는 검색결과를 선택하면 실행되는 이벤트로, 검색결과항목의 href값으로
			 * ajax를 실행하여 가져온 값으로 id가 start_work_form인 곳 화면을 그려서, 아래로 펼쳐준다.
			 */
			$('.js_select_work').swnavi({
				target : 'start_work_form',
				before : function(event) {
					$('#start_work_form').slideUp().slideDown();
				}
			});

			$('.js_select_user').live(
					'click',
					function(e) {
						var input = $(e.target);
						var userName = input.attr('uname');
						var userId = input.attr('uid');
						var target = input.parents('#start_new_event').find('.js_users');
						var oldHTML = target[0].innerHTML;
						if(oldHTML == null) oldHTML = "";
						var newHTML =  oldHTML + "<a href='user_space.sw?cid=us.sp."
								+ userId + "' >" + userName + ";</a>";
						target[0].innerHTML = newHTML;
						return false;
					});

			$('a.js_toggle_file_detail').swnavi({
				target : 'file_detail',
				before : function(event) {
					$('#file_detail').toggle();
				},
				after : function(event) {
					$(event.target).parent().hide().siblings().show();
				}
			});

			var lastCatTarget = null;
			var lastGroupTarget = null;
			$('.js_drill_down').live(
					'click',
					function(e) {
						var input = $(e.target);
						var target = input.siblings('div');
						var url = input.attr('targetContent');
						var categoryId = input[0].getAttribute("categoryId");
						var groupId = input[0].getAttribute("groupId");
						if (lastCatTarget != null && categoryId != null) {
							lastCatTarget.slideToggle();
							lastCatTarget = null;
						} else if (lastGroupTarget != null && groupId != null) {
							lastGroupTarget.slideToggle();
							lastGroupTarget = null;
						}
						if (url == 'undefined'
								|| (categoryId == null && groupId == null)) {
							return;
						}
						$.ajax({
							url : url,
							data : {
								categoryId : categoryId,
								groupId : groupId
							},
							context : input,
							success : function(data, status, jqXHR) {
								target.slideToggle();
								target.html(data);
								if (categoryId != null)
									lastCatTarget = target;
								else if (groupId != null)
									lastGroupTarget = target;
							}
						});
					});
		});