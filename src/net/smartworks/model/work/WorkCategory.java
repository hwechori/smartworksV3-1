package net.smartworks.model.work;

public class WorkCategory extends Work {

	public final static int	TYPE_CATEGORY	= 11;
	
	public final static String ID_DEFAULT_CATEGORY = "40288afb1b25f00b011b25f3c7950001";
	public final static String ID_DOWNLOADED_CATEGORY = "52fca4b219fef4f50119ffcd871b0000";
	
	private boolean isRunning;
		
	public boolean isRunning() {
		return isRunning;
	}
	public void setRunning(boolean isRunning) {
		this.isRunning = isRunning;
	}

	public WorkCategory(){
		
	}
	public WorkCategory(String id, String name){
		super(id, name);
		super.setType(TYPE_CATEGORY);
	}
	public WorkCategory(String id, String name, String desc){
		super(id, name, TYPE_CATEGORY, desc);
	}
}
