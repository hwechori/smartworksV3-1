/*	
 * $Id$
 * created by    : hsshin
 * creation-date : 2012. 1. 10.
 * =========================================================
 * Copyright (c) 2012 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.server.engine.organization.model;

import java.util.Date;

import net.smartworks.server.engine.common.model.BaseObject;
import net.smartworks.server.engine.common.util.CommonUtil;
import net.smartworks.server.engine.common.util.DateUtil;
import net.smartworks.server.engine.common.util.XmlUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

public class SwoGroupMember extends SwoObject {

	private static final long serialVersionUID = 1L;
	private static Log logger = LogFactory.getLog(SwoGroupMember.class);
	
	private static final String NAME = CommonUtil.toName(SwoGroupMember.class, PREFIX);

	public static final String A_GROUPID = "groupId";
	public static final String A_USERID = "userId";
	public static final String A_JOINTYPE = "joinType";
	public static final String A_JOINSTATUS = "joinStatus";
	public static final String A_JOINDATE = "joinDate";
	public static final String A_OUTDATE = "outDate";

	private String groupId;
	private String userId;
	private String joinType;
	private String joinStatus;
	private Date joinDate;
	private Date outDate;

	public SwoGroupMember() {
		super();
	}

	public String toString(String name, String tab) {
		if (name == null || name.trim().length() == 0)
			name = NAME;
		return super.toString(name, tab);
	}
	public String toAttributesString() {
		StringBuffer buf = new StringBuffer();
		buf.append(super.toAttributesString());
		appendAttributeString(A_GROUPID, groupId, buf);
		appendAttributeString(A_USERID, userId, buf);
		appendAttributeString(A_JOINTYPE, joinType, buf);
		appendAttributeString(A_JOINSTATUS, joinStatus, buf);
		appendAttributeString(A_JOINDATE, joinDate, buf);
		appendAttributeString(A_OUTDATE, outDate, buf);

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
		
		SwoGroupMember obj = null;
		if (baseObj == null || !(baseObj instanceof SwoGroupMember))
			obj = new SwoGroupMember();
		else
			obj = (SwoGroupMember)baseObj;
		SwoObject.toObject(node, obj);
		
		NamedNodeMap attrMap = node.getAttributes();
		if (attrMap != null) {
			Node groupId = attrMap.getNamedItem(A_GROUPID);
			Node userId = attrMap.getNamedItem(A_USERID);
			Node joinType = attrMap.getNamedItem(A_JOINTYPE);
			Node joinStatus = attrMap.getNamedItem(A_JOINSTATUS);
			Node joinDate = attrMap.getNamedItem(A_JOINDATE);
			Node outDate = attrMap.getNamedItem(A_OUTDATE);

			if (groupId != null)
				obj.setGroupId(groupId.getNodeValue());
			if (userId != null)
				obj.setUserId(userId.getNodeValue());
			if (joinType != null)
				obj.setJoinType(joinType.getNodeValue());
			if (joinStatus != null)
				obj.setJoinStatus(joinStatus.getNodeValue());
			if (joinDate != null)
				obj.setJoinDate(DateUtil.toDate(joinDate.getNodeValue()));
			if (outDate != null)
				obj.setOutDate(DateUtil.toDate(outDate.getNodeValue()));
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
	public static SwoGroupMember[] add(SwoGroupMember[] objs, SwoGroupMember obj) {
		if (obj == null)
			return objs;
		int size = 0;
		if (objs != null)
			size = objs.length;
		SwoGroupMember[] newObjs = new SwoGroupMember[size+1];
		int i;
		for (i=0; i<size; i++)
			newObjs[i] = objs[i];
		newObjs[i] = obj;
		return newObjs;
	}
	public static SwoGroupMember[] remove(SwoGroupMember[] objs, SwoGroupMember obj) {
		if (obj == null)
			return objs;
		int size = 0;
		if (objs != null)
			size = objs.length;
		if (size == 0)
			return objs;
		SwoGroupMember[] newObjs = new SwoGroupMember[size-1];
		int i;
		int j = 0;
		for (i=0; i<size; i++) {
			if (objs[i].equals(obj))
				continue;
			newObjs[j++] = objs[i];
		}
		return newObjs;
	}
	public static SwoGroupMember[] left(SwoGroupMember[] objs, SwoGroupMember obj) {
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
		SwoGroupMember[] newObjs = new SwoGroupMember[objs.length];
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
	public static SwoGroupMember[] right(SwoGroupMember[] objs, SwoGroupMember obj) {
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
		SwoGroupMember[] newObjs = new SwoGroupMember[objs.length];
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

	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getJoinType() {
		return joinType;
	}
	public void setJoinType(String joinType) {
		this.joinType = joinType;
	}
	public String getJoinStatus() {
		return joinStatus;
	}
	public void setJoinStatus(String joinStatus) {
		this.joinStatus = joinStatus;
	}
	public Date getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	public Date getOutDate() {
		return outDate;
	}
	public void setOutDate(Date outDate) {
		this.outDate = outDate;
	}

}