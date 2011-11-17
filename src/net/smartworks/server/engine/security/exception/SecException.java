package net.smartworks.server.engine.security.exception;

import net.smartworks.server.engine.common.exception.SwException;

public class SecException extends SwException {
	private static final long serialVersionUID = 1L;
	public SecException() {
		super();
	}
	public SecException(String message) {
		super(message);
	}
	public SecException(Throwable t) {
		super(t);
	}
	public SecException(String message, Throwable t) {
		super(message, t);
	}
}
