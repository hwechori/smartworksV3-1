
function loadCheckScheduleFields() {
	var checkScheduleFields = $('div.js_check_schedule_fields');
	if(!isEmpty(checkScheduleFields)) {
		for(var i=0; i<checkScheduleFields.length; i++) {
			var checkScheduleField = $(checkScheduleFields[i]);
			
			var gridRow = SmartWorks.GridLayout.newGridRow();
			checkScheduleField.html(SmartWorks.GridLayout.newGridTable().html(gridRow));

			var startDateName = checkScheduleField.attr("startDateName");
			var endDateName = checkScheduleField.attr("endDateName");
			var performerName = checkScheduleFields.attr("performerName");
			SmartWorks.FormRuntime.DateTimeChooserBuilder.buildEx({
				container: gridRow,
				fieldId: "txtScheduleStartDate",
				fieldName: startDateName,
				columns: 3,
				required: true
			});
		  	
			SmartWorks.FormRuntime.DateTimeChooserBuilder.buildEx({
				container: gridRow,
				fieldId: "txtScheduleEndDate",
				fieldName: endDateName,
				columns: 3,
				required: true
			});
		  	
			SmartWorks.FormRuntime.UserFieldBuilder.buildEx({
				container: gridRow,
				fieldId: "txtSchedulePerformer",
				fieldName: performerName,
				columns: 3,
				multiUsers: false,
				required: true,
				users: new Array({
					userId: currentUser.userId,
					longName: currentUser.longName
				})
			});
		}		
	}
};

function loadNewEventFields() {
	var newEventFields = $('div.js_new_event_fields');
	if(!isEmpty(newEventFields)) {
		for(var i=0; i<newEventFields.length; i++) {
			var newEventField = $(newEventFields[i]);
			
			var gridRow = SmartWorks.GridLayout.newGridRow();
			var gridTable = SmartWorks.GridLayout.newGridTable();
			newEventField.html(gridTable.html(gridRow));
			
			var eventNameTitle = newEventField.attr("eventNameTitle");
			var startDateTitle = newEventField.attr("startDateTitle");
			var endDateTitle = newEventField.attr("endDateTitle");
			var placeTitle = newEventField.attr("placeTitle");
			var relatedUsersTitle = newEventField.attr("relatedUsersTitle");
			var contentTitle = newEventField.attr("contentTitle");
			SmartWorks.FormRuntime.TextInputBuilder.buildEx({
				container: gridRow,
				fieldId: "txtEventName",
				fieldName: eventNameTitle,
				columns: 1,
				multiLines: 2,
				required: true
			});
		  	
			gridRow = SmartWorks.GridLayout.newGridRow().appendTo(gridTable);
			SmartWorks.FormRuntime.DateTimeChooserBuilder.buildEx({
				container: gridRow,
				fieldId: "txtEventStartDate",
				fieldName: startDateTitle,
				columns: 2,
				required: true
			});
			SmartWorks.FormRuntime.DateTimeChooserBuilder.buildEx({
				container: gridRow,
				fieldId: "txtEventEndDate",
				fieldName: endDateTitle,
				columns: 2,
				required: false
			});
		  	
			gridRow = SmartWorks.GridLayout.newGridRow().appendTo(gridTable);
			SmartWorks.FormRuntime.TextInputBuilder.buildEx({
				container: gridRow,
				fieldId: "txtEventPlace",
				fieldName: placeTitle,
				columns: 1,
				required: false
			});

			gridRow = SmartWorks.GridLayout.newGridRow().appendTo(gridTable);
			SmartWorks.FormRuntime.UserFieldBuilder.buildEx({
				container: gridRow,
				fieldId: "txtEventRelatedUsers",
				fieldName: relatedUsersTitle,
				columns: 1,
				multiUsers: true,
				required: false
			});

			gridRow = SmartWorks.GridLayout.newGridRow().appendTo(gridTable);
			SmartWorks.FormRuntime.RichEditorBuilder.buildEx({
				container: gridRow,
				fieldId: "txtEventContent",
				fieldName: contentTitle,
				columns: 1,
				required: false
			});
		}		
	}
};

$(function() {	
});