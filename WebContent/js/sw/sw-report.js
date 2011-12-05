
Ext.require('Ext.chart.*');
Ext.require(['Ext.Window', 'Ext.fx.target.Sprite', 'Ext.layout.container.Fit']);

var requestUrl = "get_report_data.sw";

var reportType = {
	CHART : 1,
	MATRIX : 2,
	TABLE : 3
};

var chartType = {
	LINE : "line",
	AREA : "area",
	BAR : "bar",
	COLUMN : "column",
	PIE : "pie",
	GAUGE : "gauge",
	RADAR : "radar",
	SCATTER : "scatter",
	DEFAULT : chartType.LINE
};

var smartChart = {
	reportType : reportType.CHART,
	type : chartType.DEFAULT,
	isStacked : false,
	companyId : null,
	userId : null,
	xFieldName : null,
	yValueName : null,
	groupNames : null,
	values : null,
    
    getFields : function(){
    	var fields = new Array();
    	fields.push(xFieldName);
    	for(var field in smartChart.fieldNames)
    		fields.push(field);
    	return fields;
    },
    
    getSeries : function(){
    	var series = new Array();
    	for(var groupName in smartChart.groupNames)
    		series.push({
    			type: 'line',
    			highlight: {
    				size: 7,
    				radius: 7
    			},
    			axis: 'left',
    			xField: smartChart.xFieldName,
    			yField: groupName,
    			markerConfig: {
    				type: 'cross',
    				size: 4,
    				radius: 4,
    				'stroke-width': 0
    			}
    		});
    	return series;
    },
    
	getChartData : function() {
		var url = requestUrl + "?companyId=" + smartChart.companyId
				+ "&userId=" + smartChart.userId + "&reportId=" + reportId;
		$.ajax({
			url : url,
			data : {},
			success : function(data, status, jqXHR) {
				smartChart.xFieldName = "name";
				smartChart.yValueName = "Count";
				smartChart.groupNames = ["yesterday", "today", "tomorrow" ];
				smartChart.values = [ {
					name : "ysjung",
					yesterday : 10,
					today : 9,
					tomorrow : 3
				}, {
					name : "kmyu",
					yesterday : 5,
					today : 5,
					tomorrow : 5
				}, {
					name : "hsshin",
					yesterday : 6,
					today : 15,
					tomorrow : 0
				} ];
			}
		});
	},

	load : function(reportId, target) {
		smartChart.getChartData();
		
		Ext.create('Ext.chart.Chart', {
	        height: 600,
	        position: 'relative',
	        minHeight: 600,
	        minWidth: 770,
	        renderTo: Ext.getBody(),
	    	store : Ext.create('Ext.data.JsonStore', {
	        	fields : smartChart.getFields,
	        	data : smartChart.values
	        }),
	        shadow: true,
	        theme: 'Category1',
	        legend: {
	            position: 'right'
	        },
	        axes: [{
	            type: 'Numeric',
	            minimum: 0,
	            position: 'left',
	            fields: smartChart.getFields,
	            title: smartChart.yValueName,
	            minorTickSteps: 1,
	            grid: {
	                odd: {
	                	opacity: 1,
	                    fill: '#ddd',
	                    stroke: '#bbb',
	                    'stroke-width': 0.5
	                }
	            }
	        }, {
	            type: 'Category',
	            position: 'bottom',
	            fields: SmartChart.xFieldName,
	            title: SmartChart.xFieldName
	        }],
	        series: smartChart.getSeries 
		});
	}
};
