package net.smartworks.model.service;

import net.smartworks.model.BaseObject;

public class WebService extends BaseObject{
	
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
	
	public WSDLDetail getWSDLDetail(){
		WSDLOperation operation = new WSDLOperation();
		operation.setInputVariables(inputVariables);
		operation.setReturnVariables(returnVariables);
		
		WSDLPort port = new WSDLPort();
		port.setPort(this.port);
		port.setOperations(new WSDLOperation[]{operation});
		
		WSDLDetail wsdlDetail = new WSDLDetail();
		wsdlDetail.setWsdlUri(wsdlUri);
		wsdlDetail.setPorts(new WSDLPort[]{port});
		return wsdlDetail;
	}
}
