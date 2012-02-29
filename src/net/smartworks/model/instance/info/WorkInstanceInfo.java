package net.smartworks.model.instance.info;

import net.smartworks.model.community.info.UserInfo;
import net.smartworks.model.instance.Instance;
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
	public WorkInstanceInfo(){
		super();
		super.setType(Instance.TYPE_WORK);
	}	
	public WorkInstanceInfo(String id, String subject, UserInfo owner, UserInfo lastModifier,
			LocalDate lastModifiedDate) {
		super(id, subject, Instance.TYPE_WORK, owner, lastModifier, lastModifiedDate);
	}
	
}
