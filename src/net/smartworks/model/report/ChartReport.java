package net.smartworks.model.report;

import net.smartworks.model.community.User;
import net.smartworks.model.work.FormField;
import net.smartworks.util.LocalDate;
import net.smartworks.util.SmartUtil;

public class ChartReport extends Report {

	public static final int CHART_TYPE_COLUMN = 1;
	public static final int CHART_TYPE_BAR = 2;
	public static final int CHART_TYPE_LINE = 3;
	public static final int CHART_TYPE_AREA = 4;
	public static final int CHART_TYPE_PIE = 5;
	public static final int CHART_TYPE_BUBBLE = 6;
	public static final int CHART_TYPE_PLOT = 7;
	public static final int DEFAULT_CHART_TYPE = CHART_TYPE_COLUMN;

	public static final String CHART_PCNT_MONTHLY = "chart.pcnt.monthly";
	public static final String CHART_PCNT_MONTHLY_DEPARTMENT = "chart.pcnt.monthly.by_department";
	public static final String CHART_PMEAN_MONTHLY = "chart.pmean.monthly";
	public static final String CHART_PMEAN_MONTHLY_DEPARTMENT = "chart.pmean.monthly.by_department";
	public static final String CHART_PSUM_MONTHLY = "chart.psum.monthly";
	public static final String CHART_PSUM_MONTHLY_DEPARTMENT = "chart.psum.monthly.by_department";
	public static final String CHART_PMAX_MONTHLY = "chart.pmax.monthly";
	public static final String CHART_PMAX_MONTHLY_DEPARTMENT = "chart.pmax.monthly.by_department";
	public static final String CHART_PMIN_MONTHLY = "chart.pmin.monthly";
	public static final String CHART_PMIN_MONTHLY_DEPARTMENT = "chart.pmin.monthly.by_department";

	public static final ChartReport[] DEFAULT_CHARTS_INFORMATION = new ChartReport[] { getChartPCntMonthly(), getChartPCntMonthlyByDepartment(),
		getChartPMeanMonthly(), getChartPMeanMonthlyByDepartment(), getChartPSumMonthly(), getChartPSumMonthlyByDepartment(), getChartPMaxMonthly(),
		getChartPMaxMonthlyByDepartment(), getChartPMinMonthly(), getChartPMinMonthlyByDepartment() };

	public static final ChartReport[] DEFAULT_CHARTS_PROCESS = new ChartReport[] { getChartPCntMonthly(), getChartPCntMonthlyByDepartment(),
		getChartPMeanMonthly(), getChartPMeanMonthlyByDepartment(), getChartPSumMonthly(), getChartPSumMonthlyByDepartment(), getChartPMaxMonthly(),
		getChartPMaxMonthlyByDepartment(), getChartPMinMonthly(), getChartPMinMonthlyByDepartment() };

	private int chartType = -1;
	private FormField xAxis;
	private String xAxisSeletor;
	private String xAxisSort = Report.AXIS_SORT_ASCEND.getId();
	private FormField yAxis;
	private String yAxisSelector;
	private String valueType;
	private FormField zAxis;
	private String zAxisSelector;

	public int getChartType() {
		return chartType;
	}

	public void setChartType(int chartType) {
		this.chartType = chartType;
	}

	public FormField getXAxis() {
		return xAxis;
	}

	public void setXAxis(FormField xAxis) {
		this.xAxis = xAxis;
	}

	public String getXAxisSeletor() {
		return xAxisSeletor;
	}

	public void setXAxisSeletor(String xAxisSeletor) {
		this.xAxisSeletor = xAxisSeletor;
	}

	public String getXAxisSort() {
		return xAxisSort;
	}

	public void setXAxisSort(String xAxisSort) {
		this.xAxisSort = xAxisSort;
	}

	public FormField getYAxis() {
		return yAxis;
	}

	public void setYAxis(FormField yAxis) {
		this.yAxis = yAxis;
	}

	public String getYAxisSelector() {
		return yAxisSelector;
	}

	public void setYAxisSelector(String yAxisSelector) {
		this.yAxisSelector = yAxisSelector;
	}

	public String getValueType() {
		return valueType;
	}

	public void setValueType(String valueType) {
		this.valueType = valueType;
	}

	public FormField getZAxis() {
		return zAxis;
	}

	public void setZAxis(FormField zAxis) {
		this.zAxis = zAxis;
	}

	public String getZAxisSelector() {
		return zAxisSelector;
	}

	public void setZAxisSelector(String zAxisSelector) {
		this.zAxisSelector = zAxisSelector;
	}

	public ChartReport() {
		super();
	}

	public ChartReport(String id, String name) {
		super(id, name);
	}

	public ChartReport(String id, String name, int type, User owner, User lastModifier, LocalDate lastModifiedDate) {
		super(id, name, type, owner, lastModifier, lastModifiedDate);
	}

	public static ChartReport getChartPCntMonthly() {
		ChartReport chart = new ChartReport(CHART_PCNT_MONTHLY, CHART_PCNT_MONTHLY, DEFAULT_CHART_TYPE, SmartUtil.getSystemUser(), SmartUtil.getSystemUser(),
				new LocalDate());
		chart.chartType = DEFAULT_CHART_TYPE;
		chart.xAxis = FormField.FIELD_LAST_MODIFIED_DATE;
		chart.xAxisSeletor = Report.AXIS_SELECTOR_BY_MONTH.getId();
		chart.yAxis = FormField.FIELD_LAST_MODIFIED_DATE;
		chart.valueType = Report.VALUE_TYPE_COUNT.getId();
		return chart;
	}

	public static ChartReport getChartPCntMonthlyByDepartment() {
		ChartReport chart = new ChartReport(CHART_PCNT_MONTHLY_DEPARTMENT, CHART_PCNT_MONTHLY_DEPARTMENT, DEFAULT_CHART_TYPE, SmartUtil.getSystemUser(),
				SmartUtil.getSystemUser(), new LocalDate());
		chart.chartType = DEFAULT_CHART_TYPE;
		chart.xAxis = FormField.FIELD_LAST_MODIFIED_DATE;
		chart.xAxisSeletor = Report.AXIS_SELECTOR_BY_MONTH.getId();
		chart.yAxis = FormField.FIELD_LAST_MODIFIED_DATE;
		chart.valueType = Report.VALUE_TYPE_COUNT.getId();
		chart.zAxis = FormField.FIELD_LAST_MODIFIER;
		chart.zAxisSelector = Report.AXIS_SELECTOR_USER_DEPARTMENT.getId();
		return chart;
	}

	public static ChartReport getChartPMeanMonthly() {
		ChartReport chart = new ChartReport(CHART_PMEAN_MONTHLY, CHART_PMEAN_MONTHLY, DEFAULT_CHART_TYPE, SmartUtil.getSystemUser(), SmartUtil.getSystemUser(),
				new LocalDate());
		chart.chartType = DEFAULT_CHART_TYPE;
		chart.xAxis = FormField.FIELD_LAST_MODIFIED_DATE;
		chart.xAxisSeletor = Report.AXIS_SELECTOR_BY_MONTH.getId();
		chart.yAxis = FormField.FIELD_PROCESS_TIME;
		chart.valueType = Report.VALUE_TYPE_MEAN.getId();
		return chart;
	}

	public static ChartReport getChartPMeanMonthlyByDepartment() {
		ChartReport chart = new ChartReport(CHART_PMEAN_MONTHLY_DEPARTMENT, CHART_PMEAN_MONTHLY_DEPARTMENT, DEFAULT_CHART_TYPE, SmartUtil.getSystemUser(),
				SmartUtil.getSystemUser(), new LocalDate());
		chart.chartType = DEFAULT_CHART_TYPE;
		chart.xAxis = FormField.FIELD_LAST_MODIFIED_DATE;
		chart.xAxisSeletor = Report.AXIS_SELECTOR_BY_MONTH.getId();
		chart.yAxis = FormField.FIELD_PROCESS_TIME;
		chart.valueType = Report.VALUE_TYPE_MEAN.getId();
		chart.zAxis = FormField.FIELD_LAST_MODIFIER;
		chart.zAxisSelector = Report.AXIS_SELECTOR_USER_DEPARTMENT.getId();
		return chart;
	}

	public static ChartReport getChartPSumMonthly() {
		ChartReport chart = new ChartReport(CHART_PSUM_MONTHLY, CHART_PSUM_MONTHLY, DEFAULT_CHART_TYPE, SmartUtil.getSystemUser(), SmartUtil.getSystemUser(),
				new LocalDate());
		chart.chartType = DEFAULT_CHART_TYPE;
		chart.xAxis = FormField.FIELD_LAST_MODIFIED_DATE;
		chart.xAxisSeletor = Report.AXIS_SELECTOR_BY_MONTH.getId();
		chart.yAxis = FormField.FIELD_PROCESS_TIME;
		chart.valueType = Report.VALUE_TYPE_SUM.getId();
		return chart;
	}

	public static ChartReport getChartPSumMonthlyByDepartment() {
		ChartReport chart = new ChartReport(CHART_PSUM_MONTHLY_DEPARTMENT, CHART_PSUM_MONTHLY_DEPARTMENT, DEFAULT_CHART_TYPE, SmartUtil.getSystemUser(),
				SmartUtil.getSystemUser(), new LocalDate());
		chart.chartType = DEFAULT_CHART_TYPE;
		chart.xAxis = FormField.FIELD_LAST_MODIFIED_DATE;
		chart.xAxisSeletor = Report.AXIS_SELECTOR_BY_MONTH.getId();
		chart.yAxis = FormField.FIELD_PROCESS_TIME;
		chart.valueType = Report.VALUE_TYPE_SUM.getId();
		chart.zAxis = FormField.FIELD_LAST_MODIFIER;
		chart.zAxisSelector = Report.AXIS_SELECTOR_USER_DEPARTMENT.getId();
		return chart;
	}

	public static ChartReport getChartPMaxMonthly() {
		ChartReport chart = new ChartReport(CHART_PMAX_MONTHLY, CHART_PMAX_MONTHLY, DEFAULT_CHART_TYPE, SmartUtil.getSystemUser(), SmartUtil.getSystemUser(),
				new LocalDate());
		chart.chartType = DEFAULT_CHART_TYPE;
		chart.xAxis = FormField.FIELD_LAST_MODIFIED_DATE;
		chart.xAxisSeletor = Report.AXIS_SELECTOR_BY_MONTH.getId();
		chart.yAxis = FormField.FIELD_PROCESS_TIME;
		chart.valueType = Report.VALUE_TYPE_MAX.getId();
		return chart;
	}

	public static ChartReport getChartPMaxMonthlyByDepartment() {
		ChartReport chart = new ChartReport(CHART_PMAX_MONTHLY_DEPARTMENT, CHART_PMAX_MONTHLY_DEPARTMENT, DEFAULT_CHART_TYPE, SmartUtil.getSystemUser(),
				SmartUtil.getSystemUser(), new LocalDate());
		chart.chartType = DEFAULT_CHART_TYPE;
		chart.xAxis = FormField.FIELD_LAST_MODIFIED_DATE;
		chart.xAxisSeletor = Report.AXIS_SELECTOR_BY_MONTH.getId();
		chart.yAxis = FormField.FIELD_PROCESS_TIME;
		chart.valueType = Report.VALUE_TYPE_MAX.getId();
		chart.zAxis = FormField.FIELD_LAST_MODIFIER;
		chart.zAxisSelector = Report.AXIS_SELECTOR_USER_DEPARTMENT.getId();
		return chart;
	}

	public static ChartReport getChartPMinMonthly() {
		ChartReport chart = new ChartReport(CHART_PMIN_MONTHLY, CHART_PMIN_MONTHLY, DEFAULT_CHART_TYPE, SmartUtil.getSystemUser(), SmartUtil.getSystemUser(),
				new LocalDate());
		chart.chartType = DEFAULT_CHART_TYPE;
		chart.xAxis = FormField.FIELD_LAST_MODIFIED_DATE;
		chart.xAxisSeletor = Report.AXIS_SELECTOR_BY_MONTH.getId();
		chart.yAxis = FormField.FIELD_PROCESS_TIME;
		chart.valueType = Report.VALUE_TYPE_MIN.getId();
		return chart;
	}

	public static ChartReport getChartPMinMonthlyByDepartment() {
		ChartReport chart = new ChartReport(CHART_PMIN_MONTHLY_DEPARTMENT, CHART_PMIN_MONTHLY_DEPARTMENT, DEFAULT_CHART_TYPE, SmartUtil.getSystemUser(),
				SmartUtil.getSystemUser(), new LocalDate());
		chart.chartType = DEFAULT_CHART_TYPE;
		chart.xAxis = FormField.FIELD_LAST_MODIFIED_DATE;
		chart.xAxisSeletor = Report.AXIS_SELECTOR_BY_MONTH.getId();
		chart.yAxis = FormField.FIELD_PROCESS_TIME;
		chart.valueType = Report.VALUE_TYPE_MIN.getId();
		chart.zAxis = FormField.FIELD_LAST_MODIFIER;
		chart.zAxisSelector = Report.AXIS_SELECTOR_USER_DEPARTMENT.getId();
		return chart;
	}
}
