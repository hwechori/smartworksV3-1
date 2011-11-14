/*	
 * $Id$
 * created by    : maninsoft
 * creation-date : 2011. 11. 2.
 * =========================================================
 * Copyright (c) 2011 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.server.engine.organization.model;

import net.smartworks.server.engine.common.model.BaseObject;
import net.smartworks.server.engine.common.util.CommonUtil;
import net.smartworks.server.engine.common.util.XmlUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class SwoDepartmentCond extends SwoObjectCond {

	private static final long serialVersionUID = 1L;
	private static Log logger = LogFactory.getLog(SwoDepartmentCond.class);
	
	private static final String NAME = CommonUtil.toName(SwoDepartmentCond.class, PREFIX);

	public static final String TYPE_BASIC = "BASIC";
	public static final String A_COMPANYID = "companyId";
	public static final String A_PARENTID = "parentId";
	public static final String A_ISPARENTNULL = "isParentNull";
	public static final String A_TYPE = "type";
	public static final String A_DESCRIPTION = "description";

	private String companyId;
	private String parentId;
	private boolean isParentNull;
	private String type;
	private String description;

	public SwoDepartmentCond() {
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
		appendAttributeString(A_COMPANYID, companyId, buf);
		appendAttributeString(A_PARENTID, parentId, buf);
		appendAttributeString(A_ISPARENTNULL, isParentNull, buf);
		appendAttributeString(A_TYPE, type, buf);
		return buf.toString();
	}
	public String toElementsString(String tab, boolean lite) {
		StringBuffer buf = new StringBuffer();
		buf.append(super.toElementsString(tab, lite));
		appendElementString(A_DESCRIPTION, getDescription(), tab, buf);
		return buf.toString();
	}
	public static BaseObject toObject(Node node, BaseObject baseObj) throws Exception {
		if (node == null)
			return null;
		
		SwoDepartmentCond obj = null;
		if (baseObj == null || !(baseObj instanceof SwoDepartmentCond))
			obj = new SwoDepartmentCond();
		else
			obj = (SwoDepartmentCond)baseObj;
		
		// 부모 attributes, elements 값 설정
		SwoObjectCond.toObject(node, obj);
		
		NamedNodeMap attrMap = node.getAttributes();
		if (attrMap != null) {
			Node companyId = attrMap.getNamedItem(A_COMPANYID);
			Node parentId = attrMap.getNamedItem(A_PARENTID);
			Node isParentNull = attrMap.getNamedItem(A_ISPARENTNULL);
			Node type = attrMap.getNamedItem(A_TYPE);
			if (companyId != null)
				obj.setCompanyId(companyId.getNodeValue());
			if (parentId != null)
				obj.setParentId(parentId.getNodeValue());
			if (isParentNull != null)
				obj.setParentNull(CommonUtil.toBoolean(isParentNull.getNodeValue()));
			if (type != null)
				obj.setType(type.getNodeValue());
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
				obj.setDescription(getNodeValue(childNode));
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
	public static SwoDepartmentCond[] add(SwoDepartmentCond[] objs, SwoDepartmentCond obj) {
		if (obj == null)
			return objs;
		int size = 0;
		if (objs != null)
			size = objs.length;
		SwoDepartmentCond[] newObjs = new SwoDepartmentCond[size+1];
		int i;
		for (i=0; i<size; i++)
			newObjs[i] = objs[i];
		newObjs[i] = obj;
		return newObjs;
	}
	public static SwoDepartmentCond[] remove(SwoDepartmentCond[] objs, SwoDepartmentCond obj) {
		if (obj == null)
			return objs;
		int size = 0;
		if (objs != null)
			size = objs.length;
		if (size == 0)
			return objs;
		SwoDepartmentCond[] newObjs = new SwoDepartmentCond[size-1];
		int i;
		int j = 0;
		for (i=0; i<size; i++) {
			if (objs[i].equals(obj))
				continue;
			newObjs[j++] = objs[i];
		}
		return newObjs;
	}
	public static SwoDepartmentCond[] left(SwoDepartmentCond[] objs, SwoDepartmentCond obj) {
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
		SwoDepartmentCond[] newObjs = new SwoDepartmentCond[objs.length];
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
	public static SwoDepartmentCond[] right(SwoDepartmentCond[] objs, SwoDepartmentCond obj) {
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
		SwoDepartmentCond[] newObjs = new SwoDepartmentCond[objs.length];
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
	
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
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
	public boolean isParentNull() {
		return isParentNull;
	}
	public void setParentNull(boolean isParentNull) {
		this.isParentNull = isParentNull;
	}

}