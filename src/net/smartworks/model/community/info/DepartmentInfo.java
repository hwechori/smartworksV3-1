package net.smartworks.model.community.info;

import net.smartworks.model.community.Department;

public class DepartmentInfo extends WorkSpaceInfo {

	private String desc;
		
	public String getMidPictureName() {
		if(super.getMidPictureName()!=null && !super.getMidPictureName().equals(""))
			return super.getMidPictureName();
		else  return (Department.DEFAULT_DEPART_PICTURE + "_mid.gif");
	}
	public String getMinPictureName() {
		if(super.getMinPictureName()!=null && !super.getMinPictureName().equals(""))
			return super.getMinPictureName();
		else  return (Department.DEFAULT_DEPART_PICTURE + "_min.gif");
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public DepartmentInfo(){
		super();
	}
	public DepartmentInfo(String id, String name){
		super(id, name);
	}

}
