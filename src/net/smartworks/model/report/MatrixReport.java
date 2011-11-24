package net.smartworks.model.report;

import net.smartworks.model.community.User;
import net.smartworks.model.work.FormField;
import net.smartworks.util.LocalDate;

public class MatrixReport extends ChartReport {

	private String yAxisSort;
	private String zAxisSort;
	private FormField x1Axis;
	private String x1AxisSelector;
	private String x1AxisSort;
	private FormField x2Axis;
	private String x2AxisSelector;
	private String x2AxisSort;
	
	public String getyAxisSort() {
		return yAxisSort;
	}
	public void setyAxisSort(String yAxisSort) {
		this.yAxisSort = yAxisSort;
	}
	public String getzAxisSort() {
		return zAxisSort;
	}
	public void setzAxisSort(String zAxisSort) {
		this.zAxisSort = zAxisSort;
	}
	public FormField getX1Axis() {
		return x1Axis;
	}
	public void setX1Axis(FormField x1Axis) {
		this.x1Axis = x1Axis;
	}
	public String getX1AxisSelector() {
		return x1AxisSelector;
	}
	public void setX1AxisSelector(String x1AxisSelector) {
		this.x1AxisSelector = x1AxisSelector;
	}
	public String getX1AxisSort() {
		return x1AxisSort;
	}
	public void setX1AxisSort(String x1AxisSort) {
		this.x1AxisSort = x1AxisSort;
	}
	public FormField getX2Axis() {
		return x2Axis;
	}
	public void setX2Axis(FormField x2Axis) {
		this.x2Axis = x2Axis;
	}
	public String getX2AxisSelector() {
		return x2AxisSelector;
	}
	public void setX2AxisSelector(String x2AxisSelector) {
		this.x2AxisSelector = x2AxisSelector;
	}
	public String getX2AxisSort() {
		return x2AxisSort;
	}
	public void setX2AxisSort(String x2AxisSort) {
		this.x2AxisSort = x2AxisSort;
	}
	public MatrixReport() {
		super();
	}	

	public MatrixReport(String id, String name){
		super(id, name);
	}
	public MatrixReport(String id, String name, User owner, User lastModifier,
			LocalDate lastModifiedDate) {
		super(id, name, Report.TYPE_MATRIX, owner, lastModifier, lastModifiedDate);
	}

}
