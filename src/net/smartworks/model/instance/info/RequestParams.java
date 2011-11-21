package net.smartworks.model.instance.info;

import net.smartworks.model.filter.SearchFilter;
import net.smartworks.model.instance.SortingField;

public class RequestParams {

	private int countInPage;
	private int pageNumber;
	private SortingField sortingField;
	private String searchKey;
	private SearchFilter searchFilter;
	
	public int getCountInPage() {
		return countInPage;
	}
	public void setCountInPage(int countInPage) {
		this.countInPage = countInPage;
	}
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
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
