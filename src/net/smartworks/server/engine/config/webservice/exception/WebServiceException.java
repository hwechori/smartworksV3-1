/*	
 * $Id$
 * created by    : hsshin
 * creation-date : 2011. 11. 9.
 * =========================================================
 * Copyright (c) 2011 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.server.engine.config.webservice.exception;

import net.smartworks.server.engine.common.exception.SwException;

public class WebServiceException extends SwException {

private static final long serialVersionUID = 1L;
	
	public WebServiceException() {
		super();
	}
	public WebServiceException(String message) {
		super(message);
	}
	public WebServiceException(Throwable t) {
		super(t);
	}
	public WebServiceException(String message, Throwable t) {
		super(message, t);
	}

}