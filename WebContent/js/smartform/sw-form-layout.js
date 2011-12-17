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
	$htmlForm.attr("formId", $form.attr('id'))
	$htmlForm.attr("formName", $form.attr('name'))
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

	var columnSize = this.getColumnSize();

	var $rows = $layout.find('gridRow');
	var $columns = $layout.find('columns gridColumn');

	var dataFields = this.options.formValues.dataFields;
	console.log(dataFields);

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
			console.log(dataField);
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
				SmartWorks.FormFieldBuilder.build(this.options.mode, $html_cell, $entity, dataField);				
			}

		}
	}

	this.getTable = function() {
		return $table;
	};
	
	this.spanWidths = null;
	this.getSpanWidths = function(){
		if(spanWidths != null) return this.spanWidths;
		
		var $gridColumns = $layout.find('gridColumn');
		var totalSize = 0;
		for(var i=0; i<$gridColumns.length; i++){
			totalSize = totalSize + $(gridColumns[i]).attr('size');
		}
		var spanWidths = new Array();
		for(var i=0; i<$gridColumns.length; i++){
			spanWidths.put($(gridColumns[i]).attr('size')/totalSize * 100);
		}
		this.spanWidths = spanWidths;
		return spanWidths;		
	};
	
	return this;
};
