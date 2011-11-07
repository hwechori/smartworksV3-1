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

public class SwfFieldRef extends BaseObject {

	private static final long serialVersionUID = 1L;
	private static Log logger = LogFactory.getLog(SwfFieldRef.class);
	
	protected static final String PREFIX = "Swf";
	private static final String NAME = CommonUtil.toName(SwfFieldRef.class, PREFIX);

	public static final String A_ID = "id";
	public static final String A_NAME = "name";

	private String id;
	private String name;
	public SwfFieldRef() {
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
		appendAttributeString(A_ID, id, buf);
		return buf.toString();
	}
	public String toElementsString(String tab, boolean lite) {
		StringBuffer buf = new StringBuffer();
		buf.append(super.toElementsString(tab, lite));
		appendElementString(null, name, tab, buf);
		return buf.toString();
	}
	public static BaseObject toObject(Node node, BaseObject baseObj) throws Exception {
		if (node == null)
			return null;
		
		SwfFieldRef obj = null;
		if (baseObj == null || !(baseObj instanceof SwfFieldRef))
			obj = new SwfFieldRef();
		else
			obj = (SwfFieldRef)baseObj;
		
		// 부모 attributes, elements 값 설정
		BaseObject.toObject(node, obj);
		
		NamedNodeMap attrMap = node.getAttributes();
		if (attrMap != null) {
			Node id = attrMap.getNamedItem(A_ID);
			if (id != null)
				obj.setId(id.getNodeValue());
		}
		
		// elements 값 설정
		NodeList childNodeList = node.getChildNodes();
		if (childNodeList == null || childNodeList.getLength() == 0)
			return obj;
		for (int i=0; i<childNodeList.getLength(); i++) {
			Node childNode = childNodeList.item(i);
			if (childNode.getNodeType() != Node.TEXT_NODE && childNode.getNodeType() != Node.CDATA_SECTION_NODE)
				continue;
			obj.setName(getNodeValue(childNode));
			break;
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
	public static SwfFieldRef[] add(SwfFieldRef[] objs, SwfFieldRef obj) {
		if (obj == null)
			return objs;
		int size = 0;
		if (objs != null)
			size = objs.length;
		SwfFieldRef[] newObjs = new SwfFieldRef[size+1];
		int i;
		for (i=0; i<size; i++)
			newObjs[i] = objs[i];
		newObjs[i] = obj;
		return newObjs;
	}
	public static SwfFieldRef[] remove(SwfFieldRef[] objs, SwfFieldRef obj) {
		if (obj == null)
			return objs;
		int size = 0;
		if (objs != null)
			size = objs.length;
		if (size == 0)
			return objs;
		SwfFieldRef[] newObjs = new SwfFieldRef[size-1];
		int i;
		int j = 0;
		for (i=0; i<size; i++) {
			if (objs[i].equals(obj))
				continue;
			newObjs[j++] = objs[i];
		}
		return newObjs;
	}
	public static SwfFieldRef[] left(SwfFieldRef[] objs, SwfFieldRef obj) {
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
		SwfFieldRef[] newObjs = new SwfFieldRef[objs.length];
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
	public static SwfFieldRef[] right(SwfFieldRef[] objs, SwfFieldRef obj) {
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
		SwfFieldRef[] newObjs = new SwfFieldRef[objs.length];
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

}