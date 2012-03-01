package net.smartworks.model.instance.info;

import net.smartworks.model.community.info.UserInfo;
import net.smartworks.model.instance.Instance;
import net.smartworks.model.instance.TaskInstance;
import net.smartworks.model.instance.WorkInstance;
import net.smartworks.model.work.SmartWork;
import net.smartworks.model.work.WorkCategory;
import net.smartworks.service.ISmartWorks;
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
	public String getController(){
		if(getWork()==null) return "";
		switch(getWork().getType()){
		case SmartWork.TYPE_INFORMATION:
			return WorkInstance.CONTROLLER_IWORK_SPACE;
		case SmartWork.TYPE_PROCESS:
			return WorkInstance.CONTROLLER_PWORK_SPACE;
		case SmartWork.TYPE_SCHEDULE:
			return WorkInstance.CONTROLLER_SWORK_SPACE;
		case WorkCategory.TYPE_CATEGORY:
			return "";
		}
		return "";
	}
	public String getContextId(){
		if(getWork()==null || getWorkInstance()==null) return "";
		switch(getWork().getType()){
		case SmartWork.TYPE_INFORMATION:
			return ISmartWorks.CONTEXT_PREFIX_IWORK_SPACE + getWorkInstance().getId();
		case SmartWork.TYPE_PROCESS:
			return ISmartWorks.CONTEXT_PREFIX_PWORK_SPACE + getWorkInstance().getId();
		case SmartWork.TYPE_SCHEDULE:
			return ISmartWorks.CONTEXT_PREFIX_SWORK_SPACE + getWorkInstance().getId();
		case WorkCategory.TYPE_CATEGORY:
			return "";
		}
		return "";
	}
	
	public TaskInstanceInfo(){
		super();
		super.setType(Instance.TYPE_TASK);
	}
	
	public TaskInstanceInfo(String id, String name, int taskType, UserInfo owner,
			UserInfo performer, LocalDate lastModifiedDate) {
		super(id, name, Instance.TYPE_TASK, owner, performer, lastModifiedDate);
		this.name = name;
		this.taskType = taskType;
	}
}
