package net.smartworks.model.filter;

import net.smartworks.model.BaseObject;
import net.smartworks.model.community.User;
import net.smartworks.model.instance.WorkInstance;
import net.smartworks.model.work.FormField;

public class SearchFilter extends BaseObject{
	
	public static final String SYSTEM_FILTER_PREFIX = "system.";
	public static final String FILTER_ALL_INSTANCES = "allInstances";
	public static final String FILTER_MY_INSTANCES = SYSTEM_FILTER_PREFIX + "myInstances";
	public static final String FILTER_RECENT_INSTANCES = SYSTEM_FILTER_PREFIX + "recentInstances";
	public static final String FILTER_MY_RECENT_INSTANCES = SYSTEM_FILTER_PREFIX + "myRecentInstances";
	public static final String FILTER_MY_RUNNING_INSTANCES = SYSTEM_FILTER_PREFIX + "myRunningInstances";
	public static final String FILTER_MY_ASSIGEND_INSTANCES = SYSTEM_FILTER_PREFIX + "myAssignedInstances";

	private Condition[] conditions;

	public Condition[] getConditions() {
		return conditions;
	}
	public void setConditions(Condition[] conditions) {
		this.conditions = conditions;
	}

	public boolean isSystemFilter(){
		if(super.getId().contains(SYSTEM_FILTER_PREFIX)) return true;
		return false;
	}
	
	public SearchFilter(){
	}
	
	public SearchFilter(Condition[] conditions){
		super();
		this.conditions = conditions;
	}

	public static SearchFilter getMyInstancesFilter(User currentUser){
		return new SearchFilter(new Condition[] {new Condition(FormField.FIELD_OWNER, ConditionOperator.EQUAL.getId(), currentUser )});
	}

	public static SearchFilter getRecentInstancesFilter(){
		return new SearchFilter(new Condition[] {new Condition(FormField.FIELD_LAST_MODIFIED_DATE, ConditionOperator.RECENT_DAYS.getId(), null)});
	}
	public static SearchFilter getMyRecentInstancesFilter(User currentUser){
		return new SearchFilter(new Condition[] {new Condition(FormField.FIELD_OWNER, ConditionOperator.EQUAL.getId(), currentUser ),
				new Condition(FormField.FIELD_LAST_MODIFIED_DATE, ConditionOperator.RECENT_DAYS.getId(), null)});
	}
	public static SearchFilter getMyRunningInstancesFilter(User currentUser){
		return new SearchFilter(new Condition[] {new Condition(FormField.FIELD_OWNER, ConditionOperator.EQUAL.getId(), currentUser ),
				new Condition(FormField.FIELD_STATUS, ConditionOperator.NOT_EQUAL.getId(), WorkInstance.STATUS_NOT_YET ),
				new Condition(FormField.FIELD_STATUS, ConditionOperator.NOT_EQUAL.getId(), WorkInstance.STATUS_COMPLETED )});
	}

}
