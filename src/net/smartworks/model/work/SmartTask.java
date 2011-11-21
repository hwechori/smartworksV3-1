package net.smartworks.model.work;

import net.smartworks.model.BaseObject;
import net.smartworks.model.community.User;

public class SmartTask extends BaseObject{

	private SmartForm form;
	private User assignedUser;
	private String assigningName;

	public SmartForm getForm() {
		return form;
	}
	public User getAssignedUser() {
		return assignedUser;
	}
	public void setAssignedUser(User assignedUser) {
		this.assignedUser = assignedUser;
	}
	public String getAssigningName() {
		return assigningName;
	}
	public void setAssigningName(String assigningName) {
		this.assigningName = assigningName;
	}
	public void setForm(SmartForm form) {
		this.form = form;
	}

	public SmartTask(){
		super();
	}
	public SmartTask(String id, String name){
		super(id, name);
	}
}
