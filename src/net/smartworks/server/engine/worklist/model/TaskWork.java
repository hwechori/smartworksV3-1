/* 
 * $Id$
 * created by    : yukm
 * creation-date : 2011. 12. 4.
 * =========================================================
 * Copyright (c) 2011 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.server.engine.worklist.model;

import java.util.Date;

public class TaskWork {

	private String tskObjId;    
	private String tskTitle;  
	private String tskDoc;
	private String tskType; 
	private String tskRefType;
	private String tskStatus;   
	private String tskAssignee; 
	private Date taskLastModifyDate;
	private Date tskCreateDate;
	private Date tskExecuteDate;
	private String tskName;     
	private String tskPrcInstId;
	private String tskForm;
	private String isStartActivity;
	private String tskWorkSpaceId;
	private String tskWorkSpaceType;
	private String tskDef;
	private String packageId;  
	private String packageName;
	private String childCtgId;  
	private String childCtgName;
	private String parentCtgId; 
	private String parentCtgName;
	private String prcObjId;                           
	private String prcTitle;                           
	private String prcType;                            
	private String prcStatus;                          
	private String prcCreateUser;                      
	private String prcDid;                             
	private String prcPrcId; 
	private Date prcCreateDate;
	private String prcWorkSpaceId;
	private String prcWorkSpaceType;
	private String lastTskObjId;                       
	private String lastTskName;                        
	private String lastTskCreateUser;                  
	private Date lastTskCreateDate;                  
	private String lastTskStatus;                      
	private String lastTskType;                        
	private String lastTskTitle;                       
	private String lastTskAssignee;                    
	private Date lastTskExecuteDate;                 
	private Date lastTskDueDate; 
	private String lastTskForm; 
	private String lastTskWorkSpaceId;
	private String lastTskWorkSpaceType;
	private String lastTskDef;
	private int lastTskCount;
	
	public String getTskObjId() {
		return tskObjId;
	}
	public void setTskObjId(String tskObjId) {
		this.tskObjId = tskObjId;
	}
	public String getTskTitle() {
		return tskTitle;
	}
	public void setTskTitle(String tskTitle) {
		this.tskTitle = tskTitle;
	}
	public String getTskDoc() {
		return tskDoc;
	}
	public void setTskDoc(String tskDoc) {
		this.tskDoc = tskDoc;
	}
	public String getTskType() {
		return tskType;
	}
	public void setTskType(String tskType) {
		this.tskType = tskType;
	}
	public String getTskRefType() {
		return tskRefType;
	}
	public void setTskRefType(String tskRefType) {
		this.tskRefType = tskRefType;
	}
	public String getTskStatus() {
		return tskStatus;
	}
	public void setTskStatus(String tskStatus) {
		this.tskStatus = tskStatus;
	}
	public String getTskAssignee() {
		return tskAssignee;
	}
	public void setTskAssignee(String tskAssignee) {
		this.tskAssignee = tskAssignee;
	}
	public Date getTaskLastModifyDate() {
		return taskLastModifyDate;
	}
	public void setTaskLastModifyDate(Date taskLastModifyDate) {
		this.taskLastModifyDate = taskLastModifyDate;
	}
	public Date getTskCreateDate() {
		return tskCreateDate;
	}
	public void setTskCreateDate(Date tskCreateDate) {
		this.tskCreateDate = tskCreateDate;
	}
	public Date getTskExecuteDate() {
		return tskExecuteDate;
	}
	public void setTskExecuteDate(Date tskExecuteDate) {
		this.tskExecuteDate = tskExecuteDate;
	}
	public String getTskName() {
		return tskName;
	}
	public void setTskName(String tskName) {
		this.tskName = tskName;
	}
	public String getTskPrcInstId() {
		return tskPrcInstId;
	}
	public void setTskPrcInstId(String tskPrcInstId) {
		this.tskPrcInstId = tskPrcInstId;
	}
	public String getTskForm() {
		return tskForm;
	}
	public void setTskForm(String tskForm) {
		this.tskForm = tskForm;
	}
	public String getIsStartActivity() {
		return isStartActivity;
	}
	public void setIsStartActivity(String isStartActivity) {
		this.isStartActivity = isStartActivity;
	}
	public String getPackageId() {
		return packageId;
	}
	public void setPackageId(String packageId) {
		this.packageId = packageId;
	}
	public String getPackageName() {
		return packageName;
	}
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
	public String getChildCtgId() {
		return childCtgId;
	}
	public void setChildCtgId(String childCtgId) {
		this.childCtgId = childCtgId;
	}
	public String getChildCtgName() {
		return childCtgName;
	}
	public void setChildCtgName(String childCtgName) {
		this.childCtgName = childCtgName;
	}
	public String getParentCtgId() {
		return parentCtgId;
	}
	public void setParentCtgId(String parentCtgId) {
		this.parentCtgId = parentCtgId;
	}
	public String getParentCtgName() {
		return parentCtgName;
	}
	public void setParentCtgName(String parentCtgName) {
		this.parentCtgName = parentCtgName;
	}
	public String getPrcObjId() {
		return prcObjId;
	}
	public void setPrcObjId(String prcObjId) {
		this.prcObjId = prcObjId;
	}
	public String getPrcTitle() {
		return prcTitle;
	}
	public void setPrcTitle(String prcTitle) {
		this.prcTitle = prcTitle;
	}
	public String getPrcType() {
		return prcType;
	}
	public void setPrcType(String prcType) {
		this.prcType = prcType;
	}
	public String getPrcStatus() {
		return prcStatus;
	}
	public void setPrcStatus(String prcStatus) {
		this.prcStatus = prcStatus;
	}
	public String getPrcCreateUser() {
		return prcCreateUser;
	}
	public void setPrcCreateUser(String prcCreateUser) {
		this.prcCreateUser = prcCreateUser;
	}
	public String getPrcDid() {
		return prcDid;
	}
	public void setPrcDid(String prcDid) {
		this.prcDid = prcDid;
	}
	public String getPrcPrcId() {
		return prcPrcId;
	}
	public void setPrcPrcId(String prcPrcId) {
		this.prcPrcId = prcPrcId;
	}
	public Date getPrcCreateDate() {
		return prcCreateDate;
	}
	public void setPrcCreateDate(Date prcCreateDate) {
		this.prcCreateDate = prcCreateDate;
	}
	public String getLastTskObjId() {
		return lastTskObjId;
	}
	public void setLastTskObjId(String lastTskObjId) {
		this.lastTskObjId = lastTskObjId;
	}
	public String getLastTskName() {
		return lastTskName;
	}
	public void setLastTskName(String lastTskName) {
		this.lastTskName = lastTskName;
	}
	public String getLastTskCreateUser() {
		return lastTskCreateUser;
	}
	public void setLastTskCreateUser(String lastTskCreateUser) {
		this.lastTskCreateUser = lastTskCreateUser;
	}
	public Date getLastTskCreateDate() {
		return lastTskCreateDate;
	}
	public void setLastTskCreateDate(Date lastTskCreateDate) {
		this.lastTskCreateDate = lastTskCreateDate;
	}
	public String getLastTskStatus() {
		return lastTskStatus;
	}
	public void setLastTskStatus(String lastTskStatus) {
		this.lastTskStatus = lastTskStatus;
	}
	public String getLastTskType() {
		return lastTskType;
	}
	public void setLastTskType(String lastTskType) {
		this.lastTskType = lastTskType;
	}
	public String getLastTskTitle() {
		return lastTskTitle;
	}
	public void setLastTskTitle(String lastTskTitle) {
		this.lastTskTitle = lastTskTitle;
	}
	public String getLastTskAssignee() {
		return lastTskAssignee;
	}
	public void setLastTskAssignee(String lastTskAssignee) {
		this.lastTskAssignee = lastTskAssignee;
	}
	public Date getLastTskExecuteDate() {
		return lastTskExecuteDate;
	}
	public void setLastTskExecuteDate(Date lastTskExecuteDate) {
		this.lastTskExecuteDate = lastTskExecuteDate;
	}
	public Date getLastTskDueDate() {
		return lastTskDueDate;
	}
	public void setLastTskDueDate(Date lastTskDueDate) {
		this.lastTskDueDate = lastTskDueDate;
	}
	public String getLastTskForm() {
		return lastTskForm;
	}
	public void setLastTskForm(String lastTskForm) {
		this.lastTskForm = lastTskForm;
	}
	public int getLastTskCount() {
		return lastTskCount;
	}
	public void setLastTskCount(int lastTskCount) {
		this.lastTskCount = lastTskCount;
	}
	public String getTskWorkSpaceId() {
		return tskWorkSpaceId;
	}
	public void setTskWorkSpaceId(String tskWorkSpaceId) {
		this.tskWorkSpaceId = tskWorkSpaceId;
	}
	public String getPrcWorkSpaceId() {
		return prcWorkSpaceId;
	}
	public void setPrcWorkSpaceId(String prcWorkSpaceId) {
		this.prcWorkSpaceId = prcWorkSpaceId;
	}
	public String getLastTskWorkSpaceId() {
		return lastTskWorkSpaceId;
	}
	public void setLastTskWorkSpaceId(String lastTskWorkSpaceId) {
		this.lastTskWorkSpaceId = lastTskWorkSpaceId;
	}
	public String getTskWorkSpaceType() {
		return tskWorkSpaceType;
	}
	public void setTskWorkSpaceType(String tskWorkSpaceType) {
		this.tskWorkSpaceType = tskWorkSpaceType;
	}
	public String getPrcWorkSpaceType() {
		return prcWorkSpaceType;
	}
	public void setPrcWorkSpaceType(String prcWorkSpaceType) {
		this.prcWorkSpaceType = prcWorkSpaceType;
	}
	public String getLastTskWorkSpaceType() {
		return lastTskWorkSpaceType;
	}
	public void setLastTskWorkSpaceType(String lastTskWorkSpaceType) {
		this.lastTskWorkSpaceType = lastTskWorkSpaceType;
	}
	public String getTskDef() {
		return tskDef;
	}
	public void setTskDef(String tskDef) {
		this.tskDef = tskDef;
	}
	public String getLastTskDef() {
		return lastTskDef;
	}
	public void setLastTskDef(String lastTskDef) {
		this.lastTskDef = lastTskDef;
	}
}
