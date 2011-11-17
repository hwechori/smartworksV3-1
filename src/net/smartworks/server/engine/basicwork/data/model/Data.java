/*	
 * $Id$
 * created by    : hsshin
 * creation-date : 2011. 11. 16.
 * =========================================================
 * Copyright (c) 2011 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.server.engine.basicwork.data.model;

import net.smartworks.server.engine.common.model.BaseObject;
import net.smartworks.server.engine.common.model.MisObject;
import net.smartworks.server.engine.common.util.CommonUtil;
import net.smartworks.server.engine.common.util.XmlUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

public class Data extends MisObject {

	private static final long serialVersionUID = 1L;
	private static Log logger = LogFactory.getLog(Data.class);

	protected static final String PREFIX = "Data";
	private static final String NAME = CommonUtil.toName(Data.class, PREFIX);

	public static final String A_TITLE = "title";
	public static final String A_CONTENT = "content";
	public static final String A_FILEGROUPID = "fileGroupId";
	public static final String A_MANAGER = "manager";
	public static final String A_MANAGEDEPT = "manageDept";

	private String title;
	private String content;
	private String fileGroupId;
	private String manager;
	private String manageDept;

	public String getFileGroupId() {
		return fileGroupId;
	}
	public void setFileGroupId(String fileGroupId) {
		this.fileGroupId = fileGroupId;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	public String getManageDept() {
		return manageDept;
	}
	public void setManageDept(String manageDept) {
		this.manageDept = manageDept;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Data() {
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
		appendAttributeString(A_TITLE, title, buf);
		appendAttributeString(A_CONTENT, content, buf);
		appendAttributeString(A_FILEGROUPID, fileGroupId, buf);
		appendAttributeString(A_MANAGER, manager, buf);
		appendAttributeString(A_MANAGEDEPT, manageDept, buf);
		
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

		Data obj = null;
		if (baseObj == null || !(baseObj instanceof Data))
			obj = new Data();
		else
			obj = (Data)baseObj;
		//부모 attributes, elements값 설정
		MisObject.toObject(node, obj);
		
		NamedNodeMap attrMap = node.getAttributes();
		if (attrMap != null) {
			Node title = attrMap.getNamedItem(A_TITLE);
			Node content = attrMap.getNamedItem(A_CONTENT);
			Node fileGroupId = attrMap.getNamedItem(A_FILEGROUPID);
			Node manager = attrMap.getNamedItem(A_MANAGER);
			Node manageDept = attrMap.getNamedItem(A_MANAGEDEPT);

			if (content != null)
				obj.setTitle(title.getNodeValue());
				obj.setContent(content.getNodeValue());
				obj.setFileGroupId(fileGroupId.getNodeValue());
				obj.setManager(manager.getNodeValue());
				obj.setManageDept(manageDept.getNodeValue());
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
	public static Data[] add(Data[] objs, Data obj) {
		if (obj == null)
			return objs;
		int size = 0;
		if (objs != null)
			size = objs.length;
		Data[] newObjs = new Data[size+1];
		int i;
		for (i=0; i<size; i++)
			newObjs[i] = objs[i];
		return newObjs;
	}
	public static Data[] remove(Data[] objs, Data obj) {
		if (obj == null)
			return objs;
		int size = 0;
		if (objs != null)
			size = objs.length;
		if (size == 0)
			return objs;
		Data[] newObjs = new Data[size-1];
		int i;
		int j = 0;
		for (i=0; i<size; i++) {
			if (objs[i].equals(obj))
				continue;
			newObjs[j++] = objs[i];
		}
		return newObjs;
	}
	public static Data[] left(Data[] objs, Data obj) {
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
		Data[] newObjs = new Data[objs.length];
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
	public static Data[] right(Data[] objs, Data obj) {
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
		Data[] newObjs = new Data[objs.length];
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