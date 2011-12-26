
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