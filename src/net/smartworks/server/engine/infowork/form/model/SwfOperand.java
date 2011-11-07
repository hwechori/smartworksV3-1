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

public class SwfOperand extends BaseObject {

	private static final long serialVersionUID = 1L;
	private static Log logger = LogFactory.getLog(SwfOperand.class);
	
	protected static final String PREFIX = "Swf";
	private static final String NAME = CommonUtil.toName(SwfOperand.class, PREFIX);
	
	public static final String A_TYPE = "type";
	public static final String A_FIELDID = "fieldId";
	
	private String type;
	private String fieldId;
	
	private String expression;
	public SwfOperand() {
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
		appendAttributeString(A_FIELDID, fieldId, buf);
		return buf.toString();
	}
	public String toElementsString(String tab, boolean lite) {
		StringBuffer buf = new StringBuffer();
		buf.append(super.toElementsString(tab, lite));
		appendElementString(null, expression, tab, buf);
		return buf.toString();
	}
	public static BaseObject toObject(Node node, BaseObject baseObj) throws Exception {
		if (node == null)
			return null;
		
		SwfOperand obj = null;
		if (baseObj == null || !(baseObj instanceof SwfOperand))
			obj = new SwfOperand();
		else
			obj = (SwfOperand)baseObj;
		
		// 부모 attributes, elements 값 설정
		BaseObject.toObject(node, obj);
		
		NamedNodeMap attrMap = node.getAttributes();
		if (attrMap != null) {
			Node type = attrMap.getNamedItem(A_TYPE);
			Node fieldId = attrMap.getNamedItem(A_FIELDID);
			if (type != null)
				obj.setType(type.getNodeValue());
			if (fieldId != null)
				obj.setFieldId(fieldId.getNodeValue());
		}
		
		// elements 값 설정
		NodeList childNodeList = node.getChildNodes();
		if (childNodeList == null || childNodeList.getLength() == 0)
			return obj;
		for (int i=0; i<childNodeList.getLength(); i++) {
			Node childNode = childNodeList.item(i);
			if (childNode.getNodeType() != Node.TEXT_NODE && childNode.getNodeType() != Node.CDATA_SECTION_NODE)
				continue;
			obj.setExpression(getNodeValue(childNode));
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
	public static SwfOperand[] add(SwfOperand[] objs, SwfOperand obj) {
		if (obj == null)
			return objs;
		int size = 0;
		if (objs != null)
			size = objs.length;
		SwfOperand[] newObjs = new SwfOperand[size+1];
		int i;
		for (i=0; i<size; i++)
			newObjs[i] = objs[i];
		newObjs[i] = obj;
		return newObjs;
	}
	public static SwfOperand[] remove(SwfOperand[] objs, SwfOperand obj) {
		if (obj == null)
			return objs;
		int size = 0;
		if (objs != null)
			size = objs.length;
		if (size == 0)
			return objs;
		SwfOperand[] newObjs = new SwfOperand[size-1];
		int i;
		int j = 0;
		for (i=0; i<size; i++) {
			if (objs[i].equals(obj))
				continue;
			newObjs[j++] = objs[i];
		}
		return newObjs;
	}
	public static SwfOperand[] left(SwfOperand[] objs, SwfOperand obj) {
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
		SwfOperand[] newObjs = new SwfOperand[objs.length];
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
	public static SwfOperand[] right(SwfOperand[] objs, SwfOperand obj) {
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
		SwfOperand[] newObjs = new SwfOperand[objs.length];
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
	public String getExpression() {
		return expression;
	}
	public void setExpression(String expression) {
		this.expression = expression;
	}
	public String getFieldId() {
		return fieldId;
	}
	public void setFieldId(String fieldId) {
		this.fieldId = fieldId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

}