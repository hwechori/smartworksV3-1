package net.smartworks.model.instance.info;

import net.smartworks.model.community.info.UserInfo;
import net.smartworks.model.instance.Instance;
import net.smartworks.model.work.info.WorkInfo;
import net.smartworks.util.LocalDate;

public class PWInstanceInfo extends WorkInstanceInfo {

	private TaskInstanceInfo lastTask;
	
	public TaskInstanceInfo getLastTask() {
		return lastTask;
	}
	public void setLastTask(TaskInstanceInfo lastTask) {
		this.lastTask = lastTask;
	}

	public PWInstanceInfo() {
		super();
	}

	public PWInstanceInfo(String id, String subject, WorkInfo work, UserInfo owner, UserInfo lastModifier, LocalDate lastModifiedDate, TaskInstanceInfo lastTask) {
		super(id, subject, Instance.TYPE_WORK, owner, lastModifier, lastModifiedDate);
		super.setWork(work);
		this.lastTask = lastTask;
	}

}
