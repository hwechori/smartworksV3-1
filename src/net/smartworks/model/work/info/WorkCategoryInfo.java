package net.smartworks.model.work.info;

import net.smartworks.model.work.WorkCategory;

public class WorkCategoryInfo extends WorkInfo {

	private boolean running;
	
	public boolean isRunning() {
		return running;
	}
	public void setRunning(boolean running) {
		this.running = running;
	}
	public WorkCategoryInfo(){
		super();
		super.setType(WorkCategory.TYPE_CATEGORY);
	}
	public WorkCategoryInfo(String id, String name){
		super(id, name, WorkCategory.TYPE_CATEGORY);
	}
	

}
