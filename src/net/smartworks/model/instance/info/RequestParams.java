package net.smartworks.model.instance.info;

import net.smartworks.model.filter.SearchFilter;
import net.smartworks.model.instance.SortingField;

public class RequestParams {

	public static final int PAGING_ACTION_NEXT10 = 1;
	public static final int PAGING_ACTION_NEXTEND = 2;
	public static final int PAGING_ACTION_PREV10 = 3;
	public static final int PAGING_ACTION_PREVEND = 4;
	public static final int DEFAULT_PAGE_SIZE = 20;
	
	private int pageSize=DEFAULT_PAGE_SIZE;
	private int currentPage=1;
	private int pagingAction;
	private SortingField sortingField;
	private String searchKey;
	private String filterId;
	private SearchFilter searchFilter;
	
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPagingAction() {
		return pagingAction;
	}
	public void setPagingAction(int pagingAction) {
		this.pagingAction = pagingAction;
	}
	public String getFilterId() {
		return filterId;
	}
	public void setFilterId(String filterId) {
		this.filterId = filterId;
	}
	public SortingField getSortingField() {
		return sortingField;
	}
	public void setSortingField(SortingField sortingField) {
		this.sortingField = sortingField;
	}
	public String getSearchKey() {
		return searchKey;
	}
	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}
	public SearchFilter getSearchFilter() {
		return searchFilter;
	}
	public void setSearchFilter(SearchFilter searchFilter) {
		this.searchFilter = searchFilter;
	}

	public RequestParams() {
		super();
	}
}
