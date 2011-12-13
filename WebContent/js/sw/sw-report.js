Ext.require('Ext.chart.*');
Ext.require([ 'Ext.Window', 'Ext.fx.target.Sprite',
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
	companyId : currentUser.companyId,
	userId : currentUser.userId,
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
	
	getTheme : function(){
		if(smartChart.chartType === swChartType.LINE)
			return "Base";
		else if(smartChart.chartType === swChartType.AREA)
			return "Base";
		else if(smartChart.chartType === swChartType.BAR)
			return "Base";
		else if(smartChart.chartType === swChartType.PIE)
			return "Category2";
		else if(smartChart.chartType === swChartType.COLUMN)
			return "Base";
		else if(smartChart.chartType === swChartType.GUAGE)
			return "Base";
		else if(smartChart.chartType === swChartType.RADAR)
			return "Base";
		else if(smartChart.chartType === swChartType.SCATTER)
			return "Base";
	},
	
	getAxes : function() {
		var yAxisPosition = "left";
		var xAxisPosition = "bottom";
		if(smartChart.chartType === swChartType.BAR){
			yAxisPosition = "bottom";
			xAxisPosition = "left";
		}

		if(smartChart.chartType === swChartType.PIE) return [];
		else if(smartChart.chartType === swChartType.RADAR){
			return [{
                type: 'Radial',
                position: 'radial',
                label: {
                    display: true
                }}];		
		}else if(smartChart.chartType === swChartType.GAUGE){
			return [{
                type: 'gauge',
                position: 'gauge',
                minimum: 0,
                maximum: 100,
                steps: 10,
                margin: -10
            }];
		}else{ 
			return [{
				type : 'Numeric',
				minimum : 0,
				position : yAxisPosition,
				fields : smartChart.groupNames,
				title : smartChart.yValueName,
				minorTickSteps : 1,
				label: {
					renderer: Ext.util.Format.numberRenderer('0,0'),
					font: '11px Arial'
				}
			}, {
				type : 'Category',
				position : xAxisPosition,
				fields : [ smartChart.xFieldName ],
				title : smartChart.xFieldName,
				label: {
					font: '11px Arial',
					renderer: function(name) {
						return name;
					}
				}
			} ];
		}
	},

	getSeriesForPIE : function(index){
		var series = new Array();
		series = [{
		    type: smartChart.chartType,
		    field: smartChart.groupNames[index],
		    showInLegend: true,
		    highlight: {
		      segment: {
		        margin: 20
		      }
		    },
		    label: {
		        field: 'name',
		        display: 'rotate',
		        contrast: true,
		        font: '11px Arial'
		    }		}];
	    return series;
	},
	
	getSeries : function() {
		var style  = { fill: '#38B8BF', stroke: '#38B8BF', 'stroke-width': 3 };
		if(smartChart.chartType === swChartType.RADAR ) style = { 'stroke-width': 2, fill: 'none'};

		var series = new Array();
		for ( var i = 0; i < smartChart.groupNames.length; i++){
			series.push({
				type : smartChart.chartType,
				highlight : {
					size : 7,
					radius : 7
				},
				axis : "left",
				xField : smartChart.xFieldName,
				yField : smartChart.groupNames[i],
				stacked : false,
                tips: {
                    trackMouse: true,
                    width: 110,
                    height: 25,
                    renderer: function(storeItem, item) {
                        this.setTitle(storeItem + ": " + item.value[1]);
                        console.log(storeItem);
                        console.log(item);
                    }
                },
                style: { 
                	fill: '#38B8BF', 
                	stroke: '#38B8BF', 
                	'stroke-width': 3 },
                markerConfig: {
                    type: 'circle',
                    size: 4,
                    radius: 4,
                    'stroke-width': 0,
                    fill: '#38B8BF',
                    stroke: '#38B8BF'
                }
			});
		}
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
	
	reload : function(chartType, isStacked){
		smartChart.chartType = chartType;
		smartChart.isStacked = isStacked;
		smartChart.createChart();
	},

	createChart : function(){
		if(smartChart.chartType === swChartType.PIE){
			for(var i=0; i< smartChart.groupNames.length; i++)
				Ext.create('Ext.chart.Chart', {
					width: 300,
					height: 200,
					minHeight: 300,
					minWidth: 200,
					animate: true,
//					theme: smartChart.getTheme(),
					renderTo : Ext.get(smartChart.target),
					store : Ext.create('Ext.data.JsonStore', {
						fields : smartChart.getFields(),
						data : smartChart.values
					}),
					shadow : true,
					axes : smartChart.getAxes(),
					series : smartChart.getSeriesForPIE(i)
				});		
		}else if(smartChart.chartType === swChartType.GAUGE){
			for(var i=0; i<smartChart.groupNames.length; i++)
				Ext.create('Ext.chart.Chart', {
					width: 300,
					height: 200,
					minHeight: 300,
					minWidth: 200,
		            style: 'background:#fff',
		            animate: {
		                easing: 'elasticIn',
		                duration: 1000
		            },
		            renderTo: Ext.get(smartChart.target),
		            store : Ext.create('Ext.data.JsonStore', {
						fields : smartChart.getFields(),
						data : smartChart.values
		            }),
		            
		            insetPadding: 25,
		            flex: 1,					
		            axes: smartChart.getAxes(),
		            series: [{
		                type: smartChart.chartType,
		                field: smartChart.groupNames[i],
		                donut: 30,
		                colorSet: ['#F49D10', '#ddd']
		            }]
		 				});

		}else{
			Ext.create('Ext.chart.Chart', {
				width: 600,
				height: 400,
				animate: true,
				renderTo : Ext.get(smartChart.target),
				store : Ext.create('Ext.data.JsonStore', {
					fields : smartChart.getFields(),
					data : smartChart.values
				}),
				shadow : true,
//				theme : smartChart.getTheme(),
				legend : {
					position : 'bottom'
				},
				axes : smartChart.getAxes(),
				series : smartChart.getSeries()
			});		
		}
	}
};
