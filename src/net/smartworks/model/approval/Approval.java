package net.smartworks.model.approval;

import net.smartworks.model.BaseObject;
import net.smartworks.model.community.User;

public class Approval extends BaseObject{
	
	public static final int APPROVER_MY_BOSS = 1;
	public static final int APPROVER_CHOOSE_USER = 2;
	public static final int APPROVER_CHOOSE_ON_RUNNING = 3;

	private String name;
	private int approverType;
	private User approver;

	public void setName(String name) {
		this.name = name;
	}
	public int getApproverType() {
		return approverType;
	}
	public void setApproverType(int approverType) {
		this.approverType = approverType;
	}
	public User getApprover() {
		return approver;
	}
	public void setApprover(User approver) {
		this.approver = approver;
	}
	
	public Approval(){
		super();
	}
	
	public Approval(String id, String name){
		super(id, name);
	}
}
