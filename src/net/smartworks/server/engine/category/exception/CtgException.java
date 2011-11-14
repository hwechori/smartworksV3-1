package net.smartworks.server.engine.category.exception;

import net.smartworks.server.engine.common.exception.SwException;

public class CtgException extends SwException {
	private static final long serialVersionUID = 1L;
	public CtgException() {
		super();
	}
	public CtgException(String message) {
		super(message);
	}
	public CtgException(Throwable t) {
		super(t);
	}
	public CtgException(String message, Throwable t) {
		super(message, t);
	}
}
