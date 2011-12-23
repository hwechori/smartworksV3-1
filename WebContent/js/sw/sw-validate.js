
$.validator.messages.required = "";

var showErrors = function(errorMap, errorList) {
//	if(!isEmpty(errorMap)){
		var numberOfInvalids = $('form.js_validation_required').find('.sw_error').length + this.numberOfInvalids();
		if(numberOfInvalids>0){
			$("#error_message_span").html("입력한 내용중에 " + numberOfInvalids + "개 항목이 입력되지 않았습니다. 위의 붉은색으로 선택된 항목(들)을 입력바랍니다.");
		}else{
			$("#error_message_span").html("");
		}
		this.defaultShowErrors();
		console.log('jquery-validation = '+ numberOfInvalids);
//	}else{
//		var numberOfInvalids = $('form.js_validation_required').find('.sw_error').length;
//		if(numberOfInvalids>0){
//			$("#error_message_span").html("입력한 내용중에 " + numberOfInvalids + "개 항목이 입력되지 않았습니다. 위의 붉은색으로 선택된 항목(들)을 입력바랍니다.");
//		}else{
//			$("#error_message_span").html("");
//		}
//		console.log('sw-valiation = ', $("#error_message_span"));
//	}
};
