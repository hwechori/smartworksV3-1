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

public class SwfMapping extends BaseObject {

	private static final long serialVersionUID = 1L;
	private static Log logger = LogFactory.getLog(SwfMapping.class);
	
	protected static final String PREFIX = "Swf";
	private static final String NAME = CommonUtil.toName(SwfMapping.class, PREFIX);
	
	public static final String A_TYPE = "type";
	public static final String A_EACHTIME = "eachTime";
	
	public static final String A_MAPPINGFORMID = "mappingFormId";
	public static final String A_MAPPINGFORMTYPE = "mappingFormType";
	public static final String A_FORMNAME = "formName";
	public static final String A_FIELDID = "fieldId";
	public static final String A_FIELDNAME = "fieldName";
	public static final String A_VALUEFUNC = "valueFunc";
	public static final String A_FIELDMAPPINGS = "fieldMappings";
	public static final String A_FIELDMAPPING = "fieldMapping";
	
	public static final String TYPE_SIMPLE = "mapping_form";
	public static final String TYPE_EXPRESSION = "expression";

	public static final String MAPPINGTYPE_SELFFORM = "self_form";
	public static final String MAPPINGTYPE_OTHERFORM = "info_form";
	public static final String MAPPINGTYPE_PROCESSFORM = "process_form";
	public static final String MAPPINGTYPE_SYSTEM = "system_form";
	public static final String MAPPINGSERVICEID = "mappingServiceId";
	
	private String type;
	private boolean eachTime = false;
	
	private String mappingFormId;
	private String mappingFormType;
	private String formName;
	private String fieldId;
	private String fieldName;
	private String valueFunc;
	private String mappingServiceId;

	private String expression;
	private SwfFieldMapping[] fieldMappings;
	public SwfMapping() {
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
		appendAttributeString(A_EACHTIME, eachTime, buf);
		appendAttributeString(A_MAPPINGFORMID, mappingFormId, buf);
		appendAttributeString(A_MAPPINGFORMTYPE, mappingFormType, buf);
		appendAttributeString(A_FORMNAME, formName, true, buf);
		appendAttributeString(A_FIELDID, fieldId, buf);
		appendAttributeString(A_FIELDNAME, fieldName, true, buf);
		appendAttributeString(A_VALUEFUNC, valueFunc, buf);
		appendAttributeString(MAPPINGSERVICEID, mappingServiceId, buf);
		return buf.toString();
	}
	public String toElementsString(String tab, boolean lite) {
		StringBuffer buf = new StringBuffer();
		buf.append(super.toElementsString(tab, lite));
		appendElementString(null, expression, tab, buf);
		if (lite) {
			appendElementsString(null, A_FIELDMAPPING, getFieldMappings(), tab, lite, buf);
		} else {
			appendElementsString(A_FIELDMAPPINGS, A_FIELDMAPPING, getFieldMappings(), tab, lite, buf);
		}
		return buf.toString();
	}
	public static BaseObject toObject(Node node, BaseObject baseObj) throws Exception {
		if (node == null)
			return null;
		
		SwfMapping obj = null;
		if (baseObj == null || !(baseObj instanceof SwfMapping))
			obj = new SwfMapping();
		else
			obj = (SwfMapping)baseObj;
		
		// 부모 attributes, elements 값 설정
		BaseObject.toObject(node, obj);
		
		NamedNodeMap attrMap = node.getAttributes();
		if (attrMap != null) {
			Node type = attrMap.getNamedItem(A_TYPE);
			Node eachTime = attrMap.getNamedItem(A_EACHTIME);
			Node mappingFormId = attrMap.getNamedItem(A_MAPPINGFORMID);
			Node mappingFormType = attrMap.getNamedItem(A_MAPPINGFORMTYPE);
			Node formName = attrMap.getNamedItem(A_FORMNAME);
			Node fieldId = attrMap.getNamedItem(A_FIELDID);
			Node fieldName = attrMap.getNamedItem(A_FIELDNAME);
			Node valueFunc = attrMap.getNamedItem(A_VALUEFUNC);
			Node mappingServiceId = attrMap.getNamedItem(MAPPINGSERVICEID);
			if (type != null)
				obj.setType(type.getNodeValue());
			if (eachTime != null)
				obj.setEachTime(CommonUtil.toBoolean(eachTime.getNodeValue()));
			if (mappingFormId != null)
				obj.setMappingFormId(mappingFormId.getNodeValue());
			if (mappingFormType != null)
				obj.setMappingFormType(mappingFormType.getNodeValue());
			if (formName != null)
				obj.setFormName(formName.getNodeValue());
			if (fieldId != null)
				obj.setFieldId(fieldId.getNodeValue());
			if (fieldName != null)
				obj.setFieldName(fieldName.getNodeValue());
			if (valueFunc != null)
				obj.setValueFunc(valueFunc.getNodeValue());
			if (mappingServiceId != null)
				obj.setMappingServiceId(mappingServiceId.getNodeValue());
		}
		
		// elements 값 설정
		NodeList childNodeList = node.getChildNodes();
		if (childNodeList == null || childNodeList.getLength() == 0)
			return obj;
		boolean textFilled = false;
		for (int i=0; i<childNodeList.getLength(); i++) {
			Node childNode = childNodeList.item(i);
			short nodeType = childNode.getNodeType();
			if (nodeType == Node.TEXT_NODE || nodeType == Node.CDATA_SECTION_NODE) {
				if (textFilled)
					continue;
				obj.setExpression(getNodeValue(childNode));
				textFilled = true;
				continue;
			}
			if (nodeType != Node.ELEMENT_NODE || childNode.getNodeName() == null)
				continue;
			if (childNode.getNodeName().equals(A_FIELDMAPPINGS)) {
				Node[] nodes = getNodes(childNode);
				if (nodes == null || nodes.length == 0)
					continue;
				SwfFieldMapping[] objs = new SwfFieldMapping[nodes.length];
				for (int j=0; j<nodes.length; j++)
					objs[j] = (SwfFieldMapping)SwfFieldMapping.toObject(nodes[j], null);
				obj.setFieldMappings(objs);
//			} else if (childNode.getNodeName().equals(A_FIELDMAPPING)) {
//				obj.addFieldMapping((SwfFieldMapping)SwfFieldMapping.toObject(childNode, null));
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
	public static SwfMapping[] add(SwfMapping[] objs, SwfMapping obj) {
		if (obj == null)
			return objs;
		int size = 0;
		if (objs != null)
			size = objs.length;
		SwfMapping[] newObjs = new SwfMapping[size+1];
		int i;
		for (i=0; i<size; i++)
			newObjs[i] = objs[i];
		newObjs[i] = obj;
		return newObjs;
	}
	public static SwfMapping[] remove(SwfMapping[] objs, SwfMapping obj) {
		if (obj == null)
			return objs;
		int size = 0;
		if (objs != null)
			size = objs.length;
		if (size == 0)
			return objs;
		SwfMapping[] newObjs = new SwfMapping[size-1];
		int i;
		int j = 0;
		for (i=0; i<size; i++) {
			if (objs[i].equals(obj))
				continue;
			newObjs[j++] = objs[i];
		}
		return newObjs;
	}
	public static SwfMapping[] left(SwfMapping[] objs, SwfMapping obj) {
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
		SwfMapping[] newObjs = new SwfMapping[objs.length];
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
	public static SwfMapping[] right(SwfMapping[] objs, SwfMapping obj) {
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
		SwfMapping[] newObjs = new SwfMapping[objs.length];
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
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public String getFormName() {
		return formName;
	}
	public void setFormName(String formName) {
		this.formName = formName;
	}
	public String getMappingFormId() {
		return mappingFormId;
	}
	public void setMappingFormId(String mappingFormId) {
		this.mappingFormId = mappingFormId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getMappingFormType() {
		return mappingFormType;
	}
	public void setMappingFormType(String mappingFormType) {
		this.mappingFormType = mappingFormType;
	}
	public String getValueFunc() {
		return valueFunc;
	}
	public void setValueFunc(String valueFunc) {
		this.valueFunc = valueFunc;
	}
	public SwfFieldMapping[] getFieldMappings() {
		return fieldMappings;
	}
	public void setFieldMappings(SwfFieldMapping[] fieldMappings) {
		this.fieldMappings = fieldMappings;
	}
	public boolean isEachTime() {
		return eachTime;
	}
	public void setEachTime(boolean eachTime) {
		this.eachTime = eachTime;
	}
	public String getMappingServiceId() {
		return mappingServiceId;
	}
	public void setMappingServiceId(String mappingServiceId) {
		this.mappingServiceId = mappingServiceId;
	}

}