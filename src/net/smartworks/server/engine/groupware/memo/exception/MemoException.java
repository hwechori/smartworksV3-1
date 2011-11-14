/*	
 * $Id$
 * created by    : hsshin
 * creation-date : 2011. 11. 14.
 * =========================================================
 * Copyright (c) 2011 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.server.engine.groupware.memo.exception;

import net.smartworks.server.engine.common.exception.SwException;

public class MemoException extends SwException {

	private static final long serialVersionUID = 1L;
	public MemoException() {
		super();
	}
	public MemoException(String message) {
		super(message);
	}
	public MemoException(Throwable t) {
		super(t);
	}
	public MemoException(String message, Throwable t) {
		super(message, t);
	}

}