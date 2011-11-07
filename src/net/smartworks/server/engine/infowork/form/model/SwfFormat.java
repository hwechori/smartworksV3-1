/*	
 * $Id$
 * created by    : maninsoft
 * creation-date : 2011. 11. 7.
 * =========================================================
 * Copyright (c) 2011 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.server.engine.infowork.form.model;

import net.smartworks.server.engine.common.model.BaseObject;
import net.smartworks.server.engine.common.util.CommonUtil;
import net.smartworks.server.engine.common.util.XmlUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class SwfFormat extends BaseObject {

	private static final long serialVersionUID = 1L;
	private static Log logger = LogFactory.getLog(SwfFormat.class);
	
	protected static final String PREFIX = "Swf";
	private static final String NAME = CommonUtil.toName(SwfFormat.class, PREFIX);

	public static final String A_TYPE = "type";
	public static final String A_VIEWINGTYPE = "viewingType";
	public static final String A_NUMERIC = "numeric";
	public static final String A_DATE = "date";
	public static final String A_LIST = "list";
	public static final String A_REFFORM = "refForm";
	public static final String A_CURRENCY = "currency";

	private String type;
	private String viewingType;
	
	private SwfNumeric numeric;
	private SwfDate date;
	private SwfList list;
	private SwfFormRef refForm;
	private String currency;
	public SwfFormat() {
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
		appendAttributeString(A_TYPE, type, buf);
		appendAttributeString(A_VIEWINGTYPE, viewingType, buf);
		return buf.toString();
	}
	public String toElementsString(String tab, boolean lite) {
		StringBuffer buf = new StringBuffer();
		buf.append(super.toElementsString(tab, lite));
		appendElementString(A_NUMERIC, getNumeric(), tab, buf);
		appendElementString(A_DATE, getDate(), tab, buf);
		appendElementString(A_LIST, getList(), tab, buf);
		appendElementString(A_REFFORM, getRefForm(), tab, buf);
		appendElementString(A_CURRENCY, getCurrency(), tab, buf);
		return buf.toString();
	}
	public static BaseObject toObject(Node node, BaseObject baseObj) throws Exception {
		if (node == null)
			return null;
		
		SwfFormat obj = null;
		if (baseObj == null || !(baseObj instanceof SwfFormat))
			obj = new SwfFormat();
		else
			obj = (SwfFormat)baseObj;
		
		// 부모 attributes, elements 값 설정
		BaseObject.toObject(node, obj);
		
		NamedNodeMap attrMap = node.getAttributes();
		if (attrMap != null) {
			Node type = attrMap.getNamedItem(A_TYPE);
			Node viewingType = attrMap.getNamedItem(A_VIEWINGTYPE);
			if (type != null)
				obj.setType(type.getNodeValue());
			if (viewingType != null)
				obj.setViewingType(viewingType.getNodeValue());
		}
		
		// elements 값 설정
		NodeList childNodeList = node.getChildNodes();
		if (childNodeList == null || childNodeList.getLength() == 0)
			return obj;
		for (int i=0; i<childNodeList.getLength(); i++) {
			Node childNode = childNodeList.item(i);
			if (childNode.getNodeType() != Node.ELEMENT_NODE || childNode.getNodeName() == null)
				continue;
			if (childNode.getNodeName().equals(A_NUMERIC)) {
				obj.setNumeric((SwfNumeric)SwfNumeric.toObject(childNode, null));
			} else if (childNode.getNodeName().equals(A_DATE)) {
				obj.setDate((SwfDate)SwfDate.toObject(childNode, null));
			} else if (childNode.getNodeName().equals(A_LIST)) {
				obj.setList((SwfList)SwfList.toObject(childNode, null));
			} else if (childNode.getNodeName().equals(A_REFFORM)) {
				obj.setRefForm((SwfFormRef)SwfFormRef.toObject(childNode, null));
			} else if (childNode.getNodeName().equals(A_CURRENCY)) {
				obj.setCurrency(getNodeValue(childNode));
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
	public static SwfFormat[] add(SwfFormat[] objs, SwfFormat obj) {
		if (obj == null)
			return objs;
		int size = 0;
		if (objs != null)
			size = objs.length;
		SwfFormat[] newObjs = new SwfFormat[size+1];
		int i;
		for (i=0; i<size; i++)
			newObjs[i] = objs[i];
		newObjs[i] = obj;
		return newObjs;
	}
	public static SwfFormat[] remove(SwfFormat[] objs, SwfFormat obj) {
		if (obj == null)
			return objs;
		int size = 0;
		if (objs != null)
			size = objs.length;
		if (size == 0)
			return objs;
		SwfFormat[] newObjs = new SwfFormat[size-1];
		int i;
		int j = 0;
		for (i=0; i<size; i++) {
			if (objs[i].equals(obj))
				continue;
			newObjs[j++] = objs[i];
		}
		return newObjs;
	}
	public static SwfFormat[] left(SwfFormat[] objs, SwfFormat obj) {
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
		SwfFormat[] newObjs = new SwfFormat[objs.length];
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
	public static SwfFormat[] right(SwfFormat[] objs, SwfFormat obj) {
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
		SwfFormat[] newObjs = new SwfFormat[objs.length];
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
	public SwfDate getDate() {
		return date;
	}
	public void setDate(SwfDate date) {
		this.date = date;
	}
	public SwfList getList() {
		return list;
	}
	public void setList(SwfList list) {
		this.list = list;
	}
	public SwfNumeric getNumeric() {
		return numeric;
	}
	public void setNumeric(SwfNumeric numeric) {
		this.numeric = numeric;
	}
	public SwfFormRef getRefForm() {
		return refForm;
	}
	public void setRefForm(SwfFormRef refForm) {
		this.refForm = refForm;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getViewingType() {
		return viewingType;
	}
	public void setViewingType(String viewingType) {
		this.viewingType = viewingType;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}

}