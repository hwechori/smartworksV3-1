/*	
 * $Id$
 * created by    : hsshin
 * creation-date : 2011. 11. 9.
 * =========================================================
 * Copyright (c) 2011 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.server.engine.config.model;

import net.smartworks.server.engine.common.model.BaseObject;
import net.smartworks.server.engine.common.model.MisObjectCond;
import net.smartworks.server.engine.common.util.CommonUtil;
import net.smartworks.server.engine.common.util.XmlUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

public class SwcExternalFormParameterCond extends MisObjectCond {

	private static final long serialVersionUID = 1L;
	private static Log logger = LogFactory.getLog(SwcExternalFormParameterCond.class);
	
	protected static final String PREFIX = "Swc";
	private static final String NAME = CommonUtil.toName(SwcExternalFormParameterCond.class, PREFIX);
	
	public static final String A_PARAMETERNAME = "parameterName";
	public static final String A_PARAMETERTYPE = "parameterType";
	public static final String A_VARIABLENAME = "variableName";
	public static final String A_TYPE = "type";
	
	private String parameterName;
	private String parameterType;
	private String variableName;
	private String type;
	
	public SwcExternalFormParameterCond() {
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
		appendAttributeString(A_PARAMETERNAME, parameterName, buf);
		appendAttributeString(A_PARAMETERTYPE, parameterType, buf);
		appendAttributeString(A_VARIABLENAME, variableName, buf);
		appendAttributeString(A_TYPE, type, buf);
		return buf.toString();
	}
	public static BaseObject toObject(Node node, BaseObject baseObj) throws Exception {
		if (node == null)
			return null;
		
		SwcExternalFormParameterCond obj = null;
		if (baseObj == null || !(baseObj instanceof SwcExternalFormParameterCond))
			obj = new SwcExternalFormParameterCond();
		else
			obj = (SwcExternalFormParameterCond)baseObj;
		
		//부모 attributes, elements 값 설정
		MisObjectCond.toObject(node, obj);
		
		NamedNodeMap attrMap = node.getAttributes();
		if (attrMap != null) {
			Node parameterName = attrMap.getNamedItem(A_PARAMETERNAME);
			Node parameterType = attrMap.getNamedItem(A_PARAMETERTYPE);
			Node variableName = attrMap.getNamedItem(A_VARIABLENAME);
			Node type = attrMap.getNamedItem(A_TYPE);
			if (parameterName != null)
				obj.setParameterName(parameterName.getNodeValue());
			if (parameterType != null)
				obj.setParameterType(parameterType.getNodeValue());
			if (variableName != null)
				obj.setVariableName(variableName.getNodeValue());
			if (type != null)
				obj.setType(type.getNodeValue());
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
	public static SwcExternalFormParameterCond[] add(SwcExternalFormParameterCond[] objs, SwcExternalFormParameterCond obj) {
		if (obj == null)
			return objs;
		int size = 0;
		if (objs != null)
			size = objs.length;
		SwcExternalFormParameterCond[] newObjs = new SwcExternalFormParameterCond[size+1];
		int i;
		for (i=0; i<size; i++)
			newObjs[i] = objs[i];
		newObjs[i] = obj;
		return newObjs;
	}
	public static SwcExternalFormParameterCond[] remove(SwcExternalFormParameterCond[] objs, SwcExternalFormParameterCond obj) {
		if (obj == null)
			return objs;
		int size = 0;
		if (objs != null)
			size = objs.length;
		if (size == 0)
			return objs;
		SwcExternalFormParameterCond[] newObjs = new SwcExternalFormParameterCond[size-1];
		int i;
		int j = 0;
		for (i=0; i<size; i++) {
			if (objs[i].equals(obj))
				continue;
			newObjs[j++] = objs[i];
		}
		return newObjs;
	}
	public static SwcExternalFormParameterCond[] left(SwcExternalFormParameterCond[] objs, SwcExternalFormParameterCond obj) {
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
		SwcExternalFormParameterCond[] newObjs = new SwcExternalFormParameterCond[objs.length];
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
	public static SwcExternalFormParameterCond[] right(SwcExternalFormParameterCond[] objs, SwcExternalFormParameterCond obj) {
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
		SwcExternalFormParameterCond[] newObjs = new SwcExternalFormParameterCond[objs.length];
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
	public String getParameterName() {
		return parameterName;
	}

	public void setParameterName(String parameterName) {
		this.parameterName = parameterName;
	}

	public String getParameterType() {
		return parameterType;
	}

	public void setParameterType(String parameterType) {
		this.parameterType = parameterType;
	}

	public String getVariableName() {
		return variableName;
	}

	public void setVariableName(String variableName) {
		this.variableName = variableName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}