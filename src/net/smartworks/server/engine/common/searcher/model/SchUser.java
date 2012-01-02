/*	
 * $Id$
 * created by    : hsshin
 * creation-date : 2012. 1. 2.
 * =========================================================
 * Copyright (c) 2012 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.server.engine.common.searcher.model;

public class SchUser extends SchWorkspace {

	private String roleId;

	public String getId() {
		return super.getId();
	}
	public String getName() {
		return super.getName();
	}
	public String getPosition() {
		return super.getUserPosition();
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getDeptId() {
		return super.getUserDeptId();
	}
	public String getDeptName() {
		return super.getUserDeptName();
	}
	public String getDeptDesc() {
		return super.getUserDeptDesc();
	}
	public String getLongName(){
		return getPosition() + " " + getName();
	}

}