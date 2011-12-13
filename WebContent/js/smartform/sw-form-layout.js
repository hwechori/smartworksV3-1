SmartWorks.GridLayout = function(config) {
	this.options = {
		target : $('<div></div>'),
		formXml : '',
		mode : 'edit'
	};

	SmartWorks.extend(this.options, config);

	var $table = $('<table></table>');
	$table.appendTo(this.options.target);

	var $form = $(this.options.formXml);
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

			if ($columns.length == 0) {
				width = $column.attr('size');
			} else {
				for(var k = 0 ; k < colspan && (j+k) < $columns.length ; k++){
					width += parseFloat($columns.eq(j + k).attr('size'));
				}
			}
			
			var $html_cell = $('<td fieldId="'+id+'" colspan="'+colspan+'" width="'+width+'" style="border:1px solid"></td>');
			if(rowspan)
				$html_cell.attr('rowspan', rowspan);
			if(id) {
				var $entity = $form.find('#' + id);
				SmartWorks.FormFieldBuilder.build(this.options.mode, $html_cell, $entity);				
			}

			$html_cell.appendTo($html_row);
		}
	}

	this.getTable = function() {
		return $table;
	};
	
	return this;
};
