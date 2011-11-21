package net.smartworks.model.instance;

import net.smartworks.model.community.User;
import net.smartworks.model.work.Work;
import net.smartworks.util.LocalDate;

public class CommentInstance extends Instance {

	public final static int COMMENT_TYPE_ON_WORK_DESC = 1;
	public final static int COMMENT_TYPE_ON_WORK_MANUAL = 2;
	public final static int COMMENT_TYPE_ON_WORK_INSTANCE = 3;
	public final static int COMMENT_TYPE_ON_TASK_INSTANCE = 4;

	private int commentType=-1;
	private Work work;
	private WorkInstance workInstance;
	private TaskInstance taskInstance;
	private User commentor;
	private String comment;

	public int getCommentType() {
		return commentType;
	}

	public void setCommentType(int commentType) {
		this.commentType = commentType;
	}

	public Work getWork() {
		return work;
	}

	public void setWork(Work work) {
		this.work = work;
	}

	public WorkInstance getWorkInstance() {
		return workInstance;
	}

	public void setWorkInstance(WorkInstance workInstance) {
		this.workInstance = workInstance;
	}

	public TaskInstance getTaskInstance() {
		return taskInstance;
	}

	public void setTaskInstance(TaskInstance taskInstance) {
		this.taskInstance = taskInstance;
	}

	public User getCommentor() {
		return commentor;
	}

	public void setCommentor(User commentor) {
		this.commentor = commentor;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public CommentInstance() {
		super();
	}

	public CommentInstance(String id, int commentType, String comment,
			User commentor, LocalDate lastModifiedDate) {
		super(id, "", Instance.TYPE_COMMENT, commentor, commentor,
				lastModifiedDate);
		this.commentType = commentType;
		this.commentor = commentor;
		this.comment = comment;
	}
}
