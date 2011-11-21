package net.smartworks.model.work;

import net.smartworks.model.community.User;
import net.smartworks.model.filter.SearchFilter;
import net.smartworks.model.security.AccessPolicy;
import net.smartworks.model.security.EditPolicy;
import net.smartworks.model.security.WritePolicy;
import net.smartworks.util.LocalDate;

public class SmartWork extends Work {

	public final static int TYPE_INFORMATION = 21;
	public final static int TYPE_PROCESS = 22;
	public final static int TYPE_SCHEDULE = 23;

	private WorkCategory myGroup = null;
	private WorkCategory myCategory = null;
	private AccessPolicy accessPolicy = new AccessPolicy();
	private WritePolicy writePolicy = new WritePolicy();
	private EditPolicy editPolicy = new EditPolicy();
	private SearchFilter[] searchFilters;
	private User lastModifier;
	private LocalDate lastModifiedDate;

	public String getFullpathName() {
		return this.myCategory.getName() + ((this.myGroup != null && this.myGroup.getId() != null) ? " > " + this.myGroup.getName() : "") + " > "
				+ super.getName();
	}

	public WorkCategory getMyGroup() {
		return myGroup;
	}
	public void setMyGroup(WorkCategory myGroup) {
		this.myGroup = myGroup;
	}
	public WorkCategory getMyCategory() {
		return myCategory;
	}
	public void setMyCategory(WorkCategory myCategory) {
		this.myCategory = myCategory;
	}
	public AccessPolicy getAccessPolicy() {
		return accessPolicy;
	}
	public void setAccessPolicy(AccessPolicy accessPolicy) {
		this.accessPolicy = accessPolicy;
	}
	public WritePolicy getWritePolicy() {
		return writePolicy;
	}
	public void setWritePolicy(WritePolicy writePolicy) {
		this.writePolicy = writePolicy;
	}
	public EditPolicy getEditPolicy() {
		return editPolicy;
	}
	public void setEditPolicy(EditPolicy editPolicy) {
		this.editPolicy = editPolicy;
	}
	public SearchFilter[] getSearchFilters() {
		return searchFilters;
	}
	public void setSearchFilters(SearchFilter[] searchFilters) {
		this.searchFilters = searchFilters;
	}

	public User getLastModifier() {
		return lastModifier;
	}

	public void setLastModifier(User lastModifier) {
		this.lastModifier = lastModifier;
	}

	public LocalDate getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(LocalDate lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public SmartWork() {
		super();
	}

	public SmartWork(String id, String name) {
		super(id, name);
	}

	public SmartWork(String id, String name, int type, String desc, WorkCategory myCategory) {
		super(id, name, type, desc);
		this.myCategory = myCategory;
	}

	public SearchFilter getSearchFilterById(String id, User currentUser){

		if(id.equals(SearchFilter.FILTER_ALL_INSTANCES)) return null;
		if(id.equals(SearchFilter.FILTER_MY_INSTANCES)) return SearchFilter.getMyInstancesFilter(currentUser);
		if(id.equals(SearchFilter.FILTER_RECENT_INSTANCES)) return SearchFilter.getRecentInstancesFilter();
		if(id.equals(SearchFilter.FILTER_MY_RECENT_INSTANCES)) return SearchFilter.getMyRecentInstancesFilter(currentUser);
		if(id.equals(SearchFilter.FILTER_MY_RUNNING_INSTANCES)) return SearchFilter.getMyRunningInstancesFilter(currentUser);

		if(this.searchFilters != null){
			for(SearchFilter filter : this.searchFilters){
				if(filter.getId().equals(id)) return filter;
			}
		}
		return null;
	}

}
