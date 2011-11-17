package net.smartworks.model.work;

public class WorkCategory extends Work {
	
	private String 	desc = null;
	
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}

	public WorkCategory(String id, String name){
		super(id, name);
	}	
}
