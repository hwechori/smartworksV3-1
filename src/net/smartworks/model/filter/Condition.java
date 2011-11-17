package net.smartworks.model.filter;

import net.smartworks.model.work.FormField;

public class Condition {
	
	private FormField leftField;
	private String operand;
	private FormField rightField;
	
	public FormField getLeftField() {
		return leftField;
	}
	public void setLeftField(FormField leftField) {
		this.leftField = leftField;
	}
	public String getOperand() {
		return operand;
	}
	public void setOperand(String operand) {
		this.operand = operand;
	}
	public FormField getRightField() {
		return rightField;
	}
	public void setRightField(FormField rightField) {
		this.rightField = rightField;
	}

	public Condition(){
	}
	
	public Condition(FormField leftField, String operand, FormField rightField){
		this.leftField = leftField;
		this.operand = operand;
		this.rightField = rightField;
	}
}
