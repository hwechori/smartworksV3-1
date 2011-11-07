/*	
 * $Id$
 * created by    : hsshin
 * creation-date : 2011. 11. 7.
 * =========================================================
 * Copyright (c) 2011 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.server.engine.infowork.domain.model;

import net.smartworks.server.engine.common.model.ClassObjectCond;

public class SwdFieldCond extends ClassObjectCond {

	private static final long serialVersionUID = 1L;
	
	private String domainObjId;
	private String formId;
	private String formFieldId;
	public String getDomainObjId() {
		return domainObjId;
	}
	public void setDomainObjId(String domainObjId) {
		this.domainObjId = domainObjId;
	}
	public String getFormId() {
		return formId;
	}
	public void setFormId(String formId) {
		this.formId = formId;
	}
	public SwdFieldCond() {
		super();
	}
	public String getFormFieldId() {
		return formFieldId;
	}
	public void setFormFieldId(String formFieldId) {
		this.formFieldId = formFieldId;
	}

}