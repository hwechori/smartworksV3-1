package net.smartworks.model.security;

import net.smartworks.model.community.Community;

public class AccessPolicy {

	public final static int LEVEL_PRIVATE = 1;
	public final static int LEVEL_CUSTOM = 2;
	public final static int LEVEL_PUBLIC = 3;
	public final static int LEVEL_DEFAULT = LEVEL_PUBLIC;
	
	private int level = LEVEL_DEFAULT;
	private Community[] communitiesToOpen;
	private Community[] communitiesToClose;
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}	
	public Community[] getCommunitiesToOpen() {
		return communitiesToOpen;
	}
	public void setCommunitiesToOpen(Community[] communitiesToOpen) {
		this.communitiesToOpen = communitiesToOpen;
	}
	public Community[] getCommunitiesToClose() {
		return communitiesToClose;
	}
	public void setCommunitiesToClose(Community[] communitiesToClose) {
		this.communitiesToClose = communitiesToClose;
	}
	public AccessPolicy(){
		super();
	}
	
	public AccessPolicy(int level){
		super();
		this.level = level;
	}
}
