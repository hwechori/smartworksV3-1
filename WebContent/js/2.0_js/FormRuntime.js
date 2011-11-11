var oEditors = [];
var comBoSelectArr = new Array();
//jk yoon 서비스 부분에서 현재 선택된 값을 확인할수있게 저장하는 변수.
var checkFormList = new Array();
var checkFormListIdx = 0;
// 서비스 부분에 넘겨줄 실제 선택된 값을 저장하는 변수
var realCheckList = new Array();
var editMode = "";
FormRuntime = function(workspaceId) {
	this.Version = '0.0.1';
	this.workspaceId = workspaceId;

	this.formXml = null;
	this.mode = null;

	this.layout = null;
	this.mappingCondFieldIds = new Array();
	this.width = 0;

	this.recordXml = null;
	this.useMapping = true;
	this.isSelfMapping = true;

	this.createForm = function(formXml, mode) {
		try {
			// 1. set global variables
			this.formXml = formXml;
			this.mode = mode;

			// 2. create form scope
			var workspace = $(this.workspaceId);
			if (MisFormUtil.existChild(workspace, this.workspaceId + '_docSpace')) {
				$(this.workspaceId + '_docSpace').remove();
			}
			var docSpace = document.createElement("div");
			docSpace.id = this.workspaceId + '_docSpace';
			workspace.appendChild(docSpace);
			docSpace.innerHTML = "<div id=\"" + this.workspaceId + "_mainSpace\" valign=\"top\"></div>";
			var mainSpace = $(this.workspaceId + "_mainSpace");

			this.createFields(mainSpace);

			jQuery("#" + this.workspaceId).data('FormRuntime', this);

			// 3. set mappings
			this.isSelfMapping = (SmartXMLUtil.getXMLString(formXml)).indexOf("'self_form'") >= 0;
			this.mappingCondFieldIds = new Array();
			var mappingFormsXml = SmartXMLUtil.getChildNode(SmartXMLUtil.getChildNode(formXml, "form"), "mappingForms");
			if (mappingFormsXml != null) {
				var mappingFormXmls = SmartXMLUtil.getChildNodes(mappingFormsXml, "mappingForm");
				if (!Mis.isEmpty(mappingFormXmls)) {
					for ( var i = 0; i < mappingFormXmls.length; i++) {
						try {
							var mappingFormXml = mappingFormXmls[i];
							var targetFormId = mappingFormXml
									.getAttribute('targetFormId');
							var condXml = SmartXMLUtil.getChildNodes(
									SmartXMLUtil.getChildNode(mappingFormXml,
											'conds'), 'cond');
							var condIds = new Array();
							for ( var j = 0; j < condXml.length; j++) {
								var secondXml = SmartXMLUtil.getChildNode(
										condXml[j], 'second');
								var secondType = secondXml.getAttribute('type');
								if (secondType == 'self') {
									var selfFieldId = secondXml.getAttribute('fieldId');
									if (selfFieldId != null	&& selfFieldId != '')
										condIds.push(selfFieldId);
								}
							}
							this.mappingCondFieldIds.push(condIds);
						} catch (e) {
						}
					}
				}
			}
			this.isMappingEachTime = this.isSelfMapping
					|| !Mis.isEmpty(this.mappingCondFieldIds);
			if (this.isMappingEachTime) {
				/**
				 *	formFieldCondValue 란 이름의 class를 지정한 필드에 change 이벤트 발생시 함수 동작.
				 */
				Event.addBehavior( {
					".formFieldCondValue:change" : function(event) {
						var formRuntime = jQuery("#" + event.target.getAttribute("workspaceId")).data("FormRuntime");
						formRuntime.refreshDataFields(event.target.getAttribute("fieldId"));
					}
				});
			}

			return docSpace;

		} catch (e) {
			alert("error : " + e.message);
		}
	};

	this.isMappingEachTime = false;
// runtime의 기본이 되는 필드를 생성한다.
// xml Data에서 Graphic 정보를 가져와 row/cell 생성등의 Grid작업을 하는 함수.
	this.createFields = function(scope) {
		var graphicXml = SmartXMLUtil.getChildNode(SmartXMLUtil.getChildNode(this.formXml, 'form'), 'graphic');
		var spaceXml = SmartXMLUtil.getChildNode(graphicXml, 'space');

		var width = graphicXml.getAttribute('width');
		var leftMargin = parseInt(spaceXml.getAttribute('left'));
		var rightMargin = parseInt(spaceXml.getAttribute('right'));

		this.width = width - leftMargin - rightMargin;

		var formFieldsDiv = document.createElement("div");
		formFieldsDiv.id = this.workspaceId + "_formFieldsSpace";
		scope.appendChild(formFieldsDiv);

		var layoutXml = SmartXMLUtil.getChildNode(SmartXMLUtil.getChildNode(this.formXml, 'form'), 'layout');
		// FormGridLayout.js ===> Grid를 생성.
		this.layout = new FormGridLayout(this.formXml, formFieldsDiv, this, layoutXml);

		return formFieldsDiv;
	};

var labelWidthGlobal = ""; // 현재 Grid 생성시 Label의 크기를 고정화 시키기 위한 전역 변수.
/**
 *  [윤종국]
	기존에는 label의 크기를 xml에서받아와 직접 주입하는 방식으로 되어있었으나
	현재 2.0 에 들어서면서 각각의 필드가 예전 1.0에서와 달리 유동적으로 변화되지 않고
	제각기 사이즈가 적용되게 되면서 삐뚤빼뚤하게 보이는 상황이 발생하여
	전 label 필드의 크기를 최초 의 label 필드의 width로 지정하여 고정하였음.
*/
	this.createField = function(fieldXml, row, colspan, width, height, ratio,rowspan) {
		// TODO ratio 폐지
		if (Mis.isNull(ratio))
			ratio = 1;

		var id = this.generateFieldIdByXml(fieldXml);
		var name = fieldXml.getAttribute('name');
		var systemType = fieldXml.getAttribute('systemType');
		var formatXml = SmartXMLUtil.getChildNode(fieldXml, 'format');
		var formatType = formatXml.getAttribute('type');
		var graphicXml = SmartXMLUtil.getChildNode(fieldXml, 'graphic');
		var hidden = Mis.toBoolean(graphicXml.getAttribute("hidden"), false);

		// var textAlign = Mis.toDefault(graphicXml.getAttribute("textAlign"),
		// "left");
		var textAlign = "left";
		var labelWidth = parseFloat(MisFormUtil.getFieldLabelWidth(fieldXml));
		if(labelWidthGlobal == ''){
			labelWidthGlobal = labelWidth;
		}else{
			labelWidth = labelWidthGlobal;
		}
		var contentWidth = parseFloat(MisFormUtil.getFieldContentWidth(fieldXml));
		var heightSize = parseFloat(MisFormUtil.getFieldHeight(fieldXml));
		// datagrid인 경우, label을 상단에 그리므로 labelWidth를 무시한다.
		if (formatType == "dataGrid") {
			contentWidth = width * ratio;
		} else {
			if (width >= 0) {
				contentWidth = width - labelWidth;
			} else {
				if (this.width < (labelWidth + contentWidth))
					contentWidth = this.width - labelWidth;
			}
		}
		var innerTd = row.insertCell(-1);
		innerTd.colSpan = colspan || '1';
		innerTd.rowSpan = rowspan || '1';
		innerTd.id = id+"_innerTd";
		innerTd.setAttribute('formFieldsRowId',row.id);
		innerTd.setAttribute('fieldId',id);
		// jk
		innerTd.width = "25%";
		//innerTd.width = contentWidth+'px';
		innerTd.height = heightSize+'px';

		var innerTable = document.createElement("table");
		innerTable.width = '100%';
		innerTable.setAttribute('height',innerTd.offsetHeight+'px');
		//innerTable.setAttribute('height',heightSize+'px');
		innerTable.border = '0';
		innerTable.cellPadding = "0";
		innerTable.cellSpacing = "0";

		innerTd.appendChild(innerTable);

		var innerTableTr = innerTable.insertRow(-1);

		// label 공통
		var labelCell = innerTableTr.insertCell(-1);
		labelCell.id = id + "_label";
		labelCell.width = labelWidth;
		// labelCell.height = heightSize;
		/*
		
		Element.setStyle(labelCell, {
			wordWrap : 'break-word',
			wordBreak : 'break-all',
			textOverflow : 'ellipsis'
		});
		 * */
		Element.addClassName(labelCell, "formFieldsTableLabelTd");
		var contentCell;
		if (contentWidth == 0 || hidden) {
			Element.addClassName(labelCell, 'formFieldNoLabel');
			labelCell.colSpan = 2;
			$(labelCell.id).update("&nbsp;");

			contentCell = new Element("div");
			labelCell.appendChild(contentCell);
			Element.hide(contentCell);

		} else {
			// label 공통
			
			if (formatType == "dataGrid") {
				labelCell.setAttribute('style','background-color:#ececec;');
				name = "<b>::</b> "+name+" <b>::</b>";
			}
			
			labelCell.innerHTML = "<p style='font-size:12px; !important;'>"
					+ name + "</p>";
			Element.addClassName(labelCell, 'formFieldLabel');
			if (formatType == "dataGrid") {
				//labelCell.colSpan = colspan * 2; jk
				labelCell.height = 25+'px';
				labelCell.setAttribute('align','center');
				var contentRow = $(innerTableTr).up().up().insertRow(-1);
				contentCell = contentRow.insertCell(-1);
				// jk
				// contentCell.width = contentWidth;
				// contentCell.colSpan = colspan * 2;
				Element.setStyle(contentCell, {
					paddingLeft : '0px',
					paddingRight : '0px'
				});
			} else {
				if (formatType === "numberInput"
						|| formatType === "percentInput"
						|| formatType === "currencyInput") {
					textAlign = "right";
				} else if (formatType === "imageBox") {
					textAlign = "center";
				}
				//labelCell.colSpan = '1';
				labelCell.width = labelWidth;
				if (Mis.toBoolean(fieldXml.getAttribute('required'))
						&& this.mode != "view") {
					var html = "<table border=0 cellPadding=0 cellSpacing=0 class='formRequiredLabelTable' width='100%' height='100%'><tr><td width='"
							+ (labelWidth - 4) + "px'>";
					html += labelCell.innerHTML;
					html += "</td><td width='4px'><div style='width:100%;height:"
							+ height
							+ "px;text-align:right;padding-top:1px;padding-bottom:1px;padding-left:1px;'>";
					html += "	<div class='formRequiredBar'/>";
					html += "</div></td></tr></table>";
					labelCell.innerHTML = html;
				}
				contentCell = innerTableTr.insertCell(-1);
				// contentCell.colSpan = (colspan * 2) - 1;
				// contentCell.width = contentWidth;
				// Element.setStyle(contentCell, {paddingLeft: '5px'});
			}
			// content 공통
			contentCell.id = id + "_contents";
			// contentCell.height = heightSize;
			contentCell.align = textAlign;
			Element.addClassName(contentCell, 'formFieldContents');
			Element.addClassName(contentCell, "formFieldsTableTd");
			//jk 수정 변경.
			contentCell.height = heightSize;
		}
		//this.createFieldContent(fieldXml, contentWidth, contentCell, height);
		//jk 수정
		this.createFieldContent(fieldXml, contentWidth, contentCell, heightSize, labelCell);
	};

	// Editor textarea 생성
	this.toTextEditorHtml = function(fieldXml, lang, content, height) {
		content = Mis.toNull(content);
		if (content == null) {
			content = '';
		}
		var editorHeight = "";// - 60;

		// if(navigator.appName.indexOf('Microsoft') > -1) {
		// editorHeight = height;
		// } else {
		// editorHeight = height - 15;
		// }
		editorHeight = Math.floor(height - 15);
		var editorId = this.generateFieldIdByXml(fieldXml) + "_input";
		var html = '<textarea id=\'' + editorId + '\' name=\'' + editorId
				+ '\' style=\'width:100\%;height:' + editorHeight
				+ 'px;display:none;overflow:auto; \'>' + content;
		return html;
	};

	// SmartEditor 생성
	this.createSmartEditor = function(editorId, defaultLanguage) {
		if (oEditors != null) {
			for ( var i = 0; i < oEditors.length; i++) { //같은 이름의 에디터 객체 삭제
				if (oEditors.getById[editorId]) {
					oEditors.splice(i, 1);
				}
			}
		}
		var editorSkinURI = getPath() + "/smarteditor/SEditorSkinKOR.html";
		if (defaultLanguage === "ENG") {
			editorSkinURI = getPath() + "/smarteditor/SEditorSkinENG.html";
		}
		nhn.husky.EZCreator.createInIFrame( {
			oAppRef : oEditors,
			elPlaceHolder : editorId,
			sSkinURI : editorSkinURI,
			fCreator : "createSEditorInIFrame"
		});
	};

	// private
	// runtime 테이블 형식 div 생성.
	this.generateDataGridContentDiv = function(fieldXml) {
		var graphicXml = SmartXMLUtil.getChildNode(fieldXml, "graphic");

		var div = new Element("div");
		div.id = this.generateFieldIdByXml(fieldXml) + "_DataGridInput";
		// TODO width
		Element.setStyle(div, {
			//width: "720px", 
			height : MisFormUtil.getFieldHeight(fieldXml) + "px",
			overflowX : "auto",
			overflowY : MisFormUtil.getFieldOverflowY(fieldXml),
			margin : "1px, 1px, 1px, 1px"
		});
		if (graphicXml.getAttribute("hidden") == 'true')
			Element.setStyle(div, {
				display : "none",
				visibility : "hidden"
			});

		return div;
	};
/**
 *  [윤종국]
  	그리드가 생성 되고 난후
  	각 필드에 들어갈 항목들을 생성하여 삽입하는 함수.
  
*/
	this.createFieldContent = function(fieldXml, contentWidth, contentsContainer, height, labelCell) {
		var formatXml = SmartXMLUtil.getChildNode(fieldXml, 'format');
		var toolTip = fieldXml.getAttribute('toolTip');
		var formatType = formatXml.getAttribute('type');
		var graphicXml = SmartXMLUtil.getChildNode(fieldXml, 'graphic');
		var formFieldId = fieldXml.getAttribute('id');
		var mappingsXml = SmartXMLUtil.getChildNode(fieldXml, 'mappings');
		var entity = SmartXMLUtil.getChildNode(fieldXml, 'formEntity');
		var fitToScreen = Mis.toBoolean(graphicXml.getAttribute("fitToScreen"), false);
		var id = this.generateFieldIdByXml(fieldXml);
		var formX = SmartXMLUtil.getChildNode(this.formXml, 'form');
		var formId = formX.getAttribute('id');
		var xml = '<?xml version="1.0"?><DataRecord formId="' + formId + '" formVersion="1" workItemId=""/>';
		var hiddenStyleOption = "";
		if (graphicXml != null) {
			if (contentWidth == 0 || graphicXml.getAttribute('hidden') == 'true') {
				hiddenStyleOption = "display:none;visibility:hidden;";
			}
		}
		// Element.setStyle(contentsContainer, {border : '1', borderStyle : 'solid'});
		var html;
		if(toolTip != null){
			contentsContainer.setAttribute('alt',toolTip);
			contentsContainer.setAttribute('title',toolTip);
			labelCell.setAttribute('alt',toolTip);
			labelCell.setAttribute('title',toolTip);
		}
//alert(contentsContainer);
		if (contentsContainer.colSpan > 1) {
			contentWidth = contentWidth - 15 * contentsContainer.colSpan;
		} else {
			contentWidth = contentWidth - 15;
		}
		if (this.mode == "view"	|| Mis.toBoolean(graphicXml.getAttribute('readOnly'))) {
			switch (formatType) {
			case "dataGrid":
				var div = this.generateDataGridContentDiv(fieldXml);
				// jk table
				contentsContainer.appendChild(div);
				new FormRuntimeDataGrid(this, fieldXml, div, false);
				break;
			case "textArea":
			case "richEditor":
				html = "<div class=\"smartOutput formFieldContentsRich\" id=\""
						+ id + "_input\" style=\"height:" + height + "px;\">"; 
				
				html += "&nbsp;";
				html += "</div>";
				contentsContainer.innerHTML = html;
				contentsContainer.addClassName("formFieldContentsRich");
				break;
			case "fileField":
				var contentsDivContainer = new Element("div");
				contentsDivContainer.id = id + "_FileInput";
				contentsDivContainer.addClassName("formFieldContentsView");
				var fileField = new FormFileField(contentsDivContainer, fieldXml, "hidden", this);
				contentsContainer.appendChild(contentsDivContainer);
				contentsContainer.addClassName("formFieldContentsFile");
				break;
			case "imageBox":
				var contentsDivContainer = new Element("div");
				contentsDivContainer.id = id + "_FileInput";
				contentsDivContainer.addClassName("formFieldContentsView");
				var fileField = new FormFileField(contentsDivContainer, fieldXml, "hidden", this, contentWidth, formatType,	fitToScreen);

				contentsContainer.appendChild(contentsDivContainer);
				contentsContainer.addClassName("formFieldContentsFileImage");
				break;
			case "numericStepper":
			case "numberInput":
				var contentsDivContainer = new Element("div");
				contentsDivContainer.id = id + "_container";
				contentsDivContainer.addClassName("formFieldContentsView");
				contentsContainer.appendChild(contentsDivContainer);

				var numberField = new FormNumberField(contentsDivContainer,	fieldXml, "visible", this, true);
				jQuery("#" + contentsDivContainer.id).data("formField",
						numberField);
				break;
			case "percentInput":
				var contentsDivContainer = new Element("div");
				contentsDivContainer.id = id + "_container";
				contentsDivContainer.addClassName("formFieldContentsView");
				contentsContainer.appendChild(contentsDivContainer);

				var percentField = new FormNumberField(contentsDivContainer, fieldXml, "visible", this, true, {
							suffix : "%"
						});
				jQuery("#" + contentsDivContainer.id).data("formField",	percentField);
				break;
			case "currencyInput":
				var contentsDivContainer = new Element("div");
				contentsDivContainer.id = id + "_container";
				contentsDivContainer.addClassName("formFieldContentsView");
				contentsContainer.appendChild(contentsDivContainer);

				var formatXml = SmartXMLUtil.getChildNode(fieldXml, 'format');
				var symbol = SmartXMLUtil.getNodeData(SmartXMLUtil
						.getChildNode(formatXml, 'currency'));
				var currencyField = new FormNumberField(contentsDivContainer, fieldXml, "viewer", this, true, {
							prefix : symbol
						});
				jQuery("#" + contentsDivContainer.id).data("formField",
						currencyField);
				break;
			// case "emailIDInput":
			// html = "<div id=\"" + id + "TextInput\">";
			// html += "<p class=\"formFieldView formFieldContentsView\" id=\""
			// + id + "_input\" type=\"text\" style=\"width: 100%;" +
			// hiddenStyleOption + "\">&nbsp;</p>";
			// html += "</div>";
			// contentsContainer.innerHTML = html;
			// break;
/*			case "refFormField":
				var refFormField = new FormRef(contentsContainer, fieldXml,
						'hidden', this);
				break;*/
			default:
				html = "<div id=\"" + id + "TextInput\">";
				html += "<p class=\"formFieldView formFieldContentsView\" id=\""
						+ id
						+ "_input\" type=\"text\" style=\"width: 100%;"
						+ hiddenStyleOption + "\">&nbsp;</p>";
				html += "</div>";
				contentsContainer.innerHTML = html;

				if (formatType == "refFormField") {
					var refFormField = new FormRef($(id + "TextInput"),
							fieldXml, "hidden", this);
				} else if (formatType == "userField") {
					var userFormField = new FormUser($(id + "TextInput"),
							fieldXml, "hidden", this);
				 }
			}
		} else {
			switch (formatType) {
			case "radioButton":
				//jk (contentWidth - 5) 를 지움.
				html = "<div class=\"formRadioField\" id=\"" + id
				+ "Radio\"" + hiddenStyleOption + "\" align=\"left\">";
				/*
				html = "<div class=\"formRadioField\" id=\"" + id
						+ "Radio\" style=\"width: " + (contentWidth - 5)
						+ "px;" + hiddenStyleOption + "\" align=\"left\">";
				 */
				var staticItemsXml = SmartXMLUtil.getChildNode(SmartXMLUtil.getChildNode(formatXml, "list"), "staticItems");
				var staticItem = SmartXMLUtil.getChildNodes(staticItemsXml,	"staticItem");
				for ( var i = 0; i < staticItem.length; i++) {
					if (staticItem[i].firstChild) {
						html += "<input class=\"formFieldContentsInput formFieldCondValue formFieldRadioItem\" type=\"radio\" name=\""
								+ id
								+ "_input\" value=\""
								+ staticItem[i].firstChild.nodeValue
								+ "\""
								+ "fieldId='"
								+ formFieldId
								+ "' workspaceId='"
								+ this.workspaceId
								+ "'>"
								+ staticItem[i].firstChild.nodeValue
								+ "</input>&nbsp;&nbsp;&nbsp;";
					} else { //라디오버튼에 빈값이 셋팅되었을때
						html += "<input class=\"formFieldContentsInput formFieldCondValue formFieldRadioItem\" type=\"radio\" name=\""
								+ id
								+ "_input\" value=\""
								+ ""
								+ "\""
								+ "fieldId='"
								+ formFieldId
								+ "' workspaceId='"
								+ this.workspaceId
								+ "'>"
								+ "" + "</input>&nbsp;&nbsp;&nbsp;";
					}
				}
				html += "</div>";
				/*
				html = "<div style=\"width: " + (contentWidth - 5)
						+ "px;\" align=\"center\">" + html + "</div>";
				 * */
				html = "<div align=\"center\">" + html + "</div>";
				contentsContainer.innerHTML = html;
				break;
			case "comboBox":
				html = "<div id=\"" + id + "Combo\">";
				html += "<select onchange=\"refreshComboBox('" 
						+ this.workspaceId
						+ "')\" class=\"formComboBoxField formFieldCondValue\" id=\""
						+ id
						+ "_input\" style=\"width: 100%;"
						+ hiddenStyleOption
						+ "\" fieldId='"
						+ formFieldId
						+ "' workspaceId='" + this.workspaceId + "'>";
				var listXml = SmartXMLUtil.getChildNode(formatXml, 'list');
				if (listXml != null
						&& 'static' == listXml.getAttribute('listType')) {
					var staticItem = SmartXMLUtil
							.getChildNodes(SmartXMLUtil.getChildNode(listXml,
									'staticItems'), 'staticItem');
					for ( var i = 0; i < staticItem.length; i++) {
						if (staticItem[i].firstChild) {
							html += "<option value=\""
									+ staticItem[i].firstChild.nodeValue
									+ "\">"
									+ staticItem[i].firstChild.nodeValue
									+ "</option>";
						} else { //콤보 박스에 빈값이 셋팅됬을때
							html += "<option value=\"" + "" + "\">" + ""
									+ "</option>";
						}
					}
				}
				html += "</select>";
				html += "</div>";
				contentsContainer.innerHTML = html;
				break;
			case "checkBox":
				html = "<div id=\"" + id + "Radio\" class='formCheckBoxField'>";
				html += "<input id=\""
						+ id
						+ "_input\" class=\"formFieldContentsInput formFieldCondValue\" type=\"checkbox\" style='"
						+ hiddenStyleOption + "' fieldId='" + formFieldId
						+ "' workspaceId='" + this.workspaceId + "'/>";
				html += "</div>";
				contentsContainer.innerHTML = html;
				break;
			case "dateChooser":
				html = "<div class=\"formDateField\" id=\"" + id
						+ "Date\" style=\"" + hiddenStyleOption + "\">";
				html += "	<table width=100% height=\"100%\" border = 0 cellPadding = 0 cellSpacing = 0 class='formFieldInnerTable'>";
				html += "		<tr>";
				html += "			<td valign='middle' width=*>";
				html += "				<input id=\"" + id + "_input\" name=\"" + id
						+ "_input\" fieldId=\"" + formFieldId + "\" workspaceId=\"" + this.workspaceId + "\"";
				html += "					type=\"text\" class=\"formFieldContentsInput formFieldCondValue\" readOnly style=\"width:100%;\"/>";
				html += "			</td>";
				html += "			<td width='5'></td>";
				html += "			<td  width='38px' align='left'>";
				html += "				<img src=\"" + FormEnv.dateChooserIcon + "\" id=\"" + id + "_dateBtn\" style=\"cursor:pointer;vertical-align: middle;\"";
				html += "					onclick=\"searchDate('" + id + "_input', '0');\"";
				html += "				/>";
				html += "			<img src=\"../images/close.gif\" onclick=\"$('"+id+"_input').value='';\" style=\"cursor: pointer; vertical-align: middle;\"/>";
				html += "			</td>";
				html += "		</tr>";
				html += "	</table>";
				html += "</div>";
				contentsContainer.innerHTML = html;
				break;
			case "dataGrid":
				var div = this.generateDataGridContentDiv(fieldXml);
				contentsContainer.appendChild(div);
				// TODO
				new FormRuntimeDataGrid(this, fieldXml, div, true);
				break;
			case "userField":
				var userFormField = new FormUser(contentsContainer, fieldXml,'visible', this);
				break;
			case "refFormField":
				var refFormField = new FormRef(contentsContainer, fieldXml,
						'visible', this);
				break;
			case "timeField":
				html = "<div class=\"formTimeField\" id=\"" + id
						+ "Time\" style=\"vertical-align:middle;"
						+ hiddenStyleOption + "\">";
				html += "	<table width=\"100%\" height=\"100%\" border = 0 cellPadding = 0 cellSpacing = 0 class='formFieldInnerTable'>";
				html += "		<tr>";
				html += "			<td valign='middle'>";
				html += "	<select class=\"formComboBoxField formFieldContentsInput formFieldCondValue\" id=\""
						+ id
						+ "_input\" fieldId='"
						+ formFieldId
						+ "' workspaceId='"
						+ this.workspaceId
						+ "' style='width:100%;height:" + height + "px'>";
				html += MisFormUtil.getTimeOptions();
				html += "	</select>";
				html += "			</td>";
				html += "		</tr>";
				html += "	</table>";
				html += "</div>";
				contentsContainer.innerHTML = html;
				$(id + "_input").value = '09:00';
				break;
			case "textArea":
			case "richEditor":
				//html = "<div id=\"" + id + "_container\" style=\"height: " + height + "px;width:100%;\"></div>"; // height:
																													// " +
																													// height
																													// +
																													// "px;

				html = "<table id=\""
						+ id
						+ "_container\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"height: "
						+ height + "px;width:100%;\">";
				html += "	<tr>";
				html += "		<td>"
						+ this.toTextEditorHtml(fieldXml, defaultLanguage, '',
								height);
				+"</td>";
				html += "	</tr>";
				html += "</table>";

				contentsContainer.innerHTML = html;

				// var editorContainer = $(id + "_container");
				// editorContainer.innerHTML = this.toTextEditorHtml(fieldXml,
				// defaultLanguage, '', height);//"toTextEditorHtml1
				// innerHTML";//this.toTextEditorHtml(fieldXml,
				// defaultLanguage);
				var editorId = this.generateFieldIdByXml(fieldXml) + "_input";
				this.createSmartEditor(editorId, defaultLanguage);
				break;
			case "fileField":
				var contentsDivContainer = new Element("div");
				contentsDivContainer.id = id + "FileInput";
				contentsDivContainer.addClassName("formFieldContentsInput");
				var fileField = new FormFileField(contentsDivContainer,	fieldXml, 'visible', this, contentWidth,null,null);
				contentsContainer.appendChild(contentsDivContainer);
				contentsContainer.addClassName("formFieldContentsFile");
				break;
			case "imageBox":
				var contentsDivContainer = new Element("div");
				contentsDivContainer.id = id + "FileInput";
				contentsDivContainer.addClassName("formFieldContentsInput");
				var fileField = new FormFileField(contentsDivContainer,
						fieldXml, 'visible', this, contentWidth, formatType,
						fitToScreen);

				contentsContainer.appendChild(contentsDivContainer);
				contentsContainer.addClassName("formFieldContentsFileImage");
				break;
			case "numericStepper":
			case "numberInput":
				var contentsDivContainer = new Element("div");
				contentsDivContainer.id = id + "_container";
				contentsDivContainer.addClassName("formFieldContentsInput");
				contentsContainer.appendChild(contentsDivContainer);
//alert('numberInput :::: '+id);
				var numberField = new FormNumberField(contentsDivContainer,	fieldXml, 'visible', this, false);

				jQuery("#" + contentsDivContainer.id).data("formField",	numberField);

				break;
			case "currencyInput":
				var contentsDivContainer = new Element("div");
				contentsDivContainer.id = id + "_container";
				contentsDivContainer.addClassName("formFieldContentsInput");
				contentsContainer.appendChild(contentsDivContainer);

				var formatXml = SmartXMLUtil.getChildNode(fieldXml, 'format');
				var symbol = SmartXMLUtil.getNodeData(SmartXMLUtil
						.getChildNode(formatXml, 'currency'));
				var currencyField = new FormNumberField(contentsDivContainer,
						fieldXml, 'visible', this, false, {
							prefix : symbol
						});
				jQuery("#" + contentsDivContainer.id).data("formField",
						currencyField);
				break;
			case "percentInput":
				var contentsDivContainer = new Element("div");
				contentsDivContainer.id = id + "_container";
				contentsDivContainer.addClassName("formFieldContentsInput");
				contentsContainer.appendChild(contentsDivContainer);

				var percentField = new FormNumberField(contentsDivContainer,
						fieldXml, 'visible', this, false, {
							suffix : "%"
						});
				jQuery("#" + contentsDivContainer.id).data("formField", percentField);
				break;
			case "emailIDInput":
				html = "<div id=\"" + id + "TextInput\" >"; // height: " +
															// height + "px;
				html += "	<input class=\"formTextField formFieldContentsInput formFieldCondValue\" id=\""
						+ id + "_input\"";
				html += " onchange=\"isEMail(this);\"";
				html += " type=\"text\" style=\"width: 100%;"
						+ hiddenStyleOption + "\" fieldId='" + formFieldId
						+ "' workspaceId='" + this.workspaceId + "'/>";
				html += "</div>";
				contentsContainer.innerHTML = html;
				break;
			default:
				html = "<div id=\"" + id + "TextInput\" >"; // height: " +
															// height + "px;
				html += "	<input class=\"formTextField formFieldContentsInput formFieldCondValue\"  id=\""
						+ id
						+ "_input\" type=\"text\" style=\"width: 100%;"
						+ hiddenStyleOption + "\" fieldId='" + formFieldId
						+ "' workspaceId='" + this.workspaceId + "'/>";
				
				html += "</div>";
				contentsContainer.innerHTML = html;
			}
		}

		if (this.mode != 'view' && 'true' == fieldXml.getAttribute('required')) {
			Element.addClassName($(id + "_input"), 'formFieldRequiredValue');
		}
	};

	this.validate = function() {
		return this.layout.validate();
	};

	this.initRecordString = function() {
		return "<?xml version=\"1.0\"?><DataRecord formId=\""
				+ SmartXMLUtil.getChildNode(this.formXml, "form").getAttribute(
						"id") + "\" formVersion=\"1\" workItemId=\"\"/>";
	};
	this.initRecord = function() {
		var recordString = this.initRecordString();
		var recordDoc = Mis.toDocument(recordString);
		return recordDoc.documentElement;
	};
	
/**
 * [윤종국]
 * 필드의정보를 새로고침.
 * 가져오기 등의 설정이 되어있을시 runtime 레이아웃 과 항목 필드들이 생성된후
 * 각 항목 필드에 실제 값이 들어갈 수 있도록 해주는 함수.
 * */	
	this.refreshDataFields = function(fieldId) {
		var thisField = MisFormUtil.getField(SmartXMLUtil.getChildNode(this.formXml,'form'), fieldId);
		var thisMappings = SmartXMLUtil.getChildNodes(thisField,	'mappings');
//alert(SmartXMLUtil.getXMLString(this.formXml));
		var flag = (SmartXMLUtil.getXMLString(this.formXml)).indexOf("mis:getData('self_form', 'this', '"+fieldId+"'") > 0;

		if(!Mis.isEmpty(thisMappings) && flag){
			if (this.isSelfMapping) {
				if (this.useMapping) {
					if (Mis.isNull(this.recordXml)){
						this.recordXml = this.initRecord();
					}
					var mappingRecordXmlStr = SmartXMLUtil.getXMLString(this.getData(this.formXml, this.recordXml));
					this.refreshData(mappingRecordXmlStr);
				}
			} else {
				if (this.useMapping) {
					var targetFieldIdArray = new Array();
					for ( var i = 0; i < this.mappingCondFieldIds.length; i++) {
						var condIdArray = this.mappingCondFieldIds[i];
						for ( var j = 0; j < condIdArray.length; j++) {
							if (condIdArray[j] == fieldId) {
								targetFieldIdArray = jQuery.merge(targetFieldIdArray, condIdArray);
								targetFieldIdArray = jQuery.unique(targetFieldIdArray);
								break;
							}
						}
					}
	
					if (targetFieldIdArray.length > 0) {
						var mappingRecordXml = this.initRecord();
	
						for ( var i = 0; i < targetFieldIdArray.length; i++) {
							var targetfieldId = targetFieldIdArray[i];
							if (targetfieldId != null && targetfieldId != "") {
								var targetFormEntity = MisFormUtil.getField(SmartXMLUtil.getChildNode(this.formXml, 'form'), targetfieldId);
								try {
									this.getFieldData(targetFormEntity,	mappingRecordXml);
								} catch (e) {
									// alert(e);
								}
							}
						}
	
						var mappingRecordXmlStr = SmartXMLUtil.getXMLString(mappingRecordXml);
						this.refreshData(mappingRecordXmlStr);
					}
				}
			}
		}else if(flag){
			if (this.isSelfMapping) {
				if (this.useMapping) {
					if (Mis.isNull(this.recordXml)){
						this.recordXml = this.initRecord();
					}
					var mappingRecordXmlStr = SmartXMLUtil.getXMLString(this.getData(this.formXml, this.recordXml));
//alert(mappingRecordXmlStr);
					this.refreshData(mappingRecordXmlStr);
				}
			}
		}else{
		}
	};

	this.initDataFields = function() {
		if (this.useMapping) {
			var xmlstring = this.initRecordString();
			this.refreshData(xmlstring);
		}
	};
	/*
	 * 아래 함수는 실지로 주석처리를 하여도 문제없이 돌아감... 
	 */
	this.refreshAllDataFields = function() {
		editMode = "edit";
		if(this.useMapping){
			if (this.recordXml == null)
				this.recordXml = this.initRecord();
			 
			this.recordXml = this.initRecordString();
			this.refreshData(this.recordXml);
		}
		editMode = "";
	};
// 필드 값 새로고침.
	this.refreshData = function(mappingRecordXmlStr) {
		FormEnv.comBoBeforeIndex = '';
		var mappingServicesXmls = SmartXMLUtil.getChildNode(SmartXMLUtil.getChildNode(this.formXml, 'form'), 'mappingServices');
		var mappingServiceXml = SmartXMLUtil.getChildNodes(mappingServicesXmls,	'mappingService');
		//alert(mappingServicesXmls.xml+'////'+mappingServiceXml.xml);
		//jk yoon
		var mappingArray = new Array();
		if (mappingServiceXml.length > 0) {
			for ( var i = 0; i < mappingServiceXml.length; i++) {
				var actualParametersXml = SmartXMLUtil.getChildNode(mappingServiceXml[i], 'ActualParameters');
				var actualParameterXml = SmartXMLUtil.getChildNodes(actualParametersXml, 'ActualParmeter');

				var execution = actualParametersXml.getAttribute('Execution');
				var id = mappingServiceXml[i].getAttribute('id');
				var name = mappingServiceXml[i].getAttribute('name');
				var targetServiceId = mappingServiceXml[i].getAttribute('targetServiceId');
				var str = '<mappingService id="' + id + '" name="' + name+ '" targetServiceId="' + targetServiceId+ '" Execution="' + execution + '">';

				if (actualParameterXml.length > 0) {
					for ( var j = 0; j < actualParameterXml.length; j++) {
						str += actualParameterXml[j].xml;
					}
				}
				str += '</mappingService>';
				mappingArray.push(str);
			}
		}
		mappingArray = mappingArray.join("@@");
		realIdx = 0;

		var realStr = "";
		for(var i = 0; i < realCheckList.length; i++){
			if(i != 0) realStr = realStr +"@";
				realStr += realCheckList[i]+"%"+checkFormList[i];
		}

		var req = new Ajax.Request(
				FormEnv.serviceUrl + '/services/runtime/executionService.jsp',
				{
					method : 'post',
					parameters : {
						method : 'refreshDataFields',
						userId : FormEnv.userId,
						formId : SmartXMLUtil.getChildNode(this.formXml, 'form').getAttribute('id'),
						editMode : editMode,
						data : mappingRecordXmlStr,
						mappingServicesXml : mappingArray,
						realStrData : realStr
					},
					onSuccess : function(transport) {
						var response = transport.responseXML;
						if (!Mis.isNull(response)) {
							realCheckList = new Array();
							realCheckIdx = 0;
							comBoIdx2 = 0;
							var record = SmartXMLUtil.getChildNode(response,'DataRecord');
							// if (record == null)
							// return;
							var formRuntime = $(transport.request.options['req']);
							formRuntime.loadData(formRuntime.formXml, record);
							FormEnv.loadDataComplete = false;
						}
					},
					req : this
				});
	};
	// jk 추가
	var comBoIdx2 = 0;
	var comBoArrIdx = 0;
	var realCheckIdx = 0;
	this.readyScreen = false;
	
	/**
	 * [윤종국]
	 * refresh 시에 호출되는 함수. 
	 * FormGridLayout.js 의 loadData 함수롤 호출하고, 
	 * 아래의 loadFieldData 함수를 호출.
	 */
	
	this.loadData = function(formXml, recordXml) {
		this.recordXml = recordXml;
		this.layout.loadData(formXml, recordXml);
		checkFormListIdx = 0;
		FormEnv.comBoMode = false;
	};
	this.loadFieldData = function(fieldXml, dataXml) {
		var valueNode = SmartXMLUtil.getChildNodesByAttrVar(dataXml,'DataField', 'id', fieldXml.getAttribute('id'));
		var format = SmartXMLUtil.getChildNode(fieldXml, 'format');
		var type = format.getAttribute('type');
		if (type == "dataGrid") {
			var id = this.generateFieldIdByXml(fieldXml);
			if (valueNode == null || valueNode.firstChild == null) {
				var dataGridTable = $(id + "_DataGrid");
				if (dataGridTable == null || dataGridTable.rows.length < 1)
					new FormRuntimeDataGrid(this, fieldXml, $(id+ "_DataGridInput"), (this.mode != 'view'));
			} else {
				// 데이터 그리드 동적 row 생성을 위해 데이터 사이즈 만큼 rowCnt를 읽어온다.
				var dataFieldLen = SmartXMLUtil.getChildNodes(valueNode,"DataField").length;
				var rowCnt = (dataFieldLen == 0 ? SmartXMLUtil.getChildNodes(valueNode, "DataField").length : dataFieldLen);

				if (rowCnt > 0) {
					new FormRuntimeDataGrid(this, fieldXml, $(id+ "_DataGridInput"), (this.mode != 'view'), rowCnt);
					var childrenXML = SmartXMLUtil.getChildNode(fieldXml,'children');
					if (childrenXML != null) {
						var formChildEntities = SmartXMLUtil.getChildNodes(childrenXML, 'formEntity');
						if (!Mis.isEmpty(formChildEntities)) {
							for ( var i = 0; i < rowCnt; i++) {
								var gridCulumnData = SmartXMLUtil.getChildNodesByAttrVar(valueNode,'DataField', 'row', i);
								for ( var j = 0; j < formChildEntities.length; j++) {
									this.loadDataGridFieldData(i,formChildEntities[j],gridCulumnData);// 그리드에 데이터 체움
								}
							}
						}
					}
				} else {
					new FormRuntimeDataGrid(this, fieldXml, $(id+ "_DataGridInput"), (this.mode != 'view'));
				}
			}
		} else if (valueNode != null && valueNode.firstChild != null) {
			var valueNode2 = SmartXMLUtil.getChildNodesByAttrVar2(dataXml, 'DataField', 'id', fieldXml.getAttribute('id'));
			this.readyScreen = true;

			if (valueNode2.length > 0) {
				var formatXml = SmartXMLUtil.getChildNode(fieldXml, 'format');
				var formatType = formatXml.getAttribute('type');
				if(formatType == 'comboBox'){
					comBoArrIdx = 0;
					comBoIdx2++;
					if(comBoSelectArr.length < comBoIdx2 || comBoSelectArr.length == 0)
						comBoIdx2 = 0;
//					alert('///'+comBoSelectArr+'//'+comBoIdx2+'///'+comBoSelectArr.length+'///');
// jk
				}

				var realIdx = realCheckIdx++;
				realCheckList[realIdx++] = fieldXml.getAttribute('id');
//alert(valueNode2.str);				
				for ( var ii = 0; ii < valueNode2.length; ii++) {
					var value = valueNode2[ii].firstChild.nodeValue;
					this.loadFieldDataStr(fieldXml, value, valueNode2[ii].getAttribute('refRecordId'));
					this.readyScreen = false;
				}
			}
		}
	};
	
// 필드의 데이터 값을 삽입하기 위한 함수.	
	this.loadFieldDataStr = function(fieldXml, value, refRecordId) {
		var formatXml = SmartXMLUtil.getChildNode(fieldXml, 'format');
		var formatType = formatXml.getAttribute('type');
		var graphicXml = SmartXMLUtil.getChildNode(fieldXml, 'graphic');
		var id = this.generateFieldIdByXml(fieldXml);
/*
if(value!= '' && value != 'undefined' && value != undefined && value != 'false' && value != null)
	checkFormList[checkFormListIdx++] = name;		
 * */		
		if (this.mode == 'view'	|| 'true' == graphicXml.getAttribute('readOnly')) {
			switch (formatType) {
			case 'userField':
				var userField = FormUserUtil.getFormUserByUid(id);
				userField.setValue(refRecordId);
				var html = "";
				if (Mis.isNull(refRecordId)) {
					html += value;
				} else {
					html += "<a onclick=\"FormUserUtil.openUserWindow('";
					html += refRecordId;
					html += "')\" class='userFieldLink'>" + value + "</a>";
				}
				$(id + '_input').innerHTML = html;
				break;
			case 'refFormField':
				var refField = FormRefUtil.getFormRefByUid(id);
				var html = "";
				if (Mis.isNull(refField.refFormId) || Mis.isNull(refRecordId)) {
					html += value;
				} else {
					html += "<a onclick=\"FormRefUtil.openRefWindow('";
					html += refField.refFormId;
					html += "', '";
					html += refRecordId;
					html += "')\" class='refFieldLink'>";
					html += value;
					html += "</a>";
				}
				$(id + '_input').innerHTML = html;
				break;
			case 'textArea':
			case 'datagrid':

				break;
			case 'richEditor':
				var input = $(id + "_input");
				var editorContents = value;
				input.setAttribute('style', 'height:'+value.length);
				input.innerHTML = editorContents;
				break;
			case 'fileField':
				var fileField = FormFileFieldUtil.getFormFileByUid(id);
				fileField.setValue(value);
				fileField.setName(value);
				break;
			case 'imageBox':
				var fileField = FormFileFieldUtil.getFormFileByUid(id);
				fileField.setValue(value);
				fileField.setName(value);
				break;
			case 'numericStepper':
			case 'numberInput':
				var numberField = jQuery("#" + id + "_container").data(
						'formField');
				numberField.setValue(value);
				break;
			case 'percentInput':
				var percentField = jQuery("#" + id + "_container").data(
						'formField');
				percentField.setValue(value);
				break;
			case 'currencyInput':
				var currencyField = jQuery("#" + id + "_container").data(
						'formField');
				currencyField.setValue(value);
				break;
			case 'dateChooser':
				var input = $(id + "_input");
				var timeIndex = value.indexOf('00:00:00.0', 0);
				if (timeIndex != -1) {
					input.innerHTML = value.substring(0, timeIndex);
				} else
					input.innerHTML = value;
				break;
			case 'timeField':
				var input = $(id + "_input");
				input.innerHTML = MisFormUtil.toViewTime(value.substring(0, 5));
				break;
			case 'checkBox':
				var input = $(id + "_input");
				input.innerHTML = (value == 'true') ? FormLang.checkFieldTrue
						: FormLang.checkFieldFalse;
				break;
			case 'emailIDInput':
				var html = "<a href=\"mailto:" + value
						+ "\" class=\"refFieldLink\">" + value + "</a>";
				$(id + '_input').innerHTML = html;
				break;
			default:
				var input = $(id + "_input");
				//input.setAttribute('style','text-overflow: ellipsis; word-wrap: break-word; word-break: break-all;');
				input.innerHTML = value;
			}
		} else {
			switch (formatType) {
			case 'radioButton':
				var radioButtonDiv = $(id + "Radio");
				for(var i = 0 ; i < radioButtonDiv.childNodes.length ; i++){
					if(radioButtonDiv.childNodes[i].name == id + "_input"){
						if(radioButtonDiv.childNodes[i].getAttribute('value') == value){
							radioButtonDiv.childNodes[i].checked = true;
						}
					}
				}
				/*
			case 'radioButton':
				var radioButtonDiv = $(id + "Radio");
				var str = "<input type='radio' name='" + id + "_input' value='"
						+ value + "'>";

				var sp1 = document.createElement(str);
				sp1.setAttribute('style', 'vertical-align:middle;');
				radioButtonDiv.appendChild(sp1);
				radioButtonDiv.appendChild(document.createTextNode(value));
				for ( var i = 0; i < radioButtonDiv.childNodes.length; i++) {
					if (radioButtonDiv.childNodes[i].name == id + "_input") {
						if (radioButtonDiv.childNodes[i].getAttribute('value') == value) {
							radioButtonDiv.childNodes[i].checked = true;
						}
					}
				}
				break;
				 */
				break;
			case 'comboBox':
				var selectValue = '';
				try{
					selectValue = comBoSelectArr[comBoIdx2-1];
				}catch(e){
				}
				if(selectValue == '' || selectValue == undefined || selectValue == 'undefined'){
					selectValue = value;
				}
				
				//if(comboSelectArr.length <1) comboSelectArr[0] = value;
				var formComboBox = $(id + "_input");
				// jk yoon
				if(!FormEnv.comBoMode){
					if (this.readyScreen && refRecordId ==null) {
						for ( var ci = formComboBox.length-1; ci >= 0 ; ci--) {
							try{
								formComboBox.remove(ci);
							}catch(e){
								//alert(e);
							}
						}
					}
					if(refRecordId == null){
						var new_option = new Option(value, value);
						formComboBox.options.add(new_option, 0);
					}
					var options = formComboBox.childNodes;
					for ( var i = 0; i < options.length; i++) {
						var item = options.item(i);
						if (item.getAttribute('value') == selectValue) {
							formComboBox.selectedIndex = i;
						}
					}
				}else{
					var new_option = new Option(value, value);
					formComboBox.options.add(new_option, 0);
					var options = formComboBox.childNodes;
					for ( var i = 0; i < options.length; i++) {
						var item = options.item(i);
						if (item.getAttribute('value') == value) {
							formComboBox.selectedIndex = i;
						}
					}
				}
				// formComboBox.value = value;
				break;
			case 'checkBox':
				var formCheckBox = $(id + "_input");
				formCheckBox.checked = (value == 'true');
				break;
			case 'dateChooser':
				var input = $(id + "_input");
				var timeIndex = value.indexOf('00:00:00.0', 0);
				if (timeIndex != -1) {
					input.value = value.substring(0, timeIndex);
				} else
					input.value = value;
				break;
			/*
			 * case 'textArea': var input = $(id + "_input"); input.value =
			 * value; break;
			 */
			case 'dataGrid':
				break;
			case 'userField':
				var userField = FormUserUtil.getFormUserByUid(id);
				userField.setName(value);
				userField.setValue(refRecordId);
				break;
			case 'refFormField':
				var refField = FormRefUtil.getFormRefByUid(id);
				refField.setName(value);

				refField.setValue(refRecordId);
				break;
			case 'timeField':
				var timeComboBox = $(id + "_input");
				timeComboBox.value = value.substring(0, 5);
				break;
			case 'textArea':
			case 'richEditor':
				var editorContainer = $(id + "_container");
				var height = parseFloat(editorContainer.style.height);// parseFloat(MisFormUtil.getFieldHeight(fieldXml));

				var htmlText = this.toTextEditorHtml(fieldXml, defaultLanguage, value, height);
				var editorId = this.generateFieldIdByXml(fieldXml) + "_input";

				$(editorId).value = value;

				try{
				     var tBody = editorContainer.getElementsByTagName("tbody")[0];
				     var tr = tBody.getElementsByTagName("tr")[0];
				     var td = tr.getElementsByTagName("td")[0];
				     var iframe = td.getElementsByTagName("iframe")[0];
				     var html = iframe.contentWindow.document.getElementsByTagName("html")[0];
				     var childBody = html.getElementsByTagName("body")[0];
				     var editorIframe = childBody.getElementsByTagName("iframe")[0];
				     var editorHtml = editorIframe.contentWindow.document.getElementsByTagName("html")[0];
				     var editorBody = editorHtml.getElementsByTagName("body")[0];
				     editorBody.innerHTML = value;
				    }catch(e){
			    }

				//$(editorId).innerHTML = value;
				
				//alert($(editorId)+'///'+value);

				//document.getElementById(editorId).innerHTML = value;

				//editorContainer.innerHTML = htmlText;
				// this.createSmartEditor(editorId, defaultLanguage);

				// var htmlText = this.toTextEditorHtml(fieldXml,
				// defaultLanguage, value, 0);
				// var editorId = this.generateFieldIdByXml(fieldXml) +
				// "_input";
				// $(editorId).show();
				// document.getElementById(editorId).innerHTML = value;
				/*
				 * this.createSmartEditor(editorId, defaultLanguage);
				 * 
				 * editorId.innerHTML = htmlText;
				 */
				// var editorId = this.generateFieldIdByXml(fieldXml) +
				// "_input";
				// oEditors.getById[editorId].exec("PASTE_HTML", [value]);
				break;
			case 'fileField':
				var fileField = FormFileFieldUtil.getFormFileByUid(id);
				fileField.setValue(value);
				fileField.setName(value);
				break;
			case 'imageBox':
				var fileField = FormFileFieldUtil.getFormFileByUid(id);
				fileField.setValue(value);
				fileField.setName(value);
				break;
			case 'numericStepper':
			case 'numberInput':
				var numberField = jQuery("#" + id + "_container").data(
						'formField');
				numberField.setValue(value);
				break;
			case 'currencyInput':
				var currencyField = jQuery("#" + id + "_container").data(
						'formField');
				currencyField.setValue(value);
				break;
			case 'percentInput':
				var percentField = jQuery("#" + id + "_container").data(
						'formField');
				percentField.setValue(value);
				break;
			default:
				var input = $(id + "_input");
				input.value = value;
			}
		}
	};

	this.loadDataGridFieldData = function(row, fieldXml, dataXml) {
		var valueNode = SmartXMLUtil.getChildNodesByAttrVar(dataXml,'DataField', 'id', fieldXml.getAttribute('id'));
		if (valueNode != null && valueNode.firstChild != null) {
			this.loadDataGridFieldDataStr(row, fieldXml,valueNode.firstChild.nodeValue, valueNode
							.getAttribute('refRecordId'));
		}
	};

	this.loadDataGridFieldDataStr = function(row, fieldXml, value, refRecordId) {
		var formatXml = SmartXMLUtil.getChildNode(fieldXml, 'format');
		var formatType = formatXml.getAttribute('type');
		var graphicXml = SmartXMLUtil.getChildNode(fieldXml, 'graphic');
		var id = this.generateFieldIdByXml(fieldXml);
		if (this.mode == 'view'
				|| 'true' == graphicXml.getAttribute('readOnly')) {
			switch (formatType) {
			case 'refFormField':
				var refField = FormRefUtil.getFormRefByUid(id + "_" + row);
				var html = "";
				if (Mis.isNull(refField.refFormId) || Mis.isNull(refRecordId)) {
					html += value;
				} else {
					html += "<a onclick=\"FormRefUtil.openRefWindow('";
					html += refField.refFormId;
					html += "', '";
					html += refRecordId;
					html += "')\" class='refFieldLink'>";
					html += value;
					html += "</a>";
				}
				$(id + "_" + row + '_input').innerHTML = html;
				break;
			case 'userField':
				var userField = FormUserUtil.getFormUserByUid(id + "_" + row);
				userField.setValue(refRecordId);
				var html = "";
				if (Mis.isNull(refRecordId)) {
					html += value;
				} else {
					html += "<a onclick=\"FormUserUtil.openUserWindow('";
					html += refRecordId;
					html += "')\" class='userFieldLink'>" + value + "</a>";
				}
				$(id + "_" + row + '_input').innerHTML = html;
				break;
			case 'dateChooser':
				var input = $(id + "_" + row + "_input");
				var timeIndex = value.indexOf('00:00:00.0', 0);
				if (timeIndex != -1) {
					input.innerHTML = value.substring(0, timeIndex);
				} else
					input.innerHTML = value;
				break;
			case 'timeField':
				var input = $(id + "_" + row + "_input");
				input.innerHTML = MisFormUtil.toViewTime(value.substring(0, 5));
				break;
			case 'numberInput':
				var numberField = jQuery("#" + id + "_" + row + "NumberInput")
						.data('formField');
				numberField.setValue(value);
				break;
			case 'percentInput':
				var percentField = jQuery("#" + id + "_" + row + "PercentInput")
						.data('formField');
				percentField.setValue(value);
				break;
			case 'currencyInput':
				var currencyField = jQuery(
						"#" + id + "_" + row + "CurrencyInput").data(
						'formField');
				currencyField.setValue(value);
				break;
			case 'emailIDInput':
				var html = "<a href=\"mailto:" + value
						+ "\" class=\"refFieldLink\">" + value + "</a>";
				var input = $(id + "_" + row + "_input");
				input.innerHTML = html;
				break;
			default:
				var input = $(id + "_" + row + "_input");
				input.innerHTML = value;
			}
		} else {
			switch (formatType) {
			case 'comboBox':
				var formComboBox = $(id + "_" + row + "_input");
				var options = formComboBox.childNodes;
				for ( var i = 0; i < options.length; i++) {
					var item = options.item(i);
					if (item.getAttribute('value') == value) {
						formComboBox.selectedIndex = i;
					}
				}
				break;
			case 'dateChooser':
				var input = $(id + "_" + row + "_input");
				var timeIndex = value.indexOf('00:00:00.0', 0);
				if (timeIndex != -1) {
					input.value = value.substring(0, timeIndex);
				} else
					input.value = value;
				break;
			case 'refFormField':
				var refField = FormRefUtil.getFormRefByUid(id + "_" + row);
				refField.setName(value);
				refField.setValue(refRecordId);
				break;
			case 'userField':
				var userField = FormUserUtil.getFormUserByUid(id + "_" + row);
				userField.setName(value);
				userField.setValue(refRecordId);
				break;
			case 'timeField':
				var timeComboBox = $(id + "_" + row + "_input");
				timeComboBox.value = value.substring(0, 5);
				break;
			case 'numberInput':
				var numberField = jQuery("#" + id + "_" + row + "NumberInput")
						.data('formField');
				numberField.setValue(value);
				break;
			case 'currencyInput':
				var currencyField = jQuery(
						"#" + id + "_" + row + "CurrencyInput").data(
						'formField');
				currencyField.setValue(value);
				break;
			case 'percentInput':
				var percentField = jQuery("#" + id + "_" + row + "PercentInput")
						.data('formField');
				percentField.setValue(value);
				break;
			default:
				var input = $(id + "_" + row + "_input");
				input.value = value;
			}
		}
	};

	this.getData = function(formXml, recordXml) {
		if (this.formXml == null && !Mis.isNull(formXml))
			this.formXml = formXml;
		if (recordXml == null)
			recordXml = this.initRecord();
		// if (this.layout == null)
		// this.layout
		return this.layout.getData(this.formXml, recordXml);
	};

	this.getFieldData = function(fieldXml, recordXml) {
	
		var fieldData = SmartXMLUtil.getChildNodesByAttrVar(recordXml,'DataField', 'id', fieldXml.getAttribute('id'));
		var formatXml = SmartXMLUtil.getChildNode(fieldXml, 'format');
		var formatType = formatXml.getAttribute('type');

		// if (formatType == 'dataGrid' && fieldData != null) {
		// recordXml.removeChild(fieldData);
		// fieldData = null;
		// }
		if (fieldData == null) {
			fieldData = recordXml.ownerDocument.createElement('DataField');
			fieldData.setAttribute('id', fieldXml.getAttribute('id'));
			fieldData.setAttribute('name', fieldXml.getAttribute('name'));
			recordXml.appendChild(fieldData);
		}
		var fieldValues = this.getFieldDataStr(fieldXml);
		var value = fieldValues['value'];
		var name = fieldValues['name'];
//alert(name +'///'+ value);		
		if (typeof (name) != 'undefined' && typeof (value) != 'undefined') {

			if (formatType == 'refFormField') {
				var refFormXml = SmartXMLUtil.getChildNode(formatXml, 'refForm');
				var refFormFieldXml = SmartXMLUtil.getChildNode(refFormXml,'field');

				fieldData.setAttribute('refForm', refFormXml.getAttribute('id'));
				fieldData.setAttribute('refFormField', refFormFieldXml.getAttribute('id'));
				fieldData.setAttribute('refRecordId', value);
			} else if (formatType == 'userField') {
				fieldData.setAttribute('refForm', FormUserUtil.refFormId);
				fieldData.setAttribute('refFormField', FormUserUtil.refFieldId);
				fieldData.setAttribute('refRecordId', value);
			} else if (formatType == 'numberInput'
					|| formatType == 'currencyInput'
					|| formatType == 'percentInput'
					|| formatType == 'numericStepper') {
				name = value;
				fieldData.setAttribute('refForm', '');
				fieldData.setAttribute('refFormField', '');
				fieldData.setAttribute('refRecordId', '');
			} else {
				fieldData.setAttribute('refForm', '');
				fieldData.setAttribute('refFormField', '');
				fieldData.setAttribute('refRecordId', '');
			}

			if (fieldData.firstChild != null) {
				fieldData.removeChild(fieldData.firstChild);
			}
			fieldData.appendChild(recordXml.ownerDocument.createTextNode(name));
		}

		if (formatType == 'dataGrid') {
			var datagrid = $(this.generateFieldId(fieldXml.getAttribute('id')+ "_DataGrid"));
			datagrid = datagrid.childNodes[1];
			var rowCnt = datagrid.childNodes.length;
			if (rowCnt > 0) {
				var childrenXML = SmartXMLUtil.getChildNode(fieldXml,'children');
				if (childrenXML == null)
					return;

				var formChildEntities = SmartXMLUtil.getChildNodes(childrenXML,	'formEntity');
				if (Mis.isEmpty(formChildEntities))
					return;
				for ( var i = 0; i < rowCnt; i++) {
					var gridCulumnData = SmartXMLUtil.getChildNodesByAttrVar(fieldData, 'DataField', 'row', i);
					if (gridCulumnData == null) {
						gridCulumnData = fieldData.ownerDocument.createElement('DataField');
						gridCulumnData.setAttribute('row', i);
						fieldData.appendChild(gridCulumnData);
					}
					for ( var j = 0; j < formChildEntities.length; j++)
						this.getDataGridFieldData(i, formChildEntities[j],gridCulumnData);
				}
			}
		}
	};

	this.getDataGridFieldData = function(row, fieldXml, recordXml) {	
		var fieldData = SmartXMLUtil.getChildNodesByAttrVar(recordXml,'DataField', 'id', fieldXml.getAttribute('id'));
		if (fieldData == null) {
			fieldData = recordXml.ownerDocument.createElement('DataField');
			fieldData.setAttribute('id', fieldXml.getAttribute('id'));
			fieldData.setAttribute('name', fieldXml.getAttribute('name'));
			recordXml.appendChild(fieldData);
		}

		var fieldValues = this.getDataGridFieldDataStr(row, fieldXml);
		var value = fieldValues['value'];
		var name = fieldValues['name'];

		var formatXml = SmartXMLUtil.getChildNode(fieldXml, 'format');
		var formatType = formatXml.getAttribute('type');

		if (typeof (name) != 'undefined' && typeof (value) != 'undefined') {
			if (formatType == 'refFormField') {
				var refFormXml = SmartXMLUtil
						.getChildNode(formatXml, 'refForm');
				var refFormFieldXml = SmartXMLUtil.getChildNode(refFormXml,
						'field');
				fieldData
						.setAttribute('refForm', refFormXml.getAttribute('id'));
				fieldData.setAttribute('refFormField', refFormFieldXml
						.getAttribute('id'));
				fieldData.setAttribute('refRecordId', value);
			} else if (formatType == 'userField') {
				fieldData.setAttribute('refForm', FormUserUtil.refFormId);
				fieldData.setAttribute('refFormField', FormUserUtil.refFieldId);
				fieldData.setAttribute('refRecordId', value);
			} else if (formatType == 'numberInput'
					|| formatType == 'currencyInput'
					|| formatType == 'percentInput'
					|| formatType == 'numericStepper') {
				name = value;
				fieldData.setAttribute('refForm', '');
				fieldData.setAttribute('refFormField', '');
				fieldData.setAttribute('refRecordId', '');
			} else {
				fieldData.setAttribute('refForm', '');
				fieldData.setAttribute('refFormField', '');
				fieldData.setAttribute('refRecordId', '');
			}

			if (fieldData.firstChild != null) {
				fieldData.removeChild(fieldData.firstChild);
			}

		}

		fieldData.appendChild(recordXml.ownerDocument.createTextNode(name));
	};

	this.getDataGridFieldDataStr = function(row, fieldXml) {
		var value;
		var name;

		var id = this.generateFieldIdByXml(fieldXml);
		var rowId = id + "_" + row;

		var graphicXml = SmartXMLUtil.getChildNode(fieldXml, 'graphic');
		var formatType = (SmartXMLUtil.getChildNode(fieldXml, 'format'))
				.getAttribute('type');

		if ('true' == graphicXml.getAttribute('readOnly')) {
			switch (formatType) {
			case 'numberInput':
				var numberField = jQuery("#" + rowId + "NumberInput").data(
						'formField');
				value = numberField.getValue();
				name = numberField.getName();
				break;
			case 'percentInput':
				var percentField = jQuery("#" + rowId + "PercentInput").data(
						'formField');
				name = percentField.getName();
				value = percentField.getValue();
				break;
			case 'currencyInput':
				var currencyField = jQuery("#" + rowId + "CurrencyInput").data(
						'formField');
				name = currencyField.getName();
				value = currencyField.getValue();
				break;
			case 'userField':
				var userField = FormUserUtil.getFormUserByUid(rowId);
				value = userField.getValue();
				name = userField.getName();
				break;
			case 'refFormField':
				var refField = FormRefUtil.getFormRefByUid(rowId);
				value = refField.getValue();
				name = refField.getName();
				break;
			case 'timeField':
				value = MisFormUtil.toRealTime(input.innerHTML);
				name = value;
				break;
			default:
				var input = $(rowId + "_input");
				value = input.innerHTML;
				name = value;
			}
		} else {
			switch (formatType) {
			case 'numberInput':
				var field = jQuery("#" + id + "_0" + "NumberInput").data(
						'formField');
				var prefix = field.prefix;
				var suffix = field.suffix;
				var input = document.getElementsByName(id + "_input")[row];
				name = input.value;
				value = Mis.toNotNull(NumberFormatter.toNumber(name, prefix,
						suffix));
				break;
			case 'percentInput':
				var field = jQuery("#" + id + "_0" + "PercentInput").data(
						'formField');
				var prefix = field.prefix;
				var suffix = field.suffix;
				var input = document.getElementsByName(id + "_input")[row];
				name = input.value;
				value = Mis.toNotNull(NumberFormatter.toNumber(name, prefix,
						suffix));
				break;
			case 'currencyInput':
				var field = jQuery("#" + id + "_0" + "CurrencyInput").data(
						'formField');
				var prefix = field.prefix;
				var suffix = field.suffix;
				var input = document.getElementsByName(id + "_input")[row];
				name = input.value;
				value = Mis.toNotNull(NumberFormatter.toNumber(name, prefix,
						suffix));
				break;
			case 'userField':
				var userField = FormUserUtil.getFormUserByName(id, row);
				value = userField.getValue();
				name = userField.getName();
				break;
			case 'refFormField':
				var refField = FormRefUtil.getFormRefByName(id, row);
				value = refField.getValue();
				name = refField.getName();
				break;
			default:
				var input = document.getElementsByName(id + "_input")[row];
				value = input.value;
				name = value;
			}
		}

		if (value == '&nbsp;') {
			value = '';
		}
		if (name == '&nbsp;') {
			name = '';
		}
		return {
			name : name,
			value : value
		};
	};
//jk yoon
// 필드에 실제 값 채워 넣는 함수
	this.getFieldDataStr = function(fieldXml) {
		var value;
		var name;

		var id = this.generateFieldIdByXml(fieldXml);
		var graphicXml = SmartXMLUtil.getChildNode(fieldXml, 'graphic');
		var formatType = (SmartXMLUtil.getChildNode(fieldXml, 'format')).getAttribute('type');

		if (graphicXml.getAttribute('readOnly') == "true") {
			switch (formatType) {
			case 'userField':
				var userField = FormUserUtil.getFormUserByUid(id);
				value = userField.getValue();
				name = userField.getName();
//alert(value+'///'+name);
				break;
			case 'refFormField':
				var refField = FormRefUtil.getFormRefByUid(id);
				value = refField.getValue();
				name = refField.getName();
				break;
			case 'textArea':
			case 'richEditor':
				var input = $(id + "_input");
				value = input.innerHTML;
				name = input.innerHTML;
				break;
			case 'fileField':
				var fileField = FormFileFieldUtil.getFormFileByUid(id);
				name = fileField.getValue();
				value = fileField.getValue();
				break;
			case 'imageBox':
				var fileField = FormFileFieldUtil.getFormFileByUid(id);
				name = fileField.getValue();
				value = fileField.getValue();
				break;
			case 'numericStepper':
			case 'numberInput':
				var numberField = jQuery("#" + id + "_container").data(
						'formField');
				name = numberField.getName();
				value = numberField.getValue();
				break;
			case 'percentInput':
				var percentField = jQuery("#" + id + "_container").data(
						'formField');
				name = percentField.getName();
				value = percentField.getValue();
				break;
			case 'currencyInput':
				var currencyField = jQuery("#" + id + "_container").data(
						'formField');
				name = currencyField.getName();
				value = currencyField.getValue();
				break;
			case 'dateChooser':
				var input = $(id + "_input");
				value = input.innerHTML;
				name = value;
				break;
			case 'timeField':
				var input = $(id + "_input");
				value = MisFormUtil.toRealTime(input.innerHTML);
				name = value;
				break;
			case 'checkBox':
				var input = $(id + "_input");
				value = (input.innerHTML == FormLang.checkFieldTrue);
				name = value;
				break;
			default:
				var input = $(id + "_input");
				value = input.innerHTML;
				name = input.innerHTML;
				value = name;
			}
		} else {
			switch (formatType) {
			case 'radioButton':
				var radioButtonDiv = $(id + "Radio");
				for ( var i = 0; i < radioButtonDiv.childNodes.length; i++) {
					if (radioButtonDiv.childNodes[i].name == id + "_input") {
						if (radioButtonDiv.childNodes[i].checked == true) {
							value = radioButtonDiv.childNodes[i]
									.getAttribute('value');
							name = value;
						}
					}
				}
				break;
			case 'comboBox':
				var formComboBox = $(id + "_input");
				value = formComboBox.value;
				name = value;
//jk yoon 
				comBoSelectArr[comBoArrIdx++] = value;				
				break;
			case 'checkBox':
				var formCheckBox = $(id + "_input");
				value = (formCheckBox.checked) ? 'true' : 'false';
				name = value;
				break;
			case 'dateChooser':
				var input = $(id + "_input");
				value = input.getValue();
				name = value;
				break;
			case 'dataGrid':
				break;
			case 'userField':
				var userField = FormUserUtil.getFormUserByUid(id);
				value = userField.getValue();
				name = userField.getName();
				break;
			case 'refFormField':
				var refField = FormRefUtil.getFormRefByUid(id);
				value = refField.getValue();
				name = refField.getName();
				break;
			case 'timeField':
				var timeComboBox = $(id + "_input");
				name = timeComboBox.value;
				value = timeComboBox.value;
				break;
			case 'textArea':
			case 'richEditor':
				//oEditors.getById[id + "_input"].exec("UPDATE_IR_FIELD", []);
				var editerContents = oEditors.getById[id + "_input"].getIR();
				name = editerContents;// oEditor.GetXHTML( false );
				value = editerContents;// oEditor.GetXHTML( false );
				break;
			case 'fileField':
				var fileField = FormFileFieldUtil.getFormFileByUid(id);
				name = fileField.getValue();
				value = fileField.getValue();
				break;
			case 'imageBox':
				var fileField = FormFileFieldUtil.getFormFileByUid(id);
				name = fileField.getValue();
				value = fileField.getValue();
				break;
			case 'numericStepper':
			case 'numberInput':
				//var numberField = jQuery("#" + id + "_container").data('formField');
				//name = numberField.getName();
				//value = numberField.getValue();
				// jk yoon : numberInput Field refreshData error
					try{
						var numberFieldTemp = $(id+'_input').value;
						if(numberFieldTemp.indexOf(',')>-1){
							numberFieldTemp = numberFieldTemp.split(",").join("");
						}
						name = numberFieldTemp;
						value = numberFieldTemp;
					}catch(e){
						name = '';
						value = '';
					}
				break;
			case 'percentInput':
				var percentField = jQuery("#" + id + "_container").data('formField');
				name = percentField.getName();
				value = percentField.getValue();
				break;
			case 'currencyInput':
				//var currencyField = jQuery("#" + id + "_container").data('formField');
				//name = currencyField.getName();
				//value = currencyField.getValue();
				// jk yoon : currencyInput Field refreshData error
				try{
					var currencyFieldTemp = $(id+'_input').value;
					if(currencyFieldTemp.indexOf("￦") > -1){
							currencyFieldTemp = currencyFieldTemp.split("￦").join("");
					}
					if(currencyFieldTemp.indexOf(",") > -1){
						currencyFieldTemp = currencyFieldTemp.split(",").join("");
					}
					name = currencyFieldTemp;
					value = currencyFieldTemp;
				}catch(e){
					name = '';
					value = '';
				}
				
				break;
			default:
				var input = $(id + "_input");
				value = input.getValue();
				name = value;
			}
		}
		if (value == '&nbsp;') {
			value = '';
		}
		if (name == '&nbsp;') {
			name = '';
		}
		
		if(name != '' && name != 'undefined' && name != undefined && name != 'false' && name != null)
			checkFormList[checkFormListIdx++] = name;
		
		return {
			name : name,
			value : value
		};
	};
	this.getOptionName = function(combo) {
		var opts = combo.options;
		for ( var i = 0; i < opts.length; i++) {
			if (opts.item(i).value == combo.value)
				return opts.item(i).firstChild.nodeValue;
		}
		return "";
	};
	this.generateFieldIdByXml = function(fieldXml) {
		return this.generateFieldId(fieldXml.getAttribute('id'));
	};
	this.generateFieldId = function(id) {
		return this.workspaceId + '_formField_' + id;
	};
	//jk
	this.refreshCombo = function () {
		var mappingRecordXmlStr = SmartXMLUtil.getXMLString(this.getData(this.formXml, this.recordXml));
		this.refreshData(mappingRecordXmlStr);
	}
}; // End of FormRuntime




var MisFormUtil = {
	getField : function(container, fieldId) {
		var children = Mis.getChildNode(container, "children");
		if (children == null)
			return null;
		
		var fields = SmartXMLUtil.getChildNodes(children, "formEntity");
		if (Mis.isEmpty(fields))
			return null;

		for ( var i = 0; i < fields.length; i++) {
			var field = fields[i];
			if (field.getAttribute("id") == fieldId)
				return field;

			var subField = MisFormUtil.getField(field, fieldId);
			if (subField != null)
				return subField;
		}

		return null;
	},
	getMaxColumnLength : function(layoutXml) {
		var rowsXml = SmartXMLUtil.getChildNodes(layoutXml, "gridRow");
		var colsXml = SmartXMLUtil.getChildNodes(rowsXml[0], "gridCell");
		var colLen = 0;
		for ( var i = 0; i < colsXml.length; i++)
			colLen += parseInt(colsXml[i].getAttribute('span'));
		return colLen;
	},
	existChild : function(workSpace, id) {
		for ( var i = 0; i < workSpace.childNodes.length; i++) {
			if ((workSpace.childNodes[i]).id == id) {
				return true;
			}
		}
		return false;
	},
	getFieldFormatType : function(field) {
		var format = Mis.getChildNode(field, "format");
		if (format == null)
			return "textInput";
		return Mis.toDefault(format.getAttribute("type"), "textInput");
	},
	getFieldLabelWidth : function(field) {
		var graphic = Mis.getChildNode(field, 'graphic');
		if (graphic == null)
			return MisFormUtil.getFieldDefaultLabelWidth(field);

		var labelWidth = graphic.getAttribute("labelWidth");
		if (!Mis.isNull(labelWidth) && labelWidth > 0)
			return labelWidth;

		var label = Mis.getChildNode(graphic, "label");
		if (label == null)
			return MisFormUtil.getFieldDefaultLabelWidth(field);

		// deprecated value
		labelWidth = label.getAttribute('size');
		if (!Mis.isNull(labelWidth) && labelWidth > 0)
			return labelWidth;

		return MisFormUtil.getFieldDefaultLabelWidth(field);
	},
	// private
	getFieldDefaultLabelWidth : function(field) {
		return (FormEnv.getControlConfig(MisFormUtil.getFieldFormatType(field)))["labelWidth"];
	},
	getFieldContentWidth : function(field) {
		var graphic = Mis.getChildNode(field, 'graphic');
		if (graphic == null)
			return getFieldDefaultContentWidth();

		var contentWidth = graphic.getAttribute("contentWidth");
		if (!Mis.isNull(contentWidth) && contentWidth > 0)
			return contentWidth;

		// deprecated value
		contentWidth = graphic.getAttribute('contentsSize');
		if (!Mis.isNull(contentWidth) && contentWidth > 0)
			return contentWidth;

		return MisFormUtil.getFieldDefaultContentWidth(field);
	},
	getFieldDefaultContentWidth : function(field) {
		return (FormEnv.getControlConfig(MisFormUtil.getFieldFormatType(field)))["contentWidth"];
	},
	getFieldHeight : function(field) {
		var format = SmartXMLUtil.getChildNode(field, 'format');
		var type = format.getAttribute('type');
		var graphic = SmartXMLUtil.getChildNode(field, 'graphic');
		var height = graphic.getAttribute('height');
		if (height == -1)
			height = (FormEnv.getControlConfig(type))['height'];
		return height;
	},
	getFieldOverflowY : function(field) {
		var graphic = SmartXMLUtil.getChildNode(field, 'graphic');
		var verticalScrollPolicy = graphic.getAttribute("verticalScrollPolicy");
		return Mis.toBoolean(verticalScrollPolicy, true) ? "auto" : "visible";
	},
	checkValidate : function(id) {
		if ((id).endsWith("_input")) {
			var prefix = (id).substr(0, id.length - 6);
			if ($(id).value == null || $(id).value == '') {
				//Element.setStyle($(id), {backgroundColor : '#FE96AA'});
				Element.setStyle($(id), {
					backgroundColor : ''
				});
			} else {
				Element.setStyle($(id), {
					backgroundColor : ''
				});
			}
		}
	},
	removeTableRows : function(datagrid) {
		datagrid = document.getElementById(datagrid);
		var clintAgent = navigator['userAgent'];
		var indexCt = 1;
		// if(clintAgent['search'](/Safari|Firefox/g) > -1) {
		// datagrid = datagrid.childNodes[3];
		// indexCt = 2;
		// } else {
		datagrid = datagrid.childNodes[1];
		// }
		var objCNs = datagrid.childNodes;
		for ( var i = 0; i < objCNs.length; i += indexCt) {
			if (objCNs[i].childNodes[0].childNodes[0].checked) {
				datagrid.removeChild(objCNs[i]);
				if (indexCt == 2)
					datagrid.removeChild(objCNs[i]);
				i -= indexCt;
			}
		}
	},
	getTimeOptions : function() {
		var timeOptions = "";
		for ( var i = 0; i < 24; i++) {
			var viewHour;
			var realHour;
			if (i > 12) {
				viewHour = i - 12;
			} else {
				viewHour = i;
			}
			if (viewHour < 10) {
				viewHour = '0' + viewHour;
			}
			if (i < 10) {
				realHour = '0' + i;
			} else {
				realHour = '' + i;
			}
			for ( var j = 0; j < 2; j++) {
				timeOptions += "<option value='"
						+ realHour
						+ ":"
						+ ((j == 0) ? "00" : "30")
						+ "'>"
						+ ((i > 11) ? FormLang.timeFieldPM
								: FormLang.timeFieldAM) + " " + viewHour + ":"
						+ ((j == 0) ? "00" : "30") + "</option>";
			}
		}
		return timeOptions;
	},
	toViewTime : function(realTime) {
		var realHour = parseFloat(realTime.substr(0, 2));
		var realMin = realTime.substr(3, 2);

		var viewHour;

		if (realHour > 12) {
			viewHour = realHour - 12;
		} else {
			viewHour = realHour;
		}
		if (viewHour < 10) {
			viewHour = '0' + viewHour;
		}

		return ((realHour > 11) ? FormLang.timeFieldPM : FormLang.timeFieldAM)
				+ " " + viewHour + ":" + realMin;
	},
	toRealTime : function(viewTime) {
		var time;
		var pmIdx = viewTime.lastIndexOf(FormLang.timeFieldPM);
		if (pmIdx == -1) {
			var amIdx = viewTime.lastIndexOf(FormLang.timeFieldAM);
			time = viewTime.substr(amIdx + FormLang.timeFieldAM.length + 1,
					viewTime.length - (amIdx + FormLang.timeFieldAM.length));
		} else {
			time = viewTime.substr(pmIdx + FormLang.timeFieldPM.length + 1,
					viewTime.length - (pmIdx + FormLang.timeFieldPM.length));
		}
		var sepIdx = time.indexOf(':');
		var hTime = parseFloat(time.substr(0, sepIdx));
		if (pmIdx == -1) {
			if (hTime == 0) {
				hTime = 24;
			}
		} else {
			hTime = hTime + 12;
		}
		return ((hTime < 10) ? '0' + hTime : hTime)
				+ time.substr(sepIdx, time.length - sepIdx);
	}
};

var FormUserUtil = {
	getFormUserByUid : function(uid) {
		return FormUserUtil.getFormUserByUserFieldId(uid + "_userField");
	},
	getFormUserByName : function(name, index) {
		return FormUserUtil.getFormUserByUserFieldName(name + "_userField",
				index);
	},
	getFormUserByUserFieldId : function(id) {
		var formFieldBtn = $(id);
		if (formFieldBtn != null & formFieldBtn != "undefined") {
			return formFieldBtn['user'];
		}
		return null;
	},
	getFormUserByUserFieldName : function(name, index) {
		var formFieldBtn = document.getElementsByName(name)[Mis.toDefault(
				index, 0)];
		if (formFieldBtn != null & formFieldBtn != "undefined") {
			return formFieldBtn['user'];
		}
		return null;
	},
	openUserWindow : function(userId) {
		var params = "viewUserId=" + userId;
		popupModalDialog(getPath() + '/form/personInfo.jsp', params);
	},
	refFormId : null,
	refFieldId : null,
	getSystemInfo : function(serviceUrl) {
		var req = new Ajax.Request(
				serviceUrl + '/services/portal/configService.jsp',
				{
					method : 'get',
					contentType : 'text/xml',
					parameters : {
						userId : FormEnv.userId,
						method : 'getOrgUserSystemInfo',
						compId : compId
					},
					onSuccess : function(transport) {
						var response = transport.responseXML;
						var result = SmartXMLUtil.getChildNode(response, 'Result');
						if (result.getAttribute('status') == 'OK') {
							var sysInfo = SmartXMLUtil.getChildNode(result, 'systemInfo');
							var refFormId = sysInfo.getAttribute("refFormId");
							var refFieldId = sysInfo.getAttribute("refFieldId");
							FormUserUtil.refFormId = refFormId;
							FormUserUtil.refFieldId = refFieldId;
						}
					},
					onFailure : function() {
						alert('fail');
					}
				});
	}
};

var FormRefUtil = {
	getFormRefByUid : function(uid) {
		return FormRefUtil.getFormRefByRefFieldId(uid + "_refField");
	},
	getFormRefByName : function(name, index) {
		return FormRefUtil.getFormRefByRefFieldName(name + "_refField", index);
	},
	getFormRefByRefFieldId : function(id) {
		var formFieldBtn = $(id);
		if (formFieldBtn != null & formFieldBtn != "undefined") {
			return formFieldBtn['ref'];
		}
		return null;
	},
	getFormRefByRefFieldName : function(name, index) {
		var formFieldBtn = document.getElementsByName(name)[Mis.toDefault(
				index, 0)];
		if (formFieldBtn != null && formFieldBtn != "undefined") {
			return formFieldBtn['ref'];
		}
		return null;
	},
	openRefWindow : function(formId, recordId) {
		var url = getPath() + "/common/referenceTaskView.jsp";
		var params = '?formId=' + formId + '&recordId=' + recordId;
		popupModalDialog(url, params);

		FormEnv.loadDataComplete = true;
		
		var formWork = new FormWork(formId+"taskView");
		formWork.initFormRuntime(FormEnv.userId, '../', formId, '', '', recordId, '2', 'view');

		// window.showModalDialog("../common/referenceTaskView.jsp?formId="+formId+"&recordId="+recordId,
		// window,
		// "dialogWidth: 760px; dialogHeight: 400px; dialogTop:50px;
		// dialogLeft:50px; center: yes; help: no; status: no; scroll: yes;
		// resizable: no");
	}
};

var NumberFormatter = {
	format : function(value, prefix, suffix) {
		if (Mis.isNull(value))
			return "";
		var intVal = parseInt(value);
		var floatVal = parseFloat(value);
		var formatVal = "";
		if (isNaN(intVal) && isNaN(floatVal)) {
			return "error";
		} else if (floatVal != intVal) {
			formatVal = NumberFormatter.addCommas(floatVal);
		} else {
			formatVal = NumberFormatter.addCommas(intVal);
		}
		return Mis.toDefault(prefix, "") + formatVal
				+ Mis.toDefault(suffix, "");
	},
	toNumber : function(value, prefix, suffix) {
		while (value.indexOf(",") != -1)
			value = value.replace(",", "");
		if (!Mis.isNull(prefix)) {
			while (value.indexOf(prefix) != -1)
				value = value.replace(prefix, "");
		}
		if (!Mis.isNull(suffix)) {
			while (value.indexOf(suffix) != -1)
				value = value.replace(suffix, "");
		}
		var floatValue = parseFloat(value);
		if (isNaN(floatValue))
			floatValue = null;
		return floatValue;
	},
	addCommas : function(value) {
		var nStr = value + '';
		var x = nStr.split('.');
		var x1 = x[0];
		var x2 = x.length > 1 ? '.' + x[1] : '';
		var rgx = /(\d+)(\d{3})/;
		while (rgx.test(x1)) {
			x1 = x1.replace(rgx, '$1' + ',' + '$2');
		}
		return x1 + x2;
	}
};

function uploadSucess(groupId, sendData) {
	$(sendData + "FileInput_value").value = groupId;
}
function refreshComboBox(workspaceId){
	var formRuntime = jQuery("#" + workspaceId).data("FormRuntime");
	formRuntime.refreshCombo();	
}


FormFileField = function(contentsContainer, formEntityXml, mode, formRuntime, contentWidth, formatType, fitToScreen){
	this.mode = mode;
	// save info
	this.modelXml = formEntityXml;
	this.formFieldId = formRuntime.generateFieldIdByXml(formEntityXml);
	var formatXml = SmartXMLUtil.getChildNode(formEntityXml, 'format');
  	var formatType = formatXml.getAttribute('type');
	
	this.fileuploadForm = null;
		
	try{
	var contentsDivContainer = new Element("div");
	contentsDivContainer.id = this.formFieldId + "_fileuploadDiv";			
	//Element.setStyle(contentsDivContainer, {verticalAlign : "top", position: "relative"});
	Element.setStyle(contentsContainer, {verticalAlign : "top"});
//	Element.setStyle(contentsContainer, {width : contentWidth + "px"});

	var fileFieldContentsHTML = "";		

	fileFieldContentsHTML += "<table id=\"" + this.formFieldId + "_fileList\" class=\"fileListTable\" border = 0 cellPadding = 0 cellSpacing = 0>";
	if(mode == 'hidden'){	
		fileFieldContentsHTML += "	<tr class=\"fileListTableHeader fileListTableRow\">";
		fileFieldContentsHTML += "		<td class=\"fileListTableNormal fileListTableCol\" colspan=\"3\">" + FormLang.fileFieldNoFile + "</td>";
		fileFieldContentsHTML += "	</tr>";
	}
	fileFieldContentsHTML += "</table>";
		
	new Insertion.Bottom(contentsDivContainer, fileFieldContentsHTML);

	// add to parent html element 
	contentsContainer.appendChild(contentsDivContainer);
	
		if(mode != 'hidden'){	
			var fileuploadForm = new Element("form");
			fileuploadForm.id = this.formFieldId + "_fileuploadForm";
			fileuploadForm.action = "/smartserver/services/portal/documentService.jsp?method=createFileXml&userId=" + FormEnv.userId;
			fileuploadForm.method = "post";
			fileuploadForm.encoding = "multipart/form-data";
	
			var uploadEle = new Element('input', {type : "file"});
			uploadEle.id = this.formFieldId + "_upload";
			
			if (formatType === 'imageBox') {
				uploadEle.size = '1';
				uploadEle.addClassName("fileInputImage");
			} else {
				uploadEle.addClassName("fileInput");
				uploadEle.size = "30";
			}
			uploadEle.addClassName("formFileFieldInput");
			
			fileuploadForm.setStyle({margin: "0px", padding: "0px", border : "0px"});
			
			uploadEle.setAttribute("fieldId", this.modelXml.getAttribute('id'));
			uploadEle.setAttribute("workspaceId", formRuntime.workspaceId);
	
			uploadEle.name = "upload";
			Element.setStyle(uploadEle, {width : "100%"});
			
			fileuploadForm.appendChild(uploadEle);
			contentsDivContainer.appendChild(fileuploadForm);
			this.fileuploadForm = fileuploadForm;
		}	
	}catch(e){
		alert(e.message);
	}
	// html component save
	contentsDivContainer['file'] = this;

	this.groupId = "";
	
	// upload event
	this.upload = function(fieldId) {
		FormFileFieldUtil.currentFieldId = fieldId;
		davidjc.AjaxFileUpload.initialise(this.doBeforeUpload, this.doAfterUpload, fieldId);
	}
	
	this.doBeforeUpload = function() {
		// document.getElementById("ajaxFileUploadForm_upload").disabled = true;
	};
		
	this.doAfterUpload = function (success, data) {
		if (success) {
			FormEnv.loadDataComplete = true;
			var result = SmartXMLUtil.getChildNode(data, 'Result');
			if(result.getAttribute('status') == 'OK'){
				var item = SmartXMLUtil.getChildNode(result, 'item');
				var formFileFieldObj = document.getElementById(FormFileFieldUtil.currentFieldId + "_fileuploadDiv")["file"];
				//alert('groupId : ' + item.getAttribute("groupId"));
				formFileFieldObj.setName(item.getAttribute("groupId"));
				formFileFieldObj.setValue(item.getAttribute("groupId"));
				document.getElementById(formFileFieldObj.formFieldId + "_fileuploadForm").action = "/smartserver/services/portal/documentService.jsp?method=createFileXml&userId=" + FormEnv.userId+ "&groupId=" + formFileFieldObj.groupId;
				document.getElementById(formFileFieldObj.formFieldId + "_fileuploadForm").innerHTML = "";
				
				var uploadEle = new Element('input', {type : "file"});
				uploadEle.id = formFileFieldObj.formFieldId + "_upload";
				if (formatType === 'imageBox') {
					uploadEle.size = '1';
					uploadEle.addClassName("fileInputImage");
				} else {
					//jk
					uploadEle.size = "30";
					uploadEle.addClassName("fileInput");
				}
				uploadEle.addClassName("formFileFieldInput");
				
				uploadEle.name = "upload";
				Element.setStyle(uploadEle, {width : "100%"});
				
				document.getElementById(formFileFieldObj.formFieldId + "_fileuploadForm").appendChild(uploadEle);
				document.getElementById(formFileFieldObj.formFieldId + "_fileuploadForm").reset();
				// formFileFieldObj.loadDocumnetInfo(formFileFieldObj.formFieldId);
			} else {
			}
		}
	};	
	

	
	// form ref value return  
	this.getValue = function(){
		return this.groupId;
	};
	// form ref name return 
	this.getName = function(){
		return this.groupId;
	};
	// form ref value set  
	this.setValue = function(value){
		this.groupId = value;
		if(this.fileuploadForm != null)
			this.fileuploadForm.action = "/smartserver/services/portal/documentService.jsp?method=createFileXml&userId=" + FormEnv.userId + "&groupId=" + this.groupId;
	};
	
	// form ref name set
	this.setName = function(name){
		this.groupId = name;
		this.loadDocumnetInfo(this.formFieldId);
	};

	var length = 0;
	this.loadDocumnetInfo = function(fieldId) {
		if(this.groupId != ""){
			new Ajax.Request("/smartserver/services/portal/documentService.jsp?method=findFileGroup&userId=" + FormEnv.userId + "&groupId=" + this.groupId, {
			  method: 'get',
			  onSuccess: function(transport) {
				var fieldId = transport.request.options['fieldId'];
				var fileTable = $(fieldId + "_fileList");
				while(fileTable.rows.length > 0){
					fileTable.deleteRow(fileTable.rows.length - 1);
				}
					  
			  	var resultXml = transport.responseXML;
			  	var result = SmartXMLUtil.getChildNode(resultXml, 'Result');
			    
			    var fileFieldContentsHTML = "";

			    new Insertion.Bottom(fileTable,fileFieldContentsHTML);
	
			    if(result.getAttribute('status') == 'OK'){
					if(result.getAttribute('totalCount') == "0"){
						var formFileFieldObj = document.getElementById(FormFileFieldUtil.currentFieldId + "_fileuploadDiv")["file"];
						formFileFieldObj.setName("");
						formFileFieldObj.setValue("");
						if(mode == 'hidden'){
				    		new Insertion.Bottom($(fieldId + "_fileList"), "<td class=\"fileListTableNormal fileListTableCol\" colspan=\"3\" align=\"center\">" + FormLang.fileFieldNoFile + "</td>");
				    	}
				    }else{
						var fileXmls = SmartXMLUtil.getChildNodes(result, 'File');
						for(var i = 0 ; i < fileXmls.length ; i++){
							try{
								transport.request.options['fileField'].makeFileRow(fileXmls[i], fieldId, fileTable.insertRow(-1));
								//jk
							}catch(e){
								//alert(e);
							}
						}
						var docSpace = document.getElementById('workspace_docSpace');
						docSpace.style.height = $('workspace_docSpace').offsetHeight + 14 + 'px';
						length = fileXmls.length;
				    }
				}else{
					new Insertion.Bottom($(fieldId + "_fileList"), "<td class=\"fileListTableHeaderSpecial fileListTableCol\" colspan=\"3\">" + FormLang.fileFieldErrorService + "</td>");
				}
				
			  },
			  onFailure: function(e){
			  	//alert(e.message);
			  },
			  onException : function(e){
			  	//alert(e.message);
			  },
			  fieldId : fieldId,
			  fileField : this
			});
		}
	};

	this.makeFileRow = function(fileXml, fieldId, row){
		var fileId = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(fileXml, 'id'));
		var fileName = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(fileXml, 'fileName'));
		var fileType = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(fileXml, 'fileType'));
		var size = this.makeSizeString(parseInt(SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(fileXml, 'fileSize'))));
		var filePath = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(fileXml, 'filePath'));

		var nameTd = row.insertCell(row.cells.length);
		nameTd.setAttribute("class", "fileListTableNomal fileListTableCol fileListName");
		row.appendChild(nameTd);

		var newItem = document.createElement("div");
		newItem.setAttribute("style", "margin-top:5px;");

		if (formatType === 'imageBox') {

			//nameTd.innerHTML = "<img id='" + fieldId + "_img' width='100%' vspace='6' src='/smartserver/servlet/download?fileId=" + fileId + "&userId=" + FormEnv.userId + "'>";
var img = document.createElement('img');
	img.setAttribute('id', fieldId+'_img');
	img.setAttribute('width', '100%');
	img.setAttribute('vspace', '6');
	img.setAttribute('src', 'C:\\SmartWorks\\swDocument\\Y2011\\M6\\file_41b108b16d244bdb93e23f85a1180408.jpg');

//nameTd.innerHTML = "<img id='" + fieldId + "_img' width='100%' vspace='6' src='C:\\SmartWorks\\swDocument\\Y2011\\M6\\file_41b108b16d244bdb93e23f85a1180408.jpg'>";
	nameTd.appendChild(img);
			var originWidth = $(fieldId + "_img").width;
			var imageWidth = 0;
			if (fitToScreen) {    //화면에 맞춤
				imageWidth = contentWidth-12;
			} else {              
				if (originWidth <= contentWidth-12) {
					if (originWidth <= 28) {
						imageWidth = contentWidth-12;
					} else {
						imageWidth = originWidth;
					}
				} else {
					imageWidth = contentWidth-12;
				}
			}
			$(fieldId + "_img").width = imageWidth;
		} else {
			//var nameA = new Element("a", {href : "/smartserver/servlet/download?fileId=" + fileId + "&userId=" + FormEnv.userId}).update(fileName + '&nbsp;[' + size + ']');
			var extension = this.getFileExtension(fileName);
			var imgSrc = this.getExtensionImage(extension);
			var nameA = '<img src=/smartserver/images/icon/fileImage/icon_'+ imgSrc + ' style="vertical-align:top;"> ' + '<a href=/smartserver/servlet/download?fileId=' + fileId + '&userId=' + FormEnv.userId + '>' + fileName + '</a>' + '&nbsp;[' + size + ']';

			newItem.innerHTML = nameA;
			nameTd.appendChild(newItem);
			var docSpace;
			var fileInputDiv = document.getElementById(this.formFieldId+"FileInput");
			var fileuploadDiv = document.getElementById(this.formFieldId+"_fileuploadDiv");
			var id = this.formFieldId.substr(0,32);
			var spaceHeight;
			var fileListHeight = document.getElementById(this.formFieldId+'_fileList').offsetHeight;
			try{
				if(fileInputDiv!=null)
					fileInputDiv.style.height = (fileuploadDiv.offsetHeight)+'px';
				try{
					//docSpace.style.height = (spaceHeight+fileListHeight)+'px';
					//jk
					//docSpace.style.height = $('workspace_docSpace').offsetHeight + 12+'px';
					var formFieldsRowId = $(this.formFieldId+"_innerTd").getAttribute('formFieldsRowId');
					var formFieldsRowIds = $(formFieldsRowId).childNodes;
					for(var ii = 0 ; ii < formFieldsRowIds.length; ii++){
						var fieldIdx = formFieldsRowIds[ii].getAttribute('fieldId');
						$(fieldIdx+"_label").style.height = $(formFieldsRowId).offsetHeight;
					}
					try{
						if(historyTaskId != '') {
							$(historyTaskId+"FormTd_docSpace").style.height = $(historyTaskId+"FormTd_formFieldsSpace").offsetHeight -12;
						} else {
							docSpace = document.getElementById('workspace_docSpace');
							spaceHeight = document.getElementById('workspace_formFieldsSpace').offsetHeight-12;
							docSpace.style.height = spaceHeight+'px';
						}
					}catch(e){}
					
				}catch(e){
					spaceHeight = document.getElementById(id+'HistoryTd').offsetHeight;
					document.getElementById(id+'HistoryTd').style.height = (spaceHeight+15)+'px';
					document.getElementById(id+'HistoryTd').style.marginTop = '0px';
					document.getElementById(id+'HistoryTd').style.verticalAlign = '0px';
				}
			}catch(e){
				//alert(e);
			}
		}
	
		if(this.mode != 'hidden'){	
			var removeBtn;
			if (formatType === 'imageBox') {
				removeBtn = new Element("img", {name : fieldId, src : "/smartserver/image/form/close.gif", width : "12px", height : "12px", vspace : "6" });
			} else {
				removeBtn = new Element("img", {name : fieldId, src : "/smartserver/image/form/close.gif", width : "12px", height : "12px"});
			}
					
			if (formatType === 'imageBox') {
				$(fieldId + "_upload").style.display = 'none';
			} else {
				nameTd.appendChild(document.createTextNode(' '));
			}
						
			/*removeTd.appendChild(removeBtn);	*/
			removeBtn.addClassName("formFileFieldRemoveBtn");

			newItem.appendChild(removeBtn);

			nameTd.appendChild(newItem);

			removeBtn["fileId"] = fileId;
			removeBtn["fieldId"] = fieldId;
		}
		return row;
	};
	this.makeSizeString = function(size){
		var sizeStr = "";
		
		if(size > 1000000000 ){
			sizeStr = parseInt(size / 1000000000) + "GB";
		}else if(size > 1000000){
			sizeStr = parseInt(size / 1000000) + "MB";
		}else if(size > 1000){
			sizeStr = parseInt(size / 1000) + "KB";
		}else{
			sizeStr = size + "byte";
		}
		return sizeStr;
	};

	this.removeFile = function(fileId, fieldId){
		FormEnv.loadDataComplete = true;
		var url = "/smartserver/services/portal/documentService.jsp?method=deleteFile&userId=" + FormEnv.userId + "&fileId=" + fileId;
		new Ajax.Request(url, {
			  method: 'get',
			  onSuccess: function(transport) {
				var resultXml = transport.responseXML;
			  	var result = SmartXMLUtil.getChildNode(resultXml, 'Result');
			    
			    if(result.getAttribute('status') == 'OK'){
				}else{
				}
				transport.request.options['fileField'].loadDocumnetInfo(transport.request.options['fieldId']);
				var fileInputDiv = document.getElementById(fieldId+"FileInput");
				fileInputDiv.style.height = fileInputDiv.offsetHeight - 12 +'px';

				var docSpace = document.getElementById('workspace_docSpace');
				if(length != 1) {
					docSpace.style.height = ($('workspace_docSpace').offsetHeight - 14*2) + 'px';
				} else {
					docSpace.style.height = ($('workspace_docSpace').offsetHeight - 14) + 'px';
				}

				var formFieldsRowId = $(fieldId+"_innerTd").getAttribute('formFieldsRowId');
				var formFieldsRowIds = $(formFieldsRowId).childNodes;

				for(var ii = 0 ; ii < formFieldsRowIds.length; ii++){
					var fieldIdx = formFieldsRowIds[ii].getAttribute('fieldId');
					$(fieldIdx+"_label").style.height = fileInputDiv.offsetHeight - 12 +'px';
				}
			  },
			  onFailure: function(e){
			  	//alert(e.message);
			  },
			  onException : function(e){
			  	//alert(e.message);
			  },
			  fieldId : fieldId,
			  fileField : this
			});
	};

	//파일명에 따른 확장자 추출.
	this.getFileExtension = function(fileName) {

		if(fileName == null || fileName == "")
			return "";
		var pos = fileName.split(".");
		var ext = pos[pos.length-1];

		return ext;
	};

	//확장자에 따른 이미지파일 추출 .
	this.getExtensionImage = function(fileExtension) {

		var imgSrc = "";
		if(fileExtension == "jpg") {
			imgSrc = "jpg.gif";
		} else if(fileExtension == "ppt") {
			imgSrc = "ppt.gif";
		} else if(fileExtension == "pptx") {
			imgSrc = "ppt.gif";
		} else if(fileExtension == "xls") {
			imgSrc = "xls.gif";
		} else if(fileExtension == "xlsx") {
			imgSrc = "xls.gif";
		} else if(fileExtension == "zip") {
			imgSrc = "zip.gif";
		} else if(fileExtension == "doc") {
			imgSrc = "doc.gif";
		} else if(fileExtension == "docx") {
			imgSrc = "doc.gif";
		} else if(fileExtension == "gif") {
			imgSrc = "gif.gif";
		} else if(fileExtension == "hwp") {
			imgSrc = "hwp.gif";
		} else if(fileExtension == "pdf") {
			imgSrc = "pdf.gif";
		} else if(fileExtension == "rar") {
			imgSrc = "rar.gif";
		} else if(fileExtension == "txt") {
			imgSrc = "txt.gif";
		} else if(fileExtension == "jpg") {
			imgSrc = "jpg.gif";
		} else {
			imgSrc = "none.gif";
		}
		return imgSrc;
		
	};

};

var FormFileFieldUtil = {
	currentFieldId : null,
	getFormFileByUid : function(uid){		
		return FormFileFieldUtil.getFormFileByFieldId(uid + "_fileuploadDiv");
	},
	getFormFileByFieldId : function(id){
		var formFileField = $(id);
		if(formFileField != null & formFileField != "undefined"){
			return formFileField['file'];
		}
		return null;
	}
};

//Event.addBehavior.reassignAfterAjax = true;

/*Event.addBehavior({
  ".formFileFieldRemoveBtn:click" : function(e) {
  	var formField = FormFileFieldUtil.getFormFileByUid(e.target.name);
	formField.removeFile(e.target["fileId"], e.target["fieldId"]);
	$(e.target["fieldId"] + "_upload").style.display = 'block';
  },
  ".formFileFieldInput:change" : function(e) {
	var fileObj = e.srcElement || e.target;
	var filePath = fileObj.value;
	var fileType = filePath.substring(filePath.lastIndexOf('.')+1, filePath.length).toUpperCase();
	if (fileObj.size === 1) {   //formatType : imageBox (gif, jpg only)
		if (!(fileType === 'GIF' || fileType === 'JPG' || fileType === 'JPEG')) { 
			warnMessage('errorCodeinvalidImage', 'INPUT_VALIDIMAGE');
			return;
		}
	}
	
	var fieldId = e.target.id.substr(0, e.target.id.length - 7);
	document.getElementById(fieldId + "_fileuploadDiv")['file'].upload(fieldId);
  }
});

Event.addBehavior({".numberFieldChangeValue:change" : function(event) {
		var formRuntime = jQuery("#" + event.target.getAttribute("workspaceId")).data("FormRuntime");
		formRuntime.refreshCombo();
}});*/