package net.smartworks.model.report;

import net.smartworks.model.community.User;
import net.smartworks.model.work.FormField;
import net.smartworks.util.LocalDate;

public class MatrixReport extends ChartReport {

	private FormField x1Axis;
	private String x1AxisSeletor;
	private String x1AxisSort;
	private FormField x2Axis;
	private String x2AxisSelector;
	private String x2AxisSort;
	private FormField y1Axis;
	private String y1AxisSelector;
	private String y1AxisSort;
	private FormField y2Axis;
	private String y2AxisSelector;
	private String y2AxisSort;
	private String value;
		
	public FormField getX1Axis() {
		return x1Axis;
	}
	public void setX1Axis(FormField x1Axis) {
		this.x1Axis = x1Axis;
	}
	public String getX1AxisSeletor() {
		return x1AxisSeletor;
	}
	public void setX1AxisSeletor(String x1AxisSeletor) {
		this.x1AxisSeletor = x1AxisSeletor;
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
	public FormField getY1Axis() {
		return y1Axis;
	}
	public void setY1Axis(FormField y1Axis) {
		this.y1Axis = y1Axis;
	}
	public String getY1AxisSelector() {
		return y1AxisSelector;
	}
	public void setY1AxisSelector(String y1AxisSelector) {
		this.y1AxisSelector = y1AxisSelector;
	}
	public String getY1AxisSort() {
		return y1AxisSort;
	}
	public void setY1AxisSort(String y1AxisSort) {
		this.y1AxisSort = y1AxisSort;
	}
	public FormField getY2Axis() {
		return y2Axis;
	}
	public void setY2Axis(FormField y2Axis) {
		this.y2Axis = y2Axis;
	}
	public String getY2AxisSelector() {
		return y2AxisSelector;
	}
	public void setY2AxisSelector(String y2AxisSelector) {
		this.y2AxisSelector = y2AxisSelector;
	}
	public String getY2AxisSort() {
		return y2AxisSort;
	}
	public void setY2AxisSort(String y2AxisSort) {
		this.y2AxisSort = y2AxisSort;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
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
