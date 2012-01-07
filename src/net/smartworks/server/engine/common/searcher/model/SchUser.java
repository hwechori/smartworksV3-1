/*	
 * $Id$
 * created by    : hsshin
 * creation-date : 2012. 1. 2.
 * =========================================================
 * Copyright (c) 2012 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.server.engine.common.searcher.model;

public class SchUser extends SchWorkspace {

	public String getCompanyName() {
		return super.getUserCompanyName();
	}
	public int getUserLevel() {
		return super.getUserLevel();
	}
	public String getLocale() {
		return super.getUserLocale();
	}
	public String getTimeZone() {
		return super.getUserTimeZone();
	}
	public String getEmployeeId() {
		return super.getUserEmployeeId();
	}
	public String getPhoneNo() {
		return super.getUserCellPhoneNo();
	}
	public String getCellPhoneNo() {
		return super.getUserCellPhoneNo();
	}
	public String getCompanyId() {
		return super.getUserCompanyId();
	}
	public String getId() {
		return super.getId();
	}
	public String getName() {
		return super.getName();
	}
	public String getPosition() {
		return super.getUserPosition();
	}
	public int getRole() {
		return super.getUserRole();
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