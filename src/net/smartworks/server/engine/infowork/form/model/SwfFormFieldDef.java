/*	
 * $Id$
 * created by    : hsshin
 * creation-date : 2011. 11. 16.
 * =========================================================
 * Copyright (c) 2011 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.server.engine.infowork.form.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SwfFormFieldDef implements Serializable {

	public static final String TYPE_BOOLEAN = "boolean";
	public static final String TYPE_STRING = "string";
	public static final String TYPE_NUMBER = "number";
	public static final String TYPE_DATE = "date";
	public static final String TYPE_DATETIME = "datetime";
	public static final String TYPE_TIME = "time";
	public static final String TYPE_TEXT = "text";
	public static final String TYPE_COMPLEX = "complex";

	private static final long serialVersionUID = 1L;

	private String packageId;
	private String formId;
	private String id;
	private String name;
	private String title;
	private String systemName;
	private String type;
	private String formatType;
	private String viewingType;
	private String refForm;
	private String refFormField;
	private boolean isArray;
	private boolean isSystem;

	private List<SwfFormFieldDef> children;

	public String getPackageId() {
		return packageId;
	}
	public void setPackageId(String packageId) {
		this.packageId = packageId;
	}
	public String getId() {
		return this.id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFormId() {
		return this.formId;
	}
	public void setFormId(String formId) {
		this.formId = formId;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return this.title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSystemName() {
		return this.systemName;
	}
	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}
	public String getType() {
		return this.type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public boolean isArray() {
		return this.isArray;
	}
	public void setArray(boolean isArray) {
		this.isArray = isArray;
	}
	public boolean isSystem() {
		return this.isSystem;
	}
	public void setSystem(boolean isSystem) {
		this.isSystem = isSystem;
	}
	public String getFormatType() {
		return formatType;
	}
	public void setFormatType(String formatType) {
		this.formatType = formatType;
	}
	public String getRefForm() {
		return this.refForm;
	}
	public void setRefForm(String refForm) {
		this.refForm = refForm;
	}
	public String getRefFormField() {
		return this.refFormField;
	}
	public void setRefFormField(String refFormFieldId) {
		this.refFormField = refFormFieldId;
	}
	public void addChildField(SwfFormFieldDef fieldDef) {
		if(this.children == null)
			this.children = new ArrayList<SwfFormFieldDef>();
		this.children.add(fieldDef);
	}
	public List<SwfFormFieldDef> getChildren() {
		return this.children;
	}
	public String getViewingType() {
		return viewingType;
	}
	public void setViewingType(String viewingType) {
		this.viewingType = viewingType;
	}

}