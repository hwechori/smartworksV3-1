/*	
 * $Id$
 * created by    : maninsoft
 * creation-date : 2011. 11. 7.
 * =========================================================
 * Copyright (c) 2011 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.server.engine.infowork.domain.model;

import java.util.Set;

import net.smartworks.server.engine.common.model.BaseObject;
import net.smartworks.server.engine.common.model.ClassObject;
import net.smartworks.server.engine.common.util.CommonUtil;
import net.smartworks.server.engine.common.util.XmlUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class SwdDomain extends ClassObject {

	private static final long serialVersionUID = 1L;
	private static Log logger = LogFactory.getLog(SwdDomain.class);
	
	protected static final String PREFIX = "Swd";
	private static final String NAME = CommonUtil.toName(SwdDomain.class, PREFIX);

	public static final String A_FORMID = "formId";
	public static final String A_FORMVERSION = "formVersion";
	public static final String A_FORMNAME = "formName";
	public static final String A_TABLENAME = "tableName";
	public static final String A_KEYCOLUMN = "keyColumn";
	public static final String A_TITLEFIELDID = "titleFieldId";
	public static final String A_ISSYSTEMDOMAIN = "isSystemDomain";
	public static final String A_PUBLISHMODE = "publishMode";

	public static final String A_FIELDS = "fields";
	public static final String A_FIELD = "field";
	
	private String formId;
	private int formVersion;
	private String formName;
	private String tableName;
	private String keyColumn;
	private String titleFieldId;
	private String systemDomainYn;
	private String publishMode;
	
	private SwdField[] fields;
	private Set fieldSet;
	public SwdDomain() {
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
		appendAttributeString(A_FORMID, formId, buf);
		appendAttributeString(A_FORMVERSION, formVersion, buf);
		appendAttributeString(A_FORMNAME, formName, true, buf);
		appendAttributeString(A_TABLENAME, tableName, buf);
		appendAttributeString(A_KEYCOLUMN, keyColumn, buf);
		appendAttributeString(A_TITLEFIELDID, titleFieldId, buf);
		appendAttributeString(A_ISSYSTEMDOMAIN, isSystemDomain(), buf);
		appendAttributeString(A_PUBLISHMODE, publishMode, buf);
		return buf.toString();
	}
	public String toElementsString(String tab, boolean lite) {
		StringBuffer buf = new StringBuffer();
		buf.append(super.toElementsString(tab, lite));
		if (lite) {
			appendElementsString(null, A_FIELD, getFields(), tab, lite, buf);
		} else {
			appendElementsString(A_FIELDS, A_FIELD, getFields(), tab, lite, buf);
		}
		return buf.toString();
	}
	public static BaseObject toObject(Node node, BaseObject baseObj) throws Exception {
		if (node == null)
			return null;
		
		SwdDomain obj = null;
		if (baseObj == null || !(baseObj instanceof SwdDomain))
			obj = new SwdDomain();
		else
			obj = (SwdDomain)baseObj;
		
		// 부모 attributes, elements 값 설정
		ClassObject.toObject(node, obj);
		
		NamedNodeMap attrMap = node.getAttributes();
		if (attrMap != null) {
			Node formId = attrMap.getNamedItem(A_FORMID);
			Node formVersion = attrMap.getNamedItem(A_FORMVERSION);
			Node formName = attrMap.getNamedItem(A_FORMNAME);
			Node tableName = attrMap.getNamedItem(A_TABLENAME);
			Node keyColumn = attrMap.getNamedItem(A_KEYCOLUMN);
			Node titleFieldId = attrMap.getNamedItem(A_TITLEFIELDID);
			Node isSystemDomain = attrMap.getNamedItem(A_ISSYSTEMDOMAIN);
			Node publishMode = attrMap.getNamedItem(A_PUBLISHMODE);
			if (formId != null)
				obj.setFormId(formId.getNodeValue());
			if (formVersion != null)
				obj.setFormVersion(CommonUtil.toInt(formVersion.getNodeValue()));
			if (formName != null)
				obj.setFormName(formName.getNodeValue());
			if (tableName != null)
				obj.setTableName(tableName.getNodeValue());
			if (keyColumn != null)
				obj.setKeyColumn(keyColumn.getNodeValue());
			if (titleFieldId != null)
				obj.setTitleFieldId(titleFieldId.getNodeValue());
			if (isSystemDomain != null)
				obj.setSystemDomain(CommonUtil.toBoolean(isSystemDomain.getNodeValue()));
			if (publishMode != null)
				obj.setPublishMode(publishMode.getNodeValue());
		}
		
		// elements 값 설정
		NodeList childNodeList = node.getChildNodes();
		if (childNodeList == null || childNodeList.getLength() == 0)
			return obj;
		for (int i=0; i<childNodeList.getLength(); i++) {
			Node childNode = childNodeList.item(i);
			if (childNode.getNodeType() != Node.ELEMENT_NODE || childNode.getNodeName() == null)
				continue;
			if (childNode.getNodeName().equals(A_FIELDS)) {
				Node[] nodes = getNodes(childNode);
				if (nodes == null || nodes.length == 0)
					continue;
				SwdField[] objs = new SwdField[nodes.length];
				for (int j=0; j<nodes.length; j++)
					objs[j] = (SwdField)SwdField.toObject(nodes[j], null);
				obj.setFields(objs);
//			} else if (childNode.getNodeName().equals(A_FIELD)) {
//				obj.addField((SwdField)SwdField.toObject(childNode, null));
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
	public static SwdDomain[] add(SwdDomain[] objs, SwdDomain obj) {
		if (obj == null)
			return objs;
		int size = 0;
		if (objs != null)
			size = objs.length;
		SwdDomain[] newObjs = new SwdDomain[size+1];
		int i;
		for (i=0; i<size; i++)
			newObjs[i] = objs[i];
		newObjs[i] = obj;
		return newObjs;
	}
	public static SwdDomain[] remove(SwdDomain[] objs, SwdDomain obj) {
		if (obj == null)
			return objs;
		int size = 0;
		if (objs != null)
			size = objs.length;
		if (size == 0)
			return objs;
		SwdDomain[] newObjs = new SwdDomain[size-1];
		int i;
		int j = 0;
		for (i=0; i<size; i++) {
			if (objs[i].equals(obj))
				continue;
			newObjs[j++] = objs[i];
		}
		return newObjs;
	}
	public static SwdDomain[] left(SwdDomain[] objs, SwdDomain obj) {
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
		SwdDomain[] newObjs = new SwdDomain[objs.length];
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
	public static SwdDomain[] right(SwdDomain[] objs, SwdDomain obj) {
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
		SwdDomain[] newObjs = new SwdDomain[objs.length];
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
	public void addField(SwdField field) {
		if (field == null)
			return;
		this.setFields(SwdField.add(this.getFields(), field));
	}
	public SwdField[] getFields() {
		if (CommonUtil.isEmpty(fieldSet))
			return null;
		if (!CommonUtil.isEmpty(fields))
			return fields;
		fields = new SwdField[fieldSet.size()];
		fieldSet.toArray(fields);
		return fields;
	}
	public void setFields(SwdField[] fields) {
		this.fields = fields;
		this.fieldSet = CommonUtil.toSet(fields);
	}
	public String getFormId() {
		return formId;
	}
	public void setFormId(String formId) {
		this.formId = formId;
	}
	public String getFormName() {
		return formName;
	}
	public void setFormName(String formName) {
		this.formName = formName;
	}
	public int getFormVersion() {
		return formVersion;
	}
	public void setFormVersion(int formVersion) {
		this.formVersion = formVersion;
	}
	public boolean isSystemDomain() {
		return systemDomainYn != null && systemDomainYn.equals("Y");
	}
	public void setSystemDomain(boolean isSystemDomain) {
		this.systemDomainYn = isSystemDomain? "Y":"N";
	}
	public String getKeyColumn() {
		return keyColumn;
	}
	public void setKeyColumn(String keyColumn) {
		this.keyColumn = keyColumn;
	}
	public String getPublishMode() {
		return publishMode;
	}
	public void setPublishMode(String publishMode) {
		this.publishMode = publishMode;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public String getTitleFieldId() {
		return titleFieldId;
	}
	public void setTitleFieldId(String titleFieldId) {
		this.titleFieldId = titleFieldId;
	}

}