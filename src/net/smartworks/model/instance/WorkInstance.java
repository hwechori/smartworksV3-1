package net.smartworks.model.instance;

import net.smartworks.model.community.User;
import net.smartworks.model.instance.info.TaskInstanceInfo;
import net.smartworks.model.work.SmartWork;
import net.smartworks.model.work.Work;
import net.smartworks.model.work.WorkCategory;
import net.smartworks.service.ISmartWorks;
import net.smartworks.util.LocalDate;

public class WorkInstance extends Instance {

	public static final int TYPE_PROCESS = 31;
	public static final int TYPE_INFORMATION = 32;
	public static final int TYPE_SCHEDULE = 33;

	public static final String CONTROLLER_IWORK_SPACE = "iwork_space.sw";
	public static final String CONTROLLER_PWORK_SPACE = "pwork_space.sw";
	public static final String CONTROLLER_SWORK_SPACE = "swork_space.sw";
	public static final String CONTROLLER_FILE_SPACE = "file_space.sw";

	public static final int DEFAULT_SUB_INSTANCE_FETCH_COUNT = 3; 
	public static final int FETCH_ALL_SUB_INSTANCE = -1; 
	
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
	public String getController(){
		if(getWork()==null) return "";
		switch(getWork().getType()){
		case SmartWork.TYPE_INFORMATION:
			if(getWork().getId().equals(SmartWork.ID_FILE_MANAGEMENT))
				return WorkInstance.CONTROLLER_FILE_SPACE;
			else
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
		if(getWork()==null) return "";
		switch(getWork().getType()){
		case SmartWork.TYPE_INFORMATION:
			if(SmartWork.ID_FILE_MANAGEMENT.equals(getWork().getId()))
				return ISmartWorks.CONTEXT_PREFIX_FILE_SPACE + getId();
			else if(SmartWork.ID_DEPARTMENT_MANAGEMENT.equals(getWork().getId()))
				return ISmartWorks.CONTEXT_PREFIX_DEPARTMENT_SPACE + getId();
			else if(SmartWork.ID_GROUP_MANAGEMENT.equals(getWork().getId()))
				return ISmartWorks.CONTEXT_PREFIX_GROUP_SPACE + getId();
			else
				return ISmartWorks.CONTEXT_PREFIX_IWORK_SPACE + getId();
		case SmartWork.TYPE_PROCESS:
			return ISmartWorks.CONTEXT_PREFIX_PWORK_SPACE + getId();
		case SmartWork.TYPE_SCHEDULE:
			return ISmartWorks.CONTEXT_PREFIX_SWORK_SPACE + getId();
		case WorkCategory.TYPE_CATEGORY:
			return "";
		}
		return "";
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
