package net.smartworks.server.engine.resource.model.hb;

import net.smartworks.server.engine.resource.model.IChartConditionDef;

/**
 *
 * @author jhnam
 * @version $Id: HbChartConditionDef.java,v 1.1 2011/11/08 03:15:02 kmyu Exp $
 */
public class HbChartConditionDef implements IChartConditionDef {

	/**
	 * 조건 아이디
	 */
	private String id;
	/**
	 * 조건 이름
	 */
	private String name;
	/**
	 * 조건 칼럼 아이디
	 */
	private String columnId;
	/**
	 * 조건 칼럼 이름
	 */
	private String columnName;
	/**
	 * 조건 값
	 */
	private String conditionValue;
	/**
	 * 오퍼레이터
	 */
	private String comparison;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the columnId
	 */
	public String getColumnId() {
		return columnId;
	}

	/**
	 * @param columnId the columnId to set
	 */
	public void setColumnId(String columnId) {
		this.columnId = columnId;
	}

	/**
	 * @return the columnName
	 */
	public String getColumnName() {
		return columnName;
	}

	/**
	 * @param columnName the columnName to set
	 */
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	/**
	 * @return the conditionValue
	 */
	public String getConditionValue() {
		return conditionValue;
	}

	/**
	 * @param conditionValue the conditionValue to set
	 */
	public void setConditionValue(String conditionValue) {
		this.conditionValue = conditionValue;
	}

	/**
	 * @return the comparison
	 */
	public String getComparison() {
		return comparison;
	}

	/**
	 * @param comparison the comparison to set
	 */
	public void setComparison(String comparison) {
		this.comparison = comparison;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	
}
