/*	
 * $Id$
 * created by    : hsshin
 * creation-date : 2011. 11. 14.
 * =========================================================
 * Copyright (c) 2011 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.server.engine.groupware.message.model;

import net.smartworks.server.engine.common.model.BaseObject;
import net.smartworks.server.engine.common.model.MisObject;
import net.smartworks.server.engine.common.util.CommonUtil;
import net.smartworks.server.engine.common.util.XmlUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

public class Message extends MisObject {

	private static final long serialVersionUID = 1L;
	private static Log logger = LogFactory.getLog(Message.class);
	
	protected static final String PREFIX = "Msg";
	private static final String NAME = CommonUtil.toName(Message.class, PREFIX);
	
	public static final String A_CONTENT = "content";
	public static final String A_TARGETUSER = "targetUser";
	
	private String content;
	private String targetUser;
	
	public Message() {
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
		appendAttributeString(A_CONTENT, content, buf);
		appendAttributeString(A_TARGETUSER, targetUser, buf);
		
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
		
		Message obj = null;
		if (baseObj == null || !(baseObj instanceof Message))
			obj = new Message();
		else
			obj = (Message)baseObj;
		//부모 attributes, elements값 설정
		MisObject.toObject(node, obj);
		
		NamedNodeMap attrMap = node.getAttributes();
		if (attrMap != null) {
			Node content = attrMap.getNamedItem(A_CONTENT);
			Node targetUser = attrMap.getNamedItem(A_TARGETUSER);
			
			if (content != null)
				obj.setContent(content.getNodeValue());
				obj.setTargetUser(targetUser.getNodeValue());
		}
		//element값 설정
		
		return  obj;
	}
	public static BaseObject toObject(String str) throws Exception {
		if (str == null)
			return null;
		Document doc = XmlUtil.toDocument(str);
		if (doc == null)
			return null;
		return toObject(doc.getDocumentElement(), null);
	}
	public static Message[] add(Message[] objs, Message obj) {
		if (obj == null)
			return objs;
		int size = 0;
		if (objs != null)
			size = objs.length;
		Message[] newObjs = new Message[size+1];
		int i;
		for (i=0; i<size; i++)
			newObjs[i] = objs[i];
		return newObjs;
	}
	public static Message[] remove(Message[] objs, Message obj) {
		if (obj == null)
			return objs;
		int size = 0;
		if (objs != null)
			size = objs.length;
		if (size == 0)
			return objs;
		Message[] newObjs = new Message[size-1];
		int i;
		int j = 0;
		for (i=0; i<size; i++) {
			if (objs[i].equals(obj))
				continue;
			newObjs[j++] = objs[i];
		}
		return newObjs;
	}
	public static Message[] left(Message[] objs, Message obj) {
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
		Message[] newObjs = new Message[objs.length];
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
	public static Message[] right(Message[] objs, Message obj) {
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
		Message[] newObjs = new Message[objs.length];
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTargetUser() {
		return targetUser;
	}
	public void setTargetUser(String targetUser) {
		this.targetUser = targetUser;
	}

}