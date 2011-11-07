package net.smartworks.server.engine.process.link.exception;

import net.smartworks.server.engine.common.exception.MisException;

public class LnkException extends MisException {
	private static final long serialVersionUID = 1L;
	public LnkException() {
		super();
	}
	public LnkException(String message) {
		super(message);
	}
	public LnkException(Throwable t) {
		super(t);
	}
	public LnkException(String message, Throwable t) {
		super(message, t);
	}
}
