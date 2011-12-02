/*	
 * $Id$
 * created by    : hsshin
 * creation-date : 2011. 11. 15.
 * =========================================================
 * Copyright (c) 2011 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.server.engine.docfile.model;

import java.io.Serializable;
import java.util.Date;

import net.smartworks.server.engine.common.util.XmlUtil;

public class HbDocumentModel implements IDocumentModel, Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 문서 아이디
	 */
	private String id;
	/**
	 * 문서 제목
	 */
	private String title;
	/**
	 * 문서 코드
	 */
	private String code;
	/**
	 * 관리 부서
	 */
	private String ownerDept;
	/**
	 * 관리자
	 */
	private String ownerUser;
	/**
	 * 파일 그룹 아이디
	 */
	private String fileGroupId;
	/**
	 * 참조 타입
	 */
	private int refType;
	/**
	 * 참조 아이디
	 */
	private String refId;	
	/**
	 * 작성자
	 */
	private String creator;
	/**
	 * 작성시간
	 */
	private Date createdTime;

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

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the ownerDept
	 */
	public String getOwnerDept() {
		return ownerDept;
	}

	/**
	 * @param ownerDept the ownerDept to set
	 */
	public void setOwnerDept(String ownerDept) {
		this.ownerDept = ownerDept;
	}

	/**
	 * @return the ownerUser
	 */
	public String getOwnerUser() {
		return ownerUser;
	}

	/**
	 * @param ownerUser the ownerUser to set
	 */
	public void setOwnerUser(String ownerUser) {
		this.ownerUser = ownerUser;
	}

	/**
	 * @return the fileGroupId
	 */
	public String getFileGroupId() {
		return fileGroupId;
	}

	/**
	 * @param fileGroupId the fileGroupId to set
	 */
	public void setFileGroupId(String fileGroupId) {
		this.fileGroupId = fileGroupId;
	}

	/**
	 * @return the refType
	 */
	public int getRefType() {
		return refType;
	}

	/**
	 * @param refType the refType to set
	 */
	public void setRefType(int refType) {
		this.refType = refType;
	}

	/**
	 * @return the refId
	 */
	public String getRefId() {
		return refId;
	}

	/**
	 * @param refId the refId to set
	 */
	public void setRefId(String refId) {
		this.refId = refId;
	}

	/**
	 * @return the creator
	 */
	public String getCreator() {
		return creator;
	}

	/**
	 * @param creator the creator to set
	 */
	public void setCreator(String creator) {
		this.creator = creator;
	}

	/**
	 * @return the createdTime
	 */
	public Date getCreatedTime() {
		return createdTime;
	}

	/**
	 * @param createdTime the createdTime to set
	 */
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object obj) {
		
		if(!(obj instanceof HbDocumentModel))
			return false;
		
		HbDocumentModel model = (HbDocumentModel)obj;
		
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
			return XmlUtil.beanToXmlString("Document", this, this.getClass());
		} catch (Exception e) {
			return "";
		}
	}

}