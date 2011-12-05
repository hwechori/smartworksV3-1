/*	
 * $Id$
 * created by    : maninsoft
 * creation-date : 2011. 11. 7.
 * =========================================================
 * Copyright (c) 2011 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.server.engine.infowork.domain.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import net.smartworks.server.engine.common.model.BaseObject;
import net.smartworks.server.engine.common.util.CommonUtil;
import net.smartworks.server.engine.common.util.DateUtil;
import net.smartworks.server.engine.common.util.XmlUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class SwdRecord extends BaseObject {

	private static final long serialVersionUID = 1L;
	private static Log logger = LogFactory.getLog(SwdRecord.class);
	
	protected static final String PREFIX = "Swd";
	private static final String NAME = "DataRecord";

	public static final String A_DOMAINID = "domainId";
	public static final String A_RECORDID = "recordId";
	public static final String A_FORMID = "formId";
	public static final String A_FORMVERSION = "formVersion";
	public static final String A_CREATIONUSER = "creator";
	public static final String A_CREATIONDATE = "createdTime";
	public static final String A_MODIFICATIONUSER = "modifier";
	public static final String A_MODIFICATIONDATE = "modifiedTime";
	public static final String A_DATAFIELD = "DataField";
	
	private String domainId;
	private String recordId;
	private String formId;
	private String formName;
	private int formVersion = 1;
	private String creationUser;
	private Date creationDate;
	private String modificationUser;
	private Date modificationDate;

	private SwdDataField[] dataFields;
	private Map<String, SwdDataField> dataFieldMap;
	public SwdRecord() {
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
		appendAttributeString(A_FORMVERSION, formVersion, buf);
		appendAttributeString(A_CREATIONUSER, creationUser, buf);
		appendAttributeString(A_CREATIONDATE, creationDate, buf);
		appendAttributeString(A_MODIFICATIONUSER, modificationUser, buf);
		appendAttributeString(A_MODIFICATIONDATE, modificationDate, buf);
		return buf.toString();
	}
	public String toElementsString(String tab, boolean lite) {
		StringBuffer buf = new StringBuffer();
		buf.append(super.toElementsString(tab, lite));
		appendElementsString(null, A_DATAFIELD, getDataFields(), tab, lite, buf);
		return buf.toString();
	}
	public static BaseObject toObject(Node node, BaseObject baseObj) throws Exception {
		if (node == null)
			return null;
		
		SwdRecord obj = null;
		if (baseObj == null || !(baseObj instanceof SwdRecord))
			obj = new SwdRecord();
		else
			obj = (SwdRecord)baseObj;
		
		// 부모 attributes, elements 값 설정
		BaseObject.toObject(node, obj);
		
		NamedNodeMap attrMap = node.getAttributes();
		if (attrMap != null) {
			Node domainId = attrMap.getNamedItem(A_DOMAINID);
			Node recordId = attrMap.getNamedItem(A_RECORDID);
			Node formId = attrMap.getNamedItem(A_FORMID);
			Node formVersion = attrMap.getNamedItem(A_FORMVERSION);
			Node creationUser = attrMap.getNamedItem(A_CREATIONUSER);
			Node creationDate = attrMap.getNamedItem(A_CREATIONDATE);
			Node modificationUser = attrMap.getNamedItem(A_MODIFICATIONUSER);
			Node modificationDate = attrMap.getNamedItem(A_MODIFICATIONDATE);
			if (domainId != null)
				obj.setDomainId(domainId.getNodeValue());
			if (recordId != null)
				obj.setRecordId(recordId.getNodeValue());
			if (formId != null)
				obj.setFormId(formId.getNodeValue());
			if (formVersion != null)
				obj.setFormVersion(CommonUtil.toInt(formVersion.getNodeValue()));
			if (creationUser != null)
				obj.setCreationUser(creationUser.getNodeValue());
			if (creationDate != null)
				obj.setCreationDate(DateUtil.toDate(creationDate.getNodeValue()));
			if (modificationUser != null)
				obj.setModificationUser(modificationUser.getNodeValue());
			if (modificationDate != null)
				obj.setModificationDate(DateUtil.toDate(modificationDate.getNodeValue()));
		}
		
		// elements 값 설정
		NodeList childNodeList = node.getChildNodes();
		if (childNodeList == null || childNodeList.getLength() == 0)
			return obj;
		for (int i=0; i<childNodeList.getLength(); i++) {
			Node childNode = childNodeList.item(i);
			if (childNode.getNodeType() != Node.ELEMENT_NODE || childNode.getNodeName() == null)
				continue;
			if (childNode.getNodeName().equals(A_DATAFIELD)) {
				obj.addDataField((SwdDataField)SwdDataField.toObject(childNode, null));
			}
		}
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
	public void addDataField(SwdDataField dataField) {
		this.setDataFields(SwdDataField.add(this.getDataFields(), dataField));
	}
	public void removeDataField(String id) {
		if (dataFieldMap == null || !dataFieldMap.containsKey(id))
			return;
		removeDataField(dataFieldMap.get(id));
	}
	public void removeDataField(SwdDataField dataField) {
		this.setDataFields(SwdDataField.remove(this.getDataFields(), dataField));
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public String getCreationUser() {
		return creationUser;
	}
	public void setCreationUser(String creationUser) {
		this.creationUser = creationUser;
	}
	public SwdDataField[] getDataFields() {
		return dataFields;
	}
	public void setDataFields(SwdDataField[] dataFields) {
		this.dataFields = dataFields;
		if (CommonUtil.isEmpty(dataFields)) {
			this.dataFieldMap = null;
		} else {
			String id;
			for (SwdDataField dataField : dataFields) {
				id = dataField.getId();
				if (CommonUtil.isEmpty(id))
					continue;
				if (dataFieldMap == null)
					dataFieldMap = new HashMap<String, SwdDataField>();
				dataFieldMap.put(id, dataField);
			}
		}
	}
	public SwdDataField getDataField(String id) {
		if (CommonUtil.isEmpty(id))
			return null;
		if (CommonUtil.size(dataFieldMap) != CommonUtil.size(dataFields))
			this.setDataFields(dataFields);
		if (CommonUtil.isEmpty(dataFieldMap))
			return null;
		if (!dataFieldMap.containsKey(id))
			return null;
		return dataFieldMap.get(id);
	}
	public void setDataField(String id, SwdDataField field) {
		removeDataField(id);
		if (field == null)
			return;
		field.setId(id);
		addDataField(field);
	}
	public void setDataField2(String id, SwdDataField field) {
		if (field == null)
			return;
		field.setId(id);
		addDataField(field);
	}
	public String getDataFieldValue(String id) {
		SwdDataField dataField = getDataField(id);
		if (dataField == null)
			return null;
		return dataField.getValue();
	}
	public void setDataFieldValue(String id, String type, String value) {
		SwdDataField dataField = getDataField(id);
		if (dataField == null) {
			dataField = new SwdDataField();
			dataField.setId(id);
			dataField.setType(type);
			addDataField(dataField);
		}
		dataField.setRefRecordId(null);
		dataField.setRefForm(null);
		dataField.setRefFormField(null);
		dataField.setValue(value);
	}
	public String getFormId() {
		return formId;
	}
	public void setFormId(String formId) {
		this.formId = formId;
	}
	public int getFormVersion() {
		return formVersion;
	}
	public void setFormVersion(int formVersion) {
		this.formVersion = formVersion;
	}
	public Date getModificationDate() {
		return modificationDate;
	}
	public void setModificationDate(Date modificationDate) {
		this.modificationDate = modificationDate;
	}
	public String getModificationUser() {
		return modificationUser;
	}
	public void setModificationUser(String modificationUser) {
		this.modificationUser = modificationUser;
	}
	public String getRecordId() {
		return recordId;
	}
	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}
	public String getDomainId() {
		return domainId;
	}
	public void setDomainId(String domainId) {
		this.domainId = domainId;
	}
	public String getFormName() {
		return formName;
	}
	public void setFormName(String formName) {
		this.formName = formName;
	}

}