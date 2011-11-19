package net.smartworks.model.filter;

import net.smartworks.model.BaseObject;
import net.smartworks.model.community.User;
import net.smartworks.model.work.FormField;
import net.smartworks.util.LocalDate;

public class SearchFilter extends BaseObject{
	
	public static final String FILTER_ALL_INSTANCES = "allInstances";
	public static final String FILTER_MY_INSTANCES = "myInstances";
	public static final String FILTER_RECENT_INSTANCES = "recentInstances";
	public static final String FILTER_MY_RECENT_INSTANCES = "myRecentInstances";
	private Condition[] conditions;

	public Condition[] getConditions() {
		return conditions;
	}
	public void setConditions(Condition[] conditions) {
		this.conditions = conditions;
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
		LocalDate currentDate = new LocalDate();
		long oneWeekBefore = currentDate.getGMTDate() - 7*LocalDate.ONE_DAY;
		return new SearchFilter(new Condition[] {new Condition(FormField.FIELD_LAST_MODIFIED_DATE, ConditionOperator.GREATER_EQUAL.getId(), new LocalDate(oneWeekBefore) )});
	}
	public static SearchFilter getMyRecentInstancesFilter(User currentUser){
		LocalDate currentDate = new LocalDate();
		long oneWeekBefore = currentDate.getGMTDate() - 7*LocalDate.ONE_DAY;
		return new SearchFilter(new Condition[] {new Condition(FormField.FIELD_OWNER, ConditionOperator.EQUAL.getId(), currentUser ),
				new Condition(FormField.FIELD_LAST_MODIFIED_DATE, ConditionOperator.GREATER_EQUAL.getId(), new LocalDate(oneWeekBefore) )});
	}

}
