package net.smartworks.model.work;

import net.smartworks.model.BaseObject;

public class SmartGantt extends BaseObject{

	private String details;
	private String picturePath;
	private String minPictureName;
	private String orgPictureName;
	
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public String getPicturePath() {
		return picturePath;
	}
	public void setPicturePath(String picturePath) {
		this.picturePath = picturePath;
	}
	public String getMinPictureName() {
		return minPictureName;
	}
	public void setMinPictureName(String minPictureName) {
		this.minPictureName = minPictureName;
	}
	public String getOrgPictureName() {
		return orgPictureName;
	}
	public void setOrgPictureName(String orgPictureName) {
		this.orgPictureName = orgPictureName;
	}
	SmartGantt(){
		super();
	}
	SmartGantt(String id, String name){
		super(id, name);
	}
}
