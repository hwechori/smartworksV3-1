package net.smartworks.model.work;

import net.smartworks.model.BaseObject;

public class SmartTask extends BaseObject{

	private SmartForm form;

	public SmartForm getForm() {
		return form;
	}
	public void setForm(SmartForm form) {
		this.form = form;
	}

	public SmartTask(){
		super();
	}
	public SmartTask(String id, String name){
		super(id, name);
	}
}
