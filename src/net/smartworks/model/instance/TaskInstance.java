package net.smartworks.model.instance;

import java.util.Date;

import net.smartworks.model.community.User;
import net.smartworks.model.community.WorkSpace;
import net.smartworks.model.work.SmartForm;
import net.smartworks.util.LocalDate;

public class TaskInstance extends Instance {

	public final static int INFORMATION_TASK_CREATED = 11;
	public final static int INFORMATION_TASK_UDATED = 12;
	public final static int INFORMATION_TASK_DELETED = 13;
	public final static int INFORMATION_TASK_ASSIGNED = 14;
	public final static int INFORMATION_TASK_FORWARDED = 15;

	public final static int PROCESS_TASK_ASSIGNED = 21;
	public final static int PROCESS_TASK_FORWARDED = 22;

	public final static int SCHEDULE_TASK_ASSIGNED = 31;
	public final static int SCHEDULE_TASK_FORWARDED = 32;

	public final static int APPROVAL_TASK_ASSIGNED = 41;
	public final static int APPROVAL_TASK_FORWARDED = 42;

	private String name;
	private int taskType=-1;
	private WorkInstance workInstance;
	private User assignee;
	private User performer;
	private SmartForm smartForm;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTaskType() {
		return taskType;
	}

	public void setTaskType(int taskType) {
		this.taskType = taskType;
	}

	public User getAssignee() {
		return assignee;
	}

	public void setAssignee(User assignee) {
		this.assignee = assignee;
	}

	public WorkInstance getWorkInstance() {
		return workInstance;
	}

	public void setWorkInstance(WorkInstance workInstance) {
		this.workInstance = workInstance;
	}

	public User getPerformer() {
		return performer;
	}

	public void setPerformer(User performer) {
		this.performer = performer;
	}

	public SmartForm getSmartForm() {
		return smartForm;
	}

	public void setSmartForm(SmartForm smartForm) {
		this.smartForm = smartForm;
	}

	public TaskInstance() {
		super();
	}

	public TaskInstance(String id, String name, int taskType, User owner,
			LocalDate lastModifiedDate) {
		super(id, name, Instance.TYPE_TASK, owner, lastModifiedDate);
		this.name = name;
		this.taskType = taskType;
	}
}
