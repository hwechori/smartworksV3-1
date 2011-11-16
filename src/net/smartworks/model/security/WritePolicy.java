package net.smartworks.model.security;

import net.smartworks.model.community.Community;

public class WritePolicy {

	public final static int LEVEL_CUSTOM = 1;
	public final static int LEVEL_PUBLIC = 2;
	public final static int LEVEL_DEFAULT = LEVEL_PUBLIC;
	
	private int level = LEVEL_DEFAULT;
	private Community[] communitiesToWrite;
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}	
	public WritePolicy(){
		super();
	}	
	public Community[] getCommunitiesToWrite() {
		return communitiesToWrite;
	}
	public void setCommunitiesToWrite(Community[] communitiesToWrite) {
		this.communitiesToWrite = communitiesToWrite;
	}
	public WritePolicy(int level){
		super();
		this.level = level;
	}
}
