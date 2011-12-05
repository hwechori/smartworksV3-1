/*	
 * $Id$
 * created by    : hsshin
 * creation-date : 2011. 11. 30.
 * =========================================================
 * Copyright (c) 2011 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.server.engine.infowork.domain.model;

import java.util.Date;

import net.smartworks.model.instance.FieldData;

public class SwdRecordExtend {

	private String parentCtgId;
	private String parentCtg;
	private String subCtgId;
	private String subCtg;
	private String formId;
	private String formName;
	private String domainId;
	private String recId;
	private String recSubject;
	private String recStatus;
	private String recCreateUser;
	private Date recCreateDate;
	private String recModifyUser;
	private Date recModifyDate;
	private FieldData[] fieldDatas;

	public FieldData[] getFieldDatas() {
		return fieldDatas;
	}
	public void setFieldDatas(FieldData[] fieldDatas) {
		this.fieldDatas = fieldDatas;
	}
	public String getFormName() {
		return formName;
	}
	public void setFormName(String formName) {
		this.formName = formName;
	}
	public String getFormId() {
		return formId;
	}
	public void setFormId(String formId) {
		this.formId = formId;
	}
	public String getDomainId() {
		return domainId;
	}
	public void setDomainId(String domainId) {
		this.domainId = domainId;
	}
	public String getParentCtgId() {
		return parentCtgId;
	}
	public void setParentCtgId(String parentCtgId) {
		this.parentCtgId = parentCtgId;
	}
	public String getParentCtg() {
		return parentCtg;
	}
	public void setParentCtg(String parentCtg) {
		this.parentCtg = parentCtg;
	}
	public String getSubCtgId() {
		return subCtgId;
	}
	public void setSubCtgId(String subCtgId) {
		this.subCtgId = subCtgId;
	}
	public String getSubCtg() {
		return subCtg;
	}
	public void setSubCtg(String subCtg) {
		this.subCtg = subCtg;
	}
	public String getRecId() {
		return recId;
	}
	public void setRecId(String recId) {
		this.recId = recId;
	}
	public String getRecSubject() {
		return recSubject;
	}
	public void setRecSubject(String recSubject) {
		this.recSubject = recSubject;
	}
	public String getRecStatus() {
		return recStatus;
	}
	public void setRecStatus(String recStatus) {
		this.recStatus = recStatus;
	}
	public String getRecCreateUser() {
		return recCreateUser;
	}
	public void setRecCreateUser(String recCreateUser) {
		this.recCreateUser = recCreateUser;
	}
	public Date getRecCreateDate() {
		return recCreateDate;
	}
	public void setRecCreateDate(Date recCreateDate) {
		this.recCreateDate = recCreateDate;
	}
	public String getRecModifyUser() {
		return recModifyUser;
	}
	public void setRecModifyUser(String recModifyUser) {
		this.recModifyUser = recModifyUser;
	}
	public Date getRecModifyDate() {
		return recModifyDate;
	}
	public void setRecModifyDate(Date recModifyDate) {
		this.recModifyDate = recModifyDate;
	}

}