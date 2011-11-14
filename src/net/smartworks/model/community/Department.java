package net.smartworks.model.community;

import net.smartworks.model.BaseObject;

public class Department extends WorkSpace {
	
	private String 	desc = null;
	private Department parent = null;
	private User	head = null;
	private User[]	members = null;
	private Department[] children = null;

	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Department getParent() {
		return parent;
	}
	public void setParent(Department parent) {
		this.parent = parent;
	}
	public User getHead() {
		return head;
	}
	public void setHead(User head) {
		this.head = head;
	}
	public User[] getMembers() {
		return members;
	}
	public void setMembers(User[] members) {
		this.members = members;
	}
	public Department[] getChildren() {
		return children;
	}
	public void setChildren(Department[] children) {
		this.children = children;
	}
	
	public Department(){
		super();
	}
	
	public Department(String id, String name){
		super(id, name);
	}
	
	public Department(String id, String name, User[] members){

		super(id, name);
		this.members = members;
	}

	public Department(String id, String name, User[] members, User head){
		
		super(id, name);
		this.members = members;
		this.head = head;
	}
}
