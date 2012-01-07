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
	
	public SwoUserExtend(String id, String name, String companyId, String companyName, String departmentId, String departmentName, String locale, String pictureName, String picturePath,
			String position, String timeZone, String userLevel) {
		this.id = id;
		this.name = name;
		this.companyId = companyId;
		this.companyName = companyName;
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.locale = locale;
		this.pictureName = pictureName;
		this.picturePath = picturePath;
		this.position = position;
		this.timeZone = timeZone;
		this.userLevel = userLevel;
	}
	private String id = null;
	private String name = null;
	private String companyId = null;
	private String companyName = null;
	private String departmentId = null;
	private String departmentName = null;
	private String locale = null;
	private String pictureName = null;
	private String picturePath = null;
	private String roleId = null;
	private String position = null;
	private String timeZone = null;
	private String userLevel = null;
	private String type = null;
	private String description = null;
	private String smallPictureName = null;

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
	public String getPicturePath() {
		return picturePath;
	}
	public void setPicturePath(String picturePath) {
		this.picturePath = picturePath;
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
	public String getUserLevel() {
		return userLevel;
	}
	public void setUserLevel(String userLevel) {
		this.userLevel = userLevel;
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
