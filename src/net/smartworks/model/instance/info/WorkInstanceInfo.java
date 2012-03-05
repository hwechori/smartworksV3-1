package net.smartworks.model.instance.info;

import net.smartworks.model.community.info.UserInfo;
import net.smartworks.model.instance.Instance;
import net.smartworks.model.instance.WorkInstance;
import net.smartworks.model.work.SmartWork;
import net.smartworks.model.work.WorkCategory;
import net.smartworks.service.ISmartWorks;
import net.smartworks.util.LocalDate;

public class WorkInstanceInfo extends InstanceInfo {

	public static final int DEFAULT_CONNECTED_WORK_FETCH_COUNT = 3; 
	
	private TaskInstanceInfo lastTask;
	private int lastTaskCount = -1;
	private int subInstanceCount;
	private InstanceInfo[] subInstances;

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
	public int getSubInstanceCount() {
		return subInstanceCount;
	}
	public void setSubInstanceCount(int subInstanceCount) {
		this.subInstanceCount = subInstanceCount;
	}
	public InstanceInfo[] getSubInstances() {
		return subInstances;
	}
	public void setSubInstances(InstanceInfo[] subInstances) {
		this.subInstances = subInstances;
	}
	public String getController(){
		if(getWork()==null) return "";
		switch(getWork().getType()){
		case SmartWork.TYPE_INFORMATION:
			if(SmartWork.ID_FILE_MANAGEMENT.equals(getWork().getId()))
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

	public WorkInstanceInfo(){
		super();
		super.setType(Instance.TYPE_WORK);
	}	
	public WorkInstanceInfo(String id, String subject, UserInfo owner, UserInfo lastModifier,
			LocalDate lastModifiedDate) {
		super(id, subject, Instance.TYPE_WORK, owner, lastModifier, lastModifiedDate);
	}
	
}
