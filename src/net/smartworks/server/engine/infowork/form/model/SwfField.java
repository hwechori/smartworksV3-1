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

public class SwfField extends BaseObject {

	private static final long serialVersionUID = 1L;
	private static Log logger = LogFactory.getLog(SwfField.class);
	
	protected static final String PREFIX = "Swf";
	private static final String NAME = CommonUtil.toName(SwfField.class, PREFIX);
	
	public static final String A_ID = "id";
	public static final String A_NAME = "name";
	public static final String A_SYSTEMNAME = "systemName";
	public static final String A_SYSTEMTYPE = "systemType";
	public static final String A_ARRAY = "array";
	public static final String A_REQUIRED = "required";
	public static final String A_SYSTEM = "system";
	public static final String A_FIELDS = "children";
	public static final String A_FIELD = "formEntity";
	public static final String A_GRAPHIC = "graphic";
	public static final String A_FORMAT = "format";
	public static final String A_MAPPINGS = "mappings";
	
	private String id;
	private String name;
	private String systemName;
	private String systemType;
	private boolean array;
	private boolean required;
	private boolean system;

	private SwfField[] fields;
	private SwfMappings mappings;
	private SwfFormat format;

	public SwfField() {
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
		appendAttributeString(A_SYSTEMNAME, systemName, buf);
		appendAttributeString(A_SYSTEMTYPE, systemType, buf);
		appendAttributeString(A_ARRAY, array, buf);
		appendAttributeString(A_REQUIRED, required, buf);
		appendAttributeString(A_SYSTEM, system, buf);
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
		appendElementString(A_MAPPINGS, getMappings(), tab, buf);
//		appendElementString(A_GRAPHIC, getGraphic(), tab, buf);
		appendElementString(A_FORMAT, getFormat(), tab, buf);
		return buf.toString();
	}
	public static BaseObject toObject(Node node, BaseObject baseObj) throws Exception {
		if (node == null)
			return null;
		
		SwfField obj = null;
		if (baseObj == null || !(baseObj instanceof SwfField))
			obj = new SwfField();
		else
			obj = (SwfField)baseObj;
		
		// 부모 attributes, elements 값 설정
		BaseObject.toObject(node, obj);
		
		NamedNodeMap attrMap = node.getAttributes();
		if (attrMap != null) {
			Node id = attrMap.getNamedItem(A_ID);
			Node name = attrMap.getNamedItem(A_NAME);
			Node systemName = attrMap.getNamedItem(A_SYSTEMNAME);
			Node systemType = attrMap.getNamedItem(A_SYSTEMTYPE);
			Node array = attrMap.getNamedItem(A_ARRAY);
			Node required = attrMap.getNamedItem(A_REQUIRED);
			Node system = attrMap.getNamedItem(A_SYSTEM);
			if (id != null)
				obj.setId(id.getNodeValue());
			if (name != null)
				obj.setName(name.getNodeValue());
			if (systemName != null)
				obj.setSystemName(systemName.getNodeValue());
			if (systemType != null)
				obj.setSystemType(systemType.getNodeValue());
			if (array != null)
				obj.setArray(CommonUtil.toBoolean(array.getNodeValue()));
			if (required != null)
				obj.setRequired(CommonUtil.toBoolean(required.getNodeValue()));
			if (system != null)
				obj.setSystem(CommonUtil.toBoolean(system.getNodeValue()));
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
				SwfField[] objs = new SwfField[nodes.length];
				for (int j=0; j<nodes.length; j++)
					objs[j] = (SwfField)SwfField.toObject(nodes[j], null);
				obj.setFields(objs);
//			} else if (childNode.getNodeName().equals(A_FIELD)) {
//				obj.addField((SwfField)SwfField.toObject(childNode, null));
			} else if (childNode.getNodeName().equals(A_MAPPINGS)) {
				obj.setMappings((SwfMappings)SwfMappings.toObject(childNode, null));
			} else if (childNode.getNodeName().equals(A_GRAPHIC)) {
//				obj.setGraphic((SwfFieldGraphic)SwfFieldGraphic.toObject(childNode, null));
			} else if (childNode.getNodeName().equals(A_FORMAT)) {
				obj.setFormat((SwfFormat)SwfFormat.toObject(childNode, null));
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
	public static SwfField[] add(SwfField[] objs, SwfField obj) {
		if (obj == null)
			return objs;
		int size = 0;
		if (objs != null)
			size = objs.length;
		SwfField[] newObjs = new SwfField[size+1];
		int i;
		for (i=0; i<size; i++)
			newObjs[i] = objs[i];
		newObjs[i] = obj;
		return newObjs;
	}
	public static SwfField[] remove(SwfField[] objs, SwfField obj) {
		if (obj == null)
			return objs;
		int size = 0;
		if (objs != null)
			size = objs.length;
		if (size == 0)
			return objs;
		SwfField[] newObjs = new SwfField[size-1];
		int i;
		int j = 0;
		for (i=0; i<size; i++) {
			if (objs[i].equals(obj))
				continue;
			newObjs[j++] = objs[i];
		}
		return newObjs;
	}
	public static SwfField[] left(SwfField[] objs, SwfField obj) {
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
		SwfField[] newObjs = new SwfField[objs.length];
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
	public static SwfField[] right(SwfField[] objs, SwfField obj) {
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
		SwfField[] newObjs = new SwfField[objs.length];
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
	public boolean isArray() {
		return array;
	}
	public void setArray(boolean array) {
		this.array = array;
	}
	public SwfField[] getFields() {
		return fields;
	}
	public void setFields(SwfField[] children) {
		this.fields = children;
	}
	public SwfFormat getFormat() {
		return format;
	}
	public void setFormat(SwfFormat format) {
		this.format = format;
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
	public boolean isRequired() {
		return required;
	}
	public void setRequired(boolean required) {
		this.required = required;
	}
	public boolean isSystem() {
		return system;
	}
	public void setSystem(boolean system) {
		this.system = system;
	}
	public String getSystemName() {
		return systemName;
	}
	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}
	public String getSystemType() {
		return systemType;
	}
	public void setSystemType(String systemType) {
		this.systemType = systemType;
	}
	public SwfMappings getMappings() {
		return mappings;
	}
	public void setMappings(SwfMappings mappings) {
		this.mappings = mappings;
	}

}