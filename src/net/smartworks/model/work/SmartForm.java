package net.smartworks.model.work;

import net.smartworks.model.BaseObject;

public class SmartForm extends BaseObject{

	public static final String FORM_IMAGE_PATH = "images/";
	public static final String  NO_FORM_IMAGE  = "no_form_image";

	public final static String ID_MEMMO_MANAGEMENT = "frm_9d4df59b25694c8ea13e07e0f0fb2579";
	public final static String NAME_MEMMO_MANAGEMENT = "개인메모";

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
		if(this.minImageName != null && !this.minImageName.equals(""))
			return this.minImageName;
		return 		NO_FORM_IMAGE + "_min.jpg";
	}
	public void setMinImageName(String minImageName) {
		this.minImageName = minImageName;
	}
	public String getOrgImageName() {
		if(this.orgImageName != null && !this.orgImageName.equals(""))
			return this.orgImageName;
		return 		NO_FORM_IMAGE + ".jpg";
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
