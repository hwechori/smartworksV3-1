/* 
 * $Id$
 * created by    : yukm
 * creation-date : 2011. 11. 16.
 * =========================================================
 * Copyright (c) 2011 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public class ExceptionInterceptor {
	
	@ExceptionHandler(NullPointerException.class)
	@ResponseStatus(HttpStatus.FORBIDDEN)
	public @ResponseBody String nullPointExceptionHandler(NullPointerException e) {
		return e.getMessage();
	}
	
}
