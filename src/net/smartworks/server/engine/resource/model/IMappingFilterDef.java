package net.smartworks.server.engine.resource.model;

/**
 * 매핑 필터 모델
 * <li> 매핑 테이블 : SWMappingFilter
 * 
 * @author jhnam
 * @version $Id: IMappingFilterDef.java,v 1.1 2011/11/08 03:15:07 kmyu Exp $
 */
public interface IMappingFilterDef {

	/**
	 * @return the mappingId
	 */
	public String getMappingId();
	
	/**
	 * @param mappingId the mappingId to set
	 */
	public void setMappingId(String mappingId);
	
	/**
	 * @return the condition
	 */
	public String getCondition();
	
	/**
	 * @param condition the condition to set
	 */
	public void setCondition(String condition);
	
	/**
	 * @return the operand1
	 */
	public String getOperand1();
	
	/**
	 * @param operand1 the operand1 to set
	 */
	public void setOperand1(String operand1);
	
	/**
	 * @return the operator
	 */
	public String getOperator();
	
	/**
	 * @param operator the operator to set
	 */
	public void setOperator(String operator);
	
	/**
	 * @return the operand2
	 */
	public String getOperand2();
	
	/**
	 * @param operand2 the operand2 to set
	 */
	public void setOperand2(String operand2);
	
}
