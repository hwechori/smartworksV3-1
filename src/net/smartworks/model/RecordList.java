package net.smartworks.model;

public class RecordList {
	
	public static final int TYPE_WORK_HOUR_LIST = 1;
	public static final int TYPE_COMPANY_EVENT_LIST = 2;
	public static final int TYPE_APPROVAL_LINE_LIST = 3;
	public static final int TYPE_WEB_SERVICE_LIST = 4;
	public static final int TYPE_EXTERNAL_FORM_LIST = 5;
	public static final int DEFAULT_PAGE_SIZE = 20;
		
	private int type;
	private BaseObject[] records;
	private int pageSize=DEFAULT_PAGE_SIZE;
	private int	totalPages=1;
	private int currentPage=1;
	
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getPageSize() {
		return pageSize;
	}
	public BaseObject[] getRecords() {
		return records;
	}
	public void setRecords(BaseObject[] records) {
		this.records = records;
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
	public RecordList(){
		super();
	}
}
