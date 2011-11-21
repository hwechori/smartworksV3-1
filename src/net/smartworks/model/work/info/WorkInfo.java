package net.smartworks.model.work.info;

import net.smartworks.model.BaseObject;

public class WorkInfo extends BaseObject {

	private int type;

	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}

	public WorkInfo(){
		super();
	}

	public WorkInfo(String id, String name, int type){
		super(id, name);
		this.type = type;
	}
	
}
