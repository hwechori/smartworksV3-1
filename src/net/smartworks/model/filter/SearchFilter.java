package net.smartworks.model.filter;

import net.smartworks.model.BaseObject;

public class SearchFilter extends BaseObject{

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
