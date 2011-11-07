/*	
 * $Id$
 * created by    : hsshin
 * creation-date : 2011. 11. 7.
 * =========================================================
 * Copyright (c) 2011 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.server.engine.infowork.domain.model;

import net.smartworks.server.engine.common.model.BaseObject;
import net.smartworks.server.engine.common.model.ClassObject;
import net.smartworks.server.engine.common.util.CommonUtil;
import net.smartworks.server.engine.common.util.XmlUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

public class SwdField extends ClassObject {

	private static final long serialVersionUID = 1L;
	private static Log logger = LogFactory.getLog(SwdField.class);
	
	protected static final String PREFIX = "Swd";
	private static final String NAME = CommonUtil.toName(SwdField.class, PREFIX);

	public static final String A_FORMFIELDID = "formFieldId";
	public static final String A_FORMFIELDPATH = "formFieldPath";
	public static final String A_FORMFIELDNAME = "formFieldName";
	public static final String A_FORMFIELDTYPE = "formFieldType";
	public static final String A_TABLECOLUMNNAME = "tableColumnName";
	public static final String A_ISARRAY = "isArray";
	public static final String A_ISSYSTEMFIELD = "isSystemField";
	public static final String A_DISPLAYORDER = "displayOrder";
	public static final String A_TABLEWIDTH = "tableWidth";

	private String formFieldId;
	private String formFieldPath;
	private String formFieldName;
	private String formFieldType;
	private String tableColumnName;
	private String arrayYn;
	private String systemFieldYn;
	private int displayOrder;
	private float tableWidth;
	private SwdDomain domain;
	public SwdField() {
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
		appendAttributeString(A_FORMFIELDID, formFieldId, buf);
		appendAttributeString(A_FORMFIELDPATH, formFieldPath, buf);
		appendAttributeString(A_FORMFIELDNAME, formFieldName, true, buf);
		appendAttributeString(A_FORMFIELDTYPE, formFieldType, buf);
		appendAttributeString(A_TABLECOLUMNNAME, tableColumnName, buf);
		appendAttributeString(A_ISARRAY, isArray(), buf);
		appendAttributeString(A_ISSYSTEMFIELD, isSystemField(), buf);
		appendAttributeString(A_DISPLAYORDER, displayOrder, buf);
		appendAttributeString(A_TABLEWIDTH, tableWidth, buf);
		return buf.toString();
	}
	public static BaseObject toObject(Node node, BaseObject baseObj) throws Exception {
		if (node == null)
			return null;
		
		SwdField obj = null;
		if (baseObj == null || !(baseObj instanceof SwdField))
			obj = new SwdField();
		else
			obj = (SwdField)baseObj;
		
		// 부모 attributes, elements 값 설정
		ClassObject.toObject(node, obj);
		
		NamedNodeMap attrMap = node.getAttributes();
		if (attrMap != null) {
			Node formFieldId = attrMap.getNamedItem(A_FORMFIELDID);
			Node formFieldPath = attrMap.getNamedItem(A_FORMFIELDPATH);
			Node formFieldName = attrMap.getNamedItem(A_FORMFIELDNAME);
			Node formFieldType = attrMap.getNamedItem(A_FORMFIELDTYPE);
			Node tableColumnName = attrMap.getNamedItem(A_TABLECOLUMNNAME);
			Node isArray = attrMap.getNamedItem(A_ISARRAY);
			Node isSystemField = attrMap.getNamedItem(A_ISSYSTEMFIELD);
			Node displayOrder = attrMap.getNamedItem(A_DISPLAYORDER);
			Node tableWidth = attrMap.getNamedItem(A_TABLEWIDTH);
			if (formFieldId != null)
				obj.setFormFieldId(formFieldId.getNodeValue());
			if (formFieldPath != null)
				obj.setFormFieldPath(formFieldPath.getNodeValue());
			if (formFieldName != null)
				obj.setFormFieldName(formFieldName.getNodeValue());
			if (formFieldType != null)
				obj.setFormFieldType(formFieldType.getNodeValue());
			if (tableColumnName != null)
				obj.setTableColumnName(tableColumnName.getNodeValue());
			if (isArray != null)
				obj.setArray(CommonUtil.toBoolean(isArray.getNodeValue()));
			if (isSystemField != null)
				obj.setSystemField(CommonUtil.toBoolean(isSystemField.getNodeValue()));
			if (displayOrder != null)
				obj.setDisplayOrder(CommonUtil.toInt(displayOrder.getNodeValue()));
			if (tableWidth != null)
				obj.setTableWidth(CommonUtil.toFloat(tableWidth.getNodeValue()));
		}
		
		// elements 값 설정
		
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
	public static SwdField[] add(SwdField[] objs, SwdField obj) {
		if (obj == null)
			return objs;
		int size = 0;
		if (objs != null)
			size = objs.length;
		SwdField[] newObjs = new SwdField[size+1];
		int i;
		for (i=0; i<size; i++)
			newObjs[i] = objs[i];
		newObjs[i] = obj;
		return newObjs;
	}
	public static SwdField[] remove(SwdField[] objs, SwdField obj) {
		if (obj == null)
			return objs;
		int size = 0;
		if (objs != null)
			size = objs.length;
		if (size == 0)
			return objs;
		SwdField[] newObjs = new SwdField[size-1];
		int i;
		int j = 0;
		for (i=0; i<size; i++) {
			if (objs[i].equals(obj))
				continue;
			newObjs[j++] = objs[i];
		}
		return newObjs;
	}
	public static SwdField[] left(SwdField[] objs, SwdField obj) {
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
		SwdField[] newObjs = new SwdField[objs.length];
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
	public static SwdField[] right(SwdField[] objs, SwdField obj) {
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
		SwdField[] newObjs = new SwdField[objs.length];
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
	public int getDisplayOrder() {
		return displayOrder;
	}
	public void setDisplayOrder(int displayOrder) {
		this.displayOrder = displayOrder;
	}
	public String getFormFieldId() {
		return formFieldId;
	}
	public void setFormFieldId(String formFieldId) {
		this.formFieldId = formFieldId;
	}
	public String getFormFieldName() {
		return formFieldName;
	}
	public void setFormFieldName(String formFieldName) {
		this.formFieldName = formFieldName;
	}
	public String getFormFieldPath() {
		return formFieldPath;
	}
	public void setFormFieldPath(String formFieldPath) {
		this.formFieldPath = formFieldPath;
	}
	public String getFormFieldType() {
		return formFieldType;
	}
	public void setFormFieldType(String formFieldType) {
		this.formFieldType = formFieldType;
	}
	public boolean isArray() {
		return arrayYn != null && arrayYn.equals("Y");
	}
	public void setArray(boolean isArray) {
		this.arrayYn = isArray? "Y":"N";
	}
	public boolean isSystemField() {
		return systemFieldYn != null && systemFieldYn.equals("Y");
	}
	public void setSystemField(boolean isSystemField) {
		this.systemFieldYn = isSystemField? "Y":"N";
	}
	public String getTableColumnName() {
		return tableColumnName;
	}
	public void setTableColumnName(String tableColumnName) {
		this.tableColumnName = tableColumnName;
	}
	public float getTableWidth() {
		return tableWidth;
	}
	public void setTableWidth(float tableWidth) {
		this.tableWidth = tableWidth;
	}
	public SwdDomain getDomain() {
		return domain;
	}
	public void setDomain(SwdDomain domain) {
		this.domain = domain;
	}

}