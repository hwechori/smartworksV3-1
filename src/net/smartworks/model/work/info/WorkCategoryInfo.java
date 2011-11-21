package net.smartworks.model.work.info;

import net.smartworks.model.work.WorkCategory;

public class WorkCategoryInfo extends WorkInfo {

	public WorkCategoryInfo(){
		super();
	}
	public WorkCategoryInfo(String id, String name){
		super(id, name, WorkCategory.TYPE_CATEGORY);
	}
	

}
