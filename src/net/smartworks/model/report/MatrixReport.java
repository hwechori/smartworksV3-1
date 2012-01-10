package net.smartworks.model.report;

import net.smartworks.model.community.User;
import net.smartworks.model.work.FormField;
import net.smartworks.util.LocalDate;

public class MatrixReport extends ChartReport {
	
	public static final MatrixReport[] DEFAULT_MATRIXS_INFORMATION = new MatrixReport[]{};
	public static final MatrixReport[] DEFAULT_MATRIXS_PROCESS = new MatrixReport[]{};

	private FormField xSecondAxis;
	private String xSecondAxisSelector;
	private String xSecondAxisSort;
	private FormField zSecondAxis;
	private String zSecondAxisSelector;
	private String zSecondAxisSort;
	
	
	public FormField getXSecondAxis() {
		return xSecondAxis;
	}
	public void setXSecondAxis(FormField xSecondAxis) {
		this.xSecondAxis = xSecondAxis;
	}
	public String getXSecondAxisSelector() {
		return xSecondAxisSelector;
	}
	public void setXSecondAxisSelector(String xSecondAxisSelector) {
		this.xSecondAxisSelector = xSecondAxisSelector;
	}
	public String getXSecondAxisSort() {
		return xSecondAxisSort;
	}
	public void setXSecondAxisSort(String xSecondAxisSort) {
		this.xSecondAxisSort = xSecondAxisSort;
	}
	public FormField getZSecondAxis() {
		return zSecondAxis;
	}
	public void setZSecondAxis(FormField zSecondAxis) {
		this.zSecondAxis = zSecondAxis;
	}
	public String getZSecondAxisSelector() {
		return zSecondAxisSelector;
	}
	public void setZSecondAxisSelector(String zSecondAxisSelector) {
		this.zSecondAxisSelector = zSecondAxisSelector;
	}
	public String getZSecondAxisSort() {
		return zSecondAxisSort;
	}
	public void setZSecondAxisSort(String zSecondAxisSort) {
		this.zSecondAxisSort = zSecondAxisSort;
	}

	public MatrixReport() {
		super();
	}	

	public MatrixReport(String id, String name){
		super(id, name);
	}
	public MatrixReport(String id, String name, User owner, User lastModifier,
			LocalDate lastModifiedDate) {
		super(id, name, owner, lastModifier, lastModifiedDate);
		super.setType(Report.TYPE_MATRIX);
	}

}
