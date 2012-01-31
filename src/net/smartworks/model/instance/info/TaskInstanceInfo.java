package net.smartworks.model.instance.info;

import net.smartworks.model.community.info.UserInfo;
import net.smartworks.model.instance.Instance;
import net.smartworks.util.LocalDate;

public class TaskInstanceInfo extends InstanceInfo {
	
	private String name;
	private int taskType=-1;
	private WorkInstanceInfo  workInstance;
	private UserInfo assignee;
	private UserInfo performer;
	private String formId;
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
	public WorkInstanceInfo getWorkInstance() {
		return workInstance;
	}
	public void setWorkInstance(WorkInstanceInfo workInstance) {
		this.workInstance = workInstance;
	}
	public UserInfo getAssignee() {
		return assignee;
	}
	public void setAssignee(UserInfo assignee) {
		this.assignee = assignee;
	}
	public UserInfo getPerformer() {
		return performer;
	}
	public void setPerformer(UserInfo performer) {
		this.performer = performer;
	}

	public String getFormId() {
		return formId;
	}
	public void setFormId(String formId) {
		this.formId = formId;
	}
	public TaskInstanceInfo(){
		super();
	}
	
	public TaskInstanceInfo(String id, String name, int taskType, UserInfo owner,
			UserInfo performer, LocalDate lastModifiedDate) {
		super(id, name, Instance.TYPE_TASK, owner, performer, lastModifiedDate);
		this.name = name;
		this.taskType = taskType;
	}
}
