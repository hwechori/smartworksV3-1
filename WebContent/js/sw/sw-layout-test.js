module('GridLayout');

test('columnsize', function() {
	expect(2);

	stop();
	$.ajax({
		url: '/get_form_xml.sw',
		success: function(data) {
			layout = new SmartWorks.GridLayout({
				target : $('#form_layout')[0],
				formXml : data
			});
			alert(data);
			equal(layout.getColumnSize(), 2, 'Column Size Calculation');
			equal(layout.getTable().find('tr').length, 4, 'Row Size Calculation');
			
			console.log(layout.getTable());


			start();
		}
	});
});
