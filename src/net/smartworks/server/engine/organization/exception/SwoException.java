/*	
 * $Id$
 * created by    : maninsoft
 * creation-date : 2011. 11. 2.
 * =========================================================
 * Copyright (c) 2011 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.server.engine.organization.exception;

import net.smartworks.server.engine.common.exception.MisException;

public class SwoException extends MisException {

	private static final long serialVersionUID = 1L;

	public SwoException() {
		super();
	}
	public SwoException(String message) {
		super(message);
	}
	public SwoException(Throwable t) {
		super(t);
	}
	public SwoException(String message, Throwable t) {
		super(message, t);
	}

}