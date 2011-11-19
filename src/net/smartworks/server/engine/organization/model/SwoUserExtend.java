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
	
	public SwoUserExtend(String id, String name, String companyName, String departmentName, String locale, String pictureName, String picturePath,
			String position, String timeZone, String userLevel) {
		this.id = id;
		this.name = name;
		this.companyName = companyName;
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
	private String companyName = null;
	private String departmentName = null;
	private String locale = null;
	private String pictureName = null;
	private String picturePath = null;
	private String position = null;
	private String timeZone = null;
	private String userLevel = null;
	
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
}
