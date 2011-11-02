/*	
 * $Id$
 * created by    : hsshin
 * creation-date : 2011. 11. 2.
 * =========================================================
 * Copyright (c) 2011 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.server.engine.organization.model;

import net.smartworks.model.BaseObject;
import net.smartworks.server.engine.common.util.CommonUtil;
import net.smartworks.server.engine.common.util.XmlUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

public class SwoUser extends BaseObject {

	private static final long serialVersionUID = 1L;
	private static Log logger = LogFactory.getLog(SwoUser.class);
	
	private static final String NAME = CommonUtil.toName(SwoUser.class, PREFIX);

	public static final String A_PASSWORD = "password";
	public static final String A_COMPANYID = "companyId";
	public static final String A_DEPTID = "deptId";
	public static final String A_ROLEID = "roleId";
	public static final String A_AUTHID = "authId";
	public static final String A_EMPNO = "empNo";
	public static final String A_TYPE = "type";
	public static final String A_POSITION = "position";
	public static final String A_EMAIL = "email";
	public static final String A_LANG = "lang";
	public static final String A_STDTIME = "stdTime";
	public static final String A_PICTURE = "picture";
	public static final String A_RETIREE = "retiree";
	public static final String A_MOBILENO = "mobileNo";
	public static final String A_INTERNALNO = "internalNo";

	private String password;
	private String companyId;
	private String deptId;
	private String roleId;
	private String authId;
	private String empNo;
	private String type;
	private String position;
	private String email;	
	private String lang;
	private String stdTime;
	private String picture;
	private String retiree;
	private String mobileNo;
	private String internalNo;
	
	public SwoUser() {
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
		appendAttributeString(A_PASSWORD, password, true, buf);
		appendAttributeString(A_EMAIL, email, buf);
		appendAttributeString(A_LANG, lang, buf);
		appendAttributeString(A_STDTIME, stdTime, buf);
		appendAttributeString(A_COMPANYID, companyId, buf);
		appendAttributeString(A_DEPTID, deptId, buf);
		appendAttributeString(A_ROLEID, roleId, buf);
		appendAttributeString(A_AUTHID, authId, buf);
		appendAttributeString(A_EMPNO, empNo, buf);
		appendAttributeString(A_TYPE, type, buf);
		appendAttributeString(A_POSITION, position, buf);
		appendAttributeString(A_PICTURE, picture, true, buf);
		appendAttributeString(A_RETIREE, retiree, true, buf);
		appendAttributeString(A_MOBILENO, mobileNo, true, buf);
		appendAttributeString(A_INTERNALNO, internalNo, true, buf);
		return buf.toString();
	}
	public String toElementsString(String tab, boolean lite) {
		StringBuffer buf = new StringBuffer();
		buf.append(super.toElementsString(tab, lite));
		return buf.toString();
	}
	public static BaseObject toObject(Node node, BaseObject baseObj) throws Exception {
		if (node == null)
			return null;
		
		SwoUser obj = null;
		if (baseObj == null || !(baseObj instanceof SwoUser))
			obj = new SwoUser();
		else
			obj = (SwoUser)baseObj;
		
		// 부모 attributes, elements 값 설정
		SwoObject.toObject(node, obj);
		
		NamedNodeMap attrMap = node.getAttributes();
		if (attrMap != null) {
			Node password = attrMap.getNamedItem(A_PASSWORD);
			Node email = attrMap.getNamedItem(A_EMAIL);
			Node lang = attrMap.getNamedItem(A_LANG);
			Node stdTime = attrMap.getNamedItem(A_STDTIME);
			Node companyId = attrMap.getNamedItem(A_COMPANYID);
			Node deptId = attrMap.getNamedItem(A_DEPTID);
			Node roleId = attrMap.getNamedItem(A_ROLEID);
			Node authId = attrMap.getNamedItem(A_AUTHID);
			Node empNo = attrMap.getNamedItem(A_EMPNO);
			Node type = attrMap.getNamedItem(A_TYPE);
			Node position = attrMap.getNamedItem(A_POSITION);
			Node picture = attrMap.getNamedItem(A_PICTURE);
			Node retiree = attrMap.getNamedItem(A_RETIREE);
			Node mobileNo = attrMap.getNamedItem("A_MOBILENO");
			Node internalNo = attrMap.getNamedItem("A_INTERNALNO");
			
			if (password != null)
				obj.setPassword(password.getNodeValue());
			if (email != null)
				obj.setEmail(email.getNodeValue());
			if (lang != null)
				obj.setLang(lang.getNodeValue());
			if (stdTime != null)
				obj.setStdTime(stdTime.getNodeValue());
			if (companyId != null)
				obj.setCompanyId(companyId.getNodeValue());
			if (deptId != null)
				obj.setDeptId(deptId.getNodeValue());
			if (roleId != null)
				obj.setRoleId(roleId.getNodeValue());
			if (authId != null)
				obj.setAuthId(authId.getNodeValue());
			if (empNo != null)
				obj.setEmpNo(empNo.getNodeValue());
			if (type != null)
				obj.setType(type.getNodeValue());
			if (position != null)
				obj.setPosition(position.getNodeValue());
			if (picture != null)
				obj.setPicture(picture.getNodeValue());
			if (retiree != null)
				obj.setRetiree(retiree.getNodeValue());
			if (mobileNo != null)
				obj.setMobileNo(mobileNo.getNodeValue());
			if (internalNo != null)
				obj.setInternalNo(internalNo.getNodeValue());
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
	public static SwoUser[] add(SwoUser[] objs, SwoUser obj) {
		if (obj == null)
			return objs;
		int size = 0;
		if (objs != null)
			size = objs.length;
		SwoUser[] newObjs = new SwoUser[size+1];
		int i;
		for (i=0; i<size; i++)
			newObjs[i] = objs[i];
		newObjs[i] = obj;
		return newObjs;
	}
	public static SwoUser[] remove(SwoUser[] objs, SwoUser obj) {
		if (obj == null)
			return objs;
		int size = 0;
		if (objs != null)
			size = objs.length;
		if (size == 0)
			return objs;
		SwoUser[] newObjs = new SwoUser[size-1];
		int i;
		int j = 0;
		for (i=0; i<size; i++) {
			if (objs[i].equals(obj))
				continue;
			newObjs[j++] = objs[i];
		}
		return newObjs;
	}
	public static SwoUser[] left(SwoUser[] objs, SwoUser obj) {
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
		SwoUser[] newObjs = new SwoUser[objs.length];
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
	public static SwoUser[] right(SwoUser[] objs, SwoUser obj) {
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
		SwoUser[] newObjs = new SwoUser[objs.length];
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
	public String getEmpNo() {
		return empNo;
	}
	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}
	public String getDeptId() {
		return deptId;
	}
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getAuthId() {
		return authId;
	}
	public void setAuthId(String authId) {
		this.authId = authId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String passwd) {
		this.password = passwd;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLang() {
		return this.lang;
	}
	public String getStdTime() {
		return this.stdTime;
	}
	public void setLang(String lang) {
		this.lang = lang;
	}
	public void setStdTime(String stdTime) {
		this.stdTime = stdTime;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getRetiree() {
		return retiree;
	}
	public void setRetiree(String retiree) {
		this.retiree = retiree;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getInternalNo() {
		return internalNo;
	}
	public void setInternalNo(String internalNo) {
		this.internalNo = internalNo;
	}

}