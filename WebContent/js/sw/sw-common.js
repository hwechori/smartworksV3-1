
smartCommon= {
	
	liveTodayTimePicker : function(){
		$.datepicker.setDefaults($.datepicker.regional[currentUser.locale]);
		$.timepicker.setDefaults($.timepicker.regional[currentUser.locale]);
		$('input.js_todaytimepicker').datetimepicker({
			defaultDate : new Date(),
			dateFormat : 'yy.mm.dd',
			timeFormat : 'hh:mm',
			hourGrid: 4,
			minuteGrid: 10,
			onSelect: function(date) {
				$(this).change();
				if(!isEmpty($('form.js_validation_required').find('.error'))){
					$('form.js_validation_required').validate({ showErrors: showErrors}).form();
				}
		    }
		});
	},
	
	liveTodayPicker : function(){
		$.datepicker.setDefaults($.datepicker.regional[currentUser.locale]);
		$('input.js_todaypicker').datepicker({
			defaultDate : new Date(),
			dateFormat : 'yy.mm.dd',
			onSelect: function(date) {
				$(this).change();
				if(!isEmpty($('form.js_validation_required').find('.error'))){
					$('form.js_validation_required').validate({ showErrors: showErrors}).form();
				}
		    }
		});
	},
	
	liveTimePicker : function(){
		$.timepicker.setDefaults($.timepicker.regional[currentUser.locale]);
		$('input.js_timepicker').timepicker({
			timeFormat: 'hh:mm',
			hourGrid: 4,
			minuteGrid: 10,
			onSelect: function(date) {
				$(this).change();
				if(!isEmpty($('form.js_validation_required').find('.error'))){
					$('form.js_validation_required').validate({ showErrors: showErrors}).form();
				}
		    }
		});
	}

};