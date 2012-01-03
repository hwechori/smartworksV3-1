/*	
 * $Id$
 * created by    : hsshin
 * creation-date : 2011. 11. 17.
 * =========================================================
 * Copyright (c) 2011 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.server.engine.infowork.domain.model;

import java.io.Serializable;

import net.smartworks.server.engine.common.util.XmlUtil;

public class SwdDomainFieldView implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private String formFieldId;
	private String formFieldName;
	private String tableColName;
	private String domainId;


	private int dispOrder;
	private float tableWidth;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFormFieldId() {
		return formFieldId;
	}
	public void setFormFieldId(String fieldId) {
		this.formFieldId = fieldId;
	}
	public String getFormFieldName() {
		return formFieldName;
	}
	public void setFormFieldName(String formFieldName) {
		this.formFieldName = formFieldName;
	}
	public String getTableColName() {
		return tableColName;
	}
	public void setTableColName(String tableColName) {
		this.tableColName = tableColName;
	}
	public String getDomainId() {
		return domainId;
	}
	public void setDomainId(String domainId) {
		this.domainId = domainId;
	}
	public int getDispOrder() {
		return dispOrder;
	}
	public void setDispOrder(int dispOrder) {
		this.dispOrder = dispOrder;
	}
	public float getTableWidth() {
		return tableWidth;
	}
	public void setTableWidth(float tableWidth) {
		this.tableWidth = tableWidth;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object obj) {
		
		if(!(obj instanceof SwdDomainFieldView))
			return false;
		
		SwdDomainFieldView model = (SwdDomainFieldView)obj;
		
		if(this.id == null || model.getId() == null)
			return false;
		
		if(this.id.equals(model.getId()))
			return true;
		else
			return false;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public String toString() {
		try {
			return XmlUtil.beanToXmlString("FieldViewInfo", this, this.getClass());
		} catch (Exception e) {
			return "";
		}
	}

}