package net.smartworks.model.service;

public class WSDLPort{
	
	private String port;
	private WSDLOperation[] operations;
	
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
	public WSDLOperation[] getOperations() {
		return operations;
	}
	public void setOperations(WSDLOperation[] operations) {
		this.operations = operations;
	}

	public WSDLPort(){
	}
}
