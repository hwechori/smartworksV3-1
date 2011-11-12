package net.smartworks.server.engine.process.monitoring.Exception;

import net.smartworks.server.engine.common.exception.SwException;

public class MonException extends SwException {
	private static final long serialVersionUID = 1L;
	public MonException() {
		super();
	}
	public MonException(String message) {
		super(message);
	}
	public MonException(Throwable t) {
		super(t);
	}
	public MonException(String message, Throwable t) {
		super(message, t);
	}
}
