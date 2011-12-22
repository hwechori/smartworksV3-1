package net.smartworks.model.report.info;

import net.smartworks.model.BaseObject;
import net.smartworks.model.report.ChartReport;

public class ReportInfo extends BaseObject {

	private int type;
	private int chartType=-1;
	
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getChartType() {
		return chartType;
	}
	public void setChartType(int chartType) {
		this.chartType = chartType;
	}
	public String getChartTypeInString(){
		if(chartType<1 || chartType>=ChartReport.CHART_TYPES_STRING.length) return null;
		return ChartReport.CHART_TYPES_STRING[chartType];
	}
	
	public ReportInfo() {
		super();
	}
	
	public ReportInfo(String id, String name){
		super(id, name);
	}
}
