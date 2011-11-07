/*	
 * $Id$
 * created by    : maninsoft
 * creation-date : 2011. 11. 2.
 * =========================================================
 * Copyright (c) 2011 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.server.engine.organization.model;

import net.smartworks.server.engine.common.model.BaseObject;
import net.smartworks.server.engine.common.util.CommonUtil;
import net.smartworks.server.engine.common.util.XmlUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

public class SwoContact extends SwoObject {

	private static final long serialVersionUID = 1L;
	private static Log logger = LogFactory.getLog(SwoContact.class);
	
	private static final String NAME = CommonUtil.toName(SwoContact.class, PREFIX);

	public static final String A_COMPANYID = "companyId";
	public static final String A_DEPTID = "deptId";
	public static final String A_POSITION = "position";
	public static final String A_EMAIL = "email";
	public static final String A_TELEPHONE = "telephone";
	
	private String companyId;
	private String deptId;
	private String position;
	private String email;
	private String telephone;

	public SwoContact() {
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
		appendAttributeString(A_COMPANYID, companyId, buf);
		appendAttributeString(A_DEPTID, deptId, buf);
		appendAttributeString(A_POSITION, position, buf);
		appendAttributeString(A_EMAIL, email, buf);
		appendAttributeString(A_TELEPHONE, telephone, buf);
		return buf.toString();
	}
	public static BaseObject toObject(Node node, BaseObject baseObj) throws Exception {
		if (node == null)
			return null;
		
		SwoContact obj = null;
		if (baseObj == null || !(baseObj instanceof SwoContact))
			obj = new SwoContact();
		else
			obj = (SwoContact)baseObj;
		
		// 부모 attributes, elements 값 설정
		SwoObject.toObject(node, obj);
		
		NamedNodeMap attrMap = node.getAttributes();
		if (attrMap != null) {
			Node companyId = attrMap.getNamedItem(A_COMPANYID);
			Node deptId = attrMap.getNamedItem(A_DEPTID);
			Node pos = attrMap.getNamedItem(A_POSITION);
			Node email = attrMap.getNamedItem(A_EMAIL);
			Node telephone = attrMap.getNamedItem(A_TELEPHONE);
			if (companyId != null)
				obj.setCompanyId(companyId.getNodeValue());
			if (deptId != null)
				obj.setDeptId(deptId.getNodeValue());
			if (pos != null)
				obj.setPosition(pos.getNodeValue());
			if (email != null)
				obj.setEmail(email.getNodeValue());
			if (telephone != null)
				obj.setTelephone(telephone.getNodeValue());
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
	public static SwoContact[] add(SwoContact[] objs, SwoContact obj) {
		if (obj == null)
			return objs;
		int size = 0;
		if (objs != null)
			size = objs.length;
		SwoContact[] newObjs = new SwoContact[size+1];
		int i;
		for (i=0; i<size; i++)
			newObjs[i] = objs[i];
		newObjs[i] = obj;
		return newObjs;
	}
	public static SwoContact[] remove(SwoContact[] objs, SwoContact obj) {
		if (obj == null)
			return objs;
		int size = 0;
		if (objs != null)
			size = objs.length;
		if (size == 0)
			return objs;
		SwoContact[] newObjs = new SwoContact[size-1];
		int i;
		int j = 0;
		for (i=0; i<size; i++) {
			if (objs[i].equals(obj))
				continue;
			newObjs[j++] = objs[i];
		}
		return newObjs;
	}
	public static SwoContact[] left(SwoContact[] objs, SwoContact obj) {
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
		SwoContact[] newObjs = new SwoContact[objs.length];
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
	public static SwoContact[] right(SwoContact[] objs, SwoContact obj) {
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
		SwoContact[] newObjs = new SwoContact[objs.length];
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
	
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public String getDeptId() {
		return deptId;
	}
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String pos) {
		this.position = pos;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

}