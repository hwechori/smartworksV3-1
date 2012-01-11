/*	
 * $Id$
 * created by    : hsshin
 * creation-date : 2012. 1. 10.
 * =========================================================
 * Copyright (c) 2012 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.server.engine.organization.model;

import java.sql.Date;

public class SwoGroupMember extends SwoObject {

	private static final long serialVersionUID = 1L;

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