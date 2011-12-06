
package net.smartworks.server.engine.common.searcher.exception;

import net.smartworks.server.engine.common.exception.SwException;

public class SchException extends SwException {
	private static final long serialVersionUID = 1L;
	public SchException() {
		super();
	}
	public SchException(String message) {
		super(message);
	}
	public SchException(Throwable t) {
		super(t);
	}
	public SchException(String message, Throwable t) {
		super(message, t);
	}
}
