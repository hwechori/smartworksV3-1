package net.smartworks.server.engine.resource.exception;

/**
 * SmartServer에서 발생한 런타임 예외
 * 
 * @author jhnam
 * @version $Id: SmartServerRuntimeException.java,v 1.1 2011/11/08 03:15:13 kmyu Exp $
 */
public class SmartServerRuntimeException extends RuntimeException {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	public SmartServerRuntimeException() {
		super();
	}
	
	public SmartServerRuntimeException(String message) {
		super(message);
	}
	
	public SmartServerRuntimeException(Throwable th) {
		super(th);
	}
	
	public SmartServerRuntimeException(String message, Throwable th) {
		super();
	}
	
}
