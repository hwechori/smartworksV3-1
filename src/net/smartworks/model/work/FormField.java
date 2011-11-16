package net.smartworks.model.work;

import net.smartworks.model.BaseObject;

public class FormField extends BaseObject{

	private String type;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public FormField(){
		super();
	}
	public FormField(String id, String name, String type){
		super(id, name);
		this.setType(type);
	}
}
