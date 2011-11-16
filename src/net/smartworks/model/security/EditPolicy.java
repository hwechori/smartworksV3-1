package net.smartworks.model.security;

import net.smartworks.model.community.Community;

public class EditPolicy {

	public final static int LEVEL_PRIVATE = 1;
	public final static int LEVEL_CUSTOM = 2;
	public final static int LEVEL_PUBLIC = 3;
	public final static int LEVEL_DEFAULT = LEVEL_PUBLIC;
	
	private int level = LEVEL_DEFAULT;
	private Community[] communitiesToEdit;
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}	
	public EditPolicy(){
		super();
	}	
	public Community[] getCommunitiesToEdit() {
		return communitiesToEdit;
	}
	public void setCommunitiesToEdit(Community[] communitiesToEdit) {
		this.communitiesToEdit = communitiesToEdit;
	}
	public EditPolicy(int level){
		super();
		this.level = level;
	}
}
