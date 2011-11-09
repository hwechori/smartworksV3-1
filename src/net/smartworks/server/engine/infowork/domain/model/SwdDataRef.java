/*	
 * $Id$
 * created by    : maninsoft
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

public class SwdDataRef extends ClassObject {

	private static final long serialVersionUID = 1L;
	private static Log logger = LogFactory.getLog(SwdDataRef.class);
	
	protected static final String PREFIX = "Swd";
	private static final String NAME = CommonUtil.toName(SwdDataRef.class, PREFIX);

	public static final String A_MYFORMID = "myFormId";
	public static final String A_MYFORMFIELDID = "myFormFieldId";
	public static final String A_MYRECORDID = "myRecordId";
	public static final String A_REFFORMID = "refFormId";
	public static final String A_REFFORMFIELDID = "refFormFieldId";
	public static final String A_REFRECORDID = "refRecordId";
	
	private String myFormId;
	private String myFormFieldId;
	private String myRecordId;
	private String refFormId;
	private String refFormFieldId;
	private String refRecordId;
	
	public SwdDataRef() {
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
		appendAttributeString(A_MYFORMID, myFormId, buf);
		appendAttributeString(A_MYFORMFIELDID, myFormFieldId, buf);
		appendAttributeString(A_MYRECORDID, myRecordId, true, buf);
		appendAttributeString(A_REFFORMID, refFormId, buf);
		appendAttributeString(A_REFFORMFIELDID, refFormFieldId, buf);
		appendAttributeString(A_REFRECORDID, refRecordId, buf);
		return buf.toString();
	}
	public static BaseObject toObject(Node node, BaseObject baseObj) throws Exception {
		if (node == null)
			return null;
		
		SwdDataRef obj = null;
		if (baseObj == null || !(baseObj instanceof SwdDataRef))
			obj = new SwdDataRef();
		else
			obj = (SwdDataRef)baseObj;
		
		ClassObject.toObject(node, obj);
		
		NamedNodeMap attrMap = node.getAttributes();
		if (attrMap != null) {
			Node myFormId = attrMap.getNamedItem(A_MYFORMID);
			Node myFormFieldId = attrMap.getNamedItem(A_MYFORMFIELDID);
			Node myRecordId = attrMap.getNamedItem(A_MYRECORDID);
			Node refFormId = attrMap.getNamedItem(A_REFFORMID);
			Node refFormFieldId = attrMap.getNamedItem(A_REFFORMFIELDID);
			Node refRecordId = attrMap.getNamedItem(A_REFRECORDID);
			if (myFormId != null)
				obj.setMyFormId(myFormId.getNodeValue());
			if (myFormFieldId != null)
				obj.setMyFormFieldId(myFormFieldId.getNodeValue());
			if (myRecordId != null)
				obj.setMyRecordId(myRecordId.getNodeValue());
			if (refFormId != null)
				obj.setRefFormId(refFormId.getNodeValue());
			if (refFormFieldId != null)
				obj.setRefFormFieldId(refFormFieldId.getNodeValue());
			if (refRecordId != null)
				obj.setRefRecordId(refRecordId.getNodeValue());
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
	public static SwdDataRef[] add(SwdDataRef[] objs, SwdDataRef obj) {
		if (obj == null)
			return objs;
		int size = 0;
		if (objs != null)
			size = objs.length;
		SwdDataRef[] newObjs = new SwdDataRef[size+1];
		int i;
		for (i=0; i<size; i++)
			newObjs[i] = objs[i];
		newObjs[i] = obj;
		return newObjs;
	}
	public static SwdDataRef[] remove(SwdDataRef[] objs, SwdDataRef obj) {
		if (obj == null)
			return objs;
		int size = 0;
		if (objs != null)
			size = objs.length;
		if (size == 0)
			return objs;
		SwdDataRef[] newObjs = new SwdDataRef[size-1];
		int i;
		int j = 0;
		for (i=0; i<size; i++) {
			if (objs[i].equals(obj))
				continue;
			newObjs[j++] = objs[i];
		}
		return newObjs;
	}
	public static SwdDataRef[] left(SwdDataRef[] objs, SwdDataRef obj) {
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
		SwdDataRef[] newObjs = new SwdDataRef[objs.length];
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
	public static SwdDataRef[] right(SwdDataRef[] objs, SwdDataRef obj) {
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
		SwdDataRef[] newObjs = new SwdDataRef[objs.length];
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
	
	public String getMyFormFieldId() {
		return myFormFieldId;
	}
	public void setMyFormFieldId(String myFormField) {
		this.myFormFieldId = myFormField;
	}
	public String getMyFormId() {
		return myFormId;
	}
	public void setMyFormId(String myFormId) {
		this.myFormId = myFormId;
	}
	public String getMyRecordId() {
		return myRecordId;
	}
	public void setMyRecordId(String myRecordId) {
		this.myRecordId = myRecordId;
	}
	public String getRefFormFieldId() {
		return refFormFieldId;
	}
	public void setRefFormFieldId(String refFormField) {
		this.refFormFieldId = refFormField;
	}
	public String getRefFormId() {
		return refFormId;
	}
	public void setRefFormId(String refFormId) {
		this.refFormId = refFormId;
	}
	public String getRefRecordId() {
		return refRecordId;
	}
	public void setRefRecordId(String refRecordId) {
		this.refRecordId = refRecordId;
	}

}