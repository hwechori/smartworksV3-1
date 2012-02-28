package net.smartworks.model.work;

import net.smartworks.model.community.User;
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
	
	public final static String ID_FILE_MANAGEMENT = "pkg_309666dd2bb5493c9d7e618b3a0aad96";
	public final static String ID_EVENT_MANAGEMENT = "pkg_c08a02b36192489fbc13fdb6bed6f5fc";
	public final static String ID_MEMO_MANAGEMENT = "pkg_d391d4cd01864b2cada59ab5a9b12cd5";
	public final static String ID_BOARD_MANAGEMENT = "pkg_62eeb90b11e1466b86d2d7c4dadf63ca";
	public final static String ID_COMPANY_MANAGEMENT = "pkg_fbbd1761c3f144d49337dc38119caa28";
	public final static String ID_DEPARTMENT_MANAGEMENT = "pkg_c2156de59c14435bb551c61c1593a442";
	public final static String ID_FORUM_MANAGEMENT = "pkg_af2c5abbdc694feab78b2706c31f3bde";
	public final static String ID_CONTACTS_MANAGEMENT = "pkg_dde3f719c50143cd821e6c46e8df8655";
	
	private WorkCategory myGroup = null;
	private WorkCategory myCategory = null;
	private AccessPolicy accessPolicy = new AccessPolicy();
	private WritePolicy writePolicy = new WritePolicy();
	private EditPolicy editPolicy = new EditPolicy();
	private String lastReportId;
	private ReportInfo[] reports;
	private String lastFilterId;
	private SearchFilterInfo[] searchFilters;
	private User creater;
	private LocalDate createdDate;
	private User lastModifier;
	private LocalDate lastModifiedDate;
	private boolean isRunning;
	private boolean isEditing;
	private User editingUser;
	private LocalDate editingStartDate;

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
	public String getLastReportId() {
		return lastReportId;
	}
	public void setLastReportId(String lastReportId) {
		this.lastReportId = lastReportId;
	}
	public String getLastFilterId() {
		return lastFilterId;
	}
	public void setLastFilterId(String lastFilterId) {
		this.lastFilterId = lastFilterId;
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
	public User getCreater() {
		return creater;
	}
	public void setCreater(User creater) {
		this.creater = creater;
	}
	public LocalDate getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
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
	public boolean isRunning() {
		return isRunning;
	}
	public void setRunning(boolean isRunning) {
		this.isRunning = isRunning;
	}
	public boolean isEditing() {
		return isEditing;
	}
	public void setEditing(boolean isEditing) {
		this.isEditing = isEditing;
	}
	public User getEditingUser() {
		return editingUser;
	}
	public void setEditingUser(User editingUser) {
		this.editingUser = editingUser;
	}
	public LocalDate getEditingStartDate() {
		return editingStartDate;
	}
	public void setEditingStartDate(LocalDate editingStartDate) {
		this.editingStartDate = editingStartDate;
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
