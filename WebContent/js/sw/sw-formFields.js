function loadMyProfileField() {
	var myProfileFields = $('div.js_my_profile_field');
	if(!isEmpty(myProfileFields)) {
		for(var i=0; i<myProfileFields.length; i++) {
			var myProfileField = $(myProfileFields[i]);
			
			var gridRow = SmartWorks.GridLayout.newGridRow();
			var gridTable = SmartWorks.GridLayout.newGridTable();
			myProfileField.html(gridTable.html(gridRow));

			SmartWorks.FormRuntime.ImageBoxBuilder.buildEx({
				container: gridRow,
				fieldId: "imgMyProfile",
				fieldName: "picture profile",
				imgSource: currentUser.orgPicture,
				pictureWidth: 110,
				pictureHeight: 110,
				required: false
			});
		}		
	}
};

function loadCompanyLogoField() {
	var companyLogoFields = $('div.js_company_logo_field');
	if(!isEmpty(companyLogoFields)) {
		for(var i=0; i<companyLogoFields.length; i++) {
			var companyLogoField = $(companyLogoFields[i]);
			
			var imgSource = companyLogoField.attr('imgSource');
			var gridRow = SmartWorks.GridLayout.newGridRow();
			var gridTable = SmartWorks.GridLayout.newGridTable();
			companyLogoField.html(gridTable.html(gridRow));

			SmartWorks.FormRuntime.ImageBoxBuilder.buildEx({
				container: gridRow,
				fieldId: "imgCompanyLogo",
				fieldName: "picture profile",
				imgSource: imgSource,
				columns: 1,
				pictureWidth: 130,
				pictureHeight: 35,
				required: false
			});
		}		
	}
};

function loadCheckScheduleFields() {
	var checkScheduleFields = $('div.js_check_schedule_fields');
	if(!isEmpty(checkScheduleFields)) {
		for(var i=0; i<checkScheduleFields.length; i++) {
			var checkScheduleField = $(checkScheduleFields[i]);
			
			var gridRow = SmartWorks.GridLayout.newGridRow();
			var gridTable = SmartWorks.GridLayout.newGridTable();
			checkScheduleField.html(gridTable.html(gridRow));

			var startDateName = checkScheduleField.attr("startDateName");
			var endDateName = checkScheduleField.attr("endDateName");
			var performerName = checkScheduleFields.attr("performerName");
			SmartWorks.FormRuntime.DateTimeChooserBuilder.buildEx({
				container: gridRow,
				fieldId: "txtScheduleStartDate",
				fieldName: startDateName,
				columns: 2,
				colSpan: 1,
				required: true
			});
		  	
			SmartWorks.FormRuntime.DateTimeChooserBuilder.buildEx({
				container: gridRow,
				fieldId: "txtScheduleEndDate",
				fieldName: endDateName,
				columns: 2,
				colSpan: 1,
				required: true
			});
		  	
			gridRow = SmartWorks.GridLayout.newGridRow().appendTo(gridTable);
			SmartWorks.FormRuntime.UserFieldBuilder.buildEx({
				container: gridRow,
				fieldId: "txtSchedulePerformer",
				fieldName: performerName,
				columns: 2,
				colSpan: 1,
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

function loadNewPictureFields() {
	var newPictureFields = $('div.js_new_picture_fields');
	if(!isEmpty(newPictureFields)) {
		for(var i=0; i<newPictureFields.length; i++) {
			var newPictureField = $(newPictureFields[i]);
			var gridRow = SmartWorks.GridLayout.newGridRow();
			var gridTable = SmartWorks.GridLayout.newGridTable();
			newPictureField.html(gridTable.html(gridRow));
			
			var pictureDescTitle = newPictureField.attr("pictureDescTitle");

			SmartWorks.FormRuntime.ImageBoxBuilder.buildEx({
				container: gridRow,
				fieldId: "imgPictureFile",
				fieldName: "picture profile",
				columns: 1,
				pictureWidth: 512,
				required: true
			});

			gridRow = SmartWorks.GridLayout.newGridRow().appendTo(gridTable);
			gridRow.hide();
			SmartWorks.FormRuntime.TextInputBuilder.buildEx({
				container: gridRow,
				fieldId: "txtPictureDesc",
				fieldName: pictureDescTitle,
				columns: 1,
				multiLines: 2,
				required: false
			});
		}		
	}
};

function loadNewFileFields() {
	var newFileFields = $('div.js_new_file_fields');
	if(!isEmpty(newFileFields)) {
		for(var i=0; i<newFileFields.length; i++) {
			var newFileField = $(newFileFields[i]);
			var gridRow = SmartWorks.GridLayout.newGridRow();
			var gridTable = SmartWorks.GridLayout.newGridTable();
			newFileField.html(gridTable.html(gridRow));
			
			var fileNameTitle = newFileField.attr("fileNameTitle");
			var fileDescTitle = newFileField.attr("fileDescTitle");

			SmartWorks.FormRuntime.FileFieldBuilder.buildEx({
				container: gridRow,
				fieldId: "txtFileField",
				fieldName: fileNameTitle,
				columns: 1,
				required: true
			});
			gridRow.find('.form_label').hide();
			
			gridRow = SmartWorks.GridLayout.newGridRow().appendTo(gridTable);
			gridRow.hide();
			SmartWorks.FormRuntime.TextInputBuilder.buildEx({
				container: gridRow,
				fieldId: "txtFileDesc",
				fieldName: fileDescTitle,
				columns: 1,
				multiLines: 2,
				required: false
			});
		}		
	}
};

function loadNewEventFields(startDate, endDate) {
	var newEventFields = $('div.js_new_event_fields');
	if(!isEmpty(newEventFields)) {
		for(var i=0; i<newEventFields.length; i++) {
			var newEventField = $(newEventFields[i]);
			var gridRow = SmartWorks.GridLayout.newGridRow();
			var gridTable = SmartWorks.GridLayout.newGridTable();
			newEventField.html(gridTable.html(gridRow));
			
			var placeHolderTitle = newEventField.attr("placeHolderTitle");
			var eventNameTitle = newEventField.attr("eventNameTitle");
			var startDateTitle = newEventField.attr("startDateTitle");
			var endDateTitle = newEventField.attr("endDateTitle");
			var alarmPolicyTitle = newEventField.attr("alarmPolicyTitle");
			var placeTitle = newEventField.attr("placeTitle");
			var relatedUsersTitle = newEventField.attr("relatedUsersTitle");
			var contentTitle = newEventField.attr("contentTitle");
			SmartWorks.FormRuntime.TextInputBuilder.buildEx({
				container: gridRow,
				fieldId: "txtEventName",
				fieldName: eventNameTitle,
				columns: 3,
				colSpan: 3,
				required: true
			});
			gridRow.find('.form_label').hide();
			gridRow.find('.form_value input').removeClass('fieldline').attr('placeholder', placeHolderTitle);
			var startDateStr = "";
			if(isEmpty(startDate)){
				var today = new Date();
				startDate = new Date(today.getTime() - today.getHours()*60*60*1000 - today.getMinutes()*60*1000);
			}
			startDateStr = startDate.format('yyyy.mm.dd hh:MM');
			gridRow = SmartWorks.GridLayout.newGridRow().appendTo(gridTable);
			gridRow.hide();
			SmartWorks.FormRuntime.DateTimeChooserBuilder.buildEx({
				container: gridRow,
				fieldId: "txtEventStartDate",
				fieldName: startDateTitle,
				value: startDateStr,
				columns: 3,
				colSpan: 1,
				required: true
			});

			var endDateStr = "";
			if(!isEmpty(endDate))
				endDateStr = endDate.format('yyyy.mm.dd hh:MM');
			SmartWorks.FormRuntime.DateTimeChooserBuilder.buildEx({
				container: gridRow,
				fieldId: "txtEventEndDate",
				fieldName: endDateTitle,
				value: endDateStr,
				columns: 3,
				colSpan: 1,
				required: false
			});
			
			var staticItems = new Array();
			staticItems.push(smartMessage.get("alarmPolicyNone"));
			staticItems.push(smartMessage.get("alarmPolicyOnTime"));
			staticItems.push(smartMessage.get("alarmPolicy5m"));
			staticItems.push(smartMessage.get("alarmPolicy10m"));
			staticItems.push(smartMessage.get("alarmPolicy15m"));
			staticItems.push(smartMessage.get("alarmPolicy30m"));
			staticItems.push(smartMessage.get("alarmPolicy1h"));
			staticItems.push(smartMessage.get("alarmPolicy1d"));
			SmartWorks.FormRuntime.ComboBoxBuilder.buildEx({
				container: gridRow,
				fieldId: "selEventAlarmPolicy",
				fieldName: alarmPolicyTitle,
				columns: 3,
				colSpan: 1,
				staticItems : staticItems,
				required: false
			});
		  	
			gridRow = SmartWorks.GridLayout.newGridRow().appendTo(gridTable);
			gridRow.hide();
			SmartWorks.FormRuntime.TextInputBuilder.buildEx({
				container: gridRow,
				fieldId: "txtEventPlace",
				fieldName: placeTitle,
				columns: 3,
				colSpan: 3,
				required: false
			});

			gridRow = SmartWorks.GridLayout.newGridRow().appendTo(gridTable);
			gridRow.hide();
			SmartWorks.FormRuntime.UserFieldBuilder.buildEx({
				container: gridRow,
				fieldId: "txtEventRelatedUsers",
				fieldName: relatedUsersTitle,
				columns: 3,
				colSpan: 3,
				multiUsers: true,
				required: false
			});

			gridRow = SmartWorks.GridLayout.newGridRow().appendTo(gridTable);
			gridRow.hide();
			SmartWorks.FormRuntime.TextInputBuilder.buildEx({
				container: gridRow,
				fieldId: "txtEventContent",
				fieldName: contentTitle,
				columns: 3,
				colSpan: 3,
				multiLines: 3,
				required: false
			});
		}		
	}
};

function loadNewBoardFields() {
	var newBoardFields = $('div.js_new_board_fields');
	if(!isEmpty(newBoardFields)) {
		for(var i=0; i<newBoardFields.length; i++) {
			var newBoardField = $(newBoardFields[i]);
			var gridRow = SmartWorks.GridLayout.newGridRow();
			var gridTable = SmartWorks.GridLayout.newGridTable();
			newBoardField.html(gridTable.html(gridRow));
			
			var placeHolderTitle = newBoardField.attr("placeHolderTitle");
			var boardNameTitle = newBoardField.attr("boardNameTitle");
			var boardDetailsTitle = newBoardField.attr("boardDetailsTitle");
			var boardFilesTitle = newBoardField.attr("boardFilesTitle");

			SmartWorks.FormRuntime.TextInputBuilder.buildEx({
				container: gridRow,
				fieldId: "txtBoardName",
				fieldName: boardNameTitle,
				columns: 1,
				required: true
			});
			gridRow.find('.form_label').hide();
			gridRow.find('.form_value input').removeClass('fieldline').attr('placeholder', placeHolderTitle);
			
			var gridRow = SmartWorks.GridLayout.newGridRow().appendTo(gridTable);
			gridRow.hide();
			SmartWorks.FormRuntime.TextInputBuilder.buildEx({
				container: gridRow,
				fieldId: "txtBoardDetails",
				fieldName: boardDetailsTitle,
				columns: 1,
				multiLines: 4,
				required: true
			});
			
			var gridRow = SmartWorks.GridLayout.newGridRow().appendTo(gridTable);
			gridRow.hide();
			SmartWorks.FormRuntime.FileFieldBuilder.buildEx({
				container: gridRow,
				fieldId: "txtBoardFiles",
				fieldName: boardFilesTitle,
				columns: 1,
				required: false
			});
		}		
	}
};

function loadTaskForwardFields() {
	var taskForwardFields = $('div.js_task_forward_fields');
	if(!isEmpty(taskForwardFields)) {
		for(var i=0; i<taskForwardFields.length; i++) {
			var taskForwardField = $(taskForwardFields[i]);
			
			var gridRow = SmartWorks.GridLayout.newGridRow();
			var gridTable = SmartWorks.GridLayout.newGridTable();
			taskForwardField.html(gridTable.html(gridRow));
			
			var subjectTitle = taskForwardField.attr("subjectTitle");
			var forwardeeTitle = taskForwardField.attr("forwardeeTitle");
			var commentsTitle = taskForwardField.attr("commentsTitle");

			SmartWorks.FormRuntime.TextInputBuilder.buildEx({
				container: gridRow,
				fieldId: "txtForwardSubject",
				fieldName: subjectTitle,
				columns: 1,
				required: true
			});
			
			gridRow = SmartWorks.GridLayout.newGridRow().appendTo(gridTable);
			SmartWorks.FormRuntime.UserFieldBuilder.buildEx({
				container: gridRow,
				fieldId: "txtForwardForwardee",
				fieldName: forwardeeTitle,
				columns: 1,
				multiUsers: true,
				required: true
			});

			var gridRow = SmartWorks.GridLayout.newGridRow().appendTo(gridTable);
			SmartWorks.FormRuntime.TextInputBuilder.buildEx({
				container: gridRow,
				fieldId: "txtForwardComments",
				fieldName: commentsTitle,
				columns: 1,
				multiLines: 4,
				required: false
			});
		}		
	}
};

function loadGroupProfileField() {
	var groupProfileFields = $('div.js_group_profile_field');
	if(!isEmpty(groupProfileFields)) {
		for(var i=0; i<groupProfileFields.length; i++) {
			var groupProfileField = $(groupProfileFields[i]);
			
			var gridRow = SmartWorks.GridLayout.newGridRow();
			var gridTable = SmartWorks.GridLayout.newGridTable();
			groupProfileField.html(gridTable.html(gridRow));

			SmartWorks.FormRuntime.ImageBoxBuilder.buildEx({
				container: gridRow,
				fieldId: "imgGroupProfile",
				fieldName: "group profile",
				imgSource: "images/default_group_picture.gif",
				pictureWidth: 110,
				pictureHeight: 110,
				required: false
			});
			console.log("groupProfileField=", groupProfileField);
		}		
	}
};

function loadNewGroupFields() {
	var newGroupFields = $('div.js_new_group_fields');
	if(!isEmpty(newGroupFields)) {
		for(var i=0; i<newGroupFields.length; i++) {
			var newGroupField = $(newGroupFields[i]);
			var gridRow = SmartWorks.GridLayout.newGridRow();
			var gridTable = SmartWorks.GridLayout.newGridTable();
			newGroupField.html(gridTable.html(gridRow));
			var groupMembersTitle = newGroupField.attr("groupMembersTitle");

			SmartWorks.FormRuntime.UserFieldBuilder.buildEx({
				container: gridRow,
				fieldId: "txtGroupMembers",
				fieldName: groupMembersTitle,
				columns: 2,
				colSpan: 1,
				multiUsers: true,
				required: false
			});
			console.log('newGroupField=', newGroupField);			
		}		
	}
};
