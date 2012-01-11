/*	
 * $Id$
 * created by    : hsshin
 * creation-date : 2012. 1. 9.
 * =========================================================
 * Copyright (c) 2012 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.server.engine.organization.model;

public class SwoDepartmentExtend {

	public SwoDepartmentExtend() {
		super();
	}

	public SwoDepartmentExtend(String id, String name, String description, String parentId) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.parentId = parentId;
	}

	private String id = null;
	private String name = null;
	private String description = null;
	private String parentId = null;
	private String headId = null;
	private String bigPictureName = null;
	private String smallPictureName = null;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getHeadId() {
		return headId;
	}
	public void setHeadId(String headId) {
		this.headId = headId;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public String getBigPictureName() {
		return bigPictureName;
	}
	public void setBigPictureName(String bigPictureName) {
		this.bigPictureName = bigPictureName;
	}
	public String getSmallPictureName() {
		return smallPictureName;
	}
	public void setSmallPictureName(String smallPictureName) {
		this.smallPictureName = smallPictureName;
	}

}