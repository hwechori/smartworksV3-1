package net.smartworks.model.work;

import net.smartworks.model.BaseObject;
import net.smartworks.model.work.info.SmartTaskInfo;

public class SmartDiagram extends BaseObject{

	public static final String DIAGRAM_IMAGE_PATH = "images/";
	public static final String  NO_PROCESS_IMAGE  = "no_process_image";
	
	private String description;
	private String minImageName;
	private String orgImageName;
	private SmartTaskInfo[] tasks;
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getMinImageName() {
		if(this.minImageName != null && !this.minImageName.equals(""))
			return this.minImageName;
		return 		NO_PROCESS_IMAGE + "_min.jpg";
	}
	public void setMinImageName(String minImageName) {
		this.minImageName = minImageName;
	}
	public String getOrgImageName() {
		if(this.orgImageName != null && !this.orgImageName.equals(""))
			return this.orgImageName;
		return 		NO_PROCESS_IMAGE + ".jpg";
	}
	public void setOrgImageName(String orgImageName) {
		this.orgImageName = orgImageName;
	}
	public String getOrgImage(){
		return DIAGRAM_IMAGE_PATH + getOrgImageName();
	}
	public String getMinImage(){
		return DIAGRAM_IMAGE_PATH + getMinImageName();
	}
	public SmartTaskInfo[] getTasks() {
		return tasks;
	}
	public void setTasks(SmartTaskInfo[] tasks) {
		this.tasks = tasks;
	}
	public SmartDiagram(){
		super();
	}
	public SmartDiagram(String id, String name){
		super(id, name);
	}
}
