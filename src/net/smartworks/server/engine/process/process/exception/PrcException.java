
package net.smartworks.server.engine.process.process.exception;

import net.smartworks.server.engine.common.exception.SwException;

public class PrcException extends SwException {
	private static final long serialVersionUID = 1L;
	public PrcException() {
		super();
	}
	public PrcException(String message) {
		super(message);
	}
	public PrcException(Throwable t) {
		super(t);
	}
	public PrcException(String message, Throwable t) {
		super(message, t);
	}
}
