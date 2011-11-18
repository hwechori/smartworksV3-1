package net.smartworks.model.filter;

import net.smartworks.model.community.User;
import net.smartworks.model.work.FormField;
import net.smartworks.util.LocalDate;

public class Condition {
	
	private FormField leftOperand;
	private String operator;
	private Object rightOperand;
	
	public FormField getLeftOperand() {
		return leftOperand;
	}
	public void setLeftOperand(FormField leftOperand) {
		this.leftOperand = leftOperand;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public Object getRightOperand() {
		return rightOperand;
	}
	public void setRightOperand(Object rightOperand) {
		this.rightOperand = rightOperand;
	}
	public Condition(){
	}	
	public Condition(FormField leftOperand, String operator, Object rightOperand){
		this.leftOperand = leftOperand;
		this.operator = operator;
		this.rightOperand = rightOperand;
	}

	public Condition[] getMyInstancesCondition(User currentUser){
		return new Condition[] {new Condition(FormField.FIELD_OWNER, ConditionOperator.EQUAL.getId(), currentUser )};
	}

	public Condition[] getRecentInstancesCondition(){
		LocalDate currentDate = new LocalDate();
		long oneWeekBefore = currentDate.getGMTDate() - 7*LocalDate.ONE_DAY;
		return new Condition[] {new Condition(FormField.FIELD_LAST_MODIFIED_DATE, ConditionOperator.GREATER_EQUAL.getId(), new LocalDate(oneWeekBefore) )};
	}
	public Condition[] getMyRecentInstancesCondition(User currentUser){
		LocalDate currentDate = new LocalDate();
		long oneWeekBefore = currentDate.getGMTDate() - 7*LocalDate.ONE_DAY;
		return new Condition[] {new Condition(FormField.FIELD_OWNER, ConditionOperator.EQUAL.getId(), currentUser ),
				new Condition(FormField.FIELD_LAST_MODIFIED_DATE, ConditionOperator.GREATER_EQUAL.getId(), new LocalDate(oneWeekBefore) )};
	}
}
