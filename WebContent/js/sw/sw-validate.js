
$.validator.messages.required = "";

$.validator.addMethod('positiveNumber',
	    function (value) { 
	        return Number(value) > 0;
	    }, '0보다 큰숫자를 입력바랍니다.');

var showErrors = function(errorMap, errorList) {
	if(!isEmpty(errorMap)){
		this.noOfErrors = $('form.js_validation_required').find('.sw_required.sw_error').length + $('form.js_validation_required').find('.required.error').length;
		if(this.noOfErrors>0){
			$("#error_message_span").html("입력한 내용중에 " + this.noOfErrors + "개 항목이 입력되지 않았습니다. 위의 붉은색으로 선택된 항목(들)을 입력바랍니다.");
		}else{
			$("#error_message_span").html("");
		}
		this.defaultShowErrors();
	}else{
		this.noOfErrors = $('form.js_validation_required').find('.sw_required.sw_error').length + $('form.js_validation_required').find('.required.error').length;
		if(this.noOfErrors>0){
			$("#error_message_span").html("입력한 내용중에 " + this.noOfErrors + "개 항목이 입력되지 않았습니다. 위의 붉은색으로 선택된 항목(들)을 입력바랍니다.");
		}else{
			$("#error_message_span").html("");
		}
	}
};
