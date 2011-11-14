package net.smartworks.model.community;


public class Group extends WorkSpace{

	private String	desc = null;
	private boolean	isPublic = false;
	private User	leader = null;
	private User[] 	members = null;
	private User	owner = null;

	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public boolean isPublic() {
		return isPublic;
	}
	public void setPublic(boolean isPublic) {
		this.isPublic = isPublic;
	}
	public User getLeader() {
		return leader;
	}
	public void setLeader(User leader) {
		this.leader = leader;
	}
	public User[] getMembers() {
		return members;
	}
	public void setMembers(User[] members) {
		this.members = members;
	}
	public User getOwner() {
		return owner;
	}
	public void setOwner(User owner) {
		this.owner = owner;
	}

	public Group(){
		super();
	}
	public Group(String id, String name){
		super(id, name);
	}
	public Group(String id, String name, User[] members){
		
		super(id, name);
		this.members = members;
	}
	public Group(String id, String name, User[] members, User leader){
		
		super(id, name);
		this.members = members;
		this.leader = leader;
	}
}
