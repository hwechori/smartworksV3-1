package net.smartworks.model.work.info;

import net.smartworks.model.BaseObject;
import net.smartworks.model.work.FormField;
import net.smartworks.model.work.SmartForm;

public class SmartFormInfo extends BaseObject{

	private String description;
	private String minImageName;
	private String orgImageName;
	
	public String getDescription(){
		return this.description;
	}
	public void setDescription(String description){
		this.description = description;
	}
	public String getMinImageName() {
		return 		super.getId() + "_min.jpg";
	}
	public void setMinImageName(String minImageName) {
		this.minImageName = minImageName;
	}
	public String getOrgImageName() {
		return 		super.getId() + ".jpg";
	}
	public void setOrgImageName(String orgImageName) {
		this.orgImageName = orgImageName;
	}
	public String getOrgImage(){
		return SmartForm.FORM_IMAGE_PATH + getOrgImageName();
	}
	public String getMinImage(){
		return SmartForm.FORM_IMAGE_PATH + getMinImageName();
	}
	public SmartFormInfo(){
		super();
	}
	public SmartFormInfo(String id, String name){
		super(id, name);
	}
}
