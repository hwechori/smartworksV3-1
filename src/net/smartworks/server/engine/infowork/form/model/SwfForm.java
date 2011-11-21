/*	
 * $Id$
 * created by    : maninsoft
 * creation-date : 2011. 11. 7.
 * =========================================================
 * Copyright (c) 2011 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.server.engine.infowork.form.model;

import java.util.Date;

import net.smartworks.server.engine.common.model.BaseObject;
import net.smartworks.server.engine.common.model.ClassObject;
import net.smartworks.server.engine.common.util.CommonUtil;
import net.smartworks.server.engine.common.util.DateUtil;
import net.smartworks.server.engine.common.util.XmlUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class SwfForm extends ClassObject {

	private static final long serialVersionUID = 1L;
	private static Log logger = LogFactory.getLog(SwfForm.class);
	
	protected static final String PREFIX = "Swf";
	private static final String NAME = CommonUtil.toName(SwfForm.class, PREFIX);

	public static final String A_NAME = "name";
	public static final String A_CREATIONUSER = "creationUser";
	public static final String A_CREATIONDATE = "creationDate";
	public static final String A_MODIFICATIONUSER = "modificationUser";
	public static final String A_MODIFICATIONDATE = "modificationDate";
	public static final String A_DESCRIPTION = "description";
	public static final String A_STATUS = "status";
	public static final String A_ID = "id";
	public static final String A_VERSION = "version";
	public static final String A_PACKAGEID = "packageId";
	public static final String A_FORMTYPE = "formType";
	public static final String A_SYSTEMNAME = "systemName";
	public static final String A_KEYWORD = "keyword";
	public static final String A_FIELDS = "children";
	public static final String A_FIELD = "formEntity";
	public static final String A_MAPPINGFORMS = "mappingForms";
	public static final String A_MAPPINGFORM = "mappingForm";

	private String name;
	private String creationUser;
	private Date creationDate;
	private String modificationUser;
	private Date modificationDate;
	private String status;
	private String id;
	private int version;
	private String packageId;
	private String formType;
	private String systemName;

	private String description;
	private String keyword;
	private SwfField[] fields;
	private SwfFormLink[] mappingForms;
	
	private String objString;
	public SwfForm() {
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
		appendAttributeString(A_NAME, name, true, buf);
		appendAttributeString(A_CREATIONUSER, creationUser, buf);
		appendAttributeString(A_CREATIONDATE, creationDate, buf);
		appendAttributeString(A_MODIFICATIONUSER, modificationUser, buf);
		appendAttributeString(A_MODIFICATIONDATE, modificationDate, buf);
		appendAttributeString(A_STATUS, status, buf);
		appendAttributeString(A_ID, id, buf);
		appendAttributeString(A_VERSION, version, buf);
		appendAttributeString(A_PACKAGEID, packageId, buf);
		appendAttributeString(A_SYSTEMNAME, systemName, buf);
		appendAttributeString(A_FORMTYPE, formType, buf);
		return buf.toString();
	}
	public String toElementsString(String tab, boolean lite) {
		StringBuffer buf = new StringBuffer();
		buf.append(super.toElementsString(tab, lite));
		appendElementString(A_DESCRIPTION, getDescription(), tab, true, buf);
		appendElementString(A_KEYWORD, getKeyword(), tab, buf);
		if (lite) {
			appendElementsString(null, A_FIELD, getFields(), tab, lite, buf);
			appendElementsString(null, A_MAPPINGFORM, getMappingForms(), tab, lite, buf);
		} else {
			appendElementsString(A_FIELDS, A_FIELD, getFields(), tab, lite, buf);
			appendElementsString(A_MAPPINGFORMS, A_MAPPINGFORM, getMappingForms(), tab, lite, buf);
		}
		return buf.toString();
	}
	public static BaseObject toObject(Node node, BaseObject baseObj) throws Exception {
		if (node == null)
			return null;
		
		SwfForm obj = null;
		if (baseObj == null || !(baseObj instanceof SwfForm))
			obj = new SwfForm();
		else
			obj = (SwfForm)baseObj;
		
		// 부모 attributes, elements 값 설정
		ClassObject.toObject(node, obj);
		
		NamedNodeMap attrMap = node.getAttributes();
		if (attrMap != null) {
			Node name = attrMap.getNamedItem(A_NAME);
			Node creationUser = attrMap.getNamedItem(A_CREATIONUSER);
			Node creationDate = attrMap.getNamedItem(A_CREATIONDATE);
			Node modificationUser = attrMap.getNamedItem(A_MODIFICATIONUSER);
			Node modificationDate = attrMap.getNamedItem(A_MODIFICATIONDATE);
			Node status = attrMap.getNamedItem(A_STATUS);
			Node id = attrMap.getNamedItem(A_ID);
			Node version = attrMap.getNamedItem(A_VERSION);
			Node packageId = attrMap.getNamedItem(A_PACKAGEID);
			Node systemName = attrMap.getNamedItem(A_SYSTEMNAME);
			Node formType = attrMap.getNamedItem(A_FORMTYPE);
			if (name != null)
				obj.setName(name.getNodeValue());
			if (creationUser != null)
				obj.setCreationUser(creationUser.getNodeValue());
			if (creationDate != null)
				obj.setCreationDate(DateUtil.toDate(creationDate.getNodeValue()));
			if (modificationUser != null)
				obj.setModificationUser(modificationUser.getNodeValue());
			if (modificationDate != null)
				obj.setModificationDate(DateUtil.toDate(modificationDate.getNodeValue()));
			if (status != null)
				obj.setStatus(status.getNodeValue());
			if (id != null)
				obj.setId(id.getNodeValue());
			if (version != null)
				obj.setVersion(CommonUtil.toInt(version.getNodeValue()));
			if (packageId != null)
				obj.setPackageId(packageId.getNodeValue());
			if (systemName != null)
				obj.setSystemName(systemName.getNodeValue());
			if (formType != null)
				obj.setFormType(formType.getNodeValue());
		}
		
		// elements 값 설정
		NodeList childNodeList = node.getChildNodes();
		if (childNodeList == null || childNodeList.getLength() == 0)
			return obj;
		for (int i=0; i<childNodeList.getLength(); i++) {
			Node childNode = childNodeList.item(i);
			if (childNode.getNodeType() != Node.ELEMENT_NODE || childNode.getNodeName() == null)
				continue;
			if (childNode.getNodeName().equals(A_DESCRIPTION)) {
				obj.setDescription(getNodeValue(childNode, true));
			} else if (childNode.getNodeName().equals(A_KEYWORD)) {
				obj.setKeyword(getNodeValue(childNode));
			} else if (childNode.getNodeName().equals(A_FIELDS)) {
				Node[] nodes = getNodes(childNode);
				if (nodes == null || nodes.length == 0)
					continue;
				SwfField[] objs = new SwfField[nodes.length];
				for (int j=0; j<nodes.length; j++)
					objs[j] = (SwfField)SwfField.toObject(nodes[j], null);
				obj.setFields(objs);
//			} else if (childNode.getNodeName().equals(A_FIELD)) {
//				obj.addField((SwfField)SwfField.toObject(childNode, null));
			} else if (childNode.getNodeName().equals(A_MAPPINGFORMS)) {
				Node[] nodes = getNodes(childNode);
				if (nodes == null || nodes.length == 0)
					continue;
				SwfFormLink[] objs = new SwfFormLink[nodes.length];
				for (int j=0; j<nodes.length; j++)
					objs[j] = (SwfFormLink)SwfFormLink.toObject(nodes[j], null);
				obj.setMappingForms(objs);
//			} else if (childNode.getNodeName().equals(A_MAPPINGFORM)) {
//				obj.addMappingForm((SwfMappingForm)SwfMappingForm.toObject(childNode, null));
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
	public static SwfForm[] add(SwfForm[] objs, SwfForm obj) {
		if (obj == null)
			return objs;
		int size = 0;
		if (objs != null)
			size = objs.length;
		SwfForm[] newObjs = new SwfForm[size+1];
		int i;
		for (i=0; i<size; i++)
			newObjs[i] = objs[i];
		newObjs[i] = obj;
		return newObjs;
	}
	public static SwfForm[] remove(SwfForm[] objs, SwfForm obj) {
		if (obj == null)
			return objs;
		int size = 0;
		if (objs != null)
			size = objs.length;
		if (size == 0)
			return objs;
		SwfForm[] newObjs = new SwfForm[size-1];
		int i;
		int j = 0;
		for (i=0; i<size; i++) {
			if (objs[i].equals(obj))
				continue;
			newObjs[j++] = objs[i];
		}
		return newObjs;
	}
	public static SwfForm[] left(SwfForm[] objs, SwfForm obj) {
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
		SwfForm[] newObjs = new SwfForm[objs.length];
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
	public static SwfForm[] right(SwfForm[] objs, SwfForm obj) {
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
		SwfForm[] newObjs = new SwfForm[objs.length];
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
	public void addField(SwfField field) {
		if (field == null)
			return;
		this.setFields(SwfField.add(this.getFields(), field));
	}
	public SwfField[] getFields() {
		return fields;
	}
	public void setFields(SwfField[] fields) {
		this.fields = fields;
	}
	public String getFormType() {
		return formType;
	}
	public void setFormType(String formType) {
		this.formType = formType;
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
	public String getSystemName() {
		return systemName;
	}
	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	public SwfFormLink[] getMappingForms() {
		return mappingForms;
	}
	public void setMappingForms(SwfFormLink[] mappingForms) {
		this.mappingForms = mappingForms;
	}
	public String getObjString() {
		return objString;
	}
	public void setObjString(String objString) {
		this.objString = objString;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getPackageId() {
		return packageId;
	}
	public void setPackageId(String packageId) {
		this.packageId = packageId;
	}

}