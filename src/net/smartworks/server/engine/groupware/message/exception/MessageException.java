/*	
 * $Id$
 * created by    : hsshin
 * creation-date : 2011. 11. 14.
 * =========================================================
 * Copyright (c) 2011 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.server.engine.groupware.message.exception;

import net.smartworks.server.engine.common.exception.SwException;

public class MessageException extends SwException {

	private static final long serialVersionUID = 1L;
	public MessageException() {
		super();
	}
	public MessageException(String message) {
		super(message);
	}
	public MessageException(Throwable t) {
		super(t);
	}
	public MessageException(String message, Throwable t) {
		super(message, t);
	}

}