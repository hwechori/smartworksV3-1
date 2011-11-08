/*	
 * $Id$
 * created by    : hsshin
 * creation-date : 2011. 11. 7.
 * =========================================================
 * Copyright (c) 2011 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.server.engine.common.script.exception;

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