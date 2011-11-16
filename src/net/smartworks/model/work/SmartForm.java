package net.smartworks.model.work;

import net.smartworks.model.BaseObject;

public class SmartForm extends BaseObject{

	private String details;
	private String imagePath;
	private String minImageName;
	private String orgImageName;
	private FormField[] fields;
	
	public FormField[] getFields() {
		return fields;
	}
	public void setFields(FormField[] fields) {
		this.fields = fields;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public String getImagePath() {
		return "images/";
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
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
	public SmartForm(){
		super();
	}
	public SmartForm(String id, String name){
		super(id, name);
	}
}
