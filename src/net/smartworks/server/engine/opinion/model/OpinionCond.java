/*	
 * $Id$
 * created by    : hsshin
 * creation-date : 2012. 3. 19.
 * =========================================================
 * Copyright (c) 2012 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.server.engine.opinion.model;

import net.smartworks.server.engine.common.model.BaseObject;
import net.smartworks.server.engine.common.model.MisObject;
import net.smartworks.server.engine.common.model.MisObjectCond;
import net.smartworks.server.engine.common.util.CommonUtil;
import net.smartworks.server.engine.common.util.XmlUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

public class OpinionCond extends MisObjectCond {

	private static final long serialVersionUID = 1L;
	private static Log logger = LogFactory.getLog(OpinionCond.class);

	protected static final String PREFIX = "Opn";
	private static final String NAME = CommonUtil.toName(OpinionCond.class, PREFIX);

	public static final String A_REFTYPE = "refType";
	public static final String A_REFID = "refId";
	public static final String A_GROUPID = "groupId";
	public static final String A_REFDOMAINID = "refDomainId";
	public static final String A_REFFORMID = "refFormId";
	public static final String A_TITLE = "title";
	public static final String A_OPINION = "opinion";

	private int refType;
	private String groupId;
	private String refId;
	private String refDomainId;
	private String refFormId;
	private String title;
	private String opinion;

	public OpinionCond() {
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
		appendAttributeString(A_REFTYPE, refType, buf);
		appendAttributeString(A_REFID, refId, buf);
		appendAttributeString(A_GROUPID, groupId, buf);
		appendAttributeString(A_TITLE, title, buf);
		appendAttributeString(A_OPINION, opinion, buf);
		appendAttributeString(A_REFDOMAINID, refDomainId, buf);
		appendAttributeString(A_REFFORMID, refFormId, buf);
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

		OpinionCond obj = null;
		if (baseObj == null || !(baseObj instanceof OpinionCond))
			obj = new OpinionCond();
		else
			obj = (OpinionCond)baseObj;
		//부모 attributes, elements값 설정
		MisObject.toObject(node, obj);

		NamedNodeMap attrMap = node.getAttributes();
		if (attrMap != null) {
			Node refType = attrMap.getNamedItem(A_REFTYPE);
			Node refId = attrMap.getNamedItem(A_REFID);
			Node groupId = attrMap.getNamedItem(A_GROUPID);
			Node title = attrMap.getNamedItem(A_TITLE);
			Node opinion = attrMap.getNamedItem(A_OPINION);
			Node refDomainId = attrMap.getNamedItem(A_REFDOMAINID);
			Node refFormId = attrMap.getNamedItem(A_REFFORMID);

			if(refType != null)
				obj.setRefType(Integer.parseInt(refType.getNodeValue()));
			if(refId != null)
				obj.setRefId(refId.getNodeValue());
			if(groupId != null)
				obj.setGroupId(groupId.getNodeValue());
			if(title != null)
				obj.setTitle(title.getNodeValue());
			if(opinion != null)
				obj.setOpinion(opinion.getNodeValue());
			if(refDomainId != null)
				obj.setRefDomainId(refDomainId.getNodeValue());
			if(refFormId != null)
				obj.setRefFormId(refFormId.getNodeValue());
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
	public static OpinionCond[] add(OpinionCond[] objs, OpinionCond obj) {
		if (obj == null)
			return objs;
		int size = 0;
		if (objs != null)
			size = objs.length;
		OpinionCond[] newObjs = new OpinionCond[size+1];
		int i;
		for (i=0; i<size; i++)
			newObjs[i] = objs[i];
		return newObjs;
	}
	public static OpinionCond[] remove(OpinionCond[] objs, OpinionCond obj) {
		if (obj == null)
			return objs;
		int size = 0;
		if (objs != null)
			size = objs.length;
		if (size == 0)
			return objs;
		OpinionCond[] newObjs = new OpinionCond[size-1];
		int i;
		int j = 0;
		for (i=0; i<size; i++) {
			if (objs[i].equals(obj))
				continue;
			newObjs[j++] = objs[i];
		}
		return newObjs;
	}
	public static OpinionCond[] left(OpinionCond[] objs, OpinionCond obj) {
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
		OpinionCond[] newObjs = new OpinionCond[objs.length];
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
	public static OpinionCond[] right(OpinionCond[] objs, OpinionCond obj) {
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
		OpinionCond[] newObjs = new OpinionCond[objs.length];
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

	public int getRefType() {
		return refType;
	}
	public void setRefType(int refType) {
		this.refType = refType;
	}
	public String getRefId() {
		return refId;
	}
	public void setRefId(String refId) {
		this.refId = refId;
	}
	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getOpinion() {
		return opinion;
	}
	public void setOpinion(String opinion) {
		this.opinion = opinion;
	}
	public String getRefDomainId() {
		return refDomainId;
	}
	public void setRefDomainId(String refDomainId) {
		this.refDomainId = refDomainId;
	}
	public String getRefFormId() {
		return refFormId;
	}
	public void setRefFormId(String refFormId) {
		this.refFormId = refFormId;
	}

}