package net.smartworks.server.engine.config.eventday.exception;

import net.smartworks.server.engine.common.exception.SwException;

public class EventDayException extends SwException {

	private static final long serialVersionUID = 1L;

	public EventDayException() {
		super();
	}
	public EventDayException(String message) {
		super(message);
	}
	public EventDayException(Throwable t) {
		super(t);
	}
	public EventDayException(String message, Throwable t) {
		super(message, t);
	}

}