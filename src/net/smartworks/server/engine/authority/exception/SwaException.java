/*	
 * $Id$
 * created by    : hsshin
 * creation-date : 2011. 11. 16.
 * =========================================================
 * Copyright (c) 2011 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.server.engine.authority.exception;

import net.smartworks.server.engine.common.exception.SwException;

public class SwaException extends SwException {

	private static final long serialVersionUID = 1L;
	public SwaException() {
		super();
	}
	public SwaException(String message) {
		super(message);
	}
	public SwaException(Throwable t) {
		super(t);
	}
	public SwaException(String message, Throwable t) {
		super(message, t);
	}

}