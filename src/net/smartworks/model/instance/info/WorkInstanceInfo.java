package net.smartworks.model.instance.info;

import net.smartworks.model.community.info.UserInfo;
import net.smartworks.model.instance.Instance;
import net.smartworks.model.instance.WorkInstance;
import net.smartworks.model.work.SmartWork;
import net.smartworks.model.work.WorkCategory;
import net.smartworks.service.ISmartWorks;
import net.smartworks.util.LocalDate;

public class WorkInstanceInfo extends InstanceInfo {

	private TaskInstanceInfo lastTask;
	private int lastTaskCount = -1;
	private boolean haveNew = false;
	private int commentCount;
	private CommentInstanceInfo[] comments;

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
	public boolean isHaveNew() {
		return haveNew;
	}
	public void setHaveNew(boolean haveNew) {
		this.haveNew = haveNew;
	}
	public int getCommentCount() {
		return commentCount;
	}
	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}
	public CommentInstanceInfo[] getComments() {
		return comments;
	}
	public void setComments(CommentInstanceInfo[] comments) {
		this.comments = comments;
	}
	public String getController(){
		switch(getType()){
		case SmartWork.TYPE_INFORMATION:
			if(getId().equals(SmartWork.ID_FILE_MANAGEMENT))
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
		switch(getType()){
		case SmartWork.TYPE_INFORMATION:
			if(getId().equals(SmartWork.ID_FILE_MANAGEMENT))
				return ISmartWorks.CONTEXT_PREFIX_FILE_SPACE + getId();
			else if(getId().equals(SmartWork.ID_DEPARTMENT_MANAGEMENT))
				return ISmartWorks.CONTEXT_PREFIX_DEPARTMENT_SPACE + getId();
			else if(getId().equals(SmartWork.ID_GROUP_MANAGEMENT))
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
