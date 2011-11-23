package net.smartworks.model.report;

import net.smartworks.model.BaseObject;
import net.smartworks.model.community.User;
import net.smartworks.model.community.WorkSpace;
import net.smartworks.model.work.Work;
import net.smartworks.util.LocalDate;

public class Report extends BaseObject {

	public final static int TYPE_CHART = 1;
	public final static int TYPE_MATRIX = 2;
	public final static int TYPE_TABLE = 3;
	
	private int type=-1;
	private Work work;
	private User owner;
	private LocalDate createdDate;
	private User lastModifier;
	private LocalDate lastModifiedDate;

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
	
	public Report() {
		super();
	}
	
	public Report(String id, String name){
		super(id, name);
	}

	public Report(String id, String name, int type, User owner, User lastModifier,
			LocalDate lastModifiedDate) {
		super(id, name);
		this.type = type;
		this.owner = owner;
		this.lastModifier = lastModifier;
		this.lastModifiedDate = lastModifiedDate;
	}
}
