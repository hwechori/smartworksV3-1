package net.smartworks.model.instance;

public class InstanceList {
	
	public static final int TYPE_PROCESS_INSTANCE_LIST = 1;
	public static final int TYPE_INFORMATION_INSTANCE_LIST = 2;
	public static final int TYPE_SCHDULE_INSTANCE_LIST = 3;
	
	private int type;
	private InstanceRecord[]	instanceDatas;
	private int countInPage;
	private int	totalPages;
	private int currentPage;
	
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public InstanceRecord[] getInstanceDatas() {
		return instanceDatas;
	}
	public void setInstanceDatas(InstanceRecord[] instanceDatas) {
		this.instanceDatas = instanceDatas;
	}
	public int getCountInPage() {
		return countInPage;
	}
	public void setCountInPage(int countInPage) {
		this.countInPage = countInPage;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public InstanceList(){
		super();
	}
}
