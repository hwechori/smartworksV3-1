
function createFileDataFields(config){
	var options = {
			formXml : null,
			groupId : null,
			fileName : null,
			fileList : null,
			comments : null
	};

	SmartWorks.extend(options, config);
	
	var formXml = $(options.formXml);
	console.log("formXml", formXml);
	var dataFields = new Array();
	dataFields.push(SmartWorks.FormRuntime.TextInputBuilder.dataField({
		fieldName: '제목',
		formXml: formXml,
		value: options.fileName								
	}));
	dataFields.push(SmartWorks.FormRuntime.TextInputBuilder.dataField({
		fieldName: '검색어',
		formXml: formXml,
		value : options.fileName == "" ? currentUser.name : options.fileName + " " + currentUser.name
	}));
	dataFields.push(SmartWorks.FormRuntime.RefFormFieldBuilder.dataField({
		fieldName: '관리부서',
		formXml: formXml,
		refRecordId: currentUser.departmentId,
		value: currentUser.department
	}));
	dataFields.push(SmartWorks.FormRuntime.UserFieldBuilder.dataField({
		fieldName: '관리담당자',
		formXml: formXml,
		users: new Array({
			userId: currentUser.userId,
			longName: currentUser.longName
		})
	}));
	dataFields.push(SmartWorks.FormRuntime.RichEditorBuilder.dataField({
		fieldName: '내용',
		formXml: formXml,
		value : options.comments
	}));
	dataFields.push(SmartWorks.FormRuntime.FileFieldBuilder.dataField({
			fieldName: '첨부파일',
			formXml: formXml,
			groupId: options.groupId,
			isTempfile: true,
			fileList: options.fileList
	}));
	return {dataFields: dataFields};
}

function createMemoDataFields(config){
	var options = {
			formXml : null,
			contents : null
	};

	SmartWorks.extend(options, config);

	var formXml = $(options.formXml);
	console.log("formXml", formXml);
	var dataFields = new Array();
	dataFields.push(SmartWorks.FormRuntime.TextInputBuilder.dataField({
		fieldName: '제목',
		formXml: formXml,
		value: options.contents
	}));
	dataFields.push(SmartWorks.FormRuntime.RichEditorBuilder.dataField({
		fieldName: '내용',
		formXml: formXml,
		value : options.contents
	}));
	return {dataFields: dataFields};
}

function createBoardDataFields(config){
	var options = {
			formXml : null,
			groupId : null,
			fileName : null,
			fileList : null,
			title : null,
			contents : null
	};

	SmartWorks.extend(options, config);
	
	var formXml = $(options.formXml);
	console.log("formXml", formXml);
	var dataFields = new Array();
	dataFields.push(SmartWorks.FormRuntime.TextInputBuilder.dataField({
		fieldName: '제목',
		formXml: formXml,
		value: options.title
	}));
	dataFields.push(SmartWorks.FormRuntime.RichEditorBuilder.dataField({
		fieldName: '내용',
		formXml: formXml,
		value : options.contents
	}));
	dataFields.push(SmartWorks.FormRuntime.FileFieldBuilder.dataField({
			fieldName: '첨부파일',
			formXml: formXml,
			groupId: options.groupId,
			isTempfile: true,
			fileList: options.fileList
	}));
	return {dataFields: dataFields};
}

function createEventDataFields(config){
	var options = {
			formXml : null,
			name : null,
			startDate : null,
			endDate : null,
			alarmPolicy : null,
			place : null,
			relatedUsers : null,
			content : null
	};

	SmartWorks.extend(options, config);

	var formXml = $(options.formXml);
	console.log("formXml", formXml);
	var dataFields = new Array();
	dataFields.push(SmartWorks.FormRuntime.TextInputBuilder.dataField({
		fieldName: '이벤트이름',
		formXml: formXml,
		value: options.name
	}));
	dataFields.push(SmartWorks.FormRuntime.DateTimeChooserBuilder.dataField({
		fieldName: '시작일자',
		formXml: formXml,
		value: options.startDate
	}));
	dataFields.push(SmartWorks.FormRuntime.DateTimeChooserBuilder.dataField({
		fieldName: '종료일자',
		formXml: formXml,
		value: options.endDate
	}));
	dataFields.push(SmartWorks.FormRuntime.ComboBoxBuilder.dataField({
		fieldName: '미리알림',
		formXml: formXml,
		value: options.alarmPolicy
	}));
	dataFields.push(SmartWorks.FormRuntime.TextInputBuilder.dataField({
		fieldName: '장소',
		formXml: formXml,
		value: options.place
	}));
	dataFields.push(SmartWorks.FormRuntime.UserFieldBuilder.dataField({
		fieldName: '참여자',
		formXml: formXml,
		users: options.relatedUsers
	}));
	dataFields.push(SmartWorks.FormRuntime.RichEditorBuilder.dataField({
		fieldName: '이벤트내용',
		formXml: formXml,
		value : options.content
	}));
	console.log("dataFields :::: ", dataFields);
	return {dataFields: dataFields};
}
