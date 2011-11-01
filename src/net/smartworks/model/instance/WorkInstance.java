package net.smartworks.model.instance;

import java.util.Date;

import net.smartworks.model.community.User;
import net.smartworks.model.work.Work;
import net.smartworks.util.LocalDate;

public class WorkInstance extends Instance {

	private TaskInstance[] tasks;
	private TaskInstance firstTask;
	private TaskInstance runningTask;	
	private User lastModifier;

	public TaskInstance[] getTasks() {
		return tasks;
	}
	public void setTasks(TaskInstance[] tasks) {
		this.tasks = tasks;
	}
	public TaskInstance getFirstTask() {
		return firstTask;
	}
	public void setFirstTask(TaskInstance firstTask) {
		this.firstTask = firstTask;
	}
	public TaskInstance getRunningTask() {
		return runningTask;
	}
	public void setRunningTask(TaskInstance runningTask) {
		this.runningTask = runningTask;
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
