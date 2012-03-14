package net.smartworks.model.filter;

import net.smartworks.model.BaseObject;
import net.smartworks.model.community.User;
import net.smartworks.model.instance.WorkInstance;
import net.smartworks.model.security.AccessPolicy;
import net.smartworks.model.work.FormField;
import net.smartworks.util.LocalDate;

public class SearchFilter extends BaseObject{
	
	public static final String SYSTEM_FILTER_PREFIX = "system.";
	public static final String FILTER_ALL_INSTANCES = SYSTEM_FILTER_PREFIX + "allInstances";
	public static final String FILTER_MY_INSTANCES = SYSTEM_FILTER_PREFIX + "myInstances";
	public static final String FILTER_RECENT_INSTANCES = SYSTEM_FILTER_PREFIX + "recentInstances";
	public static final String FILTER_MY_RECENT_INSTANCES = SYSTEM_FILTER_PREFIX + "myRecentInstances";
	public static final String FILTER_MY_RUNNING_INSTANCES = SYSTEM_FILTER_PREFIX + "myRunningInstances";
	public static final String FILTER_MY_ASSIGEND_INSTANCES = SYSTEM_FILTER_PREFIX + "myAssignedInstances";
	public static final String FILTER_BY_WORK_ID = SYSTEM_FILTER_PREFIX + "byWorkId";
	public static final String FILTER_BY_FILE_CATEGORY_ID = SYSTEM_FILTER_PREFIX + "byFileCategoryId";
	public static final String FILTER_BY_FILE_TYPE = SYSTEM_FILTER_PREFIX + "byFileType";
	public static final String FILTER_BY_OWNER = SYSTEM_FILTER_PREFIX + "byOwner";
	public static final String FILTER_BY_CREATED_DATE = SYSTEM_FILTER_PREFIX + "byCreatedDate";
	
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

	public static SearchFilter getAllInstancesFilter(){
		return new SearchFilter(FILTER_ALL_INSTANCES, FILTER_ALL_INSTANCES, new Condition[]{});
	}
	public static SearchFilter getMyInstancesFilter(User currentUser){
		return new SearchFilter(FILTER_MY_INSTANCES, FILTER_MY_INSTANCES, new Condition[] {
						new Condition(FormField.FIELD_OWNER, ConditionOperator.EQUAL.getId(), currentUser )
					});
	}

	public static SearchFilter getRecentInstancesFilter(){
		return new SearchFilter(FILTER_RECENT_INSTANCES, FILTER_RECENT_INSTANCES, new Condition[] {
					new Condition(FormField.FIELD_LAST_MODIFIED_DATE, ConditionOperator.RECENT_DAYS.getId(), null)
				});
	}
	public static SearchFilter getMyRecentInstancesFilter(User currentUser){
		return new SearchFilter(FILTER_MY_RECENT_INSTANCES, FILTER_MY_RECENT_INSTANCES, new Condition[] {
					new Condition(FormField.FIELD_OWNER, ConditionOperator.EQUAL.getId(), currentUser ),
					new Condition(FormField.FIELD_LAST_MODIFIED_DATE, ConditionOperator.RECENT_DAYS.getId(), null)
				});
	}
	public static SearchFilter getMyRunningInstancesFilter(User currentUser){
		return new SearchFilter(FILTER_MY_RUNNING_INSTANCES, FILTER_MY_RUNNING_INSTANCES, new Condition[] {
					new Condition(FormField.FIELD_OWNER, ConditionOperator.EQUAL.getId(), currentUser ),
					new Condition(FormField.FIELD_STATUS, ConditionOperator.NOT_EQUAL.getId(), WorkInstance.STATUS_NOT_YET ),
					new Condition(FormField.FIELD_STATUS, ConditionOperator.NOT_EQUAL.getId(), WorkInstance.STATUS_COMPLETED )
				});
	}
	public static SearchFilter getByWorkIdFilter(String workId){
		return new SearchFilter(FILTER_BY_WORK_ID, FILTER_BY_WORK_ID, new Condition[] {
					new Condition(FormField.FIELD_WORK_ID, ConditionOperator.EQUAL.getId(), workId )
				});
	}
	public static SearchFilter getByFileCategoryIdFilter(String categoryId){
		return new SearchFilter(FILTER_BY_FILE_CATEGORY_ID, FILTER_BY_FILE_CATEGORY_ID, new Condition[] {
					new Condition(FormField.FIELD_FILE_CATEGORY_ID, ConditionOperator.EQUAL.getId(), categoryId )
				});
	}
	public static SearchFilter getByFileTypeFilter(String fileType){
		return new SearchFilter(FILTER_BY_FILE_TYPE, FILTER_BY_FILE_TYPE, new Condition[] {
					new Condition(FormField.FIELD_FILE_TYPE, ConditionOperator.EQUAL.getId(), fileType )
				});
	}

	public static SearchFilter getByOwnerFilter(String ownerId){
		return new SearchFilter(FILTER_BY_OWNER, FILTER_BY_OWNER, new Condition[] {
					new Condition(FormField.FIELD_OWNER, ConditionOperator.EQUAL.getId(), ownerId )
				});
	}

	public static SearchFilter getByCreatedDateFilter(String date){
		return new SearchFilter(FILTER_BY_CREATED_DATE, FILTER_BY_CREATED_DATE, new Condition[] {
					new Condition(FormField.FIELD_CREATED_DATE, ConditionOperator.EQUAL.getId(), date)
				});
	}

}
