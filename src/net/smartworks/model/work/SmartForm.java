package net.smartworks.model.work;

import net.smartworks.model.BaseObject;

public class SmartForm extends BaseObject{

	public static final String FORM_IMAGE_PATH = "images/";
	
	private String description;
	private String minImageName;
	private String orgImageName;
	private FormField[] fields;
	
	public FormField[] getFields() {
		return fields;
	}
	public void setFields(FormField[] fields) {
		this.fields = fields;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
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
		return FORM_IMAGE_PATH + getOrgImageName();
	}
	public String getMinImage(){
		return FORM_IMAGE_PATH + getMinImageName();
	}
	public SmartForm(){
		super();
	}
	public SmartForm(String id, String name){
		super(id, name);
	}
}
