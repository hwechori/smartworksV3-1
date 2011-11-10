package net.smartworks.server.engine.process.approval.exception;

import net.smartworks.server.engine.common.exception.SwException;


public class AprException extends SwException {
	private static final long serialVersionUID = 1L;
	public AprException() {
		super();
	}
	public AprException(String message) {
		super(message);
	}
	public AprException(Throwable t) {
		super(t);
	}
	public AprException(String message, Throwable t) {
		super(message, t);
	}
}
