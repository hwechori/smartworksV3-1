/*	
 * $Id$
 * created by    : maninsoft
 * creation-date : 2011. 11. 7.
 * =========================================================
 * Copyright (c) 2011 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.server.engine.common.util;

import java.io.Serializable;

public class Wrapper implements Serializable {

	private static final long serialVersionUID = 1L;
	private Object obj;
	public Wrapper() {
		super();
	}
	public Wrapper(Object obj) {
		super();
		this.obj = obj;
	}
	public Object getObj() {
		return obj;
	}
	public void setObj(Object obj) {
		this.obj = obj;
	}

}
