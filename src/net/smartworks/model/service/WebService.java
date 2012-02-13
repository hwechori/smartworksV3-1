package net.smartworks.model.service;

import net.smartworks.model.BaseObject;

public class WebService extends BaseObject{
	
	public class Variable{
		String name;
		String elementName;
		String elementType;
	};
	private String desc;
	private String wsdlUri;
	private String port;
	private String operation;
	private Variable[] inputVariables;
	private Variable[] returnVariables;
		
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getWsdlUri() {
		return wsdlUri;
	}
	public void setWsdlUri(String wsdlUri) {
		this.wsdlUri = wsdlUri;
	}
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
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
	
	public WebService(){
	}
}
