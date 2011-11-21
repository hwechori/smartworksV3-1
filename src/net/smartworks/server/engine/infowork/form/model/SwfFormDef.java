/*	
 * $Id$
 * created by    : hsshin
 * creation-date : 2011. 11. 16.
 * =========================================================
 * Copyright (c) 2011 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.server.engine.infowork.form.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import net.smartworks.server.engine.common.util.XmlUtil;

public class SwfFormDef implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private int version;
	private String name;
	private String title;
	/**
	 * 시스템 이름 - 데이터가 있다면 정보관리업무에서 테이블 이름으로 사용
	 */
	private String systemName;
	/**
	 * 폼 필드 맵. 키 : 폼 필드 아이디 - 값 : 폼 필드 객체
	 */
	private Map<String, SwfFormFieldDef> formFieldMap = new HashMap<String, SwfFormFieldDef>();
	
	/**
	 * 폼 매핑 맵. 키 : 폼 매핑 맵 - 값 : 폼 매핑 모델
	 */
	private Map<String, SwfFormMappingDef> formMappingMap = new HashMap<String, SwfFormMappingDef>();
	
	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.model.IFormMeta#addFormField(com.maninsoft.smart.server.model.IFormField)
	 */
	public void addFormField(SwfFormFieldDef formField) {
		this.formFieldMap.put(formField.getId(), formField);
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.model.IFormMeta#getFormFieldMap()
	 */
	public Map<String, SwfFormFieldDef> getFormFieldMap() {
		return this.formFieldMap;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.model.IFormDef#addFormMapping(com.maninsoft.smart.server.model.IFormMappingModel)
	 */
	public void addFormMapping(SwfFormMappingDef mappingModel) {
		this.formMappingMap.put(mappingModel.getId(), mappingModel);
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.model.IFormDef#getFormMappingMap()
	 */
	public Map<String, SwfFormMappingDef> getFormMappingMap() {
		return this.formMappingMap;
	}
	
	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.model.IFormMeta#getId()
	 */
	public String getId() {
		return this.id;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.model.IFormMeta#getName()
	 */
	public String getName() {
		return this.name;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.model.IFormMeta#getTitle()
	 */
	public String getTitle() {
		return this.title;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.model.IFormDef#getSystemName()
	 */
	public String getSystemName() {
		return this.systemName;
	}
	
	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.model.IFormMeta#getVersion()
	 */
	public int getVersion() {
		return this.version;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.model.IFormMeta#setId(java.lang.String)
	 */
	public void setId(String id) {
		this.id = id;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.model.IFormMeta#setName(java.lang.String)
	 */
	public void setName(String name) {
		this.name = name;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.model.IFormMeta#setTitle(java.lang.String)
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.model.IFormDef#setSystemName(java.lang.String)
	 */
	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}
	
	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.model.IFormMeta#setVersion(int)
	 */
	public void setVersion(int version) {
		this.version = version;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public String toString() {
		String returnStr = "";
		try {
			returnStr = XmlUtil.formToXml(this);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnStr;
	}

}