$.validation.addRule(
		"test",{
			check: function(value) {
				if(value != "test") {
					return false;
				}
				return true;
			},
			msg : "Must equal to the word test."
		});

$(function() {
	$('form.js_validation_required').validate({
		rules: {
			chkScheduleWork: "required",
		},
		messages: {
			chkScheduleWork: "예정시작시간을 선택하세요!!"}
	});
});