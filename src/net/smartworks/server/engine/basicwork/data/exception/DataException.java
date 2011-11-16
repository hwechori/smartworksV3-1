/*	
 * $Id$
 * created by    : hsshin
 * creation-date : 2011. 11. 16.
 * =========================================================
 * Copyright (c) 2011 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.server.engine.basicwork.data.exception;

import net.smartworks.server.engine.common.exception.SwException;

public class DataException extends SwException {

	private static final long serialVersionUID = 1L;
	public DataException() {
		super();
	}
	public DataException(String message) {
		super(message);
	}
	public DataException(Throwable t) {
		super(t);
	}
	public DataException(String message, Throwable t) {
		super(message, t);
	}

}