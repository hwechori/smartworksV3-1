/*	
 * $Id$
 * created by    : hsshin
 * creation-date : 2011. 11. 16.
 * =========================================================
 * Copyright (c) 2011 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.server.engine.infowork.form.model;

import java.io.Serializable;
import java.util.Date;

import net.smartworks.server.engine.common.util.XmlUtil;
import net.smartworks.server.engine.factory.SwManagerFactory;
import net.smartworks.server.engine.organization.exception.SwoException;

public class SwfFormModel implements Serializable {

	/**
	 * 체크아웃 상태 - CHECKED-OUT
	 */
	public static final String STATUS_CHECKED_OUT = "CHECKED-OUT";
	/**
	 * 체크인 상태 - CHECKED-IN
	 */
	public static final String STATUS_CHECKED_IN = "CHECKED-IN";
	/**
	 * 배치 - DEPLOYED
	 */
	public static final String STATUS_DEPLOYED = "DEPLOYED";

	/**
	 * 양식
	 */
	public static final String TYPE_NONE = "NONE";
	/**
	 * 정보관리 업무
	 */
	public static final String TYPE_SINGLE = "SINGLE";
	/**
	 * 프로세스 업무
	 */
	public static final String TYPE_PROCESS = "PROCESS";

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 폼 유니크 아이디
	 */
	private String id;
	/**
	 * 패키지 아이디
	 */	
	private String packageId;
	/**
	 * 폼 아이디
	 */
	private String formId;
	/**
	 * 폼 버전
	 */
	private int version;
	/**
	 * 폼 이름
	 */
	private String name;
	/**
	 * 폼 타입 - SINGLE / GENERAL
	 */
	private String type;
	/**
	 * 폼 상태
	 */
	private String status;
	/**
	 * 공개 모드
	 */
	private String publishMode;
	/**
	 * 생성자
	 */
	private String creator;
	/**
	 * 생성자 이름
	 */
	private String creatorName;
	/**
	 * 생성 시간
	 */
	private Date createdTime;	
	/**
	 * 갱신자
	 */
	private String modifier;
	/**
	 * 갱신자 이름
	 */
	private String modifierName;
	/**
	 * 갱신 시간
	 */
	private Date modifiedTime;
	/**
	 * 폼 키워드
	 */
	private String keyword;	
	/**
	 * 주관부서
	 */
	private String ownerDept;
	/**
	 * 담당자
	 */
	private String owner;
	/**
	 * 인코딩
	 */
	private String encoding;
	/**
	 * 설명
	 */
	private String description;
	/**
	 * 내용 - xml
	 */
	private String content;

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
	 * @return the packageId
	 */
	public String getPackageId() {
		return packageId;
	}

	/**
	 * @param packageId the packageId to set
	 */
	public void setPackageId(String packageId) {
		this.packageId = packageId;
	}

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
	 * @return the version
	 */
	public int getVersion() {
		return version;
	}

	/**
	 * @param version the version to set
	 */
	public void setVersion(int version) {
		this.version = version;
	}

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

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
	/**
	 * @return the publishMode
	 */
	public String getPublishMode() {
		return publishMode;
	}

	/**
	 * @param publishMode the publishMode to set
	 */
	public void setPublishMode(String publishMode) {
		this.publishMode = publishMode;
	}

	/**
	 * @return the creatorName
	 */
	public String getCreatorName() {
		return creatorName;
	}

	/**
	 * @return the creator
	 */
	public String getCreator() {
		return creator;
	}

	/**
	 * @param creator the creator to set
	 * @throws SwoException 
	 */
	public void setCreator(String creator) throws SwoException {
		this.creator = creator;
		
		if(this.creator != null)
			this.creatorName = SwManagerFactory.getInstance().getSwoManager().getUserDispName(this.creator);
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

	/**
	 * @return the modifier
	 */
	public String getModifier() {
		return modifier;
	}

	/**
	 * @return the modifierName
	 */
	public String getModifierName() {
		return modifierName;
	}
	
	/**
	 * @param modifier the modifier to set
	 * @throws SwoException 
	 */
	public void setModifier(String modifier) throws SwoException {
		this.modifier = modifier;
		
		if(this.modifier != null)
			this.modifierName = SwManagerFactory.getInstance().getSwoManager().getUserDispName(this.creator);		
	}

	/**
	 * @return the modifiedTime
	 */
	public Date getModifiedTime() {
		return modifiedTime;
	}

	/**
	 * @param modifiedTime the modifiedTime to set
	 */
	public void setModifiedTime(Date modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

	/**
	 * @return the keyword
	 */
	public String getKeyword() {
		return keyword;
	}

	/**
	 * @param keyword the keyword to set
	 */
	public void setKeyword(String keyword) {
		this.keyword = keyword;
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
	 * @return the owner
	 */
	public String getOwner() {
		return owner;
	}

	/**
	 * @param owner the owner to set
	 */
	public void setOwner(String owner) {
		this.owner = owner;
	}

	/**
	 * @return the encoding
	 */
	public String getEncoding() {
		return encoding;
	}

	/**
	 * @param encoding the encoding to set
	 */
	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object obj) {
		
		if(!(obj instanceof SwfFormModel))
			return false;
		
		SwfFormModel model = (SwfFormModel)obj;

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
			return XmlUtil.beanToXmlString("Form", this, this.getClass());
		} catch (Exception e) {
			return "";
		}
	}

}