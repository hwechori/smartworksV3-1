package net.smartworks.server.engine.resource.util.lang;

import java.io.PrintWriter;
import java.io.StringWriter;

import net.smartworks.server.service.util.SmartCommonConstants;

/**
 * 예외 메시지를 핸들링하는 유틸
 * 
 * @author jhnam
 * @version $Id: ExceptionUtil.java,v 1.1 2011/11/08 03:15:11 kmyu Exp $
 */
public class ExceptionUtil {

	/**
	 * 발생한 예외에 대해서 모든 예외를 String으로 생성한다.
	 * 
	 * @param rootMessage 가장 상위에 표시할 메시지
	 * @param exception 발생한 예외
	 * @return
	 */
	public static String getTraceMessage(String rootMessage, Throwable exception) {
		
		Throwable ex = (Throwable)exception;
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		ex.printStackTrace(pw);
		return (rootMessage != null ? rootMessage + SmartCommonConstants.LINE : "") + sw.getBuffer().toString();
	}
	
	/**
	 * 발생한 예외에 대해서 스마트 BPMS 에서 발생한 모든 예외를 String으로 생성한다.
	 * 특히 네트워크로 클라이언트 측에 에러 메시지를 보낼 경우, 혹은 에러 메시지를 메일로 보낼 경우에 사용한다.
	 * 
	 * @param rootMessage 가장 상위에 표시할 메시지
	 * @param exception 발생한 예외
	 * @return
	 */
	public static String getSmartTraceMessage(String rootMessage, Throwable exception) {
		
		Throwable ex = (Throwable)exception;
		StackTraceElement[] ste = ex.getStackTrace();
		StringBuffer buffer = new StringBuffer();
		buffer.append(rootMessage);
		
		buffer.append(SmartCommonConstants.LINE);
		buffer.append(SmartCommonConstants.LINE);
		buffer.append(ex.getMessage());
		
		buffer.append(SmartCommonConstants.LINE);
		
		for(int i = 0 ; i < ste.length ; i++) {			
			if(ste[i].toString().startsWith("com.maninsoft.smart.")) {
				buffer.append(ste[i].toString());
				buffer.append(SmartCommonConstants.LINE);
			} else
				break;
		}

		Throwable cause = ex.getCause();
		while(cause != null) {
			if(cause.getCause() == null) {
				buffer.append("Cause by - ");
				buffer.append(cause.getMessage());
				ste = cause.getStackTrace();
				
				for(int i = 0 ; i < ste.length ; i++) {
					buffer.append(ste[i].toString());
					buffer.append(SmartCommonConstants.LINE);
				}
			} 
			
			cause = cause.getCause();
		}

		return buffer.toString();
	}
	
}
