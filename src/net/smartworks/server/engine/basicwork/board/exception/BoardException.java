/*	
 * $Id$
 * created by    : hsshin
 * creation-date : 2011. 11. 16.
 * =========================================================
 * Copyright (c) 2011 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.server.engine.basicwork.board.exception;

import net.smartworks.server.engine.common.exception.SwException;

public class BoardException extends SwException {

	private static final long serialVersionUID = 1L;
	public BoardException() {
		super();
	}
	public BoardException(String message) {
		super(message);
	}
	public BoardException(Throwable t) {
		super(t);
	}
	public BoardException(String message, Throwable t) {
		super(message, t);
	}

}