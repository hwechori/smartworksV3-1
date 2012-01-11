
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
		labelFont : '11px Arial',
		labelRotate : null,
	
		getFields : function() {
			var fields = new Array();
			fields.push({name: smartChart.xFieldName});
			for ( var i = 0; i < smartChart.groupNames.length; i++)
				fields.push({name: smartChart.groupNames[i]});
			return fields;
		},
		
		getTheme : function(chartType){
			if(chartType === swChartType.LINE)
				return "Base";
			else if(chartType === swChartType.AREA)
				return "Base";
			else if(chartType === swChartType.BAR)
				return "Base";
			else if(chartType === swChartType.PIE)
				return "Category2";
			else if(chartType === swChartType.COLUMN)
				return "Base";
			else if(chartType === swChartType.GUAGE)
				return "Base";
			else if(chartType === swChartType.RADAR)
				return "Category2";
			else if(chartType === swChartType.SCATTER)
				return "Base";
		},
		
		getAxes : function(chartType) {
			var yAxisPosition = "left";
			var xAxisPosition = "bottom";
			var yAxisGrid = true;
			if(chartType === swChartType.AREA)
				yAxisGrid = false;
			if(chartType === swChartType.BAR){
				yAxisPosition = "bottom";
				xAxisPosition = "left";
			}
			var labelRotate = smartChart.labelRotate;
			if(chartType === swChartType.BAR
					|| chartType === swChartType.PIE
					|| chartType === swChartType.GAUGE
					|| chartType === swChartType.RADAR){
				labelRotate = null;
			}
			
			var numericLabel = {
				renderer: Ext.util.Format.numberRenderer('0,0'),
				font: smartChart.labelFont
			};
			var categoryLabel = {
				font: smartChart.labelFont,
				renderer: function(name) {
					return name;
				}
			};
	
			if(chartType === swChartType.PIE) return [];
			else if(chartType === swChartType.RADAR){
				return [{
	                type: 'Radial',
	                position: 'radial',
	                label: {
	                    display: true,
	                    font: smartChart.labelFont
	                }
				}];		
			}else if(chartType === swChartType.GAUGE){
				return [{
	                type: 'gauge',
	                position: 'gauge',
	                title: smartChart.xfieldName,
	                minimum: 0,
	                maximum: 100,
	                steps: 10,
	                margin: -10
	            }];
			}else if(chartType === swChartType.SCATTER){
				return [{
					        type: 'Numeric',
					        position: 'left',
					        fields: smartChart.groupNames,
					        title: smartChart.yValueName,
					        grid: true,
					        minimum: 0,
					        label : numericLabel
					    }, {
					        type: 'Category',
					        position: 'bottom',
					        fields: [ smartChart.xFieldName ],
					        title: smartChart.xFieldName,
					        label: labelRotate
					    }];
			}else if(chartType === swChartType.LINE 
					|| chartType === swChartType.AREA
					|| chartType === swChartType.BAR
					|| chartType === swChartType.COLUMN){ 
				return [{
					type : 'Numeric',
					minimum : 0,
					position : yAxisPosition,
					grid : yAxisGrid,
					fields : smartChart.groupNames,
					title : smartChart.yValueName,
					minorTickSteps : 1,
					label: numericLabel
				}, {
					type : 'Category',
					position : xAxisPosition,
					fields : [ smartChart.xFieldName ],
					title : smartChart.xFieldName,
	                label: labelRotate
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
			        font: smartChart.labelFont
			    }		}];
		    return series;
		},
		
		getSeries : function(chartType) {			
			var markerConfig = {
					type: 'circle',
					radius: 3,
					size: 3,							
				}; 
			var highlight = {
                    size: 7,
                    radius: 7
                };
			var axis = "left";
			if(chartType === swChartType.BAR) axis = "bottom";
			
			if(chartType === swChartType.LINE){
				var series = new Array();
				for(var i=0; i<smartChart.groupNames.length; i++){
					series.push({
						type : chartType,
						axis : axis,
						xField : smartChart.xFieldName,
						yField : smartChart.groupNames[i],
		                highlight: highlight,
		                markerConfig: markerConfig,
		                style:{
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
			}else if(chartType === swChartType.RADAR){
				var series = new Array();
				for(var i=0; i<smartChart.groupNames.length; i++){
					series.push({
						type : chartType,
						xField : smartChart.xFieldName,
						yField : smartChart.groupNames[i],
						showInLegend: true,
						showMarkers: true,
						markerConfig: markerConfig,
						style:{
							'stroke-width': 2,
							fill: 'none'
						}
					});
				}
				return series;
				
			}else if(chartType === swChartType.SCATTER){
				var series = new Array();
				for(var i=0; i<smartChart.groupNames.length; i++){
					series.push({
				        type: chartType,
					    showInLegend: true,
		                highlight: highlight,
		                label: {
		                	orientation: smartChart.labelOrientation
		                },
		                markerConfig: markerConfig,
		                style : {
		                    'stroke-width': 0
		                },
				        axis: 'left',
				        xField: smartChart.xFieldName,
				        yField: smartChart.groupNames[i]
					});
				}
				return series;
				
			}else if(chartType === swChartType.AREA
					|| chartType === swChartType.GAUGE
					|| chartType === swChartType.COLUMN
					|| chartType === swChartType.BAR){
				return [{
					type : chartType,
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
						if(data.values.length>15){
							smartChart.labelRotate = {
				                	rotate : {
				                		degrees : 270
				                	}
				                };
						}else smartChart.labelRotate = null;
						smartChart.createChart();
					}
				},
				error : function(xhr, ajaxOptions, thrownError){
					
				}
			});
		},
	
		load : function(reportType, reportId, chartType, isStacked, target) {
			smartChart.reportType = reportType;
			if(isEmpty(chartType)) chartType = swChartType.DEFAULT;
			smartChart.chartType = chartType;
			smartChart.isStacked = isStacked;
			smartChart.target = target;
			$('#'+target).html('');
			smartChart.getChartData(reportId);
		},
		
		loadWithData : function(reportType, data, chartType, isStacked, target) {
			console.log($('#' + target));
			smartChart.reportType = reportType;
			if(isEmpty(chartType)) chartType = swChartType.DEFAULT;
			smartChart.chartType = chartType;
			smartChart.isStacked = isStacked;
			smartChart.target = target;
			$('#'+target).html('');
			if(data){
				smartChart.xFieldName = data.xFieldName;
				smartChart.yValueName = data.yValueName;
				smartChart.groupNames = data.groupNames;
				smartChart.values = data.values;
				smartChart.createChart();
			}
		},
		
		reload : function(chartType, isStacked){
			smartChart.chartType = chartType;
			smartChart.isStacked = isStacked;
			$('#'+smartChart.target).html('');
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
//		    gridPanel = Ext.create('Ext.grid.Panel', {
//		        id: 'reportDataGrid',
//		        align: 'stretch',
//		        border: false,
//		        height: 200,
//		        resizable: true,
//		        store:  Ext.create('Ext.data.JsonStore', {
//					fields : smartChart.getFields(),
//					data : smartChart.values
//				}),
//				renderTo : Ext.get(smartChart.target),
//		        columns: smartChart.getColumns(),

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
						axes : smartChart.getAxes(smartChart.chartType),
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
			            axes: smartChart.getAxes(smartChart.chartType),
			            series: [{
			                type: smartChart.chartType,
			                field: smartChart.groupNames[i],
			                donut: 30,
			                colorSet: ['#F49D10', '#ddd']
			            }]
			 				});
	
			}else if(smartChart.chartType === swChartType.SCATTER){
					Ext.create('Ext.chart.Chart', {
						width: 600,
						height: 300,
						animate: true,
						theme: 'Category2',
						resizable: true,
			            style: 'background:#fff',
			            renderTo: Ext.get(smartChart.target),
			            store : Ext.create('Ext.data.JsonStore', {
							fields : smartChart.getFields(),
							data : smartChart.values
			            }),
			            
						legend : {
							position : 'right'
						},
			            flex: 1,					
			            axes: smartChart.getAxes(smartChart.chartType),
			            series: smartChart.getSeries(smartChart.chartType)
					});
	
			}else{
				Ext.create('Ext.form.Panel',{
					layout: {
						align: 'stretch',
						type: 'vbox'
					},
			        style: 'overflow: hidden;',
					items: [{
						xtype: 'container',
						flex: 1,
						layout: 'fit',
						items: [{
							xtype: 'chart',
							width: 600,
							height: 300,
							animate: true,
							theme: 'Category2',
							resizable: true,
							insetPadding: 20,// radar
							renderTo : Ext.get(smartChart.target),
							store : Ext.create('Ext.data.JsonStore', {
								fields : smartChart.getFields(),
								data : smartChart.values
							}),
							shadow : true,
							legend : {
								position : 'right'
							},
							axes : smartChart.getAxes(smartChart.chartType),
							series : smartChart.getSeries(smartChart.chartType)
						}]
					}]
				});
			}
		}
	};
});
