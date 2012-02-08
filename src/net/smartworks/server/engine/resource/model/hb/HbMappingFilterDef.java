package net.smartworks.server.engine.resource.model.hb;

import java.io.Serializable;

import net.smartworks.server.engine.resource.model.IMappingFilterDef;
import net.smartworks.server.engine.resource.util.XmlUtil;

/**
 * IMappingFilterModel 하이버네이트 구현
 * 
 * @author jhnam
 * @version $Id: HbMappingFilterDef.java,v 1.1 2011/11/08 03:15:04 kmyu Exp $
 */
public class HbMappingFilterDef implements IMappingFilterDef, Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;	
	/**
	 * 매핑 아이디
	 */
	private String mappingId;
	/**
	 * 필터 조건 - and/or/firtst
	 */
	private String condition;
	/**
	 * 오퍼랜드1
	 */
	private String operand1;
	/**
	 * 오퍼레이터
	 */
	private String operator;
	/**
	 * 오퍼랜드2
	 */
	private String operand2;
		
	/**
	 * @return the mappingId
	 */
	public String getMappingId() {
		return mappingId;
	}
	
	/**
	 * @param mappingId the mappingId to set
	 */
	public void setMappingId(String mappingId) {
		this.mappingId = mappingId;
	}
	
	/**
	 * @return the condition
	 */
	public String getCondition() {
		return condition;
	}
	
	/**
	 * @param condition the condition to set
	 */
	public void setCondition(String condition) {
		this.condition = condition;
	}
	
	/**
	 * @return the operand1
	 */
	public String getOperand1() {
		return operand1;
	}
	
	/**
	 * @param operand1 the operand1 to set
	 */
	public void setOperand1(String operand1) {
		this.operand1 = operand1;
	}
	
	/**
	 * @return the operator
	 */
	public String getOperator() {
		return operator;
	}
	
	/**
	 * @param operator the operator to set
	 */
	public void setOperator(String operator) {
		this.operator = operator;
	}
	
	/**
	 * @return the operand2
	 */
	public String getOperand2() {
		return operand2;
	}
	
	/**
	 * @param operand2 the operand2 to set
	 */
	public void setOperand2(String operand2) {
		this.operand2 = operand2;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public String toString() {
		try {
			return XmlUtil.beanToXmlString("MappingFilter", this, this.getClass());
		} catch (Exception e) {
			return "";
		}
	}
	
}
