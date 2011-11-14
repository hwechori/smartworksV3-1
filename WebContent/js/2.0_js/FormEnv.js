var FormEnv = {
	serviceUrl: '../',
	userId: null,
	comBoMode : null,
	comBoBeforeIndex : '',
	loadDataComplete : true,
	//textEditorPath: getPath() + "/FCKedit/",
	//textEditorPath: getPath() + "/component/fckeditor/",
	
	dateChooserIcon: getPath() + "/component/form/image/format/dateChooser.gif",
	formRefIcon: getPath() + "/component/form/image/format/formRef.gif",
	userRefIcon: getPath() + "/image/form/btn_mems.gif",
	
	addTableRowIcon: getPath() + "/images/common/ibt_add.gif",
	removeTableRowsIcon: getPath() + "/images/common/ibt_delete.gif",
	url : '',
	params : '',
	getControlConfig: function(type) {
		return MisFormControlConfig[type];
	}
};

/**
 * 반드시 Flex의 폼타입과 값이 일치하도록 관리
 */
var MisFormControlConfig = {
	textInput: {labelWidth: 80, contentWidth: 190, height: 25, weight: 1},
	numberInput: {labelWidth: 80, contentWidth: 190, height: 25, weight: 1},
	richEditor: {labelWidth: 80, contentWidth: 500, height: 250, weight: 1},
	comboBox: {labelWidth: 80, contentWidth: 190, height: 25, weight: 1},
	dateChooser: {labelWidth: 80, contentWidth: 130, height: 25, weight: 1},
	timeField: {labelWidth: 80, contentWidth: 130, height: 25, weight: 1},
	userField: {labelWidth: 80, contentWidth: 130, height: 25, weight: 1},
	fileField: {labelWidth: 80, contentWidth: 275, height: 110, weight: 1},
	refFormField: {labelWidth: 80, contentWidth: 190, height: 25, weight: 1},
	currencyInput: {labelWidth: 80, contentWidth: 190, height: 25, weight: 1},
	percentInput: {labelWidth: 80, contentWidth: 100, height: 25, weight: 1},
	checkBox: {labelWidth: 80, contentWidth: 65, height: 25, weight: 1},
	radioButton: {labelWidth: 80, contentWidth: 220, height: 25, weight: 2},
	dataGrid: {labelWidth: 80, contentWidth: 440, height: 110, weight: 2},
	numericStepper: {labelWidth: 80, contentWidth: 65, height: 25, weight: 1},
	textArea: {labelWidth: 80, contentWidth: 440, height: 110, weight: 1},
	list: {labelWidth: 80, contentWidth: 155, height: 110, weight: 2}
};

//Event.addBehavior.reassignAfterAjax = true;