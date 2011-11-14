package net.smartworks.server.engine.pkg.exception;

import net.smartworks.server.engine.common.exception.SwException;

public class SwpException extends SwException {
	private static final long serialVersionUID = 1L;
	public SwpException() {
	}
	public SwpException(String message) {
		super(message);
	}
	public SwpException(Throwable t) {
		super(t);
	}
	public SwpException(String message, Throwable t) {
		super(message, t);
	}
}
