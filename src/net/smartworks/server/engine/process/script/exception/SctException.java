package net.smartworks.server.engine.process.script.exception;

import net.smartworks.server.engine.common.exception.SwException;


public class SctException extends SwException {
	private static final long serialVersionUID = 1L;
	public SctException() {
		super();
	}
	public SctException(String message) {
		super(message);
	}
	public SctException(Throwable t) {
		super(t);
	}
	public SctException(String message, Throwable t) {
		super(message, t);
	}
}
