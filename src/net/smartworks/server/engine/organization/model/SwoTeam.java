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

public class SwoTeam extends SwoObject {

	private static final long serialVersionUID = 1L;
	private static Log logger = LogFactory.getLog(SwoTeam.class);
	
	private static final String NAME = CommonUtil.toName(SwoTeam.class, PREFIX);

	public static final String A_TEAMLEADER = "teamLeader";
	public static final String A_DEPT = "dept";
	public static final String A_MEMBER = "member";
	public static final String A_ACCESSLEVEL = "accessLevel";
	public static final String A_STATE = "state";
	public static final String A_DESCRIPTION = "description";
	
	private String teamLeader;
	private String dept;
	private String member;
	private String accessLevel;
	private String state;
	private String description;
	
	public SwoTeam() {
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
		appendAttributeString(A_TEAMLEADER, teamLeader, buf);
		appendAttributeString(A_DEPT, dept, buf);
		appendAttributeString(A_MEMBER, member, buf);
		appendAttributeString(A_ACCESSLEVEL,accessLevel, buf);
		appendAttributeString(A_STATE,state, buf);
		appendAttributeString(A_DESCRIPTION,description, buf);
		
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
		
		SwoTeam obj = null;
		if (baseObj == null || !(baseObj instanceof SwoTeam))
			obj = new SwoTeam();
		else
			obj = (SwoTeam)baseObj;
		SwoObject.toObject(node, obj);
		
		NamedNodeMap attrMap = node.getAttributes();
		if (attrMap != null) {
			Node teamLeader = attrMap.getNamedItem(A_TEAMLEADER);
			Node dept = attrMap.getNamedItem(A_DEPT);
			Node member = attrMap.getNamedItem(A_MEMBER);
			Node accessLevel = attrMap.getNamedItem(A_ACCESSLEVEL);
			Node state = attrMap.getNamedItem(A_STATE);
			Node description = attrMap.getNamedItem(A_DESCRIPTION);
			
			if (teamLeader != null)
				obj.setTeamLeader(teamLeader.getNodeValue());
			if (dept != null)
				obj.setDept(dept.getNodeValue());
			if (member != null)
				obj.setMember(member.getNodeValue());
			if (accessLevel != null)
				obj.setAccessLevel(accessLevel.getNodeValue());
			if (state != null)
				obj.setState(state.getNodeValue());
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
	public static SwoTeam[] add(SwoTeam[] objs, SwoTeam obj) {
		if (obj == null)
			return objs;
		int size = 0;
		if (objs != null)
			size = objs.length;
		SwoTeam[] newObjs = new SwoTeam[size+1];
		int i;
		for (i=0; i<size; i++)
			newObjs[i] = objs[i];
		newObjs[i] = obj;
		return newObjs;
	}
	public static SwoTeam[] remove(SwoTeam[] objs, SwoTeam obj) {
		if (obj == null)
			return objs;
		int size = 0;
		if (objs != null)
			size = objs.length;
		if (size == 0)
			return objs;
		SwoTeam[] newObjs = new SwoTeam[size-1];
		int i;
		int j = 0;
		for (i=0; i<size; i++) {
			if (objs[i].equals(obj))
				continue;
			newObjs[j++] = objs[i];
		}
		return newObjs;
	}
	public static SwoTeam[] left(SwoTeam[] objs, SwoTeam obj) {
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
		SwoTeam[] newObjs = new SwoTeam[objs.length];
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
	public static SwoTeam[] right(SwoTeam[] objs, SwoTeam obj) {
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
		SwoTeam[] newObjs = new SwoTeam[objs.length];
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

	public String getTeamLeader() {
		return teamLeader;
	}
	public void setTeamLeader(String teamLeader) {
		this.teamLeader = teamLeader;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getMember() {
		return member;
	}
	public void setMember(String member) {
		this.member = member;
	}
	public String getAccessLevel() {
		return accessLevel;
	}
	public void setAccessLevel(String accessLevel) {
		this.accessLevel = accessLevel;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

}