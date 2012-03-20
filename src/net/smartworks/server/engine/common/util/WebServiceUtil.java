package net.smartworks.server.engine.common.util;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;

import javax.xml.namespace.QName;
import javax.xml.rpc.ServiceException;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class WebServiceUtil {

	protected final Log logger = LogFactory.getLog(getClass());
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
		
		Log logger = LogFactory.getLog(WebServiceUtil.class);
		if (logger.isInfoEnabled()) {
			StringBuffer infoBuffer = new StringBuffer();
			infoBuffer.append("Invoke WebService \n[ EndPointAddress : ").append(targetEndpointAddress).append(", Operation : ").append(operation).append(", \n Input : ");
			if (inputParams != null) {
				for (int i = 0; i < inputParams.length; i++) {
					infoBuffer.append(inputParams[i]).append(", ");
				}
			}
			infoBuffer.append(", \n Result : ");
			for (int i = 0; i < returnValue.length; i++) {
				infoBuffer.append(returnValue[i]).append(",");
			}
			infoBuffer.append("]" );
			logger.info(infoBuffer.toString());
		}
		return returnValue;
	}
}
