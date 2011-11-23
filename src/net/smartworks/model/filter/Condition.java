package net.smartworks.model.filter;

import net.smartworks.model.work.FormField;

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
}
