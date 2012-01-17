/*	
 * $Id$
 * created by    : hsshin
 * creation-date : 2011. 11. 9.
 * =========================================================
 * Copyright (c) 2011 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.server.engine.config.webservice.model;

import net.smartworks.server.engine.common.model.BaseObject;
import net.smartworks.server.engine.common.model.MisObjectCond;
import net.smartworks.server.engine.common.util.CommonUtil;
import net.smartworks.server.engine.common.util.XmlUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class WebServiceCond extends MisObjectCond {

	private static final long serialVersionUID = 1L;
	private static Log logger = LogFactory.getLog(WebServiceCond.class);
	
	protected static final String PREFIX = "Web";
	private static final String NAME = CommonUtil.toName(WebServiceCond.class, PREFIX);
	
	public static final String A_WEBSERVICENAME = "webServiceName";
	public static final String A_WEBSERVICEADDRESS = "webServiceAddress";
	public static final String A_WSDLADDRESS = "wsdlAddress";
	public static final String A_PORTNAME = "portName";
	public static final String A_OPERATIONNAME = "operationName";
	public static final String A_DESCRIPTION = "description";
	public static final String A_WEBSERVICEPARAMETERS = "webServiceParameters";
	public static final String A_WEBSERVICEPARAMETER = "webServiceParameter";
	
	private String webServiceName;
	private String webServiceAddress;
	private String wsdlAddress;
	private String portName;
	private String operationName;
	private String description;
	
	private WebServiceParameter[] webServiceParameters;
	
	public WebServiceCond() {
		super();
	}
	
	public String toString(String name, String tab){
		if(name == null || name.trim().length() == 0)
			name = NAME;
		return super.toString(name, tab);
	}
	public String toLiteString(String name, String tab) {
		if (name == null || name.trim().length() == 0)
			name = NAME;
		return super.toLiteString(name, tab);
	} 
	public String toAttributesString() {
		StringBuffer buf = new StringBuffer();
		buf.append(super.toAttributesString());
		appendAttributeString(A_WEBSERVICENAME, webServiceName, buf);
		appendAttributeString(A_WEBSERVICEADDRESS, webServiceAddress, buf);
		appendAttributeString(A_WSDLADDRESS, wsdlAddress, buf);
		appendAttributeString(A_PORTNAME, portName, buf);	
		appendAttributeString(A_OPERATIONNAME, operationName, buf);
		return buf.toString();
	}
	public String toElementsString(String tab, boolean lite) {
		StringBuffer buf = new StringBuffer();
		buf.append(super.toElementsString(tab, lite));
		appendElementString(A_DESCRIPTION, description, tab, true, buf);
		appendElementsString(A_WEBSERVICEPARAMETERS, A_WEBSERVICEPARAMETER, getWebServiceParameters(), tab, lite, buf);
		return buf.toString();
	}
	public static BaseObject toObject(Node node, BaseObject baseObj) throws Exception {
		if (node == null)
			return null;
		
		WebServiceCond obj = null;
		if (baseObj == null || !(baseObj instanceof WebServiceCond))
			obj = new WebServiceCond();
		else
			obj = (WebServiceCond)baseObj;
		
		//부모 attributes, elements 값 설정
		BaseObject.toObject(node, obj);
		
		NamedNodeMap attrMap = node.getAttributes();
		if (attrMap != null) {
			Node webServiceName = attrMap.getNamedItem(A_WEBSERVICENAME);
			Node webServiceAddress = attrMap.getNamedItem(A_WEBSERVICEADDRESS);
			Node wsdlAddress = attrMap.getNamedItem(A_WSDLADDRESS);
			Node portName = attrMap.getNamedItem(A_PORTNAME);
			Node operationName = attrMap.getNamedItem(A_OPERATIONNAME);
			Node description = attrMap.getNamedItem(A_DESCRIPTION);

			if (webServiceName != null)
				obj.setWebServiceName(webServiceName.getNodeValue());
			if (webServiceAddress != null)
				obj.setWebServiceAddress(webServiceAddress.getNodeValue());
			if (wsdlAddress != null)
				obj.setWsdlAddress(wsdlAddress.getNodeValue());
			if (portName != null)
				obj.setPortName(portName.getNodeValue());
			if (operationName != null)
				obj.setOperationName(operationName.getNodeValue());
			if (description != null)
				obj.setDescription(description.getNodeValue());
		}
		//elements 값 설정
		NodeList childNodeList = node.getChildNodes();
		if (childNodeList == null || childNodeList.getLength() == 0)
			return obj;
		for (int i=0; i<childNodeList.getLength(); i++) {
			Node childNode  = childNodeList.item(i);
			if (childNode.getNodeType() != Node.ELEMENT_NODE || childNode.getNodeName() == null)
				continue;
			if (childNode.getNodeName().equals("A_WEBSERVICEPARAMETER")) {
				obj.addWebWebServiceParameter((WebServiceParameter)WebServiceParameter.toObject(childNode, null));
			}
		}
		return obj;
	}
	public static BaseObject toObject(String str) throws Exception {
		if (str == null)
			return null;
		Document doc = XmlUtil.toDocument(str);
		if (doc == null)
			return null;
		return toObject(doc.getDocumentElement(), null);
	}
	public static WebServiceCond[] add(WebServiceCond[] objs, WebServiceCond obj) {
		if (obj == null)
			return objs;
		int size = 0;
		if (objs != null)
			size = objs.length;
		WebServiceCond[] newObjs = new WebServiceCond[size+1];
		int i;
		for (i=0; i<size; i++)
			newObjs[i] = objs[i];
		newObjs[i] = obj;
		return newObjs;
	}
	public static WebServiceCond[] remove(WebServiceCond[] objs, WebServiceCond obj) {
		if (obj == null)
			return objs;
		int size = 0;
		if (objs != null)
			size = objs.length;
		if (size == 0)
			return objs;
		WebServiceCond[] newObjs = new WebServiceCond[size-1];
		int i;
		int j = 0;
		for (i=0; i<size; i++) {
			if (objs[i].equals(obj))
				continue;
			newObjs[j++] = objs[i];
		}
		return newObjs;
	}
	public static WebServiceCond[] left(WebServiceCond[] objs, WebServiceCond obj) {
		if (objs == null || objs.length == 0 || obj == null)
			return objs;
		int idx = -1;
		for (int i=0; i<objs.length; i++) {
			if (!objs[i].equals(obj))
				continue;
			idx = i;
			break;
		}
		if (idx < 1)
			return objs;
		WebServiceCond[] newObjs = new WebServiceCond[objs.length];
		for (int i=0; i<objs.length; i++) {
			if (i == idx) {
				newObjs[i] = objs[idx-1];
				continue;
			} else if (i == idx-1) {
				newObjs[i] = objs[idx];
				continue;
			}
			newObjs[i] = objs[i];
		}
		return newObjs;
	}
	public static WebServiceCond[] right(WebServiceCond[] objs, WebServiceCond obj) {
		if (objs == null || objs.length == 0 || obj == null)
			return objs;
		int idx = -1;
		for (int i=0; i<objs.length; i++) {
			if (!objs[i].equals(obj))
				continue;
			idx = i;
			break;
		}
		if (idx == -1 || idx+1 == objs.length)
			return objs;
		WebServiceCond[] newObjs = new WebServiceCond[objs.length];
		for (int i=0; i<objs.length; i++) {
			if (i == idx) {
				newObjs[i] = objs[idx+1];
				continue;
			} else if (i == idx+1) {
				newObjs[i] = objs[idx];
				continue;
			}
			newObjs[i] = objs[i];
		}
		return newObjs;
	}
	public Object clone() throws CloneNotSupportedException {
		try {
			return toObject(this.toString());
		} catch (Exception e) {
			logger.warn(e, e);
			return null;
		}
	}
	public void addWebWebServiceParameter(WebServiceParameter webServiceParameter) {
		if (webServiceParameter == null)
			return;
		this.setWebServiceParameters(WebServiceParameter.add(this.getWebServiceParameters(), webServiceParameter));
	}
	public String getWebServiceName() {
		return webServiceName;
	}

	public void setWebServiceName(String webServiceName) {
		this.webServiceName = webServiceName;
	}

	public String getWebServiceAddress() {
		return webServiceAddress;
	}

	public void setWebServiceAddress(String webServiceAddress) {
		this.webServiceAddress = webServiceAddress;
	}
	public String getWsdlAddress() {
		return wsdlAddress;
	}
	public void setWsdlAddress(String wsdlAddress) {
		this.wsdlAddress = wsdlAddress;
	}
	public String getPortName() {
		return portName;
	}
	public void setPortName(String portName) {
		this.portName = portName;
	}
	public String getOperationName() {
		return operationName;
	}
	public void setOperationName(String operationName) {
		this.operationName = operationName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public WebServiceParameter[] getWebServiceParameters() {
		return webServiceParameters;
	}

	public void setWebServiceParameters(
			WebServiceParameter[] webServiceParameters) {
		this.webServiceParameters = webServiceParameters;
	}

}