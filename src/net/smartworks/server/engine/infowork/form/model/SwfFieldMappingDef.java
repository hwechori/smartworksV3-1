/*	
 * $Id$
 * created by    : hsshin
 * creation-date : 2011. 11. 16.
 * =========================================================
 * Copyright (c) 2011 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.server.engine.infowork.form.model;

import java.io.Serializable;

import net.smartworks.server.engine.common.util.XmlUtil;

public class SwfFieldMappingDef implements Serializable {

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