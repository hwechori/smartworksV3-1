/*	
 * $Id$
 * created by    : hsshin
 * creation-date : 2011. 11. 18.
 * =========================================================
 * Copyright (c) 2011 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.server.engine.basicwork.addressbook.exception;

import net.smartworks.server.engine.common.exception.SwException;

public class AddressBookException extends SwException {

	private static final long serialVersionUID = 1L;
	public AddressBookException() {
		super();
	}
	public AddressBookException(String message) {
		super(message);
	}
	public AddressBookException(Throwable t) {
		super(t);
	}
	public AddressBookException(String message, Throwable t) {
		super(message, t);
	}

}