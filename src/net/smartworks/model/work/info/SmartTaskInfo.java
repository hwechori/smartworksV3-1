package net.smartworks.model.work.info;

import net.smartworks.model.BaseObject;
import net.smartworks.model.community.info.UserInfo;

public class SmartTaskInfo extends BaseObject{

	private SmartFormInfo form;
	private boolean startTask;
	private UserInfo assignedUser;
	private String assigningName;

	public boolean isStartTask() {
		return startTask;
	}
	public void setStartTask(boolean startTask) {
		this.startTask = startTask;
	}
	public SmartFormInfo getForm() {
		return form;
	}
	public void setForm(SmartFormInfo form) {
		this.form = form;
	}
	public UserInfo getAssignedUser() {
		return assignedUser;
	}
	public void setAssignedUser(UserInfo assignedUser) {
		this.assignedUser = assignedUser;
	}
	public String getAssigningName() {
		return assigningName;
	}
	public void setAssigningName(String assigningName) {
		this.assigningName = assigningName;
	}

	public SmartTaskInfo(){
		super();
	}
	public SmartTaskInfo(String id, String name){
		super(id, name);
	}
}
