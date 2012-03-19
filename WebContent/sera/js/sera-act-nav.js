$(function() {
	
	/*
	 * 어디에서든 class 값이 js_container로 지정된 anchor 가 선택이 되면, anchor 의 href 값으로 ajax 를 호출하여
	 * 가져온 값을 container(메인컨텐트)화면에 보여준다.
	 */
	$('a.js_sera_content').swnavi({
		history : true,
		before : function(event){
			smartPop.progressCenter();				
		},
		target : 'sera_content',
		after : function(event){
			smartPop.closeProgress();
		}
	});
	
});
