package net.smartworks.model.instance;

public class RunningCounts {

	private int total;
	private int assignedOnly;
	
	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
	public int getAssignedOnly() {
		return assignedOnly;
	}
	public void setAssignedOnly(int assignedOnly) {
		this.assignedOnly = assignedOnly;
	}

	public RunningCounts() {
		super();
	}

	public RunningCounts(int total, int assignedOnly) {
		super();
		this.total = total;
		this.assignedOnly = assignedOnly;
	}
}
