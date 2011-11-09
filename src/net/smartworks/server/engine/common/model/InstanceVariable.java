/*	
 * $Id$
 * created by    : maninsoft
 * creation-date : 2011. 11. 7.
 * =========================================================
 * Copyright (c) 2011 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.server.engine.common.model;

import net.smartworks.server.engine.common.util.CommonUtil;
import net.smartworks.server.engine.common.util.XmlUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class InstanceVariable extends MisObject {

	private static final long serialVersionUID = 1L;
	private static Log logger = LogFactory.getLog(InstanceVariable.class);
	protected static final String PREFIX = "Var";
	
	private static final String NAME = CommonUtil.toName(InstanceVariable.class, PREFIX);
	
	public static String A_ID = "id";
	public static String A_INSTTYPE = "instType";
	public static String A_INSTID = "instId";
	public static String A_VARIABLENAME = "variableName";
	public static String A_VARIABLETYPE = "variableType";
	public static String A_VARIABLEMODE = "variableMode";
	public static String A_VARIABLEVALUE = "variableValue";
	public static String A_VARIABLEREQ = "variableReq";

	private String id;
	private String instType;
	private String instId;
	private String variableName;
	private String variableType;
	private String variableMode;
	private String variableValue;
	private String variableReq;
	
	public InstanceVariable() {
		super();
	}
	
	public  String toString(String name, String tab) {
		if (name == null || name.trim().length() == 0)
			name = NAME;
			return super.toString(name, tab);
	}
	public String toAttributesString() {
		StringBuffer buf = new StringBuffer();
		buf.append(super.toAttributesString());
		appendAttributeString(A_ID, id, buf);
		appendAttributeString(A_INSTTYPE, instType, buf);
		appendAttributeString(A_INSTID, instId, buf);
		appendAttributeString(A_VARIABLENAME, variableName, buf);
		appendAttributeString(A_VARIABLETYPE, variableType, buf);
		appendAttributeString(A_VARIABLEMODE, variableMode, buf);
		appendAttributeString(A_VARIABLEREQ, variableReq, buf);

		return buf.toString();
	}
	public String toElementsString(String tab) {
		StringBuffer buf = new StringBuffer();
		buf.append(super.toElementsString(tab));
		appendElementString(A_VARIABLEVALUE, getVariableValue(), tab, true, buf);	
		return buf.toString();
	}
	
	public static BaseObject toObject(Node node, BaseObject baseObj) throws Exception {
		if (node == null)
			return null;
		
		InstanceVariable obj = null;
		if (node == null || !(baseObj instanceof InstanceVariable))
			obj = new InstanceVariable();
		else
			obj = (InstanceVariable)baseObj;
		MisObject.toObject(node, obj);
		
		NamedNodeMap attrMap = node.getAttributes();
		if (attrMap != null) {
			Node id = attrMap.getNamedItem(A_ID);
			Node instType = attrMap.getNamedItem(A_INSTTYPE);
			Node instId = attrMap.getNamedItem(A_INSTID);
			Node variableName = attrMap.getNamedItem(A_VARIABLENAME);	
			Node variableType = attrMap.getNamedItem(A_VARIABLETYPE);
			Node variableMode = attrMap.getNamedItem(A_VARIABLEMODE);
			Node variableValue = attrMap.getNamedItem(A_VARIABLEVALUE);
			Node variableReq = attrMap.getNamedItem(A_VARIABLEREQ);

			if (id != null)
				obj.setId(id.getNodeValue());
			if (instType != null)
				obj.setInstType(instType.getNodeValue());
			if (instId != null)
				obj.setInstId(instId.getNodeValue());	
			if (variableName != null)
				obj.setVariableName(variableName.getNodeValue());
			if (variableType != null)
				obj.setVariableType(variableType.getNodeValue());
			if (variableMode != null)
				obj.setVariableMode(variableMode.getNodeValue());	
			if (variableReq != null)
				obj.setVariableReq(variableReq.getNodeValue());
		}
		
		NodeList childNodeList = node.getChildNodes();
		if (childNodeList == null || childNodeList.getLength() == 0)
			return obj;
		for (int i=0; i<childNodeList.getLength(); i++) {
			Node childNode = childNodeList.item(i);
			if (childNode.getNodeType() != Node.ELEMENT_NODE || childNode.getNodeName() == null)
				continue;
			if (childNode.getNodeName().equals(A_VARIABLEVALUE)) {
				obj.setVariableValue(getNodeValue(childNode));
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
	public static InstanceVariable[] add(InstanceVariable[] objs, InstanceVariable obj) {
		if (obj == null)
			return objs;
		int size = 0;
		if (objs != null)
			size = objs.length;
		InstanceVariable[] newObjs = new InstanceVariable[size+1];
		int i;
		for (i=0; i<size; i++)
			newObjs[i] = objs[i];
		newObjs[i] = obj;
		return newObjs;
	}
	public static InstanceVariable[] remove(InstanceVariable[] objs, InstanceVariable obj) {
		if (obj == null)
			return objs;
		int size = 0;
		if (objs != null)
			size = objs.length;
		if (size == 0)
			return objs;
		InstanceVariable[] newObjs = new InstanceVariable[size-1];
		int i;
		int j = 0;
		for (i=0; i<size; i++) {
			if (objs[i].equals(obj))
				continue;
			newObjs[j++] = objs[i];
		}
		return newObjs;
	}
	public static InstanceVariable[] left(InstanceVariable[] objs, InstanceVariable obj) {
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
		InstanceVariable[] newObjs = new InstanceVariable[objs.length];
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
	public static InstanceVariable[] right(InstanceVariable[] objs, InstanceVariable obj) {
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
		InstanceVariable[] newObjs = new InstanceVariable[objs.length];
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
	public String getInstType() {
		return instType;
	}
	public void setInstType(String instType) {
		this.instType = instType;
	}
	public String getInstId() {
		return instId;
	}
	public void setInstId(String instId) {
		this.instId = instId;
	}
	public String getVariableName() {
		return variableName;
	}
	public void setVariableName(String variableName) {
		this.variableName = variableName;
	}
	public String getVariableType() {
		return variableType;
	}
	public void setVariableType(String variableType) {
		this.variableType = variableType;
	}
	public String getVariableMode() {
		return variableMode;
	}
	public void setVariableMode(String variableMode) {
		this.variableMode = variableMode;
	}
	public String getVariableValue() {
		return variableValue;
	}
	public void setVariableValue(String variableValue) {
		this.variableValue = variableValue;
	}
	public String getVariableReq() {
		return variableReq;
	}
	public void setVariableReq(String variableReq) {
		this.variableReq = variableReq;
	}

}