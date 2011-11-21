package net.smartworks.model.work.info;

public class SmartWorkInfo extends WorkInfo {

	private WorkCategoryInfo myGroup = null;
	private WorkCategoryInfo myCategory = null;

	public String getFullpathName(){
		return this.myCategory.getName() + ((this.myGroup != null && this.myGroup.getId() != null) ? " > " + this.myGroup.getName() : "") + " > "
				+ super.getName();		
	}
	public WorkCategoryInfo getMyGroup() {
		return myGroup;
	}
	public void setMyGroup(WorkCategoryInfo myGroup) {
		this.myGroup = myGroup;
	}
	public WorkCategoryInfo getMyCategory() {
		return myCategory;
	}
	public void setMyCategory(WorkCategoryInfo myCategory) {
		this.myCategory = myCategory;
	}

	public SmartWorkInfo(){
		super();
	}

	public SmartWorkInfo(String id, String name, int type, WorkCategoryInfo myGroup, WorkCategoryInfo myCategory){
		super(id, name, type);
		this.myGroup = myGroup;;
		this.myCategory = myCategory;
	}
	
	
}
