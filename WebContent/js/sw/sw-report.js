Ext.require('Ext.chart.*');
Ext
		.require([ 'Ext.Window', 'Ext.fx.target.Sprite',
				'Ext.layout.container.Fit' ]);

var swReportType = {
	CHART : 1,
	MATRIX : 2,
	TABLE : 3
};

var swChartType = {
	LINE : "line",
	AREA : "area",
	BAR : "bar",
	COLUMN : "column",
	PIE : "pie",
	GAUGE : "gauge",
	RADAR : "radar",
	SCATTER : "scatter",
	DEFAULT : this.LINE
};

var chartUtil = {

};

var smartChart = {
	reportType : swReportType.CHART,
	chartType : swChartType.DEFAULT,
	isStacked : false,
	target : null,
	companyId : null,
	userId : null,
	xFieldName : null,
	yValueName : null,
	groupNames : null,
	values : null,
	requestUrl : "get_report_data.sw",

	getFields : function() {
		var fields = new Array();
		fields.push(smartChart.xFieldName);
		for ( var i = 0; i < smartChart.groupNames.length; i++)
			fields.push(smartChart.groupNames[i]);
		return fields;
	},

	getSeries : function() {
		var series = new Array();
		for ( var i = 0; i < smartChart.groupNames.length; i++)
			series.push({
				type : smartChart.chartType,
				highlight : {
					size : 7,
					radius : 7
				},
				axis : 'left',
				xField : smartChart.xFieldName,
				yField : smartChart.groupNames[i],
				markerConfig : {
					type : 'cross',
					size : 4,
					radius : 4,
					'stroke-width' : 0
				}
			});
		return series;
	},

	getChartData : function(reportId) {
		var url = smartChart.requestUrl + "?companyId=" + smartChart.companyId
				+ "&userId=" + smartChart.userId + "&reportId=" + reportId;
		$.ajax({
			url : url,
			data : {},
			success : function(data, status, jqXHR) {
				if(data){
					smartChart.xFieldName = data.xFieldName;
					smartChart.yValueName = data.yValueName;
					smartChart.groupNames = data.groupNames;
					smartChart.values = data.values;
					smartChart.createChart();
				}
			}
		});
	},

	load : function(reportId, chartType, isStacked, target) {
		smartChart.chartType = chartType;
		smartChart.isStacked = isStacked;
		smartChart.target = target;
		smartChart.getChartData(reportId);
	},

	createChart : function(){
		Ext.create('Ext.chart.Chart', {
	        width: 800,
	        height: 400,
	        minHeight: 400,
	        minWidth: 800,
			renderTo : Ext.get("chart_target"),
			store : Ext.create('Ext.data.JsonStore', {
				fields : smartChart.getFields(),
				data : smartChart.values
			}),
			shadow : true,
			theme : 'Category1',
			legend : {
				position : 'right'
			},
			axes : [ {
				type : 'Numeric',
				minimum : 0,
				position : 'left',
				fields : smartChart.groupNames,
				title : smartChart.yValueName,
				minorTickSteps : 1,
				grid : {
					odd : {
						opacity : 1,
						fill : '#ddd',
						stroke : '#bbb',
						'stroke-width' : 0.5
					}
				}
			}, {
				type : 'Category',
				position : 'bottom',
				fields : [ smartChart.xFieldName ],
				title : smartChart.xFieldName
			} ],
			series : smartChart.getSeries()
		});
	}
};
