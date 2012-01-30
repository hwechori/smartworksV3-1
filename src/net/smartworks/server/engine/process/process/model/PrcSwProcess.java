/* 
 * $Id$
 * created by    : yukm
 * creation-date : 2012. 1. 30.
 * =========================================================
 * Copyright (c) 2012 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.server.engine.process.process.model;

import java.util.Date;

import net.smartworks.server.engine.common.util.XmlUtil;

public class PrcSwProcess {
	/**
	 * 프로세스 유니크 아이디
	 */
	private String id;
	/**
	 * 프로세스가 소속된 패키지 아이디
	 */
	private String packageId;
	/**
	 * 프로세스 버전
	 */
	private int version;
	/**
	 * 프로세스 아이디
	 */
	private String processId;	
	/**
	 * 프로세스 이름
	 */
	private String name;
	/**
	 * 프로세스 상태
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
	 * 키워드
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
	 * XPDL 내용
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
	 * @return the processId
	 */
	public String getProcessId() {
		return processId;
	}

	/**
	 * @param processId the processId to set
	 */
	public void setProcessId(String processId) {
		this.processId = processId;
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
	 * @return the creatorName
	 */
	public String getCreatorName() {
		return this.creatorName;
	}

	/**
	 * @param creatorName the creatorName to set
	 */
	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName;
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
		return this.modifierName;
	}
	
	/**
	 * @param modifier the modifier to set
	 */
	public void setModifier(String modifier) {
		this.modifier = modifier;
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

	public String toString() {
		try {
			return XmlUtil.beanToXmlString("Process", this, this.getClass());
		} catch (Exception e) {
			return "";
		}
	}
	
}
