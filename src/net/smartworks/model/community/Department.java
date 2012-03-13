package net.smartworks.model.community;

import net.smartworks.model.community.info.DepartmentInfo;
import net.smartworks.model.community.info.UserInfo;

public class Department extends WorkSpace {

	public static final String  DEFAULT_DEPART_PICTURE  = "default_depart_picture";

	private String 	desc = null;
	private DepartmentInfo parent = null;
	private User	head = null;
	private UserInfo[]	members = null;
	private DepartmentInfo[] children = null;

	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public DepartmentInfo getParent() {
		return parent;
	}
	public void setParent(DepartmentInfo parent) {
		this.parent = parent;
	}
	public User getHead() {
		return head;
	}
	public void setHead(User head) {
		this.head = head;
	}
	public UserInfo[] getMembers() {
		return members;
	}
	public void setMembers(UserInfo[] members) {
		this.members = members;
	}
	public DepartmentInfo[] getChildren() {
		return children;
	}
	public void setChildren(DepartmentInfo[] children) {
		this.children = children;
	}
	
	public Department(){
		super();
	}
	
	public Department(String id, String name){
		super(id, name);
	}
	
	public Department(String id, String name, UserInfo[] members){

		super(id, name);
		this.members = members;
	}

	public Department(String id, String name, UserInfo[] members, User head){
		
		super(id, name);
		this.members = members;
		this.head = head;
	}

	public DepartmentInfo getDepartmentInfo(){
		DepartmentInfo departmentInfo = new DepartmentInfo(getId(), getName());
		departmentInfo.setBigPictureName(getBigPictureName());
		departmentInfo.setDesc(getDesc());
		departmentInfo.setSmallPictureName(getSmallPictureName());
		return departmentInfo;
	}
}
