package net.smartworks.server.engine.common.collection.exception;

import net.smartworks.server.engine.common.exception.MisException;

public class ColException extends MisException {
	private static final long serialVersionUID = 1L;
	public ColException() {
		super();
	}
	public ColException(String message) {
		super(message);
	}
	public ColException(Throwable t) {
		super(t);
	}
	public ColException(String message, Throwable t) {
		super(message, t);
	}
}
