package net.smartworks.model.work;

import net.smartworks.model.BaseObject;

public class SmartForm extends BaseObject{

	private String name;
	private String details;
	private String picturePath;
	private String minPictureName;
	private String orgPictureName;
	
	SmartForm(){
		super();
	}
	SmartForm(String id, String name){
		super(id, name);
	}
}
