package net.smartworks.model.service;

public class WSDLOperation{
	
	private String operation;
	private Variable[] inputVariables;
	private Variable[] returnVariables;

	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public Variable[] getInputVariables() {
		return inputVariables;
	}
	public void setInputVariables(Variable[] inputVariables) {
		this.inputVariables = inputVariables;
	}
	public Variable[] getReturnVariables() {
		return returnVariables;
	}
	public void setReturnVariables(Variable[] returnVariables) {
		this.returnVariables = returnVariables;
	}
	
	public WSDLOperation(){
	}
}
