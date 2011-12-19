
$.validator.messages.required = "";

var showErrors = function(errorMap, errorList) {
	var numberOfInvalids = $('form.js_validation_required').find('.sw_error').length + this.numberOfInvalids();
	if(numberOfInvalids>0){
		$("#error_message_span").html("입력한 내용중에 " + numberOfInvalids + "개 항목이 입력되지 않았습니다. 위의 붉은색으로 선택된 항목(들)을 입력바랍니다.");
	}else{
		$("#error_message_span").html("");
	}
	this.defaultShowErrors();	
};
