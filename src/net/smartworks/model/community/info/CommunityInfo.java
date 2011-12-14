package net.smartworks.model.community.info;

import net.smartworks.model.BaseObject;
import net.smartworks.model.community.Community;

public class CommunityInfo extends BaseObject {
	
	private String minPictureName;
	private String midPictureName;

	public String getMinPictureName() {
		return minPictureName;
	}
	public void setMinPictureName(String minPictureName) {
		this.minPictureName = minPictureName;
	}
	public String getMidPictureName() {
		return midPictureName;
	}
	public void setMidPictureName(String midPictureName) {
		this.midPictureName = midPictureName;
	}
	public String getMinPicture(){
		return Community.PICTURE_PATH + getMinPictureName();
	}
	public String getMidPicture(){
		return Community.PICTURE_PATH + getMidPictureName();
	}

	public CommunityInfo(){
		super();
	}
	public CommunityInfo(String id, String name){
		super(id, name);
	}
}
