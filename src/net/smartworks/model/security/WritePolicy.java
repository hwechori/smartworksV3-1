package net.smartworks.model.security;

import net.smartworks.model.community.Community;
import net.smartworks.model.community.info.CommunityInfo;
import net.smartworks.model.community.info.DepartmentInfo;
import net.smartworks.model.community.info.GroupInfo;
import net.smartworks.model.community.info.UserInfo;
import net.smartworks.service.impl.SmartWorks;
import net.smartworks.util.SmartUtil;

public class WritePolicy {

	public final static int LEVEL_CUSTOM = 1;
	public final static int LEVEL_PUBLIC = 2;
	public final static int LEVEL_DEFAULT = LEVEL_PUBLIC;
	
	private int level = LEVEL_DEFAULT;
	private CommunityInfo[] communitiesToWrite;
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}	
	public WritePolicy(){
		super();
	}	
	public CommunityInfo[] getCommunitiesToWrite() {
		return communitiesToWrite;
	}
	public void setCommunitiesToWrite(CommunityInfo[] communitiesToWrite) {
		this.communitiesToWrite = communitiesToWrite;
	}
	public WritePolicy(int level){
		super();
		this.level = level;
	}

	public boolean isWritableForMe(){
		if(this.level == WritePolicy.LEVEL_PUBLIC){
			return true;
		}else if(this.level == WritePolicy.LEVEL_CUSTOM){
			if(SmartUtil.isBlankObject(communitiesToWrite)) return false;
			SmartWorks smartWorks = new SmartWorks();
			DepartmentInfo[] myDepartments = null;
			GroupInfo[] myGroups = null;
			try{
				myDepartments = smartWorks.getMyDepartments();
				myGroups = smartWorks.getMyGroups();
			}catch (Exception e){				
			}
			for(CommunityInfo community : communitiesToWrite ){
				if(community.getClass().equals(UserInfo.class) && community.getId().equals(SmartUtil.getCurrentUser().getId())){
					return true;
				}
				else if(community.getClass().equals(DepartmentInfo.class) && !SmartUtil.isBlankObject(myDepartments)){
					for(DepartmentInfo department : myDepartments)
						if(department.getId().equals(community.getId())) return true;
				}else if(community.getClass().equals(GroupInfo.class) && !SmartUtil.isBlankObject(myGroups)){
					for(GroupInfo group : myGroups)
						if(group.getId().equals(community.getId())) return true;
				}
			}
		}
		return false;
	}
}
