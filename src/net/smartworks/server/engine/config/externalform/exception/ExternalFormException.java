/*	
 * $Id$
 * created by    : hsshin
 * creation-date : 2011. 11. 9.
 * =========================================================
 * Copyright (c) 2011 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.server.engine.config.externalform.exception;

import net.smartworks.server.engine.common.exception.SwException;

public class ExternalFormException extends SwException {

	private static final long serialVersionUID = 1L;
	
	public ExternalFormException() {
		super();
	}
	public ExternalFormException(String message) {
		super(message);
	}
	public ExternalFormException(Throwable t) {
		super(t);
	}
	public ExternalFormException(String message, Throwable t) {
		super(message, t);
	}
}
