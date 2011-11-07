package net.smartworks.server.engine.process.deploy.exception;

import net.smartworks.server.engine.common.exception.MisException;


public class DepException extends MisException {
	private static final long serialVersionUID = 1L;
	public DepException() {
		super();
	}
	public DepException(String message) {
		super(message);
	}
	public DepException(Throwable t) {
		super(t);
	}
	public DepException(String message, Throwable t) {
		super(message, t);
	}
}
