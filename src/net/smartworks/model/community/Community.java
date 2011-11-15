package net.smartworks.model.community;

import net.smartworks.model.BaseObject;

public class Community extends BaseObject {

	private String 	picturePath = null;
	private String 	orgPictureName = null;
	private String 	midPictureName = null;
	private String 	minPictureName = null;

	public String getPicturePath() {
		return "images/";
	}
	public void setPicturePath(String picturePath) {
		this.picturePath = picturePath;
	}
	public String getOrgPictureName() {
		return 		super.getId() + ".jpg";
	}
	public void setOrgPictureName(String orgPictureName) {
		this.orgPictureName = orgPictureName;
	}
	public String getMidPictureName() {
		return super.getId() + "_mid.jpg";
	}
	public void setMidPictureName(String midPictureName) {
		this.midPictureName = midPictureName;
	}
	public String getMinPictureName() {
		return super.getId() + "_min.jpg";
	}
	public void setMinPictureName(String minPictureName) {
		this.minPictureName = minPictureName;
	}
	
	public String getOrgPicture(){
		return getPicturePath() + getOrgPictureName();
	}
	public String getMidPicture(){
		return getPicturePath() + getMidPictureName();
	}
	public String getMinPicture(){
		return getPicturePath() + getMinPictureName();
	}
	
	public Community(){
		super();
	}
	public Community(String id, String name){
		super(id, name);
	}
}
