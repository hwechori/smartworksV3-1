/*	
 * $Id$
 * created by    : hsshin
 * creation-date : 2011. 11. 7.
 * =========================================================
 * Copyright (c) 2011 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.server.engine.infowork.domain.exception;

import net.smartworks.server.engine.common.exception.SwException;

public class SwdException extends SwException {

	private static final long serialVersionUID = 1L;
	public SwdException() {
		super();
	}
	public SwdException(String message) {
		super(message);
	}
	public SwdException(Throwable t) {
		super(t);
	}
	public SwdException(String message, Throwable t) {
		super(message, t);
	}

}