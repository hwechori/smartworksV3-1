package net.smartworks.server.engine.resource.model;

/**
 * 차트 조건 모델
 * 
 * @author jhnam
 * @version $Id: IChartConditionDef.java,v 1.1 2011/11/08 03:15:07 kmyu Exp $
 */
public interface IChartConditionDef {

	/**
	 * @return the id
	 */
	public String getId();

	/**
	 * @param id the id to set
	 */
	public void setId(String id);
	
	/**
	 * @return the name
	 */
	public String getName();

	/**
	 * @param name the name to set
	 */
	public void setName(String name);

	/**
	 * @return the columnId
	 */
	public String getColumnId();

	/**
	 * @param columnId the columnId to set
	 */
	public void setColumnId(String columnId);

	/**
	 * @return the columnName
	 */
	public String getColumnName();

	/**
	 * @param columnName the columnName to set
	 */
	public void setColumnName(String columnName);

	/**
	 * @return the conditionValue
	 */
	public String getConditionValue();

	/**
	 * @param conditionValue the conditionValue to set
	 */
	public void setConditionValue(String conditionValue);

	/**
	 * @return the comparison
	 */
	public String getComparison();

	/**
	 * @param comparison the comparison to set
	 */
	public void setComparison(String comparison);
	
}
