package net.smartworks.server.engine.resource.model.hb;

import java.util.ArrayList;
import java.util.List;

import net.smartworks.server.engine.resource.model.IChartConditionDef;
import net.smartworks.server.engine.resource.model.IGadgetDef;
import net.smartworks.server.engine.resource.util.SmartServerModelUtil;

/**
 * IGadgetDef 구현
 * 
 * @author jhnam
 * @version $Id: HbGadgetDef.java,v 1.1 2011/11/08 03:15:01 kmyu Exp $
 */
public class HbGadgetDef implements IGadgetDef {

	/**
	 * 차트 타입
	 */
	private String type;
	/**
	 * 차트 이름
	 */
	private String name;	
	/**
	 * 폼 아이디
	 */
	private String formId;
	/**
	 * 범례 아이디
	 */
	private String remarkId;
	/**
	 * 범례 이름
	 */
	private String remarkName;
	/**
	 * 값 필드 아이디
	 */
	private String valueId;
	/**
	 * 값 이름
	 */
	private String valueName;
	/**
	 * 값 단위
	 */
	private String valueUnit;
	/**
	 * 값 필터 함수
	 */
	private String valueFilterFunction;
	/**
	 * 값 필터 최소값 
	 */
	private String minValue;
	/**
	 * 값 필터 최대값
	 */
	private String maxValue;
	/**
	 * 값 타입
	 */
	private String valueType;
	/**
	 * Group By 필드 아이디
	 */
	private String groupingId;
	/**
	 * Group By 필드 이름
	 */
	private String groupingName;
	/**
	 * Group By 필터 타입
	 */
	private String groupingFilterType;
	/**
	 * Group By 필터 값
	 */
	private String groupingFilterValue;
	/**
	 * 조건 관계
	 */
	private String conditionsRelation;
	/**
	 * 차트 조건
	 */
	private List<IChartConditionDef> conditions;
	/**
	 * Grid Column - columnId
	 */
	private List<String[]> columns;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFormId() {
		return formId;
	}
	public void setFormId(String formId) {
		this.formId = formId;
	}
	public String getRemarkId() {
		return remarkId;
	}
	public void setRemarkId(String remarkId) {
		this.remarkId = remarkId;
	}
	public String getRemarkName() {
		return remarkName;
	}
	public void setRemarkName(String remarkName) {
		this.remarkName = remarkName;
	}
	public String getValueId() {
		return valueId;
	}
	public void setValueId(String valueId) {
		this.valueId = valueId;
	}
	public String getValueName() {
		return valueName;
	}
	public void setValueName(String valueName) {
		this.valueName = valueName;
	}
	public String getValueFilterFunction() {
		return valueFilterFunction;
	}
	public void setValueFilterFunction(String valueFilterFunction) {
		this.valueFilterFunction = valueFilterFunction;
	}
	public String getMinValue() {
		return minValue;
	}
	public void setMinValue(String minValue) {
		this.minValue = minValue;
	}
	public String getMaxValue() {
		return maxValue;
	}
	public void setMaxValue(String maxValue) {
		this.maxValue = maxValue;
	}
	public String getValueType() {
		return valueType;
	}
	public void setValueType(String valueType) {
		this.valueType = valueType;
	}
	public String getGroupingId() {
		return groupingId;
	}
	public void setGroupingId(String groupingId) {
		this.groupingId = groupingId;
	}
	public String getGroupingName() {
		return groupingName;
	}
	public void setGroupingName(String groupingName) {
		this.groupingName = groupingName;
	}
	public String getGroupingFilterType() {
		return groupingFilterType;
	}
	public void setGroupingFilterType(String groupingFilterType) {
		this.groupingFilterType = groupingFilterType;
	}
	public String getGroupingFilterValue() {
		return groupingFilterValue;
	}
	public void setGroupingFilterValue(String groupingFilterValue) {
		this.groupingFilterValue = groupingFilterValue;
	}
	public String getConditionsRelation() {
		return conditionsRelation;
	}
	public void setConditionsRelation(String conditionsRelation) {
		this.conditionsRelation = conditionsRelation;
	}
	public List<IChartConditionDef> getConditions() {
		return conditions;
	}
	public void setConditions(List<IChartConditionDef> conditions) {
		this.conditions = conditions;
	}
	public void addCondition(IChartConditionDef condition) {
		if(this.conditions == null)
			this.conditions = new ArrayList<IChartConditionDef>();
		this.conditions.add(condition);
	}
	public List<String[]> getColumns() {
		return this.columns;
	}
	public void setColumns(List<String[]> columns) {
		this.columns = columns;
	}
	public void addColumn(String columnId, String columnName) {
		if(this.columns == null)
			this.columns = new ArrayList<String[]>();
		String[] columns = {columnId, columnName};
		this.columns.add(columns);
	}
	public String toString() {
		return SmartServerModelUtil.gadgetToXml(this);
	}
	public String getValueUnit() {
		return valueUnit;
	}
	public void setValueUnit(String valueUnit) {
		this.valueUnit = valueUnit;
	}
}
