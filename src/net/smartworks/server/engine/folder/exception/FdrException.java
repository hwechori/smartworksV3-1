/*	
 * $Id$
 * created by    : hsshin
 * creation-date : 2012. 3. 7.
 * =========================================================
 * Copyright (c) 2012 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.server.engine.folder.exception;

import net.smartworks.server.engine.common.exception.SwException;

public class FdrException extends SwException {
	private static final long serialVersionUID = 1L;
	public FdrException() {
		super();
	}
	public FdrException(String message) {
		super(message);
	}
	public FdrException(Throwable t) {
		super(t);
	}
	public FdrException(String message, Throwable t) {
		super(message, t);
	}

}