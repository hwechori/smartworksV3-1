package net.smartworks.model.community.info;

import net.smartworks.model.community.Group;

public class GroupInfo extends WorkSpaceInfo {

	public String getMidPictureName() {
		if(super.getMidPictureName()!=null && !super.getMidPictureName().equals(""))
			return super.getMidPictureName();
		else  return (Group.DEFAULT_GROUP_PICTURE + "_mid.gif");
	}
	public String getMinPictureName() {
		if(super.getMinPictureName()!=null && !super.getMinPictureName().equals(""))
			return super.getMinPictureName();
		else  return (Group.DEFAULT_GROUP_PICTURE + "_min.gif");
	}
	private String desc;
	
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public GroupInfo(){
		super();
	}
	public GroupInfo(String id, String name){
		super(id, name);
	}

}
