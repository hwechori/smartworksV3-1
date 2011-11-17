package net.smartworks.model.instance;

import net.smartworks.model.community.User;
import net.smartworks.model.work.Work;
import net.smartworks.util.LocalDate;

public class WorkInstance extends Instance {

	public static final int INSTANCE_TYPE_PROCESS = 11;
	public static final int INSTANCE_TYPE_INFORMATION = 12;
	public static final int INSTANCE_TYPE_SCHEDULE = 13;
	
	private TaskInstance[] tasks;
	private User lastModifier;

	public TaskInstance[] getTasks() {
		return tasks;
	}
	public void setTasks(TaskInstance[] tasks) {
		this.tasks = tasks;
	}
	public User getLastModifier() {
		return lastModifier;
	}
	public void setLastModifier(User lastModifier) {
		this.lastModifier = lastModifier;
	}

	public WorkInstance() {
		super();
	}

	public WorkInstance(String id, String subject, Work work, User owner,
			LocalDate lastModifiedDate) {
		super(id, subject, Instance.TYPE_WORK, owner, lastModifiedDate);
		super.setWork(work);
		this.lastModifier = owner;
	}
}
