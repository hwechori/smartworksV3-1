/*	
 * $Id$
 * created by    : maninsoft
 * creation-date : 2011. 11. 7.
 * =========================================================
 * Copyright (c) 2011 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.server.engine.infowork.domain.model;

import java.util.List;
import java.util.Map;

import net.smartworks.server.engine.common.model.BaseObject;
import net.smartworks.server.engine.common.util.CommonUtil;
import net.smartworks.server.engine.common.util.XmlUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class SwdDataField extends BaseObject {

	private static final long serialVersionUID = 1L;
	private static Log logger = LogFactory.getLog(SwdDataField.class);
	
	protected static final String PREFIX = "Swd";
	private static final String NAME = CommonUtil.toName(SwdDataField.class, PREFIX);

	public static final String A_ID = "id";
	public static final String A_NAME = "name";
	public static final String A_TYPE = "type";
	public static final String A_ROW = "row";
	public static final String A_REFFORM = "refForm";
	public static final String A_REFFORMFIELD = "refFormField";
	public static final String A_REFRECORDID = "refRecordId";
	public static final String A_DATAFIELD = "DataField";
	
	private String id;
	private String name;
	private String type;
	private int row;
	private String refForm;
	private String refFormField;
	private String refRecordId;
	
	private String value;
	private List<Map<String, String>> users;

	public List<Map<String, String>> getUsers() {
		return users;
	}
	public void setUsers(List<Map<String, String>> users) {
		this.users = users;
	}
	private int displayOrder;

	public int getDisplayOrder() {
		return displayOrder;
	}
	public void setDisplayOrder(int displayOrder) {
		this.displayOrder = displayOrder;
	}
	public String getId() {
		return id;
	}
	private SwdDataField[] dataFields;
	public SwdDataField() {
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
		appendAttributeString(A_TYPE, type, buf);
		appendAttributeString(A_ROW, row, buf);
		appendAttributeString(A_REFFORM, refForm, buf);
		appendAttributeString(A_REFFORMFIELD, refFormField, buf);
		appendAttributeString(A_REFRECORDID, refRecordId, buf);
		return buf.toString();
	}
	public String toElementsString(String tab, boolean lite) {
		StringBuffer buf = new StringBuffer();
		buf.append(super.toElementsString(tab, lite));
		appendElementString(null, value, tab, true, buf);
		appendElementsString(null, A_DATAFIELD, getDataFields(), tab, lite, buf);
		return buf.toString();
	}
	public static BaseObject toObject(Node node, BaseObject baseObj) throws Exception {
		if (node == null)
			return null;
		
		SwdDataField obj = null;
		if (baseObj == null || !(baseObj instanceof SwdDataField))
			obj = new SwdDataField();
		else
			obj = (SwdDataField)baseObj;
		
		// 부모 attributes, elements 값 설정
		BaseObject.toObject(node, obj);
		
		NamedNodeMap attrMap = node.getAttributes();
		if (attrMap != null) {
			Node id = attrMap.getNamedItem(A_ID);
			Node name = attrMap.getNamedItem(A_NAME);
			Node type = attrMap.getNamedItem(A_TYPE);
			Node row = attrMap.getNamedItem(A_ROW);
			Node refForm = attrMap.getNamedItem(A_REFFORM);
			Node refFormField = attrMap.getNamedItem(A_REFFORMFIELD);
			Node refRecordId = attrMap.getNamedItem(A_REFRECORDID);
			if (id != null)
				obj.setId(id.getNodeValue());
			if (name != null)
				obj.setName(name.getNodeValue());
			if (type != null)
				obj.setType(type.getNodeValue());
			if (row != null)
				obj.setRow(CommonUtil.toInt(row.getNodeValue()));
			if (refForm != null)
				obj.setRefForm(refForm.getNodeValue());
			if (refFormField != null)
				obj.setRefFormField(refFormField.getNodeValue());
			if (refRecordId != null)
				obj.setRefRecordId(refRecordId.getNodeValue());
		}
		
		// elements 값 설정
		NodeList childNodeList = node.getChildNodes();
		if (childNodeList == null || childNodeList.getLength() == 0)
			return obj;
		boolean valueSetted = false;
		for (int i=0; i<childNodeList.getLength(); i++) {
			Node childNode = childNodeList.item(i);
			if (!valueSetted && (childNode.getNodeType() == Node.TEXT_NODE || childNode.getNodeType() == Node.CDATA_SECTION_NODE)) {
				String value = getNodeValue(childNode, true);
				if (CommonUtil.isEmpty(value))
					continue;
				obj.setValue(value);
				break;
			} else if (childNode.getNodeType() != Node.ELEMENT_NODE || childNode.getNodeName() == null) {
				continue;
			}
			if (childNode.getNodeName().equals(A_DATAFIELD)) {
				obj.addDataField((SwdDataField)SwdDataField.toObject(childNode, null));
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
	public static SwdDataField[] add(SwdDataField[] objs, SwdDataField obj) {
		if (obj == null)
			return objs;
		int size = 0;
		if (objs != null)
			size = objs.length;
		SwdDataField[] newObjs = new SwdDataField[size+1];
		int i;
		for (i=0; i<size; i++)
			newObjs[i] = objs[i];
		newObjs[i] = obj;
		return newObjs;
	}
	public static SwdDataField[] remove(SwdDataField[] objs, SwdDataField obj) {
		if (obj == null)
			return objs;
		int size = 0;
		if (objs != null)
			size = objs.length;
		if (size == 0)
			return objs;
		SwdDataField[] newObjs = new SwdDataField[size-1];
		int i;
		int j = 0;
		for (i=0; i<size; i++) {
			if (objs[i].equals(obj))
				continue;
			newObjs[j++] = objs[i];
		}
		return newObjs;
	}
	public static SwdDataField[] left(SwdDataField[] objs, SwdDataField obj) {
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
		SwdDataField[] newObjs = new SwdDataField[objs.length];
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
	public static SwdDataField[] right(SwdDataField[] objs, SwdDataField obj) {
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
		SwdDataField[] newObjs = new SwdDataField[objs.length];
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
	public void addDataField(SwdDataField dataField) {
		this.setDataFields(SwdDataField.add(this.getDataFields(), dataField));
	}
	public SwdDataField[] getDataFields() {
		return dataFields;
	}
	public void setDataFields(SwdDataField[] dataFields) {
		this.dataFields = dataFields;
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
	public String getRefForm() {
		return refForm;
	}
	public void setRefForm(String refForm) {
		this.refForm = refForm;
	}
	public String getRefFormField() {
		return refFormField;
	}
	public void setRefFormField(String refFormField) {
		this.refFormField = refFormField;
	}
	public String getRefRecordId() {
		return refRecordId;
	}
	public void setRefRecordId(String refRecordId) {
		this.refRecordId = refRecordId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public int getRow() {
		return row;
	}
	public void setRow(int rowCnt) {
		this.row = rowCnt;
	}

}