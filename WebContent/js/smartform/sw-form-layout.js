SmartWorks.GridLayout = function(config) {
	this.options = {
		target : $('<div></div>'),
		formXml : '',
		formValues : '',
		mode : 'edit'
	};

	SmartWorks.extend(this.options, config);

	var $htmlForm = $('<form name="frmSmartForm" class="js_validation_required form_layout"><table></table></form>');
	var $table = $htmlForm.find('table');

	var $form = $(this.options.formXml);
	$htmlForm.attr("formId", $form.attr('id'));
	$htmlForm.attr("formName", $form.attr('name'));
	$htmlForm.appendTo(this.options.target);
	
	var $layout = $form.find('layout');

	this.getColumnSize = function() {
		var columnSize = 0;

		var grids = $layout.children('gridRow').first().children('gridCell');
		for ( var i = 0; i < grids.length; i++) {
			columnSize += parseInt(grids.eq(i).attr('span'));
		}
		return columnSize;
	};

	this.spanWidths = null;
	this.getLabelWidth = function(fieldId){
		if(this.spanWidths == null){			
			var $gridColumns = $layout.find('gridColumn');
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
		$column = $layout.find('gridCell[fieldId="'+ fieldId + '"]');

		var index = parseInt($column.attr('gridColumnIndex'));
		if(isNaN(index)) {
			index = $column.prevAll().length;
		}

		var span = parseInt($column.attr('span'));
		var columnWidth = 0;
		for(var i=index; i<this.spanWidths.length && i<index+span; i++){
			columnWidth = columnWidth + this.spanWidths[i];
		}
		return 10.0/columnWidth*100.0;
	};
	

	var columnSize = this.getColumnSize();

	var $rows = $layout.find('gridRow');
	var $columns = $layout.find('columns gridColumn');

	var dataFields = this.options.formValues.dataFields;

	for ( var i = 0; i < $rows.length; i++) {
		var $row = $rows.eq(i);
		
		var $html_row = $('<tr></tr>');
		var $cells = $row.children('gridCell');
		$table.append($html_row);

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
			console.log("dataField", dataField);
			if ($columns.length == 0) {
				width = $column.attr('size');
			} else {
				for(var k = 0 ; k < colspan && (j+k) < $columns.length ; k++){
					width += parseFloat($columns.eq(j + k).attr('size'));
				}
			}
			
			var $html_cell = $('<td class="form_col" fieldId="'+id+'" colspan="'+colspan+'" width="'+width+'" ></td>');
			
			$html_cell.appendTo($html_row);
			
			if(rowspan)
				$html_cell.attr('rowspan', rowspan);
			if(id) {
				var $entity = $form.find('#' + id);
				SmartWorks.FormFieldBuilder.build(this.options.mode, $html_cell, $entity, dataField, this);				
			}

		}
	}

	this.getTable = function() {
		return $table;
	};
	
	return this;
};

SmartWorks.GridLayout.serializeObject = function(form){
	var fileFields = SmartWorks.FormRuntime.FileFieldBuilder.serializeObject(form.find('.js_type_fileField'));
	var userFields = SmartWorks.FormRuntime.UserFieldBuilder.serializeObject(form.find('.js_type_userField'));
	var richEditors = SmartWorks.FormRuntime.RichEditorBuilder.serializeObject(form.find('.js_type_richEditor'));
	var refFormFields = SmartWorks.FormRuntime.RefFormFieldBuilder.serializeObject(form.find('.js_type_refFormField'));
	var imageBoxs = SmartWorks.FormRuntime.ImageBoxBuilder.serializeObject(form.find('.js_type_imageBox'));
	var dataGrids = {};
	console.log(fileFields, userFields, richEditors, refFormFields, imageBoxs, dataGrids);
	return mergeObjects(merge3Objects(fileFields, userFields, richEditors), merge3Objects(refFormFields, imageBoxs, dataGrids));
};

SmartWorks.GridLayout.validate = function(form){
	var fileFields = SmartWorks.FormRuntime.FileFieldBuilder.validate(form.find('.js_type_fileField'));
	var userFields = SmartWorks.FormRuntime.UserFieldBuilder.validate(form.find('.js_type_userField'));
	var richEditors = SmartWorks.FormRuntime.RichEditorBuilder.validate(form.find('.js_type_richEditor'));
	var refFormFields = SmartWorks.FormRuntime.RefFormFieldBuilder.validate(form.find('.js_type_refFormField'));
	var imageBoxs = SmartWorks.FormRuntime.ImageBoxBuilder.validate(form.find('.js_type_imageBox'));
	var dataGrids = true;
	
	return (fileFields && userFields && richEditors && refFormFields && imageBoxs && dataGrids);
};