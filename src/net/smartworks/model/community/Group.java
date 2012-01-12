package net.smartworks.model.community;

import net.smartworks.model.community.info.UserInfo;


public class Group extends WorkSpace {

	public static final String DEFAULT_GROUP_PICTURE  = "default_group_picture";
	public static final String GROUP_TYPE_OPEN = "Open";
	public static final String GROUP_TYPE_CLOSED = "Closed";
	public static final String GROUP_TYPE_DEFAULT = GROUP_TYPE_OPEN;

	private String	desc = null;
	private boolean	isPublic = false;
	private User	leader = null;
	private UserInfo[] 	members = null;
	private User	owner = null;
	private String type = GROUP_TYPE_DEFAULT;

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
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
	public UserInfo[] getMembers() {
		return members;
	}
	public void setMembers(UserInfo[] members) {
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
	public Group(String id, String name, UserInfo[] members){
		
		super(id, name);
		this.members = members;
	}
	public Group(String id, String name, UserInfo[] members, User leader){
		
		super(id, name);
		this.members = members;
		this.leader = leader;
	}
}
