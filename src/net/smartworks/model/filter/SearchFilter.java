package net.smartworks.model.filter;

import net.smartworks.model.BaseObject;
import net.smartworks.model.community.User;
import net.smartworks.model.instance.WorkInstance;
import net.smartworks.model.work.FormField;

public class SearchFilter extends BaseObject{
	
	public static final String SYSTEM_FILTER_PREFIX = "system.";
	public static final String FILTER_ALL_INSTANCES = SYSTEM_FILTER_PREFIX + "allInstances";
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
		super();
	}
	
	public SearchFilter(String id, String name){
		super(id, name);
	}
	
	public SearchFilter(String id, String name, Condition[] conditions){
		super(id, name);
		this.conditions = conditions;
	}

	public static SearchFilter getMyInstancesFilter(User currentUser){
		return new SearchFilter(FILTER_MY_INSTANCES, FILTER_MY_INSTANCES, new Condition[] {new Condition(FormField.FIELD_OWNER, ConditionOperator.EQUAL.getId(), currentUser )});
	}

	public static SearchFilter getRecentInstancesFilter(){
		return new SearchFilter(FILTER_RECENT_INSTANCES, FILTER_RECENT_INSTANCES, new Condition[] {new Condition(FormField.FIELD_LAST_MODIFIED_DATE, ConditionOperator.RECENT_DAYS.getId(), null)});
	}
	public static SearchFilter getMyRecentInstancesFilter(User currentUser){
		return new SearchFilter(FILTER_MY_RECENT_INSTANCES, FILTER_MY_RECENT_INSTANCES, new Condition[] {new Condition(FormField.FIELD_OWNER, ConditionOperator.EQUAL.getId(), currentUser ),
				new Condition(FormField.FIELD_LAST_MODIFIED_DATE, ConditionOperator.RECENT_DAYS.getId(), null)});
	}
	public static SearchFilter getMyRunningInstancesFilter(User currentUser){
		return new SearchFilter(FILTER_MY_RUNNING_INSTANCES, FILTER_MY_RUNNING_INSTANCES, new Condition[] {new Condition(FormField.FIELD_OWNER, ConditionOperator.EQUAL.getId(), currentUser ),
				new Condition(FormField.FIELD_STATUS, ConditionOperator.NOT_EQUAL.getId(), WorkInstance.STATUS_NOT_YET ),
				new Condition(FormField.FIELD_STATUS, ConditionOperator.NOT_EQUAL.getId(), WorkInstance.STATUS_COMPLETED )});
	}

}
