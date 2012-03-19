/*	
 * $Id$
 * created by    : hsshin
 * creation-date : 2012. 3. 19.
 * =========================================================
 * Copyright (c) 2012 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.server.engine.opinion.exception;

import net.smartworks.server.engine.common.exception.SwException;

public class OpinionException extends SwException {

	private static final long serialVersionUID = 1L;
	public OpinionException() {
		super();
	}
	public OpinionException(String message) {
		super(message);
	}
	public OpinionException(Throwable t) {
		super(t);
	}
	public OpinionException(String message, Throwable t) {
		super(message, t);
	}

}