/*	
 * $Id$
 * created by    : hsshin
 * creation-date : 2011. 11. 16.
 * =========================================================
 * Copyright (c) 2011 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.server.engine.basicwork.notice.exception;

import net.smartworks.server.engine.common.exception.SwException;

public class NoticeException extends SwException {

	private static final long serialVersionUID = 1L;
	public NoticeException() {
		super();
	}
	public NoticeException(String message) {
		super(message);
	}
	public NoticeException(Throwable t) {
		super(t);
	}
	public NoticeException(String message, Throwable t) {
		super(message, t);
	}

}