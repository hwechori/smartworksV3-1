package net.smartworks.model.approval;

import net.smartworks.model.BaseObject;

public class ApprovalLine extends BaseObject{
	
	private String desc;
	private int approvalLevel=3;
	private Approval[] approvals;
	
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public int getApprovalLevel() {
		return approvalLevel;
	}
	public void setApprovalLevel(int approvalLevel) {
		this.approvalLevel = approvalLevel;
	}
	public Approval[] getApprovals() {
		return approvals;
	}
	public void setApprovals(Approval[] approvals) {
		this.approvals = approvals;
	}
	public ApprovalLine(){
		super();
	}
	public ApprovalLine(String id, String name){
		super(id, name);
	}	
}
