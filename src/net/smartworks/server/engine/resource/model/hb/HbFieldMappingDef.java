package net.smartworks.server.engine.resource.model.hb;

import java.io.Serializable;

import net.smartworks.server.engine.resource.model.IFieldMappingDef;
import net.smartworks.server.engine.resource.util.XmlUtil;

/**
 * IFieldMappingModel 하이버네이트 구현
 * 
 * @author jhnam
 * @version $Id: HbFieldMappingDef.java,v 1.1 2011/11/08 03:15:02 kmyu Exp $
 */
public class HbFieldMappingDef implements IFieldMappingDef, Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 매핑 아이디
	 */
	private String mappingId;
	/**
	 * 폼 액션 - import/export
	 */
	private String action;
	/**
	 * 매핑의 from 필드 아이디
	 */
	private String fromFieldId;
	/**
	 * 매핑의 to 필드 아이디
	 */
	private String toFieldId;
	
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
	 * @return the action
	 */
	public String getAction() {
		return action;
	}
	
	/**
	 * @param action the action to set
	 */
	public void setAction(String action) {
		this.action = action;
	}
	
	/**
	 * @return the fromFieldId
	 */
	public String getFromFieldId() {
		return fromFieldId;
	}
	
	/**
	 * @param fromFieldId the fromFieldId to set
	 */
	public void setFromFieldId(String fromFieldId) {
		this.fromFieldId = fromFieldId;
	}
	
	/**
	 * @return the toFieldId
	 */
	public String getToFieldId() {
		return toFieldId;
	}
	
	/**
	 * @param toFieldId the toFieldId to set
	 */
	public void setToFieldId(String toFieldId) {
		this.toFieldId = toFieldId;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public String toString() {
		try {
			return XmlUtil.beanToXmlString("FieldMapping", this, this.getClass());
		} catch (Exception e) {
			return "";
		}
	}
	
}
