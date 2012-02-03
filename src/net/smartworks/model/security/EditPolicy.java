package net.smartworks.model.security;

import net.smartworks.util.SmartUtil;

public class EditPolicy {

	public final static int LEVEL_WIKI = 1;
	public final static int LEVEL_BLOG = 2;
	public final static int LEVEL_DEFAULT = LEVEL_WIKI;
	
	private int level = LEVEL_DEFAULT;
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}	
	public EditPolicy(){
		super();
	}	
	public EditPolicy(int level){
		super();
		this.level = level;
	}

	public boolean isEditableForMe(String ownerId){
		if(this.level == EditPolicy.LEVEL_WIKI || ownerId.equals(SmartUtil.getCurrentUser().getId()))
			return true;
		return false;
	}
}
