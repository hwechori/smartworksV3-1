package net.smartworks.model.community.info;

import net.smartworks.model.community.User;
import net.smartworks.util.SmartUtil;

public class UserInfo extends WorkSpaceInfo {

	private String nickName;
	private int role = User.USER_ROLE_MEMBER;
	private DepartmentInfo department;
	private String position = "";
	private String phoneNo = "";
	private String cellPhoneNo = "";

	public String getNickName() {
		if(SmartUtil.isBlankObject(nickName)) return getName();
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
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
		if(!position.equals("")) return position + " " + super.getName();
		else return super.getName();
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getCellPhoneNo() {
		return cellPhoneNo;
	}
	public void setCellPhoneNo(String cellPhoneNo) {
		this.cellPhoneNo = cellPhoneNo;
	}
	public UserInfo(){
		super();
	}
	public UserInfo(String id, String name){
		super(id, name);
	}

	public String getEmailAddressShown(){
		return getLongName()  + " <" + getId() + ">";
	}
}
