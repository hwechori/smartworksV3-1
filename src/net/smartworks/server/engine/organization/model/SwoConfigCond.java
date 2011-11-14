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

public class SwoConfigCond extends SwoObjectCond {

	private static final long serialVersionUID = 1L;
	private static Log logger = LogFactory.getLog(SwoConfigCond.class);
	
	private static final String NAME = CommonUtil.toName(SwoConfigCond.class, PREFIX);
	
	public static final String A_SMTPADDRESS = "smtpAddress";
	public static final String A_USERID = "userId";
	public static final String A_PASSWORD = "password";
	public static final String A_ISACTIVITY = "isActivity";

	private String smtpAddress;
	private String userId;
	private String password;
	private boolean isActivity = true;
	
	public SwoConfigCond() {
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
		appendAttributeString(A_USERID, userId, buf);
		appendAttributeString(A_SMTPADDRESS, smtpAddress, buf);
		appendAttributeString(A_ISACTIVITY, isActivity, buf);
	
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
		
		SwoConfig obj = null;
		if (baseObj == null || !(baseObj instanceof SwoConfig))
			obj = new SwoConfig();
		else
			obj = (SwoConfig)baseObj;
		
		// 부모 attributes, elements 값 설정
		SwoObjectCond.toObject(node, obj);
		
		NamedNodeMap attrMap = node.getAttributes();
		if (attrMap != null) {
			Node password = attrMap.getNamedItem(A_PASSWORD);
			Node userId = attrMap.getNamedItem(A_USERID);
			Node smtpAddress = attrMap.getNamedItem(A_SMTPADDRESS);
			Node isActivity = attrMap.getNamedItem(A_ISACTIVITY);
			
			if (password != null)
				obj.setPassword(password.getNodeValue());
			if (userId != null)
				obj.setUserId(userId.getNodeValue());
			if (smtpAddress != null)
				obj.setSmtpAddress(smtpAddress.getNodeValue());
			if (isActivity != null)
				obj.setActivity(CommonUtil.toBoolean(isActivity.getNodeValue()));
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
	public static SwoConfigCond[] add(SwoConfigCond[] objs, SwoConfigCond obj) {
		if (obj == null)
			return objs;
		int size = 0;
		if (objs != null)
			size = objs.length;
		SwoConfigCond[] newObjs = new SwoConfigCond[size+1];
		int i;
		for (i=0; i<size; i++)
			newObjs[i] = objs[i];
		newObjs[i] = obj;
		return newObjs;
	}
	public static SwoConfigCond[] remove(SwoConfigCond[] objs, SwoConfigCond obj) {
		if (obj == null)
			return objs;
		int size = 0;
		if (objs != null)
			size = objs.length;
		if (size == 0)
			return objs;
		SwoConfigCond[] newObjs = new SwoConfigCond[size-1];
		int i;
		int j = 0;
		for (i=0; i<size; i++) {
			if (objs[i].equals(obj))
				continue;
			newObjs[j++] = objs[i];
		}
		return newObjs;
	}
	public static SwoConfigCond[] left(SwoConfigCond[] objs, SwoConfigCond obj) {
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
		SwoConfigCond[] newObjs = new SwoConfigCond[objs.length];
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
	public static SwoConfigCond[] right(SwoConfigCond[] objs, SwoConfigCond obj) {
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
		SwoConfigCond[] newObjs = new SwoConfigCond[objs.length];
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
	
	public boolean isActivity() {
		return isActivity;
	}
	public void setActivity(boolean isActivity) {
		this.isActivity = isActivity;
	}
	public String getSmtpAddress() {
		return smtpAddress;
	}
	public void setSmtpAddress(String smtpAddress) {
		this.smtpAddress = smtpAddress;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}