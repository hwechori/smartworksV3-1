package net.smartworks.model.instance;

import net.smartworks.model.community.User;
import net.smartworks.util.LocalDate;

public class InstanceRecord {

	private User owner;
	private User lastModifier;
	private LocalDate lastModifiedDate;
	private FieldData[] fieldDatas;
	
	public User getOwner() {
		return owner;
	}
	public void setOwner(User owner) {
		this.owner = owner;
	}
	public User getLastModifier() {
		return lastModifier;
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
	public FieldData[] getFieldDatas() {
		return fieldDatas;
	}
	public void setFieldDatas(FieldData[] fieldDatas) {
		this.fieldDatas = fieldDatas;
	}
	public InstanceRecord(){
		super();
	}	
	public InstanceRecord(User owner, User lastModifier, LocalDate lastModifiedDate, FieldData[] fieldDatas){
		super();
		this.owner = owner;
		this.lastModifier = lastModifier;
		this.lastModifiedDate = lastModifiedDate;
		this.fieldDatas = fieldDatas;
	}
}
