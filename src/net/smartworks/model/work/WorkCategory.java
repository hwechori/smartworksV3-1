package net.smartworks.model.work;

public class WorkCategory extends Work {

	public final static int	TYPE_CATEGORY	= 11;
	
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
