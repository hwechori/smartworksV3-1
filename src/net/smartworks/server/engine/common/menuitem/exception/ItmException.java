
package net.smartworks.server.engine.common.menuitem.exception;

import net.smartworks.server.engine.common.exception.SwException;

public class ItmException extends SwException {
	private static final long serialVersionUID = 1L;
	public ItmException() {
		super();
	}
	public ItmException(String message) {
		super(message);
	}
	public ItmException(Throwable t) {
		super(t);
	}
	public ItmException(String message, Throwable t) {
		super(message, t);
	}
}
