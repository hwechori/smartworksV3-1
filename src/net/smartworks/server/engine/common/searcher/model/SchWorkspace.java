/* 
 * $Id$
 * created by    : yukm
 * creation-date : 2011. 12. 6.
 * =========================================================
 * Copyright (c) 2011 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.server.engine.common.searcher.model;

public class SchWorkspace {

	private String id;
	private String name;
	private String type;
	private String description;
	private String userPosition;
	private String userDeptId;
	private String userDeptName;
	private String userDeptDesc;
	
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUserPosition() {
		return userPosition;
	}
	public void setUserPosition(String userPosition) {
		this.userPosition = userPosition;
	}
	public String getUserDeptId() {
		return userDeptId;
	}
	public void setUserDeptId(String userDeptId) {
		this.userDeptId = userDeptId;
	}
	public String getUserDeptName() {
		return userDeptName;
	}
	public void setUserDeptName(String userDeptName) {
		this.userDeptName = userDeptName;
	}
	public String getUserDeptDesc() {
		return userDeptDesc;
	}
	public void setUserDeptDesc(String userDeptDesc) {
		this.userDeptDesc = userDeptDesc;
	}
	
}
