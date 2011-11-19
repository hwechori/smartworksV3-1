/*	
 * $Id$
 * created by    : hsshin
 * creation-date : 2011. 11. 18.
 * =========================================================
 * Copyright (c) 2011 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.server.engine.basicwork.addressbook.model;

import net.smartworks.server.engine.common.model.BaseObject;
import net.smartworks.server.engine.common.model.MisObject;
import net.smartworks.server.engine.common.util.CommonUtil;
import net.smartworks.server.engine.common.util.XmlUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

/**
 * 주소록(연락처) 모델 클래스 : 이메일에서의 주소록으로 함께 쓰임. 
 * @author : hsshin
 * @version : v 1.0
 * @description :
 */
public class AddressBook extends MisObject {

	private static final long serialVersionUID = 1L;
	private static Log logger = LogFactory.getLog(AddressBook.class);
	
	private static final String NAME = CommonUtil.toName(AddressBook.class, PREFIX);

	public static final String A_DEPTID = "deptId";
	public static final String A_POSITION = "position";
	public static final String A_MOBILE = "mobile";
	public static final String A_TELEPHONE = "telephone";
	public static final String A_FAX = "fax";
	public static final String A_EMAIL = "email";
	public static final String A_MESSENGER = "messenger";
	public static final String A_ADDRESS = "address";
	public static final String A_COUNTRY = "country";
	public static final String A_RELATION = "relation";
	public static final String A_DESCRIPTION = "description";

	private String deptId;		//부서
	private String position;	//직급(직함)
	private String mobile;		//휴대전화
	private String telephone;	//사무실(집)전화
	private String fax;			//팩스
	private String email;		//이메일
	private String messenger;	//메신저
	private String address;		//주소
	private String country;		//국가
	private String relation;	//관계
	private String description;	//설명

	public String getDeptId() {
		return deptId;
	}
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMessenger() {
		return messenger;
	}
	public void setMessenger(String messenger) {
		this.messenger = messenger;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getRelation() {
		return relation;
	}
	public void setRelation(String relation) {
		this.relation = relation;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public AddressBook() {
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
		appendAttributeString(A_DEPTID, deptId, buf);
		appendAttributeString(A_POSITION, position, buf);
		appendAttributeString(A_MOBILE, mobile, buf);
		appendAttributeString(A_TELEPHONE, telephone, buf);
		appendAttributeString(A_FAX, fax, buf);
		appendAttributeString(A_EMAIL, email, buf);
		appendAttributeString(A_MESSENGER, messenger, buf);
		appendAttributeString(A_ADDRESS, address, buf);
		appendAttributeString(A_COUNTRY, country, buf);
		appendAttributeString(A_RELATION, relation, buf);
		appendAttributeString(A_DESCRIPTION, description, buf);
		return buf.toString();
	}
	public static BaseObject toObject(Node node, BaseObject baseObj) throws Exception {
		if (node == null)
			return null;

		AddressBook obj = null;
		if (baseObj == null || !(baseObj instanceof AddressBook))
			obj = new AddressBook();
		else
			obj = (AddressBook)baseObj;

		// 부모 attributes, elements 값 설정
		MisObject.toObject(node, obj);
		
		NamedNodeMap attrMap = node.getAttributes();
		if (attrMap != null) {
			Node deptId = attrMap.getNamedItem(A_DEPTID);
			Node position = attrMap.getNamedItem(A_POSITION);
			Node mobile = attrMap.getNamedItem(A_MOBILE);
			Node telephone = attrMap.getNamedItem(A_TELEPHONE);
			Node fax = attrMap.getNamedItem(A_FAX);
			Node email = attrMap.getNamedItem(A_EMAIL);
			Node messenger = attrMap.getNamedItem(A_MESSENGER);
			Node address = attrMap.getNamedItem(A_ADDRESS);
			Node country = attrMap.getNamedItem(A_COUNTRY);
			Node relation = attrMap.getNamedItem(A_RELATION);
			Node description = attrMap.getNamedItem(A_DESCRIPTION);

			if (deptId != null)
				obj.setDeptId(deptId.getNodeValue());
			if (position != null)
				obj.setPosition(position.getNodeValue());
			if (mobile != null)
				obj.setMobile(mobile.getNodeValue());
			if (telephone != null)
				obj.setTelephone(telephone.getNodeValue());
			if (fax != null)
				obj.setFax(fax.getNodeValue());
			if (email != null)
				obj.setEmail(email.getNodeValue());
			if (messenger != null)
				obj.setMessenger(messenger.getNodeValue());
			if (address != null)
				obj.setAddress(address.getNodeValue());
			if (country != null)
				obj.setCountry(country.getNodeValue());
			if (relation != null)
				obj.setRelation(relation.getNodeValue());
			if (description != null)
				obj.setDescription(description.getNodeValue());
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
	public static AddressBook[] add(AddressBook[] objs, AddressBook obj) {
		if (obj == null)
			return objs;
		int size = 0;
		if (objs != null)
			size = objs.length;
		AddressBook[] newObjs = new AddressBook[size+1];
		int i;
		for (i=0; i<size; i++)
			newObjs[i] = objs[i];
		newObjs[i] = obj;
		return newObjs;
	}
	public static AddressBook[] remove(AddressBook[] objs, AddressBook obj) {
		if (obj == null)
			return objs;
		int size = 0;
		if (objs != null)
			size = objs.length;
		if (size == 0)
			return objs;
		AddressBook[] newObjs = new AddressBook[size-1];
		int i;
		int j = 0;
		for (i=0; i<size; i++) {
			if (objs[i].equals(obj))
				continue;
			newObjs[j++] = objs[i];
		}
		return newObjs;
	}
	public static AddressBook[] left(AddressBook[] objs, AddressBook obj) {
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
		AddressBook[] newObjs = new AddressBook[objs.length];
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
	public static AddressBook[] right(AddressBook[] objs, AddressBook obj) {
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
		AddressBook[] newObjs = new AddressBook[objs.length];
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

}