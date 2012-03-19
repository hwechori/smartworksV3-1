package net.smartworks.server.engine.common.util;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;

import javax.xml.namespace.QName;
import javax.xml.rpc.ServiceException;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;

public class WebServiceUtil {

	public static final String RETURN_TYPE_ARRAY = "ArrayOf_xsd_string";
	
	public static String[] invokeWebService(String targetEndpointAddress, String operation, String[] inputParams, String returnType)  throws MalformedURLException, ServiceException, RemoteException {
		if (CommonUtil.isEmpty(targetEndpointAddress) || CommonUtil.isEmpty(operation))
			return null;
		Service service = new Service();
		Call call = (Call)service.createCall();
		call.setTargetEndpointAddress(new URL(targetEndpointAddress));
		call.setOperationName(new QName("", operation));
		String[] returnValue = null;
		if (returnType.equalsIgnoreCase(RETURN_TYPE_ARRAY)) {
			returnValue = (String[])call.invoke(inputParams);
		} else {
			returnValue = new String[] {(String)call.invoke(inputParams)};
		}
		return returnValue;
	}
}
