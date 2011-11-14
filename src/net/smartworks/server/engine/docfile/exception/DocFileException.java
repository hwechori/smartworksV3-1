/*	
 * $Id$
 * created by    : hsshin
 * creation-date : 2011. 11. 14.
 * =========================================================
 * Copyright (c) 2011 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.server.engine.docfile.exception;

import net.smartworks.server.engine.common.exception.SwException;

public class DocFileException extends SwException {

	private static final long serialVersionUID = 1L;
	public DocFileException() {
		super();
	}
	public DocFileException(String message) {
		super(message);
	}
	public DocFileException(Throwable t) {
		super(t);
	}
	public DocFileException(String message, Throwable t) {
		super(message, t);
	}

}