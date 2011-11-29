package net.smartworks.model.work;

import net.smartworks.model.community.User;
import net.smartworks.model.filter.SearchFilter;
import net.smartworks.model.filter.info.SearchFilterInfo;
import net.smartworks.model.report.info.ReportInfo;
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
	private ReportInfo[] reports;
	private SearchFilterInfo[] searchFilters;
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
	public SearchFilterInfo[] getSearchFilters() {
		return searchFilters;
	}
	public void setSearchFilters(SearchFilterInfo[] searchFilters) {
		this.searchFilters = searchFilters;
	}

	public ReportInfo[] getReports() {
		return reports;
	}
	public void setReports(ReportInfo[] reports) {
		this.reports = reports;
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

}
