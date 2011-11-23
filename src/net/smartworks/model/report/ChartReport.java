package net.smartworks.model.report;

import net.smartworks.model.community.User;
import net.smartworks.model.work.FormField;
import net.smartworks.util.LocalDate;

public class ChartReport extends Report {

	public static final int CHART_TYPE_COLUMN = 1;
	public static final int CHART_TYPE_BAR = 2;
	public static final int CHART_TYPE_LINE = 3;
	public static final int CHART_TYPE_AREA = 4;
	public static final int CHART_TYPE_PIE = 5;
	public static final int CHART_TYPE_BUBBLE = 6;
	public static final int CHART_TYPE_PLOT = 7;
	
	public static final int VALUE_TYPE_COUNT = 1;
	public static final int VALUE_TYPE_SUM = 2;
	public static final int VALUE_TYPE_MEAN = 3;
	public static final int VALUE_TYPE_MIN = 4;
	public static final int VALUE_TYPE_MAX = 5;
	
	
	private int chartType = -1;
	private FormField xAxis;
	private FormField yAxis;
	private FormField zAxis;
	private int valueType;
	
	public ChartReport() {
		super();
	}
	
	public ChartReport(String id, String name){
		super(id, name);
	}

	public ChartReport(String id, String name, int type, User owner, User lastModifier,
			LocalDate lastModifiedDate) {
		super(id, name, type, owner, lastModifier, lastModifiedDate);
	}
	
}
