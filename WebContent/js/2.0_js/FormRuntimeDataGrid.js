FormRuntimeDataGrid = function (formRuntime, gridField, contentDiv, edit, rowCnt) {
	rowCnt = rowCnt > 0 ? rowCnt : 1;
	
	var workspaceId = formRuntime.generateFieldIdByXml(gridField);
	var fields = SmartXMLUtil.getChildNodes(SmartXMLUtil.getChildNode(gridField, "children"), "formEntity");
	
	var graphic = SmartXMLUtil.getChildNode(gridField, "graphic");
	var fitWidth = Mis.toBoolean(graphic.getAttribute("fitWidth"), false);
	var verticalScroll = Mis.toBoolean(graphic.getAttribute("verticalScrollPolicy"), true);
	
	var html = "";
	
	var editTdWidth = 40;
	if (fields != null && fields.length > 0) {
		var width = null;
		var tableWidth = 0;
		var scale = 1;
		if (fitWidth) {
			width = "100%";
			for (var j=0; j<fields.length; j++) {
				var tmpSize = MisFormUtil.getFieldContentWidth(fields[j]);
					tableWidth += parseFloat(tmpSize);
			}
			if (tableWidth > 0) {
				var realTableWidth = 700;
				if (edit)
					realTableWidth = realTableWidth - editTdWidth;
				scale = realTableWidth / tableWidth;
				tableWidth = 0;
			}
		} else {
			for (var j=0; j<fields.length; j++) {
				var tmpSize = MisFormUtil.getFieldContentWidth(fields[j]);
					tableWidth += parseFloat(tmpSize);
			}
				
			if (edit)
				tableWidth += editTdWidth;
			
			width = tableWidth + "px";
		}
		//jk width 를 임의로 설정
		width = '100%';
		html += "<table id=\""+workspaceId + "_DataGrid"+"\" cellspacing=\"1px\" style=\"width: " + width + ";\" class=\"tableCtrlTable\">";
		
		// 테이블 헤더
		html += "<thead>";
		html +=	"<tr class=\"tableCtrlTitleTr\" style=\"position: relative; top: expression(this.offsetParent.scrollTop);\">";
		if (edit) {
			html += "<td align=\"center\" width=\"" + editTdWidth + "px\" class=\"tableCtrlTitleTd\">";
			html +=	"<div style=\"display: none;\"><textarea id=\"" + workspaceId + "_DataGrid_formEntityXml\">" + SmartXMLUtil.getXMLString(gridField) + "</textarea></div>";
			html +=	"<img style=\"cursor:pointer;\" src=\"" + FormEnv.addTableRowIcon + "\" title=\"행추가\" onclick=\"new FormRuntimeDataGridAddRow('" + workspaceId + "_DataGrid', SmartXMLUtil.getXML($('" + workspaceId + "_DataGrid_formEntityXml').value));\">";
			html += "<img style=\"cursor:pointer;\" src=\"" + FormEnv.removeTableRowsIcon + "\" title=\"행삭제\" onclick=\"MisFormUtil.removeTableRows('" + workspaceId + "_DataGrid')\">";
			html += "</td>";
		}
		for (var i=0; i<fields.length; i++) {
			var name = fields[i].getAttribute('name');
			var formatType = (SmartXMLUtil.getChildNode(fields[i], 'format')).getAttribute('type');
			var contentWidth = MisFormUtil.getFieldContentWidth(fields[i]) * scale;
			
			html += "<td width=\""+ contentWidth + "px\" class=\"tableCtrlTitleTd\">"+name+"</td>";
		}
		html += "</tr>";
		html += "</thead>";
		
		// 테이블 바디
		html += "<tbody>";
		
		//data row 만들기
		for (var k=0; k<rowCnt; k++) {
			if (edit) {
				html += "<tr class=\"tableCtrlRecordTr\">";
			} else {
				html += "<tr class=\"tableCtrlRecordTr2\">";
			}
			if (edit)
				html += "<td align=\"center\" class=\"tableCtrlRecordTd\"><input type=\"checkbox\" style=\"border: none;\"></td>";
			
			for (var r=0 ; r<fields.length; r++) {
				var formatType = (SmartXMLUtil.getChildNode(fields[r], 'format')).getAttribute('type');
				var subContentSize = MisFormUtil.getFieldContentWidth(fields[r]) * scale;
				
				var formatXml = SmartXMLUtil.getChildNode(fields[r], 'format');
				var graphicXml = SmartXMLUtil.getChildNode(fields[r], 'graphic');
				var fieldId = fields[r].getAttribute('id');
//				var align = Mis.toDefault(graphicXml.getAttribute("textAlign"), "left");
				var align = "left";
				var id = formRuntime.generateFieldIdByXml(fields[r]);
				var rowId = id + "_" + k;
				
				var hiddenStyleOption = "";
				if(graphicXml != null){
					if(subContentSize == 0 || graphicXml.getAttribute('hidden') == 'true'){
						hiddenStyleOption = "display:none;visibility:hidden;";
					}
				}

				if (edit) {
					switch (formatType) {
						case 'comboBox':
							html += "<td align=\""+align+"\" class=\"tableCtrlRecordTd\">";
							html += "<div id=\"" + rowId + "Combo\" name=\"" + id + "Combo\">";
							html += "<select id=\"" + rowId + "_input\" name=\"" + id + "_input\"";
							html += " class=\"formComboBoxField tableCtrlTextInput numberFieldInput\" style=\"width: 100%;" + hiddenStyleOption + "\" fieldId='" + fieldId + "' workspaceId='" + formRuntime.workspaceId + "'>";
							var listXml = SmartXMLUtil.getChildNode(formatXml, 'list');
							if(listXml != null && 'static' == listXml.getAttribute('listType')){
								var staticItem = SmartXMLUtil.getChildNodes(SmartXMLUtil.getChildNode(listXml, 'staticItems'), 'staticItem');
								for(var q = 0; q < staticItem.length ;q++){
									if(staticItem[q].firstChild) {
										html += "<option value=\"" + staticItem[q].firstChild.nodeValue + "\">" + staticItem[q].firstChild.nodeValue + "</option>";
									} else { //콤보박스에 빈값이 셋팅되었을때
										html += "<option value=\"\"></option>";
									}
								}
							}
							html += "</select>";
							html += "</div>";
							html += "</td>"; 
							break;
						case 'dateChooser':
							html += "<td align=\""+align+"\" class=\"tableCtrlRecordTd\">";
							html += "<div id=\"" + rowId + "Date\" name=\"" + id + "Date\" class=\"formDateField\" style=\"width: 100%;"+ hiddenStyleOption + "\">";
							html += "	<table width=\"100%\" height=\"100%\" border = 0 cellPadding = 0 cellSpacing = 0 class='formFieldInnerTable'>";
							html += "		<tr>";
							html += "			<td valign='middle' width='" + (subContentSize - 18) + "'>";
							html += "				<input id=\"" + rowId + "_input\" name=\"" + id + "_input\" type=\"text\" fieldId='" + fieldId + "' workspaceId='" + formRuntime.workspaceId + "' ";
							html += "					class=\"tableCtrlTextInput numberFieldInput\" style=\"width: 100%;\"/>";
							html += "			</td>";
							html += "			<td width='2'></td>";
							html += "			<td valign='middle' width='18'>";
				 			html += "				<img id=\"" + rowId + "_dateBtn\" name=\"" + id + "_dateBtn\" src=\"" + FormEnv.dateChooserIcon + "\" style=\"cursor:pointer;\" ";
				 			html += "					onclick=\"searchDate('" + rowId + "_input', '-1');\"";
							html += "				/>";
							html += "			<img src=\"../images/close.gif\" onclick=\"$('"+rowId+"_input').value='';\" style=\"cursor: pointer; vertical-align: middle;\"/>";
							html += "			</td>";
							html += "		</tr>";
							html += "	</table>";		
							html += "</div>";
							html += "</td>";
							break;
						case 'timeField':
							html += "<td align=\""+align+"\" class=\"tableCtrlRecordTd\">";
							html += "<div id=\"" + rowId + "Time\" name=\"" + id + "Time\" class=\"formTimeField\" style=\"width: 100%;vertical-align:middle;"+ hiddenStyleOption + "\">";
							html += "	<table width=\"100%\" height=\"100%\" border = 0 cellPadding = 0 cellSpacing = 0 class='formFieldInnerTable'>";
							html += "		<tr>";
							html += "			<td valign='middle'>";
							html += "<select id=\"" + rowId + "_input\" name=\"" + id + "_input\" class=\"formComboBoxField tableCtrlTextInput numberFieldInput\" fieldId='" + fieldId + "' workspaceId='" + formRuntime.workspaceId + "' style='width:100%'>";
							html += MisFormUtil.getTimeOptions();	 			
							html += "</select>";
							html += "			</td>";
							html += "		</tr>";
							html += "	</table>";
							html += "</div>";
							html += "</td>";
							break;
						case 'numberInput':
							align = "right";
							html += "<td align=\""+align+"\" class=\"tableCtrlRecordTd\">";
							html += "<div id=\"" + rowId + "NumberInput\" name=\"" + id + "NumberInput\" style=\"width:100%\">";
							html += "	<input id=\"" + rowId + "_input\" name=\"" + id + "_input\" class=\"numberFieldInput tableCtrlTextInput\" type=\"text\" style=\"\" fieldId='" + fieldId + "' workspaceId='" + formRuntime.workspaceId + "'/>";
							html += "</div>";
							html += "</td>";
							break;
						case 'percentInput':
							align = "right";
							html += "<td align=\""+align+"\" class=\"tableCtrlRecordTd\">";
							html += "<div id=\"" + rowId + "PercentInput\" name=\"" + id + "PercentInput\" style=\"width:100%\">";
							html += "	<input id=\"" + rowId + "_input\" name=\"" + id + "_input\" class=\"formPercentField tableCtrlTextInput numberFieldInput\" type=\"text\" style=\"\" fieldId='" + fieldId + "' workspaceId='" + formRuntime.workspaceId + "'/>";
							html += "</div>";
							html += "</td>";
							break;
						case 'currencyInput':
							align = "right";
							html += "<td align=\""+align+"\" class=\"tableCtrlRecordTd\">";
							html += "<div id=\"" + rowId + "CurrencyInput\" name=\"" + id + "CurrencyInput\" style=\"width:100%;\">";
							html += "	<input id=\"" + rowId + "_input\" name=\"" + id + "_input\" class=\"formCurrencyField tableCtrlTextInput numberFieldInput\" type=\"text\" style=\"width: 100%;\" fieldId='" + fieldId + "' workspaceId='" + formRuntime.workspaceId + "'/>";
							html += "</div>";
							html += "</td>";
							break;
						case 'refFormField':
							html += "<td align=\""+align+"\" class=\"tableCtrlRecordTd\">";
							html += "<div id=\"" + rowId + "_refField_input\" name=\"" + id + "_refField_input\">";		
							html += "	<table  border = 0 cellPadding = 0 cellSpacing = 0 class='formFieldInnerTable' width='100%'>";
							html += "		<tr>";
							html += "			<td valign='middle' width='" + (subContentSize - 18) + "'>";
							html += "				<input id=\"" + rowId + "_input\" name=\"" + id + "_input\" class=\"tableCtrlTextInput numberFieldInput\" style=\"\" value=\"\" fieldId='" + fieldId + "' workspaceId='" + formRuntime.workspaceId + "'/>";
							html += "			</td>";
							html += "			<td style=\"\" width='18' >";
							html += "				<img id=\"" + rowId + "_refField\" name=\"" + id + "_refField\" style=\"cursor:pointer;\" src=\"" + FormEnv.formRefIcon + "\" ></img>";
							html += "				<input id=\"" + rowId + "_refField_value\" name=\"" + id + "_refField_value\" type=\"hidden\" value=\"\"/>";
							html += "			</td>";
							html += "		</tr>";
							html += "	</table>";					
							html += "</div>";
							html += "</td>"; 				
							break;
						case 'userField':
							html += "<td align=\""+align+"\" class=\"tableCtrlRecordTd\">";
							html += "<div id =\"" + rowId + "_refField_input\" name =\"" + id + "_refField_input\">";		
							html += "	<table width=" + subContentSize + " height=100% border = 0 cellPadding = 0 cellSpacing = 0 class='formFieldInnerTable' style='width:100%;height:100%'>";
							html += "		<tr>";
							html += "			<td valign='middle' width=" + (subContentSize - 18) + ">";
							html += "				<input id=\"" + rowId + "_input\" name=\"" + id + "_input\" class=\"tableCtrlTextInput numberFieldInput\" style=\"\" value=\"\" fieldId='" + fieldId + "' workspaceId='" + formRuntime.workspaceId + "'/>";
							html += "			</td>";
							html += "			<td valign='middle' width=18\">";
							html += "				<img id=\"" + rowId + "_userField\" name=\"" + id + "_userField\" style=\"cursor:pointer;\" src=\"" + FormEnv.userRefIcon + "\"></img>";
							html += "				<input id=\"" + rowId + "_userField_value\" name=\"" + id + "_userField_value\" type=\"hidden\" value=\"\"/>";
							html += "			</td>";
							html += "		</tr>";
							html += "	</table>";				
							html += "</div>";
							html += "</td>"; 				
							break;
						case 'emailIDInput':			
							html += "<td align=\""+align+"\" class=\"tableCtrlRecordTd\">";
							html += "<div id=\"" + rowId + "TextInput\" name=\"" + id + "TextInput\">"; 
							html += "	<input id=\"" + rowId +"_input\" name=\"" + id +"_input\" class=\"tableCtrlTextInput numberFieldInput\" type=\"text\" onchange=\"isEMail(this);\" fieldId='" + fieldId + "' workspaceId='" + formRuntime.workspaceId + "'/>";				
							html += "</div>";
							html += "</td>";
							break;
						default :
							html += "<td align=\""+align+"\" class=\"tableCtrlRecordTd\">";
							html += "<div id=\"" + rowId + "TextInput\" name=\"" + id + "TextInput\">"; 
							html += "	<input id=\"" + rowId +"_input\" name=\"" + id +"_input\" class=\"tableCtrlTextInput numberFieldInput\" type=\"text\" fieldId='" + fieldId + "' workspaceId='" + formRuntime.workspaceId + "'/>";				
							html += "</div>";
							html += "</td>";
					}
				} else {
					switch (formatType) {
						case 'numberInput':
							align = "right";
							html += "<td align=\""+align+"\" class=\"tableCtrlRecordTd\">";
							html += "<div id=\"" + rowId + "NumberInput\" name=\"" + id + "NumberInput\" style=\"width:100%;\">";
							html += "	<p id=\"" + rowId + "_input\" name=\"" + id + "_input\" class=\"tableCtrlTextInput tableCtrlTextInputLeft\"></p>";	
							html += "</div>";
							html += "</td>";
							break;
						case 'percentInput':
							align = "right";
							html += "<td align=\""+align+"\" class=\"tableCtrlRecordTd\">";
							html += "<div id=\"" + rowId + "PercentInput\" name=\"" + id + "PercentInput\" style=\"width:100%;\">";
							html += "	<p id=\"" + rowId + "_input\" name=\"" + id + "_input\" class=\"tableCtrlTextInput tableCtrlTextInputLeft\"></p>";	
							html += "</div>";
							html += "</td>";
							break;
						case 'currencyInput':
							align = "right";
							html += "<td align=\""+align+"\" class=\"tableCtrlRecordTd\">";
							html += "<div id=\"" + rowId + "CurrencyInput\" name=\"" + id + "CurrencyInput\" style=\"width:100%;\">";
							html += "	<p id=\"" + rowId + "_input\" name=\"" + id + "_input\" class=\"tableCtrlTextInput tableCtrlTextInputLeft\"></p>";	
							html += "</div>";
							html += "</td>";
							break;
						case 'refFormField':
							html += "<td width=\""+ subContentSize + "px\" align=\""+align+"\" class=\"tableCtrlRecordTd\">";
							html += "<div id=\"" + rowId + "TextInput\" name=\"" + id + "TextInput\">"; 
							html += "	<p id=\""+ rowId +"_input\" name=\""+ id +"_input\" class=\"formFieldView formFieldContentsView\" type=\"text\">&nbsp;</p>";				
							html += "</div>";
							html += "<div id =\"" + rowId + "_refField_input\" name =\"" + id + "_refField_input\">";	
							html += "	<input id=\"" + rowId + "_input\" name=\"" + id + "_input\" class=\"tableCtrlTextInput\" type=\"hidden\" value=\"\"/>";
							html += "	<img id=\"" + rowId + "_refField\" name=\"" + id + "_refField\" style=\"cursor:pointer;display:none;visible:hidden;\" src=\"" + FormEnv.formRefIcon + "\" ></img>";
							html += "	<input id=\"" + rowId + "_refField_value\" name=\"" + id + "_refField_value\" type=\"hidden\" value=\"\"/>";				
							html += "</div>";
							html += "</td>"; 				
							break;
						case 'userField':
							html += "<td width=\""+ subContentSize + "px\" align=\""+align+"\" class=\"tableCtrlRecordTd\">";
							html += "<div id=\"" + rowId + "TextInput\" name=\"" + id + "TextInput\">"; 
							html += "	<p id=\"" + rowId + "_input\" name=\"" + id + "_input\" class=\"formFieldView formFieldContentsView\" type=\"text\">&nbsp;</p>";				
							html += "</div>";
							html += "<div id =\"" + rowId + "_refField_input\" name =\"" + id + "_refField_input\">";	
							html += "	<input id=\"" + rowId + "_input\" name=\"" + id + "_input\" class=\"tableCtrlTextInput\" type=\"hidden\" value=\"\" style=\"\"/>";
							html += "	<img id=\"" + rowId + "_userField\" name=\"" + id + "_userField\" style=\"cursor:pointer;display:none;visible:hidden;\" src=\"" + FormEnv.userRefIcon + "\"></img>";
							html += "	<input id=\"" + rowId + "_userField_value\" name=\"" + id + "_userField_value\" type=\"hidden\" value=\"\" style=\"\"/>";
							html += "</div>";
							html += "</td>"; 				
							break;
						//case 'emailIDInput':			
						//	html += "<td align=\""+align+"\" class=\"tableCtrlRecordTd\">";
						//	html += "<div id=\"" + rowId + "TextInput\" name=\"" + id + "TextInput\">"; 
						//	html += "	<input id=\"" + rowId +"_input\" name=\"" + id +"_input\" class=\"tableCtrlTextInput\" type=\"text\" onchange=\"isEMail(this);\" fieldId='" + fieldId + "' workspaceId='" + formRuntime.workspaceId + "'/>";				
						//	html += "</div>";
						//	html += "</td>";
						//	break;
						default :
							html += "<td width=\""+ subContentSize + "px\" align=\""+align+"\" class=\"tableCtrlRecordTd\">";
							html += "<div id=\"" + rowId + "TextInput\" name=\"" + id + "TextInput\">"; 
							html += "	<p id=\""+ rowId +"_input\" name=\""+ id +"_input\" class=\"formFieldView formFieldContentsView\" type=\"text\">&nbsp;</p>";				
							html += "</div>";
							html += "</td>";
					}
				}		
			}
			html += "</tr>";
		}
	}
	html += "</tbody></table>";
	
	// 세로스크롤을 사용하지 않는 경우 높이 보다 레코드 갯수가 더 많을 경우 
	// 마지막 레코드가 가로스크롤에 가리는 문제를 해결하기 위해서...
	if (!verticalScroll && tableWidth > 720)
		html += "<div style=\"height: 16px;\"></div>";
		
	contentDiv.innerHTML = html;
	
	for (var n=0; n<rowCnt; n++) {		
		for (var m=0; m< fields.length; m++) {
			var id = formRuntime.generateFieldIdByXml(fields[m]);
			var rowId = id + "_" + n;
			
			var formatType = (SmartXMLUtil.getChildNode(fields[m], 'format')).getAttribute('type');
			if (edit) {
				switch (formatType) {
					case 'dateChooser':
//						Calendar.setup({
//								inputField: rowId + "_input",
//								ifFormat: "%Y-%m-%d",
//								button: rowId + "_dateBtn",
//								align: "Tl",
//								singleClick: true,
//								onUpdate:	function(cal){
//									var p = cal.params;
//								}
//						});
						break;
					case 'timeField':
						$(rowId + "_input").value='09:00';
						break;
					case 'numberInput':
						var numberField = new FormDataGridNumberField(contentDiv, fields[m], n, formRuntime, false);
						jQuery("#" + rowId + "NumberInput").data("formField", numberField);
						break;
					case 'percentInput':
						var percentField = new FormDataGridNumberField(contentDiv, fields[m], n, formRuntime, false, {suffix: "%"});
						jQuery("#" + rowId + "PercentInput").data("formField", percentField);
						break;
					case 'currencyInput':
						var formatXml = SmartXMLUtil.getChildNode(fields[m], "format");
						var symbol = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(formatXml, "currency"));
						var currencyField = new FormDataGridNumberField(contentDiv, fields[m], n, formRuntime, false, {prefix: symbol});
						jQuery("#" + rowId + "CurrencyInput").data("formField", currencyField);
						break;
					case 'userField':
						var userFormField = new FormDataGridUserField(contentDiv, fields[m], n, 'visible', formRuntime, subContentSize);
						break;
					case 'refFormField':
						var refFormField = new FormDataGridRefField(contentDiv, fields[m], n, 'visible', formRuntime, subContentSize);
						break;
					default :
				}
			} else {
				switch(formatType){
					case 'numberInput':
						var numberField = new FormDataGridNumberField(contentDiv, fields[m], n, formRuntime, true);
						jQuery("#" + rowId + "NumberInput").data("formField", numberField);
						break;
					case 'percentInput':
						var percentField = new FormDataGridNumberField(contentDiv, fields[m], n, formRuntime, true, {suffix: "%"});
						jQuery("#" + rowId + "PercentInput").data("formField", percentField);
						break;
					case 'currencyInput':
						var formatXml = SmartXMLUtil.getChildNode(fields[m], "format");
						var symbol = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(formatXml, "currency"));
						var currencyField = new FormDataGridNumberField(contentDiv, fields[m], n, formRuntime, true, {prefix: symbol});
						jQuery("#" + rowId + "CurrencyInput").data("formField", currencyField);
						break;
					case 'refFormField':
						var refFormField = new FormDataGridRefField($(rowId + "TextInput"), fields[m], n, 'hidden', formRuntime, subContentSize);
						break;
					case 'userField':
						var userFormField = new FormDataGridUserField($(rowId + "TextInput"), fields[m], n, 'hidden', formRuntime, subContentSize);		
						break;
					default :
				}
			}
		}
	}
};

FormRuntimeDataGridAddRow = function (dataGridTable, gridField, edit) {
	edit = Mis.toBoolean(edit, true);
	var editTdWidth = 40;
	
	var fields = SmartXMLUtil.getChildNodes(SmartXMLUtil.getChildNode(gridField, 'children'), 'formEntity');
	var rowIndex = $(dataGridTable).childNodes[1].childNodes.length;
	var newRow = $(dataGridTable).insertRow(-1);//새로운 행 만들기
	
	var graphic = SmartXMLUtil.getChildNode(gridField, "graphic");
	var fitWidth = Mis.toBoolean(graphic.getAttribute("fitWidth"), false);
	var scale = 1;
	if (fitWidth) {
		var tableWidth = 0;
		for (var j=0; j<fields.length; j++) {
			var tmpSize = MisFormUtil.getFieldContentWidth(fields[j]);
				tableWidth += parseFloat(tmpSize);
		}
		if (tableWidth > 0) {
			var realTableWidth = 700;
			if (edit)
				realTableWidth = realTableWidth - editTdWidth;
			scale = realTableWidth / tableWidth;
		}
	}

	newRow.className = "tableCtrlRecordTr";
	var newCellArr = new Array();
	for (var i=0; i<(fields.length); i++)
		newCellArr[i] = newRow.insertCell(-1);
	
	for (var r=0; r<fields.length; r++) {
		var formatType = (SmartXMLUtil.getChildNode(fields[r], 'format')).getAttribute('type');
		var subContentSize = MisFormUtil.getFieldContentWidth(fields[r]) * scale;
		
		var formatXml = SmartXMLUtil.getChildNode(fields[r], 'format');
		var graphicXml = SmartXMLUtil.getChildNode(fields[r], 'graphic');
		var formTextStyle = '';
		var align = Mis.toDefault(graphicXml.getAttribute("textAlign"), "left");
		
		var fieldId = fields[r].getAttribute('id');
		var id = "workspace_formField_" + fieldId;
		var rowId = id + "_" + rowIndex;
		
		var hiddenStyleOption = "";
		if(graphicXml != null){
			if(subContentSize == 0 || graphicXml.getAttribute('hidden') == 'true'){
				hiddenStyleOption = "display:none;visibility:hidden;";
			}
		}
			
		var html;
		switch(formatType){
			case 'comboBox':							
				html = "<div id=\"" + rowId + "Combo\" name=\"" + id + "Combo\" width=\"100%\">";
				html += "	<select id=\"" + rowId + "_input\" name=\"" + id + "_input\" class=\"formComboBoxField tableCtrlTextInput\" style=\"width: 100%;" + hiddenStyleOption + "\" fieldId='" + fieldId + "' workspaceId='workspace'>";
				var listXml = SmartXMLUtil.getChildNode(formatXml, 'list');
				if(listXml != null && 'static' == listXml.getAttribute('listType')){
					var staticItem = SmartXMLUtil.getChildNodes(SmartXMLUtil.getChildNode(listXml, 'staticItems'), 'staticItem');
					for(var q = 0; q < staticItem.length ;q++){
						if(staticItem[q].firstChild) {
							html += "<option value=\"" + staticItem[q].firstChild.nodeValue + "\">" + staticItem[q].firstChild.nodeValue + "</option>";
						} else { //콤보박스에 빈값이 셋팅되었을때
							html += "<option value=\"\"></option>";
						}
					}
				}			
				html += "	</select>";
				html += "</div>";	
				break;
			case 'dateChooser':
				html = "<div id=\"" + rowId + "Date\" name=\"" + id + "Date\" class=\"formDateField\" style=\"width: 100%;"+ hiddenStyleOption + "\">";
				html += "	<table width=\"100%\" height=\"100%\" border = 0 cellPadding = 0 cellSpacing = 0 class='formFieldInnerTable'>";
				html += "		<tr>";
				html += "			<td valign='middle' width='" + (subContentSize - 18) + "'>";
				html += "				<input id=\"" + rowId + "_input\" name=\"" + id + "_input\" type=\"text\" fieldId='" + fieldId + "' workspaceId='workspace' ";
				html += "					class=\"tableCtrlTextInput numberFieldInput\" style=\"width: 100%;\"/>";
				html += "			</td>";
				html += "			<td width='2'></td>";
				html += "			<td valign='middle' width='18'>";
				html += "				<img src=\"" + FormEnv.dateChooserIcon + "\" id=\"" + rowId + "_dateBtn\" style=\"cursor:pointer;\" ";
	 			html += "					onclick=\"searchDate('" + rowId + "_input', '-1');\"";
				html += "				/>";
				html += "			<img src=\"../images/close.gif\" onclick=\"$('"+rowId+"_input').value='';\" style=\"cursor: pointer; vertical-align: middle;\"/>";
				html += "			</td>";
				html += "		</tr>";
				html += "	</table>";		
				html += "</div>";
				break;
			case 'timeField':
				html = "<div id=\"" + rowId + "Time\" name=\"" + id + "Time\" class=\"formTimeField\" style=\"width: 100%;vertical-align:middle;"+ hiddenStyleOption + "\">";
				html += "	<table width=\"100%\" height=\"100%\" border = 0 cellPadding = 0 cellSpacing = 0 class='formFieldInnerTable'>";
				html += "		<tr>";
				html += "			<td valign='middle'>";
				html += "				<select id=\"" + rowId + "_input\" name=\"" + id + "_input\" class=\"formComboBoxField tableCtrlTextInput\" fieldId='" + fieldId + "' workspaceId='workspace' style='width:100%'>";
				html += MisFormUtil.getTimeOptions();	 			
				html += "				</select>";
				html += "			</td>";
				html += "		</tr>";
				html += "	</table>";
				html += "</div>";
				break;
			case 'numberInput':
				html = "<div id=\"" + rowId + "NumberInput\" name=\"" + id + "NumberInput\" style=\"width:100%\">";
				html += "	<input id=\"" + rowId + "_input\" name=\"" + id + "_input\" class=\"numberFieldInput tableCtrlTextInput numberFieldInput\" type=\"text\" style=\"\" fieldId='" + fieldId + "' workspaceId='workspace'/>";
				html += "</div>";
				break;
			case 'percentInput':
				html = "<div id=\"" + rowId + "PercentInput\" name=\"" + id + "PercentInput\" style=\"width:100%\">";
				html += "	<input id=\"" + rowId + "_input\" name=\"" + id + "_input\" class=\"formPercentField tableCtrlTextInput numberFieldInput\" type=\"text\" style=\"\" fieldId='" + fieldId + "' workspaceId='workspace'/>";
				html += "</div>";
				break;
			case 'currencyInput':
				html = "<div id=\"" + rowId + "CurrencyInput\" name=\"" + id + "CurrencyInput\" style=\"width:100%;\">";
				html += "	<input id=\"" + rowId + "_input\" name=\"" + id + "_input\" class=\"formCurrencyField tableCtrlTextInput numberFieldInput\" type=\"text\" style=\"\" fieldId='" + fieldId + "' workspaceId='workspace'/>";
				html += "</div>";
				break;
			case 'refFormField':
				html = "<div id =\"" + rowId + "_refField_input\" name =\"" + id + "_refField_input\">";
				html += "	<table width='100%' border = 0 cellPadding = 0 cellSpacing = 0 class='formFieldInnerTable'>";
				html += "		<tr>";
				html += "			<td valign='middle' width='" + (subContentSize - 18) + "'>";
				html += "				<input id=\"" + rowId + "_input\" name=\"" + id + "_input\" class=\"tableCtrlTextInput numberFieldInput\" style=\"\" value=\"\" fieldId='" + fieldId + "' workspaceId='workspace'/>";
				html += "			</td>";
				html += "			<td style=\"\" width='18' >";
				html += "				<img id=\"" + rowId + "_refField\" name=\"" + id + "_refField\" style=\"cursor:pointer;\" src=\"" + FormEnv.formRefIcon + "\" ></img>";
				html += "				<input id=\"" + rowId + "_refField_value\" name=\"" + id + "_refField_value\" type=\"hidden\" value=\"\"/>";
				html += "			</td>";
				html += "		</tr>";
				html += "	</table>";					
				html += "</div>";
				break;
			case 'userField':
				html = "<div id =\"" + rowId + "_refField_input\" name =\"" + id + "_refField_input\">";		
				html += "	<table width=" + subContentSize + " height=100% border = 0 cellPadding = 0 cellSpacing = 0 class='formFieldInnerTable' style='width:100%;height:100%'>";
				html += "		<tr>";
				html += "			<td valign='middle' width=" + (subContentSize - 18) + ">";
				html += "				<input id=\"" + rowId + "_input\" name=\"" + id + "_input\" class=\"tableCtrlTextInput numberFieldInput\" style=\"\" value=\"\" fieldId='" + fieldId + "' workspaceId='workspace'/>";
				html += "			</td>";
				html += "			<td valign='middle' width=18\">";
				html += "				<img id=\"" + rowId + "_userField\" name=\"" + id + "_userField\" src=\"" + FormEnv.userRefIcon + "\" style=\"cursor:pointer;\"></img>";
				html += "				<input id=\"" + rowId + "_userField_value\" name=\"" + id + "_userField_value\" type=\"hidden\" value=\"\"/>";
				html += "			</td>";
				html += "		</tr>";
				html += "	</table>";				
				html += "</div>";
				break;
			case 'emailIDInput':			
				html = "<div id=\"" + rowId + "TextInput\" name=\"" + id + "TextInput\">"; 
				html += "	<input id=\"" + rowId +"_input\" name=\"" + id +"_input\" class=\"tableCtrlTextInput numberFieldInput\" type=\"text\" onchange=\"isEMail(this);\" fieldId='" + fieldId + "' workspaceId='workspace'/>";				
				html += "</div>";
				break;
			default :
				html = "<div id=\"" + rowId + "TextInput\" name=\"" + id + "TextInput\">"; 
				html += "	<input id=\"" + rowId +"_input\" name=\"" + id +"_input\" class=\"tableCtrlTextInput numberFieldInput\" type=\"text\" fieldId='" + fieldId + "' workspaceId='workspace'/>";				
				html += "</div>";
//				html += "</td>";
		}
		newCellArr[r].innerHTML = html;
		newCellArr[r].className = "tableCtrlRecordTd";
		newCellArr[r].align = align;
		newCellArr[r].width = subContentSize;
	}
	
	if (edit) {
		var editBoxCell = newRow.insertCell(0);
		editBoxCell.innerHTML = "<input type=\"checkbox\" style=\"border: none\">";
		editBoxCell.className = "tableCtrlRecordTd";
		editBoxCell.align = "center";
	}
	
	for (var m=0; m<fields.length; m++) {
		var formatType = (SmartXMLUtil.getChildNode(fields[m], 'format')).getAttribute('type');
		
		var fieldId = fields[m].getAttribute('id');
		var id = "workspace_formField_" + fieldId;
		var rowId = id + "_" + rowIndex;
		
		switch(formatType){
			case 'dateChooser':
//				Calendar.setup({
//						inputField: rowId + "_input",
//						ifFormat: "%Y-%m-%d",
//						button: rowId + "_dateBtn",
//						align: "Tl",
//						singleClick: true,
//						onUpdate: function(cal){
//						var p = cal.params;
//					}
//				});
				break;
			case 'timeField':
				$(rowId + "_input").value='09:00';
				break;
			case 'numberInput':
				var numberField = new FormDataGridNumberField(dataGridTable+"Input", fields[m], rowIndex, null, false, {"preGenId": rowId});
				jQuery("#" + rowId + "NumberInput").data("formField", numberField);
				break;
			case 'percentInput':
				var percentField = new FormDataGridNumberField(dataGridTable+"Input", fields[m], rowIndex, null, false, {"preGenId": rowId, suffix: "%"});
				jQuery("#" + rowId + "PercentInput").data("formField", percentField);
				break;
			case 'currencyInput':
				var formatXml = SmartXMLUtil.getChildNode(fields[m], "format");
				var symbol = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(formatXml, "currency"));
				var currencyField = new FormDataGridNumberField(dataGridTable+"Input", fields[m], rowIndex, null, false, {"preGenId": rowId, prefix: symbol});
				jQuery("#" + rowId + "CurrencyInput").data("formField", currencyField);
				break;
			case 'userField':
				var userFormField = new FormDataGridUserField(dataGridTable+"Input", fields[m], rowIndex, 'visible', null, subContentSize, true, rowId);
				break;
			case 'refFormField':
				var refFormField = new FormDataGridRefField(dataGridTable+"Input", fields[m], rowIndex, 'visible', null, subContentSize, true, rowId);
				break;
			default :
		}
	}
};