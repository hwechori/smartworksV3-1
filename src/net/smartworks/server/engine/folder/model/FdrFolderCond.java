/*	
 * $Id$
 * created by    : hsshin
 * creation-date : 2012. 3. 7.
 * =========================================================
 * Copyright (c) 2012 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.server.engine.folder.model;

import net.smartworks.server.engine.common.model.BaseObject;
import net.smartworks.server.engine.common.model.MisObjectCond;
import net.smartworks.server.engine.common.util.CommonUtil;
import net.smartworks.server.engine.common.util.XmlUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

public class FdrFolderCond extends MisObjectCond {
	private static final long serialVersionUID = 1L;
	private static Log logger = LogFactory.getLog(FdrFolderCond.class);
	
	protected static final String PREFIX = "Fdr";
	private static final String NAME = CommonUtil.toName(FdrFolderCond.class, PREFIX);

	public static final String A_PARENTID = "parentId";
	public static final String A_DISPLAYORDER = "displayOrder";
	public static final String A_TYPENOTIN = "objIdNotIn";
	public static final String A_TYPENOTINS = "objIdNotIns";

	private String parentId;
	private int displayOrder = -1;
	
	private String[] objIdNotIn;
	private String[] objIdNotIns;

	public FdrFolderCond() {
		super();
	}
	public String toString(String name, String tab) {
		if (name == null || name.trim().length() == 0)
			name = NAME;
		return super.toString(name, tab);
	}
	public String toLiteString(String name, String tab) {
		if (name == null || name.trim().length() ==0)
			name = NAME;
		return super.toLiteString(name, tab);
	}
	public String toAttributesString() {
		StringBuffer buf = new StringBuffer();
		buf.append(super.toAttributesString());
		appendAttributeString(A_PARENTID, parentId, buf);
		appendAttributeString(A_DISPLAYORDER, displayOrder, buf);
		return buf.toString();
	}
	public static BaseObject toObject(Node node, BaseObject baseObj) throws Exception {
		if(node == null)
			return null;
		FdrFolderCond obj = null;
		if(baseObj == null ||!(baseObj instanceof FdrFolderCond))
			obj = new FdrFolderCond();
		else 
			obj =(FdrFolderCond)baseObj;
		//부모 attributes, elements 값 설정
		MisObjectCond.toObject(node,obj);
		
		NamedNodeMap attrMap = node.getAttributes();
		if (attrMap != null) {
			Node parentId = attrMap.getNamedItem(A_PARENTID);
			Node displayOrder = attrMap.getNamedItem(A_DISPLAYORDER);
			if (parentId != null)
				obj.setParentId(parentId.getNodeValue());
			if (displayOrder != null)
				obj.setDisplayOrder(CommonUtil.toInt(displayOrder.getNodeValue()));	
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
	public static FdrFolderCond[] add(FdrFolderCond[] objs, FdrFolderCond obj) {
		if (obj == null)
			return objs;
		int size = 0;
		if(objs != null)
			size= 0;
		if (objs != null)
			size = objs.length;
		FdrFolderCond[] newObjs = new FdrFolderCond[size+1];
		int i;
		for (i=0; i<size; i++)
			newObjs[i] = objs[i];
		newObjs[i] = obj;
		return newObjs;		
	}
	public static FdrFolderCond[] remove(FdrFolderCond[] objs, FdrFolderCond obj) {
		if(obj == null)
			return objs;
		int size = 0;
		if (objs != null)
			size = objs.length;
		if (size == 0)
			return objs;
		FdrFolderCond[] newObjs = new FdrFolderCond[size-1];
		int i;
		int j =0;
		for (i=0; i<size; i++) {
			if (objs[i].equals(obj))
				continue;
			newObjs[j++] =objs[i];
		}
		return newObjs;
	}
	public static FdrFolderCond[] left(FdrFolderCond[] objs, FdrFolderCond obj) {
		if (objs == null || objs.length == 0 || obj == null)
			return objs;
		int idx = -1;
		for (int i=0; i<objs.length; i++){
			if (!objs[i].equals(obj))
				continue;
			idx = i;
			break;
		}
		if (idx < 1)
			return objs;
		FdrFolderCond[] newObjs = new FdrFolderCond[objs.length];
		for (int i =0; i<objs.length; i++) {
			if(i == idx) {
				newObjs[i] = objs[idx-1];
				continue;
			}else if (i == idx-1) {
				newObjs[i]= objs[idx];
				continue;
			}
			newObjs[i] = objs[i];
		}
		return newObjs;
	}
	public static FdrFolderCond[] right(FdrFolderCond[] objs, FdrFolderCond obj) {
		if (objs == null || objs.length ==0 || obj == null)
			return objs;
		int idx = -1;
		for (int i=0; i<objs.length;i++) {
			if(!objs[i].equals(obj))
				continue;
			idx = i;
			break;
		}
		if (idx == -1 || idx+1 == objs.length)
			return objs;
		FdrFolderCond[] newObjs = new FdrFolderCond[objs.length];
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
		}catch (Exception e) {
			logger.warn(e,e);
			return null;
		}
	}

	public String[] getObjIdNotIn() {
		return objIdNotIn;
	}
	public void setObjIdNotIn(String[] objIdNotIn) {
		this.objIdNotIn = objIdNotIn;
	}
	public String[] getObjIdNotIns() {
		return objIdNotIns;
	}
	public void setObjIdNotIns(String[] objIdNotIns) {
		this.objIdNotIns = objIdNotIns;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public int getDisplayOrder() {
		return displayOrder;
	}
	public void setDisplayOrder(int displayOrder) {
		this.displayOrder = displayOrder;
	}

}