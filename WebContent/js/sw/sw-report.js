
Ext.require([ 'Ext.Window',
              'Ext.form.*',
              'Ext.data.*',
              'Ext.chart.*',
              'Ext.grid.Panel',
              'Ext.layout.container.Column',
              'Ext.fx.target.Sprite',
              'Ext.layout.container.Fit' ]);
Ext.onReady(function () {
	swReportType = {
		CHART : 1,
		MATRIX : 2,
		TABLE : 3
	};
	
	swChartType = {
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
	
	chartUtil = {
	
	};
	
	smartChart = {
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
			fields.push({name: smartChart.xFieldName});
			for ( var i = 0; i < smartChart.groupNames.length; i++)
				fields.push({name: smartChart.groupNames[i]});
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
			var yAxisGrid = true;
			if(smartChart.chartType === swChartType.AREA)
				yAxisGrid = false;
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
					grid : yAxisGrid,
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
			    donut: 20,
			    highlight: {
			      segment: {
			        margin: 10
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
		
		getSeries : function(type) {			
			var axis = "left";
			if(smartChart.chartType === swChartType.RADAR ) style = { 'stroke-width': 2, fill: 'none'};	
			if(smartChart.chartType === swChartType.BAR) axis = "bottom";
			if(type === swChartType.LINE){
				var series = new Array();
				for(var i=0; i<smartChart.groupNames.length; i++){
					series.push({
						type : smartChart.chartType,
						axis : axis,
						xField : smartChart.xFieldName,
						yField : smartChart.groupNames[i],
						stacked : smartChart.isStacked,
		                highlight: {
		                    size: 7,
		                    radius: 7
		                },
		                markerConfig: {
		                    type: 'circle',
		                    size: 4,
		                    radius: 4,
		                    'stroke-width': 0
		                }
//		                tips: {
//		                    trackMouse: true,
//		                    height : -1,
//		                    width : -1,
//		                    renderer: function(storeItem, item) {
//		                    	this.setTitle(storeItem.data.name + ":" +item.value[1]);
//		                    }
//		                }
					});
				}
				return series;
			}else{
				return [{
					type : smartChart.chartType,
	                gutter: 80,
					axis : axis,
					xField : smartChart.xFieldName,
					yField : smartChart.groupNames,
					highlight : true,
					stacked : smartChart.isStacked
//	                tips: {
//	                    trackMouse: true,
//	                    height : 18,
//	                    width : 60,
//	                    renderer: function(storeItem, item) {                    	
//	                    	this.setTitle(item.value[1]);
//	                    }
//	                }
				}];
			}
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
		
		getColumns : function(){
        	var columns = new Array();
        	columns.push({
        		id: smartChart.xFieldName,
        		text: smartChart.xFieldName,
        		flex: 1,
        		sortable: true,
        		dataIndex: smartChart.xFieldName
        	});
        	for(var i=0; i<smartChart.groupNames.length; i++){
	        	columns.push({
	        		text: smartChart.groupNames[i],
	        		align: 'right',
	        		sortable: true,
	        		dataIndex: smartChart.groupNames[i]
	        	});		        		
        	}
        	return columns;			
		},
		
		createChart : function(){
		    gridPanel = Ext.create('Ext.grid.Panel', {
		        id: 'reportDataGrid',
		        align: 'stretch',
		        border: false,
		        height: 200,
		        resizable: true,
		        store:  Ext.create('Ext.data.JsonStore', {
					fields : smartChart.getFields(),
					data : smartChart.values
				}),
				renderTo : Ext.get(smartChart.target),
		        columns: smartChart.getColumns(),
//		        listeners: {
//		            selectionchange: function(model, records) {
//		                var json, name, i, l, items, series, fields;
//		                if (records[0]) {
//		                    rec = records[0];
//		                    if (!form) {
//		                        form = this.up('form').getForm();
//		                        fields = form.getFields();
//		                        fields.each(function(field){
//		                            if (field.name != 'company') {
//		                                field.setDisabled(false);
//		                            }
//		                        });
//		                    } else {
//		                        fields = form.getFields();
//		                    }
//		                    
//		                    // prevent change events from firing
//		                    fields.each(function(field){
//		                        field.suspendEvents();
//		                    });
//		                    form.loadRecord(rec);
//		                    updateRecord(rec);
//		                    fields.each(function(field){
//		                        field.resumeEvents();
//		                    });
//		                }
////		            }
//		        }
		    });
		    
			if(smartChart.chartType === swChartType.PIE){
				for(var i=0; i< smartChart.groupNames.length; i++)
					Ext.create('Ext.chart.Chart', {
						width: 300,
						height: 200,
						minHeight: 300,
						minWidth: 200,
						animate: true,
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
					align: 'stretch',
					height: 400,
					animate: true,
					resizable: true,
					renderTo : Ext.get(smartChart.target),
					store : Ext.create('Ext.data.JsonStore', {
						fields : smartChart.getFields(),
						data : smartChart.values
					}),
					shadow : true,
					legend : {
						position : 'right'
					},
					axes : smartChart.getAxes(),
					series : smartChart.getSeries(smartChart.chartType)
				});		
			}
		}
	};
});
