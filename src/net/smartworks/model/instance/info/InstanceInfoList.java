package net.smartworks.model.instance.info;

import net.smartworks.model.instance.SortingField;
public class InstanceInfoList {
	
	public static final int TYPE_PROCESS_INSTANCE_LIST = 1;
	public static final int TYPE_INFORMATION_INSTANCE_LIST = 2;
	public static final int TYPE_SCHDULE_INSTANCE_LIST = 3;
	public static final int TYPE_MAIL_INSTANCE_LIST = 4;
	
	private int type;
	private InstanceInfo[]	instanceDatas;
	private SortingField sortedField;
	private int pageSize;
	private int	totalPages;
	private int currentPage;
	
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public InstanceInfo[] getInstanceDatas() {
		return instanceDatas;
	}
	public void setInstanceDatas(InstanceInfo[] instanceDatas) {
		this.instanceDatas = instanceDatas;
	}
	public SortingField getSortedField() {
		return sortedField;
	}
	public void setSortedField(SortingField sortedField) {
		this.sortedField = sortedField;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
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
	public InstanceInfoList(){
		super();
	}
}
