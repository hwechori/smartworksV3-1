package net.smartworks.model.filter;

import net.smartworks.model.BaseObject;

public class SearchFilter extends BaseObject{
	
	public static final int BASIC_FILTER_ALL_INSTANCES = 1;
	public static final int BASIC_FILTER_MY_INSTANCES = 2;
	public static final int BASIC_FILTER_RECENT_INSTANCES = 3;
	public static final int BASIC_FILTER_MY_RECENT_INSTANCES = 4;
	
	private Condition[] conditions;

	public Condition[] getConditions() {
		return conditions;
	}
	public void setConditions(Condition[] conditions) {
		this.conditions = conditions;
	}

	public SearchFilter(){
	}

}
