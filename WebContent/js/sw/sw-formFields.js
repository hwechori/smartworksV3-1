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
				colSpan: 1,
				required: true
			});
		  	
			SmartWorks.FormRuntime.DateTimeChooserBuilder.buildEx({
				container: gridRow,
				fieldId: "txtScheduleEndDate",
				fieldName: endDateName,
				columns: 3,
				colSpan: 1,
				required: true
			});
		  	
			SmartWorks.FormRuntime.UserFieldBuilder.buildEx({
				container: gridRow,
				fieldId: "txtSchedulePerformer",
				fieldName: performerName,
				columns: 3,
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

			gridRow = SmartWorks.GridLayout.newGridRow().appendTo(gridTable);
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
				columns: 2,
				colSpan: 2,
				required: true
			});
		  	
			gridRow = SmartWorks.GridLayout.newGridRow().appendTo(gridTable);
			SmartWorks.FormRuntime.DateTimeChooserBuilder.buildEx({
				container: gridRow,
				fieldId: "txtEventStartDate",
				fieldName: startDateTitle,
				columns: 2,
				colSpan: 1,
				required: true
			});
			SmartWorks.FormRuntime.DateTimeChooserBuilder.buildEx({
				container: gridRow,
				fieldId: "txtEventEndDate",
				fieldName: endDateTitle,
				columns: 2,
				colSpan: 1,
				required: false
			});
		  	
			gridRow = SmartWorks.GridLayout.newGridRow().appendTo(gridTable);
			SmartWorks.FormRuntime.TextInputBuilder.buildEx({
				container: gridRow,
				fieldId: "txtEventPlace",
				fieldName: placeTitle,
				columns: 2,
				colSpan: 2,
				required: false
			});

			gridRow = SmartWorks.GridLayout.newGridRow().appendTo(gridTable);
			SmartWorks.FormRuntime.UserFieldBuilder.buildEx({
				container: gridRow,
				fieldId: "txtEventRelatedUsers",
				fieldName: relatedUsersTitle,
				columns: 2,
				colSpan: 2,
				multiUsers: true,
				required: false
			});

			gridRow = SmartWorks.GridLayout.newGridRow().appendTo(gridTable);
			SmartWorks.FormRuntime.TextInputBuilder.buildEx({
				container: gridRow,
				fieldId: "txtEventContent",
				fieldName: contentTitle,
				columns: 2,
				colSpan: 2,
				multiLines: 3,
				required: false
			});
		}		
	}
};

function loadNewMemoFields() {
	var newMemoFields = $('div.js_new_memo_fields');
	if(!isEmpty(newMemoFields)) {
		for(var i=0; i<newMemoFields.length; i++) {
			var newMemoField = $(newMemoFields[i]);
			
			var gridRow = SmartWorks.GridLayout.newGridRow();
			var gridTable = SmartWorks.GridLayout.newGridTable();
			newMemoField.html(gridTable.html(gridRow));
			
			var memoNameTitle = newMemoField.attr("memoNameTitle");
			SmartWorks.FormRuntime.TextInputBuilder.buildEx({
				container: gridRow,
				fieldId: "txtMemo",
				fieldName: memoNameTitle,
				columns: 1,
				multiLines: 2,
				required: true
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
			
			var gridRow = SmartWorks.GridLayout.newGridRow().appendTo(gridTable);
			SmartWorks.FormRuntime.TextInputBuilder.buildEx({
				container: gridRow,
				fieldId: "txtBoardDetails",
				fieldName: boardDetailsTitle,
				columns: 1,
				multiLines: 4,
				required: true
			});
			
			var gridRow = SmartWorks.GridLayout.newGridRow().appendTo(gridTable);
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
				imgSource: "images/default_group_picture.jpg",
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
			alert("jell");
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

$(function() {	
});