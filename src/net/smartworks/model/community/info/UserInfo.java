package net.smartworks.model.community.info;

import net.smartworks.model.community.User;

public class UserInfo extends WorkSpaceInfo {

	private String position;
	private DepartmentInfo department;
	
	public String getMidPictureName() {
		if(super.getMidPictureName()!=null && !super.getMidPictureName().equals(""))
			return super.getMidPictureName();
		else  return (User.NO_USER_PICTURE + "_mid.jpg");
	}
	public String getMinPictureName() {
		if(super.getMinPictureName()!=null && !super.getMinPictureName().equals(""))
			return super.getMinPictureName();
		else  return (User.NO_USER_PICTURE + "_min.jpg");
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public DepartmentInfo getDepartment() {
		return department;
	}
	public void setDepartment(DepartmentInfo department) {
		this.department = department;
	}
	public String getLongName(){
		return position + " " + super.getName();
	}
	
	public UserInfo(){
		super();
	}
	public UserInfo(String id, String name){
		super(id, name);
	}
}
