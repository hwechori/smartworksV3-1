/*	
 * $Id$
 * created by    : hsshin
 * creation-date : 2011. 11. 16.
 * =========================================================
 * Copyright (c) 2011 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.server.engine.infowork.form.model;

import java.io.Serializable;

public class SwfFormContent implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private String packageId;
	private String formId;
	private int version;
	private String content;

	public String getContent() {
		return this.content;
	}
	public String getId() {
		return this.id;
	}
	public String getPackageId() {
		return this.packageId;
	}
	public String getFormId() {
		return this.formId;
	}
	public int getVersion() {
		return this.version;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setPackageId(String packageId) {
		this.packageId = packageId;
	}
	public void setFormId(String formId) {
		this.formId = formId;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	public boolean equals(Object obj) {
		
		if(!(obj instanceof SwfFormContent))
			return false;
		
		SwfFormContent model = (SwfFormContent)obj;
		
		if(this.id == null || model.getId() == null)
			return false;
		
		if(this.id.equals(model.getId()))
			return true;
		else
			return false;
	}
	public String toString() {
		return this.content;
	}

}