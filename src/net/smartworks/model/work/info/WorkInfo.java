package net.smartworks.model.work.info;

import net.smartworks.model.BaseObject;
import net.smartworks.model.work.Work;

public class WorkInfo extends BaseObject {
	
	private int type;
	private String desc;
	private int providedBy = Work.PROVIDED_BY_USER;
	
	public int getProvidedBy() {
		return providedBy;
	}
	public void setProvidedBy(int providedBy) {
		this.providedBy = providedBy;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public WorkInfo(){
		super();
	}

	public WorkInfo(String id, String name, int type){
		super(id, name);
		this.type = type;
	}
	
}
