package net.smartworks.model.work;

import net.smartworks.model.community.User;
import net.smartworks.util.LocalDate;

public class SmartWork extends Work {

	public final static int 	TYPE_INFORMATION 	= 11;
	public final static int 	TYPE_PROCESS 		= 12;
	public final static int 	TYPE_SCHEDULE 		= 13;
	
	private String 	fullpathName = null;
	private WorkCategory myGroup = null;
	private WorkCategory myCategory = null;
	private AccessPolicy accessPolicy = new AccessPolicy();
	private WritePolicy writePolicy = new WritePolicy();
	private EditPolicy editPolicy = new EditPolicy();
	private SmartForm[] forms = null;
	private User lastModifier;
	private LocalDate lastModifiedDate;

	public String getFullpathName() {
		return this.myCategory.getName() + ( (this.myGroup != null && this.myGroup.getId()!= null) ? ">" + this.myGroup.getName() : "") + ">" + super.getName();
	}
	public void setFullpathName(String fullpathName) {
		this.fullpathName = fullpathName;
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

	public SmartWork(){
		super();
	}
	public SmartWork(String id, String name){
		super(id, name);
	}
	public SmartWork(String id, String name, int type, String desc, WorkCategory myCategory){
		super(id, name, type, desc);
		this.myCategory = myCategory;
	}

}
