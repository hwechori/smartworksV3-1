package net.smartworks.server.engine.config.exception;

import net.smartworks.server.engine.common.exception.SwException;

public class SwcException extends SwException {

	private static final long serialVersionUID = 1L;

	public SwcException() {
		super();
	}
	public SwcException(String message) {
		super(message);
	}
	public SwcException(Throwable t) {
		super(t);
	}
	public SwcException(String message, Throwable t) {
		super(message, t);
	}

}