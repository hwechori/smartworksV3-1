package net.smartworks.model.community.info;

public class UserInfo extends WorkSpaceInfo {

	private String position;
	private DepartmentInfo department;

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
