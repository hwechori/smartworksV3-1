package net.smartworks.model.instance.info;

import net.smartworks.model.community.info.UserInfo;
import net.smartworks.model.instance.Instance;
import net.smartworks.util.LocalDate;

public class WorkInstanceInfo extends InstanceInfo {

	private TaskInstanceInfo lastTask;
	private int lastTaskCount = -1;

	public WorkInstanceInfo(){
		super();
		super.setType(Instance.TYPE_WORK);
	}	
	public WorkInstanceInfo(String id, String subject, UserInfo owner, UserInfo lastModifier,
			LocalDate lastModifiedDate) {
		super(id, subject, Instance.TYPE_WORK, owner, lastModifier, lastModifiedDate);
	}
	
	public TaskInstanceInfo getLastTask() {
		return lastTask;
	}
	public void setLastTask(TaskInstanceInfo lastTask) {
		this.lastTask = lastTask;
	}
	public int getLastTaskCount() {
		return lastTaskCount;
	}
	public void setLastTaskCount(int lastTaskCount) {
		this.lastTaskCount = lastTaskCount;
	}
}
