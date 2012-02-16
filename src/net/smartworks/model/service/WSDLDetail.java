package net.smartworks.model.service;

public class WSDLDetail{
	
	private String wsdlUri;
	private WSDLPort[] ports;

	public WSDLDetail(){
	}

	public String getWsdlUri() {
		return wsdlUri;
	}

	public void setWsdlUri(String wsdlUri) {
		this.wsdlUri = wsdlUri;
	}

	public WSDLPort[] getPorts() {
		return ports;
	}

	public void setPorts(WSDLPort[] ports) {
		this.ports = ports;
	}
}
