/*	
 * $Id$
 * created by    : hsshin
 * creation-date : 2011. 11. 16.
 * =========================================================
 * Copyright (c) 2011 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.server.engine.infowork.form.model;

import java.io.Serializable;
import java.io.StringWriter;
import java.util.HashSet;
import java.util.Set;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class SwfFormMappingDef implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 폼 매핑 번호
	 */
	private String id;	
	/**
	 * 폼 아이디
	 */
	private String formId;
	/**
	 * 폼 버전
	 */
	private int formVersion;
	/**
	 * 참조 폼 아이디
	 */
	private String refFormId;
	/**
	 * 참조 폼 버전
	 */
	private int refFormVersion;
	/**
	 * 참조 폼 타입
	 */
	private String type;
	/**
	 * 필드 매핑 셋
	 */
	private Set<SwfFieldMappingDef> fieldMappingSet;
	/**
	 * 매핑 필터 셋
	 */
	private Set<SwfMappingFilterDef> mappingFilterSet;
	
	/**
	 * @return the formId
	 */
	public String getFormId() {
		return formId;
	}
	
	/**
	 * @param formId the formId to set
	 */
	public void setFormId(String formId) {
		this.formId = formId;
	}
	
	/**
	 * @return the formVersion
	 */
	public int getFormVersion() {
		return formVersion;
	}
	
	/**
	 * @param formVersion the formVersion to set
	 */
	public void setFormVersion(int formVersion) {
		this.formVersion = formVersion;
	}
	
	/**
	 * @return the mappingNo
	 */
	public String getId() {
		return id;
	}
	
	/**
	 * @param mappingNo the mappingNo to set
	 */
	public void setId(String mappingNo) {
		this.id = mappingNo;
	}
	
	/**
	 * @return the refFormId
	 */
	public String getRefFormId() {
		return refFormId;
	}
	
	/**
	 * @param refFormId the refFormId to set
	 */
	public void setRefFormId(String refFormId) {
		this.refFormId = refFormId;
	}
	
	/**
	 * @return the refFormVersion
	 */
	public int getRefFormVersion() {
		return refFormVersion;
	}
	
	/**
	 * @param refFormVersion the refFormVersion to set
	 */
	public void setRefFormVersion(int refFormVersion) {
		this.refFormVersion = refFormVersion;
	}
	
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.model.IFormMappingModel#addFieldMapping(com.maninsoft.smart.server.model.IFieldMappingModel)
	 */
	public void addFieldMapping(SwfFieldMappingDef fieldMapping) {
		
		if(this.fieldMappingSet == null)
			this.fieldMappingSet = new HashSet<SwfFieldMappingDef>();
		
		this.fieldMappingSet.add(fieldMapping);
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.model.IFormMappingModel#addMappingFilter(com.maninsoft.smart.server.model.IMappingFilterModel)
	 */
	public void addMappingFilter(SwfMappingFilterDef mappingFilter) {

		if(this.mappingFilterSet == null)
			this.mappingFilterSet = new HashSet<SwfMappingFilterDef>();
		
		this.mappingFilterSet.add(mappingFilter);
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.model.IFormMappingModel#getFieldMappingSet()
	 */
	public Set<SwfFieldMappingDef> getFieldMappingSet() {
		return this.fieldMappingSet;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.model.IFormMappingModel#getMappingFilterSet()
	 */
	public Set<SwfMappingFilterDef> getMappingFilterSet() {
		return this.mappingFilterSet;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.model.IFormMappingModel#removeFieldMapping(com.maninsoft.smart.server.model.IFieldMappingModel)
	 */
	public void removeFieldMapping(SwfFieldMappingDef fieldMapping) {
		
		if(this.fieldMappingSet != null)
			this.fieldMappingSet.remove(fieldMapping);
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.model.IFormMappingModel#removeMappingFilter(com.maninsoft.smart.server.model.IMappingFilterModel)
	 */
	public void removeMappingFilter(SwfMappingFilterDef mappingFilter) {
		
		if(this.mappingFilterSet != null)
			this.mappingFilterSet.remove(mappingFilter);
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.model.IFormMappingModel#setFieldMappingSet(java.util.Set)
	 */
	public void setFieldMappingSet(Set<SwfFieldMappingDef> fieldMappingSet) {
		this.fieldMappingSet = fieldMappingSet;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.model.IFormMappingModel#setMappingFilterSet(java.util.Set)
	 */
	public void setMappingFilterSet(Set<SwfMappingFilterDef> mappingFilterSet) {
		this.mappingFilterSet = mappingFilterSet;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object obj) {
		
		if(!(obj instanceof SwfFormMappingDef))
			return false;
		
		SwfFormMappingDef model = (SwfFormMappingDef)obj;
		
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
			XStream nodeXs = new XStream(new DomDriver());
			nodeXs.alias("FormMapping", SwfFormMappingDef.class);
			nodeXs.alias("FieldMapping", SwfFieldMappingDef.class);			
			nodeXs.alias("MappingFilter", SwfMappingFilterDef.class);
			StringWriter writer = new StringWriter();
			nodeXs.toXML(this, writer);
			return writer.toString();
			
		} catch (Exception e) {
			return "";
		}
	}

}