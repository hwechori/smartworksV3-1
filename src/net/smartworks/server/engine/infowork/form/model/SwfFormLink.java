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

public class SwfFormLink extends BaseObject {

	private static final long serialVersionUID = 1L;
	private static Log logger = LogFactory.getLog(SwfFormLink.class);
	
	protected static final String PREFIX = "Swf";
	private static final String NAME = CommonUtil.toName(SwfFormLink.class, PREFIX);
	
	public static final String A_ID = "id";
	public static final String A_NAME = "name";
	public static final String A_TARGETFORMID = "targetFormId";
	public static final String A_TARGETFORMNAME = "targetFormName";
	public static final String A_CONDS = "conds";
	
	private String id;
	private String name;
	private String targetFormId;
	private String targetFormName;
	
	private SwfConditions conds;
	public SwfFormLink() {
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
		appendAttributeString(A_NAME, name, true, buf);
		appendAttributeString(A_TARGETFORMID, targetFormId, buf);
		appendAttributeString(A_TARGETFORMNAME, targetFormName, true, buf);
		return buf.toString();
	}
	public String toElementsString(String tab, boolean lite) {
		StringBuffer buf = new StringBuffer();
		buf.append(super.toElementsString(tab, lite));
		appendElementString(A_CONDS, getConds(), tab, buf);
		return buf.toString();
	}
	public static BaseObject toObject(Node node, BaseObject baseObj) throws Exception {
		if (node == null)
			return null;
		
		SwfFormLink obj = null;
		if (baseObj == null || !(baseObj instanceof SwfFormLink))
			obj = new SwfFormLink();
		else
			obj = (SwfFormLink)baseObj;
		
		// 부모 attributes, elements 값 설정
		BaseObject.toObject(node, obj);
		
		NamedNodeMap attrMap = node.getAttributes();
		if (attrMap != null) {
			Node id = attrMap.getNamedItem(A_ID);
			Node name = attrMap.getNamedItem(A_NAME);
			Node targetFormId = attrMap.getNamedItem(A_TARGETFORMID);
			Node targetFormName = attrMap.getNamedItem(A_TARGETFORMNAME);
			if (id != null)
				obj.setId(id.getNodeValue());
			if (name != null)
				obj.setName(name.getNodeValue());
			if (targetFormId != null)
				obj.setTargetFormId(targetFormId.getNodeValue());
			if (targetFormName != null)
				obj.setTargetFormName(targetFormName.getNodeValue());
		}
		
		// elements 값 설정
		NodeList childNodeList = node.getChildNodes();
		if (childNodeList == null || childNodeList.getLength() == 0)
			return obj;
		for (int i=0; i<childNodeList.getLength(); i++) {
			Node childNode = childNodeList.item(i);
			if (childNode.getNodeType() != Node.ELEMENT_NODE || childNode.getNodeName() == null)
				continue;
			if (childNode.getNodeName().equals(A_CONDS)) {
				obj.setConds((SwfConditions)SwfConditions.toObject(childNode, null));
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
	public static SwfFormLink[] add(SwfFormLink[] objs, SwfFormLink obj) {
		if (obj == null)
			return objs;
		int size = 0;
		if (objs != null)
			size = objs.length;
		SwfFormLink[] newObjs = new SwfFormLink[size+1];
		int i;
		for (i=0; i<size; i++)
			newObjs[i] = objs[i];
		newObjs[i] = obj;
		return newObjs;
	}
	public static SwfFormLink[] remove(SwfFormLink[] objs, SwfFormLink obj) {
		if (obj == null)
			return objs;
		int size = 0;
		if (objs != null)
			size = objs.length;
		if (size == 0)
			return objs;
		SwfFormLink[] newObjs = new SwfFormLink[size-1];
		int i;
		int j = 0;
		for (i=0; i<size; i++) {
			if (objs[i].equals(obj))
				continue;
			newObjs[j++] = objs[i];
		}
		return newObjs;
	}
	public static SwfFormLink[] left(SwfFormLink[] objs, SwfFormLink obj) {
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
		SwfFormLink[] newObjs = new SwfFormLink[objs.length];
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
	public static SwfFormLink[] right(SwfFormLink[] objs, SwfFormLink obj) {
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
		SwfFormLink[] newObjs = new SwfFormLink[objs.length];
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
	public String getTargetFormId() {
		return targetFormId;
	}
	public void setTargetFormId(String targetFormId) {
		this.targetFormId = targetFormId;
	}
	public String getTargetFormName() {
		return targetFormName;
	}
	public void setTargetFormName(String targetFormName) {
		this.targetFormName = targetFormName;
	}
	public SwfConditions getConds() {
		return conds;
	}
	public void setConds(SwfConditions conds) {
		this.conds = conds;
	}

}