package net.smartworks.model.instance;

import net.smartworks.model.community.User;
import net.smartworks.model.community.WorkSpace;
import net.smartworks.model.work.Work;
import net.smartworks.util.LocalDate;

public class Instance {

	public final static int TYPE_WORK = 1;
	public final static int TYPE_TASK = 2;
	public final static int TYPE_ASYNC_MESSAGE = 3;
	public final static int TYPE_NOTIFICATION = 4;
	public final static int TYPE_COMMENT = 5;
	public final static int TYPE_MAIL = 6;
	public final static int TYPE_EVENT = 7;
	public final static int TYPE_FILE = 8;
	public final static int TYPE_IMAGE = 9;
	public final static int TYPE_MEMO = 10;
	public final static int TYPE_BOARD = 11;
	
	public final static int STATUS_NOT_YET = 0;
	public final static int STATUS_RUNNING = 1;
	public final static int STATUS_DELAYED_RUNNING = 2;
	public final static int STATUS_RETURNED = 3;
	public final static int STATUS_COMPLETED = 4;
	public final static int STATUS_PLANNED = 5;
	
	private String id;
	private String subject;
	private int type=-1;
	private Work work;
	private WorkSpace workSpace;
	private int status=-1;
	private User owner;
	private LocalDate createdDate;
	private User lastModifier;
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
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public Work getWork() {
		return work;
	}
	public void setWork(Work work) {
		this.work = work;
	}
	public WorkSpace getWorkSpace() {
		if (workSpace == null && owner != null)
			return owner;
		return workSpace;
	}

	public void setWorkSpace(WorkSpace workSpace) {
		this.workSpace = workSpace;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public User getOwner() {
		return owner;
	}
	public void setOwner(User owner) {
		this.owner = owner;
	}
	public User getLastModifier() {
		return lastModifier;
	}
	public LocalDate getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}
	public void setLastModifier(User lastModifier) {
		this.lastModifier = lastModifier;
	}
	public LocalDate getLastModifiedDate() {
		return lastModifiedDate;
	}
	public void setLastModifiedDate(LocalDate lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
	
	public Instance() {
		super();
	}

	public Instance(String id, String subject, int type, User owner, User lastModifier,
			LocalDate lastModifiedDate) {
		super();
		this.id = id;
		this.subject = subject;
		this.type = type;
		this.workSpace = owner;
		this.owner = owner;
		this.lastModifier = lastModifier;
		this.lastModifiedDate = lastModifiedDate;
	}
}
