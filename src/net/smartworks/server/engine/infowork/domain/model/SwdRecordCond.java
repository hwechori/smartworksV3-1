/*	
 * $Id$
 * created by    : maninsoft
 * creation-date : 2011. 11. 7.
 * =========================================================
 * Copyright (c) 2011 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.server.engine.infowork.domain.model;

import java.util.Date;

import net.smartworks.server.engine.common.model.BaseObject;
import net.smartworks.server.engine.common.model.ClassObjectCond;
import net.smartworks.server.engine.common.model.Cond;
import net.smartworks.server.engine.common.util.CommonUtil;
import net.smartworks.server.engine.common.util.DateUtil;
import net.smartworks.server.engine.common.util.XmlUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

public class SwdRecordCond extends ClassObjectCond {

	private static final long serialVersionUID = 1L;
	private static Log logger = LogFactory.getLog(SwdRecordCond.class);
	
	protected static final String PREFIX = "Swd";
	private static final String NAME = CommonUtil.toName(SwdRecordCond.class, PREFIX);

	public static final String A_DOMAINID = "domainId";
	public static final String A_RECORDID = "recordId";
	public static final String A_FORMID = "formId";
	public static final String A_CREATIONUSER = "creator";
	public static final String A_CREATIONDATEFROM = "createdTimeFrom";
	public static final String A_CREATIONDATETO = "createdTimeTo";
	public static final String A_MODIFICATIONUSER = "modifier";
	public static final String A_MODIFICATIONDATEFROM = "modifiedTimeFrom";
	public static final String A_MODIFICATIONDATETO = "modifiedTimeTo";
	public static final String A_REFERENCEDFORMID = "referencedFormId";
	public static final String A_REFERENCEDRECORDID = "referencedRecordId";
	public static final String A_DISPLAYABLEDATAFILEDSONLY = "displayableDataFieldsOnly";
	public static final String A_SEARCHKEY = "searchKey";
	public static final String A_WORKSPACEID = "workSpaceId";
	public static final String A_WORKSPACETYPE = "workSpaceType";
	public static final String A_ACCESSLEVEL = "accessLevel";
	public static final String A_ACCESSVALUE = "accessValue";

	private String recordId;
	private String domainId;
	private String formId;
	private String packageId;
	private String creationUser;
	private Date creationDateFrom;
	private Date creationDateTo;
	private String modificationUser;
	private Date modificationDateFrom;
	private Date modificationDateTo;
	private String referencedFormId;
	private String referencedRecordId;
	private boolean displayableDataFieldsOnly;
	private String workSpaceId;
	private String workSpaceType;
	private String accessLevel;
	private String accessValue;
	
	private String searchKey;
	public SwdRecordCond() {
		super();
	}
	public String toString(String name, String tab) {
		if (name == null || name.trim().length() == 0)
			name = NAME;
		return super.toString(name, tab);
	}
	public String toLiteString(String name, String tab) {
		if (name == null || name.trim().length() == 0)
			name = NAME;
		return super.toLiteString(name, tab);
	}
	public String toAttributesString() {
		StringBuffer buf = new StringBuffer();
		buf.append(super.toAttributesString());
		appendAttributeString(A_DOMAINID, domainId, buf);
		appendAttributeString(A_RECORDID, recordId, buf);
		appendAttributeString(A_FORMID, formId, buf);
		appendAttributeString(A_CREATIONUSER, creationUser, buf);
		appendAttributeString(A_CREATIONDATEFROM, creationDateFrom, buf);
		appendAttributeString(A_CREATIONDATETO, creationDateTo, buf);
		appendAttributeString(A_MODIFICATIONUSER, modificationUser, buf);
		appendAttributeString(A_MODIFICATIONDATEFROM, modificationDateFrom, buf);
		appendAttributeString(A_MODIFICATIONDATETO, modificationDateTo, buf);
		appendAttributeString(A_REFERENCEDFORMID, referencedFormId, buf);
		appendAttributeString(A_REFERENCEDRECORDID, referencedRecordId, buf);
		appendAttributeString(A_DISPLAYABLEDATAFILEDSONLY, displayableDataFieldsOnly, buf);
		appendAttributeString(A_SEARCHKEY, searchKey, true, buf);
		appendAttributeString(A_WORKSPACEID, workSpaceId, buf);
		appendAttributeString(A_WORKSPACETYPE, workSpaceType, buf);
		appendAttributeString(A_ACCESSLEVEL, accessLevel, buf);
		appendAttributeString(A_ACCESSVALUE, accessValue, buf);
		return buf.toString();
	}
	public static BaseObject toObject(Node node, BaseObject baseObj) throws Exception {
		if (node == null)
			return null;
		
		SwdRecordCond obj = null;
		if (baseObj == null || !(baseObj instanceof SwdRecordCond))
			obj = new SwdRecordCond();
		else
			obj = (SwdRecordCond)baseObj;
		
		// 부모 attributes, elements 값 설정
		Cond.toObject(node, obj);
		
		NamedNodeMap attrMap = node.getAttributes();
		if (attrMap != null) {
			Node domainId = attrMap.getNamedItem(A_DOMAINID);
			Node recordId = attrMap.getNamedItem(A_RECORDID);
			Node formId = attrMap.getNamedItem(A_FORMID);
			Node creationUser = attrMap.getNamedItem(A_CREATIONUSER);
			Node creationDateFrom = attrMap.getNamedItem(A_CREATIONDATEFROM);
			Node creationDateTo = attrMap.getNamedItem(A_CREATIONDATETO);
			Node modificationUser = attrMap.getNamedItem(A_MODIFICATIONUSER);
			Node modificationDateFrom = attrMap.getNamedItem(A_MODIFICATIONDATEFROM);
			Node modificationDateTo = attrMap.getNamedItem(A_MODIFICATIONDATETO);
			Node referencedFormId = attrMap.getNamedItem(A_REFERENCEDFORMID);
			Node referencedRecordId = attrMap.getNamedItem(A_REFERENCEDRECORDID);
			Node displayableDataFieldsOnly = attrMap.getNamedItem(A_DISPLAYABLEDATAFILEDSONLY);
			Node searchKey = attrMap.getNamedItem(A_SEARCHKEY);
			Node workSpaceId = attrMap.getNamedItem(A_WORKSPACEID);
			Node workSpaceType = attrMap.getNamedItem(A_WORKSPACETYPE);
			Node accessLevel = attrMap.getNamedItem(A_ACCESSLEVEL);
			Node accessValue = attrMap.getNamedItem(A_ACCESSVALUE);
			if (domainId != null)
				obj.setDomainId(domainId.getNodeValue());
			if (recordId != null)
				obj.setRecordId(recordId.getNodeValue());
			if (formId != null)
				obj.setFormId(formId.getNodeValue());
			if (creationUser != null)
				obj.setCreationUser(creationUser.getNodeValue());
			if (creationDateFrom != null)
				obj.setCreationDateFrom(DateUtil.toDate(creationDateFrom.getNodeValue()));
			if (creationDateTo != null)
				obj.setCreationDateTo(DateUtil.toDate(creationDateTo.getNodeValue()));
			if (modificationUser != null)
				obj.setModificationUser(modificationUser.getNodeValue());
			if (modificationDateFrom != null)
				obj.setModificationDateFrom(DateUtil.toDate(modificationDateFrom.getNodeValue()));
			if (modificationDateTo != null)
				obj.setModificationDateTo(DateUtil.toDate(modificationDateTo.getNodeValue()));
			if (referencedFormId != null)
				obj.setReferencedFormId(referencedFormId.getNodeValue());
			if (referencedRecordId != null)
				obj.setReferencedRecordId(referencedRecordId.getNodeValue());
			if (displayableDataFieldsOnly != null)
				obj.setDisplayableDataFieldsOnly(CommonUtil.toBoolean(displayableDataFieldsOnly.getNodeValue()));
			if (searchKey != null)
				obj.setSearchKey(searchKey.getNodeValue());
			if (workSpaceId != null)
				obj.setWorkSpaceId(workSpaceId.getNodeValue());
			if (workSpaceType != null)
				obj.setWorkSpaceType(workSpaceType.getNodeValue());
			if (accessLevel != null)
				obj.setAccessLevel(accessLevel.getNodeValue());
			if (accessValue != null)
				obj.setAccessValue(accessValue.getNodeValue());
		}
		
		// elements 값 설정
		
		return obj;
	}
	public static BaseObject toObject(String str) throws Exception {
		if (str == null)
			return null;
		Document doc = XmlUtil.toDocument(str);
		if (doc == null)
			return null;
		return toObject(doc.getDocumentElement(), null);
	}
	public static SwdRecord[] add(SwdRecord[] objs, SwdRecord obj) {
		if (obj == null)
			return objs;
		int size = 0;
		if (objs != null)
			size = objs.length;
		SwdRecord[] newObjs = new SwdRecord[size+1];
		int i;
		for (i=0; i<size; i++)
			newObjs[i] = objs[i];
		newObjs[i] = obj;
		return newObjs;
	}
	public static SwdRecord[] remove(SwdRecord[] objs, SwdRecord obj) {
		if (obj == null)
			return objs;
		int size = 0;
		if (objs != null)
			size = objs.length;
		if (size == 0)
			return objs;
		SwdRecord[] newObjs = new SwdRecord[size-1];
		int i;
		int j = 0;
		for (i=0; i<size; i++) {
			if (objs[i].equals(obj))
				continue;
			newObjs[j++] = objs[i];
		}
		return newObjs;
	}
	public static SwdRecord[] left(SwdRecord[] objs, SwdRecord obj) {
		if (objs == null || objs.length == 0 || obj == null)
			return objs;
		int idx = -1;
		for (int i=0; i<objs.length; i++) {
			if (!objs[i].equals(obj))
				continue;
			idx = i;
			break;
		}
		if (idx < 1)
			return objs;
		SwdRecord[] newObjs = new SwdRecord[objs.length];
		for (int i=0; i<objs.length; i++) {
			if (i == idx) {
				newObjs[i] = objs[idx-1];
				continue;
			} else if (i == idx-1) {
				newObjs[i] = objs[idx];
				continue;
			}
			newObjs[i] = objs[i];
		}
		return newObjs;
	}
	public static SwdRecord[] right(SwdRecord[] objs, SwdRecord obj) {
		if (objs == null || objs.length == 0 || obj == null)
			return objs;
		int idx = -1;
		for (int i=0; i<objs.length; i++) {
			if (!objs[i].equals(obj))
				continue;
			idx = i;
			break;
		}
		if (idx == -1 || idx+1 == objs.length)
			return objs;
		SwdRecord[] newObjs = new SwdRecord[objs.length];
		for (int i=0; i<objs.length; i++) {
			if (i == idx) {
				newObjs[i] = objs[idx+1];
				continue;
			} else if (i == idx+1) {
				newObjs[i] = objs[idx];
				continue;
			}
			newObjs[i] = objs[i];
		}
		return newObjs;
	}
	public Object clone() throws CloneNotSupportedException {
		try {
			return toObject(this.toString());
		} catch (Exception e) {
			logger.warn(e, e);
			return null;
		}
	}
	public String getDomainId() {
		return domainId;
	}
	public void setDomainId(String domainId) {
		this.domainId = domainId;
	}
	public String getFormId() {
		return formId;
	}
	public void setFormId(String formId) {
		this.formId = formId;
	}
	public String getRecordId() {
		return recordId;
	}
	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}
	public String getSearchKey() {
		return searchKey;
	}
	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}
	public boolean isDisplayableDataFieldsOnly() {
		return displayableDataFieldsOnly;
	}
	public void setDisplayableDataFieldsOnly(boolean displayableFieldOnly) {
		this.displayableDataFieldsOnly = displayableFieldOnly;
	}
	public Date getCreationDateFrom() {
		return creationDateFrom;
	}
	public void setCreationDateFrom(Date creationDateFrom) {
		this.creationDateFrom = creationDateFrom;
	}
	public Date getCreationDateTo() {
		return creationDateTo;
	}
	public void setCreationDateTo(Date creationDateTo) {
		this.creationDateTo = creationDateTo;
	}
	public String getCreationUser() {
		return creationUser;
	}
	public void setCreationUser(String creationUser) {
		this.creationUser = creationUser;
	}
	public Date getModificationDateFrom() {
		return modificationDateFrom;
	}
	public void setModificationDateFrom(Date modificationDateFrom) {
		this.modificationDateFrom = modificationDateFrom;
	}
	public Date getModificationDateTo() {
		return modificationDateTo;
	}
	public void setModificationDateTo(Date modificationDateTo) {
		this.modificationDateTo = modificationDateTo;
	}
	public String getModificationUser() {
		return modificationUser;
	}
	public void setModificationUser(String modificationUser) {
		this.modificationUser = modificationUser;
	}
	public String getReferencedFormId() {
		return referencedFormId;
	}
	public void setReferencedFormId(String referencedFormId) {
		this.referencedFormId = referencedFormId;
	}
	public String getReferencedRecordId() {
		return referencedRecordId;
	}
	public void setReferencedRecordId(String referencedRecordId) {
		this.referencedRecordId = referencedRecordId;
	}
	public String getPackageId() {
		return packageId;
	}
	public void setPackageId(String packageId) {
		this.packageId = packageId;
	}
	public String getWorkSpaceId() {
		return workSpaceId;
	}
	public void setWorkSpaceId(String workSpaceId) {
		this.workSpaceId = workSpaceId;
	}
	public String getWorkSpaceType() {
		return workSpaceType;
	}
	public void setWorkSpaceType(String workSpaceType) {
		this.workSpaceType = workSpaceType;
	}
	public String getAccessLevel() {
		return accessLevel;
	}
	public void setAccessLevel(String accessLevel) {
		this.accessLevel = accessLevel;
	}
	public String getAccessValue() {
		return accessValue;
	}
	public void setAccessValue(String accessValue) {
		this.accessValue = accessValue;
	}

}