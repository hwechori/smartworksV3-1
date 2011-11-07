var resizeTable = new Array();
FormGridLayout = function(formXml, formFieldsDiv, formRuntime, layoutXml){
	this.layoutXml = layoutXml;
	this.formRuntime = formRuntime;
	
	this.formFieldsTable = document.createElement("table");
	var formFieldsTable = this.formFieldsTable;
	//jk this.workspaceId 를 this.formRuntime.workspaceId로 변경.
	formFieldsTable.id = this.formRuntime.workspaceId + "_formFieldsTable";
	
	resizeTable.push(this.formRuntime.workspaceId + "_formFieldsTable");
	
	formFieldsTable.border = '0';
	formFieldsTable.cellPadding = "0";
	formFieldsTable.cellSpacing = "1";
	
	//formFieldsTable.style.width = formFieldsDiv.offsetWidth;
	formFieldsTable.style.width = '100%';
	/*
	window.onresize = function(){
		try{
			formFieldsTable.style.width = '600px';
			formFieldsTable.style.width = formFieldsDiv.offsetWidth;
			
			//Element.setStyle(formFieldsTable, {width:'600px'});
			//Element.setStyle(formFieldsTable, {width:formFieldsDiv.offsetWidth});	
			for(var i = 0 ; i < resizeTable.length; i++){
				var table = $(resizeTable[i]);
				if(formFieldsDiv.offsetWidth != table.style.width){
					table.style.width = '600px';
					table.style.width = formFieldsDiv.offsetWidth;
				}
			}
		}catch(e){}
	};
	 * */
	
	//jk 삭제.;
	//Element.setStyle(formFieldsTable, {width: '100%',wordWrap:'break-word', wordBreak:'break-all', textOverflow:'ellipsis'});
	//Element.setStyle(formFieldsTable, { });
	
	Element.addClassName(formFieldsTable, "formFieldsTable");
	formFieldsDiv.appendChild(formFieldsTable);
	
	var colLen = MisFormUtil.getMaxColumnLength(layoutXml);
	
	
	var gridHeaderColsXml = SmartXMLUtil.getChildNode(layoutXml, "columns");
	var gridHeaderColXml = SmartXMLUtil.getChildNodes(gridHeaderColsXml, "gridColumn");
	var gridRowsXmls = SmartXMLUtil.getChildNodes(layoutXml, "gridRow");
	var ratio = 1.05;
	for (var i=0; i<gridRowsXmls.length; i++) {
			
		formFieldsRow = formFieldsTable.insertRow(-1);
		// jkyoon 수정 -7 에서 -15
		formFieldsRow.height = gridRowsXmls[i].getAttribute("size") - 10;
		formFieldsRow.id = 'formFieldsRow_'+i;

		var gridColsXml = SmartXMLUtil.getChildNodes(gridRowsXmls[i], "gridCell");
		for (var j=0; j<gridColsXml.length; j++) {
			var colWidth = 0;
			var gridColSpan = parseInt(gridColsXml[j].getAttribute("span"));
			var gridRowSpan = parseInt(gridColsXml[j].getAttribute("rowSpan"));
			if (gridHeaderColXml.length == 0) {
				colWidth = gridColsXml[j].getAttribute("size");
			} else {
				for(var k = 0 ; k < gridColSpan && (j+k) < gridHeaderColXml.length ; k++){
					colWidth += parseFloat(gridHeaderColXml[j + k].getAttribute("size"));
				}
			}
			
			var fieldId = gridColsXml[j].getAttribute("fieldId");
			if (fieldId != null && fieldId != "") {
				var targetFormEntity= MisFormUtil.getField(SmartXMLUtil.getChildNode(formXml, 'form'), fieldId);
				formRuntime.createField(targetFormEntity, formFieldsRow, gridColSpan, colWidth, gridRowsXmls[i].getAttribute("size") - 10, ratio, gridRowSpan);
			} else {
				var formFieldsCol = formFieldsRow.insertCell(-1);
				formFieldsCol.colSpan = gridColSpan || '1';
				formFieldsCol.rowSpan = gridRowSpan || '1';			
				if (colWidth > 0){
					formFieldsCol.width = colWidth;
				}
				Element.addClassName(formFieldsCol, "formFieldContents");				
				Element.addClassName(formFieldsCol, "formFieldsTableTd");
				formFieldsCol.update("&nbsp;");
			}
		}
	}
	
	
	//Element.setStyle(formFieldsDiv, {width : '100%', height : Element.getHeight(formFieldsTable) + 'px'});
	
	this.getData = function(formXml, recordXml){
		var gridRowsXml = SmartXMLUtil.getChildNodes(this.layoutXml, "gridRow");
		for (var i=0; i<gridRowsXml.length; i++) {
			var gridColsXml = SmartXMLUtil.getChildNodes(gridRowsXml[i], "gridCell");
			for (var j=0; j<gridColsXml.length; j++) {
				var fieldId = gridColsXml[j].getAttribute("fieldId");
				if (fieldId != null && fieldId != "") {
					var targetFormEntity= MisFormUtil.getField(SmartXMLUtil.getChildNode(formXml, 'form'), fieldId);
					try {
						this.formRuntime.getFieldData(targetFormEntity, recordXml);
					} catch(e) {
					}
				}
			}
		}
		recordXml.setAttribute('formId', (SmartXMLUtil.getChildNode(formXml, 'form')).getAttribute('id'));
		return recordXml;
	};
	this.loadData = function(formXml, recordXml){
		var rows = SmartXMLUtil.getChildNodes(this.layoutXml, "gridRow");

		for (var i=0; i<rows.length; i++) {
			var cols = SmartXMLUtil.getChildNodes(rows[i], "gridCell");
			for (var j=0; j<cols.length; j++) {
				var fieldId = cols[j].getAttribute("fieldId");
				if(fieldId != null && fieldId != ""){
					var fieldXml= MisFormUtil.getField(SmartXMLUtil.getChildNode(formXml, 'form'), fieldId);
					try {
						this.formRuntime.loadFieldData(fieldXml, recordXml);
					} catch(e) {
					}
				}
			}
		}
		
		var formFieldsTables = $(this.formRuntime.workspaceId + "_formFieldsTable");
		//var formFieldsDiv = $(this.formRuntime.workspaceId + "_formFieldsSpace");		
		var formMainSpace = $(this.formRuntime.workspaceId + "_mainSpace");
		var formDocSpace = $(this.formRuntime.workspaceId + '_docSpace');		

		//Element.setStyle(formFieldsDiv, {width : '100%', height : this.formFieldsTable.getHeight() + 'px'});
		
		/*
		if (!Mis.isNull(formMainSpace))
			Element.setStyle(formMainSpace, {width: '100%', height: Element.getHeight(formFieldsDiv) + 'px'});
		 * */
		if (!Mis.isNull(formDocSpace))
			Element.setStyle(formDocSpace, {height: (Element.getHeight(formMainSpace)) + 'px'});
		// jk cell 관련.
		if(FormEnv.loadDataComplete){
			var idxx = new Array();
			var flag = false;
			for (var i=0; i<rows.length; i++) {
				var gridColsXml = SmartXMLUtil.getChildNodes(rows[i], "gridCell");
				for (var jj=0; jj<gridColsXml.length; jj++) {
						var fieldIds = gridColsXml[jj].getAttribute("fieldId");
						if (fieldIds != null && fieldIds != "") {
							var targetFormEntity= MisFormUtil.getField(SmartXMLUtil.getChildNode(formXml, 'form'), fieldIds);
							var mainId = formRuntime.generateFieldIdByXml(targetFormEntity);
							innerTdHeight = $(mainId+'_innerTd').offsetHeight;
							var formatXml = SmartXMLUtil.getChildNode(targetFormEntity, 'format');
							var formatType = formatXml.getAttribute('type');
							if(formatType != 'dataGrid'){
								$(mainId+'_label').setAttribute('style','word-wrap: break-word;height:'+(innerTdHeight-1)+'px;');
							}else if(formatType == 'richEditor'){
								flag = true;
								idxx.push(i);
							}
						}
				}
			}
			//jk
			if(flag){
				for(var idxx2 = 0 ; idxx2 < idxx.length; idxx2++){
					var gridColsXml2 = SmartXMLUtil.getChildNodes(rows[idxx2], "gridCell");
					for (var jj=0; jj<gridColsXml2.length; jj++) {
						var fieldIds2 = gridColsXml2[jj].getAttribute("fieldId");
						if (fieldIds2 != null && fieldIds2 != "") {
							var targetFormEntity2= MisFormUtil.getField(SmartXMLUtil.getChildNode(formXml, 'form'), fieldIds2);
							var mainId2 = formRuntime.generateFieldIdByXml(targetFormEntity2);
							innerTdHeight2 = $(mainId2+'_innerTd').offsetHeight;
							var formatXml2 = SmartXMLUtil.getChildNode(targetFormEntity2, 'format');
							var formatType2 = formatXml2.getAttribute('type');
							if(formatType2 != 'dataGrid' && formatType != 'richEditor'){
								$(mainId2+'_label').setAttribute('style','word-wrap: break-word;height:23px;');
							}
						}
					}
				}
				flag = false;
			}
		}
		//jk 
			try{formDocSpace.style.height = formFieldsTable.offsetHeight +'px';}catch(e){}
			FormEnv.loadDataComplete = false;
	};
	
	this.validate = function(){
		var msg = '';
		var unvalidField = new Array();
		var result = true;
		var gridRowsXml = SmartXMLUtil.getChildNodes(this.layoutXml, "gridRow");
		for(var i = 0 ; i < gridRowsXml.length ; i++){
			var gridColsXml = SmartXMLUtil.getChildNodes(gridRowsXml[i], "gridCell");
			for(var j = 0 ; j < gridColsXml.length ; j++){
				var fieldId = gridColsXml[j].getAttribute("fieldId");
				if(fieldId != null && fieldId != ""){
					var targetFormEntity= MisFormUtil.getField(SmartXMLUtil.getChildNode(formXml, 'form'), fieldId);
					if('true' == targetFormEntity.getAttribute('required')){
						var fieldData = this.formRuntime.getFieldDataStr(targetFormEntity);
						if(fieldData['name'] == null || fieldData['name'] == '' || fieldData['name'] == '<br>' ){
							//fieldData['name'] == '<br>' For FF SmartEditor
							result = false;
							unvalidField.push(targetFormEntity.getAttribute('name'));
						}
					}
				}
			}
		}
		return {result : result, unvalidField : unvalidField};
	};
};