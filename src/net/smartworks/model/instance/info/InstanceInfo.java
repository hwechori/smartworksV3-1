package net.smartworks.model.instance.info;

import net.smartworks.model.community.info.UserInfo;
import net.smartworks.model.community.info.WorkSpaceInfo;
import net.smartworks.model.work.info.WorkInfo;
import net.smartworks.util.LocalDate;

public class InstanceInfo{

	private String id;
	private String subject;
	private int type=-1;
	private WorkInfo work;
	private WorkSpaceInfo workSpace;
	private int status=-1;
	private int numberOfAssociatedWorks=0;
	private UserInfo owner;
	private LocalDate createdDate;
	private UserInfo lastModifier;
	private LocalDate lastModifiedDate;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSubject() {
		return subject;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public WorkInfo getWork() {
		return work;
	}
	public void setWork(WorkInfo work) {
		this.work = work;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getNumberOfAssociatedWorks() {
		return numberOfAssociatedWorks;
	}
	public void setNumberOfAssociatedWorks(int numberOfAssociatedWorks) {
		this.numberOfAssociatedWorks = numberOfAssociatedWorks;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public WorkSpaceInfo getWorkSpace() {
		if (workSpace == null && owner != null)
			return owner;
		return workSpace;
	}
	public void setWorkSpace(WorkSpaceInfo workSpace) {
		this.workSpace = workSpace;
	}
	public LocalDate getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}
	public UserInfo getOwner() {
		return owner;
	}
	public void setOwner(UserInfo owner) {
		this.owner = owner;
	}
	public UserInfo getLastModifier() {
		return lastModifier;
	}
	public void setLastModifier(UserInfo lastModifier) {
		this.lastModifier = lastModifier;
	}
	public LocalDate getLastModifiedDate() {
		return lastModifiedDate;
	}
	public void setLastModifiedDate(LocalDate lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public InstanceInfo(){
		super();
	}	
	public InstanceInfo(String id, String subject, int type, UserInfo owner, UserInfo lastModifier,
			LocalDate lastModifiedDate) {
		super();
		this.id = id;
		this.subject = subject;
		this.type = type;
		this.owner = owner;
		this.lastModifier = lastModifier;
		this.lastModifiedDate = lastModifiedDate;
	}
}
