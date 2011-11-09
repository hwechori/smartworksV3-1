/*	
 * $Id$
 * created by    : maninsoft
 * creation-date : 2011. 11. 7.
 * =========================================================
 * Copyright (c) 2011 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.server.engine.infowork.form.exception;

import net.smartworks.server.engine.common.exception.SwException;

public class SwfException extends SwException {

	private static final long serialVersionUID = 1L;
	public SwfException() {
		super();
	}
	public SwfException(String message) {
		super(message);
	}
	public SwfException(Throwable t) {
		super(t);
	}
	public SwfException(String message, Throwable t) {
		super(message, t);
	}

}