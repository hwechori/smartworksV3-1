package net.smartworks.model.security;

import net.smartworks.model.community.Community;
import net.smartworks.model.community.info.CommunityInfo;

public class AccessPolicy {

	public final static int LEVEL_PRIVATE = 1;
	public final static int LEVEL_CUSTOM = 2;
	public final static int LEVEL_PUBLIC = 3;
	public final static int LEVEL_DEFAULT = LEVEL_PUBLIC;
	
	private int level = LEVEL_DEFAULT;
	private CommunityInfo[] communitiesToOpen;
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}	
	public CommunityInfo[] getCommunitiesToOpen() {
		return communitiesToOpen;
	}
	public void setCommunitiesToOpen(CommunityInfo[] communitiesToOpen) {
		this.communitiesToOpen = communitiesToOpen;
	}
	public AccessPolicy(){
		super();
	}
	
	public AccessPolicy(int level){
		super();
		this.level = level;
	}
}
