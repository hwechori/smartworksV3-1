/* 
 * $Id$
 * created by    : yukm
 * creation-date : 2011. 11. 19.
 * =========================================================
 * Copyright (c) 2011 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.server.engine.organization.model;

public class SwoUserExtend {
	public SwoUserExtend() {
		super();
	}
	
	public SwoUserExtend(String id, String name, String companyId, String companyName, String departmentId, String departmentName, String departmentDesc, String locale,
			String timeZone, String pictureName, String position, String roleId, String authId, String employeeId, String email, String phoneNo, String cellPhoneNo) {
		this.id = id;
		this.name = name;
		this.companyId = companyId;
		this.companyName = companyName;
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.departmentDesc = departmentDesc;
		this.locale = locale;
		this.timeZone = timeZone;
		this.pictureName = pictureName;
		this.position = position;
		this.roleId = roleId;
		this.authId = authId;
		this.employeeId = employeeId;
		this.email = email;
		this.phoneNo = phoneNo;
		this.cellPhoneNo = cellPhoneNo;
	}

	private String id = null;
	private String name = null;
	private String companyId = null;
	private String companyName = null;
	private String departmentId = null;
	private String departmentName = null;
	private String departmentDesc = null;
	private String locale = null;
	private String timeZone = null;
	private String pictureName = null;
	private String position = null;
	private String roleId = null;
	private String authId = null;
	private String employeeId = null;
	private String email = null;
	private String phoneNo = null;
	private String cellPhoneNo = null;
	private String type = null;
	private String description = null;
	private String bigPictureName = null;
	private String smallPictureName = null;

	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getCellPhoneNo() {
		return cellPhoneNo;
	}
	public void setCellPhoneNo(String cellPhoneNo) {
		this.cellPhoneNo = cellPhoneNo;
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
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getDepartmentDesc() {
		return departmentDesc;
	}
	public void setDepartmentDesc(String departmentDesc) {
		this.departmentDesc = departmentDesc;
	}
	public String getLocale() {
		return locale;
	}
	public void setLocale(String locale) {
		this.locale = locale;
	}
	public String getPictureName() {
		return pictureName;
	}
	public void setPictureName(String pictureName) {
		this.pictureName = pictureName;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getTimeZone() {
		return timeZone;
	}
	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}
	public String getAuthId() {
		return authId;
	}
	public void setAuthId(String authId) {
		this.authId = authId;
	}
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public String getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}
}
