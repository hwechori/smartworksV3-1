package net.smartworks.server.engine.resource.model;

import java.util.List;

/**
 * 가젯 정의 정보
 * 
 * @author jhnam
 * @version $Id: IGadgetDef.java,v 1.1 2011/11/08 03:15:07 kmyu Exp $
 */
public interface IGadgetDef {
	
	/**
	 * GRID 가젯
	 */
	public static final String TYPE_GRID = "GRID";
	/**
	 * 기본차트 가젯 타입 - 업무 처리 건수
	 */	
	public static final String TYPE_WORK_COMPLETE_COUNT_BASIC_CHART = "WORK_COMPLETE_COUNT_BASIC_CHART";
	/**
	 * 기본차트 가젯 타입 - 지연 업무 건수
	 */	
	public static final String TYPE_WORK_DELAY_COUNT_BASIC_CHART = "WORK_DELAY_COUNT_BASIC_CHART";
	/**
	 * 기본차트 가젯 타입 - 업무 처리 평균 시간
	 */	
	public static final String TYPE_WORK_AVG_TIME_BASIC_CHART  = "WORK_AVG_TIME_BASIC_CHART";
	/**
	 * 기본차트 가젯
	 */	
	public static final String BASIC_CHART = "BASIC_CHART";	
	/**
	 * 바차트 가젯
	 */	
	public static final String TYPE_BAR_CHART = "BAR_CHART";
	/**
	 * 라인차트 가젯
	 */	
	public static final String TYPE_LINE_CHART = "LINE_CHART";
	/**
	 * 파이차트 가젯
	 */	
	public static final String TYPE_PIE_CHART = "PIE_CHART";
	/**
	 * Area차트 가젯
	 */	
	public static final String TYPE_AREAR_CHART = "AREAR_CHART";
	/**
	 * 게이지차트 가젯
	 */	
	public static final String TYPE_GAUGE_CHART = "GAUGE_CHART";
	
	public String getType();
	public void setType(String type);
	
	public String getName();
	public void setName(String name);
	
	public String getFormId();
	public void setFormId(String formId);
	
	public String getRemarkId();
	public void setRemarkId(String remarkId);
	
	public String getRemarkName();
	public void setRemarkName(String remarkName);
	
	public String getValueId();
	public void setValueId(String valueId);
	
	public String getValueName();
	public void setValueName(String valueUnit);
	
	public String getValueUnit();
	public void setValueUnit(String valueUnit);
	
	public String getValueFilterFunction();
	public void setValueFilterFunction(String valueFilterFunction);
	
	public String getMinValue();
	public void setMinValue(String minValue);
	
	public String getMaxValue();
	public void setMaxValue(String maxValue);
	
	public String getValueType();
	public void setValueType(String valueType);
	
	public String getGroupingId();
	public void setGroupingId(String groupingId);
	
	public String getGroupingName();
	public void setGroupingName(String groupingName);
	
	public String getGroupingFilterType();
	public void setGroupingFilterType(String groupingFilterType);
	
	public String getGroupingFilterValue();
	public void setGroupingFilterValue(String groupingFilterValue);
	
	public String getConditionsRelation();
	public void setConditionsRelation(String conditionsRelation);
	
	public List<IChartConditionDef> getConditions();
	public void setConditions(List<IChartConditionDef> conditions);
	public void addCondition(IChartConditionDef condition);
	
	public List<String[]> getColumns();
	public void setColumns(List<String[]> columns);
	public void addColumn(String columnId, String columnName);
	
}
