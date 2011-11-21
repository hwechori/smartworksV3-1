package net.smartworks.model.instance;

import net.smartworks.model.community.User;
import net.smartworks.model.work.Work;
import net.smartworks.util.LocalDate;

public class WorkInstance extends Instance {

	public static final int TYPE_PROCESS = 11;
	public static final int TYPE_INFORMATION = 12;
	public static final int TYPE_SCHEDULE = 13;

	private TaskInstance[] tasks;
	
	public TaskInstance[] getTasks() {
		return tasks;
	}
	public void setTasks(TaskInstance[] tasks) {
		this.tasks = tasks;
	}

	public WorkInstance() {
		super();
	}

	public WorkInstance(String id, String subject, Work work, User owner, User lastModifier,
			LocalDate lastModifiedDate) {
		super(id, subject, Instance.TYPE_WORK, owner, lastModifier, lastModifiedDate);
		super.setWork(work);
	}
}
