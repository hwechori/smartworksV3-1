package net.smartworks.model.instance;

import net.smartworks.model.community.User;
import net.smartworks.model.instance.info.TaskInstanceInfo;
import net.smartworks.model.work.Work;
import net.smartworks.util.LocalDate;

public class WorkInstance extends Instance {

	public static final int TYPE_PROCESS = 11;
	public static final int TYPE_INFORMATION = 12;
	public static final int TYPE_SCHEDULE = 13;

	private TaskInstanceInfo[] tasks;
	private int numberOfSubInstances; 
	
	public TaskInstanceInfo[] getTasks() {
		return tasks;
	}
	public void setTasks(TaskInstanceInfo[] tasks) {
		this.tasks = tasks;
	}

	public int getNumberOfSubInstances() {
		return numberOfSubInstances;
	}
	public void setNumberOfSubInstances(int numberOfSubInstances) {
		this.numberOfSubInstances = numberOfSubInstances;
	}
	public WorkInstance() {
		super();
		super.setType(Instance.TYPE_WORK);
	}

	public WorkInstance(String id, String subject, Work work, User owner, User lastModifier,
			LocalDate lastModifiedDate) {
		super(id, subject, Instance.TYPE_WORK, owner, lastModifier, lastModifiedDate);
		super.setWork(work);
	}
}
