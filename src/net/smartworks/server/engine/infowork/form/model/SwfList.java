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

public class SwfList extends BaseObject {

	private static final long serialVersionUID = 1L;
	private static Log logger = LogFactory.getLog(SwfDate.class);
	
	protected static final String PREFIX = "Swf";
	private static final String NAME = CommonUtil.toName(SwfDate.class, PREFIX);

	public static final String A_TYPE = "type";
	public static final String A_LISTTYPE = "listType";
	public static final String A_REFCODECATEGORYID = "refCodeCategoryId";
	public static final String A_REFCODECATEGORYNAME = "refCodeCategoryName";
	public static final String A_STATICITEMS = "staticItems";
	public static final String A_STATICITEM = "staticItem";

	private String type;
	private String listType;
	private String refCodeCategoryId;
	private String refCodeCategoryName;
	private String[] staticItems;
	public SwfList() {
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
		appendAttributeString(A_LISTTYPE, listType, buf);
		appendAttributeString(A_REFCODECATEGORYID, refCodeCategoryId, buf);
		appendAttributeString(A_REFCODECATEGORYNAME, refCodeCategoryName, true, buf);
		return buf.toString();
	}
	public String toElementsString(String tab, boolean lite) {
		StringBuffer buf = new StringBuffer();
		buf.append(super.toElementsString(tab, lite));
		if (lite) {
			appendElementsString(null, A_STATICITEM, getStaticItems(), tab, buf);
		} else {
			appendElementsString(A_STATICITEMS, A_STATICITEM, getStaticItems(), tab, buf);
		}
		return buf.toString();
	}
	public static BaseObject toObject(Node node, BaseObject baseObj) throws Exception {
		if (node == null)
			return null;
		
		SwfList obj = null;
		if (baseObj == null || !(baseObj instanceof SwfList))
			obj = new SwfList();
		else
			obj = (SwfList)baseObj;
		
		// 부모 attributes, elements 값 설정
		BaseObject.toObject(node, obj);
		
		NamedNodeMap attrMap = node.getAttributes();
		if (attrMap != null) {
			Node type = attrMap.getNamedItem(A_TYPE);
			Node listType = attrMap.getNamedItem(A_LISTTYPE);
			Node refCodeCategoryId = attrMap.getNamedItem(A_REFCODECATEGORYID);
			Node refCodeCategoryName = attrMap.getNamedItem(A_REFCODECATEGORYNAME);
			if (type != null)
				obj.setType(type.getNodeValue());
			if (listType != null)
				obj.setListType(listType.getNodeValue());
			if (refCodeCategoryId != null)
				obj.setRefCodeCategoryId(refCodeCategoryId.getNodeValue());
			if (refCodeCategoryName != null)
				obj.setRefCodeCategoryName(refCodeCategoryName.getNodeValue());
		}
		
		// elements 값 설정
		NodeList childNodeList = node.getChildNodes();
		if (childNodeList == null || childNodeList.getLength() == 0)
			return obj;
		for (int i=0; i<childNodeList.getLength(); i++) {
			Node childNode = childNodeList.item(i);
			if (childNode.getNodeType() != Node.ELEMENT_NODE || childNode.getNodeName() == null)
				continue;
			if (childNode.getNodeName().equals(A_STATICITEMS)) {
				Node[] nodes = getNodes(childNode);
				if (nodes == null || nodes.length == 0)
					continue;
				String[] objs = new String[nodes.length];
				for (int j=0; j<nodes.length; j++)
					objs[j] = getNodeValue(nodes[j]);
				obj.setStaticItems(objs);
//			} else if (childNode.getNodeName().equals(A_STATICITEM)) {
//				obj.addStaticItem(getNodeValue(childNode));
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
	public static SwfList[] add(SwfList[] objs, SwfList obj) {
		if (obj == null)
			return objs;
		int size = 0;
		if (objs != null)
			size = objs.length;
		SwfList[] newObjs = new SwfList[size+1];
		int i;
		for (i=0; i<size; i++)
			newObjs[i] = objs[i];
		newObjs[i] = obj;
		return newObjs;
	}
	public static SwfList[] remove(SwfList[] objs, SwfList obj) {
		if (obj == null)
			return objs;
		int size = 0;
		if (objs != null)
			size = objs.length;
		if (size == 0)
			return objs;
		SwfList[] newObjs = new SwfList[size-1];
		int i;
		int j = 0;
		for (i=0; i<size; i++) {
			if (objs[i].equals(obj))
				continue;
			newObjs[j++] = objs[i];
		}
		return newObjs;
	}
	public static SwfList[] left(SwfList[] objs, SwfList obj) {
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
		SwfList[] newObjs = new SwfList[objs.length];
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
	public static SwfList[] right(SwfList[] objs, SwfList obj) {
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
		SwfList[] newObjs = new SwfList[objs.length];
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
	public String getListType() {
		return listType;
	}
	public void setListType(String listType) {
		this.listType = listType;
	}
	public String getRefCodeCategoryId() {
		return refCodeCategoryId;
	}
	public void setRefCodeCategoryId(String refCodeCategoryId) {
		this.refCodeCategoryId = refCodeCategoryId;
	}
	public String getRefCodeCategoryName() {
		return refCodeCategoryName;
	}
	public void setRefCodeCategoryName(String refCodeCategoryName) {
		this.refCodeCategoryName = refCodeCategoryName;
	}
	public String[] getStaticItems() {
		return staticItems;
	}
	public void setStaticItems(String[] staticItems) {
		this.staticItems = staticItems;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

}