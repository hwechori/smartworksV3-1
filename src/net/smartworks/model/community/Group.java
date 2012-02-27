package net.smartworks.model.community;

import net.smartworks.model.community.info.UserInfo;
import net.smartworks.util.LocalDate;


public class Group extends WorkSpace {

	public static final String DEFAULT_GROUP_PICTURE  = "default_group_picture";
	public static final String GROUP_TYPE_OPEN = "Open";
	public static final String GROUP_TYPE_CLOSED = "Closed";
	public static final String GROUP_TYPE_DEFAULT = GROUP_TYPE_OPEN;
	//public static final String GROUP_STATUS_CONTINUE = "Continue";
	//public static final String GROUP_STATUS_SUSPEND = "Suspend";
	//public static final String GROUP_STATUS_DEFAULT = GROUP_STATUS_CONTINUE;

	private String	desc = null;
	private boolean	isPublic = false;
	//private boolean isContinue = false;
	private User	leader = null;
	private UserInfo[] 	members = null;
	private User	owner = null;
	private LocalDate openDate = null;
	private int numberOfGroupMember = 0;
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
//	public boolean isContinue() {
//		return isContinue;
//	}
//	public void setContinue(boolean isContinue) {
//		this.isContinue = isContinue;
//	}
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
	public LocalDate getOpenDate() {
		return openDate;
	}
	public void setOpenDate(LocalDate openDate) {
		this.openDate = openDate;
	}
	public int getNumberOfGroupMember() {
		return numberOfGroupMember;
	}
	public void setNumberOfGroupMember(int numberOfGroupMember) {
		this.numberOfGroupMember = numberOfGroupMember;
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
