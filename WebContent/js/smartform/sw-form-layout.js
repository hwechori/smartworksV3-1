SmartWorks.GridLayout = function(config) {
	this.options = {
		target : $('<div></div>'),
		formXml : '',
		formValues : '',
		mode : 'edit',
		requiredOnly : 'false',
		workId : null,
		formId : null,
		recordId : null,
		taskInstId : null,
		onSuccess : null,
		onError : null
	};
	
	this.$layout = null;
	this.$table = null;

	this.getColumnSize = function() {
		var columnSize = 0;
		if(isEmpty(this.$layout)) return columnSize;
		
		var grids = this.$layout.children('gridRow').first().children('gridCell');
		for ( var i = 0; i < grids.length; i++) {
			columnSize += parseInt(grids.eq(i).attr('span'));
		}
		return columnSize;
	};

	this.spanWidths = null;
	this.getLabelWidth = function(fieldId){
		if(isEmpty(this.$layout)) return 0;
		
		if(this.spanWidths == null){			
			var $gridColumns = this.$layout.find('gridColumn');
			var totalSize = 0.0;
			for(var i=0; i<$gridColumns.length; i++){
				totalSize = totalSize + parseFloat($($gridColumns[i]).attr('size'));
			}
			var spanWidths = new Array();
			for(var i=0; i<$gridColumns.length; i++){
				spanWidths.push(parseFloat($($gridColumns[i]).attr('size'))/totalSize*100.0);
			}
			this.spanWidths = spanWidths;
		}
		$column = this.$layout.find('gridCell[fieldId="'+ fieldId + '"]');

		var index = parseInt($column.attr('gridColumnIndex'));
		if(isNaN(index)) {
			index = $column.prevAll().length;
		}

		var span = parseInt($column.attr('span'));
		var columnWidth = 0;
		for(var i=index; i<this.spanWidths.length && i<index+span; i++){
			columnWidth = columnWidth + this.spanWidths[i];
		}
		return 12.0/columnWidth*100.0;
	};

	this.getTable = function() {
		return this.$table;
	};

	this.getLayout = function(formXml, formValues, mySelf, refreshTarget){
		var this_ = this;
		if(!isEmpty(mySelf)) this_ = mySelf;
		var $htmlForm = $('<form name="frmSmartForm" class="js_validation_required form_layout"><table></table></form>');
		this_.$table = $htmlForm.find('table');

		var $form = $(this_.options.formXml);
		if(!isEmpty(formXml)) $form = $(formXml);
		
		$htmlForm.attr("formId", $form.attr('id'));
		$htmlForm.attr("formName", $form.attr('name'));
		
		var mode = this_.options.mode;
		if(isEmpty(refreshTarget)){
			$htmlForm.appendTo(this_.options.target);			
		}else{
			$htmlForm.appendTo(refreshTarget);
			mode = "edit";
		}
		
		this_.$layout = $form.find('layout');

		var $rows = this_.$layout.find('gridRow');
		var $columns = this_.$layout.find('columns gridColumn');

		var dataFields = this_.options.formValues.dataFields;
		if(!isEmpty(formValues)) dataFields = formValues.dataFields;

		var totalWidth = 0;
		for(var i = 0 ; i < $columns.length ; i++){
			totalWidth += parseFloat($columns.eq(i).attr('size'));
		}
		
		for ( var i = 0; i < $rows.length; i++) {
			var $row = $rows.eq(i);
			
			var $html_row = $('<tr></tr>');
			var $cells = $row.children('gridCell');
			this_.$table.append($html_row);

			for ( var j = 0; j < $cells.length; j++) {
				var $cell = $cells.eq(j);
				var id = $cell.attr('fieldId');
				var colspan = parseInt($cell.attr('span'));
				var rowspan = parseInt($cell.attr('rowspan'));			
				var width = 0;
				var dataField = null;
				for(var k in dataFields) {
					if(dataFields[k].id === id) {
						dataField = dataFields[k];
						break;
					}
				}
				if (isEmpty($columns)) {
					width = $column.attr('size');
				} else {
					for(var k = 0 ; k < colspan && (j+k) < $columns.length ; k++){
						width += parseFloat($columns.eq(j + k).attr('size'));
					}
				}
				
				var $html_cell = $('<td class="form_col" fieldId="'+id+'" colspan="'+colspan+'" width="'+width/totalWidth*100 +'%" ></td>');			
				$html_cell.appendTo($html_row);					
				if(rowspan)
					$html_cell.attr('rowspan', rowspan);
				if(id) {
					var $entity = $form.find('#' + id);
					if(this_.options.requiredOnly !== 'true' || $entity[0].getAttribute('required') === 'true'){
						SmartWorks.FormFieldBuilder.build(mode, $html_cell, $entity, dataField, this_);
					}
				}

			}
		}
		if(isEmpty(refreshTarget)){
			if($.isFunction(this_.options.onSuccess)){
				this_.options.onSuccess();
				return;
			}
			return this_;
		}
	};
		
	SmartWorks.extend(this.options, config);
	this.options.target.html('');

	if(isEmpty(this.options.formXml) && !isEmpty(this.options.workId)){
		var workId = this.options.workId;
		var formId = this.options.formId;
		var recordId = this.options.recordId;
		var taskInstId = this.options.taskInstId;
		var formValues = this.options.formValues;
		var onError = this.options.onError;
		var getLayout = this.getLayout;
		var refreshTarget = this.options.target.hide();
		var this_ = this;
		$.ajax({
			url : "get_form_xml.sw",
			data : {
				workId : workId,
				formId : formId
			},
			success : function(formXml, status, jqXHR) {
				if(isEmpty(formValues) && (!isEmpty(workId)) && (!isEmpty(recordId))){
					$.ajax({
						url : "get_record.sw",
						data : {
							workId : workId,
							recordId : recordId
						},
						success : function(formData, status, jqXHR) {
							getLayout(formXml, formData.record, this_, refreshTarget);
							var forms = refreshTarget.find('form');
							var paramsJson = {};
							paramsJson['workId'] = workId;
							paramsJson['recordId'] = recordId;
							for(var i=0; i<forms.length; i++){
								var form = $(forms[i]);
								
								// 폼이 스마트폼이면 formId와 formName 값을 전달한다...
								if(form.attr('name') === 'frmSmartForm'){
									paramsJson['formId'] = form.attr('formId');
									paramsJson['formName'] = form.attr('formName');
								}
								
								// 폼이름 키값으로 하여 해당 폼에 있는 모든 입력항목들을 JSON형식으로 Serialize 한다...
								paramsJson[form.attr('name')] = mergeObjects(form.serializeObject(), SmartWorks.GridLayout.serializeObject(form));
							}
							refreshTarget.html("").show();
							console.log(JSON.stringify(paramsJson));
							$.ajax({
								url : "refresh_record.sw",
								contentType : 'application/json',
								type : 'POST',
								data : JSON.stringify(paramsJson),
								success : function(formData, status, jqXHR) {
									return getLayout(formXml, formData.record, this_);
								},
								error : function(e) {
									return getLayout(formXml, null, this_);
								}
							});					
						},
						error : function(){
							return getLayout(formXml, null, this_);
						}
					});
				}else if(isEmpty(formValues) && (!isEmpty(workId)) && (!isEmpty(taskInstId))){
						$.ajax({
							url : "get_record.sw",
							data : {
								workId : workId,
								taskInstId : taskInstId
							},
							success : function(formData, status, jqXHR) {
								getLayout(formXml, formData.record, this_, refreshTarget);
								var forms = refreshTarget.find('form');
								var paramsJson = {};
								paramsJson['workId'] = workId;
								paramsJson['taskInstId'] = taskInstId;
								for(var i=0; i<forms.length; i++){
									var form = $(forms[i]);
									
									// 폼이 스마트폼이면 formId와 formName 값을 전달한다...
									if(form.attr('name') === 'frmSmartForm'){
										paramsJson['formId'] = form.attr('formId');
										paramsJson['formName'] = form.attr('formName');
									}
									
									// 폼이름 키값으로 하여 해당 폼에 있는 모든 입력항목들을 JSON형식으로 Serialize 한다...
									paramsJson[form.attr('name')] = mergeObjects(form.serializeObject(), SmartWorks.GridLayout.serializeObject(form));
								}
								refreshTarget.html("").show();
								console.log(JSON.stringify(paramsJson));
								$.ajax({
									url : "refresh_record.sw",
									contentType : 'application/json',
									type : 'POST',
									data : JSON.stringify(paramsJson),
									success : function(formData, status, jqXHR) {
										return getLayout(formXml, formData.record, this_);
									},
									error : function(e) {
										return getLayout(formXml, null, this_);
									}
								});					
							},
							error : function(){
								return getLayout(formXml, null, this_);
							}
						});
				}else{
					var paramsJson = {};
					paramsJson['workId'] = workId;
					console.log(JSON.stringify(paramsJson));
					$.ajax({
						url : "refresh_record.sw",
						contentType : 'application/json',
						type : 'POST',
						data : JSON.stringify(paramsJson),
						success : function(formData, status, jqXHR) {
							return getLayout(formXml, formData.record, this_);
						},
						error : function(e) {
							return getLayout(formXml, null, this_);
						}
					});
				}
			},
			error : function(xhr, ajaxOptions, thrownError){
				if($.isFunction(onError))
					onError(xhr, ajaxOptions, thrownError);
				return;
			}
		});
	}else if(isEmpty(this.options.formValues) && (!isEmpty(this.options.workId)) && (!isEmpty(this.options.recordId))){
		var onError = this.options.onError;
		var getLayout = this.getLayout;
		var refreshTarget = this.options.target.hide();
		var this_ = this;
		$.ajax({
			url : "get_record.sw",
			data : {
				workId : this.options.workId,
				recordId : this.options.recordId
			},
			success : function(formData, status, jqXHR) {
				getLayout(null, formData.record, this_, refreshTarget);
				var forms = refreshTarget.find('form');
				var paramsJson = {};
				paramsJson['workId'] = this.options.workId;
				paramsJson['recordId'] = this.options.workId;
				for(var i=0; i<forms.length; i++){
					var form = $(forms[i]);
					
					// 폼이 스마트폼이면 formId와 formName 값을 전달한다...
					if(form.attr('name') === 'frmSmartForm'){
						paramsJson['formId'] = form.attr('formId');
						paramsJson['formName'] = form.attr('formName');
					}
					
					// 폼이름 키값으로 하여 해당 폼에 있는 모든 입력항목들을 JSON형식으로 Serialize 한다...
					paramsJson[form.attr('name')] = mergeObjects(form.serializeObject(), SmartWorks.GridLayout.serializeObject(form));
				}
				refreshTarget.html("").show();
				console.log(JSON.stringify(paramsJson));
				$.ajax({
					url : "refresh_record.sw",
					contentType : 'application/json',
					type : 'POST',
					data : JSON.stringify(paramsJson),
					success : function(formData, status, jqXHR) {
						return getLayout(null, formData.record, this_);
					},
					error : function(e) {
						return getLayout(null, null, this_);
					}
				});					
			},
			error : function(xhr, ajaxOptions, thrownError){
				if($.isFunction(onError))
					onError(xhr, ajaxOptions, thrownError);
				return;
			}
		});
	}else{
		this.getLayout(null, null, null);
	}
	return this;
};

SmartWorks.GridLayout.newGridTable = function(){
	return $('<table><tbody></tbody></table>');
};

SmartWorks.GridLayout.newGridRow = function(){
	return $('<tr></tr>');
};


SmartWorks.GridLayout.serializeObject = function(form){
	var fileFields = SmartWorks.FormRuntime.FileFieldBuilder.serializeObject(form.find('.js_type_fileField'));
	var userFields = SmartWorks.FormRuntime.UserFieldBuilder.serializeObject(form.find('.js_type_userField'));
	var departmentFields = {};//SmartWorks.FormRuntime.DepartmentFieldBuilder.serializeObject(form.find('.js_type_departmentField'));
	var richEditors = SmartWorks.FormRuntime.RichEditorBuilder.serializeObject(form.find('.js_type_richEditor'));
	var refFormFields = SmartWorks.FormRuntime.RefFormFieldBuilder.serializeObject(form.find('.js_type_refFormField'));
	var imageBoxs = SmartWorks.FormRuntime.ImageBoxBuilder.serializeObject(form.find('.js_type_imageBox'));
	var numberInputs = SmartWorks.FormRuntime.NumberInputBuilder.serializeObject(form.find('.js_type_numberInput'));
	var percentInputs = SmartWorks.FormRuntime.PercentInputBuilder.serializeObject(form.find('.js_type_percentInput'));
	var currencyInputs = SmartWorks.FormRuntime.CurrencyInputBuilder.serializeObject(form.find('.js_type_currencyInput'));
	var dataGrids = {};
	return merge3Objects(merge3Objects(fileFields, userFields, richEditors), 
			merge3Objects(refFormFields, imageBoxs, departmentFields), 
			merge3Objects(numberInputs, percentInputs, currencyInputs));
};

SmartWorks.GridLayout.validate = function(form, messageTarget){
	var fileFields = SmartWorks.FormRuntime.FileFieldBuilder.validate(form.find('.js_type_fileField:visible'));
	var userFields = SmartWorks.FormRuntime.UserFieldBuilder.validate(form.find('.js_type_userField:visible'));
	var departmentFields = true;//SmartWorks.FormRuntime.DepartmentFieldBuilder.validate(form.find('.js_type_departmentField'));
	var richEditors = SmartWorks.FormRuntime.RichEditorBuilder.validate(form.find('.js_type_richEditor:visible'));
	var refFormFields = SmartWorks.FormRuntime.RefFormFieldBuilder.validate(form.find('.js_type_refFormField:visible'));
	var imageBoxs = SmartWorks.FormRuntime.ImageBoxBuilder.validate(form.find('.js_type_imageBox:visible'));
	var radioButtons = SmartWorks.FormRuntime.RadioButtonBuilder.validate(form.find('.js_type_radioButton:visible'));
	var dataGrids = true;
	var jq_validate = true;
	
	if(messageTarget instanceof jQuery){
		$('.sw_error_message').hide();
		messageTarget.show();
	}
	form.each(function(){
		jq_validate = $(this).validate({ showErrors: showErrors, ignore:":not(:visible)" }).form() && jq_validate;
	});

	var sw_validate = (fileFields && userFields && departmentFields && richEditors && refFormFields && imageBoxs && dataGrids && radioButtons && jq_validate);
	if(!sw_validate || !jq_validate){
		showErrors();
	}
	if(messageTarget instanceof jQuery) $('.sw_error_message').show();
	return sw_validate;
};

SmartWorks.GridLayout.getLayout = function(){
	
};
